package com.bytedance.ai.bridge.method.media;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.media.image.AbsPreviewImageMethodIDL;
import com.bytedance.ai.bridge.service.PreviewImageCallback;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.utils.g;
import f3.h;
import k3.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements PreviewImageCallback {
    public final /* synthetic */ h<AbsPreviewImageMethodIDL.a> a;

    @Override // com.bytedance.ai.bridge.service.PreviewImageCallback
    public final void onSuccess() {
        g.a.i("AISDK_JSB_PreviewImageMethod", "call success");
        h<AbsPreviewImageMethodIDL.a> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsPreviewImageMethodIDL.a.class, "<this>");
        h.a.b(r0, (ResultModel) c.a(AbsPreviewImageMethodIDL.a.class));
    }

    public a(h<AbsPreviewImageMethodIDL.a> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.bridge.service.PreviewImageCallback
    public final void onFail(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call failed, errNo=");
        f3.a r11 = f3.a.f;
        r1.append(r11.a);
        r1.append(", msg=");
        r1.append(r10);
        r0.e("AISDK_JSB_PreviewImageMethod", r1.toString());
        h.a.a(this.a, r10, r11, null, 10);
    }
}
