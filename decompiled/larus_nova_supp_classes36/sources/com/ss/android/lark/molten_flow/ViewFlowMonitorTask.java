package com.ss.android.lark.molten_flow;

import android.content.Context;
import com.bytedance.lark.view_flow_wrapper.ViewFlowPlugin;
import com.bytedance.lark.view_flow_wrapper.e;
import com.bytedance.lark.view_flow_wrapper.y;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yrb.a;
import yrb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/molten_flow/ViewFlowMonitorTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "lark-molten-flow_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ViewFlowMonitorTask extends AsyncLaunchTask<Object> {
    public ViewFlowMonitorTask() {
    }

    public final void a(Context r3) {
        y r4 = ViewFlowPlugin.a;
        c r5 = new c();
        Intrinsics.checkNotNullParameter(r5, "callback");
        ViewFlowPlugin.a = r5;
        a r6 = new a();
        Intrinsics.checkNotNullParameter(r6, "wrapper");
        e r1 = com.bytedance.lark.view_flow_wrapper.internal.a.a;
        Intrinsics.checkNotNullParameter(r6, "wrapper");
        com.bytedance.lark.view_flow_wrapper.internal.a.a = r6;
    }
}
