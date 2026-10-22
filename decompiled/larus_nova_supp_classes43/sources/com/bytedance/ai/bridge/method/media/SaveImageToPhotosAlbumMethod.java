package com.bytedance.ai.bridge.method.media;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.media.image.AbsSaveImageToPhotosAlbumMethodIDL;
import com.bytedance.ai.bridge.service.IHostImageDepend;
import com.bytedance.ai.bridge.service.SaveImageToPhotosAlbumRequest;
import com.bytedance.ai.utils.g;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/media/SaveImageToPhotosAlbumMethod;", "Lcom/bytedance/ai/bridge/media/image/AbsSaveImageToPhotosAlbumMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/media/image/AbsSaveImageToPhotosAlbumMethodIDL$SaveImageToPhotosAlbumParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/media/image/AbsSaveImageToPhotosAlbumMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveImageToPhotosAlbumMethod extends AbsSaveImageToPhotosAlbumMethodIDL {

    public static final class a {
    }

    static {
    }

    public SaveImageToPhotosAlbumMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSaveImageToPhotosAlbumMethodIDL.b r13 = (AbsSaveImageToPhotosAlbumMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r0 = g.a;
        r0.i("AISDK_JSB_SaveImageToPhotosAlbumMethod", "call start, filePath length=" + r13.getFilePath().length());
        if (StringsKt.isBlank(r13.getFilePath()) == false) goto L5;
        StringBuilder r14 = new StringBuilder("call failed, errNo=");
        f3.a r15 = f3.a.h;
        r14.append(r15.a);
        r14.append(", msg=filePath is empty");
        r0.w("AISDK_JSB_SaveImageToPhotosAlbumMethod", r14.toString());
        h.a.a(r12, "filePath cannot be empty", r15, null, 10);
        return;
    L5:
        IHostImageDepend r1 = r4.a.p;
        if (r1 != null) goto L8;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.g;
        r16.append(r17.a);
        r16.append(", msg=HostImageDepend is null");
        r0.e("AISDK_JSB_SaveImageToPhotosAlbumMethod", r16.toString());
        h.a.a(r12, "HostImageDepend is not registered", r17, null, 10);
        return;
    L8:
        r1.saveImageToPhotosAlbum(new SaveImageToPhotosAlbumRequest(r10, this.a, x3.a.e(r10, r13.getFilePath())), new b(r12));
    }
}
