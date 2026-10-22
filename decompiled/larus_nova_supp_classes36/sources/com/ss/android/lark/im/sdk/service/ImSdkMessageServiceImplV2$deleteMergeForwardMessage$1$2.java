package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.DeleteLarkMessagesInDoubaoResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/im/sdk/service/ImSdkMessageServiceImplV2$deleteMergeForwardMessage$1$2", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/im/v1/DeleteLarkMessagesInDoubaoResponse;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImSdkMessageServiceImplV2$deleteMergeForwardMessage$1$2 implements IGetDataCallback<DeleteLarkMessagesInDoubaoResponse> {
    public ImSdkMessageServiceImplV2$deleteMergeForwardMessage$1$2() {
    }

    public void onSuccess(DeleteLarkMessagesInDoubaoResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        String r3 = r2.getDebugMsg();
        if (r3 != null) goto L5;
        r3 = "error";
    L5:
        Log.e("ImSdkMessageServiceImplV2", r3);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((DeleteLarkMessagesInDoubaoResponse) r1);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }
}
