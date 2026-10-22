package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class FlowKt__CollectionKt {

    static final class a<T> implements d {

        /* JADX INFO: Incorrect field signature: TC; */
        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Collection f10398c;

        /* JADX WARN: Incorrect types in method signature: (TC;)V */
        a(Collection r10) {
            this.f10398c = r10;
        }

        @Override // kotlinx.coroutines.flow.d
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            this.f10398c.add(r10);
            return Unit.INSTANCE;
        }
    }

    public static final <T, C extends Collection<? super T>> Object a(c<? extends T> r10, C r11, Continuation<? super C> r12) {
        if ((r12 instanceof FlowKt__CollectionKt$toCollection$1) == false) goto L7;
        FlowKt__CollectionKt$toCollection$1 r13 = (FlowKt__CollectionKt$toCollection$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        Collection r18 = (Collection) r13.L$0;
        ResultKt.throwOnFailure(r15);
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        d<? super Object> r19 = new a(r11);
        r13.L$0 = r11;
        r13.label = 1;
        if (r10.a(r19, r13) != r16) goto L18;
        return r16;
    L18:
        return r11;
    L7:
        r13 = new FlowKt__CollectionKt$toCollection$1(r12);
        goto L8
    }
}
