package com.obric.memorydata.recommend.ui.list;

import androidx.lifecycle.ViewModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u001f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0018R\"\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryListShareViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_targetEntityFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "Lcom/obric/memorydata/recommend/ui/list/MemoryTab;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "targetEntityFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getTargetEntityFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "setTargetEntity", "", "memoryTab", "memoryItem", "_memoryClearFlow", "", "memoryClearFlow", "getMemoryClearFlow", "setMemoryCleared", "clear", "clearMemory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "_listRefreshFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "listRefreshFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getListRefreshFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "refresh", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryListShareViewModel extends ViewModel {
    private final ad<Boolean> _listRefreshFlow;
    private final ae<Boolean> _memoryClearFlow;
    private final ae<Pair<MemoryTab, f>> _targetEntityFlow;
    private final ai<Boolean> listRefreshFlow;
    private final ar<Boolean> memoryClearFlow;
    private final ar<Pair<MemoryTab, f>> targetEntityFlow;

    public MemoryListShareViewModel() {
        ae<Pair<MemoryTab, f>> r1 = at.a(null);
        this._targetEntityFlow = r1;
        this.targetEntityFlow = (ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin");
        ae<Boolean> r2 = at.a(false);
        this._memoryClearFlow = r2;
        this.memoryClearFlow = (ar) ZeusTransformUtils.preCheckCast(r2, ar.class, "com.obric.memorydata.plugin");
        ad<Boolean> r0 = ak.a(0, 0, null, 6, null);
        this._listRefreshFlow = r0;
        this.listRefreshFlow = (ai) ZeusTransformUtils.preCheckCast(r0, ai.class, "com.obric.memorydata.plugin");
    }

    public final Object clearMemory(Continuation<? super Boolean> r2) {
        Continuation<? super Boolean> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
        return com.obric.memorydata.recommend.model.b.f12534a.a(r1);
    }

    public final ai<Boolean> getListRefreshFlow() {
        return this.listRefreshFlow;
    }

    public final ar<Boolean> getMemoryClearFlow() {
        return this.memoryClearFlow;
    }

    public final ar<Pair<MemoryTab, f>> getTargetEntityFlow() {
        return this.targetEntityFlow;
    }

    public final Object refresh(Continuation<? super Unit> r3) {
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Object r2 = this._listRefreshFlow.emit(Boxing.boxBoolean(true), r4);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    public final void setMemoryCleared(boolean r1) {
        this._memoryClearFlow.b(Boolean.valueOf(r1));
    }

    public final void setTargetEntity(MemoryTab r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "memoryTab");
        Intrinsics.checkNotNullParameter(r3, "memoryItem");
        this._targetEntityFlow.b(new Pair(r2, r3));
    }
}
