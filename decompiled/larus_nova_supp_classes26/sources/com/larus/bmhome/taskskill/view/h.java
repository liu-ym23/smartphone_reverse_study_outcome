package com.larus.bmhome.taskskill.view;

import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ PcConnectionStatusManager a;

    public /* synthetic */ h(PcConnectionStatusManager r1) {
        this.a = r1;
    }

    public final Object invoke(Object r14) {
        PcConnectionStatusManager r0 = this.a;
        AllDeviceResponse r15 = (AllDeviceResponse) r14;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("receive allDevicesLiveData change to [");
        if (r15 == null) goto L7;
        List r3 = r15.getDevices();
        if (r3 == null) goto L7;
        String r4 = CollectionsKt.joinToString$default(r3, null, null, null, 0, null, new m(), 31, null);
    L8:
        r2.append(r4);
        r2.append("], pcConnectionStatusBinding is ");
        if (r0.e != null) goto L11;
        String r5 = "null";
    L12:
        r2.append(r5);
        r1.i("PcConnectionStatusManager", r2.toString());
        r0.d(r15, true);
        return Unit.INSTANCE;
    L11:
        r5 = "non-null";
    L7:
        r4 = null;
        goto L8
    }
}
