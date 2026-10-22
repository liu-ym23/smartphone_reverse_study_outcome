package l31;

import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.List;
import k31.f;
import k31.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;
import rc0.q;
import z41.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final boolean a;
    public final int b;
    public final int c;
    public final boolean d;
    public final String e;
    public final f f;
    public final q g;
    public final k h;
    public final k31.a i;
    public final int j;
    public final boolean k;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L26;
        a r4 = (a) r3;
        if (this.b == r4.b) goto L8;
        return false;
    L8:
        if (this.c == r4.c) goto L10;
        return false;
    L10:
        if (this.d == r4.d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L22;
        return false;
    L22:
        if (this.j == r4.j) goto L24;
        return false;
    L24:
        if (this.k == r4.k) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((this.b * 31) + this.c) * 31;
        boolean r1 = this.d;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        int r6 = 0;
        if (r5 == null) goto L8;
        int r7 = r5.hashCode();
    L9:
        int r8 = (r4 + r7) * 31;
        f r9 = this.f;
        if (r9 == null) goto L12;
        int r10 = r9.hashCode();
    L13:
        int r12 = (r8 + r10) * 31;
        q r13 = this.g;
        if (r13 == null) goto L16;
        int r14 = r13.hashCode();
    L17:
        int r15 = (r12 + r14) * 31;
        k r16 = this.h;
        if (r16 == null) goto L20;
        int r17 = r16.hashCode();
    L21:
        int r18 = (r15 + r17) * 31;
        k31.a r19 = this.i;
        if (r19 == null) goto L24;
        r6 = r19.hashCode();
    L24:
        int r20 = (((r18 + r6) * 31) + this.j) * 31;
        boolean r22 = this.k;
        if (r22 == true) goto L29;
        r2 = r22;
    L29:
        return r20 + r2;
    L20:
        r17 = 0;
        goto L21
    L16:
        r14 = 0;
        goto L17
    L12:
        r10 = 0;
        goto L13
    L8:
        r7 = 0;
        goto L9
    }

    public final String toString() {
        return "TransferParam(parentW=" + this.b + ", parentH=" + this.c + ", isFullScreen=" + this.d + ", sei=" + this.e + ", seiCache=" + this.f + ", seiOptExtra=" + this.g + ", statusBarOption=" + this.h + ", components=" + this.i + ", uiLayout=" + this.j + ", isGameLink=" + this.k + ")";
    }

    public final Float a() {
        f r0 = this.f;
        String r1 = this.e;
        if (r0 == null) goto L33;
        p0 r2 = r0.b;
        if (r2 == null) goto L79;
        List r6 = r2.e();
        if (r6 == null) goto L80;
        double r7 = n11.a.d(r6);
        double r9 = n11.a.a(r6);
        if (r7 > 0.0d) goto L13;
        return null;
    L13:
        if (r9 <= 0.0d) goto L81;
        n0 r3 = r0.a;
        if (r3 == null) goto L21;
        Pair r4 = TuplesKt.to(Integer.valueOf(r3.b()), Integer.valueOf(r3.a()));
        int r5 = ((Number) r4.component1()).intValue();
        int r8 = ((Number) r4.component2()).intValue();
        if (r5 == 0) goto L21;
        if (r8 == 0) goto L21;
        return Float.valueOf(((float) (((double) r5) * r7)) / ((float) (((double) r8) * r9)));
    L21:
        q0 r10 = r2.getCanvas();
        if (r10 != null) goto L24;
        Pair r12 = null;
    L25:
        if (r12 != null) goto L27;
        r12 = TuplesKt.to(0, 0);
    L27:
        int r13 = ((Number) r12.component1()).intValue();
        int r14 = ((Number) r12.component2()).intValue();
        if (r13 == 0) goto L78;
        if (r14 != 0) goto L32;
        return null;
    L32:
        return Float.valueOf(((float) (((double) r13) * r7)) / ((float) (((double) r14) * r9)));
    L78:
        return null;
    L24:
        r12 = TuplesKt.to(Integer.valueOf(r10.b()), Integer.valueOf(r10.a()));
        goto L25
    L81:
        return null;
    L80:
        return null;
    L79:
        return null;
    L33:
        if (r1 == null) goto L83;
        q r15 = this.g;
        if (r15 == null) goto L37;
        JSONObject r16 = r15.b;
    L39:
        if (this.a == false) goto L44;
        if (r16 == null) goto L44;
        JSONArray r17 = com.bytedance.android.live.revenue.common.player.utils.a.c(r16);
        if (r17 == null) goto L87;
    L47:
        double r18 = com.bytedance.android.live.revenue.common.player.utils.a.i(r17);
        double r19 = com.bytedance.android.live.revenue.common.player.utils.a.d(r17);
        if (r18 > 0.0d) goto L50;
        return null;
    L50:
        if (r19 <= 0.0d) goto L89;
        n0 r20 = com.bytedance.android.live.revenue.common.player.utils.a.a(r1, this.a);
        if (r20 == null) goto L58;
        Pair r22 = TuplesKt.to(Integer.valueOf(r20.b()), Integer.valueOf(r20.a()));
        int r23 = ((Number) r22.component1()).intValue();
        int r24 = ((Number) r22.component2()).intValue();
        if (r23 == 0) goto L58;
        if (r24 == 0) goto L58;
        return Float.valueOf(((float) (((double) r23) * r18)) / ((float) (((double) r24) * r19)));
    L58:
        Intrinsics.checkNotNullParameter(r1, "sei");
        if (r16 != null) goto L67;
        JSONObject r25 = com.bytedance.android.live.revenue.common.player.utils.a.j(r1);
        if (r25 != null) goto L64;
    L65:
        Pair r26 = null;
    L68:
        if (r26 != null) goto L70;
        r26 = TuplesKt.to(0, 0);
    L70:
        int r27 = ((Number) r26.component1()).intValue();
        int r28 = ((Number) r26.component2()).intValue();
        if (r27 == 0) goto L86;
        if (r28 != 0) goto L75;
        return null;
    L75:
        return Float.valueOf(((float) (((double) r27) * r18)) / ((float) (((double) r28) * r19)));
    L86:
        return null;
    L64:
        if (r25.has("app_data") == false) goto L65;
        r16 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r25, "app_data"), ""));
    L67:
        JSONObject r29 = new JSONObject(r16.optString("canvas"));
        r26 = TuplesKt.to(Integer.valueOf(r29.optInt("width")), Integer.valueOf(r29.optInt("height")));
        goto L68
    L89:
        return null;
    L87:
        return null;
    L44:
        r17 = com.bytedance.android.live.revenue.common.player.utils.a.b(r1);
        if (r17 != null) goto L47;
        return null;
    L37:
        r16 = null;
        goto L39
    L83:
        return null;
    }

    public /* synthetic */ a(int r12, int r13, boolean r14, String r15, f r16, q r17, k r18, k31.a r19) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, 0, false);
    }

    public a(int r2, int r3, boolean r4, String r5, f r6, q r7, k r8, k31.a r9, int r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "statusBarOption");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r12;
        this.a = d.c.B6();
    }
}
