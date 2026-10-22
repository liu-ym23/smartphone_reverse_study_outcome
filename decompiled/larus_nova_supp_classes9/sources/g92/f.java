package g92;

import com.bytedance.android.livesdk.interactivity.api.comment.event.DefaultLandingPanel;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public JsonObject a;
    public final OpenInputSource b;
    public final long c;
    public final String d;
    public final Map<Object, Object> e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L14;
        f r7 = (f) r6;
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L8;
        return false;
    L8:
        if (this.c == r7.c) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        OpenInputSource r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.c;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.d;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Map<Object, Object> r8 = this.e;
        if (r8 == null) goto L14;
        r1 = r8.hashCode();
    L14:
        return r7 + r1;
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PrepareInputParam(openInputSource=" + this.b + ", triggerTime=" + this.c + ", defaultLandingPanel=" + this.d + ", extraMap=" + this.e + ")";
    }

    public f() {
        this(OpenInputSource.Unknow, System.currentTimeMillis(), DefaultLandingPanel.Default.getPanel(), null);
    }

    public f(OpenInputSource r1, long r2, String r4, Map<Object, ? extends Object> r5) {
        this.b = r1;
        this.c = r2;
        this.d = r4;
        this.e = r5;
    }
}
