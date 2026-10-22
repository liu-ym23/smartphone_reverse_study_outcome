package com.bytedance.lynx.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import g8.g;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f6822c;
    public boolean d;
    public volatile boolean e;
    public g f;

    public f(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
    }

    @Override // com.bytedance.lynx.media.e
    public final boolean c() {
        return this.d;
    }

    @Override // com.bytedance.lynx.media.e
    public final void d() {
        this.d = false;
        this.f = null;
    }

    @Override // android.view.View
    public final void draw(Canvas r10) {
        if (r10 != null) goto L4;
    L8:
        super.draw(r10);
        return;
    L4:
        if (this.f6822c == null) goto L8;
        r10.saveLayer(new RectF(0.0f, 0.0f, getWidth(), getHeight()), null, 31);
        Path r5 = new Path();
        RectF r11 = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        float[] r12 = this.f6822c;
        Intrinsics.checkNotNull(r12);
        r5.addRoundRect(r11, r12, Path.Direction.CW);
        r10.clipPath(r5);
        super.draw(r10);
        r10.restore();
    }

    @Override // com.bytedance.lynx.media.e
    public final void f(g r10) {
        if (ViewCompat.isAttachedToWindow(this) == false) goto L8;
        sf.a r5 = getMediaView();
        if (r5 == null) goto L10;
        LynxLog.b(2, "LynxVideoEnginePlayableWrapperView", "invoke prepare");
        r5.g(r10);
        this.d = true;
        return;
    L10:
        return;
    L8:
        this.e = true;
        this.f = r10;
        LynxLog.b(2, "LynxVideoEnginePlayableWrapperView", "set pendingPrepare");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e == false) goto L9;
        sf.a r5 = getMediaView();
        if (r5 == null) goto L7;
        r5.g(this.f);
    L7:
        this.f = null;
        this.d = true;
        this.e = false;
        LynxLog.b(2, "LynxVideoEnginePlayableWrapperView", "unset pendingPrepare");
        return;
    }

    public final void setBorderRadius(float[] r5) {
        this.f6822c = r5;
        invalidate();
    }

    @Override // com.bytedance.lynx.media.e
    public void setPlayParams(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Object r5 = r10.get("player-type");
        if ((r5 instanceof String) == false) goto L5;
        String r11 = (String) r5;
    L6:
        if (r11 != null) goto L8;
        r11 = "default";
    L8:
        ConcurrentHashMap r12 = tf.b.f22130a;
        Intrinsics.checkNotNullParameter(r11, "playerType");
        if (((tf.a) tf.b.f22130a.get(r11)) != null) goto L12;
        LynxLog.b(4, "LynxVideoEnginePlayableWrapperView", "mediaView playerType not found");
        return;
    L12:
        sf.a r13 = getMediaView();
        Context r14 = getContext();
        Intrinsics.checkNotNullParameter(r14, "context");
        setMediaView(new sf.f(r14));
        if (getMediaView() != null) goto L23;
        if (r13 == null) goto L21;
        uf.b r15 = ((sf.d) r13).f21895b;
        if (r15 == null) goto L21;
        if (r15.c() == false) goto L21;
        r15.f22339b.m();
    L21:
        LynxLog.b(4, "LynxVideoEnginePlayableWrapperView", "mediaView invalid playableInstance");
        return;
    L23:
        sf.a r16 = getMediaView();
        if (r16 == null) goto L26;
        r16.a();
        r16.e(this);
        LynxLog.b(2, "LynxVideoEnginePlayableWrapperView", "mediaView trigger initialize");
    L26:
        sf.a r17 = getMediaView();
        if (r17 == null) goto L29;
        r17.a(r10);
    L29:
        Object r18 = r10.get("auto_prepare");
        if ((r18 instanceof Boolean) == false) goto L32;
        Boolean r19 = (Boolean) r18;
    L33:
        if (r19 == null) goto L35;
        boolean r20 = r19.booleanValue();
    L36:
        if (r20 == true) goto L38;
    L44:
        if (r13 == null) goto L52;
        uf.b r21 = ((sf.d) r13).f21895b;
        if (r21 != null) goto L48;
        return;
    L48:
        if (r21.c() == false) goto L54;
        r21.f22339b.m();
        return;
    L54:
        return;
    L52:
        return;
    L38:
        if (ViewCompat.isAttachedToWindow(this) == false) goto L43;
        sf.a r22 = getMediaView();
        if (r22 == null) goto L42;
        r22.g(null);
    L42:
        this.d = true;
        LynxLog.b(2, "LynxVideoEnginePlayableWrapperView", "Trigger prepare for mediaView " + getMediaView());
        goto L44
    L43:
        this.e = true;
        goto L44
    L35:
        r20 = false;
        goto L36
    L32:
        r19 = null;
        goto L33
    L5:
        r11 = null;
        goto L6
    }
}
