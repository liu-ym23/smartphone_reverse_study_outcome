package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.ActionContextCreator;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.select.SelectableView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContentLongClickListener implements View.OnLongClickListener {
    public final LKUILightTextView a;
    public final c b;
    public final Function0<Boolean> c;
    public com.ss.android.lark.widget.select.m d;
    public Pair<Integer, Integer> e;
    public final Handler f;
    public boolean g;
    public final ScrollView h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Rect r;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a s;
    public PopupWindow t;
    public final Lazy u;
    public final LKUILightTextView v;
    public final b w;
    public final Lazy x;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ContentLongClickListener a;

        public b(ContentLongClickListener r1) {
            this.a = r1;
        }

        public final void a() {
            ContentLongClickListener r0 = this.a;
            if (r0.g == false) goto L27;
            boolean r1 = false;
            r0.g = false;
            com.ss.android.lark.widget.select.m r2 = r0.d;
            if (r2 != null) goto L7;
            return;
        L7:
            com.ss.android.lark.widget.select.g r3 = r2.c();
            if (r3 != null) goto L10;
            return;
        L10:
            Rect r4 = new Rect();
            this.a.a.getGlobalVisibleRect(r4);
            int r5 = r3.b;
            int r6 = r4.top;
            if (r5 >= r6) goto L13;
        L16:
            boolean r7 = true;
        L17:
            int r8 = r3.c;
            if (r8 >= r6) goto L20;
        L21:
            r1 = true;
        L22:
            com.ss.android.lark.widget.select.m r9 = this.a.d;
            if (r9 == null) goto L25;
            r9.m(!r7, !r1);
        L25:
            ContentLongClickListener r10 = this.a;
            LKUILightTextView r11 = r10.a;
            PopupWindow r12 = r10.t;
            ((Number) ((Pair) r10.u.getValue()).getFirst()).intValue();
            ((Number) ((Pair) this.a.u.getValue()).getSecond()).intValue();
            ContentLongClickListener.a(r10, r3, r11, r12);
            return;
        L20:
            if (r8 <= r4.bottom) goto L22;
        L13:
            if (r5 > r4.bottom) goto L16;
            r7 = false;
            goto L17
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        this.l = true;
        c(this.t);
        com.ss.android.lark.widget.select.m r0 = this.d;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        this.d = null;
        this.t = null;
    }

    public final void d() {
        com.ss.android.lark.widget.select.m r0 = this.d;
        if (r0 == null) goto L6;
        UICallbackExecutor.post(new f(r0, this));
    L6:
        c(this.t);
    }

    public static void c(PopupWindow r2) {
        if (r2 == null) goto L6;
        boolean r1 = true;
        if (r2.isShowing() != true) goto L6;
    L7:
        if (r1 == false) goto L10;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
        return;
    L10:
        return;
    L6:
        r1 = false;
        goto L7
    }

    public final void e(ActionContextCreator r3) {
        Intrinsics.checkNotNullParameter(r3, "actionContextCreator");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a r0 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a();
        f4b.d r4 = r3.a(this.a);
        if (r4 != null) goto L5;
        Log.e("FullActionPanelManager", "setup actionManager failed, actionContext is null");
    L6:
        r0.b = new ContentLongClickListener$updatePanelContext$1$1(this);
        this.s = r0;
        return;
    L5:
        r0.a = r4;
        goto L6
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r13) {
        com.ss.android.lark.widget.select.m r14 = this.d;
        if (r14 == null) goto L5;
        r14.a();
    L5:
        LKUILightTextView r15 = this.v;
        com.ss.android.lark.widget.select.c r0 = null;
        if (r15 == null) goto L8;
        SelectableView.State r16 = r15.getState();
    L10:
        if (r16 != SelectableView.State.SELECTED) goto L12;
        this.c.invoke();
    L12:
        int r17 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.d.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.selection.scrolling") == false) goto L19;
        final ScrollView r18 = this.h;
        if (r18 == null) goto L19;
        r0 = new com.ss.android.lark.widget.select.c(this.b.getContext(), r18, new ContentLongClickListener$createAutoScrollStrategy$1(r18, this), new ContentLongClickListener$createAutoScrollStrategy$2(this));
    L19:
        com.ss.android.lark.widget.select.m.a r19 = new com.ss.android.lark.widget.select.m.a(new com.ss.android.lark.widget.select.b(this.a), ContextsKt.requireActivity(this.a));
        r19.c = UIUtils.getColor(this.b.getContext(), 2131105548);
        r19.d = ((Number) this.x.getValue()).intValue();
        if (r0 == null) goto L22;
        r19.e = r0;
    L22:
        com.ss.android.lark.widget.select.m r1 = new com.ss.android.lark.widget.select.m(r19);
        r1.m = new j(this);
        r1.n = new k(this, r0, r1);
        r1.b();
        LKUILightTextView r110 = this.a;
        int r2 = ((Number) this.e.getFirst()).intValue();
        int r3 = ((Number) this.e.getSecond()).intValue();
        if ((r3 - r2) < 2) goto L25;
        Pair r111 = TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r3));
    L55:
        r1.l(((Number) r111.component1()).intValue(), ((Number) r111.component2()).intValue());
        this.d = r1;
        return true;
    L25:
        Layout r112 = r110.getLayout();
        if (r112 != null) goto L29;
        r111 = TuplesKt.to(-1, -1);
        goto L55
    L29:
        if (r2 == r3) goto L31;
    L39:
        int r4 = r112.getLineForOffset(r2);
        if (r112.getLineForOffset(r2) != (r112.getLineForOffset(r2 - 1) + 1)) goto L42;
        boolean r6 = true;
    L43:
        if (r6 == false) goto L45;
        r4 = Math.max(r4 - 1, 0);
    L45:
        int r5 = r2 + 2;
        int r7 = r112.getLineEnd(r4);
        if (r6 == false) goto L49;
        r111 = TuplesKt.to(Integer.valueOf(r7 - 1), Integer.valueOf(Math.min(r5 - 1, r112.getText().length())));
        goto L55
    L49:
        if (r5 < r112.getText().length()) goto L52;
        r111 = TuplesKt.to(Integer.valueOf(r112.getText().length() - 2), Integer.valueOf(r112.getText().length()));
        goto L55
    L52:
        if (r4 == r112.getLineForOffset(r5)) goto L54;
        r111 = TuplesKt.to(Integer.valueOf(r7 - 2), Integer.valueOf(r7));
        goto L55
    L54:
        r111 = TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r5));
        goto L55
    L42:
        r6 = false;
        goto L43
    L31:
        if ((r112.getText() instanceof Spanned) == false) goto L39;
        CharSequence r8 = r112.getText();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.text.Spanned");
        Spanned r9 = (Spanned) r8;
        Object[] r10 = r9.getSpans(0, r9.length(), ReplacementSpan.class);
        int r11 = r10.length;
        int r12 = 0;
    L33:
        if (r12 >= r11) goto L39;
        ReplacementSpan r113 = (ReplacementSpan) r10[r12];
        int r114 = r9.getSpanStart(r113);
        int r115 = r9.getSpanEnd(r113);
        if (r114 > r2) goto L38;
        if (r115 < r3) goto L38;
        r111 = TuplesKt.to(Integer.valueOf(r114), Integer.valueOf(r115));
    L38:
        r12 = r12 + 1;
        goto L33
    L8:
        r16 = null;
        goto L10
    }

    public /* synthetic */ ContentLongClickListener(LKUILightTextView r2, c r3, ActionContextCreator r4) {
        this(r2, r3, r4, AnonymousClass1.INSTANCE);
    }

    public ContentLongClickListener(LKUILightTextView r3, c r4, ActionContextCreator r5, Function0<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r3, "contentTv");
        Intrinsics.checkNotNullParameter(r4, "clickContext");
        Intrinsics.checkNotNullParameter(r6, "dismissCoordinator");
        this.a = r3;
        this.b = r4;
        this.c = r6;
        this.e = TuplesKt.to(Integer.MAX_VALUE, Integer.valueOf(PluginList.LEVEL_NOT_SET));
        this.f = new Handler(Looper.getMainLooper());
        this.j = true;
        this.m = LazyKt.lazy(ContentLongClickListener$partialSelectBottomOffset$2.INSTANCE);
        this.n = LazyKt.lazy(ContentLongClickListener$partialSelectTopOffset$2.INSTANCE);
        this.o = LazyKt.lazy(ContentLongClickListener$partialSelectTopShadowSize$2.INSTANCE);
        this.p = LazyKt.lazy(ContentLongClickListener$partialSelectBottomShadowSize$2.INSTANCE);
        this.q = LazyKt.lazy(ContentLongClickListener$menuShowMarginHorizontal$2.INSTANCE);
        this.r = new Rect();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a r7 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a();
        LKUILightTextView r0 = null;
        if (r5 == null) goto L5;
        f4b.d r8 = r5.a(r3);
    L6:
        if (r8 != null) goto L8;
        Log.e("FullActionPanelManager", "setup actionManager failed, actionContext is null");
    L9:
        r7.b = new ContentLongClickListener$panelManager$1$1(this);
        this.s = r7;
        LazyThreadSafetyMode r9 = LazyThreadSafetyMode.NONE;
        this.u = LazyKt.lazy(r9, new ContentLongClickListener$menuShowMargins$2(this));
        this.w = new b(this);
        this.x = LazyKt.lazy(r9, new ContentLongClickListener$cursorHandleSize$2(this));
        ViewParent r10 = r3.getParent().getParent();
        if ((r10 instanceof ScrollView) == false) goto L12;
        ScrollView r11 = (ScrollView) r10;
    L13:
        this.h = r11;
        if (r11 == null) goto L16;
        LKUILightTextView r12 = (LKUILightTextView) r11.findViewById(2131391649);
    L17:
        if (r11 == null) goto L20;
        r0 = (LKUILightTextView) r11.findViewById(2131390392);
    L20:
        if (Intrinsics.areEqual(r0, r3) == true) goto L23;
        r12 = r0;
    L23:
        this.v = r12;
        r3.setOnTouchListener(new g(this, new GestureDetector(r4.getContext(), new i(this))));
        if (r11 == null) goto L29;
        ViewTreeObserver r13 = r11.getViewTreeObserver();
        if (r13 == null) goto L30;
        r13.addOnScrollChangedListener(new h(this));
        return;
    L30:
        return;
    L29:
        return;
    L16:
        r12 = null;
        goto L17
    L12:
        r11 = null;
        goto L13
    L8:
        r7.a = r8;
        goto L9
    L5:
        r8 = null;
        goto L6
    }

    public static final void a(ContentLongClickListener r12, com.ss.android.lark.widget.select.g r13, LKUILightTextView r14, PopupWindow r15) {
        ScrollView r0 = r12.h;
        if (r0 == null) goto L37;
        if (r15 == null) goto L38;
        c(r15);
        Rect r1 = new Rect();
        r0.getGlobalVisibleRect(r1);
        View r2 = r15.getContentView();
        r2.measure(0, 0);
        Pair r3 = TuplesKt.to(Integer.valueOf(r2.getMeasuredWidth()), Integer.valueOf(r2.getMeasuredHeight()));
        int r4 = ((Number) r3.component1()).intValue();
        int r5 = ((Number) r3.component2()).intValue();
        int[] r6 = new int[2];
        r14.getLocationOnScreen(r6);
        if (r13.f == false) goto L10;
        int r7 = r6[0] + ((r13.e + r13.d) / 2);
        int r8 = r4 / 2;
    L11:
        int r9 = r7 - r8;
        int r10 = Math.min(Math.max(r1.left + ((Number) r12.q.getValue()).intValue(), r9), (r1.right - r4) - ((Number) r12.q.getValue()).intValue());
        if (r13.c >= (r0.getHeight() - r5)) goto L14;
        int r16 = r13.c + ((Number) r12.m.getValue()).intValue();
        int r17 = ((Number) r12.o.getValue()).intValue();
    L23:
        int r11 = r16 - r17;
    L26:
        if (PopupWindowLancet.hasSubWindowToken(r14) == false) goto L29;
        return;
    L29:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r15) == false) goto L31;
        r15.showAtLocation(r14, 8388659, r10, r11);
        return;
    L31:
        OverlaySource r18 = PopupWindowLancet.resolveSource(r14);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r15, r14, r18, 8388659, r10, r11) == true) goto L40;
        r15.showAtLocation(r14, 8388659, r10, r11);
        PopupWindowLancet.trackAfterShow(r15, r18, r14);
        return;
    L40:
        return;
    L14:
        int r19 = r13.b;
        if (r19 <= r5) goto L18;
        r11 = ((r19 - r5) + ((Number) r12.p.getValue()).intValue()) - ((Number) r12.n.getValue()).intValue();
        goto L26
    L18:
        if (r13.c >= r0.getHeight()) goto L20;
        r16 = (r13.c - r5) + ((Number) r12.p.getValue()).intValue();
        r17 = ((Number) r12.n.getValue()).intValue();
        goto L23
    L20:
        int r110 = r13.b;
        if (r110 <= 0) goto L24;
        r16 = r110 + ((Number) r12.m.getValue()).intValue();
        r17 = ((Number) r12.o.getValue()).intValue();
        goto L23
    L24:
        r11 = (r0.getHeight() / 2) - (r5 / 2);
        goto L26
    L10:
        r7 = r1.centerX();
        r8 = r4 / 2;
        goto L11
    L38:
        return;
    }
}
