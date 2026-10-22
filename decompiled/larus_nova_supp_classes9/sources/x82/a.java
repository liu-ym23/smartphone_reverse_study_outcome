package x82;

import ey.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a extends com.bytedance.android.livesdk.interactivity.medialink.contract.b {
    public static final C0295a t2 = null;

    /* JADX INFO: renamed from: x82.a$a, reason: collision with other inner class name */
    public static final class C0295a {
        public static final /* synthetic */ C0295a a = null;

        public C0295a() {
        }

        static {
            a = new C0295a();
        }

        public static a a() {
            com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
            com.bytedance.android.livesdk.interactivity.medialink.contract.b r0 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
            if ((r0 instanceof a) == true) goto L6;
            r0 = null;
        L6:
            return (a) r0;
        }
    }

    static {
        t2 = C0295a.a;
    }

    void Mn(String r1, dy.a r2);

    boolean N(String r1);

    com.bytedance.android.livesdk.interactivity.medialink.contract.d getConnectionContext();

    k getLinkOutManager();
}
