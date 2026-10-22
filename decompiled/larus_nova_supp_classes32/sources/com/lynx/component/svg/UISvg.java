package com.lynx.component.svg;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.serval.svg.SVGRender;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.ILynxUIMeaningfulContent$MeaningfulContentStatus;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.UIThreadUtils;
import java.nio.charset.Charset;
import java.util.Map;
import x5a.i;
import x5a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(fragmentLayerRendererHost = x5a.d.class, isCreateAsync = true, supportFragmentLayerRender = true, tagName = {SVGRenderEngine.SVG, "x-svg"})
@LynxGeneratorName(packageName = "com.lynx.component.svg")
public class UISvg extends LynxUI<SvgImageView> {
    public static final /* synthetic */ int l = 0;
    public String a;
    public volatile String b;
    public volatile String c;
    public final com.lynx.component.svg.d d;
    public volatile com.lynx.component.svg.parser.c e;
    public volatile SVG f;
    public boolean g;
    public volatile boolean h;
    public volatile boolean i;
    public volatile SVGRender j;
    public volatile boolean k;

    public class a implements Runnable {
        public final /* synthetic */ UISvg a;

        public final void a() {
            if (this.a.f != null) goto L5;
            return;
        L5:
            x5a.e r0 = new x5a.e(this.a.f, this.a.e, this.a.d);
            ((SvgImageView) UISvg.P(this.a)).setImageDrawable(r0);
            this.a.invalidate();
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

        public a(UISvg r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ UISvg a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(UISvg r1) {
            this.a = r1;
        }
    }

    public class c implements com.lynx.component.svg.d.c {
        public final /* synthetic */ UISvg a;

        @Override // com.lynx.component.svg.d.InterfaceC0046d
        public final void onStart() {
        }

        @Override // com.lynx.component.svg.d.InterfaceC0046d
        public final void onSuccess() {
        }

        public c(UISvg r1) {
            this.a = r1;
        }

        @Override // com.lynx.component.svg.d.InterfaceC0046d
        public final void onError(String r3) {
            LLog.e("lynx_UISvg", "requestSrc error! the src is " + this.a.a + " error message is" + r3);
        }

        @Override // com.lynx.component.svg.d.c
        public final void a(String r3, SVG r4) {
            UISvg r0 = this.a;
            if (r0.g == false) goto L6;
            r0.b = r3;
            this.a.U(r3, true);
            return;
        L6:
            if (LynxEnv.inst().enableSvgAsync() == false) goto L8;
            LynxThreadPool.e().execute(new x5a.h(r0, r4));
            return;
        L8:
            UIThreadUtils.runOnUiThread(new j(r0, r4));
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ UISvg a;

        public final void a() {
            SVG r0 = SVG.c(this.a.b);     // Catch: SVGParseException -> L10
            UISvg r1 = this.a;     // Catch: SVGParseException -> L10
            r1.getClass();     // Catch: SVGParseException -> L10
            if (LynxEnv.inst().enableSvgAsync() == false) goto L8;
            r1.f = r0;     // Catch: SVGParseException -> L10
            if (r1.f == null) goto L13;
            UIThreadUtils.runOnUiThread(new i(r1, new x5a.e(r0, r1.e, r1.d), r0));     // Catch: SVGParseException -> L10
        L13:
            return;
        L8:
            UIThreadUtils.runOnUiThread(new j(r1, r0));     // Catch: SVGParseException -> L10
        L10:
            e = move-exception;
            LLog.e("lynx_UISvg", "onPropsUpdated():  the content is:" + this.a.b + "the error message is " + e.toString());
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

        public d(UISvg r1) {
            this.a = r1;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ UISvg c;

        public class a implements Runnable {
            public final /* synthetic */ j6a.a a;
            public final /* synthetic */ e b;

            @Override // java.lang.Runnable
            public final void run() {
                ((SvgImageView) UISvg.N(this.b.c)).setImageDrawable(this.a);     // Catch: Throwable -> L6
                this.b.c.invalidate();     // Catch: Throwable -> L6
                e r0 = this.b;     // Catch: Throwable -> L6
                if (r0.b == false) goto L9;
                UISvg.R(r0.c, null);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public a(e r1, j6a.a r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public final void a() {
        L6:
            e = move-exception;
            LLog.e("lynx_UISvg", "setDrawable: the content: " + this.c.b + ", the error message: " + e.getMessage());
            return;
        L3:
            if (this.c.j == null) goto L11;
            this.c.j.setColor(this.c.c);     // Catch: Exception -> L6
            UIThreadUtils.runOnUiThread(new a(this, new j6a.a(this.c.j.renderPicture(this.a, new Rect(0, 0, this.c.getWidth(), this.c.getHeight())))));     // Catch: Exception -> L6
            return;
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

        public e(UISvg r1, String r2, boolean r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ UISvg a;

        public class a implements Runnable {
            public final /* synthetic */ PictureDrawable a;
            public final /* synthetic */ f b;

            @Override // java.lang.Runnable
            public final void run() {
                ((SvgImageView) UISvg.O(this.b.a)).setImageDrawable(this.a);     // Catch: Throwable -> L4
                this.b.a.invalidate();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(f r1, x5a.e r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.a.f == null) goto L10;
            UIThreadUtils.runOnUiThread(new a(this, new x5a.e(this.a.f, this.a.e, this.a.d)));     // Catch: Throwable -> L7
            return;
        }

        public f(UISvg r1) {
            this.a = r1;
        }
    }

    public UISvg() {
        throw null;
    }

    public final void S() {
        if (this.g == false) goto L7;
        U(this.b, false);
        return;
    L7:
        if (LynxEnv.inst().enableSvgAsync() == false) goto L9;
        LynxThreadPool.e().execute(new f(this));
        return;
    L9:
        UIThreadUtils.runOnUiThread(new a(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        if (this.f == null) goto L7;
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
    L7:
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    }

    public final void T() {
        if (LynxEnv.inst().enableSvgAsync() == false) goto L5;
        LynxThreadPool.e().execute(new b(this));
        return;
    L5:
        this.d.a();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        this.k = true;
        this.j = null;
        T();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        T();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        com.lynx.component.svg.parser.c r0 = this.e;
        float r1 = getWidth();
        float r2 = getHeight();
        r0.getClass();
        r0.a = new SVG.b(0.0f, 0.0f, r1, r2);
        if (this.g == false) goto L6;
        this.h = true;
        return;
    L6:
        if (this.f == null) goto L10;
        S();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        if (this.g == true) goto L5;
        return;
    L5:
        if (this.h == false) goto L12;
        this.h = false;
        if (TextUtils.isEmpty(this.b) == false) goto L9;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L9:
        U(this.b, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        boolean r2 = false;
        if (this.i == false) goto L21;
        this.i = false;
        if (this.a.startsWith("data:image/svg+xml;base64") == false) goto L16;
        String r3 = new String(Base64.decode(this.a.substring(26).getBytes(Charset.defaultCharset()), 0), Charset.defaultCharset());
        r2 = true;
        if (TextUtils.isEmpty(r3) == false) goto L10;
        ((SvgImageView) this.mView).setImageDrawable(null);
        this.b = null;
        goto L16
    L10:
        if (r3.equals(this.b) == true) goto L16;
        this.b = r3;
        if (this.g == false) goto L15;
        U(this.b, true);
        goto L16
    L15:
        LynxThreadPool.e().execute(new x5a.g(this));
    L16:
        if (r2 == false) goto L18;
        return;
    L18:
        this.d.c(this.a, new c(this));
        return;
    L21:
        if (this.g == false) goto L23;
        return;
    L23:
        if (TextUtils.isEmpty(this.b) == false) goto L29;
        if (TextUtils.isEmpty(this.a) == false) goto L29;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L29:
        if (this.h == false) goto L33;
        this.h = false;
        LynxThreadPool.e().execute(new d(this));
        return;
    }

    public static /* synthetic */ View M(UISvg r0) {
        return r0.mView;
    }

    public static /* synthetic */ View N(UISvg r0) {
        return r0.mView;
    }

    public static /* synthetic */ View O(UISvg r0) {
        return r0.mView;
    }

    public static /* synthetic */ View P(UISvg r0) {
        return r0.mView;
    }

    public static /* synthetic */ View Q(UISvg r0) {
        return r0.mView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        return new SvgImageView(r2);
    }

    @LynxProp(name = "current-color")
    public void setColor(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        String r3 = null;
    L7:
        if (TextUtils.equals(r3, this.c) == false) goto L9;
        return;
    L9:
        this.c = r3;
        if (this.g == false) goto L13;
        this.h = true;
        return;
    L13:
        return;
    L5:
        r3 = r2.trim();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = LynxAccessibilityModule.MSG_CONTENT)
    public void setContent(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        ((SvgImageView) this.mView).setImageDrawable(null);
        this.b = null;
        return;
    L7:
        if (r2.equals(this.b) == false) goto L9;
        return;
    L9:
        this.b = r2;
        this.h = true;
    }

    @LynxProp(defaultBoolean = false, name = "enable-serval-svg")
    public void setEnableServalSvg(boolean r2) {
        this.g = r2;
        if (r2 == true) goto L5;
        return;
    L5:
        if (this.j != null) goto L9;
        LynxThreadPool.e().execute(new h(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = LynxError.LYNX_ERROR_KEY_RESOURCE_URL)
    public void setSource(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        this.a = null;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L7:
        if (r2.equals(this.a) == false) goto L9;
        return;
    L9:
        this.a = r2;
        this.i = true;
    }

    public UISvg(LynxContext r3, Object r4) {
        super(r3, r4);
        this.g = false;
        this.h = false;
        this.i = false;
        this.k = false;
        this.e = new com.lynx.component.svg.parser.c(r3.getUIBody().getFontSize(), getFontSize());
        this.d = new com.lynx.component.svg.d(r3, this);
    }

    public static void R(UISvg r4, SVG r5) {
        Map<String, EventsListener> r0 = r4.mEvents;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.containsKey("load") == false) goto L24;
        m7a.a r1 = new m7a.a(r4.getSign(), "load");
        if (r5 != null) goto L10;
        float r2 = r4.getHeight();
    L12:
        r1.a("height", Float.valueOf(r2));
        if (r5 != null) goto L16;
        float r6 = r4.getWidth();
    L18:
        r1.a("width", Float.valueOf(r6));
        r4.getLynxContext().getEventEmitter().sendCustomEvent(r1);
        return;
    L16:
        if (r5.a == null) goto L20;
        r6 = r5.a().c;
        goto L18
    L20:
        throw new IllegalArgumentException("SVG document is empty");
    L10:
        if (r5.a == null) goto L22;
        r2 = r5.a().d;
        goto L12
    L22:
        throw new IllegalArgumentException("SVG document is empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U(String r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L6:
        LynxThreadPool.e().execute(new e(this, r3, r4));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, Rect r13) {
        super.updateLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        com.lynx.component.svg.parser.c r14 = this.e;
        float r15 = getWidth();
        float r16 = getHeight();
        r14.getClass();
        r14.a = new SVG.b(0.0f, 0.0f, r15, r16);
        if (this.f != null) goto L5;
        return;
    L5:
        if (this.g == true) goto L9;
        S();
        return;
    }
}
