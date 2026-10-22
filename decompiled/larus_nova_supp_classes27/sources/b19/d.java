package b19;

import android.view.View;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ FlowCommonAppCompatActivity a;

    public /* synthetic */ d(FlowCommonAppCompatActivity r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowCommonAppCompatActivity r0 = this.a;
        View r1 = r0.b;
        if (r1 == null) goto L6;
        int r2 = u.b(r0);
        int r3 = r1.getPaddingStart();
        int r4 = r1.getPaddingTop();
        int r5 = r1.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:needAdaptNavigationBarPadding,start:" + r3 + ",top:" + r4 + ",end:" + r5 + ",bottom:" + r2);
        r1.setPaddingRelative(r3, r4, r5, r2);
        return;
    }
}
