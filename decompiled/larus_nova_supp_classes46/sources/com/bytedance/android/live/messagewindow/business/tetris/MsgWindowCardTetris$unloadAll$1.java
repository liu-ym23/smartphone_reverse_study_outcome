package com.bytedance.android.live.messagewindow.business.tetris;

import h71.d;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MsgWindowCardTetris$unloadAll$1 extends MutablePropertyReference0Impl {
    public MsgWindowCardTetris$unloadAll$1(MsgWindowCardTetris r7) {
        super(r7, MsgWindowCardTetris.class, "msgWindowPositionAdjuster", "getMsgWindowPositionAdjuster()Lcom/bytedance/android/live/room/api/messagewindow/process/IMsgWindowPositionAdjuster;", 0);
    }

    public Object get() {
        d r0 = ((MsgWindowCardTetris) ((CallableReference) this).receiver).v;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L5:
        return r0;
    }

    public void set(Object r2) {
        d r3 = (d) r2;
        ((MsgWindowCardTetris) ((CallableReference) this).receiver).v = r3;
    }
}
