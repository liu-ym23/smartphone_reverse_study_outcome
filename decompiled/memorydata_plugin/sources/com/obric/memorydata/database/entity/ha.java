package com.obric.memorydata.database.entity;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0016\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010 \u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J \u0010\"\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/database/entity/RawObservationPayloadUtils;", "", "<init>", "()V", "SOURCE_SCREENSHOT", "", "SOURCE_GLASSES", "SOURCE_AUDITORY", "PAYLOAD_TYPE", "PAYLOAD_TYPE_IMAGE", "PAYLOAD_TYPE_ASR", "LEGACY_PAYLOAD_RECORD_TYPE", "PAYLOAD_SCREENSHOT_PATH", "PAYLOAD_IMAGE_TOS_KEY", "PAYLOAD_VIEW_TREE_PATH", "PAYLOAD_LOCAL_SPEAKER_ID", "META_CLIENT_RULE_IDS", "META_PROFILE_ID", "screenshotPath", "entity", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "screenshotPathFromPayload", "payload", "viewTreePath", "viewTreePathFromPayload", "payloadWithImageTosKey", "imageTosKey", "payloadWithScreenshotPath", "payloadWithViewTreePath", "clientRuleIds", "parsePayload", "Lorg/json/JSONObject;", "extractJsonStringField", "key", "upsertJsonStringField", EventBody.KEY_VALUE, "escapeJsonString", "unescapeJsonString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ha f9173a = null;

    static {
        f9173a = new ha();
    }

    private ha() {
    }

    private final String a(String r9, String r10, String r11) {
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r2 = false;
        if (StringsKt.startsWith$default(r12, "{", false, 2, null) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L12;
        r12 = null;
    L12:
        if (r12 == null) goto L14;
        String r8 = Typography.quote + r10 + "\":\"" + d(r11) + Typography.quote;
        Regex r13 = new Regex(Typography.quote + Regex.Companion.escape(r10) + "\"\\s*:\\s*\"(?:\\\\.|[^\"\\\\])*\"");
        if (r13.containsMatchIn((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L18;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.removeSuffix(StringsKt.removePrefix(r12, (CharSequence) ZeusTransformUtils.preCheckCast("{", CharSequence.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("}", CharSequence.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L22;
        r2 = true;
    L22:
        char r15 = '{';
        if (r2 == false) goto L25;
        StringBuilder r16 = new StringBuilder();
    L27:
        return r16.append(r15).append(r8).append('}').toString();
    L25:
        r16 = new StringBuilder().append('{').append(r14);
        r15 = ',';
        goto L27
    L18:
        return r13.replace((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), r8);
    L14:
        return "{\"" + r10 + "\":\"" + d(r11) + "\"}";
    L5:
        if (StringsKt.endsWith$default(r12, "}", false, 2, null) == false) goto L7;
        r3 = true;
        goto L8
    }

    private final String c(String r9, String r10) {
        if (r9 == null) goto L5;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L7:
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return "";
    L15:
        MatchResult r12 = Regex.find$default(new Regex(Typography.quote + Regex.Companion.escape(r10) + "\"\\s*:\\s*\"((?:\\\\.|[^\"\\\\])*)\""), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r12 != null) goto L19;
        return "";
    L19:
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(e((String) ZeusTransformUtils.preCheckCast(r12.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L12:
        r3 = false;
        goto L13
    L5:
        r11 = null;
        goto L7
    }

    private final JSONObject c(String r4) {
        Object r0 = null;
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L24;
        return null;
    L24:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
        ha r6 = (ha) ZeusTransformUtils.preCheckCast(this, ha.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Object r7 = Result.m1421constructorimpl(new JSONObject(r5));     // Catch: Throwable -> L16
    L19:
        if (Result.m1427isFailureimpl(r7) == true) goto L23;
        r0 = r7;
    L23:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r0, JSONObject.class, "com.obric.memorydata.plugin");
    L16:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    L11:
        r2 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    private final String d(String r13) {
        return StringsKt.replace$default(StringsKt.replace$default(r13, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null);
    }

    private final String e(String r13) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r13, "\\/", "/", false, 4, null), "\\\"", "\"", false, 4, null), "\\\\", "\\", false, 4, null);
    }

    public final String a(RawObservationEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return a(r2.getPayload());
    }

    public final String a(String r8) {
        Object r1 = "";
        boolean r3 = true;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L19
        JSONObject r7 = ((ha) ZeusTransformUtils.preCheckCast(this, ha.class, "com.obric.memorydata.plugin")).c(r8);     // Catch: Throwable -> L19
        String r6 = null;
        if (r7 == null) goto L15;
        String r9 = r7.optString("screenshot_path");     // Catch: Throwable -> L19
        if (r9 == null) goto L15;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L19
        if (r10 == null) goto L15;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L15;
        r6 = r10;
        goto L15
    L12:
        r11 = false;
    L15:
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        Object r12 = Result.m1421constructorimpl(r6);     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r12) == true) goto L25;
        r1 = r12;
    L25:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin");
        if (r13.length() == 0) goto L29;
        r3 = false;
    L29:
        if (r3 == false) goto L32;
        r13 = f9173a.c(r8, "screenshot_path");
    L32:
        return (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public final String a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "payload");
        Intrinsics.checkNotNullParameter(r5, "imageTosKey");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r3 = ((ha) ZeusTransformUtils.preCheckCast(this, ha.class, "com.obric.memorydata.plugin")).c(r4);     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        r3 = new JSONObject();     // Catch: Throwable -> L8
    L6:
        r3.put("image_tos_key", r5);     // Catch: Throwable -> L8
        Object r6 = Result.m1421constructorimpl(r3.toString());     // Catch: Throwable -> L8
    L11:
        if (Result.m1424exceptionOrNullimpl(r6) == null) goto L15;
        r6 = f9173a.a(r4, "image_tos_key", r5);
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final String b(RawObservationEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return b(r2.getPayload());
    }

    public final String b(String r8) {
        Object r1 = "";
        boolean r3 = true;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L19
        JSONObject r7 = ((ha) ZeusTransformUtils.preCheckCast(this, ha.class, "com.obric.memorydata.plugin")).c(r8);     // Catch: Throwable -> L19
        String r6 = null;
        if (r7 == null) goto L15;
        String r9 = r7.optString("view_tree_path");     // Catch: Throwable -> L19
        if (r9 == null) goto L15;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L19
        if (r10 == null) goto L15;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L15;
        r6 = r10;
        goto L15
    L12:
        r11 = false;
    L15:
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        Object r12 = Result.m1421constructorimpl(r6);     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r12) == true) goto L25;
        r1 = r12;
    L25:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin");
        if (r13.length() == 0) goto L29;
        r3 = false;
    L29:
        if (r3 == false) goto L32;
        r13 = f9173a.c(r8, "view_tree_path");
    L32:
        return (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public final String b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "payload");
        Intrinsics.checkNotNullParameter(r5, "viewTreePath");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r3 = ((ha) ZeusTransformUtils.preCheckCast(this, ha.class, "com.obric.memorydata.plugin")).c(r4);     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        r3 = new JSONObject();     // Catch: Throwable -> L8
    L6:
        r3.put("view_tree_path", r5);     // Catch: Throwable -> L8
        Object r6 = Result.m1421constructorimpl(r3.toString());     // Catch: Throwable -> L8
    L11:
        if (Result.m1424exceptionOrNullimpl(r6) == null) goto L15;
        r6 = f9173a.a(r4, "view_tree_path", r5);
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final String c(RawObservationEntity r8) {
        Object r1 = "";
        Intrinsics.checkNotNullParameter(r8, "entity");
        boolean r3 = true;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L19
        JSONObject r7 = ((ha) ZeusTransformUtils.preCheckCast(this, ha.class, "com.obric.memorydata.plugin")).c(r8.getMeta());     // Catch: Throwable -> L19
        String r6 = null;
        if (r7 == null) goto L15;
        String r9 = r7.optString("client_rule_ids");     // Catch: Throwable -> L19
        if (r9 == null) goto L15;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L19
        if (r10 == null) goto L15;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L15;
        r6 = r10;
        goto L15
    L12:
        r11 = false;
    L15:
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        Object r12 = Result.m1421constructorimpl(r6);     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r12) == true) goto L25;
        r1 = r12;
    L25:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin");
        if (r13.length() == 0) goto L29;
        r3 = false;
    L29:
        if (r3 == false) goto L32;
        r13 = f9173a.c(r8.getMeta(), "client_rule_ids");
    L32:
        return (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
