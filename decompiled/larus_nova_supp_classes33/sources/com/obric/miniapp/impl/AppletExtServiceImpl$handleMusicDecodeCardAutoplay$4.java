package com.obric.miniapp.impl;

import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.miniapp.intent.LatestConversationSentMessageResolver;
import com.obric.miniapp.intent.s;
import com.obric.miniapp.intent.u;
import com.obric.miniapp.intent.v;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.impl.AppletExtServiceImpl$handleMusicDecodeCardAutoplay$4", f = "AppletExtServiceImpl.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
final class AppletExtServiceImpl$handleMusicDecodeCardAutoplay$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ u.a $card;
    final /* synthetic */ Message $message;
    final /* synthetic */ Long $messageCreateTimeMs;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AppletExtServiceImpl this$0;

    public AppletExtServiceImpl$handleMusicDecodeCardAutoplay$4(u.a r1, AppletExtServiceImpl r2, Message r3, Long r4, Continuation<? super AppletExtServiceImpl$handleMusicDecodeCardAutoplay$4> r5) {
        this.$card = r1;
        this.this$0 = r2;
        this.$message = r3;
        this.$messageCreateTimeMs = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AppletExtServiceImpl$handleMusicDecodeCardAutoplay$4(this.$card, this.this$0, this.$message, this.$messageCreateTimeMs, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        MusicEntity[] r2 = (MusicEntity[]) this.L$2;
        String r3 = (String) this.L$1;
        v r4 = (v) this.L$0;
        ResultKt.throwOnFailure(r15);
        v r10 = r4;
    L21:
        boolean r6 = ((Boolean) r15).booleanValue();
        Long r7 = this.$messageCreateTimeMs;
        monitor-enter(r10);
        Intrinsics.checkNotNullParameter(r3, "cardId");     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r2, "songs");     // Catch: Throwable -> L42
        MusicEntity r16 = (MusicEntity) ArraysKt.firstOrNull(r2);     // Catch: Throwable -> L42
        if (r16 != null) goto L28;
        monitor-exit(r10);
    L30:
        com.obric.miniapp.intent.k r17 = null;
    L33:
        if (r17 != null) goto L37;
        return Unit.INSTANCE;
    L37:
        if (r17.a == false) goto L39;
        com.bytedance.ai.utils.g.a.i("MiniAppService", "music decode card autoplay started cardId=" + this.$card.a);
    L41:
        return Unit.INSTANCE;
    L39:
        com.bytedance.ai.utils.g.a.w("MiniAppService", "music decode card autoplay failed cardId=" + this.$card.a + ", code=" + r17.b);
        goto L41
    L28:
        if (v.c.g(r3, r16.getId(), r6, r7, System.currentTimeMillis()) == true) goto L31;
        monitor-exit(r10);
        goto L30
    L31:
        r17 = v.e(r3, r2, 0, s.d.b(r3));     // Catch: Throwable -> L42
        monitor-exit(r10);
    L42:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        v r18 = v.a;
        u.a r5 = this.$card;
        String r8 = r5.a;
        MusicEntity[] r9 = r5.b;
        AppletExtServiceImpl r11 = this.this$0;
        Message r12 = this.$message;
        this.L$0 = r18;
        this.L$1 = r8;
        this.L$2 = r9;
        this.label = 1;
        int r13 = AppletExtServiceImpl.l;
        r11.getClass();
        String r14 = r12.getConversationId();
        if (r14 != null) goto L11;
        Object r19 = Boxing.boxBoolean(false);
    L18:
        if (r19 != r0) goto L20;
        return r0;
    L20:
        r10 = r18;
        r2 = r9;
        r15 = r19;
        r3 = r8;
        goto L21
    L11:
        AccountService r20 = AccountService.a;
        Set r21 = SetsKt.setOf(new String[]{r20.getUserId(), r20.getSecUserId()});
        LinkedHashSet r110 = new LinkedHashSet();
        Iterator r22 = r21.iterator();
    L13:
        if (r22.hasNext() == false) goto L17;
        Object r23 = r22.next();
        if ((!StringsKt.isBlank((String) r23)) == false) goto L13;
        r110.add(r23);
        goto L13
    L17:
        r19 = LatestConversationSentMessageResolver.a.a(r14, r12.getReplyId(), r110, new AppletExtServiceImpl$isLatestRoundReply$2(r11), this);
        goto L18
    }
}
