package com.ss.android.lark.framework.assembly.imageloader;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.abtest.feature.launch.LaunchAbTestConfig;
import com.ss.android.lark.image.i;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitImageModuleTask extends AbstractLaunchTask {
    public InitImageModuleTask() {
    }

    public final void a(Context r2) {
        List r3 = LaunchAbTestConfig.a;
        if (((Boolean) LaunchAbTestConfig.c.getValue()).booleanValue() == true) goto L6;
        Log.i("ImageModuleProvider", "preLoad");
        i.a();
        return;
    }
}
