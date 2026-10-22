package com.obric.memorydata.middleware.impl.image;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonObject;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.HttpMethod;
import com.obric.memorydata.middleware.api.bridge.HttpRequest;
import com.obric.memorydata.middleware.api.bridge.NetworkBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.Response;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020\u0005H\u0002J\u000e\u0010%\u001a\u0004\u0018\u00010\u0018*\u00020&H\u0002J\u0016\u0010'\u001a\u0004\u0018\u00010\u0005*\u00020&2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0012\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXPrepareUploadClient;", "", "<init>", "()V", "TAG", "", "DOUBAO_API_BASE_URL", "PATH_PREPARE_UPLOAD", "RESOURCE_TYPE_FILE", "", "RESOURCE_TYPE_IMAGE", "RESOURCE_TYPE_AUDIO", "SCENE_ID", "AUDITORY_SCENE_ID", "TENANT_ID", "HEADER_X_TT_TOKEN", "HEADER_SDK_VERSION", "SDK_VERSION", "ISO_TIME_PATTERN", "MILLIS_THRESHOLD", "", "lastErrorMessage", "getLastErrorMessage", "fetchAssistantFeedbackImageToken", "Lcom/obric/memorydata/middleware/impl/image/ImageXToken;", "fetchAssistantFeedbackFileToken", "fetchAuditoryMemoryAudioToken", "auditoryMemoryRequestBodyForTest", "Lcom/google/gson/JsonObject;", "auditoryMemoryRequestBodyForTest$middleware_impl_obricRelease", "fetchAssistantFeedbackToken", "resourceType", "fetchToken", "sceneId", "buildRequestBody", "fail", "message", "toImageXToken", "Lorg/json/JSONObject;", "nonBlankString", "key", "parseEpochSeconds", EventBody.KEY_VALUE, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f11730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f11731b;

    static {
        f11730a = new f();
    }

    private f() {
    }

    private final i a(int r2) {
        return a(r2, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED);
    }

    private final i a(int r24, String r25) {
        f r0 = this;
        f11731b = null;
        String r3 = AppContext.INSTANCE.getToken();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L10;
        r0 = (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin");
        String r1 = "prepare_upload requires a logged-in account";
    L9:
        return r0.a(r1);
    L10:
        Response r2 = NetworkBridgeAPI.INSTANCE.sendRequest(new HttpRequest(HttpMethod.POST, "https://api-normal.doubao.com", "/alice/resource/prepare_upload", false, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Tt-Token", r3), TuplesKt.to("Sdk-Version", "2")}), b(r24, r25), 0, 0, 0, 912, null));
        if (r2.getCode() == 0) goto L44;
        String r4 = r2.getMsg();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L18;
        String r5 = StringsKt.take(r4, 160);
    L19:
        JSONObject r6 = r2.getExtras();
        if (r6 == null) goto L28;
        JSONObject r7 = r6.optJSONObject("headers");
        if (r7 == null) goto L28;
        String r8 = r7.optString("x-tt-logid");
        if (r8 == null) goto L28;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L28;
    L29:
        StringBuilder r9 = new StringBuilder().append("prepare_upload failed (code=").append(r2.getCode());
        if (r5 == null) goto L32;
        String r10 = ", msg=" + r5;
    L33:
        String r11 = "";
        if (r10 != null) goto L36;
        r10 = "";
    L36:
        StringBuilder r12 = r9.append(r10);
        if (r8 == null) goto L39;
        String r13 = ", logId=" + r8;
    L40:
        if (r13 == null) goto L43;
        r11 = r13;
    L43:
        r1 = r12.append(r11).append(')').toString();
        goto L9
    L39:
        r13 = null;
        goto L40
    L32:
        r10 = null;
    L28:
        r8 = null;
        goto L29
    L18:
        r5 = null;
        goto L19
    L44:
        JSONObject r14 = r2.getData();
        if (r14 == null) goto L49;
        i r15 = r0.a(r14);
        if (r15 == null) goto L49;
        return r15;
    L49:
        return ((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin")).a("prepare_upload returned invalid token data");
    }

    private final i a(String r7) {
        f11731b = r7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageXPrepareUpload", r7, null, 4, null);
        return null;
    }

    private final i a(JSONObject r15) {
        JSONObject r0 = r15.optJSONObject("upload_auth_token");
        if (r0 != null) goto L5;
        return null;
    L5:
        String r4 = a(r0, "access_key");
        if (r4 != null) goto L8;
        return null;
    L8:
        String r5 = a(r0, "secret_key");
        if (r5 != null) goto L11;
        return null;
    L11:
        String r6 = a(r0, "session_token");
        if (r6 != null) goto L14;
        return null;
    L14:
        long r2 = b(a(r0, "expired_time"));
        long r7 = b(a(r0, "current_time"));
        String r11 = a(r15, "service_id");
        if (r11 != null) goto L17;
        return null;
    L17:
        String r12 = a(r15, "upload_host");
        if (r12 != null) goto L21;
        return null;
    L21:
        if (r2 > r7) goto L23;
    L27:
        return null;
    L23:
        if (r7 <= 0) goto L27;
        long r9 = System.currentTimeMillis() / ((long) 1000);
        return new i(r4, r5, r6, (r2 + r9) - r7, r9, r11, r12, a(r15, "upload_path_prefix"));
    }

    private final String a(JSONObject r1, String r2) {
        String r0 = r1.optString(r2);
        Intrinsics.checkNotNull(r0);
        boolean r3 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L7:
        r3 = false;
    L8:
        if (r3 == true) goto L12;
        return null;
    L12:
        return r0;
    L5:
        if (Intrinsics.areEqual(r0, "null") == true) goto L7;
        goto L7
    }

    private final long b(String r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return 0;
    L12:
        Long r2 = StringsKt.toLongOrNull(r8);
        if (r2 == null) goto L31;
        long r7 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r7 >= 10000000000L) goto L17;
        return r7;
    L17:
        return r7 / ((long) 1000);
    L31:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L24
        f r9 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        SimpleDateFormat r10 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.US);     // Catch: Throwable -> L24
        r10.setLenient(false);     // Catch: Throwable -> L24
        Date r11 = r10.parse(r8);     // Catch: Throwable -> L24
        if (r11 == null) goto L21;
        long r12 = r11.getTime() / ((long) 1000);     // Catch: Throwable -> L24
    L22:
        Object r13 = Result.m1421constructorimpl(Long.valueOf(r12));     // Catch: Throwable -> L24
    L27:
        if (Result.m1427isFailureimpl(r13) == false) goto L30;
        r13 = 0L;
    L30:
        return ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue();
    L21:
        r12 = 0;
    L24:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L27
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final JsonObject b(int r3, String r4) {
        JsonObject r2 = new JsonObject();
        r2.addProperty("resource_type", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r3), Number.class, "com.obric.memorydata.plugin"));
        r2.addProperty("scene_id", r4);
        r2.addProperty("tenant_id", "4");
        return r2;
    }

    public final String a() {
        return f11731b;
    }

    public final i b() {
        return a(2);
    }

    public final i c() {
        return a(1);
    }

    public final i d() {
        return a(3, "145");
    }
}
