package j19;

import android.os.Handler;
import android.os.Looper;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements l19.f {
    public final /* synthetic */ PhotoViewerDialog a;

    public i(PhotoViewerDialog r1) {
        this.a = r1;
    }

    @Override // l19.f
    public final void onTransitionBegin(int r3) {
        Iterator<d> r0 = this.a.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onTransitionBegin(r3);
        goto L4
    }

    @Override // l19.f
    public final void onTransitionEnd(int r5) {
        if (r5 != 2) goto L5;
        PhotoViewerDialog r0 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r0);
    L23:
        Iterator<d> r2 = this.a.i.iterator();
    L25:
        if (r2.hasNext() == false) goto L27;
        r2.next().onTransitionEnd(r5);
        goto L25
    L27:
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L11:
        if (Looper.myLooper() == r1.getLooper()) goto L13;
        r1.post(DialogLancet.createDismissRunnable(r0));
        goto L23
    L5:
        if (r5 != 3) goto L23;
        PhotoViewerDialog r4 = this.a;
        r4.k = r4.j;
        goto L23
    }

    @Override // l19.f
    public final void onTransitionChanged(int r5, float r6) {
        PhotoViewerDialog r0 = this.a;
        if (r5 != 0) goto L5;
        float r3 = r6;
    L15:
        r0.j = r3;
        this.a.c.getBackground().setAlpha((int) (this.a.j * 255));
        Iterator<d> r1 = this.a.i.iterator();
    L17:
        if (r1.hasNext() == false) goto L19;
        r1.next().onTransitionChanged(r5, r6);
        goto L17
    L19:
        return;
    L5:
        if (r5 != 1) goto L7;
        float r2 = r0.k;
        r3 = r2 + ((1 - r2) * r6);
        goto L15
    L7:
        if (r5 == 2) goto L12;
        r3 = 1.0f;
        if (r5 != 3) goto L15;
        r3 = 1 - Math.min(1.0f, Math.max(r6, 0.0f));
        goto L15
    L12:
        r3 = r0.k * (1 - r6);
        goto L15
    }
}
