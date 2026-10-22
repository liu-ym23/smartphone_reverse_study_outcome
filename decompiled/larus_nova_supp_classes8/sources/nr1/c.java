package nr1;

import com.bytedance.android.livesdk.player.LivePlayerMonitor;
import com.bytedance.android.livesdk.player.g0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vr1.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements a0 {
    public final LivePlayerMonitor a;

    @Override // vr1.a0
    public final void b() {
        Intrinsics.checkNotNullParameter("", "enterFromMerge");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.a.t("", "", 0);
    }

    @Override // vr1.a0
    public final void h() {
        this.a.f = 1;
    }

    public c(LivePlayerMonitor r2) {
        Intrinsics.checkNotNullParameter(r2, "livePlayerMonitor");
        this.a = r2;
    }

    @Override // vr1.a0
    public final void a(int r2) {
        this.a.e = r2;
    }

    @Override // vr1.a0
    public final void f(long r11) {
        Intrinsics.checkNotNullParameter("", "enterFromMerge");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.a.o(105, "ttplayer init failed", r11, "", "", "", "", 0);
    }

    @Override // vr1.a0
    public final void g(long r7) {
        Intrinsics.checkNotNullParameter("", "enterFromMerge");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.a.n(r7, "", "", 0);
    }

    @Override // vr1.a0
    public final void c(int r3, String r4, long r5) {
        this.a.q(new g0(r3, r4, r5));
    }

    @Override // vr1.a0
    public final void d(int r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter("", "enterFromMerge");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.a.s(r11, r12, r13, "", "", "", "", 0);
    }

    @Override // vr1.a0
    public final void e(int r3, JSONObject r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "info");
        this.a.q(new g0(r3, r4, r5));
    }
}
