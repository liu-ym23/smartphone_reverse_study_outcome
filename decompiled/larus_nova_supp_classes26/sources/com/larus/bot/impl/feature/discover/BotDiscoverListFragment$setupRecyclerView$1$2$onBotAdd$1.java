package com.larus.bot.impl.feature.discover;

import android.content.Context;
import android.os.Bundle;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.utils.a4;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$setupRecyclerView$1$2$onBotAdd$1", f = "BotDiscoverListFragment.kt", i = {0, 0}, l = {496}, m = "invokeSuspend", n = {"success", "start$iv"}, s = {"L$0", "J$0"})
public final class BotDiscoverListFragment$setupRecyclerView$1$2$onBotAdd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    final /* synthetic */ int $position;
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$setupRecyclerView$1$2$onBotAdd$1(BotDiscoverListFragment r1, RecommendBot r2, int r3, Continuation<? super BotDiscoverListFragment$setupRecyclerView$1$2$onBotAdd$1> r4) {
        this.this$0 = r1;
        this.$data = r2;
        this.$position = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotDiscoverListFragment$setupRecyclerView$1$2$onBotAdd$1(this.this$0, this.$data, this.$position, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        long r5 = this.J$0;
        int r1 = this.I$0;
        BotDiscoverListFragment r3 = (BotDiscoverListFragment) this.L$2;
        RecommendBot r7 = (RecommendBot) this.L$1;
        Ref.BooleanRef r8 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r18);
        long r9 = r5;
        Object r6 = r18;
    L16:
        if (((Boolean) r6).booleanValue() == true) goto L21;
        r8.element = false;
        BotStatusCacheDelegate r10 = BotStatusCacheDelegate.b;
        String r11 = r7.o();
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r10.a(r11, false);
        int r12 = BotDiscoverListFragment.A;
        r3.Z90().notifyItemChanged(r1);
        t19.s r4 = t19.s.a;
        Context r13 = r3.getContext();
        r4.getClass();
        t19.s.b(r13, 2131908080, false);
    L21:
        long r14 = System.currentTimeMillis() - r9;
        BotDiscoverListFragment r15 = this.this$0;
        RecommendBot r16 = this.$data;
        boolean r17 = r8.element;
        int r19 = BotDiscoverListFragment.A;
        Bundle r20 = r15.getArguments();
        String r21 = null;
        if (r20 == null) goto L24;
        String r22 = r20.getString("previous_page", "");
    L25:
        JSONObject r23 = IAIChatControlTraceService.a.Xb(r16.a);
        String r110 = r16.o();
        String r111 = r16.o();
        String r112 = r15.W90(r16);
        String r24 = IAIChatService.a.j8().a(r16);
        zp9.w r113 = r15.Y90().getTabTag();
        if (r113 == null) goto L28;
        String r114 = r113.b;
    L30:
        if (com.larus.utils.o0.d(r22) == false) goto L32;
        r21 = r22;
    L32:
        Intrinsics.checkNotNullParameter(r23, "params");
        if (r17 == false) goto L36;
        int r25 = 1;
    L56:
        r23.put("success", r25);     // Catch: JSONException -> L52
        r23.put("duration", r14);     // Catch: JSONException -> L52
        if (r110 == null) goto L40;
        r23.put("bot_id", r110);     // Catch: JSONException -> L52
    L40:
        r23.put("chat_type", r112);     // Catch: JSONException -> L52
        r23.put("click_from", "bot_discover");     // Catch: JSONException -> L52
        if (r114 == null) goto L43;
        r23.put("discover_page_bot_type", r114);     // Catch: JSONException -> L52
    L43:
        r23.put("enter_method", "click_plus");     // Catch: JSONException -> L52
        if (r24 == null) goto L46;
        r23.put("is_immersive_background", r24);     // Catch: JSONException -> L52
    L46:
        if (r21 == null) goto L48;
        r23.put("previous_page", r21);     // Catch: JSONException -> L52
    L48:
        r23.put("group_type", "private");     // Catch: JSONException -> L52
        if (r111 == null) goto L54;
        r23.put("item_id", r111);     // Catch: JSONException -> L52
    L54:
        TrackParams r26 = new TrackParams().merge(r23);
        by7.a r27 = new by7.a("follow_bot_result");
        r27.b = r15;
        r27.a.merge(r26);
        r27.b();
        return Unit.INSTANCE;
    L52:
        e = move-exception;
        FLogger.a.e("FollowEventHelper", "error in FollowEventHelper followBotResult " + e.getLocalizedMessage());
        goto L54
    L36:
        r25 = 0;
        goto L56
    L28:
        r114 = null;
        goto L30
    L24:
        r22 = null;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        r8 = new Ref.BooleanRef();
        r8.element = true;
        r7 = this.$data;
        r3 = this.this$0;
        int r28 = this.$position;
        r9 = System.currentTimeMillis();
        a4.a.getClass();
        a4.a(a4.b);
        BotStatusCacheDelegate r29 = BotStatusCacheDelegate.b;
        String r115 = r7.o();
        if (r115 != null) goto L11;
        r115 = "";
    L11:
        r29.a(r115, true);
        int r30 = BotDiscoverListFragment.A;
        r3.Z90().notifyItemChanged(r28);
        BotDiscoverListFragment.T90(r3, r7);
        BotDiscoverListModel r31 = r3.Y90();
        this.L$0 = r8;
        this.L$1 = r7;
        this.L$2 = r3;
        this.I$0 = r28;
        this.J$0 = r9;
        this.label = 1;
        r6 = r31.createConversationByBot(r7, this);
        if (r6 != r0) goto L14;
        return r0;
    L14:
        r1 = r28;
        goto L16
    }
}
