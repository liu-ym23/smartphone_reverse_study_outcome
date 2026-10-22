package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import com.larksuite.framework.callback.CancelableGetDataCallback;
import com.ss.android.lark.pb.messages.PutMessageLinkResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CopyMessageLinkHandler$Companion$getMessageLink$3$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancelableGetDataCallback<PutMessageLinkResponse> $cancelable;

    public CopyMessageLinkHandler$Companion$getMessageLink$3$1$1(CancelableGetDataCallback<PutMessageLinkResponse> r1) {
        this.$cancelable = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable r1) {
        this.$cancelable.cancel();
    }
}
