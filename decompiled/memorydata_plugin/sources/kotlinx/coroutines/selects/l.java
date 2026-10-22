package kotlinx.coroutines.selects;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.internal.ag;
import kotlinx.coroutines.internal.ai;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001HB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0010\u0010\u001e\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u000e\u0010\u001f\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\u00028\u0000H\u0091@¢\u0006\u0002\u0010 J\u000e\u0010%\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010 J\u001c\u0010&\u001a\u000e\u0018\u00010\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010*\u001a\u00020\u001b2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020\u0014H\u0016J*\u0010.\u001a\u00028\u00002\u0010\u0010/\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u00102\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u00103\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u00105\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000eJ\u001a\u00107\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u00108\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010 J0\u0010'\u001a\u00020\u001b*\u0002092\u001c\u0010:\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0;H\u0096\u0002¢\u0006\u0002\u0010=JB\u0010'\u001a\u00020\u001b\"\u0004\b\u0001\u0010>*\b\u0012\u0004\u0012\u0002H>0?2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002¢\u0006\u0002\u0010AJV\u0010'\u001a\u00020\u001b\"\u0004\b\u0001\u0010B\"\u0004\b\u0002\u0010>*\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H>0C2\u0006\u0010D\u001a\u0002HB2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002¢\u0006\u0002\u0010EJ \u0010F\u001a\u00020\u001b*\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010G\u001a\u00020\u0010H\u0001R$\u0010\b\u001a\u0014\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019X\u0082\u0004¨\u0006I"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "clauses", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposableHandleOrSegment", "", "inRegistrationPhase", "", "getInRegistrationPhase", "()Z", "indexInSegment", "", "internalResult", "isCancelled", "isSelected", "state", "Lkotlinx/atomicfu/AtomicRef;", "checkClauseObject", "", "clauseObject", SlardarSettingsConstants.SETTING_GENERAL_CLEANUP, "selectedClause", "complete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "doSelect", "doSelectSuspend", "findClause", "invoke", "cause", "", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "processResultAndInvokeBlockRecoveringException", "clause", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reregisterClause", "selectInRegistrationPhase", "trySelect", "result", "trySelectDetailed", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "waitUntilSelected", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", com.tom_roush.pdfbox.pdmodel.a.d.i.m, "Lkotlinx/coroutines/selects/SelectClause2;", AutoTestConstant.PARAM, "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "register", "reregister", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class l<R> implements kotlinx.coroutines.m, c<R>, n<R> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f17638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<l<R>.a> f17639b;
    private Object c;
    private int d;
    private Object e;
    private volatile /* synthetic */ Object state$volatile;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B¶\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b\u0012U\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000e\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012g\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u0014¢\u0006\u0002\u0010\u0015J*\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001a\u001a\u00020\nJ\u0018\u0010\u001b\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0014\u0010 \u001a\u00020!2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\"R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000Rq\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u00148\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "regFunc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "Lkotlinx/coroutines/selects/SelectInstance;", "select", AutoTestConstant.PARAM, "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "block", "onCancellationConstructor", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "disposableHandleOrSegment", "indexInSegment", "", "createOnCancellationAction", "dispose", "invokeBlock", "argument", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResult", "result", "tryRegisterAsWaiter", "", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f17640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function3<m<?>, Object, Object, Function1<Throwable, Unit>> f17641b;
        public Object c;
        public int d;
        final /* synthetic */ l<R> e;
        private final Function3<Object, m<?>, Object, Unit> f;
        private final Function3<Object, Object, Object, Object> g;
        private final Object h;
        private final Object i;

        public a(l r3, Object r4, Function3<Object, ? super m<?>, Object, Unit> r5, Function3<Object, Object, Object, ? extends Object> r6, Object r7, Object r8, Function3<? super m<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> r9) {
            Function3<Object, m<?>, Object, Unit> r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
            Function3<Object, Object, Object, Object> r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
            Function3<m<?>, Object, Object, Function1<Throwable, Unit>> r12 = (Function3) ZeusTransformUtils.wrapperContextForParams(r9, Function3.class, "com.obric.memorydata.plugin");
            this.e = r3;
            this.f17640a = r4;
            this.f = r10;
            this.g = r11;
            this.h = r7;
            this.i = r8;
            this.f17641b = r12;
            this.d = -1;
        }

        public final Object a(Object r3) {
            return this.g.invoke(this.f17640a, this.h, r3);
        }

        public final Object a(Object r4, Continuation<? super R> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r0 = this.i;
            if (this.h != o.a()) goto L6;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
            Function1 r3 = (Function1) ZeusTransformUtils.preCheckCast(r0, Function1.class, "com.obric.memorydata.plugin");
            return ((Function1) ZeusTransformUtils.preCheckCast(r0, Function1.class, "com.obric.memorydata.plugin")).invoke(r6);
        L6:
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            Function2 r7 = (Function2) ZeusTransformUtils.preCheckCast(r0, Function2.class, "com.obric.memorydata.plugin");
            return ((Function2) ZeusTransformUtils.preCheckCast(r0, Function2.class, "com.obric.memorydata.plugin")).invoke(r4, r6);
        }

        public final Function1<Throwable, Unit> a(m<?> r3, Object r4) {
            m<?> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            Function3<m<?>, Object, Object, Function1<Throwable, Unit>> r0 = this.f17641b;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (Function1) ZeusTransformUtils.preCheckCast(r0.invoke(r5, this.h, r4), Function1.class, "com.obric.memorydata.plugin");
        }

        public final void a() {
            Object r0 = this.c;
            l<R> r1 = this.e;
            bc r3 = null;
            if (ZeusTransformUtils.instanceOf(r0, ag.class) == false) goto L6;
            ((ag) ZeusTransformUtils.preCheckCast(r0, ag.class, "com.obric.memorydata.plugin")).a(this.d, null, r1.getContext());
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r0, bc.class) == false) goto L8;
            r3 = (bc) ZeusTransformUtils.preCheckCast(r0, bc.class, "com.obric.memorydata.plugin");
        L8:
            if (r3 == null) goto L12;
            r3.dispose();
            return;
        }

        public final boolean a(l<R> r5) {
            if (an.a() == false) goto L16;
            if (l.b(r5) == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            if (r0 == true) goto L16;
            throw new AssertionError();
        L7:
            if (l.c(r5) == true) goto L10;
            r0 = false;
        L16:
            if (an.a() == true) goto L18;
        L25:
            this.f.invoke(this.f17640a, r5, this.h);
            if (l.a(r5) == o.d()) goto L28;
            return false;
        L28:
            return true;
        L18:
            if (l.a(r5) != o.d()) goto L20;
            boolean r1 = true;
        L21:
            if (r1 == true) goto L25;
            throw new AssertionError();
        L20:
            r1 = false;
            goto L21
        }
    }

    static {
        f = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "state$volatile");
    }

    public l(CoroutineContext r3) {
        this.f17638a = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        this.state$volatile = o.c();
        this.f17639b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(2), List.class, "com.obric.memorydata.plugin");
        this.d = -1;
        this.e = o.d();
    }

    private final Object a(l<R>.a r5, Object r6, Continuation<? super R> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, SelectImplementation$processResultAndInvokeBlockRecoveringException$1.class) == false) goto L7;
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = (SelectImplementation$processResultAndInvokeBlockRecoveringException$1) ZeusTransformUtils.preCheckCast(r8, SelectImplementation$processResultAndInvokeBlockRecoveringException$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L16;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L13
    L30:
        return r4;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r4);
        Object r10 = r5.a(r6);     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r4 = r5.a(r10, r0);     // Catch: Throwable -> L13
        if (r4 != r9) goto L30;
        return r9;
    L13:
        th = move-exception;
        if (an.c() == true) goto L25;
        throw th;
    L25:
        if (ZeusTransformUtils.instanceOf(r0, CoroutineStackFrame.class) == true) goto L28;
        throw th;
    L28:
        throw ai.a(th, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r0, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L7:
        r0 = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(this, r8);
        goto L8
    }

    public static final /* synthetic */ Object a(l r0) {
        return r0.e;
    }

    static /* synthetic */ <R> Object a(l<R> r2, Continuation<? super R> r3) {
        Continuation<? super R> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if (r2.c() == false) goto L7;
        return r2.d(r4);
    L7:
        return r2.b(r4);
    }

    public static final /* synthetic */ Object a(l r2, a r3, Object r4, Continuation r5) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater a() {
        return e();
    }

    private final void a(l<R>.a r5) {
        if (an.a() == true) goto L5;
    L9:
        List<l<R>.a> r0 = this.f17639b;
        if (r0 != null) goto L12;
        return;
    L12:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r1.hasNext() == false) goto L18;
        l<R>.a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin");
        if (r2 == r5) goto L14;
        r2.a();
        goto L14
    L18:
        e().set(this, o.f());
        this.e = o.d();
        this.f17639b = null;
        return;
    L5:
        if (Intrinsics.areEqual(e().get(this), r5) == true) goto L9;
        throw new AssertionError();
    }

    public static final /* synthetic */ void a(l r0, Object r1) {
        r0.c(r1);
    }

    public static /* synthetic */ void a(l r0, a r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        r0.a(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    private final Object b(Continuation<? super R> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, SelectImplementation$doSelectSuspend$1.class) == false) goto L7;
        SelectImplementation$doSelectSuspend$1 r0 = (SelectImplementation$doSelectSuspend$1) ZeusTransformUtils.preCheckCast(r8, SelectImplementation$doSelectSuspend$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L22:
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        l<R> this = (l) ZeusTransformUtils.preCheckCast(r0.L$0, l.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L19:
        r0.L$0 = null;
        r0.label = 2;
        r9 = this.d(r0);
        if (r9 != r2) goto L22;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        r0.L$0 = this;
        r0.label = 1;
        if (c(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new SelectImplementation$doSelectSuspend$1(this, r8);
        goto L8
    }

    public static final /* synthetic */ Object b(l r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final void b(Object r6) {
        List<l<R>.a> r5 = this.f17639b;
        Intrinsics.checkNotNull(r5);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L6;
        if (((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).f17640a != r6) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L9;
    L15:
        if (r2 == false) goto L18;
        return;
    L18:
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + r6).toString());
    L13:
        r0 = false;
    L6:
        r2 = true;
        goto L15
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private final boolean b() {
        Object r1 = e().get(this);
        if (r1 != o.c()) goto L5;
    L8:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, List.class) == true) goto L8;
        return false;
    }

    public static final /* synthetic */ boolean b(l r0) {
        return r0.b();
    }

    private final int c(Object r7, Object r8) {
    L2:
        Object r0 = e().get(this);
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.n.class) == true) goto L4;
        if (Intrinsics.areEqual(r0, o.f()) == false) goto L18;
        boolean r1 = true;
    L19:
        if (r1 == true) goto L20;
        if (Intrinsics.areEqual(r0, o.e()) == true) goto L24;
        if (Intrinsics.areEqual(r0, o.c()) == true) goto L28;
        if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L36;
        if (e().compareAndSet(this, r0, CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), r7)) == false) goto L2;
        return 1;
    L36:
        throw new IllegalStateException(("Unexpected state: " + r0).toString());
    L28:
        if (e().compareAndSet(this, r0, CollectionsKt.listOf(r7)) == false) goto L2;
        return 1;
    L24:
        return 2;
    L20:
        return 3;
    L18:
        r1 = ZeusTransformUtils.instanceOf(r0, a.class);
        goto L19
    L4:
        l<R>.a r2 = d(r7);
        if (r2 == null) goto L2;
        Function1<Throwable, Unit> r4 = r2.a((m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin"), r8);
        if (e().compareAndSet(this, r0, r2) == false) goto L2;
        kotlinx.coroutines.n r9 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        this.e = r8;
        if (o.a(r9, r4) == false) goto L13;
        return 0;
    L13:
        this.e = o.d();
        return 2;
    }

    private final Object c(Continuation<? super Unit> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r9), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        AtomicReferenceFieldUpdater r3 = a();
    L3:
        Object r4 = r3.get(this);
        if (r4 == o.c()) goto L6;
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L17;
        if (a().compareAndSet(this, r4, o.c()) == false) goto L3;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r6.hasNext() == false) goto L3;
        a(this, r6.next());
        goto L14
    L17:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L28;
        r2.a(Unit.INSTANCE, ((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin")).a((m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin"), a(this)));
    L19:
        Object r7 = r0.h();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L23:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        return r7;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException(("unexpected state: " + r4).toString());
    L6:
        if (a().compareAndSet(this, r4, r2) == false) goto L3;
        kotlinx.coroutines.q.a(r2, (kotlinx.coroutines.m) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.m.class, "com.obric.memorydata.plugin"));
        goto L19
    }

    private final void c(Object r2) {
        l<R>.a r3 = d(r2);
        Intrinsics.checkNotNull(r3);
        r3.c = null;
        r3.d = -1;
        a(r3, true);
    }

    private final boolean c() {
        return ZeusTransformUtils.instanceOf(e().get(this), a.class);
    }

    public static final /* synthetic */ boolean c(l r0) {
        return r0.d();
    }

    private final Object d(Continuation<? super R> r4) {
        Continuation<? super R> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if (an.a() == true) goto L5;
    L9:
        Object r0 = e().get(this);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        l<R>.a r1 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        Object r2 = this.e;
        a(r1);
        if (an.c() == true) goto L14;
        return r1.a(r1.a(r2), r5);
    L14:
        return a(r1, r2, r5);
    L5:
        if (c() == true) goto L9;
        throw new AssertionError();
    }

    private final l<R>.a d(Object r5) {
        List<l<R>.a> r4 = this.f17639b;
        Object r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        if (((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin")).f17640a != r5) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
        r0 = r1;
        goto L14
    L11:
        r3 = false;
    L14:
        l<R>.a r7 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        return r7;
    L18:
        throw new IllegalStateException(("Clause with object " + r5 + " is not found").toString());
    }

    private final boolean d() {
        if (e().get(this) != o.e()) goto L5;
        return true;
    L5:
        return false;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater e() {
        return f;
    }

    public Object a(Continuation<? super R> r3) {
        return a(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.selects.m
    public void a(Object r1) {
        this.e = r1;
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable r4) {
        AtomicReferenceFieldUpdater r5 = e();
    L3:
        Object r0 = r5.get(this);
        if (r0 == o.f()) goto L5;
        if (r5.compareAndSet(this, r0, o.e()) == false) goto L3;
        List<l<R>.a> r6 = this.f17639b;
        if (r6 != null) goto L11;
        return;
    L11:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        ((a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.memorydata.plugin")).a();
        goto L13
    L15:
        this.e = o.d();
        this.f17639b = null;
        return;
    }

    @Override // kotlinx.coroutines.selects.m
    public void a(bc r3) {
        this.c = (bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.de
    public void a(ag<?> r1, int r2) {
        this.c = r1;
        this.d = r2;
    }

    @Override // kotlinx.coroutines.selects.c
    public void a(f r9, Function1<? super Continuation<? super R>, ? extends Object> r10) {
        f r11 = (f) ZeusTransformUtils.wrapperContextForParams(r9, f.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        a(this, new a(this, r11.a(), r11.b(), r11.c(), o.a(), r6, r11.d()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.c
    public <Q> void a(h<? extends Q> r9, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r10) {
        h r11 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        a(this, new a(this, r11.a(), r11.b(), r11.c(), null, r6, r11.d()), false, 1, null);
    }

    public final void a(l<R>.a r3, boolean r4) {
        if (an.a() == false) goto L13;
        if (e().get(this) == o.e()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (ZeusTransformUtils.instanceOf(e().get(this), a.class) == false) goto L15;
        return;
    L15:
        if (r4 == true) goto L18;
        b(r3.f17640a);
    L18:
        if (r3.a(this) == false) goto L22;
        if (r4 == true) goto L21;
        List<l<R>.a> r5 = this.f17639b;
        Intrinsics.checkNotNull(r5);
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).add(r3);
    L21:
        r3.c = this.c;
        r3.d = this.d;
        this.c = null;
        this.d = -1;
        return;
    L22:
        e().set(this, r3);
    }

    @Override // kotlinx.coroutines.selects.m
    public boolean a(Object r1, Object r2) {
        if (c(r1, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final TrySelectDetailedResult b(Object r1, Object r2) {
        return o.a(c(r1, r2));
    }

    @Override // kotlinx.coroutines.selects.m
    public CoroutineContext getContext() {
        return this.f17638a;
    }
}
