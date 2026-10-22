package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import android.telephony.TelephonyCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends TelephonyCallback implements TelephonyCallback.CallStateListener {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // android.telephony.TelephonyCallback.CallStateListener
    public final void onCallStateChanged(int r2) {
        a.a(this.a, r2);
    }
}
