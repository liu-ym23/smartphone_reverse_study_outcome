package com.bytedance.android.annie.bridge.method;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.bridge.UploadFileResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s2 implements q2 {
    public final /* synthetic */ t2 a;

    public s2(t2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.bridge.method.q2
    public final void a(UploadFileResultModel r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        t2 r0 = this.a;
        r10.b(UploadFileResultModel.Code.Success);
        r10.d(r11);
        r0.finishWithResult(r10);
    }

    @Override // com.bytedance.android.annie.bridge.method.q2
    public final void b(UploadFileResultModel.Code r10, String r11, UploadFileResultModel r12) {
        Intrinsics.checkNotNullParameter(r10, "code");
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        t2 r0 = this.a;
        if (r12 != null) goto L5;
        r12 = new UploadFileResultModel();
    L5:
        r12.b(r10);
        r12.d(r11);
        r0.finishWithResult(r12);
    }
}
