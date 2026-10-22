package com.ss.android.lark.flow.feed.cell.contact;

import com.bytedance.lark.pb.basic.v1.FeedButtonData;
import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.feed.v1.AppFeedCard;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.bytedance.lark.pb.feed.v1.Digest;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.feed.app.entity.AutoMuteSettingNoticeType;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.EmojiProperty;
import com.ss.android.lark.feed.app.entity.MutexMarkType;
import com.ss.android.lark.feed.app.entity.TextProperty;
import com.ss.android.lark.feed.app.entity.TextWithEmojiProperty;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements f {
    public c() {
    }

    public final FeedPreviewInfo a(FeedEntityPreview r8) {
        Intrinsics.checkNotNullParameter(r8, "pbFeed");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        FeedPreviewInfo r0 = beb.b.c(r8);
        AppFeedCard r9 = r8.app_feed_card_data;
        String r1 = "";
        if (r9 == null) goto L8;
        AppFeedCard.TitleData r2 = r9.title_data;
        if (r2 == null) goto L8;
        String r3 = r2.title;
        if (r3 == null) goto L8;
    L9:
        r0.g = r3;
        r0.d = FeedCard.Type.APP_FEED;
        long r4 = 0;
        if (r9 == null) goto L16;
        AppFeedCard.FeedDefaultData r5 = r9.feed_default_data;
        if (r5 == null) goto L16;
        Long r6 = r5.rank_time;
        if (r6 == null) goto L16;
        long r7 = r6.longValue();
    L17:
        r0.l = r7;
        boolean r10 = false;
        if (r9 == null) goto L24;
        AppFeedCard.FeedDefaultData r11 = r9.feed_default_data;
        if (r11 == null) goto L24;
        Boolean r12 = r11.is_shortcut;
        if (r12 == null) goto L24;
        boolean r13 = r12.booleanValue();
    L25:
        r0.o = r13;
        if (r9 == null) goto L32;
        AppFeedCard.DisplayTimeData r14 = r9.display_time_data;
        if (r14 == null) goto L32;
        Long r15 = r14.display_time_ms;
        if (r15 == null) goto L32;
        long r16 = r15.longValue();
    L33:
        r0.k = r16;
        List r17 = null;
        if (r9 == null) goto L38;
        AppFeedCard.PreviewData r18 = r9.preview_data;
        if (r18 == null) goto L38;
        Digest r19 = beb.b.a(r18);
    L39:
        r0.p0 = r19;
        if (r9 == null) goto L45;
        AppFeedCard.PreviewData r20 = r9.preview_data;
        if (r20 == null) goto L45;
        AppFeedCard.PreviewStatus r21 = r20.status;
        if (r21 == null) goto L45;
    L46:
        r0.O2 = r21;
        if (r9 == null) goto L53;
        AppFeedCard.AvatarData r22 = r9.avatar_data;
        if (r22 == null) goto L53;
        Image r23 = r22.avatar;
        if (r23 == null) goto L53;
        String r24 = r23.key;
    L54:
        r0.f = r24;
        if (r9 == null) goto L61;
        AppFeedCard.BadgeData r25 = r9.badge_data;
        if (r25 == null) goto L61;
        Long r26 = r25.badge;
        if (r26 == null) goto L61;
        r4 = r26.longValue();
    L61:
        r0.i = r4;
        if (r9 == null) goto L70;
        AppFeedCard.SettingData r27 = r9.setting_data;
        if (r27 == null) goto L70;
        Boolean r28 = r27.mute;
        if (r28 == null) goto L70;
        if (r28.booleanValue() == true) goto L70;
        r10 = true;
    L70:
        r0.j = r10;
        if (r9 == null) goto L73;
        Long r29 = r9.app_id;
    L74:
        r0.V1 = String.valueOf(r29);
        if (r9 == null) goto L80;
        String r30 = r9.biz_id;
        if (r30 == null) goto L80;
        r1 = r30;
    L80:
        if (r9 == null) goto L83;
        AppFeedCardType r31 = r9.type;
        if (r31 == null) goto L83;
    L84:
        if (r9 == null) goto L89;
        AppFeedCard.ExtraData r32 = r9.biz_extra_data;
        if (r32 == null) goto L89;
        ByteString r33 = r32.extra_data;
        if (r33 == null) goto L89;
    L90:
        if (r9 == null) goto L94;
        AppFeedCard.ExtraData r34 = r9.biz_extra_data;
        if (r34 == null) goto L94;
        AppFeedCard.ExtraData.BizFields r35 = r34.biz_fields;
    L95:
        r0.N2 = new com.ss.android.lark.biz.im.api.c(r31, r1, r33, r35);
        int r36 = beb.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.im.feed.feed_button") == false) goto L102;
        if (r9 == null) goto L101;
        FeedButtonData r37 = r9.button_data;
        if (r37 == null) goto L101;
        r17 = r37.buttons;
    L101:
        r0.P2 = r17;
    L102:
        return r0;
    L94:
        r35 = null;
    L89:
        r33 = ByteString.EMPTY;
    L83:
        r31 = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        goto L84
    L73:
        r29 = null;
    L53:
        r24 = null;
    L45:
        r21 = AppFeedCard.PreviewStatus.PREVIEW_NORMAL;
    L38:
        r19 = null;
    L32:
        r16 = 0;
    L24:
        r13 = false;
    L16:
        r7 = 0;
    L8:
        r3 = "";
        goto L9
    }

    public final UIFeedCard b(FeedPreviewInfo r9) {
        Intrinsics.checkNotNullParameter(r9, "feedPreviewInfo");
        ContactUiFeedCard r1 = new ContactUiFeedCard();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r9, "feedPreviewInfo");
        r1.setId(r9.a);
        r1.setType(r9.d);
        r1.setFeedType(r9.e);
        com.ss.android.lark.biz.im.api.c r0 = r9.N2;
        if (r0 == null) goto L5;
        AppFeedCardType r2 = r0.a;
    L6:
        r1.setBizType(r2);
        String r3 = r9.h;
        if (r3 != null) goto L13;
        com.ss.android.lark.biz.im.api.c r4 = r9.N2;
        if (r4 == null) goto L12;
        r3 = r4.b;
        goto L13
    L12:
        r3 = "";
    L13:
        r1.setBizId(r3);
        r1.setAppId(r9.V1);
        r1.setUid(r9.b);
        r1.setCheckUser(r9.c);
        r1.setUpdateTime(r9.m);
        r1.setRankTime(r9.l);
        r1.setDisplayTime(r9.k);
        r1.setParentCardId(r9.P1);
        r1.setRemind(r9.j);
        r1.setShortCut(r9.o);
        r1.setFlag(r9.A);
        r1.setName(r9.g);
        r1.setAvatarId(r9.a());
        r1.setAvatarKey(r9.f);
        r1.setUnreadCount(r9.i);
        FeedPreviewInfo.AtInfo r5 = r9.p;
        ArrayList r6 = null;
        if (r5 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UIFeedCard.AtInfo r7 = new UIFeedCard.AtInfo(r5.a, r5.e, r5.c);
        r7.setAtDisplayTime(r5.g);
        r7.setAtRankTime(r5.f);
        r7.setAtContent(r5.h);
        r7.setAtType(AtInfo.AtType.fromValue(r5.b.getValue()));
    L17:
        r1.setAtInfo(r7);
        Digest r8 = r9.p0;
        if (r8 == null) goto L61;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        List r10 = r8.elements;
        if (r10 == null) goto L53;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L23:
        if (r12.hasNext() == false) goto L54;
        Digest.Element r13 = (Digest.Element) r12.next();
        Digest.Element.Tag r14 = r13.tag;
        if (r14 != null) goto L27;
        int r15 = -1;
    L29:
        if (r15 != 1) goto L31;
        Digest.Element.TextProperty r16 = r13.text;
        if (r16 == null) goto L50;
        String r17 = r16.content;
        if (r17 == null) goto L50;
        TextWithEmojiProperty r18 = new TextProperty(r17);
    L51:
        if (r18 == null) goto L23;
        r11.add(r18);
    L50:
        r18 = null;
        goto L51
    L31:
        if (r15 != 2) goto L33;
        Digest.Element.EmojiProperty r19 = r13.emoji;
        if (r19 == null) goto L50;
        String r20 = r19.emoji_key;
        if (r20 == null) goto L50;
        r18 = new EmojiProperty(r20, r19.default_content);
        goto L51
    L33:
        if (r15 != 3) goto L50;
        Digest.Element.TextProperty r21 = r13.text;
        if (r21 == null) goto L50;
        String r22 = r21.content;
        if (r22 == null) goto L50;
        r18 = new TextWithEmojiProperty(r22);
        goto L51
    L27:
        r15 = beb.b.a.a[r14.ordinal()];
    L54:
        ArrayList r23 = new ArrayList();
        if (r11 == null) goto L61;
        Iterator r24 = r11.iterator();
    L58:
        if (r24.hasNext() == false) goto L60;
        r23.add((DigestElement) r24.next());
        goto L58
    L60:
        r6 = r23;
        goto L61
    L53:
        r11 = null;
    L61:
        r1.setDigestMessage(r6);
        r1.setOnTopRankTime(r9.K2);
        r1.setIsPriorityProcessing(r9.L2);
        r1.setFeedCardButtons(beb.b.b(r9.P2));
        AppFeedCard.PreviewStatus r25 = r9.O2;
        if (r25 != AppFeedCard.PreviewStatus.ERROR) goto L65;
        MutexMarkType r26 = MutexMarkType.FAILED;
    L68:
        r1.setMutexMarkType(r26);
        r1.setMuteNoticeType(AutoMuteSettingNoticeType.Companion.valueOf(Integer.valueOf(r9.S2.getNumber())));
        r1.setRedBadge(r9.T2);
        return r1;
    L65:
        if (r25 != AppFeedCard.PreviewStatus.EDITING) goto L67;
        r26 = MutexMarkType.DRAFT;
        goto L68
    L67:
        r26 = MutexMarkType.UNKNOWN;
        goto L68
    L16:
        r7 = null;
        goto L17
    L5:
        r2 = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        goto L6
    }

    public final boolean c(FeedEntityPreview r2) {
        Intrinsics.checkNotNullParameter(r2, "pbFeed");
        AppFeedCard r3 = r2.app_feed_card_data;
        if (r3 == null) goto L5;
        AppFeedCardType r4 = r3.type;
    L7:
        if (r4 != AppFeedCardType.CONTACT) goto L9;
        return true;
    L9:
        return false;
    L5:
        r4 = null;
        goto L7
    }
}
