package com.larus.call_plugins_doubao_common;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ CommonFeedbackVoicePluginV2 a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ f(CommonFeedbackVoicePluginV2 r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        CommonFeedbackVoicePluginV2 r0 = this.a;
        Function1<? super Boolean, Unit> r1 = this.b;
        r0.j3().i(r1);
        return Unit.INSTANCE;
    }
}
