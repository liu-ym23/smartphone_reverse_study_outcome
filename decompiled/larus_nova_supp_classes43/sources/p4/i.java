package p4;

import com.bytedance.ai.bridge.remote.model.PrivacyCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public final boolean a;
    public final PrivacyCard b;
    public final boolean c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        PrivacyCard r11 = this.b;
        if (r11 != null) goto L9;
        int r12 = 0;
    L10:
        int r13 = (r10 + r12) * 31;
        if (this.c == true) goto L15;
        r1 = 1237;
    L15:
        return r13 + r1;
    L9:
        r12 = r11.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CheckPrivacyOrLoginStatusResult(privacyAgreed=" + this.a + ", privacyCard=" + this.b + ", alreadyLogin=" + this.c + ')';
    }

    public i(boolean r1, PrivacyCard r10, boolean r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
