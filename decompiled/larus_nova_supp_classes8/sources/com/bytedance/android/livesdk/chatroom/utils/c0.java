package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarConstraints;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarSlot;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c0 {
    void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r1, ExtendedToolbarButton r2);

    String b();

    Map<ExtendedToolbarButton, ToolbarSlot> c();

    void d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r1, ExtendedToolbarButton r2);

    ToolbarConstraints e();

    void f(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r1, ExtendedToolbarButton r2);

    Map<ExtendedToolbarButton, ToolbarSlot> g();

    ArrayList<ExtendedToolbarButton> h();

    int i(ExtendedToolbarButton r1);
}
