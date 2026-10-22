package sob;

import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils.AsrNerStatisticV2;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils.UserInfoHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final d a = null;
    public static final Map<String, String> b = null;

    public d() {
    }

    static {
        a = new d();
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("0", "inaccurate"), TuplesKt.to(Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL, "incomplete"), TuplesKt.to(Conf$StickerSetManagerPosition.STICKER_SET_SHOP, "took_too_long"), TuplesKt.to("3", "others")});
    }

    public static JSONArray b(a r5) {
        JSONArray r0 = new JSONArray();
        Iterator<T> r6 = r5.a.iterator();     // Catch: Exception -> L8
    L5:
        if (r6.hasNext() == false) goto L10;
        b r1 = (b) r6.next();     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        r2.put("voice_id", r1.a);     // Catch: Exception -> L8
        r2.put("is_name_searched", r1.b);     // Catch: Exception -> L8
        r2.put("is_accept", r1.c);     // Catch: Exception -> L8
        r2.put("result_cat", r1.d);     // Catch: Exception -> L8
        r2.put("result_cat_rank", r1.e);     // Catch: Exception -> L8
        r2.put("asr_uid", r1.f);     // Catch: Exception -> L8
        r2.put("client_uid", r1.g);     // Catch: Exception -> L8
        r0.put(r2);     // Catch: Exception -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        Log.e("HitPointUtils", "makeJsonArrayByAsrNer", e);
        goto L10
    }

    public static JSONArray c(AsrNerStatisticV2 r5) {
        JSONArray r0 = new JSONArray();
        Iterator<T> r6 = r5.getUserInfoList().iterator();     // Catch: Exception -> L8
    L5:
        if (r6.hasNext() == false) goto L10;
        UserInfoHitPoint r1 = (UserInfoHitPoint) r6.next();     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        r2.put("uid", r1.getUid());     // Catch: Exception -> L8
        r2.put("is_chat_user", r1.isChatUser());     // Catch: Exception -> L8
        r0.put(r2);     // Catch: Exception -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        Log.e("HitPointUtils", "makeJsonArrayByAsrNer", e);
        goto L10
    }

    public static float a(String r13, String r14) {
        if (r13 != null) goto L5;
        r13 = r14;
    L5:
        if (r13.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
    L44:
        return -1.0f;
    L10:
        if (r14.length() != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L44;
        char[] r15 = r13.toCharArray();
        char[] r16 = r14.toCharArray();
        int r2 = r15.length;
        int r3 = r16.length;
        int r4 = r2 + 1;
        int[][] r5 = new int[r4][];
        int r6 = 0;
    L16:
        if (r6 >= r4) goto L18;
        r5[r6] = new int[r3 + 1];
        r6 = r6 + 1;
        goto L16
    L18:
        if (r2 < 0) goto L23;
        int r7 = 0;
    L20:
        r5[r7][0] = r7;
        if (r7 == r2) goto L23;
        r7 = r7 + 1;
    L23:
        if (r3 < 0) goto L28;
        int r8 = 0;
    L25:
        r5[0][r8] = r8;
        if (r8 == r3) goto L28;
        r8 = r8 + 1;
    L28:
        if (1 > r2) goto L41;
        int r9 = 1;
    L30:
        if (1 > r3) goto L39;
        int r10 = 1;
    L32:
        int r11 = r9 - 1;
        int r12 = r10 - 1;
        if (r15[r11] != r16[r12]) goto L35;
        int r17 = 0;
    L36:
        int[] r18 = r5[r9];
        r18[r10] = RangesKt.coerceAtMost(RangesKt.coerceAtMost(r5[r11][r10] + 1, r18[r12] + 1), r5[r11][r12] + r17);
        if (r10 == r3) goto L39;
        r10 = r10 + 1;
        goto L32
    L35:
        r17 = 1;
    L39:
        if (r9 == r2) goto L41;
        r9 = r9 + 1;
    L41:
        int r19 = r5[r2][r3];
        if (r2 <= 0) goto L44;
        return r19 / r2;
    L12:
        r1 = false;
        goto L13
    L7:
        r0 = false;
        goto L8
    }

    public static float d(String r1, String r2) {
        return a(r1, r2);
    L4:
        e = move-exception;
        Log.e("HitPointUtils", "safeCalculateCER / error: " + e);
        return -1.0f;
    }

    public static void f(String r2, Pair... r3) {
        e(r2, MapsKt.emptyMap(), (Pair[]) Arrays.copyOf(r3, r3.length));
    }

    public static void h(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "sourceId");
        Intrinsics.checkNotNullParameter(r4, "extraAnalyticParams");
        e("im_voice_input_click", r4, new Pair[]{new Pair("source_id", r3), new Pair("click", "slide_audio")});
    }

    public static void e(String r8, Map r9, Pair... r10) {
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L24
        int r4 = r10.length;     // Catch: Exception -> L24
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L29;
        Pair r6 = r10[r5];     // Catch: Exception -> L24
        r3.put((String) r6.getFirst(), r6.getSecond());     // Catch: Exception -> L24
        r5 = r5 + 1;
        goto L4
    L29:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L17
        Iterator r12 = r9.entrySet().iterator();     // Catch: Throwable -> L17
    L9:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L17
        String r7 = (String) r13.getKey();     // Catch: Throwable -> L17
        String r14 = (String) r13.getValue();     // Catch: Throwable -> L17
        if ((!StringsKt.isBlank(r7)) == false) goto L9;
        if ((!StringsKt.isBlank(r14)) == false) goto L9;
        r3.put(r7, r14);     // Catch: Throwable -> L17
        goto L9
    L15:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Exception -> L24
        if (r16 == null) goto L22;
        Log.e("HitPointUtils", "sendHitPoint / event: " + r8 + ", error: ", r16);     // Catch: Exception -> L24
    L22:
        Statistics.sendEvent(r8, r3);     // Catch: Exception -> L24
        return;
    L17:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Exception -> L24
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.e("HitPointUtils", "sendHitPoint / event: " + r8 + ", error: " + e);
    }

    public static void g(String r3, String r4, String r5, Map r6) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "sourceId");
        Intrinsics.checkNotNullParameter(r5, "clickItem");
        Intrinsics.checkNotNullParameter(r6, "extraAnalyticParams");
        e("im_voice_input_more_click", r6, new Pair[]{new Pair("chat_id", r3), new Pair("source_id", r4), new Pair("click", r5), new Pair("location", "im_input_button")});
    }
}
