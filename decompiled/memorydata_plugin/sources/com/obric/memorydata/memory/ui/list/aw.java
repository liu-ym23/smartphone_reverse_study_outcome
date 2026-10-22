package com.obric.memorydata.memory.ui.list;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.union.build.storage.SemanticConfirmationResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoRepository;", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoRepositoryState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "review", "Lcom/obric/memorydata/union/build/storage/SemanticConfirmationResult;", "item", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM, "", "(Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", IslandSession.REOPEN_VALUE_CLOSE, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface aw {
    Object a(ar r1, boolean r2, Continuation<? super SemanticConfirmationResult> r3);

    Object a(Continuation<? super Unit> r1);

    kotlinx.coroutines.flow.ar<ay> a();

    void b();
}
