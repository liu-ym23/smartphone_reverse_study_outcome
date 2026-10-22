package ho8;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final boolean a;
    public final int b;
    public final Message c;
    public final String d;
    public final float e;
    public final boolean f;
    public final Map<String, Object> g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((((((r0 * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Float.floatToIntBits(this.e)) * 31;
        if (this.f == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.g.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "WidgetVMData(needAdjustCorner=" + this.a + ", maxWidth=" + this.b + ", message=" + this.c + ", renderData=" + this.d + ", radius=" + this.e + ", enableCache=" + this.f + ", extraData=" + this.g + ')';
    }

    public a(boolean r2, int r3, Message r4, String r5, float r6, boolean r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "renderData");
        Intrinsics.checkNotNullParameter(r8, "extraData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
