package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nOnTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,66:1\n17#2:67\n*S KotlinDebug\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n56#1:67\n*E\n"})
final class OnTimeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10654a;

    @SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n1#1,18:1\n57#2,2:19\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f10655c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OnTimeout f10656g;

        public a(k r10, OnTimeout r11) {
            this.f10655c = r10;
            this.f10656g = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f10655c.d(this.f10656g, Unit.INSTANCE);
        }
    }

    public OnTimeout(long r10) {
        this.f10654a = r10;
    }

    public static final /* synthetic */ void a(OnTimeout r10, k r11, Object r12) {
        r10.c(r11, r12);
    }

    private final void c(k<?> r10, Object r11) {
        if (this.f10654a > 0) goto L6;
        r10.f(Unit.INSTANCE);
        return;
    L6:
        a r12 = new a(r10, this);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation r13 = (SelectImplementation) r10;
        CoroutineContext r14 = r10.getContext();
        r10.a(DelayKt.c(r14).B(this.f10654a, r12, r14));
    }

    public final d b() {
        OnTimeout$selectClause$1 r10 = OnTimeout$selectClause$1.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new e(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3), null, 4, null);
    }
}
