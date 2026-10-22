package com.obric.assistant.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.util.m2;
import com.obric.assistant.window.materials.MaterialSceneType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\f\u00101\u001a\u00020%*\u000202H\u0002J\"\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u001dH\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0016\u0010:\u001a\u00020%2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020%0<H\u0016J \u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\u0010\u0010C\u001a\u00020%2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0016J \u0010G\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010H\u001a\u00020\u001dH\u0016J\u0010\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020KH\u0002J\u0018\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020?2\u0006\u0010H\u001a\u00020\u001dH\u0016J\u000e\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020?J\b\u0010R\u001a\u00020%H\u0002J\b\u0010S\u001a\u00020%H\u0016R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006U"}, d2 = {"Lcom/obric/assistant/view/WindowChatTitleAlignLeftStyle;", "Lcom/obric/assistant/view/ObricChatTitleAlignLeftStyle;", "Lcom/obric/assistant/view/ObricSwipeGestureView$OnSwipeGestureListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "pageUIAbility", "Lcom/obric/assistant/window/ability/IObricPageUIAbility;", "getPageUIAbility", "()Lcom/obric/assistant/window/ability/IObricPageUIAbility;", "pageUIAbility$delegate", "viewTopMargin", "", "viewBottomMargin", "buttonWidth", "buttonHeight", "gestureView", "Lcom/obric/assistant/view/ObricSwipeGestureView;", "getGestureView", "()Lcom/obric/assistant/view/ObricSwipeGestureView;", "gestureView$delegate", "interruptMoveAction", "", "downTopEmptyHeight", "actionInMiddleRange", "showItemIds", "", "getShowItemIds", "()Ljava/util/List;", "initView", "", "isMainCvs", "titleName", "", "ttsChecked", "isSideBar", "isEnterpriseColdStart", "setupEnterpriseTitle", "setupGestureView", "setupTtsContainer", "setupMultiTaskManagement", "bringInteractiveButtonsToFront", "setupMaterialInternal", "Landroid/view/View;", "setTitle", "title", "tagConfig", "Lcom/larus/platform/api/ChatTitleTagConfig;", "isDefaultName", "setCvsOnlyRead", "isOnlyRead", "setOnTtsLongPressAction", "longClickAction", "Lkotlin/Function0;", "doMoveAction", "distance", "", "velocity", "finish", "isLandscapeDragDisabled", "tryVibrate", "onDown", "e", "Landroid/view/MotionEvent;", "onSwipeFinish", "swipeUp", "onClickNextFloorView", "pointF", "Landroid/graphics/PointF;", "onClickTitleBar", "downPoint", "onSwipe", "delta", "changeTitleAlpha", "alpha", "setupViewGone", "updateAllIconVisibilityForObric", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowChatTitleAlignLeftStyle extends ObricChatTitleAlignLeftStyle implements ObricSwipeGestureView.c {
    public static final /* synthetic */ int k1 = 0;
    public final int H0;
    public final int L0;
    public final int P0;
    public final int V0;
    public final Lazy b1;
    public int g1;
    public boolean h1;
    public final Lazy k0;
    public final Lazy p0;

    public static final class a {
    }

    static {
    }

    public void setOnTtsLongPressAction(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "longClickAction");
    }

    private final ObricSwipeGestureView getGestureView() {
        return (ObricSwipeGestureView) this.b1.getValue();
    }

    private final laa.d getPageStateAbility() {
        return (laa.d) this.k0.getValue();
    }

    private final xha.c getPageUIAbility() {
        return (xha.c) this.p0.getValue();
    }

    private final List<Integer> getShowItemIds() {
        List r0 = CollectionsKt.createListBuilder();
        r0.add(2131389947);
        r0.add(2131393304);
        r0.add(2131380479);
        r0.add(2131381186);
        return CollectionsKt.build(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E7() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = getChildAt(r1);
        if (getShowItemIds().contains(Integer.valueOf(r2.getId())) == true) goto L9;
        if (r2.getVisibility() == 8) goto L9;
        e1.o(r2);
    L9:
        r1 = r1 + 1;
        goto L3
    }

    public final void o7() {
        E7();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowChatTitleAlignLeftStyle(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.k0 = LazyKt.lazy(new k0(this));
        this.p0 = LazyKt.lazy(new l0(this));
        this.H0 = i5.q();
        this.L0 = i5.r0();
        this.P0 = c7.b(40);
        this.V0 = c7.b(40);
        this.b1 = LazyKt.lazy(new m0(r3));
        this.h1 = true;
        setClipChildren(false);
        setClipToPadding(false);
    }

    private final void setupMaterialInternal(View r4) {
        FLogger.a.i("WindowChatTitleAlignLeftStyle", "set up title bar material");
        r4.setTag(2131381207, r4);
        Lazy r0 = bia.g.a;
        bia.g.a(r4, true, MaterialSceneType.FLOATING_BG);
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void E(float r5) {
        laa.d r0 = getPageStateAbility();
        boolean r1 = true;
        if (r0 == null) goto L9;
        ObricFloatChatPageState r2 = r0.getPageState();
        if (r2 == null) goto L9;
        ObricFloatChatPageData.Companion.getClass();
        if ((r2 instanceof vda.a) != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L23;
        laa.d r4 = getPageStateAbility();
        if (r4 == null) goto L18;
        ObricFloatChatPageState r6 = r4.getPageState();
        if (r6 == null) goto L18;
        ObricFloatChatPageData.Companion.getClass();
        if ((r6 instanceof vda.b) != true) goto L18;
    L19:
        if (r1 == true) goto L24;
        C7(r5, 0.0f, false);
        return;
    L24:
        return;
    L18:
        r1 = false;
        goto L19
    L23:
        return;
    L9:
        r3 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void F4(PointF r12) {
        Intrinsics.checkNotNullParameter(r12, "pointF");
        PointF r0 = new PointF(r12.x, r12.y);
        FLogger.a.i("WindowChatTitleAlignLeftStyle", "onClickTitleBar, downPoint = " + r0);
        if (getVisibility() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L36;
        int r14 = getChildCount();
        int r4 = 0;
    L9:
        if (r4 >= r14) goto L43;
        View r5 = getChildAt(r4);
        if (r5.getVisibility() != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L35;
        if (r5.getAlpha() != 1.0f) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L35;
        float r8 = r5.getX();
        float r9 = r5.getX() + r5.getWidth();
        float r10 = r0.x;
        if (r8 <= r10) goto L23;
    L25:
        boolean r11 = false;
    L26:
        if (r11 == false) goto L35;
        float r15 = r5.getY();
        float r16 = r5.getY() + r5.getHeight();
        float r17 = r0.y;
        if (r15 <= r17) goto L30;
    L32:
        boolean r18 = false;
    L33:
        if (r18 == false) goto L35;
        r5.performClick();
        goto L35
    L30:
        if (r17 > r16) goto L32;
        r18 = true;
        goto L33
    L23:
        if (r10 > r9) goto L25;
        r11 = true;
        goto L26
    L18:
        r7 = false;
    L35:
        FLogger.a.i("WindowChatTitleAlignLeftStyle", "onClickTitleBar, it is " + r5 + ", \nrect is " + r5.getX() + ", " + r5.getY() + ", " + (r5.getX() + r5.getWidth()) + ", " + (r5.getY() + r5.getHeight()));
        r4 = r4 + 1;
        goto L9
    L13:
        r6 = false;
        goto L14
    L43:
        return;
    L36:
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void onDown(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        xha.c r4 = getPageUIAbility();
        Integer r0 = null;
        if (r4 == null) goto L5;
        Integer r5 = r4.w40();
    L6:
        laa.d r1 = getPageStateAbility();
        if (r1 == null) goto L12;
        ObricFloatChatPageState r2 = r1.getPageState();
        if (r2 == null) goto L12;
        r0 = Integer.valueOf(r2.getHeight());
    L12:
        if (Intrinsics.areEqual(r5, r0) == false) goto L21;
        xha.c r6 = getPageUIAbility();
        if (r6 == null) goto L18;
        Integer r7 = r6.w40();
        if (r7 == null) goto L18;
        int r8 = r7.intValue();
    L19:
        this.g1 = r8;
        return;
    L18:
        r8 = 0;
        goto L19
    L21:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public void setCvsOnlyRead(boolean r1) {
        e1.o(getBinding().t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y7(float r4) {
        FLogger.a.i("WindowChatTitleAlignLeftStyle", "change title bar alpha");
        setAlpha(r4);
        ObricSwipeGestureView r0 = getGestureView();
        if (r4 <= 0.0f) goto L5;
        boolean r5 = true;
    L6:
        r0.setEnabled(r5);
        E7();
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void s5(float r2, float r3) {
        C7(r2, r3, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C7(float r25, float r26, boolean r27) {
        ObricFloatChatPageData.a r3 = ObricFloatChatPageData.Companion;
        laa.d r4 = getPageStateAbility();
        if (r4 == null) goto L5;
        ObricFloatChatPageState r5 = r4.getPageState();
    L6:
        r3.getClass();
        boolean r6 = true;
        if ((r5 instanceof vda.f) == true) goto L21;
        Context r7 = getContext();
        if (r7 == null) goto L17;
        Resources r8 = r7.getResources();
        if (r8 == null) goto L17;
        Configuration r9 = r8.getConfiguration();
        if (r9 == null) goto L17;
        if (r9.orientation != 2) goto L17;
        boolean r10 = true;
    L18:
        if (r10 == true) goto L21;
        boolean r11 = false;
    L22:
        if (r11 == false) goto L24;
        return;
    L24:
        laa.d r12 = getPageStateAbility();
        if (r12 == null) goto L31;
        ObricFloatChatPageState r13 = r12.getPageState();
        if (r13 == null) goto L31;
        if ((r13 instanceof vda.c) != true) goto L31;
        boolean r14 = true;
    L32:
        if (r14 == true) goto L36;
        laa.d r15 = getPageStateAbility();
        if (r15 == null) goto L36;
        r15.o2(this.g1);
    L36:
        if (r27 == true) goto L38;
        laa.d r2 = getPageStateAbility();
        if (r2 == null) goto L82;
        r2.o2(this.g1 + ((int) r25));
    L82:
        int r16 = -m2.c;
        int r17 = m2.d;
        int r1 = (int) r25;
        if (r16 > r1) goto L86;
        if (r1 > r17) goto L86;
    L87:
        if (r6 == false) goto L89;
    L93:
        this.h1 = r6;
        return;
    L89:
        if (this.h1 == false) goto L93;
        if (r1 < r16) goto L93;
        if (r1 <= r17) goto L93;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_SOFT);
    L86:
        r6 = false;
        goto L87
    L38:
        if (r26 >= (-1500.0f)) goto L47;
        if (r25 >= 0.0f) goto L47;
        laa.d r18 = getPageStateAbility();
        if (r18 == null) goto L44;
        laa.d.a.c(r18, Float.valueOf(r26), false, "swipe_up", 2);
    L44:
        int r19 = fia.a.a;
        fia.a.b(ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp());
        return;
    L47:
        if (r26 <= 1500.0f) goto L55;
        if (r25 <= 0.0f) goto L55;
        laa.d r20 = getPageStateAbility();
        if (r20 == null) goto L95;
        laa.d.a.a(r20, r26, false, 2);
        return;
    L95:
        return;
    L55:
        if (r25 <= 0.0f) goto L65;
        if (r25 >= m2.d) goto L61;
        laa.d r21 = getPageStateAbility();
        if (r21 == null) goto L96;
        laa.d.a.d(r21, false, this.g1, null, false, false, PageStateChangedReason.SWIPE_GESTURE_VIEW, 29);
        return;
    L96:
        return;
    L61:
        laa.d r22 = getPageStateAbility();
        if (r22 == null) goto L98;
        laa.d.a.a(r22, r26, false, 2);
        return;
    L98:
        return;
    L65:
        if (Math.abs(r25) >= m2.c) goto L70;
        laa.d r23 = getPageStateAbility();
        if (r23 == null) goto L69;
        laa.d.a.d(r23, false, this.g1, null, false, false, PageStateChangedReason.SWIPE_GESTURE_VIEW, 29);
    L69:
        fia.a.b(null);
        return;
    L70:
        laa.d r110 = getPageStateAbility();
        if (r110 == null) goto L101;
        int r24 = r110.getPageState().getHeight();
        int r28 = m2.b;
        if (r24 > r28) goto L78;
        laa.d r29 = getPageStateAbility();
        if (r29 == null) goto L77;
        laa.d.a.c(r29, Float.valueOf(r26), false, "swipe_up", 2);
    L77:
        int r30 = fia.a.a;
        fia.a.b(ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp());
        return;
    L78:
        laa.d.a.d(r110, false, r28, null, true, false, PageStateChangedReason.SWIPE_GESTURE_VIEW, 21);
        return;
    L101:
        return;
    L31:
        r14 = false;
    L17:
        r10 = false;
    L21:
        r11 = true;
        goto L22
    L5:
        r5 = null;
        goto L6
    }

    public final void Ia(String r2, com.larus.platform.api.j r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        super.Ia(r2, r3, r4);
        E7();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.view.ObricChatTitleAlignLeftStyle
    public final void i6(boolean r2, String r3, boolean r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "titleName");
        super.i6(r2, r3, r4, r5, r6);
        pla.j.g(getGestureView());
        ObricSwipeGestureView r7 = getGestureView();
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(-1, 0);
        r8.topToTop = 0;
        r8.bottomToBottom = 0;
        r8.startToStart = 0;
        r8.endToEnd = 0;
        Unit r9 = Unit.INSTANCE;
        addView(r7, r8);
        getGestureView().setOnSwipeGestureListener(this);
        E7();
        FrameLayout r10 = getBinding().E;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
    L6:
        if (r12 == null) goto L8;
        ((ViewGroup.MarginLayoutParams) r12).width = this.P0;
        ((ViewGroup.MarginLayoutParams) r12).height = this.V0;
        r12.setMarginEnd(i5.q());
        ((ViewGroup.MarginLayoutParams) r12).topMargin = this.H0;
        ((ViewGroup.MarginLayoutParams) r12).bottomMargin = this.L0;
    L9:
        r10.setLayoutParams(r12);
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        LottieAdapterView r13 = getBinding().D;
        ViewGroup.LayoutParams r14 = getBinding().D.getLayoutParams();
        if (r14 == null) goto L12;
        r14.width = this.P0;
        r14.height = this.V0;
    L13:
        r13.setLayoutParams(r14);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        Intrinsics.checkNotNull(r13);
        setupMaterialInternal(r13);
        ImageView r15 = getBinding().q;
        Intrinsics.checkNotNull(r15);
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L24;
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r16;
        ((ViewGroup.MarginLayoutParams) r17).width = this.P0;
        ((ViewGroup.MarginLayoutParams) r17).height = this.V0;
        r17.startToStart = 0;
        r17.setMarginStart(i5.q());
        ((ViewGroup.MarginLayoutParams) r17).topMargin = this.H0;
        ((ViewGroup.MarginLayoutParams) r17).bottomMargin = this.L0;
        r15.setLayoutParams(r17);
        setupMaterialInternal(r15);
        getBinding().E.bringToFront();
        getBinding().q.bringToFront();
        if (AccountService.a.isEnterpriseAccount() == false) goto L22;
        int r18 = (int) getContext().getResources().getDimension(2131167415);
        int r19 = (int) getContext().getResources().getDimension(2131167150);
        View r20 = LayoutInflater.from(getContext()).inflate(2131563376, null, false);
        if (r20 == null) goto L21;
        FrameLayout r21 = (FrameLayout) r20;
        Intrinsics.checkNotNull(r21);
        setupMaterialInternal(r21);
        ConstraintLayout.LayoutParams r22 = new ConstraintLayout.LayoutParams(r18, r19);
        r22.topToTop = 2131389947;
        r22.bottomToBottom = 2131389947;
        r22.startToStart = 0;
        r22.endToEnd = 0;
        addView(r21, r22);
        return;
    L21:
        throw new NullPointerException("rootView");
    L22:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L12:
        r14 = null;
        goto L13
    L8:
        r12 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }
}
