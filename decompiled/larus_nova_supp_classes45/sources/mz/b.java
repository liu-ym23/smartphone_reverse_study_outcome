package mz;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public float a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;

    public final int a() {
        if (this.b == false) goto L6;
        return 1;
    L6:
        if (this.c == false) goto L9;
        return 2;
    L9:
        if (this.d == false) goto L12;
        return 3;
    L12:
        if (this.e == false) goto L14;
        return 4;
    L14:
        return 0;
    }

    public b(String r4) {
        if (r4 == null) goto L12;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        b(new JSONObject(r4), null);     // Catch: Throwable -> L6
        ALogger.d("RoomItemExplicitInfo", "info:" + r4 + ",isBaseSend:" + this.b + ",isEcomSend:" + this.c + ",isRevenueSend:" + this.d + ",isGrouponSend:" + this.e + "，stayTime:" + this.a);     // Catch: Throwable -> L6
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Result.box-impl(r5);
        return;
    L6:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public b(JSONObject r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "json");
        b(r2, r3);
    }

    public final void b(JSONObject r4, JSONObject r5) {
        boolean r1 = false;
        if (r4.optInt("mq2_is_base_send") != 1) goto L5;
        boolean r0 = true;
    L6:
        this.b = r0;
        if (r4.optInt("mq2_is_ecom_send") != 1) goto L9;
        boolean r2 = true;
    L10:
        this.c = r2;
        if (r4.optInt("mq2_is_revenue_send") != 1) goto L13;
        boolean r3 = true;
    L14:
        this.d = r3;
        if (r4.optInt("mq2_is_groupon_send") != 1) goto L17;
        r1 = true;
    L17:
        this.e = r1;
        float r6 = 0.0f;
        if (r5 == null) goto L25;
        String r7 = r5.optString("staytime");
        if (r7 == null) goto L24;
        Float r8 = StringsKt.toFloatOrNull(r7);
        if (r8 == null) goto L24;
        r6 = r8.floatValue();
    L24:
        this.a = r6;
        return;
    L25:
        String r9 = r4.optString("feed_draw_client_targets_rec_info");
        if ((!StringsKt.isBlank(r9)) == true) goto L29;
        r9 = null;
    L29:
        if (r9 == null) goto L41;
        String r11 = new JSONObject(r9).optString("staytime");     // Catch: Exception -> L37
        if (r11 == null) goto L35;
        Float r12 = StringsKt.toFloatOrNull(r11);     // Catch: Exception -> L37
        if (r12 == null) goto L35;
        r6 = r12.floatValue();     // Catch: Exception -> L37
    L35:
        this.a = r6;     // Catch: Exception -> L37
        return;
    L42:
        return;
    L41:
        return;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }
}
