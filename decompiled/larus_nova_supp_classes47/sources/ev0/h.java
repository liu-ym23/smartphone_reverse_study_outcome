package ev0;

import android.app.Dialog;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends b7.a {
    public final /* synthetic */ PanelInfo a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.monitor.d b;
    public final /* synthetic */ c c;
    public final /* synthetic */ Map d;

    public final void onPrepareComponentStart() {
        com.bytedance.android.livesdk.chatroom.monitor.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.d("PREPARE_COMPONENT");
    L5:
        this.c.getClass();
        c.a("showHybridDialog onPrepareComponentStart");
    }

    public final void onRelease() {
        super.onRelease();
        PanelInfo r0 = this.a;
        PanelInfo.State r1 = PanelInfo.State.DISMISSED;
        HybridDialog r2 = this.c.e;
        if (r2 == null) goto L5;
        Dialog r3 = r2.getDialog();
    L6:
        r0.a(r1, r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onLoadSuccess(View r3) {
        com.bytedance.android.livesdk.chatroom.monitor.d r4 = this.b;
        if (r4 == null) goto L5;
        r4.d("ON_PAGE_FINISH");
        r4.g();
    L5:
        this.d.put("hybrid_state", "load_success");
        c r5 = this.c;
        String r0 = LiveTaskPanelTraceMonitor.Step.PANEL_SHOW_HYBRID_SUCCESS.getStep();
        Map r1 = this.d;
        r5.getClass();
        c.d(r0, r1);
        PanelInfo r6 = this.a;
        PanelInfo.State r2 = PanelInfo.State.SHOWING;
        HybridDialog r7 = this.c.e;
        if (r7 == null) goto L8;
        Dialog r8 = r7.getDialog();
    L9:
        r6.a(r2, r8);
        this.c.getClass();
        c.a("showHybridDialog onLoadSuccess");
        return;
    L8:
        r8 = null;
        goto L9
    }

    public final void onLoadStart(View r1, boolean r2) {
        com.bytedance.android.livesdk.chatroom.monitor.d r3 = this.b;
        if (r3 == null) goto L5;
        r3.d("LOAD_URL");
    L5:
        this.c.getClass();
        c.a("showHybridDialog onLoadStart");
    }

    public final void onLoadFail(View r1, String r2, String r3) {
        super.onLoadFail(r1, r2, r3);
        PanelInfo r4 = this.a;
        PanelInfo.State r5 = PanelInfo.State.DISMISSED;
        HybridDialog r6 = this.c.e;
        if (r6 == null) goto L5;
        Dialog r7 = r6.getDialog();
    L6:
        r4.a(r5, r7);
        int r8 = hv0.a.a;
        c r9 = this.c;
        Uri r10 = this.a.d;
        r9.getClass();
        hv0.a.b(0, c.c(r10), this.c.b.size());
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void onPrepareInitDataStart(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "scheme");
        Intrinsics.checkNotNullParameter(r2, "fallbackUrl");
        com.bytedance.android.livesdk.chatroom.monitor.d r4 = this.b;
        if (r4 == null) goto L5;
        r4.d("PREPARE_DATA");
    L5:
        this.c.getClass();
        c.a("showHybridDialog onPrepareInitDataStart");
    }

    public h(PanelInfo r1, com.bytedance.android.livesdk.chatroom.monitor.d r2, c r3, Map r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
