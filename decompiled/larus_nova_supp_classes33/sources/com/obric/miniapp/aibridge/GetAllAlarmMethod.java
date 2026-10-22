package com.obric.miniapp.aibridge;

import android.app.Application;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.alarm.AlarmManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/GetAllAlarmMethod;", "Lcom/obric/miniapp/aibridge/AbsGetAllAlarmMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsGetAllAlarmMethodIDL$GetAllAlarmParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsGetAllAlarmMethodIDL$GetAllAlarmResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAllAlarmMethod extends AbsGetAllAlarmMethodIDL {
    public GetAllAlarmMethod() {
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.obric.miniapp.aibridge.g] */
    public final void handle(e3.d r4, ParamModel r5, final f3.h r6) {
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetAllAlarmMethodIDL.a) r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        zka.r.a r7 = zka.r.a;
        AppHost.Companion r8 = AppHost.a;
        Application r0 = r8.getApplication();
        r7.getClass();
        if (zka.r.a.a(r0) == false) goto L7;
        yka.a r9 = yka.a.b;
        if (r9.e(r8.getApplication()) == false) goto L7;
        FLogger.a.d("GetAllAlarmMethod", "getAllAlarmIds");
        r9.d(r8.getApplication(), new f(r6));
        return;
    L7:
        AlarmManager r10 = AlarmManager.a;
        ?? r11 = new g(r6);
        r10.getClass();
        AlarmManager.h(r11);
    }
}
