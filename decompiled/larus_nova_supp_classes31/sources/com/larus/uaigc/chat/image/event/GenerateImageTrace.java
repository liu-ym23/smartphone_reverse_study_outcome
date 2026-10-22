package com.larus.uaigc.chat.image.event;

import android.util.LruCache;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import dp8.e;
import ic8.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class GenerateImageTrace implements ky9.a {
    public static final GenerateImageTrace a = null;
    public static final LruCache<String, String> b = null;
    public static final LruCache<String, Long> c = null;
    public static final Set<String> d = null;
    public static final LruCache<String, String> e = null;
    public static final LruCache<String, String> f = null;
    public static final Lazy g = null;

    public static final class a implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ by7.a a;
        public final /* synthetic */ Message b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ Ref.IntRef d;
        public final /* synthetic */ long e;
        public final /* synthetic */ Message f;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r9) {
            Intrinsics.checkNotNullParameter(r9, "error");
            Intrinsics.checkNotNullParameter(r9, "error");
            by7.a r10 = this.a;
            Message r0 = this.b;
            Ref.IntRef r1 = this.c;
            Ref.IntRef r2 = this.d;
            long r3 = this.e;
            Message r5 = this.f;
            r10.d("message_id", r0.getMessageId());
            r10.d("success_cnt", Integer.valueOf(r1.element));
            r10.d("total_cnt", Integer.valueOf(r2.element));
            r10.d("duration", Long.valueOf(System.currentTimeMillis() - r3));
            if (r1.element <= 0) goto L5;
            int r4 = 1;
        L6:
            r10.d("success", Integer.valueOf(r4));
            r10.d("with_image", 0);
            String r6 = GenerateImageTrace.e.get(r5.getLocalMessageId());
            if (r6 == null) goto L9;
            r10.d("create_way", r6);
        L9:
            this.a.b();
            return;
        L5:
            r4 = 0;
            goto L6
        }

        public final void onSuccess(Object r12) {
            List r13 = (List) r12;
            Intrinsics.checkNotNullParameter(r13, "result");
            Iterator r14 = r13.iterator();
        L3:
            int r1 = 1;
            if (r14.hasNext() == false) goto L11;
            Object r0 = r14.next();
            if (((Message) r0).getContentType() != 6) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L3;
        L12:
            if (r0 == null) goto L14;
            int r15 = 1;
        L15:
            by7.a r2 = this.a;
            Message r4 = this.b;
            Ref.IntRef r5 = this.c;
            Ref.IntRef r6 = this.d;
            long r7 = this.e;
            Message r8 = this.f;
            r2.d("message_id", r4.getMessageId());
            r2.d("success_cnt", Integer.valueOf(r5.element));
            r2.d("total_cnt", Integer.valueOf(r6.element));
            r2.d("duration", Long.valueOf(System.currentTimeMillis() - r7));
            if (r5.element > 0) goto L19;
            r1 = 0;
        L19:
            r2.d("success", Integer.valueOf(r1));
            r2.d("with_image", Integer.valueOf(r15));
            String r16 = GenerateImageTrace.e.get(r8.getLocalMessageId());
            if (r16 == null) goto L22;
            r2.d("create_way", r16);
        L22:
            this.a.b();
            return;
        L14:
            r15 = 0;
            goto L15
        L8:
            r3 = false;
            goto L9
        L11:
            r0 = null;
            goto L12
        }

        public a(by7.a r1, Message r2, Ref.IntRef r3, Ref.IntRef r4, long r5, Message r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/larus/uaigc/chat/image/event/GenerateImageTrace$onAddOrUpdateMessage$whiteTeeIndexList$1$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class b extends TypeToken<ArrayList<Integer>> {
        public b() {
        }
    }

    public GenerateImageTrace() {
    }

    static {
        a = new GenerateImageTrace();
        b = new LruCache(20);
        c = new LruCache(20);
        d = Collections.synchronizedSet(new HashSet());
        e = new LruCache(20);
        f = new LruCache(20);
        g = LazyKt.lazy(new com.larus.uaigc.chat.image.event.a());
    }

    @Override // ky9.a
    public final boolean b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Set<String> r0 = d;
        String r3 = r2.getLocalMessageId();
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        return r0.contains(r3);
    }

    @Override // ky9.a
    public final void a(String r5, Message r6) {
        Intrinsics.checkNotNullParameter(r5, "cid");
        Intrinsics.checkNotNullParameter(r6, "msg");
        c.put(r6.getLocalMessageId(), Long.valueOf(System.currentTimeMillis()));
        LruCache<String, String> r7 = e;
        String r0 = r6.getLocalMessageId();
        String r1 = b.get(r6.getLocalMessageId());
        String r2 = "";
        if (r1 != null) goto L8;
        IAIChatControlTraceService.Companion r3 = IAIChatControlTraceService.a;
        String r4 = r6.getLocalMessageId();
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r1 = r3.Ia(r4);
    L8:
        r7.put(r0, r1);
        LruCache<String, String> r8 = f;
        String r9 = r6.getLocalMessageId();
        Map r10 = r6.getExt();
        if (r10 == null) goto L14;
        String r11 = (String) r10.get("sec_scene");
        if (r11 == null) goto L14;
        r2 = r11;
    L14:
        r8.put(r9, r2);
    }

    @Override // ky9.a
    public final void e(Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        String r4 = b.put(r2.getLocalMessageId(), r3);
    }

    @Override // ky9.a
    public final void c(String r4, boolean r5, Message r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        if (r4 != null) goto L5;
        return;
    L5:
        c.put(r6.getLocalMessageId(), Long.valueOf(System.currentTimeMillis()));
        e.put(r6.getLocalMessageId(), "regenerate");
        if (r5 == true) goto L9;
        f.put(r6.getLocalMessageId(), "");
        return;
    }

    @Override // ky9.a
    public final void d(String r18, Message r19, Message r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r18, "cid");
        Intrinsics.checkNotNullParameter(r19, "msg");
        if (b(r19) == false) goto L6;
        FLogger.a.i("GenerateImageTrace", "return because eventReportHistory contains this msg");
        return;
    L6:
        if (r20 != null) goto L8;
        return;
    L8:
        if (r20.getLocalMessageId() == null) goto L446;
        Long r3 = c.get(r20.getLocalMessageId());
        if (r3 == null) goto L442;
        long r5 = r3.longValue();
        Ref.IntRef r7 = new Ref.IntRef();
        Ref.IntRef r4 = new Ref.IntRef();
        if (d.k(r19) == false) goto L43;
        List r10 = com.larus.im.bean.message.a.l(r19);
        ArrayList r15 = new ArrayList();
        Iterator r11 = ((ArrayList) r10).iterator();
    L16:
        if (r11.hasNext() == false) goto L26;
        Object r12 = r11.next();
        Integer r13 = ((CreationItem) r12).type;
        if (r13 != null) goto L21;
    L23:
        boolean r14 = false;
    L24:
        if (r14 == false) goto L16;
        r15.add(r12);
        goto L16
    L21:
        if (r13.intValue() != 1) goto L23;
        r14 = true;
        goto L24
    L26:
        r7.element = r15.size();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L28:
        if (r17.hasNext() == false) goto L41;
        Object r110 = r17.next();
        ImageData r111 = ((CreationItem) r110).image;
        if (r111 == null) goto L37;
        Integer r112 = r111.status;
        if (r112 == null) goto L37;
        if (r112.intValue() != 2) goto L37;
        boolean r113 = true;
    L38:
        if (r113 == false) goto L28;
        r16.add(r110);
    L37:
        r113 = false;
        goto L38
    L41:
        r4.element = r16.size();
        ArrayList r114 = null;
    L121:
        if (r7.element <= 0) goto L123;
    L126:
        boolean r115 = true;
    L127:
        if (r115 == true) goto L129;
        return;
    L129:
        if (r19.getMessageStatus() == MessageStatus.MessageStatus_AVAILABLE) goto L131;
        return;
    L131:
        if (r19.getMessageStatusLocal() != 21) goto L445;
        Set<String> r116 = d;
        String r117 = r19.getLocalMessageId();
        String r118 = "";
        if (r117 != null) goto L136;
        r117 = "";
    L136:
        if (r116.add(r117) == true) goto L138;
        return;
    L138:
        FLogger.a.i("GenerateImageTrace", "create_picture_result onReceiveMessage image " + r18);
        Gson r0 = (Gson) g.getValue();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L145
        Map r8 = r20.getExt();     // Catch: Throwable -> L145
        if (r8 == null) goto L142;
        String r9 = (String) r8.get("white_tee_index_list");     // Catch: Throwable -> L145
    L143:
        Object r1 = Result.constructor-impl((ArrayList) r0.fromJson(r9, new b().getType()));     // Catch: Throwable -> L145
    L148:
        if (Result.exceptionOrNull-impl(r1) == null) goto L151;
        r1 = new ArrayList();
    L151:
        ArrayList r2 = (ArrayList) r1;
        if (r2 != null) goto L154;
        r2 = new ArrayList();
    L154:
        by7.a r23 = new by7.a("create_picture_result");
        if (r22 != null) goto L157;
        String r119 = "";
    L158:
        r23.d("bot_id", r119);
        r23.d("create_way", "chat_action_bar");
        String r120 = f.get(r20.getLocalMessageId());
        if (r120 == null) goto L161;
        r23.d("sec_scene", r120);
    L161:
        String r121 = e.get(r20.getLocalMessageId());
        if (r121 == null) goto L164;
        r23.d("create_way", r121);
    L164:
        if (r21 == null) goto L167;
        r23.d("chat_type", r21);
    L167:
        if (Intrinsics.areEqual(ap8.a.b(r19), "avatar_image") == false) goto L169;
    L198:
        r23.d("is_replica_gen", 1);
    L200:
        if (Intrinsics.areEqual(ap8.a.b(r19), "ai_beautify_image") == false) goto L202;
    L231:
        int r122 = 1;
    L232:
        r23.d("is_image_edit", Integer.valueOf(r122));
        String r123 = r19.getReplyId();
        if (r123 == null) goto L236;
        Message r124 = (Message) IAIChatControlTraceService.a.mb().get(r123);
        if (r124 == null) goto L236;
    L237:
        Map r125 = r124.getExt();
        if (r125 == null) goto L242;
        Boolean r126 = j.j(r125);
        if (r126 == null) goto L242;
        Integer r127 = Integer.valueOf(r126.booleanValue() ? 1 : 0);
    L243:
        r23.d("is_manual_input", r127);
        if (r122 == 0) goto L254;
        Map r128 = r124.getExt();
        if (r128 == null) goto L254;
        p1 r129 = j.e(r128);
        if (r129 == null) goto L254;
        Integer r130 = r129.a;
        if (r130 == null) goto L252;
        String r131 = r130.toString();
    L253:
        r23.d("image_edit_function_id", r131);
        goto L254
    L252:
        r131 = null;
    L254:
        IAIChatControlTraceService.Companion r132 = IAIChatControlTraceService.a;
        androidx.collection.LruCache<String, String> r133 = r132.kb();
        String r134 = r20.getLocalMessageId();
        if (r134 != null) goto L257;
        r134 = "";
    L257:
        r23.d("enter_method", r133.get(r134));
        Map r135 = r124.getExt();
        if (r135 == null) goto L260;
        String r136 = (String) r135.get("outer_link_source");
    L261:
        r23.d("outer_link_source", r136);
        Map r137 = r19.getExt();
        if (r137 == null) goto L264;
        String r138 = (String) r137.get("need_deep_think");
    L265:
        String r139 = "1";
        if (Intrinsics.areEqual(r138, "1") == false) goto L268;
        Object r140 = "1";
    L269:
        r23.d("is_deep_thinking_switch_on", r140);
        if (com.larus.im.bean.message.a.C0(r19) == true) goto L273;
        r139 = "0";
    L273:
        r23.d("is_deep_thinking", r139);
        if (d.n0(r19) == false) goto L277;
    L316:
        String r24 = "pic";
    L313:
        String r141 = r24;
    L317:
        r23.d("message_type", r141);
        r23.d("ai_create_show_mode", tz9.a.a(r19));
        androidx.collection.LruCache<String, Map<String, String>> r25 = r132.dc();
        String r142 = r20.getLocalMessageId();
        if (r142 != null) goto L320;
        r142 = "";
    L320:
        Map r26 = (Map) r25.get(r142);
        if (r26 == null) goto L325;
        String r27 = (String) r26.get("ai_generate_tab_id");
        if (r27 == null) goto L325;
        r23.d("ai_generate_tab_id", r27);
    L325:
        androidx.collection.LruCache<String, Map<String, String>> r28 = r132.dc();
        String r143 = r20.getLocalMessageId();
        if (r143 != null) goto L328;
        r143 = "";
    L328:
        Map r29 = (Map) r28.get(r143);
        if (r29 == null) goto L333;
        String r30 = (String) r29.get("ai_generate_tab_name");
        if (r30 == null) goto L333;
        r23.d("ai_generate_tab_name", r30);
    L333:
        androidx.collection.LruCache<String, Map<String, String>> r31 = r132.dc();
        String r144 = r20.getLocalMessageId();
        if (r144 != null) goto L336;
        r144 = "";
    L336:
        Map r32 = (Map) r31.get(r144);
        if (r32 == null) goto L341;
        String r33 = (String) r32.get("ai_generate_tab_type");
        if (r33 == null) goto L341;
        r23.d("ai_generate_tab_type", r33);
    L341:
        androidx.collection.LruCache<String, Map<String, String>> r34 = r132.dc();
        String r145 = r20.getLocalMessageId();
        if (r145 != null) goto L344;
        r145 = "";
    L344:
        Map r35 = (Map) r34.get(r145);
        if (r35 == null) goto L349;
        String r36 = (String) r35.get("ai_creation_recommend_from");
        if (r36 == null) goto L349;
        r23.d("ai_creation_recommend_from", r36);
    L349:
        androidx.collection.LruCache<String, Map<String, String>> r37 = r132.dc();
        String r146 = r20.getLocalMessageId();
        if (r146 != null) goto L352;
        r146 = "";
    L352:
        Map r38 = (Map) r37.get(r146);
        if (r38 == null) goto L357;
        String r39 = (String) r38.get("is_from_template");
        if (r39 == null) goto L357;
        r23.d("is_from_template", r39);
    L358:
        androidx.collection.LruCache<String, Map<String, String>> r40 = r132.dc();
        String r147 = r20.getLocalMessageId();
        if (r147 != null) goto L361;
        r147 = "";
    L361:
        Map r41 = (Map) r40.get(r147);
        if (r41 == null) goto L366;
        String r42 = (String) r41.get("from_template_id");
        if (r42 == null) goto L366;
        r23.d("from_template_id", r42);
    L366:
        androidx.collection.LruCache<String, Map<String, String>> r43 = r132.dc();
        String r148 = r20.getLocalMessageId();
        if (r148 != null) goto L369;
        r148 = "";
    L369:
        Map r44 = (Map) r43.get(r148);
        if (r44 == null) goto L374;
        String r45 = (String) r44.get("from_template_type");
        if (r45 == null) goto L374;
        r23.d("from_template_type", r45);
    L374:
        androidx.collection.LruCache<String, Map<String, String>> r46 = r132.dc();
        String r149 = r20.getLocalMessageId();
        if (r149 != null) goto L377;
        r149 = "";
    L377:
        Map r47 = (Map) r46.get(r149);
        if (r47 == null) goto L382;
        String r48 = (String) r47.get("from_template_sub_type");
        if (r48 == null) goto L382;
        r23.d("from_template_sub_type", r48);
    L382:
        Intrinsics.checkNotNullParameter(r20, "<this>");
        ArrayList r49 = (ArrayList) com.larus.im.bean.message.a.l(r20);
        if (r49.isEmpty() == true) goto L400;
        Iterator r50 = r49.iterator();
    L387:
        if (r50.hasNext() == false) goto L400;
        CreationGenDetail r150 = ((CreationItem) r50.next()).genDetail;
        if (r150 == null) goto L397;
        Integer r151 = r150.taskType;
        if (r151 == null) goto L397;
        if (r151.intValue() != 5) goto L397;
        boolean r152 = true;
    L398:
        if (r152 == false) goto L387;
        boolean r153 = true;
    L401:
        r23.d("is_replica_gen", Boolean.valueOf(r153));
        r23.d("replica_cnt", Integer.valueOf(r2.size()));
        if (o0.d(com.larus.im.bean.message.a.g(r19)) == false) goto L410;
        String r154 = com.larus.im.bean.message.a.g(r19);
        if (r154 == null) goto L411;
        NativeMessageServiceImpl r155 = com.larus.im.d.e();
        String r51 = r19.getConversationId();
        if (r51 == null) goto L409;
        r118 = r51;
    L409:
        r155.p(r118, r154, new a(r23, r19, r4, r7, r5, r20));
        Unit r52 = Unit.INSTANCE;
    L411:
        c.remove(r20.getLocalMessageId());
        return;
    L410:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new GenerateImageTrace$onAddOrUpdateMessage$8(r19, r23, r4, r7, r5, null), 2, null);
    L397:
        r152 = false;
    L400:
        r153 = false;
    L357:
        r23.d("is_from_template", "0");
        goto L358
    L277:
        if (d.a0(r19) == false) goto L290;
        CreationMsgContentData r53 = e.c(r19);
        if (r53 == null) goto L283;
        CreationInfo r54 = r53.creationInfo;
        if (r54 == null) goto L283;
        Integer r156 = r54.layoutType;
    L284:
        if (r156 == null) goto L316;
        if (r156.intValue() != 1) goto L316;
        r141 = "pic_and_text";
    L283:
        r156 = null;
        goto L284
    L290:
        if ((!com.larus.im.bean.message.a.k(r19).isEmpty()) == false) goto L316;
        Block r55 = (Block) CollectionsKt.firstOrNull(com.larus.im.bean.message.a.k(r19));
        if (r55 == null) goto L315;
        BlockContent r56 = r55.getContent();
        if (r56 == null) goto L302;
        CreationBlock r57 = r56.getCreationBlock();
        if (r57 == null) goto L302;
        List r58 = r57.creations;
        if (r58 == null) goto L302;
        CreationItem r59 = (CreationItem) CollectionsKt.firstOrNull(r58);
        if (r59 == null) goto L302;
        Integer r157 = r59.type;
    L303:
        if (r157 != null) goto L306;
    L308:
        if (r157 != null) goto L311;
    L314:
        r141 = "";
        goto L317
    L311:
        if (r157.intValue() != 2) goto L314;
        r24 = "video_and_text";
        goto L313
    L306:
        if (r157.intValue() != 1) goto L308;
        r141 = "pic_and_text";
    L302:
        r157 = null;
        goto L303
    L315:
        r141 = null;
        goto L317
    L268:
        r140 = "0";
        goto L269
    L264:
        r138 = null;
        goto L265
    L260:
        r136 = null;
    L242:
        r127 = null;
    L236:
        r124 = r20;
        goto L237
    L202:
        if (d.k(r19) == false) goto L217;
        if (r15 == null) goto L214;
        CreationItem r158 = (CreationItem) CollectionsKt.firstOrNull(r15);
        if (r158 == null) goto L214;
        CreationGenDetail r159 = r158.genDetail;
        if (r159 == null) goto L214;
        Integer r160 = r159.taskType;
        if (r160 == null) goto L214;
        if (r160.intValue() != 7) goto L214;
        boolean r161 = true;
    L215:
        if (r161 == true) goto L231;
    L214:
        r161 = false;
    L217:
        if (d.a0(r19) == false) goto L230;
        if (r114 == null) goto L227;
        CreationTask r162 = (CreationTask) CollectionsKt.firstOrNull(r114);
        if (r162 == null) goto L227;
        Integer r163 = r162.taskType;
        if (r163 == null) goto L227;
        if (r163.intValue() != 7) goto L227;
        boolean r164 = true;
    L228:
        if (r164 == false) goto L230;
    L227:
        r164 = false;
    L230:
        r122 = 0;
        goto L232
    L169:
        if (d.k(r19) == false) goto L184;
        if (r15 == null) goto L181;
        CreationItem r60 = (CreationItem) CollectionsKt.firstOrNull(r15);
        if (r60 == null) goto L181;
        CreationGenDetail r61 = r60.genDetail;
        if (r61 == null) goto L181;
        Integer r62 = r61.taskType;
        if (r62 == null) goto L181;
        if (r62.intValue() != 5) goto L181;
        boolean r63 = true;
    L182:
        if (r63 == true) goto L198;
    L181:
        r63 = false;
    L184:
        if (d.a0(r19) == false) goto L197;
        if (r114 == null) goto L194;
        CreationTask r64 = (CreationTask) CollectionsKt.firstOrNull(r114);
        if (r64 == null) goto L194;
        Integer r65 = r64.taskType;
        if (r65 == null) goto L194;
        if (r65.intValue() != 5) goto L194;
        boolean r66 = true;
    L195:
        if (r66 == false) goto L197;
    L194:
        r66 = false;
    L197:
        r23.d("is_replica_gen", 0);
        goto L200
    L157:
        r119 = r22;
        goto L158
    L142:
        r9 = null;
    L145:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L148
    L445:
        return;
    L123:
        if (r19.getContentType() == 6) goto L126;
        r115 = false;
        goto L127
    L43:
        if (d.a0(r19) == false) goto L99;
        CreationMsgContentData r165 = e.c(r19);
        if (r165 == null) goto L75;
        CreationInfo r166 = r165.creationInfo;
        if (r166 == null) goto L75;
        Map r167 = r166.taskInfo;
        if (r167 == null) goto L75;
        Collection r168 = r167.values();
        if (r168 == null) goto L75;
        r114 = new ArrayList();
        Iterator r169 = r168.iterator();
    L54:
        if (r169.hasNext() == false) goto L76;
        Object r170 = r169.next();
        CreationTask r171 = (CreationTask) r170;
        if (r171 == null) goto L63;
        Integer r172 = r171.loadingAssetType;
        if (r172 == null) goto L63;
        if (r172.intValue() != 5) goto L63;
        boolean r173 = true;
    L64:
        if (r173 == true) goto L71;
        if (r171 == null) goto L67;
        Integer r174 = r171.loadingAssetType;
    L68:
        if (r174 == null) goto L71;
        boolean r175 = false;
    L72:
        if (r175 == false) goto L54;
        r114.add(r170);
        goto L54
    L67:
        r174 = null;
    L71:
        r175 = true;
    L63:
        r173 = false;
    L76:
        if (r114 == null) goto L78;
        int r176 = r114.size();
    L79:
        r7.element = r176;
        if (r114 == null) goto L96;
        ArrayList r177 = new ArrayList();
        Iterator r178 = r114.iterator();
    L83:
        if (r178.hasNext() == false) goto L95;
        Object r179 = r178.next();
        CreationTask r180 = (CreationTask) r179;
        if (r180 == null) goto L92;
        Integer r181 = r180.status;
        if (r181 == null) goto L92;
        if (r181.intValue() != 4) goto L92;
        boolean r182 = true;
    L93:
        if (r182 == false) goto L83;
        r177.add(r179);
    L92:
        r182 = false;
        goto L93
    L95:
        int r183 = r177.size();
    L97:
        r4.element = r183;
    L119:
        r15 = null;
        goto L121
    L96:
        r183 = 0;
        goto L97
    L78:
        r176 = 0;
    L75:
        r114 = null;
        goto L76
    L99:
        if (r19.getContentType() != 6) goto L118;
        ImageContentData r184 = IAIChatUgcAIGCService.a.d0(r19);
        if (r184 == null) goto L103;
        List r185 = r184.getImageList();
    L104:
        if (r185 == null) goto L106;
        int r186 = r185.size();
    L107:
        r7.element = r186;
        if (r185 == null) goto L116;
        ArrayList r187 = new ArrayList();
        Iterator r188 = r185.iterator();
    L111:
        if (r188.hasNext() == false) goto L115;
        Object r189 = r188.next();
        if (df8.b.c((ImageItem) r189) == false) goto L111;
        r187.add(r189);
        goto L111
    L115:
        int r190 = r187.size();
    L117:
        r4.element = r190;
        goto L118
    L116:
        r190 = 0;
        goto L117
    L106:
        r186 = 0;
        goto L107
    L103:
        r185 = null;
    L118:
        r114 = null;
        goto L119
    L442:
        return;
    }
}
