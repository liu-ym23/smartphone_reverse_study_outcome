package com.larksuite.component.blockit.sub_process;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import oy7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@RemoteServiceImpl(service = IP0SubProcess.class)
public class P0SubProcessImpl implements IP0SubProcess {
    private static final String TAG = "P0SubProcessImpl";

    public P0SubProcessImpl(Context r1) {
    }

    @Override // com.larksuite.component.blockit.sub_process.IP0SubProcess
    public void triggerRefresh(String r4) {
        Log.i(TAG, "triggerRefresh START");
        int r1 = a.d.a;
        a.c(r4, false, false, null, null);
        Log.i(TAG, "triggerRefresh END");
    }
}
