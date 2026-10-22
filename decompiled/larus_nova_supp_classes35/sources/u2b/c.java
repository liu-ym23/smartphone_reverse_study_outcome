package u2b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.n0;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.CotDisplayModel;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.cot.CotViewModel;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.chat.entity.message.CotStatus;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.g0;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements x4b.c<MessageInfo, y6b.c<?>>, h {
    public final d a;
    public final r b;
    public final m c;
    public final i d;
    public final p e;
    public final k f;
    public final f g;
    public final g h;
    public final a i;
    public final l j;
    public final s k;
    public final n l;
    public final q m;
    public final t n;
    public final e o;
    public final Map<Message.Type, List<y6b.d>> p;
    public final v q;
    public final boolean r;
    public boolean s;
    public boolean t;

    public static List<y6b.f> c(List<MessageInfo> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        Context r0 = ChatCoreModule.a().getContext();
        int r1 = v2c.a.b(r0, 2131106607);
        ArrayList r2 = new ArrayList();
        Iterator<MessageInfo> r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L15;
        MessageInfo r3 = r9.next();
        CharSequence r4 = g0.b(r0, r3.getMessage(), r1);
        if (r4 != null) goto L11;
        r4 = BuildConfig.FLAVOR;
    L11:
        y6b.f.a r5 = new y6b.f.a();
        String r6 = r3.getId();
        Intrinsics.checkNotNullParameter(r6, "messageId");
        ((n0.a) r5).a = r6;
        Intrinsics.checkNotNullParameter(r4, "content");
        ((n0.a) r5).e = r4;
        ((n0.a) r5).f = r3.getMessage().getThreadPosition();
        if (r3.getMessageSender() == null) goto L14;
        ChatChatter r7 = r3.getMessageSender();
        String r10 = com.ss.android.lark.chat.utils.m.b(r7, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true);
        String r11 = r7.getId();
        Intrinsics.checkNotNullParameter(r11, "senderId");
        ((n0.a) r5).b = r11;
        Intrinsics.checkNotNullParameter(r10, IPortraitService.NAME);
        ((n0.a) r5).d = r10;
        String r12 = r7.getAvatarKey();
        Intrinsics.checkNotNullParameter(r12, "avatarKey");
        ((n0.a) r5).c = r12;
    L14:
        r2.add(new y6b.f(r5));
        goto L7
    L15:
        return r2;
    }

    @Override // u2b.h
    public final void a(boolean r1) {
        this.s = r1;
    }

    @Override // x4b.c
    public final y6b.c b(Object r2) {
        return d((MessageInfo) r2, true);
    }

    public static void f(Map r2, y6b.d r3) {
        List r0 = (List) r2.get(r3.a());
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        r2.put(r3.a(), r0);
    L5:
        r0.add(r3);
    }

    public final y6b.c d(MessageInfo r9, boolean r10) {
        Message r0 = r9.getMessage();
        Message.Type r1 = r0.getType();
        ChatChatter r2 = r9.getMessageSender();
        if (r1 != Message.Type.SYSTEM) goto L7;
        ChatChatter r3 = ((SystemContent) r0.getContent()).getFromChatter();
        if (r3 == null) goto L7;
        r2 = r3;
    L7:
        ChatChatter r4 = r9.getRecallUser();
        f5b.a r5 = null;
        if (r10 == true) goto L10;
        y6b.c r6 = null;
    L24:
        if (r10 == true) goto L26;
    L28:
        y6b.c r11 = null;
    L30:
        if (this.t == false) goto L32;
        List<y6b.f> r7 = c(r9.getLatestRepliesInThread());
    L33:
        PartialReplyInfo r8 = r0.getPartialReplyInfo();
        y6b.c.a<v5b.a<?>> r12 = e(r9, r0, r1);
        r12.i0 = r6;
        r12.j0 = r8;
        r12.k0 = r11;
        r12.l0 = r0.getSyncToChatThreadRootId();
        r12.m0 = r0.getSyncToChatMessageType();
        r12.n0 = r0.getSyncToChatRelatedMessageId();
        r12.r = r9.getReactionInfoList();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r12.t = r9.getPin();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r12.W = r9.getDingStatus();
        if (r9.getOriginalSender() == null) goto L36;
        d r13 = this.a;
        ChatChatter r14 = r9.getOriginalSender();
        r13.getClass();
        y6b.b r15 = d.a(r14);
    L37:
        r12.o0 = r15;
        if (r4 == null) goto L40;
        this.a.getClass();
        y6b.b r16 = d.a(r4);
    L41:
        r12.h0 = r16;
        r12.x0 = r9.getReplyInThreadCount();
        r12.A0 = r9.getMessageFoldDetail();
        r12.E0 = r9.getUniversalPinExtra();
        r12.C0 = r7;
        r12.F0 = r9.getSmartReplyEntryInfo();
        r12.H0 = r9.getAiRecommendQuestions();
        if (r0.getAiSmartReply() == null) goto L45;
        r5 = r0.getAiSmartReply().parseToVO();
    L45:
        r12.G0 = r5;
        r0.getAnalysisConfigs();
        r12.getClass();
        r12.I0 = r0.isThreadForwardRootMessage();
        if (r2 == null) goto L48;
        Intrinsics.checkNotNullParameter(r2.getAvatarKey(), "fromAvatarKey");
        r12.getClass();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        this.a.getClass();
        y6b.b r17 = d.a(r2);
        Intrinsics.checkNotNullParameter(r17, "fromChatter");
        r12.q = r17;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
    L48:
        y6b.c<T> r18 = r12.g();
        r18.T2 = r9.isForceUpdate();
        r18.U2 = ReplyInThreadUtil.b(r18);
        Log.d("ChatMessageDataMapper", "current Thread = " + ThreadMethodProxy.currentThread().getName());
        r18.a3 = r9.getMessage().getAIMessageLikeFeedbackStatus();
        r18.W2 = r0.getThreadPosition();
        return r18;
    L40:
        r16 = null;
        goto L41
    L36:
        r15 = null;
        goto L37
    L32:
        r7 = null;
        goto L33
    L26:
        if (r9.getThreadParentMessageInfo() == null) goto L28;
        r11 = d(r9.getThreadParentMessageInfo(), false);
        goto L30
    L10:
        if (r0.getType() == Message.Type.DOUBAO) goto L12;
    L18:
        r6 = null;
    L19:
        if (r6 != null) goto L24;
        if (r9.getParentMessageInfo() == null) goto L24;
        r6 = d(r9.getParentMessageInfo(), false);
        goto L24
    L12:
        if (r0.getExtras() == null) goto L18;
        g5b.a r19 = (g5b.a) r0.getExtras().get(g5b.a.class);
        if (r19 == null) goto L18;
        MessageInfo r20 = r19.d;
        if (r20 == null) goto L18;
        r6 = d(r20, false);
        goto L19
    }

    public final y6b.c.a<v5b.a<?>> e(MessageInfo r24, Message r25, Message.Type r26) {
        y6b.c.a<v5b.a<?>> r3 = new y6b.c.a();
        if (r24 != null) goto L5;
        return r3;
    L5:
        Content r0 = r25.getContent();
        String r4 = BuildConfig.FLAVOR;
        if (r0 == null) goto L21;
        List r1 = (List) ((HashMap) this.p).get(r26);
        if (r1 == null) goto L21;
        Iterator r2 = r1.iterator();
        v5b.a r6 = null;
    L11:
        if (r2.hasNext() == false) goto L19;
        y6b.d r7 = (y6b.d) r2.next();
        v5b.a r8 = r7.c(this.q, r24);
        if (r8 != null) goto L15;
        r6 = r8;
        goto L11
    L15:
        if (this.s == false) goto L17;
        CharSequence r5 = r7.d(r24);
        r6 = r8;
    L20:
        r8 = r6;
        b r9 = null;
    L22:
        if (r8 != null) goto L27;
        t r10 = this.n;
        v r11 = this.q;
        r10.getClass();
        r8 = t.e(r11, r24);
        if (this.s == false) goto L26;
        r5 = this.n.d(r24);
        goto L27
    L26:
        b r12 = new b(this, this.n, r24);
    L28:
        CharSequence r13 = r5;
        boolean r14 = false;
        if (this.r == true) goto L31;
    L33:
        boolean r15 = false;
    L34:
        e r16 = this.o;
        com.ss.android.lark.chat.cot.a r17 = this.q.o0();
        CotContent r18 = r25.getCotContent();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "cotFeatureGate");
        if (r17.a.isEnable("lark.im.agent.cot_message") == false) goto L38;
        if (r18 == null) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == false) goto L42;
        if (r18 == null) goto L42;
        CotViewModel r20 = com.ss.android.lark.chat.cot.g.a(r18);     // Catch: Exception -> L45
        com.ss.android.lark.chat.cot.f.c("vo_build", com.ss.android.lark.chat.cot.f.d(r18) + ", blocks=" + r20.getBlocks().size() + ", overallStatus=" + r20.getOverallStatus());     // Catch: Exception -> L45
    L47:
        Context r110 = ChatCoreModule.a().getContext();
        CharSequence r111 = com.ss.android.lark.chat.cot.h.c(r20);
        if (r111 != null) goto L50;
    L55:
        r111 = com.ss.android.lark.chat.cot.h.a(r20);
        if (r111 != null) goto L58;
    L60:
        r111 = null;
    L61:
        if (r111 != null) goto L63;
        Intrinsics.checkNotNull(r110);
        r111 = com.ss.android.lark.chat.cot.h.b(r20, r110);
    L63:
        String r112 = r111.toString();
        if (r20.getOverallStatus() != CotStatus.RUNNING) goto L66;
        boolean r113 = true;
    L67:
        CotDisplayModel r114 = new CotDisplayModel(r112, r113, r20.getOverallStatus(), r20);
    L68:
        r3.e(r25.getId());
        r3.a(r25.getcId());
        r3.f(r25.getType());
        r3.b(r25.getChatId());
        r3.d(r25.getFromId());
        r3.c(r8);
        Intrinsics.checkNotNullParameter(r13, "displayText");
        r3.b0 = r13;
        r3.c0 = r12;
        r3.g = r25.isFromMe();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.g0 = r25.isReEditable();
        r3.h = r25.isRemoved();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.i = r25.isVisible();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.j = r25.getReplyCount();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.k = r25.getCreateTime();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.l = r25.getPosition();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.m = r25.getBadgeCount();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.n = r25.isBadged();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.o = r25.getStatus();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        SendStatus r21 = r25.getSendStatus();
        Intrinsics.checkNotNullParameter(r21, "sendStatus");
        r3.p = r21;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        if (r25.getRootId() != null) goto L71;
        String r22 = BuildConfig.FLAVOR;
    L72:
        Intrinsics.checkNotNullParameter(r22, "rootId");
        r3.R = r22;
        if (r25.getParentId() == null) goto L76;
        r4 = r25.getParentId();
    L76:
        Intrinsics.checkNotNullParameter(r4, "parentId");
        r3.S = r4;
        r3.T = r25.isDing();
        r3.U = r25.isEphemeral();
        r3.V = !TextUtils.isEmpty(r25.getParentSourceId());
        r3.f0 = r25.getMeReadType();
        r3.d0 = r25.getReadCount();
        r3.e0 = r25.getUnReadCount();
        r3.X = r25.isBurned();
        r3.Z = r25.getBurnLife();
        r3.Y = r25.getBurnTime();
        r3.a0 = r25.isOnTimeDel();
        r3.p0 = r25.getOriginalSenderId();
        r3.q0 = r25.isForwardFromFriend();
        if (r25.getRecallerIdentity() != Message.RecallerIdentity.GROUP_ADMIN) goto L79;
        boolean r23 = true;
    L80:
        r3.r0 = r23;
        r3.s0 = r25.getRecallerIdentity();
        r3.t0 = r15;
        r3.u0 = r25.isIncludeDocUrl();
        r3.N = r25.getMessageLinkMap();
        r3.u = r25.isDecryptFailed();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.v0 = r25.getThreadId();
        r3.w0 = r25.getThreadMessageType();
        r3.y0 = r25.isFlag();
        r3.w = r25.getMessageLanguage();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.x = r25.getCharacterLength();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.z0 = r24.getMessage().getEditInfo();
        r3.D0 = r24.getMessage().getMessageLocalDataInfoMap();
        r3.y = r25.getDlpState();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.z = r25.getSecurityESCReviewExtra();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.C = r25.getValidateIMFileResult();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.A = r25.isRestricted();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.B = r25.isSetGrey();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r27 = r25.getDisabledAction();
        if (r27 != null) goto L83;
        r27 = MapsKt.emptyMap();
    L83:
        r3.D = r27;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        ChatDisplayModeSetting r28 = r25.getChatDisplayModeSetting();
        Intrinsics.checkNotNullParameter(r28, "chatDisplayModeSetting");
        r3.B0 = r28;
        r3.v = r24.getMessage().isCleaned();
        MessageStreamStatus r29 = r25.getStreamStatus();
        Intrinsics.checkNotNullParameter(r29, "status");
        r3.E = r29;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r25.isNewTopic();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.J = r25.getAppInfoItemName();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.K = r25.getDisplayPolicy();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.L = r25.getSenderAppInfo();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r25.getAiAnswerRawData();
        r3.F = r25.getAiChatModeId();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r25.getAiMessageType();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r24.getMyAIThreadInfo();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type B of com.ss.android.lark.chat.vo.AbsMessageVO.Builder");
        r3.E0 = r24.getUniversalPinExtra();
        j6b.k.b.getClass();
        Intrinsics.checkNotNullParameter(r8, "contentVO");
        if ((r8 instanceof PostContentVO) == false) goto L95;
        String r30 = (String) ((PostContentVO) r8).E.getValue();
        if (r30 != null) goto L88;
    L91:
        boolean r31 = true;
    L92:
        if (r31 == true) goto L95;
    L202:
        r3.G = r14;
        r3.H = r25.getSourceType();
        r25.isHasFollowUP();
        r3.I = r25.getSourceId();
        r3.M = r25.getAiInfo();
        r3.O = r25.getCotContent();
        r3.P = r114;
        r3.Q = r25.getExtras();
        return r3;
    L88:
        if (r30.length() == 0) goto L91;
        r31 = false;
    L95:
        if ((r8 instanceof BaseTextContentVO) == false) goto L202;
        g6b.a.InterfaceC0223a r32 = g6b.a.a;
        if (r32 == null) goto L103;
        com.ss.android.lark.officesdk.integrator.im.h r33 = r32.getFeatureGatingDependency();
        if (r33 == null) goto L103;
        if (r33.a("im.fix_url_preview.single_url_with_attachment.reverse") != true) goto L103;
        boolean r34 = true;
    L104:
        BaseTextContentVO r35 = (BaseTextContentVO) r8;
        if ((!r35.f().isEmpty()) == false) goto L108;
        if (r34 == false) goto L202;
    L108:
        Map<String, PreviewHangPoint> r36 = j6b.k.b(r8);
        if ((!r36.isEmpty()) == true) goto L124;
        Map<String, PreviewHangPoint> r37 = r35.C;
        LinkedHashMap r38 = new LinkedHashMap();
        Iterator<Map.Entry<String, PreviewHangPoint>> r39 = r37.entrySet().iterator();
    L113:
        if (r39.hasNext() == false) goto L122;
        Map.Entry<String, PreviewHangPoint> r40 = r39.next();
        String r115 = r40.getKey();
        PreviewHangPoint r116 = r40.getValue();
        if (StringsKt.startsWith$default(r115, "URLPreview", false, 2, null) == true) goto L117;
    L119:
        boolean r117 = false;
    L120:
        if (r117 == false) goto L113;
        r38.put(r40.getKey(), r40.getValue());
        goto L113
    L117:
        if (r116.isValidCardData() == false) goto L119;
        r117 = true;
        goto L120
    L122:
        r36 = r38;
    L124:
        if (r36.size() != 1) goto L202;
        Iterator r41 = r36.values().iterator();
    L128:
        if (r41.hasNext() == false) goto L132;
        if (((PreviewHangPoint) r41.next()).isValidCardData() == true) goto L128;
    L132:
        RichText r42 = r35.g();
        if (r42 == null) goto L202;
        if (r42.getAnchorIds().size() != 1) goto L202;
        if (r42.getElementIds().size() > 5) goto L202;
        ArrayList r43 = new ArrayList();
        ArrayList r44 = new ArrayList();
        List r118 = r42.getElementIds();
        Map r119 = r42.getElements().getDictionary();
        Iterator r120 = r118.iterator();
    L143:
        if (r120.hasNext() == false) goto L148;
        RichTextElement r121 = (RichTextElement) r119.get((String) r120.next());
        if (r121 == null) goto L143;
        Intrinsics.checkNotNull(r119);
        j6b.k.d(r121, r119, r43, r44);
        goto L143
    L148:
        Pair r122 = new Pair(r43, r44);
        ArrayList r45 = (ArrayList) r122.getFirst();
        ArrayList r46 = (ArrayList) r122.getSecond();
        Set<String> r123 = r36.keySet();
        List r47 = r42.getAnchorIds();
        if (r47 == null) goto L151;
        String r48 = (String) ListProtector.get(r47, 0);
    L152:
        boolean r49 = CollectionsKt.contains(r123, r48);
        boolean r50 = StringsKt.startsWith$default((String) CollectionsKt.first(r36.keySet()), "URLPreview", false, 2, null);
        if (r45.size() != 1) goto L172;
        if (r46.isEmpty() == false) goto L172;
        RichTextElement r51 = (RichTextElement) ListProtector.get(r45, 0);
        RichTextElement.AnchorProperty r52 = r51.getProperty();
        if ((r52 instanceof RichTextElement.AnchorProperty) == false) goto L202;
        if (r49 == true) goto L161;
        if (r50 == false) goto L202;
    L161:
        if (r52.isCustom() == true) goto L202;
        Map r53 = r51.getStyle();
        if (r53 != null) goto L165;
    L168:
        boolean r54 = true;
    L169:
        if (r54 == false) goto L202;
    L201:
        r14 = true;
        goto L202
    L165:
        if (r53.isEmpty() == true) goto L168;
        r54 = false;
    L172:
        if (r45.size() <= 1) goto L199;
        RichTextElement r55 = (RichTextElement) ListProtector.get(r45, 0);
        if ((r55.getProperty() instanceof RichTextElement.AnchorProperty) == false) goto L202;
        RichTextElement.AnchorProperty r56 = r55.getProperty();
        Intrinsics.checkNotNull(r56, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement.AnchorProperty");
        if (r56.isCustom() == true) goto L202;
        Map r57 = r55.getStyle();
        if (r57 != null) goto L180;
    L183:
        boolean r58 = true;
    L184:
        if (r58 == false) goto L202;
        int r59 = r45.size();
        int r60 = 1;
    L187:
        if (r60 >= r59) goto L199;
        RichTextElement.TextProperty r61 = ((RichTextElement) ListProtector.get(r45, r60)).getProperty();
        if ((r61 instanceof RichTextElement.TextProperty) == false) goto L202;
        RichTextElement.TextProperty r62 = r61;
        if (r62.getContent() == null) goto L198;
        if (StringsKt.trim(r62.getContent()).toString().length() <= 0) goto L195;
        boolean r63 = true;
    L196:
        if (r63 == false) goto L198;
    L195:
        r63 = false;
    L198:
        r60 = r60 + 1;
        goto L187
    L180:
        if (r57.isEmpty() == true) goto L183;
        r58 = false;
    L199:
        if (r49 == true) goto L201;
        if (r50 == false) goto L202;
    L151:
        r48 = null;
    L103:
        r34 = false;
        goto L104
    L79:
        r23 = false;
        goto L80
    L71:
        r22 = r25.getRootId();
        goto L72
    L66:
        r113 = false;
        goto L67
    L58:
        if ((!StringsKt.isBlank(r111)) == false) goto L60;
    L50:
        if ((!StringsKt.isBlank(r111)) == true) goto L53;
        r111 = null;
    L53:
        if (r111 == null) goto L55;
    L45:
        e = move-exception;
        com.ss.android.lark.chat.cot.f.b("vo_build", "reduce failed, " + com.ss.android.lark.chat.cot.f.d(r18), e);
        r20 = new CotViewModel(r18.getCotId(), new ArrayList(), r18.getStatus(), false, null, 24, null);
    L42:
        r114 = null;
    L38:
        r19 = false;
        goto L39
    L31:
        if (r25.isFromMe() == false) goto L33;
        r15 = true;
    L27:
        r12 = r9;
        goto L28
    L17:
        r9 = new b(this, r7, r24);
        r5 = BuildConfig.FLAVOR;
        goto L22
    L19:
        r5 = BuildConfig.FLAVOR;
    L21:
        r5 = BuildConfig.FLAVOR;
        r9 = null;
        r8 = null;
        goto L22
    }

    public c(v r5, boolean r6, boolean r7, List<y6b.d<v5b.a<?>>> r8) {
        this.a = new d();
        this.b = new r();
        this.c = new m();
        this.d = new i();
        this.e = new p();
        this.f = new k();
        this.g = new f();
        this.h = new g();
        this.i = new a();
        this.j = new l();
        this.k = new s();
        this.l = new n();
        this.m = new q();
        this.n = new t();
        this.o = new e();
        this.p = new HashMap();
        this.s = false;
        this.t = true;
        this.q = r5;
        this.r = r7;
        List<r5b.e<?, ?, ?>> r9 = ChatCoreModule.a().getExtensionDependency().c();
        if (CollectionUtils.isEmpty(r9) == true) goto L8;
        Iterator<r5b.e<?, ?, ?>> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        p2b.a r1 = new p2b.a(r10.next().b());
        f(this.p, r1);
    L8:
        Map r11 = com.ss.android.lark.im.base.d.a;
        List r12 = com.ss.android.lark.im.base.d.b(ImExtensionType.MESSAGE_CELL, xya.a.class);
        if (CollectionUtils.isEmpty(r12) == true) goto L19;
        Iterator r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        List r14 = ((xya.a) r13.next()).c();
        if (CollectionUtils.isEmpty(r14) == true) goto L12;
        Iterator r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L12;
        v5b.b r2 = (v5b.b) r15.next();
        f(this.p, new p2b.a(r2));
    L19:
        if (r8 == null) goto L24;
        Iterator<y6b.d<v5b.a<?>>> r16 = r8.iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        y6b.d<v5b.a<?>> r17 = r16.next();
        f(this.p, r17);
    L24:
        if (r6 == true) goto L26;
        this.b.a = false;
        this.c.a = false;
    L26:
        f(this.p, this.b);
        f(this.p, this.c);
        f(this.p, this.d);
        f(this.p, this.e);
        f(this.p, this.f);
        f(this.p, this.g);
        f(this.p, this.h);
        f(this.p, this.i);
        f(this.p, this.j);
        f(this.p, this.k);
        f(this.p, this.l);
        f(this.p, this.m);
    }
}
