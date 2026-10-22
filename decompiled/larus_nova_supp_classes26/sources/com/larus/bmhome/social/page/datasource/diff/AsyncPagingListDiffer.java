package com.larus.bmhome.social.page.datasource.diff;

import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AsyncPagingListDiffer<DATA> extends PagingListDiffer<DATA> {
    public static final /* synthetic */ int e = 0;

    public static final class a {
    }

    public static final class b<DATA> {
        public final int a;
        public final int b;
        public final int c;
        public final List<DATA> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "Op(opCode=" + this.a + ", start=" + this.b + ", itemCount=" + this.c + ", source=" + this.d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(int r2, int r3, int r4, List<? extends DATA> r5) {
            Intrinsics.checkNotNullParameter(r5, MusicAppletPage.KEY_SOURCE);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public final List<DATA> c() {
        return com.larus.utils.h.d(this.d);
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object i(Continuation r5) {
        l(new b(3, 0, 0, CollectionsKt.emptyList()), r5);
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object k(Continuation r1) {
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer, com.larus.bmhome.social.page.datasource.diff.b
    public final /* bridge */ /* synthetic */ Object b(com.larus.bmhome.social.page.datasource.event.a r1, Continuation r2) {
        return f((h) r1, r2);
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object e(List<? extends DATA> r1, Continuation<? super Unit> r2) {
        this.d.size();
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object f(h<DATA> r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof AsyncPagingListDiffer$collectEvent$1) == false) goto L7;
        AsyncPagingListDiffer$collectEvent$1 r0 = (AsyncPagingListDiffer$collectEvent$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (h) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        r0.L$0 = null;
        r0.label = 2;
        if (PagingListDiffer.g(this, r7, r0) != r2) goto L23;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        AsyncPagingListDiffer$collectEvent$2 r10 = new AsyncPagingListDiffer$collectEvent$2(this, null);
        r0.L$0 = r7;
        r0.label = 1;
        if (CoroutineExtKt.a(EmptyCoroutineContext.INSTANCE, r10, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new AsyncPagingListDiffer$collectEvent$1(this, r8);
        goto L8
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object h(List<? extends DATA> r1, Continuation<? super Unit> r2) {
        throw null;
    }

    public final void l(b r5, Continuation r6) {
        if ((r6 instanceof AsyncPagingListDiffer$dispatchOp$1) == false) goto L7;
        AsyncPagingListDiffer$dispatchOp$1 r0 = (AsyncPagingListDiffer$dispatchOp$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L12;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r0.L$1;
        b r3 = (b) r0.L$0;
        ResultKt.throwOnFailure(r7);
        throw null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r8.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r5;
        r0.L$1 = null;
        r0.label = 1;
        throw null;
    L7:
        r0 = new AsyncPagingListDiffer$dispatchOp$1(this, r6);
        goto L8
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public Object insert(int r4, List<? extends DATA> r5, Continuation<? super Unit> r6) {
        l(new b(1, r4, r5.size(), r5), r6);
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public Object update(int r4, List<? extends DATA> r5, Continuation<? super Unit> r6) {
        l(new b(2, r4, r5.size(), r5), r6);
        throw null;
    }
}
