package ev0;

import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        c r5 = this.a.a;
        int r0 = c.f;
        r5.getClass();
        c.a("observePanelState subscribe State.READY 超时关闭");
        this.a.c.put("fail_reason", "time_out");
        c r6 = this.a.a;
        String r1 = LiveTaskPanelTraceMonitor.Step.PANEL_SHOW_HYBRID_FAIL.getStep();
        Map r2 = this.a.c;
        r6.getClass();
        c.d(r1, r2);
        this.a.b.a(PanelInfo.State.DISMISSED, null);
    }
}
