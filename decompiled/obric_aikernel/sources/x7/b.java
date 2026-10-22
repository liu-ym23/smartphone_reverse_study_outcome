package x7;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.util.Base64;
import android.util.Log;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.d;
import com.google.gson.i;
import com.google.gson.k;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.common.CloudModelRequest;
import com.obric.aikernel.model.cloud.common.CommonNetworkImpl;
import com.obric.aikernel.model.cloud.common.c;
import com.obric.aikernel.model.cloud.common.e;
import com.obric.aikernel.model_decrypt.api.IDecryptFeature;
import com.obric.aikernel.model_decrypt.api.IDecryptFeatureKt;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.utils.g;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends CloudModelRequest {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f13571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13572h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: x7.b$b, reason: collision with other inner class name */
    public static final class CallableC0317b implements Callable<AssetFileDescriptor> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptor f13573c;

        CallableC0317b(ParcelFileDescriptor r10) {
            this.f13573c = r10;
        }

        public AssetFileDescriptor a() {
            return new AssetFileDescriptor(this.f13573c, 0, -1);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ AssetFileDescriptor call() {
            return a();
        }
    }

    static {
        new a(null);
    }

    public b(Context r10, String r11, String r12, RequestParams r13, com.obric.aikernel.b r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bizName");
        Intrinsics.checkNotNullParameter(r12, "version");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        super(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void g(int r10, int r11, int r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        j(r10, r11, r12, r13, r14, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Bundle h() {
        String r10 = a() + '_' + d().getBackend().getString("version");
        Map<String, Object> r11 = new LinkedHashMap();
        Map<String, String> r12 = new LinkedHashMap();
        Parcelable r13 = d().getBackend().getParcelable("transparent");
        if ((r13 instanceof SharedMemory) == false) goto L5;
        SharedMemory r14 = (SharedMemory) r13;
    L6:
        String r15 = "";
        if (r14 == null) goto L17;
        StringBuilder r16 = new StringBuilder();
        d r17 = new d();
        ByteBuffer r18 = r14.mapReadOnly().asReadOnlyBuffer();
        r16.append("jsonSize:" + r18.limit() + ' ');
        byte[] r19 = new byte[r18.limit()];
        r18.rewind();
        r18.get(r19);
        k r20 = (k) r17.k(StringsKt.decodeToString(r19), k.class);
        String r21 = r20.s("path").h();
        Intrinsics.checkNotNullExpressionValue(r21, "json.get(\"path\").asString");
        Set<Map.Entry<String, i>> r110 = r20.s("header").e().r();
        Intrinsics.checkNotNullExpressionValue(r110, "json.get(\"header\").asJsonObject.entrySet()");
        LinkedHashMap r111 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r110, 10)), 16));
        Iterator<T> r112 = r110.iterator();
    L10:
        if (r112.hasNext() == false) goto L12;
        Map.Entry r113 = (Map.Entry) r112.next();
        Pair r22 = new Pair(r113.getKey(), ((i) r113.getValue()).h());
        r111.put(r22.getFirst(), r22.getSecond());
        goto L10
    L12:
        Set<Map.Entry<String, i>> r23 = r20.s("query").e().r();
        Intrinsics.checkNotNullExpressionValue(r23, "json.get(\"query\").asJsonObject.entrySet()");
        Map r114 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r23, 10)), 16));
        Iterator<T> r24 = r23.iterator();
    L14:
        if (r24.hasNext() == false) goto L16;
        Map.Entry r115 = (Map.Entry) r24.next();
        Pair r116 = new Pair(r115.getKey(), ((i) r115.getValue()).h());
        r114.put(r116.getFirst(), r116.getSecond());
        goto L14
    L16:
        k r25 = r20.s("body").e();
        Intrinsics.checkNotNullExpressionValue(r25, "json.get(\"body\").asJsonObject");
        r16.append("path:" + r21 + ' ');
        d().getBackend().putString("debugPrompt", r16.toString());
        String r26 = r21;
        r12 = r111;
        Object r27 = r25;
    L19:
        if (d().getBackend().containsKey("cloud_research_model") == false) goto L21;
        Log.i("ModelCenterRequest", "request args is: " + d().getBackend() + " request body is: " + r27);
    L21:
        Bundle r117 = new Bundle();
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L33
    L30:
        th = move-exception;
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, d().getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L24:
        if (Intrinsics.areEqual(r12.get("X-Ocean-Encrypted"), NetConst.ENCRYPT_VERISON_CODE) == false) goto L27;
        JSONObject r28 = com.obric.aikernel.utils.i.b(r11);     // Catch: Throwable -> L30
        IDecryptFeature r29 = IDecryptFeatureKt.getDecryptFeature();     // Catch: Throwable -> L30
        String r30 = r28.toString();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r30, "bodyJson.toString()");     // Catch: Throwable -> L30
        String r31 = r29.dataEncrypt(r30);     // Catch: Throwable -> L30
        k r32 = new k();     // Catch: Throwable -> L30
        r32.p("encrypted_body", r31);     // Catch: Throwable -> L30
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, d().getBackend(), ApiPerfDetails.onStartVmRun, false, 2, null);     // Catch: Throwable -> L30
        e r33 = CommonNetworkImpl.f4638a.m();     // Catch: Throwable -> L30
        Object r34 = r32;
    L26:
        c r35 = r33.a(r26, r34, r114, r12);     // Catch: Throwable -> L30
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, d().getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);     // Catch: Throwable -> L33
        Object r36 = Result.m32constructorimpl(r35);     // Catch: Throwable -> L33
    L36:
        if (Result.m39isSuccessimpl(r36) == false) goto L91;
        c r37 = (c) r36;
        String r119 = r37.b();
        if (r119 != null) goto L40;
        r119 = "{}";
    L40:
        JSONObject r120 = new JSONObject(r119);
        Map<String, String> r121 = r37.d();
        if (r121 == null) goto L53;
        String r38 = r121.get("x-tt-logid");
        if (r38 == null) goto L53;
        if (r38.length() <= 0) goto L47;
        boolean r122 = true;
    L48:
        if (r122 == true) goto L51;
        r38 = null;
    L51:
        if (r38 == null) goto L53;
        r117.putString("log_id", r38);
        ApiPerfDetails.Companion.b(d().getBackend()).putString("log_id", r38);
    L55:
        if (Intrinsics.areEqual(r12.get("X-Ocean-Encrypted"), NetConst.ENCRYPT_VERISON_CODE) == true) goto L57;
        JSONObject r39 = r120.optJSONObject("data");
        if (r39 == null) goto L81;
        String r40 = r39.optString("text");
    L82:
        if (r40 != null) goto L84;
        String r41 = "";
    L85:
        AIKLog r42 = AIKLog.INSTANCE;
        StringBuilder r43 = new StringBuilder();
        r43.append("run modelCenter ");
    L86:
        r43.append(r10);
        r43.append(' ');
        r43.append(d().getTraceIdStr());
        r43.append(" status:");
        r43.append(r37.f());
        r43.append(" logid:");
        r43.append(r38);
        r43.append(" message:");
        r43.append(r37.e());
        r43.append(" resp:");
        r43.append(r120.optJSONObject("resp"));
        r42.i("ModelCenterRequest", r43.toString());
        Bundle r44 = r117;
        e8.a.v(r44, r41, com.obric.aikernel.model.cloud.common.d.a(r37), r37.e());
        Bundle r45 = ApiPerfDetails.Companion.b(d().getBackend());
        JSONObject r46 = r120.optJSONObject("resp");
        if (r46 == null) goto L89;
        long r47 = r46.optLong("server_time");
    L90:
        r45.putLong("server_time", r47);
        r15 = r38;
    L92:
        Throwable r48 = Result.m35exceptionOrNullimpl(r36);
        if (r48 == null) goto L95;
        AIKLog.INSTANCE.e("ModelCenterRequest", "run modelCenter " + r10 + " error logid:" + r15 + " traceid:[" + d().getTraceIdStr() + "] " + ExceptionsKt.stackTraceToString(r48));
        e8.a.z(r44, 110, ExceptionsKt.stackTraceToString(r48), true);
    L95:
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, d().getBackend(), ApiPerfDetails.onCallbackClient, false, 2, null);
        b().j2(r44);
        return r44;
    L89:
        r47 = 0;
        goto L90
    L84:
        Intrinsics.checkNotNullExpressionValue(r40, "res.optJSONObject(\"data\")?.optString(\"text\") ?: \"\"");
        r41 = r40;
        goto L85
    L81:
        r40 = null;
        goto L82
    L57:
        if (r120.has("encrypted_body") == false) goto L59;
        String r49 = r120.getString("encrypted_body");
        IDecryptFeature r50 = IDecryptFeatureKt.getDecryptFeature();
        Intrinsics.checkNotNullExpressionValue(r49, "respBody");
        String r51 = r50.dataDecrypt(r49);
        if (r51 == null) goto L76;
        JSONObject r52 = g.b(r51);
        if (r52 == null) goto L71;
        JSONObject r53 = r52.optJSONObject("data");
        if (r53 == null) goto L71;
        String r54 = r53.optString("text");
    L72:
        if (r54 != null) goto L74;
        r41 = "";
    L75:
        r42 = AIKLog.INSTANCE;
        r43 = new StringBuilder();
        r43.append("run encrypted modelCenter ");
        goto L86
    L74:
        Intrinsics.checkNotNullExpressionValue(r54, "plainTextInByteArray.str…?.optString(\"text\") ?: \"\"");
        r41 = r54;
    L71:
        r54 = null;
        goto L72
    L76:
        AIKLog.INSTANCE.e("ModelCenterRequest", "decrypt failed");
        throw new AIKernelException(110, "decrypt failed", null, 0, 12, null);
    L59:
        if (r37.f() != (-200)) goto L61;
        int r55 = r37.f();
    L63:
        throw new AIKernelException(r55, "encrypted_body lost:" + r37.f() + ' ' + r37.e(), null, 0, 12, null);
    L61:
        r55 = 110;
        goto L63
    L47:
        r122 = false;
    L53:
        r38 = "";
        goto L55
    L91:
        r44 = r117;
        goto L92
    L27:
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, d().getBackend(), ApiPerfDetails.onStartVmRun, false, 2, null);     // Catch: Throwable -> L30
        r33 = CommonNetworkImpl.f4638a.m();     // Catch: Throwable -> L30
        r34 = r27;
    L33:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r36 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L36
    L17:
        r12.put(NetConst.KEY_CONTENT_TYPE, "application/json");
        k(r11, r12);
        String r57 = d().getBackend().getString("path", "");
        Intrinsics.checkNotNullExpressionValue(r57, "params.backend.getString(\"path\", \"\")");
        r114 = MapsKt.emptyMap();
        r26 = r57;
        r27 = r11;
        goto L19
    L5:
        r14 = null;
        goto L6
    }

    private final void i(Map<String, Object> r21, Map<String, String> r22) {
        if (d().getBackend().containsKey("cloud_research_model") == true) goto L5;
        r22.put("X-Ocean-Encrypted", NetConst.ENCRYPT_VERISON_CODE);
    L5:
        StringBuilder r10 = new StringBuilder();
        k r11 = new k();
        String r12 = d().getBackend().getString("prompt");
        if (r12 == null) goto L8;
        r11.p("system_prompt", r12);
        r10.append("promptSize:" + r12.length() + ' ');
    L8:
        String r13 = d().getBackend().getString("transparent_args");
        if (r13 != null) goto L69;
    L26:
        l("/ocean/device_intelligence/vlm");
        ParcelFileDescriptor r14 = (ParcelFileDescriptor) d().getBackend().getParcelable("fdObject");
        String r15 = d().getBackend().getString("filePath");
        final int r16 = d().getBackend().getInt("thumbnail_size", 0);
        final int r17 = d().getBackend().getInt("width", 1024);
        final int r18 = d().getBackend().getInt("height", 1024);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L34
        if (r14 == null) goto L31;
        ImageDecoder.Source r20 = ImageDecoder.createSource(new CallableC0317b(r14));     // Catch: Throwable -> L34
        if (r20 == null) goto L31;
    L32:
        Intrinsics.checkNotNullExpressionValue(r20, "fdObj?.let {\n           …lver, Uri.parse(fileUri))");     // Catch: Throwable -> L34
        Object r23 = Result.m32constructorimpl(ImageDecoder.decodeBitmap(r20, new x7.a(r16, r17, r18)));     // Catch: Throwable -> L34
    L36:
        Throwable r110 = Result.m35exceptionOrNullimpl(r23);
        if (r110 != null) goto L63;
        if (Result.m38isFailureimpl(r23) == false) goto L41;
        r23 = null;
    L41:
        Bitmap r24 = (Bitmap) r23;
        if (r24 == null) goto L61;
        r10.append("uri:" + r15 + ' ');
        ByteArrayOutputStream r25 = new ByteArrayOutputStream();
        r24.compress(Bitmap.CompressFormat.JPEG, 100, r25);     // Catch: Throwable -> L54
        byte[] r111 = r25.toByteArray();     // Catch: Throwable -> L54
        if (r111.length != 0) goto L48;
        AIKLog.INSTANCE.w("ModelCenterRequest", "compress JPEG got empty, try webp.");     // Catch: Throwable -> L54
        r24.compress(Bitmap.CompressFormat.WEBP, 100, r25);     // Catch: Throwable -> L54
        r111 = r25.toByteArray();     // Catch: Throwable -> L54
    L48:
        if (r111.length == 0) goto L53;
        String r26 = Base64.encodeToString(r111, 0);     // Catch: Throwable -> L54
        r11.p("input_image", r26);     // Catch: Throwable -> L54
        r10.append("byteArraySize:" + r111.length + ", imgSize:" + r26.length() + ", bitmap:(" + r24.getWidth() + ',' + r24.getHeight() + ',' + r24.getRowBytes() + ')');     // Catch: Throwable -> L54
        CloseableKt.closeFinally(r25, null);
        d().getBackend().putString("debugPrompt", r10.toString());
        String r27 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r27, "visualPrompt.toString()");
        r21.put("prompt", r27);
        r21.put("biz_name", e8.a.e(d().getBackend()));
        String r28 = d().getBackend().getString("version", "2.0");
        Intrinsics.checkNotNullExpressionValue(r28, "params.backend.getString(\"version\", \"2.0\")");
        r21.put("version", r28);
        AIKLog.INSTANCE.d("ModelCenterRequest", "fillVlmV2Args ok: " + d().getBackend().getString("debugPrompt"));
        return;
    L53:
        throw new AIKernelException(IdlErrors.E_DecodeFileError, "compress JPEG got empty byteArray, src bitmap:(" + r24.getWidth() + ',' + r24.getHeight() + ',' + r24.getAllocationByteCount() + "), " + r15, null, 0, 12, null);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        CloseableKt.closeFinally(r25, th);
        throw th;
    L61:
        throw new AIKernelException(IdlErrors.E_DecodeFileError, "decode result is null: " + r15, null, 0, 12, null);
    L63:
        throw new AIKernelException(IdlErrors.E_DecodeFileError, r110.getMessage(), null, 0, 12, null);
    L31:
        r20 = ImageDecoder.createSource(c().getContentResolver(), Uri.parse(r15));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r23 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L36
    L69:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L12
        Object r30 = Result.m32constructorimpl((k) g.a().k(r13, k.class));     // Catch: Throwable -> L12
    L14:
        Throwable r31 = Result.m35exceptionOrNullimpl(r30);
        if (r31 == null) goto L18;
        AIKLog.INSTANCE.e("ModelCenterRequest", "fillVlmV2Args: parse transparent json args failed, " + r31);
    L18:
        if (Result.m38isFailureimpl(r30) == false) goto L20;
        r30 = null;
    L20:
        k r32 = (k) r30;
        if (r32 == null) goto L26;
        Set<Map.Entry<String, i>> r33 = r32.r();
        Intrinsics.checkNotNullExpressionValue(r33, "it.entrySet()");
        Iterator<T> r34 = r33.iterator();
    L24:
        if (r34.hasNext() == false) goto L26;
        Map.Entry r35 = (Map.Entry) r34.next();
        r11.m((String) r35.getKey(), (i) r35.getValue());
    L12:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r30 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private static final void j(int r10, int r11, int r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        Intrinsics.checkNotNullParameter(r13, "decoder");
        Intrinsics.checkNotNullParameter(r14, "info");
        Intrinsics.checkNotNullParameter(r15, "<anonymous parameter 2>");
        int r16 = r14.getSize().getWidth();
        int r17 = r14.getSize().getHeight();
        if (r10 <= 0) goto L7;
        if (r16 > r10) goto L6;
        if (r17 > r10) goto L6;
    L10:
        r12 = r17;
        r11 = r16;
    L11:
        r13.setTargetSize(r11, r12);
        return;
    L6:
        float r18 = r10;
        float r19 = r16;
        float r20 = r17;
        float r21 = Math.max(r19 / r18, r20 / r18);
        r11 = (int) (r19 / r21);
        r12 = (int) (r20 / r21);
        goto L11
    L7:
        if (r16 > r11) goto L11;
        if (r17 <= r12) goto L10;
        goto L10
    }

    private final void k(Map<String, Object> r10, Map<String, String> r11) {
        String r12 = d().getBackend().getString("version");
        if (Intrinsics.areEqual(a(), "vlm_caption") == false) goto L5;
    L20:
        if (r12 != null) goto L22;
    L25:
        boolean r13 = true;
    L26:
        if (r13 == true) goto L30;
    L9:
        i(r10, r11);
        return;
    L30:
        return;
    L22:
        if (r12.length() == 0) goto L25;
        r13 = false;
        goto L26
    L5:
        if (Intrinsics.areEqual(a(), "vlm_tag") == true) goto L20;
        if (Intrinsics.areEqual(a(), "picture_classify") == true) goto L9;
        if (Intrinsics.areEqual(d().getBackend().getString("cloud_research_model"), "vlm") == true) goto L9;
        String r14 = this.f13572h;
        if (r14 == null) goto L16;
        l(r14);
    L16:
        Integer r15 = this.f13571g;
        if (r15 == null) goto L19;
        r10.put(WsConstants.KEY_CONNECTION_TYPE, Integer.valueOf(r15.intValue()));
    L19:
        String r16 = d().getBackend().getString("content", "");
        Intrinsics.checkNotNullExpressionValue(r16, "params.backend.getString(\"content\", \"\")");
        r10.put("prompt", r16);
    }

    private final void l(String r10) {
        d().getBackend().putString("path", r10);
    }

    @Override // com.obric.aikernel.model.cloud.common.CloudModelRequest
    public Object e(Continuation<? super Bundle> r10) {
        return h();
    }

    public final void m(String r10) {
        this.f13572h = r10;
    }

    public final void n(Integer r10) {
        this.f13571g = r10;
    }
}
