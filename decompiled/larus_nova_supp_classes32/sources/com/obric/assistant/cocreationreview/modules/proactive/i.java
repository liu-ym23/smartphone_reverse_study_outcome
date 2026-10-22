package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.l5;
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final i a = null;
    public static volatile ProactiveLabelingFeedbackConfigDto b;

    static {
        a = new i();
    }

    public i() {
    }

    public static l5 a() {
        ProactiveLabelingFeedbackConfigDto r0 = b;
        if (r0 == null) goto L5;
        l5 r1 = e.a;
        List<String> r2 = r0.a;
        if (r2.isEmpty() == false) goto L9;
        r2 = r1.g;
    L9:
        List<String> r10 = r2;
        List<String> r3 = r0.b;
        if (r3.isEmpty() == false) goto L12;
        r3 = r1.h;
    L12:
        List<String> r11 = r3;
        String r4 = r0.c;
        if (StringsKt.isBlank(r4) == false) goto L15;
        r4 = r1.i;
    L15:
        String r12 = r4;
        ModuleKey r5 = r1.a;
        String r6 = r1.b;
        String r7 = r1.c;
        int r8 = r1.d;
        int r9 = r1.e;
        String r13 = r1.f;
        String r14 = r1.j;
        String r15 = r1.k;
        boolean r16 = r1.l;
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "label");
        Intrinsics.checkNotNullParameter(r7, "shortLabel");
        Intrinsics.checkNotNullParameter(r13, "description");
        Intrinsics.checkNotNullParameter(r10, "positiveReasons");
        Intrinsics.checkNotNullParameter(r11, "negativeReasons");
        Intrinsics.checkNotNullParameter(r12, "feedbackPlaceholder");
        Intrinsics.checkNotNullParameter(r14, "positiveFeedbackPlaceholder");
        Intrinsics.checkNotNullParameter(r15, "negativeFeedbackPlaceholder");
        return new l5(r5, r6, r7, r8, r9, r13, r10, r11, r12, r14, r15, r16);
    L5:
        return e.a;
    }

    public final void update(ProactiveLabelingFeedbackConfigDto r1) {
        b = r1;
    }
}
