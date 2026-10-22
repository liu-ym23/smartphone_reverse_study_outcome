package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.monitor.page.WindowFreezeMonitor;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0014J\u0014\u0010(\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!¨\u0006,"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuSubContent;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "getPanelType", "()Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "shadowTarget", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "getShadowTarget", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "menuContext", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "getMenuContext", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "setMenuContext", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;)V", "parentItemWidth", "getParentItemWidth", "()I", "setParentItemWidth", "(I)V", "menuContainer", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "getMenuContainer", "()Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "menuContainer$delegate", "Lkotlin/Lazy;", "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "setActions", "actions", BuildConfig.FLAVOR, "Lcom/ss/android/lark/biz/im/extension/panel/ContentMessageActionItem;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuSubContent extends FrameLayout implements IPopupMenuContent {
    public final PanelType a;
    public final IPopupMenuContent.ShadowTarget b;
    public d c;
    public int d;
    public final Lazy e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ zya.b a;
        public final /* synthetic */ PopupMenuItem b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PopupMenuSubContent d;

        public a(zya.b r1, PopupMenuItem r2, boolean r3, PopupMenuSubContent r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (g.a(this.a, this.b, this.c) == false) goto L10;
            d r5 = this.d.getMenuContext();
            if (r5 == null) goto L11;
            com.ss.android.lark.chat.message.menu.v2.popup.a r6 = r5.a();
            if (r6 == null) goto L12;
            i0.a(r6, false, null, 7);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PopupMenuSubContent a;

        public b(PopupMenuSubContent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            d r2 = this.a.getMenuContext();
            if (r2 == null) goto L8;
            com.ss.android.lark.chat.message.menu.v2.popup.a r3 = r2.a();
            if (r3 == null) goto L9;
            r3.e();
            return;
        L9:
            return;
        }
    }

    public PopupMenuSubContent(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PopupMenuSubContent(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LKUIRoundLinearLayout getMenuContainer() {
        return (LKUIRoundLinearLayout) this.e.getValue();
    }

    public final d getMenuContext() {
        return this.c;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public PanelType getPanelType() {
        return this.a;
    }

    public final int getParentItemWidth() {
        return this.d;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public IPopupMenuContent.ShadowTarget getShadowTarget() {
        return this.b;
    }

    public final void setActions(List<zya.b> r15) {
        Intrinsics.checkNotNullParameter(r15, "actions");
        Context r0 = getContext();
        d r1 = this.c;
        if (r1 == null) goto L9;
        com.ss.android.lark.biz.im.api.message.params.m r2 = r1.c;
        if (r2 == null) goto L9;
        Integer r3 = r2.f;
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        int r5 = UIUtils.getColor(r0, r4);
        getMenuContainer().removeAllViews();
        Iterator<T> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L61;
        zya.b r6 = (zya.b) r16.next();
        boolean r9 = g.b(r6);
        View r11 = null;
        boolean r12 = false;
        PopupMenuItem r10 = new PopupMenuItem(getContext(), null, 6, 0);
        r10.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r10.setIcon(r6.b);
        r10.setText(r6.e);
        Context r7 = getContext();
        int r8 = UIUtils.getColor(getContext(), 2131102416);
        d r13 = this.c;
        if (r13 == null) goto L18;
        com.ss.android.lark.biz.im.api.message.params.m r14 = r13.c;
        if (r14 == null) goto L18;
        Integer r17 = r14.g;
    L19:
        g.c(r10, r7, r6, r5, r8, r17, r9);
        if (r6.c == true) goto L27;
        if (r9 == true) goto L23;
        r10.setIconTint(UIUtils.getColor(getContext(), 2131102416));
        r10.setTextColor(UIUtils.getColor(getContext(), 2131102416));
        goto L27
    L23:
        Integer r18 = r6.d;
        if (r18 == null) goto L26;
        int r19 = UIUtils.getColor(getContext(), r18.intValue());
        r10.setIconTint(r19);
        r10.setTextColor(r19);
        goto L27
    L26:
        r10.setIconTint(r5);
        r10.setTextColor(r5);
    L27:
        List r20 = r6.k;
        if (r20 != null) goto L30;
    L33:
        boolean r21 = true;
    L34:
        boolean r22 = !r21;
        r10.a(r22);
        if (r22 == false) goto L37;
        r10.setArrowTint(r5);
    L37:
        if (r20 != null) goto L39;
    L40:
        r12 = true;
    L41:
        if (r12 == false) goto L43;
        r10.setOnClickListener(new a(r6, r10, r9, this));
    L44:
        int r23 = WindowFreezeMonitor.a;
        if (WindowFreezeMonitor.a(getMenuContainer()) == true) goto L48;
        r11 = getMenuContainer().getChildAt(getMenuContainer().getChildCount() - 1);
    L48:
        if (r11 == null) goto L60;
        if ((r11 instanceof h) == true) goto L60;
        LKUIRoundLinearLayout r24 = getMenuContainer();
        Context r25 = getContext();
        d r26 = this.c;
        if (r26 == null) goto L58;
        com.ss.android.lark.biz.im.api.message.params.m r27 = r26.c;
        if (r27 == null) goto L58;
        Integer r28 = r27.d;
        if (r28 == null) goto L58;
        int r29 = r28.intValue();
    L59:
        r24.addView(new h(r25, false, 0.0f, r29, 20));
    L58:
        r29 = 2131108714;
    L60:
        getMenuContainer().addView(r10);
        goto L12
    L43:
        r10.setOnClickListener(new b(this));
        goto L44
    L39:
        if (r20.isEmpty() == false) goto L41;
    L30:
        if (r20.isEmpty() == true) goto L33;
        r21 = false;
    L18:
        r17 = null;
        goto L19
    L61:
        return;
    L9:
        r4 = 2131102418;
        goto L10
    }

    public final void setMenuContext(d r1) {
        this.c = r1;
    }

    public final void setParentItemWidth(int r1) {
        this.d = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        int r0 = this.d;
        if (r0 <= 0) goto L5;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r0 + UIUtils.dp2px(getContext(), 10.0f), 1073741824), r4);
        return;
    L5:
        super.onMeasure(r3, r4);
    }

    public PopupMenuSubContent(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = PanelType.ACTION;
        this.b = IPopupMenuContent.ShadowTarget.CHILD;
        this.e = LazyKt.lazy(new PopupMenuSubContent$menuContainer$2(r2, this));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(getMenuContainer());
    }

    public /* synthetic */ PopupMenuSubContent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
