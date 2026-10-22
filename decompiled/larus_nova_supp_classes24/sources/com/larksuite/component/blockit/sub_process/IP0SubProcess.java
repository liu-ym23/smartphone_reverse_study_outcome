package com.larksuite.component.blockit.sub_process;

import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@RemoteService(hostProcess = IP0SubProcess.P0_PROCESS_NAME)
public interface IP0SubProcess extends IHookInterface {
    public static final String P0_PROCESS_NAME = "p0";

    void triggerRefresh(String r1);
}
