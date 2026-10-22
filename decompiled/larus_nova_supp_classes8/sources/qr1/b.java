package qr1;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Observer<Boolean> {
    public final /* synthetic */ i a;

    public b(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Boolean r0 = Boolean.TRUE;
        if (r0.equals((Boolean) r5) == false) goto L9;
        this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "first frame ready"));
        this.a.d("point_finish_first_frame_time", String.valueOf(System.currentTimeMillis()));
        this.a.a("player_status", "success");
        long r1 = this.a.f();
        if (r1 <= 0) goto L7;
        this.a.e("start_to_first_frame_cost", System.currentTimeMillis() - r1);
    L7:
        i r6 = this.a;
        r6.f.c = true;
        r6.h(0, "");
        return;
    }
}
