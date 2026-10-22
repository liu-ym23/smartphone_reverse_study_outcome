package com.bytedance.ai.bridge.method.media;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.media.image.AbsPreviewImageMethodIDL;
import com.bytedance.ai.bridge.service.IHostImageDepend;
import com.bytedance.ai.bridge.service.PreviewImageRequest;
import com.bytedance.ai.utils.g;
import e3.d;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/media/PreviewImageMethod;", "Lcom/bytedance/ai/bridge/media/image/AbsPreviewImageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/media/image/AbsPreviewImageMethodIDL$PreviewImageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/media/image/AbsPreviewImageMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewImageMethod extends AbsPreviewImageMethodIDL {

    public static final class a {
    }

    static {
    }

    public PreviewImageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r12, ParamModel r13, h r14) {
        AbsPreviewImageMethodIDL.b r15 = (AbsPreviewImageMethodIDL.b) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        g r0 = g.a;
        r0.i("AISDK_JSB_PreviewImageMethod", "call start, urlCount=" + r15.getUrls().size() + ", current=" + r15.getCurrent() + ", showmenu=" + r15.getShowmenu());
        IHostImageDepend r1 = r4.a.p;
        String r10 = null;
        if (r1 != null) goto L6;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.g;
        r16.append(r17.a);
        r16.append(", msg=HostImageDepend is null");
        r0.e("AISDK_JSB_PreviewImageMethod", r16.toString());
        h.a.a(r14, "HostImageDepend is not registered", r17, null, 10);
        return;
    L6:
        if (r15.getUrls().isEmpty() == false) goto L8;
        StringBuilder r18 = new StringBuilder("call failed, errNo=");
        f3.a r19 = f3.a.h;
        r18.append(r19.a);
        r18.append(", msg=urls is empty");
        r0.w("AISDK_JSB_PreviewImageMethod", r18.toString());
        h.a.a(r14, "urls cannot be empty", r19, null, 10);
        return;
    L8:
        List<String> r11 = r15.getUrls();
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r21 = r11.iterator();
    L10:
        if (r21.hasNext() == false) goto L12;
        String r22 = (String) r21.next();
        Intrinsics.checkNotNull(r22);
        r20.add(x3.a.e(r12, r22));
        goto L10
    L12:
        String r23 = r15.getCurrent();
        if (r23 == null) goto L15;
        r10 = x3.a.e(r12, r23);
    L15:
        r1.previewImage(new PreviewImageRequest(r12, this.a, r20, r10, r15.getShowmenu()), new com.bytedance.ai.bridge.method.media.a(r14));
    }
}
