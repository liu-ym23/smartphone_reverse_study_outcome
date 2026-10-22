package com.obric.assistant.cocreationreview;

import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h1 implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public /* synthetic */ h1(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r12) {
        String r0 = this.a;
        String r1 = this.b;
        a5 r2 = (a5) r12;
        Set<String> r13 = CocreationReviewActivity.P1;
        Intrinsics.checkNotNullParameter(r2, "current");
        Set<String> r14 = r2.c;
        List<Integer> r3 = t3.a;
        Intrinsics.checkNotNullParameter(r14, "currentReasons");
        Intrinsics.checkNotNullParameter(r0, "reason");
        if (r14.contains(r0) == false) goto L5;
        Set r15 = SetsKt.minus(r14, r0);
    L6:
        Set r4 = r15;
        int r16 = s3.a;
        s3.b("draft.action", "toggleReason recordId=" + r1 + ", reason=" + r0 + ", selected=" + r4.contains(r0) + ", reasonCount=" + r4.size());
        return a5.a(r2, null, r4, null, false, 0, null, SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FAILED);
    L5:
        r15 = SetsKt.plus(r14, r0);
        goto L6
    }
}
