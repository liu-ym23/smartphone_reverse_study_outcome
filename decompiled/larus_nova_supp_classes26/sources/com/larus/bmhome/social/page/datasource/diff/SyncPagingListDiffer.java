package com.larus.bmhome.social.page.datasource.diff;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SyncPagingListDiffer<DATA> extends PagingListDiffer<DATA> {
    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public final List<DATA> c() {
        return com.larus.utils.h.d(this.d);
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object i(Continuation r5) {
        int r0 = 0;
        int r6 = com.larus.utils.h.f(this.d, 0);
        List<? extends DATA> r1 = this.d;
        int r2 = 0 + r6;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 >= 0) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        r0 = r2;
    L13:
        int r4 = r0 - r6;
        if (r4 <= 0) goto L17;
        j(this.d.subList(r6, r0));
        this.b.onRemoved(r6, r4);
    L17:
        return Unit.INSTANCE;
    L10:
        if (r2 < 0) goto L13;
        r0 = r1.size();
        goto L13
    L5:
        if (r2 > r1.size()) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object k(Continuation r3) {
        if (this.d.isEmpty() == false) goto L6;
        e(null, r3);
        throw null;
    L6:
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer, com.larus.bmhome.social.page.datasource.diff.b
    public final /* bridge */ /* synthetic */ Object b(com.larus.bmhome.social.page.datasource.event.a r1, Continuation r2) {
        return f((h) r1, r2);
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object e(List<? extends DATA> r2, Continuation<? super Unit> r3) {
        if (r2.isEmpty() == true) goto L5;
        int r4 = r2.size();
        if (this.d.isEmpty() == false) goto L10;
        j(r2);
        this.b.onInserted(0, r4);
        return Unit.INSTANCE;
    L10:
        int r5 = this.d.size() + 1;
        this.b.onInserted(r5, r4);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object f(h<DATA> r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new SyncPagingListDiffer$collectEvent$2(this, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object h(List<? extends DATA> r2, Continuation<? super Unit> r3) {
        if (r2.isEmpty() == true) goto L5;
        j(CollectionsKt.plus(r2, this.d));
        this.b.onInserted(0, r2.size());
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public Object insert(int r2, List<? extends DATA> r3, Continuation<? super Unit> r4) {
        if (r3.isEmpty() == false) goto L7;
        return Unit.INSTANCE;
    L7:
        if (this.d.isEmpty() == false) goto L13;
        Object r5 = e(r3, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r5;
    L12:
        return Unit.INSTANCE;
    L13:
        if (r2 > 0) goto L20;
        Object r6 = h(r3, r4);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r6;
    L18:
        return Unit.INSTANCE;
    L20:
        if (r2 < this.d.size()) goto L26;
        Object r7 = e(r3, r4);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r7;
    L25:
        return Unit.INSTANCE;
    L26:
        List<? extends DATA> r8 = CollectionsKt.toMutableList(this.d);
        r8.addAll(r2, r3);
        j(r8);
        this.b.onInserted(r2, r3.size());
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public Object update(int r7, List<? extends DATA> r8, Continuation<? super Unit> r9) {
        if (r8.isEmpty() == true) goto L30;
        if (this.d.isEmpty() == true) goto L30;
        if (com.larus.utils.h.a(this.d, r7) == true) goto L12;
        return Unit.INSTANCE;
    L12:
        if ((r8.size() + r7) <= this.d.size()) goto L14;
        int r10 = this.d.size();
    L15:
        if (r7 > r10) goto L17;
        ArrayList r0 = new ArrayList();
        List r1 = CollectionsKt.toMutableList(this.d);
        int r2 = r7;
    L19:
        if (r2 >= r10) goto L24;
        Object r3 = ListProtector.get(r1, r2);
        Object r4 = ListProtector.get(r8, r2 - r7);
        ListProtector.set(r1, r2, r4);
        DiffUtil.ItemCallback<Item> r5 = this.a;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r3);
        Object r6 = r5.getChangePayload(r4, r3);
        if (r6 == null) goto L23;
        r0.add(r6);
    L23:
        r2 = r2 + 1;
        goto L19
    L24:
        j(com.larus.utils.h.d(r1));
        ListUpdateCallback r11 = this.b;
        int r12 = r10 - r7;
        if (r0.isEmpty() == false) goto L27;
        r0 = null;
    L27:
        r11.onChanged(r7, r12, r0);
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L14:
        r10 = r8.size() + r7;
    L30:
        return Unit.INSTANCE;
    }
}
