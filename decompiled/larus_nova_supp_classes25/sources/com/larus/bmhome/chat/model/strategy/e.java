package com.larus.bmhome.chat.model.strategy;

import com.larus.im.bean.message.Message;
import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ ChatRetryStrategy a;
    public final /* synthetic */ Message b;

    public /* synthetic */ e(ChatRetryStrategy r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        ChatRetryStrategy r0 = this.a;
        Message r1 = this.b;
        ResourceUploadError r5 = (ResourceUploadError) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        String r2 = r1.getLocalMessageId();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.k(r2, r5);
        return Unit.INSTANCE;
    }
}
