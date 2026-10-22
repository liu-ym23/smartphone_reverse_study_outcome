package com.larus.bot.impl.feature.health;

import android.R;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bot.impl.databinding.LarusLayoutChatHealthTipBinding;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.settings.provider.health.HealthAgreementInfo;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002J\b\u0010,\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bot/impl/feature/health/ChatHealthTipFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusLayoutChatHealthTipBinding;", "currentRotationAnimation", "Landroid/animation/ValueAnimator;", "botName", "", "bitModelUrl", "botId", "scope", "Lkotlinx/coroutines/CoroutineScope;", "backCallback", "Lkotlin/Function1;", "", "getBackCallback", "()Lkotlin/jvm/functions/Function1;", "setBackCallback", "(Lkotlin/jvm/functions/Function1;)V", "bottomSheet", "Landroid/view/View;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onCreate", "onAttach", "context", "Landroid/content/Context;", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "initViews", "reportUserHaveAgree", "renderTips", "startLoading", "endLoading", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatHealthTipFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int l = 0;
    public LarusLayoutChatHealthTipBinding d;
    public ValueAnimator e;
    public String f;
    public String g;
    public String h;
    public final CoroutineScope i;
    public Function1<? super String, Unit> j;
    public View k;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void onDestroy() {
        CoroutineScopeKt.cancel$default(this.i, null, 1, null);
        ValueAnimator r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public ChatHealthTipFragment() {
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = CoroutineScopeKt.MainScope();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        r0.setCancelable(false);
    L5:
        Dialog r1 = getDialog();
        if (r1 == null) goto L9;
        r1.setCanceledOnTouchOutside(false);
        return;
    }

    public static final void S90(ChatHealthTipFragment r1) {
        ValueAnimator r0 = r1.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        LarusLayoutChatHealthTipBinding r2 = r1.d;
        if (r2 == null) goto L10;
        AppCompatTextView r3 = r2.b;
        if (r3 == null) goto L10;
        e1.q(r3);
    L10:
        LarusLayoutChatHealthTipBinding r4 = r1.d;
        if (r4 == null) goto L15;
        AppCompatTextView r5 = r4.f;
        if (r5 == null) goto L15;
        e1.x(r5);
    L15:
        LarusLayoutChatHealthTipBinding r6 = r1.d;
        if (r6 == null) goto L21;
        View r7 = r6.e;
        if (r7 == null) goto L22;
        e1.q(r7);
        return;
    L22:
        return;
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r2);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new AnonymousClass1());
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        this.f = r4.getString("bot_name", "");
        this.g = r4.getString("bot_picture", "");
        this.h = r4.getString("bot_id", "");
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        Dialog r8 = getDialog();
        if (r8 == null) goto L5;
        View r9 = r8.findViewById(2131368870);
    L6:
        this.k = r9;
        if (r9 == null) goto L9;
        r9.setBackgroundResource(R.color.transparent);
    L9:
        LarusLayoutChatHealthTipBinding r10 = this.d;
        if (r10 == null) goto L14;
        AppCompatTextView r11 = r10.c;
        if (r11 == null) goto L14;
        r11.setText(this.f);
    L14:
        LarusLayoutChatHealthTipBinding r12 = this.d;
        if (r12 == null) goto L19;
        CircleSimpleDraweeView r13 = r12.h;
        if (r13 == null) goto L19;
        ImageLoaderKt.u(r13, this.g, "change_app_icon");
    L19:
        LarusLayoutChatHealthTipBinding r14 = this.d;
        if (r14 == null) goto L24;
        AppCompatImageView r15 = r14.d;
        if (r15 == null) goto L24;
        e1.d(r15, new com.larus.bot.impl.feature.health.a(this));
    L24:
        LarusLayoutChatHealthTipBinding r16 = this.d;
        if (r16 == null) goto L75;
        AppCompatTextView r17 = r16.f;
        if (r17 == null) goto L75;
        e1.d(r17, new b(this));
    L75:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L72
        e10 r19 = e10.a;     // Catch: Throwable -> L72
        SpannableStringBuilder r20 = new SpannableStringBuilder(e10.X().getPanelTotalContent());     // Catch: Throwable -> L72
        List r21 = e10.X().getPanelLinkRanges();     // Catch: Throwable -> L72
        if (r21 == null) goto L45;
        List r22 = CollectionsKt.filterNotNull(r21);     // Catch: Throwable -> L72
        if (r22 == null) goto L45;
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L72
    L35:
        if (r23.hasNext() == false) goto L45;
        HealthAgreementInfo r1 = (HealthAgreementInfo) r23.next();     // Catch: Throwable -> L72
        Integer r2 = r1.getStartIndex();     // Catch: Throwable -> L72
        if (r2 == null) goto L39;
        int r3 = r2.intValue();     // Catch: Throwable -> L72
    L40:
        Integer r4 = r1.getLength();     // Catch: Throwable -> L72
        if (r4 == null) goto L43;
        int r5 = r4.intValue();     // Catch: Throwable -> L72
    L44:
        d r24 = new d(r1, this);     // Catch: Throwable -> L72
        r20.setSpan(r24, r3, r5 + r3, 33);     // Catch: Throwable -> L72
        goto L35
    L43:
        r5 = 0;
        goto L44
    L39:
        r3 = 0;
    L45:
        LarusLayoutChatHealthTipBinding r25 = this.d;     // Catch: Throwable -> L72
        if (r25 == null) goto L50;
        AppCompatTextView r26 = r25.g;     // Catch: Throwable -> L72
        if (r26 == null) goto L50;
        r26.setMovementMethod(LinkMovementMethod.getInstance());     // Catch: Throwable -> L72
    L50:
        LarusLayoutChatHealthTipBinding r27 = this.d;     // Catch: Throwable -> L72
        if (r27 == null) goto L55;
        AppCompatTextView r28 = r27.g;     // Catch: Throwable -> L72
        if (r28 == null) goto L55;
        r28.setHighlightColor(0);     // Catch: Throwable -> L72
    L55:
        LarusLayoutChatHealthTipBinding r29 = this.d;     // Catch: Throwable -> L72
        if (r29 == null) goto L60;
        AppCompatTextView r30 = r29.g;     // Catch: Throwable -> L72
        if (r30 == null) goto L60;
        r30.setClickable(true);     // Catch: Throwable -> L72
    L60:
        LarusLayoutChatHealthTipBinding r31 = this.d;     // Catch: Throwable -> L72
        if (r31 == null) goto L65;
        AppCompatTextView r32 = r31.g;     // Catch: Throwable -> L72
        if (r32 == null) goto L65;
        r32.setLongClickable(false);     // Catch: Throwable -> L72
    L65:
        LarusLayoutChatHealthTipBinding r33 = this.d;     // Catch: Throwable -> L72
        if (r33 == null) goto L70;
        AppCompatTextView r34 = r33.g;     // Catch: Throwable -> L72
        if (r34 == null) goto L70;
        r34.setText(r20);     // Catch: Throwable -> L72
    L70:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L72
        return;
    L72:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L5:
        r9 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562776, r11, false);
        int r14 = 2131363765;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r13, 2131363765);
        if (r2 == null) goto L19;
        r14 = 2131364347;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r13, 2131364347);
        if (r3 == null) goto L19;
        r14 = 2131371857;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r13, 2131371857);
        if (r4 == null) goto L19;
        r14 = 2131378988;
        View r5 = ViewBindings.findChildViewById(r13, 2131378988);
        if (r5 == null) goto L19;
        r14 = 2131387241;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r13, 2131387241);
        if (r6 == null) goto L19;
        r14 = 2131388725;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r13, 2131388725);
        if (r7 == null) goto L19;
        r14 = 2131389158;
        CircleSimpleDraweeView r8 = ViewBindings.findChildViewById(r13, 2131389158);
        if (r8 == null) goto L19;
        ConstraintLayout r15 = r13;
        this.d = new LarusLayoutChatHealthTipBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
