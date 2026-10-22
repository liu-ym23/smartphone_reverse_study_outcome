package toa;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyProtection;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.privacy.azerothprivacy.crypto.KeyAgeementException;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import org.json.JSONException;
import org.json.JSONObject;
import uoa.b;
import uoa.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static KeyStore b;
    public static final Map<String, Key> c = null;
    public static final Map<String, Key> d = null;
    public static final Map<String, Key> e = null;
    public static boolean f;
    public static final AtomicInteger g = null;
    public static final d h = null;
    public final ConcurrentHashMap<Object, Future<Boolean>> a;

    public static class a {
        public static final d a = null;

        static {
            a = new d();
        }
    }

    static {
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        g = new AtomicInteger(0);
        h = a.a;
    }

    public d() {
        this.a = new ConcurrentHashMap();
        KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L5
        b = r1;     // Catch: Exception -> L5
        r1.load(null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b = null;
        f = true;
        apa.a.c("AzerothKeystore", "failed to get AndroidKeyStore instance", e);
        xoa.a.a(e, "failed to load android key store", null);
    }

    public static b a(Context r4) throws InvalidKeyException {
        String r0 = AzerothPrivacy.getAppInfo().e;
        long r1 = toa.a.c(AzerothPrivacy.getAppContext(), r0);     // Catch: KeyAgeementException -> L10
        Key r5 = h(r4, r0, Long.valueOf(r1));
        if (r5 == null) goto L9;
        return new b(r1, r5);
    L9:
        throw new InvalidKeyException("null key returned");
    L11:
        if (g.compareAndSet(0, 1) == false) goto L14;
        ThreadMethodProxy.start(new PthreadThreadV2(new c(r4, r0), "AzerothKeystore"));
    L14:
        throw new InvalidKeyException("zero key version returned");
    }

    public static void f(g r10) throws KeyStoreException {
        int r2 = 1;
    L4:
        if (r2 > 3) goto L17;
        SecretKeySpec r4 = new SecretKeySpec(r10.c, "AES");     // Catch: KeyStoreException -> L7
        b.setEntry(r10.a("aes_key"), new KeyStore.SecretKeyEntry(r4), new KeyProtection.Builder(3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).build());     // Catch: KeyStoreException -> L7
        b.deleteEntry(j("aes_key", r10.b));     // Catch: KeyStoreException -> L7
        SecretKeySpec r5 = new SecretKeySpec(r10.c, "HmacSHA256");     // Catch: KeyStoreException -> L7
        b.setEntry(r10.a("hmacsha256_key"), new KeyStore.SecretKeyEntry(r5), new KeyProtection.Builder(4).setDigests(new String[]{"SHA-256"}).build());     // Catch: KeyStoreException -> L7
        b.deleteEntry(j("hmacsha256_key", r10.b));     // Catch: KeyStoreException -> L7
        return;
    L7:
        e = move-exception;
        String r6 = e.toString();
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        r7.put("AzerothKeystore", r6);     // Catch: JSONException -> L11
        r8.put("failed_count", r2);     // Catch: JSONException -> L11
    L13:
        bpa.a.b("crypto", r7, r8, null);
        if (r2 == 3) goto L16;
        r2 = r2 + 1;
        goto L4
    L16:
        throw e;
    L11:
        e = move-exception;
        xoa.a.a(e, "key store error event reporter Json exception", null);
        goto L13
    }

    public static Key b(Context r3, long r4) throws Exception {
        String r0 = AzerothPrivacy.getAppInfo().e;
        String r1 = i("sub_aes_key", r0, Long.valueOf(r4));
        Key r2 = (Key) ((ConcurrentHashMap) e).get(r1);
        if (r2 != null) goto L9;
        Key r5 = h(r3, r0, Long.valueOf(r4));
        if (r5 == null) goto L8;
        r2 = l(r0, new b(r4, r5));
        goto L9
    L8:
        throw new KeyStoreException("null root key returned");
    L9:
        if (r2 == null) goto L12;
        return r2;
    L12:
        throw new KeyStoreException("null sub key returned");
    }

    public static void d(g r3, Context r4) {
        epa.a r5 = epa.a.b(r4);
        String r0 = Base64.encodeToString(r3.c, 2);
        String r2 = r3.a("aes_key");
        r5.getClass();
        epa.a.e(r2, r0);
        String r6 = j("aes_key", r3.b);
        epa.a.c.remove(r6);
        epa.a.c.commit();
    }

    public static void e(g r9, Context r10) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, KeyStoreException {
        epa.a r0 = epa.a.b(r10);
        GregorianCalendar r1 = new GregorianCalendar();
        GregorianCalendar r2 = new GregorianCalendar();
        r2.add(1, 1);
        KeyPairGeneratorSpec r3 = new KeyPairGeneratorSpec.Builder(r10).setAlias(r9.a("rsa_private_key")).setSubject(new X500Principal("CN=" + r9.a("rsa_private_key"))).setSerialNumber(new BigInteger(63, new SecureRandom())).setStartDate(r1.getTime()).setEndDate(r2.getTime()).build();
        KeyPairGenerator r4 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        r4.initialize(r3);
        PublicKey r5 = r4.generateKeyPair().getPublic();
        Cipher r6 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r6.init(1, r5);
        String r7 = Base64.encodeToString(r6.doFinal(r9.c), 2);
        String r8 = r9.a("aes_key");
        r0.getClass();
        epa.a.e(r8, r7);
        epa.a.c.remove(j("aes_key", r9.b));
        epa.a.c.commit();
        b.deleteEntry(j("rsa_private_key", r9.b));
    }

    public static String j(String r2, String r3) {
        String r0 = toa.a.a;
        monitor-enter(toa.a.class);
        Long r1 = (Long) ((ConcurrentHashMap) toa.a.e).get(r3);     // Catch: Throwable -> L8
        monitor-exit(toa.a.class);
        return r2 + r3 + String.valueOf(r1);
    L8:
        th = move-exception;
        throw th;
    }

    public static Key l(String r8, b r9) {
        long r0 = CastLongProtector.parseLong(r8);     // Catch: Exception -> L4
        ByteBuffer r2 = ByteBuffer.allocate(8);     // Catch: Exception -> L4
        r2.order(ByteOrder.LITTLE_ENDIAN).putLong(r0);     // Catch: Exception -> L4
        byte[] r1 = r2.array();     // Catch: Exception -> L4
        Key r3 = r9.b;     // Catch: Exception -> L4
        Cipher r4 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L4
        byte[] r5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};     // Catch: Exception -> L4
        r4.init(1, r3, new GCMParameterSpec(128, r5));     // Catch: Exception -> L4
        ByteBuffer r6 = ByteBuffer.allocate(r4.doFinal(r1).length + 12);     // Catch: Exception -> L4
        r6.put(r5);     // Catch: Exception -> L4
        SecretKeySpec r7 = new SecretKeySpec(r6.array(), "AES");     // Catch: Exception -> L4
        String r10 = i("sub_aes_key", r8, Long.valueOf(r9.a));     // Catch: Exception -> L4
        ((ConcurrentHashMap) e).put(r10, r7);     // Catch: Exception -> L4
        return r7;
    L4:
        e = move-exception;
        HashMap r11 = new HashMap();
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r11.put("shared_preference", epa.a.a().toString());
        xoa.a.a(e, "sub key initial exception", r11);
        return null;
    }

    public final void c(Context r17, String r18) {
        if (NetworkUtils.isNetworkAvailable(AzerothPrivacy.getAppContext()) == false) goto L68;
        if (dpa.d.a().cryptoSetting.disable_crypto == true) goto L68;
        long r2 = System.currentTimeMillis();
        JSONObject r9 = new JSONObject();
        int r7 = 0;
        Future<Boolean> r8 = null;
        r9.put("AzerothKeystore", "GetSharedSecret");     // Catch: Throwable -> L40 Exception -> L43
        d r10 = h;     // Catch: Throwable -> L40 Exception -> L43
        Future<Boolean> r11 = r10.a.get("initKeys");     // Catch: Throwable -> L40 Exception -> L43
        if (r11 == null) goto L85;
        r8 = r11;
    L72:
        boolean r4 = r8.get(3, TimeUnit.SECONDS).booleanValue();     // Catch: Throwable -> L36 Exception -> L38
        if (r4 == true) goto L76;
        toa.a.f(r18);     // Catch: Exception -> L38 Throwable -> L57
        r7 = 3;
    L76:
        apa.a.a("CRYPTO", "InitialKey result is " + r4);     // Catch: Throwable -> L34 Exception -> L38
        r10.a.remove("initKeys", r8);     // Catch: Throwable -> L34 Exception -> L38
    L86:
        long r0 = toa.a.c(r17, r18);     // Catch: Exception -> L30
    L91:
        long r5 = toa.a.b(r17, r18);     // Catch: Exception -> L33
        int r15 = r7;
    L52:
        long r12 = r5;
        int r6 = r15;
        long r13 = r0;
    L55:
        bpa.a.e(r2, r6, r13, r12, r9);
        return;
    L33:
        r6 = r7;
    L54:
        r13 = r0;
        r12 = 0;
    L30:
        r0 = 0;
    L34:
        th = th;
        int r14 = r7;
    L74:
        long r16 = toa.a.c(r17, r18);     // Catch: Exception -> L61
    L83:
        long r19 = toa.a.b(r17, r18);     // Catch: Exception -> L64
    L65:
        bpa.a.e(r2, r14, r16, r19, r9);
        throw th;
    L64:
        r19 = 0;
    L61:
        r16 = 0;
    L36:
        th = th;
    L42:
        r14 = 0;
    L38:
        e = e;
    L45:
        r11 = r8;
    L46:
        toa.a.f(r18);     // Catch: Throwable -> L57
        HashMap r20 = new HashMap();     // Catch: Throwable -> L57
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();     // Catch: Throwable -> L57
        r20.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L57
        xoa.a.a(e, "key initial remote exception", r20);     // Catch: Throwable -> L57
        h.a.remove("initKeys", r11);     // Catch: Throwable -> L57
        r0 = toa.a.c(r17, r18);     // Catch: Exception -> L49
    L88:
        r5 = toa.a.b(r17, r18);     // Catch: Exception -> L53
        r15 = 3;
    L53:
        r6 = 3;
    L49:
        r0 = 0;
        goto L88
    L85:
    L79:
        FutureTask r110 = new FutureTask(new b(this, r17, r18));     // Catch: Exception -> L18 Throwable -> L36
        r8 = r10.a.putIfAbsent("initKeys", r110);     // Catch: Exception -> L18 Throwable -> L36
        if (r8 != null) goto L72;
        r110.run();     // Catch: Exception -> L16 Throwable -> L36
        r8 = r110;
    L16:
        e = e;
        r11 = r110;
    L18:
        e = e;
    L20:
        e = e;
    L57:
        th = th;
        r14 = 3;
    L43:
        e = e;
    L40:
        th = th;
    }

    public static Key g(Context r2, String r3, Long r4) {
        if (f == true) goto L12;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        return b.getKey(i("hmacsha256_key", r3, r4), null);
    L9:
        e = move-exception;
        apa.a.b("CRYPTO", "GetHmacSHA256Key exceptions:" + e);
        HashMap r5 = new HashMap();
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r5.put("shared_preference", epa.a.a().toString());
        xoa.a.a(e, "retrieve hmac key exception", r5);
        return null;
    L12:
        return h(r2, r3, r4);
    }

    public static Key h(Context r12, String r13, Long r14) {
        epa.a r15 = epa.a.b(r12);
        String r1 = i("aes_key", r13, r14);     // Catch: KeyAgeementException -> L36
        apa.a.a("CRYPTO", "start get key:" + r1);
        if (f == false) goto L37;
        Map<String, Key> r16 = d;
        Key r17 = (Key) ((ConcurrentHashMap) r16).get(r1);
        if (r17 != null) goto L17;
        r15.getClass();
        String r18 = epa.a.b.getString(r1, "");
        if (TextUtils.isEmpty(r18) == true) goto L17;
        byte[] r19 = Base64.decode(r18, 0);     // Catch: Exception -> L15
        if (r19.length != 32) goto L13;
        ((ConcurrentHashMap) r16).put(r1, new SecretKeySpec(r19, "AES"));     // Catch: Exception -> L15
        r17 = (Key) ((ConcurrentHashMap) r16).get(r1);     // Catch: Exception -> L15
    L38:
        goto L17
    L13:
        epa.a.e(r1, "");     // Catch: Exception -> L15
    L15:
        e = move-exception;
        apa.a.b("CRYPTO", "GetKey exceptions:" + e);
        HashMap r110 = new HashMap();
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r110.put("shared_preference", epa.a.a().toString());
        xoa.a.a(e, "plane B retrieve key exception", r110);
        epa.a.e(r1, "");
    L17:
        return r17;
    L37:
    L33:
        e = move-exception;
        apa.a.b("CRYPTO", "GetKey exceptions:" + e);
        HashMap r111 = new HashMap();
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r111.put("shared_preference", epa.a.a().toString());
        xoa.a.a(e, "retrieve key exception", r111);
        goto L35
    L19:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        Map<String, Key> r2 = c;     // Catch: Exception -> L33
        Key r10 = (Key) ((ConcurrentHashMap) r2).get(r1);     // Catch: Exception -> L33
        if (r10 != null) goto L32;
        PrivateKey r112 = (PrivateKey) b.getKey(i("rsa_private_key", r13, r14), null);     // Catch: Exception -> L33
        r15.getClass();     // Catch: Exception -> L33
        String r113 = epa.a.b.getString(r1, "");     // Catch: Exception -> L33
        if (r112 == null) goto L32;
        if (TextUtils.isEmpty(r113) == true) goto L32;
        Cipher r114 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Exception -> L33
        r114.init(2, r112);     // Catch: Exception -> L33
        byte[] r115 = r114.doFinal(Base64.decode(r113, 0));     // Catch: Exception -> L33
        if (r115.length != 32) goto L31;
        r10 = new SecretKeySpec(r115, "AES");     // Catch: Exception -> L33
    L31:
        ((ConcurrentHashMap) r2).put(r1, r10);     // Catch: Exception -> L33
    L32:
        return r10;
    L21:
        return b.getKey(r1, null);
    L35:
        return null;
    }

    public static String i(String r2, String r3, Long r4) throws KeyAgeementException {
        if (r4 != null) goto L5;
        r4 = Long.valueOf(toa.a.c(AzerothPrivacy.getAppContext(), r3));
    L5:
        return r2 + r3 + r4;
    }

    public static void k(Context r2, String r3, Key r4) {
        l(r3, new b(toa.a.c(r2, r3), r4));
        return;
    L5:
        e = move-exception;
        xoa.b r5 = xoa.a.a;
        xoa.b r6 = xoa.a.a;
        xoa.a.a(e, "init subkey failed", null);
    }
}
