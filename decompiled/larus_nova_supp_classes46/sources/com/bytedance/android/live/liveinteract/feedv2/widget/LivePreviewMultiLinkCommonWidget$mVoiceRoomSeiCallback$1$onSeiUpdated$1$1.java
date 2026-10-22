package com.bytedance.android.live.liveinteract.feedv2.widget;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class LivePreviewMultiLinkCommonWidget$mVoiceRoomSeiCallback$1$onSeiUpdated$1$1 extends MutablePropertyReference0Impl {
    public LivePreviewMultiLinkCommonWidget$mVoiceRoomSeiCallback$1$onSeiUpdated$1$1(LivePreviewMultiLinkCommonWidget r7) {
        super(r7, LivePreviewMultiLinkCommonWidget.class, "mRoom", "getMRoom()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", 0);
    }

    public Object get() {
        IRoom r0 = ((LivePreviewMultiLinkCommonWidget) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L5:
        return r0;
    }

    public void set(Object r2) {
        IRoom r3 = (IRoom) r2;
        ((LivePreviewMultiLinkCommonWidget) ((CallableReference) this).receiver).a = r3;
    }
}
