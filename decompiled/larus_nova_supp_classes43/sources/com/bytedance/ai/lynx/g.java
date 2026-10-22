package com.bytedance.ai.lynx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.bytedance.ai.applet.render.core.lynx.LynxAIBridgePort;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$d;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxLoadOption;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.s0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends LynxView {
    public static final /* synthetic */ int l = 0;
    public final String a;
    public final String b;
    public final com.bytedance.ai.lynx.b c;
    public Uri d;
    public com.ivy.ivykit.api.bridge.g e;
    public com.ivy.ivykit.api.plugin.b f;
    public IAISDKDebugService$d g;
    public s4.c<ReadableMap> h;
    public boolean i;
    public b j;
    public Drawable k;

    public static final class a {
    }

    public interface b {
        boolean onTouchEvent(MotionEvent r1);
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void destroy() {
        setDebugOverlay(null);
        com.bytedance.ai.debug.f.a.getClass();
        IAISDKDebugService.Companion r1 = IAISDKDebugService.a;
        r1.getClass();
        IAISDKDebugService.b r10 = IAISDKDebugService.Companion.c;
        if ((r10 instanceof IAISDKDebugService.b) == false) goto L5;
        IAISDKDebugService.b r11 = r10;
    L6:
        if (r11 == null) goto L8;
        r11.K(this);
    L8:
        r1.D(this.g);
        com.ivy.ivykit.api.plugin.b r12 = this.f;
        if (r12 == null) goto L11;
        r12.release();
    L11:
        this.f = null;
        removeLynxViewClient(this.c);
        setAsyncImageInterceptor(null);
        com.ivy.ivykit.api.bridge.g r0 = this.e;
        if (r0 == null) goto L14;
        r0.release();
    L14:
        super.destroy();
        return;
    L5:
        r11 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r r0 = this.c.d;
        if (r0 == null) goto L6;
        r0.onDetachedFromWindow(this);
        return;
    }

    public final Drawable getDebugOverlay() {
        return this.k;
    }

    public final s4.c<ReadableMap> getLynxRemoteBridgeMessages() {
        return this.h;
    }

    public final Uri getOriginalUri$ai_sdk_release() {
        return this.d;
    }

    public final b getTouchEventCallback() {
        return this.j;
    }

    private final void setNpthLastUrl(String r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        HashMap r1 = new HashMap();     // Catch: Throwable -> L11
        if (r10 == null) goto L8;
        List r11 = StringsKt.split$default(r10, new String[]{"?"}, false, 0, 6, null);     // Catch: Throwable -> L11
        if (r11 == null) goto L8;
        String r12 = (String) ListProtector.get(r11, 0);     // Catch: Throwable -> L11
        if (r12 == null) goto L8;
    L9:
        r1.put("last_lynx_url", r12);     // Catch: Throwable -> L11
        r1.put("lynx_sdk_version", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L11
        Npth.addTags(r1);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L8:
        r12 = "";
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.dispatchDraw(r10);
        Drawable r0 = this.k;
        if (r0 == null) goto L6;
        r0.setBounds(0, 0, getWidth(), getHeight());
        r0.draw(r10);
        return;
    }

    public final boolean dispatchTouchEvent(MotionEvent r10) {
        b r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        MotionEvent r11 = MotionEvent.obtain(r10);
        r11.setAction(3);
        super.dispatchTouchEvent(r11);
        r11.recycle();
        return true;
    L11:
        return super.dispatchTouchEvent(r10);
    L5:
        if (r0.onTouchEvent(r10) != true) goto L7;
        r1 = true;
        goto L7
    }

    public final LynxAIBridgePort h(s4.c<ReadableMap> r10) {
        Intrinsics.checkNotNullParameter(r10, "remoteMessageCache");
        LynxAIBridgePort r0 = new LynxAIBridgePort(this, r10);
        r0.setRemoteReadyListener(new f(this));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDebugOverlay(Drawable r10) {
        Drawable r0 = this.k;
        if (r0 != r10) goto L6;
        return;
    L6:
        if (r0 == null) goto L8;
        r0.setCallback(null);
    L8:
        if (r10 == null) goto L10;
        r10.setCallback(this);
    L11:
        this.k = r10;
        invalidate();
        return;
    L10:
        r10 = null;
        goto L11
    }

    public final void setLynxRemoteBridgeMessages(s4.c<ReadableMap> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.h = r10;
    }

    public final void setReused(boolean r1) {
        this.i = r1;
    }

    public final void setTouchEventCallback(b r1) {
        this.j = r1;
    }

    public final void updateData(TemplateData r10) {
        Intrinsics.checkNotNullParameter(r10, "initData");
        r10.markReadOnly();
        super.updateData(r10);
    }

    public final void k(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        int r0 = com.bytedance.ai.applet.render.core.lynx.p.a;
        com.bytedance.ai.applet.render.core.lynx.p.a.a(this, r10, r11, r12);
    }

    public g(Context r10, String r11, String r12, LynxViewBuilder r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "containerId");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "builder");
        super(r10, r13);
        this.a = r11;
        this.b = r12;
        com.bytedance.ai.lynx.b r15 = new com.bytedance.ai.lynx.b(this, this.b);
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r15.f = r14;
        this.c = r15;
        this.d = Uri.EMPTY;
        this.h = new s4.c();
        addLynxViewClient(r15);
    }

    public static /* synthetic */ void j(g r10, String r11, TemplateBundle r12, TemplateData r13, r r14) {
        r10.i(r11, r12, r13, r14, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(String r10, TemplateBundle r11, TemplateData r12, r r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "templateBundle");
        Intrinsics.checkNotNullParameter(r12, "initData");
        Intrinsics.checkNotNullParameter(r13, "lifeCycle");
        Uri r0 = UriProtector.parse(r10);
        this.d = r0;
        String r1 = UriProtector.getQueryParameter(r0, "forest_session_id");     // Catch: Exception -> L5
    L7:
        if (r1 != null) goto L9;
        r1 = this.a;
    L9:
        com.bytedance.ai.lynx.b r15 = this.c;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r15.e = r1;
        r15.c = this.d;
        r15.d = r13;
        setNpthLastUrl(r10);
        s0.a r16 = new s0.a();
        r16.a = r10;
        r16.c = r11;
        r16.d = r12;
        r16.f = LynxLoadMode.NORMAL;
        r16.a(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        s0 r17 = r16.b();
        q r18 = q.a;
        TemplateData r19 = TemplateData.fromMap(q.c(this.b));
        Map r20 = q.f(getContext());
        if (r20 == null) goto L15;
        Iterator r21 = r20.entrySet().iterator();
    L13:
        if (r21.hasNext() == false) goto L15;
        Map.Entry r22 = (Map.Entry) r21.next();
        r19.put((String) r22.getKey(), r22.getValue());
    L15:
        r19.put("__AI_SDK_VERSION__", "1.15.0-rc.7");
        if (r14 == null) goto L21;
        Iterator<Map.Entry<String, ? extends Object>> r23 = r14.entrySet().iterator();
    L19:
        if (r23.hasNext() == false) goto L21;
        Map.Entry<String, ? extends Object> r24 = r23.next();
        r19.put(r24.getKey(), r24.getValue());
    L21:
        r19.markReadOnly();
        updateGlobalProps(r19);
        loadTemplate(r17);
        return;
    L5:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AppletLynxView", "loadTemplateBundle parse forest_session_id error", e);
        r1 = null;
        goto L7
    }
}
