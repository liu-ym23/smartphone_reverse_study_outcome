package com.obric.assistant.feedback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IObricFeedbackService$b {
    public final boolean a;

    public IObricFeedbackService$b() {
        this(false);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof IObricFeedbackService$b) == true) goto L9;
        return false;
    L9:
        if (this.a == ((IObricFeedbackService$b) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "CompleteParams(isPrivacyNotAgree=" + this.a + ')';
    }

    public IObricFeedbackService$b(boolean r1) {
        this.a = r1;
    }
}
