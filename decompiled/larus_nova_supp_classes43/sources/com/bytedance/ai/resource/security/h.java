package com.bytedance.ai.resource.security;

import android.util.Base64;
import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.bytedance.lynx.service.security.LynxSecurityService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.lynx.tasm.service.IServiceProvider;
import com.lynx.tasm.service.security.ILynxSecurityService;
import i8a.n;
import java.security.PublicKey;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final h a = null;
    public static final LruCache<String, Boolean> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Object e = null;
    public static final Set<String> f = null;
    public static final LinkedHashMap<String, Map<Long, PublicKey>> g = null;
    public static final ConcurrentHashMap<String, byte[]> h = null;
    public static final ConcurrentHashMap<String, a> i = null;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PublicKeysCache(version=" + this.a + ", keysJson=" + this.b + ')';
        }

        public a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "version");
            Intrinsics.checkNotNullParameter(r11, "keysJson");
            this.a = r10;
            this.b = r11;
        }
    }

    public h() {
    }

    static {
        a = new h();
        b = new LruCache(20);
        c = LazyKt.lazy(new f());
        d = LazyKt.lazy(new g());
        e = new Object();
        f = Collections.synchronizedSet(new LinkedHashSet());
        g = new LinkedHashMap(8, 0.75f, true);
        h = new ConcurrentHashMap();
        i = new ConcurrentHashMap();
    }

    public static String a(Map r10) {
        LinkedHashMap r0 = new LinkedHashMap(r10.size());
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) r11.next();
        long r12 = ((Number) r1.getKey()).longValue();
        PublicKey r13 = (PublicKey) r1.getValue();
        r0.put(Long.toString(r12, CharsKt.checkRadix(16)), Base64.encodeToString(r13.getEncoded(), 2));
        goto L4
    L7:
        return GsonProtectorUtils.toJson((Gson) d.getValue(), r0);
    }

    public static boolean b(String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "packageName");
        Intrinsics.checkNotNullParameter(r14, "newVersion");
        if (r15 == false) goto L5;
        String r10 = "debug_" + r13;
    L6:
        String r11 = "";
        LynxSecurityService r12 = null;
        if (r15 == false) goto L14;
        a r16 = i.get(r10);
        if (r16 == null) goto L11;
        String r17 = r16.a;
    L12:
        if (r17 == null) goto L18;
    L17:
        r11 = r17;
    L18:
        if (r15 == false) goto L23;
        a r18 = i.get(r10);
        if (r18 == null) goto L22;
        String r19 = r18.b;
    L24:
        boolean r20 = false;
        if (r19 != null) goto L27;
    L30:
        boolean r21 = true;
    L31:
        boolean r22 = !r21;
        com.bytedance.ai.utils.g r23 = com.bytedance.ai.utils.g.a;
        r23.i("AIPackageSecurityStore", "ensurePublicKeysIfNeeded. storagePackageName: " + r10 + ". localVersion: " + r11 + ", newVersion: " + r14 + ", isDebugResource: " + r15);
        if (r22 == true) goto L34;
    L84:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L74
        j.a.getClass();     // Catch: Throwable -> L74
        Pair r111 = j.e(r13);     // Catch: Throwable -> L74
        String r1 = (String) r111.getFirst();     // Catch: Throwable -> L74
        String r112 = a((Map) r111.getSecond());     // Catch: Throwable -> L74
        c(r10, r1, r112, r15);     // Catch: Throwable -> L74
        IServiceProvider r24 = n.c().a(ILynxSecurityService.class);     // Catch: Throwable -> L74
        if ((r24 instanceof LynxSecurityService) == false) goto L62;
        r12 = (LynxSecurityService) r24;     // Catch: Throwable -> L74
    L62:
        r23.i("AIPackageSecurityStore", "update public keys. packageName: " + r13 + ", storagePackageName: " + r10 + ", version: " + r1 + ", isDebugResource: " + r15 + ",  size: " + r112.length());     // Catch: Throwable -> L74
        if (r12 == null) goto L65;
        r12.updateRSAPublicKeys(r112);     // Catch: Throwable -> L74
    L66:
        Object r113 = e;     // Catch: Throwable -> L74
        monitor-enter(r113);     // Catch: Throwable -> L74
        f.add(r10);     // Catch: Throwable -> L71
        monitor-exit(r113);     // Catch: Throwable -> L74
        Object r114 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L74
    L76:
        Throwable r115 = Result.exceptionOrNull-impl(r114);
        if (r115 == null) goto L79;
        com.bytedance.ai.utils.g.a.e("AIPackageSecurityStore", "refresh sign public keys failed: " + r115.getMessage());
    L79:
        Boolean r116 = Boolean.FALSE;
        if (Result.isFailure-impl(r114) == false) goto L83;
        r114 = r116;
    L83:
        return ((Boolean) r114).booleanValue();
    L71:
        th = move-exception;
        throw th;     // Catch: Throwable -> L74
    L65:
        r23.e("AIPackageSecurityStore", "securityService is NULL");     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r114 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L76
    L34:
        if (Intrinsics.areEqual(r14, r11) == false) goto L36;
    L39:
        Set<String> r118 = f;
        if (r118.contains(r10) == true) goto L58;
        Object r0 = e;
        monitor-enter(r0);
    L55:
        th = move-exception;
        throw th;
    L44:
        if (r118.contains(r10) == true) goto L52;
        r23.i("AIPackageSecurityStore", "init public keys. size: " + r19.length() + ". localVersion: " + r11 + ", newVersion: " + r14 + ", isDebugResource: " + r15);     // Catch: Throwable -> L55
        IServiceProvider r119 = n.c().a(ILynxSecurityService.class);     // Catch: Throwable -> L55
        if ((r119 instanceof LynxSecurityService) == false) goto L48;
        r12 = (LynxSecurityService) r119;     // Catch: Throwable -> L55
    L48:
        if (r12 == null) goto L50;
        r12.updateRSAPublicKeys(r19);     // Catch: Throwable -> L55
    L51:
        r118.add(r10);     // Catch: Throwable -> L55
        goto L52
    L50:
        r23.e("AIPackageSecurityStore", "securityService is NULL");     // Catch: Throwable -> L55
    L52:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L55
        monitor-exit(r0);
    L58:
        return true;
    L36:
        if (r14.length() != 0) goto L38;
        r20 = true;
    L38:
        if (r20 == false) goto L84;
    L27:
        if (StringsKt.isBlank(r19) == true) goto L30;
        r21 = false;
        goto L31
    L22:
        r19 = null;
        goto L24
    L23:
        Intrinsics.checkNotNullParameter(r10, "packageName");
        r19 = ((Keva) c.getValue()).getString("pubkey_json_" + r10, null);
        goto L24
    L11:
        r17 = null;
        goto L12
    L14:
        Intrinsics.checkNotNullParameter(r10, "packageName");
        r17 = ((Keva) c.getValue()).getString("pubkey_ver_" + r10, "");
        if (r17 != null) goto L17;
    L5:
        r10 = r13;
        goto L6
    }

    public static void c(String r10, String r11, String r12, boolean r13) {
        if (r13 == false) goto L4;
        i.put(r10, new a(r11, r12));
        return;
    L4:
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "version");
        Intrinsics.checkNotNullParameter(r12, "keysJson");
        Lazy r14 = c;
        ((Keva) r14.getValue()).storeString("pubkey_ver_" + r10, r11);
        ((Keva) r14.getValue()).storeString("pubkey_json_" + r10, r12);
        LinkedHashMap<String, Map<Long, PublicKey>> r15 = g;
        monitor-enter(r15);
        Map<Long, PublicKey> r16 = r15.remove(r10);     // Catch: Throwable -> L9
        monitor-exit(r15);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
