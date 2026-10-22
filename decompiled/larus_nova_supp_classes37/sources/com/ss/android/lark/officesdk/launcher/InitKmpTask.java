package com.ss.android.lark.officesdk.launcher;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/InitKmpTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "Companion", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class InitKmpTask extends AbstractLaunchTask<Object> {

    public static final class a {
    }

    static {
    }

    public InitKmpTask() {
    }

    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        tt7.b.a();     // Catch: Throwable -> L5
        Log.i("InitKmpTask", "init kmp container");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("InitKmpTask", "init kmp container failed", th);
        throw th;
    }
}
