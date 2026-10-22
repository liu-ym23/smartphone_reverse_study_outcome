package com.obric.cae.utils;

import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.obric.cae.utils.AIKernelUtils$runModelInference$2", f = "AIKernelUtils.kt", i = {0}, l = {102}, m = "invokeSuspend", n = {EventBody.KEY_VALUE}, s = {"L$0"})
public final class AIKernelUtils$f extends SuspendLambda implements Function2<al, Continuation<? super Float>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f7351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7352b;
    public final /* synthetic */ IBaseModel c;
    public final /* synthetic */ RequestParams d;
    public final /* synthetic */ String e;

    public static final class a extends Lambda implements Function3<Boolean, Object, JSONObject, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Float> f7353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7354b;

        public a(Ref.ObjectRef<Float> r1, String r2) {
            this.f7353a = r1;
            this.f7354b = r2;
            super(3);
        }

        /* JADX WARN: Type inference failed for: r5v6, types: [T, java.lang.Float] */
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(Boolean r4, Object r5, JSONObject r6) {
            ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            Intrinsics.checkNotNullParameter((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin"), "<anonymous parameter 2>");
            Ref.ObjectRef<Float> r7 = this.f7353a;     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Number");     // Catch: Exception -> L5
            r7.element = Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).floatValue());     // Catch: Exception -> L5
            com.obric.cae.log.a.c("AIKernelUtils", "Model{" + this.f7354b + "} inference succeeded, result=" + this.f7353a.element);     // Catch: Exception -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            e = move-exception;
            com.obric.cae.log.a.a("AIKernelUtils", "Failed to parse inference result: " + e.getMessage(), e);
            goto L8
        }
    }

    public static final class b extends Lambda implements Function3<Integer, String, JSONObject, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7355a = null;

        static {
            f7355a = new b();
        }

        public b() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(Integer r2, String r3, JSONObject r4) {
            int r1 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue();
            String r5 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
            JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "errInfo");
            Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
            com.obric.cae.log.a.i("AIKernelUtils", "Model inference failed: " + r1 + ", " + r5);
            return Unit.INSTANCE;
        }
    }

    public AIKernelUtils$f(IBaseModel r3, RequestParams r4, String r5, Continuation<? super AIKernelUtils$f> r6) {
        IBaseModel r7 = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r3, IBaseModel.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.c = r7;
        this.d = r4;
        this.e = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return new AIKernelUtils$f(this.c, this.d, this.e, r5);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(al r3, Continuation<? super Float> r4) {
        return ((AIKernelUtils$f) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), AIKernelUtils$f.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.f7352b;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.ObjectRef r2 = this.f7351a;
        ResultKt.throwOnFailure(r5);
    L12:
        Response r6 = (Response) ZeusTransformUtils.preCheckCast(r5, Response.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L16;
        com.obric.cae.log.a.i("AIKernelUtils", "Failed to run model inference, infer() returned null, biz=" + this.e);
        return null;
    L16:
        ResponseKt.fail(ResponseKt.ok(r6, new a(r2, this.e)), b.f7355a);
        return r2.element;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        IBaseModel r3 = this.c;
        RequestParams r4 = this.d;
        this.f7351a = r7;
        this.f7352b = 1;
        Object r8 = r3.infer(r4, this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r7;
        r5 = r8;
        goto L12
    }
}
