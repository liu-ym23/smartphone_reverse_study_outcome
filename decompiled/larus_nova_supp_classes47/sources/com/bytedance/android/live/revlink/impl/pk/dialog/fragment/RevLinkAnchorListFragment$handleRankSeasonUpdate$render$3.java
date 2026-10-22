package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.pk.ui.PKRankUnlockView;
import com.bytedance.android.live.revlink.impl.pk.ui.PKRankUnlockView$handleForProgress$1;
import com.bytedance.android.livesdk.link.model.f8;
import com.bytedance.android.livesdk.link.model.s8;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/s8;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/s8;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevLinkAnchorListFragment$handleRankSeasonUpdate$render$3 extends FunctionReferenceImpl implements Function1<s8, Unit> {
    public RevLinkAnchorListFragment$handleRankSeasonUpdate$render$3(RevLinkAnchorListFragment r8) {
        super(1, r8, RevLinkAnchorListFragment.class, "updateForRankUnlockView", "updateForRankUnlockView(Lcom/bytedance/android/livesdk/link/model/IRivalRankSeasonInfo;)V", 0);
    }

    public final void invoke(s8 r12) {
        RevLinkAnchorListFragment r0 = (RevLinkAnchorListFragment) ((CallableReference) this).receiver;
        int r1 = RevLinkAnchorListFragment.F;
        LinearLayout r2 = (LinearLayout) r0.S90(2131362585);
        if (r2 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r2, false);
    L5:
        final PKRankUnlockView r3 = (PKRankUnlockView) r0.S90(2131362602);
        if (r3 == null) goto L8;
        UtilityKotlinExtentionsKt.z(r3, true);
    L8:
        if (r3 == null) goto L74;
        TextView r4 = r3.c;
        ur2.a r5 = vh6.c.b(ur2.a.class);
        String r6 = null;
        if (r12 == null) goto L14;
        f8 r7 = r12.getQualifyInfo();
        if (r7 == null) goto L14;
        a5 r8 = r7.getDesc();
    L15:
        r4.setText(r5.Lf(r8, ""));
        TextView r9 = r3.d;
        if (r12 == null) goto L20;
        f8 r10 = r12.getQualifyInfo();
        if (r10 == null) goto L20;
        String r13 = r10.getTitle();
    L21:
        r9.setText(r13);
        if (r12 == null) goto L60;
        f8 r14 = r12.getQualifyInfo();
        if (r14 == null) goto L60;
        if (r14.getShowProgress() != true) goto L60;
        ViewUtilsKt.g(r3.a, true);
        ViewUtilsKt.g(r3.f, true);
        long r15 = 0;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L39
        f8 r17 = r12.getQualifyInfo();     // Catch: Throwable -> L39
        if (r17 == null) goto L32;
        long r18 = r17.getCount();     // Catch: Throwable -> L39
    L33:
        float r19 = r18;
        f8 r20 = r12.getQualifyInfo();     // Catch: Throwable -> L39
        if (r20 == null) goto L36;
        long r22 = r20.getTargetCount();     // Catch: Throwable -> L39
    L37:
        Object r23 = Result.constructor-impl(Float.valueOf(r19 / r22));     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r23) == false) goto L44;
        r23 = null;
    L44:
        Float r24 = (Float) r23;
        if (r24 == null) goto L47;
        final float r25 = r24.floatValue();
    L48:
        ViewUtilsKt.g(r3.a, true);
        r3.a.addOnLayoutChangeListener(new PKRankUnlockView$handleForProgress$1(r3, r25));
        int r26 = r3.a.getWidth();
        View r27 = r3.b;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if (r28 == null) goto L51;
        r28.width = (int) (r26 * r25);
        Unit r29 = Unit.INSTANCE;
    L52:
        r27.setLayoutParams(r28);
        r3.b.requestLayout();
        r3.j = r26;
        f8 r30 = r12.getQualifyInfo();
        if (r30 == null) goto L55;
        long r32 = r30.getCount();
    L56:
        f8 r33 = r12.getQualifyInfo();
        if (r33 == null) goto L59;
        r15 = r33.getTargetCount();
    L59:
        SpannableStringBuilder r34 = new SpannableStringBuilder();
        SpannableString r35 = new SpannableString(String.valueOf(r32));
        r35.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), 0, String.valueOf(r32).length(), 33);
        Unit r36 = Unit.INSTANCE;
        r34.append(r35);
        r34.append("/" + r15);
        r3.f.setText(r34);
    L61:
        if (r12 == null) goto L63;
        String r37 = r12.getUnLockTxt();
    L65:
        if (r2.a(r37) == false) goto L67;
        r3.e.setText(r37);
    L67:
        TextView r38 = r3.g;
        if (r12 == null) goto L70;
        r6 = r12.getButtonText();
    L70:
        r38.setText(r6);
        r3.g.setTextColor(-1);
        r3.g.setBackgroundResource(2131249455);
        r3.g.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.ui.k(r3));
        r3.h.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.ui.l(r3, r12));
        return;
    L63:
        r37 = null;
        goto L65
    L55:
        r32 = 0;
        goto L56
    L51:
        r28 = null;
        goto L52
    L47:
        r25 = 0.0f;
        goto L48
    L36:
        r22 = 1;
        goto L37
    L32:
        r18 = 0;
    L39:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L60:
        ViewUtilsKt.g(r3.a, false);
        ViewUtilsKt.g(r3.f, false);
    L20:
        r13 = null;
    L14:
        r8 = null;
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((s8) r1);
        return Unit.INSTANCE;
    }
}
