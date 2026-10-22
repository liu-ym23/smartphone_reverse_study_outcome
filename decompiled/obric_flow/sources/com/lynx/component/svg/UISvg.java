package com.lynx.component.svg;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.lynx.animax.i;
import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.parser.c0;
import com.lynx.component.svg.parser.d;
import com.lynx.component.svg.parser.n0;
import com.lynx.serval.svg.SVGRender;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.utils.j;
import i4.a;
import java.nio.charset.Charset;
import java.util.Map;
import ko.r;
import lm.b;
import lm.e;
import lm.f;
import lm.g;
import mn.h;
import sj.k;

/* JADX INFO: loaded from: classes2.dex */
public class UISvg extends LynxUI<SvgImageView> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f9723j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f9725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f9726c;
    public volatile d d;
    public volatile n0 e;
    public boolean f;
    public volatile boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile SVGRender f9727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f9728i;

    public UISvg(b0 r5, z r10) {
        super(r5, r10);
        this.f = false;
        this.g = false;
        this.f9728i = false;
        this.d = new d(r5.f10145m.getFontSize(), getFontSize());
        this.f9726c = new a(r5, this);
    }

    public static /* synthetic */ View b(UISvg r5) {
        return r5.mView;
    }

    public static void c(UISvg r5, n0 r10) {
        r5.getClass();
        StringBuilder r11 = new StringBuilder("setDrawable(). threadName:");
        r11.append(Thread.currentThread().getName());
        r11.append(" svg hashCode:");
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        r11.append(r12);
        r11.append(" ui-svg hashCode:");
        r11.append(r5);
        r11.append(" isAsync:");
        r11.append(LynxEnv.inst().enableSvgAsync());
        LynxLog.b(2, "lynx_UISvg", r11.toString());
        if (LynxEnv.inst().enableSvgAsync() == false) goto L10;
        r5.i(r10);
        return;
    L10:
        f r13 = new f(r5, r10, 1);
        j.a().post(r13);
        return;
    L5:
        r12 = -1;
        goto L6
    }

    public static /* synthetic */ View j(UISvg r5) {
        return r5.mView;
    }

    public static void k(UISvg r5, n0 r10) {
        Map<String, on.a> r11 = r5.mEvents;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.containsKey("load") == false) goto L25;
        i r12 = new i(r5.getSign(), "load");
        if (r10 != null) goto L10;
        float r13 = r5.getHeight();
    L12:
        r12.a("height", Float.valueOf(r13));
        if (r10 != null) goto L16;
        float r14 = r5.getWidth();
    L18:
        r12.a("width", Float.valueOf(r14));
        r5.getLynxContext().g.b(r12);
        return;
    L16:
        if (((c0) r10.f9841a) == null) goto L21;
        r14 = r10.c().f9803c;
        goto L18
    L21:
        throw new IllegalArgumentException("SVG document is empty");
    L10:
        if (((c0) r10.f9841a) == null) goto L23;
        r13 = r10.c().d;
        goto L12
    L23:
        throw new IllegalArgumentException("SVG document is empty");
    }

    public static /* synthetic */ View l(UISvg r5) {
        return r5.mView;
    }

    public static /* synthetic */ View m(UISvg r5) {
        return r5.mView;
    }

    public static /* synthetic */ View n(UISvg r5) {
        return r5.mView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new SvgImageView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        this.f9728i = true;
        this.f9727h = null;
        if (LynxEnv.inst().enableSvgAsync() == false) goto L6;
        h.k().execute(new e(this, 1));
        return;
    L6:
        this.f9726c.k();
    }

    public final void i(n0 r10) {
        this.e = r10;
        if (this.e != null) goto L5;
        return;
    L5:
        LynxLog.b(2, "lynx_UISvg", "executeDrawableSyncOnSVGThread(),option:" + this.d.toString() + " svg hashCode:" + r10.hashCode() + " ui-svg hashCode:" + this);
        j.a().post(new com.bytedance.android.anniex.scene.core.i(this, new b(r10, this.d, this.f9726c), r10, 21, false));
    }

    public final void o() {
        if (this.f == false) goto L7;
        String r5 = this.f9725b;
        int r10 = 0;
        h.k().execute(new g(this, r5, r10, false));
        return;
    L7:
        if (LynxEnv.inst().enableSvgAsync() == false) goto L10;
        h.k().execute(new e(this, 5));
        return;
    L10:
        e r11 = new e(this, 0);
        j.a().post(r11);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        LynxLog.b(2, "lynx_UISvg", "onDetach():ui-svg hashCode:" + this);
        if (LynxEnv.inst().enableSvgAsync() == false) goto L6;
        h.k().execute(new e(this, 1));
        return;
    L6:
        this.f9726c.k();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        d r5 = this.d;
        float r10 = getWidth();
        float r11 = getHeight();
        r5.getClass();
        r5.f9799c = new com.lynx.component.svg.parser.e(0.0f, 0.0f, r10, r11);
        if (this.f == false) goto L7;
        this.g = true;
        return;
    L7:
        if (this.e == null) goto L10;
        LynxLog.b(2, "lynx_UISvg", "onLayoutUpdated()");
        o();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        if (this.g == true) goto L5;
        return;
    L5:
        if (this.f == false) goto L9;
        this.g = false;
        String r5 = this.f9725b;
        int r10 = 0;
        h.k().execute(new g(this, r5, r10, true));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.g == false) goto L9;
        this.g = false;
        h.k().execute(new e(this, 3));
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "content")
    public void setContent(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L7;
        ((SvgImageView) this.mView).setImageDrawable(null);
        this.f9725b = null;
        return;
    L7:
        if (r5.equals(this.f9725b) == false) goto L9;
        return;
    L9:
        this.f9725b = r5;
        StringBuilder r10 = com.lynx.tasm.utils.e.b("setContent:", r5, " threadName:");
        r10.append(Thread.currentThread().getName());
        r10.append(" ui-svg hashCode:");
        r10.append(this);
        LynxLog.b(2, "lynx_UISvg", r10.toString());
        this.g = true;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "enable-serval-svg")
    public void setEnableServalSvg(boolean r5) {
        this.f = r5;
        if (r5 == true) goto L5;
        return;
    L5:
        if (this.f9727h != null) goto L9;
        h.k().execute(new e(this, 4));
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "src")
    public void setSource(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        this.f9724a = null;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L7:
        if (r10.equals(this.f9724a) == true) goto L34;
        this.f9724a = r10;
        LynxLog.b(2, "lynx_UISvg", "setSource(). the src:" + this.f9724a + " threadName:" + Thread.currentThread().getName() + " ui-svg hashCode:" + this);
        if (this.f9724a.startsWith("data:image/svg+xml;base64") == false) goto L19;
        String r11 = new String(Base64.decode(this.f9724a.substring(26).getBytes(Charset.defaultCharset()), 0), Charset.defaultCharset());
        if (TextUtils.isEmpty(r11) == false) goto L15;
        ((SvgImageView) this.mView).setImageDrawable(null);
        this.f9725b = null;
        return;
    L15:
        if (r11.equals(this.f9725b) == true) goto L35;
        this.f9725b = r11;
        LynxLog.b(2, "lynx_UISvg", "tryDecodeBase64AndUpdate(): the src is " + this.f9724a + " the content:" + this.f9725b + " threadName:" + Thread.currentThread().getName() + " ui-svg hashCode:" + this);
        h.k().execute(new e(this, 2));
        return;
    L35:
        return;
    L19:
        a r12 = this.f9726c;
        String r5 = this.f9724a;
        k r13 = new k(this, false);
        String r14 = dn.a.J((b0) r12.f17503c, false, r5);
        if (TextUtils.isEmpty(r14) == false) goto L24;
        r13.i("url is empty!");
        return;
    L24:
        if (TextUtils.isEmpty(Uri.parse(r14).getScheme()) == false) goto L27;
        r13.i("scheme is Empty!");
        return;
    L27:
        b0 r15 = (b0) r12.f17503c;
        r15.getClass();
        fo.e r16 = new fo.e(r14);
        wn.h r17 = r15.D;
        if (r17 == null) goto L31;
        r17.i(new r(8, r14, LynxResourceRequest$LynxResourceType.e), new q7.a(12, r13, false, r14));
        return;
    L31:
        mn.i.d().i(r16, new sg.a(r13));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, Rect r111) {
        super.updateLayout(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111);
        d r20 = this.d;
        float r21 = getWidth();
        float r22 = getHeight();
        r20.getClass();
        r20.f9799c = new com.lynx.component.svg.parser.e(0.0f, 0.0f, r21, r22);
        if (this.e != null) goto L5;
        return;
    L5:
        if (this.f == true) goto L9;
        LynxLog.b(2, "lynx_UISvg", "updateLayout() options：" + this.d.toString());
        o();
        return;
    }
}
