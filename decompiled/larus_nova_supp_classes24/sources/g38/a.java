package g38;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static void a(CoroutineScope r6, Function2 r7) {
        EmptyCoroutineContext r0 = EmptyCoroutineContext.INSTANCE;
        CoroutineStart r1 = CoroutineStart.DEFAULT;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "start");
        Intrinsics.checkNotNullParameter(r7, "block");
        BuildersKt.launch(r6, r0.plus(new b(qqb.a.d(), r6.getCoroutineContext().get(ContinuationInterceptor.Key))), r1, r7);
    }
}
