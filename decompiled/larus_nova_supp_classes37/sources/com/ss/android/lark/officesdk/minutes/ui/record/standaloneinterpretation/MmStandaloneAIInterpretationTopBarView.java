package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.ui.databinding.OfficeSdkMmViewStandaloneAiInterpretationTopBarBinding;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J&\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0010H\u0014J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010\u001f\u001a\u00020\u0010*\u00020 2\b\b\u0001\u0010!\u001a\u00020\b2\b\b\u0001\u0010\"\u001a\u00020\bH\u0002J\u0014\u0010#\u001a\u00020\u0010*\u00020 2\u0006\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u0012\u0010&\u001a\u00020\b2\b\b\u0001\u0010\"\u001a\u00020\bH\u0002J\f\u0010'\u001a\u00020(*\u00020)H\u0002J \u0010*\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u001aH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020\u001aH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationTopBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/MmRecordingTopPaddingTarget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/databinding/OfficeSdkMmViewStandaloneAiInterpretationTopBarBinding;", "bindScope", "Lkotlinx/coroutines/CoroutineScope;", "setTopPadding", "", "padding", "bind", "scope", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/MmRecordingSlotScope;", "viewModel", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationViewModel;", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "hasHostNavRect", "", "onDetachedFromWindow", "dp", "value", "", "setIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "drawableRes", "colorRes", "setSpeakerIcon", "muted", "applyDoubaoMiniAppHeaderStyle", "tokenColor", "displayText", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;", "showLanguagePanel", "showSpeakerToast", "soundOn", "resolveSpeakerToastMessage", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmStandaloneAIInterpretationTopBarView extends ConstraintLayout implements com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.a {
    public static final /* synthetic */ int c = 0;
    public final OfficeSdkMmViewStandaloneAiInterpretationTopBarBinding a;
    public CoroutineScope b;

    public static final class a {
    }

    static {
    }

    public MmStandaloneAIInterpretationTopBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmStandaloneAIInterpretationTopBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        CoroutineScope r0 = this.b;
        if (r0 == null) goto L5;
        CoroutineScopeKt.cancel$default(r0, null, 1, null);
    L5:
        this.b = null;
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int R5(float r2) {
        return UIUtils.dp2px(getContext(), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.a
    public void setTopPadding(int r2) {
        setPadding(0, r2, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(AppCompatImageView r2, boolean r3) {
        if (r3 == false) goto L4;
        int r0 = 2131244752;
    L5:
        if (r3 == false) goto L7;
        int r4 = 2131102418;
    L8:
        r2.setImageResource(r0);
        r2.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(getContext(), r4)));
        return;
    L7:
        r4 = com.ss.android.lark.officesdk.minutes.ui.style.a.a(r2.getContext()).c();
        goto L8
    L4:
        r0 = 2131244753;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmStandaloneAIInterpretationTopBarView(Context r20, AttributeSet r21, int r22) {
        Intrinsics.checkNotNullParameter(r20, "context");
        super(r20, r21, r22);
        ConstraintLayout r1 = LayoutInflater.from(r20).inflate(2131564110, this, false);
        addView(r1);
        int r3 = 2131363245;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r1, 2131363245);
        if (r4 == null) goto L23;
        r3 = 2131363772;
        AppCompatImageView r15 = ViewBindings.findChildViewById(r1, 2131363772);
        if (r15 == null) goto L23;
        r3 = 2131377147;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131377147);
        if (r9 == null) goto L23;
        r3 = 2131377150;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131377150);
        if (r10 == null) goto L23;
        r3 = 2131377151;
        View r14 = ViewBindings.findChildViewById(r1, 2131377151);
        if (r14 == null) goto L23;
        r3 = 2131385939;
        AppCompatImageView r13 = ViewBindings.findChildViewById(r1, 2131385939);
        if (r13 == null) goto L23;
        r3 = 2131387017;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r1, 2131387017);
        if (r12 == null) goto L23;
        r3 = 2131387060;
        AppCompatImageView r11 = ViewBindings.findChildViewById(r1, 2131387060);
        if (r11 == null) goto L23;
        r3 = 2131388193;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r1, 2131388193);
        if (r8 == null) goto L23;
        this.a = new OfficeSdkMmViewStandaloneAiInterpretationTopBarBinding(r1, r4, r15, r9, r10, r14, r13, r12, r11, r8);
        com.ss.android.lark.officesdk.minutes.ui.style.contract.d r5 = com.ss.android.lark.officesdk.minutes.ui.style.a.a(r20);
        int r6 = r5.o();
        int r7 = UDColorUtils.getColor(getContext(), r6);
        int r16 = r5.n();
        int r17 = r5.b();
        r12.setText(null);
        r12.setTextColor(r7);
        r8.setText(null);
        r8.setTextColor(r7);
        int r2 = zvb.a.b;
        r14.setBackground(zvb.a.C0209a.c(r20, 2131100553, 36, null, null, 52));
        r15.setImageDrawable(UDIconUtils.getIconDrawable(r15.getContext(), 2131254998, UDColorUtils.getColor(getContext(), 2131102418)));
        r13.setImageResource(2131244754);
        r13.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(getContext(), r17)));
        r4.setImageDrawable(UDIconUtils.getIconDrawable(r4.getContext(), 2131254326, UDColorUtils.getColor(getContext(), r16)));
        S5(r11, true);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r3)));
    }

    public /* synthetic */ MmStandaloneAIInterpretationTopBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
