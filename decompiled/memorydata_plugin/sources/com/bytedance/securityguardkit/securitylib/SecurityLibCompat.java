package com.bytedance.securityguardkit.securitylib;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.aiassistant.security.platformkey.PlatformKeyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class SecurityLibCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Namespace f3167a;

    public static final enum Namespace extends Enum<Namespace> {
        private static final /* synthetic */ Namespace[] $VALUES = null;
        public static final Namespace ASSISTANT = null;
        public static final Namespace OBRIC = null;

        private static /* synthetic */ Namespace[] $values() {
            return new Namespace[]{OBRIC, ASSISTANT};
        }

        static {
            OBRIC = new Namespace("OBRIC", 0);
            ASSISTANT = new Namespace("ASSISTANT", 1);
            $VALUES = $values();
        }

        private Namespace(String r1, int r2) {
            super(r1, r2);
        }

        public static Namespace valueOf(String r2) {
            return (Namespace) ZeusTransformUtils.preCheckCast(Enum.valueOf(Namespace.class, r2), Namespace.class, "com.obric.memorydata.plugin");
        }

        public static Namespace[] values() {
            return (Namespace[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Namespace[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final class a {
        static byte[] a(Context r6, int r7, byte[] r8, byte[] r9, Bundle r10) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            return PlatformKeyManager.getInstance().decrypt(r1, r7, r8, r9, r10);
        }
    }

    private static final class b {
        static byte[] a(Context r6, int r7, byte[] r8, byte[] r9, Bundle r10) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            return com.obric.security.platformkey.PlatformKeyManager.getInstance().decrypt(r1, r7, r8, r9, r10);
        }
    }

    public static Namespace a() {
        Namespace r0 = f3167a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (a("com.obric.security.secretdata.SecretDataManager") == false) goto L8;
        Namespace r1 = Namespace.OBRIC;
    L9:
        f3167a = r1;
        return r1;
    L8:
        r1 = Namespace.ASSISTANT;
        goto L9
    }

    private static boolean a(String r3) {
        Class.forName(r3, false, null);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        e = move-exception;
        Log.e("SecurityLibCompat", "Class not found:" + e);
        return false;
    }

    public static byte[] a(Context r2, int r3, byte[] r4, byte[] r5, Bundle r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (a() != Namespace.OBRIC) goto L7;
        return b.a(r7, r3, r4, r5, r6);
    L7:
        return a.a(r7, r3, r4, r5, r6);
    }
}
