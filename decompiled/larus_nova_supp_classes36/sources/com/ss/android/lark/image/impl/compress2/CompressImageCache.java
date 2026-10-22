package com.ss.android.lark.image.impl.compress2;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.diskmanage.storage.d;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class CompressImageCache {
    private String cacheDir;
    private final Context context;

    private void checkCacheDir() {
        if (TextUtils.isEmpty(this.cacheDir) == false) goto L5;
        this.cacheDir = d.h(this.context);
        return;
    L5:
        FileUtils.t(this.cacheDir);
    }

    public File createCacheFile(String r3) {
        return new PolarisFileWrapper(this.cacheDir, r3);
    }

    public File getCacheFile(String r3) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.cacheDir, r3);
        if (r0.exists() == false) goto L5;
        return r0;
    L5:
        return null;
    }

    public CompressImageCache(Context r1, String r2) {
        this.context = r1;
        this.cacheDir = r2;
        checkCacheDir();
    }
}
