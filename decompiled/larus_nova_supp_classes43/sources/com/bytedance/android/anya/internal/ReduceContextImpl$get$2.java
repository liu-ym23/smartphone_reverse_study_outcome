package com.bytedance.android.anya.internal;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.n0;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003\"\f\b\u0001\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "E", "P", "Lcom/bytedance/android/anya/MVIState;", "invoke", "()Lcom/bytedance/android/anya/MVIState;"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class ReduceContextImpl$get$2 extends Lambda implements Function0<MVIState<?>> {
    final /* synthetic */ int $index;
    final /* synthetic */ n0 $this_get;

    public ReduceContextImpl$get$2(n0 r1, int r10) {
        this.$this_get = r1;
        this.$index = r10;
        super(0);
    }

    public final MVIState<?> invoke() {
        Function0<T> r0 = ((p.b) this.$this_get).a;
        if (r0 == 0) goto L10;
        u r1 = (u) ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, 0)).invoke();
        if (r1 != null) goto L11;
        return null;
    L11:
        return (MVIState) CollectionsKt.getOrNull(r1.c(), this.$index);
    L10:
        throw new TypeCastException("null cannot be cast to non-null type () -> com.bytedance.android.anya.internal.StateListPropertyImpl<P, E>?");
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m471invoke() {
        return invoke();
    }
}
