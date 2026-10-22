package com.larus.audio.call.aec;

import android.os.Handler;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class BackTraceRecorderAecImpl {
    public final BoundedAudioDataQueue a;
    public final BoundedAudioDataQueue b;
    public final Object c;
    public final CoroutineScope d;
    public final AtomicReference<Function1<byte[], Unit>> e;
    public final AtomicReference<f> f;
    public final AtomicInteger g;
    public volatile boolean h;
    public volatile boolean i;
    public volatile boolean j;
    public volatile Job k;
    public volatile boolean l;

    /* JADX INFO: renamed from: com.larus.audio.call.aec.BackTraceRecorderAecImpl$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r8) {
            super(0, r8, BackTraceRecorderAecImpl.class, "onFrameConsumed", "onFrameConsumed()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m403invoke() {
            BackTraceRecorderAecImpl r0 = (BackTraceRecorderAecImpl) ((CallableReference) this).receiver;
            Object r1 = r0.c;
            monitor-enter(r1);
            r0.g.set(0);     // Catch: Throwable -> L14
            if (r0.h == true) goto L7;
        L11:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r1);
            return;
        L7:
            if (r0.j == true) goto L11;
            if (r0.a.currentSize() <= 0) goto L11;
            r0.d();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m403invoke();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/larus/audio/call/aec/BackTraceRecorderAecImpl$BoundedAudioDataQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantAudioData;", "maxSize", "", "<init>", "(I)V", "queueLock", "", "itemCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "onFrameConsumed", "Lkotlin/Function0;", "", "getOnFrameConsumed", "()Lkotlin/jvm/functions/Function0;", "setOnFrameConsumed", "(Lkotlin/jvm/functions/Function0;)V", "offerKeepingLatest", "", "audioData", "currentSize", "poll", "clear", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class BoundedAudioDataQueue extends ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> {
        private final AtomicInteger itemCount;
        private final int maxSize;
        private Function0<Unit> onFrameConsumed;
        private final Object queueLock;

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Object r0 = this.queueLock;
            monitor-enter(r0);
            super.clear();     // Catch: Throwable -> L7
            this.itemCount.set(0);     // Catch: Throwable -> L7
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final int currentSize() {
            return this.itemCount.get();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
        public SAMICoreVoiceAssistantAudioData poll() {
            Object r0 = this.queueLock;
            monitor-enter(r0);
            SAMICoreVoiceAssistantAudioData r1 = (SAMICoreVoiceAssistantAudioData) super.poll();     // Catch: Throwable -> L13
            if (r1 == null) goto L7;
            this.itemCount.decrementAndGet();     // Catch: Throwable -> L13
        L7:
            monitor-exit(r0);
            if (r1 == null) goto L12;
            Function0<Unit> r2 = this.onFrameConsumed;
            if (r2 == null) goto L12;
            r2.invoke();
        L12:
            return r1;
        L13:
            th = move-exception;
            throw th;
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public final Function0<Unit> getOnFrameConsumed() {
            return this.onFrameConsumed;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        public BoundedAudioDataQueue(int r2) {
            this.maxSize = r2;
            this.queueLock = new Object();
            this.itemCount = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r2) {
            if (r2 != null) goto L4;
            boolean r0 = true;
        L5:
            if (r0 == true) goto L9;
            return false;
        L9:
            return contains((SAMICoreVoiceAssistantAudioData) r2);
        L4:
            r0 = r2 instanceof SAMICoreVoiceAssistantAudioData;
            goto L5
        }

        public final boolean offerKeepingLatest(SAMICoreVoiceAssistantAudioData r4) {
            Intrinsics.checkNotNullParameter(r4, "audioData");
            Object r0 = this.queueLock;
            monitor-enter(r0);
        L18:
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.itemCount.get() < this.maxSize) goto L10;
            if (super.poll() == null) goto L10;
            this.itemCount.decrementAndGet();     // Catch: Throwable -> L15
        L10:
            boolean r5 = offer(r4);     // Catch: Throwable -> L15
            if (r5 == false) goto L13;
            this.itemCount.incrementAndGet();     // Catch: Throwable -> L15
        L13:
            monitor-exit(r0);
            return r5;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean remove(Object r2) {
            if (r2 != null) goto L4;
            boolean r0 = true;
        L5:
            if (r0 == true) goto L9;
            return false;
        L9:
            return remove((SAMICoreVoiceAssistantAudioData) r2);
        L4:
            r0 = r2 instanceof SAMICoreVoiceAssistantAudioData;
            goto L5
        }

        public final void setOnFrameConsumed(Function0<Unit> r1) {
            this.onFrameConsumed = r1;
        }

        public /* bridge */ boolean contains(SAMICoreVoiceAssistantAudioData r1) {
            return super.contains(r1);
        }

        public /* bridge */ boolean remove(SAMICoreVoiceAssistantAudioData r1) {
            return super.remove(r1);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void c() {
        Object r0 = this.c;
        monitor-enter(r0);
        this.g.set(0);     // Catch: Throwable -> L16
        this.b.clear();     // Catch: Throwable -> L16
        this.a.clear();     // Catch: Throwable -> L16
        if (f() == true) goto L8;
        monitor-exit(r0);
        return;
    L8:
        f r1 = this.f.get();     // Catch: Throwable -> L16
        if (r1 == null) goto L14;
        Handler r2 = r1.i;     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        r2.removeCallbacksAndMessages(null);     // Catch: Throwable -> L16
    L13:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.j == false) goto L7;
        return;
    L7:
        if (this.a.currentSize() > 0) goto L10;
        return;
    L10:
        if (this.g.compareAndSet(0, 1) == true) goto L12;
        return;
    L12:
        f r0 = this.f.get();
        if (r0 != null) goto L16;
        this.g.set(0);
        return;
    L16:
        Handler r1 = r0.i;
        if (r1 == null) goto L22;
        r1.post(new d(r0));
        return;
    }

    public final boolean f() {
        if (this.h == true) goto L5;
    L9:
        return false;
    L5:
        if (this.j == true) goto L9;
        if (this.f.get() == null) goto L9;
        return true;
    }

    public final void g() {
        Object r0 = this.c;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.h == true) goto L11;
        if (this.i == true) goto L11;
        if (this.l == true) goto L11;
    L12:
        monitor-exit(r0);
        return;
    L11:
        if (this.j == true) goto L12;
        this.j = true;     // Catch: Throwable -> L19
        this.h = false;     // Catch: Throwable -> L19
        this.e.set(new t());     // Catch: Throwable -> L19
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        BackTraceRecorderAecImpl$release$destroyAction$1 r2 = new BackTraceRecorderAecImpl$release$destroyAction$1(this, null);
        BuildersKt.launch$default(this.d, null, null, new BackTraceRecorderAecImpl$release$2(r2, null), 3, null);
    }

    public BackTraceRecorderAecImpl() {
        BoundedAudioDataQueue r0 = new BoundedAudioDataQueue(160);
        this.a = r0;
        this.b = new BoundedAudioDataQueue(160);
        this.c = new Object();
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.e = new AtomicReference(new s());
        this.f = new AtomicReference(null);
        this.g = new AtomicInteger(0);
        r0.setOnFrameConsumed(new AnonymousClass1(this));
    }

    public final void h() {
        if (f() == true) goto L5;
        return;
    L5:
        f r0 = this.f.get();
        if (r0 == null) goto L9;
        com.larus.audio.call.util.e.a.i(r0.b, "[reset] SamiCore");
        SAMICoreProperty r1 = new SAMICoreProperty();
        SAMICorePropertyId r2 = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Reset_Aec;
        r1.id = r2;
        r0.a.SAMICoreSetProperty(r2, r1);
        return;
    }

    public static final void a(BackTraceRecorderAecImpl r2) {
        r2.g.set(0);
        r2.l = false;
        r2.b.clear();
        r2.a.clear();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        f r3 = r2.f.get();     // Catch: Throwable -> L11
        Unit r1 = null;
        if (r3 == null) goto L9;
        Handler r4 = r3.i;     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        r4.removeCallbacksAndMessages(null);     // Catch: Throwable -> L11
    L8:
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r1);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L19;
        c68.b.c("BackTraceRecorderAecImpl", "clear failed", r6);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static final int b(BackTraceRecorderAecImpl r4) {
        SAMICoreVoiceAssistantAudioData r0 = r4.b.poll();
        int r1 = 0;
    L4:
        if (r0 == null) goto L9;
        if (r4.a.offerKeepingLatest(r0) == false) goto L7;
        r1 = r1 + 1;
        r0 = r4.b.poll();
        goto L4
    L7:
        c68.b.e("BackTraceRecorderAecImpl", "drop pending audio data because queue offer failed");
    L9:
        if (r1 <= 0) goto L11;
        int r2 = c68.b.a;
        c68.b.d("BackTraceRecorderAecImpl", "drain pending audio data after AEC ready, drainedCount=" + r1 + ", queueSize=" + r4.a.currentSize());
    L11:
        return r1;
    }

    public final void e(Function1<? super byte[], Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onAudioDataReceived");
        Object r0 = this.c;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.j == false) goto L7;
    L15:
        monitor-exit(r0);
        return;
    L7:
        if (this.h == true) goto L15;
        if (this.i == true) goto L15;
        this.i = true;     // Catch: Throwable -> L17
        this.e.set(r8);     // Catch: Throwable -> L17
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        this.k = BuildersKt.launch$default(this.d, null, null, new BackTraceRecorderAecImpl$init$2(this, null), 3, null);
    }

    public final void i(byte[] r7, byte[] r8) {
        Intrinsics.checkNotNullParameter(r7, "micData");
        Intrinsics.checkNotNullParameter(r8, "refData");
        SAMICoreVoiceAssistantAudioData r2 = new SAMICoreVoiceAssistantAudioData();
        r2.data = r7;
        r2.refData = r8;
        Object r3 = this.c;
        monitor-enter(r3);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.j == false) goto L10;
        c68.b.e("BackTraceRecorderAecImpl", "drop audio data because AEC is destroying");     // Catch: Throwable -> L31
        monitor-exit(r3);
        return;
    L10:
        if (this.l == false) goto L13;
    L26:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r3);
        if (r7 == null) goto L35;
        int r10 = c68.b.a;
        c68.b.e("BackTraceRecorderAecImpl", "dispatch raw mic because OBRIC AEC fallback is enabled, size=" + r7.length);
        this.e.get().invoke(r7);
        return;
    L35:
        return;
    L13:
        if (f() == false) goto L15;
        com.larus.audio.call.util.e.a.i("BackTraceRecorderAecImpl", "triggerAecWithMicAndRefData with micData " + r7.length + ", refData " + r8.length);     // Catch: Throwable -> L31
        if (this.a.offerKeepingLatest(r2) == true) goto L25;
        c68.b.e("BackTraceRecorderAecImpl", "drop audio data because queue offer failed");     // Catch: Throwable -> L31
        monitor-exit(r3);
        return;
    L25:
        d();     // Catch: Throwable -> L31
        r7 = null;
        goto L26
    L15:
        if (this.b.offerKeepingLatest(r2) == true) goto L17;
        c68.b.e("BackTraceRecorderAecImpl", "drop audio data because pending before ready queue offer failed");     // Catch: Throwable -> L31
    L17:
        int r11 = c68.b.a;     // Catch: Throwable -> L31
        c68.b.d("BackTraceRecorderAecImpl", "cache audio data before AEC ready, pendingSize=" + this.b.currentSize());     // Catch: Throwable -> L31
        monitor-exit(r3);
    }
}
