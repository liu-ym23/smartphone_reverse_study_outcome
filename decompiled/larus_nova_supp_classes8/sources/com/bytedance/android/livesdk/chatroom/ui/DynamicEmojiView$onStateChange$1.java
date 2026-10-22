package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DynamicEmojiView$onStateChange$1 extends MutablePropertyReference0Impl {
    public DynamicEmojiView$onStateChange$1(DynamicEmojiView r7) {
        super(r7, DynamicEmojiView.class, "taskEnd", "getTaskEnd()Lkotlin/jvm/functions/Function0;", 0);
    }

    public Object get() {
        Function0<Unit> r0 = ((DynamicEmojiView) ((CallableReference) this).receiver).h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskEnd");
    L5:
        return r0;
    }

    public void set(Object r2) {
        Function0<Unit> r3 = (Function0) r2;
        ((DynamicEmojiView) ((CallableReference) this).receiver).h = r3;
    }
}
