package kotlinx.coroutines.selects;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c {
    public static final void a(SelectImplementation r8, long r9, Function1 r11) {
        b r2 = new b(r9);
        OnTimeout$selectClause$1 r10 = OnTimeout$selectClause$1.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        r8.k(new SelectImplementation.a(r8, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3), SelectKt.a, SelectKt.f, (SuspendLambda) r11, null), false);
    }
}
