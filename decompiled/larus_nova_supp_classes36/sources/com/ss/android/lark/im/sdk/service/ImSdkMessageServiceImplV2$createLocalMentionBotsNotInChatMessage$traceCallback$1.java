package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/im/sdk/service/ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$traceCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/im/sdk/service/MentionBotLocalMessageCreateResult;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$traceCallback$1 implements IGetDataCallback<MentionBotLocalMessageCreateResult> {
    final /* synthetic */ IGetDataCallback<MentionBotLocalMessageCreateResult> $callback;
    final /* synthetic */ String $sourceMessageId;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("MentionAgentTrace", "4191 err msg=" + this.$sourceMessageId + " code=" + r3.getErrorCode());
        this.$callback.onError(r3);
    }

    public void onSuccess(MentionBotLocalMessageCreateResult r4) {
        if (Intrinsics.areEqual(r4, MentionBotLocalMessageCreateResult.a.a) == false) goto L6;
        Log.i("MentionAgentTrace", "4191 rsp msg=" + this.$sourceMessageId + " ok");
    L10:
        this.$callback.onSuccess(r4);
        return;
    L6:
        if ((r4 instanceof MentionBotLocalMessageCreateResult.Failure) == false) goto L8;
        ((MentionBotLocalMessageCreateResult.Failure) r4).getClass();
        Log.w("MentionAgentTrace", "4191 rsp msg=" + this.$sourceMessageId + " fail=null");
        goto L10
    L8:
        if (r4 != null) goto L13;
        Log.w("MentionAgentTrace", "4191 rsp msg=" + this.$sourceMessageId + " null");
        goto L10
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((MentionBotLocalMessageCreateResult) r1);
    }

    public ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$traceCallback$1(String r1, IGetDataCallback<MentionBotLocalMessageCreateResult> r2) {
        this.$sourceMessageId = r1;
        this.$callback = r2;
    }
}
