package com.obric.miniapp.alarm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.utils.ResourceUtils;
import com.obric.miniapp.calendar.compatibility.CalendarEntity;
import com.obric.miniapp.calendar.compatibility.EventEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a0 implements b0 {
    public static final a0 b = null;
    public static final Gson c = null;

    public a0() {
    }

    @Override // com.obric.miniapp.alarm.b0
    public final void c() {
    }

    static {
        b = new a0();
        c = new Gson();
        ILiveCard.Companion.getInst().init(AppHost.a.getApplication());
    }

    @Override // com.obric.miniapp.alarm.b0
    public final void a(a r56) {
        Intrinsics.checkNotNullParameter(r56, "alarm");
        AppHost.Companion r0 = AppHost.a;
        Application r3 = r0.getApplication();
        Lazy r4 = m0.a;
        PendingIntent r9 = m0.c(r56, r0.getApplication());
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        String r2 = r56.j.get("pageData");     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        JsonObject r5 = JsonParser.parseString(r2).getAsJsonObject().getAsJsonObject("eventEntity");     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == false) goto L14;
        r6 = null;
    L14:
        JsonObject r7 = (JsonObject) r6;
        if (r7 == null) goto L19;
        String[] r8 = EventEntity.w0;
        EventEntity r10 = EventEntity.a.b(r7);
        if (r10 == null) goto L19;
        EventEntity r11 = com.obric.miniapp.calendar.compatibility.a.b(r10, r3);
    L20:
        LiveCardAlarmExpirationController r12 = LiveCardAlarmExpirationController.a;
        if (r11 == null) goto L23;
        Long r13 = r11.a;
    L25:
        if (LiveCardAlarmExpirationController.f(r3, r13) == true) goto L28;
        FLogger.a.i("LiveCardAlarmUtils", "showNotification, id: " + r56.a + ", eventEntity is not exists, ignore");
        return;
    L28:
        if (r11 != null) goto L238;
    L42:
        Integer r14 = null;
    L43:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L40
    L47:
        if (Result.isFailure-impl(r15) == false) goto L49;
        r15 = null;
    L49:
        Integer r16 = (Integer) r15;
        if (r16 == null) goto L52;
        Duration.Companion r17 = Duration.Companion;
        Long r18 = Long.valueOf(Duration.getInWholeMilliseconds-impl(DurationKt.toDuration(r16.intValue(), DurationUnit.MINUTES)));
    L53:
        long r19 = r56.d.b();
        if (r11 == null) goto L56;
        EventEntity.EventFreq r110 = r11.W;
    L57:
        if (r11 == null) goto L61;
        Long r111 = r11.i;
        if (r111 == null) goto L61;
        long r112 = r111.longValue();
    L62:
        if (r11 == null) goto L65;
        Long r113 = r11.m;
        if (r113 == null) goto L65;
    L70:
        boolean r114 = false;
        if (r113 != null) goto L74;
    L75:
        boolean r115 = true;
    L77:
        if (r115 == true) goto L81;
        r113 = null;
    L81:
        if (r113 == null) goto L95;
        Long r20 = Long.valueOf(r113.longValue() - r112);
        if (r20.longValue() <= 0) goto L85;
        boolean r21 = true;
    L86:
        if (r21 == true) goto L89;
        r20 = null;
    L89:
        if (r20 == null) goto L95;
        long r22 = r20.longValue();
        if (r18 == null) goto L93;
        long r23 = r18.longValue();
    L94:
        Long r24 = Long.valueOf((r19 + r23) + r22);
    L96:
        if (r24 == null) goto L98;
        Long r25 = Long.valueOf(r24.longValue() - new Date().getTime());
    L99:
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("showNotification, id: ");
        EventEntity r28 = r11;
        r27.append(r56.a);
        r27.append(", startTime: ");
        r27.append(r112);
        r27.append(", endTime: ");
        r27.append(r113);
        r27.append(", calculateEndTime: ");
        r27.append(r24);
        r27.append(", durationMs: ");
        r27.append(r25);
        r27.append(", freq: ");
        r27.append(r110);
        r27.append(", triggerTime: ");
        r27.append(r19);
        r27.append(", precedesTime: ");
        r27.append(r18);
        r27.append(", eventEntity: ");
        r27.append(r7);
        r26.i("LiveCardAlarmUtils", r27.toString());
        if (r25 == null) goto L102;
        long r29 = r25.longValue();
    L104:
        if (r29 >= 0) goto L107;
        r26.i("LiveCardAlarmUtils", "showNotification, id: " + r56.a + ", durationMs is negative, ignore");
        return;
    L107:
        String r30 = r56.c;
        if (r110 == null) goto L110;
        boolean r31 = true;
    L111:
        if (r31 == false) goto L113;
        String r32 = r30;
    L114:
        if (r28 == null) goto L116;
        EventEntity r33 = r28;
        String r210 = r33.y;
    L117:
        if (r33 == null) goto L164;
        Long r34 = r33.e;
        if (r34 == null) goto L164;
        Uri r35 = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, r34.longValue());
        ContentResolver r36 = r3.getContentResolver();
        String[] r37 = {"cal_sync1"};
        f06.c r38 = new f06.c();
        Object[] r39 = {r35, r37, null, null, null};
        f06.b r40 = new f06.b();
        f06.d r41 = r38.b(240004, "android/content/ContentResolver", "query", r36, r39, "android.database.Cursor", r40);
        if (r41.a == false) goto L123;
        r38.a(240004, "android/content/ContentResolver", "query", r36, r39, null, r40, false);
        Cursor r42 = (Cursor) r41.b;
    L124:
        if (r42 == null) goto L140;
        Cursor r43 = r42;
        Cursor r44 = r43;     // Catch: Throwable -> L134
        if (r44.moveToFirst() == false) goto L132;
        String[] r45 = CalendarEntity.E;     // Catch: Throwable -> L134
        CalendarEntity.AccountType r46 = CalendarEntity.a.a(r44).e;     // Catch: Throwable -> L134
        if (r46 == null) goto L132;
        String r47 = r46.toString();     // Catch: Throwable -> L134
        Throwable r48 = null;
    L133:
        CloseableKt.closeFinally(r43, r48);
    L141:
        if (r47 == null) goto L164;
        switch(r47.hashCode()) {
            case -1953474717: goto L158;
            case 64897: goto L155;
            case 2329198: goto L152;
            case 2358713: goto L149;
            case 72607563: goto L146;
            default: goto L161;
        };
    L161:
        boolean r49 = false;
    L162:
        if (r49 == false) goto L164;
        String r310 = r47;
    L166:
        if (r33 == null) goto L184;
        EventEntity.EventType r50 = r33.u;
        if (r50 == null) goto L184;
        String r51 = r50.toString();
        if (r51 == null) goto L184;
        if (Intrinsics.areEqual(r51, AlarmSessionType.EVENT) == false) goto L174;
    L177:
        boolean r52 = true;
    L178:
        if (r52 == true) goto L181;
        r51 = null;
    L181:
        if (r51 == null) goto L184;
        String r311 = r51;
    L185:
        Lazy r53 = AlarmTtsNotificationDispatcher.a;
        Intrinsics.checkNotNullParameter(r56, "alarm");
        AlarmTtsNotificationDispatcher.c.tryEmit(r56);
        final String r54 = r56.a;
        if (r33 == null) goto L188;
        Long r312 = r33.a;
    L189:
        String r55 = r56.b;
        Long r57 = Long.valueOf(r112);
        if (r110 != null) goto L192;
        boolean r58 = true;
    L193:
        if (r58 == false) goto L195;
        Long r313 = r113;
    L196:
        if (r57 != null) goto L200;
        if (r32 != null) goto L200;
        return;
    L200:
        if (ILiveCard.Companion.getInst().getVersion(r3) >= 6) goto L202;
        String r59 = "忽略";
    L203:
        LeftBtn r60 = new LeftBtn("calendar_cancel", r59);
        if (r57 == null) goto L212;
        r57.longValue();
        if (r32 != null) goto L208;
    L209:
        r114 = true;
    L210:
        if (r114 == false) goto L212;
        Long r314 = r57;
    L213:
        AlarmSessionInfo r61 = new AlarmSessionInfo(r60, r210, r310, r314, r313, r55, r311, r32);
        SimpleDateFormat r62 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        if (Intrinsics.areEqual(r61.getType(), AlarmSessionType.EVENT) == false) goto L216;
        String r63 = "oic_calendar.svg";
    L217:
        Icon r315 = new Icon(20, 20, ResourceUtils.INSTANCE.getAssetsFile(AppHost.a.getApplication(), r63, "svg"), null, null, null, null, false, null, null, null, 2040, null);
        if (r57 == null) goto L231;
        r57.longValue();
        Object r64 = Result.constructor-impl(r62.format(r57));     // Catch: Throwable -> L222
    L224:
        Object r65 = r64;
        if (Result.isFailure-impl(r65) == false) goto L227;
        r65 = null;
    L227:
        String r66 = (String) r65;
        if (r66 == null) goto L231;
        String r316 = r66;
    L234:
        IslandWidget r67 = CommonCollapseTemplate.create$default(new CommonCollapseTemplate(null, new Text(r316, 14, "#FFFFFFFF", null, null, null, null, null, 248, null), r315, null, 9, null), null, 1, null);
        String r410 = GsonProtectorUtils.toJson(c, r61);
        Boolean r411 = Boolean.TRUE;
        IslandWidget r68 = new IslandWidget("com.obric.island_applet:memory_showinfo_template", r410, r411, null, null, null, null, null, null, 504, null);
        r68.addOnViewClickCallback(r61.getLeft_btn().getId(), new y(r54));
        IslandSession r69 = new IslandSession(r67, r68, null, null, r9, new z(r54), null, 0, null, null, r411, null, 2048, null, null, null, 0, 125900, null);
        LiveCardAlarmExpirationController r70 = LiveCardAlarmExpirationController.a;
        Intrinsics.checkNotNullParameter(r54, "id");
        Intrinsics.checkNotNullParameter(r69, "session");
        BuildersKt.launch$default(LiveCardAlarmExpirationController.b, null, null, new LiveCardAlarmExpirationController$addSession$1(r54, r25, r69, r312, null), 3, null);
        return;
    L222:
        th = move-exception;
        Result.Companion r71 = Result.Companion;
        r64 = Result.constructor-impl(ResultKt.createFailure(th));
    L231:
        if (r32 != null) goto L233;
        r32 = "";
    L233:
        r316 = r32;
        goto L234
    L216:
        r63 = "oic_calendar_badge_clock.svg";
        goto L217
    L208:
        if (r32.length() != 0) goto L210;
    L212:
        r314 = null;
        goto L213
    L202:
        r59 = ResourceUtils.INSTANCE.getString(2131911804);
        goto L203
    L195:
        r313 = null;
        goto L196
    L192:
        r58 = false;
        goto L193
    L188:
        r312 = null;
        goto L189
    L174:
        if (Intrinsics.areEqual(r51, AlarmSessionType.TODO) == true) goto L177;
        r52 = false;
    L184:
        r311 = AlarmSessionType.EVENT;
        goto L185
    L146:
        if (r47.equals(AccountType.LOCAL) == false) goto L161;
    L160:
        r49 = true;
        goto L162
    L149:
        if (r47.equals(AccountType.MAIN) == true) goto L160;
    L152:
        if (r47.equals(AccountType.LARK) == false) goto L161;
    L155:
        if (r47.equals(AccountType.ALL) == true) goto L160;
    L158:
        if (r47.equals(AccountType.OTHERS) == true) goto L160;
    L132:
        r48 = null;
        r47 = null;
    L134:
        th = move-exception;
        throw th;     // Catch: Throwable -> L137
    L137:
        th = move-exception;
        CloseableKt.closeFinally(r43, th);
        throw th;
    L140:
        r47 = null;
        goto L141
    L123:
        Cursor r72 = r36.query(r35, r37, null, null, null);
        r38.a(240004, "android/content/ContentResolver", "query", r36, r39, r72, r40, true);
        r42 = r72;
    L164:
        r310 = null;
        goto L166
    L116:
        r33 = r28;
        r210 = null;
        goto L117
    L113:
        r32 = null;
        goto L114
    L110:
        r31 = false;
        goto L111
    L102:
        r29 = 0;
        goto L104
    L98:
        r25 = null;
        goto L99
    L93:
        r23 = 0;
        goto L94
    L85:
        r21 = false;
    L95:
        r24 = null;
        goto L96
    L74:
        if (r113.longValue() != r112) goto L75;
        r115 = false;
    L65:
        if (r7 == null) goto L69;
        JsonElement r116 = vka.n.a(r7, "dtend");
        if (r116 == null) goto L69;
        r113 = Long.valueOf(r116.getAsLong());
    L69:
        r113 = null;
    L61:
        r112 = r19;
        goto L62
    L56:
        r110 = null;
        goto L57
    L52:
        r18 = null;
    L40:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L238:
        Long r73 = r11.a;     // Catch: Throwable -> L40
        if (r73 == null) goto L42;
        xka.k r74 = new xka.k(r73.longValue());     // Catch: Throwable -> L40
        vka.f r118 = vka.f.a;     // Catch: Throwable -> L40
        List r75 = r74.a().asList();     // Catch: Throwable -> L40
        if (r75 == null) goto L42;
        JsonElement r76 = (JsonElement) CollectionsKt.firstOrNull(r75);     // Catch: Throwable -> L40
        if (r76 == null) goto L42;
        JsonObject r77 = r76.getAsJsonObject();     // Catch: Throwable -> L40
        if (r77 == null) goto L42;
        JsonElement r78 = r77.get("minutes");     // Catch: Throwable -> L40
        if (r78 == null) goto L42;
        r14 = Integer.valueOf(r78.getAsInt());     // Catch: Throwable -> L40
        goto L43
    L23:
        r13 = null;
    L19:
        r11 = null;
        goto L20
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.obric.miniapp.alarm.b0
    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        LiveCardAlarmExpirationController r1 = LiveCardAlarmExpirationController.a;
        Intrinsics.checkNotNullParameter(r3, "id");
        LiveCardAlarmExpirationController.a r4 = LiveCardAlarmExpirationController.c.get(r3);
        if (r4 == null) goto L5;
        IslandSession r5 = r4.a;
    L6:
        if (r5 == null) goto L11;
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L12;
        r0.destroySession(r5);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
