package com.ss.android.lark.framework.assembly.soloader;

import android.content.Context;
import com.facebook.soloader.SoLoader;
import com.larksuite.framework.launch.task.AsyncLaunchTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitSoLoaderTask extends AsyncLaunchTask {
    public InitSoLoaderTask() {
    }

    public final void a(Context r2) {
        SoLoader.init(r2, false);
    }
}
