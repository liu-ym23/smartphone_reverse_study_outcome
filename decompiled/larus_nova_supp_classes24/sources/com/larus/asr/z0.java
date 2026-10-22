package com.larus.asr;

import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class z0 implements Function1 {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ z0(Function2 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        Function2 r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        Set r1 = ChatBottomSpeakerComponent.F2;
        FLogger.a.i("ChatBottomSpeakerComponent", "checkSpeakPermission result: " + r6);
        r0.invoke(Boolean.valueOf(r6), Boolean.FALSE);
        return Unit.INSTANCE;
    }
}
