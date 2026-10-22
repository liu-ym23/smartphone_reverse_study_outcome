package kotlinx.coroutines.sync;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.de;
import kotlinx.coroutines.internal.ag;
import kotlinx.coroutines.internal.aj;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.q;
import kotlinx.coroutines.selects.m;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002+,B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010 \u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0082@¢\u0006\u0002\u0010!J\u001e\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010\nH\u0014J\u001e\u0010%\u001a\u00020\u00192\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010)\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010*\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\t8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eRk\u0010\u000f\u001a_\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u0010j\u0002`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001cX\u0082\u0004¨\u0006-"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "(Z)V", "isLocked", "()Z", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSelectCancellationUnlockConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "select", AutoTestConstant.PARAM, "internalResult", "Lkotlin/Function1;", "", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "owner", "Lkotlinx/atomicfu/AtomicRef;", "holdsLock", "holdsLockImpl", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "onLockProcessResult", "result", "onLockRegFunction", "toString", "", "tryLock", "tryLockImpl", "unlock", "CancellableContinuationWithOwner", "SelectInstanceWithOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class b extends e implements kotlinx.coroutines.sync.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17648b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function3<m<?>, Object, Object, Function1<Throwable, Unit>> f17649a;
    private volatile /* synthetic */ Object owner$volatile;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007H\u0097\u0001J\t\u0010\u0017\u001a\u00020\u0002H\u0097\u0001J2\u0010\u0018\u001a\u00020\u00022'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00020\u001aj\u0002`\u001dH\u0096\u0001J\u001d\u0010\u0018\u001a\u00020\u00022\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020!H\u0096\u0001J:\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022#\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\u00020\u00022\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0096\u0001¢\u0006\u0002\u0010)J$\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007H\u0097\u0001¢\u0006\u0002\u0010,JF\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00072#\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010/\u001a\u00020\u0014H\u0097\u0001J\u001a\u00100\u001a\u00020\u0002*\u0002012\u0006\u0010#\u001a\u00020\u0002H\u0097\u0001¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\u0002*\u0002012\u0006\u0010/\u001a\u00020\u0014H\u0097\u0001R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "isActive", "", "()Z", "isCancelled", "isCompleted", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cause", "", "completeResume", "token", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "Lkotlinx/coroutines/CompletionHandler;", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "resume", EventBody.KEY_VALUE, "onCancellation", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function1;)V", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "tryResume", "idempotent", "(Lkotlin/Unit;Ljava/lang/Object;)Ljava/lang/Object;", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeWithException", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/Unit;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class a implements de, n<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o<Unit> f17650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17651b;
        final /* synthetic */ b c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(b r1, o<? super Unit> r2, Object r3) {
            this.c = r1;
            this.f17650a = r2;
            this.f17651b = r3;
        }

        @Override // kotlinx.coroutines.n
        public /* synthetic */ Object a(Unit r3, Object r4, Function1 r5) {
            Function1<? super Throwable, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            return a2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), r4, r6);
        }

        @Override // kotlinx.coroutines.n
        public Object a(Throwable r1) {
            return this.f17650a.a(r1);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public Object a2(Unit r6, Object r7, Function1<? super Throwable, Unit> r8) {
            Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
            b r10 = this.c;
            boolean r2 = true;
            if (an.a() == true) goto L5;
        L12:
            o<Unit> r11 = this.f17650a;
            final b r4 = this.c;
            Object r12 = r11.a(r6, r7, (Function1) ZeusTransformUtils.preCheckCast(new MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(r4, this), Function1.class, "com.obric.memorydata.plugin"));
            if (r12 == null) goto L25;
            b r13 = this.c;
            if (an.a() == true) goto L17;
        L24:
            b.b().set(this.c, this.f17651b);
            goto L25
        L17:
            if (b.b().get(r13) == c.a()) goto L20;
            r2 = false;
        L20:
            if (r2 == true) goto L24;
            throw new AssertionError();
        L25:
            return r12;
        L5:
            if (b.b().get(r10) != c.a()) goto L7;
            boolean r14 = true;
        L8:
            if (r14 == true) goto L12;
            throw new AssertionError();
        L7:
            r14 = false;
            goto L8
        }

        @Override // kotlinx.coroutines.n
        public void a(Object r1) {
            this.f17650a.a(r1);
        }

        @Override // kotlinx.coroutines.n
        public /* synthetic */ void a(Unit r3, Function1 r4) {
            Function1<? super Throwable, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            a2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), r5);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(Unit r4, Function1<? super Throwable, Unit> r5) {
            Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            b r7 = this.c;
            if (an.a() == true) goto L5;
        L12:
            b.b().set(this.c, this.f17651b);
            o<Unit> r8 = this.f17650a;
            final b r2 = this.c;
            r8.a(r4, (Function1) ZeusTransformUtils.preCheckCast(new MutexImpl$CancellableContinuationWithOwner$resume$2(r2, this), Function1.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            if (b.b().get(r7) != c.a()) goto L7;
            boolean r9 = true;
        L8:
            if (r9 == true) goto L12;
            throw new AssertionError();
        L7:
            r9 = false;
            goto L8
        }

        @Override // kotlinx.coroutines.n
        public void a(Function1<? super Throwable, Unit> r3) {
            Function1<? super Throwable, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            this.f17650a.a(r4);
        }

        @Override // kotlinx.coroutines.n
        public /* synthetic */ void a(ah r3, Unit r4) {
            a2(r3, (Unit) ZeusTransformUtils.preCheckCast(r4, Unit.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.n
        public void a(ah r1, Throwable r2) {
            this.f17650a.a(r1, r2);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(ah r1, Unit r2) {
            this.f17650a.a(r1, r2);
        }

        @Override // kotlinx.coroutines.de
        public void a(ag<?> r1, int r2) {
            this.f17650a.a(r1, r2);
        }

        @Override // kotlinx.coroutines.n
        public boolean a() {
            return this.f17650a.a();
        }

        @Override // kotlinx.coroutines.n
        public boolean b() {
            return this.f17650a.b();
        }

        @Override // kotlinx.coroutines.n
        public boolean b(Throwable r1) {
            return this.f17650a.b(r1);
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f17650a.getContext();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r1) {
            this.f17650a.resumeWith(r1);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u001d\u0010\u000f\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016R\u0012\u0010\u0007\u001a\u00020\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner;", "Q", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "select", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/selects/SelectInstanceInternal;Ljava/lang/Object;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposeOnCompletion", "", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "selectInRegistrationPhase", "internalResult", "trySelect", "", "clauseObject", "result", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class C0885b<Q> implements kotlinx.coroutines.selects.n<Q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kotlinx.coroutines.selects.n<Q> f17652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17653b;
        final /* synthetic */ b c;

        public C0885b(b r3, kotlinx.coroutines.selects.n<Q> r4, Object r5) {
            kotlinx.coroutines.selects.n<Q> r6 = (kotlinx.coroutines.selects.n) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.selects.n.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.f17652a = r6;
            this.f17653b = r5;
        }

        @Override // kotlinx.coroutines.selects.m
        public void a(Object r4) {
            b r0 = this.c;
            if (an.a() == true) goto L5;
        L12:
            b.b().set(this.c, this.f17653b);
            this.f17652a.a(r4);
            return;
        L5:
            if (b.b().get(r0) != c.a()) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L12;
            throw new AssertionError();
        L7:
            r1 = false;
            goto L8
        }

        @Override // kotlinx.coroutines.selects.m
        public void a(bc r3) {
            bc r4 = (bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.memorydata.plugin");
            this.f17652a.a(r4);
        }

        @Override // kotlinx.coroutines.de
        public void a(ag<?> r1, int r2) {
            this.f17652a.a(r1, r2);
        }

        @Override // kotlinx.coroutines.selects.m
        public boolean a(Object r3, Object r4) {
            b r0 = this.c;
            if (an.a() == true) goto L5;
        L12:
            boolean r5 = this.f17652a.a(r3, r4);
            b r6 = this.c;
            if (r5 == false) goto L15;
            b.b().set(r6, this.f17653b);
        L15:
            return r5;
        L5:
            if (b.b().get(r0) != c.a()) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L12;
            throw new AssertionError();
        L7:
            r1 = false;
            goto L8
        }

        @Override // kotlinx.coroutines.selects.m
        public CoroutineContext getContext() {
            return this.f17652a.getContext();
        }
    }

    static {
        f17648b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner$volatile");
    }

    public b(boolean r3) {
        super(1, r3 ? 1 : 0);
        if (r3 == false) goto L5;
        aj r4 = null;
    L6:
        this.owner$volatile = r4;
        this.f17649a = (Function3) ZeusTransformUtils.preCheckCast(new MutexImpl$onSelectCancellationUnlockConstructor$1(this), Function3.class, "com.obric.memorydata.plugin");
        return;
    L5:
        r4 = c.a();
        goto L6
    }

    static /* synthetic */ Object a(b r2, Object r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if (r2.a(r3) == true) goto L5;
        Object r6 = r2.b(r3, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r6;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final Object b(Object r4, Continuation<? super Unit> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = q.a(IntrinsicsKt.intercepted(r6));
        a((n) ZeusTransformUtils.preCheckCast(new a(this, r0, r4), n.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        Object r3 = r0.h();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L8:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        return r3;
    L11:
        return Unit.INSTANCE;
    L12:
        th = move-exception;
        r0.i();
        throw th;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater b() {
        return f();
    }

    private final int d(Object r3) {
    L3:
        if (a() == false) goto L4;
        Object r0 = f().get(this);
        if (r0 == c.a()) goto L3;
        if (r0 != r3) goto L10;
        return 1;
    L10:
        return 2;
    L4:
        return 0;
    }

    private final int e(Object r5) {
    L2:
        boolean r1 = true;
        if (e() == true) goto L5;
        if (r5 == null) goto L17;
        int r0 = d(r5);
        if (r0 == 1) goto L23;
        if (r0 != 2) goto L2;
        return 1;
    L23:
        return 2;
    L17:
        return 1;
    L5:
        if (an.a() == true) goto L7;
    L14:
        f().set(this, r5);
        return 0;
    L7:
        if (f().get(this) == c.a()) goto L10;
        r1 = false;
    L10:
        if (r1 == true) goto L14;
        throw new AssertionError();
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater f() {
        return f17648b;
    }

    public Object a(Object r2, Object r3) {
        if (Intrinsics.areEqual(r3, c.b()) == true) goto L6;
        return this;
    L6:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r2).toString());
    }

    @Override // kotlinx.coroutines.sync.a
    public Object a(Object r3, Continuation<? super Unit> r4) {
        return a(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public void a(m<?> r4, Object r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L7:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        b((m) ZeusTransformUtils.preCheckCast(new C0885b(this, (kotlinx.coroutines.selects.n) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.selects.n.class, "com.obric.memorydata.plugin"), r5), m.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        if (c(r5) == false) goto L7;
        r6.a(c.b());
    }

    public boolean a() {
        if (d() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean a(Object r3) {
        int r2 = e(r3);
        if (r2 == 0) goto L13;
        if (r2 != 1) goto L6;
        return false;
    L6:
        if (r2 == 2) goto L10;
        throw new IllegalStateException("unexpected".toString());
    L10:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r3).toString());
    L13:
        return true;
    }

    @Override // kotlinx.coroutines.sync.a
    public void b(Object r4) {
    L3:
        if (a() == false) goto L19;
        Object r0 = f().get(this);
        if (r0 == c.a()) goto L3;
        if (r0 == r4) goto L10;
        if (r4 == null) goto L10;
        boolean r1 = false;
    L11:
        if (r1 == false) goto L17;
        if (f().compareAndSet(this, r0, c.a()) == false) goto L3;
        c();
        return;
    L17:
        throw new IllegalStateException(("This mutex is locked by " + r0 + ", but " + r4 + " is expected").toString());
    L10:
        r1 = true;
        goto L11
    L19:
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public boolean c(Object r1) {
        if (d(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "Mutex@" + ao.a(this) + "[isLocked=" + a() + ",owner=" + f().get(this) + ']';
    }
}
