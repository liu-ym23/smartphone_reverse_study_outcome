package com.obric.memorydata.awareness.impl.data;

import com.obric.aikernel.res.metadata.config.i;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"getPapayaConfig", "Lcom/obric/memorydata/awareness/impl/data/PapayaConfig;", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "awareness_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final PapayaConfig a(i r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        String r10 = String.valueOf(AIInferRuntime.f6160a.a(r9));
        Object r11 = u.a().fromJson(r10, PapayaConfig.class);     // Catch: Exception -> L5
    L8:
        return (PapayaConfig) ZeusTransformUtils.preCheckCast(r11, PapayaConfig.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r10 + " toObj error : " + e, null, 4, null);
        r11 = null;
        goto L8
    }
}
