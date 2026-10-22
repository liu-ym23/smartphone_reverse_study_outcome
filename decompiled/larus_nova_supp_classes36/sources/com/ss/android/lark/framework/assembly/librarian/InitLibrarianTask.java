package com.ss.android.lark.framework.assembly.librarian;

import android.content.Context;
import com.bytedance.librarian.c;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/framework/assembly/librarian/InitLibrarianTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "Companion", "LarkLibrarianMonitor", "librarian-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitLibrarianTask extends AsyncLaunchTask<Object> {

    public static final class a {
    }

    public static final class b extends c {
        public b() {
        }

        public final void a(String r2) {
            if (r2 != null) goto L4;
            r2 = "nil";
        L4:
            Log.d("com.ss.android.lark.framework.assembly.librarian.InitLibrarianTask", r2);
        }

        public final void b(String r2) {
            if (r2 != null) goto L4;
            r2 = "nil";
        L4:
            Log.w("com.ss.android.lark.framework.assembly.librarian.InitLibrarianTask", r2);
        }

        public final void c(String r2, Throwable r3) {
            if (r2 != null) goto L4;
            r2 = "nil";
        L4:
            Log.w("com.ss.android.lark.framework.assembly.librarian.InitLibrarianTask", r2, r3);
        }
    }

    static {
    }

    public InitLibrarianTask() {
    }

    public final void a(Context r3) {
        if (r3 == null) goto L5;
        Log.i("com.ss.android.lark.framework.assembly.librarian.InitLibrarianTask", "init librarian loader");
        com.bytedance.librarian.a.b(r3, ApkUtil.getAppVersionName(r3), new b());
        return;
    }
}
