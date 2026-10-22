package com.obric.assistant.chat.menu;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.structures.SAMICoreFlowMarkQueryTag;
import com.mammon.audiosdk.structures.SAMICoreHttpCommonContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import m58.h;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final Lazy a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AsrFeedBack.values().length];
            r0[AsrFeedBack.ToDouBao.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AsrFeedBack.NotToDouBao.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = LazyKt.lazy(new d());
    }

    public static boolean a(Context r19, ot8.a r20, Message r21, String r22, long r23) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "item");
        Intrinsics.checkNotNullParameter(r21, "message");
        String r3 = null;
        if ((r20 instanceof l0) == false) goto L5;
        l0 r1 = (l0) r20;
    L7:
        if (r1 != null) goto L10;
        return false;
    L10:
        switch(r1.a) {
            case -1360002: goto L13;
            case -1360001: goto L12;
            default: goto L11;
        };
    L11:
        return false;
    L12:
        int r5 = 1;
    L15:
        if (r1.p == true) goto L18;
        s.a.getClass();
        s.s(r19, 2131912267);
        return true;
    L18:
        Map r0 = r21.getExt();
        if (r0 == null) goto L21;
        String r2 = (String) r0.get("o_user_asr_feedback");
    L22:
        AsrFeedBack r6 = AsrFeedBack.ToDouBao;
        if (Intrinsics.areEqual(r2, r6.getValue()) == false) goto L28;
        if (r5 != 1) goto L26;
        AsrFeedBack r4 = AsrFeedBack.Reset;
    L27:
        String r7 = r4.getValue();
    L36:
        int r10 = CastIntegerProtector.parseInt(r7);
        Map r8 = r21.getExt();
        if (r8 == null) goto L39;
        String r9 = (String) r8.get("o_user_asr_feedback");
    L40:
        if (r9 == null) goto L49;
        Iterator r11 = AsrFeedBack.getEntries().iterator();
    L43:
        if (r11.hasNext() == false) goto L47;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((AsrFeedBack) r12).getValue(), r9) == false) goto L43;
    L48:
        AsrFeedBack r13 = (AsrFeedBack) r12;
    L50:
        AsrFeedBack r14 = AsrFeedBack.ToDouBao;
        if (r13 != r14) goto L55;
        if (r5 != 1) goto L55;
    L57:
        int r15 = 1;
    L59:
        if (r13 != null) goto L61;
        int r16 = -1;
    L62:
        if (r16 != 1) goto L64;
        if (r5 != 1) goto L74;
        AsrFeedBack r17 = AsrFeedBack.Reset;
    L75:
        String r18 = r17.getValue();
    L76:
        String r24 = r18;
        SAMICoreFlowMarkQueryTag r25 = new SAMICoreFlowMarkQueryTag();
        String r26 = NameKeys.UnloadStrategy_No_Strategy;
        if (r22 != null) goto L79;
        String r110 = NameKeys.UnloadStrategy_No_Strategy;
    L80:
        r25.callAsrId = r110;
        r25.messageId = r21.getMessageId();
        AccountService r111 = AccountService.a;
        r25.userId = r111.getUserId();
        r25.isToDoubao = r5;
        r25.isReset = r15;
        JSONObject r27 = new JSONObject();
        r27.put("o_user_asr_feedback", r24);
        Map r28 = r21.getExt();
        if (r28 == null) goto L83;
        String r29 = (String) r28.get("obric_continuous_task_id");
    L84:
        if (r29 != null) goto L86;
        r29 = NameKeys.UnloadStrategy_No_Strategy;
    L86:
        r27.put("task_id", r29);
        String r30 = com.larus.bmhome.chat.bean.d.H(r21);
        if (r30 != null) goto L89;
        r30 = NameKeys.UnloadStrategy_No_Strategy;
    L89:
        r27.put("query_content", r30);
        r25.extra = r27.toString();
        FLogger.a.d("UserAsrFeedbackUtils", "callAsrId: " + r25.callAsrId + ", messageId: " + r25.messageId + ", userId: " + r25.userId + ", isToDoubao: " + r25.isToDoubao);
        SAMICoreProperty r31 = new SAMICoreProperty();
        r31.id = SAMICorePropertyId.SAMICorePropertyId_Http_Common_Request_Flow_Mark_Query_Type;
        r31.type = SAMICoreDataType.SAMICoreDataType_Http_Common_Request_Flow_Mark_Query_Type;
        r31.dataObjectArray = new SAMICoreFlowMarkQueryTag[]{r25};
        r31.dataArrayLen = 1;
        SAMICoreHttpCommonContextCreateParameter r32 = new SAMICoreHttpCommonContextCreateParameter();
        r32.url = "https://audio.doubao.com/internal/api/v1/invoke";
        r32.appKey = "NTIQXNbrFj";
        r32.tokenType = SAMICoreTokenType.TOKEN_TO_C_D;
        r32.apiNamespace = "AudioDataManager";
        x58.a r33 = h.a;
        if (r33 == null) goto L105;
        String r34 = r33.b;
        if (r34 == null) goto L105;
        if (StringsKt.isBlank(r34) == true) goto L115;
        r3 = r34;
        goto L105
    L115:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L97
        JSONObject r36 = new JSONObject();     // Catch: Throwable -> L97
        r36.put("Passport-Auth", "session");     // Catch: Throwable -> L97
        r36.put("sdk-version", RiskPreferenceSettings.SMART_BALANCE);     // Catch: Throwable -> L97
        r36.put("X-tt-Token", r111.getXTTToken());     // Catch: Throwable -> L97
        Object r37 = Result.constructor-impl(r36.toString());     // Catch: Throwable -> L97
    L100:
        if (Result.exceptionOrNull-impl(r37) == null) goto L103;
        r37 = NameKeys.UnloadStrategy_No_Strategy;
    L103:
        r3 = (String) r37;
    L97:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L105:
        r32.token = r3;
        x58.a r39 = h.a;
        if (r39 == null) goto L111;
        String r40 = r39.c;
        if (r40 == null) goto L111;
        r26 = r40;
    L111:
        r32.header = r26;
        int r41 = ((SAMICore) a.getValue()).SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_HTTP_COMMON, r32);
        FLogger.a.i("UserAsrFeedbackUtils", "Create SAMICoreIdentify_HTTP_COMMON handle, ret " + r41);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new UserAsrFeedbackUtils$asrUserFeedback$1(r21, r15, r31, r24, null), 3, null);
        IAIChatControlTraceService r42 = (IAIChatControlTraceService) ServiceManager.get().getService(IAIChatControlTraceService.class);
        if (r42 == null) goto L114;
        r42.Va(r10, r23);
    L114:
        return true;
    L83:
        r29 = null;
        goto L84
    L79:
        r110 = r22;
        goto L80
    L74:
        r17 = AsrFeedBack.NotToDouBao;
        goto L75
    L64:
        if (r16 == 2) goto L69;
        if (r5 == 1) goto L68;
        r14 = AsrFeedBack.NotToDouBao;
    L68:
        r18 = r14.getValue();
        goto L76
    L69:
        if (r5 != 0) goto L71;
        r14 = AsrFeedBack.Reset;
    L71:
        r18 = r14.getValue();
        goto L76
    L61:
        r16 = a.a[r13.ordinal()];
    L55:
        if (r13 != AsrFeedBack.NotToDouBao) goto L58;
        if (r5 == 0) goto L57;
    L58:
        r15 = 0;
        goto L59
    L47:
        r12 = null;
        goto L48
    L49:
        r13 = null;
        goto L50
    L39:
        r9 = null;
        goto L40
    L26:
        r4 = AsrFeedBack.NotToDouBao;
        goto L27
    L28:
        AsrFeedBack r43 = AsrFeedBack.NotToDouBao;
        if (Intrinsics.areEqual(r2, r43.getValue()) == false) goto L33;
        if (r5 != 0) goto L32;
        r7 = "4";
        goto L36
    L32:
        r7 = r6.getValue();
        goto L36
    L33:
        if (r5 != 1) goto L35;
        r7 = r6.getValue();
        goto L36
    L35:
        r7 = r43.getValue();
        goto L36
    L21:
        r2 = null;
        goto L22
    L13:
        r5 = 0;
        goto L15
    L5:
        r1 = null;
        goto L7
    }
}
