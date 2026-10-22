package com.larus.slides.impl;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z2;
import com.larus.slides.api.ISlidesService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.SlidesServiceImpl$openSlidesAndChat$1", f = "SlidesServiceImpl.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {191, 193, 202, 205}, m = "invokeSuspend", n = {"message", "artifactBlock", "attempt", "message", "artifactBlock", "attempt", "message", "artifactBlock"}, s = {"L$0", "L$1", "I$2", "L$0", "L$1", "I$2", "L$0", "L$1"})
public final class SlidesServiceImpl$openSlidesAndChat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ ni8.e $switchConversationParams;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ SlidesServiceImpl this$0;

    /* JADX INFO: renamed from: com.larus.slides.impl.SlidesServiceImpl$openSlidesAndChat$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.SlidesServiceImpl$openSlidesAndChat$1$2", f = "SlidesServiceImpl.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<ArtifactBlock> $artifactBlock;
        final /* synthetic */ String $botId;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $conversationId;
        final /* synthetic */ Ref.ObjectRef<Message> $message;
        final /* synthetic */ String $messageId;
        final /* synthetic */ ni8.e $newConversationParams;
        final /* synthetic */ ni8.e $switchConversationParams;
        int label;
        final /* synthetic */ SlidesServiceImpl this$0;

        public AnonymousClass2(SlidesServiceImpl r1, ni8.e r2, Context r3, Ref.ObjectRef<ArtifactBlock> r4, String r5, Ref.ObjectRef<Message> r6, String r7, String r8, ni8.e r9, Continuation<? super AnonymousClass2> r10) {
            this.this$0 = r1;
            this.$newConversationParams = r2;
            this.$context = r3;
            this.$artifactBlock = r4;
            this.$messageId = r5;
            this.$message = r6;
            this.$conversationId = r7;
            this.$botId = r8;
            this.$switchConversationParams = r9;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
            return new AnonymousClass2(this.this$0, this.$newConversationParams, this.$context, this.$artifactBlock, this.$messageId, this.$message, this.$conversationId, this.$botId, this.$switchConversationParams, r13);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r26) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            String r9 = "";
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r26);
        L18:
            Ref.ObjectRef<ArtifactBlock> r3 = this.$artifactBlock;
            Ref.ObjectRef<Message> r4 = this.$message;
            String r10 = this.$messageId;
            String r11 = this.$botId;
            ni8.e r12 = this.$switchConversationParams;
            StringBuilder r13 = new StringBuilder("sslocal://doubao_apps?app_id=db_1JOlsY6&path=detail&route_mode=navigate");
            List r14 = CollectionsKt.createListBuilder();
            r14.add(TuplesKt.to("biz", "slides"));
            ArtifactBlock r8 = (ArtifactBlock) r3.element;
            if (r8 == null) goto L22;
            String r15 = r8.getResourceId();
            if (r15 == null) goto L22;
        L23:
            r14.add(TuplesKt.to("slides_token", r15));
            ArtifactBlock r5 = (ArtifactBlock) r3.element;
            if (r5 == null) goto L26;
            String r6 = r5.getArtifactVersionId();
        L27:
            r14.add(TuplesKt.to("artifact_version_id", r6));
            ArtifactBlock r7 = (ArtifactBlock) r3.element;
            if (r7 == null) goto L32;
            Integer r16 = r7.getResourceVersion();
            if (r16 == null) goto L32;
            String r17 = r16.toString();
        L33:
            r14.add(TuplesKt.to("resource_version", r17));
            ArtifactBlock r18 = (ArtifactBlock) r3.element;
            if (r18 == null) goto L36;
            String r19 = r18.getArtifactMetaId();
        L37:
            r14.add(TuplesKt.to("artifact_meta_id", r19));
            ArtifactBlock r20 = (ArtifactBlock) r3.element;
            if (r20 == null) goto L41;
            String r21 = r20.getResourceId();
            if (r21 == null) goto L41;
        L42:
            r14.add(TuplesKt.to("resource_id", r21));
            r14.add(TuplesKt.to("resource_type", "9"));
            Message r22 = (Message) r4.element;
            if (r22 == null) goto L48;
            String r23 = r22.getMessageId();
            if (r23 == null) goto L48;
            r10 = r23;
        L48:
            r14.add(TuplesKt.to("message_id", r10));
            Message r24 = (Message) r4.element;
            if (r24 == null) goto L51;
            String r25 = com.larus.im.bean.message.a.c(r24);
        L52:
            r14.add(TuplesKt.to("aippt_task_id", r25));
            r14.add(TuplesKt.to("bot_id", r11));
            r14.add(TuplesKt.to("enter_from", r12.k));
            r14.add(TuplesKt.to("enter_method", r12.k));
            r14.add(TuplesKt.to("previous_page", ""));
            r14.add(TuplesKt.to("click_timestamp", String.valueOf(System.currentTimeMillis())));
            List r27 = CollectionsKt.build(r14);
            ArrayList r28 = new ArrayList();
            Iterator r29 = r27.iterator();
        L54:
            if (r29.hasNext() == false) goto L67;
            Pair r30 = (Pair) r29.next();
            String r31 = (String) r30.component1();
            String r32 = (String) r30.component2();
            if (r32 != null) goto L58;
        L61:
            boolean r33 = true;
        L62:
            if (r33 == false) goto L64;
            String r34 = null;
        L65:
            if (r34 == null) goto L54;
            r28.add(r34);
            goto L54
        L64:
            r34 = r31 + '=' + URLEncoder.encode(r32, "UTF-8");
            goto L65
        L58:
            if (r32.length() == 0) goto L61;
            r33 = false;
            goto L62
        L67:
            r13.append("&query=" + URLEncoder.encode(CollectionsKt.joinToString$default(r28, "&", null, null, 0, null, null, 62, null), "UTF-8"));
            SmartRouter.buildRoute(this.$context, r13.toString()).d();
        L120:
            return Unit.INSTANCE;
        L51:
            r25 = null;
        L41:
            r21 = "";
            goto L42
        L36:
            r19 = null;
        L32:
            r17 = null;
            goto L33
        L26:
            r6 = null;
        L22:
            r15 = "";
            goto L23
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r26);
            SlidesServiceImpl r35 = this.this$0;
            ni8.e r110 = this.$newConversationParams;
            int r111 = SlidesServiceImpl.b;
            r35.getClass();
            Boolean r112 = Boolean.TRUE;
            Bundle r36 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", "openSlidesAndChat"), TuplesKt.to("argConversationId", r110.a), TuplesKt.to("argBotId", r110.j), TuplesKt.to("argBotType", r110.n), TuplesKt.to("argClickEnterFrom", r110.k), TuplesKt.to("argCvsBgImgUrl", r110.b), TuplesKt.to("argCvsBgImgColor", r110.c), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r110.d)), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r110.i)), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", "bot_list"), TuplesKt.to("navigate_up_from", "chat_list"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r110.o)), TuplesKt.to("target_middle_msg_id", r110.q), TuplesKt.to("is_single_mode", r112), TuplesKt.to("is_from_push", r112), TuplesKt.to("is_from_outer", r112), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r110.r), TuplesKt.to("argBotConversationType", Integer.valueOf(r110.v))});
            com.bytedance.router.i r113 = SmartRouter.buildRoute(this.$context, "//flow/chat_page");
            r113.c.putExtras(r36);
            r113.d = 2130772401;
            r113.e = 2130772399;
            r113.d();
            if (this.$artifactBlock.element != null) goto L12;
            FLogger.a.w("SlidesServiceImpl", "Open slides and chat: messageId=" + this.$messageId + " artifactBlock is null");
        L12:
            if (z2.a.f4() == false) goto L68;
            ISlidesService r37 = (ISlidesService) ServiceManager.get().getService(ISlidesService.class);
            if (r37 == null) goto L18;
            this.label = 1;
            if (r37.a(this) != r1) goto L18;
            return r1;
        L68:
            ISlidesService r38 = (ISlidesService) ServiceManager.get().getService(ISlidesService.class);
            if (r38 == null) goto L120;
            Context r39 = this.$context;
            Pair[] r40 = new Pair[15];
            ArtifactBlock r114 = (ArtifactBlock) this.$artifactBlock.element;
            if (r114 == null) goto L74;
            String r115 = r114.getResourceId();
            if (r115 == null) goto L74;
        L75:
            r40[0] = TuplesKt.to("slides_token", r115);
            Message r41 = (Message) this.$message.element;
            if (r41 == null) goto L79;
            String r42 = r41.getConversationId();
            if (r42 == null) goto L79;
        L80:
            r40[1] = TuplesKt.to("conversation_id", r42);
            Message r43 = (Message) this.$message.element;
            if (r43 == null) goto L83;
            String r44 = r43.getSectionId();
        L84:
            r40[2] = TuplesKt.to("section_id", r44);
            ArtifactBlock r45 = (ArtifactBlock) this.$artifactBlock.element;
            if (r45 == null) goto L87;
            String r46 = r45.getArtifactVersionId();
        L88:
            r40[3] = TuplesKt.to("artifact_version_id", r46);
            ArtifactBlock r47 = (ArtifactBlock) this.$artifactBlock.element;
            if (r47 == null) goto L91;
            Integer r48 = r47.getResourceVersion();
        L92:
            r40[4] = TuplesKt.to("resource_version", r48);
            ArtifactBlock r49 = (ArtifactBlock) this.$artifactBlock.element;
            if (r49 == null) goto L95;
            String r50 = r49.getArtifactMetaId();
        L96:
            r40[5] = TuplesKt.to("artifact_meta_id", r50);
            ArtifactBlock r51 = (ArtifactBlock) this.$artifactBlock.element;
            if (r51 == null) goto L100;
            String r52 = r51.getResourceId();
            if (r52 == null) goto L100;
        L101:
            r40[6] = TuplesKt.to("resource_id", r52);
            ArtifactBlock r53 = (ArtifactBlock) this.$artifactBlock.element;
            if (r53 == null) goto L104;
            Integer r54 = r53.getResourceType();
        L105:
            r40[7] = TuplesKt.to("resource_type", r54);
            Message r55 = (Message) this.$message.element;
            if (r55 == null) goto L109;
            String r56 = r55.getMessageId();
            if (r56 == null) goto L109;
        L110:
            r40[8] = TuplesKt.to("message_id", r56);
            Message r57 = (Message) this.$message.element;
            if (r57 == null) goto L113;
            String r116 = com.larus.im.bean.message.a.c(r57);
        L114:
            r40[9] = TuplesKt.to("aippt_task_id", r116);
            r40[10] = TuplesKt.to("bot_id", this.$botId);
            r40[11] = TuplesKt.to("enter_from", this.$switchConversationParams.k);
            r40[12] = TuplesKt.to("enter_method", this.$switchConversationParams.k);
            r40[13] = TuplesKt.to("previous_page", "");
            r40[14] = TuplesKt.to("click_timestamp", Boxing.boxLong(System.currentTimeMillis()));
            Bundle r58 = com.larus.utils.f.c(r40);
            String r59 = this.$switchConversationParams.k;
            if (r59 == null) goto L118;
            r9 = r59;
        L118:
            r38.g(r39, r58, r9);
            goto L120
        L113:
            r116 = null;
        L109:
            r56 = this.$messageId;
            goto L110
        L104:
            r54 = null;
        L100:
            r52 = "";
            goto L101
        L95:
            r50 = null;
            goto L96
        L91:
            r48 = null;
            goto L92
        L87:
            r46 = null;
            goto L88
        L83:
            r44 = null;
        L79:
            r42 = this.$conversationId;
        L74:
            r115 = "";
            goto L75
        }
    }

    public SlidesServiceImpl$openSlidesAndChat$1(String r1, ni8.e r2, String r3, SlidesServiceImpl r4, Context r5, Continuation<? super SlidesServiceImpl$openSlidesAndChat$1> r6) {
        this.$conversationId = r1;
        this.$switchConversationParams = r2;
        this.$messageId = r3;
        this.this$0 = r4;
        this.$context = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SlidesServiceImpl$openSlidesAndChat$1(this.$conversationId, this.$switchConversationParams, this.$messageId, this.this$0, this.$context, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e5 -> B:27:0x00f0). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r47) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r4 = 2;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ResultKt.throwOnFailure(r47);
    L86:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r5 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r47);
        Ref.ObjectRef r12 = r3;
        Ref.ObjectRef r14 = r5;
        Object r6 = r47;
        SlidesServiceImpl$openSlidesAndChat$1 r7 = this;
    L73:
        BotModel r8 = (BotModel) r6;
        if (r8 == null) goto L77;
        String r9 = r8.getBotId();
        if (r9 == null) goto L77;
    L78:
        Message r10 = (Message) r14.element;
        if (r10 == null) goto L81;
        long r11 = r10.getLocalIndex();
    L82:
        long r30 = r11;
        ni8.e r13 = r7.$switchConversationParams;
        String r15 = r13.a;
        String r16 = r13.b;
        String r17 = r13.c;
        boolean r18 = r13.d;
        boolean r19 = r13.e;
        boolean r110 = r13.f;
        int r111 = r13.g;
        ConversationPage r20 = r13.h;
        boolean r21 = r13.i;
        String r0 = r13.k;
        Integer r22 = r13.l;
        Ref.ObjectRef r42 = r14;
        List r112 = r13.m;
        Ref.ObjectRef r43 = r12;
        Integer r113 = r13.n;
        SlidesServiceImpl$openSlidesAndChat$1 r44 = r7;
        RecommendFrom r23 = r13.p;
        String r24 = r13.q;
        String r25 = r13.r;
        String r26 = r13.s;
        Bundle r27 = r13.t;
        String r28 = r13.u;
        int r29 = r13.v;
        int r31 = r13.w;
        long r32 = r13.x;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r112, "pageList");
        ni8.e r33 = new ni8.e(r15, r16, r17, r18, r19, r110, r111, r20, r21, r9, r0, r22, r112, r113, r30, r23, r24, r25, r26, r27, r28, r29, r31, r32);
        MainCoroutineDispatcher r34 = Dispatchers.getMain();
        AnonymousClass2 r35 = new AnonymousClass2(r44.this$0, r33, r44.$context, r43, r44.$messageId, r42, r44.$conversationId, r9, r44.$switchConversationParams, null);
        r44.L$0 = null;
        r44.L$1 = null;
        r44.label = 4;
        if (BuildersKt.withContext(r34, r35, r44) != r1) goto L86;
        return r1;
    L81:
        r11 = -1;
    L77:
        r9 = "";
        goto L78
    L12:
        int r36 = this.I$2;
        int r37 = this.I$1;
        int r114 = this.I$0;
        Ref.ObjectRef r115 = (Ref.ObjectRef) this.L$4;
        SlidesServiceImpl r116 = (SlidesServiceImpl) this.L$3;
        String r117 = (String) this.L$2;
        Ref.ObjectRef r118 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r119 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r47);
        Object r38 = r47;
        SlidesServiceImpl$openSlidesAndChat$1 r120 = this;
        int r39 = r37;
        Ref.ObjectRef r40 = r118;
        String r121 = r117;
        SlidesServiceImpl r122 = r116;
        int r123 = r114;
        Ref.ObjectRef r124 = r119;
    L27:
        r115.element = r38;
        Message r41 = (Message) r124.element;
        int r125 = SlidesServiceImpl.b;
        r122.getClass();
        if (r41 == null) goto L59;
        List r45 = r41.getContentBlock();
        if (r45 == null) goto L59;
        Iterator r46 = r45.iterator();
    L33:
        if (r46.hasNext() == false) goto L53;
        Object r126 = r46.next();
        Block r127 = (Block) r126;
        if (r127.getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L49;
        BlockContent r48 = r127.getContent();
        if (r48 == null) goto L46;
        ArtifactBlock r49 = r48.getDocBlock();
        if (r49 == null) goto L46;
        Integer r50 = r49.getResourceType();
        if (r50 == null) goto L46;
        if (r50.intValue() != 9) goto L46;
        boolean r51 = true;
    L47:
        if (r51 == false) goto L49;
        boolean r52 = true;
    L50:
        if (r52 == false) goto L33;
    L54:
        Block r128 = (Block) r126;
        if (r128 == null) goto L59;
        BlockContent r53 = r128.getContent();
        if (r53 == null) goto L59;
        ArtifactBlock r54 = r53.getDocBlock();
    L60:
        r40.element = r54;
        if (r54 != null) goto L68;
        FLogger r55 = FLogger.a;
        StringBuilder r56 = new StringBuilder("Open slides and chat: messageId=");
        r56.append(r121);
        r56.append(" attempt=");
        r56.append(r36);
        r56.append(" message=");
        if (r124.element != null) goto L66;
        boolean r57 = true;
    L67:
        r56.append(r57);
        r56.append(" artifactBlock=null");
        r55.w("SlidesServiceImpl", r56.toString());
        goto L68
    L66:
        r57 = false;
    L68:
        r36 = r39 + 1;
        int r129 = r123;
        SlidesServiceImpl r130 = r122;
        String r131 = r121;
        SlidesServiceImpl$openSlidesAndChat$1 r132 = r120;
        r4 = 2;
    L15:
        if (r36 >= r129) goto L69;
        if (r36 <= 0) goto L22;
        r132.L$0 = r124;
        r132.L$1 = r40;
        r132.L$2 = r131;
        r132.L$3 = r130;
        r132.L$4 = null;
        r132.I$0 = r129;
        r132.I$1 = r36;
        r132.I$2 = r36;
        r132.label = 1;
        if (DelayKt.delay(500, r132) != r1) goto L20;
        return r1;
    L20:
        Ref.ObjectRef r58 = r124;
        int r133 = r129;
        SlidesServiceImpl r134 = r130;
        String r135 = r131;
        Ref.ObjectRef r136 = r40;
        int r59 = r36;
    L21:
        SlidesServiceImpl r410 = r134;
        r115 = r58;
        Ref.ObjectRef r60 = r136;
        r131 = r135;
        r130 = r410;
    L23:
        IChatRepoService r61 = RepoDispatcherDelegate.b.e();
        r132.L$0 = r115;
        r132.L$1 = r60;
        r132.L$2 = r131;
        r132.L$3 = r130;
        r132.L$4 = r115;
        r132.I$0 = r133;
        r132.I$1 = r59;
        r132.I$2 = r36;
        r132.label = r4;
        r38 = r61.E1(r131, r132);
        if (r38 != r1) goto L26;
        return r1;
    L26:
        r120 = r132;
        r121 = r131;
        r122 = r130;
        r123 = r133;
        r124 = r115;
        int r411 = r59;
        r40 = r60;
        r39 = r411;
        goto L27
    L22:
        r60 = r40;
        r59 = r36;
        int r412 = r129;
        r115 = r124;
        r133 = r412;
        goto L23
    L69:
        IBotRepoService r62 = RepoDispatcherDelegate.b.b();
        String r63 = r132.$conversationId;
        r132.L$0 = r124;
        r132.L$1 = r40;
        r132.L$2 = null;
        r132.L$3 = null;
        r132.L$4 = null;
        r132.label = 3;
        r6 = r62.j1(r63, true, r132);
        if (r6 != r1) goto L72;
        return r1;
    L72:
        r12 = r40;
        r7 = r132;
        r14 = r124;
    L46:
        r51 = false;
    L49:
        r52 = false;
        goto L50
    L53:
        r126 = null;
    L59:
        r54 = null;
        goto L60
    L13:
        r36 = this.I$2;
        r59 = this.I$1;
        r133 = this.I$0;
        r134 = (SlidesServiceImpl) this.L$3;
        r135 = (String) this.L$2;
        r136 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r137 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r47);
        r58 = r137;
        r132 = this;
        goto L21
    L14:
        ResultKt.throwOnFailure(r47);
        Ref.ObjectRef r64 = new Ref.ObjectRef();
        r40 = new Ref.ObjectRef();
        r132 = this;
        r131 = this.$messageId;
        r130 = this.this$0;
        r129 = 3;
        r124 = r64;
        r36 = 0;
        goto L15
    }
}
