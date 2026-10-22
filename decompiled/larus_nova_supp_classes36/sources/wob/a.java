package wob;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.slot.InjectableInputView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ InjectableInputView a;

    public a(InjectableInputView r1) {
        this.a = r1;
    }

    public final void a() {
        int r0 = this.a.b.getMeasuredWidth();
        int r1 = this.a.d.getMeasuredWidth();
        InjectableInputView r2 = this.a;
        int r3 = r2.h;
        int r4 = 0;
        if (r0 <= 0) goto L5;
        int r5 = r0 + r2.i;
    L6:
        int r6 = r5 + r3;
        if (r1 <= 0) goto L9;
        r4 = r2.i + r1;
    L9:
        EditText r7 = r2.a;
        int r8 = r7.getPaddingTop();
        r7.setPadding(r6, r8, r3 + r4, this.a.a.getPaddingBottom());
        return;
    L5:
        r5 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
