package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.transition.TransitionPhotoDraweeView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/PhotoViewerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoViewerDialogFragment extends DialogFragment {
    public static final /* synthetic */ int j = 0;
    public TransitionPhotoDraweeView d;
    public ImageView e;
    public ConstraintLayout f;
    public String g;
    public float h;
    public float i;

    public static final class a {
    }

    public static final class b implements ca2.a {
        public final /* synthetic */ PhotoViewerDialogFragment a;

        @Override // ca2.a
        public final void onTransitionBegin(int r1) {
        }

        public b(PhotoViewerDialogFragment r1) {
            this.a = r1;
        }

        @Override // ca2.a
        public final void onTransitionEnd(int r2) {
            if (r2 == 2) goto L16;
            if (r2 != 3) goto L20;
            PhotoViewerDialogFragment r3 = this.a;
            r3.i = r3.h;
            return;
        L20:
            return;
        L16:
            this.a.dismiss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L19;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // ca2.a
        public final void onTransitionChanged(int r4, float r5) {
            PhotoViewerDialogFragment r0 = this.a;
            if (r4 != 0) goto L5;
        L14:
            r0.h = r5;
            ConstraintLayout r6 = this.a.f;
            if (r6 == null) goto L20;
            Drawable r7 = r6.getBackground();
            if (r7 == null) goto L21;
            r7.setAlpha((int) (this.a.h * 255));
            return;
        L21:
            return;
        L20:
            return;
        L5:
            if (r4 != 1) goto L7;
            float r8 = r0.i;
            r5 = r8 + ((1 - r8) * r5);
            goto L14
        L7:
            if (r4 != 2) goto L9;
            r5 = r0.i * (1 - r5);
            goto L14
        L9:
            if (r4 == 3) goto L11;
            r5 = 1.0f;
            goto L14
        L11:
            r5 = 1 - Math.max(r5, 0.0f);
            goto L14
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PhotoViewerDialogFragment a;

        public c(PhotoViewerDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public PhotoViewerDialogFragment() {
        this.h = 1.0f;
        this.i = 1.0f;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
    L12:
        TransitionPhotoDraweeView r1 = this.d;
        if (r1 == null) goto L18;
        r1.n.clear();
        return;
    L18:
        return;
    L5:
        if (r0.isShowing() != true) goto L12;
        dismiss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L12;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        Window r1 = r0.getWindow();
    L6:
        if (r1 == null) goto L8;
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L8:
        if (r1 == null) goto L13;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        if (r2 == null) goto L14;
        r2.gravity = 17;
        r2.width = -1;
        r2.height = -1;
        r1.setAttributes(r2);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L11
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        TransitionPhotoDraweeView r4 = this.d;
        if (r4 == null) goto L5;
        r4.setController(Fresco.newDraweeControllerBuilder().setUri(this.g).build());
        b r5 = new b(this);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r4.n.add(r5);
    L5:
        ImageView r6 = this.e;
        if (r6 == null) goto L9;
        r6.setOnClickListener(new c(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Context r5 = getContext();
        if (r5 == null) goto L18;
        View r6 = LayoutInflater.from(r5).inflate(2131566732, r3, true);
        ImageView r7 = null;
        if ((r6 instanceof ConstraintLayout) == true) goto L7;
        r6 = null;
    L7:
        ConstraintLayout r8 = (ConstraintLayout) r6;
        this.f = r8;
        if (r8 == null) goto L10;
        TransitionPhotoDraweeView r9 = (TransitionPhotoDraweeView) r8.findViewById(2131382263);
    L11:
        this.d = r9;
        ConstraintLayout r10 = this.f;
        if (r10 == null) goto L14;
        r7 = (ImageView) r10.findViewById(2131366988);
    L14:
        this.e = r7;
        ConstraintLayout r11 = this.f;
        if (r11 == null) goto L18;
        r11.setBackgroundColor(-16777216);
        goto L18
    L10:
        r9 = null;
    L18:
        return this.f;
    }
}
