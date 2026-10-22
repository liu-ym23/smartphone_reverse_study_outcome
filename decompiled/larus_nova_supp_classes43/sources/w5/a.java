package w5;

import android.view.View;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ BottomSheetBehavior d;

    @Override // java.lang.Runnable
    public final void run() {
        this.d.c(this.a, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BottomSheetBehavior r1, View r10, int r11, boolean r12) {
        this.d = r1;
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
