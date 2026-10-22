package com.ss.android.lark.conditional.access.network.model.response;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.util.f;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import m8b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final c b(DecisionData.Action r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r3 = null;
        Integer r4 = null;
        if (r7.getParams().get("deviceChallenge") != null) goto L40;
    L37:
        m8b.a r8 = null;
        String r0 = null;
        String r2 = null;
    L39:
        return new c(r4, r2, r8, r0);
    L40:
        JsonObject r9 = ((JsonElement) f.a(r7.getParams().get("deviceChallenge"), JsonElement.class)).getAsJsonObject();     // Catch: Exception -> L6
    L8:
        if (r9 == null) goto L37;
        JsonElement r1 = a("challengeType", r9);
        if (r1 == null) goto L12;
        Integer r5 = Integer.valueOf(r1.getAsInt());
    L13:
        JsonElement r6 = a(Keys.API_RETURN_KEY_NONCE, r9);
        if (r6 == null) goto L16;
        r2 = r6.getAsString();
    L17:
        JsonElement r10 = a("tokenChallengeCode", r9);
        if (r10 == null) goto L20;
        r3 = r10.getAsString();
    L20:
        JsonElement r11 = a("certInfo", r9);
        if (r11 == null) goto L24;
        String r12 = r11.getAsString();
        if (r12 == null) goto L24;
    L25:
        boolean r13 = false;
        if (r12.length() <= 0) goto L28;
        boolean r14 = true;
    L29:
        if (r14 == true) goto L42;
    L36:
        r8 = new m8b.a(r13);
        r0 = r3;
        r4 = r5;
        goto L39
    L42:
        JsonElement r15 = ((JsonObject) f.a(r12, JsonObject.class)).get("needCertVerify");     // Catch: Exception -> L34
        if (r15 == null) goto L36;
        r13 = r15.getAsBoolean();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        int r16 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_Action", "parseToDeviceChallenge parse certInfo error! " + ExceptionsKt.stackTraceToString(e));
        goto L36
    L28:
        r14 = false;
    L24:
        r12 = BuildConfig.FLAVOR;
        goto L25
    L16:
        r2 = null;
        goto L17
    L12:
        r5 = null;
    L6:
        e = move-exception;
        int r17 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_Action", "parseToDeviceChallenge get deviceChallenge error! " + ExceptionsKt.stackTraceToString(e));
        r9 = null;
        goto L8
    }

    public static final JsonElement a(String r2, JsonObject r3) {
        JsonElement r4 = r3.get(r2);     // Catch: Exception -> L5
        if (r4.isJsonPrimitive() == false) goto L11;
        return r4;
    L11:
        return null;
    L5:
        e = move-exception;
        int r0 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_Action", "parseToDeviceChallenge get " + r2 + " error! " + ExceptionsKt.stackTraceToString(e));
        return null;
    }
}
