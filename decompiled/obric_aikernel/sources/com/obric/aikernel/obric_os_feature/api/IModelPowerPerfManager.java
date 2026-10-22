package com.obric.aikernel.obric_os_feature.api;

import android.os.Bundle;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.middleware.interfaces.a;
import com.obric.aikernel.sdk.config.RequestParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IModelPowerPerfManager extends IService, a {
    void notifyModelUsage(JSONObject r10);

    @Override // com.obric.aikernel.middleware.interfaces.a
    void notifyVMExecuteBegin(RequestParams r10, Bundle r11);

    @Override // com.obric.aikernel.middleware.interfaces.a
    void notifyVMExecuteEnd(RequestParams r10);
}
