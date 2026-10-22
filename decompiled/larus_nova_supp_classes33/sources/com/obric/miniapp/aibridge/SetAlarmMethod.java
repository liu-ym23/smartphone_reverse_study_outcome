package com.obric.miniapp.aibridge;

import android.app.Application;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.alarm.AlarmManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/SetAlarmMethod;", "Lcom/obric/miniapp/aibridge/AbsSetAlarmMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsSetAlarmMethodIDL$SetAlarmParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsSetAlarmMethodIDL$SetAlarmResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetAlarmMethod extends AbsSetAlarmMethodIDL {
    public SetAlarmMethod() {
    }

    public final void handle(e3.d r11, ParamModel r12, final f3.h r13) {
        AbsSetAlarmMethodIDL.a r14 = (AbsSetAlarmMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        boolean r15 = com.obric.miniapp.alarm.w.b;
        com.obric.miniapp.alarm.w r16 = com.obric.miniapp.alarm.w.a.b(r14.getTime());
        Map<String, Object> r0 = r14.getExtraParams();
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, Object>> r2 = r0.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L16;
        Map.Entry<String, Object> r3 = r2.next();
        String r4 = r3.getKey();
        Object r5 = r3.getValue();
        Pair r6 = null;
        if ((r5 instanceof String) == false) goto L11;
        String r7 = (String) r5;
    L12:
        if (r7 == null) goto L14;
        r6 = TuplesKt.to(r4, r7);
    L14:
        if (r6 == null) goto L7;
        r1.add(r6);
        goto L7
    L11:
        r7 = null;
        goto L12
    L16:
        Map r8 = MapsKt.toMap(r1);
        zka.r.a r9 = zka.r.a;
        AppHost.Companion r10 = AppHost.a;
        Application r17 = r10.getApplication();
        r9.getClass();
        if (zka.r.a.a(r17) == false) goto L21;
        yka.a r18 = yka.a.b;
        if (r18.e(r10.getApplication()) == false) goto L21;
        FLogger.a.d("SetAlarmMethod", "start createOrUpdateAlarm");
        r18.a(r10.getApplication(), r14.getAlarmId(), r14.getTitle(), r14.getDescription(), r16, r8, new y(r13));
        return;
    L21:
        AlarmManager r19 = AlarmManager.a;
        String r20 = r14.getAlarmId();
        String r21 = r14.getTitle();
        String r22 = r14.getDescription();
        Function1 r23 = new z(r13);
        r19.getClass();
        AlarmManager.e(r20, r21, r22, r16, r8, r23);
    }
}
