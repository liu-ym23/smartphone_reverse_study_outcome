package nl0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.lynx.element.pullrefresh.LynxPullRefreshView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements gqa.b {
    public final /* synthetic */ LynxPullRefreshView a;

    public c(LynxPullRefreshView r1) {
        this.a = r1;
    }

    public final void O0(h r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        ALogger.i("LynxPullRefreshView", "OnLoadMoreListener -> start load more");
        LynxContext r5 = this.a.getLynxContext();
        if (r5 == null) goto L8;
        EventEmitter r6 = r5.getEventEmitter();
        if (r6 == null) goto L9;
        r6.sendCustomEvent(new com.lynx.tasm.event.a(this.a.getSign(), "startloadmore"));
        return;
    L9:
        return;
    }
}
