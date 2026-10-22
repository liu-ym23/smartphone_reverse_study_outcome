package com.ss.android.lark.forwardv2.impl.model.service;

import android.os.SystemClock;
import com.bytedance.lark.pb.feed.v1.GetRecentVisitTargetsResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/forwardv2/impl/model/service/ForwardService$getRecentVisitTargets$innerCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/feed/v1/GetRecentVisitTargetsResponse;", "onSuccess", "", "response", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardService$getRecentVisitTargets$innerCallback$1 implements IGetDataCallback<GetRecentVisitTargetsResponse> {
    final /* synthetic */ IGetDataCallback<GetRecentVisitTargetsResponse> $callback;
    final /* synthetic */ boolean $isLocal;
    final /* synthetic */ long $startRequestVisitTime;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        this.$callback.onError(r3);
        Log.e("Android_Recent_Visit", "from local: " + this.$isLocal + ", GetRecentVisitTargetsResponse + " + r3, r3.getCause());
    }

    public void onSuccess(GetRecentVisitTargetsResponse r6) {
        Log.i("Android_Recent_Visit", "load recent visit successful, sdk cost: " + (SystemClock.elapsedRealtime() - this.$startRequestVisitTime) + ", from local: " + this.$isLocal);
        if (r6 != null) goto L6;
        Log.e("Android_Recent_Visit", "GetRecentVisitTargetsResponse is null, from local: " + this.$isLocal);
        this.$callback.onSuccess(new GetRecentVisitTargetsResponse.Builder().build());
        return;
    L6:
        this.$callback.onSuccess(r6);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((GetRecentVisitTargetsResponse) r1);
    }

    public ForwardService$getRecentVisitTargets$innerCallback$1(long r1, boolean r3, IGetDataCallback<GetRecentVisitTargetsResponse> r4) {
        this.$startRequestVisitTime = r1;
        this.$isLocal = r3;
        this.$callback = r4;
    }
}
