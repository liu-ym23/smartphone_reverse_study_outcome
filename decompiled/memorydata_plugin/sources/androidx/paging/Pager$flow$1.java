package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class Pager$flow$1<Key, Value> extends FunctionReferenceImpl implements SuspendFunction, Function1<Continuation<? super PagingSource<Key, Value>>, Object> {
    Pager$flow$1(Object r8) {
        super(1, r8, SuspendingPagingSourceFactory.class, "create", "create(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Object r3) {
        return invoke((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(Continuation<? super PagingSource<Key, Value>> r3) {
        Continuation<? super PagingSource<Key, Value>> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return ((SuspendingPagingSourceFactory) ZeusTransformUtils.preCheckCast(this.receiver, SuspendingPagingSourceFactory.class, "com.obric.memorydata.plugin")).create(r4);
    }
}
