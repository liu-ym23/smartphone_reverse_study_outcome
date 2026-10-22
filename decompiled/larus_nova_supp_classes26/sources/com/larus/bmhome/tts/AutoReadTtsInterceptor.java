package com.larus.bmhome.tts;

import android.app.Application;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.util.h;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.tips.GuideTipType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.utils.i;
import com.larus.home.impl.sdk.n1;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsInterceptResult;
import com.larus.tts.TtsScene;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f2a.c;
import f2a.d;
import f2a.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t19.s;
import wc9.e;
import wf9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u0010\u001a\u00020\t*\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/tts/AutoReadTtsInterceptor;", "Lcom/larus/tts/ITtsReaderInterceptor;", "<init>", "()V", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "priority", "", "canHandle", "", "message", "Lcom/larus/im/bean/message/Message;", "scene", "Lcom/larus/tts/TtsScene;", "intercept", "Lcom/larus/tts/TtsInterceptResult;", "notFilteredByAutoReadTts", "noNeedPlay", "msg", "convertTtsContent", "Lcom/larus/im/bean/message/TextContent;", "isNotPlayable", "content", "", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoReadTtsInterceptor implements ITtsReaderInterceptor {
    public final d a;

    public static final class a {
    }

    static {
    }

    public final int priority() {
        return 110;
    }

    public AutoReadTtsInterceptor() {
        this.a = new d("Chat", "AutoReadTtsInterceptor");
    }

    public final boolean c(Message r5) {
        r r0 = h.a(r5);
        if (r0 == null) goto L10;
        Integer r1 = r0.a;
        if (r1 == null) goto L10;
        if (r1.intValue() != 11) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L21;
        Map r6 = r5.getExt();
        if (r6 == null) goto L15;
        String r7 = (String) r6.get("o_did");
    L17:
        if (Intrinsics.areEqual(r7, o.a.getDeviceId()) == true) goto L22;
        return false;
    L22:
        return true;
    L15:
        r7 = null;
        goto L17
    L21:
        return true;
    L10:
        r2 = false;
        goto L11
    }

    public final boolean a(Message r3, TtsScene r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "scene");
        return CollectionsKt.listOf(new TtsScene[]{TtsScene.Auto_ReceiveMessage, TtsScene.Auto_UpdateMessage, TtsScene.Auto_Streaming}).contains(r4);
    }

    public final TtsInterceptResult b(Message r35, TtsScene r36) {
        Intrinsics.checkNotNullParameter(r35, "message");
        Intrinsics.checkNotNullParameter(r36, "scene");
        ObricTtsControlDelegate r4 = ObricTtsControlDelegate.b;
        String r13 = "";
        if (r4.j(r35) == false) goto L5;
    L15:
        boolean r5 = es8.d.a;
        y r6 = es8.d.a(y.class);
        if (r6 == null) goto L18;
        e r7 = r6.h();
    L20:
        if (com.larus.bmhome.chat.bean.d.z0(r35) == false) goto L33;
        if (com.larus.bmhome.chat.bean.d.W0(r35) == true) goto L33;
        c r2 = this.a.b("[TTS][ONBOARD] tts not play");
        r2.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r3 = new Pair[4];
        f r8 = f.i;
        String r9 = r35.getMessageId();
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r3[0] = TuplesKt.to(r8, r9);
        f r10 = new f("local_message_id");
        String r11 = r35.getLocalMessageId();
        if (r11 == null) goto L30;
        r13 = r11;
    L30:
        r3[1] = TuplesKt.to(r10, r13);
        r3[2] = TuplesKt.to(new f("is_welcome_back_msg"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.W0(r35)));
        r3[3] = TuplesKt.to(new f("is_on_boarding_msg"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.z0(r35)));
        r2.d(MapsKt.mapOf(r3));
        c.c(r2, null, 15);
        return TtsInterceptResult.Deny;
    L33:
        if (com.larus.bmhome.chat.bean.d.a0(r35) == true) goto L35;
    L45:
        int r16 = b.a;
        Intrinsics.checkNotNullParameter(r35, "message");
        boolean r12 = com.larus.im.bean.message.a.r0(r35);
        boolean r17 = com.larus.bmhome.chat.bean.d.f0(r35);
        if (r12 == true) goto L50;
        if (r17 == true) goto L50;
        boolean r18 = false;
    L52:
        if (r18 == false) goto L67;
        if (z2.a.startTtsWhenReceiveContent() == false) goto L56;
    L57:
        c r14 = this.a.b("[TTS][LOADING] tts not play");
        r14.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r15 = new Pair[6];
        f r19 = f.i;
        String r20 = r35.getMessageId();
        if (r20 != null) goto L60;
        r20 = "";
    L60:
        r15[0] = TuplesKt.to(r19, r20);
        f r21 = new f("local_message_id");
        String r22 = r35.getLocalMessageId();
        if (r22 == null) goto L64;
        r13 = r22;
    L64:
        r15[1] = TuplesKt.to(r21, r13);
        r15[2] = TuplesKt.to(f.g, Integer.valueOf(r35.getContentType()));
        r15[3] = TuplesKt.to(new f("is_deep_thinking_typing"), Boolean.valueOf(r17));
        r15[4] = TuplesKt.to(new f("is_server_loading"), Boolean.valueOf(r12));
        r15[5] = TuplesKt.to(new f("server_loading_not_interrupt_tts"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.L(r35)));
        r14.d(MapsKt.mapOf(r15));
        c.c(r14, null, 15);
        return TtsInterceptResult.Deny;
    L56:
        if (com.larus.bmhome.chat.bean.d.L(r35) == true) goto L57;
    L67:
        if (r36 == TtsScene.Auto_UpdateMessage) goto L71;
        if (z2.a.autoReadTtsOptConfig().getSkipTtsAutoReadCheckScene() == true) goto L71;
    L92:
        if (Intrinsics.areEqual(r35.getSenderId(), AccountService.a.getUserId()) == true) goto L133;
        String r23 = r35.getMessageId();
        if (r23 != null) goto L96;
    L99:
        boolean r24 = true;
    L100:
        if (r24 == true) goto L133;
        if (r4.e() == true) goto L104;
    L105:
        y r25 = es8.d.a(y.class);
        if (r25 == null) goto L112;
        e r26 = r25.h();
        if (r26 == null) goto L112;
        if (r26.i == true) goto L112;
        boolean r27 = true;
    L113:
        if (r27 == true) goto L133;
        IFlowSdkDepend r28 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r28 == null) goto L119;
        r28.N();
        if (n1.a.R() != 1) goto L119;
        boolean r29 = true;
    L120:
        if (r29 == true) goto L133;
        if (com.larus.im.bean.message.a.p0(r35) == true) goto L133;
        if (com.larus.im.bean.message.a.i0(r35) == true) goto L133;
        Intrinsics.checkNotNullParameter(r35, "<this>");
        Map r30 = r35.getExt();
        if (r30 == null) goto L128;
        String r31 = (String) r30.get("tts_not_supported");
    L130:
        if (Intrinsics.areEqual(r31, "1") == true) goto L133;
        boolean r32 = false;
    L135:
        if (r32 == false) goto L153;
        c r33 = this.a.b("[TTS][NO_NEED_PLAY]");
        r33.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r34 = new Pair[5];
        f r37 = f.i;
        String r38 = r35.getMessageId();
        if (r38 != null) goto L139;
        r38 = "";
    L139:
        r34[0] = TuplesKt.to(r37, r38);
        f r39 = new f("sender_id");
        String r40 = r35.getSenderId();
        if (r40 == null) goto L143;
        r13 = r40;
    L143:
        r34[1] = TuplesKt.to(r39, r13);
        f r41 = new f("tts_enable");
        if (r7 == null) goto L146;
        Boolean r42 = Boolean.valueOf(r7.i);
    L147:
        r34[2] = TuplesKt.to(r41, String.valueOf(r42));
        r34[3] = TuplesKt.to(new f("tts_enable_cache"), String.valueOf(es8.d.c()));
        f r43 = new f("is_not_allow_tts");
        Intrinsics.checkNotNullParameter(r35, "<this>");
        Map r1 = r35.getExt();
        if (r1 == null) goto L150;
        String r44 = (String) r1.get("tts_not_supported");
    L151:
        r34[4] = TuplesKt.to(r43, Boolean.valueOf(Intrinsics.areEqual(r44, "1")));
        r33.d(MapsKt.mapOf(r34));
        c.c(r33, null, 15);
        return TtsInterceptResult.Deny;
    L150:
        r44 = null;
        goto L151
    L146:
        r42 = null;
        goto L147
    L153:
        Map r45 = r35.getExt();
        if (r45 == null) goto L156;
        String r46 = (String) r45.get("risk_fake_item");
    L158:
        if (Intrinsics.areEqual(r46, "1") == false) goto L175;
        Map r47 = r35.getExt();
        if (r47 == null) goto L162;
        String r48 = (String) r47.get("wrapper_name");
    L164:
        if (Intrinsics.areEqual(r48, "wrapper_name_fake_stream") == false) goto L175;
        c r49 = this.a.a("[TTS][RISK_FAKE_ITEM] not play");
        r49.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r50 = new Pair[2];
        f r51 = f.i;
        String r52 = r35.getMessageId();
        if (r52 == null) goto L169;
        r13 = r52;
    L169:
        r50[0] = TuplesKt.to(r51, r13);
        f r53 = new f("conversation_type");
        if (r7 == null) goto L172;
        Integer r54 = r7.j;
    L173:
        r50[1] = TuplesKt.to(r53, String.valueOf(r54));
        r49.d(MapsKt.mapOf(r50));
        c.c(r49, null, 15);
        return TtsInterceptResult.Deny;
    L172:
        r54 = null;
        goto L173
    L162:
        r48 = null;
    L175:
        if (r7 == null) goto L182;
        Integer r55 = r7.j;
        if (r55 == null) goto L182;
        if (r55.intValue() != 3) goto L182;
        boolean r56 = true;
    L183:
        if (r56 == true) goto L193;
        c r57 = this.a.a("[TTS][NOT_BOT_CHAT] not chat bot");
        String r210 = "";
        r57.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r110 = new Pair[2];
        f r111 = f.i;
        String r211 = r35.getMessageId();
        if (r211 != null) goto L187;
        String r58 = r210;
    L188:
        r110[0] = TuplesKt.to(r111, r58);
        f r59 = new f("conversation_type");
        if (r7 == null) goto L191;
        Integer r60 = r7.j;
    L192:
        Pair r61 = TuplesKt.to(r59, String.valueOf(r60));
        int r62 = 1;
        r110[1] = r61;
        r57.d(MapsKt.mapOf(r110));
        c.c(r57, null, 15);
    L195:
        if (r35.getContentType() == r62) goto L203;
        if (r35.getContentType() == 9999) goto L203;
        if (com.larus.bmhome.chat.bean.d.a0(r35) == true) goto L203;
        TextContent r63 = null;
    L206:
        if (r63 == null) goto L208;
        String r64 = r63.text;
    L209:
        if (r64 != null) goto L211;
        r64 = r210;
    L211:
        y r65 = es8.d.a(y.class);
        if (r65 == null) goto L214;
        e r66 = r65.h();
    L215:
        boolean r67 = ObricInteractDelegate.b.isContLockScreenQueryReply(r35);
        z2 r112 = z2.a;
        if (r112.ttsUseLocalStatus() == false) goto L225;
        if (com.larus.bmhome.chat.bean.d.w0(r35) == true) goto L225;
        if (r67 == true) goto L225;
        c r68 = this.a.b("[TTS] check message is not playable");
        r68.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r69 = new Pair[3];
        f r70 = f.i;
        String r71 = r35.getMessageId();
        if (r71 != null) goto L223;
        r71 = r210;
    L223:
        r69[0] = TuplesKt.to(r70, r71);
        r69[1] = TuplesKt.to(f.g, Integer.valueOf(r35.getContentType()));
        r69[2] = TuplesKt.to(new f("is_message_readable"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.w0(r35)));
        r68.d(MapsKt.mapOf(r69));
        c.c(r68, null, 15);
    L286:
        boolean r72 = true;
    L288:
        if (r72 == false) goto L302;
        c r73 = this.a.b("[TTS][NOT_PLAYABLE]");
        r73.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r74 = new Pair[3];
        f r75 = f.i;
        String r76 = r35.getMessageId();
        if (r76 != null) goto L292;
        r76 = r210;
    L292:
        r74[0] = TuplesKt.to(r75, r76);
        f r77 = new f("sender_id");
        String r78 = r35.getSenderId();
        if (r78 != null) goto L295;
        String r113 = r210;
    L296:
        r74[1] = TuplesKt.to(r77, r113);
        f r79 = new f("tts_enable");
        if (r7 == null) goto L299;
        Boolean r80 = Boolean.valueOf(r7.i);
    L300:
        r74[2] = TuplesKt.to(r79, String.valueOf(r80));
        r73.d(MapsKt.mapOf(r74));
        c.c(r73, null, 15);
        return TtsInterceptResult.Deny;
    L299:
        r80 = null;
        goto L300
    L295:
        r113 = r78;
        goto L296
    L302:
        Map r81 = r35.getExt();
        if (r81 == null) goto L305;
        String r82 = (String) r81.get("empty_response");
    L307:
        if (Intrinsics.areEqual(r82, "1") == false) goto L317;
        c r83 = this.a.b("[TTS][EMPTY_RESPONSE] ext empty_response == 1");
        r83.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r84 = new Pair[2];
        f r85 = f.i;
        String r86 = r35.getMessageId();
        if (r86 != null) goto L311;
        r86 = r210;
    L311:
        r84[0] = TuplesKt.to(r85, r86);
        f r87 = new f("local_message_id");
        String r88 = r35.getLocalMessageId();
        if (r88 != null) goto L314;
        String r114 = r210;
    L315:
        r84[1] = TuplesKt.to(r87, r114);
        r83.d(MapsKt.mapOf(r84));
        c.c(r83, null, 15);
        return TtsInterceptResult.Deny;
    L314:
        r114 = r88;
        goto L315
    L317:
        m58.y r89 = m58.y.a;
        m58.b r90 = m58.h.k;
        if (r90 == null) goto L320;
        Application r91 = r90.getApplication();
    L321:
        Integer r92 = r89.b(r91);
        if (r92 == null) goto L324;
        int r93 = r92.intValue();
    L326:
        if (r112.T2() == 0) goto L328;
        boolean r94 = true;
    L329:
        if (r93 > 0) goto L336;
        if (r94 == true) goto L336;
        c r95 = this.a.a("[TTS][VOLUME_ZERO] do not allow to start tts. because volume is 0!");
        r95.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r96 = new Pair[3];
        f r97 = f.i;
        String r98 = r35.getMessageId();
        if (r98 != null) goto L334;
        r98 = r210;
    L334:
        r96[0] = TuplesKt.to(r97, r98);
        r96[1] = TuplesKt.to(new f("volume"), String.valueOf(r93));
        r96[2] = TuplesKt.to(new f("zero_volume_strategy"), String.valueOf(r112.T2()));
        r95.d(MapsKt.mapOf(r96));
        c.c(r95, null, 15);
        return TtsInterceptResult.Deny;
    L336:
        l r99 = es8.d.a(l.class);
        if (r99 != null) goto L339;
    L341:
        boolean r115 = false;
    L342:
        if (r115 == false) goto L350;
        s r100 = s.a;
        Application r101 = FlowRuntime.a().getApplication();
        r100.getClass();
        s.s(r101, 2131911054);
        c r102 = this.a.a("[TTS][INTERRUPT_BY_HANDSFREE_MODE]");
        r102.c.b = CollectionsKt.listOf("TtsPlay");
        f r103 = f.i;
        String r104 = r35.getMessageId();
        if (r104 != null) goto L346;
        String r116 = r210;
    L347:
        r102.d(MapsKt.mapOf(TuplesKt.to(r103, r116)));
        c.c(r102, null, 15);
        return TtsInterceptResult.Deny;
    L346:
        r116 = r104;
        goto L347
    L350:
        return TtsInterceptResult.Pass;
    L339:
        if (r99.Lo() != true) goto L341;
        r115 = true;
        goto L342
    L328:
        r94 = false;
        goto L329
    L324:
        r93 = 0;
        goto L326
    L320:
        r91 = null;
        goto L321
    L305:
        r82 = null;
    L225:
        if (r112.ttsUseLocalStatus() == false) goto L237;
        if (r66 != null) goto L228;
    L230:
        boolean r105 = false;
    L231:
        if (r105 == true) goto L233;
    L242:
        boolean r106 = false;
    L244:
        Integer[] r117 = {1, Integer.valueOf(GuideTipType.FORCE_SHOW)};
        if (r64.length() != 0) goto L247;
        boolean r107 = true;
    L248:
        if (r107 == false) goto L258;
        String r108 = r35.getMessageId();
        if (r108 != null) goto L252;
    L255:
        boolean r109 = true;
    L256:
        if (r109 == false) goto L258;
    L266:
        c r118 = this.a.b("[TTS] check message is not playable");
        r118.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r119 = new Pair[6];
        f r120 = f.i;
        String r121 = r35.getMessageId();
        if (r121 != null) goto L269;
        r121 = r210;
    L269:
        r119[0] = TuplesKt.to(r120, r121);
        r119[1] = TuplesKt.to(f.g, Integer.valueOf(r35.getContentType()));
        r119[2] = TuplesKt.to(new f("tts_enable"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.Q(r35)));
        r119[3] = TuplesKt.to(new f("is_message_tts_enable"), Boolean.valueOf(r106));
        r119[4] = TuplesKt.to(new f("use_local_status"), Boolean.valueOf(r112.ttsUseLocalStatus()));
        r119[5] = TuplesKt.to(new f("msgLoading"), Boolean.valueOf(r35.getMsgLoading()));
        r118.d(MapsKt.mapOf(r119));
        c.c(r118, null, 15);
        goto L286
    L252:
        if (r108.length() == 0) goto L255;
        r109 = false;
    L258:
        if (ArraysKt.contains(r117, Integer.valueOf(r35.getContentType())) == false) goto L260;
    L261:
        if (r106 == true) goto L265;
        if (r35.getMsgLoading() == false) goto L266;
    L265:
        if (com.larus.bmhome.chat.bean.d.t0(r35) == true) goto L266;
        if (com.larus.bmhome.chat.bean.d.z0(r35) == false) goto L279;
        if (com.larus.bmhome.chat.bean.d.W0(r35) == true) goto L279;
        c r122 = this.a.b("[TTS] check message is not playable");
        r122.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r123 = new Pair[3];
        f r124 = f.i;
        String r125 = r35.getMessageId();
        if (r125 != null) goto L277;
        r125 = r210;
    L277:
        r123[0] = TuplesKt.to(r124, r125);
        r123[1] = TuplesKt.to(new f("is_on_boarding_msg"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.z0(r35)));
        r123[2] = TuplesKt.to(new f("is_welcome_back_msg"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.W0(r35)));
        r122.d(MapsKt.mapOf(r123));
        c.c(r122, null, 15);
    L279:
        if (com.larus.bmhome.chat.bean.d.W0(r35) == true) goto L281;
    L287:
        r72 = false;
        goto L288
    L281:
        if (i.f(r66) == false) goto L287;
        c r126 = this.a.b("[TTS] check message is not playable");
        r126.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r127 = new Pair[3];
        f r128 = f.i;
        String r129 = r35.getMessageId();
        if (r129 != null) goto L285;
        r129 = r210;
    L285:
        r127[0] = TuplesKt.to(r128, r129);
        r127[1] = TuplesKt.to(new f("is_welcome_back_msg"), Boolean.valueOf(com.larus.bmhome.chat.bean.d.W0(r35)));
        r127[2] = TuplesKt.to(new f("is_main_bot"), Boolean.valueOf(i.f(r66)));
        r126.d(MapsKt.mapOf(r127));
        c.c(r126, null, 15);
        goto L286
    L260:
        if (dp8.a.b(r35) == false) goto L266;
    L247:
        r107 = false;
        goto L248
    L233:
        if (com.larus.bmhome.chat.bean.d.w0(r35) == true) goto L243;
        if (r67 == false) goto L242;
    L243:
        r106 = true;
        goto L244
    L228:
        if (r66.i != true) goto L230;
        r105 = true;
        goto L231
    L237:
        if (com.larus.bmhome.chat.bean.d.Q(r35) == true) goto L243;
        if (r67 == true) goto L243;
        if (r4.v(r35) == false) goto L242;
    L214:
        r66 = null;
        goto L215
    L208:
        r64 = null;
    L203:
        if (com.larus.im.bean.message.a.b0(r35) == false) goto L205;
        r63 = new TextContent(com.larus.im.bean.message.a.e(r35), null, null, null, null, null, null, null, 254, null);
        goto L206
    L205:
        Intrinsics.checkNotNullParameter(r35, "<this>");
        Intrinsics.checkNotNullParameter(r35, "<this>");
        r63 = vd9.r.b(r35);
        goto L206
    L191:
        r60 = null;
        goto L192
    L187:
        r58 = r211;
        goto L188
    L193:
        r210 = "";
        r62 = 1;
    L182:
        r56 = false;
        goto L183
    L156:
        r46 = null;
        goto L158
    L128:
        r31 = null;
    L119:
        r29 = false;
    L112:
        r27 = false;
        goto L113
    L104:
        if (es8.d.c() == false) goto L133;
    L96:
        if (r23.length() == 0) goto L99;
        r24 = false;
    L133:
        r32 = true;
    L71:
        if (c(r35) == true) goto L92;
        if (com.larus.im.bean.message.a.n0(r35) == false) goto L92;
        z2 r130 = z2.a;
        if (r130.autoReadTtsOptConfig().getEnableReceivedMessageFilter() == false) goto L92;
        c r131 = this.a.a("[TTS][TRY_AUTO_READ_RECEIVED_MESSAGE] tts not play");
        r131.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r132 = new Pair[7];
        f r133 = f.i;
        String r134 = r35.getMessageId();
        if (r134 != null) goto L79;
        r134 = "";
    L79:
        r132[0] = TuplesKt.to(r133, r134);
        f r135 = new f("local_message_id");
        String r136 = r35.getLocalMessageId();
        if (r136 != null) goto L82;
        r136 = "";
    L82:
        r132[1] = TuplesKt.to(r135, r136);
        r132[2] = TuplesKt.to(new f("is_filtered_by_auto_read_tts"), Boolean.valueOf(c(r35)));
        r132[3] = TuplesKt.to(new f("is_received"), Boolean.valueOf(com.larus.im.bean.message.a.n0(r35)));
        r132[4] = TuplesKt.to(new f("from_scene"), r36.name());
        r132[5] = TuplesKt.to(new f("enable_received_message_filter"), Boolean.valueOf(r130.autoReadTtsOptConfig().getEnableReceivedMessageFilter()));
        r132[6] = TuplesKt.to(new f("skipTtsAutoReadCheckScene"), Boolean.valueOf(r130.autoReadTtsOptConfig().getSkipTtsAutoReadCheckScene()));
        r131.d(MapsKt.mapOf(r132));
        c.c(r131, null, 15);
        o r137 = o.a;
        JSONObject r138 = new JSONObject();
        String r139 = r35.getMessageId();
        if (r139 != null) goto L85;
        r139 = "";
    L85:
        r138.put(MusicAppletPage.KEY_MESSAGE_ID, r139);
        String r140 = r35.getLocalMessageId();
        if (r140 == null) goto L89;
        r13 = r140;
    L89:
        r138.put("local_message_id", r13);
        r138.put("content_type", r35.getContentType());
        Unit r141 = Unit.INSTANCE;
        r137.reportEvent("tts_try_auto_read_received_message", r138);
        return TtsInterceptResult.Deny;
    L50:
        r18 = true;
        goto L52
    L35:
        if (dp8.a.b(r35) == true) goto L45;
        c r142 = this.a.b("[TTS][CREATION_NO_MIX] tts not play");
        r142.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r143 = new Pair[3];
        f r144 = f.i;
        String r145 = r35.getMessageId();
        if (r145 != null) goto L39;
        r145 = "";
    L39:
        r143[0] = TuplesKt.to(r144, r145);
        f r146 = new f("local_message_id");
        String r147 = r35.getLocalMessageId();
        if (r147 == null) goto L43;
        r13 = r147;
    L43:
        r143[1] = TuplesKt.to(r146, r13);
        r143[2] = TuplesKt.to(f.g, Integer.valueOf(r35.getContentType()));
        r142.d(MapsKt.mapOf(r143));
        c.c(r142, null, 15);
        return TtsInterceptResult.Deny;
    L18:
        r7 = null;
        goto L20
    L5:
        if (es8.d.b() != null) goto L15;
        c r148 = this.a.b("[TTS][CHAT_FRAGMENT_UNAVAILABLE] tts not play");
        r148.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r149 = new Pair[3];
        f r150 = f.i;
        String r151 = r35.getMessageId();
        if (r151 != null) goto L9;
        r151 = "";
    L9:
        r149[0] = TuplesKt.to(r150, r151);
        f r152 = new f("local_message_id");
        String r153 = r35.getLocalMessageId();
        if (r153 == null) goto L13;
        r13 = r153;
    L13:
        r149[1] = TuplesKt.to(r152, r13);
        r149[2] = TuplesKt.to(new f("from_scene"), r36.name());
        r148.d(MapsKt.mapOf(r149));
        c.c(r148, null, 15);
        return TtsInterceptResult.Deny;
    }
}
