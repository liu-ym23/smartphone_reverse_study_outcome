package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u0018\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0014J0\u00102\u001a\u00020+2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0014J\u0010\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020;H\u0014R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b'\u0010(¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuPartialContent;", "Landroid/view/ViewGroup;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "getPanelType", "()Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "value", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "menuContext", "getMenuContext", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "setMenuContext", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;)V", "arrowHeight", "arrowWidth", "arrowPoint", "path", "Landroid/graphics/Path;", "radius", BuildConfig.FLAVOR, "rectF", "Landroid/graphics/RectF;", "bgPaint", "Landroid/graphics/Paint;", "getBgPaint", "()Landroid/graphics/Paint;", "bgPaint$delegate", "Lkotlin/Lazy;", "menuContainer", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "getMenuContainer", "()Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "menuContainer$delegate", "setMenuItems", BuildConfig.FLAVOR, "actionList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/biz/im/extension/panel/MessageActionItem;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", BuildConfig.FLAVOR, "l", "t", "r", "b", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuPartialContent extends ViewGroup implements IPopupMenuContent {
    public final PanelType a;
    public d b;
    public final int c;
    public final int d;
    public final int e;
    public final Path f;
    public final float g;
    public final RectF h;
    public final Lazy i;
    public final Lazy j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ zya.b a;
        public final /* synthetic */ PopupMenuItemPartial b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PopupMenuPartialContent d;

        public a(zya.b r1, PopupMenuItemPartial r2, boolean r3, PopupMenuPartialContent r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (g.a(this.a, this.b, this.c) == false) goto L14;
            d r5 = this.d.getMenuContext();
            if (r5 == null) goto L15;
            com.ss.android.lark.chat.message.menu.v2.popup.a r6 = r5.a();
            if (r6 == null) goto L16;
            yya.i r0 = this.a.n;
            if (r0 == null) goto L11;
            MessageActionType r1 = r0.getType();
        L12:
            i0.a(r6, true, r1, 4);
            return;
        L11:
            r1 = null;
            goto L12
        L16:
            return;
        L15:
            return;
        }
    }

    public PopupMenuPartialContent(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PopupMenuPartialContent(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Paint getBgPaint() {
        return (Paint) this.i.getValue();
    }

    private final LKUIRoundLinearLayout getMenuContainer() {
        return (LKUIRoundLinearLayout) this.j.getValue();
    }

    public final d getMenuContext() {
        return this.b;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public PanelType getPanelType() {
        return this.a;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public IPopupMenuContent.ShadowTarget getShadowTarget() {
        return IPopupMenuContent.ShadowTarget.SELF;
    }

    private final void setMenuItems(List<? extends zya.e> r12) {
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L28;
        zya.b r0 = (zya.e) r13.next();
        Integer r2 = null;
        if ((r0 instanceof zya.b) == false) goto L8;
        zya.b r1 = r0;
    L9:
        if (r1 == null) goto L4;
        boolean r3 = g.b(r1);
        PopupMenuItemPartial r10 = new PopupMenuItemPartial(getContext(), null, 6, 0);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        r4.weight = 1.0f;
        r10.setLayoutParams(r4);
        r10.setIcon(r1.b);
        r10.setText(r1.e);
        Context r5 = getContext();
        Context r6 = getContext();
        d r7 = this.b;
        if (r7 == null) goto L18;
        com.ss.android.lark.biz.im.api.message.params.m r8 = r7.c;
        if (r8 == null) goto L18;
        Integer r9 = r8.f;
        if (r9 == null) goto L18;
        int r11 = r9.intValue();
    L19:
        int r14 = UIUtils.getColor(r6, r11);
        int r15 = UIUtils.getColor(getContext(), 2131102416);
        d r16 = this.b;
        if (r16 == null) goto L24;
        com.ss.android.lark.biz.im.api.message.params.m r17 = r16.c;
        if (r17 == null) goto L24;
        r2 = r17.g;
    L24:
        g.c(r10, r5, r1, r14, r15, r2, r3);
        if (r3 == true) goto L27;
        r10.setAlpha(0.5f);
    L27:
        r10.setOnClickListener(new a(r1, r10, r3, this));
        getMenuContainer().addView(r10);
    L18:
        r11 = 2131102418;
        goto L19
    L8:
        r1 = null;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        this.f.reset();
        float r2 = this.g;
        float r3 = 2;
        float r4 = r2 * r3;
        this.f.moveTo(0.0f, r2);
        this.h.set(0.0f, 0.0f, r4, r4);
        this.f.arcTo(this.h, 180.0f, 90.0f);
        this.f.lineTo(getMeasuredWidth() - this.g, 0.0f);
        this.h.set(getMeasuredWidth() - r4, 0.0f, getMeasuredWidth(), r4);
        this.f.arcTo(this.h, 270.0f, 90.0f);
        this.f.lineTo(getMeasuredWidth(), getMenuContainer().getMeasuredHeight() - this.g);
        this.h.set(getMeasuredWidth() - r4, getMenuContainer().getMeasuredHeight() - r4, getMeasuredWidth(), getMenuContainer().getMeasuredHeight());
        this.f.arcTo(this.h, 0.0f, 90.0f);
        float r5 = getMenuContainer().getMeasuredHeight();
        float r6 = getMeasuredWidth() / 2.0f;
        float r7 = this.d;
        float r9 = this.c;
        float r8 = r7 / r3;
        this.f.lineTo(r6 + r8, r5);
        float r10 = r7 / 4;
        float r16 = r5 + r9;
        this.f.cubicTo(r6 + r10, r5, this.e + r6, r16, r6, r16);
        this.f.cubicTo(r6 - this.e, r16, r6 - r10, r5, r6 - r8, r5);
        this.f.lineTo(this.g, r5);
        this.h.set(0.0f, getMenuContainer().getMeasuredHeight() - r4, r4, getMenuContainer().getMeasuredHeight());
        this.f.arcTo(this.h, 90.0f, 90.0f);
        this.f.close();
        r18.drawPath(this.f, getBgPaint());
        super.dispatchDraw(r18);
    }

    public final void setMenuContext(d r1) {
        this.b = r1;
        if (r1 == null) goto L8;
        com.ss.android.lark.chat.message.menu.d r2 = r1.b;
        if (r2 == null) goto L9;
        setMenuItems(r2.a);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        getMenuContainer().measure(r2, r3);
        setMeasuredDimension(getMenuContainer().getMeasuredWidth(), getMenuContainer().getMeasuredHeight() + this.c);
    }

    public PopupMenuPartialContent(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = PanelType.ACTION;
        this.c = UIUtils.dp2px(r2, 7.0f);
        this.d = UIUtils.dp2px(r2, 20.0f);
        this.e = UIUtils.dp2px(r2, 2.0f);
        this.f = new Path();
        this.g = UIUtils.dp2px(r2, 12.0f);
        this.h = new RectF();
        this.i = LazyKt.lazy(new PopupMenuPartialContent$bgPaint$2(this, r2));
        this.j = LazyKt.lazy(new PopupMenuPartialContent$menuContainer$2(r2));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(getMenuContainer());
    }

    public /* synthetic */ PopupMenuPartialContent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        getMenuContainer().layout(0, 0, getMenuContainer().getMeasuredWidth(), getMenuContainer().getMeasuredHeight());
    }
}
