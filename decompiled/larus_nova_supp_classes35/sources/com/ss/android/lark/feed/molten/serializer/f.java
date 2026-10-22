package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.feed.app.entity.AutoMuteSettingNoticeType;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.FeedCardButton;
import com.ss.android.lark.feed.app.entity.MutexMarkType;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements meb.e {
    public final TypeAdapter<FeedCard.Type> a;
    public final TypeAdapter<FeedCard.FeedType> b;
    public final TypeAdapter<AppFeedCardType> c;
    public final TypeAdapter<Chat.ChatMode> d;
    public final TypeAdapter<List<UrgentInfo>> e;
    public final TypeAdapter<MutexMarkType> f;
    public final TypeAdapter<UIFeedCard.AtInfo> g;
    public final TypeAdapter<List<DigestElement>> h;
    public final TypeAdapter<List<Reaction>> i;
    public final TypeAdapter<AutoMuteSettingNoticeType> j;
    public final TypeAdapter<List<FeedCardButton>> k;
    public final Field l;
    public final Field m;
    public final Field n;
    public final Field o;
    public final Field p;

    @Override // meb.e
    public final void a(JsonObject r5, UIFeedCard r6) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r6, "value");
        a.j(r5, "id", r6.getId());
        a.i(r5, "entityType", r6.getType(), this.a);
        a.i(r5, "feedType", r6.getFeedType(), this.b);
        a.i(r5, "bizType", r6.getBizType(), this.c);
        a.j(r5, "bizId", r6.getBizId());
        a.j(r5, Keys.API_RETURN_KEY_APP_ID, r6.getAppId());
        a.j(r5, "uid", r6.getUid());
        a.g(r5, "checkUser", Boolean.valueOf(r6.isCheckUser()));
        a.h(r5, "updateTime", Long.valueOf(r6.getUpdateTime()));
        a.h(r5, "rankTime", Long.valueOf(r6.getRankTime()));
        a.h(r5, "displayTime", Long.valueOf(r6.getDisplayTime()));
        a.h(r5, "rankPriority", Long.valueOf(r6.getRankPriority()));
        a.g(r5, "isSwipedLeftPinned", Boolean.valueOf(r6.isSwipedLeftPinned()));
        a.g(r5, "isSwipeRightPinned", Boolean.valueOf(r6.isSwipeRightPinned()));
        a.j(r5, "parentCardId", r6.getParentCardId());
        a.i(r5, "chatMode", r6.getChatMode(), this.d);
        a.g(r5, "isOfflineOncall", Boolean.valueOf(r6.getOfflineOncall()));
        a.h(r5, "shortcutPosition", Integer.valueOf(r6.getShortcutPosition()));
        a.g(r5, "isDisplayInShortcut", Boolean.valueOf(r6.getIsDisplayInShortcut()));
        a.h(r5, "markType", Integer.valueOf(r6.getMarkType()));
        a.a(r5, "urgentInfos", r6.getUrgentInfos(), this.e);
        a.g(r5, "isStranger", Boolean.valueOf(r6.isStranger()));
        a.g(r5, "isBlocked", Boolean.valueOf(r6.isBlocked()));
        a.h(r5, "canSetStranger", Integer.valueOf(r6.getCanSetStranger()));
        Object r0 = this.l.get(r6);
        List r2 = null;
        if ((r0 instanceof MutexMarkType) == false) goto L5;
        MutexMarkType r1 = (MutexMarkType) r0;
    L6:
        a.i(r5, "mutexMarkType", r1, this.f);
        a.j(r5, "draftMessage", r6.getDraftMessage());
        a.g(r5, "isRemind", Boolean.valueOf(r6.isRemind()));
        a.g(r5, "isShortCutFeed", Boolean.valueOf(r6.isShortCut()));
        a.h(r5, "onTopRankTime", Long.valueOf(r6.getOnTopRankTime()));
        a.g(r5, "isFake", Boolean.valueOf(r6.getIsFake()));
        a.g(r5, "isPriorityProcessing", Boolean.valueOf(r6.getIsPriorityProcessing()));
        a.g(r5, "isFirstTopRank", Boolean.valueOf(r6.getIsFirstTopRank()));
        a.g(r5, "isExpiredFoldHint", Boolean.valueOf(r6.getIsExpiredFoldHint()));
        a.g(r5, "isFlag", Boolean.valueOf(r6.isFlag()));
        a.j(r5, IPortraitService.NAME, r6.getName());
        a.j(r5, "avatarId", r6.getAvatarId());
        a.j(r5, "avatarKey", r6.getAvatarKey());
        a.h(r5, "unreadCount", Long.valueOf(r6.getUnreadCount()));
        a.i(r5, "atInfo", r6.getAtInfo(), this.g);
        a.a(r5, "digestMessage", r6.getDigestMessage(), this.h);
        Object r3 = this.p.get(r6);
        if ((r3 instanceof List) == false) goto L9;
        List r4 = (List) r3;
    L10:
        a.a(r5, "draftDigestMessage", r4, this.h);
        a.g(r5, "isCrossTenant", Boolean.valueOf(r6.isCrossTenant()));
        Object r7 = this.m.get(r6);
        if ((r7 instanceof List) == false) goto L13;
        r2 = (List) r7;
    L13:
        a.a(r5, "reactions", r2, this.i);
        a.h(r5, "reactionCount", Integer.valueOf(this.n.getInt(r6)));
        a.h(r5, "reactionDisplayCount", Integer.valueOf(this.o.getInt(r6)));
        a.i(r5, "muteNoticeType", r6.getMuteNoticeType(), this.j);
        a.g(r5, "isRedBadge", Boolean.valueOf(r6.isRedBadge()));
        a.g(r5, "isFlowMainBot", Boolean.valueOf(r6.getIsFlowMainBot()));
        a.a(r5, "feedCardButtons", r6.getFeedCardButtons(), this.k);
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // meb.e
    public final void b(JsonObject r7, UIFeedCard r8) {
        Intrinsics.checkNotNullParameter(r7, "json");
        Intrinsics.checkNotNullParameter(r8, "value");
        r8.setId(a.l(r7, "id"));
        FeedCard.Type r0 = (FeedCard.Type) a.k(r7, "entityType", this.a);
        if (r0 == null) goto L5;
        r8.setType(r0);
    L5:
        FeedCard.FeedType r1 = (FeedCard.FeedType) a.k(r7, "feedType", this.b);
        if (r1 == null) goto L8;
        r8.setFeedType(r1);
    L8:
        AppFeedCardType r2 = (AppFeedCardType) a.k(r7, "bizType", this.c);
        if (r2 == null) goto L11;
        r8.setBizType(r2);
    L11:
        r8.setBizId(a.l(r7, "bizId"));
        r8.setAppId(a.l(r7, Keys.API_RETURN_KEY_APP_ID));
        r8.setUid(a.l(r7, "uid"));
        Boolean r3 = a.c(r7, "checkUser");
        boolean r4 = false;
        if (r3 == null) goto L14;
        boolean r5 = r3.booleanValue();
    L15:
        r8.setCheckUser(r5);
        Long r6 = a.f(r7, "updateTime");
        long r9 = 0;
        if (r6 == null) goto L18;
        long r10 = r6.longValue();
    L19:
        r8.setUpdateTime(r10);
        Long r11 = a.f(r7, "rankTime");
        if (r11 == null) goto L22;
        long r12 = r11.longValue();
    L23:
        r8.setRankTime(r12);
        Long r13 = a.f(r7, "displayTime");
        if (r13 == null) goto L26;
        long r14 = r13.longValue();
    L27:
        r8.setDisplayTime(r14);
        Long r15 = a.f(r7, "rankPriority");
        if (r15 == null) goto L30;
        long r16 = r15.longValue();
    L31:
        r8.setRankPriority(r16);
        Boolean r17 = a.c(r7, "isSwipedLeftPinned");
        if (r17 == null) goto L34;
        boolean r18 = r17.booleanValue();
    L35:
        r8.setSwipedLeftPinned(r18);
        Boolean r19 = a.c(r7, "isSwipeRightPinned");
        if (r19 == null) goto L38;
        boolean r20 = r19.booleanValue();
    L39:
        r8.setSwipeRightPinned(r20);
        r8.setParentCardId(a.l(r7, "parentCardId"));
        Chat.ChatMode r21 = (Chat.ChatMode) a.k(r7, "chatMode", this.d);
        if (r21 == null) goto L42;
        r8.setChatMode(r21);
    L42:
        Boolean r22 = a.c(r7, "isOfflineOncall");
        if (r22 == null) goto L45;
        boolean r23 = r22.booleanValue();
    L46:
        r8.setOfflineOncall(r23);
        Integer r24 = a.e(r7, "shortcutPosition");
        if (r24 == null) goto L49;
        int r25 = r24.intValue();
    L50:
        r8.setShortcutPosition(r25);
        Boolean r26 = a.c(r7, "isDisplayInShortcut");
        if (r26 == null) goto L53;
        boolean r27 = r26.booleanValue();
    L54:
        r8.setIsDisplayInShortcut(r27);
        Integer r28 = a.e(r7, "markType");
        if (r28 == null) goto L57;
        int r29 = r28.intValue();
    L58:
        r8.setMarkType(r29);
        List r30 = a.b(r7, "urgentInfos", this.e);
        if (r30 != null) goto L61;
        r30 = CollectionsKt.emptyList();
    L61:
        r8.setUrgentInfos(new ArrayList(r30));
        Boolean r31 = a.c(r7, "isStranger");
        if (r31 == null) goto L64;
        boolean r32 = r31.booleanValue();
    L65:
        r8.setStranger(r32);
        Boolean r33 = a.c(r7, "isBlocked");
        if (r33 == null) goto L68;
        boolean r34 = r33.booleanValue();
    L69:
        r8.setBlocked(r34);
        Integer r35 = a.e(r7, "canSetStranger");
        if (r35 == null) goto L72;
        int r36 = r35.intValue();
    L73:
        r8.setCanSetStranger(r36);
        r8.setMutexMarkType((MutexMarkType) a.k(r7, "mutexMarkType", this.f));
        r8.setDraftMessage(a.l(r7, "draftMessage"));
        Boolean r37 = a.c(r7, "isRemind");
        if (r37 == null) goto L76;
        boolean r38 = r37.booleanValue();
    L77:
        r8.setRemind(r38);
        Boolean r39 = a.c(r7, "isShortCutFeed");
        if (r39 == null) goto L80;
        boolean r40 = r39.booleanValue();
    L81:
        r8.setShortCut(r40);
        Long r41 = a.f(r7, "onTopRankTime");
        if (r41 == null) goto L84;
        long r42 = r41.longValue();
    L85:
        r8.setOnTopRankTime(r42);
        Boolean r43 = a.c(r7, "isFake");
        if (r43 == null) goto L88;
        boolean r44 = r43.booleanValue();
    L89:
        r8.setIsFake(r44);
        Boolean r45 = a.c(r7, "isPriorityProcessing");
        if (r45 == null) goto L92;
        boolean r46 = r45.booleanValue();
    L93:
        r8.setIsPriorityProcessing(r46);
        Boolean r47 = a.c(r7, "isFirstTopRank");
        if (r47 == null) goto L96;
        boolean r48 = r47.booleanValue();
    L97:
        r8.setIsFirstTopRank(r48);
        Boolean r49 = a.c(r7, "isExpiredFoldHint");
        if (r49 == null) goto L100;
        boolean r50 = r49.booleanValue();
    L101:
        r8.setIsExpiredFoldHint(r50);
        Boolean r51 = a.c(r7, "isFlag");
        if (r51 == null) goto L104;
        boolean r52 = r51.booleanValue();
    L105:
        r8.setFlag(r52);
        r8.setName(a.l(r7, IPortraitService.NAME));
        r8.setAvatarId(a.l(r7, "avatarId"));
        r8.setAvatarKey(a.l(r7, "avatarKey"));
        Long r53 = a.f(r7, "unreadCount");
        if (r53 == null) goto L108;
        r9 = r53.longValue();
    L108:
        r8.setUnreadCount(r9);
        r8.setAtInfo((UIFeedCard.AtInfo) a.k(r7, "atInfo", this.g));
        List r54 = a.b(r7, "digestMessage", this.h);
        ArrayList<DigestElement> r55 = null;
        if (r54 == null) goto L111;
        ArrayList<DigestElement> r56 = new ArrayList(r54);
    L112:
        r8.setDigestMessage(r56);
        List r57 = a.b(r7, "draftDigestMessage", this.h);
        if (r57 == null) goto L115;
        r55 = new ArrayList(r57);
    L115:
        r8.setDraftDigestMessage(r55);
        Boolean r58 = a.c(r7, "isCrossTenant");
        if (r58 == null) goto L118;
        boolean r59 = r58.booleanValue();
    L119:
        r8.setCrossTenant(r59);
        List r60 = a.b(r7, "reactions", this.i);
        if (r60 != null) goto L122;
        r60 = CollectionsKt.emptyList();
    L122:
        r8.setReactions(new ArrayList(r60));
        Integer r61 = a.e(r7, "reactionCount");
        if (r61 == null) goto L125;
        int r62 = r61.intValue();
    L126:
        r8.setReactionCount(r62);
        Integer r63 = a.e(r7, "reactionDisplayCount");
        if (r63 == null) goto L129;
        int r64 = r63.intValue();
    L130:
        r8.setReactionDisplayCount(r64);
        AutoMuteSettingNoticeType r65 = (AutoMuteSettingNoticeType) a.k(r7, "muteNoticeType", this.j);
        if (r65 == null) goto L133;
        r8.setMuteNoticeType(r65);
    L133:
        Boolean r66 = a.c(r7, "isRedBadge");
        if (r66 == null) goto L136;
        boolean r67 = r66.booleanValue();
    L137:
        r8.setRedBadge(r67);
        Boolean r68 = a.c(r7, "isFlowMainBot");
        if (r68 == null) goto L140;
        r4 = r68.booleanValue();
    L140:
        r8.setIsFlowMainBot(r4);
        List r69 = a.b(r7, "feedCardButtons", this.k);
        if (r69 != null) goto L143;
        r69 = CollectionsKt.emptyList();
    L143:
        r8.setFeedCardButtons(new ArrayList(r69));
        return;
    L136:
        r67 = false;
        goto L137
    L129:
        r64 = 0;
        goto L130
    L125:
        r62 = 0;
        goto L126
    L118:
        r59 = false;
        goto L119
    L111:
        r56 = null;
        goto L112
    L104:
        r52 = false;
        goto L105
    L100:
        r50 = false;
        goto L101
    L96:
        r48 = false;
        goto L97
    L92:
        r46 = false;
        goto L93
    L88:
        r44 = false;
        goto L89
    L84:
        r42 = 0;
        goto L85
    L80:
        r40 = false;
        goto L81
    L76:
        r38 = false;
        goto L77
    L72:
        r36 = 0;
        goto L73
    L68:
        r34 = false;
        goto L69
    L64:
        r32 = false;
        goto L65
    L57:
        r29 = 0;
        goto L58
    L53:
        r27 = false;
        goto L54
    L49:
        r25 = 0;
        goto L50
    L45:
        r23 = false;
        goto L46
    L38:
        r20 = false;
        goto L39
    L34:
        r18 = false;
        goto L35
    L30:
        r16 = 0;
        goto L31
    L26:
        r14 = 0;
        goto L27
    L22:
        r12 = 0;
        goto L23
    L18:
        r10 = 0;
        goto L19
    L14:
        r5 = false;
        goto L15
    }

    public f(TypeAdapter r2, TypeAdapter r3, WireEnumTypeAdapter r4, TypeAdapter r5, ListTypeAdapter r6, TypeAdapter r7, UIFeedCardAtInfoTypeAdapter r8, ListTypeAdapter r9, ListTypeAdapter r10, TypeAdapter r11, ListTypeAdapter r12) {
        Intrinsics.checkNotNullParameter(r2, "entityTypeAdapter");
        Intrinsics.checkNotNullParameter(r3, "feedTypeAdapter");
        Intrinsics.checkNotNullParameter(r4, "bizTypeAdapter");
        Intrinsics.checkNotNullParameter(r5, "chatModeAdapter");
        Intrinsics.checkNotNullParameter(r6, "urgentInfoListAdapter");
        Intrinsics.checkNotNullParameter(r7, "mutexMarkTypeAdapter");
        Intrinsics.checkNotNullParameter(r8, "atInfoAdapter");
        Intrinsics.checkNotNullParameter(r9, "digestElementListAdapter");
        Intrinsics.checkNotNullParameter(r10, "reactionListAdapter");
        Intrinsics.checkNotNullParameter(r11, "muteNoticeTypeAdapter");
        Intrinsics.checkNotNullParameter(r12, "feedCardButtonListAdapter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        Field r13 = UIFeedCard.class.getDeclaredField("mutexMarkType");
        r13.setAccessible(true);
        this.l = r13;
        Field r14 = UIFeedCard.class.getDeclaredField("reactions");
        r14.setAccessible(true);
        this.m = r14;
        Field r15 = UIFeedCard.class.getDeclaredField("reactionCount");
        r15.setAccessible(true);
        this.n = r15;
        Field r16 = UIFeedCard.class.getDeclaredField("reactionDisplayCount");
        r16.setAccessible(true);
        this.o = r16;
        Field r17 = UIFeedCard.class.getDeclaredField("draftDigestMessage");
        r17.setAccessible(true);
        this.p = r17;
    }
}
