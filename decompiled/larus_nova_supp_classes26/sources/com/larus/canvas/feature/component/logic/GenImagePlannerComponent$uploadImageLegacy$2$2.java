package com.larus.canvas.feature.component.logic;

import com.larus.bmhome.upload.ResourceUploader;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$uploadImageLegacy$2$2", f = "GenImagePlannerComponent.kt", i = {}, l = {1781}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$uploadImageLegacy$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<mr9.l> $continuation;
    final /* synthetic */ String $localPath;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public static final class a implements Function1<mr9.l, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<mr9.l> a;
        public final /* synthetic */ AtomicBoolean b;

        public a(kotlinx.coroutines.i<? super mr9.l> r1, AtomicBoolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r4) {
            mr9.l r5 = (mr9.l) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            if (this.a.isActive() == false) goto L8;
            if (this.b.compareAndSet(false, true) == false) goto L8;
            this.a.resumeWith(Result.constructor-impl(r5));
        L8:
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<mr9.k, Unit> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object invoke(Object r2) {
            Intrinsics.checkNotNullParameter((mr9.k) r2, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<ResourceUploadError, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<mr9.l> a;
        public final /* synthetic */ AtomicBoolean b;

        public c(kotlinx.coroutines.i<? super mr9.l> r1, AtomicBoolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r4) {
            ResourceUploadError r5 = (ResourceUploadError) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            FLogger.a.e("GenImagePlannerComponent", "upload image failed", r5);
            if (this.a.isActive() == false) goto L8;
            if (this.b.compareAndSet(false, true) == false) goto L8;
            kotlinx.coroutines.i<mr9.l> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r5)));
        L8:
            return Unit.INSTANCE;
        }
    }

    public GenImagePlannerComponent$uploadImageLegacy$2$2(String r1, GenImagePlannerComponent r2, kotlinx.coroutines.i<? super mr9.l> r3, Continuation<? super GenImagePlannerComponent$uploadImageLegacy$2$2> r4) {
        this.$localPath = r1;
        this.this$0 = r2;
        this.$continuation = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GenImagePlannerComponent$uploadImageLegacy$2$2(this.$localPath, this.this$0, this.$continuation, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r29) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r29);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r29);
        AtomicBoolean r3 = new AtomicBoolean(false);
        ResourceUploader r4 = ResourceUploader.a;
        String r6 = this.$localPath;
        UploadDataType r8 = UploadDataType.IMAGE;
        kotlinx.coroutines.i<mr9.l> r12 = this.$continuation;
        mr9.j r14 = new mr9.j(r6, "bot_chat", r8, new a(r12, r3), b.a, new c(r12, r3), false, null, null, null, this.this$0.A, true, new CountDownLatch(1), null, null, null, null, null, null, null, 2081728);
        this.label = 1;
        if (r4.j(r14, this) != r1) goto L12;
        return r1;
    }
}
