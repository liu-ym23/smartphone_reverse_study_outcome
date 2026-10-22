package com.ss.android.lark.officesdk.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.n;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n2\u0006\u0010\r\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/api/NoopOnlineOfflineService;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService;", "<init>", "()V", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$State;", "getState", "Lkotlinx/coroutines/flow/StateFlow;", "online", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineResult;", "params", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OnlineParams;", "offline", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineResult;", "Lcom/ss/android/lark/officesdk/api/IOnlineOfflineService$OfflineParams;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class NoopOnlineOfflineService implements IOnlineOfflineService {
    private final z0<IOnlineOfflineService.State> state;

    @Inject
    public NoopOnlineOfflineService() {
        this.state = j1.a(IOnlineOfflineService.State.Offline.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.api.IOnlineOfflineService
    public i1<IOnlineOfflineService.State> getState() {
        return this.state;
    }

    @Override // com.ss.android.lark.officesdk.api.IOnlineOfflineService
    public Flow<Result<IOnlineOfflineService.OfflineResult>> offline(IOnlineOfflineService.OfflineParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Result.Companion r3 = Result.Companion;
        return new n(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("IOnlineOfflineService is not available")))));
    }

    @Override // com.ss.android.lark.officesdk.api.IOnlineOfflineService
    public Flow<Result<IOnlineOfflineService.OnlineResult>> online(IOnlineOfflineService.OnlineParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Result.Companion r3 = Result.Companion;
        return new n(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("IOnlineOfflineService is not available")))));
    }
}
