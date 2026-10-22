package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.pb.messages.PutMessageLinkResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chat/chatwindow/chat/menu/handler/CopyMessageLinkHandler$Companion$getMessageLink$3$1$callback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/pb/messages/PutMessageLinkResponse;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CopyMessageLinkHandler$Companion$getMessageLink$3$1$callback$1 implements IGetDataCallback<PutMessageLinkResponse> {
    final /* synthetic */ kotlinx.coroutines.i<PutMessageLinkResponse> $continuation;

    public CopyMessageLinkHandler$Companion$getMessageLink$3$1$callback$1(kotlinx.coroutines.i<? super PutMessageLinkResponse> r1) {
        this.$continuation = r1;
    }

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        kotlinx.coroutines.i<PutMessageLinkResponse> r0 = this.$continuation;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r3)));
    }

    public void onSuccess(PutMessageLinkResponse r2) {
        if (r2 == null) goto L4;
        this.$continuation.resumeWith(Result.constructor-impl(r2));
        return;
    L4:
        kotlinx.coroutines.i<PutMessageLinkResponse> r3 = this.$continuation;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(ResultKt.createFailure(new NullPointerException())));
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((PutMessageLinkResponse) r1);
    }
}
