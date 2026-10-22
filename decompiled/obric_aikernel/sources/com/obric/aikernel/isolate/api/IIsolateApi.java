package com.obric.aikernel.isolate.api;

import android.os.Bundle;
import com.bytedance.news.common.service.manager.IService;
import k7.a;

/* JADX INFO: loaded from: classes2.dex */
public interface IIsolateApi extends IService {
    a debugKV();

    boolean interceptByDebugMode(Bundle r10);

    boolean isOnlyRunBizFromProp(String r10);

    boolean isSysAikernelSwitchEnabled(String r10, boolean r11);

    boolean testProvisionBizFromProp(String r10);
}
