package com.obric.assistant.chat.internal;

import ai8.e;
import android.app.Application;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.d;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.service.IMessageService;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import lr8.c;
import org.json.JSONObject;
import t19.s;
import wf9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.internal.ChatSender$hideAndReSendMessage$1", f = "ChatSender.kt", i = {0, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {168, 172, 180, 186}, m = "invokeSuspend", n = {"chatRepo", "chatRepo", "chatRepo", "question", "conversationId", "collectionId", "chatRepo", "question", "conversationId", "collectionId", "questions"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class ChatSender$hideAndReSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ boolean $isQuestion;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $scene;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ ChatSender this$0;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
        }
    }

    public ChatSender$hideAndReSendMessage$1(String r1, boolean r2, ChatSender r3, String r4, Map<String, String> r5, Continuation<? super ChatSender$hideAndReSendMessage$1> r6) {
        this.$messageId = r1;
        this.$isQuestion = r2;
        this.this$0 = r3;
        this.$scene = r4;
        this.$extras = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatSender$hideAndReSendMessage$1(this.$messageId, this.$isQuestion, this.this$0, this.$scene, this.$extras, r9);
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
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        List r3 = (List) this.L$4;
        String r4 = (String) this.L$3;
        String r5 = (String) this.L$2;
        Message r6 = (Message) this.L$1;
        IChatRepoService r7 = (IChatRepoService) this.L$0;
        ResultKt.throwOnFailure(r36);
        IChatRepoService r12 = r7;
        String r9 = r5;
        Object r10 = r36;
    L72:
        List r11 = CollectionsKt.plus(r3, (List) r10);
        ChatSender r13 = this.this$0;
        int r14 = ChatSender.c;
        r13.getClass();
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("hideMessages called,  ");
        List r17 = r11;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L74:
        if (r19.hasNext() == false) goto L76;
        r18.add(((Message) r19.next()).getLocalMessageId());
        goto L74
    L76:
        r16.append(r18);
        r15.i("Obric_ChatSender", r16.toString());
        Iterator r20 = r17.iterator();
    L78:
        if (r20.hasNext() == false) goto L88;
        Message r21 = (Message) r20.next();
        NativeMessageServiceImpl r110 = d.e();
        String r111 = r21.getMessageId();
        if (r111 != null) goto L82;
        String r112 = NameKeys.UnloadStrategy_No_Strategy;
    L83:
        MessageStatus r113 = MessageStatus.MessageStatus_INVISIBLE;
        String r22 = r21.getConversationId();
        if (r22 != null) goto L86;
        String r114 = NameKeys.UnloadStrategy_No_Strategy;
    L87:
        IMessageService.a.c(r110, r112, r113, r114, MapsKt.mapOf(TuplesKt.to("not_delete_by_default", "1")), 32);
        goto L78
    L86:
        r114 = r22;
        goto L87
    L82:
        r112 = r111;
        goto L83
    L88:
        if (r4 != null) goto L90;
    L93:
        boolean r23 = true;
    L94:
        if (r23 == true) goto L96;
        String r24 = UUID.randomUUID().toString();
    L97:
        Map<String, String> r25 = this.$extras;
        ArrayList r26 = new ArrayList();
        Iterator r27 = r3.iterator();
    L99:
        if (r27.hasNext() == false) goto L239;
        Message r115 = (Message) r27.next();
        int r116 = b.a;
        String r117 = com.flow.kmp.common.util.i.a();
        Map r118 = r115.getExt();
        if (r118 == null) goto L104;
        Map r119 = MapsKt.toMutableMap(r118);
        if (r119 == null) goto L104;
    L106:
        if (r25 == null) goto L120;
        r119.putAll(r25);
        Intrinsics.checkNotNullParameter(r119, "<this>");
        Intrinsics.checkNotNullParameter(r25, "map");
        String r120 = r25.get("o_session");
        if (r120 == null) goto L120;
        JSONObject r28 = new JSONObject(r120);
        String r121 = (String) r119.get("o_session");
        if (r121 == null) goto L112;
        JSONObject r29 = new JSONObject(r121);
    L113:
        if (r29 != null) goto L115;
        r29 = new JSONObject();
    L115:
        Iterator<String> r122 = r28.keys();
    L117:
        if (r122.hasNext() == false) goto L119;
        String r33 = r8;
        String r30 = r122.next();
        r29.put(r30, r28.opt(r30));
        r122 = r122;
        r8 = r33;
        goto L117
    L119:
        String r34 = r8;
        r119.put("o_session", r29.toString());
    L121:
        if (r24 == null) goto L123;
        r119.put("collection_id", r24);
    L123:
        String r31 = r6.getMessageId();
        if (r31 != null) goto L126;
        r31 = r34;
    L126:
        Intrinsics.checkNotNullParameter(r119, "<this>");
        Intrinsics.checkNotNullParameter("replay_msg_id", "key");
        Intrinsics.checkNotNullParameter(r31, "value");
        String r32 = (String) r119.get("o_session");
        if (r32 == null) goto L129;
        JSONObject r123 = new JSONObject(r32);
    L130:
        if (r123 != null) goto L132;
        r123 = new JSONObject();
    L132:
        r123.put("replay_msg_id", r31);
        r119.put("o_session", r123.toString());
        r119.put("reedit_id", String.valueOf(r6.getMessageId()));
        Map r35 = r115.getBusinessExt();
        if (r35 != null) goto L135;
        r35 = new LinkedHashMap();
    L135:
        Map r37 = com.larus.utils.h.c(r35, new Pair[]{TuplesKt.to("send_loading", ic8.j.f(r115))});
        int r38 = g.a;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        ReferenceInfo r39 = com.larus.bmhome.chat.bean.d.b1(r115);
        if (r115.getContentType() != 1) goto L143;
        String r40 = com.larus.bmhome.chat.bean.d.H(r115);
        if (r40 != null) goto L140;
        String r124 = r34;
    L141:
        ai8.h r41 = new ai8.h(r124, r117, null, r39, r119, r37, false, false, null, null, 964);
    L236:
        if (r41 == null) goto L238;
        r26.add(r41);
    L238:
        r27 = r27;
        r25 = r25;
        r8 = r34;
        goto L99
    L140:
        r124 = r40;
        goto L141
    L143:
        if (r115.getContentType() != 6) goto L178;
        List r42 = com.larus.bmhome.chat.bean.d.g(r115).imageList;
        if (r42 == null) goto L147;
        Image r43 = (Image) CollectionsKt.getOrNull(r42, 0);
    L149:
        if (r43 == null) goto L151;
        String r125 = r43.localResPath;
    L152:
        if (r125 != null) goto L154;
        String r126 = r34;
    L155:
        if (r43 == null) goto L157;
        String r127 = r43.key;
    L158:
        if (r43 == null) goto L162;
        ImageObj r128 = r43.imageOri;
        if (r128 == null) goto L162;
        Integer r129 = Integer.valueOf(r128.height);
    L163:
        if (r43 == null) goto L167;
        ImageObj r130 = r43.imageOri;
        if (r130 == null) goto L167;
        Integer r210 = Integer.valueOf(r130.width);
    L168:
        if (r43 == null) goto L170;
        String r211 = r43.resourceId;
    L171:
        if (r43 == null) goto L175;
        ImageObj r44 = r43.imageOri;
        if (r44 == null) goto L175;
        String r212 = r44.url;
    L176:
        r41 = new e(r126, r127, r129, r210, r211, r212, r117, r39, r119, r37, false, null, null, null, 30784);
    L175:
        r212 = null;
        goto L176
    L170:
        r211 = null;
    L167:
        r210 = null;
    L162:
        r129 = null;
        goto L163
    L157:
        r127 = null;
        goto L158
    L154:
        r126 = r125;
        goto L155
    L151:
        r125 = null;
        goto L152
    L147:
        r43 = null;
        goto L149
    L178:
        if (c.a(r115) == false) goto L187;
        NestedFileContent r131 = com.larus.bmhome.chat.bean.d.f(r115);
        List r45 = r131.getEntities();
        if (r45 == null) goto L185;
        Iterator r46 = r45.iterator();
    L183:
        if (r46.hasNext() == false) goto L185;
        ((UplinkFileEntity) r46.next()).setFileParsedStatus(Integer.valueOf(FileParseState.SUCCESS.getValue()));
    L185:
        r41 = new ai8.f(r131, r117, null, r39, r119, r37, false, null, null, null, 964);
        goto L236
    L187:
        if (r115.getContentType() == 9999) goto L189;
    L234:
        FLogger.a.e("MessageRequestConvert", "unsupported content type: " + r115.getContentType());
        s r47 = s.a;
        Application r48 = AppHost.a.getApplication();
        r47.getClass();
        s.b(r48, 2131910343, false);
    L235:
        r41 = null;
        goto L236
    L189:
        if (r115.isNewBlockType() == false) goto L234;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        ReferenceInfo r213 = com.larus.bmhome.chat.bean.d.b1(r115);
        List r49 = r115.getContentBlock();
        if (r49 == null) goto L203;
        Iterator r50 = r49.iterator();
    L194:
        if (r50.hasNext() == false) goto L201;
        Object r51 = r50.next();
        if (((Block) r51).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L198;
        boolean r132 = true;
    L199:
        if (r132 == false) goto L194;
    L202:
        Block r52 = (Block) r51;
    L204:
        if (r52 == null) goto L210;
        FLogger.a.i("MessageRequestConvert", "convert message content type 9999 to SendTextStrategy");
        String r53 = com.larus.bmhome.chat.bean.d.H(r115);
        if (r53 != null) goto L208;
        String r133 = r34;
    L209:
        r41 = new ai8.h(r133, r117, null, r213, r119, r37, false, false, null, null, 964);
        goto L236
    L208:
        r133 = r53;
        goto L209
    L210:
        List r54 = r115.getContentBlock();
        if (r54 == null) goto L223;
        Iterator r55 = r54.iterator();
    L214:
        if (r55.hasNext() == false) goto L221;
        Object r56 = r55.next();
        if (((Block) r56).getBlockType() != BlockType.BLOCK_TYPE_ATTACHMENT.getValue()) goto L218;
        boolean r134 = true;
    L219:
        if (r134 == false) goto L214;
    L222:
        Block r57 = (Block) r56;
    L224:
        if (r57 == null) goto L233;
        FLogger.a.i("MessageRequestConvert", "convert message content type 9999 to SendAttachmentStrategy");
        NestedFileContent r135 = com.larus.bmhome.chat.bean.d.f(r115);
        List r58 = r135.getEntities();
        if (r58 == null) goto L231;
        Iterator r59 = r58.iterator();
    L229:
        if (r59.hasNext() == false) goto L231;
        ((UplinkFileEntity) r59.next()).setFileParsedStatus(Integer.valueOf(FileParseState.SUCCESS.getValue()));
    L231:
        r41 = new ai8.f(r135, r117, null, r213, r119, r37, false, null, null, null, 964);
        goto L236
    L233:
        FLogger.a.e("MessageRequestConvert", "convert message content type 9999 to strategy failed, supported block not found");
        s r60 = s.a;
        Application r61 = AppHost.a.getApplication();
        r60.getClass();
        s.b(r61, 2131910343, false);
        goto L235
    L218:
        r134 = false;
        goto L219
    L221:
        r56 = null;
        goto L222
    L223:
        r57 = null;
        goto L224
    L198:
        r132 = false;
        goto L199
    L201:
        r51 = null;
        goto L202
    L203:
        r52 = null;
        goto L204
    L129:
        r123 = null;
        goto L130
    L112:
        r29 = null;
    L120:
        r34 = r8;
    L104:
        r119 = new LinkedHashMap();
        goto L106
    L239:
        u1.a.a(r12.getSender(), r9, r26, this.$scene, "hideAndReSendMessage");
        return Unit.INSTANCE;
    L96:
        r24 = null;
        goto L97
    L90:
        if (r4.length() == 0) goto L93;
        r23 = false;
        goto L94
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r4 = (String) this.L$3;
        String r62 = (String) this.L$2;
        Message r63 = (Message) this.L$1;
        IChatRepoService r136 = (IChatRepoService) this.L$0;
        ResultKt.throwOnFailure(r36);
        r12 = r136;
        Message r137 = r63;
        r9 = r62;
        Object r64 = r36;
    L51:
        List r65 = CollectionsKt.sortedWith((Iterable) r64, new a());
    L53:
        ChatSender r138 = this.this$0;
        this.L$0 = r12;
        this.L$1 = r137;
        this.L$2 = r9;
        this.L$3 = r4;
        this.L$4 = r65;
        this.label = 4;
        int r66 = ChatSender.c;
        r138.getClass();
        if (r137 != null) goto L56;
        r10 = CollectionsKt.emptyList();
    L69:
        if (r10 != r1) goto L71;
        return r1;
    L71:
        r3 = r65;
        r6 = r137;
        goto L72
    L56:
        String r67 = r137.getMessageId();
        if (r67 != null) goto L59;
        r67 = NameKeys.UnloadStrategy_No_Strategy;
    L59:
        String r139 = r137.getConversationId();
        if (r139 != null) goto L63;
        r139 = NameKeys.UnloadStrategy_No_Strategy;
    L63:
        if (StringsKt.isBlank(r67) == false) goto L65;
    L68:
        r10 = CollectionsKt.emptyList();
        goto L69
    L65:
        if (StringsKt.isBlank(r139) == true) goto L68;
        CompletableDeferred r140 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        d.e().o(r139, r67, new f(r140));
        r10 = r140.await(this);
        goto L69
    L12:
        IChatRepoService r68 = (IChatRepoService) this.L$0;
        ResultKt.throwOnFailure(r36);
        Object r69 = r36;
    L28:
        Message r70 = (Message) r69;
        if (r70 == null) goto L31;
    L24:
        IChatRepoService r141 = r68;
        String r71 = r70.getConversationId();
        if (r71 == null) goto L35;
        Map r142 = r70.getExt();
        if (r142 == null) goto L39;
        String r143 = (String) r142.get("collection_id");
    L40:
        if (r143 != null) goto L42;
    L45:
        boolean r144 = true;
    L46:
        if (r144 == true) goto L52;
        this.L$0 = r141;
        this.L$1 = r70;
        this.L$2 = r71;
        this.L$3 = r143;
        this.label = 3;
        r64 = r141.s1(r70, this);
        if (r64 != r1) goto L50;
        return r1;
    L50:
        Message r310 = r70;
        r9 = r71;
        r4 = r143;
        r12 = r141;
        r137 = r310;
        goto L51
    L52:
        r65 = CollectionsKt.listOf(r70);
        Message r311 = r70;
        r9 = r71;
        r4 = r143;
        r12 = r141;
        r137 = r311;
        goto L53
    L42:
        if (r143.length() == 0) goto L45;
        r144 = false;
        goto L46
    L39:
        r143 = null;
        goto L40
    L35:
        return Unit.INSTANCE;
    L31:
        return Unit.INSTANCE;
    L13:
        r68 = (IChatRepoService) this.L$0;
        ResultKt.throwOnFailure(r36);
        Object r145 = r36;
    L17:
        Message r146 = (Message) r145;
        if (r146 != null) goto L22;
        return Unit.INSTANCE;
    L22:
        if (this.$isQuestion == false) goto L25;
        r70 = r146;
        goto L24
    L25:
        this.L$0 = r68;
        this.label = 2;
        r69 = r68.y1(r146, this);
        if (r69 != r1) goto L28;
        return r1;
    L14:
        ResultKt.throwOnFailure(r36);
        r68 = RepoDispatcherDelegate.b.e();
        String r147 = this.$messageId;
        this.L$0 = r68;
        this.label = 1;
        r145 = r68.E1(r147, this);
        if (r145 != r1) goto L17;
        return r1;
    }
}
