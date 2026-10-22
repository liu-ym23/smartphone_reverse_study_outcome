package com.larus.dora.impl.nl;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.dora.impl.databinding.LarusDoraDialogPrivacyPolicyBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/impl/nl/DoraPrivacyDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "title", "", "content", "onAgreeClick", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDialogPrivacyPolicyBinding;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupUI", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraPrivacyDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public final String d;
    public final String e;
    public final Function0<Unit> f;
    public LarusDoraDialogPrivacyPolicyBinding g;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951938;
    }

    public DoraPrivacyDialogFragment() {
        this.d = "";
        this.e = "";
        this.f = new c();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L5;
        r6.setCanceledOnTouchOutside(false);
    L5:
        BottomSheetDialog r7 = getDialog();
        if ((r7 instanceof BottomSheetDialog) == false) goto L8;
        BottomSheetDialog r8 = r7;
    L9:
        if (r8 == null) goto L11;
        View r9 = r8.findViewById(2131368870);
    L12:
        if (r9 == null) goto L14;
        r9.setBackgroundResource(R.color.transparent);
        BottomSheetBehavior r0 = BottomSheetBehavior.from(r9);
        r0.setState(3);
        int r2 = com.larus.utils.m0.a;
        r0.setPeekHeight(com.larus.utils.m0.a(r9.getContext()));
        r0.setHideable(false);
    L14:
        LarusDoraDialogPrivacyPolicyBinding r10 = this.g;
        if (r10 == null) goto L22;
        ConstraintLayout r11 = r10.b;
        boolean r1 = v19.h.a;
        if (v19.h.a(null) == false) goto L19;
        int r3 = 2131102539;
    L20:
        r11.setBackgroundResource(r3);
        r10.f.setText(this.d);
        r10.e.setUrlSpannedText(this.e + ' ');
        r10.e.setOnClickListener(new d(r10));
        e1.d(r10.c, new com.larus.dora.impl.nl.a(this));
        e1.d(r10.d, new b(this));
        return;
    L19:
        r3 = 2131102529;
        goto L20
    L22:
        return;
    L11:
        r9 = null;
        goto L12
    L8:
        r8 = null;
        goto L9
    }

    public DoraPrivacyDialogFragment(String r2, String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "onAgreeClick");
        this();
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562167, r9, false);
        int r12 = 2131367728;
        RoundConstraintLayout r2 = (RoundConstraintLayout) ViewBindings.findChildViewById(r11, 2131367728);
        if (r2 == null) goto L15;
        r12 = 2131369966;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r11, 2131369966);
        if (r3 == null) goto L15;
        r12 = 2131369967;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r11, 2131369967);
        if (r4 == null) goto L15;
        r12 = 2131369968;
        UrlSpanTextView r5 = (UrlSpanTextView) ViewBindings.findChildViewById(r11, 2131369968);
        if (r5 == null) goto L15;
        r12 = 2131369969;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r11, 2131369969);
        if (r6 == null) goto L15;
        FrameLayout r13 = (FrameLayout) r11;
        this.g = new LarusDoraDialogPrivacyPolicyBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
