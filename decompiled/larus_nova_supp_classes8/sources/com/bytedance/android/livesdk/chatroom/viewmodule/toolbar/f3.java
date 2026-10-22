package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.live.base.model.message.l5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f3 {
    public static final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s a(l5 r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$convert2Model");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r0 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s();
        r0.a = r4.getComponentType();
        String r2 = "";
        if (TextUtils.isEmpty(r4.getText()) == true) goto L9;
        String r1 = r4.getText();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
    L9:
        if (TextUtils.isEmpty(r4.getSchema()) == true) goto L14;
        String r3 = r4.getSchema();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.e = r3;
    L14:
        r0.c = r4.getIcon();
        String r5 = r4.getExtraData();
        if (r5 == null) goto L18;
        r2 = r5;
    L18:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.d = r2;
        r0.f = r4.getGroupId();
        r0.l.b = true;
        r0.g = (int) r4.getShowType();
        return r0;
    }

    public static final ToolbarButton b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$toLocalData");
        SparseArray<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w> r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0.e;
        return com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0.a.a(r1.a, r2, r3);
    }
}
