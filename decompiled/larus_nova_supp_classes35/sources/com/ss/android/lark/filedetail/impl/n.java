package com.ss.android.lark.filedetail.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.integrator.mock.FileDetailModuleDependencyMock;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements RxScheduledExecutor.Producer<String> {
    public final /* synthetic */ FileDetailFragment a;

    public final Object produce() {
        FileDetailFragment r0 = this.a;
        FileDetailModuleDependencyMock.b r1 = r0.E;
        r0.i.getKey();
        r1.getClass();
        Log.w("FileDetailModuleDependencyMock", "getDownloadFilePath mocked");
        return null;
    }

    public n(FileDetailFragment r1) {
        this.a = r1;
    }
}
