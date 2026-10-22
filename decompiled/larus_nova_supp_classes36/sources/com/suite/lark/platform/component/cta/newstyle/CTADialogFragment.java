package com.suite.lark.platform.component.cta.newstyle;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberNonDirectionalPage$Param$Type;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.UIHelper;
import com.suite.lark.platform.component.cta.databinding.FragmentCtaDialogBinding;
import com.suite.lark.platform.component.cta.newstyle.adapter.BenefitListAdapter;
import com.suite.lark.platform.component.cta.newstyle.adapter.VersionInfoAdapter;
import com.suite.lark.platform.component.cta.newstyle.entity.CTAParams;
import com.suite.lark.platform.component.cta.newstyle.widgets.CustomButtonGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import z5c.e4;
import z5c.j3;
import z5c.p2;
import z5c.r;
import z5c.v1;
import z5c.w0;
import z5c.x0;
import z5c.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0016J\b\u00105\u001a\u00020&H\u0016J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/CTADialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "viewBinding", "Lcom/suite/lark/platform/component/cta/databinding/FragmentCtaDialogBinding;", "ctaDialogCallback", "Lcom/suite/lark/platform/component/cta/entity/CTADialogCallback;", "getCtaDialogCallback", "()Lcom/suite/lark/platform/component/cta/entity/CTADialogCallback;", "setCtaDialogCallback", "(Lcom/suite/lark/platform/component/cta/entity/CTADialogCallback;)V", "stuckSpotResponse", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse;", "ctaParams", "Lcom/suite/lark/platform/component/cta/newstyle/entity/CTAParams;", "featureKey", "", "scene", "benefitListAdapter", "Lcom/suite/lark/platform/component/cta/newstyle/adapter/BenefitListAdapter;", "cards", "", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Card;", "getCards", "()Ljava/util/List;", "currentCard", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "", "view", "initData", "", "initView", "initListeners", "initBottomSheet", "initTitleBar", "initTitleView", "initBenefitList", "initVersionInfo", "intBodyImageView", "initBodyView", "initFooterView", "onDestroy", "dismiss", "onCancel", "dialog", "Landroid/content/DialogInterface;", "callbackOnShow", "callbackOnCancel", "callbackOnDismiss", "updateButtonListConstraint", "isCardsEmpty", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CTADialogFragment extends BottomSheetDialogFragment {
    public FragmentCtaDialogBinding d;
    public goc.a e;
    public goc.b f;
    public CTAParams g;
    public String h;
    public String i;
    public BenefitListAdapter j;
    public goc.b.e k;

    public static final class a extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ CTADialogFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public a(CTADialogFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 == 5) goto L13;
            return;
        L13:
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b implements DialogInterface.OnShowListener {
        public final /* synthetic */ CTADialogFragment a;

        public b(CTADialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r8) {
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
            View r9 = ((BottomSheetDialog) r8).findViewById(2131368870);
            if (r9 == null) goto L5;
            r9.setBackgroundColor(UIUtils.getColor(this.a.requireContext(), 2131106784));
        L5:
            CTADialogFragment r10 = this.a;
            goc.a r0 = r10.e;
            if (r0 == null) goto L8;
            r0.onShow();
        L8:
            goc.b r1 = r10.f;
            if (r1 == null) goto L14;
            goc.b.g r2 = r1.b();
            if (r2 == null) goto L14;
            goc.b.h r3 = r2.b();
            if (r3 == null) goto L14;
        L15:
            int r4 = g.a;
            String r5 = r10.h;
            String r6 = r10.i;
            String r7 = r3.b();
            String r11 = "";
            if (r7 != null) goto L18;
            r7 = "";
        L18:
            boolean r12 = r3.a();
            boolean r13 = r3.d();
            goc.b.e r14 = r10.k;
            if (r14 == null) goto L21;
            String r15 = r14.d();
        L22:
            if (r15 != null) goto L24;
            r15 = "";
        L24:
            String r16 = r3.c();
            if (r16 == null) goto L28;
            r11 = r16;
        L28:
            Intrinsics.checkNotNullParameter(r5, "functionKey");
            Intrinsics.checkNotNullParameter(r6, "functionScene");
            Intrinsics.checkNotNullParameter(r7, "functionCategory");
            Intrinsics.checkNotNullParameter(r15, "skuKey");
            Intrinsics.checkNotNullParameter(r11, "viewType");
            s5c.d r17 = s5c.d.b.b(y0.c.a(r5), x0.d.a(r6)).plus(w0.c.a(r7)).plus(j3.c.a(r15)).plus(e4.e.a(r11));
            if (r12 == false) goto L31;
            s5c.a r18 = z5c.e.c;
        L32:
            s5c.d r19 = r17.plus(r18);
            if (r13 == false) goto L35;
            s5c.a r20 = v1.d;
        L36:
            Statistics.sendEvent("common_pricing_popup_view", r19.plus(r20).plus(p2.c).toJson());
            return;
        L35:
            r20 = v1.c;
            goto L36
        L31:
            r18 = z5c.e.d;
            goto L32
        L21:
            r15 = null;
        L14:
            r3 = new goc.b.h(0);
            goto L15
        }
    }

    public final List<goc.b.e> S90() {
        goc.b r0 = this.f;
        if (r0 == null) goto L11;
        goc.b.g r1 = r0.b();
        if (r1 == null) goto L11;
        goc.b.f r2 = r1.a();
        if (r2 == null) goto L11;
        goc.b.c r3 = r2.a();
        if (r3 == null) goto L11;
        List<goc.b.e> r4 = r3.a();
    L12:
        if (r4 != null) goto L15;
        r4 = CollectionsKt.emptyList();
    L15:
        return CollectionsKt.filterNotNull(r4);
    L11:
        r4 = null;
        goto L12
    }

    public CTADialogFragment() {
        this.h = "";
        this.i = "";
    }

    public final void T90() {
        BottomSheetDialog r0 = getDialog();
        BottomSheetBehavior r2 = null;
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.getBehavior();
    L8:
        if (r2 == null) goto L10;
        r2.setPeekHeight(UIUtils.getScreenHeight(getContext()));
    L10:
        if (r2 == null) goto L12;
        r2.setDraggable(true);
    L12:
        if (r2 == null) goto L15;
        r2.addBottomSheetCallback(new a(this));
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void dismiss() {
        super/*androidx.fragment.app.DialogFragment*/.dismiss();     // Catch: Exception -> L4
    L8:
        Context r0 = getContext();
        if (r0 == null) goto L13;
        Activity r1 = ContextsKt.findActivity(r0);
        if (r1 == null) goto L13;
        r1.finish();
    L13:
        goc.a r2 = this.e;
        if (r2 == null) goto L19;
        r2.onDismiss();
        return;
    L19:
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L8;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.e = null;
        loc.e.a = null;
        loc.e.b = null;
    }

    public final void onCancel(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r10);
        Context r11 = getContext();
        if (r11 == null) goto L7;
        Activity r12 = ContextsKt.findActivity(r11);
        if (r12 == null) goto L7;
        r12.finish();
    L7:
        goc.b r13 = this.f;
        if (r13 == null) goto L13;
        goc.b.g r14 = r13.b();
        if (r14 == null) goto L13;
        goc.b.h r15 = r14.b();
        if (r15 == null) goto L13;
    L14:
        int r0 = g.a;
        String r1 = this.h;
        String r2 = this.i;
        String r3 = r15.b();
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        boolean r4 = r15.a();
        boolean r5 = r15.d();
        goc.b.e r6 = this.k;
        if (r6 == null) goto L20;
        String r7 = r6.d();
    L21:
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        String r16 = r15.c();
        if (r16 != null) goto L26;
        String r8 = "";
    L27:
        String r9 = r3;
        g.a(r1, r2, r9, r4, r5, r7, r8, r.h);
        return;
    L26:
        r8 = r16;
        goto L27
    L20:
        r7 = null;
    L13:
        r15 = new goc.b.h(0);
        goto L14
    }

    public final Dialog onCreateDialog(Bundle r2) {
        BottomSheetDialog r3 = new BottomSheetDialog(requireContext());
        r3.setCancelable(true);
        r3.setCanceledOnTouchOutside(true);
        r3.setOnShowListener(new b(this));
        return r3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r26, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r26, r27);
        this.f = h.a;
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Object r1 = r0.get("intent_cta_params");
    L7:
        if ((r1 instanceof CTAParams) == false) goto L9;
        CTAParams r2 = (CTAParams) r1;
    L10:
        if (r2 != null) goto L12;
        boolean r3 = false;
    L16:
        if (r3 == false) goto L242;
        T90();
        FragmentCtaDialogBinding r4 = this.d;
        String r5 = "viewBinding";
        if (r4 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L30:
        r4.h.setLeftClickListener(new e(this));
        goc.b r6 = this.f;
        if (r6 == null) goto L40;
        goc.b.g r7 = r6.b();
        if (r7 == null) goto L40;
        goc.b.f r8 = r7.a();
        if (r8 == null) goto L40;
        goc.b.l r9 = r8.c();
        if (r9 == null) goto L40;
        String r10 = r9.a();
        if (r10 == null) goto L40;
    L41:
        goc.b r11 = this.f;
        if (r11 == null) goto L50;
        goc.b.g r12 = r11.b();
        if (r12 == null) goto L50;
        goc.b.f r13 = r12.a();
        if (r13 == null) goto L50;
        goc.b.c r14 = r13.a();
        if (r14 == null) goto L50;
        List<goc.b.l> r15 = r14.c();
    L51:
        if (r15 != null) goto L53;
        r15 = CollectionsKt.emptyList();
    L53:
        List r16 = CollectionsKt.filterNotNull(r15);
        FragmentCtaDialogBinding r17 = this.d;
        if (r17 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L56:
        r17.g.setText(r10);
        FragmentCtaDialogBinding r18 = this.d;
        if (r18 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = null;
    L59:
        TextView r19 = r18.f;
        Context r20 = requireContext();
        joc.c r21 = loc.e.a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r20, "context");
        SpannableStringBuilder r110 = new SpannableStringBuilder();
        Iterator r22 = r16.iterator();
        int r111 = 0;
    L61:
        if (r22.hasNext() == false) goto L129;
        Object r112 = r22.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L65;
        CollectionsKt.throwIndexOverflow();
    L65:
        goc.b.l r114 = (goc.b.l) r112;
        String r115 = r114.a();
        if (r115 != null) goto L68;
        r115 = "";
    L68:
        SpannableStringBuilder r116 = new SpannableStringBuilder(foc.d.a(r115));
        List<goc.b.i> r117 = r114.b();
        if (r117 != null) goto L71;
        r117 = CollectionsKt.emptyList();
    L71:
        Iterator r118 = CollectionsKt.filterNotNull(r117).iterator();
    L73:
        if (r118.hasNext() == false) goto L128;
        goc.b.i r119 = (goc.b.i) r118.next();
        String r23 = r119.getType();
        if (r23 == null) goto L73;
        int r24 = r23.hashCode();
        Iterator r120 = r22;
        if (r24 == 3321850) goto L109;
        if (r24 == 3599307) goto L97;
        if (r24 == 1021751938) goto L84;
    L127:
        r22 = r120;
        goto L73
    L84:
        if (r23.equals("plain_text") == false) goto L127;
        String r25 = r119.c();
        if (r25 != null) goto L89;
        r25 = "";
    L89:
        MatchResult r28 = Regex.find$default(new Regex("\\{\\{" + r25 + "\\}\\}"), r116, 0, 2, null);
        if (r28 == null) goto L127;
        int r29 = r28.getRange().getFirst();
        int r30 = r28.getRange().getLast() + 1;
        String r31 = r119.b();
        if (r31 != null) goto L95;
        r31 = "";
    L95:
        r116.replace(r29, r30, r31);
        goto L127
    L97:
        if (r23.equals("user") == false) goto L127;
        String r32 = r119.c();
        if (r32 != null) goto L101;
        r32 = "";
    L101:
        MatchResult r33 = Regex.find$default(new Regex("\\{\\{" + r32 + "\\}\\}"), r116, 0, 2, null);
        if (r33 == null) goto L127;
        String r34 = r119.b();
        if (r34 != null) goto L107;
        r34 = "";
    L107:
        String r35 = "@".concat(r34);
        r116.replace(r33.getRange().getFirst(), r33.getRange().getLast() + 1, r35);
        r116.setSpan(new b18.a(UDColorUtils.getColor(r20, 2131106616), new loc.b(r32)), r33.getRange().getFirst(), r33.getRange().getFirst() + r35.length(), 17);
        goto L127
    L109:
        if (r23.equals(InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK) == false) goto L127;
        String r36 = r119.c();
        if (r36 != null) goto L114;
        r36 = "";
    L114:
        String r37 = r119.a();
        if (r37 != null) goto L118;
        r37 = "";
    L118:
        if (StringsKt.isBlank(r37) == true) goto L127;
        MatchResult r38 = Regex.find$default(new Regex("\\{\\{" + r36 + "\\}\\}"), r116, 0, 2, null);
        if (r38 == null) goto L127;
        String r39 = r119.b();
        if (r39 != null) goto L126;
        r39 = "";
    L126:
        r116.replace(r38.getRange().getFirst(), r38.getRange().getLast() + 1, r39);
        r116.setSpan(new b18.a(UDColorUtils.getColor(r20, 2131106616), new loc.a(r37)), r38.getRange().getFirst(), r38.getRange().getFirst() + r39.length(), 17);
        goto L127
    L128:
        r110.append(r116);
        r111 = r113;
        goto L61
    L129:
        r19.setText(r110);
        r19.setMovementMethod(LinkMovementMethod.getInstance());
        if ((!S90().isEmpty()) == false) goto L172;
        FragmentCtaDialogBinding r40 = this.d;
        if (r40 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r40 = null;
    L134:
        RecyclerView r41 = r40.b;
        BenefitListAdapter r42 = new BenefitListAdapter(requireContext());
        this.j = r42;
        r41.setAdapter(r42);
        r41.setLayoutManager(new LinearLayoutManager(requireContext()));
        r41.setItemAnimator(null);
        r41.setVisibility(0);
        if (S90().isEmpty() == false) goto L137;
        r41.setVisibility(8);
    L158:
        f r43 = new f(this);
        FragmentCtaDialogBinding r44 = this.d;
        if (r44 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r44 = null;
    L161:
        LKUIRoundableLayout r45 = r44.j;
        FragmentCtaDialogBinding r46 = this.d;
        if (r46 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r46 = null;
    L164:
        RecyclerView r47 = r46.i;
        VersionInfoAdapter r121 = new VersionInfoAdapter(requireContext(), r43);
        r47.setAdapter(r121);
        r47.setLayoutManager(new LinearLayoutManager(requireContext()));
        FragmentCtaDialogBinding r48 = null;
        r47.setItemAnimator(null);
        r45.setVisibility(0);
        if (S90().isEmpty() == false) goto L167;
        r45.setVisibility(8);
    L199:
        boolean r49 = S90().isEmpty();
        FragmentCtaDialogBinding r50 = this.d;
        if (r50 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r50 = r48;
    L202:
        ConstraintLayout r51 = r50.e;
        ConstraintSet r52 = new ConstraintSet();
        r52.clone(r51);
        if (r49 == false) goto L205;
        r52.connect(2131365029, 3, 2131368308, 4, UIUtils.dp2px(requireContext(), 4.0f));
    L206:
        r52.applyTo(r51);
        goc.b r53 = this.f;
        if (r53 == null) goto L213;
        goc.b.g r54 = r53.b();
        if (r54 == null) goto L213;
        goc.b.f r55 = r54.a();
        if (r55 == null) goto L213;
        Object r56 = r55.b();
    L214:
        if (r56 != null) goto L216;
        r56 = CollectionsKt.emptyList();
    L216:
        Iterator r57 = CollectionsKt.filterNotNull((Iterable) r56).iterator();
    L218:
        if (r57.hasNext() == false) goto L240;
        goc.b.d r58 = (goc.b.d) r57.next();
        FragmentCtaDialogBinding r59 = this.d;
        if (r59 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException(r5);
        r59 = r48;
    L222:
        CustomButtonGroup r60 = r59.c;
        Context r61 = requireContext();
        joc.c r122 = loc.e.a;
        Intrinsics.checkNotNullParameter(r61, "context");
        Intrinsics.checkNotNullParameter(r58, "button");
        if (Intrinsics.areEqual(r58.d(), "primary") == false) goto L225;
        UDButton r123 = new UDButton(r61, null, 0, 6, null);
        r123.setClickable(true);
        r123.setMaxLines(1);
        r123.setEllipsize(TextUtils.TruncateAt.END);
        r123.setSingleLine(true);
        int r62 = UIUtils.dp2px(r61, 16.0f);
        int r124 = UIUtils.dp2px(r61, 9.0f);
        r123.setPadding(r62, r124, r62, r124);
        r123.setTextSize(17.0f);
        r123.setGravity(17);
        r123.setTextColor(UIUtils.getColor(r61, 2131105560));
        int r63 = UIUtils.getColor(r61, 2131105548);
        r123.setBackgroundColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{UIUtils.getColor(r61, 2131109022), r63}));
        r123.setCornerRadius(UIUtils.getDimens(r61, 2131169383));
    L226:
        r123.setOnClickListener(new com.suite.lark.platform.component.cta.newstyle.b(r123, this, r58));
        String r64 = r58.c();
        if (r64 != null) goto L229;
    L232:
        boolean r65 = true;
    L233:
        if (r65 == false) goto L238;
        String r66 = r58.b();
        if (r66 != null) goto L237;
        r66 = "";
    L237:
        r123.setText(r66);
    L239:
        r60.addView(r123);
        r5 = r5;
        r57 = r57;
        r48 = null;
        goto L218
    L238:
        Context r67 = r123.getContext();
        String r68 = r58.c();
        int r125 = UIUtils.dp2px(r123.getContext(), 20.0f);
        com.suite.lark.platform.component.cta.newstyle.a r126 = new com.suite.lark.platform.component.cta.newstyle.a(r123, r58);
        Intrinsics.checkNotNullParameter(r123, "<this>");
        Intrinsics.checkNotNullParameter(r67, "context");
        Intrinsics.checkNotNullParameter(r68, "url");
        Intrinsics.checkNotNullParameter(r126, "simpleTarget");
        ImageLoader.with(r67).asDrawable().load(r68).override(r125, r125).into(new loc.c(r126));
        goto L239
    L229:
        if (r64.length() == 0) goto L232;
        r65 = false;
        goto L233
    L225:
        r123 = new UDButton(r61, null, 0, 6, null);
        r123.setClickable(true);
        r123.setMaxLines(1);
        r123.setEllipsize(TextUtils.TruncateAt.END);
        r123.setSingleLine(true);
        int r69 = UIUtils.dp2px(r61, 16.0f);
        int r70 = UIUtils.dp2px(r61, 9.0f);
        r123.setPadding(r69, r70, r69, r70);
        r123.setTextSize(17.0f);
        r123.setGravity(17);
        r123.setTextColor(UIUtils.getColor(r61, 2131105542));
        int r127 = UIUtils.getColor(r61, 2131109044);
        r123.setBackgroundColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{UIUtils.getColor(r61, 2131109019), r127}));
        r123.setCornerRadius(UIUtils.getDimens(r61, 2131169383));
        r123.setStrokeWidth(UIUtils.getDimens(r61, 2131169362));
        r123.setStrokeColor(UIUtils.getColor(r61, 2131105542));
        goto L226
    L240:
        loc.e.a = new c(this);
        loc.e.b = new d(this);
        return;
    L213:
        r56 = r48;
        goto L214
    L205:
        r52.connect(2131365029, 3, 2131392212, 4, UIUtils.dp2px(requireContext(), 24.0f));
        goto L206
    L167:
        List<goc.b.e> r71 = S90();
        Intrinsics.checkNotNullParameter(r71, "items");
        List<goc.b.e> r72 = r71;
        ArrayList r73 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r72, 10));
        Iterator<T> r74 = r72.iterator();
    L169:
        if (r74.hasNext() == false) goto L171;
        goc.b.e r75 = (goc.b.e) r74.next();
        r73.add(new joc.a(r75, r75.g()));
        goto L169
    L171:
        r121.c.submitList(r73);
        goto L199
    L137:
        Iterator<T> r76 = S90().iterator();
    L139:
        if (r76.hasNext() == false) goto L158;
        goc.b.e r77 = (goc.b.e) r76.next();
        List<goc.b.C0270b> r128 = r77.a();
        if (r128 != null) goto L143;
    L146:
        boolean r129 = true;
    L147:
        if (r129 == true) goto L148;
        if (r77.g() == false) goto L139;
        this.k = r77;
        BenefitListAdapter r130 = this.j;
        if (r130 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("benefitListAdapter");
        r130 = null;
    L154:
        List<goc.b.C0270b> r78 = r77.a();
        if (r78 != null) goto L157;
        r78 = CollectionsKt.emptyList();
    L157:
        List r79 = CollectionsKt.filterNotNull(r78);
        r130.getClass();
        Intrinsics.checkNotNullParameter(r79, "items");
        r130.b.submitList(r79);
        goto L139
    L148:
        r41.setVisibility(8);
        goto L139
    L143:
        if (r128.isEmpty() == true) goto L146;
        r129 = false;
        goto L147
    L172:
        r48 = null;
        FragmentCtaDialogBinding r80 = this.d;
        if (r80 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r80 = null;
    L175:
        r80.d.setVisibility(0);
        int r81 = UIHelper.getWindowWidth(getContext());
        Drawable r82 = UIUtils.getDrawable(getContext(), 2131238212);
        if (r82 == null) goto L178;
        int r83 = r82.getIntrinsicWidth();
    L179:
        if (r82 == null) goto L181;
        int r84 = r82.getIntrinsicHeight();
    L182:
        int r85 = (r84 * r81) / r83;
        FragmentCtaDialogBinding r86 = this.d;
        if (r86 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r86 = null;
    L185:
        ImageView r87 = r86.d;
        Context r131 = requireContext();
        goc.b r132 = this.f;
        if (r132 == null) goto L197;
        goc.b.g r133 = r132.b();
        if (r133 == null) goto L197;
        goc.b.f r134 = r133.a();
        if (r134 == null) goto L197;
        goc.b.c r135 = r134.a();
        if (r135 == null) goto L197;
        goc.b.j r136 = r135.b();
        if (r136 == null) goto L197;
        String r137 = r136.a();
        if (r137 == null) goto L197;
    L198:
        joc.c r138 = loc.e.a;
        Intrinsics.checkNotNullParameter(r87, "<this>");
        Intrinsics.checkNotNullParameter(r131, "context");
        Intrinsics.checkNotNullParameter(r137, "url");
        ImageLoader.with(r131).load(r137).fitCenter().error(2131238212).override(r81, r85).into(new loc.d(r87));
    L197:
        r137 = "";
        goto L198
    L181:
        r84 = 1;
        goto L182
    L178:
        r83 = 1;
    L50:
        r15 = null;
    L40:
        r10 = UIUtils.getString(getContext(), 2131890624);
        goto L41
    L242:
        dismissAllowingStateLoss();     // Catch: Exception -> L19
    L23:
        FragmentActivity r88 = getActivity();
        if (r88 == null) goto L262;
        r88.finish();
        return;
    L262:
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r89 = DialogFragmentLancet.sLastShowStack;
        if (r89 == null) goto L23;
        com.bytedance.crash.d.d(r89, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    L12:
        this.g = r2;
        this.h = r2.getFeatureKey();
        CTAParams r90 = this.g;
        if (r90 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("ctaParams");
        r90 = null;
    L15:
        this.i = r90.getScene();
        r3 = true;
        goto L16
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        int r15 = koc.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.platform.component.cta.use_scroll_view_disabled") == true) goto L5;
        int r16 = 2131561184;
    L6:
        LKUIRoundableLayout r17 = r12.inflate(r16, r13, false);
        int r18 = 2131364099;
        RecyclerView r2 = ViewBindings.findChildViewById(r17, 2131364099);
        if (r2 == null) goto L27;
        r18 = 2131365029;
        CustomButtonGroup r3 = (CustomButtonGroup) ViewBindings.findChildViewById(r17, 2131365029);
        if (r3 == null) goto L27;
        r18 = 2131368308;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r17, 2131368308);
        if (r4 == null) goto L27;
        r18 = 2131384821;
        ConstraintLayout r5 = ViewBindings.findChildViewById(r17, 2131384821);
        if (r5 == null) goto L27;
        r18 = 2131387625;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r17, 2131387625);
        if (r6 == null) goto L27;
        r18 = 2131388772;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r17, 2131388772);
        if (r7 == null) goto L27;
        r18 = 2131388928;
        CommonTitleBar r8 = ViewBindings.findChildViewById(r17, 2131388928);
        if (r8 == null) goto L27;
        r18 = 2131392209;
        RecyclerView r9 = ViewBindings.findChildViewById(r17, 2131392209);
        if (r9 == null) goto L27;
        r18 = 2131392212;
        LKUIRoundableLayout r10 = ViewBindings.findChildViewById(r17, 2131392212);
        if (r10 == null) goto L27;
        this.d = new FragmentCtaDialogBinding(r17, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        Intrinsics.checkNotNull(r17);
        return r17;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r18)));
    L5:
        r16 = 2131561183;
        goto L6
    }
}
