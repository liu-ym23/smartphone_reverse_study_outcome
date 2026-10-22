package com.obric.memorydata.aikernelcore;

import android.os.Bundle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.WebSocketManager$onMessage$3", f = "WebSocketManager.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
final class WebSocketManager$onMessage$3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebSocketManager.b $msg;
    int label;

    WebSocketManager$onMessage$3(WebSocketManager.b r3, Continuation<? super WebSocketManager$onMessage$3> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$msg = r3;
        super(2, r5);
    }

    private static final Unit invokeSuspend$lambda$4(final String r1, RequestParams r2) {
        ParamsKt.setCustomArgs(r2, new $$Lambda$WebSocketManager$onMessage$3$cw5gRCQRgpAoNOt3EVyC7HchHI8(r1));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$4$lambda$3(String r3, Bundle r4) {
        r4.putAll(BundleExtKt.json2Bundle$default(new JSONObject(r3), false, 2, null));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$6(String r11, Bundle r12) {
        int r0 = r12.getInt(IdlKeys.ErrorCode, 0);
        String r6 = r12.getString(IdlKeys.ErrorInfo, "");
        if (r0 == 0) goto L6;
        Intrinsics.checkNotNull(r6);
        WebSocketManager.a(WebSocketManager.f8445a, 6, "service-" + r11 + "@1", r6, null, null, 24, null);
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$95E72lsUE-2NLnIQ_H3qxVE7zGE, reason: not valid java name */
    public static /* synthetic */ Unit m459lambda$95E72lsUE2NLnIQ_H3qxVE7zGE(String r0, Bundle r1) {
        return invokeSuspend$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit lambda$9wZbP5rim7r7zd2abNNtzkFt_zY(String r0, RequestParams r1) {
        return invokeSuspend$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit lambda$cw5gRCQRgpAoNOt3EVyC7HchHI8(String r0, Bundle r1) {
        return invokeSuspend$lambda$4$lambda$3(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new WebSocketManager$onMessage$3(this.$msg, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((WebSocketManager$onMessage$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), WebSocketManager$onMessage$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r15v10, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v20, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L52:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        JsonObject r16 = this.$msg.b().getAsJsonObject();
        if (r16.has("business") == true) goto L13;
        r16 = null;
    L13:
        if (r16 == null) goto L20;
        JsonElement r17 = r16.get("business");
        if (r17 == null) goto L20;
        String r18 = r17.getAsString();
        if (r18 == null) goto L20;
        final String r6 = r18;
    L21:
        JsonObject r19 = this.$msg.b().getAsJsonObject();
        if (r19.has("entrance") == true) goto L25;
        r19 = null;
    L25:
        if (r19 == null) goto L30;
        JsonElement r110 = r19.get("entrance");
        if (r110 == null) goto L30;
        String r111 = r110.getAsString();
        ?? r112 = r111;
        if (r111 == null) goto L30;
    L31:
        JsonObject r2 = this.$msg.b().getAsJsonObject();
        if (r2.has(TrackerImpl.PARAMS) == true) goto L35;
        r2 = null;
    L35:
        if (r2 == null) goto L40;
        JsonElement r3 = r2.get(TrackerImpl.PARAMS);
        if (r3 == null) goto L40;
        final String r4 = r3.getAsString();
        if (r4 == null) goto L40;
    L41:
        RequestParams r7 = new RequestParams(null, new $$Lambda$WebSocketManager$onMessage$3$9wZbP5rim7r7zd2abNNtzkFt_zY(r4), 1, null);
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = "";
        if (StringsKt.startsWith$default(r112, "flow", false, 2, null) == false) goto L47;
        ?? r113 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{ParameterizedMessage.ERROR_MSG_SEPARATOR}, false, 0, 6, null), 1), String.class, "com.obric.memorydata.plugin");
        if (r113 == 0) goto L46;
        r5.element = r113;
    L46:
        r7.setUseStream(true);
    L48:
        MemoryScriptEngineEnv r8 = MemoryScriptEngineEnv.INSTANCE;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.element, String.class, "com.obric.memorydata.plugin");
        Function1<? super Bundle, Unit> r10 = new $$Lambda$WebSocketManager$onMessage$3$95E72lsUE2NLnIQ_H3qxVE7zGE(r6);
        Continuation<? super Unit> r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r8.runPackage(r6, r7, r9, r10, r11) != r0) goto L52;
        return r0;
    L47:
        r5.element = r112;
    L40:
        r4 = "{}";
    L30:
        r112 = "";
    L20:
        r6 = "";
        goto L21
    }
}
