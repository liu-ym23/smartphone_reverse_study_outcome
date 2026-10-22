package com.ss.android.lark.framework.assembly.lkui;

import android.app.Activity;
import android.content.Context;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.appcontext.applifecycle.t;
import com.ss.android.lark.appcontext.applifecycle.w;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitLKUIToastTask extends AbstractLaunchTask {
    public final a c;
    public final b d;

    public class a implements t {
        public a() {
        }

        public final void a(Activity r2) {
            Log.i("InitLKUIToastTask", "onBackToFrontEvent");
            LKUIToast.enableToast();
        }
    }

    public class b implements w {
        public b() {
        }

        public final void a(Class r2) {
            Log.i("InitLKUIToastTask", "onFrontToBackEvent");
            LKUIToast.disableToast();
        }
    }

    public InitLKUIToastTask() {
        this.c = new a();
        this.d = new b();
    }

    public final void a(Context r2) {
        a r3 = this.c;
        if (r3 != null) goto L5;
        List r4 = LifecycleHandler.a;
    L6:
        b r5 = this.d;
        if (r5 == null) goto L11;
        ((CopyOnWriteArrayList) LifecycleHandler.b).add(r5);
        return;
    L11:
        return;
    L5:
        ((CopyOnWriteArrayList) LifecycleHandler.a).add(r3);
        goto L6
    }
}
