package com.larus.dora.impl.guide.service;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class GuideSession {
    public static final /* synthetic */ int m = 0;
    public final int a;
    public i59.b b;
    public GuideSessionState c;
    public final String d;
    public final WeakReference<Context> e;
    public final List<Integer> f;
    public final CoroutineScope g;
    public final Function4<Integer, Integer, Integer, Integer, Unit> h;
    public l i;
    public final CopyOnWriteArrayList<l> j;
    public final List<Job> k;
    public final kotlinx.coroutines.sync.a l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/guide/service/GuideSession$GuideSessionState;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "STARTED", "PAUSED", "FINISHED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GuideSessionState extends Enum<GuideSessionState> {
        public static final GuideSessionState CREATED = null;
        public static final GuideSessionState FINISHED = null;
        public static final GuideSessionState PAUSED = null;
        public static final GuideSessionState STARTED = null;
        public static final /* synthetic */ GuideSessionState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<GuideSessionState> getEntries() {
            return b;
        }

        static {
            GuideSessionState r0 = new GuideSessionState("CREATED", 0);
            CREATED = r0;
            GuideSessionState r1 = new GuideSessionState("STARTED", 1);
            STARTED = r1;
            GuideSessionState r3 = new GuideSessionState("PAUSED", 2);
            PAUSED = r3;
            GuideSessionState r5 = new GuideSessionState("FINISHED", 3);
            FINISHED = r5;
            GuideSessionState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static GuideSessionState[] values() {
            return (GuideSessionState[]) a.clone();
        }

        public static GuideSessionState valueOf(String r1) {
            return (GuideSessionState) r27.a.a(GuideSessionState.class, r1);
        }

        public GuideSessionState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public GuideSession() {
        throw null;
    }

    public final synchronized void d() {
        monitor-enter(this);
        g49.d.d(c(), "launch() start");     // Catch: Throwable -> L10
        Iterator<T> r0 = this.k.iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        Job.DefaultImpls.cancel$default((Job) r0.next(), null, 1, null);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.k.clear();     // Catch: Throwable -> L10
        e(new GuideSession$launch$2(this, null));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void i() {
        monitor-enter(this);
        g49.d.d(c(), "stop() start");     // Catch: Throwable -> L10
        Iterator<T> r0 = this.k.iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        Job.DefaultImpls.cancel$default((Job) r0.next(), null, 1, null);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.k.clear();     // Catch: Throwable -> L10
        e(new GuideSession$stop$2(this, null));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final String c() {
        StringBuilder r4 = new StringBuilder("GuideSession(id=");     // Catch: Exception -> L9
        r4.append(this.a);     // Catch: Exception -> L9
        r4.append(", page=");     // Catch: Exception -> L9
        r4.append(this.d);     // Catch: Exception -> L9
        r4.append(", state=");     // Catch: Exception -> L9
        r4.append(this.c);     // Catch: Exception -> L9
        r4.append(", currentGuideId=");     // Catch: Exception -> L9
        l r5 = this.i;     // Catch: Exception -> L9
        if (r5 == null) goto L6;
        Integer r6 = Integer.valueOf(r5.f());     // Catch: Exception -> L9
    L7:
        r4.append(r6);     // Catch: Exception -> L9
        r4.append(", remainingGuideCount=");     // Catch: Exception -> L9
        r4.append(this.j.size());     // Catch: Exception -> L9
        r4.append(')');     // Catch: Exception -> L9
        return r4.toString();
    L6:
        r6 = null;
    L9:
        e = move-exception;
        g49.d.c("GuideSession", "get tag failed: " + e.getMessage(), e);
        return "GuideSession(id=" + this.a + ", page=" + this.d + ", state=" + this.c + ')';
    }

    public final WeakReference<Context> getContext() {
        return this.e;
    }

    public final void b(DoraGuideMeta r4) {
        Intrinsics.checkNotNullParameter(r4, "guideMeta");
        g49.d.d(c(), "dismissGuide() start, guideMeta=" + r4);
        e(new GuideSession$dismissGuide$2(this, r4, null));
    }

    public final void e(Function1<? super Continuation<? super Unit>, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "block");
        final Job r9 = BuildersKt.launch$default(this.g, Dispatchers.getIO(), null, new GuideSession$launchWithMutex$job$1(this, r8, null), 2, null);
        this.k.add(r9);
        r9.invokeOnCompletion(new c(this, r9));
    }

    public final void g(DoraGuideMeta r4) {
        Intrinsics.checkNotNullParameter(r4, "guideMeta");
        g49.d.d(c(), "pushGuide() start, guideMeta=" + r4);
        e(new GuideSession$pushGuide$1(this, r4, null));
    }

    public final void h(GuideSessionState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public static Object f(Function1 r3, Continuation r4) {
        Object r5 = BuildersKt.withContext(Dispatchers.getMain(), new GuideSession$onMain$2(r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object a(GuideSession r4, l r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof GuideSession$dismissSafe$1) == false) goto L7;
        GuideSession$dismissSafe$1 r0 = (GuideSession$dismissSafe$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L21
    L19:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L27;
        g49.d.c(r4.c(), "dismissGuide() exception: " + r9.getMessage(), r9);
        r4.c = GuideSessionState.FINISHED;
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        GuideSession$dismissSafe$2$1 r11 = new GuideSession$dismissSafe$2$1(r5, null, null, null);     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        if (f(r11, r0) != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new GuideSession$dismissSafe$1(r4, r6);
        goto L8
    }

    public GuideSession(int r6, String r7, WeakReference r8, List r9, LifecycleCoroutineScope r10, Function4 r11) {
        GuideSessionState r0 = GuideSessionState.CREATED;
        CopyOnWriteArrayList<l> r1 = new CopyOnWriteArrayList();
        List<Job> r2 = Collections.synchronizedList(new ArrayList());
        MutexImpl r3 = kotlinx.coroutines.sync.b.a();
        Intrinsics.checkNotNullParameter(r0, "state");
        Intrinsics.checkNotNullParameter(r7, "page");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "guideFilterList");
        Intrinsics.checkNotNullParameter(r10, "lifeCycleScope");
        Intrinsics.checkNotNullParameter(r11, "guideListener");
        Intrinsics.checkNotNullParameter(r1, "remainingGuides");
        Intrinsics.checkNotNullParameter(r2, "orchestratorJobs");
        Intrinsics.checkNotNullParameter(r3, "mutex");
        this.a = r6;
        this.b = null;
        this.c = r0;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = null;
        this.j = r1;
        this.k = r2;
        this.l = r3;
    }
}
