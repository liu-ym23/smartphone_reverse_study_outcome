package com.larus.bmhome.chat.helper;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.f5;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.model.i1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ConversationClickHelper$handleConversationClick$5", f = "ConversationClickHelper.kt", i = {0}, l = {141}, m = "invokeSuspend", n = {"conversationId"}, s = {"L$0"})
public final class ConversationClickHelper$handleConversationClick$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $argPosition;
    final /* synthetic */ wh8.a $data;
    final /* synthetic */ String $enterFrom;
    final /* synthetic */ boolean $isShowTab;
    Object L$0;
    int label;
    final /* synthetic */ ConversationClickHelper this$0;

    public ConversationClickHelper$handleConversationClick$5(wh8.a r1, ConversationClickHelper r2, boolean r3, String r4, String r5, Continuation<? super ConversationClickHelper$handleConversationClick$5> r6) {
        this.$data = r1;
        this.this$0 = r2;
        this.$isShowTab = r3;
        this.$enterFrom = r4;
        this.$argPosition = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ConversationClickHelper$handleConversationClick$5(this.$data, this.this$0, this.$isShowTab, this.$enterFrom, this.$argPosition, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r6 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r36);
        Object r7 = r36;
    L43:
        String r8 = (String) r7;
        String r9 = r3;
    L45:
        ConversationClickHelper r4 = this.this$0;
        wh8.a r5 = this.$data;
        if (r5 == null) goto L48;
        wc9.e r10 = r5.a;
    L49:
        int r11 = ConversationClickHelper.f;
        r4.getClass();
        z2 r12 = z2.a;
        if (r12.getGoMaxReadPositionConfig().b() == true) goto L52;
    L54:
        boolean r13 = false;
    L55:
        long r14 = -1;
        if (r13 == true) goto L58;
        Pair r15 = TuplesKt.to(0, -1L);
    L77:
        wh8.a r16 = this.$data;
        if (r16 == null) goto L82;
        BotModel r17 = r16.b;
        if (r17 == null) goto L82;
        String r18 = r17.getBgImgUrl();
    L83:
        wh8.a r19 = this.$data;
        if (r19 == null) goto L88;
        BotModel r20 = r19.b;
        if (r20 == null) goto L88;
        String r110 = r20.getBgImgColor();
    L89:
        wh8.a r21 = this.$data;
        if (r21 == null) goto L94;
        BotModel r22 = r21.b;
        if (r22 == null) goto L94;
        boolean r111 = r22.getBgImgOpen();
    L95:
        int r23 = f5.a;
        wh8.a r24 = this.$data;
        if (r24 == null) goto L102;
        wc9.e r25 = r24.a;
        if (r25 == null) goto L102;
        ConversationPage r26 = r25.g;
        if (r26 == null) goto L102;
        Integer r27 = r26.getDefaultStatus();
    L103:
        int r112 = f5.a(r27);
        wh8.a r28 = this.$data;
        if (r28 == null) goto L108;
        BotModel r29 = r28.b;
        if (r29 == null) goto L108;
        String r113 = r29.getBotId();
    L109:
        wh8.a r30 = this.$data;
        if (r30 == null) goto L117;
        wc9.e r31 = r30.a;
        if (r31 == null) goto L117;
        ConversationPage r32 = r31.g;
        if (r32 == null) goto L117;
        List r33 = r32.getPageList();
        if (r33 == null) goto L117;
    L118:
        List r210 = r33;
        wh8.a r34 = this.$data;
        if (r34 == null) goto L123;
        wc9.e r35 = r34.a;
        if (r35 == null) goto L123;
        ConversationPage r114 = r35.g;
    L124:
        if (r34 == null) goto L128;
        BotModel r37 = r34.b;
        if (r37 == null) goto L128;
        Integer r211 = r37.getBotType();
    L129:
        wh8.a r38 = this.$data;
        if (r38 == null) goto L134;
        wc9.e r39 = r38.a;
        if (r39 == null) goto L134;
        Integer r115 = r39.j;
    L135:
        if (r38 == null) goto L137;
        RecommendFrom r40 = r38.f;
    L138:
        if (r40 == null) goto L140;
        RecommendFrom r41 = r38.f;
    L141:
        RecommendFrom r212 = r41;
        wh8.a r42 = this.$data;
        if (r42 == null) goto L144;
        r6 = r42.b();
    L144:
        String r213 = r6;
        wh8.a r43 = this.$data;
        if (r43 == null) goto L151;
        wc9.e r44 = r43.a;
        if (r44 == null) goto L151;
        Integer r45 = r44.v;
        if (r45 == null) goto L151;
        int r310 = r45.intValue();
    L152:
        ConversationClickHelper.b(this.this$0, new ni8.e(r9, r18, r110, r111, this.$isShowTab, false, r112, r114, r113, this.$enterFrom, r115, r210, r211, 0, r212, null, null, null, null, r213, r310, ((Number) r15.getFirst()).intValue(), ((Number) r15.getSecond()).longValue(), 999712), this.$argPosition);
        return Unit.INSTANCE;
    L151:
        r310 = 0;
        goto L152
    L140:
        r41 = new RecommendFrom(this.this$0.b, null, null, 6);
        goto L141
    L137:
        r40 = null;
    L134:
        r115 = null;
    L128:
        r211 = null;
    L123:
        r114 = null;
    L117:
        r33 = CollectionsKt.emptyList();
    L108:
        r113 = null;
    L102:
        r27 = null;
    L94:
        r111 = true;
    L88:
        r110 = null;
    L82:
        r18 = null;
        goto L83
    L58:
        if (r10 == null) goto L62;
        Integer r46 = r10.l;
        if (r46 == null) goto L62;
        int r47 = r46.intValue();
    L63:
        if (r10 == null) goto L67;
        Integer r116 = r10.m;
        if (r116 == null) goto L67;
        int r117 = r116.intValue();
    L68:
        int r48 = RangesKt.coerceAtLeast(r47 - r117, 0);
        if (r48 > 0) goto L71;
        r15 = TuplesKt.to(0, -1L);
        goto L77
    L71:
        Integer r49 = Integer.valueOf(r48);
        if (r10 == null) goto L76;
        Long r50 = r10.o;
        if (r50 == null) goto L76;
        r14 = r50.longValue();
    L76:
        r15 = TuplesKt.to(r49, Long.valueOf(r14));
    L67:
        r117 = 0;
    L62:
        r47 = 0;
        goto L63
    L52:
        if (r12.getChatReadPositionBugfixConfig().a() == false) goto L54;
        r13 = true;
        goto L55
    L48:
        r10 = null;
        goto L49
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r36);
        wh8.a r51 = this.$data;
        if (r51 == null) goto L13;
        wc9.e r52 = r51.a;
        if (r52 == null) goto L13;
        String r53 = r52.a;
    L14:
        if (r53 == null) goto L18;
        Lazy r54 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r53, "<this>");
        if (com.larus.im.j.f(r53) != true) goto L18;
        boolean r55 = true;
    L19:
        if (r55 == false) goto L44;
        wh8.a r56 = this.$data;
        if (r56.b == null) goto L44;
        wc9.e r57 = r56.a;
        if (r57 == null) goto L28;
        Map r58 = r57.x;
        if (r58 == null) goto L28;
        Map<String, String> r59 = MapsKt.toMutableMap(r58);
        if (r59 == null) goto L28;
    L30:
        if (i1.a(this.$data) == false) goto L37;
        BotStatusCacheDelegate r60 = BotStatusCacheDelegate.b;
        BotModel r61 = this.$data.b;
        if (r61 == null) goto L35;
        String r62 = r61.getBotId();
        if (r62 == null) goto L35;
    L36:
        r60.a(r62, true);
    L35:
        r62 = "";
    L37:
        ConversationModel r63 = this.this$0.c;
        if (r63 == null) goto L44;
        BotModel r64 = this.$data.b;
        this.L$0 = r53;
        this.label = 1;
        r7 = r63.createLocalConversation(r64, r59, this);
        if (r7 != r1) goto L42;
        return r1;
    L42:
        r3 = r53;
    L28:
        r59 = new HashMap();
    L44:
        r9 = r53;
    L18:
        r55 = false;
    L13:
        r53 = null;
        goto L14
    }
}
