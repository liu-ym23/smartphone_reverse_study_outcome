package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class DynamicEmojiDialogBuilder$check$1 extends MutablePropertyReference0Impl {
    public DynamicEmojiDialogBuilder$check$1(t r7) {
        super(r7, t.class, "context", "getContext()Landroid/content/Context;", 0);
    }

    public Object get() {
        Context r0 = ((t) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }

    public void set(Object r2) {
        Context r3 = (Context) r2;
        ((t) ((CallableReference) this).receiver).a = r3;
    }
}
