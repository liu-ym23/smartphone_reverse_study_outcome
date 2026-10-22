package leb;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.larksuite.component.ui.tag.DrawableStateSet;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.chat.entity.Item;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.a0;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import e0c.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends b<ChatFeedPreview> {
    public c() {
    }

    @Override // leb.b
    public final ChatFeedPreview e(FeedPreviewInfo r10) {
        ChatFeedPreview r0 = new ChatFeedPreview();
        f(r0, r10);
        Chat.Type r1 = r10.G;
        Chat.Type r2 = Chat.Type.P2P;
        int r3 = 0;
        if (r1 == r2) goto L5;
    L7:
        boolean r4 = false;
    L8:
        r0.setBotChat(r4);
        r0.setBotMute(r10.H0);
        if (r0.isBotChat() == true) goto L11;
    L15:
        boolean r5 = false;
    L16:
        r0.setShowBotTag(r5);
        if (r0.isBotChat() == true) goto L19;
    L23:
        boolean r6 = false;
    L24:
        r0.setShowAgentTag(r6);
        r0.setChatType(r10.G);
        r0.setChatMode(r10.H);
        r0.setMeeting(r10.L);
        r0.setSecret(r10.K);
        r0.setUserCount(r10.b1);
        r0.setUserCountVisible(r10.g1);
        r0.setDepartment(r10.P);
        r0.setSuper(r10.Q);
        r0.setTenantChat(r10.R);
        r0.setPublic(r10.S);
        r0.setOfficialOncall(r10.T);
        r0.setOfflineOncall(r10.U);
        r0.setZenModeEndTime(r10.n);
        r0.setOnCallId(r10.Q1);
        r0.setMiniAvatarKey(r10.V0);
        r0.setP2pChatterId(r10.J);
        r0.setMyThreadUpdated(r10.g2);
        r0.setCrossWithKa(r10.V);
        r0.setFocusInfo(r10.Y);
        r0.setChatterApplyCount(r10.Z);
        r0.setSpecialFocus(r10.k0);
        r0.setTags(r10.W);
        r0.setStatus(r10.p2);
        r0.setChatRole(r10.x2);
        r0.setOrderAvatarKey(r10.H2);
        r0.setShowSwitch(r10.I2);
        List r7 = r10.h1;
        ArrayList<ChatTeamInfo> r8 = null;
        if (r7 != null) goto L27;
        ArrayList<Item> r9 = null;
    L28:
        r0.setItems(r9);
        r0.setFrozen(r10.J2);
        List r11 = r10.k1;
        if (r11 != null) goto L31;
        ArrayList<FeedTeamInfo> r12 = null;
    L32:
        r0.setJoinedTeamInfos(r12);
        List r13 = r10.p1;
        if (r13 == null) goto L36;
        r8 = new ArrayList(r13);
    L36:
        r0.setBoundTeamInfos(r8);
        r0.setAIMainChat(r10.v1);
        r0.setAIBotChat(r10.x1);
        r0.setChatAdmin(r10.y1);
        r0.setChatOwner(r10.G1);
        r0.setChatNotMemberType(r10.H1);
        r0.setLastHasSmartReply(r10.L1);
        r0.setChatReadable(r10.y2);
        r0.setStranger(r10.E2);
        r0.setBlocked(r10.F2);
        r0.setCanSetStranger(r10.G2);
        r0.setAtKnowledgeAiQueryStatus(r10.Q2);
        r0.setMuteNoticeType(r10.S2);
        r0.setRedBadge(r10.T2);
        r0.setDigestIsQuery(r10.R2);
        Context r14 = UIHelper.getContext();
        int r15 = LarkNameTag.d;
        LarkNameTag.d r16 = LarkNameTag.f.a(r14);
        r16.t = r0.isDepartment();
        r16.u = r0.isSuper();
        r16.v = r0.isTenantChat();
        r16.w = r0.isPublic();
        if (r0.getChatType() == r2) goto L39;
    L43:
        boolean r17 = false;
    L44:
        r16.x = r17;
        r16.q = r0.isSecret();
        r16.r = r0.isShowBotTag();
        r16.s = r0.isShowAgentTag();
        r16.p = r0.isMeeting();
        boolean r18 = r0.isShowOnCallTag();
        boolean r19 = r0.isOfflineOncall();
        r16.n = r18;
        r16.o = r19;
        if (r0.isOfficialOncall() == false) goto L47;
    L52:
        boolean r20 = true;
    L53:
        r16.y = r20;
        List<Tag> r21 = r0.getTags();
        Tag r22 = Tag.USER_RESIGNED;
        r16.A = r21.contains(r22);
        int r23 = com.ss.android.lark.feed.shared.data.utils.d.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.ss.android.lark.feed.shared.fg.c.a.isEnable("im.message.stranger") == true) goto L57;
        Log.i("FeedTagBlockJudge", "fg not open ");
        LarkNameTag.BlockLabelType r24 = LarkNameTag.BlockLabelType.NONE;
    L89:
        Intrinsics.checkNotNullParameter(r24, "value");
        r16.C = r24;
        ((LarkNameTag.c) r16).g = zz7.b.h(r14, 12);
        ((LarkNameTag.c) r16).h = zz7.b.g(r14, 12);
        ((LarkNameTag.c) r16).f = r0.isCrossWithKa();
        r16.z = false;
        TagData r110 = a0.a(r0.getTagData());
        if (r110 == null) goto L92;
        r16.g(TagData.parse(r110));
    L92:
        DrawableStateSet[] r111 = ((LarkNameTag.c) r16).c;
        if (r111 == null) goto L101;
        int r25 = r111.length;
    L95:
        if (r3 >= r25) goto L101;
        DrawableStateSet r26 = r111[r3];
        LinkedHashMap r27 = ((LarkNameTag.c) r16).d;
        Object r28 = r27.get(r26);
        if (r28 != null) goto L99;
        r28 = new UDTagsDrawable.a(((LarkNameTag.c) r16).a);
        r27.put(r26, r28);
    L99:
        ((UDTagsDrawable.a) r28).i = true;
        r3 = r3 + 1;
    L101:
        if (r0.isCrossWithKa() == false) goto L103;
        ((LarkNameTag.c) r16).f = true;
    L103:
        LarkNameTag r112 = r16.f();
        if (com.ss.android.lark.feed.shared.data.utils.e.b == null) goto L106;
    L115:
        com.ss.android.lark.feed.shared.data.utils.e.b.a(r0.getId(), r112, r112.b());
        r0.setFeedNameTag(r112);
        return r0;
    L106:
        monitor-enter(com.ss.android.lark.feed.shared.data.utils.e.class);
    L112:
        th = move-exception;
        throw th;
    L108:
        if (com.ss.android.lark.feed.shared.data.utils.e.b != null) goto L110;
        com.ss.android.lark.feed.shared.data.utils.e.b = new com.ss.android.lark.feed.shared.data.utils.e();     // Catch: Throwable -> L112
    L110:
        monitor-exit(com.ss.android.lark.feed.shared.data.utils.e.class);     // Catch: Throwable -> L112
        goto L115
    L57:
        if (r0.isSecret() == false) goto L60;
        Log.i("FeedTagBlockJudge", "current chat is secret chat chat = " + r0.getId());
        r24 = LarkNameTag.BlockLabelType.NONE;
        goto L89
    L60:
        if (r0.getTags().contains(r22) == false) goto L62;
    L88:
        Log.i("FeedTagBlockJudge", "current chat is unActive or frozen or resigned ka chat = " + r0.getId());
        r24 = LarkNameTag.BlockLabelType.NONE;
        goto L89
    L62:
        if (r0.getTags().contains(Tag.UNACTIVATED) == true) goto L88;
        if (r0.getTags().contains(Tag.FROZEN) == true) goto L88;
        Object r29 = k.a(LarkContext.getApplication(), oeb.d.class);
        if (r29 == null) goto L87;
        if (((oeb.d) r29).get() == true) goto L72;
        r24 = LarkNameTag.BlockLabelType.NONE;
        goto L89
    L72:
        if (r0.getCanSetStranger() != 0) goto L75;
        Log.d("FeedTagBlockJudge", "feed preview " + r0.getId() + ", can set stranger null");
        r24 = LarkNameTag.BlockLabelType.NONE;
        goto L89
    L75:
        if (r0.getCanSetStranger() != 1) goto L83;
        if (r0.isBlocked() == false) goto L80;
        r24 = LarkNameTag.BlockLabelType.TOTAL_BLOCKED;
        goto L89
    L80:
        if (r0.isStranger() == false) goto L85;
        r24 = LarkNameTag.BlockLabelType.STRANGER;
    L85:
        r24 = LarkNameTag.BlockLabelType.NONE;
        goto L89
    L83:
        if (r0.isBlocked() == false) goto L85;
        r24 = LarkNameTag.BlockLabelType.BLOCK;
        goto L89
    L87:
        throw new IllegalStateException("Required value was null.".toString());
    L47:
        if (CollectionUtils.isEmpty(r0.getTags()) == false) goto L49;
    L51:
        r20 = false;
        goto L53
    L49:
        if (r0.getTags().contains(Tag.OFFICIAL) == false) goto L51;
    L39:
        if (r0.isBotChat() == true) goto L43;
        if (heb.a.a.getSettingDependency().isInZenMode(r0.getZenModeEndTime()) == false) goto L43;
        r17 = true;
        goto L44
    L31:
        r12 = new ArrayList(r11);
        goto L32
    L27:
        r9 = new ArrayList(r7);
        goto L28
    L19:
        if (Chatter.BOT_TAG.equals(r10.M) == false) goto L23;
        if (r10.N == false) goto L23;
        r6 = true;
        goto L24
    L11:
        if (Chatter.BOT_TAG.equals(r10.M) == false) goto L15;
        if (r10.N == true) goto L15;
        r5 = true;
        goto L16
    L5:
        if (r10.I != Chatter.ChatterType.BOT) goto L7;
        r4 = true;
        goto L8
    }

    @Override // leb.b
    public final void d(FeedPreview r1, FeedPreviewInfo r2) {
        a(r1, r2);
        b.b(r1);
    }
}
