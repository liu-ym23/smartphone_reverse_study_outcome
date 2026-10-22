package com.ss.android.lark.framework.assembly.displaystore;

import android.content.Context;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/framework/assembly/displaystore/OfficeInitDisplayStoreTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "initDisplayStore", "Companion", "displaymanager-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OfficeInitDisplayStoreTask extends AbstractLaunchTask<Object> {

    public static final class a {
    }

    static {
    }

    public OfficeInitDisplayStoreTask() {
    }

    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        OfficeInitDisplayStoreTask$initDisplayStore$1 r4 = OfficeInitDisplayStoreTask$initDisplayStore$1.INSTANCE;
        ZoomLevel6 r0 = zz7.b.a;
        Intrinsics.checkNotNullParameter(r4, "setter");
        Log.i("DisplayManagerTAG", "init office sdk");
        zz7.b.a = (ZoomLevel6) r4.invoke();
    }
}
