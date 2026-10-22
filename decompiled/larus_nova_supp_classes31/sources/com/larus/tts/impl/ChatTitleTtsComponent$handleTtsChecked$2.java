package com.larus.tts.impl;

import androidx.collection.LruCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.g;
import com.larus.platform.service.z2;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import ko8.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$handleTtsChecked$2", f = "ChatTitleTtsComponent.kt", i = {}, l = {915, 920}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleTtsComponent$handleTtsChecked$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ e $conversation;
    final /* synthetic */ boolean $isAudioDowngrade;
    final /* synthetic */ Message $latestMessage;
    final /* synthetic */ String $openMethod;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public ChatTitleTtsComponent$handleTtsChecked$2(e r1, boolean r2, ChatTitleTtsComponent r3, Message r4, boolean r5, BotModel r6, String r7, Continuation<? super ChatTitleTtsComponent$handleTtsChecked$2> r8) {
        this.$conversation = r1;
        this.$checked = r2;
        this.this$0 = r3;
        this.$latestMessage = r4;
        this.$isAudioDowngrade = r5;
        this.$bot = r6;
        this.$openMethod = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatTitleTtsComponent$handleTtsChecked$2(this.$conversation, this.$checked, this.this$0, this.$latestMessage, this.$isAudioDowngrade, this.$bot, this.$openMethod, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v18, types: [boolean] */
    public final Object invokeSuspend(Object r57) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = "";
        String r5 = null;
        boolean r6 = true;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        boolean r4 = this.Z$1;
        boolean r7 = this.Z$0;
        String r8 = (String) this.L$4;
        e r9 = (e) this.L$3;
        BotModel r10 = (BotModel) this.L$2;
        Message r11 = (Message) this.L$1;
        LifecycleOwner r12 = (ChatTitleTtsComponent) this.L$0;
        ResultKt.throwOnFailure(r57);
        String r16 = r8;
        e r15 = r9;
        LifecycleOwner r14 = r12;
        ?? r13 = r7;
    L26:
        if (r13 != 0) goto L28;
        int r17 = ChatTitleTtsComponent.v;
        r14.X2().i6("click_tts_icon", true);
    L69:
        if (r13 == 0) goto L73;
        if (r4 == false) goto L72;
        String r18 = "resource_downgrade_open";
    L74:
        int r19 = wi8.e.a;
        if (r10 == null) goto L77;
        String r20 = r10.getBotId();
    L78:
        if (r20 != null) goto L80;
        String r21 = "";
    L81:
        if (r15 == null) goto L86;
        String r22 = r15.a;
        if (r22 == null) goto L86;
        r3 = r22;
    L86:
        LruCache r23 = a.a;
        if (r15 == null) goto L89;
        Integer r24 = r15.v;
    L90:
        int r25 = ChatTitleTtsComponent.v;
        String r110 = a.f(r24, r14.N2(), r14.L2());
        if (r11 == null) goto L93;
        boolean r111 = d.Q0(r11);
    L94:
        if (r11 == null) goto L96;
        boolean r26 = d.f0(r11);
    L97:
        Intrinsics.checkNotNullParameter(r14, "<this>");
        by7.e r27 = com.larus.ui.arch.component.internal.attach.a.b(r14, r14);
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
        boolean r112 = r26;
        LifecycleOwner r28 = r14;
        String r113 = r18;
        e r29 = r15;
        wi8.e.b(r13, r21, false, r3, r110, r111, r112, r113, r16, r27, 1536);
        if (z2.a.voiceGlobalSwitchEnable() == false) goto L104;
        Keva r30 = j0.d();
        if (r30 == null) goto L102;
        r30.storeInt("bot_global_tts_switch", r13);
    L102:
        TtsGuideDelegate.b.h(com.larus.bmhome.utils.i.c(j0.a()));
    L146:
        return Unit.INSTANCE;
    L104:
        if (com.larus.bmhome.utils.i.f(r29) == false) goto L106;
    L134:
        Keva r31 = j0.a;
        String r32 = ((ChatTitleTtsComponent) r28).r;
        if (r32 != null) goto L137;
    L140:
        if (r6 == false) goto L142;
        g.a.ensureNotReachHere("cvs id is null please check code !!!");
    L142:
        Keva r33 = j0.d();
        if (r33 == null) goto L146;
        r33.storeInt("bot_tts_switch_" + r32, r13);
        goto L146
    L137:
        if (r32.length() == 0) goto L140;
        r6 = false;
        goto L140
    L106:
        if (r29 == null) goto L113;
        Integer r114 = r29.j;
        if (r114 == null) goto L113;
        if (r114.intValue() != 3) goto L113;
        boolean r115 = true;
    L114:
        if (r115 == false) goto L121;
        Integer r116 = r29.v;
        if (r116 == null) goto L121;
        if (r116.intValue() == 3) goto L134;
    L121:
        Keva r34 = j0.a;
        if (r29 == null) goto L124;
        r5 = r29.a;
    L124:
        if (r5 != null) goto L126;
    L129:
        if (r6 == false) goto L131;
        g.a.ensureNotReachHere("cvs id is null please check code !!!");
    L131:
        Keva r35 = j0.d();
        if (r35 == null) goto L146;
        r35.storeInt("bot_tts_switch_" + r5, r13);
        goto L146
    L126:
        if (r5.length() == 0) goto L129;
        r6 = false;
    L113:
        r115 = false;
        goto L114
    L96:
        r26 = false;
        goto L97
    L93:
        r111 = false;
        goto L94
    L89:
        r24 = null;
        goto L90
    L80:
        r21 = r20;
        goto L81
    L77:
        r20 = null;
        goto L78
    L72:
        r18 = "other_open";
        goto L74
    L73:
        r18 = "other_close";
        goto L74
    L28:
        if (r11 == null) goto L69;
        int r36 = ChatTitleTtsComponent.v;
        r14.getClass();
        if (com.larus.im.bean.message.a.E0(r11) == false) goto L51;
        List r37 = com.larus.bmhome.chat.layout.holder.helper.s.a(r11);
        if (r37 == null) goto L69;
        Message r38 = (Message) CollectionsKt.firstOrNull(r37);
        if (r38 == null) goto L69;
        String r39 = r38.getMessageId();
        if (r39 != null) goto L38;
    L40:
        boolean r40 = false;
    L41:
        if (r40 == false) goto L43;
    L45:
        boolean r41 = false;
    L46:
        if (r41 == true) goto L49;
        r38 = null;
    L49:
        if (r38 == null) goto L69;
    L53:
        if (d.Q0(r11) == false) goto L69;
        if (d.G0(r11) == true) goto L69;
        if (r38.getContentType() != 1) goto L59;
    L60:
        AudioServiceDelegate r42 = AudioServiceDelegate.a;
        if (r42.r0().l() == PlayStateEnum.PLAY_STATE_PLAYING) goto L69;
        if (r42.r0().l() == PlayStateEnum.PLAY_STATE_PREPARE) goto L69;
        if (d.w0(r38) == false) goto L69;
        if (ObricTtsControlDelegate.b.n() == false) goto L69;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new ChatTitleTtsComponent$tryStartTtsWhenTtsOpen$1(r14, r38, null), 3, null);
        goto L69
    L59:
        if (r38.getContentType() != 9999) goto L69;
    L43:
        if (com.larus.im.bean.message.a.r0(r38) == true) goto L45;
        r41 = true;
        goto L46
    L38:
        if (StringsKt.contains$default(r39, "#", false, 2, null) != true) goto L40;
        r40 = true;
        goto L41
    L51:
        r38 = r11;
        goto L53
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        boolean r43 = this.Z$1;
        boolean r44 = this.Z$0;
        String r45 = (String) this.L$4;
        e r46 = (e) this.L$3;
        BotModel r117 = (BotModel) this.L$2;
        Message r118 = (Message) this.L$1;
        LifecycleOwner r119 = (ChatTitleTtsComponent) this.L$0;
        ResultKt.throwOnFailure(r57);
        LifecycleOwner r120 = r119;
        Message r121 = r118;
        BotModel r122 = r117;
        boolean r123 = r43;
        Object r47 = r57;
    L21:
        boolean r48 = ((Boolean) r47).booleanValue();
        MainCoroutineDispatcher r124 = Dispatchers.getMain();
        ChatTitleTtsComponent$handleTtsChecked$2$1$1 r125 = new ChatTitleTtsComponent$handleTtsChecked$2$1$1(r48, r120, r44, null);
        this.L$0 = r120;
        this.L$1 = r121;
        this.L$2 = r122;
        this.L$3 = r46;
        this.L$4 = r45;
        this.Z$0 = r44;
        this.Z$1 = r123;
        this.label = 2;
        if (BuildersKt.withContext(r124, r125, this) != r1) goto L24;
        return r1;
    L24:
        r13 = r44;
        r16 = r45;
        r15 = r46;
        r4 = r123;
        r10 = r122;
        r11 = r121;
        r14 = r120;
        goto L26
    L10:
        ResultKt.throwOnFailure(r57);
        e r49 = this.$conversation;
        if (r49 == null) goto L16;
        String r50 = r49.a;
        if (r50 == null) goto L16;
        String r126 = r50;
    L17:
        e r51 = new e(r126, null, null, null, null, null, null, null, this.$checked, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -258, 63);
        r44 = this.$checked;
        LifecycleOwner r52 = this.this$0;
        Message r53 = this.$latestMessage;
        r123 = this.$isAudioDowngrade;
        r122 = this.$bot;
        e r127 = this.$conversation;
        String r128 = this.$openMethod;
        IConversationRepoService r129 = RepoDispatcherDelegate.b.f();
        String r130 = r51.a;
        boolean r54 = r51.i;
        this.L$0 = r52;
        this.L$1 = r53;
        this.L$2 = r122;
        this.L$3 = r127;
        this.L$4 = r128;
        this.Z$0 = r44;
        this.Z$1 = r123;
        this.label = 1;
        r47 = r129.p(r130, r54, this);
        if (r47 != r1) goto L20;
        return r1;
    L20:
        r120 = r52;
        r45 = r128;
        r121 = r53;
        r46 = r127;
    L16:
        r126 = "";
        goto L17
    }
}
