package com.larus.bmhome.chat.trace;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.ability.MessageMonitorItemType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.container.RenderExceptionTrace;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.home.impl.sdk.SdkSheetsServiceImpl;
import com.larus.home.impl.sdk.n1;
import com.larus.home.impl.sdk.x1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactStatus;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.z2;
import com.larus.utils.z0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.a3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatMessageReadTrace$trackReadMessage$1", f = "ChatMessageReadTrace.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1016, 1019}, m = "invokeSuspend", n = {"chatMessageTimeInfo", "chatType", "message", "messageID", "replyID", "sectionID", "conversationID", "chatMessageTimeInfo", "chatType", "message", "messageID", "replyID", "sectionID", "conversationID", "isChatLastMessage"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
final class ChatMessageReadTrace$trackReadMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ s $chatMessageTimeInfoParam;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ p this$0;

    public ChatMessageReadTrace$trackReadMessage$1(s r1, p r2, Continuation<? super ChatMessageReadTrace$trackReadMessage$1> r3) {
        this.$chatMessageTimeInfoParam = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatMessageReadTrace$trackReadMessage$1(this.$chatMessageTimeInfoParam, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public final Object invokeSuspend(Object r94) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        String r1 = (String) this.L$7;
        String r3 = (String) this.L$6;
        String r5 = (String) this.L$5;
        String r9 = (String) this.L$4;
        String r10 = (String) this.L$3;
        Message r11 = (Message) this.L$2;
        String r12 = (String) this.L$1;
        s r13 = (s) this.L$0;
        ResultKt.throwOnFailure(r94);
        s r14 = r13;
        String r15 = r12;
        Message r16 = r11;
        String r17 = r10;
        String r18 = r9;
        String r19 = r5;
        Object r6 = r94;
    L52:
        BotModel r7 = (BotModel) r6;
        if (r7 == null) goto L55;
        String r110 = r7.getBotId();
    L56:
        if (r110 != null) goto L58;
        String r72 = r1;
        String r20 = r3;
        String r21 = "";
        String r111 = r19;
        String r112 = r18;
        String r113 = r17;
        String r23 = r15;
    L60:
        Function0<Pair<String, Integer>> r4 = this.this$0.f;
        if (r4 == null) goto L65;
        Pair r8 = (Pair) r4.invoke();
        if (r8 == null) goto L65;
        Integer r22 = (Integer) r8.getSecond();
    L67:
        if (r14.i == true) goto L76;
        Map r24 = r16.getExt();
        if (r24 == null) goto L71;
        String r25 = (String) r24.get("regen");
    L73:
        if (Intrinsics.areEqual(r25, "1") == true) goto L76;
        long r30 = 0;
    L77:
        int r26 = r14.j;
        long r27 = r14.d;
        long r28 = r14.b;
        long r29 = r27 - r28;
        Message r95 = r16;
        long r114 = r14.c;
        if (r114 != (-1)) goto L80;
    L83:
        long r31 = 0;
    L85:
        if (r31 <= r29) goto L88;
        r31 = r29;
    L88:
        if (r14.k == false) goto L95;
        long r115 = r14.y;
        if (r115 == 0) goto L95;
        long r210 = r115;
        long r116 = r14.z;
        if (r116 != 0) goto L94;
        r116 = System.currentTimeMillis();
        r210 = r14.y;
    L94:
        long r117 = r116 - r210;
    L97:
        if (r95 == null) goto L101;
        Map r32 = r95.getBusinessExt();
        if (r32 == null) goto L101;
        String r33 = (String) r32.get("message_case_mode");
    L103:
        if (Intrinsics.areEqual(r33, "1") == false) goto L106;
    L108:
        long r34 = 0;
    L109:
        s r118 = r14;
        if (r29 > z2.a.p()) goto L116;
        if (r118.k == true) goto L116;
        return Unit.INSTANCE;
    L116:
        if (r118.l == false) goto L118;
        long r35 = 1;
    L120:
        if (r118.m == false) goto L122;
        long r36 = 1;
    L123:
        if (r95 == null) goto L127;
        Map r37 = r95.getBusinessExt();
        if (r37 == null) goto L127;
        String r38 = (String) r37.get("message_case_mode");
    L129:
        if (Intrinsics.areEqual(r38, "1") == false) goto L132;
        Long r119 = null;
    L136:
        String r120 = r118.A;
        if (r118.n == true) goto L139;
    L141:
        long r39 = 0;
    L143:
        if (r118.p == false) goto L145;
        long r40 = 1;
    L146:
        if (r95 == null) goto L150;
        Map r41 = r95.getBusinessExt();
        if (r41 == null) goto L150;
        String r42 = (String) r41.get("message_case_mode");
    L152:
        if (Intrinsics.areEqual(r42, "1") == false) goto L155;
        long r211 = 1;
        Long r43 = null;
    L161:
        int r44 = r95.getContentType();
        long r45 = z0.c(com.larus.bmhome.chat.component.collection.m.b(r95));
        long r46 = z0.c(com.larus.bmhome.chat.component.collection.m.a(r95));
        if (Intrinsics.areEqual(ChatControlTrace.b.Za(r95), "ecommerce_product") == false) goto L164;
        String r121 = "1";
    L165:
        ArtifactBlock r212 = com.larus.im.bean.message.a.n(r95);
        RenderExceptionTrace r47 = RenderExceptionTrace.a;
        String r48 = r95.getMessageId();
        if (r48 != null) goto L168;
        r48 = "";
    L168:
        String r96 = r121;
        Intrinsics.checkNotNullParameter(r48, "msgId");
        Long r49 = r119;
        RenderExceptionTrace.a r50 = RenderExceptionTrace.b.remove(r48);
        String r122 = r95.getMessageId();
        if (r122 != null) goto L171;
        r122 = "";
    L171:
        Intrinsics.checkNotNullParameter(r122, "msgId");
        ConcurrentHashMap<String, RenderExceptionTrace.c> r123 = RenderExceptionTrace.c;
        long r51 = r117;
        RenderExceptionTrace.c r124 = r123.get(r122);
        if (r124 == null) goto L175;
        CopyOnWriteArrayList<WeakReference<rt8.a>> r125 = r124.a;
        if (r125 == null) goto L175;
    L176:
        long r52 = r31;
        r123.put(r122, new RenderExceptionTrace.c(r125));
        Intrinsics.checkNotNullParameter(r95, "message");
        Intrinsics.checkNotNullParameter(r118, "chatMessageTimeInfo");
        long r53 = SystemClock.elapsedRealtime();
        JSONObject r126 = new JSONObject();
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L290
        Map r128 = r95.getExt();     // Catch: Throwable -> L290
        if (r128 == null) goto L180;
        String r129 = (String) r128.get("tea_tags_time_cost");     // Catch: Throwable -> L290
    L181:
        if (r129 != null) goto L183;
    L186:
        boolean r130 = true;
    L187:
        if (r130 == true) goto L193;
        Iterator<Map.Entry<String, String>> r131 = com.larus.bmhome.chat.trace.appreciable.z.a(r129, "ChatMessageReadTrace").entrySet().iterator();     // Catch: Throwable -> L290
    L189:
        if (r131.hasNext() == false) goto L193;
        Map.Entry<String, String> r132 = r131.next();     // Catch: Throwable -> L290
        Iterator<Map.Entry<String, String>> r55 = r131;
        r126.put(r132.getKey(), r132.getValue());     // Catch: Throwable -> L290
        r131 = r55;
    L193:
        RenderExceptionTrace r133 = RenderExceptionTrace.a;
        if (r50 == null) goto L278;
        Object r134 = "message_case_mode";
        int r56 = r44;
        int r54 = r26;
        long r135 = r118.d - r118.b;     // Catch: Throwable -> L273
        if (r50.a == false) goto L201;
        r29 = r29;
        Object r57 = "1";
    L210:
        Map<String, RenderExceptionTrace.b> r58 = r50.f;     // Catch: Throwable -> L259
        if (r58 != null) goto L213;
    L261:
        s r60 = r118;
        Object r61 = r134;
    L262:
        String r59 = r50.g;     // Catch: Throwable -> L257
        String r62 = r50.h;     // Catch: Throwable -> L257
        String r63 = r50.i;     // Catch: Throwable -> L257
        JSONObject r64 = r50.j;     // Catch: Throwable -> L257
        Map<ContainerExceptionType, RenderExceptionTrace.d> r65 = r50.k;     // Catch: Throwable -> L257
        if (r65 == null) goto L279;
        Iterator<Map.Entry<ContainerExceptionType, RenderExceptionTrace.d>> r66 = r65.entrySet().iterator();     // Catch: Throwable -> L257
    L266:
        if (r66.hasNext() == false) goto L279;
        RenderExceptionTrace.d r67 = r66.next().getValue();     // Catch: Throwable -> L257
        if (r67.a >= r135) goto L270;
        boolean r68 = true;
    L271:
        if (r68 == false) goto L266;
        r63 = RenderExceptionTrace.d(r63, r67.c);     // Catch: Throwable -> L257
        r62 = RenderExceptionTrace.d(r62, r67.b);     // Catch: Throwable -> L257
        r64 = RenderExceptionTrace.c(r64, r67.d);     // Catch: Throwable -> L257
        goto L266
    L270:
        r68 = false;
    L279:
        if (r124 == null) goto L281;
        r124.a();     // Catch: Throwable -> L257
        r59 = RenderExceptionTrace.d(r59, r124.b);     // Catch: Throwable -> L257
        r62 = RenderExceptionTrace.d(r62, r124.c);     // Catch: Throwable -> L257
        r63 = RenderExceptionTrace.d(r63, r124.d);     // Catch: Throwable -> L257
        r64 = RenderExceptionTrace.c(r64, r124.e);     // Catch: Throwable -> L257
    L281:
        r126.put("monitor_items", r59);     // Catch: Throwable -> L257
        if (r62 == null) goto L284;
        r126.put("exception_items", r62);     // Catch: Throwable -> L257
    L284:
        if (r63 == null) goto L286;
        r126.put("exceptions", r63);     // Catch: Throwable -> L257
    L286:
        if (r64 == null) goto L288;
        r126.put("exception_extra_params", r64.toString());     // Catch: Throwable -> L257
    L288:
        r126.put("slo_monitor_total_duration", SystemClock.elapsedRealtime() - r53);     // Catch: Throwable -> L257
        Object r69 = Result.constructor-impl(r126);     // Catch: Throwable -> L257
    L293:
        JSONObject r70 = new JSONObject();
        if (Result.isFailure-impl(r69) == false) goto L296;
        r69 = r70;
    L296:
        ChatControlTrace r71 = ChatControlTrace.b;
        JSONObject r73 = r71.Ua(r95, (JSONObject) r69);
        if (r73 != null) goto L299;
        r73 = new JSONObject();
    L299:
        yc9.c0.c(r95, r73);
        Map r74 = r95.getExt();
        if (r74 == null) goto L305;
        if (r74.containsKey("general_task_upgrade_strategy") != true) goto L305;
        boolean r75 = true;
    L306:
        if (r75 == false) goto L312;
        Map r76 = r95.getExt();
        if (r76 == null) goto L310;
        String r77 = (String) r76.get("general_task_upgrade_strategy");
    L311:
        r73.put("action_type", r77);
        goto L312
    L310:
        r77 = null;
    L312:
        tx9.x r78 = tx9.x.a;
        LruCache<String, Message> r79 = ChatControlTrace.q;
        String r80 = r95.getReplyId();
        if (r80 != null) goto L315;
        r80 = "";
    L315:
        Message r81 = (Message) r79.get(r80);
        if (r81 == null) goto L318;
        Map r82 = r81.getBusinessExt();
    L319:
        r78.getClass();
        tx9.x.a(r82, r73);
        s r136 = r60;
        long r83 = r136.s;
        if (r83 <= 0) goto L325;
        if (r136.k == false) goto L325;
        Long r84 = Boxing.boxLong(r83 - r136.b);
    L332:
        if (r84.longValue() <= r29) goto L334;
        r84 = Boxing.boxLong(r29);
    L334:
        Long r710 = r84;
        String r85 = r136.t;
        if (r85 != null) goto L340;
        int r86 = a3.a;
        String r87 = r136.e;
        Intrinsics.checkNotNullParameter(r87, "endMethodString");
        if (Intrinsics.areEqual(r87, "scroll") == false) goto L339;
        r85 = "content_disappear";
        goto L340
    L339:
        r85 = "leave";
    L340:
        String r711 = r85;
        String r712 = CollectionsKt.joinToString$default(com.larus.im.bean.message.a.f(r95), ",", null, null, 0, null, new q(), 30, null);
        String r88 = r95.getReplyId();
        if (r88 != null) goto L343;
        r88 = "";
    L343:
        Message r89 = (Message) r79.get(r88);
        if (r89 == null) goto L355;
        Map r90 = r89.getBusinessExt();
        if (r90 == null) goto L355;
        String r91 = (String) r90.get("drive_file_send_info");
        if (r91 == null) goto L355;
        if (r91.length() <= 0) goto L352;
        boolean r92 = true;
    L353:
        if (r92 == false) goto L355;
    L356:
        FlowDriveFileSendInfo r93 = FlowDriveSdkService.a.m(r91);
        IFlowSdkDepend r97 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r97 == null) goto L359;
        r97.N();
        n1 r98 = n1.a;
    L360:
        if (r97 == null) goto L362;
        r97.D();
        JSONObject r99 = x1.a.g();
    L363:
        if (r212 == null) goto L366;
        Integer r100 = r212.getResourceType();
        if (r100 == null) goto L366;
    L372:
        Integer r610 = r100;
    L374:
        if (r212 == null) goto L377;
        Integer r101 = r212.getResourceType();
        if (r101 == null) goto L377;
    L385:
        if (r212 == null) goto L388;
        String r137 = r212.getResourceId();
        if (r137 == null) goto L388;
    L396:
        String r611 = r137;
    L398:
        if (r212 == null) goto L401;
        String r138 = r212.getArtifactMetaId();
        if (r138 == null) goto L401;
    L409:
        String r612 = r138;
    L411:
        if (r99 == null) goto L420;
        String r102 = r99.optString("base_id");
        if (r102 == null) goto L420;
        if (r102.length() <= 0) goto L417;
        boolean r139 = true;
    L418:
        if (r139 == false) goto L420;
        String r613 = r102;
    L421:
        long r140 = r54;
        long r103 = r136.x;
        String r104 = r136.f;
        String r141 = r136.e;
        long r142 = r56;
        Integer r143 = r136.q;
        if (r143 == null) goto L424;
        Long r144 = Boxing.boxLong(r143.intValue());
    L425:
        Regex r145 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r95, "<this>");
        String r410 = com.larus.bmhome.chat.bean.d.x(r95).getNotifyTaskId();
        Intrinsics.checkNotNullParameter(r95, "<this>");
        String r614 = com.larus.bmhome.chat.bean.d.x(r95).getMsgSourceType();
        Intrinsics.checkNotNullParameter(r95, "<this>");
        String r615 = com.larus.bmhome.chat.bean.d.x(r95).getMsgCandidateSourceType();
        Intrinsics.checkNotNullParameter(r95, "<this>");
        String r146 = com.larus.bmhome.chat.bean.d.x(r95).getMsgGid();
        int r147 = r136.h;
        String r616 = r71.tb(r95);
        Integer r713 = r101;
        if (com.larus.im.bean.message.a.C0(r95) == false) goto L428;
        long r617 = r211;
    L429:
        Map r105 = r95.getBusinessExt();
        if (r105 == null) goto L432;
        String r106 = (String) r105.get(r61);
    L434:
        if (Intrinsics.areEqual(r106, r57) == false) goto L436;
        String r107 = r71.bb(ChatControlTrace.y);
    L437:
        String r148 = ChatControlTrace.N;
        String r149 = ChatControlTrace.O;
        String r510 = tz9.a.a(r95);
        String r618 = tz9.a.b(r95);
        if (r212 == null) goto L440;
        String r714 = r212.getResourceId();
    L441:
        if (r610 != null) goto L443;
        String r715 = r107;
        String r810 = r149;
    L446:
        boolean r108 = false;
    L447:
        if (r108 == false) goto L449;
        String r109 = r611;
    L450:
        String r150 = com.larus.im.bean.message.a.c(r95);
        String r811 = r109;
        if (r212 == null) goto L453;
        int r411 = 1;
    L454:
        p r151 = this.this$0;
        if (r212 == null) goto L457;
        Integer r213 = r212.getStatus();
    L458:
        r151.getClass();
        if (r213 == null) goto L467;
        r213.intValue();
        String r812 = r148;
        if (r213.intValue() != ArtifactStatus.OUTDATED.getValue()) goto L463;
    L466:
        String r152 = "folded";
    L468:
        p r153 = this.this$0;
        if (r212 == null) goto L471;
        Integer r214 = r212.getStatus();
    L472:
        r153.getClass();
        int r154 = ArtifactStatus.GENERATING.getValue();
        String r813 = r152;
        if (r214 != null) goto L476;
    L478:
        int r155 = ArtifactStatus.GENERATED.getValue();
        if (r214 != null) goto L482;
    L484:
        int r156 = ArtifactStatus.UNKNOWN.getValue();
        if (r214 != null) goto L488;
    L490:
        String r157 = null;
    L491:
        if (r98 == null) goto L493;
        Integer r158 = Boxing.boxInt(r98.R());
    L494:
        if (r98 == null) goto L496;
        Integer r159 = Boxing.boxInt(r98.p());
    L497:
        int r716 = r95.getMessageStatusLocal();
        Integer r814 = r159;
        by7.e r160 = this.this$0.b;
        if (r93 == null) goto L500;
        String r815 = r93.getCollectionId();
    L501:
        if (r93 == null) goto L503;
        String r816 = r93.getCollectionName();
    L504:
        if (r93 == null) goto L506;
        String r817 = r93.getContentType();
    L507:
        if (r93 == null) goto L509;
        String r161 = r93.getContentSecType();
    L510:
        Map r818 = com.larus.bmhome.chat.bean.d.l(r95);
        if (r97 == null) goto L513;
        r97.h();
        String r162 = SdkSheetsServiceImpl.a.d(r95);
    L514:
        tx9.z2.a(r113, r112, r111, r20, r21, r22, r23, Boxing.boxLong(r140), Boxing.boxLong(r103), Boxing.boxLong(r29), Boxing.boxLong(r52), Boxing.boxLong(r51), Boxing.boxLong(r34), Boxing.boxLong(r30), r104, r141, Boxing.boxLong(r35), Boxing.boxLong(r36), r49, Boxing.boxLong(r39), r43, Boxing.boxLong(r40), Boxing.boxLong(r142), Boxing.boxLong(r45), Boxing.boxLong(r46), r144, r614, r410, Boxing.boxInt(r147), r96, r616, r615, r73, r160, Boxing.boxLong(r617), r146, r812, r810, r715, r120, r510, r618, r714, r612, r713, r610, r811, r611, r613, r150, Boxing.boxInt(r411), r813, r157, r158, r814, r72, r710, r711, r712, Boxing.boxInt(r716), r815, r816, r817, r161, r818, r162);
        return Unit.INSTANCE;
    L513:
        r162 = null;
        goto L514
    L509:
        r161 = null;
        goto L510
    L506:
        r817 = null;
        goto L507
    L503:
        r816 = null;
        goto L504
    L500:
        r815 = null;
        goto L501
    L496:
        r159 = null;
        goto L497
    L493:
        r158 = null;
        goto L494
    L488:
        if (r214.intValue() != r156) goto L490;
        r157 = "fail";
        goto L491
    L482:
        if (r214.intValue() != r155) goto L484;
        r157 = "success";
        goto L491
    L476:
        if (r214.intValue() != r154) goto L478;
        r157 = "process";
        goto L491
    L471:
        r214 = null;
        goto L472
    L463:
        if (r213.intValue() == ArtifactStatus.DELETED.getValue()) goto L466;
        r152 = "expanded";
        goto L468
    L467:
        r812 = r148;
        r152 = null;
        goto L468
    L457:
        r213 = null;
        goto L458
    L453:
        r411 = 0;
        goto L454
    L449:
        r109 = null;
        goto L450
    L443:
        r715 = r107;
        r810 = r149;
        if (r610.intValue() != 9) goto L446;
        r108 = true;
        goto L447
    L440:
        r714 = null;
        goto L441
    L436:
        r107 = null;
        goto L437
    L432:
        r106 = null;
        goto L434
    L428:
        r617 = 0;
        goto L429
    L424:
        r144 = null;
        goto L425
    L417:
        r139 = false;
    L420:
        r613 = null;
    L401:
        if (r99 == null) goto L410;
        r138 = r99.optString("artifact_meta_id");
        if (r138 == null) goto L410;
        if (r138.length() <= 0) goto L407;
        boolean r163 = true;
    L408:
        if (r163 == false) goto L410;
    L407:
        r163 = false;
    L410:
        r612 = null;
    L388:
        if (r99 == null) goto L397;
        r137 = r99.optString("resource_id");
        if (r137 == null) goto L397;
        if (r137.length() <= 0) goto L394;
        boolean r164 = true;
    L395:
        if (r164 == false) goto L397;
    L394:
        r164 = false;
    L397:
        r611 = null;
    L377:
        if (r99 == null) goto L384;
        r101 = Boxing.boxInt(r99.optInt("artifact_type"));
        if (r101.intValue() <= 0) goto L381;
        boolean r165 = true;
    L382:
        if (r165 == false) goto L384;
    L381:
        r165 = false;
    L384:
        r101 = null;
    L366:
        if (r99 == null) goto L373;
        r100 = Boxing.boxInt(r99.optInt("resource_type"));
        if (r100.intValue() <= 0) goto L370;
        boolean r166 = true;
    L371:
        if (r166 == false) goto L373;
    L370:
        r166 = false;
    L373:
        r610 = null;
        goto L374
    L362:
        r99 = null;
        goto L363
    L359:
        r98 = null;
        goto L360
    L352:
        r92 = false;
    L355:
        r91 = null;
    L325:
        if (r136.r == true) goto L327;
    L330:
        r84 = Boxing.boxLong(0);
        goto L332
    L327:
        if (r136.k == false) goto L330;
        r84 = Boxing.boxLong(r136.d - r136.b);
        goto L332
    L318:
        r82 = null;
    L305:
        r75 = false;
    L257:
        th = th;
    L292:
        Result.Companion r167 = Result.Companion;
        r69 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L293
    L213:
        if (RenderExceptionTrace.g(MessageMonitorItemType.LYNX) == true) goto L261;
        Iterator<T> r168 = r58.values().iterator();     // Catch: Throwable -> L259
        long r169 = 0;
        String r170 = null;
    L215:
        if (r168.hasNext() == false) goto L234;
        RenderExceptionTrace.b r171 = (RenderExceptionTrace.b) r168.next();     // Catch: Throwable -> L259
        r60 = r118;
        r61 = r134;
        long r172 = r171.a;     // Catch: Throwable -> L257
        if (r172 <= 0) goto L224;
        long r619 = r172;
        long r173 = r171.b;     // Catch: Throwable -> L257
        if (r173 <= 0) goto L224;
    L226:
        long r174 = r173 - r619;     // Catch: Throwable -> L257
    L229:
        if (r169 >= r174) goto L233;
        r170 = r171.e;     // Catch: Throwable -> L257
        r169 = r174;
        if (r170 != null) goto L233;
        r170 = "";
    L233:
        r118 = r60;
        r134 = r61;
    L224:
        if (r172 <= 0) goto L227;
        r173 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L257
        r619 = r171.a;     // Catch: Throwable -> L257
        goto L226
    L227:
        r174 = 0;
        goto L229
    L234:
        r60 = r118;
        r61 = r134;
        if (r169 <= 0) goto L237;
        r126.put("max_lynx_duration", r169);     // Catch: Throwable -> L257
    L237:
        MessageMonitorItemType r175 = MessageMonitorItemType.LYNX;     // Catch: Throwable -> L257
        if (r169 <= RenderExceptionTrace.f(r175)) goto L262;
        if (com.larus.utils.o0.d(r170) == false) goto L262;
        if (r169 >= r135) goto L262;
        String r176 = r50.i;     // Catch: Throwable -> L257
        ContainerExceptionType r177 = ContainerExceptionType.TIMEOUT_LYNX;     // Catch: Throwable -> L257
        r50.i = RenderExceptionTrace.d(r176, r177.getValue());     // Catch: Throwable -> L257
        r50.h = RenderExceptionTrace.d(r50.h, r175.getValue());     // Catch: Throwable -> L257
        if (r50.j != null) goto L246;
        r50.j = new JSONObject();     // Catch: Throwable -> L257
    L246:
        JSONObject r178 = r50.j;     // Catch: Throwable -> L257
        if (r178 == null) goto L262;
        r178.put(r177.getValue() + "_card_id", r170);     // Catch: Throwable -> L257
        String r179 = r177.getValue() + "_applet_id";     // Catch: Throwable -> L257
        RenderExceptionTrace.b r180 = r58.get(r170);     // Catch: Throwable -> L257
        if (r180 == null) goto L251;
        String r181 = r180.c;     // Catch: Throwable -> L257
    L252:
        r178.put(r179, r181);     // Catch: Throwable -> L257
        String r182 = r177.getValue() + "_widget_id";     // Catch: Throwable -> L257
        RenderExceptionTrace.b r183 = r58.get(r170);     // Catch: Throwable -> L257
        if (r183 == null) goto L255;
        String r184 = r183.d;     // Catch: Throwable -> L257
    L256:
        r178.put(r182, r184);     // Catch: Throwable -> L257
        goto L262
    L255:
        r184 = null;
        goto L256
    L251:
        r181 = null;
    L259:
        th = th;
    L260:
        r60 = r118;
        r61 = r134;
        goto L292
    L201:
        r57 = "1";
        r29 = r29;
        r126.put("create_duration", r50.c - r50.b);     // Catch: Throwable -> L259
        r126.put("bind_duration", r50.e - r50.d);     // Catch: Throwable -> L259
    L205:
        th = th;
        r29 = r29;
    L273:
        th = th;
    L275:
        r57 = "1";
    L276:
        th = th;
        r56 = r44;
        r54 = r26;
        goto L275
    L278:
        r29 = r29;
        r56 = r44;
        r54 = r26;
        r57 = "1";
        r61 = "message_case_mode";
        r60 = r118;
        r59 = null;
        r62 = null;
        r63 = null;
        r64 = null;
        goto L279
    L183:
        if (r129.length() == 0) goto L186;
        r130 = false;
        goto L187
    L180:
        r129 = null;
    L290:
        th = th;
        r29 = r29;
        r56 = r44;
        r54 = r26;
        r57 = "1";
        r61 = "message_case_mode";
        r60 = r118;
    L175:
        r125 = new CopyOnWriteArrayList();
        goto L176
    L164:
        r121 = TriggerSendLoading.NO_LOADING;
        goto L165
    L155:
        if (r118.v == true) goto L157;
    L159:
        r211 = 1;
        Long r185 = Boxing.boxLong(0);
    L160:
        r43 = r185;
        goto L161
    L157:
        if (r118.w == false) goto L159;
        r211 = 1;
        r185 = Boxing.boxLong(1);
    L150:
        r42 = null;
        goto L152
    L145:
        r40 = 0;
        goto L146
    L139:
        if (r118.o == false) goto L141;
        r39 = 1;
        goto L143
    L132:
        if (r118.u == false) goto L134;
        Long r186 = Boxing.boxLong(1);
    L135:
        r119 = r186;
        goto L136
    L134:
        r186 = Boxing.boxLong(0);
    L127:
        r38 = null;
        goto L129
    L122:
        r36 = 0;
        goto L123
    L118:
        r35 = 0;
        goto L120
    L106:
        if (r14.k == false) goto L108;
        r34 = 1;
    L101:
        r33 = null;
    L95:
        r117 = 0;
        goto L97
    L80:
        if (r14.k == false) goto L83;
        r31 = r114 - r28;
        goto L85
    L71:
        r25 = null;
    L76:
        r30 = 1;
    L65:
        r22 = null;
        goto L67
    L58:
        String r187 = r1;
    L59:
        r20 = r3;
        r72 = r187;
        r111 = r19;
        r112 = r18;
        r113 = r17;
        r23 = r15;
        r21 = r110;
        goto L60
    L55:
        r110 = null;
        goto L56
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r3 = (String) this.L$6;
        r19 = (String) this.L$5;
        r18 = (String) this.L$4;
        r17 = (String) this.L$3;
        r16 = (Message) this.L$2;
        r15 = (String) this.L$1;
        r14 = (s) this.L$0;
        ResultKt.throwOnFailure(r94);
        Object r188 = r94;
    L35:
        Message r189 = (Message) r188;
        if (r189 != null) goto L38;
        r187 = null;
    L42:
        Function0<Pair<String, Integer>> r190 = this.this$0.f;
        if (r190 == null) goto L48;
        Pair r191 = (Pair) r190.invoke();
        if (r191 == null) goto L48;
        r110 = (String) r191.getFirst();
        if (r110 != null) goto L59;
    L48:
        RepoDispatcher.a.getClass();
        ChatRepo r192 = RepoDispatcher.d;
        this.L$0 = r14;
        this.L$1 = r15;
        this.L$2 = r16;
        this.L$3 = r17;
        this.L$4 = r18;
        this.L$5 = r19;
        this.L$6 = r3;
        this.L$7 = r187;
        this.label = 2;
        r6 = r192.F1(r17, this);
        if (r6 != r0) goto L51;
        return r0;
    L51:
        r1 = r187;
        goto L52
    L38:
        if (Intrinsics.areEqual(r189.getMessageId(), r17) == false) goto L40;
        r187 = "1";
        goto L42
    L40:
        r187 = TriggerSendLoading.NO_LOADING;
        goto L42
    L10:
        ResultKt.throwOnFailure(r94);
        s r193 = this.$chatMessageTimeInfoParam;
        if (r193 == null) goto L13;
        Function0<String> r194 = this.this$0.e;
        if (r194 == null) goto L17;
        String r195 = (String) r194.invoke();
    L18:
        if (r195 != null) goto L20;
        r195 = "";
    L20:
        Message r196 = r193.g;
        if (r196 == null) goto L23;
        r17 = r196.getMessageId();
        if (r17 != null) goto L27;
        r17 = "";
    L27:
        String r197 = r196.getReplyId();
        String r198 = r196.getSectionId();
        String r199 = r196.getConversationId();
        RepoDispatcher.a.getClass();
        ChatRepo r1100 = RepoDispatcher.d;
        if (r199 != null) goto L30;
        String r200 = "";
    L31:
        this.L$0 = r193;
        this.L$1 = r195;
        this.L$2 = r196;
        this.L$3 = r17;
        this.L$4 = r197;
        this.L$5 = r198;
        this.L$6 = r199;
        this.label = 1;
        r188 = r1100.D1(r200, this);
        if (r188 != r0) goto L34;
        return r0;
    L34:
        r14 = r193;
        r3 = r199;
        r15 = r195;
        r19 = r198;
        r16 = r196;
        r18 = r197;
        goto L35
    L30:
        r200 = r199;
        goto L31
    L23:
        return Unit.INSTANCE;
    L17:
        r195 = null;
        goto L18
    L13:
        return Unit.INSTANCE;
    }
}
