package e40;

import android.content.DialogInterface;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements DialogInterface.OnClickListener {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        ALogger.i("CloudGroupLivePreviewView", "click leave btn, cancel");
        int r7 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "clickLeaveCancel", 0, null, 28);
        r5.dismiss();
    }
}
