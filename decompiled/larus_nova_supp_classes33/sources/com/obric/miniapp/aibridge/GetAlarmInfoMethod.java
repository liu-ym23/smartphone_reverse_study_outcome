package com.obric.miniapp.aibridge;

import android.app.Application;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.alarm.AlarmManager;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/GetAlarmInfoMethod;", "Lcom/obric/miniapp/aibridge/AbsGetAlarmInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsGetAlarmInfoMethodIDL$GetAlarmInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsGetAlarmInfoMethodIDL$GetAlarmInfoResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAlarmInfoMethod extends AbsGetAlarmInfoMethodIDL {
    public GetAlarmInfoMethod() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.miniapp.aibridge.e] */
    public final void handle(e3.d r5, ParamModel r6, final f3.h r7) {
        AbsGetAlarmInfoMethodIDL.a r8 = (AbsGetAlarmInfoMethodIDL.a) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r9 = r8.getAlarmId();
        zka.r.a r0 = zka.r.a;
        AppHost.Companion r1 = AppHost.a;
        Application r2 = r1.getApplication();
        r0.getClass();
        if (zka.r.a.a(r2) == false) goto L7;
        yka.a r3 = yka.a.b;
        if (r3.e(r1.getApplication()) == false) goto L7;
        FLogger.a.d("GetAlarmInfoMethod", SystemAppletMethod.METHOD_GET_ALARM_JSON_BY_ID);
        r3.c(r1.getApplication(), r8.getAlarmId(), new d(r7));
        return;
    L7:
        AlarmManager r10 = AlarmManager.a;
        ?? r4 = new e(r7);
        r10.getClass();
        AlarmManager.g(r9, r4);
    }
}
