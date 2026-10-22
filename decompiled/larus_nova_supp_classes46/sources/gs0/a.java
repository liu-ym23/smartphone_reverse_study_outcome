package gs0;

import com.bytedance.android.livesdkapi.player.ISetSurfaceInterceptor;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final C0217a d = null;
    public boolean a;
    public boolean b;
    public final ILivePlayerClient c;

    /* JADX INFO: renamed from: gs0.a$a, reason: collision with other inner class name */
    public static final class C0217a implements ISetSurfaceInterceptor {
        public C0217a() {
        }

        public final ISetSurfaceInterceptor.MODE intercept(ILivePlayerClient r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "client");
            if (r1.isPlaying() == false) goto L9;
            if (Intrinsics.areEqual((Boolean) r1.getEventHub().getFirstFrame().getValue(), Boolean.TRUE) == false) goto L9;
            return ISetSurfaceInterceptor.MODE.ADD;
        L9:
            return ISetSurfaceInterceptor.MODE.DEFAULT;
        }
    }

    public static final class b {
    }

    static {
        d = new C0217a();
    }

    public a(ILivePlayerClient r1) {
        this.c = r1;
    }

    public final void a(boolean r2) {
        this.a = r2;
        if (r2 == false) goto L7;
        ILivePlayerClient r3 = this.c;
        if (r3 == null) goto L11;
        r3.setSetSurfaceInterceptor(d);
        return;
    L11:
        return;
    L7:
        ILivePlayerClient r4 = this.c;
        if (r4 == null) goto L13;
        r4.setSetSurfaceInterceptor(null);
        return;
    }

    public final void b(boolean r2) {
        this.b = r2;
        if (r2 == false) goto L7;
        ILivePlayerClient r3 = this.c;
        if (r3 == null) goto L11;
        r3.setSetSurfaceInterceptor(d);
        return;
    L11:
        return;
    L7:
        ILivePlayerClient r4 = this.c;
        if (r4 == null) goto L13;
        r4.setSetSurfaceInterceptor(null);
        return;
    }
}
