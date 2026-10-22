package s64;

import com.bytedance.awemeopen.servicesapi.ui.host.ext.UIComponentExtensionType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final String a;
    public final String b;
    public final JSONObject c;
    public final List<c> d;
    public final UIComponentExtensionType e;

    public b() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        JSONObject r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((r4 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "UIComponentInitData(awemeId=" + this.a + ", authorOpenId=" + this.b + ", hostCommonParams=" + this.c + ", photoList=" + this.d + ", extensionType=" + this.e + ')';
    }

    public b(String r3, String r4, JSONObject r5, List r6) {
        UIComponentExtensionType r0 = UIComponentExtensionType.PHOTO_DETAIL_LONG_PRESS;
        Intrinsics.checkNotNullParameter(r3, "awemeId");
        Intrinsics.checkNotNullParameter(r6, "photoList");
        Intrinsics.checkNotNullParameter(r0, "extensionType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r0;
    }
}
