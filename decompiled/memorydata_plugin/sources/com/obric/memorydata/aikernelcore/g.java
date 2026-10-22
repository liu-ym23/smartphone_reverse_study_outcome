package com.obric.memorydata.aikernelcore;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/aikernelcore/PapayaLogger;", "Lcom/obric/aikernel/runtime/utils/ILogger;", "<init>", "()V", "log", "", LocationMonitorConst.TAG, "", "message", "level", "", "tracking", "key", "data", "Lorg/json/JSONObject;", "aeeLog", "logLevel", "printLog", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g implements com.obric.aikernel.runtime.utils.c {
    public g() {
    }

    private final void b(int r7, String r8, String r9) {
        if (r7 != 4) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r8, r9, false, 4, null);
        return;
    L5:
        if (r7 != 5) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r8, r9, null, 4, null);
        return;
    L7:
        if (r7 != 6) goto L9;
    L11:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r8, r9, null, 4, null);
        return;
    L9:
        if (r7 == 7) goto L11;
        RunLog.INSTANCE.debug(r8, r9);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void a(int r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r14, "message");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("@", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L5;
        b(r12, StringsKt.replaceFirst$default((String) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"@"}, false, 0, 6, null).get(0), String.class, "com.obric.memorydata.plugin"), "service-", "", false, 4, null), r14);
        WebSocketManager.a(WebSocketManager.f8445a, r12, r13, r14, null, null, 24, null);
        return;
    L5:
        b(r12, r13, r14);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void a(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        b(r4, r2, r3);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void a(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "data");
    }
}
