package com.ss.android.lark.framework.assembly.rxjava;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.b;
import com.ss.android.lark.utils.rxjava.f;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Properties;
import kjb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitRxJavaTask extends AsyncLaunchTask {
    public InitRxJavaTask() {
    }

    public final void a(Context r3) {
        RxJavaPlugins.setErrorHandler(new f(DevEnvUtil.isDevelopPackage(b.a)));
        Properties r4 = System.getProperties();
        r4.setProperty("rx2.purge-enabled", "false");
        r4.setProperty("rx2.io-keep-alive-time", "300");
        RxJavaPlugins.setScheduleHandler(new a());
    }
}
