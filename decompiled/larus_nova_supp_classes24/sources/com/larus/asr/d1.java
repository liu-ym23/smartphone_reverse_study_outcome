package com.larus.asr;

import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d1 implements Function1 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;

    public /* synthetic */ d1(ChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        final ChatBottomSpeakerComponent r0 = this.a;
        Set r1 = ChatBottomSpeakerComponent.F2;
        Intrinsics.checkNotNullParameter(r5, "applicant");
        FLogger.a.i("ChatBottomSpeakerComponent", "handsfree: external focus interrupted by " + r5 + " -> hideSpeakerAndSubmit()");
        com.larus.utils.t0.a.post(new i1(r0));
        return Unit.INSTANCE;
    }
}
