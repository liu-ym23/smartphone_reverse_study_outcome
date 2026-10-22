package li;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f19668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f19670c;

    public k(Integer r5, String r10, ArrayList r11) {
        this.f19668a = r5;
        this.f19669b = r10;
        this.f19670c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r10 = (k) r5;
        Integer r11 = r10.f19668a;
        if (Intrinsics.areEqual(this.f19668a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19669b, r10.f19669b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19670c, r10.f19670c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f19668a.hashCode() * 31;
        int r10 = 0;
        String r11 = this.f19669b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        ArrayList r14 = this.f19670c;
        if (r14 == null) goto L11;
        r10 = r14.hashCode();
    L11:
        return r13 + r10;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "MethodCallLimitsBean(runtime_call_count=" + this.f19668a + ", runtime_call_frequency=" + this.f19669b + ", url=" + this.f19670c + ')';
    }
}
