package nl0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.lynx.element.pullrefresh.LynxPullRefreshView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import gqa.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends f {
    public final /* synthetic */ LynxPullRefreshView a;

    public final void L() {
        ALogger.d("LynxPullRefreshView", "MultiPurposeListener -> onHeaderMoving");
    }

    public final void h() {
        ALogger.d("LynxPullRefreshView", "MultiPurposeListener -> onHeaderFinish");
    }

    public final void o() {
        ALogger.d("LynxPullRefreshView", "MultiPurposeListener -> onHeaderStartAnimator");
    }

    public final void p() {
        ALogger.d("LynxPullRefreshView", "MultiPurposeListener -> onHeaderReleased");
        LynxContext r0 = this.a.getLynxContext();
        if (r0 == null) goto L8;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L9;
        r1.sendCustomEvent(new com.lynx.tasm.event.a(this.a.getSign(), "headerreleased"));
        return;
    L9:
        return;
    }

    public d(LynxPullRefreshView r1) {
        this.a = r1;
    }
}
