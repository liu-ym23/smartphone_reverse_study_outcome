package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInTopEmojiView;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.chat.message.menu.v2.o0;
import com.ss.android.lark.monitor.page.WindowFreezeMonitor;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u000209J\b\u0010;\u001a\u000209H\u0002J\b\u0010<\u001a\u000209H\u0002J\u0018\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bH\u0014J\u0012\u0010@\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020EH\u0014J\b\u0010F\u001a\u000209H\u0002J\b\u0010G\u001a\u000209H\u0002J\u0010\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u0002092\u0006\u0010I\u001a\u00020JH\u0002R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010'\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b5\u00106¨\u0006L"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuMainContent;", "Landroid/widget/LinearLayout;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelType", "Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "getPanelType", "()Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", "shadowTarget", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "getShadowTarget", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuContent$ShadowTarget;", "value", "Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "menuContext", "getMenuContext", "()Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;", "setMenuContext", "(Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuContext;)V", "onReactionClickListener", "Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "getOnReactionClickListener", "()Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;", "setOnReactionClickListener", "(Lcom/ss/android/lark/chat/message/menu/v2/ReactionClickListener;)V", "subMenuShowing", BuildConfig.FLAVOR, "maskPaint", "Landroid/graphics/Paint;", "getMaskPaint", "()Landroid/graphics/Paint;", "maskPaint$delegate", "Lkotlin/Lazy;", "maskAlphaRatio", BuildConfig.FLAVOR, "maskAnimator", "Landroid/animation/ValueAnimator;", "maskRectF", "Landroid/graphics/RectF;", "reactionContainer", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "getReactionContainer", "()Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "reactionContainer$delegate", "menuContainer", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "getMenuContainer", "()Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "menuContainer$delegate", "onSubMenuShown", BuildConfig.FLAVOR, "onSubMenuDismissed", "showMask", "hideMask", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "refreshContainer", "refreshActions", "setReaction", "actions", "Lcom/ss/android/lark/chat/message/menu/MessageActionParseResult;", "setMenuItems", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuMainContent extends LinearLayout implements IPopupMenuContent {
    public final PanelType a;
    public final IPopupMenuContent.ShadowTarget b;
    public com.ss.android.lark.chat.message.menu.v2.popup.d c;
    public o0 d;
    public boolean e;
    public final Lazy f;
    public float g;
    public ValueAnimator h;
    public final RectF i;
    public final Lazy j;
    public final Lazy k;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ zya.e a;
        public final /* synthetic */ PopupMenuItemGrid b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PopupMenuMainContent d;

        public a(zya.e r1, PopupMenuItemGrid r2, boolean r3, PopupMenuMainContent r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (g.a(this.a, this.b, this.c) == false) goto L10;
            com.ss.android.lark.chat.message.menu.v2.popup.d r5 = this.d.getMenuContext();
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
        public final /* synthetic */ zya.e a;
        public final /* synthetic */ PopupMenuItem b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PopupMenuMainContent d;

        public b(zya.e r1, PopupMenuItem r2, boolean r3, PopupMenuMainContent r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (g.a(this.a, this.b, this.c) == false) goto L10;
            com.ss.android.lark.chat.message.menu.v2.popup.d r5 = this.d.getMenuContext();
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

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ zya.e a;
        public final /* synthetic */ PopupMenuItem b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ List<zya.b> d;
        public final /* synthetic */ PopupMenuMainContent e;
        public final /* synthetic */ com.ss.android.lark.chat.message.menu.d f;

        public c(zya.e r1, PopupMenuItem r2, boolean r3, List<zya.b> r4, PopupMenuMainContent r5, com.ss.android.lark.chat.message.menu.d r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            if (g.a(this.a, this.b, this.c) == false) goto L31;
            boolean r0 = false;
            if (this.c == false) goto L25;
            List r1 = CollectionsKt.mutableListOf(new zya.b[]{this.a});
            r1.addAll(this.d);
            com.ss.android.lark.chat.message.menu.v2.popup.d r2 = this.e.getMenuContext();
            if (r2 == null) goto L32;
            com.ss.android.lark.chat.message.menu.v2.popup.a r3 = r2.a();
            if (r3 == null) goto L33;
            PopupMenuItem r4 = this.b;
            if (this.f.c == false) goto L23;
            com.ss.android.lark.chat.message.menu.v2.popup.d r5 = this.e.getMenuContext();
            if (r5 == null) goto L21;
            yya.a r7 = r5.a;
            if (r7 == null) goto L21;
            v5b.c r8 = r7.m();
            if (r8 == null) goto L21;
            if (r8.h() != true) goto L21;
            boolean r9 = true;
        L22:
            if (r9 == true) goto L23;
        L24:
            r3.b(r1, r4, r0);
            return;
        L21:
            r9 = false;
        L23:
            r0 = true;
            goto L24
        L33:
            return;
        L32:
            return;
        L25:
            com.ss.android.lark.chat.message.menu.v2.popup.d r10 = this.e.getMenuContext();
            if (r10 == null) goto L35;
            com.ss.android.lark.chat.message.menu.v2.popup.a r11 = r10.a();
            if (r11 == null) goto L36;
            i0.a(r11, false, null, 7);
            return;
        L36:
            return;
        L35:
            return;
        }
    }

    public static final class d implements o0 {
        public final /* synthetic */ PopupMenuMainContent a;

        public d(PopupMenuMainContent r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.message.menu.v2.o0
        public final void a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "reactionKey");
            o0 r0 = this.a.getOnReactionClickListener();
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            return;
        }
    }

    public PopupMenuMainContent(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PopupMenuMainContent(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Paint getMaskPaint() {
        return (Paint) this.f.getValue();
    }

    private final LKUIRoundLinearLayout getMenuContainer() {
        return (LKUIRoundLinearLayout) this.k.getValue();
    }

    private final LKUIRoundableLayout getReactionContainer() {
        return (LKUIRoundableLayout) this.j.getValue();
    }

    public final com.ss.android.lark.chat.message.menu.v2.popup.d getMenuContext() {
        return this.c;
    }

    public final o0 getOnReactionClickListener() {
        return this.d;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public PanelType getPanelType() {
        return this.a;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.IPopupMenuContent
    public IPopupMenuContent.ShadowTarget getShadowTarget() {
        return this.b;
    }

    private final void setMenuItems(com.ss.android.lark.chat.message.menu.d r21) {
        Context r0 = getContext();
        com.ss.android.lark.chat.message.menu.v2.popup.d r1 = this.c;
        if (r1 == null) goto L9;
        com.ss.android.lark.biz.im.api.message.params.m r2 = r1.c;
        if (r2 == null) goto L9;
        Integer r3 = r2.f;
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        int r15 = UIUtils.getColor(r0, r4);
        getMenuContainer().removeAllViews();
        Iterator<T> r16 = r21.a.iterator();
    L12:
        if (r16.hasNext() == false) goto L102;
        zya.b r5 = (zya.e) r16.next();
        if ((r5 instanceof zya.h) == false) goto L25;
        Context r9 = getContext();
        com.ss.android.lark.chat.message.menu.v2.popup.d r6 = this.c;
        if (r6 == null) goto L22;
        com.ss.android.lark.biz.im.api.message.params.m r7 = r6.c;
        if (r7 == null) goto L22;
        Integer r8 = r7.c;
        if (r8 == null) goto L22;
        int r12 = r8.intValue();
    L23:
        getMenuContainer().addView(new h(r9, false, 8.0f, r12, 0.0f));
    L22:
        r12 = 2131108899;
        goto L23
    L25:
        if ((r5 instanceof zya.b) == false) goto L12;
        zya.b r10 = r5;
        boolean r11 = g.b(r10);
        Integer r13 = null;
        if (r10.h != 5) goto L58;
        int r14 = WindowFreezeMonitor.a;
        if (WindowFreezeMonitor.a(getMenuContainer()) == false) goto L31;
    L34:
        PopupMenuGridContainer r17 = new PopupMenuGridContainer(getContext(), null, 6, 0);
        r17.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        getMenuContainer().addView(r17);
    L35:
        PopupMenuItemGrid r18 = new PopupMenuItemGrid(getContext(), null, 6, 0);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-1, -2);
        r19.weight = 1.0f;
        r18.setLayoutParams(r19);
        r18.setIcon(r10.b);
        r18.setText(r10.e);
        Context r20 = getContext();
        int r110 = UIUtils.getColor(getContext(), 2131102416);
        com.ss.android.lark.chat.message.menu.v2.popup.d r22 = this.c;
        if (r22 == null) goto L41;
        com.ss.android.lark.biz.im.api.message.params.m r23 = r22.c;
        if (r23 == null) goto L41;
        r13 = r23.g;
    L41:
        boolean r24 = false;
        g.c(r18, r20, r10, r15, r110, r13, r11);
        if (r11 == true) goto L44;
        r18.setAlpha(0.5f);
    L44:
        r18.setOnClickListener(new a(r5, r18, r11, this));
        if (r17.getChildCount() == 0) goto L47;
        r24 = true;
    L47:
        if (r24 == false) goto L57;
        Context r25 = getContext();
        com.ss.android.lark.chat.message.menu.v2.popup.d r26 = this.c;
        if (r26 == null) goto L55;
        com.ss.android.lark.biz.im.api.message.params.m r27 = r26.c;
        if (r27 == null) goto L55;
        Integer r28 = r27.d;
        if (r28 == null) goto L55;
        int r111 = r28.intValue();
    L56:
        r17.addView(new h(r25, true, 0.0f, r111, 20));
    L55:
        r111 = 2131108702;
    L57:
        r17.addView(r18);
        goto L12
    L31:
        if ((getMenuContainer().getChildAt(getMenuContainer().getChildCount() - 1) instanceof PopupMenuGridContainer) == false) goto L34;
        View r29 = getMenuContainer().getChildAt(getMenuContainer().getChildCount() - 1);
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.v2.popup.PopupMenuGridContainer");
        r17 = (PopupMenuGridContainer) r29;
        goto L35
    L58:
        boolean r30 = false;
        PopupMenuItem r112 = new PopupMenuItem(getContext(), null, 6, 0);
        r112.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r112.setIcon(r10.b);
        r112.setText(r10.e);
        Context r31 = getContext();
        int r113 = UIUtils.getColor(getContext(), 2131102416);
        com.ss.android.lark.chat.message.menu.v2.popup.d r32 = this.c;
        if (r32 == null) goto L63;
        com.ss.android.lark.biz.im.api.message.params.m r33 = r32.c;
        if (r33 == null) goto L63;
        Integer r114 = r33.g;
    L64:
        g.c(r112, r31, r10, r15, r113, r114, r11);
        if (r11 == true) goto L67;
        r112.setAlpha(0.5f);
    L67:
        List r34 = r10.k;
        List r35 = r34;
        if (r35 != null) goto L70;
    L73:
        boolean r115 = true;
    L74:
        boolean r36 = !r115;
        r112.a(r36);
        if (r36 == false) goto L77;
        r112.setArrowTint(r15);
    L77:
        if (r35 != null) goto L79;
    L80:
        r30 = true;
    L81:
        if (r30 == false) goto L83;
        r112.setOnClickListener(new b(r5, r112, r11, this));
        PopupMenuItem r116 = r112;
    L84:
        int r37 = WindowFreezeMonitor.a;
        if (WindowFreezeMonitor.a(getMenuContainer()) == false) goto L87;
        View r117 = null;
    L88:
        if (r117 != null) goto L90;
    L100:
        getMenuContainer().addView(r116);
        goto L12
    L90:
        if ((r117 instanceof h) == true) goto L100;
        LKUIRoundLinearLayout r38 = getMenuContainer();
        Context r39 = getContext();
        com.ss.android.lark.chat.message.menu.v2.popup.d r40 = this.c;
        if (r40 == null) goto L98;
        com.ss.android.lark.biz.im.api.message.params.m r41 = r40.c;
        if (r41 == null) goto L98;
        Integer r42 = r41.d;
        if (r42 == null) goto L98;
        int r43 = r42.intValue();
    L99:
        r38.addView(new h(r39, false, 0.0f, r43, 20));
    L98:
        r43 = 2131108702;
        goto L99
    L87:
        r117 = getMenuContainer().getChildAt(getMenuContainer().getChildCount() - 1);
        goto L88
    L83:
        r116 = r112;
        r116.setOnClickListener(new c(r5, r112, r11, r34, this, r21));
        goto L84
    L79:
        if (r35.isEmpty() == false) goto L81;
    L70:
        if (r35.isEmpty() == true) goto L73;
        r115 = false;
    L63:
        r114 = null;
        goto L64
    L102:
        return;
    L9:
        r4 = 2131102418;
        goto L10
    }

    private final void setReaction(com.ss.android.lark.chat.message.menu.d r7) {
        if (r7.c == false) goto L26;
        com.ss.android.lark.chat.message.menu.v2.popup.d r8 = this.c;
        if (r8 == null) goto L25;
        com.ss.android.lark.chat.message.menu.v2.popup.a r9 = r8.a();
        if (r9 == null) goto L28;
        BuiltInTopEmojiView r0 = new BuiltInTopEmojiView(getContext());
        int r1 = UIUtils.dp2px(getContext(), 28.0f);
        int r2 = UIUtils.dp2px(getContext(), 40.0f);
        int r3 = UIUtils.dp2px(getContext(), 40.0f);
        int r4 = UIUtils.dp2px(getContext(), 0.0f);
        r0.b = r1;
        r0.c = r2;
        r0.d = r3;
        r0.e = r4;
        if (r0.getWidth() <= 0) goto L12;
        r0.a();
    L12:
        d r5 = new d(this);
        Intrinsics.checkNotNullParameter(r9, "control");
        Intrinsics.checkNotNullParameter(r5, "reactionClickListener");
        r0.j = r9;
        r0.k = r5;
        com.ss.android.lark.chat.message.menu.v2.popup.d r10 = this.c;
        if (r10 == null) goto L19;
        yya.a r11 = r10.a;
        if (r11 == null) goto L19;
        v5b.c r12 = r11.m();
        if (r12 == null) goto L19;
        Message.Type r13 = r12.getType();
    L21:
        if (r13 != Message.Type.DOUBAO) goto L23;
        boolean r14 = true;
    L24:
        r0.setLikeInFront(r14);
        ViewGroup.LayoutParams r15 = new ViewGroup.LayoutParams(-1, -2);
        getReactionContainer().removeAllViews();
        getReactionContainer().addView(r0, r15);
        getReactionContainer().setVisibility(0);
        return;
    L23:
        r14 = false;
    L19:
        r13 = null;
        goto L21
    L28:
        return;
    L25:
        return;
    L26:
        getReactionContainer().removeAllViews();
        getReactionContainer().setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.dispatchDraw(r6);
        if (this.e == false) goto L6;
        this.i.set(getMenuContainer().getLeft(), getMenuContainer().getTop(), getMenuContainer().getRight(), getMenuContainer().getBottom());
        getMaskPaint().setAlpha((int) (this.g * 128));
        r6.drawRoundRect(this.i, getMenuContainer().getRadius(), getMenuContainer().getRadius(), getMaskPaint());
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.e == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    public final void setMenuContext(com.ss.android.lark.chat.message.menu.v2.popup.d r5) {
        this.c = r5;
        if (r5 == null) goto L17;
        LKUIRoundLinearLayout r0 = getMenuContainer();
        Context r1 = getContext();
        com.ss.android.lark.biz.im.api.message.params.m r2 = r5.c;
        int r3 = 2131108877;
        if (r2 == null) goto L10;
        Integer r4 = r2.b;
        if (r4 == null) goto L10;
        int r6 = r4.intValue();
    L11:
        r0.setBackgroundColor(UIUtils.getColor(r1, r6));
        LKUIRoundableLayout r7 = getReactionContainer();
        Context r8 = getContext();
        com.ss.android.lark.biz.im.api.message.params.m r9 = r5.c;
        if (r9 == null) goto L16;
        Integer r10 = r9.b;
        if (r10 == null) goto L16;
        r3 = r10.intValue();
    L16:
        r7.setBackgroundColor(UIUtils.getColor(r8, r3));
    L10:
        r6 = 2131108877;
    L17:
        com.ss.android.lark.chat.message.menu.v2.popup.d r11 = this.c;
        if (r11 == null) goto L29;
        com.ss.android.lark.chat.message.menu.d r12 = r11.b;
        setReaction(r12);
        setMenuItems(r12);
        boolean r13 = r11.a.m().h();
        ViewGroup.LayoutParams r14 = getMenuContainer().getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
        if (r12.c == false) goto L26;
        if (r13 == false) goto L24;
        int r16 = 8388613;
    L25:
        r15.gravity = r16;
    L27:
        getMenuContainer().setLayoutParams(r15);
        return;
    L24:
        r16 = 8388611;
        goto L25
    L26:
        r15.gravity = 1;
        goto L27
    }

    public final void setOnReactionClickListener(o0 r1) {
        this.d = r1;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        int r7 = (int) (((double) getMeasuredWidth()) * 0.7d);
        if (getMenuContainer().getMeasuredWidth() == r7) goto L6;
        getMenuContainer().measure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r6), PluginList.LEVEL_NOT_SET));
        return;
    }

    public PopupMenuMainContent(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = PanelType.ACTION;
        this.b = IPopupMenuContent.ShadowTarget.CHILD;
        this.f = LazyKt.lazy(new PopupMenuMainContent$maskPaint$2(r2, this));
        this.i = new RectF();
        this.j = LazyKt.lazy(new PopupMenuMainContent$reactionContainer$2(r2, this));
        this.k = LazyKt.lazy(new PopupMenuMainContent$menuContainer$2(r2, this));
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        addView(getReactionContainer());
        addView(getMenuContainer());
    }

    public /* synthetic */ PopupMenuMainContent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
