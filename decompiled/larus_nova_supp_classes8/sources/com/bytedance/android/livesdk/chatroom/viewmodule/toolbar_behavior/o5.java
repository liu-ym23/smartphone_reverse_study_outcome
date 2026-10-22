package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o5 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i {
    public final /* synthetic */ ToolbarTransformWidgetBehavior a;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final /* synthetic */ void a() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final /* synthetic */ void onCancelClick() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final /* synthetic */ void onConfirmClick() {
    }

    public o5(ToolbarTransformWidgetBehavior r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        if (r4 == false) goto L6;
        this.a.e();
        return;
    }
}
