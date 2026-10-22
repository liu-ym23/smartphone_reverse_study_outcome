package com.larus.ugc.perf.impl.genimg;

import com.ixigua.lib.track.TrackParams;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.DurationInfo;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ugc.perf.impl.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b extends OldUgcGenImgPerfMonitor {
    public static final b d = null;
    public static boolean e;

    static {
        d = new b();
    }

    public b() {
    }

    public static Map n(List r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        DurationInfo r1 = (DurationInfo) r4.next();
        String r2 = r1.stepName;
        Long r5 = r1.duration;
        if (r2 == null) goto L9;
        if (r5 == null) goto L9;
        Pair r6 = TuplesKt.to(r2, r5);
    L10:
        if (r6 == null) goto L4;
        r0.add(r6);
    L9:
        r6 = null;
        goto L10
    L12:
        Map r7 = MapsKt.toMap(r0);
        if (r7 == null) goto L15;
        return r7;
    L15:
        return MapsKt.emptyMap();
    }

    @Override // com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor, com.larus.ugc.perf.impl.d
    public final void a(com.larus.ugc.perf.impl.e r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        List r0 = CollectionsKt.listOf("homework_correction");
        Message r1 = r10.a;
        if (r1 == null) goto L13;
        List r2 = com.larus.im.bean.message.a.k(r1);
        if (r2 == null) goto L13;
        Block r3 = (Block) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L13;
        BlockContent r4 = r3.getContent();
        if (r4 == null) goto L13;
        CreationBlock r5 = r4.getCreationBlock();
        if (r5 == null) goto L13;
        String r6 = r5.scene;
    L15:
        if (CollectionsKt.contains(r0, r6) == false) goto L17;
        return;
    L17:
        boolean r7 = true;
        if (e == true) goto L22;
        e = true;
        com.larus.im.d.e().registerOnGlobalMessageObserver(new a());
    L22:
        if (Intrinsics.areEqual(r10.b.get("receive_first_image"), Boolean.TRUE) == true) goto L51;
        Message r8 = r10.a;
        if (r8 == null) goto L42;
        Iterator r9 = ((ArrayList) com.larus.im.bean.message.a.l(r8)).iterator();
    L28:
        if (r9.hasNext() == false) goto L40;
        Object r11 = r9.next();
        ImageData r12 = ((CreationItem) r11).image;
        if (r12 == null) goto L37;
        Integer r13 = r12.status;
        if (r13 == null) goto L37;
        if (r13.intValue() != 2) goto L37;
        boolean r14 = true;
    L38:
        if (r14 == false) goto L28;
    L41:
        CreationItem r15 = (CreationItem) r11;
    L43:
        if (r15 == null) goto L45;
        boolean r16 = true;
    L46:
        if (r16 == false) goto L51;
        r10.b.put("receive_first_image", Boolean.TRUE);
        r10.b.put("receive_first_imagetime", Long.valueOf(System.currentTimeMillis()));
        HashMap<String, Object> r17 = r10.b;
        String r18 = r15.id;
        if (r18 != null) goto L50;
        r18 = "";
    L50:
        r17.put("receive_first_imagetask_id", r18);
        goto L51
    L45:
        r16 = false;
    L37:
        r14 = false;
        goto L38
    L40:
        r11 = null;
        goto L41
    L42:
        r15 = null;
    L51:
        m(r10, 0);
        Message r19 = r10.a;
        if (r19 != null) goto L54;
    L56:
        r7 = false;
    L57:
        if (r7 == false) goto L66;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcCreationBlockMsgPerfMonitor$reportCreationTaskShow$1(r10, null), 2, null);
        return;
    L66:
        return;
    L54:
        if (com.larus.bmhome.chat.bean.d.j0(r19) != true) goto L56;
    L13:
        r6 = null;
        goto L15
    }

    @Override // com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor, nq9.g
    public final void b(Message r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "message");
        Intrinsics.checkNotNullParameter(r26, "taskId");
        super.b(r25, r26);
        com.larus.ugc.perf.impl.e r9 = com.larus.ugc.perf.impl.d.a.a(r25);
        if (r9 != null) goto L5;
        return;
    L5:
        Object r0 = r9.b.get("gen_image/image_load_finish" + r26);
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L8;
        return;
    L8:
        r9.b.put("gen_image/image_load_finish" + r26, r1);
        long r2 = System.currentTimeMillis();
        Object r3 = r9.b.get("gen_image/load_image" + r26 + "start_time");
        String r4 = null;
        if ((r3 instanceof Long) == false) goto L11;
        Long r5 = (Long) r3;
    L12:
        if (r5 == null) goto L14;
        long r6 = r5.longValue();
    L15:
        long r7 = r2 - r6;
        Message r8 = r9.a;
        if (r8 == null) goto L19;
        r4 = tz9.a.a(r8);
    L19:
        if (r4 != null) goto L21;
        String r20 = "";
    L22:
        String r10 = r9.b();
        if (r10 != null) goto L25;
        String r21 = "";
    L26:
        h1a.e.a(new OldUgcGenImgPerfMonitor.b(null, null, null, Long.valueOf(r7), "gen_image/image_load_finish", r20, "1", 0L, r21, r26, null, null, null, null, null, null, null, null, 261127), r9);
        return;
    L25:
        r21 = r10;
        goto L26
    L21:
        r20 = r4;
        goto L22
    L14:
        r6 = System.currentTimeMillis();
        goto L15
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor, nq9.g
    public final void e(Message r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "message");
        Intrinsics.checkNotNullParameter(r26, "taskId");
        com.larus.ugc.perf.impl.e r9 = com.larus.ugc.perf.impl.d.a.a(r25);
        if (r9 != null) goto L5;
        return;
    L5:
        Object r0 = r9.b.get("gen_image/show_loading" + r26);
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L8;
        return;
    L8:
        r9.b.put("gen_image/show_loading" + r26, r1);
        long r2 = System.currentTimeMillis();
        Object r3 = r9.b.get("gen_image/task_start" + r26 + "start_time");
        String r4 = null;
        if ((r3 instanceof Long) == false) goto L11;
        Long r5 = (Long) r3;
    L12:
        if (r5 == null) goto L14;
        long r6 = r5.longValue();
    L15:
        long r7 = r2 - r6;
        Message r8 = r9.a;
        if (r8 == null) goto L19;
        r4 = tz9.a.a(r8);
    L19:
        if (r4 != null) goto L21;
        String r20 = "";
    L22:
        String r10 = r9.b();
        if (r10 != null) goto L25;
        String r21 = "";
    L26:
        h1a.e.a(new OldUgcGenImgPerfMonitor.b(null, null, null, Long.valueOf(r7), "gen_image/show_loading", r20, null, null, r21, r26, null, null, null, null, null, null, null, null, 261319), r9);
        return;
    L25:
        r21 = r10;
        goto L26
    L21:
        r20 = r4;
        goto L22
    L14:
        r6 = System.currentTimeMillis();
        goto L15
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor, nq9.g
    public final void f(Message r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "message");
        Intrinsics.checkNotNullParameter(r26, "taskId");
        super.f(r25, r26);
        com.larus.ugc.perf.impl.e r9 = com.larus.ugc.perf.impl.d.a.a(r25);
        if (r9 != null) goto L5;
        return;
    L5:
        Object r0 = r9.b.get("gen_image/image_load_finish" + r26);
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L8;
        return;
    L8:
        r9.b.put("gen_image/image_load_finish" + r26, r1);
        long r2 = System.currentTimeMillis();
        Object r3 = r9.b.get("gen_image/load_image" + r26 + "start_time");
        String r4 = null;
        if ((r3 instanceof Long) == false) goto L11;
        Long r5 = (Long) r3;
    L12:
        if (r5 == null) goto L14;
        long r6 = r5.longValue();
    L15:
        long r7 = r2 - r6;
        Message r8 = r9.a;
        if (r8 == null) goto L19;
        r4 = tz9.a.a(r8);
    L19:
        if (r4 != null) goto L21;
        String r20 = "";
    L22:
        String r10 = r9.b();
        if (r10 != null) goto L25;
        String r21 = "";
    L26:
        h1a.e.a(new OldUgcGenImgPerfMonitor.b(null, null, null, Long.valueOf(r7), "gen_image/image_load_finish", r20, "0", -1L, r21, r26, null, null, null, null, null, null, null, null, 261127), r9);
        return;
    L25:
        r21 = r10;
        goto L26
    L21:
        r20 = r4;
        goto L22
    L14:
        r6 = System.currentTimeMillis();
        goto L15
    L11:
        r5 = null;
        goto L12
    }

    public final void m(com.larus.ugc.perf.impl.e r45, long r46) {
        Message r3 = r45.a;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (r4 == false) goto L11;
    L13:
        Object r5 = r45.b.get("gen_image/receive_last_package");
        Boolean r9 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r9) == false) goto L16;
        return;
    L16:
        r45.b.put("gen_image/receive_last_package", r9);
        Message r6 = r45.a;
        if (r6 == null) goto L19;
        List r7 = com.larus.im.bean.message.a.l(r6);
    L20:
        f r10 = f.a;
        Message r11 = r45.a;
        r10.getClass();
        List r12 = f.a(r11);
        Message r13 = r45.a;
        if (r13 != null) goto L23;
    L25:
        boolean r14 = false;
    L26:
        if (r14 == true) goto L43;
        if (r7 != null) goto L29;
    L32:
        boolean r15 = true;
    L33:
        if (r15 == false) goto L43;
        List r16 = r12;
        if (r16 != null) goto L37;
    L40:
        boolean r17 = true;
    L41:
        if (r17 == false) goto L43;
        return;
    L37:
        if (r16.isEmpty() == true) goto L40;
        r17 = false;
        goto L41
    L29:
        if (r7.isEmpty() == true) goto L32;
        r15 = false;
    L43:
        long r18 = System.currentTimeMillis();
        Long r19 = r45.d();
        if (r19 == null) goto L46;
        long r110 = r19.longValue();
    L47:
        long r111 = r18 - r110;
        if (r46 == 0) goto L50;
    L54:
        Long r112 = r45.c();
        if (r112 == null) goto L57;
        long r113 = r112.longValue();
    L58:
        long r114 = System.currentTimeMillis() - r113;
        Object r115 = r45.b.get("receive_first_imagetime");
        if ((r115 instanceof Long) == false) goto L61;
        Long r116 = (Long) r115;
    L62:
        if (r116 == null) goto L64;
        long r117 = r116.longValue();
    L65:
        Long r118 = r45.d();
        if (r118 == null) goto L68;
        long r119 = r118.longValue();
    L69:
        long r120 = r117 - r119;
        if (r12 == null) goto L72;
        int r121 = r12.size();
    L73:
        if (r121 != 0) goto L77;
        if (r7 == null) goto L76;
        r121 = r7.size();
        goto L77
    L76:
        r121 = 0;
    L77:
        long r1 = OldUgcGenImgPerfMonitor.k(r45.a, r46);
        if (r121 != 0) goto L82;
        if (r1 != 0) goto L82;
        return;
    L82:
        if (r1 != 710082041) goto L85;
        return;
    L85:
        if (r7 == null) goto L102;
        ArrayList r8 = new ArrayList();
        Iterator r20 = r7.iterator();
    L88:
        if (r20.hasNext() == false) goto L101;
        Object r21 = r20.next();
        ImageData r22 = ((CreationItem) r21).image;
        if (r22 == null) goto L97;
        Integer r23 = r22.status;
        if (r23 == null) goto L97;
        if (r23.intValue() != 2) goto L97;
        boolean r24 = true;
    L98:
        if (r24 == false) goto L88;
        r8.add(r21);
    L97:
        r24 = false;
        goto L98
    L101:
        int r25 = r8.size();
    L103:
        Message r26 = r45.a;
        if (r26 == null) goto L106;
        String r27 = tz9.a.a(r26);
    L107:
        String r28 = "";
        if (r27 != null) goto L110;
        String r30 = "";
    L111:
        Object r29 = r45.b.get("message_receive_first_package");
        if ((r29 instanceof Long) == false) goto L114;
        Long r210 = (Long) r29;
    L115:
        if (r46 == 0) goto L118;
        r111 = -1;
    L118:
        Message r31 = r45.a;
        if (r31 == null) goto L121;
        Integer r37 = Integer.valueOf(com.larus.bmhome.chat.bean.d.h(r31));
    L122:
        Message r32 = r45.a;
        if (r32 == null) goto L125;
        Integer r38 = IAIChatControlTraceService.a.Wb(r32);
        long r211 = 0;
    L127:
        if (r1 != r211) goto L138;
        Message r33 = r45.a;
        if (r33 != null) goto L131;
    L133:
        boolean r34 = false;
    L134:
        if (r34 == false) goto L138;
        if (r121 <= 0) goto L137;
        if (r25 == 0) goto L138;
    L137:
        String r35 = "1";
    L139:
        String r36 = r35;
        Message r39 = r45.a;
        if (r39 == null) goto L142;
        String r40 = ap8.a.b(r39);
    L143:
        if (r40 == null) goto L147;
        r28 = r40;
    L147:
        if (r28.length() != 0) goto L149;
        boolean r41 = true;
    L150:
        if (r41 == false) goto L152;
        r28 = "image";
    L152:
        String r42 = r28;
        if (r7 == null) goto L160;
        CreationItem r43 = (CreationItem) CollectionsKt.firstOrNull(r7);
        if (r43 == null) goto L160;
        CreationGenDetail r44 = r43.genDetail;
        if (r44 == null) goto L160;
        Integer r47 = r44.taskType;
        if (r47 == null) goto L160;
    L165:
        if (r47 == null) goto L167;
        String r310 = r47.toString();
    L168:
        LinkedHashSet r48 = new LinkedHashSet();
        if (r7 == null) goto L179;
        Iterator r49 = r7.iterator();
    L172:
        if (r49.hasNext() == false) goto L179;
        CreationGenDetail r50 = ((CreationItem) r49.next()).genDetail;
        if (r50 == null) goto L172;
        Integer r51 = r50.taskType;
        if (r51 == null) goto L172;
        r48.add(Integer.valueOf(r51.intValue()));
    L179:
        if (r48.size() <= 1) goto L181;
        boolean r52 = true;
    L182:
        h1a.e.a(new OldUgcGenImgPerfMonitor.b(r210, Long.valueOf(r120), Long.valueOf(r114), Long.valueOf(r111), "gen_image/receive_last_package", r30, r36, Long.valueOf(r1), null, null, r310, l3.f(Boolean.valueOf(r52)), r37, r38, Integer.valueOf(r121), Integer.valueOf(r25), r42, null, 131840), r45);
        Message r2 = r45.a;
        if (r2 == null) goto L206;
        List r53 = ap8.a.a(r2);
        if (r53 == null) goto L206;
        Iterator r54 = r53.iterator();
    L188:
        if (r54.hasNext() == false) goto L204;
        Object r55 = r54.next();
        AICreationTaskDurationInfo r56 = (AICreationTaskDurationInfo) r55;
        Integer r57 = r56.type;
        if (r57 != null) goto L193;
    L201:
        boolean r58 = false;
    L202:
        if (r58 == false) goto L188;
    L205:
        AICreationTaskDurationInfo r59 = (AICreationTaskDurationInfo) r55;
    L207:
        Message r60 = r45.a;
        if (r60 == null) goto L210;
        String r61 = r60.getMessageId();
    L211:
        if (r1 != r211) goto L213;
        boolean r62 = true;
    L214:
        Object r63 = r45.b.get("receive_first_imagetask_id");
        if ((r63 instanceof String) == false) goto L217;
        String r64 = (String) r63;
    L218:
        if (r59 == null) goto L222;
        List r65 = r59.durationInfo;
        if (r65 == null) goto L222;
        Map r66 = n(r65);
    L223:
        h1a.b.a(r61, r64, r62, Long.valueOf(r120), r66);
        Message r67 = r45.a;
        if (r67 == null) goto L271;
        List r68 = ap8.a.a(r67);
        if (r68 == null) goto L297;
        ArrayList r69 = new ArrayList();
        Iterator r70 = r68.iterator();
    L229:
        if (r70.hasNext() == false) goto L239;
        Object r71 = r70.next();
        Integer r72 = ((AICreationTaskDurationInfo) r71).type;
        if (r72 != null) goto L234;
    L236:
        boolean r73 = false;
    L237:
        if (r73 == false) goto L229;
        r69.add(r71);
        goto L229
    L234:
        if (r72.intValue() != 2) goto L236;
        r73 = true;
        goto L237
    L239:
        Iterator r74 = r69.iterator();
    L241:
        if (r74.hasNext() == false) goto L298;
        AICreationTaskDurationInfo r75 = (AICreationTaskDurationInfo) r74.next();
        Message r76 = r45.a;
        if (r76 == null) goto L245;
        String r77 = r76.getMessageId();
    L246:
        String r78 = r75.taskId;
        Integer r79 = r75.errorCode;
        if (r79 == null) goto L252;
        if (r79.intValue() != 0) goto L252;
        int r80 = 1;
    L253:
        Integer r81 = r75.errorCode;
        List r82 = r75.durationInfo;
        if (r82 == null) goto L256;
        d.getClass();
        Map r83 = n(r82);
    L257:
        TrackParams r122 = new TrackParams();
        if (r77 == null) goto L260;
        r122.put("message_id", r77);
    L260:
        if (r78 == null) goto L262;
        r122.put("task_id", r78);
    L262:
        r122.put("success", Integer.valueOf(r80));
        if (r81 == null) goto L265;
        r122.put("error_code", Integer.valueOf(r81.intValue()));
    L265:
        if (r83 == null) goto L270;
        Iterator r84 = r83.entrySet().iterator();
    L268:
        if (r84.hasNext() == false) goto L270;
        Map.Entry r85 = (Map.Entry) r84.next();
        r122.put((String) r85.getKey(), Long.valueOf(((Number) r85.getValue()).longValue()));
    L270:
        by7.a r86 = new by7.a("report_creation_task_monitor");
        r86.a.merge(r122);
        r86.b();
        goto L241
    L256:
        r83 = null;
    L252:
        r80 = 0;
        goto L253
    L245:
        r77 = null;
        goto L246
    L298:
        return;
    L297:
        return;
    L271:
        return;
    L222:
        r66 = null;
        goto L223
    L217:
        r64 = null;
        goto L218
    L213:
        r62 = false;
        goto L214
    L210:
        r61 = null;
        goto L211
    L193:
        if (r57.intValue() != 2) goto L201;
        String r87 = r56.taskId;
        Object r88 = r45.b.get("receive_first_imagetask_id");
        if ((r88 instanceof String) == false) goto L197;
        String r89 = (String) r88;
    L199:
        if (Intrinsics.areEqual(r87, r89) == false) goto L201;
        r58 = true;
        goto L202
    L197:
        r89 = null;
        goto L199
    L204:
        r55 = null;
    L206:
        r59 = null;
        goto L207
    L181:
        r52 = false;
        goto L182
    L167:
        r310 = null;
    L160:
        if (r12 == null) goto L164;
        com.larus.ugc.perf.impl.a r90 = (com.larus.ugc.perf.impl.a) CollectionsKt.firstOrNull(r12);
        if (r90 == null) goto L164;
        r47 = r90.taskType;
    L164:
        r47 = null;
        goto L165
    L149:
        r41 = false;
        goto L150
    L142:
        r40 = null;
        goto L143
    L131:
        if (r33.getMessageStatusLocal() != 21) goto L133;
        r34 = true;
    L138:
        r35 = "0";
        goto L139
    L125:
        r211 = 0;
        r38 = null;
        goto L127
    L121:
        r37 = null;
        goto L122
    L114:
        r210 = null;
        goto L115
    L110:
        r30 = r27;
        goto L111
    L106:
        r27 = null;
        goto L107
    L102:
        r25 = 0;
        goto L103
    L72:
        r121 = 0;
        goto L73
    L68:
        r119 = System.currentTimeMillis();
        goto L69
    L64:
        r117 = System.currentTimeMillis();
        goto L65
    L61:
        r116 = null;
        goto L62
    L57:
        r113 = 0;
        goto L58
    L50:
        if (r111 > 0) goto L52;
        return;
    L52:
        if (r111 <= 180000) goto L54;
        return;
    L46:
        r110 = System.currentTimeMillis();
        goto L47
    L23:
        if (com.larus.bmhome.chat.bean.d.j1(r13) != true) goto L25;
        r14 = true;
        goto L26
    L19:
        r7 = null;
        goto L20
    L11:
        if (r46 != 0) goto L13;
        return;
    L5:
        if (com.larus.bmhome.chat.bean.d.j0(r3) != true) goto L7;
        r4 = true;
        goto L9
    }
}
