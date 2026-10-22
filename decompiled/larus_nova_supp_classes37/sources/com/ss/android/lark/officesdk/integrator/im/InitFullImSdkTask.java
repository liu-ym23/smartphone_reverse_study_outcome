package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.integrator.im.sdk.service.InitImSdkServiceTask;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/im/InitFullImSdkTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "Companion", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class InitFullImSdkTask extends AbstractLaunchTask<InitFullImSdkTask> {

    public static final class a {
    }

    static {
    }

    public InitFullImSdkTask() {
    }

    public final void a(Context r4) {
        ImSdk r0 = ImSdk.a;     // Catch: Throwable -> L8
        if (ImSdk.c == true) goto L6;
        Log.w("InitFullImSdkTask", "IM SDK is not initialized");     // Catch: Throwable -> L8
        new InitImSdkServiceTask().a(LarkContext.getApplication());     // Catch: Throwable -> L8
    L6:
        Log.i("InitFullImSdkTask", "initFullImSdk successfully");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Log.e("InitFullImSdkTask", "initFullImSdk failed: " + th);
    }
}
