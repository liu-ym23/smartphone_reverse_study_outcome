package com.larksuite.component.card.component.audio.service;

import android.app.Application;
import com.larksuite.component.card.component.audio.monitor.CardAudioMonitor;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.resources.CardResource;
import com.larksuite.component.card.resources.e;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.audio.service.CardAudioServiceImpl$loadResourceAndPlay$2", f = "CardAudioServiceImpl.kt", i = {0}, l = {191}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class CardAudioServiceImpl$loadResourceAndPlay$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioInfo $audioInfo;
    final /* synthetic */ int $position;
    final /* synthetic */ String $sessionID;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CardAudioServiceImpl this$0;

    public CardAudioServiceImpl$loadResourceAndPlay$2(AudioInfo r1, CardAudioServiceImpl r2, String r3, int r4, Continuation<? super CardAudioServiceImpl$loadResourceAndPlay$2> r5) {
        this.$audioInfo = r1;
        this.this$0 = r2;
        this.$sessionID = r3;
        this.$position = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CardAudioServiceImpl$loadResourceAndPlay$2 r6 = new CardAudioServiceImpl$loadResourceAndPlay$2(this.$audioInfo, this.this$0, this.$sessionID, this.$position, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = "";
        boolean r5 = true;
        CardResource r6 = null;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L16 ErrorResult -> L22 CancellationException -> L39
    L14:
        r6 = (CardResource) r14;     // Catch: Throwable -> L16 ErrorResult -> L22 CancellationException -> L39
    L40:
        if (r6 == null) goto L42;
        CardAudioServiceImpl r15 = this.this$0;
        String r4 = this.$sessionID;
        AudioInfo r7 = this.$audioInfo;
        int r8 = this.$position;
        int r9 = CardAudioServiceImpl.g;
        r15.o(r4, r7, r6, r8);
    L44:
        return Unit.INSTANCE;
    L42:
        CardAudioServiceImpl.q(this.this$0, this.$sessionID, CardAudioStateEntity.CardAudioStateEnum.ERROR, Boxing.boxInt(0), null, 8);
        goto L44
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        com.larksuite.component.card.resources.b r10 = new com.larksuite.component.card.resources.b(CardResource.ResourceType.AUDIO, this.$audioInfo.getKey(), this.$audioInfo.getVisitInfo());     // Catch: Throwable -> L16 ErrorResult -> L22 CancellationException -> L39
        e r11 = this.this$0.a;     // Catch: Throwable -> L16 ErrorResult -> L22 CancellationException -> L39
        this.L$0 = r16;     // Catch: Throwable -> L16 ErrorResult -> L22 CancellationException -> L39
        this.label = 1;     // Catch: Throwable -> L16 ErrorResult -> L22 CancellationException -> L39
        r14 = r11.b(r10, this);     // Catch: Throwable -> L16 ErrorResult -> L22 CancellationException -> L39
        if (r14 != r0) goto L14;
        return r0;
    L22:
        e = move-exception;
        String r12 = e.getDisplayMsg();
        if (r12 != null) goto L26;
    L33:
        r12 = UIHelper.getString(2131892819);
    L34:
        Application r13 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r12);
        UDToast.show(r13, r12);
        StringBuilder r17 = new StringBuilder();
        int r19 = CardAudioServiceImpl.g;
        r17.append(CardAudioServiceImpl.c.a(this.$sessionID));
        r17.append(" forceLoadResource error result");
        Log.e("CardAudioService", r17.toString(), e);
        CardAudioServiceImpl r20 = this.this$0;
        String r21 = this.$sessionID;
        CardAudioMonitor.AudioOperationFailType r22 = CardAudioMonitor.AudioOperationFailType.RESOURCE;
        int r23 = e.getCode();
        String r110 = e.getDebugMsg();
        if (r110 == null) goto L38;
        r3 = r110;
    L38:
        CardAudioServiceImpl.m(r20, r21, r22, r23, r3);
        goto L40
    L26:
        if (r12.length() > 0) goto L29;
        r5 = false;
    L29:
        if (r5 == true) goto L32;
        r12 = null;
    L32:
        if (r12 != null) goto L34;
    L39:
        StringBuilder r111 = new StringBuilder();
        int r24 = CardAudioServiceImpl.g;
        r111.append(CardAudioServiceImpl.c.a(this.$sessionID));
        r111.append(" forceLoadResource cancelled");
        Log.e("CardAudioService", r111.toString());
    L16:
        th = move-exception;
        StringBuilder r25 = new StringBuilder();
        int r26 = CardAudioServiceImpl.g;
        r25.append(CardAudioServiceImpl.c.a(this.$sessionID));
        r25.append(" forceLoadResource error");
        Log.e("CardAudioService", r25.toString(), th);
        CardAudioServiceImpl r27 = this.this$0;
        String r29 = this.$sessionID;
        CardAudioMonitor.AudioOperationFailType r30 = CardAudioMonitor.AudioOperationFailType.RESOURCE;
        String r112 = th.getMessage();
        if (r112 == null) goto L21;
        r3 = r112;
    L21:
        CardAudioServiceImpl.m(r27, r29, r30, -2, r3);
        goto L40
    }
}
