package uhb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.flow.passport.ui.widget.common.CodeView;
import com.ss.android.lark.flow.passport.ui.widget.verifycode.VerifyCodeEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ VerifyCodeEditText a;

    @Override // java.lang.Runnable
    public final void run() {
        VerifyCodeEditText r0 = this.a;     // Catch: Throwable -> L8
        CodeView[] r1 = r0.d;     // Catch: Throwable -> L8
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.length <= 0) goto L15;
        r0.a.setPadding(r1[0].getWidth() / 2, 0, 0, 0);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public b(VerifyCodeEditText r1) {
        this.a = r1;
    }
}
