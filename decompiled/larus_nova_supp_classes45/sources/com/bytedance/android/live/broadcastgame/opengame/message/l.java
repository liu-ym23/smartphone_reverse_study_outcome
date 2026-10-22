package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l {
    public static final f0 a(com.bytedance.android.livesdk.message.model.e0 r46, int r47) {
        Intrinsics.checkNotNullParameter(r46, "$this$toOpenEntranceMessage");
        String r0 = r46.entranceExtra;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L81;
        String r3 = r46.extra;
        String r8 = r46.entranceSchemaUrl;
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        String r9 = r46.appId;
        if (r9 != null) goto L32;
        String r12 = "";
    L33:
        String r11 = r8;
        String r13 = r3;
    L34:
        long r14 = 0;
        int r28 = 0;
    L35:
        if (r13 == null) goto L83;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L76
        JSONObject r4 = LiveSeiUtil.c(r13);     // Catch: Exception -> L76
        String r15 = r4.optString(OpenPlatformBaseDebugger.APP_ID, "");     // Catch: Exception -> L76
        long r17 = r4.optLong("room_id", 0);     // Catch: Exception -> L76
        r4.optLong("seq", 0);     // Catch: Exception -> L76
        long r19 = r4.optLong("conn_id", 0);     // Catch: Exception -> L76
        JSONObject r5 = LiveSeiUtil.c(r13);     // Catch: Exception -> L76
        if (r11.length() != 0) goto L39;
        boolean r6 = true;
    L40:
        if (r6 == false) goto L42;
        String r22 = r5.optString("schema");     // Catch: Exception -> L76
    L43:
        int r7 = r5.optInt("business_type");     // Catch: Exception -> L76
        long r25 = r5.optLong("mode");     // Catch: Exception -> L76
        String r16 = r5.optString("current_game_version");     // Catch: Exception -> L76
        boolean r31 = r5.optBoolean("need_metrics_report", false);     // Catch: Exception -> L76
        String r27 = r5.optString("current_game_identifer");     // Catch: Exception -> L76
        String r29 = r5.optString("game_category");     // Catch: Exception -> L76
        ImageModel r18 = r46.icon;     // Catch: Exception -> L76
        if (r18 != null) goto L46;
    L52:
        ImageModel r21 = r46.icon;     // Catch: Exception -> L76
        if (r21 == null) goto L55;
        String r23 = r21.getUri();     // Catch: Exception -> L76
    L56:
        boolean r38 = r5.optBoolean("hide_user_entrance", false);     // Catch: Exception -> L76
        boolean r41 = Intrinsics.areEqual(r5.optString("enter_from", ""), "revenue_interact");     // Catch: Exception -> L76
        if (r12.length() != 0) goto L59;
        boolean r24 = true;
    L60:
        if (r24 == false) goto L62;
        String r26 = r15;
    L63:
        String r32 = r46.name;     // Catch: Exception -> L76
        if (r23 != null) goto L66;
        String r210 = "";
    L67:
        String r33 = r5.optString("developer");     // Catch: Exception -> L76
        int r34 = (int) r46.status;     // Catch: Exception -> L76
        boolean r35 = r46.checkEntranceVisible;     // Catch: Exception -> L76
        Map r36 = r46.startPageQuery;     // Catch: Exception -> L76
        boolean r37 = r46.joinEnable;     // Catch: Exception -> L76
        boolean r110 = r46.soreEnable;     // Catch: Exception -> L76
        if (r7 == 5) goto L71;
        r2 = false;
    L71:
        f0 r39 = new f0(r14, r16, r17, r19, r26, r22, r32, r210, r25, r27, r28, r29, r31, r33, r7, r34, false, r35, r47, r36, r38, Boolean.valueOf(r2), null, r41, r46.entranceSchemaUrl, r37, r110, 67633152);     // Catch: Exception -> L76
        Unit r42 = Unit.INSTANCE;     // Catch: Exception -> L75
    L74:
        return r39;
    L66:
        r210 = r23;
        goto L67
    L62:
        r26 = r12;
        goto L63
    L59:
        r24 = false;
    L55:
        r23 = null;
        goto L56
    L46:
        if (r18.isValid() != true) goto L52;
        ImageModel r43 = r46.icon;     // Catch: Exception -> L76
        if (r43 == null) goto L55;
        List<String> r44 = r43.mUrls;     // Catch: Exception -> L76
        if (r44 == null) goto L55;
        r23 = (String) ListProtector.get(r44, 0);     // Catch: Exception -> L76
        goto L56
    L42:
        r22 = r11;
        goto L43
    L39:
        r6 = false;
    L84:
        return null;
    L83:
        return null;
    L32:
        r12 = r9;
        goto L33
    L81:
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L17
        String r48 = r46.entranceExtra;     // Catch: Throwable -> L17
        if (r48 == null) goto L14;
        com.bytedance.android.livesdk.message.model.x r49 = (com.bytedance.android.livesdk.message.model.x) GsonHelper.get().fromJson(r48, com.bytedance.android.livesdk.message.model.x.class);     // Catch: Throwable -> L17
    L15:
        Object r51 = Result.constructor-impl(r49);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r51) == false) goto L22;
        r51 = null;
    L22:
        com.bytedance.android.livesdk.message.model.x r52 = (com.bytedance.android.livesdk.message.model.x) r51;
        if (r52 == null) goto L25;
        r13 = r52.extra;
        r11 = r52.schemaUrl;
        long r111 = r52.gameId;
        r12 = r52.appId;
        r28 = (int) r52.gameKind;
        r14 = r111;
        goto L35
    L25:
        r13 = null;
        r11 = "";
        r12 = r11;
        goto L34
    L14:
        r49 = null;
    L17:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r51 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
