package com.obric.assistant.cocreationreview.modules.searchqa;

import android.database.sqlite.SQLiteDatabase;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.a;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.OSearchEntityCollection;
import com.larus.im.bean.message.block.OSearchEntityImage;
import com.larus.im.bean.message.block.OSearchEntityText;
import com.larus.im.bean.message.block.OSearchEntityVideo;
import com.larus.im.bean.message.block.OSearchQueryResultBlock;
import com.larus.im.bean.message.block.OSearchReference;
import com.larus.im.bean.message.block.OSearchReferenceInCollection;
import com.larus.im.bean.message.block.TextBlock;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.s3;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.searchqa.SearchQaMessageCollector$handleMessage$2", f = "SearchQaMessageCollector.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
final class SearchQaMessageCollector$handleMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $extSnapshot;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ t this$0;

    public SearchQaMessageCollector$handleMessage$2(t r1, Message r2, String r3, Map<String, String> r4, Continuation<? super SearchQaMessageCollector$handleMessage$2> r5) {
        this.this$0 = r1;
        this.$message = r2;
        this.$messageId = r3;
        this.$extSnapshot = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SearchQaMessageCollector$handleMessage$2(this.this$0, this.$message, this.$messageId, this.$extSnapshot, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r5 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r28);
        Object r3 = r28;
    L27:
        Message r4 = (Message) r3;
        if (r4 != null) goto L30;
    L54:
        String r12 = null;
    L55:
        if (r12 != null) goto L65;
        int r1 = s3.a;
        s3.c("search_qa.collector", "skip no query messageId=" + this.$messageId + ", replyId=" + this.$message.getReplyId());
        t r6 = this.this$0;
        LinkedHashSet r7 = r6.d;
        String r8 = this.$messageId;
        monitor-enter(r7);
        r6.d.remove(r8);     // Catch: Throwable -> L62
        monitor-exit(r7);
        return Unit.INSTANCE;
    L62:
        th = move-exception;
        throw th;
    L65:
        Message r9 = this.$message;
        Map<String, String> r10 = this.$extSnapshot;
        List r11 = r9.getContentBlock();
        if (r11 != null) goto L68;
        r11 = CollectionsKt.emptyList();
    L68:
        List r13 = r11;
        Iterator r14 = r13.iterator();
    L70:
        if (r14.hasNext() == false) goto L77;
        Object r15 = r14.next();
        if (((Block) r15).getBlockType() != 10042) goto L74;
        boolean r16 = true;
    L75:
        if (r16 == false) goto L70;
    L78:
        Block r17 = (Block) r15;
        if (r17 == null) goto L83;
        BlockContent r18 = r17.getContent();
        if (r18 == null) goto L83;
        OSearchQueryResultBlock r19 = r18.getOSearchQueryResultBlock();
    L84:
        Iterator r20 = r13.iterator();
    L86:
        if (r20.hasNext() == false) goto L93;
        Object r21 = r20.next();
        if (((Block) r21).getBlockType() != 10000) goto L90;
        boolean r22 = true;
    L91:
        if (r22 == false) goto L86;
    L94:
        Block r23 = (Block) r21;
        if (r23 == null) goto L105;
        BlockContent r24 = r23.getContent();
        if (r24 == null) goto L105;
        TextBlock r25 = r24.getTextBlock();
        if (r25 == null) goto L105;
        String r26 = r25.text;
        if (r26 == null) goto L105;
        if ((!StringsKt.isBlank(r26)) == false) goto L105;
        String r110 = r26;
    L106:
        if (r19 == null) goto L108;
        List r27 = r19.results;
    L109:
        if (r27 != null) goto L111;
        r27 = CollectionsKt.emptyList();
    L111:
        ArrayList r111 = new ArrayList();
        Iterator r29 = r27.iterator();
    L113:
        if (r29.hasNext() == false) goto L233;
        OSearchReference r30 = (OSearchReference) r29.next();
        if (r30 == null) goto L129;
        OSearchEntityText r112 = r30.getOEntityText();
        if (r112 == null) goto L129;
        String r113 = r112.getTitle();
        if (r113 != null) goto L121;
    L127:
        s r114 = null;
    L128:
        if (r114 == null) goto L129;
    L231:
        if (r114 == null) goto L113;
        r111.add(r114);
        goto L113
    L121:
        if ((!StringsKt.isBlank(r113)) == false) goto L123;
        String r115 = r113;
    L124:
        if (r115 == null) goto L127;
        r114 = new s(r115, u.a(r115), r112.getEntityType(), r112.getEntityId(), r112.getEntityPackageName(), r112.getIndex(), null, null, null, 896);
        goto L128
    L123:
        r115 = null;
    L129:
        if (r30 == null) goto L210;
        OSearchEntityCollection r116 = r30.getOEntityCollection();
        if (r116 == null) goto L210;
        String r117 = r116.getTitle();
        if (r117 != null) goto L135;
    L208:
        s r31 = null;
    L209:
        r114 = r31;
    L211:
        if (r114 != null) goto L231;
        if (r30 == null) goto L230;
        TextCard r32 = r30.getTextCard();
        if (r32 == null) goto L230;
        String r33 = r32.getTitle();
        if (r33 == null) goto L230;
        if ((!StringsKt.isBlank(r33)) == false) goto L220;
        String r118 = r33;
    L221:
        if (r118 == null) goto L230;
        String r119 = u.a(r118);
        Integer r210 = r32.getIndex();
        String r34 = r32.getUrl();
        if (r34 != null) goto L226;
    L228:
        String r211 = null;
    L229:
        r114 = new s(r118, r119, null, null, null, r210, null, null, r211, 440);
        goto L231
    L226:
        if ((!StringsKt.isBlank(r34)) == false) goto L228;
        r211 = r34;
        goto L229
    L220:
        r118 = null;
    L230:
        r114 = null;
        goto L231
    L135:
        if ((!StringsKt.isBlank(r117)) == false) goto L137;
        String r120 = r117;
    L138:
        if (r120 == null) goto L208;
        List r121 = r116.getItems();
        if (r121 != null) goto L143;
        r121 = CollectionsKt.emptyList();
    L143:
        ArrayList r122 = new ArrayList();
        Iterator r123 = r121.iterator();
    L145:
        if (r123.hasNext() == false) goto L189;
        OSearchReferenceInCollection r124 = (OSearchReferenceInCollection) r123.next();
        if (r124 == null) goto L186;
        OSearchEntityImage r125 = r124.getOEntityImage();
        if (r125 == null) goto L167;
        String r126 = r125.getResUri();
        if (r126 != null) goto L153;
    L156:
        boolean r127 = true;
    L158:
        if ((!r127) == true) goto L161;
        r125 = null;
    L161:
        if (r125 == null) goto L167;
        String r128 = r125.getResUri();
        if (r128 != null) goto L165;
        String r212 = NameKeys.UnloadStrategy_No_Strategy;
    L166:
        r r35 = new r(r212, r125.getEntityType(), r125.getEntityId(), r125.getEntityPackageName(), r125.getIndex(), false);
    L187:
        if (r35 == null) goto L145;
        r122.add(r35);
        goto L145
    L165:
        r212 = r128;
        goto L166
    L153:
        if (StringsKt.isBlank(r126) == true) goto L156;
        r127 = false;
    L167:
        OSearchEntityVideo r129 = r124.getOEntityVideo();
        if (r129 == null) goto L186;
        String r130 = r129.getResUri();
        if (r130 != null) goto L172;
    L175:
        boolean r131 = true;
    L177:
        if ((!r131) == true) goto L180;
        r129 = null;
    L180:
        if (r129 == null) goto L186;
        String r132 = r129.getResUri();
        if (r132 != null) goto L184;
        String r133 = NameKeys.UnloadStrategy_No_Strategy;
    L185:
        r35 = new r(r133, r129.getEntityType(), r129.getEntityId(), r129.getEntityPackageName(), r129.getIndex(), true);
        goto L187
    L184:
        r133 = r132;
        goto L185
    L172:
        if (StringsKt.isBlank(r130) == true) goto L175;
        r131 = false;
    L186:
        r35 = null;
        goto L187
    L189:
        r r36 = (r) CollectionsKt.firstOrNull(r122);
        String r134 = u.a(r120);
        if (r36 == null) goto L192;
        String r135 = r36.b;
    L193:
        if (r36 == null) goto L195;
        String r213 = r36.c;
    L196:
        if (r36 == null) goto L198;
        String r214 = r36.d;
    L199:
        String r37 = r116.getIndex();
        if (r37 == null) goto L202;
        Integer r215 = StringsKt.toIntOrNull(r37);
    L203:
        ArrayList r38 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator r39 = r122.iterator();
    L205:
        if (r39.hasNext() == false) goto L207;
        r38.add(((r) r39.next()).a);
        goto L205
    L207:
        r31 = new s(r120, r134, r135, r213, r214, r215, r38, r122, null, 512);
        goto L209
    L202:
        r215 = null;
        goto L203
    L198:
        r214 = null;
        goto L199
    L195:
        r213 = null;
        goto L196
    L192:
        r135 = null;
        goto L193
    L137:
        r120 = null;
    L210:
        r114 = null;
        goto L211
    L233:
        if (r110 != null) goto L235;
        c0 r136 = null;
    L261:
        if (r136 != null) goto L271;
        int r40 = s3.a;
        s3.c("search_qa.collector", "skip parse failed messageId=" + this.$messageId);
        t r41 = this.this$0;
        LinkedHashSet r42 = r41.d;
        String r43 = this.$messageId;
        monitor-enter(r42);
        r41.d.remove(r43);     // Catch: Throwable -> L268
        monitor-exit(r42);
        return Unit.INSTANCE;
    L268:
        th = move-exception;
        throw th;
    L271:
        j r44 = this.this$0.a;
        List r45 = CollectionsKt.listOf(r136);
        r44.getClass();
        Intrinsics.checkNotNullParameter(r45, "records");
        if (r45.isEmpty() == true) goto L282;
        SQLiteDatabase r46 = r44.a.getWritableDatabase();
        r46.beginTransaction();
        Iterator r47 = r45.iterator();     // Catch: Throwable -> L283
    L277:
        if (r47.hasNext() == false) goto L279;
        r46.insertWithOnConflict("search_qa_data", null, k.a((c0) r47.next()), 5);     // Catch: Throwable -> L283
        goto L277
    L279:
        r46.setTransactionSuccessful();     // Catch: Throwable -> L283
        r46.endTransaction();
        int r48 = s3.a;
        s3.b("search_qa.database", "upsert count=" + r45.size() + ", ids=" + CollectionsKt.joinToString$default(r45, null, null, null, 0, null, new i(), 31, null));
        com.obric.assistant.cocreationreview.g r49 = j.b;
        StringBuilder r50 = new StringBuilder("search_qa_records_upsert:");
        r50.append(r45.size());
        r49.a(r50.toString());
    L283:
        th = move-exception;
        r46.endTransaction();
        throw th;
    L282:
        return Unit.INSTANCE;
    L235:
        Long r51 = Long.valueOf(r9.getCreateTime());
        if (r51.longValue() > 0) goto L239;
        r5 = false;
    L239:
        if (r5 == true) goto L242;
        r51 = null;
    L242:
        if (r51 == null) goto L244;
        long r52 = r51.longValue() * 1000;
    L245:
        String r53 = r9.getMessageId();
        if (r53 != null) goto L248;
        String r54 = NameKeys.UnloadStrategy_No_Strategy;
    L249:
        ModuleKey r137 = h.a.a;
        if (r19 == null) goto L252;
        String r55 = r19.summary;
    L253:
        if (r55 != null) goto L255;
        String r138 = NameKeys.UnloadStrategy_No_Strategy;
    L256:
        String r139 = r10.get("inner_log_id");
        String r56 = r9.getMessageId();
        if (r56 != null) goto L259;
        String r140 = NameKeys.UnloadStrategy_No_Strategy;
    L260:
        r136 = new c0(r54, r137, r52, NameKeys.UnloadStrategy_No_Strategy, r12, r138, r110, r111, r139, r140, 2048);
        goto L261
    L259:
        r140 = r56;
        goto L260
    L255:
        r138 = r55;
        goto L256
    L252:
        r55 = null;
        goto L253
    L248:
        r54 = r53;
        goto L249
    L244:
        r52 = System.currentTimeMillis();
        goto L245
    L108:
        r27 = null;
    L105:
        r110 = null;
        goto L106
    L90:
        r22 = false;
        goto L91
    L93:
        r21 = null;
    L83:
        r19 = null;
        goto L84
    L74:
        r16 = false;
        goto L75
    L77:
        r15 = null;
        goto L78
    L30:
        if (a.b0(r4) == false) goto L49;
        Iterator r57 = ((ArrayList) a.A(r4)).iterator();
    L33:
        if (r57.hasNext() == false) goto L40;
        Object r58 = r57.next();
        if (((Block) r58).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L37;
        boolean r59 = true;
    L38:
        if (r59 == false) goto L33;
    L41:
        Block r60 = (Block) r58;
        if (r60 == null) goto L48;
        BlockContent r61 = r60.getContent();
        if (r61 == null) goto L48;
        TextBlock r62 = r61.getTextBlock();
        if (r62 == null) goto L48;
        String r63 = r62.text;
    L50:
        if (r63 == null) goto L54;
        if ((!StringsKt.isBlank(r63)) == false) goto L54;
        r12 = r63;
    L48:
        r63 = null;
        goto L50
    L37:
        r59 = false;
        goto L38
    L40:
        r58 = null;
        goto L41
    L49:
        r63 = a.O(r4);
        goto L50
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r28);
        t r64 = this.this$0;
        Message r65 = this.$message;
        this.label = 1;
        r64.getClass();
        String r66 = r65.getReplyId();
        if (r66 != null) goto L11;
    L24:
        r3 = null;
    L25:
        if (r3 != r0) goto L27;
        return r0;
    L11:
        if ((!StringsKt.isBlank(r66)) == true) goto L13;
    L15:
        boolean r67 = false;
    L16:
        if (r67 == true) goto L19;
        r66 = null;
    L19:
        if (r66 == null) goto L24;
        IChatRepoService r68 = (IChatRepoService) ServiceManager.get().getService(IChatRepoService.class);
        if (r68 == null) goto L24;
        r3 = r68.E1(r66, this);
        goto L25
    L13:
        if (Intrinsics.areEqual(r66, "0") == true) goto L15;
        r67 = true;
        goto L16
    }
}
