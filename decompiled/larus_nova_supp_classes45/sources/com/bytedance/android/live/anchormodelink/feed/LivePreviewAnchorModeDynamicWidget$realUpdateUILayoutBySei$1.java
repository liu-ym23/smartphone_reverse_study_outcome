package com.bytedance.android.live.anchormodelink.feed;

import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class LivePreviewAnchorModeDynamicWidget$realUpdateUILayoutBySei$1 extends MutablePropertyReference0Impl {
    public LivePreviewAnchorModeDynamicWidget$realUpdateUILayoutBySei$1(LivePreviewAnchorModeDynamicWidget r7) {
        super(r7, LivePreviewAnchorModeDynamicWidget.class, "configOuterProvider", "getConfigOuterProvider()Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", 0);
    }

    public Object get() {
        IPreviewMultiLinkOuterConfigProvider r0 = ((LivePreviewAnchorModeDynamicWidget) ((CallableReference) this).receiver).d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        return r0;
    }

    public void set(Object r2) {
        IPreviewMultiLinkOuterConfigProvider r3 = (IPreviewMultiLinkOuterConfigProvider) r2;
        ((LivePreviewAnchorModeDynamicWidget) ((CallableReference) this).receiver).d = r3;
    }
}
