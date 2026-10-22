package com.larus.bmhome.upload.sdk;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mr9.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/model/upload/ResourceUploadToken;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.UploadAuthTokenService$fetch$3", f = "UploadAuthTokenService.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
final class UploadAuthTokenService$fetch$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super m>, Object> {
    final /* synthetic */ String $dataType;
    final /* synthetic */ String $scene;
    int label;

    public UploadAuthTokenService$fetch$3(String r1, String r2, Continuation<? super UploadAuthTokenService$fetch$3> r3) {
        this.$dataType = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UploadAuthTokenService$fetch$3(this.$dataType, this.$scene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super m> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        com.larus.network.http.f r15 = (com.larus.network.http.a) r14;
        if ((r15 instanceof com.larus.network.http.f) == true) goto L22;
        m r16 = (m) ((com.larus.network.http.a) r15).b;
        if (r16 == null) goto L20;
        Keva r2 = fs8.a.a;
        String r3 = this.$dataType;
        Intrinsics.checkNotNullParameter(r16, "tokenData");
        Intrinsics.checkNotNullParameter(r3, "dataType");
        UploadDataType.Companion.getClass();
        if (UploadDataType.a.a(r3) == false) goto L18;
        FLogger.a.d("UploaderCacheStrategy", "save cache token: " + r16 + ", currentTime: " + AppHost.a.getAppClock().currentTimeMillis());
        fs8.a.a.storeString("image_token_data" + r3 + fs8.a.a(), GsonProtectorUtils.toJson(new Gson(), r16));
    L18:
        FLogger.a.i("UploadAuthToken", "[fetch] api(/alice/upload/auth_token) success");
        return r16;
    L20:
        FLogger.a.e("UploadAuthToken", "[fetch] api(/alice/upload/auth_token) success but token is null");
        throw new ResourceUploadError("upload_get_auth_token_error", "token data is null");
    L22:
        FLogger.a.e("UploadAuthToken", "[fetch] api(/alice/upload/auth_token) failed, msg:" + r15.d);
        throw new ResourceUploadError("upload_get_auth_token_error", "api(/alice/upload/auth_token) error");
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        String r5 = this.$scene;
        String r6 = this.$dataType;
        r4.put("scene", r5);
        r4.put("data_type", r6);
        Unit r7 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", m.class, "/alice/upload/auth_token", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L11;
        return r0;
    }
}
