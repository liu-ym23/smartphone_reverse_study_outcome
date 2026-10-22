package com.ss.android.lark.forwardv3.data.services;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/forwardv3/data/services/ForwardGetServices$getRecentVisitData$3$innerCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardGetServices$getRecentVisitData$3$innerCallback$1 implements IGetDataCallback<List<SearchBaseInfo>> {
    final /* synthetic */ boolean $isLocal;
    final /* synthetic */ Continuation<List<SearchBaseInfo>> $it;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("ForwardGetServices", "get visit forward data v1 error: " + r3 + ", from local: " + this.$isLocal, r3);
        Continuation<List<SearchBaseInfo>> r0 = this.$it;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r3)));
    }

    public void onSuccess(List<SearchBaseInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$it.resumeWith(Result.constructor-impl(r2));
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ForwardGetServices$getRecentVisitData$3$innerCallback$1(Continuation<? super List<SearchBaseInfo>> r1, boolean r2) {
        this.$it = r1;
        this.$isLocal = r2;
    }
}
