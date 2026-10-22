package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import android.telephony.PhoneStateListener;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends PhoneStateListener {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // android.telephony.PhoneStateListener
    @Deprecated(message = "Deprecated in Java")
    public final void onCallStateChanged(int r1, String r2) {
        a.a(this.a, r1);
    }
}
