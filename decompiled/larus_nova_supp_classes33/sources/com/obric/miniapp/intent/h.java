package com.obric.miniapp.intent;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.settings.IObricSettingRouteService;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.entity.ResultCode;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.miniapp.alarm.AlarmManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h {
    public static final h a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IntentCardOpType.values().length];
            r0[IntentCardOpType.QUERY_APP_ICON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L85:
            r0[IntentCardOpType.OPEN_APP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L99:
            r0[IntentCardOpType.OPEN_APP_DETAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[IntentCardOpType.SET_ALARM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L65:
            r0[IntentCardOpType.TURN_ON_OFF_ALARM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L79:
            r0[IntentCardOpType.DELETE_ALARM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L93:
            r0[IntentCardOpType.DELETE_CONTACTS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L71:
            r0[IntentCardOpType.DELETE_CALL_HISTORY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L87:
            r0[IntentCardOpType.DELETE_MESSAGES.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L89:
            r0[IntentCardOpType.DELETE_MEMORIES.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
        L55:
            r0[IntentCardOpType.OPEN_VIEW_ALL_SHEET.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
        L83:
            r0[IntentCardOpType.SHOW_ENTITY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
        L97:
            r0[IntentCardOpType.CALL_PHONE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L53:
            r0[IntentCardOpType.SEND_SMS.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
        L67:
            r0[IntentCardOpType.OPEN_SMS_COMPOSER.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
        L95:
            r0[IntentCardOpType.CONFIRM_MESSAGE_SEND.ordinal()] = 16;     // Catch: NoSuchFieldError -> L44
        L59:
            r0[IntentCardOpType.PLAY_MUSIC.ordinal()] = 17;     // Catch: NoSuchFieldError -> L45
        L63:
            r0[IntentCardOpType.PAUSE_MUSIC.ordinal()] = 18;     // Catch: NoSuchFieldError -> L46
        L81:
            r0[IntentCardOpType.QUERY_MUSIC_STATE.ordinal()] = 19;     // Catch: NoSuchFieldError -> L47
        L57:
            r0[IntentCardOpType.OPEN_MUSIC_PAGE.ordinal()] = 20;     // Catch: NoSuchFieldError -> L48
        L75:
            r0[IntentCardOpType.SHOW_PHOTO_GROUP.ordinal()] = 21;     // Catch: NoSuchFieldError -> L49
        L77:
            r0[IntentCardOpType.QUERY_PRIVILEGED_IMAGE.ordinal()] = 22;     // Catch: NoSuchFieldError -> L50
        L91:
            r0[IntentCardOpType.DELETE_RECORDINGS.ordinal()] = 23;     // Catch: NoSuchFieldError -> L51
        L69:
            r0[IntentCardOpType.SHOW_WEATHER.ordinal()] = 24;     // Catch: NoSuchFieldError -> L52
        L27:
            a = r0;
        }
    }

    static {
        a = new h();
    }

    public h() {
    }

    public static Context g(e3.d r1) {
        Activity r2 = r1.getOwnerActivity();
        if (r2 != null) goto L11;
        AppHost.Companion r3 = AppHost.a;
        Activity r0 = r3.a().getCurrentActivity();
        if (r0 == null) goto L9;
        return r0;
    L9:
        return r3.getApplication().getApplicationContext();
    L11:
        return r2;
    }

    public static String h(e3.d r1) {
        WidgetContainer r2 = (WidgetContainer) r1.d(WidgetContainer.class);
        String r0 = null;
        if (r2 == null) goto L5;
        com.bytedance.ai.widget.contianer.m r3 = r2.g;
    L6:
        if (r3 == null) goto L8;
        r0 = r3.j;
    L8:
        if (r0 != null) goto L11;
        return "";
    L11:
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    public static String f(JSONObject r1, String r2) {
        if (r1.has(r2) == false) goto L7;
        String r3 = r1.optString(r2);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == false) goto L9;
        return r3;
    L9:
        return "";
    L7:
        return "";
    }

    public static JSONObject i(j r3, JSONObject r4) {
        JSONObject r0 = new JSONObject();
        r0.put("status", 0);
        r0.put("op", r3.a);
        r0.put("request_id", r3.b);
        r0.put("scene", r3.c);
        r0.put("content", r4);
        r0.put("error_code", "");
        r0.put("error_message", "");
        return r0;
    }

    public static /* synthetic */ JSONObject j(h r1, j r2) {
        JSONObject r0 = new JSONObject();
        r1.getClass();
        return i(r2, r0);
    }

    public final JSONObject k(c r2, j r3) {
        if (r2.a == false) goto L6;
        return j(this, r3);
    L6:
        return c(r3, r2.b, r2.c);
    }

    public final JSONObject l(k r2, j r3) {
        if (r2.a == false) goto L6;
        return j(this, r3);
    L6:
        return c(r3, r2.b, r2.c);
    }

    public static JSONObject c(j r2, String r3, String r4) {
        return d(r2.a, r2.b, r3, r4, r2.c);
    }

    public static void a(final j r6, String r7, Set r8, final com.obric.miniapp.aibridge.i r9) {
        FLogger r0 = FLogger.a;
        r0.i("IntentCardOperation", "delete request op=" + r6.a + " requestId=" + r6.b + " scene=" + r6.c + " expectedScene=" + r7);
        if (Intrinsics.areEqual(r6.c, r7) == true) goto L6;
        r0.e("IntentCardOperation", "delete rejected op=" + r6.a + " requestId=" + r6.b + " scene=" + r6.c + " expectedScene=" + r7);
        StringBuilder r10 = new StringBuilder();
        r10.append(r6.a);
        r10.append(" is restricted to ");
        r10.append(r7);
        r9.invoke(c(r6, "INVALID_SCENE", r10.toString()));
        return;
    L6:
        DeleteEntitiesOperation.a.a(r6.d, r8, new g(r6, r9));
    }

    private final c startActivity(Context r3, Intent r4, String r5, String r6) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r4.addFlags(268435456);     // Catch: Throwable -> L5
        r3.startActivity(r4);     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(new c(true, "", ""));     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L15;
        FLogger.a.e("IntentCardOperation", r5 + " failed packageName=" + r6, r8);
        String r9 = r8.getMessage();
        if (r9 != null) goto L13;
        r9 = r5 + " failed";
    L13:
        r7 = new c(false, "START_ACTIVITY_FAILED", r9);
    L15:
        return (c) r7;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Type inference failed for: r12v4, types: [com.obric.miniapp.intent.w, java.lang.Object] */
    public final void b(e3.d r19, final j r20, IntentCardOpType r21, final com.obric.miniapp.aibridge.i r22) {
        int r5 = 0;
        String r7 = null;
        Integer r8 = null;
        Integer r9 = null;
        String r10 = null;
        String r11 = null;
        switch(a.a[r21.ordinal()]) {
            case 1: goto L526;
            case 2: goto L507;
            case 3: goto L497;
            case 4: goto L461;
            case 5: goto L424;
            case 6: goto L423;
            case 7: goto L422;
            case 8: goto L421;
            case 9: goto L420;
            case 10: goto L419;
            case 11: goto L344;
            case 12: goto L278;
            case 13: goto L236;
            case 14: goto L181;
            case 15: goto L171;
            case 16: goto L139;
            case 17: goto L91;
            case 18: goto L90;
            case 19: goto L82;
            case 20: goto L76;
            case 21: goto L25;
            case 22: goto L24;
            case 23: goto L20;
            case 24: goto L6;
            default: goto L5;
        };
    L6:
        Set<String> r0 = b0.a;
        JSONObject r1 = r20.d;
        Intrinsics.checkNotNullParameter(r1, "payload");
        String r4 = StringsKt.trim(r1.optString("location")).toString();
        if (r4.length() != 0) goto L9;
        r5 = 1;
    L9:
        if (r5 == 0) goto L11;
        int r2 = k.d;
        k r3 = k.a.a("MISSING_LOCATION", "location is required");
    L18:
        r22.invoke(l(r3, r20));
        return;
    L11:
        String r6 = StringsKt.trim(r1.optString("type")).toString().toUpperCase(Locale.ROOT);
        if (b0.a.contains(r6) == true) goto L14;
        int r12 = k.d;
        r3 = k.a.a("UNSUPPORTED_WEATHER_TYPE", "unsupported weather type: " + r6);
        goto L18
    L14:
        IAgentAppIntentIDL r13 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r13 != null) goto L17;
        int r14 = k.d;
        r3 = k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
        goto L18
    L17:
        r13.showWeather(r4, r6);
        int r15 = k.d;
        r3 = k.a.b();
        goto L18
    L24:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new IntentCardOperationHelper$dispatch$2(r20, r22, null), 3, null);
        return;
    L25:
        a0 r16 = a0.a;
        JSONObject r17 = r20.d;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "payload");
        JSONArray r18 = r17.optJSONArray("entities");
        if (r18 != null) goto L542;
        int r23 = k.d;
        k r24 = k.a.a("MISSING_ENTITIES", "entities is required");
    L75:
        r22.invoke(l(r24, r20));
        return;
    L542:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L42
        int r26 = r18.length();     // Catch: Throwable -> L42
        PhotoEntity[] r110 = new PhotoEntity[r26];     // Catch: Throwable -> L42
        int r111 = 0;
    L29:
        if (r111 >= r26) goto L40;
        JSONObject r112 = r18.optJSONObject(r111);     // Catch: Throwable -> L42
        if (r112 == null) goto L38;
        zda.a.a.getClass();     // Catch: Throwable -> L42
        AppEntity r113 = zda.a.d(r112);     // Catch: Throwable -> L42
        if ((r113 instanceof PhotoEntity) == false) goto L36;
        PhotoEntity r114 = (PhotoEntity) r113;     // Catch: Throwable -> L42
    L37:
        if (r114 == null) goto L38;
        r110[r111] = r114;     // Catch: Throwable -> L42
        r111 = r111 + 1;     // Catch: Throwable -> L42
        goto L29
    L36:
        r114 = null;
    L38:
        r110 = null;
    L40:
        Object r27 = Result.constructor-impl(r110);     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r27) == false) goto L47;
        r27 = null;
    L47:
        PhotoEntity[] r28 = (PhotoEntity[]) r27;
        if (r28 != null) goto L51;
        int r29 = k.d;
        r24 = k.a.a("INVALID_ENTITIES", "entities is invalid");
        goto L75
    L51:
        if (r28.length != 0) goto L53;
        boolean r30 = true;
    L54:
        if (r30 == false) goto L56;
        int r31 = k.d;
        r24 = k.a.a("MISSING_ENTITIES", "entities is empty");
        goto L75
    L56:
        Object r32 = r17.opt("index");
        if ((r32 instanceof Number) == false) goto L60;
        r8 = Integer.valueOf(((Number) r32).intValue());
    L62:
        if (r8 == null) goto L64;
        int r33 = r8.intValue();
    L65:
        if (r33 >= 0) goto L67;
    L69:
        if (r5 != 0) goto L71;
        int r34 = k.d;
        r24 = k.a.a("INVALID_INDEX", "index is out of range");
        goto L75
    L71:
        IAgentAppIntentIDL r35 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r35 != null) goto L74;
        int r36 = k.d;
        r24 = k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
        goto L75
    L74:
        r35.showPhoto(r28, r33);
        int r37 = k.d;
        r24 = k.a.b();
        goto L75
    L67:
        if (r33 >= r28.length) goto L69;
        r5 = 1;
        goto L69
    L64:
        r33 = 0;
        goto L65
    L60:
        if ((r32 instanceof String) == false) goto L62;
        r8 = StringsKt.toIntOrNull((String) r32);
        goto L62
    L53:
        r30 = false;
    L42:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L76:
        v.a.getClass();
        IAgentAppIntentIDL r39 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r39 != null) goto L79;
        int r40 = k.d;
        k r41 = k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
    L80:
        r22.invoke(l(r41, r20));
        return;
    L79:
        r39.showMusicPage();
        int r42 = k.d;
        r41 = k.a.b();
        goto L80
    L90:
        r22.invoke(l(v.a.d(h(r19)), r20));
        return;
    L91:
        v r43 = v.a;
        JSONObject r44 = r20.d;
        String r45 = h(r19);
        monitor-enter(r43);
        Intrinsics.checkNotNullParameter(r44, "payload");     // Catch: Throwable -> L136
        Intrinsics.checkNotNullParameter(r45, "cardId");     // Catch: Throwable -> L136
        if (StringsKt.isBlank(r45) == false) goto L98;
        int r46 = k.d;     // Catch: Throwable -> L136
        k r47 = k.a.a("MISSING_CARD_ID", "mixture_card_id is required");     // Catch: Throwable -> L136
        monitor-exit(r43);
    L135:
        r22.invoke(l(r47, r20));
        return;
    L98:
        JSONArray r48 = r44.optJSONArray("entities");     // Catch: Throwable -> L136
        if (r48 != null) goto L103;
        int r49 = k.d;     // Catch: Throwable -> L136
        r47 = k.a.a("MISSING_ENTITIES", "entities is required");     // Catch: Throwable -> L136
        monitor-exit(r43);
        goto L135
    L103:
        MusicEntity[] r50 = v.c(r48);     // Catch: Throwable -> L136
        if (r50 != null) goto L109;
        int r51 = k.d;     // Catch: Throwable -> L136
        r47 = k.a.a("INVALID_ENTITIES", "entities is invalid");     // Catch: Throwable -> L136
        monitor-exit(r43);
        goto L135
    L109:
        if (r50.length != 0) goto L111;
        boolean r115 = true;
    L112:
        if (r115 == false) goto L116;
        int r52 = k.d;     // Catch: Throwable -> L136
        r47 = k.a.a("MISSING_ENTITIES", "entities is empty");     // Catch: Throwable -> L136
        monitor-exit(r43);
        goto L135
    L116:
        Object r53 = r44.opt("index");     // Catch: Throwable -> L136
        if ((r53 instanceof Number) == false) goto L120;
        r9 = Integer.valueOf(((Number) r53).intValue());     // Catch: Throwable -> L136
    L122:
        if (r9 == null) goto L124;
        int r54 = r9.intValue();     // Catch: Throwable -> L136
    L125:
        if (r54 >= 0) goto L127;
    L129:
        if (r5 != 0) goto L133;
        int r55 = k.d;     // Catch: Throwable -> L136
        r47 = k.a.a("INVALID_INDEX", "index is out of range");     // Catch: Throwable -> L136
        monitor-exit(r43);
        goto L135
    L133:
        r47 = v.e(r45, r50, r54, s.d.b(r45));     // Catch: Throwable -> L136
        monitor-exit(r43);
        goto L135
    L127:
        if (r54 >= r50.length) goto L129;
        r5 = 1;
        goto L129
    L124:
        r54 = 0;
        goto L125
    L120:
        if ((r53 instanceof String) == false) goto L122;
        r9 = StringsKt.toIntOrNull((String) r53);     // Catch: Throwable -> L136
        goto L122
    L111:
        r115 = false;
    L136:
        th = move-exception;
        throw th;
    L139:
        WidgetContainer r56 = (WidgetContainer) r19.d(WidgetContainer.class);
        if (r56 == null) goto L142;
        String r57 = r56.l();
    L143:
        if (r57 != null) goto L145;
        r57 = "";
    L145:
        b r58 = b.a;
        JSONObject r59 = r20.d;
        r58.getClass();
        Intrinsics.checkNotNullParameter(r59, "payload");
        Intrinsics.checkNotNullParameter(r57, "widgetMessageId");
        String r60 = r59.optString("local_message_id");
        Intrinsics.checkNotNull(r60);
        if ((true ^ StringsKt.isBlank(r60)) == false) goto L148;
        r10 = r60;
    L148:
        if (r10 != null) goto L150;
        int r61 = k.d;
        k r62 = k.a.a("MISSING_LOCAL_MESSAGE_ID", "local_message_id is required");
    L170:
        r22.invoke(l(r62, r20));
        return;
    L150:
        IAgentAppIntentIDL r63 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r63 != null) goto L153;
        int r64 = k.d;
        r62 = k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
        goto L170
    L153:
        Intrinsics.checkNotNullParameter(r10, "localMessageId");
        Intrinsics.checkNotNullParameter(r57, "widgetMessageId");
        String r65 = r10;
        if (StringsKt.isBlank(r57) == false) goto L540;
    L169:
        r63.notifyLarkSendStausChanged(r65, 10);
        int r66 = k.d;
        r62 = k.a.b();
        goto L170
    L540:
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L162
        JSONObject r68 = new JSONObject(r10);     // Catch: Throwable -> L162
        if (r68.optBoolean("o_stateless_send") == true) goto L159;
        String r69 = r10;
    L160:
        Object r70 = Result.constructor-impl(r69);     // Catch: Throwable -> L162
    L164:
        Object r71 = r10;
        if (Result.isFailure-impl(r70) == true) goto L168;
        r71 = r70;
    L168:
        r65 = (String) r71;
        goto L169
    L159:
        String r72 = r68.put("widget_message_id", r57).toString();     // Catch: Throwable -> L162
        Intrinsics.checkNotNull(r72);     // Catch: Throwable -> L162
        r69 = r72;
    L162:
        th = move-exception;
        Result.Companion r73 = Result.Companion;
        r70 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L164
    L142:
        r57 = null;
        goto L143
    L171:
        Context r74 = g(r19);
        JSONObject r75 = r20.d;
        String r76 = f(r75, "telephone");
        if (StringsKt.isBlank(r76) == false) goto L174;
        c r77 = new c(false, "MISSING_TELEPHONE", "telephone is required");
    L180:
        r22.invoke(k(r77, r20));
        return;
    L174:
        Intent r78 = new Intent("android.intent.action.SENDTO");
        r78.setData(Uri.fromParts("smsto", r76, null));
        if (r75.has("text") == true) goto L177;
    L179:
        r77 = startActivity(r74, r78, "open sms composer", "");
        goto L180
    L177:
        if (r75.isNull("text") == true) goto L179;
        r78.putExtra("sms_body", r75.optString("text"));
        goto L179
    L181:
        y r79 = y.a;
        JSONObject r80 = r20.d;
        r79.getClass();
        Intrinsics.checkNotNullParameter(r80, "payload");
        String r81 = r80.optString("telephone");
        Intrinsics.checkNotNull(r81);
        if ((!StringsKt.isBlank(r81)) == true) goto L185;
        r81 = null;
    L185:
        if (r81 != null) goto L188;
        r81 = "";
    L188:
        if (StringsKt.isBlank(r81) == false) goto L190;
        String r82 = null;
    L191:
        JSONObject r83 = r80.optJSONObject("contact");
        if (r83 != null) goto L538;
        ContactEntity r84 = null;
    L206:
        if (r84 == null) goto L208;
    L211:
        if (r82 != null) goto L214;
        if (r84 != null) goto L214;
        int r85 = k.d;
        k r86 = k.a.a("MISSING_TARGET", "telephone or contact is required");
    L235:
        r22.invoke(l(r86, r20));
        return;
    L214:
        IAgentAppIntentIDL r87 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r87 != null) goto L218;
        int r88 = k.d;
        r86 = k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
        goto L235
    L218:
        if (r80.has("text") == true) goto L220;
    L223:
        String r89 = null;
    L224:
        String r90 = r80.optString("reply_id");
        Intrinsics.checkNotNull(r90);
        if ((true ^ StringsKt.isBlank(r90)) == true) goto L228;
        r90 = null;
    L228:
        if (r90 != null) goto L231;
        r90 = "";
    L231:
        if (StringsKt.isBlank(r90) == true) goto L234;
        r11 = r90;
    L234:
        r87.sendSms(r82, r84, r89, r11);
        int r91 = k.d;
        r86 = k.a.b();
        goto L235
    L220:
        if (r80.isNull("text") == true) goto L223;
        r89 = r80.optString("text");
        goto L224
    L208:
        if (r80.has("contact") == false) goto L210;
        int r92 = k.d;
        r86 = k.a.a("INVALID_CONTACT", "contact is invalid");
        goto L235
    L210:
        r84 = null;
        goto L211
    L538:
        Result.Companion r93 = Result.Companion;     // Catch: Throwable -> L200
        zda.a.a.getClass();     // Catch: Throwable -> L200
        ContactEntity r94 = zda.a.d(r83);     // Catch: Throwable -> L200
        if ((r94 instanceof ContactEntity) == false) goto L197;
        ContactEntity r95 = r94;     // Catch: Throwable -> L200
    L198:
        Object r96 = Result.constructor-impl(r95);     // Catch: Throwable -> L200
    L203:
        if (Result.isFailure-impl(r96) == false) goto L205;
        r96 = null;
    L205:
        r84 = (ContactEntity) r96;
        goto L206
    L197:
        r95 = null;
    L200:
        th = move-exception;
        Result.Companion r97 = Result.Companion;
        r96 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L203
    L190:
        r82 = r81;
        goto L191
    L236:
        com.obric.miniapp.intent.a r98 = com.obric.miniapp.intent.a.a;
        JSONObject r99 = r20.d;
        CallPhoneOperation$execute$1 r100 = new CallPhoneOperation$execute$1(r98);
        r98.getClass();
        Intrinsics.checkNotNullParameter(r99, "payload");
        Intrinsics.checkNotNullParameter(r100, "isSimAbsent");
        String r101 = com.obric.miniapp.intent.a.a(r99, "telephone");
        if (StringsKt.isBlank(r101) == false) goto L239;
        String r102 = null;
    L240:
        JSONObject r103 = r99.optJSONObject("contact");
        if (r103 != null) goto L535;
        ContactEntity r104 = null;
    L255:
        if (r104 == null) goto L257;
    L260:
        if (r102 != null) goto L264;
        if (r104 != null) goto L264;
        int r105 = k.d;
        k r106 = k.a.a("MISSING_TARGET", "telephone or contact is required");
    L277:
        r22.invoke(l(r106, r20));
        return;
    L264:
        if (((Boolean) r100.invoke()).booleanValue() == false) goto L266;
        int r107 = k.d;
        r106 = k.a.a("NO_SIM_CARD", "SIM card not present");
        goto L277
    L266:
        IAgentAppIntentIDL r108 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r108 != null) goto L269;
        int r109 = k.d;
        r106 = k.a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
        goto L277
    L269:
        String r116 = com.obric.miniapp.intent.a.a(r99, "call_type");
        if (StringsKt.isBlank(r116) == false) goto L272;
        r116 = null;
    L272:
        String r117 = com.obric.miniapp.intent.a.a(r99, "reply_id");
        if (StringsKt.isBlank(r117) == true) goto L276;
        r7 = r117;
    L276:
        r108.callPhone(r102, r104, r116, r7);
        int r118 = k.d;
        r106 = k.a.b();
        goto L277
    L257:
        if (r99.has("contact") == false) goto L259;
        int r119 = k.d;
        r106 = k.a.a("INVALID_CONTACT", "contact is invalid");
        goto L277
    L259:
        r104 = null;
        goto L260
    L535:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L249
        zda.a.a.getClass();     // Catch: Throwable -> L249
        ContactEntity r121 = zda.a.d(r103);     // Catch: Throwable -> L249
        if ((r121 instanceof ContactEntity) == false) goto L246;
        ContactEntity r122 = r121;     // Catch: Throwable -> L249
    L247:
        Object r123 = Result.constructor-impl(r122);     // Catch: Throwable -> L249
    L252:
        if (Result.isFailure-impl(r123) == false) goto L254;
        r123 = null;
    L254:
        r104 = (ContactEntity) r123;
        goto L255
    L246:
        r122 = null;
    L249:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r123 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L252
    L239:
        r102 = r101;
        goto L240
    L278:
        z r125 = z.a;
        JSONObject r126 = r20.d;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r126, "payload");
        JSONObject r127 = r126.optJSONObject("entity");
        if (r127 != null) goto L532;
        int r128 = z.a.d;
        z.a r129 = z.a.C0048a.a("MISSING_ENTITY", "entity is required");
    L339:
        if (r129.a == false) goto L341;
        JSONObject r130 = j(this, r20);
    L342:
        r22.invoke(r130);
        return;
    L341:
        r130 = c(r20, r129.b, r129.c);
        goto L342
    L532:
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L283
        Intrinsics.checkNotNullParameter(r127, "entityJson");     // Catch: Throwable -> L283
        zda.a.a.getClass();     // Catch: Throwable -> L283
        Object r132 = Result.constructor-impl(zda.a.d(r127));     // Catch: Throwable -> L283
    L285:
        Throwable r133 = Result.exceptionOrNull-impl(r132);
        if (r133 != null) goto L334;
        AlarmEntity r134 = (AppEntity) r132;
        IAgentAppIntentIDL r135 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r135 != null) goto L291;
        int r136 = z.a.d;
        r129 = z.a.C0048a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
        goto L339
    L291:
        if ((r134 instanceof AlarmEntity) == false) goto L294;
        r135.showAlarm(r134);
    L332:
        r129 = new z.a(true, "", "");
        goto L339
    L294:
        if ((r134 instanceof CallHistoryEntity) == false) goto L297;
        r135.showCallHistory((CallHistoryEntity) r134);
        goto L332
    L297:
        if ((r134 instanceof ContactEntity) == false) goto L300;
        r135.showContact((ContactEntity) r134);
        goto L332
    L300:
        if ((r134 instanceof CountdownEntity) == false) goto L303;
        r135.showCountdown((CountdownEntity) r134);
        goto L332
    L303:
        if ((r134 instanceof NoteEntity) == false) goto L306;
        r135.showNote((NoteEntity) r134);
        goto L332
    L306:
        if ((r134 instanceof AlbumEntity) == false) goto L309;
        r135.showAlbum((AlbumEntity) r134);
        goto L332
    L309:
        if ((r134 instanceof PhotoEntity) == false) goto L312;
        r135.showPhoto(new PhotoEntity[]{r134}, 0);
        goto L332
    L312:
        if ((r134 instanceof FileEntity) == false) goto L315;
        r135.showFile((FileEntity) r134);
        goto L332
    L315:
        if ((r134 instanceof RecordingEntity) == false) goto L318;
        r135.showRecording((RecordingEntity) r134);
        goto L332
    L318:
        if ((r134 instanceof AuditoryRecordingEntity) == false) goto L321;
        r135.showAuditoryRecording((AuditoryRecordingEntity) r134);
        goto L332
    L321:
        if ((r134 instanceof MessageEntity) == false) goto L324;
        r135.showMessage((MessageEntity) r134);
        goto L332
    L324:
        if ((r134 instanceof ScheduleEntity) == false) goto L327;
        r135.showSchedule((ScheduleEntity) r134);
        goto L332
    L327:
        if ((r134 instanceof ProactiveMemoryEntity) == false) goto L330;
        r135.showProactiveMemory((ProactiveMemoryEntity) r134);
        goto L332
    L330:
        if ((r134 instanceof MemoryEntity) == false) goto L333;
        r135.showMemory((MemoryEntity) r134);
        goto L332
    L333:
        int r137 = z.a.d;
        r129 = z.a.C0048a.a("UNSUPPORTED_ENTITY_TYPE", "unsupported entity type: " + r134.getType());
        goto L339
    L334:
        int r138 = z.a.d;
        String r139 = r133.getMessage();
        if (r139 != null) goto L337;
        r139 = "entity is invalid";
    L337:
        r129 = z.a.C0048a.a("INVALID_ENTITY", r139);
    L283:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r132 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L285
    L419:
        a(r20, "appintent_memory", i.a, r22);
        return;
    L420:
        a(r20, "appintent_message", SetsKt.setOf(101), r22);
        return;
    L421:
        a(r20, "appintent_phone", SetsKt.setOf(Integer.valueOf(ErrorCode.NO_LOGIN)), r22);
        return;
    L422:
        a(r20, "appintent_contact", SetsKt.setOf(Integer.valueOf(ErrorCode.PRIVACY_STATEMENT_NOT_AGREE_ERROR)), r22);
        return;
    L423:
        a(r20, "appintent_alarm", SetsKt.setOf(701), r22);
        return;
    L424:
        c0 r141 = c0.a;
        JSONObject r142 = r20.d;
        r141.getClass();
        Intrinsics.checkNotNullParameter(r142, "payload");
        Object r143 = r142.opt("on");
        if ((r143 instanceof Boolean) == false) goto L428;
        Boolean r144 = (Boolean) r143;
    L431:
        if (r144 == null) goto L455;
        boolean r145 = r144.booleanValue();
        JSONObject r146 = r142.optJSONObject("entity");
        if (r146 != null) goto L534;
        int r147 = c0.a.d;
        c0.a r148 = c0.a.C0046a.a("MISSING_ENTITY", "entity is required");
    L457:
        if (r148.a == false) goto L459;
        JSONObject r149 = j(this, r20);
    L460:
        r22.invoke(r149);
        return;
    L459:
        r149 = c(r20, r148.b, r148.c);
        goto L460
    L534:
        Result.Companion r150 = Result.Companion;     // Catch: Throwable -> L443
        zda.a.a.getClass();     // Catch: Throwable -> L443
        AlarmEntity r151 = zda.a.d(r146);     // Catch: Throwable -> L443
        if ((r151 instanceof AlarmEntity) == false) goto L438;
        AlarmEntity r152 = r151;     // Catch: Throwable -> L443
    L439:
        if (r152 == null) goto L442;
        Object r153 = Result.constructor-impl(r152);     // Catch: Throwable -> L443
    L445:
        Throwable r154 = Result.exceptionOrNull-impl(r153);
        if (r154 != null) goto L451;
        AlarmEntity r155 = (AlarmEntity) r153;
        r155.setEnabled(r145);
        IAgentAppIntentIDL r156 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r156 != null) goto L450;
        int r157 = c0.a.d;
        r148 = c0.a.C0046a.a("AIAGENT_UNAVAILABLE", "aiagent service is unavailable");
        goto L457
    L450:
        r156.turnOnOffAlarm(r155, r145);
        r148 = new c0.a(true, "", "");
        goto L457
    L451:
        int r158 = c0.a.d;
        String r159 = r154.getMessage();
        if (r159 != null) goto L454;
        r159 = "entity is invalid";
    L454:
        r148 = c0.a.C0046a.a("INVALID_ENTITY", r159);
        goto L457
    L442:
        throw new IllegalStateException("entity is not AlarmEntity".toString());     // Catch: Throwable -> L443
    L438:
        r152 = null;
    L443:
        th = move-exception;
        Result.Companion r160 = Result.Companion;
        r153 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L445
    L455:
        int r161 = c0.a.d;
        r148 = c0.a.C0046a.a("MISSING_ON", "on is required");
        goto L457
    L428:
        if ((r143 instanceof String) == false) goto L430;
        r144 = StringsKt.toBooleanStrictOrNull((String) r143);
        goto L431
    L430:
        r144 = null;
        goto L431
    L461:
        String r162 = f(r20.d, "alarm_id");
        if (StringsKt.isBlank(r162) == false) goto L464;
        r22.invoke(c(r20, "MISSING_ALARM_ID", "alarm_id is required"));
        return;
    L464:
        String r163 = f(r20.d, "title");
        if (StringsKt.isBlank(r163) == false) goto L467;
        r163 = "闹钟";
    L467:
        String r164 = f(r20.d, "description");
        JSONObject r165 = r20.d;
        if (r165.has("time") == false) goto L475;
        Object r166 = r165.opt("time");
        if ((r166 instanceof Number) == false) goto L473;
        Long r167 = Long.valueOf(((Number) r166).longValue());
    L476:
        if (r167 != null) goto L478;
        r22.invoke(c(r20, "MISSING_TIME", "time is required"));
        return;
    L478:
        JSONObject r168 = r20.d.optJSONObject("extra_params");
        if (r168 != null) goto L482;
        Map r169 = MapsKt.emptyMap();
    L481:
        Map r170 = r169;
        boolean r171 = com.obric.miniapp.alarm.w.b;
        com.obric.miniapp.alarm.w r172 = com.obric.miniapp.alarm.w.a.b(r167.longValue());
        zka.r.a r173 = zka.r.a;
        AppHost.Companion r174 = AppHost.a;
        Application r175 = r174.getApplication();
        r173.getClass();
        if (zka.r.a.a(r175) == false) goto L496;
        yka.a r176 = yka.a.b;
        if (r176.e(r174.getApplication()) == false) goto L496;
        r176.a(r174.getApplication(), r162, r163, r164, r172, r170, new e(r22, r20));
        return;
    L496:
        AlarmManager r177 = AlarmManager.a;
        Function1 r178 = new f(r22, r20);
        r177.getClass();
        AlarmManager.e(r162, r163, r164, r172, r170, r178);
        return;
    L482:
        Map r179 = MapsKt.createMapBuilder();
        Iterator<String> r180 = r168.keys();
    L484:
        if (r180.hasNext() == false) goto L490;
        String r181 = r180.next();
        Object r182 = r168.opt(r181);
        if (r182 == null) goto L484;
        if (Intrinsics.areEqual(r182, JSONObject.NULL) == true) goto L484;
        Intrinsics.checkNotNull(r181);
        r179.put(r181, r182.toString());
        goto L484
    L490:
        r169 = MapsKt.build(r179);
        goto L481
    L473:
        if ((r166 instanceof String) == false) goto L475;
        r167 = StringsKt.toLongOrNull((String) r166);
    L475:
        r167 = null;
        goto L476
    L497:
        String r183 = f(r20.d, "package_name");
        String r184 = f(r20.d, MemorySourceLinkType.DEEPLINK);
        Context r185 = g(r19);
        if ((!StringsKt.isBlank(r184)) == false) goto L503;
        c r186 = startActivity(r185, new Intent("android.intent.action.VIEW", UriProtector.parse(r184)), "open deeplink", r183);
        if (r186.a == false) goto L503;
    L506:
        r22.invoke(k(r186, r20));
        return;
    L503:
        if (StringsKt.isBlank(r183) == false) goto L505;
        r186 = new c(false, "MISSING_PACKAGE_NAME", "package_name or deeplink is required");
        goto L506
    L505:
        r186 = startActivity(r185, new Intent("android.intent.action.VIEW", UriProtector.parse("market://details?id=" + r183)), "open market detail", r183);
        goto L506
    L507:
        String r187 = f(r20.d, "package_name");
        if (StringsKt.isBlank(r187) == false) goto L511;
        r22.invoke(c(r20, "MISSING_PACKAGE_NAME", "package_name is required"));
        return;
    L511:
        String r188 = r20.c;
        Intrinsics.checkNotNullParameter(r188, "scene");
        if (Intrinsics.areEqual(r188, "appintent_memory") == false) goto L519;
        IObricSettingRouteService r189 = (IObricSettingRouteService) ServiceManager.get().getService(IObricSettingRouteService.class);
        if (r189 != null) goto L517;
        r22.invoke(c(r20, "SERVICE_UNAVAILABLE", "memory data route service is unavailable"));
        return;
    L517:
        r189.d(g(r19));
        r22.invoke(j(this, r20));
        return;
    L519:
        String r190 = f(r20.d, "class_name");
        Context r191 = g(r19);
        if ((!StringsKt.isBlank(r190)) == false) goto L522;
        Intent r192 = new Intent("android.intent.action.MAIN");
        r192.setClassName(r187, r190);
        r192.addFlags(67108864);
    L525:
        r22.invoke(k(startActivity(r191, r192, "open app", r187), r20));
        return;
    L522:
        r192 = r191.getPackageManager().getLaunchIntentForPackage(r187);
        if (r192 != null) goto L525;
        r192 = new Intent("android.intent.action.MAIN");
        r192.setPackage(r187);
        r192.addCategory("android.intent.category.LAUNCHER");
        r192.addFlags(67108864);
        goto L525
    L526:
        String r193 = f(r20.d, "package_name");
        if (StringsKt.isBlank(r193) == false) goto L530;
        r22.invoke(c(r20, "MISSING_PACKAGE_NAME", "package_name is required"));
        return;
    L530:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new IntentCardOperationHelper$dispatch$1(r193, r22, r20, null), 3, null);
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    L20:
        if (Intrinsics.areEqual(r20.c, "appintent_soundrecord") == true) goto L23;
        r22.invoke(c(r20, "INVALID_SCENE", "delete_recordings is restricted to appintent_soundrecord"));
        return;
    L23:
        DeleteEntitiesOperation.a.a(r20.d, SetsKt.setOf(Integer.valueOf(ResultCode.INTERNAL_ERROR)), new d(r22, r20));
        return;
    L82:
        if (Intrinsics.areEqual(r20.c, "appintent_music") == true) goto L85;
        r22.invoke(c(r20, "INVALID_SCENE", "query_music_state is restricted to appintent_music"));
        return;
    L85:
        v.a r194 = v.a.f(h(r19));
        if (r194.a == false) goto L88;
        JSONObject r195 = i(r20, r194.b);
    L89:
        r22.invoke(r195);
        return;
    L88:
        r195 = c(r20, r194.c, r194.d);
        goto L89
    L344:
        if (Intrinsics.areEqual(r20.c, "appintent_music") == false) goto L353;
        String r196 = h(r19);
        if (StringsKt.isBlank(r196) == false) goto L349;
        r22.invoke(c(r20, "MISSING_CARD_ID", "mixture_card_id is required"));
        return;
    L349:
        String r197 = s.d.b(r196);
        if (r197 != null) goto L354;
        r22.invoke(c(r20, "MISSING_MESSAGE_ASSOCIATION", "music card message association is unavailable"));
        return;
    L354:
        x r198 = x.a;
        final Context r199 = g(r19);
        JSONObject r1100 = r20.d;
        WidgetContainer r1101 = (WidgetContainer) r19.d(WidgetContainer.class);
        if (r1101 == null) goto L357;
        String r1102 = r1101.l();
    L358:
        if (r1102 != null) goto L360;
        r1102 = "";
    L360:
        String r1103 = r1102;
        String r1104 = r20.c;
        String r1105 = h(r19);
        r198.getClass();
        Intrinsics.checkNotNullParameter(r199, "context");
        Intrinsics.checkNotNullParameter(r1100, "payload");
        ?? r1106 = new w(r199);
        Intrinsics.checkNotNullParameter(r1100, "payload");
        Intrinsics.checkNotNullParameter(r1106, "openSheet");
        String r200 = r1100.optString("page_data");
        Intrinsics.checkNotNull(r200);
        if ((!StringsKt.isBlank(r200)) == true) goto L364;
        r200 = null;
    L364:
        if (r200 != null) goto L367;
        r200 = "";
    L367:
        if (StringsKt.isBlank(r200) == false) goto L544;
        int r201 = x.a.d;
        x.a r202 = x.a.C0047a.a("MISSING_PAGE_DATA", "page_data is required");
    L415:
        if (r202.a == false) goto L417;
        JSONObject r203 = j(this, r20);
    L418:
        r22.invoke(r203);
        return;
    L417:
        r203 = c(r20, r202.b, r202.a());
        goto L418
    L544:
        Result.Companion r204 = Result.Companion;     // Catch: Throwable -> L371
        Object r205 = Result.constructor-impl(new JSONObject(r200));     // Catch: Throwable -> L371
    L373:
        Throwable r206 = Result.exceptionOrNull-impl(r205);
        if (r206 != null) goto L410;
        JSONObject r207 = (JSONObject) r205;
        JSONArray r208 = new JSONArray();
        JSONArray r209 = r207.optJSONArray("cards");
        if (r209 == null) goto L394;
        int r1107 = r209.length();
        int r1108 = 0;
    L379:
        if (r1108 >= r1107) goto L394;
        JSONObject r1109 = r209.optJSONObject(r1108);
        if (r1109 == null) goto L393;
        JSONArray r210 = r1109.optJSONArray("items");
        if (r210 == null) goto L393;
        int r1110 = r210.length();
    L386:
        if (r5 >= r1110) goto L393;
        JSONObject r211 = r210.optJSONObject(r5);
        JSONArray r1111 = r210;
        if (r211 == null) goto L392;
        JSONObject r212 = r211.optJSONObject("entity");
        if (r212 == null) goto L392;
        r208.put(r212);
    L392:
        r5 = r5 + 1;
        r210 = r1111;
    L393:
        r1108 = r1108 + 1;
        r5 = 0;
    L394:
        String r1112 = r208.toString();
        if (Intrinsics.areEqual(r1112, "[]") == false) goto L397;
        int r213 = x.a.d;
        r202 = x.a.C0047a.a("MISSING_ENTITIES", "page_data contains no entities");
        goto L415
    L397:
        if (r197 != null) goto L405;
        String r214 = r207.optString("local_message_id");
        Intrinsics.checkNotNull(r214);
        if ((!StringsKt.isBlank(r214)) == false) goto L401;
        String r215 = r214;
    L402:
        if (r215 != null) goto L404;
        r197 = "";
        goto L405
    L404:
        r197 = r215;
        goto L405
    L401:
        r215 = null;
    L405:
        String r1113 = r197;
        if (r1104 != null) goto L408;
        String r1114 = "";
    L409:
        r202 = (x.a) r1106.invoke(r1112, r1113, r1103, r1114, r1105);
        goto L415
    L408:
        r1114 = r1104;
        goto L409
    L410:
        int r216 = x.a.d;
        String r217 = r206.getMessage();
        if (r217 != null) goto L413;
        r217 = "page_data is invalid";
    L413:
        r202 = x.a.C0047a.a("INVALID_PAGE_DATA", r217);
    L371:
        th = move-exception;
        Result.Companion r218 = Result.Companion;
        r205 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L373
    L357:
        r1102 = null;
        goto L358
    L353:
        r197 = null;
        goto L354
    }

    public static JSONObject d(String r3, String r4, String r5, String r6, String r7) {
        JSONObject r0 = new JSONObject();
        r0.put("status", -1);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("op", r3);
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r0.put("request_id", r4);
        r0.put("scene", r7);
        r0.put("content", new JSONObject());
        r0.put("error_code", r5);
        r0.put("error_message", r6);
        return r0;
    }

    public static /* synthetic */ JSONObject e(h r0, String r1, String r2, String r3, String r4) {
        r0.getClass();
        return d(r1, r2, r3, r4, "");
    }
}
