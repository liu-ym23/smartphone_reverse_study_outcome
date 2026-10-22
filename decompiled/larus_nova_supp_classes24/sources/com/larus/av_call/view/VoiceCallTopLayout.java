package com.larus.av_call.view;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusLayoutRealtimeCallTopBinding;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.common_ui.view.NoSpaceTextView;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJX\u0010$\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001a\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0010J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020\u0015J\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u00020\u0010J\"\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u00102\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020%08J\u0006\u00109\u001a\u00020.J\b\u0010:\u001a\u00020%H\u0002J\u0018\u0010;\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\bH\u0016J\u000e\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u0010J\u000e\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\u0010J\u0006\u0010B\u001a\u00020%J \u0010C\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0002J\u001e\u0010D\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010J\u001e\u0010E\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010J&\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020JJ\u0010\u0010M\u001a\u00020%2\u0006\u0010I\u001a\u00020JH\u0002J\u0012\u0010N\u001a\u00020%2\b\b\u0001\u0010O\u001a\u00020\bH\u0002J\b\u0010P\u001a\u00020%H\u0002J\b\u0010Q\u001a\u00020%H\u0014J\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020UJ \u0010V\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0016J\u001a\u0010W\u001a\u00020%*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010X\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0018R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/larus/av_call/view/VoiceCallTopLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/av_call/view/IRealCallDayNight;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "topBinding", "Lcom/larus/av_call/databinding/LarusLayoutRealtimeCallTopBinding;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "forceDarkMode", "", "botName", "", "isShowChooseScene", "realtimeCallSceneButtonCenter", "Landroid/view/View;", "value", "isChooseSceneEnable", "()Z", "isSubtitleOpen", "hideTopActionIcons", "mainHandler", "Landroid/os/Handler;", "forceEnableStatusAnim", "runtimeData", "Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "configDependency", "Lcom/larus/av_call/service/IRealtimeCallConfigDependency;", "shouldHideTopActionIcons", "getShouldHideTopActionIcons", "initView", "", "realtimeCallSceneButton", "enableSubtitle", "hasRecordPermission", "subtitleUseCC", "enableAudioBgSimpleColor", "setMoreBtnVisibility", "visible", "getLeftTakePhotoBtn", "Landroid/widget/ImageView;", "getMoreBtn", "getTitleView", "Landroidx/appcompat/widget/AppCompatTextView;", "setupMoreBtnResource", "isFullVideo", "disable", "setupMoreBtn", "isVisible", "onClick", "Lkotlin/Function1;", "getSwitchCameraView", "setupTitle", "setupChooseScene", "setVisibility", "visibility", "switchSceneButtonCallName", "isVideoFullMode", "setChooseSceneEnable", "enable", "hideChooseSceneEnable", "setupSubtitle", "onOpenSubtitle", "onCloseSubtitle", "setupViews", "hasPermission", "onUpdateMajorState", "state", "Lcom/larus/audio/call/mgr/MajorState;", "showThinkingRunnable", "Ljava/lang/Runnable;", "updateImmersBotTitle", "showStatusAnim", "rawRes", "hideStatusAnim", "onDetachedFromWindow", "getSceneButtonTop", "Lcom/larus/av_call/view/SceneModeButton;", "getSubtitleButton", "Lcom/larus/common_ui/widget/roundlayout/CustomRoundImageView;", "refreshThemeDayNight", "setDarkMode", "shouldNotShowNameAndStatus", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VoiceCallTopLayout extends ConstraintLayout {
    public static final /* synthetic */ int o = 0;
    public final LarusLayoutRealtimeCallTopBinding a;
    public ThemeType b;
    public boolean c;
    public String d;
    public boolean e;
    public View f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final Handler j;
    public boolean k;
    public h88.b l;
    public final IRealtimeCallConfigDependency m;
    public final d1 n;

    public VoiceCallTopLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceCallTopLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        if (b6(this.b) == false) goto L5;
        return;
    L5:
        this.j.removeCallbacks(this.n);
        com.larus.utils.e1.o(this.a.f);
    }

    public final ImageView getLeftTakePhotoBtn() {
        return this.a.h;
    }

    public final View getMoreBtn() {
        return this.a.g;
    }

    public final SceneModeButton getSceneButtonTop() {
        return this.a.d;
    }

    public final CustomRoundImageView getSubtitleButton() {
        return this.a.e;
    }

    public final ImageView getSwitchCameraView() {
        return this.a.i;
    }

    public final AppCompatTextView getTitleView() {
        return this.a.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.j.removeCallbacks(this.n);
    }

    private final boolean getShouldHideTopActionIcons() {
        return this.i;
    }

    public final void T5(MajorState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        ThemeType r0 = this.b;
        if (r0 == ThemeType.IMMERS_BOT) goto L9;
        if (this.k == true) goto L9;
        R5();
        return;
    L9:
        if (b6(r0) == false) goto L12;
        return;
    L12:
        if ((r4 instanceof MajorState.i) == false) goto L15;
        R5();
        this.j.postDelayed(this.n, LKUIToast.DURATION_SHORT);
        return;
    L15:
        if (Intrinsics.areEqual(r4, MajorState.h.c) == false) goto L17;
        c6(2131820625);
        return;
    L17:
        R5();
    }

    public final boolean b6(ThemeType r3) {
        if (r3 != ThemeType.MAIN_BOT) goto L13;
        IRealtimeCallConfigDependency r4 = this.m;
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r4.m() != true) goto L9;
        r5 = true;
        goto L10
    L13:
        return false;
    }

    public final void c6(int r3) {
        if (b6(this.b) == false) goto L5;
        return;
    L5:
        this.j.removeCallbacks(this.n);
        LottieAdapterView r0 = this.a.f;
        Intrinsics.checkNotNull(r0);
        com.larus.utils.e1.x(r0);
        r0.setAnimation(r3);
        r0.playAnimation();
    }

    public final void i6(boolean r6) {
        this.k = r6;
        if (r6 == true) goto L6;
        R5();
    L6:
        if (this.b == ThemeType.MAIN_BOT) goto L8;
        return;
    L8:
        SceneModeButton r0 = this.a.d;
        boolean r1 = true;
        int r2 = 0;
        if (r6 == false) goto L11;
    L13:
        boolean r3 = false;
    L15:
        if (r3 == false) goto L17;
        int r4 = 0;
    L18:
        r0.setVisibility(r4);
        NoSpaceTextView r5 = this.a.b;
        if (r6 == true) goto L21;
    L23:
        r1 = false;
    L24:
        if (r1 == true) goto L27;
        r2 = 8;
    L27:
        r5.setVisibility(r2);
        return;
    L21:
        if (b6(this.b) == true) goto L23;
    L17:
        r4 = 8;
        goto L18
    L11:
        if (this.e == false) goto L13;
        r3 = true;
        goto L15
    }

    public final void setChooseSceneEnable(boolean r5) {
        if (this.g != r5) goto L5;
        return;
    L5:
        SceneModeButton r0 = this.a.d;
        float r1 = 1.0f;
        if (r5 == false) goto L8;
        float r3 = 1.0f;
    L9:
        r0.setAlpha(r3);
        View r2 = this.f;
        if (r2 == null) goto L15;
        if (r5 == true) goto L14;
        r1 = 0.6f;
    L14:
        r2.setAlpha(r1);
    L15:
        this.g = r5;
        return;
    L8:
        r3 = 0.6f;
        goto L9
    }

    public final void setMoreBtnVisibility(boolean r1) {
        if (r1 == true) goto L4;
    L6:
        com.larus.utils.e1.o(this.a.g);
        return;
    L4:
        if (getShouldHideTopActionIcons() == true) goto L6;
        com.larus.utils.e1.x(this.a.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r1) {
        super/*android.view.ViewGroup*/.setVisibility(r1);
    }

    public static void Y5(VoiceCallTopLayout r4, boolean r5) {
        r4.getClass();
        Application r0 = i88.e.a;
        AppCompatImageView r1 = r4.a.g;
        ThemeType r2 = r4.b;
        boolean r6 = r4.c;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "themeType");
        IRealtimeCallConfigDependency r3 = i88.e.b;
        if (r3 == null) goto L7;
        boolean r7 = true;
        if (r3.m() != true) goto L7;
    L8:
        if (r7 == false) goto L15;
        if (r6 == false) goto L11;
    L14:
        int r8 = 2131240972;
    L23:
        r1.setImageResource(r8);
        return;
    L11:
        if (i88.e.o(r2) == true) goto L14;
        r8 = 2131240974;
        goto L23
    L15:
        if (r5 == false) goto L17;
        r8 = 2131240958;
        goto L23
    L17:
        if (r6 == false) goto L19;
    L22:
        r8 = 2131240956;
        goto L23
    L19:
        if (i88.e.o(r2) == true) goto L22;
        r8 = 2131240959;
    L7:
        r7 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.av_call.view.d1] */
    public VoiceCallTopLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = ThemeType.DEFAULT;
        this.d = "";
        boolean r5 = true;
        this.g = true;
        this.j = new Handler(Looper.getMainLooper());
        IRealtimeCallConfigDependency r6 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        this.m = r6;
        if (r6 != null) goto L5;
    L7:
        r5 = false;
    L8:
        if (r5 == false) goto L10;
        LarusLayoutRealtimeCallTopBinding r7 = LarusLayoutRealtimeCallTopBinding.a(LayoutInflater.from(r2).inflate(2131562874, this));
        Intrinsics.checkNotNull(r7);
    L11:
        this.a = r7;
        this.n = new d1(this);
        return;
    L10:
        LayoutInflater.from(r2).inflate(2131562873, this);
        r7 = LarusLayoutRealtimeCallTopBinding.a(this);
        Intrinsics.checkNotNull(r7);
        goto L11
    L5:
        if (r6.m() != true) goto L7;
        goto L7
    }

    public final void U5(boolean r9, boolean r10, boolean r11) {
        this.c = r9;
        Application r12 = i88.e.a;
        CustomRoundImageView r0 = this.a.e;
        ThemeType r1 = this.b;
        boolean r2 = this.h;
        h88.b r13 = this.l;
        boolean r6 = false;
        if (r13 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        i88.e.j(r0, r1, r2, r9, r10, r5);
        V5(this.a, this.b, r9);
        this.a.d.a(r9);
        h88.b r14 = this.l;
        if (r14 != null) goto L11;
    L13:
        Y5(this, r6);
        return;
    L11:
        if (r14.r != true) goto L13;
        r6 = true;
        goto L13
    L5:
        if (r13.r != true) goto L7;
        r5 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(LarusLayoutRealtimeCallTopBinding r2, ThemeType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "themeType");
        if (b6(r3) == false) goto L5;
        return;
    L5:
        if (r4 == false) goto L7;
    L10:
        r2.b.setTextColor(ContextCompat.getColor(getContext(), 2131103298));
        return;
    L7:
        if (i88.e.o(r3) == true) goto L10;
        r2.b.setTextColor(ColorProtector.parseColor("#CC000000"));
    }

    public /* synthetic */ VoiceCallTopLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void Z5(boolean r9, boolean r10, boolean r11, boolean r12) {
        int r13 = 8;
        if (r9 == true) goto L5;
        NoSpaceTextView r14 = this.a.b;
        if ((!b6(this.b)) == false) goto L44;
        r13 = 0;
    L44:
        r14.setVisibility(r13);
        com.larus.utils.e1.o(this.a.d);
        com.larus.utils.e1.o(this.a.e);
        View r15 = this.f;
        if (r15 == null) goto L50;
        com.larus.utils.e1.o(r15);
        return;
    L50:
        return;
    L5:
        if (b6(this.b) == false) goto L7;
        com.larus.utils.e1.o(this.a.b);
        com.larus.utils.e1.o(this.a.f);
    L15:
        if (this.e == false) goto L24;
        SceneModeButton r16 = this.a.d;
        ThemeType r17 = this.b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "themeType");
        r16.b = r17;
        r16.a(false);
        if (this.b != ThemeType.MAIN_BOT) goto L21;
        com.larus.utils.e1.x(this.a.d);
        View r19 = this.f;
        if (r19 == null) goto L30;
        com.larus.utils.e1.o(r19);
    L30:
        if (r10 == true) goto L32;
    L40:
        com.larus.utils.e1.o(this.a.e);
        return;
    L32:
        if (getShouldHideTopActionIcons() == true) goto L40;
        this.h = false;
        com.larus.utils.e1.x(this.a.e);
        Application r20 = i88.e.a;
        CustomRoundImageView r2 = this.a.e;
        ThemeType r3 = this.b;
        boolean r4 = this.h;
        boolean r5 = this.c;
        h88.b r21 = this.l;
        if (r21 != null) goto L36;
    L38:
        boolean r7 = false;
    L39:
        i88.e.j(r2, r3, r4, r5, r11, r7);
        return;
    L36:
        if (r21.r != true) goto L38;
        r7 = true;
        goto L39
    L21:
        com.larus.utils.e1.o(this.a.d);
        View r22 = this.f;
        if (r22 == null) goto L30;
        com.larus.utils.e1.x(r22);
        goto L30
    L24:
        NoSpaceTextView r23 = this.a.b;
        if ((!b6(this.b)) == false) goto L27;
        r13 = 0;
    L27:
        r23.setVisibility(r13);
        com.larus.utils.e1.o(this.a.d);
        View r24 = this.f;
        if (r24 == null) goto L30;
        com.larus.utils.e1.o(r24);
        goto L30
    L7:
        this.a.b.setText(this.d);
        if (this.b != ThemeType.MAIN_BOT) goto L10;
        com.larus.utils.e1.o(this.a.b);
    L11:
        com.larus.utils.e1.o(this.a.f);
        if (this.b != ThemeType.IMMERS_BOT) goto L15;
        this.a.b.setAlpha(0.8f);
        this.a.f.setAlpha(0.8f);
        goto L15
    L10:
        com.larus.utils.e1.x(this.a.b);
        goto L11
    }

    public final void S5(ThemeType r2, String r3, boolean r4, View r5, boolean r6, boolean r7, boolean r8, boolean r9, h88.b r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "themeType");
        Intrinsics.checkNotNullParameter(r3, "botName");
        Intrinsics.checkNotNullParameter(r5, "realtimeCallSceneButton");
        Intrinsics.checkNotNullParameter(r10, "runtimeData");
        this.b = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.l = r10;
        this.i = r11;
        V5(this.a, r2, this.c);
        Z5(r7, r6, r8, r9);
    }
}
