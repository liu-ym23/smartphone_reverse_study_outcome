package com.ss.android.lark.im.sdk.message.resend;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.im.sdk.service.ImSdkMessageServiceImplV2$resendMessage$reSendMessageCallback$1;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements jkb.b {
    public final Message a;
    public final IGetDataCallback<String> b;

    public h(Message r2, ImSdkMessageServiceImplV2$resendMessage$reSendMessageCallback$1 r3) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }
}
