package com.bytedance.android.live.livelink.platformapi.avclient.video;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final d a;
    public final d0 b;

    public final boolean b() {
        if (this.a.s1().a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void f() {
        this.a.i1(new uv0.a(LiveRequestSourceRole.Business, "AndroidVideoCaptureApi.switchVideoCapture", null));
    }

    public final int h() {
        d0.a r0 = this.b.getBuilder();
        if (r0 != null) goto L7;
        return 4;
    L7:
        return r0.g();
    }

    public final void c(int r1) {
        d0.a r2 = this.b.getBuilder();
        if (r2 == null) goto L6;
        r2.B();
        return;
    }

    public final void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.a.U0(new uv0.a(LiveRequestSourceRole.Business, "AndroidVideoCaptureApi.startVideoCapture", null));
    }

    public final void e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.a.k1(new uv0.a(LiveRequestSourceRole.Business, "AndroidVideoCaptureApi.stopVideoCapture", null));
    }

    public final void g(int r6) {
        this.a.Z0(r6, new uv0.a(LiveRequestSourceRole.Business, "AndroidVideoCaptureApi.switchVideoCaptureWithDevice", null));
    }

    public a(d r2, d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        Intrinsics.checkNotNullParameter(r3, "liveCore");
        this.a = r2;
        this.b = r3;
    }

    public final void a(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a.P0(r2, r3);
    }
}
