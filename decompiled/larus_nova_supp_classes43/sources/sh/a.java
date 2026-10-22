package sh;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.CommentPagePhotoViewerDialog;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements TransitionListener {
    public final /* synthetic */ CommentPagePhotoViewerDialog a;

    public a(CommentPagePhotoViewerDialog r1) {
        this.a = r1;
    }

    public final void onTransitionBegin(int r10) {
        Iterator<T> r0 = this.a.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IIndicatorView) r0.next()).onTransitionBegin(r10);
        goto L4
    }

    public final void onTransitionEnd(int r10) {
        if (r10 != 2) goto L5;
        CommentPagePhotoViewerDialog r0 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r0);
    L23:
        Iterator<T> r11 = this.a.j.iterator();
    L25:
        if (r11.hasNext() == false) goto L27;
        ((IIndicatorView) r11.next()).onTransitionEnd(r10);
        goto L25
    L27:
        return;
    L18:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r12 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r12 == null) goto L22;
        d.d(r12, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L11:
        if (Looper.myLooper() == r1.getLooper()) goto L13;
        r1.post(DialogLancet.createDismissRunnable(r0));
        goto L23
    L5:
        if (r10 != 3) goto L23;
        CommentPagePhotoViewerDialog r13 = this.a;
        r13.l = r13.k;
        goto L23
    }

    public final void onTransitionChanged(int r10, float r11) {
        CommentPagePhotoViewerDialog r0 = this.a;
        if (r10 != 0) goto L5;
        float r12 = r11;
    L15:
        r0.k = r12;
        CommentPagePhotoViewerDialog r1 = this.a;
        if (r1.k <= 1.0f) goto L19;
        r1.k = 1.0f;
    L19:
        if (r1.k >= 0.0f) goto L21;
        r1.k = 0.0f;
    L21:
        r1.b.getBackground().setAlpha((int) (this.a.k * 255));
        Iterator<T> r13 = this.a.j.iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        ((IIndicatorView) r13.next()).onTransitionChanged(r10, r11);
        goto L23
    L25:
        return;
    L5:
        if (r10 != 1) goto L7;
        float r14 = r0.l;
        r12 = ((1 - r14) * r11) + r14;
        goto L15
    L7:
        if (r10 != 2) goto L9;
        r12 = (1 - r11) * r0.l;
        goto L15
    L9:
        if (r10 == 3) goto L11;
        r12 = 1.0f;
        goto L15
    L11:
        r12 = 1 - Math.max(r11, 0.0f);
        goto L15
    }
}
