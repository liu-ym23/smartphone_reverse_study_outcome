package com.byted.mgl.merge.base.api.internal;

import com.byted.mgl.merge.base.api.internal.delegate.IDelegateIpc;
import com.bytedance.bdp.serviceapi.defaults.platform.internal.AMglInvCallerService;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpHostMethodResult;
import kb4.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IBaseInvCallerService extends AMglInvCallerService {
    /* synthetic */ BdpHostMethodResult callHostMethodInMainProc(String r1, JSONObject r10);

    /* synthetic */ void callHostMethodInMainProc(String r1, JSONObject r10, a r11);

    /* synthetic */ void dispatchHostEvent(String r1, JSONObject r10);

    /* synthetic */ String getDeviceId();

    /* synthetic */ String getInstallId();

    IDelegateIpc getIpcDelegate();

    /* synthetic */ JSONObject getSettings(String r1);
}
