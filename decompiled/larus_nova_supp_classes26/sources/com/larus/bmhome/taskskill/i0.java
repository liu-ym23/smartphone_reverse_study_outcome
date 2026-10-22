package com.larus.bmhome.taskskill;

import com.larus.im.internal.jni.bean.OmniAgentTaskParam;
import com.larus.utils.logger.FLogger;
import ic8.w;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ i0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r12) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r12, "it");
        OmniAgentTaskParam r13 = new OmniAgentTaskParam(1, null, null, null, null, null, 62, null);
        r0.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r14 = Result.constructor-impl(((ouc.a) r0.K.getValue()).a(OmniAgentTaskParam.Companion.serializer(), r13));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r14);
        if (r3 == null) goto L11;
        FLogger.a.w("SkillComponent", "[toJsonStringOrNull] serialize OmniAgentTaskParam failed, msg=" + r3.getMessage());
    L11:
        if (Result.isFailure-impl(r14) == false) goto L14;
        r14 = null;
    L14:
        return (String) r14;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
