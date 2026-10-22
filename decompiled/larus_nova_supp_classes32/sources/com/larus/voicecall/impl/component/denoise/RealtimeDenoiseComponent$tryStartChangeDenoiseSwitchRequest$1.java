package com.larus.voicecall.impl.component.denoise;

import android.content.Context;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.denoise.RealtimeDenoiseComponent$tryStartChangeDenoiseSwitchRequest$1", f = "RealtimeDenoiseComponent.kt", i = {}, l = {777}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeDenoiseComponent$tryStartChangeDenoiseSwitchRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isOpen;
    int label;
    final /* synthetic */ RealtimeDenoiseComponent this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DenoiseStatusRes.values().length];
            r0[DenoiseStatusRes.FEATURE_DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DenoiseStatusRes.FEATURE_ENABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DenoiseStatusRes.LEARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public RealtimeDenoiseComponent$tryStartChangeDenoiseSwitchRequest$1(boolean r1, RealtimeDenoiseComponent r2, Continuation<? super RealtimeDenoiseComponent$tryStartChangeDenoiseSwitchRequest$1> r3) {
        this.$isOpen = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeDenoiseComponent$tryStartChangeDenoiseSwitchRequest$1(this.$isOpen, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L15:
        f r13 = (f) r12;
        FLogger r2 = FLogger.a;
        RealtimeDenoiseComponent r3 = this.this$0;
        int r4 = RealtimeDenoiseComponent.D;
        r2.i(r3.D3(), "request denoise report result=" + r13);
        if (r13 != null) goto L19;
        r2.e(this.this$0.D3(), "onDenoiseSwitchChanged. request err.");
        t19.s.j(t19.s.a, this.this$0.getContext(), this.this$0.Y2(2131900505), null, false, 28);
        this.this$0.H3(false, this.$isOpen, "net err");
        return Unit.INSTANCE;
    L19:
        RealtimeCallUtil r5 = RealtimeCallUtil.a;
        DenoiseStatusRes r6 = r13.b();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        RealtimeCallUtil.t = r6;
        if (r13.a() == VoiceFeatureAuthStatus.AUTHORIZED) goto L27;
        r2.e(this.this$0.D3(), "onDenoiseSwitchChanged. server return is not AUTHORIZED.");
        this.this$0.H3(false, this.$isOpen, "server return is not AUTHORIZED");
        if (this.$isOpen == false) goto L25;
        this.this$0.X3("tryStartChangeDenoiseSwitchRequest_unauthed");
    L25:
        return Unit.INSTANCE;
    L27:
        if (RealtimeCallUtil.G() == true) goto L29;
        r2.e(this.this$0.D3(), "server is diff from local auth status, so change to auth success.");
        SettingRepoDelegate.b.k(true);
    L29:
        this.this$0.H3(true, this.$isOpen, null);
        this.this$0.W3(r13.b());
        int r14 = a.a[r13.b().ordinal()];
        if (r14 != 1) goto L32;
        t19.s r7 = t19.s.a;
        Context r8 = this.this$0.getContext();
        int r15 = j0.a;
        t19.s.j(r7, r8, j0.d(2131911047), null, false, 28);
        this.this$0.G3("off");
    L39:
        this.this$0.Z3();
        RealtimeDenoiseComponent r16 = this.this$0;
        r16.p = null;
        r16.c4();
        return Unit.INSTANCE;
    L32:
        if (r14 != 2) goto L34;
        t19.s r17 = t19.s.a;
        Context r9 = this.this$0.getContext();
        r17.getClass();
        t19.s.o(r9, 2131911048, false);
        this.this$0.G3("on");
        goto L39
    L34:
        if (r14 != 3) goto L39;
        this.this$0.getClass();
        t19.s.j(t19.s.a, this.this$0.getContext(), RealtimeDenoiseComponent.p3(2131911045), null, false, 28);
        this.this$0.G3("study");
        goto L39
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        if (this.$isOpen == false) goto L11;
        DenoiseUploadStatus r18 = DenoiseUploadStatus.Enable;
    L12:
        e0 r10 = new e0(r18, ((h88.a) ((e3a.a) this.this$0.w.getValue())).d, this.this$0.C3().a().d);
        DenoiseNetUtil r19 = DenoiseNetUtil.a;
        this.label = 1;
        r12 = r19.a(r10, this);
        if (r12 != r0) goto L15;
        return r0;
    L11:
        r18 = DenoiseUploadStatus.Close;
        goto L12
    }
}
