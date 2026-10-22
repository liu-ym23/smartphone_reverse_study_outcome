package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "Lcom/bytedance/android/live/revenue/platform/hybrid/api/HybridView;", "invoke"}, k = 3, mv = {1, 5, 1})
final class AioLinkRpcServiceImpl$registerAioLinkBridge$2 extends Lambda implements Function0<View> {
    final /* synthetic */ IHybridComponent $componentContainer;

    public AioLinkRpcServiceImpl$registerAioLinkBridge$2(IHybridComponent r1) {
        this.$componentContainer = r1;
        super(0);
    }

    public final View invoke() {
        return this.$componentContainer.getHybridView();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m403invoke() {
        return invoke();
    }
}
