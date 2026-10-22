package z19;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.widget.SeparatedEditText;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v extends TimerTask {
    public final /* synthetic */ SeparatedEditText a;

    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.EditText, com.larus.common_ui.widget.SeparatedEditText] */
    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        ?? r0 = this.a;     // Catch: Throwable -> L4
        r0.D = !r0.D;     // Catch: Throwable -> L4
        r0.postInvalidate();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public v(SeparatedEditText r1) {
        this.a = r1;
    }
}
