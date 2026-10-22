package kr8;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.observer.MessageListState;
import com.larus.platform.spi.IAIChatControlTraceService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public static final LruCache<String, Boolean> a = null;
    public static final HashSet<String> b = null;
    public static boolean c;
    public static final a d = null;
    public static final Gson e = null;

    public static final class a implements nf9.b, nf9.d {
        public a() {
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
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

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
            String r4 = r3.getLocalMessageId();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.length() <= 0) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L11;
            r4 = null;
        L11:
            if (r4 == null) goto L15;
            Boolean r6 = q.a.put(r4, Boolean.TRUE);
            return;
        L15:
            return;
        L7:
            r5 = false;
            goto L8
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            q.a(r2);
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            q.a(r2);
        }
    }

    public static final class b implements IIMCallback<Message> {
        public final /* synthetic */ Message a;
        public final /* synthetic */ String b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r33) {
            Message r0 = (Message) r33;
            Intrinsics.checkNotNullParameter(r0, "replyMessage");
            LruCache<String, Boolean> r2 = q.a;
            String r3 = r0.getLocalMessageId();
            if (r3 != null) goto L6;
            r3 = "";
        L6:
            if (Intrinsics.areEqual(r2.get(r3), Boolean.TRUE) == false) goto L172;
            HashSet<String> r4 = q.b;
            String r5 = this.b;
            monitor-enter(r4);
            boolean r6 = r4.add(r5);     // Catch: Throwable -> L150
            monitor-exit(r4);
            if (r6 == false) goto L173;
            String r7 = this.a.getConversationId();
            if (r7 != null) goto L17;
            r7 = "";
        L17:
            IAIChatControlTraceService.Companion r8 = IAIChatControlTraceService.a;
            wc9.e r9 = r8.Qb(r7, new s());
            Message r10 = this.a;
            BotInfoCache r11 = BotInfoCache.INSTANCE;
            String r12 = r11.getBotId(r7);
            int r13 = 0;
            if (r12.length() <= 0) goto L20;
            boolean r14 = true;
        L21:
            if (r14 == true) goto L24;
            r12 = null;
        L24:
            if (r12 != null) goto L26;
            r12 = this.a.getSenderId();
        L26:
            String r15 = r12;
            if (r9 == null) goto L29;
            androidx.collection.LruCache<String, wc9.e> r16 = ko8.a.a;
            String r17 = ko8.a.f(r9.v, r11.getBotType(r7), r11.isOwnBot(r7));
        L30:
            Map r18 = r0.getExt();
            if (r18 == null) goto L33;
            String r19 = (String) r18.get("sec_scene");
        L34:
            androidx.collection.LruCache r20 = r8.kb();
            String r21 = r0.getLocalMessageId();
            if (r21 != null) goto L37;
            r21 = "";
        L37:
            String r22 = (String) r20.get(r21);
            if (r22 != null) goto L47;
            Integer r1 = ic8.j.b(r0);
            if (r1 != null) goto L43;
        L45:
            String r23 = "";
        L46:
            String r24 = r23;
        L48:
            MusicCreationContentList r25 = new MusicCreationContentList(0, MapsKt.sortedMapOf(new Pair[0]));
            if (com.larus.im.bean.message.a.b0(r10) == false) goto L61;
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Iterator r26 = vd9.r.a(r10).iterator();
        L52:
            if (r26.hasNext() == false) goto L59;
            BlockContent r27 = ((Block) r26.next()).getContent();
            if (r27 == null) goto L52;
            MusicCreationContentList r28 = r27.getLyricsToSongsMusicBlock();
            if (r28 == null) goto L52;
            r25 = r28;
            goto L52
        L59:
            if (r25.getTaskNumber() == 0) goto L174;
        L75:
            ArrayList r29 = new ArrayList();
            ArrayList r30 = new ArrayList();
            int r31 = r25.getTaskNumber();
            Map r32 = r25.getContentMap();
            if (r32 == null) goto L113;
            Iterator r34 = r32.entrySet().iterator();
            if (r34 == null) goto L113;
            String r35 = "";
            int r36 = 0;
        L81:
            if (r34.hasNext() == false) goto L114;
            MusicCreationContent r110 = (MusicCreationContent) ((Map.Entry) r34.next()).getValue();
            if (r110 == null) goto L85;
            String r111 = r110.getMusicGenFailedMsg();
        L87:
            if (TextUtils.isEmpty(r111) == false) goto L89;
            r13 = 1;
        L89:
            if (r110 == null) goto L94;
            String r112 = r110.getVid();
            if (r112 == null) goto L94;
            String r113 = r112;
        L95:
            r29.add(r113);
            if (r110 == null) goto L99;
            String r114 = r110.getTitle();
            if (r114 == null) goto L99;
        L100:
            r30.add(r114);
            if (r110 == null) goto L103;
            String r115 = r110.getVid();
        L105:
            if (TextUtils.isEmpty(r115) == true) goto L108;
            r36 = r36 + 1;
        L108:
            if (TextUtils.isEmpty(r35) == false) goto L81;
            if (r110 == null) goto L112;
            r35 = r110.getMusicGenFailedMsg();
            if (r35 != null) goto L81;
        L112:
            r35 = "";
            goto L81
        L103:
            r115 = null;
        L99:
            r114 = "";
        L94:
            r113 = "";
            goto L95
        L85:
            r111 = null;
        L114:
            if (r13 == 0) goto L116;
        L121:
            String r116 = r35;
        L122:
            String r37 = CollectionsKt.joinToString$default(r29, ",", null, null, 0, null, null, 62, null);
            String r117 = CollectionsKt.joinToString$default(r30, ",", null, null, 0, null, null, 62, null);
            String r210 = r10.getMessageId();
            Map r38 = r10.getExt();
            if (r38 == null) goto L125;
            String r118 = (String) r38.get("gen_music_create_way");
        L126:
            Map r39 = r10.getExt();
            if (r39 == null) goto L129;
            String r211 = (String) r39.get("gen_music_create_type");
        L130:
            Map r40 = r10.getExt();
            if (r40 == null) goto L133;
            String r41 = (String) r40.get("gen_music_has_lyric");
        L134:
            int r42 = !Intrinsics.areEqual(r41, TriggerSendLoading.NO_LOADING) ? 1 : 0;
            Map r43 = r10.getExt();
            if (r43 == null) goto L137;
            String r212 = (String) r43.get("gen_music_model");
        L139:
            if (com.larus.im.bean.message.a.V(r10) == false) goto L141;
            String r44 = "async";
        L142:
            String r213 = r44;
            Map r45 = r10.getExt();
            if (r45 == null) goto L147;
            String r46 = (String) r45.get("gen_music_duration");
            if (r46 == null) goto L147;
            int r214 = CastIntegerProtector.parseInt(r46);
        L148:
            l.a.b(new h(r19, r17, r15, r118, r37, r116, r117, r210, r24, r211, Integer.valueOf(r42), r212, r213, r214, "ai_music_card", r13, r36, r31, 1), n.a.b(r10.getConversationId(), r10.getMessageId()), 1);
            return;
        L147:
            int r47 = e.c;
            r214 = (int) e.a.a();
            goto L148
        L141:
            r44 = "sync";
            goto L142
        L137:
            r212 = null;
            goto L139
        L133:
            r41 = null;
            goto L134
        L129:
            r211 = null;
            goto L130
        L125:
            r118 = null;
            goto L126
        L116:
            if (TextUtils.isEmpty(r35) == false) goto L121;
            String r48 = r10.getContent();
            if (r48 != null) goto L120;
            r116 = "";
            goto L122
        L120:
            r116 = r48;
        L113:
            r35 = "";
            r36 = 0;
            goto L114
        L174:
            return;
        L61:
            String r49 = r10.getContent();
            if (r10.getContentType() != 72) goto L171;
            if (r49 != null) goto L65;
        L68:
            boolean r50 = true;
        L69:
            if (r50 == true) goto L175;
            String r51 = r10.getMessageId();
            if (r51 != null) goto L74;
            r51 = "";
        L74:
            r25 = com.larus.bmhome.music.protocol.a.b(r51, r49);
            goto L75
        L175:
            return;
        L65:
            if (r49.length() == 0) goto L68;
            r50 = false;
            goto L69
        L171:
            return;
        L43:
            if (r1.intValue() != 1) goto L45;
            r23 = "chat_action_bar";
            goto L46
        L47:
            r24 = r22;
            goto L48
        L33:
            r19 = null;
            goto L34
        L29:
            r17 = null;
            goto L30
        L20:
            r14 = false;
            goto L21
        L173:
            return;
        L150:
            th = move-exception;
            throw th;
        }

        public b(Message r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new LruCache(20);
        b = new HashSet();
        d = new a();
        e = new Gson();
    }

    public static void a(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        String r0 = r6.getReplyId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r6.getMessageId();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        boolean r3 = false;
        if (r0.length() != 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        return;
    L15:
        if (r1.length() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        return;
    L20:
        if (com.larus.im.bean.message.a.b0(r6) == false) goto L43;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        List r7 = vd9.r.a(r6);
        if ((r7 instanceof Collection) == true) goto L24;
    L26:
        Iterator r8 = r7.iterator();
    L28:
        if (r8.hasNext() == false) goto L53;
        BlockContent r9 = ((Block) r8.next()).getContent();
        if (r9 == null) goto L39;
        MusicCreationContentList r10 = r9.getLyricsToSongsMusicBlock();
        if (r10 == null) goto L39;
        if (r10.getTaskNumber() <= 0) goto L36;
        boolean r11 = true;
    L37:
        if (r11 != true) goto L39;
        boolean r12 = true;
    L40:
        if (r12 == false) goto L28;
    L52:
        boolean r13 = true;
    L54:
        if (r13 == true) goto L56;
    L61:
        if (r3 == false) goto L72;
        com.larus.im.d.e().m(r0, new b(r6, r1));
        return;
    L72:
        return;
    L56:
        if (com.larus.im.bean.message.a.V(r6) == false) goto L58;
        boolean r14 = com.larus.im.bean.message.a.I0(r6);
    L59:
        if (r14 == false) goto L61;
        r3 = true;
        goto L61
    L58:
        r14 = com.larus.bmhome.chat.bean.d.j0(r6);
        goto L59
    L36:
        r11 = false;
    L39:
        r12 = false;
    L53:
        r13 = false;
        goto L54
    L24:
        if (r7.isEmpty() == false) goto L26;
    L43:
        if (r6.getContentType() != 72) goto L53;
        String r15 = r6.getContent();
        if (r15 != null) goto L47;
    L50:
        boolean r16 = true;
    L51:
        if (r16 == true) goto L53;
    L47:
        if (r15.length() == 0) goto L50;
        r16 = false;
        goto L51
    L17:
        r5 = false;
        goto L18
    L12:
        r4 = false;
        goto L13
    }
}
