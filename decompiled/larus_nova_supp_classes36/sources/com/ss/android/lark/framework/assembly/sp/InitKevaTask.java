package com.ss.android.lark.framework.assembly.sp;

import android.content.Context;
import com.bytedance.keva.KevaBuilder;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.o0;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/framework/assembly/sp/InitKevaTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "sp-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitKevaTask extends AbstractLaunchTask<Object> {
    @Inject
    public InitKevaTask() {
    }

    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (o0.a(r2) == true) goto L5;
        return;
    L5:
        KevaBuilder.getInstance().setContext(r2.getApplicationContext());
    }
}
