package com.larus.commercecredit.impl.page;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.larus.commercecredit.impl.databinding.LarusFragmentCommerceCreditGuideBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/commercecredit/impl/page/CommerceCreditGuideFragment;", "Lcom/larus/commercecredit/impl/page/BaseCommerceCreditFragment;", "Lcom/larus/commercecredit/impl/databinding/LarusFragmentCommerceCreditGuideBinding;", "<init>", "()V", "creditTip", "Lcom/larus/commercecredit/impl/entity/CreditTip;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getAssociatedActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseArguments", "initViews", "initEvents", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceCreditGuideFragment extends BaseCommerceCreditFragment<LarusFragmentCommerceCreditGuideBinding> {
    public static final /* synthetic */ int g = 0;
    public qz8.k f;

    public static final class a {
    }

    public static final class b extends ClickableSpan {
        public final /* synthetic */ qz8.e a;
        public final /* synthetic */ CommerceCreditGuideFragment b;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r5) {
            Intrinsics.checkNotNullParameter(r5, "widget");
            String r6 = this.a.f();
            CommerceCreditGuideFragment r0 = this.b;
            com.bytedance.router.i r7 = SmartRouter.buildRoute(r0.getContext(), r6);
            r7.c.putExtra("previous_page", "credit_tip_page");
            int r1 = com.larus.commercecredit.impl.utils.k.a;
            String r2 = com.larus.commercecredit.impl.utils.k.a(r0.getArguments(), "enter_method");
            r7.c.putExtra("enter_method", r2);
            r7.d();
            r0.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            r0.y();
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L9;
            com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "ds");
            super.updateDrawState(r3);
            r3.setColor(ContextCompat.getColor(this.b.requireContext(), 2131103136));
            r3.setUnderlineText(false);
        }

        public b(qz8.e r1, CommerceCreditGuideFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void initViews() {
        qz8.k r0 = this.f;
        if (r0 == null) goto L34;
        qz8.e r1 = r0.a();
        if (r1 == null) goto L35;
        LarusFragmentCommerceCreditGuideBinding r2 = (LarusFragmentCommerceCreditGuideBinding) this.d;
        if (r2 == null) goto L36;
        ImageLoaderKt.u(r2.d, qz8.h.a(r1.e(), r1.c()), "commerce_credit_guide");
        TextView r3 = r2.f;
        String r4 = r1.h();
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r3.setText(r4);
        String r6 = r1.d();
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        String r7 = r1.g();
        if (r7 == null) goto L19;
        r5 = r7;
    L19:
        String r8 = r6.concat(r5);
        if (r5.length() <= 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == true) goto L25;
    L27:
        r2.e.setText(r8);
    L28:
        LarusFragmentCommerceCreditGuideBinding r10 = (LarusFragmentCommerceCreditGuideBinding) this.d;
        if (r10 == null) goto L37;
        TextView r11 = r10.b;
        if (r11 == null) goto L38;
        r11.setText(r1.b());
        return;
    L38:
        return;
    L37:
        return;
    L25:
        if (r1.f() == null) goto L27;
        SpannableString r12 = new SpannableString(r8);
        int r13 = r6.length();
        int r14 = r8.length();
        r12.setSpan(new b(r1, this), r13, r14, 33);
        r2.e.setText(r12);
        r2.e.setMovementMethod(LinkMovementMethod.getInstance());
        goto L28
    L22:
        r9 = false;
        goto L23
    L36:
        return;
    L35:
        return;
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final void V90() {
        super.V90();
        LarusFragmentCommerceCreditGuideBinding r0 = (LarusFragmentCommerceCreditGuideBinding) this.d;
        if (r0 == null) goto L7;
        ImageView r1 = r0.c;
        if (r1 == null) goto L7;
        e1.d(r1, new e(this));
    L7:
        LarusFragmentCommerceCreditGuideBinding r2 = (LarusFragmentCommerceCreditGuideBinding) this.d;
        if (r2 == null) goto L13;
        TextView r3 = r2.b;
        if (r3 == null) goto L14;
        e1.d(r3, new f(this));
        return;
    L14:
        return;
    }

    public CommerceCreditGuideFragment() {
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final Class<? extends Activity> T90() {
        return CommerceCreditGuideActivity.class;
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        int r4 = com.larus.commercecredit.impl.utils.k.a;
        Bundle r5 = getArguments();
        if (r5 == null) goto L9;
        String r6 = r5.getString("credit_tip");
        if (r6 == null) goto L9;
        Object r7 = new Gson().fromJson(r6, qz8.k.class);     // Catch: Exception -> L12
    L10:
        this.f = (qz8.k) r7;
        return;
    L9:
        r7 = null;
        goto L10
    }

    @Override // com.larus.commercecredit.impl.page.BaseCommerceCreditFragment
    public final ViewBinding S90(LayoutInflater r9, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r11 = r9.inflate(2131562360, r10, false);
        int r12 = 2131364655;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131364655);
        if (r3 == null) goto L15;
        r12 = 2131376107;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r11, 2131376107);
        if (r4 == null) goto L15;
        r12 = 2131376284;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r11, 2131376284);
        if (r5 == null) goto L15;
        r12 = 2131390479;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131390479);
        if (r6 == null) goto L15;
        r12 = 2131391606;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, 2131391606);
        if (r7 == null) goto L15;
        return new LarusFragmentCommerceCreditGuideBinding(r11, r3, r4, r5, r6, r7);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
