package com.larus.dora.impl;

import com.larus.account.base.api.ILoginService;
import com.mammon.audiosdk.SAMICore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Runnable {
    public /* synthetic */ m() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        SAMICore.UpdateWakeupFingerPrintUid(ILoginService.a.getAccountInfo().c);
    }
}
