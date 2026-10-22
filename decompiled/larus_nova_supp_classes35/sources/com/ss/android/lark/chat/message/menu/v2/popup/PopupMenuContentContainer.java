package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002@AB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u00020$H\u0002J\u0012\u00105\u001a\u0002002\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:H\u0014J\u0010\u0010;\u001a\u0002002\u0006\u00109\u001a\u00020:H\u0002J \u0010<\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020?H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anchorPoint", "Landroid/graphics/Point;", "getAnchorPoint", "()Landroid/graphics/Point;", "setAnchorPoint", "(Landroid/graphics/Point;)V", "anchorRect", "Landroid/graphics/Rect;", "getAnchorRect", "()Landroid/graphics/Rect;", "setAnchorRect", "(Landroid/graphics/Rect;)V", "anchorStyle", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;", "getAnchorStyle", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;", "setAnchorStyle", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;)V", "anchorAlignment", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorAlignment;", "getAnchorAlignment", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorAlignment;", "setAnchorAlignment", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorAlignment;)V", "shadowColor", "isShadowEnabled", BuildConfig.FLAVOR, "shadowPaint", "Landroid/graphics/Paint;", "getShadowPaint", "()Landroid/graphics/Paint;", "shadowPaint$delegate", "Lkotlin/Lazy;", "rect", "Landroid/graphics/RectF;", "roundRadius", BuildConfig.FLAVOR, "setupPadding", BuildConfig.FLAVOR, "getPanelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "setShadowEnabled", "enable", "addView", "child", "Landroid/view/View;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawShadow", "drawShadowForView", "view", "selfLoc", BuildConfig.FLAVOR, "AnchorStyle", "AnchorAlignment", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuContentContainer extends FrameLayout {
    public Point a;
    public Rect b;
    public AnchorStyle c;
    public AnchorAlignment d;
    public final int e;
    public boolean f;
    public final Lazy g;
    public final RectF h;
    public final float i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorAlignment;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnchorAlignment extends Enum<AnchorAlignment> {
        public static final AnchorAlignment LEFT = null;
        public static final AnchorAlignment RIGHT = null;
        public static final /* synthetic */ AnchorAlignment[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AnchorAlignment> getEntries() {
            return b;
        }

        static {
            AnchorAlignment r0 = new AnchorAlignment("LEFT", 0);
            LEFT = r0;
            AnchorAlignment r1 = new AnchorAlignment("RIGHT", 1);
            RIGHT = r1;
            AnchorAlignment[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static AnchorAlignment[] values() {
            return (AnchorAlignment[]) a.clone();
        }

        public static AnchorAlignment valueOf(String r1) {
            return (AnchorAlignment) r27.a.a(AnchorAlignment.class, r1);
        }

        public AnchorAlignment(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContentContainer$AnchorStyle;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "OVERLAY", "ASIDE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnchorStyle extends Enum<AnchorStyle> {
        public static final AnchorStyle ASIDE = null;
        public static final AnchorStyle OVERLAY = null;
        public static final /* synthetic */ AnchorStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AnchorStyle> getEntries() {
            return b;
        }

        static {
            AnchorStyle r0 = new AnchorStyle("OVERLAY", 0);
            OVERLAY = r0;
            AnchorStyle r1 = new AnchorStyle("ASIDE", 1);
            ASIDE = r1;
            AnchorStyle[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static AnchorStyle[] values() {
            return (AnchorStyle[]) a.clone();
        }

        public static AnchorStyle valueOf(String r1) {
            return (AnchorStyle) r27.a.a(AnchorStyle.class, r1);
        }

        public AnchorStyle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IPopupMenuContent.ShadowTarget.values().length];
            r0[IPopupMenuContent.ShadowTarget.SELF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[IPopupMenuContent.ShadowTarget.CHILD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[IPopupMenuContent.ShadowTarget.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public PopupMenuContentContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PopupMenuContentContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Paint getShadowPaint() {
        return (Paint) this.g.getValue();
    }

    public final PanelType getPanelType() {
        if (getChildCount() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        KeyEvent.Callback r1 = getChildAt(0);
        if ((r1 instanceof IPopupMenuContent) == false) goto L12;
        IPopupMenuContent r2 = (IPopupMenuContent) r1;
    L13:
        if (r2 == null) goto L17;
        PanelType r3 = r2.getPanelType();
        if (r3 == null) goto L17;
        return r3;
    L17:
        return PanelType.ACTION;
    L12:
        r2 = null;
        goto L13
    L8:
        return PanelType.ACTION;
    L5:
        r0 = false;
        goto L6
    }

    public final AnchorAlignment getAnchorAlignment() {
        return this.d;
    }

    public final Point getAnchorPoint() {
        return this.a;
    }

    public final Rect getAnchorRect() {
        return this.b;
    }

    public final AnchorStyle getAnchorStyle() {
        return this.c;
    }

    private final void setShadowEnabled(boolean r2) {
        this.f = r2;
        if (r2 == false) goto L5;
        int r3 = UIUtils.dp2px(getContext(), 27.0f);
    L6:
        setPadding(r3, r3, r3, r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void addView(View r2) {
        super.addView(r2);
        if ((r2 instanceof IPopupMenuContent) == true) goto L5;
        return;
    L5:
        if (((IPopupMenuContent) r2).getShadowTarget() == IPopupMenuContent.ShadowTarget.NONE) goto L7;
        boolean r3 = true;
    L8:
        setShadowEnabled(r3);
        return;
    L7:
        r3 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.f == false) goto L28;
        int[] r1 = new int[2];
        getLocationInWindow(r1);
        int r2 = getChildCount();
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L28;
        View r5 = getChildAt(r4);
        if ((r5 instanceof ViewGroup) == false) goto L9;
        ViewGroup r6 = (ViewGroup) r5;
    L10:
        if (r6 == null) goto L27;
        if ((r6 instanceof IPopupMenuContent) == false) goto L27;
        IPopupMenuContent.ShadowTarget r7 = ((IPopupMenuContent) r6).getShadowTarget();
        int r8 = a.a[r7.ordinal()];
        if (r8 == 1) goto L26;
        if (r8 != 2) goto L19;
        int r9 = r6.getChildCount();
        int r11 = 0;
    L24:
        if (r11 >= r9) goto L27;
        View r12 = r6.getChildAt(r11);
        Intrinsics.checkNotNull(r12);
        a(r10, r12, r1);
        r11 = r11 + 1;
        goto L24
    L19:
        if (r8 == 3) goto L27;
        throw new NoWhenBranchMatchedException();
    L26:
        a(r10, r6, r1);
    L27:
        r4 = r4 + 1;
        goto L5
    L9:
        r6 = null;
    L28:
        super.dispatchDraw(r10);
    }

    public final void setAnchorAlignment(AnchorAlignment r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setAnchorPoint(Point r1) {
        this.a = r1;
    }

    public final void setAnchorRect(Rect r1) {
        this.b = r1;
    }

    public final void setAnchorStyle(AnchorStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public PopupMenuContentContainer(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = AnchorStyle.ASIDE;
        this.d = AnchorAlignment.LEFT;
        this.e = 637534208;
        this.f = true;
        this.g = LazyKt.lazy(new PopupMenuContentContainer$shadowPaint$2(r2, this));
        this.h = new RectF();
        this.i = UIUtils.dp2px(r2, 12.0f);
        if (this.f == false) goto L5;
        int r5 = UIUtils.dp2px(getContext(), 27.0f);
    L6:
        setPadding(r5, r5, r5, r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public final void a(Canvas r4, View r5, int[] r6) {
        int[] r0 = new int[2];
        r5.getLocationInWindow(r0);
        int r2 = r0[0] - r6[0];
        float r1 = r2;
        float r3 = r0[1] - r6[1];
        this.h.set(r1, r3, r5.getMeasuredWidth() + r1, r5.getMeasuredHeight() + r3);
        RectF r7 = this.h;
        float r8 = this.i;
        r4.drawRoundRect(r7, r8, r8, getShadowPaint());
    }

    public /* synthetic */ PopupMenuContentContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
