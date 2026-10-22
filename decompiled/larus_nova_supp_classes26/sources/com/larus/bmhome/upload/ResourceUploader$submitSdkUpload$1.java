package com.larus.bmhome.upload;

import com.larus.bmhome.upload.instant.ImageInstantUploadFallbackRegister;
import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import mr9.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.ResourceUploader$submitSdkUpload$1", f = "ResourceUploader.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
final class ResourceUploader$submitSdkUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $forceRegister;
    final /* synthetic */ String $identifier;
    final /* synthetic */ mr9.j $runtimeParam;
    final /* synthetic */ gs8.b $taskHandle;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ String a;
        public final /* synthetic */ mr9.j b;
        public final /* synthetic */ boolean c;

        public a(String r1, mr9.j r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r34, Continuation r35) {
            is8.j r0 = (is8.j) r34;
            ResourceUploader r2 = ResourceUploader.a;
            String r3 = this.a;
            mr9.j r4 = this.b;
            boolean r5 = this.c;
            if (Intrinsics.areEqual(r0, is8.j.b.a) == false) goto L6;
            FLogger.a.i("ResourceUploader", "[sdkState] created, identifier=" + r3);
        L18:
            return Unit.INSTANCE;
        L6:
            if ((r0 instanceof is8.j.e) == false) goto L9;
            FLogger.a.i("ResourceUploader", "[sdkState] preprocessing, identifier=" + r3 + ", progress=" + ((is8.j.e) r0).a);
            goto L18
        L9:
            if ((r0 instanceof is8.j.c) == false) goto L11;
            FLogger.a.i("ResourceUploader", "[sdkState] credential preparing, identifier=" + r3 + ", authMode=" + ((is8.j.c) r0).a);
            goto L18
        L11:
            int r13 = 0;
            if ((r0 instanceof is8.j.h) == false) goto L15;
            FLogger r6 = FLogger.a;
            StringBuilder r7 = new StringBuilder("[sdkState] uploading, identifier=");
            r7.append(r3);
            r7.append(", progress=");
            is8.j.h r1 = (is8.j.h) r0;
            r7.append(r1.a);
            r7.append(", route=");
            r7.append(r1.b);
            r6.i("ResourceUploader", r7.toString());
            r4.e.invoke(new mr9.k(Long.valueOf(r1.a), false));
            goto L18
        L15:
            if ((r0 instanceof is8.j.f) == false) goto L19;
            FLogger r8 = FLogger.a;
            StringBuilder r9 = new StringBuilder("[sdkState] registering, identifier=");
            r9.append(r3);
            r9.append(", remoteKey=");
            is8.j.f r10 = (is8.j.f) r0;
            r9.append(r10.a);
            r9.append(", route=");
            r9.append(r10.b);
            r8.i("ResourceUploader", r9.toString());
            goto L18
        L19:
            n r12 = null;
            if ((r0 instanceof is8.j.g) == false) goto L56;
            ConcurrentHashMap<String, mr9.j> r11 = com.larus.bmhome.upload.sdk.g.a;
            Intrinsics.checkNotNullParameter(r3, "identifier");
            mr9.l r14 = com.larus.bmhome.upload.sdk.g.c.get(r3);
            if (r14 != null) goto L48;
            is8.h r15 = ((is8.j.g) r0).a;
            Intrinsics.checkNotNullParameter(r15, "<this>");
            String r16 = r15.b;
            String r17 = r15.c;
            is8.l r18 = r15.d;
            if (r15.e.b != UploadEngineType.IMAGE) goto L35;
            if (r18 == null) goto L35;
            Integer r19 = r18.b;
            if (r19 == null) goto L30;
            int r110 = r19.intValue();
        L31:
            Integer r20 = r18.a;
            if (r20 == null) goto L34;
            r13 = r20.intValue();
        L34:
            mr9.d r111 = new mr9.d(r110, r13);
        L36:
            is8.l r21 = r15.d;
            if (r15.e.b != UploadEngineType.VIDEO) goto L47;
            if (r21 == null) goto L47;
            String r22 = r21.d.get("vid");
            String r112 = "";
            if (r22 != null) goto L42;
            r22 = "";
        L42:
            String r113 = r21.d.get("space");
            if (r113 == null) goto L46;
            r112 = r113;
        L46:
            r12 = new n(r22, r112, new mr9.e(null, null, r21.c, null, null, null, null, r21.b, r21.a, null, null, null, 15995));
        L47:
            r14 = new mr9.l(r16, null, r17, r111, r12, false, null, 98);
            goto L48
        L30:
            r110 = 0;
        L35:
            r111 = null;
        L48:
            FLogger.a.i("ResourceUploader", "[sdkState] success, identifier=" + r3 + ", result=" + r14);
            ImageInstantUploadFallbackRegister r23 = ImageInstantUploadFallbackRegister.a;
            CoroutineScope r24 = ResourceUploader.b;
            String r25 = ((is8.j.g) r0).a.e.f.name();
            r23.getClass();
            ImageInstantUploadFallbackRegister.c(r24, r4, r14, r25, r5);
            com.larus.bmhome.upload.sdk.g.a(r3);
            r4.d.invoke(r14);     // Catch: Throwable -> L52
            ResourceUploader.f(r4);
            ResourceUploader.d(r4, "sdk success");
            throw new ResourceUploader.StopObserveSdkTaskException();
        L52:
            th = move-exception;
            ResourceUploader.f(r4);
            ResourceUploader.d(r4, "sdk success");
            throw th;
        L56:
            if ((r0 instanceof is8.j.d) == false) goto L70;
            is8.j.d r26 = (is8.j.d) r0;
            n r27 = r26.a.e;
            if ((r27 instanceof ResourceUploadError) == false) goto L60;
            r12 = (ResourceUploadError) r27;
        L60:
            if (r12 != null) goto L62;
            is8.d r28 = r26.a;
            r12 = new ResourceUploadError(r28.b, r28.c);
        L62:
            FLogger.a.e("ResourceUploader", "[sdkState] failed, identifier=" + r3 + ", error=" + r12);
            com.larus.bmhome.upload.instant.f.a(r4);
            com.larus.bmhome.upload.sdk.g.a(r3);
            r4.f.invoke(r12);     // Catch: Throwable -> L66
            ResourceUploader.e(r4, r12, "fail");
            ResourceUploader.d(r4, "sdk failure");
            throw new ResourceUploader.StopObserveSdkTaskException();
        L66:
            th = move-exception;
            ResourceUploader.e(r4, r12, "fail");
            ResourceUploader.d(r4, "sdk failure");
            throw th;
        L70:
            if ((r0 instanceof is8.j.a) == false) goto L79;
            is8.j.a r29 = (is8.j.a) r0;
            ResourceUploadError r30 = new ResourceUploadError("canceled", r29.a);
            FLogger.a.w("ResourceUploader", "[sdkState] cancelled, identifier=" + r3 + ", reason=" + r29.a);
            com.larus.bmhome.upload.instant.f.a(r4);
            com.larus.bmhome.upload.sdk.g.a(r3);
            r4.f.invoke(r30);     // Catch: Throwable -> L75
            ResourceUploader.e(r4, r30, "cancel");
            ResourceUploader.d(r4, "sdk cancel");
            throw new ResourceUploader.StopObserveSdkTaskException();
        L75:
            th = move-exception;
            ResourceUploader.e(r4, r30, "cancel");
            ResourceUploader.d(r4, "sdk cancel");
            throw th;
        L79:
            throw new NoWhenBranchMatchedException();
        }
    }

    public ResourceUploader$submitSdkUpload$1(gs8.b r1, String r2, mr9.j r3, boolean r4, Continuation<? super ResourceUploader$submitSdkUpload$1> r5) {
        this.$taskHandle = r1;
        this.$identifier = r2;
        this.$runtimeParam = r3;
        this.$forceRegister = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ResourceUploader$submitSdkUpload$1(this.$taskHandle, this.$identifier, this.$runtimeParam, this.$forceRegister, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: ResourceUploader.StopObserveSdkTaskException -> L13
    L16:
    L15:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        Flow<is8.j> r8 = this.$taskHandle.a();     // Catch: ResourceUploader.StopObserveSdkTaskException -> L13
        a r2 = new a(this.$identifier, this.$runtimeParam, this.$forceRegister);     // Catch: ResourceUploader.StopObserveSdkTaskException -> L13
        this.label = 1;     // Catch: ResourceUploader.StopObserveSdkTaskException -> L13
        if (r8.collect(r2, this) != r0) goto L16;
        return r0;
    L13:
        FLogger.a.i("ResourceUploader", "[sdkObserve] stop observing terminal task, identifier=" + this.$identifier);
        goto L15
    }
}
