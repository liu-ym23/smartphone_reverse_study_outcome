package com.obric.assistant.omni;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.OTitleCardProcessBlock;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.observer.MessageListState;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;
    public static final Lazy b = null;
    public static volatile boolean c;
    public static final OmniTaskMessageLifecycleTrace$lruMap$1 d = null;
    public static final OmniTaskMessageLifecycleTrace$lruMap$1 e = null;
    public static final OmniTaskMessageLifecycleTrace$lruMap$1 f = null;
    public static final OmniTaskMessageLifecycleTrace$lruMap$1 g = null;
    public static final C0011b h = null;

    public static final class a {
        public final long a;
        public long b;
        public long c;
        public String d;
        public long e;
        public String f;
        public String g;
        public long h;
        public String i;
        public String j;
        public String k;
        public String l;
        public boolean m;
        public boolean n;

        public a(long r3) {
            Intrinsics.checkNotNullParameter("", "firstStageStepDesc");
            Intrinsics.checkNotNullParameter("", "secondStageStepDesc");
            Intrinsics.checkNotNullParameter("", "secondStageTitle");
            Intrinsics.checkNotNullParameter("", "thirdStageStepDesc");
            Intrinsics.checkNotNullParameter("", "thirdStageTitle");
            Intrinsics.checkNotNullParameter("", "innerLogId");
            Intrinsics.checkNotNullParameter("", "omniTaskId");
            this.a = r3;
            this.b = 0;
            this.c = 0;
            this.d = "";
            this.e = 0;
            this.f = "";
            this.g = "";
            this.h = 0;
            this.i = "";
            this.j = "";
            this.k = "";
            this.l = "";
            this.m = false;
            this.n = false;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.omni.b$b, reason: collision with other inner class name */
    public static final class C0011b implements nf9.b {
        public C0011b() {
        }

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
            b r5 = b.a;
            if (b.c() == true) goto L6;
            return;
        L6:
            if (r3 != MessageListState.UPDATE) goto L11;
            Iterator<T> r6 = r4.iterator();
        L9:
            if (r6.hasNext() == false) goto L13;
            b.a((Message) r6.next());
            goto L9
        L13:
            return;
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            b.a(r2);
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            b.a(r2);
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = LazyKt.lazy(new com.obric.assistant.omni.a());
        d = new OmniTaskMessageLifecycleTrace$lruMap$1(30);
        e = new OmniTaskMessageLifecycleTrace$lruMap$1(30);
        f = new OmniTaskMessageLifecycleTrace$lruMap$1(30);
        g = new OmniTaskMessageLifecycleTrace$lruMap$1(20);
        h = new C0011b();
    }

    public static boolean c() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static final void a(Message r2) {
        b r0 = a;
        if (c() == false) goto L17;
        monitor-enter(r0);     // Catch: Exception -> L13
        d(r2);     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Exception -> L13
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Exception -> L13
    L18:
        return;
    }

    public static void b(String r2) {
        if (AppHost.a.isDebug() == false) goto L6;
        FLogger.a.d("ComplexTaskTrace", r2);
        return;
    }

    public static void d(Message r17) {
        String r1 = "";
        if (r17.getUserType() == 2) goto L6;
    L37:
        boolean r0 = false;
    L38:
        if (r0 == true) goto L40;
        return;
    L40:
        Map r2 = r17.getExt();
        if (r2 != null) goto L43;
        return;
    L43:
        String r5 = (String) r2.get("o_reference_msg_id");
        if (r5 != null) goto L46;
        return;
    L46:
        if ((!StringsKt.isBlank(r5)) == true) goto L49;
        r5 = null;
    L49:
        if (r5 == null) goto L222;
        OmniTaskMessageLifecycleTrace$lruMap$1 r6 = g;
        Object r7 = r6.get(r5);
        Object r8 = r7;
        if (r7 != null) goto L61;
        Long r9 = (Long) d.get(r5);
        if (r9 == null) goto L60;
        a r10 = new a(r9.longValue());
        Long r11 = (Long) f.get(r5);
        if (r11 == null) goto L58;
        long r12 = r11.longValue();
    L59:
        r10.b = r12;
        r6.put(r5, r10);
        r8 = r10;
        goto L61
    L58:
        r12 = 0;
        goto L59
    L60:
        return;
    L61:
        a r13 = (a) r8;
        if (r13.n == false) goto L64;
        return;
    L64:
        String r14 = (String) r2.get("inner_log_id");
        if (r14 != null) goto L67;
    L72:
        String r15 = (String) r2.get("o_omni_task_id");
        if (r15 != null) goto L75;
    L80:
        String r16 = (String) r2.get("o_task_state");
        if (r16 == null) goto L91;
        if ((!StringsKt.isBlank(r16)) == true) goto L86;
        r16 = null;
    L86:
        if (r16 == null) goto L91;
        if (Intrinsics.areEqual(r16, "queue_complex_task") == false) goto L91;
        r13.m = true;
    L91:
        if (r13.b != 0) goto L95;
        Long r18 = (Long) f.get(r5);
        if (r18 == null) goto L95;
        r13.b = r18.longValue();
    L95:
        long r19 = System.currentTimeMillis();
        String r20 = (String) r2.get("o_task_current_step_description");
        if (r20 != null) goto L98;
        r20 = "";
    L98:
        Intrinsics.checkNotNullParameter(r17, "<this>");
        List r110 = r.a(r17);
        if (r13.c != 0) goto L132;
        List r3 = r110;
        if ((r3 instanceof Collection) == true) goto L103;
    L105:
        Iterator r4 = r3.iterator();
    L107:
        if (r4.hasNext() == false) goto L128;
        Block r21 = (Block) r4.next();
        if (r21.getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L124;
        BlockContent r22 = r21.getContent();
        if (r22 == null) goto L115;
        TextBlock r23 = r22.getTextBlock();
        if (r23 == null) goto L115;
        String r24 = r23.text;
    L116:
        if (r24 != null) goto L118;
    L121:
        boolean r25 = true;
    L122:
        if (r25 == true) goto L124;
        boolean r26 = true;
    L125:
        if (r26 == false) goto L107;
        boolean r27 = true;
    L129:
        if (r27 == false) goto L132;
        r13.c = r19;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r13.d = r20;
        b("stage1_first_text cost=" + (r19 - r13.a) + "ms step_desc=" + r20 + " queue=" + r13.m);
        goto L132
    L118:
        if (StringsKt.isBlank(r24) == true) goto L121;
        r25 = false;
    L115:
        r24 = null;
    L124:
        r26 = false;
    L128:
        r27 = false;
        goto L129
    L103:
        if (r3.isEmpty() == false) goto L105;
    L132:
        if (r13.e != 0) goto L155;
        Iterator r28 = r110.iterator();
    L135:
        if (r28.hasNext() == false) goto L142;
        Object r29 = r28.next();
        if (((Block) r29).getBlockType() != BlockType.BLOCK_TYPE_O_OMNI_TITLE_CARD_PROCESS.getValue()) goto L139;
        boolean r30 = true;
    L140:
        if (r30 == false) goto L135;
    L143:
        Block r31 = (Block) r29;
        if (r31 == null) goto L155;
        r13.e = r19;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r13.f = r20;
        BlockContent r32 = r31.getContent();
        if (r32 == null) goto L150;
        OTitleCardProcessBlock r33 = r32.getOTitleCardProcessBlock();
        if (r33 == null) goto L150;
        String r34 = r33.title;
    L151:
        if (r34 != null) goto L153;
        r34 = "";
    L153:
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        r13.g = r34;
        b("stage2_first_card cost=" + (r19 - r13.a) + "ms title=" + r13.g);
    L150:
        r34 = null;
        goto L151
    L139:
        r30 = false;
        goto L140
    L142:
        r29 = null;
    L155:
        if (r13.h == 0) goto L157;
    L183:
        String r35 = (String) r2.get("o_task_state");
        if (r35 == null) goto L188;
        r1 = r35;
    L188:
        if (r13.h <= 0) goto L190;
    L191:
        r13.n = true;
        long r36 = r13.b;
        long r37 = -1;
        if (r36 <= 0) goto L194;
        long r38 = r36 - r13.a;
    L195:
        long r39 = r13.c;
        if (r39 <= 0) goto L198;
        long r40 = r39 - r13.a;
    L199:
        long r111 = r13.e;
        if (r111 <= 0) goto L202;
        long r112 = r111 - r13.a;
    L203:
        long r113 = r13.h;
        if (r113 <= 0) goto L206;
        r37 = r113 - r13.a;
    L206:
        JSONObject r41 = new JSONObject();
        r41.put("send_cost_ms", r38);
        r41.put("first_stage_cost_ms", r40);
        r41.put("second_stage_cost_ms", r112);
        r41.put("third_stage_cost_ms", r37);
        r41.put("send_start_ts", r13.a);
        r41.put("send_ack_ts", r13.b);
        r41.put("first_stage_ts", r13.c);
        r41.put("second_stage_ts", r13.e);
        r41.put("third_stage_ts", r13.h);
        r41.put("first_stage_step_desc", r13.d);
        r41.put("second_stage_step_desc", r13.f);
        r41.put("second_stage_title", r13.g);
        r41.put("third_stage_step_desc", r13.i);
        r41.put("third_stage_title", r13.j);
        r41.put("inner_log_id", r13.k);
        r41.put("omni_task_id", r13.l);
        r41.put("enter_queue", r13.m);
        o.a.reportEvent("omni_task_start_lifecycle", r41);
        b("report: " + r41);
        return;
    L202:
        r112 = -1;
        goto L203
    L198:
        r40 = -1;
        goto L199
    L194:
        r38 = -1;
        goto L195
    L190:
        if (Intrinsics.areEqual(r1, "complete") == true) goto L191;
        return;
    L157:
        if ((!StringsKt.isBlank(r13.g)) == false) goto L183;
        Iterator r42 = r110.iterator();
    L160:
        if (r42.hasNext() == false) goto L167;
        Object r43 = r42.next();
        if (((Block) r43).getBlockType() != BlockType.BLOCK_TYPE_O_OMNI_TITLE_CARD_PROCESS.getValue()) goto L164;
        boolean r44 = true;
    L165:
        if (r44 == false) goto L160;
    L168:
        Block r45 = (Block) r43;
        if (r45 == null) goto L175;
        BlockContent r46 = r45.getContent();
        if (r46 == null) goto L175;
        OTitleCardProcessBlock r47 = r46.getOTitleCardProcessBlock();
        if (r47 == null) goto L175;
        String r48 = r47.title;
    L176:
        if (r48 != null) goto L179;
        r48 = "";
    L179:
        if ((!StringsKt.isBlank(r48)) == false) goto L183;
        if (Intrinsics.areEqual(r48, r13.g) == true) goto L183;
        r13.h = r19;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r13.i = r20;
        Intrinsics.checkNotNullParameter(r48, "<set-?>");
        r13.j = r48;
        b("stage3_title_changed cost=" + (r19 - r13.a) + "ms new_title=" + r48);
    L175:
        r48 = null;
        goto L176
    L164:
        r44 = false;
        goto L165
    L167:
        r43 = null;
        goto L168
    L75:
        if ((!StringsKt.isBlank(r15)) == true) goto L78;
        r15 = null;
    L78:
        if (r15 == null) goto L80;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r13.l = r15;
        goto L80
    L67:
        if ((!StringsKt.isBlank(r14)) == true) goto L70;
        r14 = null;
    L70:
        if (r14 == null) goto L72;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.k = r14;
        goto L72
    L222:
        return;
    L6:
        if (r17.getContentType() != 9999) goto L37;
        MessageStatus r49 = r17.getMessageStatus();
        if (r49 == null) goto L37;
        if (r49 != MessageStatus.MessageStatus_AVAILABLE) goto L14;
    L16:
        Map r50 = r17.getExt();
        if (r50 == null) goto L19;
        String r51 = (String) r50.get("client_meta");
    L20:
        if (r51 != null) goto L23;
        r51 = "";
    L23:
        if (StringsKt.contains$default(r51, "\"isSilent\":1", false, 2, null) == true) goto L37;
        if (StringsKt.contains$default(r51, "\"isSilent\": 1", false, 2, null) == true) goto L37;
        Map r52 = r17.getExt();
        if (r52 != null) goto L31;
        r52 = MapsKt.emptyMap();
    L31:
        if (Intrinsics.areEqual(r52.get("o_task_type"), "complex_task") == false) goto L33;
    L36:
        r0 = true;
        goto L38
    L33:
        if (Intrinsics.areEqual(r52.get("is_complex_task"), "true") == true) goto L36;
        if (Intrinsics.areEqual(r52.get("is_complex_task"), "1") == false) goto L37;
    L19:
        r51 = null;
        goto L20
    L14:
        if (r49 == MessageStatus.MessageStatus_UNSELECTED) goto L16;
        goto L16
    }
}
