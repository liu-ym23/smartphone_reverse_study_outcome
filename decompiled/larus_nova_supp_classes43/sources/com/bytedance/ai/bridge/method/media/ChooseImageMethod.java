package com.bytedance.ai.bridge.method.media;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.media.image.AbsChooseImageMethodIDL;
import com.bytedance.ai.bridge.service.ChooseImageRequest;
import com.bytedance.ai.bridge.service.IHostImageDepend;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import e3.d;
import f3.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/media/ChooseImageMethod;", "Lcom/bytedance/ai/bridge/media/image/AbsChooseImageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/media/image/AbsChooseImageMethodIDL$ChooseImageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/media/image/AbsChooseImageMethodIDL$ChooseImageResultModel;", "copyToTempAndEncode", "", "fileManager", "Lcom/bytedance/ai/file/AppletFileManager;", "realPath", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseImageMethod extends AbsChooseImageMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public ChooseImageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r11, ParamModel r12, final h r13) {
        AbsChooseImageMethodIDL.a r14 = (AbsChooseImageMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        g r0 = g.a;
        r0.i("AISDK_JSB_ChooseImageMethod", "call start, count=" + r14.getCount() + ", sizeType=" + r14.getSizeType() + ", sourceType=" + r14.getSourceType());
        IHostImageDepend r1 = r4.a.p;
        List r10 = null;
        if (r1 != null) goto L5;
        StringBuilder r15 = new StringBuilder("call failed, errNo=");
        f3.a r16 = f3.a.g;
        r15.append(r16.a);
        r15.append(", msg=HostImageDepend is null");
        r0.e("AISDK_JSB_ChooseImageMethod", r15.toString());
        h.a.a(r13, "HostImageDepend is not registered", r16, null, 10);
        return;
    L5:
        final AppletFileManager r17 = x3.a.d(r11);
        String r18 = this.a;
        int r19 = r14.getCount();
        List<String> r20 = r14.getSizeType();
        if (r20 == null) goto L8;
        List r21 = CollectionsKt.toList(r20);
    L9:
        if (r21 != null) goto L11;
        r21 = CollectionsKt.emptyList();
    L11:
        List r22 = r21;
        List<String> r110 = r14.getSourceType();
        if (r110 == null) goto L14;
        r10 = CollectionsKt.toList(r110);
    L14:
        if (r10 != null) goto L16;
        List r23 = CollectionsKt.emptyList();
    L17:
        r1.chooseImage(new ChooseImageRequest(r11, r18, r19, r22, r23), new AnonymousClass1(this, r17, r13));
        return;
    L16:
        r23 = r10;
        goto L17
    L8:
        r21 = null;
        goto L9
    }
}
