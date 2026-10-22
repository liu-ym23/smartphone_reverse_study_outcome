package b4;

import com.lynx.tasm.TemplateData;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TemplateData f858c;

    public b(a r5, String r10, TemplateData r11) {
        this.f856a = r5;
        this.f857b = r10;
        this.f858c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        a r11 = r10.f856a;
        if (Intrinsics.areEqual(this.f856a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f857b, r10.f857b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f858c, r10.f858c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        a r10 = this.f856a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f857b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        TemplateData r16 = this.f858c;
        if (r16 == null) goto L15;
        r5 = r16.hashCode();
    L15:
        return r15 + r5;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = Arrays.hashCode(r10.f855a);
        goto L6
    }

    public final String toString() {
        return "SSRHydrateConfig(template=" + this.f856a + ", baseUrl=" + this.f857b + ", templateData=" + this.f858c + ')';
    }
}
