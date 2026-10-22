package e40;

import android.content.DialogInterface;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ a a;

    public e(a r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        ALogger.i("CloudGroupLivePreviewView", "click leave btn, confirm");
        int r7 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "clickLeaveConfirm", 0, null, 28);
        this.a.e.f();
        r5.dismiss();
    }
}
