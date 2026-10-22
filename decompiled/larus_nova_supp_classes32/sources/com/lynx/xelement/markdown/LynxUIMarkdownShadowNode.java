package com.lynx.xelement.markdown;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.markdown.Markdown;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import o8a.b;
import p8a.d;
import p8a.m;
import p8a.o;
import p8a.q;
import p8a.s;
import p8a.t;
import y6a.a;
import y6a.e;
import y6a.g;
import y6a.j;
import y6a.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIMarkdownShadowNode extends ShadowNode implements e, s, p8a.e {
    public a A;
    public String B;
    public String C;
    public final Looper D;
    public final Handler E;
    public b F;
    public d v;
    public final p8a.a w;
    public final t x;
    public final m y;
    public g z;

    @LynxProp(name = "enable-region-view")
    public void setEnableRegionView(boolean r1) {
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [o8a.b] */
    public final d D() {
        if (this.v != null) goto L11;
        if (this.m == null) goto L11;
        d r0 = new d(this.m, this);
        this.v = r0;
        r0.setResourceLoader(this.x);
        this.v.setEventListener(this.y);
        this.v.disableInternalVSync(true);
        if (this.D == null) goto L9;
        this.F = new b(this);
        Choreographer.getInstance().postFrameCallback(this.F);
    L9:
        p8a.a r1 = this.w;
        r1.a = this.v;
    L11:
        return this.v;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final Object m() {
        p8a.a r0 = this.w;
        r0.a = this.v;
        return r0;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void q() {
        if (this.D == null) goto L11;
        Looper r0 = Looper.myLooper();
        Looper r1 = this.D;
        if (r0 == r1) goto L11;
        Runnable r2 = new o8a.a(this);
        if (r1 == null) goto L10;
        this.E.post(r2);
        return;
    L10:
        UIThreadUtils.runOnUiThreadImmediately(r2);
        return;
    L11:
        super.q();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void t() {
        t r0 = this.x;
        Iterator<q> r1 = r0.b.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        final q r2 = r1.next();
        r2.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new o(r2));
        goto L4
    L6:
        r0.b.clear();
        r0.c.clear();
        this.z = null;
        this.A = null;
        d r3 = this.v;
        if (r3 == null) goto L9;
        r3.destroy();
        this.v = null;
    L9:
        this.w.a = null;
    }

    public LynxUIMarkdownShadowNode() {
        this.w = new p8a.a();
        this.x = new t(this);
        this.y = new m(this);
        this.B = NameKeys.UnloadStrategy_No_Strategy;
        this.C = NameKeys.UnloadStrategy_No_Strategy;
        Markdown.ensureInitialized();
        h(this);
        Looper r0 = Looper.myLooper();
        this.D = r0;
        if (r0 == null) goto L6;
        this.E = new Handler(r0);
        return;
    }

    public static /* synthetic */ void C(LynxUIMarkdownShadowNode r0) {
        super.q();
    }

    @LynxProp(name = "allow-break-around-punctuation")
    public void setAllowBreakAroundPunctuation(boolean r3) {
        d r0 = D();
        if (r0 == null) goto L6;
        r0.setBooleanProp(12, r3);
        return;
    }

    @LynxProp(name = "animation-frame-rate")
    public void setAnimationFrameRate(float r5) {
        d r0 = D();
        if (r0 == null) goto L6;
        r0.setNumberProp(10, r5);
        return;
    }

    @LynxProp(name = "animation-type")
    public void setAnimationType(String r3) {
        d r0 = D();
        if (r0 == null) goto L5;
        r0.setAnimationType("typewriter".equals(r3) ? 1 : 0);
    L5:
        q();
    }

    @LynxProp(name = "animation-velocity")
    public void setAnimationVelocity(float r3) {
        d r0 = D();
        if (r0 != null) goto L5;
    L9:
        q();
        return;
    L5:
        if (r3 >= 0.0f) goto L8;
        r3 = 1.0f;
    L8:
        r0.setAnimationVelocity(r3);
        goto L9
    }

    @LynxProp(name = LynxAccessibilityModule.MSG_CONTENT)
    public void setContent(String r2) {
        d r0 = D();
        if (r2 != null) goto L5;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        this.B = r2;
        if (r0 == null) goto L9;
        r0.setContent(r2);
        return;
    }

    @LynxProp(name = "content-complete")
    public void setContentComplete(boolean r3) {
        d r0 = D();
        if (r0 == null) goto L5;
        r0.setBooleanProp(3, r3);
    L5:
        q();
    }

    @LynxProp(name = "content-id")
    public void setContentID(String r1) {
        if (r1 != null) goto L4;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L4:
        this.C = r1;
    }

    @LynxProp(defaultBoolean = false, name = "text-selection")
    public void setEnableTextSelection(boolean r3) {
        d r0 = D();
        if (r0 == null) goto L6;
        r0.setBooleanProp(13, r3);
        return;
    }

    @LynxProp(name = "exposure-tags")
    public void setExposureTags(ReadableArray r3) {
        d r0 = D();
        if (r0 == null) goto L9;
        if (r3 != null) goto L6;
        ArrayList<Object> r4 = null;
    L7:
        r0.setArrayProp(9, r4);
        return;
    L6:
        r4 = r3.asArrayList();
        goto L7
    }

    @LynxProp(name = "image-downsampling")
    public void setImageDownSampling(boolean r2) {
        this.x.d = r2;
    }

    @LynxProp(name = "image-sync-load")
    public void setImageSyncLoad(boolean r2) {
        this.x.e = r2;
    }

    @LynxProp(name = "initial-animation-step")
    public void setInitialAnimationStep(int r2) {
        d r0 = D();
        if (r0 == null) goto L5;
        r0.setInitialAnimationStep(r2);
    L5:
        q();
    }

    @LynxProp(name = "content-range")
    public void setMarkdownContentRange(ReadableArray r5) {
        d r0 = D();
        if (r0 == null) goto L14;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.size() <= 0) goto L10;
        r0.setNumberProp(7, r5.getInt(0));
    L10:
        if (r5.size() <= 1) goto L12;
        r0.setNumberProp(8, r5.getInt(1));
    L12:
        q();
        return;
    }

    @LynxProp(name = "markdown-effect")
    public void setMarkdownEffect(ReadableMap r3) {
        d r0 = D();
        if (r0 == null) goto L9;
        if (r3 != null) goto L6;
        HashMap<String, Object> r4 = null;
    L7:
        r0.setObjectProp(18, r4);
        return;
    L6:
        r4 = r3.asHashMap();
        goto L7
    }

    @LynxProp(name = "markdown-max-height")
    public void setMarkdownMaxHeight(float r5) {
        d r0 = D();
        if (r0 == null) goto L5;
        r0.setNumberProp(6, r5);
    L5:
        q();
    }

    @LynxProp(defaultInt = 0, name = "selection-background-color")
    public void setSelectionBackgroundColor(int r3) {
        d r0 = D();
        if (r0 == null) goto L6;
        r0.setColorProp(14, r3);
        return;
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-color")
    public void setSelectionHandleColor(int r3) {
        d r0 = D();
        if (r0 == null) goto L6;
        r0.setColorProp(15, r3);
        return;
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-size")
    public void setSelectionHandleSize(int r5) {
        d r0 = D();
        if (r0 == null) goto L6;
        r0.setNumberProp(16, r5);
        return;
    }

    @LynxProp(name = "markdown-style")
    public void setStyleSheet(ReadableMap r2) {
        d r0 = D();
        if (r0 == null) goto L8;
        if (r2 != null) goto L6;
        HashMap<String, Object> r3 = null;
    L7:
        r0.setStyle(r3);
        goto L8
    L6:
        r3 = r2.asHashMap();
    L8:
        q();
    }

    @LynxProp(name = "text-mark-attachments")
    public void setTextMarkAttachments(ReadableArray r3) {
        d r0 = D();
        if (r0 == null) goto L9;
        if (r3 != null) goto L6;
        ArrayList<Object> r4 = null;
    L7:
        r0.setArrayProp(19, r4);
        return;
    L6:
        r4 = r3.asArrayList();
        goto L7
    }

    @LynxProp(name = "text-maxline")
    public void setTextMaxLine(int r5) {
        d r0 = D();
        if (r0 == null) goto L5;
        r0.setNumberProp(2, r5);
    L5:
        q();
    }

    @LynxProp(name = "typewriter-dynamic-height")
    public void setTypewriterAutoHeight(boolean r3) {
        d r0 = D();
        if (r0 == null) goto L5;
        r0.setBooleanProp(4, r3);
    L5:
        q();
    }

    @LynxProp(name = "typewriter-height-transition-duration")
    public void setTypewriterHeightTransitionDuration(float r5) {
        d r0 = D();
        if (r0 == null) goto L6;
        r0.setNumberProp(11, r5);
        return;
    }

    @LynxProp(name = "typewriter-height-transition-prefetch")
    public void setTypewriterHeightTransitionPrefetch(boolean r3) {
        d r0 = D();
        if (r0 == null) goto L6;
        r0.setBooleanProp(20, r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r1) {
        this.m = r1;
        D();
    }

    public final void E(String r3, Throwable r4) {
        if (this.o == false) goto L5;
        return;
    L5:
        if (this.m == null) goto L13;
        if (r4 != null) goto L9;
        String r5 = "failed to load image";
    L10:
        this.m.reportResourceError(r3, "image", r5);
        return;
    L9:
        r5 = r4.getMessage();
        goto L10
    }

    @Override // y6a.e
    public final k b(j r7, g r8) {
        this.z = r8;
        d r9 = D();
        if (r9 == null) goto L5;
        int r1 = 0;
        boolean r2 = false;
    L8:
        if (r1 >= l()) goto L16;
        ShadowNode r3 = k(r1);
        if ((r3 instanceof NativeLayoutNodeRef) == false) goto L15;
        if (r3.o() == false) goto L15;
        r3.e = false;
        r2 = true;
    L15:
        r1 = r1 + 1;
        goto L8
    L16:
        if (r2 == false) goto L18;
        r9.markDirty();
    L18:
        long r10 = r9.measure((int) r7.a, r7.b.intValue(), (int) r7.c, r7.d.intValue());
        return new k((int) ((r10 >>> 42) & 2097151), (int) ((r10 >>> 21) & 2097151), (int) (r10 & 2097151));
    L5:
        return new k(0.0f, 0.0f, 0.0f);
    }

    @Override // y6a.e
    public final void d(y6a.b r2, a r3) {
        this.A = r3;
        d r4 = D();
        if (r4 == null) goto L6;
        r4.align((int) r2.a, (int) r2.b);
        return;
    }
}
