package com.larus.audio.call.play;

import com.larus.im.service.audio.q;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.w1;
import ouc.d0;
import ouc.g0;
import ouc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AVInnerPlayerAdapter implements u68.c {
    public final g a;
    public final String b;
    public final q c;
    public final f d;
    public boolean e;
    public boolean f;
    public final CoroutineScope g;
    public final AVInnerPlayerAdapter$linkPlayerCallback$1 h;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public final /* synthetic */ AVInnerPlayerAdapter a;

        public a(CoroutineExceptionHandler.Key r1, AVInnerPlayerAdapter r2) {
            this.a = r2;
            super(r1);
        }

        public final void handleException(CoroutineContext r4, Throwable r5) {
            com.larus.audio.call.util.e.a.w(this.a.b, "[dispatchScope] exception: " + r5.getMessage(), r5);
        }
    }

    @Override // u68.a
    public final void a() {
    }

    @Override // u68.a
    public final void e(boolean r1) {
    }

    @Override // u68.c
    public final void f() {
    }

    @Override // u68.b
    public final void g(h r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // u68.a
    public final void b() {
        com.larus.audio.call.util.e.a.i(this.b, "[interrupt]");
        this.e = true;
        LinkedHashMap r1 = new LinkedHashMap();
        g0 r2 = k.c("client_interrupt");
        Intrinsics.checkNotNullParameter("end_type", "key");
        Intrinsics.checkNotNullParameter(r2, "element");
        ouc.i r3 = (ouc.i) r1.put("end_type", r2);
        d0 r4 = new d0(r1);
        if (this.f == false) goto L5;
        this.f = false;
        this.c.e("interrupt", true, r4.toString());
        return;
    L5:
        this.c.g(r4.toString());
    }

    @Override // u68.a
    public final void h() {
        com.larus.audio.call.util.e.a.i(this.b, "[clearTTS], unresolved");
    }

    @Override // u68.c
    public final void init() {
        com.larus.audio.call.util.e.a.i(this.b, "[init]");
        this.c.init();
        this.c.f().l(this.h);
    }

    @Override // u68.a
    public final boolean isPlaying() {
        if (this.c.f().isPlaying() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.c.f().a() == true) goto L8;
        return false;
    }

    @Override // u68.a
    public final void c(boolean r5) {
        com.larus.audio.call.util.e.a.i(this.b, "[mutePlay], enable: " + r5);
        this.c.c(r5);
    }

    @Override // u68.a
    public final void i(u68.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.d.h(r2);
    }

    @Override // u68.a
    public final void j(u68.a.b r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        f r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (((CopyOnWriteArraySet) r1.b).contains(r3) == false) goto L7;
        ((CopyOnWriteArraySet) r1.b).remove(r3);
        return;
    }

    @Override // u68.a
    public final void pause(String r5) {
        Intrinsics.checkNotNullParameter(r5, "caller");
        com.larus.audio.call.util.e.a.i(this.b, "[pause], caller: " + r5);
        this.c.pausePlay(r5);
    }

    @Override // u68.a
    public final void release(boolean r5) {
        com.larus.audio.call.util.e.a.i(this.b, "[release], finishCall: " + r5);
        this.c.f().q(this.h);
        this.c.a("release");
        if (CoroutineScopeKt.isActive(this.g) == false) goto L6;
        CoroutineScopeKt.cancel$default(this.g, null, 1, null);
        return;
    }

    @Override // u68.a
    public final void resume(String r5) {
        Intrinsics.checkNotNullParameter(r5, "caller");
        com.larus.audio.call.util.e.a.i(this.b, "[resume], caller: " + r5);
        this.c.d(r5);
    }

    @Override // u68.a
    public final void setVolume(float r5) {
        com.larus.audio.call.util.e.a.i(this.b, "[setVolume], gain: " + r5);
        this.c.setVolume(RangesKt.coerceIn(r5 * ((float) 100), 0.0f, 100.0f));
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.larus.audio.call.play.AVInnerPlayerAdapter$linkPlayerCallback$1] */
    public AVInnerPlayerAdapter(id9.d r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "dumpConfig");
        this.a = r3;
        this.b = "AVInnerPlayerAdapter_" + hashCode();
        this.c = r2.v();
        this.d = new f();
        this.g = CoroutineScopeKt.CoroutineScope(w1.a(1, "AVInnerPlayer").plus(new a(CoroutineExceptionHandler.Key, this)));
        this.h = new AVInnerPlayerAdapter$linkPlayerCallback$1(this);
    }

    @Override // u68.a
    public final void d(boolean r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "endType");
        com.larus.audio.call.util.e.a.i(this.b, "[stop], immediate: " + r5 + ", releaseTrack: " + r6 + ", caller: " + r7);
        q r8 = this.c;
        LinkedHashMap r0 = new LinkedHashMap();
        g0 r1 = k.c(r7);
        Intrinsics.checkNotNullParameter("end_type", "key");
        Intrinsics.checkNotNullParameter(r1, "element");
        ouc.i r2 = (ouc.i) r0.put("end_type", r1);
        Unit r3 = Unit.INSTANCE;
        r8.e(r7, r5, new d0(r0).toString());
    }

    @Override // u68.a
    public final void k(boolean r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "caller");
        com.larus.audio.call.util.e.a.i(this.b, "[play], flushBeforeStart: " + r5 + ", createAudioTrackWhenNotExist: " + r6 + ", caller: " + r7);
        if (r6 == false) goto L6;
        this.c.startPlay(r7);
        return;
    L6:
        if (this.c.f().a() == false) goto L10;
        this.c.d(r7);
        return;
    }
}
