package w62;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static a b;
    public IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView a;

    /* JADX INFO: renamed from: w62.a$a, reason: collision with other inner class name */
    public static final class C0291a {
        public static a a() {
            if (a.b != null) goto L5;
            a.b = new a();
        L5:
            a r0 = a.b;
            if (r0 == null) goto L9;
            return r0;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.input.view.AwemeCustomPureVideoPlayerManager");
        }
    }

    static {
    }

    public a() {
    }
}
