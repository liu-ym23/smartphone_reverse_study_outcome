package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/lynx/tasm/LynxView;", "invoke"}, k = 3, mv = {1, 5, 1})
final class AioLinkRpcServiceImpl$registerAioLinkBridge$1 extends Lambda implements Function0<LynxView> {
    final /* synthetic */ IHybridComponent $componentContainer;

    public AioLinkRpcServiceImpl$registerAioLinkBridge$1(IHybridComponent r1) {
        this.$componentContainer = r1;
        super(0);
    }

    public final LynxView invoke() {
        View r0 = this.$componentContainer.getHybridView();
        if ((r0 instanceof LynxView) == true) goto L6;
        r0 = null;
    L6:
        return (LynxView) r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m402invoke() {
        return invoke();
    }
}
