package com.larus.voicecall.impl.component.feedback;

import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final ArrayList<FeedbackMeta> a;
    public final String b;
    public final Message c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Message r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DislikeDetailDialogParams(metaList=" + this.a + ", feedbackPlaceholder=" + this.b + ", message=" + this.c + ')';
    }

    public a(ArrayList<FeedbackMeta> r2, String r3, Message r4) {
        Intrinsics.checkNotNullParameter(r2, "metaList");
        Intrinsics.checkNotNullParameter(r3, "feedbackPlaceholder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
