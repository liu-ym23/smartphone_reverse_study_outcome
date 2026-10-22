package com.larus.bmhome.chat.helper;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.SubConvFirstMet;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.IMMsgExt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.conversation.ForkConversationRequest;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tx9.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatRouterHelper {
    public static final ChatRouterHelper a = null;

    static {
        a = new ChatRouterHelper();
    }

    public ChatRouterHelper() {
    }

    public static boolean i() {
        boolean r2 = false;
        if (Intrinsics.areEqual(PollingConfigService.a.f("cnc_dg"), "1") == true) goto L5;
        return false;
    L5:
        t19.s r3 = t19.s.a;
        AppHost.Companion r0 = AppHost.a;
        Application r4 = r0.getApplication();
        z2 r5 = z2.a;
        FlowDowngradeToastConfig r6 = r5.getFlowDowngradeToastConfig();
        String r7 = null;
        if (r6 == null) goto L8;
        String r8 = r6.getTrafficDegradationFeatureDisableCn();
    L10:
        if (r8 != null) goto L12;
    L13:
        r2 = true;
    L14:
        if (r2 == false) goto L17;
        String r1 = r0.getApplication().getString(2131910602);
    L16:
        String r9 = r1;
        Intrinsics.checkNotNull(r9);
        t19.s.j(r3, r4, r9, null, false, 28);
        x0.a("cnc_dg");
        return true;
    L17:
        FlowDowngradeToastConfig r10 = r5.getFlowDowngradeToastConfig();
        if (r10 == null) goto L20;
        r7 = r10.getTrafficDegradationFeatureDisableCn();
    L20:
        r1 = String.valueOf(r7);
        goto L16
    L12:
        if (r8.length() != 0) goto L14;
    L8:
        r8 = null;
        goto L10
    }

    public static void b(Bundle r5, Bundle r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r1 = r6.getString("selected_skills");
        if (r1 == null) goto L7;
        r5.putString("selected_skills", r1);
    L7:
        String r2 = r6.getString("input_text");
        if (r2 == null) goto L10;
        r5.putString("input_text", r2);
    L10:
        String r3 = r6.getString("task_skill_transfer_from_conversation_id");
        if (r3 == null) goto L13;
        r5.putString("task_skill_transfer_from_conversation_id", r3);
    L13:
        String r4 = r6.getString("project_id");
        if (r4 == null) goto L16;
        r5.putString("project_id", r4);
    L16:
        String r7 = r6.getString("pending_pc_device_id");
        if (r7 == null) goto L19;
        r5.putString("pending_pc_device_id", r7);
    L19:
        String r8 = r6.getString("pending_pc_device_name");
        if (r8 == null) goto L22;
        r5.putString("pending_pc_device_name", r8);
    L22:
        String r9 = r6.getString("pending_pc_device_type");
        if (r9 == null) goto L25;
        r5.putString("pending_pc_device_type", r9);
    L25:
        String r10 = r6.getString("KEY_CAMERA_RESULT_PENDING_SESSION_ID");
        if (r10 == null) goto L29;
        r5.putString("KEY_CAMERA_RESULT_PENDING_SESSION_ID", r10);
    L29:
        if (r6.containsKey("pending_reply_mode") == false) goto L31;
        r5.putSerializable("pending_reply_mode", r6.getSerializable("pending_reply_mode"));
    L31:
        String r11 = r6.getString("entry_type");
        if (r11 == null) goto L34;
        r5.putString("entry_type", r11);
    L34:
        String r12 = r6.getString("conversation_mode_key_override");
        if (r12 == null) goto L37;
        r5.putString("conversation_mode_key_override", r12);
    L37:
        String r13 = r6.getString("open_method");
        if (r13 == null) goto L40;
        r5.putString("open_method", r13);
    L40:
        Parcelable r14 = r6.getParcelable("actionbar_instruction_send_message_track_ext_map");
        if ((r14 instanceof ICoreInputAbility.SendMessageTrackExtMap) == false) goto L43;
        ICoreInputAbility.SendMessageTrackExtMap r15 = (ICoreInputAbility.SendMessageTrackExtMap) r14;
    L44:
        if (r15 == null) goto L47;
        FLogger.a.i("ChatRouterHelper", "[appendExtraParams] sendMessageTrackExtKeys=" + r15.a.keySet());
        r5.putParcelable("actionbar_instruction_send_message_track_ext_map", r15);
    L47:
        if (z2.a.getRouterConfig().a() == false) goto L52;
        String r16 = r6.getString("reply_mode");
        if (r16 == null) goto L52;
        r5.putString("reply_mode", r16);
    L52:
        if (r6.containsKey("conversation_fork_auto_route_reanswer") == false) goto L54;
        r5.putBoolean("conversation_fork_auto_route_reanswer", r6.getBoolean("conversation_fork_auto_route_reanswer"));
    L54:
        String r17 = r6.getString("conversation_fork_ext");
        if (r17 == null) goto L58;
        r5.putString("conversation_fork_ext", r17);
        return;
    L58:
        return;
    L43:
        r15 = null;
        goto L44
    }

    public static void c(Bundle r2, wc9.e r3, boolean r4) {
        r2.putBoolean("is_create_sub_conversation", true);
        if (r3 == null) goto L5;
        String r5 = r3.a;
    L6:
        r2.putString("argCreateSubConversationId", r5);
        r2.putBoolean("arg_need_to_show_ime", r4);
        return;
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v25, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r70v0, types: [java.util.List] */
    public final Object d(String r132, wc9.e r133, List<Message> r134, String r135, String r136, Continuation<? super wc9.e> r137) {
        if ((r137 instanceof ChatRouterHelper$createLocalBotSubConv$1) == false) goto L7;
        ChatRouterHelper$createLocalBotSubConv$1 r2 = (ChatRouterHelper$createLocalBotSubConv$1) r137;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r12 = "true";
        String r13 = "";
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        BotModel r0 = (BotModel) r2.L$2;
        BotModel r6 = (BotModel) r2.L$1;
        List<Message> r7 = (List) r2.L$0;
        ResultKt.throwOnFailure(r1);
        BotModel r8 = r0;
        String r9 = null;
    L137:
        wc9.e r10 = (wc9.e) r1;
        BotInfoCache r11 = BotInfoCache.INSTANCE;
        if (r10 == null) goto L140;
        String r14 = r10.a;
    L141:
        if (r14 != null) goto L143;
        r14 = "";
    L143:
        r11.put(r14, r6);
        LocalSubConvHelper r15 = LocalSubConvHelper.a;
        if (r10 == null) goto L146;
        String r16 = r10.a;
    L147:
        if (r16 == null) goto L150;
        r13 = r16;
    L150:
        BotOnBoarding r17 = r8.getOnBoarding();
        if (r17 == null) goto L154;
        List r18 = r17.getMessageList();
        if (r18 == null) goto L154;
    L155:
        LocalSubConvHelper.j(r13, r18, r7.isEmpty());
        return r10;
    L154:
        r18 = CollectionsKt.emptyList();
        goto L155
    L146:
        r16 = r9;
        goto L147
    L140:
        r14 = r9;
        goto L141
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r19 = (String) r2.L$6;
        Ref.ObjectRef r20 = (Ref.ObjectRef) r2.L$5;
        r8 = (BotModel) r2.L$4;
        BotModel r21 = (BotModel) r2.L$3;
        String r22 = (String) r2.L$2;
        String r110 = (String) r2.L$1;
        List<Message> r111 = (List) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r12 = "true";
    L113:
        wc9.e r23 = (wc9.e) r1;
        if (r23 == null) goto L116;
        Integer r24 = r23.C;
    L117:
        r20.element = r24;
    L118:
        String r25 = r110;
        Integer r112 = (Integer) r20.element;
        r2.L$0 = r111;
        r2.L$1 = r21;
        r2.L$2 = r8;
        r9 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.L$6 = null;
        r2.label = 4;
        kotlinx.coroutines.j r26 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r26.C();
        z2.a.w3();
        boolean r27 = AccountService.a.isEnterpriseAccount();
        if (r27 == false) goto L121;
        int r28 = 2131908160;
    L122:
        String r29 = AppHost.a.getApplication().getResources().getString(r28);
        NativeConversationServiceImpl r113 = com.larus.im.d.d();
        Map r114 = MapsKt.createMapBuilder();
        r114.put("attach_local_msg", r12);
        r114.put("conv_name", r29);
        if (r22 != null) goto L125;
    L128:
        boolean r30 = true;
    L129:
        if (r30 == true) goto L131;
        r114.put("custom_suffix", r22);
    L131:
        r113.createLocalBotConversation(r8, 3, r112, MapsKt.build(r114), r25, new a(r27, r26));
        r1 = r26.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L134;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L134:
        if (r1 != r4) goto L136;
        return r4;
    L136:
        r6 = r21;
        r7 = r111;
        goto L137
    L125:
        if (r22.length() == 0) goto L128;
        r30 = false;
        goto L129
    L121:
        r28 = 2131908104;
        goto L122
    L116:
        r24 = null;
        goto L117
    L18:
        BotModel r31 = (BotModel) r2.L$5;
        BotModel r32 = (BotModel) r2.L$4;
        String r33 = (String) r2.L$3;
        r110 = (String) r2.L$2;
        r111 = (List) r2.L$1;
        wc9.e r34 = (wc9.e) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r12 = "true";
    L99:
        r22 = r33;
        r21 = r32;
        r8 = r31;
    L101:
        r20 = new Ref.ObjectRef();
        if (r34 == null) goto L104;
        Integer r35 = r34.C;
    L105:
        r20.element = r35;
        if (r35 != null) goto L118;
        if (r34 == null) goto L118;
        String r36 = r34.a;
        if (r36 == null) goto L118;
        RepoDispatcher.a.getClass();
        ConversationRepo r37 = RepoDispatcher.f;
        r2.L$0 = r111;
        r2.L$1 = r110;
        r2.L$2 = r22;
        r2.L$3 = r21;
        r2.L$4 = r8;
        r2.L$5 = r20;
        r2.L$6 = r36;
        r2.label = 3;
        r1 = IConversationRepoService$a.c(r37, r36, false, null, r2, 6);
        if (r1 != r4) goto L113;
        return r4;
    L104:
        r35 = null;
        goto L105
    L19:
        String r38 = (String) r2.L$4;
        String r39 = (String) r2.L$3;
        List<Message> r40 = (List) r2.L$2;
        wc9.e r115 = (wc9.e) r2.L$1;
        String r116 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r41 = r39;
        List<Message> r42 = r40;
    L30:
        BotModel r43 = (BotModel) r1;
        if (r43 != null) goto L34;
        return null;
    L34:
        if (r42.isEmpty() == false) goto L71;
        LocalSubConvHelper r44 = LocalSubConvHelper.a;
        ArrayList r45 = new ArrayList();
        AppHost.Companion r61 = AppHost.a;
        long r46 = 1000;
        long r53 = r61.getAppClock().currentTimeMillis() / r46;
        if (r116 != null) goto L38;
        String r117 = "";
    L39:
        Message r84 = new Message("local", null, r117, 2, 21, MessageStatus.MessageStatus_AVAILABLE, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, CollectionsKt.listOf(Integer.valueOf(MessageTag.MessageTag_Onboarding_FIRSTMEG.value)), false, null, null, r53, null, null, null, -536870974, 29, null);
        LaunchInfo r47 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r47 == null) goto L42;
        SubConvFirstMet r48 = r47.h1();
    L43:
        if (r48 == null) goto L45;
        String r118 = r48.a();
    L46:
        if (r118 != null) goto L48;
        String r138 = "";
    L49:
        if (r48 == null) goto L52;
        List r49 = r48.b();
        if (r49 == null) goto L52;
    L53:
        LinkedHashMap r119 = new LinkedHashMap();
        if ((true ^ r49.isEmpty()) == false) goto L56;
        r119.put("skill_card_cnt", String.valueOf(r49.size()));
    L56:
        r119.put("local_sub_coco_conv", "true");
        if (com.larus.utils.o0.d(r138) == false) goto L64;
        Lazy r50 = com.larus.im.j.a;
        if (r116 != null) goto L61;
        String r51 = "";
    L62:
        String r100 = com.larus.im.j.a(r51, 0);
        StringBuilder r52 = new StringBuilder("{\"text\":\"");
        String r54 = r138;
        r52.append(r54);
        r52.append("\"}");
        r45.add(Message.copy$default(r84, null, null, null, 0, 0, null, 1, false, r54, r52.toString(), null, null, null, r119, r100, r100, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, r61.getAppClock().currentTimeMillis(), null, null, null, -58177, 29, null));
        goto L64
    L61:
        r51 = r116;
    L64:
        int r55 = r45.size();
        ?? r56 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r45, 10));
        Iterator r57 = r45.iterator();
        int r120 = 0;
    L66:
        if (r57.hasNext() == false) goto L85;
        Object r121 = r57.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        long r123 = r55 - r120;
        r56.add(Message.copy$default((Message) r121, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, r123 * r46, r123, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -196609, 31, null));
        r120 = r122;
    L85:
        BotModel r58 = BotModel.copy$default(r43, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, new BotOnBoarding(null, null, null, 0, r56, 15, null), null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2147483583, null);
        if (r38 != null) goto L88;
    L91:
        boolean r59 = true;
    L92:
        if (r59 == false) goto L100;
        String r60 = com.larus.im.j.c(r116, null);
        r2.L$0 = r115;
        r2.L$1 = r42;
        r2.L$2 = r41;
        r2.L$3 = r38;
        r2.L$4 = r43;
        r2.L$5 = r58;
        r2.label = 2;
        kotlinx.coroutines.j r62 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r62.C();
        com.larus.im.d.e().g(r60, "", false, new b(r62));
        Object r63 = r62.B();
        if (r63 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L96;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L96:
        if (r63 != r4) goto L98;
        return r4;
    L98:
        r33 = r38;
        r31 = r58;
        r111 = r42;
        r32 = r43;
        wc9.e r130 = r115;
        r110 = r41;
        r34 = r130;
        goto L99
    L100:
        r22 = r38;
        r21 = r43;
        r111 = r42;
        r8 = r58;
        wc9.e r131 = r115;
        r110 = r41;
        r34 = r131;
        goto L101
    L88:
        if (r38.length() == 0) goto L91;
        r59 = false;
    L52:
        r49 = CollectionsKt.emptyList();
        goto L53
    L48:
        r138 = r118;
        goto L49
    L45:
        r118 = null;
        goto L46
    L42:
        r48 = null;
        goto L43
    L38:
        r117 = r116;
        goto L39
    L71:
        r12 = "true";
        LocalSubConvHelper r64 = LocalSubConvHelper.a;
        Intrinsics.checkNotNullParameter(r42, "msgList");
        Intrinsics.checkNotNullParameter("local", "convId");
        ArrayList r65 = new ArrayList();
        r42.size();
        Iterator r66 = r42.iterator();
        int r124 = 0;
    L73:
        if (r66.hasNext() == false) goto L84;
        Object r125 = r66.next();
        int r126 = r124 + 1;
        if (r124 >= 0) goto L77;
        CollectionsKt.throwIndexOverflow();
    L77:
        Message r127 = (Message) r125;
        IMMsgExt r128 = new IMMsgExt();
        Map r129 = r127.getExt();
        if (r129 == null) goto L80;
        r128.putAll(r129);
    L80:
        String r139 = r127.getMessageId();
        if (r139 != null) goto L83;
        r139 = "";
    L83:
        r128.setSourceMessageId(r139);
        int r140 = wf9.b.a;
        String r310 = com.flow.kmp.common.util.i.a();
        r65.add(Message.copy$default(r127, "local", null, null, 0, 0, null, 0, false, null, null, null, null, null, r128, r310, r310, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000), null, null, null, -57346, 29, null));
        r124 = r126;
        goto L73
    L84:
        r56 = CollectionsKt.reversed(r65);
        goto L85
    L20:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = r132;
        r2.L$1 = r133;
        r42 = r134;
        r2.L$2 = r42;
        r41 = r135;
        r2.L$3 = r41;
        r2.L$4 = r136;
        r2.label = 1;
        kotlinx.coroutines.j r141 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r141.C();
        BotServiceImpl r142 = com.larus.im.d.a();
        if (r132 != null) goto L23;
        String r143 = "";
    L24:
        com.larus.im.service.o.a.a(r142, r143, false, "sub", new c(r141), 8);
        Object r67 = r141.B();
        if (r67 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L27:
        if (r67 != r4) goto L29;
        return r4;
    L29:
        r116 = r132;
        r38 = r136;
        r115 = r133;
        r1 = r67;
        goto L30
    L23:
        r143 = r132;
    L7:
        r2 = new ChatRouterHelper$createLocalBotSubConv$1(this, r137);
        goto L8
    }

    public static final Object a(ChatRouterHelper r9, Bundle r10, String r11, wc9.e r12, List r13, String r14, Continuation r15) {
        r9.getClass();
        if ((r15 instanceof ChatRouterHelper$appendLocalSubConversationBundle$1) == false) goto L7;
        ChatRouterHelper$appendLocalSubConversationBundle$1 r0 = (ChatRouterHelper$appendLocalSubConversationBundle$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ChatRouterHelper$appendLocalSubConversationBundle$1 r6 = r0;
        Object r16 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (Bundle) r6.L$0;
        ResultKt.throwOnFailure(r16);
    L20:
        wc9.e r17 = (wc9.e) r16;
        String r18 = null;
        if (r17 == null) goto L23;
        String r19 = r17.a;
    L25:
        if (r19 != null) goto L27;
    L30:
        boolean r110 = true;
    L32:
        if (r110 == false) goto L34;
        FLogger.a.e("ChatRouterHelper", "appendLocalSubConversationBundle failed, local conversation is null");
        return Boxing.boxBoolean(false);
    L34:
        r10.putBoolean("is_create_sub_conversation", true);
        if (r17 == null) goto L37;
        r18 = r17.a;
    L37:
        r10.putString("argConversationId", r18);
        boolean r20 = z2.a.subConvKeyboardConfig().a();
        FLogger.a.i("ChatRouterHelper", "[shouldAutoLaunchKeyboardOnCreateSub] showKeyboardOnCreate:" + r20);
        if (r20 == false) goto L41;
        r10.putBoolean("arg_need_to_show_ime", true);
    L41:
        return Boxing.boxBoolean(true);
    L27:
        if (r19.length() == 0) goto L30;
        r110 = false;
        goto L32
    L23:
        r19 = null;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        if (r11 != null) goto L17;
        r11 = "";
    L17:
        r6.L$0 = r10;
        r6.label = 1;
        r16 = e(r9, r11, r12, r13, r14, r6, 16);
        if (r16 != r2) goto L20;
        return r2;
    L7:
        r0 = new ChatRouterHelper$appendLocalSubConversationBundle$1(r9, r15);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object e(ChatRouterHelper r7, String r8, wc9.e r9, List r10, String r11, ContinuationImpl r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        List r3 = r10;
        if ((r13 & 8) == 0) goto L9;
        r11 = null;
    L9:
        return r7.d(r8, r9, r3, r11, null, r12);
    }

    public static Object g(String r22, wc9.e r23, String r24, String r25, String r26, List r27, boolean r28, boolean r29, by7.e r30, ChatPassThroughParams r31, Bundle r32, Continuation r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r34 & 2) == 0) goto L9;
        wc9.e r15 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r3 = "";
    L23:
        if ((r34 & 64) == 0) goto L25;
        List r18 = CollectionsKt.emptyList();
    L27:
        if ((r34 & 128) == 0) goto L29;
        String r7 = "";
    L31:
        if ((r34 & 256) == 0) goto L33;
        String r8 = "";
    L35:
        if ((r34 & 512) == 0) goto L37;
        String r9 = "";
    L39:
        if ((r34 & 1024) == 0) goto L41;
        String r10 = "";
    L42:
        boolean r19 = false;
        if ((r34 & 4096) == 0) goto L45;
        boolean r2 = false;
    L47:
        if ((r34 & 8192) == 0) goto L49;
        boolean r14 = false;
    L51:
        if ((131072 & r34) == 0) goto L53;
        ChatPassThroughParams r20 = null;
    L55:
        if ((r34 & 262144) == 0) goto L57;
        Bundle r0 = null;
    L58:
        boolean r21 = r14;
        wc9.e r210 = r15;
        Bundle r5 = f(r3, r4, r1, r6, r7, r8, r9, r10, null, false, null, r30, null, r20);
        b(r5, r0);
        if (z2.a.isSubConvCreateOptEnable() == false) goto L74;
        if (r2 == false) goto L74;
        if (i() == true) goto L77;
        if (r0 == null) goto L72;
        String r11 = r0.getString("project_id");
        if (r11 == null) goto L72;
        if (r11.length() <= 0) goto L70;
        r19 = true;
    L70:
        if (r19 == false) goto L72;
    L76:
        return BuildersKt.withContext(Dispatchers.getIO(), new ChatRouterHelper$getSubConversationFragmentBundle$2(r5, r1, r210, r18, r11, null), r33);
    L72:
        r11 = null;
        goto L76
    L77:
        return null;
    L74:
        c(r5, r210, r21);
        return r5;
    L57:
        r0 = r32;
        goto L58
    L53:
        r20 = r31;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r2 = r28;
        goto L47
    L41:
        r10 = null;
        goto L42
    L37:
        r9 = null;
        goto L39
    L33:
        r8 = null;
        goto L35
    L29:
        r7 = null;
        goto L31
    L25:
        r18 = r27;
        goto L27
    L21:
        r3 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r15 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }

    public static Bundle f(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, Boolean r10, boolean r11, String r12, by7.e r13, ICoreInputAbility.OnSendParams r14, ChatPassThroughParams r15) {
        boolean r1 = false;
        Bundle r16 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r2), TuplesKt.to("message_id", r3), TuplesKt.to("argBotId", r4), TuplesKt.to("enter_method", r5), TuplesKt.to("create_sub_conv_collection_id", r6), TuplesKt.to("create_sub_conv_case_id", r7), TuplesKt.to("create_sub_conv_case_name", r8), TuplesKt.to("create_sub_conv_case_request_id", r9), TuplesKt.to("argBotConversationType", 3)});
        if (r10 == null) goto L5;
        r16.putBoolean("is_need_fixed_bottom_tab", r10.booleanValue());
    L5:
        if (r11 == false) goto L7;
        r16.putString("ignore_side_bar", "1");
    L7:
        if (r12 == null) goto L9;
        r16.putString("argBotCaseFrom", r12);
    L9:
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("[createSubConversationBundle] autoSendParams routed = ");
        if (r14 == null) goto L12;
        boolean r19 = true;
    L13:
        r18.append(r19);
        r18.append(", contentEmpty = ");
        String r20 = null;
        if (r14 == null) goto L16;
        String r21 = r14.getContent();
    L17:
        if (r21 != null) goto L19;
    L20:
        r1 = true;
    L21:
        r18.append(r1);
        r18.append(", scene = ");
        if (r14 == null) goto L24;
        String r22 = r14.getScene();
    L25:
        r18.append(r22);
        r18.append(", enterMethod = ");
        if (r14 == null) goto L28;
        r20 = r14.getEnterMethod();
    L28:
        r18.append(r20);
        r17.i("ChatRouterHelper", r18.toString());
        if (r14 == null) goto L31;
        r16.putSerializable("auto_send_message_params", r14);
    L31:
        ic8.k.b(r16, r15);
        if (r13 == null) goto L34;
        by7.h.k(r16, r13);
    L34:
        return r16;
    L24:
        r22 = null;
        goto L25
    L19:
        if (r21.length() != 0) goto L21;
    L16:
        r21 = null;
        goto L17
    L12:
        r19 = false;
        goto L13
    }

    public static void h(Context r25, String r26, wc9.e r27, String r28, String r29, String r30, String r31, List r32, String r33, String r34, String r35, String r36, Boolean r37, boolean r38, boolean r39, boolean r40, boolean r41, by7.e r42, ICoreInputAbility.OnSendParams r43, ChatPassThroughParams r44, Bundle r45, String r46, boolean r47, ForkConversationRequest r48, Function1 r49, int r50) {
        String r3 = "";
        if ((r50 & 2) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r50 & 4) == 0) goto L9;
        wc9.e r4 = null;
    L11:
        if ((r50 & 8) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r50 & 16) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r50 & 32) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r50 & 64) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r50 & 128) == 0) goto L29;
        List r10 = CollectionsKt.emptyList();
    L31:
        if ((r50 & 256) == 0) goto L33;
        String r11 = "";
    L35:
        if ((r50 & 512) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r50 & 1024) == 0) goto L41;
        String r13 = "";
    L43:
        if ((r50 & 2048) != 0) goto L47;
        r3 = r36;
    L47:
        if ((r50 & 4096) == 0) goto L49;
        Boolean r14 = null;
    L51:
        if ((r50 & 8192) == 0) goto L53;
        boolean r15 = false;
    L55:
        if ((r50 & 16384) == 0) goto L57;
        boolean r5 = false;
    L59:
        if ((r50 & 32768) == 0) goto L61;
        boolean r16 = false;
    L62:
        boolean r18 = r15;
        if ((r50 & 65536) == 0) goto L65;
        boolean r19 = true;
    L67:
        if ((r50 & 262144) == 0) goto L69;
        ICoreInputAbility.OnSendParams r17 = null;
    L71:
        if ((r50 & 524288) == 0) goto L73;
        ChatPassThroughParams r20 = null;
    L75:
        if ((r50 & 1048576) == 0) goto L77;
        Bundle r110 = null;
    L79:
        if ((r50 & 2097152) == 0) goto L81;
        String r21 = null;
    L83:
        if ((r50 & 4194304) == 0) goto L85;
        boolean r22 = false;
    L87:
        if ((r50 & 8388608) == 0) goto L89;
        ForkConversationRequest r23 = null;
    L91:
        if ((r50 & 16777216) == 0) goto L93;
        Function1 r1 = null;
    L94:
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r10, "msgList");
        Bundle r24 = f(r8, r6, r2, r7, r11, r12, r13, r3, r14, r16, r9, r42, r17, r20);
        b(r24, r110);
        if (r21 != null) goto L97;
    L105:
        if (r23 != null) goto L107;
        boolean r51 = false;
        z2 r52 = z2.a;
        if (r52.enableChatWithTab() == false) goto L113;
        String r53 = "//flow/chat_page";
    L114:
        com.bytedance.router.i r0 = SmartRouter.buildRoute(r25, r53);
        r0.c.addFlags(67108864);
        r0.c.putExtras(r24);
        if (com.larus.platform.exp.o.a() == false) goto L145;
        if (r7 == null) goto L141;
        int r54 = r7.hashCode();
        if (r54 == (-746764762)) goto L132;
        if (r54 == (-597906643)) goto L129;
        if (r54 != 2118094476) goto L141;
        if (r7.equals("cron_job") == false) goto L141;
        wc9.e r55 = r4;
    L140:
        boolean r56 = true;
    L143:
        if (r56 == false) goto L146;
        boolean r57 = true;
    L147:
        if (r57 == false) goto L149;
    L153:
        boolean r58 = true;
    L154:
        if (r22 == false) goto L160;
        r24.putBoolean("is_create_sub_conversation", true);
        if (r55 == null) goto L158;
        String r59 = r55.a;
    L159:
        r24.putString("argConversationId", r59);
        r24.putBoolean("arg_need_to_show_ime", r19);
        r0.c.putExtras(r24);
        r0.d();
        return;
    L158:
        r59 = null;
        goto L159
    L160:
        boolean r60 = r19;
        if (r58 == true) goto L163;
        c(r24, r55, r60);
        r0.g(r24);
        if (r18 == false) goto L179;
        r0.d = 2130772399;
        r0.e = 2130772399;
        r0.d();
        return;
    L179:
        r0.d();
        return;
    L163:
        if (i() == true) goto L186;
        if (r21 != null) goto L175;
        if (r110 == null) goto L174;
        String r61 = r110.getString("project_id");
        if (r61 == null) goto L174;
        if (r61.length() <= 0) goto L172;
        r51 = true;
    L172:
        if (r51 == false) goto L174;
        r21 = r61;
    L174:
        r21 = null;
    L175:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatRouterHelper$gotoSubConversation$4(r24, r2, r55, r10, r21, r57, r60, r0, r18, null), 2, null);
        return;
    L186:
        return;
    L149:
        if (r52.isSubConvCreateOptEnable() == false) goto L152;
        if (r5 == true) goto L153;
    L152:
        r58 = false;
    L146:
        r57 = false;
        goto L147
    L129:
        if (r7.equals("sidebar_quick_chat") == false) goto L141;
    L134:
        if (r4 == 0) goto L136;
        r55 = r4;
        String r62 = r55.a;
    L137:
        if (r62 == null) goto L140;
        if (StringsKt.isBlank(r62) == true) goto L140;
    L142:
        r56 = false;
        goto L143
    L136:
        r55 = r4;
        r62 = null;
        goto L137
    L132:
        if (r7.equals("sidebar_new_office_task") == true) goto L134;
    L141:
        r55 = r4;
        goto L142
    L145:
        r55 = r4;
        goto L146
    L113:
        r53 = "//flow/chat_page_bridge";
        goto L114
    L107:
        if (z2.a.J3() == true) goto L109;
        FLogger.a.d("ChatRouterHelper", "conversation fork request blocked: settings disabled");
        t19.s.a.getClass();
        t19.s.b(r25, 2131905626, false);
        return;
    L109:
        com.larus.im.d.d().forkConversation(r23, new d(r25, r1, r24, r23));
        return;
    L97:
        if (r21.length() <= 0) goto L99;
        boolean r63 = true;
    L100:
        if (r63 == false) goto L102;
        String r64 = r21;
    L103:
        if (r64 == null) goto L105;
        r24.putString("project_id", r64);
        goto L105
    L102:
        r64 = null;
        goto L103
    L99:
        r63 = false;
        goto L100
    L93:
        r1 = r49;
        goto L94
    L89:
        r23 = r48;
        goto L91
    L85:
        r22 = r47;
        goto L87
    L81:
        r21 = r46;
        goto L83
    L77:
        r110 = r45;
        goto L79
    L73:
        r20 = r44;
        goto L75
    L69:
        r17 = r43;
        goto L71
    L65:
        r19 = r41;
        goto L67
    L61:
        r16 = r40;
        goto L62
    L57:
        r5 = r39;
        goto L59
    L53:
        r15 = r38;
        goto L55
    L49:
        r14 = r37;
        goto L51
    L41:
        r13 = r35;
        goto L43
    L37:
        r12 = r34;
        goto L39
    L33:
        r11 = r33;
        goto L35
    L29:
        r10 = r32;
        goto L31
    L25:
        r9 = r31;
        goto L27
    L21:
        r8 = r30;
        goto L23
    L17:
        r7 = r29;
        goto L19
    L13:
        r6 = r28;
        goto L15
    L9:
        r4 = r27;
        goto L11
    L5:
        r2 = r26;
        goto L7
    }
}
