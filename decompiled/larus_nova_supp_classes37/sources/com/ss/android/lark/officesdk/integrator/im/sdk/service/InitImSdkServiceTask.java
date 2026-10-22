package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/im/sdk/service/InitImSdkServiceTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "getTaskName", "", "Companion", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class InitImSdkServiceTask extends AbstractLaunchTask<InitImSdkServiceTask> {

    public static final class a {
    }

    static {
    }

    public final String f() {
        return "InitImSdkService";
    }

    public InitImSdkServiceTask() {
    }

    public final void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Log.i("InitImSdkService", "before init IM SDK");
        ikb.c.a r5 = new ikb.c.a(LarkContext.getApplication());
        f r0 = new f();
        Intrinsics.checkNotNullParameter(r0, "proxyFactory");
        r5.b = r0;
        ikb.c r1 = new ikb.c(r5);
        ImSdk r6 = ImSdk.a;
        monitor-enter(r6);
        Intrinsics.checkNotNullParameter(r1, "options");     // Catch: Throwable -> L13
        if (ImSdk.c == false) goto L9;
        int r2 = com.ss.android.lark.im.sdk.a.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("Duplicated init method call.", "message");     // Catch: Throwable -> L13
        Log.w("ImSdk", "Duplicated init method call.");     // Catch: Throwable -> L13
        monitor-exit(r6);
    L11:
        Log.i("InitImSdkService", "after init IM SDK");
        return;
    L9:
        int r3 = com.ss.android.lark.im.sdk.a.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("init", "message");     // Catch: Throwable -> L13
        Log.i("ImSdk", "init");     // Catch: Throwable -> L13
        ImSdk.b = r1.getContext();     // Catch: Throwable -> L13
        ikb.h r7 = ImSdkProxy.a;     // Catch: Throwable -> L13
        ImSdkProxy.a = r1.b;     // Catch: Throwable -> L13
        ImSdk.c = true;     // Catch: Throwable -> L13
        monitor-exit(r6);
    L13:
        th = move-exception;
        throw th;
    }
}
