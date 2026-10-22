package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.cleaner;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.FileUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/cleaner/WebResCleaner;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "cleanWebappRes", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WebResCleaner {
    public static final WebResCleaner INSTANCE = null;
    public static final String TAG = "WebResCleaner";

    static {
        INSTANCE = new WebResCleaner();
    }

    private WebResCleaner() {
    }

    private final void cleanWebappRes() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(ChameleonResUtils.INSTANCE.getWebcontainerRootDir());
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0.getAbsolutePath() + '_' + System.currentTimeMillis());
        if (r0.renameTo(r1) == false) goto L5;
        FileUtils.forceDelete(r1);
        Log.i(TAG, "cleanResource, clean webapp dir success");
        return;
    L5:
        Log.w(TAG, "cleanResource: rename failed ");
    }
}
