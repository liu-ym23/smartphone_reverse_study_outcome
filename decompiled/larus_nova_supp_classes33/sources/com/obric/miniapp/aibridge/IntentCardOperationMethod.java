package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.intent.IntentCardOpType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/IntentCardOperationMethod;", "Lcom/obric/miniapp/aibridge/AbsIntentCardOperationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsIntentCardOperationMethodIDL$IntentCardOperationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsIntentCardOperationMethodIDL$IntentCardOperationResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IntentCardOperationMethod extends AbsIntentCardOperationMethodIDL {
    public IntentCardOperationMethod() {
    }

    public final void handle(e3.d r7, ParamModel r8, f3.h r9) {
        AbsIntentCardOperationMethodIDL.a r10 = (AbsIntentCardOperationMethodIDL.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        com.obric.miniapp.intent.h r2 = com.obric.miniapp.intent.h.a;
        String r11 = r10.getJson();
        i r3 = new i(r9);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "json");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r13 = new JSONObject(r11);     // Catch: Throwable -> L8
        JSONObject r14 = r13.optJSONObject("payload");     // Catch: Throwable -> L8
        if (r14 != null) goto L6;
        r14 = new JSONObject();     // Catch: Throwable -> L8
    L6:
        Object r15 = Result.constructor-impl(new com.obric.miniapp.intent.j(r13.optString("op"), com.obric.miniapp.intent.h.f(r13, "request_id"), com.obric.miniapp.intent.h.f(r13, "scene"), r14));     // Catch: Throwable -> L8
    L10:
        IntentCardOpType r0 = null;
        if (Result.isFailure-impl(r15) == false) goto L13;
        r15 = null;
    L13:
        com.obric.miniapp.intent.j r16 = (com.obric.miniapp.intent.j) r15;
        if (r16 != null) goto L16;
        r3.invoke(com.obric.miniapp.intent.h.d(null, null, "INVALID_JSON", "json is invalid", ""));
        return;
    L16:
        IntentCardOpType.a r1 = IntentCardOpType.Companion;
        String r4 = r16.a;
        r1.getClass();
        if (r4 != null) goto L19;
    L117:
        if (r0 != null) goto L130;
        r3.invoke(com.obric.miniapp.intent.h.d(r16.a, r16.b, "UNSUPPORTED_OP", "unsupported op: " + r16.a, ""));
        return;
    L130:
        r2.b(r7, r16, r0, r3);     // Catch: Throwable -> L121
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L121
    L123:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L136;
        FLogger.a.e("IntentCardOperation", "dispatch failed op=" + r16.a, r18);
        com.obric.miniapp.intent.h r19 = com.obric.miniapp.intent.h.a;
        String r5 = r16.a;
        String r20 = r16.b;
        String r21 = r18.getMessage();
        if (r21 != null) goto L128;
        r21 = "internal error";
    L128:
        r3.invoke(com.obric.miniapp.intent.h.e(r19, r5, r20, "INTERNAL_ERROR", r21));
        return;
    L136:
        return;
    L121:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L123
    L19:
        switch(r4.hashCode()) {
            case -1975487354: goto L114;
            case -1768280717: goto L110;
            case -1734978141: goto L106;
            case -1698677657: goto L102;
            case -1629918030: goto L98;
            case -1593320096: goto L94;
            case -1573756604: goto L90;
            case -1468488036: goto L86;
            case -1332825856: goto L82;
            case -848813714: goto L78;
            case -736997392: goto L74;
            case -504325460: goto L70;
            case -434227523: goto L66;
            case 82016711: goto L62;
            case 133701477: goto L58;
            case 253978550: goto L54;
            case 371217084: goto L50;
            case 634156315: goto L46;
            case 915228724: goto L42;
            case 1099987326: goto L38;
            case 1153626079: goto L34;
            case 1247787042: goto L30;
            case 1920443738: goto L26;
            case 1928092749: goto L22;
            default: goto L117;
        };
    L22:
        if (r4.equals("call_phone") == false) goto L117;
        r0 = IntentCardOpType.CALL_PHONE;
        goto L117
    L26:
        if (r4.equals("play_music") == false) goto L117;
        r0 = IntentCardOpType.PLAY_MUSIC;
        goto L117
    L30:
        if (r4.equals("send_sms") == false) goto L117;
        r0 = IntentCardOpType.SEND_SMS;
        goto L117
    L34:
        if (r4.equals("confirm_message_send") == false) goto L117;
        r0 = IntentCardOpType.CONFIRM_MESSAGE_SEND;
        goto L117
    L38:
        if (r4.equals("open_music_page") == false) goto L117;
        r0 = IntentCardOpType.OPEN_MUSIC_PAGE;
        goto L117
    L42:
        if (r4.equals("set_alarm") == false) goto L117;
        r0 = IntentCardOpType.SET_ALARM;
        goto L117
    L46:
        if (r4.equals("open_sms_composer") == false) goto L117;
        r0 = IntentCardOpType.OPEN_SMS_COMPOSER;
        goto L117
    L50:
        if (r4.equals("open_view_all_sheet") == false) goto L117;
        r0 = IntentCardOpType.OPEN_VIEW_ALL_SHEET;
        goto L117
    L54:
        if (r4.equals("delete_recordings") == false) goto L117;
        r0 = IntentCardOpType.DELETE_RECORDINGS;
        goto L117
    L58:
        if (r4.equals("show_entity") == false) goto L117;
        r0 = IntentCardOpType.SHOW_ENTITY;
        goto L117
    L62:
        if (r4.equals("delete_call_history") == false) goto L117;
        r0 = IntentCardOpType.DELETE_CALL_HISTORY;
        goto L117
    L66:
        if (r4.equals("delete_alarm") == false) goto L117;
        r0 = IntentCardOpType.DELETE_ALARM;
        goto L117
    L70:
        if (r4.equals("open_app") == false) goto L117;
        r0 = IntentCardOpType.OPEN_APP;
        goto L117
    L74:
        if (r4.equals("show_photo_group") == false) goto L117;
        r0 = IntentCardOpType.SHOW_PHOTO_GROUP;
        goto L117
    L78:
        if (r4.equals("query_app_icon") == false) goto L117;
        r0 = IntentCardOpType.QUERY_APP_ICON;
        goto L117
    L82:
        if (r4.equals("query_music_state") == false) goto L117;
        r0 = IntentCardOpType.QUERY_MUSIC_STATE;
        goto L117
    L86:
        if (r4.equals("pause_music") == false) goto L117;
        r0 = IntentCardOpType.PAUSE_MUSIC;
        goto L117
    L90:
        if (r4.equals("open_app_detail") == false) goto L117;
        r0 = IntentCardOpType.OPEN_APP_DETAIL;
        goto L117
    L94:
        if (r4.equals("delete_messages") == false) goto L117;
        r0 = IntentCardOpType.DELETE_MESSAGES;
        goto L117
    L98:
        if (r4.equals("show_weather") == false) goto L117;
        r0 = IntentCardOpType.SHOW_WEATHER;
        goto L117
    L102:
        if (r4.equals("delete_contacts") == false) goto L117;
        r0 = IntentCardOpType.DELETE_CONTACTS;
        goto L117
    L106:
        if (r4.equals("turn_on_off_alarm") == false) goto L117;
        r0 = IntentCardOpType.TURN_ON_OFF_ALARM;
        goto L117
    L110:
        if (r4.equals("delete_memories") == false) goto L117;
        r0 = IntentCardOpType.DELETE_MEMORIES;
        goto L117
    L114:
        if (r4.equals("query_privileged_image") == false) goto L117;
        r0 = IntentCardOpType.QUERY_PRIVILEGED_IMAGE;
    L8:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
