package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8.g f18996a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g8.g f18997b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g8.g f18998c = null;
    public static final g8.g d = null;
    public static final g8.g e = null;

    static {
        f18996a = new g8.g("STATE_REG", 10);
        f18997b = new g8.g("STATE_COMPLETED", 10);
        f18998c = new g8.g("STATE_CANCELLED", 10);
        d = new g8.g("NO_RESULT", 10);
        e = new g8.g("PARAM_CLAUSE_0", 10);
    }

    public static final void a(f r10, long r11, Function1 r12) {
        a r5 = new a(r11);
        OnTimeout$selectClause$1 r13 = OnTimeout$selectClause$1.INSTANCE;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        e r14 = new e(r10, r5, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r13, 3), i.f19007a, e, r12, null);
        AtomicReferenceFieldUpdater r15 = f.f;
        r10.k(r14, false);
    }
}
