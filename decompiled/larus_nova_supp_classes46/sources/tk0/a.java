package tk0;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final d a;
    public final d0 b;

    public final boolean a() {
        return this.a.t0();
    }

    public final boolean b() {
        return this.a.N();
    }

    public final void e() {
        this.a.getLiveCore().h();
    }

    public final void f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        this.a.M0(r6, new uv0.a(LiveRequestSourceRole.Business, "AndroidAudioCaptureApi.startAudioCapture", null));
    }

    public final void g(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        this.a.f1(r6, new uv0.a(LiveRequestSourceRole.Business, "AndroidAudioCaptureApi.stopAudioCapture", null));
    }

    public a(d r2, d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        Intrinsics.checkNotNullParameter(r3, "liveCore");
        this.a = r2;
        this.b = r3;
    }

    public final void c(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        this.a.Q0(r6, r7, new uv0.a(LiveRequestSourceRole.Business, "AndroidAudioCaptureApi.setAudioMute", null));
    }

    public final void d(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        this.a.R0(r6, r7, new uv0.a(LiveRequestSourceRole.Business, "AndroidAudioCaptureApi.setAudioMuteRaw", null));
    }
}
