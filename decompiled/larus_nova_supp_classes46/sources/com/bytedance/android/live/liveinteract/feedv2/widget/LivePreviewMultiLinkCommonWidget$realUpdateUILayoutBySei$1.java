package com.bytedance.android.live.liveinteract.feedv2.widget;

import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class LivePreviewMultiLinkCommonWidget$realUpdateUILayoutBySei$1 extends MutablePropertyReference0Impl {
    public LivePreviewMultiLinkCommonWidget$realUpdateUILayoutBySei$1(LivePreviewMultiLinkCommonWidget r7) {
        super(r7, LivePreviewMultiLinkCommonWidget.class, "configOuterProvider", "getConfigOuterProvider()Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", 0);
    }

    public Object get() {
        IPreviewMultiLinkOuterConfigProvider r0 = ((LivePreviewMultiLinkCommonWidget) ((CallableReference) this).receiver).e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        return r0;
    }

    public void set(Object r2) {
        IPreviewMultiLinkOuterConfigProvider r3 = (IPreviewMultiLinkOuterConfigProvider) r2;
        ((LivePreviewMultiLinkCommonWidget) ((CallableReference) this).receiver).e = r3;
    }
}
