package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ToolbarCommentBehavior$showRedDot$dataCenter$1 extends MutablePropertyReference0Impl {
    public ToolbarCommentBehavior$showRedDot$dataCenter$1(s2 r7) {
        super(r7, s2.class, "mDataCenter", "getMDataCenter()Lcom/bytedance/ies/sdk/widgets/DataCenter;", 0);
    }

    public Object get() {
        DataCenter r0 = ((s2) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L5:
        return r0;
    }

    public void set(Object r3) {
        s2 r0 = (s2) ((CallableReference) this).receiver;
        DataCenter r4 = (DataCenter) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.a = r4;
    }
}
