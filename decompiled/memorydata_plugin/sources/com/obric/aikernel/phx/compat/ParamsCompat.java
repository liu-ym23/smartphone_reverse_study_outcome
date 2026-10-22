package com.obric.aikernel.phx.compat;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.aikernel.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.SdkContext;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/phx/compat/ParamsCompat;", "", "()V", "TAG", "", "grantUri", "", Params.FILE_PATH, "fd", "Landroid/content/res/AssetFileDescriptor;", "timeoutMs", "", "(Ljava/lang/String;Landroid/content/res/AssetFileDescriptor;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStartCompat", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startCompat", "Landroid/os/Bundle;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ParamsCompat {
    public static final ParamsCompat INSTANCE = null;
    private static final String TAG = "ParamsCompat";

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$grantUri$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {0, 0, 0, 0}, l = {31}, m = "grantUri", n = {"this", Params.FILE_PATH, "fd", "timeoutMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        AnonymousClass1(ParamsCompat r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return ParamsCompat.access$grantUri(this.this$0, null, null, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$onStartCompat$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {}, l = {25}, m = "onStartCompat", n = {}, s = {})
    static final class C09941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        C09941(ParamsCompat r3, Continuation<? super C09941> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ParamsCompat.access$onStartCompat(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$startCompat$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {0}, l = {16}, m = "startCompat", n = {"$this$startCompat"}, s = {"L$0"})
    static final class C09951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        C09951(ParamsCompat r3, Continuation<? super C09951> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.startCompat(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        INSTANCE = new ParamsCompat();
    }

    private ParamsCompat() {
    }

    public static final /* synthetic */ Object access$grantUri(ParamsCompat r6, String r7, AssetFileDescriptor r8, long r9, Continuation r11) {
        return r6.grantUri(r7, r8, r9, (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$onStartCompat(ParamsCompat r2, RequestParams r3, Continuation r4) {
        return r2.onStartCompat(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object grantUri(String r7, AssetFileDescriptor r8, long r9, Continuation<? super Unit> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r12, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r9 = r1.J$0;
        r8 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r1.L$2, AssetFileDescriptor.class, "com.obric.memorydata.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        ParamsCompat this = (ParamsCompat) ZeusTransformUtils.preCheckCast(r1.L$0, ParamsCompat.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L17:
        a r14 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L27;
        ParamsCompat r6 = (ParamsCompat) ZeusTransformUtils.preCheckCast(this, ParamsCompat.class, "com.obric.memorydata.plugin");
        AIKLog.INSTANCE.w(TAG, "grantUri get null binder!");
    L26:
        return Unit.INSTANCE;
    L27:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        Bundle r15 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_GrantUri, TAG, "grantUri");     // Catch: Throwable -> L21
        r15.putString(IdlKeys.Args_GrantUri, r7);     // Catch: Throwable -> L21
        r15.putParcelable(IdlKeys.Args_GrantFd, (Parcelable) ZeusTransformUtils.preCheckCast(r8, Parcelable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        r15.putLong(IdlKeys.Args_Timeout, r9);     // Catch: Throwable -> L21
        Object r16 = Result.m1421constructorimpl(r14.a(r15));     // Catch: Throwable -> L21
    L23:
        Result.m1420boximpl(r16);
    L21:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        SdkContext r18 = SdkContext.INSTANCE;
        r1.L$0 = this;
        r1.L$1 = r7;
        r1.L$2 = r8;
        r1.J$0 = r9;
        r1.label = 1;
        r13 = r18.getBinder(r1);
        if (r13 != r3) goto L17;
        return r3;
    L7:
        r1 = new AnonymousClass1(this, r12);
        goto L8
    }

    static /* synthetic */ Object grantUri$default(ParamsCompat r6, String r7, AssetFileDescriptor r8, long r9, Continuation r11, int r12, Object r13) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L6;
        r9 = ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    L6:
        return r6.grantUri(r7, r8, r9, r5);
    }

    private final Object onStartCompat(RequestParams r11, Continuation<? super Unit> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, C09941.class) == false) goto L7;
        C09941 r0 = (C09941) ZeusTransformUtils.preCheckCast(r13, C09941.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        C09941 r7 = r0;
        Object r10 = r7.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r7.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        String r3 = r11.getBackend().getString(Params.FILE_PATH);
        if (r3 == null) goto L22;
        AssetFileDescriptor r4 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r11.getBackend().getParcelable(Params.FD_ASSET), AssetFileDescriptor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L22;
        ParamsCompat r15 = INSTANCE;
        r7.label = 1;
        if (grantUri$default(r15, r3, r4, 0, r7, 4, null) != r14) goto L22;
        return r14;
    L7:
        r0 = new C09941(this, r13);
        goto L8
    }

    public final Object startCompat(RequestParams r6, Continuation<? super Bundle> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C09951.class) == false) goto L7;
        C09951 r0 = (C09951) ZeusTransformUtils.preCheckCast(r8, C09951.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        RequestParams r5 = (RequestParams) ZeusTransformUtils.preCheckCast(r0.L$0, RequestParams.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        r6 = r5;
    L20:
        return r6.start();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (SdkContext.INSTANCE.isLegacyArch() == false) goto L20;
        r0.L$0 = r6;
        r0.label = 1;
        if (onStartCompat(r6, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new C09951(this, r8);
        goto L8
    }
}
