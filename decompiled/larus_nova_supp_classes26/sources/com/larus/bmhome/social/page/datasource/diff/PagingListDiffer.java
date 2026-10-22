package com.larus.bmhome.social.page.datasource.diff;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class PagingListDiffer<DATA> extends b<DATA, h<DATA>> {
    public volatile List<? extends DATA> d;

    public abstract Object e(List<? extends DATA> r1, Continuation<? super Unit> r2);

    public Object f(h<DATA> r1, Continuation<? super Unit> r2) {
        return g(this, r1, r2);
    }

    public abstract Object h(List<? extends DATA> r1, Continuation<? super Unit> r2);

    public abstract Object i(Continuation r1);

    public abstract Object insert(int r1, List<? extends DATA> r2, Continuation<? super Unit> r3);

    public abstract Object k(Continuation r1);

    public abstract Object update(int r1, List<? extends DATA> r2, Continuation<? super Unit> r3);

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(List<? extends DATA> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.d = r2;
        if (Intrinsics.areEqual(this.d, r2) == true) goto L6;
        d(r2);
        return;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public /* bridge */ /* synthetic */ Object b(com.larus.bmhome.social.page.datasource.event.a r1, Continuation r2) {
        return f((h) r1, r2);
    }

    public static /* synthetic */ <DATA> Object g(PagingListDiffer<DATA> r4, h<DATA> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof PagingListDiffer$collectEvent$1) == false) goto L7;
        PagingListDiffer$collectEvent$1 r0 = (PagingListDiffer$collectEvent$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r7);
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r7);
    L63:
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r7);
    L56:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r7);
    L49:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r7);
    L42:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r7);
    L35:
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r7);
    L28:
        return Unit.INSTANCE;
    L20:
        r5 = (h) r0.L$1;
        r4 = (PagingListDiffer) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L24:
        ((h.e) r5).getClass();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (r4.k(r0) != r2) goto L28;
        return r2;
    L21:
        ResultKt.throwOnFailure(r7);
        if ((r5 instanceof h.e) == false) goto L30;
        ((h.e) r5).getClass();
        goto L24
    L30:
        if ((r5 instanceof h.a) == false) goto L37;
        ((h.a) r5).getClass();
        r0.label = 3;
        if (r4.e(null, r0) != r2) goto L35;
        return r2;
    L37:
        if ((r5 instanceof h.d) == false) goto L44;
        ((h.d) r5).getClass();
        r0.label = 4;
        if (r4.h(null, r0) != r2) goto L42;
        return r2;
    L44:
        if ((r5 instanceof h.c) == false) goto L51;
        ((h.c) r5).getClass();
        r0.label = 5;
        if (r4.insert(0, null, r0) != r2) goto L49;
        return r2;
    L51:
        if ((r5 instanceof h.g) == false) goto L58;
        ((h.g) r5).getClass();
        r0.label = 6;
        if (r4.update(0, null, r0) != r2) goto L56;
        return r2;
    L58:
        if ((r5 instanceof h.f) == false) goto L65;
        ((h.f) r5).getClass();
        r0.label = 7;
        if (r4.i(r0) != r2) goto L63;
        return r2;
    L65:
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new PagingListDiffer$collectEvent$1(r4, r6);
        goto L8
    }
}
