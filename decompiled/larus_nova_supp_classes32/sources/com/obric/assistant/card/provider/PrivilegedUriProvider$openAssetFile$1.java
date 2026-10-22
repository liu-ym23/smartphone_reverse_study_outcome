package com.obric.assistant.card.provider;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/content/res/AssetFileDescriptor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.card.provider.PrivilegedUriProvider$openAssetFile$1", f = "PrivilegedUriProvider.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
public final class PrivilegedUriProvider$openAssetFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AssetFileDescriptor>, Object> {
    final /* synthetic */ String $isFetchVideoFirstFrame;
    final /* synthetic */ String $isVideo;
    final /* synthetic */ String $packageName;
    final /* synthetic */ long $startTime;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ String $uriString;
    int label;
    final /* synthetic */ PrivilegedUriProvider this$0;

    /* JADX INFO: renamed from: com.obric.assistant.card.provider.PrivilegedUriProvider$openAssetFile$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/content/res/AssetFileDescriptor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.card.provider.PrivilegedUriProvider$openAssetFile$1$1", f = "PrivilegedUriProvider.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AssetFileDescriptor>, Object> {
        final /* synthetic */ String $isFetchVideoFirstFrame;
        final /* synthetic */ String $isVideo;
        final /* synthetic */ String $packageName;
        final /* synthetic */ long $startTime;
        final /* synthetic */ Uri $uri;
        final /* synthetic */ String $uriString;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ PrivilegedUriProvider this$0;

        public AnonymousClass1(String r1, String r2, String r3, String r4, PrivilegedUriProvider r5, Uri r6, long r7, Continuation<? super AnonymousClass1> r9) {
            this.$packageName = r1;
            this.$uriString = r2;
            this.$isVideo = r3;
            this.$isFetchVideoFirstFrame = r4;
            this.this$0 = r5;
            this.$uri = r6;
            this.$startTime = r7;
            super(2, r9);
        }

        public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
            AnonymousClass1 r10 = new AnonymousClass1(this.$packageName, this.$uriString, this.$isVideo, this.$isFetchVideoFirstFrame, this.this$0, this.$uri, this.$startTime, r13);
            r10.L$0 = r12;
            return r10;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super AssetFileDescriptor> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            if (r3 == 0) goto L10;
            if (r3 != 1) goto L9;
            Uri r4 = (Uri) this.L$3;
            PrivilegedUriProvider r5 = (PrivilegedUriProvider) this.L$2;
            String r6 = (String) this.L$1;
            String r7 = (String) this.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L27
        L15:
            UriFileAccessSession r13 = (UriFileAccessSession) r12;     // Catch: Throwable -> L27
            if (r13.a == 0) goto L18;
            FLogger.a.w("PrivilegedUriProvider", "openFileDescriptorPrivileged failed: status = " + r13.a + ", message = " + r13.b);     // Catch: Throwable -> L27
        L18:
            AssetFileDescriptor r14 = r13.c;     // Catch: Throwable -> L27
            if (r14 != null) goto L21;
        L25:
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L27
        L29:
            Throwable r0 = Result.exceptionOrNull-impl(r15);
            if (r0 == null) goto L33;
            FLogger.a.w("PrivilegedUriProvider", "openFileDescriptorPrivileged failed: " + r0, r0);
        L33:
            if (Result.isFailure-impl(r15) == false) goto L35;
            r15 = null;
        L35:
            long r1 = this.$startTime;
            AssetFileDescriptor r8 = (AssetFileDescriptor) r15;
            FLogger.a.i("PrivilegedUriProvider", "used time " + (SystemClock.elapsedRealtime() - r1) + " ms");
            return r15;
        L21:
            if (Intrinsics.areEqual(r7, "1") == false) goto L25;
            if (Intrinsics.areEqual(r6, "1") == false) goto L25;
            r14 = PrivilegedUriProvider.a(r5, r4, r14);     // Catch: Throwable -> L27
            goto L25
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r12);
            CoroutineScope r16 = (CoroutineScope) this.L$0;
            String r17 = this.$packageName;
            String r9 = this.$uriString;
            r7 = this.$isVideo;
            String r10 = this.$isFetchVideoFirstFrame;
            PrivilegedUriProvider r11 = this.this$0;
            Uri r18 = this.$uri;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L27
            AtomicCapabilitySdk r110 = AtomicCapabilitySdk.INSTANCE;     // Catch: Throwable -> L27
            Uri r20 = UriProtector.parse(r9);     // Catch: Throwable -> L27
            this.L$0 = r7;     // Catch: Throwable -> L27
            this.L$1 = r10;     // Catch: Throwable -> L27
            this.L$2 = r11;     // Catch: Throwable -> L27
            this.L$3 = r18;     // Catch: Throwable -> L27
            this.label = 1;     // Catch: Throwable -> L27
            r12 = r110.openFileDescriptorPrivileged(r17, r20, this);     // Catch: Throwable -> L27
            if (r12 != r2) goto L14;
            return r2;
        L14:
            r6 = r10;
            r5 = r11;
            r4 = r18;
        L27:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L29
        }
    }

    public PrivilegedUriProvider$openAssetFile$1(String r1, String r2, String r3, String r4, PrivilegedUriProvider r5, Uri r6, long r7, Continuation<? super PrivilegedUriProvider$openAssetFile$1> r9) {
        this.$packageName = r1;
        this.$uriString = r2;
        this.$isVideo = r3;
        this.$isFetchVideoFirstFrame = r4;
        this.this$0 = r5;
        this.$uri = r6;
        this.$startTime = r7;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new PrivilegedUriProvider$openAssetFile$1(this.$packageName, this.$uriString, this.$isVideo, this.$isFetchVideoFirstFrame, this.this$0, this.$uri, this.$startTime, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AssetFileDescriptor> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        return r17;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        long r4 = TimeUnit.SECONDS.toMillis(10);
        AnonymousClass1 r3 = new AnonymousClass1(this.$packageName, this.$uriString, this.$isVideo, this.$isFetchVideoFirstFrame, this.this$0, this.$uri, this.$startTime, null);
        this.label = 1;
        Object r5 = TimeoutKt.c(r4, r3, this);
        if (r5 != r1) goto L12;
        return r1;
    L12:
        return r5;
    }
}
