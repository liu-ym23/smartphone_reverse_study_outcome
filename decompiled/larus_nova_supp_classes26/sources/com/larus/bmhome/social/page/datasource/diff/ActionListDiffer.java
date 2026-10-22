package com.larus.bmhome.social.page.datasource.diff;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.larus.bmhome.social.page.datasource.event.c;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ActionListDiffer<DATA> extends b<DATA, c<DATA>> {
    public static final /* synthetic */ int g = 0;
    public final Function1<c<DATA>, Unit> d;
    public List<? extends DATA> e;
    public long f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public final List<DATA> c() {
        return com.larus.utils.h.d(this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(List<? extends DATA> r2) {
        List<? extends DATA> r0 = this.e;
        this.e = r2;
        if (Intrinsics.areEqual(r2, r0) == true) goto L6;
        d(r2);
        return;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public final /* bridge */ /* synthetic */ Object b(com.larus.bmhome.social.page.datasource.event.a r1, Continuation r2) {
        return e((c) r1, r2);
    }

    public final Object e(c<DATA> r19, Continuation<? super Unit> r20) {
        c<DATA> r1 = r19;
        if ((r20 instanceof ActionListDiffer$collectEvent$1) == false) goto L7;
        ActionListDiffer$collectEvent$1 r3 = (ActionListDiffer$collectEvent$1) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (c) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L43:
        this.f = r1.b;
        this.d.invoke(r1);
        if (r1.d.length() <= 0) goto L46;
        boolean r10 = true;
    L47:
        if (r10 == false) goto L54;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("refreshTrace end=applied rt=");
        r8.append(r1.d);
        r8.append(" version=");
        r8.append(r1.b);
        r8.append(" size=");
        r8.append(r1.a.size());
        r8.append(" cost=");
        long r9 = com.larus.bmhome.social.page.datasource.event.d.b(r1.d);
        if (r9 < 0) goto L51;
        long r11 = System.currentTimeMillis() - r9;
    L52:
        r8.append(r11);
        r7.w("MsgRefreshFlow_ActionListDiffer", r8.toString());
        goto L54
    L51:
        r11 = -1;
    L54:
        return Unit.INSTANCE;
    L46:
        r10 = false;
        goto L47
    L16:
        ResultKt.throwOnFailure(r2);
        long r12 = this.f;
        long r13 = r1.b;
        if (1 <= r13) goto L19;
    L21:
        boolean r14 = false;
    L22:
        if (r14 == false) goto L36;
        if (r1.d.length() <= 0) goto L26;
        boolean r15 = true;
    L27:
        if (r15 == false) goto L34;
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("refreshTrace end=dropped rt=");
        r17.append(r1.d);
        r17.append(" version=");
        r17.append(r1.b);
        r17.append(" handledVersion=");
        r17.append(this.f);
        r17.append(" cost=");
        long r18 = com.larus.bmhome.social.page.datasource.event.d.b(r1.d);
        if (r18 < 0) goto L31;
        long r21 = System.currentTimeMillis() - r18;
    L32:
        r17.append(r21);
        r16.w("MsgRefreshFlow_ActionListDiffer", r17.toString());
        goto L34
    L31:
        r21 = -1;
    L34:
        return Unit.INSTANCE;
    L26:
        r15 = false;
        goto L27
    L36:
        if ((r13 - r12) == 1) goto L40;
        r3.L$0 = r1;
        r3.label = 1;
        if (g(r1, r3) != r5) goto L43;
        return r5;
    L40:
        r3.L$0 = r1;
        r3.label = 2;
        if (f(r1, r3) != r5) goto L43;
        return r5;
    L19:
        if (r13 >= r12) goto L21;
        r14 = true;
    L7:
        r3 = new ActionListDiffer$collectEvent$1(this, r20);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00e3 -> B:20:0x0066). Please report as a decompilation issue!!! */
    public final Object f(c<DATA> r17, Continuation<? super Unit> r18) {
        if ((r18 instanceof ActionListDiffer$handleAction$1) == false) goto L7;
        ActionListDiffer$handleAction$1 r1 = (ActionListDiffer$handleAction$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
        ActionListDiffer<DATA> r3 = this;
    L8:
        Object r0 = r1.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        Iterator r6 = (Iterator) r1.L$1;
        c<DATA> r9 = (c) r1.L$0;
        ResultKt.throwOnFailure(r0);
        c<DATA> r7 = r9;
    L19:
        ActionListDiffer r10 = r3;
    L21:
        if (r6.hasNext() == false) goto L53;
        com.larus.bmhome.social.page.datasource.event.b r11 = (com.larus.bmhome.social.page.datasource.event.b) r6.next();
        if ((r11 instanceof com.larus.bmhome.social.page.datasource.event.b.a) == true) goto L24;
        if ((r11 instanceof com.larus.bmhome.social.page.datasource.event.b.c) == true) goto L34;
        if ((r11 instanceof com.larus.bmhome.social.page.datasource.event.b.C0034b) == true) goto L41;
        if ((r11 instanceof com.larus.bmhome.social.page.datasource.event.b.d) == false) goto L21;
        r1.L$0 = r7;
        r1.L$1 = r6;
        r1.label = 4;
        if (r10.g(r7, r1) != r4) goto L21;
        return r4;
    L41:
        int r8 = r7.a.size();
        com.larus.bmhome.social.page.datasource.event.b.C0034b r12 = (com.larus.bmhome.social.page.datasource.event.b.C0034b) r11;
        r12.getClass();
        if ((r8 + 0) == r10.e.size()) goto L46;
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("convert REMOVED to REFRESH rt=");
        r14.append(r7.d);
        r14.append(", because newData(");
        r14.append(r7.a.size());
        r14.append(") + delta(0) != dataSource(");
        r12.getClass();
        r14.append(r10.e.size());
        r14.append(')');
        r13.i("MsgRefreshFlow_ActionListDiffer", r14.toString());
        r1.L$0 = r7;
        r1.L$1 = r6;
        r1.label = 3;
        if (r10.g(r7, r1) != r4) goto L21;
        return r4;
    L46:
        r10.h(r7.a);
        ListUpdateCallback r15 = r10.b;
        r12.getClass();
        r12.getClass();
        r15.onRemoved(0, 0);
        goto L21
    L34:
        if (r7.a.size() == r10.e.size()) goto L38;
        FLogger.a.i("MsgRefreshFlow_ActionListDiffer", "convert UPDATE to REFRESH rt=" + r7.d + ", because newData(" + r7.a.size() + ") != dataSource(" + r10.e.size() + ')');
        r1.L$0 = r7;
        r1.L$1 = r6;
        r1.label = 2;
        if (r10.g(r7, r1) != r4) goto L21;
        return r4;
    L38:
        r10.h(r7.a);
        ListUpdateCallback r16 = r10.b;
        com.larus.bmhome.social.page.datasource.event.b.c r19 = (com.larus.bmhome.social.page.datasource.event.b.c) r11;
        r19.getClass();
        r19.getClass();
        r16.onChanged(0, 0, null);
        goto L21
    L24:
        int r110 = r7.a.size();
        com.larus.bmhome.social.page.datasource.event.b.a r111 = (com.larus.bmhome.social.page.datasource.event.b.a) r11;
        r111.getClass();
        if ((r110 - 0) == r10.e.size()) goto L29;
        FLogger r20 = FLogger.a;
        StringBuilder r112 = new StringBuilder("convert INSERTED to REFRESH rt=");
        r112.append(r7.d);
        r112.append(", because newData(");
        r112.append(r7.a.size());
        r112.append(") - delta(0) != dataSource(");
        r111.getClass();
        r112.append(r10.e.size());
        r112.append(')');
        r20.i("MsgRefreshFlow_ActionListDiffer", r112.toString());
        r1.L$0 = r7;
        r1.L$1 = r6;
        r1.label = 1;
        if (r10.g(r7, r1) != r4) goto L21;
        return r4;
    L29:
        r10.h(r7.a);
        ListUpdateCallback r21 = r10.b;
        r111.getClass();
        r111.getClass();
        r21.onInserted(0, 0);
        goto L21
    L53:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r6 = (Iterator) r1.L$1;
        c<DATA> r22 = (c) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r7 = r22;
        r10 = r3;
        goto L21
    L18:
        ResultKt.throwOnFailure(r0);
        r7 = r17;
        r6 = r7.c.iterator();
    L7:
        r3 = this;
        r1 = new ActionListDiffer$handleAction$1(r3, r18);
        goto L8
    }

    public final Object g(c<DATA> r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof ActionListDiffer$refresh$1) == false) goto L7;
        ActionListDiffer$refresh$1 r0 = (ActionListDiffer$refresh$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (c) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L17:
        h(r7.a);
        ((DiffUtil.DiffResult) r9).dispatchUpdatesTo(this.b);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("MsgRefreshFlow_ActionListDiffer", "differ refresh rt=" + r7.d + " version=" + r7.b + " old=" + this.e.size() + " new=" + r7.a.size());
        CoroutineDispatcher r10 = Dispatchers.getIO();
        ActionListDiffer$refresh$result$1 r4 = new ActionListDiffer$refresh$result$1(this, r7, null);
        r0.L$0 = r7;
        r0.label = 1;
        r9 = BuildersKt.withContext(r10, r4, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new ActionListDiffer$refresh$1(this, r8);
        goto L8
    }

    public ActionListDiffer(com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback r2, DiffUtil.ItemCallback r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "updateCallback");
        Intrinsics.checkNotNullParameter(r3, "diffCallback");
        Intrinsics.checkNotNullParameter(r4, "onEventApplied");
        super(r3, r2);
        this.d = r4;
        this.e = CollectionsKt.emptyList();
    }
}
