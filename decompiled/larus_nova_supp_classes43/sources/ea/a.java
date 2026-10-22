package ea;

import android.widget.TextView;
import com.bytedance.android.annie.view.WebRiskHintView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ WebRiskHintView a;
    public final /* synthetic */ String b;

    public a(WebRiskHintView r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView r0 = this.a.a;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.setText(this.b);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
