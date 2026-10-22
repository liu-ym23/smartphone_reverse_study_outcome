package a92;

import com.bytedance.android.livesdkapi.model.CropSeiData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;
import z82.f;
import z82.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final int a;
    public final int b;
    public final boolean c;
    public final String d;
    public final g e;
    public final z82.a f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        boolean r1 = this.c;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        String r4 = this.d;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        g r8 = this.e;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        z82.a r11 = this.f;
        if (r11 == null) goto L17;
        r5 = r11.hashCode();
    L17:
        return r10 + r5;
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "TransferParam(parentW=" + this.a + ", parentH=" + this.b + ", isFullScreen=" + this.c + ", sei=" + this.d + ", statusBarOption=" + this.e + ", components=" + this.f + ")";
    }

    public final Float a() {
        JSONArray r0 = f.b(this.d);
        if (r0 != null) goto L5;
        return null;
    L5:
        double r2 = f.f(r0);
        double r4 = f.c(r0);
        if (r2 > 0.0d) goto L8;
        return null;
    L8:
        if (r4 <= 0.0d) goto L34;
        CropSeiData r1 = f.a(this.d);
        if (r1 == null) goto L17;
        Pair r3 = TuplesKt.to(Integer.valueOf(r1.cropW), Integer.valueOf(r1.cropH));
        int r6 = ((Number) r3.component1()).intValue();
        int r5 = ((Number) r3.component2()).intValue();
        if (r6 == 0) goto L17;
        if (r5 == 0) goto L17;
        return Float.valueOf(((float) (((double) r6) * r2)) / ((float) (((double) r5) * r4)));
    L17:
        String r7 = this.d;
        Intrinsics.checkNotNullParameter(r7, "sei");
        JSONObject r8 = f.g(r7);
        if (r8 != null) goto L21;
    L19:
        Pair r9 = null;
    L24:
        if (r9 != null) goto L26;
        r9 = TuplesKt.to(0, 0);
    L26:
        int r10 = ((Number) r9.component1()).intValue();
        int r11 = ((Number) r9.component2()).intValue();
        if (r10 == 0) goto L33;
        if (r11 != 0) goto L31;
        return null;
    L31:
        return Float.valueOf(((float) (((double) r10) * r2)) / ((float) (((double) r11) * r4)));
    L33:
        return null;
    L21:
        if (r8.has("app_data") == false) goto L19;
        JSONObject r13 = new JSONObject(new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r8, "app_data"), BuildConfig.FLAVOR)).optString("canvas"));
        r9 = TuplesKt.to(Integer.valueOf(r13.optInt(sz1.a.KEY_WIDTH)), Integer.valueOf(r13.optInt(sz1.a.KEY_HEIGHT)));
        goto L24
    L34:
        return null;
    }

    public a(int r2, int r3, String r4, g r5, z82.a r6) {
        Intrinsics.checkNotNullParameter(r4, "sei");
        Intrinsics.checkNotNullParameter(r5, "statusBarOption");
        this.a = r2;
        this.b = r3;
        this.c = true;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
