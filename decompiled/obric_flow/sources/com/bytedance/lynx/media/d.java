package com.bytedance.lynx.media;

import android.content.Context;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import g8.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6819c;

    public d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
    }

    @Override // com.bytedance.lynx.media.e
    public final boolean c() {
        return this.f6819c;
    }

    @Override // com.bytedance.lynx.media.e
    public final void d() {
        this.f6819c = false;
    }

    @Override // com.bytedance.lynx.media.e
    public final void f(g r5) {
        sf.a r10 = getMediaView();
        if (r10 == null) goto L6;
        LynxLog.b(2, "LynxAudioEngineLayout", "invoke prepare");
        r10.g(r5);
        this.f6819c = true;
        return;
    }

    @Override // com.bytedance.lynx.media.e
    public void setPlayParams(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        sf.a r5 = getMediaView();
        sf.c r11 = new sf.c(getContext());
        r11.a();
        LynxLog.b(2, "LynxAudioEngineLayout", "mediaView trigger initialize");
        r11.a(r10);
        setMediaView(r11);
        Object r12 = r10.get("auto_prepare");
        if ((r12 instanceof Boolean) == false) goto L5;
        Boolean r13 = (Boolean) r12;
    L6:
        if (r13 == null) goto L8;
        boolean r14 = r13.booleanValue();
    L9:
        if (r14 == false) goto L14;
        sf.a r15 = getMediaView();
        if (r15 == null) goto L13;
        r15.g(null);
    L13:
        this.f6819c = true;
        LynxLog.b(2, "LynxAudioEngineLayout", "Trigger prepare for mediaView " + getMediaView());
    L14:
        if (r5 == null) goto L22;
        uf.b r16 = ((sf.d) r5).f21895b;
        if (r16 != null) goto L18;
        return;
    L18:
        if (r16.c() == false) goto L24;
        r16.f22339b.m();
        return;
    L24:
        return;
    L22:
        return;
    L8:
        r14 = false;
        goto L9
    L5:
        r13 = null;
        goto L6
    }
}
