package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ LiveBasePluginManager a;

    public n(LiveBasePluginManager r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        d10.c r12 = (d10.c) r11;
        int r13 = com.bytedance.android.live.broadcastgame.opengame.debug.j.d;
        Context r4 = this.a.getContext();
        LiveBasePluginManager r7 = this.a;
        com.bytedance.android.live.broadcastgame.opengame.debug.d r3 = r7.d;
        DataCenter r5 = r7.h;
        ViewGroup r6 = r7.j;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r3, "pluginDebuggerProvider");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "containerView");
        Intrinsics.checkNotNullParameter(r7, "gameManager");
        View r14 = View.inflate(r4, 2131565623, null);
        EditText r1 = (EditText) r14.findViewById(2131371791);
        EditText r2 = (EditText) r14.findViewById(2131371799);
        new AlertDialog.Builder(r4).setTitle("调试信息").setView(r14).setCancelable(true).setNegativeButton("确定", new com.bytedance.android.live.broadcastgame.opengame.debug.h(r1, r2, r3, r4, r5, r6, r7)).setPositiveButton("取消", com.bytedance.android.live.broadcastgame.opengame.debug.i.a).show();
    }
}
