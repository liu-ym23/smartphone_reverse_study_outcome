package com.larus.bmhome.chat.deepresearch.component;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.IInstantMessenger;
import com.larus.podcast.api.PodcastClickSource;
import com.larus.podcast.api.PodcastGenerateApiKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchContentComponent$tryRequestPlayPodcast$3", f = "DeepReSearchContentComponent.kt", i = {1, 2}, l = {319, 326, 333}, m = "invokeSuspend", n = {"result", "result"}, s = {"L$2", "L$1"})
public final class DeepReSearchContentComponent$tryRequestPlayPodcast$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needFullscreenPlayer;
    final /* synthetic */ Function0<Unit> $onComplete;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DeepReSearchContentComponent this$0;

    public DeepReSearchContentComponent$tryRequestPlayPodcast$3(DeepReSearchContentComponent r1, boolean r2, Function0<Unit> r3, Continuation<? super DeepReSearchContentComponent$tryRequestPlayPodcast$3> r4) {
        this.this$0 = r1;
        this.$needFullscreenPlayer = r2;
        this.$onComplete = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DeepReSearchContentComponent$tryRequestPlayPodcast$3(this.this$0, this.$needFullscreenPlayer, this.$onComplete, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r7 = true;
        if (r2 == 0) goto L19;
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L12;
        if (r2 != 3) goto L11;
        com.larus.podcast.api.a r3 = (com.larus.podcast.api.a) this.L$1;
        DeepReSearchContentComponent r4 = (DeepReSearchContentComponent) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L73
    L51:
        IInstantMessenger r15 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);     // Catch: Throwable -> L73
        if (r15 == null) goto L54;
        boolean r16 = r15.b();     // Catch: Throwable -> L73
    L55:
        r4.D = false;     // Catch: Throwable -> L73
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L73
        Map<String, Long> r6 = DeepReSearchContentComponent.M;     // Catch: Throwable -> L73
        StringBuilder r8 = new StringBuilder("request generate podcast finished. result=");     // Catch: Throwable -> L73
        if (r3 == null) goto L58;
        Integer r0 = Boxing.boxInt(r3.b());     // Catch: Throwable -> L73
    L59:
        r8.append(r0);     // Catch: Throwable -> L73
        r8.append(" isConnect=");     // Catch: Throwable -> L73
        if (r16 == true) goto L63;
        r7 = false;
    L63:
        r8.append(r7);     // Catch: Throwable -> L73
        r8.append(" auditStatus=");     // Catch: Throwable -> L73
        if (r3 == null) goto L66;
        Integer r17 = Boxing.boxInt(r3.a());     // Catch: Throwable -> L73
    L67:
        r8.append(r17);     // Catch: Throwable -> L73
        r8.append(" has_error=");     // Catch: Throwable -> L73
        if (r3 == null) goto L70;
        Boolean r18 = Boxing.boxBoolean(r3.c());     // Catch: Throwable -> L73
    L71:
        r8.append(r18);     // Catch: Throwable -> L73
        r5.d("DeepSearchContent", r8.toString());     // Catch: Throwable -> L73
        r4.F = null;     // Catch: Throwable -> L73
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L73
    L75:
        DeepReSearchContentComponent r9 = this.this$0;
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 == null) goto L80;
        r9.D = false;
        FLogger r10 = FLogger.a;
        Map<String, Long> r11 = DeepReSearchContentComponent.M;
        r10.e("DeepSearchContent", "error happened when request generate podcast msg=" + r110.getMessage());
    L80:
        return Unit.INSTANCE;
    L70:
        r18 = null;
        goto L71
    L66:
        r17 = null;
        goto L67
    L58:
        r0 = null;
        goto L59
    L54:
        r16 = false;
        goto L55
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        com.larus.podcast.api.a r12 = (com.larus.podcast.api.a) this.L$2;
        Function0<Unit> r13 = (Function0) this.L$1;
        DeepReSearchContentComponent r20 = (DeepReSearchContentComponent) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L73
        com.larus.podcast.api.a r111 = r12;
    L15:
        r4 = r20;
        if (r111 != null) goto L40;
    L42:
        boolean r21 = false;
    L43:
        if (r21 == false) goto L50;
        t19.s.a.g(r4.getContext(), 2131908397, false);     // Catch: Throwable -> L73
        Job r22 = r4.q;     // Catch: Throwable -> L73
        if (r22 == null) goto L47;
        Job.DefaultImpls.cancel$default(r22, null, 1, null);     // Catch: Throwable -> L73
    L47:
        MainCoroutineDispatcher r23 = Dispatchers.getMain();     // Catch: Throwable -> L73
        DeepReSearchContentComponent$tryRequestPlayPodcast$3$1$2 r112 = new DeepReSearchContentComponent$tryRequestPlayPodcast$3$1$2(r13, null);     // Catch: Throwable -> L73
        this.L$0 = r4;     // Catch: Throwable -> L73
        this.L$1 = r111;     // Catch: Throwable -> L73
        this.L$2 = null;     // Catch: Throwable -> L73
        this.label = 3;     // Catch: Throwable -> L73
        if (BuildersKt.withContext(r23, r112, this) != r1) goto L50;
        return r1;
    L50:
        r3 = r111;
        goto L51
    L40:
        if (r111.c() != true) goto L42;
        r21 = true;
        goto L43
    L16:
        Function0<Unit> r24 = (Function0) this.L$1;
        r20 = (DeepReSearchContentComponent) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L73
    L27:
        r111 = (com.larus.podcast.api.a) ((com.larus.network.http.a) r14).b;     // Catch: Throwable -> L73
        if (r111 != null) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == false) goto L37;
        t19.s.a.g(r20.getContext(), 2131908399, false);     // Catch: Throwable -> L73
        MainCoroutineDispatcher r114 = Dispatchers.getMain();     // Catch: Throwable -> L73
        DeepReSearchContentComponent$tryRequestPlayPodcast$3$1$1 r115 = new DeepReSearchContentComponent$tryRequestPlayPodcast$3$1$1(r24, null);     // Catch: Throwable -> L73
        this.L$0 = r20;     // Catch: Throwable -> L73
        this.L$1 = r24;     // Catch: Throwable -> L73
        this.L$2 = r111;     // Catch: Throwable -> L73
        this.label = 2;     // Catch: Throwable -> L73
        if (BuildersKt.withContext(r114, r115, this) != r1) goto L37;
        return r1;
    L37:
        r13 = r24;
        goto L15
    L30:
        if (r111.a() != 1) goto L32;
        r113 = true;
        goto L33
    L19:
        ResultKt.throwOnFailure(r14);
        r20 = this.this$0;
        boolean r116 = this.$needFullscreenPlayer;
        r24 = this.$onComplete;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L73
        Map<String, Long> r118 = DeepReSearchContentComponent.M;     // Catch: Throwable -> L73
        String r119 = r20.C3();     // Catch: Throwable -> L73
        if (r116 == false) goto L23;
        boolean r120 = true;
    L24:
        PodcastClickSource r121 = PodcastClickSource.DeepResearch;     // Catch: Throwable -> L73
        this.L$0 = r20;     // Catch: Throwable -> L73
        this.L$1 = r24;     // Catch: Throwable -> L73
        this.label = 1;     // Catch: Throwable -> L73
        r14 = PodcastGenerateApiKt.a(r119, r120, r121, null, this);     // Catch: Throwable -> L73
        if (r14 != r1) goto L27;
        return r1;
    L23:
        r120 = false;
    L73:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    }
}
