package com.larus.audio.call.record;

import com.larus.audio.call.aec.w;
import com.larus.audio.call.tracer.RealtimeCallTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class c implements v68.a {
    public volatile boolean a;
    public volatile v58.a b;
    public final w c;
    public final RealtimeCallTimer d;

    @Override // v68.a
    public void b(int r1) {
    }

    @Override // v68.a
    public void c(long r1, Long r3) {
    }

    @Override // v68.a
    public void f(Function2<? super String, ? super Long, Unit> r1) {
    }

    @Override // v68.a
    public void g(Function2<? super Boolean, ? super String, Unit> r1) {
    }

    @Override // v68.a
    public final void setBluetoothForceToMedia(boolean r1) {
    }

    @Override // v68.a
    public final w h() {
        return this.c;
    }

    public c(boolean r2) {
        hashCode();
        this.b = com.larus.audio.call.f.b(r2);
        if (r2 == true) goto L5;
        w r3 = null;
    L9:
        this.c = r3;
        this.d = new RealtimeCallTimer();
        return;
    L5:
        if (com.larus.audio.call.f.d().p == false) goto L7;
        r3 = new com.larus.audio.call.aec.i();
        goto L9
    L7:
        r3 = new com.larus.audio.call.aec.j();
        goto L9
    }

    @Override // v68.a
    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
    }
}
