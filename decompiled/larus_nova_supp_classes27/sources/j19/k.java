package j19;

import android.view.View;
import com.larus.common_ui.photoviewer.PhotoViewerDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements l19.f {
    public final /* synthetic */ PhotoViewerDialogFragment a;
    public final /* synthetic */ View b;

    @Override // l19.f
    public final void onTransitionBegin(int r3) {
        Iterator<d> r0 = this.a.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onTransitionBegin(r3);
        goto L4
    }

    @Override // l19.f
    public final void onTransitionEnd(int r3) {
        if (r3 != 0) goto L4;
        this.a.U90();
    L17:
        Iterator<d> r0 = this.a.j.iterator();
    L19:
        if (r0.hasNext() == false) goto L21;
        r0.next().onTransitionEnd(r3);
        goto L19
    L21:
        return;
    L4:
        if (r3 == 2) goto L22;
        if (r3 != 3) goto L17;
        PhotoViewerDialogFragment r1 = this.a;
        r1.l = r1.k;
        goto L17
    L22:
        this.a.dismiss();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L17;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L17
    }

    public k(PhotoViewerDialogFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // l19.f
    public final void onTransitionChanged(int r5, float r6) {
        PhotoViewerDialogFragment r0 = this.a;
        if (r5 != 0) goto L5;
        float r3 = r6;
    L15:
        r0.k = r3;
        this.b.getBackground().setAlpha((int) (this.a.k * 255));
        Iterator<d> r1 = this.a.j.iterator();
    L17:
        if (r1.hasNext() == false) goto L19;
        r1.next().onTransitionChanged(r5, r6);
        goto L17
    L19:
        return;
    L5:
        if (r5 != 1) goto L7;
        float r2 = r0.l;
        r3 = r2 + ((1 - r2) * r6);
        goto L15
    L7:
        if (r5 == 2) goto L12;
        r3 = 1.0f;
        if (r5 != 3) goto L15;
        r3 = 1 - Math.min(1.0f, Math.max(r6, 0.0f));
        goto L15
    L12:
        r3 = r0.l * (1 - r6);
        goto L15
    }
}
