package com.larus.bmhome.bigimg;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.databinding.LarusAddCreationDialogBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0013\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0015\u001a\u00020\u000e26\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007J&\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/bmhome/bigimg/AddCreationBSDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/image/databinding/LarusAddCreationDialogBinding;", "resultCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "requestKey", "Landroid/os/Bundle;", "result", "", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "behaviorCallback", "com/larus/bmhome/bigimg/AddCreationBSDialog$behaviorCallback$1", "Lcom/larus/bmhome/bigimg/AddCreationBSDialog$behaviorCallback$1;", "setResultCallback", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "getTheme", "", "onViewCreated", "view", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AddCreationBSDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public LarusAddCreationDialogBinding d;
    public Function2<? super String, ? super Bundle, Unit> e;
    public BottomSheetBehavior<View> f;
    public final a g;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/bigimg/AddCreationBSDialog$Companion$PrivateStatus;", "", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PrivateStatus {
            public static final a Companion = null;
            public static final int Private = 2;
            public static final int Public = 1;

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }
    }

    public static final class a extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ AddCreationBSDialog a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public a(AddCreationBSDialog r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.f;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public AddCreationBSDialog() {
        this.g = new a(this);
    }

    public static void S90(AddCreationBSDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L5;
        r4.setOnShowListener(new com.larus.bmhome.bigimg.a(this));
    L5:
        LarusAddCreationDialogBinding r5 = this.d;
        if (r5 == null) goto L9;
        com.larus.utils.e1.d(r5.b, new b(this));
        com.larus.utils.e1.d(r5.c, new c(this));
        com.larus.utils.e1.d(r5.d, new d(this));
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131561801, r4, false);
        int r7 = 2131362559;
        if (((Space) ViewBindings.findChildViewById(r6, 2131362559)) == null) goto L17;
        r7 = 2131376107;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r6, 2131376107);
        if (r8 == null) goto L17;
        r7 = 2131388741;
        if (ViewBindings.findChildViewById(r6, 2131388741) == null) goto L17;
        r7 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131388772)) == null) goto L17;
        r7 = 2131391164;
        AppCompatTextView r0 = ViewBindings.findChildViewById(r6, 2131391164);
        if (r0 == null) goto L17;
        r7 = 2131391216;
        AppCompatTextView r1 = ViewBindings.findChildViewById(r6, 2131391216);
        if (r1 == null) goto L17;
        ConstraintLayout r9 = r6;
        this.d = new LarusAddCreationDialogBinding(r9, r8, r0, r1);
        return r9;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
