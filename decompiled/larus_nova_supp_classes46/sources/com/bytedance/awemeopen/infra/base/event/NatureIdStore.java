package com.bytedance.awemeopen.infra.base.event;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class NatureIdStore {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public NatureIdStore() {
    }

    public static final String a() {
        SharedPreferences r0 = z54.a.b("nature_content");
        String r4 = r0.getString("nature_id", "");
        if (TextUtils.isEmpty(r4) == false) goto L26;
        return null;
    L26:
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L23
        List r5 = StringsKt.split$default(r4, new String[]{"|"}, false, 0, 6, null);     // Catch: Throwable -> L23
        if (r5.size() == 2) goto L9;
        AoLogger.c("NatureIdStore", new Object[]{"invalid encrypted data format"});     // Catch: Throwable -> L23
        return null;
    L9:
        String r6 = (String) ListProtector.get(r5, 0);     // Catch: Throwable -> L23
        String r7 = (String) ListProtector.get(r5, 1);     // Catch: Throwable -> L23
        byte[] r8 = Base64.decode(r6, 2);     // Catch: Throwable -> L23
        String r13 = r0.getString("bytes", "");     // Catch: Throwable -> L23
        if (r13 == null) goto L18;
        List r1 = StringsKt.split$default(r13, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L23
        if (r1 == null) goto L18;
        List r2 = r1;     // Catch: Throwable -> L23
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Throwable -> L23
        Iterator r9 = r2.iterator();     // Catch: Throwable -> L23
    L15:
        if (r9.hasNext() == false) goto L17;
        r3.add(Byte.valueOf(CastByteProtector.parseByte((String) r9.next())));     // Catch: Throwable -> L23
        goto L15
    L17:
        byte[] r10 = CollectionsKt.toByteArray(r3);     // Catch: Throwable -> L23
    L19:
        if (r10 == null) goto L29;
        Cipher r11 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Throwable -> L23
        r11.init(2, new SecretKeySpec(r10, "AES"), new IvParameterSpec(r8));     // Catch: Throwable -> L23
        return new String(r11.doFinal(Base64.decode(r7, 2)), Charsets.UTF_8);
    L29:
        return null;
    L18:
        r10 = null;
    L23:
        th = move-exception;
        AoLogger.c("NatureIdStore", new Object[]{"fetchFromCache decrypt error", th});
        return null;
    }

    public static void c() {
        JSONObject r0 = AoSettings.a("ao_common_params_config");
        boolean r1 = true;
        if (r0 == null) goto L5;
        r1 = r0.optBoolean("enable_request", true);
    L5:
        if (r1 == true) goto L8;
        return;
    L8:
        if (r0 == null) goto L10;
        long r3 = r0.optLong("request_delay_time", 0);
    L12:
        if (r3 <= 0) goto L14;
        AoPool.e(NatureIdStore$init$2.INSTANCE, r3);
        return;
    L14:
        if (TextUtils.isEmpty(AoEnv.c()) == false) goto L17;
        AoPool.e(NatureIdStore$init$1.INSTANCE, 3000);
        return;
    L17:
        AoPool.a(NatureIdStore$asyncFetch$1.INSTANCE);
        return;
    L10:
        r3 = 0;
        goto L12
    }

    public static final void b(String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L11;
        return;
    L11:
        byte[] r3 = new byte[16];     // Catch: Exception -> L8
        new SecureRandom().nextBytes(r3);     // Catch: Exception -> L8
        byte[] r0 = new byte[16];     // Catch: Exception -> L8
        new SecureRandom().nextBytes(r0);     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L8
        Cipher r4 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Exception -> L8
        r4.init(1, new SecretKeySpec(r3, "AES"), new IvParameterSpec(r0));     // Catch: Exception -> L8
        String r13 = Base64.encodeToString(r4.doFinal(r12.getBytes(Charsets.UTF_8)), 2);     // Catch: Exception -> L8
        z54.a.b("nature_content").edit().putString("nature_id", Base64.encodeToString(r0, 2) + '|' + r13).putString("bytes", ArraysKt.joinToString$default(r3, ",", null, null, 0, null, null, 62, null)).apply();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        AoLogger.c("NatureIdStore", new Object[]{"saveToCache error", e});
    }
}
