package zx0;

import android.graphics.RectF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements zx0.a {
    public final float a;

    public static final class a {
    }

    static {
    }

    public f() {
        this.a = ((Number) ay0.a.b.getValue(null, ay0.a.a[0])).floatValue();
    }

    @Override // zx0.a
    public final b a(com.bytedance.android.live.revenue.common.player.vendor.link.c r14) {
        Intrinsics.checkNotNullParameter(r14, "reduceContext");
        RectF r0 = b(r14);
        g90.b r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        JSONArray r2 = com.bytedance.android.live.revenue.common.player.utils.a.c(r14.j.d());
        if (r2 != null) goto L8;
        return null;
    L8:
        int r3 = ((int) (this.a * r14.e)) + r14.h;
        boolean r5 = false;
        if (r14.a == false) goto L16;
        if (r14.c == false) goto L13;
        int r4 = i.b(134);
    L14:
        r3 = r4 + r14.h;
        goto L16
    L13:
        r4 = 0;
    L16:
        if (r2.length() <= 1) goto L18;
        boolean r6 = true;
    L19:
        JSONObject r7 = r14.j.d();
        if (r7 != null) goto L104;
    L23:
        int r8 = 0;
    L24:
        if (r8 == 0) goto L26;
        boolean r9 = true;
    L27:
        JSONObject r10 = r14.j.d();
        if (r10 != null) goto L106;
    L31:
        int r12 = 0;
    L32:
        if (r12 == 0) goto L34;
        boolean r13 = true;
    L36:
        if (r14.c == false) goto L42;
        if (r9 == false) goto L42;
        if (r13 == false) goto L42;
        b03.a r15 = b03.a.a;
        int r16 = (s1.y() * 16) / 9;
        int r17 = r14.e - i.b(52);
        if (r16 >= r17) goto L42;
        r3 = (r17 - r16) / 2;
    L42:
        float r18 = r14.j.f();
        if (r14.k == false) goto L56;
        int r19 = ay0.a.a();
        if (r19 == 1) goto L56;
        if (r19 != 2) goto L54;
        int r20 = r14.g;
        if (r20 == 0) goto L54;
        int r110 = r14.f;
        if (r110 == 0) goto L54;
        float r22 = r110 * 1.0f;
        float r23 = r20;
    L55:
        r18 = r22 / r23;
    L54:
        r23 = r18;
        r22 = 1;
    L56:
        boolean r24 = r14.l;
        JSONObject r111 = r14.j.d();
        if (r111 != null) goto L108;
    L68:
        if (r13 == true) goto L70;
    L72:
        if (r6 == true) goto L77;
        if (r9 == true) goto L77;
        if (r24 == true) goto L77;
        if (r5 == true) goto L77;
    L81:
        if (r14.a == false) goto L86;
        if (r14.c == false) goto L86;
    L84:
        sx0.a r25 = new sx0.a.b(r18, r3);
    L89:
        JSONObject r112 = r14.j.d();
        if (r112 != null) goto L109;
    L95:
        float r113 = 1.78f;
    L97:
        if (r9 == false) goto L100;
        r1 = new g90.b(r113);
    L100:
        return new b(r0, r25, r1);
    L109:
        JSONObject r114 = r112.optJSONObject("stream_size");     // Catch: Throwable -> L101
        if (r114 == null) goto L95;
        r113 = (float) JSONObjectProtectorUtils.getDouble(r114, "game_ratio");
    L86:
        if (r14.c == true) goto L88;
        r25 = new sx0.a.c(r18);
        goto L89
    L88:
        r25 = new sx0.a.C0316a(r18, r3, 0.40625f);
    L77:
        if (r14.b == true) goto L81;
        if (r14.a == false) goto L84;
    L70:
        if (r14.a == false) goto L72;
        r25 = new sx0.a.d(r18);
        goto L89
    L108:
        String r115 = r111.optString("grids");     // Catch: Exception -> L67
        if (r115 == null) goto L68;
        Object r116 = new JSONArray(r115).opt(0);     // Catch: Exception -> L67
        if (r116 == null) goto L66;
        if (((JSONObject) r116).optInt("is_audio") != 1) goto L68;
        r5 = true;
        goto L68
    L66:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Exception -> L67
    L34:
        r13 = false;
        goto L36
    L106:
        r12 = r10.optInt("game_full_v2");     // Catch: JSONException -> L102
    L26:
        r9 = false;
        goto L27
    L104:
        r8 = r7.optInt("game_type");     // Catch: Throwable -> L103
    L18:
        r6 = false;
        goto L19
    }

    @Override // zx0.a
    public final RectF b(com.bytedance.android.live.revenue.common.player.vendor.link.c r10) {
        Intrinsics.checkNotNullParameter(r10, "reduceContext");
        JSONObject r0 = r10.j.d();
        int r1 = 0;
        if (r0 != null) goto L61;
    L6:
        int r2 = 0;
    L7:
        JSONObject r3 = r10.j.d();
        if (r3 != null) goto L59;
    L11:
        int r4 = 0;
    L12:
        JSONObject r5 = null;
        if (r2 != 0) goto L15;
        JSONArray r6 = com.bytedance.android.live.revenue.common.player.utils.a.c(r10.j.d());
        if (r6 != null) goto L51;
        return null;
    L51:
        float r7 = (float) com.bytedance.android.live.revenue.common.player.utils.a.d(r6);
        float r8 = (float) com.bytedance.android.live.revenue.common.player.utils.a.h(r6);
        RectF r9 = new RectF(0.0f, r8, 1.0f, r7 + r8);
        if (r10.k == false) goto L55;
        return r9;
    L55:
        return com.bytedance.android.live.revenue.common.player.utils.b.a(r9, r10.j.g());
    L15:
        if (r10.a == false) goto L23;
        JSONObject r12 = r10.j.d();
        if (r12 != null) goto L65;
    L20:
        int r13 = 0;
    L21:
        if (r13 == 0) goto L23;
    L25:
        return new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    L65:
        r13 = r12.optInt("game_full_v2");     // Catch: JSONException -> L56
    L23:
        if (r4 == 1) goto L25;
        JSONObject r14 = r10.j.d();
        if (r14 != null) goto L63;
    L31:
        float r15 = r10.j.f();
        JSONObject r16 = r10.j.d();
        if (r16 == null) goto L34;
        r5 = r16.optJSONObject("stream_size");
    L34:
        if (r5 == null) goto L36;
        float r17 = (float) r5.optDouble("y");
    L37:
        if (r5 == null) goto L39;
        float r18 = (float) r5.optDouble("h");
    L40:
        if (r5 == null) goto L42;
        float r19 = (float) r5.optDouble("game_ratio");
    L43:
        if (r1 != 0) goto L45;
        float r20 = 0.0f;
    L47:
        return new RectF(0.0f, r17, 1.0f, (r18 + r17) + r20);
    L45:
        r20 = r15 / r19;
        goto L47
    L42:
        r19 = 1.78f;
        goto L43
    L39:
        r18 = 0.0f;
        goto L40
    L36:
        r17 = 0.0f;
        goto L37
    L63:
        r1 = r14.optInt("mix_stream_type");     // Catch: Throwable -> L30
        goto L31
    L59:
        r4 = r3.optInt("game_full_v2");     // Catch: JSONException -> L57
    L61:
        r2 = r0.optInt("game_type");     // Catch: Throwable -> L58
        goto L7
    }

    @Override // zx0.a
    public final boolean c(com.bytedance.android.live.revenue.common.player.vendor.link.c r2) {
        Intrinsics.checkNotNullParameter(r2, "reduceContext");
        Integer r3 = r2.j.n();
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.intValue() == 2) goto L9;
        return false;
    L9:
        return true;
    }
}
