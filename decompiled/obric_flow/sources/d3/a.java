package d3;

import ai.j0;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.v0;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16587c;
    public final b d;
    public final String e;

    public a(String r5, String r10, String r11, b r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "response");
        Intrinsics.checkNotNullParameter(r10, "resFrom");
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.URI_KEY);
        this.f16585a = r5;
        this.f16586b = r10;
        this.f16587c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        String r11 = r10.f16585a;
        if (Intrinsics.areEqual(this.f16585a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16586b, r10.f16586b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16587c, r10.f16587c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(v0.a(this.f16585a.hashCode() * 31, 0), 31, this.f16586b);
        int r10 = 0;
        String r11 = this.f16587c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        b r14 = this.d;
        if (r14 == null) goto L11;
        r10 = Arrays.hashCode(r14.f16588a);
    L11:
        return this.e.hashCode() + ((r13 + r10) * 31);
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AppletResponse(response=");
        r5.append(this.f16585a);
        r5.append(", version=0, resFrom=");
        r5.append(this.f16586b);
        r5.append(", filePath=");
        r5.append(this.f16587c);
        r5.append(", byteArray=");
        r5.append(this.d);
        r5.append(", uri=");
        return j0.p(r5, this.e, ')');
    }
}
