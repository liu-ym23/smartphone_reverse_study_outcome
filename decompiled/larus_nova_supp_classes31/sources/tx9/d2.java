package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d2 {
    public static final d2 a = null;

    static {
        a = new d2();
    }

    public d2() {
    }

    public static void c(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "resultScene");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
        r1.put("stage", "on_result");     // Catch: Throwable -> L5
        r1.put("result_code", r3);     // Catch: Throwable -> L5
        r1.put("result_scene", r4);     // Catch: Throwable -> L5
        by7.a r5 = new by7.a("rd_photo_picker_result");     // Catch: Throwable -> L5
        TrackParams r6 = new TrackParams().merge(r1);     // Catch: Throwable -> L5
        r5.a.merge(r6);     // Catch: Throwable -> L5
        r5.b();     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void d(boolean r1, boolean r2, boolean r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        if (r1 == false) goto L6;
        String r5 = "new";
    L7:
        r4.put("photo_picker_version", r5);     // Catch: Throwable -> L17
        if (r2 == false) goto L10;
        String r6 = "bottom";
    L11:
        r4.put("photo_picker_type", r6);     // Catch: Throwable -> L17
        if (r3 == false) goto L14;
        int r7 = 1;
    L15:
        r4.put("is_from_feishu", r7);     // Catch: Throwable -> L17
        by7.a r8 = new by7.a("rd_photo_picker_page_show");     // Catch: Throwable -> L17
        TrackParams r9 = new TrackParams().merge(r4);     // Catch: Throwable -> L17
        r8.a.merge(r9);     // Catch: Throwable -> L17
        r8.b();     // Catch: Throwable -> L17
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L14:
        r7 = 0;
        goto L15
    L10:
        r6 = "full_screen";
        goto L11
    L6:
        r5 = "old";
    L17:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void e(boolean r2, boolean r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "resultScene");
        Intrinsics.checkNotNullParameter(r5, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        r5.put("stage", "set_result");     // Catch: Throwable -> L13
        if (r2 == false) goto L6;
        String r6 = "new";
    L7:
        r5.put("photo_picker_version", r6);     // Catch: Throwable -> L13
        if (r3 == false) goto L10;
        int r7 = 1;
    L11:
        r5.put("is_result_empty", r7);     // Catch: Throwable -> L13
        r5.put("result_scene", r4);     // Catch: Throwable -> L13
        by7.a r8 = new by7.a("rd_photo_picker_result");     // Catch: Throwable -> L13
        TrackParams r9 = new TrackParams().merge(r5);     // Catch: Throwable -> L13
        r8.a.merge(r9);     // Catch: Throwable -> L13
        r8.b();     // Catch: Throwable -> L13
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L10:
        r7 = 0;
        goto L11
    L6:
        r6 = "old";
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void a(d2 r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        JSONObject r0 = new JSONObject();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L18
        if (r7 == null) goto L6;
        r0.put("spring_guide_card_id", r7);     // Catch: Throwable -> L18
    L6:
        if (r4 == null) goto L8;
        r0.put("bot_id", r4);     // Catch: Throwable -> L18
    L8:
        if (r5 == null) goto L10;
        r0.put("tab_name", r5);     // Catch: Throwable -> L18
    L10:
        if (r3 == null) goto L12;
        r0.put("click_from", r3);     // Catch: Throwable -> L18
    L12:
        if (r6 == null) goto L14;
        r0.put("is_landing_tab", r6);     // Catch: Throwable -> L18
    L14:
        if (r2 == null) goto L16;
        r0.put("current_page", r2);     // Catch: Throwable -> L18
    L16:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L23;
        FLogger.a.e("MobAlbumEventHelper", "error in MobAlbumEventHelper " + r10.getLocalizedMessage());
    L23:
        TrackParams r11 = new TrackParams().merge(r0);
        by7.a r12 = new by7.a("album_tab_show");
        r12.a.merge(r11);
        r12.b();
        return;
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public static void b(d2 r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9) {
        JSONObject r0 = new JSONObject();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L25;
    L7:
        if (r3 == null) goto L9;
        r0.put("chat_type", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L11;
        r0.put("click_from", r4);     // Catch: JSONException -> L5
    L11:
        if (r5 == null) goto L13;
        r0.put("button_name", r5);     // Catch: JSONException -> L5
    L13:
        if (r6 == null) goto L15;
        r0.put("current_page", r6);     // Catch: JSONException -> L5
    L15:
        if (r7 == null) goto L17;
        r0.put("previous_page", r7);     // Catch: JSONException -> L5
    L17:
        if (r8 == null) goto L19;
        r0.put("is_multi_choose_mode", r8);     // Catch: JSONException -> L5
    L19:
        if (r9 == null) goto L23;
        r0.put("is_ai_doc", r9.intValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("MobAlbumEventHelper", "error in MobAlbumEventHelper " + e.getLocalizedMessage());
    L23:
        TrackParams r10 = new TrackParams().merge(r0);
        by7.a r11 = new by7.a("click_album_button");
        r11.a.merge(r10);
        r11.b();
        return;
    L25:
        r0.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }
}
