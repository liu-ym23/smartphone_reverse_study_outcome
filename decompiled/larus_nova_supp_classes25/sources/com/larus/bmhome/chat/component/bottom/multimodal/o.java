package com.larus.bmhome.chat.component.bottom.multimodal;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.action.DirectSendData;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/component/bottom/multimodal/MultimodalDataKt$toDirectSendData$data$1$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    public static final Integer a(n r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        String r3 = r2.d.get("camera_type");     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        Integer r4 = StringsKt.toIntOrNull(r3);     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == true) goto L16;
        r0 = r5;
    L16:
        return (Integer) r0;
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static final String b(n r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.d.get("scene");
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    @Deprecated(message = "Temporary")
    public static final DirectSendData c(n r15) {
        Intrinsics.checkNotNullParameter(r15, "<this>");
        FLogger.a.i("MultimodalData", "[toDirectSendData] origin:" + r15.c);
        DirectSendData r2 = null;
        Object r3 = null;
        if (r15.b.a == true) goto L62;
        h1 r1 = r15.c;
        if (r1 == null) goto L8;
        String r6 = r1.a;
    L9:
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map<String, String> r4 = r1.c;
        if (r4 == null) goto L13;
        String r5 = r4.get("enter_method");
    L14:
        String r7 = r5;
    L16:
        h1 r8 = r15.c;
        if (r8 == null) goto L25;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Map<String, String> r9 = r8.c;
        if (r9 == null) goto L21;
        String r10 = r9.get("scene_for_text");
    L22:
        if (r10 == null) goto L25;
        String r11 = r10;
    L33:
        h1 r0 = r15.c;
        if (r0 == null) goto L36;
        Map<String, String> r12 = r0.b;
    L64:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L55
        if (r0 == null) goto L45;
        Map<String, String> r14 = r0.c;     // Catch: Throwable -> L55
        if (r14 == null) goto L45;
        String r16 = r14.get("direct_send_data_event_ext");     // Catch: Throwable -> L55
        if (r16 == null) goto L45;
        Map<String, String> r17 = (Map) new Gson().fromJson(r16, new a().getType());     // Catch: Throwable -> L55
        if (r17 == null) goto L45;
    L53:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r18) == true) goto L61;
        r3 = r18;
    L61:
        r2 = new DirectSendData(r6, r7, r12, r11, (Map) r3, null, false, 96, null);
    L45:
        h1 r19 = r15.c;     // Catch: Throwable -> L55
        if (r19 == null) goto L52;
        Map<String, String> r20 = r19.c;     // Catch: Throwable -> L55
        if (r20 == null) goto L52;
        if (r20.get("direct_use_text_message_event_ext") == null) goto L52;
        r17 = r15.c.c;     // Catch: Throwable -> L55
    L52:
        r17 = MapsKt.emptyMap();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L36:
        r12 = null;
        goto L64
    L21:
        r10 = null;
    L25:
        h1 r22 = r15.c;
        if (r22 == null) goto L32;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Map<String, String> r23 = r22.c;
        if (r23 == null) goto L30;
        String r24 = r23.get("scene");
    L31:
        r11 = r24;
        goto L33
    L30:
        r24 = null;
        goto L31
    L32:
        r11 = null;
        goto L33
    L13:
        r5 = null;
        goto L14
    L15:
        r7 = null;
        goto L16
    L8:
        r6 = null;
    L62:
        FLogger.a.i("MultimodalData", "[toDirectSendData] res:" + r2);
        return r2;
    }

    @Deprecated(message = "Temporary")
    public static final h1 d(DirectSendData r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        FLogger r0 = FLogger.a;
        r0.i("MultimodalData", "[toMultimodalTextMessageData] origin:" + r8);
        String r1 = r8.getDisplayName();
        Map r3 = r8.getMsgExtMap();
        LinkedHashMap r4 = new LinkedHashMap();
        Map r5 = r8.getEventExtra();
        if (r5 == null) goto L7;
        r4.put("direct_send_data_event_ext", GsonProtectorUtils.toJson(new Gson(), r5));
        if (r5.get("direct_use_text_message_event_ext") == null) goto L7;
        r4.putAll(r5);
    L7:
        String r6 = r8.getEnterMethod();
        if (r6 == null) goto L10;
        String r7 = (String) r4.put("enter_method", r6);
    L10:
        String r9 = r8.getSceneForText();
        if (r9 == null) goto L13;
        r4.put("scene", r9);
    L13:
        Unit r10 = Unit.INSTANCE;
        h1 r11 = new h1(r1, r3, r4);
        r0.i("MultimodalData", "[toMultimodalTextMessageData] res:" + r11);
        return r11;
    }
}
