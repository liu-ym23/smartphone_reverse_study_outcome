package com.bytedance.android.live.room;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface u {
    void a(DataCenter r1, List<ToolbarButton> r2);

    void b(DataCenter r1, List<ToolbarButton> r2);

    void c(List<ExtendedToolbarButton> r1, boolean r2);

    List<Runnable> d(DataCenter r1, Context r2);

    void e(DataCenter r1, List<ToolbarButton> r2);

    void f();
}
