package b19;

import android.view.View;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ FlowCommonAppCompatActivity a;

    public /* synthetic */ c(FlowCommonAppCompatActivity r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowCommonAppCompatActivity r0 = this.a;
        View r1 = r0.b;
        if (r1 == null) goto L6;
        r1.setBackgroundColor(r0.c);
        return;
    }
}
