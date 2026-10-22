package com.bytedance.android.live.liveinteract.videotalk.emoji;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class DynamicEmojiDialogBuilder$check$3 extends MutablePropertyReference0Impl {
    public DynamicEmojiDialogBuilder$check$3(t r7) {
        super(r7, t.class, "requestPage", "getRequestPage()Ljava/lang/String;", 0);
    }

    public Object get() {
        String r0 = ((t) ((CallableReference) this).receiver).d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L5:
        return r0;
    }

    public void set(Object r2) {
        String r3 = (String) r2;
        ((t) ((CallableReference) this).receiver).d = r3;
    }
}
