package com.larus.drive.sdk.impl.preview;

import android.os.SystemClock;
import com.larus.drive.sdk.api.network.api.DriveApi;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$resolveResourceUri$2", f = "AiFilePreviewCoordinator.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
public final class AiFilePreviewCoordinator$resolveResourceUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ long $startedAtMs;
    final /* synthetic */ String $uri;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$resolveResourceUri$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$resolveResourceUri$2$1", f = "AiFilePreviewCoordinator.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ long $startedAtMs;
        final /* synthetic */ String $uri;
        int label;

        public AnonymousClass1(String r1, long r2, Continuation<? super AnonymousClass1> r4) {
            this.$uri = r1;
            this.$startedAtMs = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$uri, this.$startedAtMs, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            dm9.a.b r15 = (dm9.a) r14;
            if ((r15 instanceof dm9.a.a) == false) goto L15;
            FLogger.a.w("AiFilePreview", "resolve failed, reason=network");
            return null;
        L15:
            if ((r15 instanceof dm9.a.b) == false) goto L39;
            dm9.a.b r16 = r15;
            if (r16.a.isSuccess() == true) goto L20;
            FLogger.a.w("AiFilePreview", "resolve failed, reason=biz_error");
            return null;
        L20:
            d89.a r17 = (d89.a) r16.a.getData();
            if (r17 == null) goto L23;
            Map<String, String> r18 = r17.a();
        L24:
            if (r18 != null) goto L27;
            FLogger.a.w("AiFilePreview", "resolve failed, reason=invalid_response");
            return null;
        L27:
            String r110 = r18.get(this.$uri);
            if (r110 != null) goto L30;
        L32:
            r110 = null;
        L33:
            if (r110 != null) goto L36;
            FLogger.a.w("AiFilePreview", "resolve failed, reason=map_missing");
            return null;
        L36:
            FLogger.a.i("AiFilePreview", "resolve success, costMs=" + (SystemClock.elapsedRealtime() - this.$startedAtMs));
            return r110;
        L30:
            if ((!StringsKt.isBlank(r110)) == false) goto L32;
        L23:
            r18 = null;
            goto L24
        L39:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            DriveApi.a r111 = DriveApi.a;
            AiFilePreviewCoordinator$resolveResourceUri$2$1$result$1 r6 = new AiFilePreviewCoordinator$resolveResourceUri$2$1$result$1(this.$uri, null);
            this.label = 1;
            r111.getClass();
            FlowHttpConnection r112 = FlowHttpConnection.a;
            r14 = FlowHttpConnection.g("Basic", DriveApi.class, r6, true, "alice/resource/mget_file_tokens_by_uris", null, null, this, 224);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    public AiFilePreviewCoordinator$resolveResourceUri$2(String r1, long r2, Continuation<? super AiFilePreviewCoordinator$resolveResourceUri$2> r4) {
        this.$uri = r1;
        this.$startedAtMs = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AiFilePreviewCoordinator$resolveResourceUri$2(this.$uri, this.$startedAtMs, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$uri, this.$startedAtMs, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r9, r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
