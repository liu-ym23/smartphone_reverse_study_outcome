package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.im.service.audio.z0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import pf9.d0;
import pf9.e0;
import pf9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$2$onSessionEvent$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGOnboardingViewModelV2$2$onSessionEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z0.a $event;
    int label;
    final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

    public DoraGOnboardingViewModelV2$2$onSessionEvent$1(DoraGOnboardingViewModelV2 r1, z0.a r2, Continuation<? super DoraGOnboardingViewModelV2$2$onSessionEvent$1> r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGOnboardingViewModelV2$2$onSessionEvent$1(this.this$0, this.$event, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L74;
        ResultKt.throwOnFailure(r21);
        IDoraService.h r6 = DoraGOnboardingViewModelV2.access$getSession(this.this$0);
        boolean r7 = true;
        if (r6 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == true) goto L12;
        pf9.z r9 = this.$event;
        if ((r9 instanceof pf9.o) == false) goto L25;
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "call start,  cur wakeup query " + this.this$0.get_wakeupQueryUiStateFlow().getValue());
        if (Intrinsics.areEqual(this.this$0.get_wakeupQueryUiStateFlow().getValue(), a0.d.a) == false) goto L19;
        this.this$0.get_wakeupQueryUiStateFlow().setValue(a0.e.a);
    L19:
        if (DoraGOnboardingViewModelV2.access$getMVuiMode$p(this.this$0) != 14) goto L22;
        this.this$0.playVideoCallTTS();
    L72:
        return Unit.INSTANCE;
    L22:
        if (DoraGOnboardingViewModelV2.access$getMVuiMode$p(this.this$0) != 6) goto L72;
        this.this$0.stopTTS("call start");
        this.this$0.playWakeUpTTS();
        goto L72
    L25:
        if ((r9 instanceof pf9.z) == false) goto L28;
        DoraGOnboardingViewModelV2.access$setMCurQueryId$p(this.this$0, r9.a);
        this.this$0.stopTTS("next query begin, cur tts stop");
        this.this$0.get_wakeupQueryUiStateFlow().setValue(a0.b.a);
        goto L72
    L28:
        if ((r9 instanceof pf9.a0) == false) goto L31;
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "query end");
        this.this$0.get_avatarUiStateFlow().setValue(AvatarUiState.THINKING);
        this.this$0.get_wakeupQueryUiStateFlow().setValue(a0.c.a);
        goto L72
    L31:
        if ((r9 instanceof d0) == false) goto L34;
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "replay begin, wakeup query : " + this.this$0.get_wakeupQueryUiStateFlow().getValue());
        goto L72
    L34:
        if ((r9 instanceof f0) == true) goto L72;
        if ((r9 instanceof e0) == false) goto L63;
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "replay end, wakeup query : " + this.this$0.get_wakeupQueryUiStateFlow().getValue());
        if (Intrinsics.areEqual(this.this$0.get_wakeupQueryUiStateFlow().getValue(), a0.c.a) == false) goto L72;
        Ref.IntRef r10 = new Ref.IntRef();
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        String r12 = DoraGOnboardingViewModelV2.access$getMCurQueryId$p(this.this$0);     // Catch: Throwable -> L59
        if (r12 == null) goto L61;
        DoraGOnboardingViewModelV2 r13 = this.this$0;     // Catch: Throwable -> L59
        IDoraAVLinkService r14 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L59
        if (r14 == null) goto L45;
        Integer r15 = r14.y1(r12);     // Catch: Throwable -> L59
    L46:
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "1 query id: " + DoraGOnboardingViewModelV2.access$getMCurQueryId$p(r13) + ", imageUuid: " + r15);     // Catch: Throwable -> L59
        if (r15 == null) goto L57;
        r10.element = 1;     // Catch: Throwable -> L59
        byte[] r5 = ((uj4.g) DoraGOnboardingViewModelV2.access$getMQueryImages$p(r13).b(r15)).b;     // Catch: Throwable -> L59
        if (r5 != null) goto L51;
    L55:
        g49.d.d(DoraGOnboardingViewModelV2.TAG, " data is null or empty");     // Catch: Throwable -> L59
    L56:
        r11.element = BitmapFactory.decodeByteArray(r5, 0, r5.length);     // Catch: Throwable -> L59
        Matrix r16 = new Matrix();     // Catch: Throwable -> L59
        r16.postRotate(90.0f);     // Catch: Throwable -> L59
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "2 query id: " + DoraGOnboardingViewModelV2.access$getMCurQueryId$p(r13) + ", imageUuid: " + r15);     // Catch: Throwable -> L59
        Object r3 = r11.element;     // Catch: Throwable -> L59
        r11.element = Bitmap.createBitmap((Bitmap) r3, 0, 0, ((Bitmap) r3).getWidth(), ((Bitmap) r11.element).getHeight(), r16, true);     // Catch: Throwable -> L59
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "3 query id: " + DoraGOnboardingViewModelV2.access$getMCurQueryId$p(r13) + ", imageUuid: " + r15);     // Catch: Throwable -> L59
        goto L57
    L51:
        if (r5.length == 0) goto L54;
        r7 = false;
    L54:
        if (r7 == false) goto L56;
    L57:
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "4 query id: " + DoraGOnboardingViewModelV2.access$getMCurQueryId$p(r13) + ", imageUuid: " + r15);     // Catch: Throwable -> L59
        goto L61
    L45:
        r15 = null;
    L61:
        this.this$0.get_wakeupQueryUiStateFlow().setValue(new a0.a(r10.element, (Bitmap) r11.element, 4));
    L59:
        th = move-exception;
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "err: " + th.getMessage());
        g49.d.c(DoraGOnboardingViewModelV2.TAG, "onSession event image err:", th);
        goto L61
    L63:
        if ((r9 instanceof pf9.q) == false) goto L69;
        Iterator r0 = ((pf9.q) r9).a.iterator();
    L66:
        if (r0.hasNext() == false) goto L72;
        pf9.p r2 = (pf9.p) r0.next();
        goto L66
    L69:
        if ((r9 instanceof pf9.n) == false) goto L72;
        g49.d.d(DoraGOnboardingViewModelV2.TAG, "call finish");
        goto L72
    L12:
        return Unit.INSTANCE;
    L7:
        if (r6.a() != 11) goto L9;
        r8 = true;
        goto L10
    L74:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
