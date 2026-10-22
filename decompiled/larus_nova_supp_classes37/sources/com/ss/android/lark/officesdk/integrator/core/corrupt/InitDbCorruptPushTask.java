package com.ss.android.lark.officesdk.integrator.core.corrupt;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import fab.c;
import fab.e;
import fab.f;
import fab.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wtb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/core/corrupt/InitDbCorruptPushTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "registerPush", "Companion", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class InitDbCorruptPushTask extends AbstractLaunchTask<Object> {

    public static final class a {
    }

    static {
    }

    public InitDbCorruptPushTask() {
    }

    public final void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Log.i("InitDbCorruptPushTask", "register db corrupt push before IM SDK init");
        if (b.a == null) goto L5;
    L14:
        b.a.getClass();
        g r5 = g.a.a;
        e r6 = e.a.a;
        r6.b = new f();
        if (r6.a.compareAndSet(false, true) == true) goto L17;
        Log.i("DataCorruptPush", "PUSH_DATA_CORRUPT listener has already registered.");
        return;
    L17:
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_DATA_CORRUPT, new c(r6));
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.a != null) goto L9;
        b.a = new fab.a(b.a.a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L14
    }
}
