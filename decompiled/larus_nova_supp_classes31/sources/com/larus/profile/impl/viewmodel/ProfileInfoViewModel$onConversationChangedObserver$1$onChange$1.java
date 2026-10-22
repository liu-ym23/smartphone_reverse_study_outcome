package com.larus.profile.impl.viewmodel;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.tencent.open.log.TraceLevel;
import fs9.n;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileInfoViewModel$onConversationChangedObserver$1$onChange$1", f = "ProfileInfoViewModel.kt", i = {0, 1, 1, 1, 1}, l = {484, 119}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "newConversation", "currentList", "profileBot"}, s = {"L$0", "L$0", "L$2", "L$3", "L$5"})
final class ProfileInfoViewModel$onConversationChangedObserver$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<e> $conversation;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ ProfileInfoViewModel this$0;

    public ProfileInfoViewModel$onConversationChangedObserver$1$onChange$1(ProfileInfoViewModel r1, List<e> r2, Continuation<? super ProfileInfoViewModel$onConversationChangedObserver$1$onChange$1> r3) {
        this.this$0 = r1;
        this.$conversation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProfileInfoViewModel$onConversationChangedObserver$1$onChange$1(this.this$0, this.$conversation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0105 -> B:74:0x010f). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 != 2) goto L12;
        n r3 = (n) this.L$5;
        Iterator r7 = (Iterator) this.L$4;
        List r8 = (List) this.L$3;
        e r9 = (e) this.L$2;
        ProfileInfoViewModel r10 = (ProfileInfoViewModel) this.L$1;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L9
        Object r13 = r18;
        kotlinx.coroutines.sync.a r12 = r11;
        ProfileInfoViewModel r14 = r10;
        e r15 = r9;
        List r16 = r8;
        Iterator r17 = r7;
        ProfileInfoViewModel$onConversationChangedObserver$1$onChange$1 r19 = this;
    L74:
        if (Intrinsics.areEqual((String) CollectionsKt.getOrNull((List) r13, 0), r3.e()) == false) goto L66;
        String r110 = r3.e();     // Catch: Throwable -> L67
        if (r110 == null) goto L61;
        BotStatusCacheDelegate r111 = BotStatusCacheDelegate.b;     // Catch: Throwable -> L67
        r111.a(r110, true);     // Catch: Throwable -> L67
        r111.d(r110, ic8.n.l(r15));     // Catch: Throwable -> L67
    L61:
        r3.v(r15.a);     // Catch: Throwable -> L67
        if (r15.a.length() <= 0) goto L64;
        boolean r112 = true;
    L65:
        r3.a = Boxing.boxBoolean(r112);     // Catch: Throwable -> L67
        goto L66
    L64:
        r112 = false;
    L66:
        ProfileInfoViewModel$onConversationChangedObserver$1$onChange$1 r4 = r19;
        Iterator r20 = r17;
        List r21 = r16;
        e r22 = r15;
        ProfileInfoViewModel r113 = r14;
        kotlinx.coroutines.sync.a r114 = r12;
    L35:
        if (r20.hasNext() == false) goto L69;
        n r115 = (n) r20.next();     // Catch: Throwable -> L9
        Integer r116 = r22.t;     // Catch: Throwable -> L9
        if (r116 == null) goto L47;
        if (r116.intValue() != 2) goto L47;
        if (Intrinsics.areEqual(r115.i(), r22.a) == false) goto L35;
        String r117 = r115.e();     // Catch: Throwable -> L9
        if (r117 == null) goto L46;
        BotStatusCacheDelegate.b.a(r117, false);     // Catch: Throwable -> L9
    L46:
        r115.v("");     // Catch: Throwable -> L9
        r115.a = Boxing.boxBoolean(false);     // Catch: Throwable -> L9
    L47:
        Integer r118 = r22.j;     // Catch: Throwable -> L9
        if (r118 == null) goto L35;
        if (r118.intValue() != 3) goto L35;
        r4.L$0 = r114;     // Catch: Throwable -> L9
        r4.L$1 = r113;     // Catch: Throwable -> L9
        r4.L$2 = r22;     // Catch: Throwable -> L9
        r4.L$3 = r21;     // Catch: Throwable -> L9
        r4.L$4 = r20;     // Catch: Throwable -> L9
        r4.L$5 = r115;     // Catch: Throwable -> L9
        r4.label = 2;     // Catch: Throwable -> L9
        r13 = ic8.n.c(r22, r4);     // Catch: Throwable -> L9
        if (r13 != r0) goto L55;
        return r0;
    L55:
        Iterator r119 = r20;
        r19 = r4;
        r3 = r115;
        r12 = r114;
        r14 = r113;
        r15 = r22;
        r16 = r21;
        r17 = r119;
        goto L74
    L69:
        ProfileInfoViewModel.access$get_profileBotsLive$p(r113).postValue(r21);     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r114.unlock(null);
        return Unit.INSTANCE;
    L67:
        th = th;
        kotlinx.coroutines.sync.a r120 = r12;
    L72:
        r120.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        List<e> r5 = (List) this.L$2;
        ProfileInfoViewModel r23 = (ProfileInfoViewModel) this.L$1;
        kotlinx.coroutines.sync.a r24 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);
        r114 = r24;
    L18:
        r21 = (List) ProfileInfoViewModel.access$get_profileBotsLive$p(r23).getValue();     // Catch: Throwable -> L9
        if (r21 != null) goto L23;
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r114.unlock(null);
        return r6;
    L23:
        e r25 = (e) CollectionsKt.getOrNull(r5, 0);     // Catch: Throwable -> L9
        if (r25 != null) goto L29;
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r114.unlock(null);
        return r26;
    L29:
        if (ic8.n.s(r25.a) == false) goto L33;
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r114.unlock(null);
        return r27;
    L33:
        r113 = r23;
        r20 = r21.iterator();     // Catch: Throwable -> L9
        r22 = r25;
        r4 = this;
        goto L35
    L14:
        ResultKt.throwOnFailure(r18);
        kotlinx.coroutines.sync.a r28 = ProfileInfoViewModel.access$getMutex$p(this.this$0);
        r23 = this.this$0;
        List<e> r29 = this.$conversation;
        this.L$0 = r28;
        this.L$1 = r23;
        this.L$2 = r29;
        this.label = 1;
        if (r28.a(null, this) != r0) goto L17;
        return r0;
    L17:
        r114 = r28;
        r5 = r29;
    L9:
        th = th;
        goto L72
    }
}
