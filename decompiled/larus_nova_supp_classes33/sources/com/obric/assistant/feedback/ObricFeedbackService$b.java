package com.obric.assistant.feedback;

import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFeedbackService$b {
    public final Map<String, Message> a;
    public final List<String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricFeedbackService$b) == true) goto L8;
        return false;
    L8:
        ObricFeedbackService$b r6 = (ObricFeedbackService$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "FeedbackMessageResult(messageMap=" + this.a + ", logIds=" + this.b + ')';
    }

    public ObricFeedbackService$b(Map<String, Message> r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "messageMap");
        Intrinsics.checkNotNullParameter(r3, "logIds");
        this.a = r2;
        this.b = r3;
    }
}
