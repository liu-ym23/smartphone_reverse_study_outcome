package com.larus.voicecall.impl.subtitle;

import com.larus.audio.call.RealtimeCallParam;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v implements f {
    public final /* synthetic */ RealtimeCallSubtitleLayout a;

    @Override // com.larus.voicecall.impl.subtitle.f
    public final String K() {
        q0 r0 = this.a.b;
        if (r0 == null) goto L7;
        com.larus.voicecall.impl.tracer.w.a r1 = r0.b;
        if (r1 == null) goto L7;
        String r2 = r1.c;
    L8:
        if (r2 != null) goto L11;
        return NameKeys.UnloadStrategy_No_Strategy;
    L11:
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.voicecall.impl.subtitle.f
    public final String L() {
        q0 r0 = this.a.b;
        if (r0 == null) goto L7;
        com.larus.voicecall.impl.tracer.w.a r1 = r0.b;
        if (r1 == null) goto L7;
        String r2 = r1.a;
    L8:
        if (r2 != null) goto L11;
        return NameKeys.UnloadStrategy_No_Strategy;
    L11:
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.voicecall.impl.subtitle.f
    public final com.larus.voicecall.impl.scene.m a() {
        Function0<com.larus.voicecall.impl.scene.m> r0 = this.a.getCurrentSceneMode();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.larus.voicecall.impl.scene.m) r0.invoke();
    }

    @Override // com.larus.voicecall.impl.subtitle.f
    public final e3a.b b() {
        return this.a.f;
    }

    @Override // com.larus.voicecall.impl.subtitle.f
    public final boolean c() {
        Function0<Boolean> r0 = this.a.u;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (((Boolean) r0.invoke()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.voicecall.impl.subtitle.f
    public final RealtimeCallParam d() {
        e3a.b r0 = this.a.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public v(RealtimeCallSubtitleLayout r1) {
        this.a = r1;
    }
}
