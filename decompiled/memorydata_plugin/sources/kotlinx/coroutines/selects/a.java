package kotlinx.coroutines.selects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002R\u0017\u0010\u0005\u001a\u00020\u00068F¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/selects/OnTimeout;", "", "timeMillis", "", "(J)V", "selectClause", "Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause$annotations", "()V", "getSelectClause", "()Lkotlinx/coroutines/selects/SelectClause0;", "register", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17628a;

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class RunnableC0883a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f17629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17630b;

        public RunnableC0883a(m r3, a r4) {
            this.f17629a = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            this.f17630b = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f17629a.a(this.f17630b, Unit.INSTANCE);
        }
    }

    public a(long r1) {
        this.f17628a = r1;
    }

    public static final /* synthetic */ void a(a r2, m r3, Object r4) {
        r2.a((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void a(m<?> r6, Object r7) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.memorydata.plugin");
        if (this.f17628a > 0) goto L6;
        r8.a(Unit.INSTANCE);
        return;
    L6:
        Runnable r9 = (Runnable) ZeusTransformUtils.preCheckCast(new RunnableC0883a(r8, this), Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        l r0 = (l) ZeusTransformUtils.preCheckCast(r8, l.class, "com.obric.memorydata.plugin");
        CoroutineContext r1 = r8.getContext();
        r8.a(au.a(r1).a(this.f17628a, r9, r1));
    }

    public final f a() {
        OnTimeout$selectClause$1 r0 = OnTimeout$selectClause$1.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return (f) ZeusTransformUtils.preCheckCast(new g(this, (Function3) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, 3), Function3.class, "com.obric.memorydata.plugin"), null, 4, null), f.class, "com.obric.memorydata.plugin");
    }
}
