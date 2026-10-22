package com.ss.android.lark.framework.assembly.imageloader;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.larksuite.framework.launch.task.AsyncLaunchTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PreloadGlideTask extends AsyncLaunchTask {
    public PreloadGlideTask() {
    }

    public final void a(Context r1) {
        Glide.get(r1);
    }
}
