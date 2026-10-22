package com.larus.avlink;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b1 implements Function0 {
    public final /* synthetic */ String a;

    public /* synthetic */ b1(String r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a;
        e10 r1 = e10.a;
        if (Intrinsics.areEqual(e10.w0().getWakeupComfortEnable(), Boolean.FALSE) == true) goto L20;
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L20;
        DeviceService r3 = r2.device();
        if (r3 == null) goto L20;
        boolean r4 = Intrinsics.areEqual(r0, "豆包豆包");
        boolean r5 = r3.p0(null);
        boolean r7 = true;
        if (r3.M() == false) goto L13;
        boolean r6 = r3.I();
    L14:
        boolean r8 = r3.f0();
        FLogger.a.i("DoraWakeupResponse", "shouldEnableWakeupResponse: deviceEnable=" + r5 + ", isConvStartEndSoundEnabled=" + r6 + "isNaturalConversationOpen=" + r8 + ", keyword=" + r0);
        if (r4 == false) goto L20;
        if (r5 == false) goto L20;
        if (r8 == false) goto L20;
        if (r6 == false) goto L20;
    L21:
        if (r7 == true) goto L23;
        FLogger.a.i("DoraWakeupResponse", "onWakeupStart: skip, keyword=" + r0);
        return Unit.INSTANCE;
    L23:
        DoraWakeupResponseManager r9 = DoraWakeupResponseManager.a;
        DoraWakeupResponseManager.d();
        DoraWakeupResponseManager.f = System.currentTimeMillis();
        FLogger.a.i("DoraWakeupResponse", "onWakeupStart: start timer, wakeupStartTimestampMs=" + DoraWakeupResponseManager.f);
        CoroutineScope r10 = DoraWakeupResponseManager.b;
        DoraWakeupResponseManager.c = BuildersKt.launch$default(r10, null, null, new DoraWakeupResponseManager$onWakeupStart$1$1(null), 3, null);
        DoraWakeupResponseManager.d = BuildersKt.launch$default(r10, null, null, new DoraWakeupResponseManager$onWakeupStart$1$2(null), 3, null);
        return Unit.INSTANCE;
    L13:
        r6 = true;
    L20:
        r7 = false;
        goto L21
    }
}
