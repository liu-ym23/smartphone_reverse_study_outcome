package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SendImgMsgCacheScanner$b implements IIMCallback<Message> {
    public final /* synthetic */ SendImgMsgCacheScanner a;
    public final /* synthetic */ File b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("SendImgMsgCacheScanner", "update message content failed, msgId:" + this.d + ", error:" + r4);
    }

    public final void onSuccess(Object r11) {
        Intrinsics.checkNotNullParameter((Message) r11, "result");
        BuildersKt.launch$default(SendImgMsgCacheScanner.f, null, null, new SendImgMsgCacheScanner$updateMessageAndDeleteFile$1$onSuccess$1(this.a, this.b, this.c, null), 3, null);
    }

    public SendImgMsgCacheScanner$b(SendImgMsgCacheScanner r1, File r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
