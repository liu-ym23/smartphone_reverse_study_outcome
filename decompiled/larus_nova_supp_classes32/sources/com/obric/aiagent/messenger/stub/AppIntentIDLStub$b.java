package com.obric.aiagent.messenger.stub;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.IFlowGetLocationCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.OLocationInfo;
import hq9.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AppIntentIDLStub$b implements a3 {
    public final /* synthetic */ AppIntentIDLStub a;
    public final /* synthetic */ IFlowGetLocationCallbackIDL b;

    public AppIntentIDLStub$b(AppIntentIDLStub r1, IFlowGetLocationCallbackIDL r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(LocationResult r6, Integer r7, GeoLocationInfo r8) {
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.CODE_KEY);
        FLogger r0 = FLogger.a;
        String r1 = AppIntentIDLStub.access$getTAG$p(this.a);
        StringBuilder r2 = new StringBuilder("getLocation onLocationDataResult called, code:");
        r2.append(r6);
        r2.append(", sdkErrorCode:");
        r2.append(r7);
        r2.append(", location isNotNull:");
        if (r8 == null) goto L5;
        boolean r4 = true;
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        if (r6 != LocationResult.SUCCESS) goto L12;
        if (r8 == null) goto L12;
        IFlowGetLocationCallbackIDL r9 = this.b;
        if (r9 == null) goto L16;
        r9.onLocationResult(true, new OLocationInfo(r8.getLongitude(), r8.getLatitude()));
        return;
    L16:
        return;
    L12:
        IFlowGetLocationCallbackIDL r10 = this.b;
        if (r10 == null) goto L18;
        r10.onLocationResult(false, null);
        return;
    L18:
        return;
    L5:
        r4 = false;
        goto L6
    }
}
