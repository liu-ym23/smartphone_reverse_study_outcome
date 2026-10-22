package com.bytedance.android.ec.base.api.ai.conversation;

import android.net.Uri;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/conversation/SchemaResolver;", "", "()V", "TAG", "", "parseAIParams", "Lcom/bytedance/android/ec/base/api/ai/conversation/AIChatSchemaParams;", a.KEY_SCHEMA, "parseOriginBcmId", "uri", "Landroid/net/Uri;", "aiParamsJson", "Lorg/json/JSONObject;", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class SchemaResolver {
    public static final SchemaResolver INSTANCE = null;
    private static final String TAG = "ECSchemaResolver";

    private SchemaResolver() {
    }

    static {
        INSTANCE = new SchemaResolver();
    }

    @JvmStatic
    public static final AIChatSchemaParams parseAIParams(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        Uri r11 = UriProtector.parse(r10);     // Catch: Throwable -> L44
        String r12 = UriProtector.getQueryParameter(r11, ConversationConstants.KEY_AI_PARAMS);     // Catch: Throwable -> L44
        String r13 = null;
        if (r12 != null) goto L16;
    L28:
        JSONObject r14 = null;
    L29:
        if (r14 == null) goto L35;
        String r15 = r14.optString(ConversationConstants.KEY_CONVERSATION_ID);     // Catch: Throwable -> L44
        if (r15 == null) goto L35;
        if ((!StringsKt.isBlank(r15)) == false) goto L35;
    L36:
        if (r14 == null) goto L42;
        String r16 = r14.optString(ConversationConstants.KEY_ORIGIN_MESSAGE_ID);     // Catch: Throwable -> L44
        if (r16 == null) goto L42;
        if ((true ^ StringsKt.isBlank(r16)) == false) goto L42;
        r13 = r16;
    L42:
        return new AIChatSchemaParams(r15, r13, INSTANCE.parseOriginBcmId(r11, r14));
    L35:
        r15 = null;
        goto L36
    L16:
        if ((!StringsKt.isBlank(r12)) == true) goto L19;
        r12 = null;
    L19:
        if (r12 == null) goto L28;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L22
        Object r18 = Result.constructor-impl(new JSONObject(r12));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r18) == false) goto L27;
        r18 = null;
    L27:
        r14 = (JSONObject) r18;     // Catch: Throwable -> L44
    L22:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L44
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L44
    L45:
        return AIChatSchemaParams.EMPTY;
    L11:
        return AIChatSchemaParams.EMPTY;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String parseOriginBcmId(Uri r10, JSONObject r11) {
        if (r11 == null) goto L12;
        String r12 = r11.optString(ConversationConstants.KEY_BCM_ID);
        if (r12 == null) goto L12;
        if ((!StringsKt.isBlank(r12)) == true) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L12;
        return r12;
    L12:
        String r13 = UriProtector.getQueryParameter(r10, ConversationConstants.KEY_ECOM_SAAS_EXTRA);
        if (r13 != null) goto L15;
        return null;
    L15:
        if ((!StringsKt.isBlank(r13)) == true) goto L18;
        r13 = null;
    L18:
        if (r13 == null) goto L37;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L21
        Object r15 = Result.constructor-impl(new JSONObject(r13));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r15) == false) goto L26;
        r15 = null;
    L26:
        JSONObject r16 = (JSONObject) r15;
        if (r16 == null) goto L38;
        String r17 = r16.optString(ConversationConstants.KEY_BCM_ID);
        if (r17 != null) goto L31;
        return null;
    L31:
        if ((!StringsKt.isBlank(r17)) == true) goto L33;
        return null;
    L33:
        return r17;
    L38:
        return null;
    L21:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L37:
        return null;
    }
}
