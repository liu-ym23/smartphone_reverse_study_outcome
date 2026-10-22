package com.larus.voicecall.impl.subtitle;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.LruCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.audio.call.plugins.RealtimeCallSubtitlePlugin;
import com.larus.audio.call.subtitle.DisplayType;
import com.larus.audio.call.subtitle.SubtitleAction;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Function;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q0 implements com.larus.voicecall.impl.scene.a {
    public static final /* synthetic */ int F = 0;
    public final boolean A;
    public Pair<String, String> B;
    public long C;
    public final boolean D;
    public final LruCache<String, String> E;
    public final LifecycleOwner a;
    public final com.larus.voicecall.impl.tracer.w.a b;
    public final IRealtimeCallTracer c;
    public final Function0<e3a.a> d;
    public final ReentrantLock e;
    public final LinkedList<a78.a> f;
    public volatile Job g;
    public final MutableSharedFlow<y0> h;
    public final MutableSharedFlow i;
    public Integer j;
    public final PthreadHandlerThreadV2 k;
    public Handler l;
    public boolean m;
    public String n;
    public final ArrayList<c> o;
    public final Handler p;
    public int q;
    public final m0 r;
    public String s;
    public volatile String t;
    public final Map<String, String> u;
    public final StateFlowImpl v;
    public final StateFlowImpl w;
    public final Set<String> x;
    public final Set<String> y;
    public final AtomicBoolean z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(n0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void c() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void d() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void i(Integer r1, boolean r2) {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void m() {
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void b() {
        FLogger r0 = FLogger.a;
        r0.i("RealtimeCallSubtitleViewModel", "onTTSEnd");
        r0.j("Realtime call", "Realtime cal onTTSEnd");
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void g() {
        FLogger r0 = FLogger.a;
        r0.i("RealtimeCallSubtitleViewModel", "RealtimeCallSubtitleViewModel_onASREnd");
        r0.j("Realtime call", "Realtime cal onASREnd");
        this.p.postDelayed(this.r, 100);
    }

    public final void h() {
        ArrayList<c> r0 = this.o;
        ListIterator<c> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(((LinkedHashMap) r1.previous().k).get("IS_PLACEHOLDER_SUBTITLE"), Boolean.TRUE) == false) goto L4;
        int r2 = r1.nextIndex();
    L9:
        if (r2 < 0) goto L15;
        ListProtector.remove(this.o, r2);
        this.h.tryEmit(new y0(SubtitleAction.REFRESH, 0, 0, false, 14));
        return;
    L15:
        return;
    L8:
        r2 = -1;
        goto L9
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void k() {
        s(this, SubtitleListUpdateType.DEEP_THINKING, null, null, null, null, null, null, null, 254);
    }

    public final void n() {
        ArrayList<c> r0 = this.o;
        ListIterator<c> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L14;
        DisplayType r2 = r1.previous().c;
        if (r2 != DisplayType.TTS_WAITING) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L4;
        int r4 = r1.nextIndex();
    L15:
        if (r4 >= 0) goto L17;
        return;
    L17:
        ListProtector.remove(this.o, r4);
        this.h.tryEmit(new y0(SubtitleAction.REFRESH, 0, 0, false, 14));
        return;
    L8:
        if (r2 == DisplayType.DEEP_THINKING) goto L11;
        r3 = false;
        goto L12
    L14:
        r4 = -1;
        goto L15
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void onInterrupt() {
        FLogger r0 = FLogger.a;
        r0.i("RealtimeCallSubtitleViewModel", "RealtimeCallSubtitleViewModel_onInterrupt");
        r0.j("Realtime call", "Realtime call onInterrupt");
        p("onInterrupt");
        this.m = true;
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void onRelease() {
        FLogger r0 = FLogger.a;
        r0.i("RealtimeCallSubtitleViewModel", "onRelease");
        r0.j("Realtime call", "Realtime call onRelease");
        p("onRelease");
    }

    public final void r() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L22
        if (this.z.get() == true) goto L20;
        ReentrantLock r1 = this.e;     // Catch: Throwable -> L22
        r1.lock();     // Catch: Throwable -> L22
        LinkedList<a78.a> r2 = this.f;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r2, "$this$operateDataSource");     // Catch: Throwable -> L17
        Integer r3 = Integer.valueOf(r2.size());     // Catch: Throwable -> L17
        r1.unlock();     // Catch: Throwable -> L22
        if (r3.intValue() <= 0) goto L20;
        Job r4 = this.g;     // Catch: Throwable -> L22
        boolean r5 = false;
        if (r4 != null) goto L11;
    L13:
        if (r5 == true) goto L20;
        a("start new job");     // Catch: Throwable -> L22
        this.g = BuildersKt.launch(LifecycleOwnerKt.getLifecycleScope(this.a), Dispatchers.getDefault(), CoroutineStart.LAZY, new RealtimeCallSubtitleViewModel$generateUpdateJob$1(this, null));     // Catch: Throwable -> L22
        Job r6 = this.g;     // Catch: Throwable -> L22
        if (r6 == null) goto L20;
        r6.start();     // Catch: Throwable -> L22
        goto L20
    L11:
        if (r4.isActive() != true) goto L13;
        r5 = true;
        goto L13
    L17:
        th = move-exception;
        r1.unlock();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L20:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L32;
        FLogger.a.e("RealtimeCallSubtitleViewModel", "startUpdateJobIfNeed failed:" + r8);
        return;
    L32:
        return;
    L22:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public final void a(String r5) {
        FLogger.a.d("RealtimeCallSubtitleViewModel", "cancel update job。 reason=" + r5);
        monitor-enter(this);
        Job r6 = this.g;     // Catch: Throwable -> L10
        if (r6 == null) goto L7;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);     // Catch: Throwable -> L10
    L7:
        this.g = null;     // Catch: Throwable -> L10
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void j(final a78.a r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        RealtimeCallSubtitlePlugin.b r0 = r5.j;
        if (r0 == null) goto L33;
        boolean r2 = true;
        if (r0 == null) goto L14;
        String r1 = r0.a;
        if (r1 == null) goto L14;
        if (r1.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 != true) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L33;
        RealtimeCallSubtitlePlugin.b r6 = r5.j;
        if (r6 == null) goto L26;
        String r7 = r6.b;
        if (r7 == null) goto L26;
        if (r7.length() != 0) goto L23;
        boolean r8 = true;
    L24:
        if (r8 != true) goto L26;
    L27:
        if (r2 == false) goto L33;
        if (r5.f == true) goto L33;
        FLogger.a.i("RealtimeCallSubtitleViewModel", "is block msg. but block data is empty");
        return;
    L23:
        r8 = false;
    L26:
        r2 = false;
        goto L27
    L11:
        r3 = false;
    L14:
        r4 = false;
    L33:
        if (r5.f == false) goto L35;
        FLogger.a.w("RealtimeCallSubtitleViewModel", "onUpdateSubtitleData needReplace is true. data=" + r5);
    L35:
        com.larus.voicecall.impl.utils.t.a("RealtimeCallSubtitleViewModel-onUpdateSubtitleData", 30, new p0(r5, this));
        Handler r9 = this.l;
        if (r9 == null) goto L39;
        r9.post(new y(this, r5));
        return;
    }

    public final <R> R o(Function1<? super LinkedList<a78.a>, ? extends R> r3) {
        ReentrantLock r0 = this.e;
        r0.lock();
        R r4 = (R) r3.invoke(this.f);
        r0.unlock();
        return r4;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void p(String r12) {
        FLogger.a.i("RealtimeCallSubtitleViewModel", "reset was called. from=".concat(r12));
        a("reset()");
        this.p.removeCallbacks(this.r);
        s(this, SubtitleListUpdateType.TTS_DELETE, null, null, null, null, null, null, null, 254);
        Handler r13 = this.l;
        if (r13 == null) goto L6;
        r13.post(new x(this));
        return;
    }

    public final void t(a78.a r14) {
        LruCache<String, String> r0 = this.E;
        String r1 = r14.d;
        if (r1 != null) goto L6;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if (r0.get(r1) != null) goto L11;
        LruCache<String, String> r2 = this.E;
        String r4 = r14.d;
        if (r4 != null) goto L10;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        r2.put(r4, NameKeys.UnloadStrategy_No_Strategy);
        FLogger.a.i("RealtimeCallSubtitleViewModel", "updateTtsText() new tts 。 ttsTaskId:" + r14.d + "  content=" + r14);
        String r3 = SubtitleListUpdateType.TTS_NEW;
    L18:
        String r5 = r3;
        RealtimeCallSubtitlePlugin.b r10 = r14.j;
        String r6 = r14.b;
        String r7 = r14.c;
        String r9 = r14.d;
        String r15 = r14.i;
        if (r15 != null) goto L21;
        String r11 = NameKeys.UnloadStrategy_No_Strategy;
    L22:
        s(this, r5, r6, r7, null, null, r9, r10, r11, 24);
        return;
    L21:
        r11 = r15;
        goto L22
    L11:
        boolean r8 = true;
        if (r14.f == true) goto L15;
        r8 = false;
    L15:
        if (r8 == false) goto L17;
        FLogger.a.e("RealtimeCallSubtitleViewModel", "updateTtsText() rewrite tts 。 ttsTaskId:" + r14.d + "  content=" + r14);
        r3 = SubtitleListUpdateType.TTS_REWRITE;
        goto L18
    L17:
        r3 = SubtitleListUpdateType.TTS_APPEND;
        goto L18
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void e(String r4, String r5) {
        if (r4 == null) goto L6;
        if (r5 == null) goto L6;
        this.u.put(r4, r5);
        FLogger.a.d("RealtimeCallSubtitleViewModel", "Mapped asrTaskId=" + r4 + " to questionId=" + r5);
    L6:
        if (z2.a.b0() == false) goto L9;
        p("onASRInfo");
        return;
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionId");
        Intrinsics.checkNotNullParameter(r3, "queryRound");
        q(r2, r3);
    }

    public final void q(final String r10, final String r11) {
        this.p.removeCallbacks(this.r);
        com.larus.voicecall.impl.utils.t.a("RealtimeCallSubtitleViewModel-onTTSPlayStart1", 1000, new a0(r10, r11, this));
        monitor-enter(this);
        boolean r3 = false;
        if (Intrinsics.areEqual(r10, this.B.getFirst()) == true) goto L7;
    L18:
        ReentrantLock r2 = this.e;     // Catch: Throwable -> L84
        r2.lock();     // Catch: Throwable -> L84
        LinkedList<a78.a> r7 = this.f;     // Catch: Throwable -> L81
        Intrinsics.checkNotNullParameter(r7, "$this$operateDataSource");     // Catch: Throwable -> L81
        Integer r8 = Integer.valueOf(r7.size());     // Catch: Throwable -> L81
        r2.unlock();     // Catch: Throwable -> L84
        if (r8.intValue() > 0) goto L25;
        com.larus.voicecall.impl.utils.t.a("RealtimeCallSubtitleViewModel-onTTSPlayStart3", 1000, new c0(r10, r11));     // Catch: Throwable -> L84
        monitor-exit(this);
        return;
    L25:
        this.B = new Pair(r10, r11);     // Catch: Throwable -> L84
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L84
        monitor-exit(this);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L74
        if (com.larus.utils.o0.d(r11) == false) goto L35;
        Long r6 = StringsKt.toLongOrNull(r11);     // Catch: Throwable -> L74
        if (r6 != null) goto L33;
    L34:
        this.t = r11;     // Catch: Throwable -> L74
        a("onTTSPlayStart()-sectionId:" + r10 + ", queryRound:" + r11);     // Catch: Throwable -> L74
        o(new d0(r11));     // Catch: Throwable -> L74
        goto L35
    L33:
        if (0 != r6.longValue()) goto L34;
    L35:
        ReentrantLock r1 = this.e;     // Catch: Throwable -> L74
        r1.lock();     // Catch: Throwable -> L74
        LinkedList<a78.a> r9 = this.f;     // Catch: Throwable -> L71
        Intrinsics.checkNotNullParameter(r9, "$this$operateDataSource");     // Catch: Throwable -> L71
        a78.a r12 = r9.peek();     // Catch: Throwable -> L71
        if (r12 != null) goto L39;
    L41:
        Boolean r13 = Boolean.valueOf(r3);     // Catch: Throwable -> L71
        r1.unlock();     // Catch: Throwable -> L74
        boolean r14 = r13.booleanValue();     // Catch: Throwable -> L74
        if ((SystemClock.elapsedRealtime() - this.C) <= 300) goto L50;
        FLogger r15 = FLogger.a;     // Catch: Throwable -> L74
        StringBuilder r16 = new StringBuilder("[onTTSPlayStart] sectionId:");     // Catch: Throwable -> L74
        r16.append(r10);     // Catch: Throwable -> L74
        r16.append(", size:");     // Catch: Throwable -> L74
        ReentrantLock r0 = this.e;     // Catch: Throwable -> L74
        r0.lock();     // Catch: Throwable -> L74
        LinkedList<a78.a> r17 = this.f;     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r17, "$this$operateDataSource");     // Catch: Throwable -> L47
        Integer r18 = Integer.valueOf(r17.size());     // Catch: Throwable -> L47
        r0.unlock();     // Catch: Throwable -> L74
        r16.append(r18.intValue());     // Catch: Throwable -> L74
        r16.append(",useTextContent:");     // Catch: Throwable -> L74
        r16.append(r14);     // Catch: Throwable -> L74
        r16.append(", queryRound=");     // Catch: Throwable -> L74
        r16.append(r11);     // Catch: Throwable -> L74
        r15.i("RealtimeCallSubtitleViewModel", r16.toString());     // Catch: Throwable -> L74
        this.C = SystemClock.elapsedRealtime();     // Catch: Throwable -> L74
        goto L50
    L47:
        th = move-exception;
        r0.unlock();     // Catch: Throwable -> L74
        throw th;     // Catch: Throwable -> L74
    L50:
        if (r14 == false) goto L52;
        r();     // Catch: Throwable -> L74
    L67:
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L74
    L76:
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 == null) goto L100;
        FLogger.a.e("RealtimeCallSubtitleViewModel", "onTTSPlayStart failed:" + r110, r110);
        return;
    L100:
        return;
    L52:
        ReentrantLock r111 = this.e;     // Catch: Throwable -> L74
        r111.lock();     // Catch: Throwable -> L74
        LinkedList<a78.a> r20 = this.f;     // Catch: Throwable -> L68
        Intrinsics.checkNotNullParameter(r20, "$this$operateDataSource");     // Catch: Throwable -> L68
        Iterator<T> r21 = r20.iterator();     // Catch: Throwable -> L68
    L54:
        a78.a r22 = null;
        if (r21.hasNext() == false) goto L59;
        Object r23 = r21.next();     // Catch: Throwable -> L68
        if (Intrinsics.areEqual(((a78.a) r23).a, r10) == false) goto L54;
    L60:
        a78.a r24 = (a78.a) r23;     // Catch: Throwable -> L68
        if (r24 == null) goto L64;
        r20.remove(r24);     // Catch: Throwable -> L68
        r22 = r24;
        goto L64
    L64:
        r111.unlock();     // Catch: Throwable -> L74
        if (r22 == null) goto L67;
        t(r22);     // Catch: Throwable -> L74
        goto L67
    L59:
        r23 = null;
    L68:
        th = move-exception;
        r111.unlock();     // Catch: Throwable -> L74
        throw th;     // Catch: Throwable -> L74
    L39:
        if (r12.g != true) goto L41;
        r3 = true;
    L71:
        th = move-exception;
        r1.unlock();     // Catch: Throwable -> L74
        throw th;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L76
    L81:
        th = move-exception;
        r2.unlock();     // Catch: Throwable -> L84
        throw th;     // Catch: Throwable -> L84
    L7:
        if (Intrinsics.areEqual(r11, this.B.getSecond()) == false) goto L18;
        Job r25 = this.g;     // Catch: Throwable -> L84
        if (r25 != null) goto L11;
    L13:
        boolean r26 = false;
    L14:
        if (r26 == false) goto L18;
        com.larus.voicecall.impl.utils.t.a("RealtimeCallSubtitleViewModel-onTTSPlayStart2", 1000, new b0(r10, r11, this));     // Catch: Throwable -> L84
        monitor-exit(this);
        return;
    L11:
        if (r25.isActive() != true) goto L13;
        r26 = true;
    L84:
        th = move-exception;
        throw th;
    }

    public final void u(String r14, String r15) {
        boolean r2 = false;
        if (r14.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        FLogger.a.w("RealtimeCallSubtitleViewModel", "withdrawRepliesByQuestionId: empty questionId, skip");
        return;
    L10:
        IntRange r1 = CollectionsKt.getIndices(this.o);
        ArrayList r4 = new ArrayList();
        Iterator r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L24;
        Object r5 = r3.next();
        c r6 = (c) ListProtector.get(this.o, ((Number) r5).intValue());
        DisplayType r7 = r6.c;
        if (r7 == DisplayType.REPLY_TXT) goto L18;
        if (r7 == DisplayType.REPLY_BLOCK) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L12;
        r4.add(r5);
    L18:
        if (Intrinsics.areEqual(r6.f, r14) == false) goto L20;
        r8 = true;
        goto L21
    L24:
        if (r4.isEmpty() == false) goto L28;
        FLogger.a.w("RealtimeCallSubtitleViewModel", "withdrawRepliesByQuestionId: no match, questionId=".concat(r14));
        return;
    L28:
        if (r15.length() != 0) goto L30;
        r2 = true;
    L30:
        if (r2 == false) goto L36;
        Iterator r16 = CollectionsKt.reversed(r4).iterator();
    L33:
        if (r16.hasNext() == false) goto L35;
        ListProtector.remove(this.o, ((Number) r16.next()).intValue());
        goto L33
    L35:
        FLogger.a.i("RealtimeCallSubtitleViewModel", "withdraw: removed " + r4.size() + " replies, questionId=" + r14);
    L41:
        this.h.tryEmit(new y0(SubtitleAction.REFRESH, 0, 0, false, 14));
        return;
    L36:
        int r9 = ((Number) CollectionsKt.first(r4)).intValue();
        c r10 = (c) ListProtector.get(this.o, r9);
        ArrayList<c> r12 = this.o;
        c r17 = c.a(r10, r15, null, DisplayType.REPLY_TXT, null, null, 58);
        r17.g = r10.g;
        String r11 = r10.j;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r17.j = r11;
        Unit r13 = Unit.INSTANCE;
        ListProtector.set(r12, r9, r17);
        Iterator r18 = CollectionsKt.reversed(CollectionsKt.drop(r4, 1)).iterator();
    L38:
        if (r18.hasNext() == false) goto L40;
        ListProtector.remove(this.o, ((Number) r18.next()).intValue());
        goto L38
    L40:
        FLogger.a.i("RealtimeCallSubtitleViewModel", "withdraw: replaced reply at index=" + r9 + ", removed " + (r4.size() - 1) + " trailing, questionId=" + r14);
        goto L41
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void l(boolean r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "asrTaskId");
        RealtimeCallUtil.a.getClass();
        if (((Boolean) RealtimeCallUtil.K.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        if (r12 == true) goto L9;
        r0.element = r13;
    L13:
        CharSequence r16 = (CharSequence) r0.element;
        if (r16 != null) goto L16;
    L19:
        boolean r17 = true;
    L20:
        if (r17 == false) goto L22;
        return;
    L22:
        final String r7 = r15 + "_asr";
        if (Intrinsics.areEqual(this.s, r7) == true) goto L25;
        String r18 = SubtitleListUpdateType.ASR_NEW;
    L26:
        final String r2 = r18;
        this.s = r7;
        f2a.c r19 = com.larus.voicecall.impl.utils.t.a.b("on asr response");
        r19.c.d = "RealtimeCallSubtitleViewModel";
        r19.f(new z(r2, r0, r7));
        f2a.c.c(r19, "onASRResponse", 13);
        String r110 = (String) ((LinkedHashMap) this.u).get(r15);
        if (r110 != null) goto L29;
        String r3 = r7;
    L30:
        s(this, r2, r3, (String) r0.element, null, null, r7, null, null, SpeechEvent.SERVER_DOWNLINK_EVENT_BOT_TRIGGERED);
        return;
    L29:
        r3 = r110;
        goto L30
    L25:
        r18 = SubtitleListUpdateType.ASR_REWRITE;
        goto L26
    L16:
        if (r16.length() == 0) goto L19;
        r17 = false;
        goto L20
    L9:
        if (RealtimeCallUtil.l() == false) goto L13;
        if (com.larus.utils.o0.d(r14) == false) goto L13;
        r0.element = r14;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [com.larus.voicecall.impl.subtitle.n0] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.voicecall.impl.subtitle.m0] */
    public q0(Flow r8, LiveData r9, LifecycleOwner r10, com.larus.voicecall.impl.tracer.w.a r11, IRealtimeCallTracer r12, com.larus.voicecall.impl.component.subtitle.t r13) {
        Intrinsics.checkNotNullParameter(r8, "callStateFlow");
        Intrinsics.checkNotNullParameter(r10, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r11, "subtitleTracerParam");
        Intrinsics.checkNotNullParameter(r12, "tracer");
        Intrinsics.checkNotNullParameter(r13, "argumentDataProvide");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = new ReentrantLock();
        this.f = new LinkedList();
        MutableSharedFlow<y0> r14 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.h = r14;
        this.i = r14;
        PthreadHandlerThreadV2 r15 = new PthreadHandlerThreadV2("realtime_call_subtitle");
        this.k = r15;
        this.o = new ArrayList();
        this.p = new Handler(Looper.getMainLooper());
        this.q = -1;
        this.r = new m0(this);
        this.u = new LinkedHashMap();
        StateFlowImpl r1 = kotlinx.coroutines.flow.j1.a(null);
        this.v = r1;
        this.w = r1;
        this.x = new LinkedHashSet();
        this.y = new LinkedHashSet();
        this.z = new AtomicBoolean(false);
        z2 r16 = z2.a;
        this.A = r16.enableRealtimeCallSubtitleOpt();
        boolean r2 = com.larus.voicecall.impl.tracer.w.c;
        Intrinsics.checkNotNullParameter(r11, "param");
        com.larus.voicecall.impl.tracer.w.d = r11;
        if (r9 == null) goto L5;
        r9.observe(r10, new b(new n0(this)));
    L5:
        ThreadMethodProxy.start(r15);
        this.l = new Handler(r15.getLooper());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new RealtimeCallSubtitleViewModel$2(r8, this, null), 3, null);
        this.B = new Pair(NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy);
        this.D = r16.N0();
        this.E = new LruCache(3);
    }

    public static void s(final q0 r13, final String r14, String r15, String r16, x3a.a r17, c r18, String r19, RealtimeCallSubtitlePlugin.b r20, String r21, int r22) {
        if ((r22 & 2) == 0) goto L5;
        final String r9 = null;
    L7:
        if ((r22 & 4) == 0) goto L9;
        final String r5 = null;
    L11:
        if ((r22 & 8) == 0) goto L13;
        final x3a.a r12 = null;
    L15:
        if ((r22 & 16) == 0) goto L17;
        final c r11 = null;
    L19:
        if ((r22 & 32) == 0) goto L21;
        final String r10 = null;
    L23:
        if ((r22 & 64) == 0) goto L25;
        final RealtimeCallSubtitlePlugin.b r7 = null;
    L27:
        if ((r22 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L29;
        final String r8 = NameKeys.UnloadStrategy_No_Strategy;
    L30:
        r13.p.post(new h0(r14, r5, r13, r7, r8, r9, r10, r11, r12));
        return;
    L29:
        r8 = r21;
        goto L30
    L25:
        r7 = r20;
        goto L27
    L21:
        r10 = r19;
        goto L23
    L17:
        r11 = r18;
        goto L19
    L13:
        r12 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r9 = r15;
        goto L7
    }
}
