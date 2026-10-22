package com.bytedance.ai.bridge.method.media;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.media.image.AbsSaveImageToPhotosAlbumMethodIDL;
import com.bytedance.ai.bridge.service.SaveImageCallback;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.utils.g;
import f3.h;
import k3.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements SaveImageCallback {
    public final /* synthetic */ h<AbsSaveImageToPhotosAlbumMethodIDL.a> a;

    @Override // com.bytedance.ai.bridge.service.SaveImageCallback
    public final void onSuccess() {
        g.a.i("AISDK_JSB_SaveImageToPhotosAlbumMethod", "call success");
        h<AbsSaveImageToPhotosAlbumMethodIDL.a> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsSaveImageToPhotosAlbumMethodIDL.a.class, "<this>");
        h.a.b(r0, (ResultModel) c.a(AbsSaveImageToPhotosAlbumMethodIDL.a.class));
    }

    public b(h<AbsSaveImageToPhotosAlbumMethodIDL.a> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.bridge.service.SaveImageCallback
    public final void onFail(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call failed, errNo=");
        f3.a r11 = f3.a.f;
        r1.append(r11.a);
        r1.append(", msg=");
        r1.append(r10);
        r0.e("AISDK_JSB_SaveImageToPhotosAlbumMethod", r1.toString());
        h.a.a(this.a, r10, r11, null, 10);
    }
}
