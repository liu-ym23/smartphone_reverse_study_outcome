package com.obric.cae.utils.bridge;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.ToNumberPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/cae/utils/bridge/PythonScriptEngineBridge;", "", "()V", "MAX_REQUEST_LENGTH", "", "MSG_SUCCESS", "", "RESULT_ERROR", "RESULT_SUCCESS", "RESULT_UNKNOWN", "gson", "Lcom/google/gson/Gson;", "handleRequest", "args", "handleRequest$CommSenseAAR_release", "normalizeJson", EventBody.KEY_VALUE, "sendNativeMsg", "biz", "CommSenseAAR_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PythonScriptEngineBridge {
    public static final PythonScriptEngineBridge INSTANCE = null;
    private static final int MAX_REQUEST_LENGTH = 1048576;
    private static final String MSG_SUCCESS = "success";
    private static final int RESULT_ERROR = -1;
    private static final int RESULT_SUCCESS = 0;
    private static final int RESULT_UNKNOWN = 2;
    private static final Gson gson = null;

    @DebugMetadata(c = "com.obric.cae.utils.bridge.PythonScriptEngineBridge$handleRequest$response$result$1", f = "PythonBridge.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<al, Continuation<? super Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BridgeData f7361b;

        /* JADX INFO: renamed from: com.obric.cae.utils.bridge.PythonScriptEngineBridge$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.obric.cae.utils.bridge.PythonScriptEngineBridge$handleRequest$response$result$1$1", f = "PythonBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0363a extends SuspendLambda implements Function2<al, Continuation<? super Object>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BridgeData f7362a;

            public C0363a(BridgeData r3, Continuation<? super C0363a> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.f7362a = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return new C0363a(this.f7362a, r4);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(al r3, Continuation<? super Object> r4) {
                return ((C0363a) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), C0363a.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r13) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(r13);
                Gson r14 = b.f7365a;
                BridgeData r12 = this.f7362a;
                Intrinsics.checkNotNullParameter(r12, "data");
                if (Intrinsics.areEqual(r12.getProtocol(), "bridge_api") == false) goto L104;
                Integer r15 = r12.getVersion();
                boolean r0 = false;
                if (r15 != null) goto L8;
            L10:
                boolean r16 = false;
            L11:
                if (r16 == false) goto L102;
                BridgeApiInfo r17 = r12.getApiInfo();
                if (r17 == null) goto L100;
                String r18 = r17.getModule();
                if (r18 == null) goto L98;
                if ((!StringsKt.isBlank(r18)) == true) goto L20;
                r18 = null;
            L20:
                if (r18 == null) goto L98;
                String r2 = r17.getApiName();
                if (r2 == null) goto L96;
                if ((!StringsKt.isBlank(r2)) == true) goto L27;
                r2 = null;
            L27:
                if (r2 == null) goto L96;
                List<Object> r19 = r17.getParams();
                if (r19 != null) goto L32;
                r19 = CollectionsKt.emptyList();
            L32:
                if (b.f7366b.matches(r2) == false) goto L94;
                if (r19.size() > 64) goto L36;
                boolean r4 = true;
            L37:
                if (r4 == false) goto L92;
                Object r5 = com.obric.cae.utils.bridge.a.f7363a.a(r18);
                if (r5 == null) goto L90;
                Method[] r6 = r5.getClass().getMethods();
                Intrinsics.checkNotNullExpressionValue(r6, "target.javaClass.methods");
                ArrayList r7 = new ArrayList();
                int r8 = r6.length;
                int r9 = 0;
            L41:
                if (r9 >= r8) goto L55;
                Method r10 = r6[r9];
                if (Modifier.isPublic(r10.getModifiers()) == true) goto L45;
            L51:
                boolean r11 = false;
            L52:
                if (r11 == false) goto L54;
                r7.add(r10);
            L54:
                r9 = r9 + 1;
                goto L41
            L45:
                if (r10.isAnnotationPresent(PythonBridgeMethod.class) == false) goto L51;
                if (Intrinsics.areEqual(r10.getName(), r2) == false) goto L51;
                if (r10.getParameterCount() != r19.size()) goto L51;
                r11 = true;
                goto L52
            L55:
                ArrayList r20 = new ArrayList();
                Iterator r21 = r7.iterator();
            L57:
                if (r21.hasNext() == false) goto L70;
                Method r22 = (Method) ZeusTransformUtils.preCheckCast(r21.next(), Method.class, "com.obric.memorydata.plugin");
                Gson r23 = b.f7365a;
                Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L61
                Intrinsics.checkNotNullExpressionValue(r22, "method");     // Catch: Throwable -> L61
                Object r25 = Result.m1421constructorimpl(TuplesKt.to(r22, b.a(r22, r19)));     // Catch: Throwable -> L61
            L64:
                if (Result.m1427isFailureimpl(r25) == false) goto L66;
                r25 = null;
            L66:
                Pair r26 = (Pair) ZeusTransformUtils.preCheckCast(r25, Pair.class, "com.obric.memorydata.plugin");
                if (r26 == null) goto L57;
                r20.add(r26);
            L61:
                th = move-exception;
                Result.Companion r27 = Result.Companion;
                r25 = Result.m1421constructorimpl(ResultKt.createFailure(th));
                goto L64
            L70:
                if (r20.size() != 1) goto L72;
                r0 = true;
            L72:
                if (r0 == false) goto L74;
                Pair r110 = (Pair) ZeusTransformUtils.preCheckCast(CollectionsKt.single(r20), Pair.class, "com.obric.memorydata.plugin");
                Method r111 = (Method) ZeusTransformUtils.preCheckCast(r110.component1(), Method.class, "com.obric.memorydata.plugin");
                Object[] r112 = (Object[]) ZeusTransformUtils.preCheckCast(r110.component2(), Object[].class, "com.obric.memorydata.plugin");
                Object r113 = r111.invoke(r5, Arrays.copyOf(r112, r112.length));     // Catch: InvocationTargetException -> L86
                if (Intrinsics.areEqual(r111.getReturnType(), Void.TYPE) == false) goto L83;
            L84:
                return Void.TYPE;
            L83:
                if (r113 == Unit.INSTANCE) goto L84;
                return r113;
            L86:
                e = move-exception;
                Throwable r114 = e.getTargetException();
                Intrinsics.checkNotNullExpressionValue(r114, "exception.targetException");
                throw r114;
            L74:
                if (r20.isEmpty() == false) goto L76;
                StringBuilder r115 = new StringBuilder("Bridge method ").append(r18).append('.').append(r2);
                String r116 = " was not found or parameters do not match";
            L78:
                throw new IllegalArgumentException(r115.append(r116).toString().toString());
            L76:
                r115 = new StringBuilder("Bridge method ").append(r18).append('.').append(r2);
                r116 = " is ambiguous";
                goto L78
            L90:
                throw new IllegalArgumentException("Bridge module " + r18 + " is not registered");
            L92:
                throw new IllegalArgumentException("Too many bridge parameters".toString());
            L36:
                r4 = false;
                goto L37
            L94:
                throw new IllegalArgumentException("Invalid bridge api_name".toString());
            L96:
                throw new IllegalArgumentException("Bridge api_name is required");
            L98:
                throw new IllegalArgumentException("Bridge module is required");
            L100:
                throw new IllegalArgumentException("Bridge body is required".toString());
            L102:
                throw new IllegalArgumentException("Unsupported bridge version".toString());
            L8:
                if (r15.intValue() != 1) goto L10;
                r16 = true;
                goto L11
            L104:
                throw new IllegalArgumentException("Unsupported bridge protocol".toString());
            }
        }

        public a(BridgeData r3, Continuation<? super a> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f7361b = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new a(this.f7361b, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(al r3, Continuation<? super Object> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), a.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.f7360a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ah r7 = ba.c();
            C0363a r2 = new C0363a(this.f7361b, null);
            this.f7360a = 1;
            r6 = i.a(r7, r2, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
        INSTANCE = new PythonScriptEngineBridge();
        Gson r0 = new GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create();
        Intrinsics.checkNotNullExpressionValue(r0, "GsonBuilder()\n        .s…DOUBLE)\n        .create()");
        gson = r0;
    }

    private PythonScriptEngineBridge() {
    }

    private final Object normalizeJson(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L6;
    L4:
        JsonElement r3 = JsonParser.parseString(r2.toString());
        Intrinsics.checkNotNullExpressionValue(r3, "parseString(value.toString())");
        return r3;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == true) goto L4;
        return r2;
    }

    @com.obric.aee.utils.a
    private final String sendNativeMsg(String r1, String r2) {
        return handleRequest$CommSenseAAR_release(r1);
    }

    public final String handleRequest$CommSenseAAR_release(String r11) {
        Intrinsics.checkNotNullParameter(r11, "args");
    L20:
        th = move-exception;
        String r10 = th.getMessage();
        if (r10 != null) goto L24;
        r10 = "Bridge execution failed";
    L24:
        BridgeResponse r12 = new BridgeResponse(-1, r10, null, 4, null);
    L25:
        String r13 = gson.toJson(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "gson.toJson(response)");
        return r13;
    L4:
        if (r11.length() > 1048576) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L19;
        BridgeData r14 = (BridgeData) ZeusTransformUtils.preCheckCast(gson.fromJson(r11, BridgeData.class), BridgeData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r14 == null) goto L17;
        Object r15 = i.a(null, new a(r14, null), 1, null);     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r15, Void.TYPE) == false) goto L13;
        r12 = new BridgeResponse(0, "success", null, 4, null);     // Catch: Throwable -> L20
        goto L25
    L13:
        if (r15 != null) goto L15;
        r12 = new BridgeResponse(2, "return null data", null, 4, null);     // Catch: Throwable -> L20
        goto L25
    L15:
        r12 = new BridgeResponse(0, "success", normalizeJson(r15));     // Catch: Throwable -> L20
        goto L25
    L17:
        throw new IllegalArgumentException("Bridge request is empty");     // Catch: Throwable -> L20
    L19:
        throw new IllegalArgumentException("Bridge request is too large".toString());     // Catch: Throwable -> L20
    L6:
        r0 = false;
        goto L7
    }
}
