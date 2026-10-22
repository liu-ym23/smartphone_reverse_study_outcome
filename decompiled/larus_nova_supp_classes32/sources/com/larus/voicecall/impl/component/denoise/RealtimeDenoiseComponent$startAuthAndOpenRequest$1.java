package com.larus.voicecall.impl.component.denoise;

import android.content.Context;
import com.larus.bmhome.chat.model.repo.IUserSettingRepoService;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.denoise.RealtimeDenoiseComponent$startAuthAndOpenRequest$1", f = "RealtimeDenoiseComponent.kt", i = {1}, l = {700, 717, 723}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class RealtimeDenoiseComponent$startAuthAndOpenRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onFail;
    final /* synthetic */ Function1<f, Unit> $onSuccess;
    Object L$0;
    int label;
    final /* synthetic */ RealtimeDenoiseComponent this$0;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.denoise.RealtimeDenoiseComponent$startAuthAndOpenRequest$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.denoise.RealtimeDenoiseComponent$startAuthAndOpenRequest$1$1", f = "RealtimeDenoiseComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<f, Unit> $onSuccess;
        final /* synthetic */ f $result;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super f, Unit> r1, f r2, Continuation<? super AnonymousClass1> r3) {
            this.$onSuccess = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$onSuccess, this.$result, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$onSuccess.invoke(this.$result);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealtimeDenoiseComponent$startAuthAndOpenRequest$1(RealtimeDenoiseComponent r1, Function1<? super String, Unit> r2, Function1<? super f, Unit> r3, Continuation<? super RealtimeDenoiseComponent$startAuthAndOpenRequest$1> r4) {
        this.this$0 = r1;
        this.$onFail = r2;
        this.$onSuccess = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimeDenoiseComponent$startAuthAndOpenRequest$1(this.this$0, this.$onFail, this.$onSuccess, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L32:
        RealtimeDenoiseComponent r11 = this.this$0;
        int r2 = RealtimeDenoiseComponent.D;
        r11.c4();
        this.this$0.p = null;
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        f r3 = (f) this.L$0;
        ResultKt.throwOnFailure(r10);
    L28:
        boolean r12 = ((Boolean) r10).booleanValue();
        FLogger r4 = FLogger.a;
        RealtimeDenoiseComponent r5 = this.this$0;
        int r6 = RealtimeDenoiseComponent.D;
        r4.e(r5.D3(), "update local voice feature train authorize. result=" + r12);
    L29:
        RealtimeCallUtil r13 = RealtimeCallUtil.a;
        DenoiseStatusRes r7 = r3.b();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        RealtimeCallUtil.t = r7;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r8 = new AnonymousClass1(this.$onSuccess, r3, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(r14, r8, this) != r0) goto L32;
        return r0;
    L11:
        ResultKt.throwOnFailure(r10);
    L15:
        r3 = (f) r10;
        if (r3 != null) goto L20;
        FLogger r15 = FLogger.a;
        RealtimeDenoiseComponent r9 = this.this$0;
        int r16 = RealtimeDenoiseComponent.D;
        r15.e(r9.D3(), "clickWithDebounce result is null");
        this.$onFail.invoke("net error");
        t19.s r17 = t19.s.a;
        Context r18 = this.this$0.getContext();
        int r19 = j0.a;
        t19.s.j(r17, r18, j0.d(2131900505), null, false, 28);
        return Unit.INSTANCE;
    L20:
        if (r3.a() == VoiceFeatureAuthStatus.AUTHORIZED) goto L23;
        this.$onFail.invoke("clickWithDebounce authStatus is not authorized");
        FLogger r110 = FLogger.a;
        RealtimeDenoiseComponent r20 = this.this$0;
        int r21 = RealtimeDenoiseComponent.D;
        r110.e(r20.D3(), "clickWithDebounce authStatus is not authorized");
        return Unit.INSTANCE;
    L23:
        FLogger r111 = FLogger.a;
        RealtimeDenoiseComponent r22 = this.this$0;
        int r23 = RealtimeDenoiseComponent.D;
        r111.i(r22.D3(), "startAuthAndOpenRequest on net result=" + r3 + '.');
        if (SettingRepoDelegate.b.k(true) == true) goto L29;
        IUserSettingRepoService r112 = zh8.a.d;
        this.L$0 = r3;
        this.label = 2;
        r10 = r112.g(this);
        if (r10 != r0) goto L28;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        e0 r113 = new e0(DenoiseUploadStatus.AuthorizedAndEnabled, ((h88.a) ((e3a.a) this.this$0.w.getValue())).d, this.this$0.C3().a().d);
        DenoiseNetUtil r24 = DenoiseNetUtil.a;
        this.label = 1;
        r10 = r24.a(r113, this);
        if (r10 != r0) goto L15;
        return r0;
    }
}
