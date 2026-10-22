package hda;

import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewFeedbackState;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s1 {
    public static final String a(q0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.f != MemoryReviewFeedbackState.SUBMITTED) goto L5;
        return null;
    L5:
        if (r3 != null) goto L7;
    L13:
        return null;
    L7:
        if ((!StringsKt.isBlank(r3)) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L13;
        return r3;
    }
}
