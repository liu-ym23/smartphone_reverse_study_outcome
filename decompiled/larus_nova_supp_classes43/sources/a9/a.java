package a9;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "AsrInitSettings(domain=" + this.a + ", path=" + this.b + ", appId=" + this.c + ", appToken=" + this.d + ", resourceId=" + this.e + ')';
    }

    public a(String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "domain");
        Intrinsics.checkNotNullParameter(r11, "path");
        Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r13, "appToken");
        Intrinsics.checkNotNullParameter(r14, "resourceId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
