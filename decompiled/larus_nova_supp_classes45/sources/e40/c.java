package e40;

import android.view.View;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        a r7 = this.a;
        r7.getClass();
        ALogger.i("CloudGroupLivePreviewView", "click leave btn, show double check dialog");
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "clickLeaveBtn", 0, null, 28);
        x0.b r1 = new x0.b(r7.getContext(), 4);
        r1.a.c = s1.B(2131915854);
        r1.a.d = s1.B(2131915853);
        r1.i(1, 2131915851, d.a);
        r1.i(0, 2131915852, new e(r7));
        r1.k(0, true);
        r1.n();
    }
}
