package com.larus.bmhome.chat.model.strategy;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.common.utility.NetworkUtils;
import com.google.gson.Gson;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import wa8.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatSendUtils {
    public static final ChatSendUtils a = null;
    public static final CoroutineScope b = null;
    public static final AtomicBoolean c = null;
    public static volatile a d;
    public static final Lazy e = null;
    public static final Set<String> f = null;

    public static final class a {
        public final String a;
        public final long b;
        public final String c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            long r3 = this.b;
            int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            String r5 = this.c;
            if (r5 == null) goto L11;
            r1 = r5.hashCode();
        L11:
            return r4 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ClientSystemPermissionSnapshot(clientSystemPermission=" + this.a + ", createdAt=" + this.b + ", localMessageId=" + this.c + ')';
        }

        public final boolean a(String r12) {
            String r0 = this.c;
            if (r0 != null) goto L5;
            Lazy r13 = com.larus.platform.exp.s.a;
            long r5 = com.larus.platform.exp.s.g;
            long r7 = SystemClock.elapsedRealtime() - this.b;
            if (0 <= r7) goto L17;
        L19:
            return false;
        L17:
            if (r7 > r5) goto L19;
            return true;
        L5:
            if (Intrinsics.areEqual(r0, r12) == false) goto L19;
            Lazy r14 = com.larus.platform.exp.s.a;
            long r6 = com.larus.platform.exp.s.h;
            long r8 = SystemClock.elapsedRealtime() - this.b;
            if (0 <= r8) goto L9;
        L11:
            boolean r15 = false;
        L12:
            if (r15 == false) goto L19;
            return true;
        L9:
            if (r8 > r6) goto L11;
            r15 = true;
            goto L12
        }

        public a(String r1, long r2, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    public ChatSendUtils() {
    }

    static {
        a = new ChatSendUtils();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new AtomicBoolean(false);
        e = LazyKt.lazy(new f0());
        f = SetsKt.setOf(new String[]{"reference_text", "page_task_info", "doc_ref_block_info", "office_sheet_ref_block_info", "office_ref_block_info", "conversation_init_option", "artifact_block"});
    }

    public static Gson n() {
        return (Gson) e.getValue();
    }

    public static void t() {
        AppHost.Companion r0 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r0.getApplication()) == true) goto L6;
        t19.s r1 = t19.s.a;
        Application r2 = r0.getApplication();
        r1.getClass();
        t19.s.s(r2, 2131908080);
        return;
    }

    public static void b(Map r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TypeIntrinsics.isMutableMap(r2) == false) goto L17;
        ICommerceCreditService.a.getClass();
        ICommerceCreditService r0 = ICommerceCreditService.a.a();
        if (r0 == null) goto L10;
        boolean r1 = true;
        if (r0.k() != true) goto L10;
    L11:
        if (r1 == false) goto L13;
        String r3 = "1";
    L14:
        r2.put("commerce_credit_config_enable", r3);
        return;
    L13:
        r3 = "0";
    L10:
        r1 = false;
        goto L11
    }

    public static Map g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 == null) goto L5;
        String r1 = r0.W();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        LocalSubConvHelper r2 = LocalSubConvHelper.a;
        if (LocalSubConvHelper.e(r3, r1) == true) goto L11;
        return null;
    L11:
        return LocalSubConvHelper.d(r3);
    L5:
        r1 = null;
        goto L6
    }

    public static Map j(List r5) {
        Intrinsics.checkNotNullParameter(r5, "answers");
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L3:
        Pair r2 = null;
        if (r6.hasNext() == false) goto L33;
        Message r1 = (Message) r6.next();
        String r3 = r1.getMessageId();
        if (r3 != null) goto L8;
    L13:
        r3 = r1.getLocalMessageId();
        if (r3 != null) goto L16;
    L18:
        r3 = null;
    L19:
        Map r4 = r1.getExt();
        if (r4 == null) goto L26;
        String r7 = (String) r4.get("suffix_active_delete_message_id_list");
        if (r7 == null) goto L26;
        if ((!StringsKt.isBlank(r7)) == false) goto L26;
    L27:
        if (r3 == null) goto L31;
        if (r7 == null) goto L31;
        r2 = TuplesKt.to(r3, r7);
    L31:
        if (r2 == null) goto L3;
        r0.add(r2);
    L26:
        r7 = null;
        goto L27
    L16:
        if ((!StringsKt.isBlank(r3)) == false) goto L18;
    L8:
        if ((!StringsKt.isBlank(r3)) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
    L33:
        Map r8 = MapsKt.toMap(r0);
        if ((!r8.isEmpty()) == true) goto L36;
        return null;
    L36:
        return r8;
    }

    public static ClientControllerParam k(BotModel r5) {
        UserSettingCacheManager.a.getClass();
        boolean r0 = UserSettingCacheManager.a();
        String r1 = null;
        if (r5 == null) goto L7;
        SpeakerVoice r2 = r5.getVoiceType();
        if (r2 == null) goto L7;
        String r3 = r2.getId();
    L8:
        if (r5 == null) goto L16;
        String r4 = r5.getCallerName();
        if (r4 == null) goto L16;
        if ((!StringsKt.isBlank(r4)) == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L16;
    L17:
        if (r5 == null) goto L22;
        SpeakerVoice r6 = r5.getVoiceType();
        if (r6 == null) goto L22;
        r1 = r6.getLanguageCode();
    L22:
        return new ClientControllerParam(r0, r1, r3, r4);
    L16:
        r4 = AccountService.a.getNickname();
    L7:
        r3 = null;
        goto L8
    }

    public static boolean o(BotModel r2) {
        if (z2.a.chatImmerseEnable() == false) goto L22;
        if (r2 == null) goto L6;
        boolean r0 = r2.getBgImgOpen();
    L7:
        if (r0 == false) goto L23;
        if (r2 == null) goto L12;
        String r1 = r2.getBgImgUrl();
        if (r1 == null) goto L12;
        boolean r3 = o0.d(r1);
    L13:
        if (r3 == false) goto L24;
        if (r2 == null) goto L18;
        String r4 = r2.getBgImgColor();
        if (r4 == null) goto L18;
        boolean r5 = o0.d(r4);
    L19:
        if (r5 == false) goto L25;
        return true;
    L25:
        return false;
    L18:
        r5 = false;
        goto L19
    L24:
        return false;
    L12:
        r3 = false;
        goto L13
    L23:
        return false;
    L6:
        r0 = false;
        goto L7
    L22:
        return false;
    }

    public static Map p(Pair... r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        HashMap r4 = MapsKt.hashMapOf((Pair[]) Arrays.copyOf(r3, r3.length));
        UserSettingCacheManager.a.getClass();
        r4.put("wiki", UserSettingCacheManager.f());
        RepoDispatcher.a.getClass();
        r4.put("search_engine_type", String.valueOf(RepoDispatcher.e.K()));
        r4.put("answer_with_suggest", String.valueOf(UserSettingCacheManager.a() ? 1 : 0));
        r4.put("media_search_type", String.valueOf(UserSettingCacheManager.b()));
        if (AudioServiceDelegate.a.g() == false) goto L5;
        String r0 = "2";
    L6:
        r4.put("record_status", r0);
        AppHost.Companion r1 = AppHost.a;
        r4.put("create_time_ms", String.valueOf(r1.getAppClock().currentTimeMillis()));
        if (r1.isOversea() == false) goto L9;
        AppLocaleUtils.a.getClass();
        Locale r2 = AppLocaleUtils.c();
    L10:
        String r5 = com.larus.utils.b0.a;
        r4.put("system_language", com.larus.utils.b0.e(r2.getLanguage()));
        return r4;
    L9:
        r2 = Locale.CHINA;
        goto L10
    L5:
        r0 = "1";
        goto L6
    }

    public static Map i(wc9.e r6, ic8.w r7) {
        Intrinsics.checkNotNullParameter(r6, "conversation");
        Intrinsics.checkNotNullParameter(r7, "strategy");
        m58.y r0 = m58.y.a;
        m58.b r1 = m58.h.k;
        String r2 = null;
        if (r1 == null) goto L5;
        Application r3 = r1.getApplication();
    L6:
        Integer r4 = r0.b(r3);
        boolean r5 = false;
        if (r4 == null) goto L9;
        int r8 = r4.intValue();
    L11:
        if (r8 != 0) goto L14;
    L16:
        String r9 = "0";
    L17:
        Map r10 = p(new Pair[]{TuplesKt.to("tts", r9), TuplesKt.to("source_from_asr", "1")});
        if (TypeIntrinsics.isMutableMap(r10) == false) goto L128;
        Map<String, String> r11 = r7.a();
        if (r11 == null) goto L30;
        String r12 = r11.get("asr_log_id");
        if (r12 == null) goto L30;
        if ((!StringsKt.isBlank(r12)) == true) goto L27;
        r12 = null;
    L27:
        if (r12 == null) goto L30;
        r10.put("asr_log_id", r12);
    L30:
        if (r11 == null) goto L32;
        String r13 = r11.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
    L33:
        if (r13 != null) goto L35;
    L37:
        boolean r14 = false;
    L38:
        if (r14 == false) goto L41;
        r10.put(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION, r13);
    L41:
        if (r11 == null) goto L43;
        String r15 = r11.get("action_bar_key");
    L44:
        if (r15 != null) goto L46;
    L48:
        if (r5 == false) goto L51;
        r10.put("action_bar_key", r15);
    L51:
        if (r11 == null) goto L53;
        String r16 = r11.get("select_text_action");
    L54:
        if (r16 == null) goto L57;
        r10.put("select_text_action", r16);
    L57:
        if (r11 == null) goto L59;
        String r17 = r11.get("sec_scene");
    L60:
        if (r17 == null) goto L63;
        r10.put("sec_scene", r17);
    L63:
        if (r11 == null) goto L65;
        String r18 = r11.get("edu_multi_answers_msg_id");
    L66:
        if (r18 == null) goto L69;
        r10.put("edu_multi_answers_msg_id", r18);
    L69:
        if (r11 == null) goto L71;
        String r19 = r11.get("from_text_click");
    L72:
        if (r19 == null) goto L75;
        r10.put("from_text_click", r19);
    L75:
        if (r11 == null) goto L77;
        r2 = r11.get("Copilot:hippo:hippo_ext");
    L77:
        if (r2 == null) goto L79;
        r10.put("Copilot:hippo:hippo_ext", r2);
    L79:
        if (r11 == null) goto L83;
        String r20 = r11.get("deep_research_phase");
        if (r20 == null) goto L83;
        r10.put("deep_research_phase", r20);
    L83:
        if (r11 == null) goto L87;
        String r21 = r11.get("deep_research_id");
        if (r21 == null) goto L87;
        r10.put("deep_research_id", r21);
    L87:
        if (r11 == null) goto L91;
        String r22 = r11.get("audio_data_tos_uri");
        if (r22 == null) goto L91;
        r10.put("audio_data_tos_uri", r22);
    L91:
        if (r11 == null) goto L95;
        String r23 = r11.get("audio_event_resp");
        if (r23 == null) goto L95;
        r10.put("audio_event_resp", r23);
    L95:
        if (r11 == null) goto L99;
        String r24 = r11.get("gen_music_create_type");
        if (r24 == null) goto L99;
        r10.put("gen_music_create_type", r24);
    L99:
        if (r11 == null) goto L103;
        String r25 = r11.get("task_skill_local_temp_selected_skills");
        if (r25 == null) goto L103;
        r10.put("task_skill_local_temp_selected_skills", r25);
    L103:
        if (r11 == null) goto L107;
        String r26 = r11.get("task_skill_local_temp_runtime_type");
        if (r26 == null) goto L107;
        r10.put("task_skill_local_temp_runtime_type", r26);
    L107:
        if (r11 == null) goto L111;
        String r27 = r11.get("o_omni_init_skill_ids");
        if (r27 == null) goto L111;
        r10.put("o_omni_init_skill_ids", r27);
    L111:
        if (r11 == null) goto L115;
        String r28 = r11.get("o_omni_skill_final_query");
        if (r28 == null) goto L115;
        r10.put("o_omni_skill_final_query", r28);
    L115:
        if (r11 == null) goto L119;
        String r29 = r11.get("o_omni_enable_skill");
        if (r29 == null) goto L119;
        r10.put("o_omni_enable_skill", r29);
    L119:
        ObricActionBarSendServiceDelegate.b.d(r11, r10);
        if (r11 == null) goto L128;
        Iterator<T> r30 = f.iterator();
    L124:
        if (r30.hasNext() == false) goto L128;
        String r31 = (String) r30.next();
        String r32 = r11.get(r31);
        if (r32 == null) goto L124;
        r10.putIfAbsent(r31, r32);
        goto L124
    L71:
        r19 = null;
        goto L72
    L65:
        r18 = null;
        goto L66
    L59:
        r17 = null;
        goto L60
    L53:
        r16 = null;
        goto L54
    L46:
        if (o0.d(r15) != true) goto L48;
        r5 = true;
        goto L48
    L43:
        r15 = null;
        goto L44
    L35:
        if (o0.d(r13) != true) goto L37;
        r14 = true;
        goto L38
    L32:
        r13 = null;
    L128:
        return r10;
    L14:
        if (r6.i == false) goto L16;
        r9 = "1";
        goto L17
    L9:
        r8 = 0;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public final Object f(yc9.f0 r24, Continuation<? super yc9.f0> r25) {
        if ((r25 instanceof ChatSendUtils$appendExtWhenIsLocalCoCoConv$1) == false) goto L7;
        ChatSendUtils$appendExtWhenIsLocalCoCoConv$1 r1 = (ChatSendUtils$appendExtWhenIsLocalCoCoConv$1) r25;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        String r5 = null;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        yc9.f0 r6 = (yc9.f0) r1.L$0;
        ResultKt.throwOnFailure(r0);
        yc9.f0 r7 = r6;
    L24:
        BotModel r8 = (BotModel) r0;
        Map r9 = r7.r;
        if (r9 == null) goto L28;
        Map r10 = MapsKt.toMutableMap(r9);
        if (r10 == null) goto L28;
    L29:
        Map r15 = r10;
        LocalSubConvHelper r11 = LocalSubConvHelper.a;
        String r12 = r7.a;
        if (r8 == null) goto L33;
        r5 = r8.getBotId();
    L33:
        if (LocalSubConvHelper.e(r12, r5) == false) goto L36;
        r15.putAll(LocalSubConvHelper.d(r7.a));
    L36:
        return yc9.f0.a(r7, null, null, null, 0, null, null, null, 0, r15, null, null, null, null, null, null, 536739839);
    L28:
        r10 = MapsKt.toMutableMap(MapsKt.emptyMap());
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        wc9.e r13 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r13 == null) goto L17;
        String r14 = r13.a;
    L18:
        if (r14 != null) goto L20;
        r14 = "";
    L20:
        RepoDispatcher.a.getClass();
        BotRepo r16 = RepoDispatcher.g;
        r1.L$0 = r24;
        r1.label = 1;
        r0 = r16.j1(r14, false, r1);
        if (r0 != r3) goto L23;
        return r3;
    L23:
        r7 = r24;
        goto L24
    L17:
        r14 = null;
    L7:
        r1 = new ChatSendUtils$appendExtWhenIsLocalCoCoConv$1(this, r25);
        goto L8
    }

    public final Object l(String r10, Continuation<? super Pair<String, String>> r11) {
        if ((r11 instanceof ChatSendUtils$getLocalCvsUplinkMeta$1) == false) goto L7;
        ChatSendUtils$getLocalCvsUplinkMeta$1 r0 = (ChatSendUtils$getLocalCvsUplinkMeta$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        return TuplesKt.to(r10, CollectionsKt.joinToString$default((Iterable) r12, null, null, null, 0, null, new c0(), 31, null));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        if (com.larus.im.j.f(r10) == false) goto L24;
        String r13 = com.larus.im.j.b(r10);
        if (r13 != null) goto L19;
        r13 = "";
    L19:
        r0.L$0 = r10;
        r0.label = 1;
        r12 = com.larus.im.j.d(r13, r0);
        if (r12 != r2) goto L25;
        return r2;
    L24:
        return TuplesKt.to(null, null);
    L7:
        r0 = new ChatSendUtils$getLocalCvsUplinkMeta$1(this, r11);
        goto L8
    }

    public final Object r(Message r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof ChatSendUtils$resetFileParseByCollectionID$1) == false) goto L7;
        ChatSendUtils$resetFileParseByCollectionID$1 r0 = (ChatSendUtils$resetFileParseByCollectionID$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        List r8 = (List) r7;
        if (r8.size() <= 1) goto L31;
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L31;
        final Message r10 = (Message) r9.next();
        if (lr8.c.a(r10) == false) goto L21;
        String r4 = (String) l0.a(null, new d0(r10));
        if (r4 == null) goto L21;
        RepoDispatcher.a.getClass();
        ChatRepo r11 = RepoDispatcher.d;
        String r12 = r10.getMessageId();
        if (r12 != null) goto L29;
        r12 = "";
    L29:
        r11.J1(r12, r4, null);
    L31:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        RepoDispatcher.a.getClass();
        ChatRepo r13 = RepoDispatcher.d;
        r0.label = 1;
        r7 = r13.s1(r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSendUtils$resetFileParseByCollectionID$1(this, r6);
        goto L8
    }

    public final Object s(String r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof ChatSendUtils$resetFileParseByMessageID$1) == false) goto L7;
        ChatSendUtils$resetFileParseByMessageID$1 r0 = (ChatSendUtils$resetFileParseByMessageID$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        final Message r8 = (Message) r7;
        if (r8 != null) goto L20;
    L22:
        r4 = false;
    L23:
        if (r4 == false) goto L31;
        String r9 = (String) l0.a(null, new e0(r8));
        if (r9 == null) goto L31;
        RepoDispatcher.a.getClass();
        ChatRepo r10 = RepoDispatcher.d;
        String r11 = r8.getMessageId();
        if (r11 != null) goto L29;
        r11 = "";
    L29:
        r10.J1(r11, r9, null);
    L31:
        return Unit.INSTANCE;
    L20:
        if (lr8.c.a(r8) != true) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        RepoDispatcher.a.getClass();
        ChatRepo r12 = RepoDispatcher.d;
        r0.label = 1;
        r7 = r12.E1(r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSendUtils$resetFileParseByMessageID$1(this, r6);
        goto L8
    }

    public static void d(String r1, String r2, Map r3) {
        if (r1 == null) goto L4;
        String r4 = ChatControlTrace.b.Ia(r1);
    L6:
        if (r4.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        if (r2 == null) goto L12;
        r4 = ChatControlTrace.b.Ia(r2);
    L12:
        if (r3 != null) goto L14;
        return;
    L14:
        if (TypeIntrinsics.isMutableMap(r3) == false) goto L18;
        r3.put("send_message_scene", r4);
        return;
    L18:
        return;
    L8:
        r0 = false;
        goto L9
    L4:
        r4 = "";
        goto L6
    }

    public static /* synthetic */ void e(ChatSendUtils r0, String r1, Map r2) {
        r0.getClass();
        d(r1, null, r2);
    }

    public static void h(Map r3, wc9.e r4, IMessageExtService.a r5) {
        Intrinsics.checkNotNullParameter(r3, "ext");
        Intrinsics.checkNotNullParameter(r4, "conversation");
        Intrinsics.checkNotNullParameter(r5, "queryData");
        Iterator r0 = ServiceManager.get().getServices(IMessageExtService.class, true).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IMessageExtService) r0.next()).a(r3, r4, r5);
        goto L4
    }

    public static void q(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        if (com.larus.platform.exp.s.b == true) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("start preloadAppletPayload, cacheValid=");
        a r2 = d;
        if (r2 == null) goto L8;
        Boolean r3 = Boolean.valueOf(r2.a(r12));
    L9:
        r1.append(r3);
        r0.d("SendMsgPerf", r1.toString());
        AtomicBoolean r4 = c;
        boolean r5 = true;
        if (r4.compareAndSet(false, true) == true) goto L12;
        return;
    L12:
        a r6 = d;
        if (r6 != null) goto L15;
    L17:
        r5 = false;
    L18:
        if (r5 == false) goto L24;
        if (r12 != null) goto L21;
    L22:
        r4.set(false);
        return;
    L21:
        if (r6.c != null) goto L22;
    L24:
        d = null;
        BuildersKt.launch$default(b, null, null, new ChatSendUtils$preloadAppletPayload$1(r10, r11, r12, null), 3, null);
        return;
    L15:
        if (r6.a(r12) != true) goto L17;
    L8:
        r3 = null;
        goto L9
    }

    public static void a(String r4, String r5, String r6, Map r7) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r7, "ext");
        a r0 = d;
        if (com.larus.platform.exp.s.b == false) goto L16;
        if (r0 == null) goto L8;
        boolean r3 = true;
        if (r0.a(r6) != true) goto L8;
    L9:
        if (r3 == false) goto L16;
        FLogger.a.i("SendMsgPerf", "use clientSystemPermission");
        if (r0.c != null) goto L13;
    L15:
        String r8 = r0.a;
    L17:
        if (r8 == null) goto L20;
        r7.put("client_system_permission", r8);
        return;
    L20:
        return;
    L13:
        if (d != r0) goto L15;
        d = null;
    L8:
        r3 = false;
    L16:
        r8 = (String) ((LinkedHashMap) AppletPayloadProviderDelegate.a.b(r4, r5, r6)).get("client_system_permission");
        goto L17
    }

    public static void c(ic8.w r7, String r8, Map r9, wc9.e r10) {
        Intrinsics.checkNotNullParameter(r7, "strategy");
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r9, "ext");
        Intrinsics.checkNotNullParameter(r10, "conversation");
        ReplyOption r11 = com.larus.bmhome.instruction.c.a.a(r8, ActiveSwitchType.DEEPTHINK.getValue());
        int r0 = r11.getModel().getDeprecatedItemId();
        if (r0 != t0.e.getDeprecatedItemId()) goto L7;
        Object r1 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        if (com.larus.bmhome.view.actionbar.custom.cache.e.c(r11) == AgentMode.MOA.getValue()) goto L7;
        r0 = t0.d.getDeprecatedItemId();
    L7:
        String r2 = null;
        if (r9.containsKey("suggest_extra") == true) goto L91;
    L19:
        Integer r3 = null;
    L20:
        boolean r4 = true;
        if (Intrinsics.areEqual(r9.get("disable_deepthink"), "1") == false) goto L24;
        int r12 = 0;
    L50:
        Object r5 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        if (com.larus.bmhome.view.actionbar.custom.cache.e.c(r11) == AgentMode.MOA.getValue()) goto L53;
    L74:
        r9.put("need_deep_think", String.valueOf(r12));
        Triple r13 = r10.f();
        if (r13 == null) goto L79;
        Pair r14 = (Pair) r13.getFirst();
        if (r14 == null) goto L79;
        r2 = (String) r14.getFirst();
    L79:
        if (r2 != null) goto L81;
    L84:
        if (r4 == false) goto L86;
    L87:
        r9.put("need_conversation_init_ext", "1");
        return;
    L86:
        if (ic8.n.r(r10) == true) goto L87;
        return;
    L81:
        if (r2.length() == 0) goto L84;
        r4 = false;
        goto L84
    L53:
        if (r0 != t0.a.getDeprecatedItemId()) goto L55;
    L56:
        ModelItemIdentity r15 = r11.getModel();
        if (r15 == null) goto L73;
        Object r16 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        monitor-enter(r16);
        b2 r17 = (b2) com.larus.bmhome.view.actionbar.custom.cache.e.b.get(r15);     // Catch: Throwable -> L70
        if (r17 == null) goto L66;
        ModelItemIdentity r18 = r17.b();     // Catch: Throwable -> L70
        if (r18 == null) goto L66;
        Integer r19 = Integer.valueOf(r18.getDeprecatedItemId());     // Catch: Throwable -> L70
    L67:
        monitor-exit(r16);
        if (r19 == null) goto L73;
        r12 = r19.intValue();
    L66:
        r19 = null;
    L70:
        th = move-exception;
        throw th;
    L73:
        r12 = 0;
        goto L74
    L55:
        if (r0 != t0.d.getDeprecatedItemId()) goto L74;
    L24:
        if (Intrinsics.areEqual(r9.get("force_enable_deepthink"), "1") == false) goto L26;
        r12 = 1;
        goto L50
    L26:
        if (r3 == null) goto L29;
        r12 = r3.intValue();
        goto L50
    L29:
        if (ObricActionBarSendServiceDelegate.b.u(r11) == false) goto L32;
        r12 = t0.a.getDeprecatedItemId();
        goto L50
    L32:
        if ((r7 instanceof ai8.h) == false) goto L34;
        ai8.h r20 = (ai8.h) r7;
    L35:
        if (r20 != null) goto L37;
    L39:
        boolean r21 = false;
    L40:
        if (r21 == false) goto L43;
    L49:
        r12 = r0;
        goto L50
    L43:
        if (r9.containsKey("need_deep_think") == false) goto L49;
        String r22 = (String) r9.get("need_deep_think");
        if (r22 == null) goto L49;
        Integer r23 = StringsKt.toIntOrNull(r22);
        if (r23 == null) goto L49;
        r12 = r23.intValue();
        goto L50
    L37:
        if (r20.h != true) goto L39;
        r21 = true;
        goto L40
    L34:
        r20 = null;
        goto L35
    L91:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        a.getClass();     // Catch: Throwable -> L11
        Object r24 = Result.constructor-impl(((PromptContent.SuggestV2Extra) n().fromJson((String) r9.get("suggest_extra"), PromptContent.SuggestV2Extra.class)).getNeedDeepThink());     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r24) == false) goto L16;
        r24 = null;
    L16:
        String r25 = (String) r24;
        if (r25 == null) goto L19;
        r3 = StringsKt.toIntOrNull(r25);
    L11:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static Map m(wc9.e r4, Message r5, Message r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "conversation");
        Intrinsics.checkNotNullParameter(r5, "answer");
        LinkedHashMap r0 = new LinkedHashMap();
        PluginManagerDelegate r1 = PluginManagerDelegate.a;
        String r2 = r5.getConversationId();
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Map r8 = PluginManagerDelegate.p(r2);
        if (r8 == null) goto L8;
        r0.putAll(r8);
    L8:
        if (r6 == null) goto L14;
        Map r9 = r6.getExt();
        if (r9 == null) goto L14;
        String r10 = (String) r9.get("Copilot:hippo:hippo_ext");
        if (r10 == null) goto L14;
        String r11 = (String) r0.put("Copilot:hippo:hippo_ext", r10);
    L14:
        if (r6 == null) goto L20;
        Map r12 = r6.getExt();
        if (r12 == null) goto L20;
        String r13 = (String) r12.get("college_entrance_examination");
        if (r13 == null) goto L20;
        String r14 = (String) r0.put("college_entrance_examination", r13);
    L20:
        com.larus.bmhome.instruction.c r15 = com.larus.bmhome.instruction.c.a;
        String r16 = r5.getSenderId();
        if (r16 == null) goto L24;
        r3 = r16;
    L24:
        r0.put("need_deep_think", String.valueOf(r15.a(r3, ActiveSwitchType.DEEPTHINK.getValue()).getModel().getDeprecatedItemId()));
        if (r7 == null) goto L28;
        String r17 = (String) r0.put("regen_instruction", r7);
    L28:
        if (r6 == null) goto L33;
        Map r18 = r6.getExt();
        if (r18 == null) goto L33;
        String r19 = (String) r18.get("need_deep_think");
        if (r19 == null) goto L33;
    L37:
        if (r19 == null) goto L39;
        String r20 = (String) r0.put("creation_need_deep_think", r19);
    L39:
        Iterator r21 = ServiceManager.get().getServices(IMessageExtService.class, true).iterator();
    L41:
        if (r21.hasNext() == false) goto L43;
        ((IMessageExtService) r21.next()).a(r0, r4, null);
        goto L41
    L43:
        r0.putAll(com.larus.bmhome.chat.model.a0.a());
        return r0;
    L33:
        Map r22 = r5.getExt();
        if (r22 == null) goto L36;
        r19 = (String) r22.get("creation_need_deep_think");
        goto L37
    L36:
        r19 = null;
        goto L37
    }
}
