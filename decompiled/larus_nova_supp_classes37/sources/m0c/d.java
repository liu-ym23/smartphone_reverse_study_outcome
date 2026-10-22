package m0c;

import com.ss.android.lark.passportc.api.Scene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final com.ss.android.lark.log.trace.b a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;
    public static final String j = null;
    public static final String k = null;
    public static final String l = null;
    public static final String m = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Scene.values().length];
            r0[Scene.FAST_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Scene.SWITCH_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new com.ss.android.lark.log.trace.b();
        b = "OfflineForeground";
        c = "OfflineTransfer";
        d = "BringNewOnline";
        e = "SwapTransfer";
        f = "OnlineTransfer";
        g = "ComponentTask";
        h = "NotifyChange";
        i = "NotifyGlobalUserOffline";
        j = "NotifyGlobalUserChange";
        k = "NotifyGlobalUserOnline";
        l = "NotifyUserOffline";
        m = "NotifyUserOnline";
    }

    public static com.ss.android.lark.log.trace.b a(Scene r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L6:
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L11;
        return a;
    L11:
        return a;
    L4:
        r2 = a.a[r1.ordinal()];
        goto L6
    }
}
