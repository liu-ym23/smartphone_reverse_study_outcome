package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public g a;
    public PositionAlign b;
    public int c;
    public float d;
    public boolean e;
    public InterfaceC0041c f;
    public b g;
    public WeakReference<PopupWindow> h;
    public WeakReference<View> i;
    public WeakReference<View> j;
    public boolean k;
    public final h l;

    public static final class a {
    }

    public interface b {
        void onDismiss();
    }

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.menu.c$c, reason: collision with other inner class name */
    public interface InterfaceC0041c {
        void a(PopupWindow r1);
    }

    public static abstract class d<T extends d<T>> {
        public PositionAlign a;
        public Integer b;
        public g c;
        public Boolean d;
        public InterfaceC0041c e;
        public b f;
        public boolean g;

        public d() {
        }

        public final c a() {
            c r0 = new c();
            g r1 = this.c;
            if (r1 == null) goto L5;
            Intrinsics.checkNotNullParameter(r1, "viewCreator");
            r0.a = r1;
        L5:
            PositionAlign r2 = this.a;
            if (r2 == null) goto L8;
            Intrinsics.checkNotNullParameter(r2, "align");
            r0.b = r2;
        L8:
            Integer r3 = this.b;
            if (r3 == null) goto L11;
            r0.c = r3.intValue();
        L11:
            Boolean r4 = this.d;
            if (r4 == null) goto L14;
            r0.e = r4.booleanValue();
        L14:
            InterfaceC0041c r5 = this.e;
            if (r5 == null) goto L17;
            Intrinsics.checkNotNullParameter(r5, "listener");
            r0.f = r5;
        L17:
            b r6 = this.f;
            if (r6 == null) goto L20;
            Intrinsics.checkNotNullParameter(r6, "listener");
            r0.g = r6;
        L20:
            r0.k = this.g;
            return r0;
        }

        public final void e() {
            this.d = Boolean.TRUE;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        }

        public final void b(PositionAlign r2) {
            Intrinsics.checkNotNullParameter(r2, "align");
            this.a = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        }

        public final void c(int r1) {
            this.b = Integer.valueOf(r1);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        }

        public final void d(b r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.f = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.universe_design.menu.UDMenu.UDMenuBuilder");
        }
    }

    public static final class e extends d<e> {
        public UDDimension h;
        public UDDimension i;
        public UDDimension j;
        public UDDimension k;

        public e() {
            this.h = new UDDimension.Dp(16.0f);
            this.i = new UDDimension.Dp(16.0f);
            this.j = new UDDimension.Dp(16.0f);
            this.k = new UDDimension.Dp(16.0f);
        }

        public final void f(View r2) {
            Intrinsics.checkNotNullParameter(r2, "customView");
            this.c = new com.larksuite.component.universe_design.menu.d(r2, this);
        }

        public final void g(UDDimension.Dp r2, UDDimension.Dp r3, UDDimension.Dp r4, UDDimension.Dp r5) {
            Intrinsics.checkNotNullParameter(r2, "leftPadding");
            Intrinsics.checkNotNullParameter(r3, "topPadding");
            Intrinsics.checkNotNullParameter(r4, "rightPadding");
            Intrinsics.checkNotNullParameter(r5, "bottomPadding");
            this.h = r2;
            this.i = r3;
            this.j = r4;
            this.k = r5;
        }
    }

    public static final class f extends d<f> {
        public final List<Integer> h;

        public f() {
            this.g = true;
            this.h = new ArrayList();
        }

        public final void f(List r2) {
            Intrinsics.checkNotNullParameter(r2, "menuItems");
            this.c = new com.larksuite.component.universe_design.menu.e(r2, this);
        }
    }

    public interface g {
        ViewGroup create(Context r1);
    }

    public static final class h implements View.OnLayoutChangeListener {
        public final /* synthetic */ c a;

        public h(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
            c r11 = this.a;
            WeakReference<View> r12 = r11.j;
            if (r12 == null) goto L37;
            View r13 = r12.get();
            if (r13 == null) goto L42;
            WeakReference<View> r14 = r11.i;
            if (r14 == null) goto L38;
            View r15 = r14.get();
            if (r15 == null) goto L43;
            WeakReference<PopupWindow> r16 = r11.h;
            if (r16 == null) goto L39;
            PopupWindow r17 = r16.get();
            if (r17 != null) goto L17;
            return;
        L17:
            if (r17.isShowing() == false) goto L44;
            RectF r19 = com.larksuite.component.universe_design.menu.a.a(new com.larksuite.component.universe_design.menu.b(r13, r15, r11.c, r11.b, h18.d.a(r15.getContext(), r11.d)));
            if (r19 == null) goto L45;
            int r20 = (int) r19.left;
            Context r21 = r15.getContext();
            int r22 = 0;
            if (r11.k == false) goto L25;
            int r23 = -((int) new UDDimension.Dp(16).toPixels(r21));
        L26:
            int r24 = r20 + r23;
            int r25 = (int) r19.top;
            Context r26 = r15.getContext();
            if (r11.k == false) goto L29;
            r22 = -((int) new UDDimension.Dp(10).toPixels(r26));
        L29:
            int r27 = r25 + r22;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r17) == false) goto L33;
            r17.update(r24, r27, -1, -1);
            return;
        L33:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r17, r24, r27, -1, -1) == true) goto L46;
            r17.update(r24, r27, -1, -1);
            return;
        L46:
            return;
        L25:
            r23 = 0;
            goto L26
        L45:
            return;
        L44:
            return;
        L39:
            return;
        L43:
            return;
        L38:
            return;
        L42:
            return;
        }
    }

    public static final class i implements PopupWindow.OnDismissListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ Runnable b;

        public i(c r1, j r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            b r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.onDismiss();
        L5:
            this.b.run();
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ View b;

        public j(c r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L4
            this.b.removeOnLayoutChangeListener(r0.l);     // Catch: Throwable -> L4
            c r1 = this.a;     // Catch: Throwable -> L4
            r1.h = null;     // Catch: Throwable -> L4
            r1.j = null;     // Catch: Throwable -> L4
            r1.i = null;     // Catch: Throwable -> L4
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

    public final void a() {
        WeakReference<PopupWindow> r0 = this.h;
        if (r0 == null) goto L13;
        PopupWindow r1 = r0.get();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isShowing() == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L15;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
        return;
    L15:
        return;
    }

    public c() {
        this.b = PositionAlign.CENTER;
        this.c = 80;
        this.d = 4.0f;
        this.e = true;
        this.l = new h(this);
    }

    public final void b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        c(r2);
    }

    public final boolean c(View r15) {
        WeakReference<PopupWindow> r0 = this.h;
        if (r0 == null) goto L13;
        PopupWindow r1 = r0.get();
        if (r1 == null) goto L13;
        if (r1.isShowing() == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return false;
    L13:
        if (r15.isAttachedToWindow() == true) goto L15;
        r15.addOnAttachStateChangeListener(new com.larksuite.component.universe_design.menu.f(this, r15));
    L15:
        g r2 = this.a;
        if (r2 == null) goto L53;
        ViewGroup r3 = r2.create(r15.getContext());
        if (r3 == null) goto L53;
        RectF r4 = com.larksuite.component.universe_design.menu.a.a(new com.larksuite.component.universe_design.menu.b(r3, r15, this.c, this.b, h18.d.a(r15.getContext(), this.d)));
        if (r4 != null) goto L22;
        return false;
    L22:
        int r5 = (int) r4.left;
        Context r6 = r15.getContext();
        if (this.k == false) goto L25;
        int r7 = -((int) new UDDimension.Dp(16).toPixels(r6));
    L26:
        int r8 = r5 + r7;
        int r9 = (int) r4.top;
        Context r10 = r15.getContext();
        if (this.k == false) goto L29;
        int r11 = -((int) new UDDimension.Dp(10).toPixels(r10));
    L30:
        int r12 = r9 + r11;
        if (this.k == false) goto L33;
        Context r13 = r3.getContext();
        Intrinsics.checkNotNull(r13);
        UDShadowLayout r14 = new UDShadowLayout(r13);
        r14.c(2131953894);
        r14.addView(r3, -1, -1);
        View r16 = r14;
    L34:
        PopupWindow r17 = new PopupWindow(r16, -2, -2);
        r17.setOutsideTouchable(this.e);
        r17.setFocusable(true);
        if (PopupWindowLancet.hasSubWindowToken(r15) == false) goto L38;
    L44:
        j r19 = new j(this, r15);
        if (r17.isShowing() == false) goto L50;
        this.h = new WeakReference(r17);
        this.j = new WeakReference(r3);
        this.i = new WeakReference(r15);
        InterfaceC0041c r110 = this.f;
        if (r110 == null) goto L49;
        r110.a(r17);
    L49:
        r17.setOnDismissListener(new i(this, r19));
        return true;
    L50:
        r19.run();
        return false;
    L38:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r17) == false) goto L40;
        r17.showAtLocation(r15, 8388659, r8, r12);
        goto L44
    L40:
        OverlaySource r111 = PopupWindowLancet.resolveSource(r15);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r17, r15, r111, 8388659, r8, r12) == true) goto L44;
        r17.showAtLocation(r15, 8388659, r8, r12);
        PopupWindowLancet.trackAfterShow(r17, r111, r15);
        goto L44
    L33:
        r16 = r3;
        goto L34
    L29:
        r11 = 0;
        goto L30
    L25:
        r7 = 0;
    L53:
        throw new IllegalArgumentException("viewCreator is null, please set UDMenuViewCreator first.");
    }
}
