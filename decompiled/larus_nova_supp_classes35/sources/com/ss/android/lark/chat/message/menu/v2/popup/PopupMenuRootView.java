package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010.\u001a\u00020\u0019J\u0014\u0010/\u001a\u00020\u00192\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001901J<\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020*2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u00010-2\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\b\b\u0002\u00109\u001a\u00020\u0012J\u000e\u0010:\u001a\u00020\u00192\u0006\u00103\u001a\u00020*J\u000e\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@H\u0016J0\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007H\u0014J\u0012\u0010G\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010IH\u0016R&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRc\u0010\u0010\u001aK\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuRootView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "dismiss", "Lkotlin/Function3;", BuildConfig.FLAVOR, "Lkotlin/ParameterName;", IPortraitService.NAME, "isClickActionItem", "Lcom/ss/android/lark/biz/im/extension/message_action/MessageActionType;", "clickActionType", "isClickInputContainer", BuildConfig.FLAVOR, "getDismiss", "()Lkotlin/jvm/functions/Function3;", "setDismiss", "(Lkotlin/jvm/functions/Function3;)V", "needAdapterInputText", "getNeedAdapterInputText", "()Z", "setNeedAdapterInputText", "(Z)V", "bottomInputContainerHeight", "getBottomInputContainerHeight", "()Ljava/lang/Integer;", "setBottomInputContainerHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "dimView", "Landroid/view/View;", "anchorMargin", "safeEdge", "Landroid/graphics/Rect;", "startShowAnim", "startDismissAnim", "completion", "Lkotlin/Function0;", "addMenuView", "view", "anchorPoint", "Landroid/graphics/Point;", "anchorRect", "anchorStyle", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;", "alignmentParentItemRight", "removeMenuView", "performSwitchAnim", "toPanelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuRootView extends FrameLayout {
    public int a;
    public Function3<? super Boolean, ? super MessageActionType, ? super Boolean, Unit> b;
    public boolean c;
    public Integer d;
    public final View e;
    public final int f;
    public final Rect g;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public PopupMenuRootView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PopupMenuRootView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int getBackgroundColorRes() {
        return this.a;
    }

    public final Integer getBottomInputContainerHeight() {
        return this.d;
    }

    public final Function3<Boolean, MessageActionType, Boolean, Unit> getDismiss() {
        return this.b;
    }

    public final boolean getNeedAdapterInputText() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.getKeyCode() != 4) goto L12;
        if (r3.getAction() != 0) goto L12;
        Function3<? super Boolean, ? super MessageActionType, ? super Boolean, Unit> r4 = this.b;
        if (r4 == null) goto L13;
        Boolean r0 = Boolean.FALSE;
        r4.invoke(r0, null, r0);
        return true;
    L13:
        return true;
    L12:
        return super.dispatchKeyEvent(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        if (this.c == false) goto L25;
        if (r4 == null) goto L25;
        Integer r0 = this.d;
        if (r0 == null) goto L23;
        if (r0.intValue() <= 0) goto L23;
        if (r4.getAction() != 0) goto L21;
        if (r4.getY() <= (getHeight() - r0.intValue())) goto L21;
        Function3<? super Boolean, ? super MessageActionType, ? super Boolean, Unit> r5 = this.b;
        if (r5 == null) goto L26;
        r5.invoke(Boolean.FALSE, null, Boolean.TRUE);
        return false;
    L26:
        return false;
    L21:
        return super.dispatchTouchEvent(r4);
    L23:
        return super.dispatchTouchEvent(r4);
    L25:
        return super.dispatchTouchEvent(r4);
    }

    public final void setBackgroundColorRes(int r3) {
        this.a = r3;
        this.e.setBackgroundColor(UIUtils.getColor(getContext(), this.a));
    }

    public final void setBottomInputContainerHeight(Integer r1) {
        this.d = r1;
    }

    public final void setDismiss(Function3<? super Boolean, ? super MessageActionType, ? super Boolean, Unit> r1) {
        this.b = r1;
    }

    public final void setNeedAdapterInputText(boolean r1) {
        this.c = r1;
    }

    public PopupMenuRootView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = -1;
        View r5 = new View(r2);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(r5);
        this.e = r5;
        this.f = UIUtils.dp2px(r2, 16.0f);
        this.g = new Rect(0, UIUtils.dp2px(r2, 32.0f), 0, UIUtils.dp2px(r2, 32.0f));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public /* synthetic */ PopupMenuRootView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static /* synthetic */ void b(PopupMenuRootView r6, View r7, Point r8, int r9) {
        if ((r9 & 2) == 0) goto L5;
        r8 = null;
    L5:
        r6.a(r7, r8, null, null, false);
    }

    public final void a(View r6, Point r7, Rect r8, PopupMenuContentContainer.AnchorStyle r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r6, "view");
        PopupMenuContentContainer r0 = new PopupMenuContentContainer(getContext(), null, 6, 0);
        r0.setLayoutParams(new ViewGroup.LayoutParams(r6.getLayoutParams()));
        r0.addView(r6);
        r0.setAnchorPoint(r7);
        r0.setAnchorRect(r8);
        if (r10 == false) goto L5;
        PopupMenuContentContainer.AnchorAlignment r11 = PopupMenuContentContainer.AnchorAlignment.RIGHT;
    L6:
        r0.setAnchorAlignment(r11);
        if (r9 == null) goto L9;
        r0.setAnchorStyle(r9);
    L9:
        addView(r0);
        return;
    L5:
        r11 = PopupMenuContentContainer.AnchorAlignment.LEFT;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        View r14 = this.e;
        r14.layout(0, 0, r14.getMeasuredWidth(), this.e.getMeasuredHeight());
        int r15 = getChildCount();
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L49;
        View r17 = getChildAt(r16);
        if (Intrinsics.areEqual(r17, this.e) == true) goto L48;
        if ((r17 instanceof PopupMenuContentContainer) == false) goto L10;
        PopupMenuContentContainer r18 = (PopupMenuContentContainer) r17;
    L11:
        if (r18 == null) goto L48;
        boolean r0 = true;
        if (r18.getAnchorRect() == null) goto L16;
    L19:
        boolean r19 = true;
    L20:
        if (r19 == false) goto L45;
        int r110 = r18.getMeasuredWidth();
        int r1 = r18.getMeasuredHeight();
        if (r18.getAnchorStyle() != PopupMenuContentContainer.AnchorStyle.OVERLAY) goto L31;
        Rect r2 = r18.getAnchorRect();
        if (r2 == null) goto L25;
        if (r18.getAnchorAlignment() != PopupMenuContentContainer.AnchorAlignment.LEFT) goto L29;
        int r3 = r2.left - r18.getPaddingStart();
    L30:
        int r4 = RangesKt.coerceIn(r3, 0, Math.max(0, getMeasuredWidth() - r110));
        int r5 = RangesKt.coerceIn(r2.top - r18.getPaddingTop(), 0, getMeasuredHeight() - r1);
        r18.layout(r4, r5, r110 + r4, r1 + r5);
        goto L48
    L29:
        r3 = (r2.right + r18.getPaddingEnd()) - r110;
        goto L30
    L25:
        return;
    L31:
        Point r6 = r18.getAnchorPoint();
        if (r6 == null) goto L33;
        int r7 = r6.x;
        int r8 = r6.y;
        int r20 = RangesKt.coerceIn(r7 - (r110 / 2), 0, Math.max(0, getMeasuredWidth() - r110));
        int r21 = (r8 - this.f) - this.g.top;
        int r22 = ((getMeasuredHeight() - r8) - this.f) - this.g.bottom;
        if (r21 < ((r1 - r18.getPaddingTop()) - r18.getPaddingBottom())) goto L38;
    L40:
        if (r0 == false) goto L42;
        int r23 = ((r8 - this.f) - r1) + r18.getPaddingBottom();
        int r24 = this.g.top;
        int r25 = RangesKt.coerceIn(r23, r24, Math.max(r24, getMeasuredHeight() - r1));
    L43:
        r18.layout(r20, r25, r110 + r20, r1 + r25);
        goto L48
    L42:
        int r26 = (r8 + this.f) - r18.getPaddingTop();
        int r27 = this.g.top;
        r25 = RangesKt.coerceIn(r26, r27, Math.max(r27, getMeasuredHeight() - r1));
        goto L43
    L38:
        if (r22 < ((r1 - r18.getPaddingTop()) - r18.getPaddingBottom())) goto L40;
        r0 = false;
        goto L40
    L33:
        return;
    L45:
        if (r18.getPanelType() != PanelType.EMOJI) goto L47;
        r18.layout(0, getMeasuredHeight() - r18.getMeasuredHeight(), r18.getMeasuredWidth(), getMeasuredHeight());
        goto L48
    L47:
        r18.layout(0, 0, r18.getMeasuredWidth(), r18.getMeasuredHeight());
        goto L48
    L16:
        if (r18.getAnchorPoint() != null) goto L19;
        r19 = false;
        goto L20
    L10:
        r18 = null;
    L48:
        r16 = r16 + 1;
        goto L3
    }
}
