package nr1;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.helper.EnterRoomTimeTracer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements wr1.d {
    public final EnterRoomTimeTracer a;

    @Override // wr1.d
    public final void cancelTrace() {
        this.a.p();
    }

    @Override // wr1.d
    public final void f() {
        this.a.k = "live_replay";
    }

    public b(EnterRoomTimeTracer r2) {
        Intrinsics.checkNotNullParameter(r2, "enterRoomTimeTracer");
        this.a = r2;
    }

    @Override // wr1.d
    public final void a(boolean r2) {
        this.a.q = r2;
    }

    @Override // wr1.d
    public final void b(Bundle r2) {
        this.a.q(r2);
    }

    @Override // wr1.d
    public final void c(Map<String, String> r2) {
        this.a.p = r2;
    }

    @Override // wr1.d
    public final void e(Map<String, String> r5) {
        this.a.n(0, r5, null);
    }

    @Override // wr1.d
    public final long g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "eventNameString");
        EnterRoomTimeTracer.EventName r4 = EnterRoomTimeTracer.EventName.valueOf(r3);
        EnterRoomTimeTracer.a r5 = (EnterRoomTimeTracer.a) this.a.f.get(r4.ordinal());
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.b;
    }

    @Override // wr1.d
    public final void d(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "eventNameString");
        EnterRoomTimeTracer.EventName r4 = EnterRoomTimeTracer.EventName.valueOf(r2);
        this.a.m(r4, r3);
    }
}
