package com.obric.aikernel;

import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.isolate.api.IIsolateApi;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.common.CloudRequestConfigs;
import com.obric.aikernel.multiproc.SubProcessManager;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.service.res.PythonRuntimeService;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class InferEntry$requestHandleImpl$1 implements com.obric.aikernel.request.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InferEntry f4391a;

    InferEntry$requestHandleImpl$1(InferEntry r10) {
        this.f4391a = r10;
    }

    public static final /* synthetic */ Object i(InferEntry$requestHandleImpl$1 r10, String r11, String r12, RequestParams r13, Continuation r14) {
        return r10.l(r11, r12, r13, r14);
    }

    public static final /* synthetic */ Object j(InferEntry$requestHandleImpl$1 r10, String r11, String r12, String r13, boolean r14, RequestParams r15, Continuation r16) {
        return r10.m(r11, r12, r13, r14, r15, r16);
    }

    private final Object l(String r10, String r11, RequestParams r12, Continuation<? super InferEntry.b> r13) {
        if ((r13 instanceof InferEntry$requestHandleImpl$1$preparePackage$1) == false) goto L7;
        InferEntry$requestHandleImpl$1$preparePackage$1 r14 = (InferEntry$requestHandleImpl$1$preparePackage$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        List r19 = (List) r16;
        if (r19 == null) goto L33;
        Iterator r20 = r19.iterator();
    L21:
        if (r20.hasNext() == false) goto L25;
        Object r21 = r20.next();
        if (((Boolean) ((Pair) r21).getSecond()).booleanValue() == false) goto L21;
    L26:
        Pair r22 = (Pair) r21;
        if (r22 != null) goto L29;
        return null;
    L29:
        return new InferEntry.b((String) r22.getFirst(), SubProcessManager.f4700a.b(AppContext.INSTANCE.getContext(), (String) r22.getFirst()));
    L25:
        r21 = null;
        goto L26
    L33:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        PythonRuntimeService r23 = InferEntry.f(this.f4391a);
        r14.label = 1;
        r16 = r23.I(r10, r11, r12, r14);
        if (r16 != r17) goto L17;
        return r17;
    L7:
        r14 = new InferEntry$requestHandleImpl$1$preparePackage$1(this, r13);
        goto L8
    }

    private final Object m(String r10, String r11, String r12, boolean r13, RequestParams r14, Continuation<? super PackageResource> r15) {
        if ((r15 instanceof InferEntry$requestHandleImpl$1$updatePackage$3) == false) goto L7;
        InferEntry$requestHandleImpl$1$updatePackage$3 r16 = (InferEntry$requestHandleImpl$1$updatePackage$3) r15;
        int r17 = r16.label;
        if ((r17 & Integer.MIN_VALUE) == 0) goto L7;
        r16.label = r17 - Integer.MIN_VALUE;
    L8:
        InferEntry$requestHandleImpl$1$updatePackage$3 r18 = r16;
        Object r19 = r18.result;
        Object r20 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r21 = r18.label;
        boolean r22 = true;
        if (r21 == 0) goto L14;
        if (r21 != 1) goto L13;
        r14 = (RequestParams) r18.L$2;
        r11 = (String) r18.L$1;
        r10 = (String) r18.L$0;
        ResultKt.throwOnFailure(r19);
    L17:
        PackageResource r110 = (PackageResource) r19;
        if (r110.isAvailable() == false) goto L20;
        return r110;
    L20:
        if (r11.length() != 0) goto L22;
        boolean r23 = true;
    L23:
        if (r23 == false) goto L34;
        PackageResource r24 = CloudRequestConfigs.f4631a.c(r10, r14);
        if (r24 != null) goto L27;
    L29:
        r22 = false;
    L30:
        if (r22 == true) goto L32;
        return r110;
    L32:
        return r24;
    L27:
        if (r24.isAvailable() != true) goto L29;
    L34:
        return r110;
    L22:
        r23 = false;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r19);
        PythonRuntimeService r25 = InferEntry.f(this.f4391a);
        r18.L$0 = r10;
        r18.L$1 = r11;
        r18.L$2 = r14;
        r18.label = 1;
        r19 = r25.R(r10, r12, r13, r11, r18);
        if (r19 != r20) goto L17;
        return r20;
    L7:
        r16 = new InferEntry$requestHandleImpl$1$updatePackage$3(this, r15);
        goto L8
    }

    @Override // com.obric.aikernel.request.a
    public Object a(String r11, RequestParams r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        if ((r13 instanceof InferEntry$requestHandleImpl$1$getPackageUpdateProgress$1) == false) goto L7;
        InferEntry$requestHandleImpl$1$getPackageUpdateProgress$1 r10 = (InferEntry$requestHandleImpl$1$getPackageUpdateProgress$1) r13;
        int r14 = r10.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r10.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        boolean r18 = true;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        int r19 = r10.I$0;
        Bundle r110 = (Bundle) r10.L$2;
        r12 = (RequestParams) r10.L$1;
        InferEntry$requestHandleImpl$1 r20 = (InferEntry$requestHandleImpl$1) r10.L$0;
        ResultKt.throwOnFailure(r15);
        Bundle r21 = r110;
        Object r22 = r15;
    L18:
        Bundle r111 = e8.a.w(r21, r22, 0, null, 6, null);
        if (r19 != 0) goto L22;
        r18 = false;
    L22:
        com.obric.aikernel.request.b r112 = new com.obric.aikernel.request.b(r18, r111);
        ApiPerfDetails.a r113 = ApiPerfDetails.Companion;
        ApiPerfDetails.a.j(r113, r12.getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);
        ApiPerfDetails.a.j(r113, r12.getBackend(), ApiPerfDetails.onCallbackClient, false, 2, null);
        r20.k(r12);
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, r12.getBackend(), ApiPerfDetails.onStartVmRun, false, 2, null);
        Bundle r114 = new Bundle();
        PythonRuntimeService r23 = InferEntry.f(this.f4391a);
        r10.L$0 = this;
        r10.L$1 = r12;
        r10.L$2 = r114;
        r10.I$0 = 1;
        r10.label = 1;
        Object r115 = r23.B(r11, r10);
        if (r115 != r16) goto L17;
        return r16;
    L17:
        r20 = this;
        r22 = r115;
        r21 = r114;
        r19 = 1;
    L7:
        r10 = new InferEntry$requestHandleImpl$1$getPackageUpdateProgress$1(this, r13);
        goto L8
    }

    @Override // com.obric.aikernel.request.a
    public Object b(String r17, RequestParams r18, Continuation<? super PackageResource> r19) {
        if ((r19 instanceof InferEntry$requestHandleImpl$1$updatePackage$1) == false) goto L7;
        InferEntry$requestHandleImpl$1$updatePackage$1 r10 = (InferEntry$requestHandleImpl$1$updatePackage$1) r19;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        InferEntry$requestHandleImpl$1$updatePackage$1 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        RequestParams r16 = (RequestParams) r12.L$2;
        String r20 = (String) r12.L$1;
        InferEntry$requestHandleImpl$1 r21 = (InferEntry$requestHandleImpl$1) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L28:
        PackageResource r22 = (PackageResource) r13;
        String r23 = r20;
    L29:
        if (r22 != null) goto L31;
        r22 = new PackageResource(r23, 1, 0, null, 0, 28, null);
    L31:
        ApiPerfDetails.a r24 = ApiPerfDetails.Companion;
        ApiPerfDetails.a.j(r24, r16.getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);
        ApiPerfDetails.a.j(r24, r16.getBackend(), ApiPerfDetails.onCallbackClient, false, 2, null);
        r21.k(r16);
        return r22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, r18.getBackend(), ApiPerfDetails.onStartVmRun, false, 2, null);
        String r25 = com.obric.aikernel.utils.b.a(r18.getBackend());
        if (r25 != null) goto L17;
        r25 = "";
    L17:
        String r26 = r25;
        String r27 = e8.a.j(r18.getBackend());
        boolean r28 = r18.getBackend().getBoolean("forceUpdate");
        r22 = null;
        IIsolateApi r29 = k7.b.a();
        boolean r110 = false;
        if (r29 != null) goto L20;
    L22:
        if (r110 == false) goto L24;
        AIKLog.INSTANCE.i("InferEntry", "getPackage intercept by sys.aikernel.test_provision biz:" + r17);
        r16 = r18;
        r21 = this;
        r23 = r17;
        goto L29
    L24:
        r12.L$0 = this;
        r12.L$1 = r17;
        r12.L$2 = r18;
        r12.label = 1;
        r13 = m(r17, r26, r27, r28, r18, r12);
        if (r13 != r14) goto L27;
        return r14;
    L27:
        r21 = this;
        r20 = r17;
        r16 = r18;
        goto L28
    L20:
        if (r29.testProvisionBizFromProp(r17) != true) goto L22;
        r110 = true;
    L7:
        r10 = new InferEntry$requestHandleImpl$1$updatePackage$1(this, r19);
        goto L8
    }

    @Override // com.obric.aikernel.request.a
    public Object c(List<String> r10, RequestParams r11, b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        return com.obric.aikernel.request.a.C0111a.a(this, r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.request.a
    public Object d(String r10, RequestParams r11, b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        if ((r13 instanceof InferEntry$requestHandleImpl$1$unloadPackage$1) == false) goto L7;
        InferEntry$requestHandleImpl$1$unloadPackage$1 r14 = (InferEntry$requestHandleImpl$1$unloadPackage$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        InferEntry$requestHandleImpl$1$unloadPackage$1 r16 = r14;
        Object r17 = r16.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r16.label;
        boolean r20 = true;
        if (r19 == 0) goto L14;
        if (r19 != 1) goto L13;
        int r21 = r16.I$0;
        r11 = (RequestParams) r16.L$1;
        InferEntry$requestHandleImpl$1 r22 = (InferEntry$requestHandleImpl$1) r16.L$0;
        ResultKt.throwOnFailure(r17);
    L20:
        Bundle r110 = (Bundle) r17;
        if (r21 != 0) goto L24;
        r20 = false;
    L24:
        com.obric.aikernel.request.b r111 = new com.obric.aikernel.request.b(r20, r110);
        InferEntry$requestHandleImpl$1 this = r22;
    L26:
        this.k(r11);
        return r111;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        if (com.obric.aikernel.multiproc.d.f4707a.f() == false) goto L25;
        PythonRuntimeService r23 = InferEntry.f(this.f4391a);
        r16.L$0 = this;
        r16.L$1 = r11;
        r16.I$0 = 1;
        r16.label = 1;
        r17 = r23.U(r10, r11, "unload", r12, r16);
        if (r17 != r18) goto L19;
        return r18;
    L19:
        r22 = this;
        r21 = 1;
        goto L20
    L25:
        com.obric.aikernel.request.b.C0112b r24 = com.obric.aikernel.request.b.f4839c;
        e8.a.r(r12, r24.b());
        r111 = new com.obric.aikernel.request.b(true, r24.b());
    L7:
        r14 = new InferEntry$requestHandleImpl$1$unloadPackage$1(this, r13);
        goto L8
    }

    @Override // com.obric.aikernel.request.a
    public Object e(String r13, RequestParams r14, Continuation<? super PackageResource> r15) {
        if ((r15 instanceof InferEntry$requestHandleImpl$1$getPackage$1) == false) goto L7;
        InferEntry$requestHandleImpl$1$getPackage$1 r10 = (InferEntry$requestHandleImpl$1$getPackage$1) r15;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r16 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        boolean r18 = false;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        r14 = (RequestParams) r10.L$2;
        r13 = (String) r10.L$1;
        InferEntry$requestHandleImpl$1 this = (InferEntry$requestHandleImpl$1) r10.L$0;
        ResultKt.throwOnFailure(r16);
    L41:
        PackageResource r19 = (PackageResource) r16;
        if (r19 != null) goto L44;
    L46:
        boolean r110 = false;
    L47:
        if (r110 == false) goto L48;
    L37:
        String r20 = r13;
    L55:
        ApiPerfDetails.a r111 = ApiPerfDetails.Companion;
        ApiPerfDetails.a.j(r111, r14.getBackend(), ApiPerfDetails.onEndVmRun, false, 2, null);
        if (r19 != null) goto L58;
        r19 = new PackageResource(r20, 1, 0, null, 0, 28, null);
    L58:
        ApiPerfDetails.a.j(r111, r14.getBackend(), ApiPerfDetails.onCallbackClient, false, 2, null);
        this.k(r14);
        return r19;
    L48:
        PackageResource r112 = CloudRequestConfigs.f4631a.c(r13, r14);
        if (r112 != null) goto L51;
    L53:
        if (r18 == false) goto L37;
        r20 = r13;
        r19 = r112;
        goto L55
    L51:
        if (r112.isAvailable() != true) goto L53;
        r18 = true;
        goto L53
    L44:
        if (r19.isAvailable() != true) goto L46;
        r110 = true;
        goto L47
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (RequestParams) r10.L$2;
        r13 = (String) r10.L$1;
        this = (InferEntry$requestHandleImpl$1) r10.L$0;
        ResultKt.throwOnFailure(r16);
    L36:
        r19 = (PackageResource) r16;
        goto L37
    L16:
        ResultKt.throwOnFailure(r16);
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, r14.getBackend(), ApiPerfDetails.onStartVmRun, false, 2, null);
        String r113 = com.obric.aikernel.utils.b.a(r14.getBackend());
        r19 = null;
        AIKLog r21 = AIKLog.INSTANCE;
        r21.d("InferEntry", "getPackage biz= " + r13 + " loraType= " + r113);
        IIsolateApi r22 = k7.b.a();
        if (r22 != null) goto L19;
    L21:
        boolean r23 = false;
    L22:
        if (r23 == false) goto L24;
        r21.i("InferEntry", "getPackage intercept by sys.aikernel.test_provision biz:" + r13);
        goto L37
    L24:
        if (r113 != null) goto L26;
    L31:
        boolean r24 = false;
    L32:
        if (r24 == false) goto L38;
        PythonRuntimeService r25 = InferEntry.f(this.f4391a);
        r10.L$0 = this;
        r10.L$1 = r13;
        r10.L$2 = r14;
        r10.label = 1;
        r16 = r25.y(r13, r113, r10);
        if (r16 != r12) goto L36;
        return r12;
    L38:
        PythonRuntimeService r114 = InferEntry.f(this.f4391a);
        r10.L$0 = this;
        r10.L$1 = r13;
        r10.L$2 = r14;
        r10.label = 2;
        r16 = r114.z(r13, r10);
        if (r16 != r12) goto L41;
        return r12;
    L26:
        if (r113.length() <= 0) goto L28;
        boolean r26 = true;
    L29:
        if (r26 != true) goto L31;
        r24 = true;
        goto L32
    L28:
        r26 = false;
        goto L29
    L19:
        if (r22.testProvisionBizFromProp(r13) != true) goto L21;
        r23 = true;
    L7:
        r10 = new InferEntry$requestHandleImpl$1$getPackage$1(this, r15);
        goto L8
    }

    @Override // com.obric.aikernel.request.a
    public Object f(List<String> r10, RequestParams r11, b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        return com.obric.aikernel.request.a.C0111a.b(this, r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.request.a
    public Object g(String r10, RequestParams r11, b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        if ((r13 instanceof InferEntry$requestHandleImpl$1$runPackage$1) == false) goto L7;
        InferEntry$requestHandleImpl$1$runPackage$1 r14 = (InferEntry$requestHandleImpl$1$runPackage$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        InferEntry$requestHandleImpl$1$runPackage$1 r16 = r14;
        Object r17 = r16.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r16.label;
        boolean r20 = true;
        if (r19 == 0) goto L16;
        if (r19 == 1) goto L15;
        if (r19 != 2) goto L14;
        r12 = (b) r16.L$2;
        r11 = (RequestParams) r16.L$1;
        InferEntry$requestHandleImpl$1 this = (InferEntry$requestHandleImpl$1) r16.L$0;
        ResultKt.throwOnFailure(r17);
    L33:
        InferEntry.b r110 = (InferEntry.b) r17;
        if (r110 != null) goto L47;
        com.obric.aikernel.request.b.C0112b r21 = com.obric.aikernel.request.b.f4839c;
        e8.a.r(r12, r21.b());
        com.obric.aikernel.request.b r111 = new com.obric.aikernel.request.b(true, r21.b());
    L36:
        InferEntry$requestHandleImpl$1 r22 = this;
    L45:
        r22.k(r11);
        return r111;
    L47:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L39
        a.AbstractBinderC0095a.U0(r110.a()).A1(r11.getBackend(), r12);     // Catch: Throwable -> L39
        Object r24 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r25 = Result.m35exceptionOrNullimpl(r24);
        if (r25 == null) goto L44;
        AIKLog.INSTANCE.e("InferEntry", "runPackage transact failed: " + r25);
    L44:
        r111 = new com.obric.aikernel.request.b(true, com.obric.aikernel.request.b.f4839c.e());
    L39:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r24 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L41
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r26 = r16.I$0;
        r11 = (RequestParams) r16.L$1;
        r22 = (InferEntry$requestHandleImpl$1) r16.L$0;
        ResultKt.throwOnFailure(r17);
    L25:
        Bundle r113 = (Bundle) r17;
        if (r26 != 0) goto L29;
        r20 = false;
    L29:
        r111 = new com.obric.aikernel.request.b(r20, r113);
        goto L45
    L16:
        ResultKt.throwOnFailure(r17);
        if (com.obric.aikernel.multiproc.d.f4707a.f() == false) goto L30;
        String r114 = r11.getBackend().getString(IdlKeys.Args_Infer_Event);
        if (r114 != null) goto L21;
        r114 = r11.getBackend().getString("_debug_entrance", "");
    L21:
        String r27 = r114;
        AIKLog.INSTANCE.d("InferEntry", "runPackage " + r10 + ' ' + r11.getTraceIdStr() + " event: " + r27);
        PythonRuntimeService r28 = InferEntry.f(this.f4391a);
        Intrinsics.checkNotNullExpressionValue(r27, NotificationCompat.CATEGORY_EVENT);
        r16.L$0 = this;
        r16.L$1 = r11;
        r16.I$0 = 1;
        r16.label = 1;
        r17 = r28.U(r10, r11, r27, r12, r16);
        if (r17 != r18) goto L24;
        return r18;
    L24:
        r22 = this;
        r26 = 1;
        goto L25
    L30:
        String r115 = com.obric.aikernel.utils.b.a(r11.getBackend());
        r16.L$0 = this;
        r16.L$1 = r11;
        r16.L$2 = r12;
        r16.label = 2;
        r17 = l(r10, r115, r11, r16);
        if (r17 != r18) goto L33;
        return r18;
    L7:
        r14 = new InferEntry$requestHandleImpl$1$runPackage$1(this, r13);
        goto L8
    }

    @Override // com.obric.aikernel.request.a
    public Object h(String r10, RequestParams r11, b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        if ((r13 instanceof InferEntry$requestHandleImpl$1$loadPackage$1) == false) goto L7;
        InferEntry$requestHandleImpl$1$loadPackage$1 r14 = (InferEntry$requestHandleImpl$1$loadPackage$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        r12 = (b) r14.L$2;
        r11 = (RequestParams) r14.L$1;
        InferEntry$requestHandleImpl$1 this = (InferEntry$requestHandleImpl$1) r14.L$0;
        ResultKt.throwOnFailure(r16);
    L17:
        InferEntry.b r19 = (InferEntry.b) r16;
        String r20 = null;
        Bundle r21 = e8.a.E(new Bundle(), 0, null, 3, null);
        if (r19 == null) goto L20;
        IBinder r22 = r19.a();
    L21:
        r21.putBinder(IdlKeys.Args_InferBinder, r22);
        if (r19 == null) goto L24;
        r20 = r19.b();
    L24:
        r21.putString(IdlKeys.Args_TargetProcess, r20);
        e8.a.r(r12, r21);
        this.k(r11);
        return new com.obric.aikernel.request.b(true, r21);
    L20:
        r22 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        String r23 = com.obric.aikernel.utils.b.a(r11.getBackend());
        r14.L$0 = this;
        r14.L$1 = r11;
        r14.L$2 = r12;
        r14.label = 1;
        r16 = l(r10, r23, r11, r14);
        if (r16 != r17) goto L17;
        return r17;
    L7:
        r14 = new InferEntry$requestHandleImpl$1$loadPackage$1(this, r13);
        goto L8
    }

    public final void k(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        ApiPerfDetails.a r11 = ApiPerfDetails.Companion;
        r11.i(r10.getBackend(), ApiPerfDetails.onEndApiElapse, true);
        ApiPerfDetails.a.j(r11, r10.getBackend(), ApiPerfDetails.onEndApi, false, 2, null);
    }
}
