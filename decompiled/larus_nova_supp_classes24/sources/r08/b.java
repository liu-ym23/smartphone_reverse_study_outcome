package r08;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import h18.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends UDListDialogController {
    public float h;

    public static final class a {
    }

    /* JADX INFO: renamed from: r08.b$b, reason: collision with other inner class name */
    public static final class C0122b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ b a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public C0122b(b r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
        public final void onStateChanged(View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "bottomSheet");
            if (r4 != 5) goto L23;
            ?? r5 = this.a.getMDialog();
            if (r5 == 0) goto L27;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L16:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r7 == null) goto L20;
            d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L9:
            if (Looper.myLooper() == r6.getLooper()) goto L11;
            r6.post(DialogLancet.createDismissRunnable(r5));
            return;
        L27:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ?? r5 = this.a.getMDialog();
            if (r5 == 0) goto L21;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L14:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
            return;
        }
    }

    static {
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultRootRes() {
        return 2131568078;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r0 = super.createView();
        if (r0 != null) goto L5;
        return null;
    L5:
        View r2 = r0.findViewById(2131391773);
        if (r2 == null) goto L15;
        BottomSheetBehavior r3 = BottomSheetBehavior.from(r2);
        int r4 = r3.getPeekHeight();
        float r5 = this.h;
        if (r5 <= 0.0f) goto L10;
        r3.setPeekHeight((int) getSize(r5, g.a(getContext()).getHeight()));
    L12:
        r3.setHideable(false);
        r3.setBottomSheetCallback(new C0122b(this));
        if (getMBackground() == null) goto L15;
        r0.setBackground(null);
        r2.setBackground(getMBackground());
        goto L15
    L10:
        if (r4 != 0) goto L12;
        r3.setPeekHeight((int) getSize(0.5f, g.a(getContext()).getHeight()));
    L15:
        View r1 = r0.findViewById(2131391772);
        if (Intrinsics.areEqual(getMCanceledOnTouchOutside(), Boolean.FALSE) == true) goto L19;
        if (r1 == null) goto L19;
        r1.setOnClickListener(new c(this));
    L19:
        return r0;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof r08.a) == false) goto L7;
        super.apply(r2, r3);
        this.h = ((r08.a) r2).a;
        return;
    L7:
        throw new IllegalArgumentException("builder should be UDActionSheetBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }
}
