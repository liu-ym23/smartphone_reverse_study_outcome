package com.larus.bmhome.chat.model.strategy.block;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.internal.delegate.k0;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.block.ChatBlockSendStrategy$reeditMessage$1", f = "ChatBlockSendStrategy.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {885, 895, 903, 907}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "requestExtras", "collectionId", "isConversationForkAutoRouteReanswer", "$this$launch", "requestExtras", "collectionId", "questions", "editQueryIds", "isConversationForkAutoRouteReanswer", "$this$launch", "requestExtras", "collectionId", "questions", "editQueryIds", "relatedDeletedMessageIds", "isConversationForkAutoRouteReanswer"}, s = {"L$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"})
public final class ChatBlockSendStrategy$reeditMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $attachmentEntityLocalMsgId;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ String $content;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ boolean $isReplaceNone;
    final /* synthetic */ Message $message;
    final /* synthetic */ AttachmentInfo $newAttachmentInfo;
    final /* synthetic */ NestedFileContent $newNestedFileContent;
    final /* synthetic */ String $scene;
    final /* synthetic */ Long $sendClickTimestamp;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    final /* synthetic */ ChatBlockSendStrategy this$0;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
        }
    }

    public ChatBlockSendStrategy$reeditMessage$1(Message r1, String r2, ChatBlockSendStrategy r3, wc9.e r4, Map<String, String> r5, String r6, NestedFileContent r7, AttachmentInfo r8, boolean r9, ChatPageContext r10, String r11, Long r12, Continuation<? super ChatBlockSendStrategy$reeditMessage$1> r13) {
        this.$message = r1;
        this.$scene = r2;
        this.this$0 = r3;
        this.$conversation = r4;
        this.$extras = r5;
        this.$content = r6;
        this.$newNestedFileContent = r7;
        this.$newAttachmentInfo = r8;
        this.$isReplaceNone = r9;
        this.$chatPageContext = r10;
        this.$attachmentEntityLocalMsgId = r11;
        this.$sendClickTimestamp = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
        ChatBlockSendStrategy$reeditMessage$1 r15 = new ChatBlockSendStrategy$reeditMessage$1(this.$message, this.$scene, this.this$0, this.$conversation, this.$extras, this.$content, this.$newNestedFileContent, this.$newAttachmentInfo, this.$isReplaceNone, this.$chatPageContext, this.$attachmentEntityLocalMsgId, this.$sendClickTimestamp, r18);
        r15.L$0 = r17;
        return r15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r88) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r14 = "ChatBlockSendStrategy";
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        boolean r2 = this.Z$0;
        Map r3 = (Map) this.L$5;
        List r4 = (List) this.L$4;
        List r5 = (List) this.L$3;
        String r6 = (String) this.L$2;
        Map r7 = (Map) this.L$1;
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r88);
        final boolean r26 = r2;
    L71:
        String r9 = this.$content;
        if (r9 != null) goto L74;
    L77:
        boolean r10 = true;
    L78:
        if (r10 == false) goto L380;
    L86:
        Object r11 = null;
    L87:
        TextContent r12 = (TextContent) r11;
        if (r12 == null) goto L90;
        String r13 = r12.text;
    L92:
        if (r13 != null) goto L94;
        r13 = "";
    L94:
        NestedFileContent r15 = this.$newNestedFileContent;
        if (r15 == null) goto L97;
        List r16 = r15.getEntities();
    L98:
        List r17 = r16;
        if (r17 != null) goto L101;
    L104:
        boolean r18 = true;
    L105:
        boolean r19 = !r18;
        Integer r20 = z2.a.attachmentEditConfig().getReeditWithAttachment();
        if (r20 != null) goto L109;
    L111:
        boolean r21 = false;
    L112:
        if (r19 == false) goto L114;
    L117:
        boolean r110 = true;
    L119:
        if (this.$isReplaceNone == false) goto L121;
    L128:
        if (r6 != null) goto L130;
    L133:
        boolean r22 = true;
    L134:
        if (r22 == false) goto L138;
        if (r110 == true) goto L138;
        String r23 = null;
    L139:
        String r111 = this.$scene;
        String r112 = this.$content;
        ChatPageContext r113 = this.$chatPageContext;
        ChatBlockSendStrategy r24 = this.this$0;
        final Map r39 = r3;
        wc9.e r25 = this.$conversation;
        String r40 = "1";
        ArrayList r114 = new ArrayList();
        Iterator r27 = r5.iterator();
    L140:
        boolean r41 = r21;
        if (r27.hasNext() == false) goto L157;
        Message r28 = (Message) r27.next();
        int r115 = wf9.b.a;
        Iterator r29 = r27;
        String r30 = com.flow.kmp.common.util.i.a();
        String r42 = r14;
        k0 r116 = k0.b;
        String r117 = r28.getLocalMessageId();
        boolean r43 = r19;
        if (r117 != null) goto L145;
        String r31 = "";
    L146:
        r116.b(r31, r30);
        ChatControlTrace r32 = ChatControlTrace.b;
        if (r111 != null) goto L149;
        String r118 = "edit";
    L150:
        r32.Ma(r30, r118);
        Map<String, String> r210 = a(r7, r24, r113, r23, r4, r25, r28.getExt(), r28);
        Map r33 = r28.getBusinessExt();
        if (r33 != null) goto L153;
        r33 = new LinkedHashMap();
    L153:
        wc9.e r211 = r25;
        Map r212 = com.larus.utils.h.c(r33, new Pair[]{TuplesKt.to("send_loading", ic8.j.f(r28))});
        d0.a.getClass();
        ic8.w r34 = d0.p(r28, false, true, r112, r30, r210, r212, r113);
        if (r34 == null) goto L156;
        r114.add(r34);
    L156:
        r27 = r29;
        r25 = r211;
        r21 = r41;
        r14 = r42;
        r19 = r43;
        goto L140
    L149:
        r118 = r111;
        goto L150
    L145:
        r31 = r117;
        goto L146
    L157:
        boolean r44 = r19;
        String r45 = r14;
        final List r35 = CollectionsKt.toMutableList(r114);
        List r36 = r35;
        if ((r36 instanceof Collection) == true) goto L160;
    L162:
        Iterator r37 = r36.iterator();
    L164:
        if (r37.hasNext() == false) goto L168;
        if ((((ic8.w) r37.next()) instanceof ai8.h) == false) goto L164;
        boolean r38 = true;
    L169:
        if (r38 == false) goto L171;
    L181:
        if (r110 == true) goto L183;
    L199:
        if (r44 == true) goto L201;
        String r46 = r45;
        if (r41 == true) goto L230;
    L241:
        AttachmentInfo r47 = this.$newAttachmentInfo;
        if (r47 == null) goto L279;
        String r48 = this.$scene;
        Message r49 = this.$message;
        ChatPageContext r119 = this.$chatPageContext;
        ChatBlockSendStrategy r120 = this.this$0;
        wc9.e r121 = this.$conversation;
        int r122 = wf9.b.a;
        String r123 = com.flow.kmp.common.util.i.a();
        ChatControlTrace r124 = ChatControlTrace.b;
        if (r48 != null) goto L246;
        r48 = "edit";
    L246:
        r124.Ma(r123, r48);
        if (r47.isImage() == false) goto L267;
        String r410 = r47.getFilePath();
        String r411 = r47.getTosKey();
        Integer r50 = r47.getHeight();
        if (r50 == null) goto L251;
        int r51 = r50.intValue();
    L252:
        Integer r125 = r47.getWidth();
        if (r125 == null) goto L255;
        int r126 = r125.intValue();
    L256:
        ai8.e r52 = new ai8.e(r410, r411, Boxing.boxInt(r51), Boxing.boxInt(r126), r47.getResourceId(), r47.getServerUrl(), r123, com.larus.bmhome.chat.bean.d.b1(r49), invokeSuspend$buildReeditExt$default(r7, r120, r119, r23, r4, r121, r49.getExt(), null, 128, null), null, false, r119, null, null, 27712);
        Iterator r53 = r35.iterator();
        int r54 = 0;
    L258:
        if (r53.hasNext() == false) goto L263;
        if ((((ic8.w) r53.next()) instanceof ai8.e) == true) goto L264;
        r54 = r54 + 1;
    L264:
        if (r54 >= 0) goto L266;
        ListProtector.add(r35, 0, r52);
    L278:
        Unit r55 = Unit.INSTANCE;
    L303:
        if (r35.isEmpty() == false) goto L306;
        FLogger.a.i(r46, "reeditMessage: no strategy generated, do nothing");
        return Unit.INSTANCE;
    L306:
        List r56 = r35;
        ArrayList r57 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r56, 10));
        Iterator r58 = r56.iterator();
    L308:
        if (r58.hasNext() == false) goto L310;
        ic8.w r59 = (ic8.w) r58.next();
        r57.add(new Message(null, null, null, 0, 0, null, r59.contentType(), false, null, r59.content(), null, null, null, r59.a(), null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, r59.g(), null, 0, null, null, null, 2147474879, 31, null));
        goto L308
    L310:
        String r60 = CommonParamManager.b();
        wc9.e r61 = this.$conversation;
        Long r62 = this.$sendClickTimestamp;
        Iterator r127 = r56.iterator();
    L312:
        if (r127.hasNext() == false) goto L318;
        ic8.w r128 = (ic8.w) r127.next();
        com.larus.bmhome.chat.trace.appreciable.f r213 = com.larus.bmhome.chat.trace.appreciable.f.a;
        String r129 = r128.b();
        if (r129 != null) goto L316;
        String r214 = "";
    L317:
        com.larus.bmhome.chat.trace.appreciable.f.l(r213, r214, r61.a, "edit", r128.contentType(), r57, null, r60, r62, 32);
        goto L312
    L316:
        r214 = r129;
        goto L317
    L318:
        NestedFileContent r63 = this.$newNestedFileContent;
        if (r63 == null) goto L334;
        List r64 = r63.getEntities();
        if (r64 == null) goto L334;
        ArrayList r65 = new ArrayList();
        Iterator r66 = r64.iterator();
    L324:
        if (r66.hasNext() == false) goto L335;
        Object r67 = r66.next();
        Integer r68 = ((UplinkFileEntity) r67).getUpLinkStatus();
        int r130 = UpLinkState.SUCCESS.getValue();
        if (r68 != null) goto L329;
    L330:
        boolean r131 = true;
    L332:
        if (r131 == false) goto L324;
        r65.add(r67);
        goto L324
    L329:
        if (r68.intValue() != r130) goto L330;
        r131 = false;
    L335:
        Iterator r69 = r35.iterator();
        int r132 = 0;
    L337:
        if (r69.hasNext() == false) goto L342;
        if ((((ic8.w) r69.next()) instanceof ai8.f) == true) goto L343;
        r132 = r132 + 1;
    L343:
        String r70 = this.$attachmentEntityLocalMsgId;
        if (r70 != null) goto L346;
    L349:
        boolean r71 = true;
    L350:
        if (r71 == false) goto L352;
    L378:
        ChatBlockSendStrategy.m(this.this$0, this.$conversation, r35, !r26, r39);
        return Unit.INSTANCE;
    L352:
        if (this.$newNestedFileContent == null) goto L378;
        if (r65 != null) goto L355;
    L358:
        boolean r72 = true;
    L359:
        if (r72 == true) goto L378;
        if (r132 < 0) goto L378;
        FLogger.a.i(r46, "reeditMessage: file uploading, prepare local messages first then wait, panelLocalMsgId=" + this.$attachmentEntityLocalMsgId + ", processingCount=" + r65.size());
        Object r73 = ListProtector.get(r35, r132);
        Intrinsics.checkNotNull(r73, "null cannot be cast to non-null type com.larus.bmhome.chat.model.strategy.media.SendNestedFileStrategy");
        final String r74 = ((ai8.f) r73).b;
        ArrayList r75 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r56, 10));
        Iterator r76 = r56.iterator();
    L363:
        if (r76.hasNext() == false) goto L376;
        ic8.w r77 = (ic8.w) r76.next();
        Map<String, String> r78 = r77.a();
        if (r78 == null) goto L367;
        Map<String, String> r79 = MapsKt.toMap(r78);
    L368:
        if (r79 != null) goto L370;
        r79 = MapsKt.emptyMap();
    L370:
        Map<String, String> r80 = r77.f();
        if (r80 == null) goto L374;
        Map<String, String> r81 = MapsKt.toMutableMap(r80);
        if (r81 == null) goto L374;
    L375:
        String r82 = r40;
        r81.put("send_loading", r82);
        r75.add(r77.c(r79, r81));
        r40 = r82;
    L374:
        r81 = new LinkedHashMap();
        goto L375
    L367:
        r79 = null;
        goto L368
    L376:
        final ChatBlockSendStrategy r83 = this.this$0;
        final wc9.e r84 = this.$conversation;
        String r85 = r84.a;
        final String r86 = this.$attachmentEntityLocalMsgId;
        final NestedFileContent r87 = this.$newNestedFileContent;
        r83.i(r85, 0, r75, new q(r83, r84, r86, r74, r87, r35, r26, r39));
        return Unit.INSTANCE;
    L355:
        if (r65.isEmpty() == true) goto L358;
        r72 = false;
        goto L359
    L346:
        if (StringsKt.isBlank(r70) == true) goto L349;
        r71 = false;
        goto L350
    L342:
        r132 = -1;
    L334:
        r65 = null;
        goto L335
    L266:
        ListProtector.set(r35, r54, r52);
        goto L278
    L263:
        r54 = -1;
        goto L264
    L255:
        r126 = 0;
        goto L256
    L251:
        r51 = 0;
        goto L252
    L267:
        ai8.d r89 = new ai8.d(r47.getFilePath(), r47.getFileName(), r47.getTosKey(), r47.getResourceId(), r123, com.larus.bmhome.chat.bean.d.b1(r49), invokeSuspend$buildReeditExt$default(r7, r120, r119, r23, r4, r121, r49.getExt(), null, 128, null), null, r119, 384);
        Iterator r90 = r35.iterator();
        int r91 = 0;
    L269:
        if (r90.hasNext() == false) goto L274;
        if ((((ic8.w) r90.next()) instanceof ai8.d) == true) goto L275;
        r91 = r91 + 1;
    L275:
        if (r91 >= 0) goto L277;
        ListProtector.add(r35, 0, r89);
        goto L278
    L277:
        ListProtector.set(r35, r91, r89);
        goto L278
    L274:
        r91 = -1;
        goto L275
    L279:
        boolean r92 = this.$isReplaceNone;
        if (r41 == false) goto L303;
        if (r92 == true) goto L303;
        Iterator r93 = r35.iterator();
        int r133 = 0;
    L284:
        if (r93.hasNext() == false) goto L289;
        if ((((ic8.w) r93.next()) instanceof ai8.d) == true) goto L290;
        r133 = r133 + 1;
    L290:
        if (r133 < 0) goto L292;
        ListProtector.remove(r35, r133);
    L292:
        Iterator r94 = r35.iterator();
        int r134 = 0;
    L294:
        if (r94.hasNext() == false) goto L299;
        if ((((ic8.w) r94.next()) instanceof ai8.e) == true) goto L300;
        r134 = r134 + 1;
    L300:
        if (r134 < 0) goto L303;
        ListProtector.remove(r35, r134);
        goto L303
    L299:
        r134 = -1;
        goto L300
    L289:
        r133 = -1;
        goto L290
    L230:
        if (this.$isReplaceNone == true) goto L241;
        Iterator r95 = r35.iterator();
        int r96 = 0;
    L233:
        if (r95.hasNext() == false) goto L238;
        if ((((ic8.w) r95.next()) instanceof ai8.f) == true) goto L239;
        r96 = r96 + 1;
    L239:
        if (r96 < 0) goto L241;
        ListProtector.remove(r35, r96);
        goto L241
    L238:
        r96 = -1;
        goto L239
    L201:
        if (Intrinsics.areEqual(this.$attachmentEntityLocalMsgId, this.$message.getLocalMessageId()) == false) goto L203;
        r46 = r45;
        FLogger.a.e(r46, "reeditMessage: attachmentEntityLocalMsgId equals original message localMessageId, localMessageId=" + this.$message.getLocalMessageId());
    L204:
        String r97 = this.$attachmentEntityLocalMsgId;
        if (r97 != null) goto L207;
    L212:
        int r99 = wf9.b.a;
        r97 = com.flow.kmp.common.util.i.a();
    L213:
        ChatControlTrace r100 = ChatControlTrace.b;
        String r135 = this.$scene;
        if (r135 != null) goto L216;
        r135 = "edit";
    L216:
        r100.Ma(r97, r135);
        ai8.f r101 = new ai8.f(this.$newNestedFileContent, r97, null, com.larus.bmhome.chat.bean.d.b1(this.$message), invokeSuspend$buildReeditExt$default(r7, this.this$0, this.$chatPageContext, r23, r4, this.$conversation, this.$message.getExt(), null, 128, null), null, false, null, this.$chatPageContext, null, 740);
        Iterator r102 = r35.iterator();
        int r103 = 0;
    L218:
        if (r102.hasNext() == false) goto L223;
        if ((((ic8.w) r102.next()) instanceof ai8.f) == true) goto L224;
        r103 = r103 + 1;
    L224:
        if (r103 >= 0) goto L226;
        ListProtector.add(r35, 0, r101);
        goto L303
    L226:
        ListProtector.set(r35, r103, r101);
        goto L303
    L223:
        r103 = -1;
        goto L224
    L207:
        if ((!StringsKt.isBlank(r97)) == true) goto L210;
        r97 = null;
    L210:
        if (r97 == null) goto L212;
    L203:
        r46 = r45;
        goto L204
    L183:
        if (this.$isReplaceNone == true) goto L199;
        if (r13.length() != 0) goto L187;
        boolean r104 = true;
    L188:
        if (r104 == false) goto L199;
        Iterator r105 = r35.iterator();
        int r106 = 0;
    L191:
        if (r105.hasNext() == false) goto L196;
        if ((((ic8.w) r105.next()) instanceof ai8.h) == true) goto L197;
        r106 = r106 + 1;
    L197:
        if (r106 < 0) goto L199;
        ListProtector.remove(r35, r106);
        goto L199
    L196:
        r106 = -1;
        goto L197
    L187:
        r104 = false;
        goto L188
    L171:
        if (this.$isReplaceNone == true) goto L181;
        if (r13.length() <= 0) goto L175;
        boolean r107 = true;
    L176:
        if (r107 == false) goto L181;
        int r108 = wf9.b.a;
        String r109 = com.flow.kmp.common.util.i.a();
        ChatControlTrace r136 = ChatControlTrace.b;
        String r137 = this.$scene;
        if (r137 != null) goto L180;
        r137 = "edit";
    L180:
        r136.Ma(r109, r137);
        r35.add(new ai8.h(r13, r109, null, com.larus.bmhome.chat.bean.d.b1(this.$message), invokeSuspend$buildReeditExt$default(r7, this.this$0, this.$chatPageContext, r23, r4, this.$conversation, this.$message.getExt(), null, 128, null), null, false, true, this.$chatPageContext, null, 612));
        goto L181
    L175:
        r107 = false;
    L168:
        r38 = false;
        goto L169
    L160:
        if (r36.isEmpty() == false) goto L162;
    L138:
        r23 = UUID.randomUUID().toString();
        goto L139
    L130:
        if (r6.length() == 0) goto L133;
        r22 = false;
        goto L134
    L121:
        if (r13.length() != 0) goto L123;
        boolean r138 = true;
    L124:
        if (r138 == false) goto L128;
        if (r110 == true) goto L128;
        FLogger.a.i("ChatBlockSendStrategy", "reeditMessage: new content is empty, do nothing");
        return Unit.INSTANCE;
    L123:
        r138 = false;
        goto L124
    L114:
        if (this.$newAttachmentInfo != null) goto L117;
        r110 = false;
        goto L119
    L109:
        if (r20.intValue() != 1) goto L111;
        r21 = true;
        goto L112
    L101:
        if (r17.isEmpty() == true) goto L104;
        r18 = false;
        goto L105
    L97:
        r16 = null;
        goto L98
    L90:
        r13 = null;
        goto L92
    L380:
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L82
        r11 = Result.constructor-impl(HttpExtKt.f.fromJson(r9, TextContent.class));     // Catch: Throwable -> L82
    L85:
        if (Result.isFailure-impl(r11) == false) goto L87;
    L82:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L85
    L74:
        if (StringsKt.isBlank(r9) == true) goto L77;
        r10 = false;
        goto L78
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        boolean r141 = this.Z$0;
        List r142 = (List) this.L$4;
        List r143 = (List) this.L$3;
        String r144 = (String) this.L$2;
        Map r145 = (Map) this.L$1;
        CoroutineScope r146 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r88);
        Object r147 = r88;
        boolean r148 = r141;
        List r149 = r142;
        CoroutineScope r150 = r146;
        List r151 = r143;
        String r152 = r144;
        Map r153 = r145;
    L67:
        List r154 = (List) r147;
        List r155 = CollectionsKt.plus(r151, r154);
        ChatSendUtils.a.getClass();
        Map r156 = ChatSendUtils.j(r154);
        RepoDispatcher.a.getClass();
        ChatRepo r157 = RepoDispatcher.d;
        String r158 = this.$conversation.a;
        this.L$0 = r150;
        this.L$1 = r153;
        this.L$2 = r152;
        this.L$3 = r151;
        this.L$4 = r149;
        this.L$5 = r156;
        this.Z$0 = r148;
        this.label = 4;
        Map r159 = r153;
        String r160 = r152;
        List r161 = r151;
        if (r157.C1(r158, r155, false, false, this) != r0) goto L70;
        return r0;
    L70:
        r3 = r156;
        r7 = r159;
        r6 = r160;
        r26 = r148;
        r4 = r149;
        r5 = r161;
        goto L71
    L12:
        boolean r162 = this.Z$0;
        String r163 = (String) this.L$2;
        Map r164 = (Map) this.L$1;
        CoroutineScope r165 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r88);
        Object r166 = r88;
    L45:
        List r167 = CollectionsKt.sortedWith((Iterable) r166, new a());
    L46:
        CoroutineScope r168 = r165;
        ArrayList r169 = new ArrayList();
        Iterator r170 = r167.iterator();
    L50:
        if (r170.hasNext() == false) goto L54;
        String r171 = ((Message) r170.next()).getMessageId();
        if (r171 == null) goto L50;
        r169.add(r171);
        goto L50
    L54:
        ArrayList r172 = new ArrayList();
        Iterator r173 = r169.iterator();
    L56:
        if (r173.hasNext() == false) goto L63;
        Object r174 = r173.next();
        if (((String) r174).length() <= 0) goto L60;
        boolean r175 = true;
    L61:
        if (r175 == false) goto L56;
        r172.add(r174);
        goto L56
    L60:
        r175 = false;
        goto L61
    L63:
        RepoDispatcher.a.getClass();
        ChatRepo r176 = RepoDispatcher.d;
        Message r177 = this.$message;
        this.L$0 = r168;
        this.L$1 = r164;
        this.L$2 = r163;
        this.L$3 = r167;
        this.L$4 = r172;
        this.Z$0 = r162;
        this.label = 3;
        r176.getClass();
        r147 = ChatRepo.d(r177, this);
        if (r147 != r0) goto L66;
        return r0;
    L66:
        r148 = r162;
        r149 = r172;
        r150 = r168;
        r153 = r164;
        r151 = r167;
        r152 = r163;
        goto L67
    L13:
        CoroutineScope r178 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r88);
        CoroutineScope r179 = r178;
        Object r180 = r88;
    L19:
        Boolean r181 = (Boolean) r180;
    L21:
        r165 = r179;
        Map<String, String> r182 = this.$extras;
        if (r182 == null) goto L24;
        String r183 = r182.get("conversation_fork_auto_route_reanswer");
    L25:
        r162 = Intrinsics.areEqual(r183, "1");
        Map<String, String> r184 = this.$extras;
        if (r184 == null) goto L30;
        r164 = MapsKt.toMutableMap(r184);
        if (r164 == null) goto L30;
        r164.remove("conversation_fork_auto_route_reanswer");
    L31:
        Map r185 = this.$message.getExt();
        if (r185 == null) goto L34;
        r163 = (String) r185.get("collection_id");
    L35:
        if (r163 != null) goto L37;
    L40:
        boolean r186 = true;
    L41:
        if (r186 == true) goto L47;
        RepoDispatcher.a.getClass();
        ChatRepo r187 = RepoDispatcher.d;
        Message r188 = this.$message;
        this.L$0 = r165;
        this.L$1 = r164;
        this.L$2 = r163;
        this.Z$0 = r162;
        this.label = 2;
        r166 = r187.s1(r188, this);
        if (r166 != r0) goto L45;
        return r0;
    L47:
        r167 = CollectionsKt.listOf(this.$message);
        goto L46
    L37:
        if (r163.length() == 0) goto L40;
        r186 = false;
        goto L41
    L34:
        r163 = null;
    L30:
        r164 = null;
        goto L31
    L24:
        r183 = null;
        goto L25
    L14:
        ResultKt.throwOnFailure(r88);
        CoroutineScope r189 = (CoroutineScope) this.L$0;
        FLogger.a.i("ChatBlockSendStrategy", "reeditMessage: messageId = " + this.$message.getMessageId() + ", scene = " + this.$scene);
        IObricChatSPIService r190 = (IObricChatSPIService) this.this$0.c.getValue();
        if (r190 == null) goto L20;
        String r191 = this.$conversation.a;
        this.L$0 = r189;
        this.label = 1;
        r179 = r189;
        r180 = IObricChatSPIService.a.a(r190, r191, false, null, this, 6);
        if (r180 != r0) goto L19;
        return r0;
    L20:
        r179 = r189;
        goto L21
    }

    public static final Map<String, String> a(Map<String, String> r12, ChatBlockSendStrategy r13, ChatPageContext r14, String r15, List<String> r16, wc9.e r17, Map<String, String> r18, Message r19) {
        if (r18 == null) goto L6;
        Map<String, String> r2 = MapsKt.toMutableMap(r18);
        if (r2 == null) goto L6;
    L7:
        if (r12 == null) goto L9;
        r2.putAll(r12);
    L9:
        ChatBlockSendStrategy.k(r13, r2, r14);
        if (r15 == null) goto L12;
        r2.put("collection_id", r15);
    L12:
        r2.remove("prompt_modification");
        if (ObricFeatureServiceDelegate.b.a() == false) goto L22;
        if (r19 == null) goto L22;
        Set r0 = ServiceManager.get().getServices(IMessageExtService.class, true);
        if (r0 == null) goto L22;
        Iterator r1 = r0.iterator();
    L19:
        if (r1.hasNext() == false) goto L22;
        ((IMessageExtService) r1.next()).b(r2, new IMessageExtService.a(r19.getContent(), String.valueOf(r19.getMessageId())));
    L22:
        if ((!r16.isEmpty()) == false) goto L24;
        r2.put("edit_query_id", CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, null, 62, null));
    L24:
        if (r19 == null) goto L26;
        String r3 = r19.getLocalMessageId();
    L27:
        if (r3 == null) goto L32;
        String r4 = r19.getLocalMessageId();
        if (r4 != null) goto L31;
        r4 = "";
    L31:
        r2.put("modified_from", r4);
    L32:
        return r2;
    L26:
        r3 = null;
    L6:
        r2 = new LinkedHashMap();
        goto L7
    }

    public static /* synthetic */ Map invokeSuspend$buildReeditExt$default(Map r9, ChatBlockSendStrategy r10, ChatPageContext r11, String r12, List r13, wc9.e r14, Map r15, Message r16, int r17, Object r18) {
        if ((r17 & 128) == 0) goto L5;
        Message r8 = null;
    L7:
        return a(r9, r10, r11, r12, r13, r14, r15, r8);
    L5:
        r8 = r16;
        goto L7
    }
}
