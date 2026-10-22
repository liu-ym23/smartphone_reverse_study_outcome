package com.larus.slides.sdk.impl.plugins.event;

import android.util.Pair;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.OfflineDataManager;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.trace.CopyContentTypeString;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.sdk.impl.plugins.event.SlidesLoadEventPluginV2$updateCache$1$onSuccess$1", f = "SlidesLoadEventPluginV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SlidesLoadEventPluginV2$updateCache$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $resKey;
    final /* synthetic */ String $result;
    final /* synthetic */ String $token;
    int label;

    public SlidesLoadEventPluginV2$updateCache$1$onSuccess$1(String r1, String r2, String r3, Continuation<? super SlidesLoadEventPluginV2$updateCache$1$onSuccess$1> r4) {
        this.$result = r1;
        this.$token = r2;
        this.$resKey = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SlidesLoadEventPluginV2$updateCache$1$onSuccess$1(this.$result, this.$token, this.$resKey, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r9);
        String r10 = "";
        ResourceData r1 = new ResourceData();     // Catch: Exception -> L22
        String r2 = this.$resKey;     // Catch: Exception -> L22
        String r3 = this.$token;     // Catch: Exception -> L22
        r1.setReskey(r2);     // Catch: Exception -> L22
        r1.setObj_token(r3);     // Catch: Exception -> L22
        a r4 = (a) new Gson().fromJson(this.$result, a.class);     // Catch: Exception -> L22
        if (r4 == null) goto L8;
        JsonElement r5 = r4.a();     // Catch: Exception -> L22
    L9:
        JsonObject r6 = new JsonObject();     // Catch: Exception -> L22
        r6.add("data", r5);     // Catch: Exception -> L22
        r6.addProperty("msg", "success");     // Catch: Exception -> L22
        r6.addProperty(CopyContentTypeString.CODE, Boxing.boxInt(0));     // Catch: Exception -> L22
        r6.addProperty("full", Boxing.boxBoolean(true));     // Catch: Exception -> L22
        r6.addProperty("saveTime", Boxing.boxLong(System.currentTimeMillis()));     // Catch: Exception -> L22
        r1.setResvalue(r6.toString());     // Catch: Exception -> L22
        ResourceData r7 = OfflineDataManager.get().loadSubInfo(this.$token, this.$resKey, 0);     // Catch: Exception -> L22
        if (r7 != null) goto L13;
    L17:
        Pair r11 = OfflineDataManager.get().insertResourceData(r1);     // Catch: Exception -> L22
        long r8 = ((Number) r11.first).longValue();     // Catch: Exception -> L22
        r10 = (String) r11.second;     // Catch: Exception -> L22
    L19:
        if (r8 > 0) goto L25;
        FLogger.a.e("SlidesLoadEventPluginV2", "updateResourceData fail! ret = " + r8 + ", errorMsg = " + r10);     // Catch: Exception -> L22
    L25:
        return Unit.INSTANCE;
    L13:
        if (r7.getId() <= 0) goto L17;
        r1.setId(r7.getId());     // Catch: Exception -> L22
        r1.setSubblock_preload_status(r7.getSubblock_preload_status());     // Catch: Exception -> L22
        r1.setLoadFrom(r7.getLoadFrom());     // Catch: Exception -> L22
        r8 = OfflineDataManager.get().updateResourceData(r1);     // Catch: Exception -> L22
        if (r8 > 0) goto L19;
        FLogger.a.i("SlidesLoadEventPluginV2", "updateResourceData fail! ret = " + r8);     // Catch: Exception -> L22
        Pair r12 = OfflineDataManager.get().insertResourceData(r1);     // Catch: Exception -> L22
        r8 = ((Number) r12.first).longValue();     // Catch: Exception -> L22
        r10 = (String) r12.second;     // Catch: Exception -> L22
        goto L19
    L8:
        r5 = null;
    L22:
        e = move-exception;
        FLogger.a.e("SlidesLoadEventPluginV2", "update cache fail, message: " + e.getMessage());
        goto L25
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
