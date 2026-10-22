package com.larus.asr.session;

import com.larus.asr.ChatBottomSpeakerComponent$f;
import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class ComponentAsrSession implements o {
    public final p a;
    public final String b;
    public final VoiceInputType c;
    public final Function0<Boolean> d;
    public final f2a.d e;
    public final com.larus.asr.session.component.f0 f;
    public final Lazy g;
    public volatile com.larus.asr.session.component.f0 h;
    public Function0<Unit> i;

    public static final class a {
    }

    static {
    }

    public abstract com.larus.asr.session.component.d0 b();

    public void h(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public void i(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public void j(com.larus.asr.session.component.f0 r1, String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "path");
    }

    @Override // com.larus.asr.session.o
    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        return this.f.l.get();
    }

    @Override // com.larus.asr.session.o
    public void clear() {
        com.larus.asr.session.component.f0 r0 = this.h;
        if (r0 == null) goto L5;
        r0.h.set(true);
    L5:
        Iterator<T> r1 = d().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((com.larus.asr.session.component.o0) r1.next()).onClear();
        goto L7
    L9:
        if (r0 == null) goto L13;
        r0.f(false);
        return;
    }

    public final List<com.larus.asr.session.component.o0> d() {
        return ((com.larus.asr.session.component.d0) this.g.getValue()).b;
    }

    @Override // com.larus.asr.session.o
    public boolean m0() {
        com.larus.asr.session.component.f0 r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.f.get() != true) goto L7;
        return true;
    }

    public final List<com.larus.asr.session.component.q0> k() {
        List<com.larus.asr.session.component.o0> r0 = d();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof com.larus.asr.session.component.q0) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    @Override // com.larus.asr.session.o
    public final void onStop() {
        Iterator<T> r0 = d().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.o0) r0.next()).onStop();
        goto L4
    }

    public static final List a(ComponentAsrSession r3) {
        List<com.larus.asr.session.component.p0> r4 = ((com.larus.asr.session.component.d0) r3.g.getValue()).a;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r1 = r5.next();
        if ((r1 instanceof com.larus.asr.session.component.n0) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.k.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.j.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.k.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "withExtHandle");
        Iterator<T> r0 = k().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.q0) r0.next()).b(r3);
        goto L4
    }

    public final boolean e(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (((Boolean) this.d.invoke()).booleanValue() == true) goto L5;
    L13:
        return false;
    L5:
        if (this.h != r2) goto L13;
        if (g(r2) == false) goto L13;
        if (r2.c() == true) goto L13;
        if (r2.g.get() == true) goto L13;
        return true;
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.j.add(r2);
    }

    public boolean f(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return e(r2);
    }

    public boolean g(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return Intrinsics.areEqual(r2.a, this.a.ua());
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r3) {
        Iterator<T> r0 = k().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.q0) r0.next()).g(r3);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.f.e(r2);
    }

    @Override // com.larus.asr.session.o
    public final void ra(Function2<? super String, ? super String, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "handle");
        Iterator r0 = ((ArrayList) k()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.q0) r0.next()).k(r3);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void sa(ChatBottomSpeakerComponent$f r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        this.i = r2;
    }

    public final void c(int r4, com.larus.asr.session.component.b0 r5) {
        if (((Boolean) r5.e.invoke()).booleanValue() == true) goto L6;
        com.larus.asr.session.component.f0 r6 = r5.getContext();
        r6.h.set(true);
        r6.f(true);
        return;
    L6:
        com.larus.asr.session.component.p0 r0 = (com.larus.asr.session.component.p0) CollectionsKt.getOrNull(((com.larus.asr.session.component.d0) this.g.getValue()).a, r4);
        if (r0 != null) goto L9;
        return;
    L9:
        r0.b(r5, new i(new AtomicBoolean(false), this, r4, r5));
    }

    @Override // com.larus.asr.session.o
    public void qa(String r5, Message r6) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        com.larus.asr.session.component.f0 r0 = this.h;
        if (r0 == null) goto L5;
        r0.h.set(true);
    L5:
        com.larus.asr.session.component.f0 r1 = this.h;
        if (r1 == null) goto L8;
        r1.f.set(false);
        r1.e.compareAndSet(false, true);
    L8:
        com.larus.asr.session.component.f0 r2 = this.h;
        if (r2 == null) goto L11;
        r2.f(false);
    L11:
        com.larus.asr.session.component.a r3 = new com.larus.asr.session.component.a(r5, r6);
        Iterator<T> r7 = d().iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        ((com.larus.asr.session.component.o0) r7.next()).d(r3);
        goto L13
    L15:
        Iterator<T> r8 = d().iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        ((com.larus.asr.session.component.o0) r8.next()).c(r3);
        goto L17
    }

    @Override // com.larus.asr.session.o
    public void ma(String r3, Message r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        com.larus.asr.session.component.f0 r0 = this.h;
        if (r0 == null) goto L5;
        r0.e.set(false);
    L5:
        com.larus.asr.session.component.f0 r1 = this.h;
        if (r1 == null) goto L8;
        r1.d();
    L8:
        com.larus.asr.session.component.j0 r2 = new com.larus.asr.session.component.j0(r3, r4, r5);
        Iterator<T> r6 = d().iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((com.larus.asr.session.component.o0) r6.next()).i(r2);
        goto L10
    L12:
        Iterator<T> r7 = d().iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        ((com.larus.asr.session.component.o0) r7.next()).e(r2);
        goto L14
    }

    public ComponentAsrSession(p r2, String r3, VoiceInputType r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "voiceInputType");
        Intrinsics.checkNotNullParameter(r5, "isCurrentSession");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new f2a.d("VoiceInput", "ComponentAsrSession");
        this.f = new com.larus.asr.session.component.f0(r3, r5);
        this.g = LazyKt.lazy(new ComponentAsrSession$components$2(this));
        this.i = new k();
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r3, Function1<? super com.larus.audio.a, Boolean> r4, Function2<? super String, ? super byte[], Unit> r5, Function1<? super String, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r3, "successResultHandle");
        Intrinsics.checkNotNullParameter(r4, "failResultHandle");
        Intrinsics.checkNotNullParameter(r5, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r6, "handle");
        Iterator r0 = ((ArrayList) k()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.q0) r0.next()).m(r3, r4, r5, r6);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.asr.session.h] */
    @Override // com.larus.asr.session.o
    public final void pa(String r14, boolean r15, boolean r16, com.larus.audio.asr.c0 r17, long r19, Long r20, Integer r21, d58.a r22) {
        Intrinsics.checkNotNullParameter(r14, "itemId");
        Intrinsics.checkNotNullParameter(r17, "traceInfo");
        Intrinsics.checkNotNullParameter(r22, "durationConfig");
        final com.larus.asr.session.component.f0 r1 = this.f;
        com.larus.asr.session.component.k0 r12 = new com.larus.asr.session.component.k0(r14, r15, r16, r17, r19, r20, r21, r22);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "request");
        r1.c = r12;
        r1.e.set(false);
        r1.f.set(false);
        r1.g.set(false);
        r1.h.set(false);
        r1.d = null;
        r1.m = null;
        r1.n = 0;
        r1.o = AsrEngineRoute.NONE;
        r1.i = null;
        r1.q = false;
        i(r1);
        this.h = r1;
        c(0, new com.larus.asr.session.component.b0(r1, new l(r1, this), new m(this), this.i, new h(this, r1)));
    }
}
