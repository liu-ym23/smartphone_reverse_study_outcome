package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/im/sdk/service/ImSdkChatServiceImplV2$checkMentionBotInvitableIds$traceCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImSdkChatServiceImplV2$checkMentionBotInvitableIds$traceCallback$1 implements IGetDataCallback<List<? extends String>> {
    final /* synthetic */ IGetDataCallback<List<String>> $callback;
    final /* synthetic */ String $chatId;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("MentionAgentTrace", "CHECK err chat=" + this.$chatId + " code=" + r3.getErrorCode());
        this.$callback.onError(r3);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public void onSuccess(List<String> r2) {
        this.$callback.onSuccess(r2);
    }

    public ImSdkChatServiceImplV2$checkMentionBotInvitableIds$traceCallback$1(IGetDataCallback<List<String>> r1, String r2) {
        this.$callback = r1;
        this.$chatId = r2;
    }
}
