package com.ss.android.lark.flow.feed.cell.chat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.AvatarType;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.ChatNotMemberType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.feed.cardcomponent.bottomaction.FeedCardButtonsComponent;
import com.ss.android.lark.feed.cardcomponent.preview.e;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.feed.page.FlowHumanFeedItemsFragment;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements h {
    public static final int k = 0;
    public com.ss.android.lark.feed.cardcomponent.teams.b a;
    public com.ss.android.lark.feed.cardcomponent.avatar.a b;
    public ehb.a c;
    public xdb.a d;
    public com.ss.android.lark.flow.feed.component.preview.a e;
    public e f;
    public com.ss.android.lark.flow.feed.component.badge.a g;
    public FeedCardButtonsComponent h;
    public UIFeedCard i;
    public com.ss.android.lark.feed.export.feedcard.d j;

    public static final class a {
    }

    public b() {
    }

    public final void onViewAttachedToWindow() {
    }

    public final void onViewDetachedFromWindow() {
    }

    public final void onViewRecycled() {
    }

    static {
        k = UIHelper.dp2px(8.0f);
    }

    public final void c() {
        UIFeedCard r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.feed.export.feedcard.d r1 = this.j;
        if (r1 != null) goto L8;
        return;
    L8:
        fhb.a.f(r0, fhb.a.b(r1));
    }

    public final com.ss.android.lark.feed.export.feedcard.a a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "itemView");
        this.a = new com.ss.android.lark.feed.cardcomponent.teams.b(r11.getContext());
        this.b = new com.ss.android.lark.feed.cardcomponent.avatar.a(r11.getContext(), 60);
        this.c = new ehb.a(r11.getContext());
        this.d = new xdb.a(r11.getContext());
        this.e = new com.ss.android.lark.flow.feed.component.preview.a(r11.getContext());
        this.g = new com.ss.android.lark.flow.feed.component.badge.a(r11.getContext());
        this.f = new e(r11.getContext());
        this.h = new FeedCardButtonsComponent(r11.getContext());
        com.ss.android.lark.feed.cardcomponent.avatar.a r0 = this.b;
        FeedCardButtonsComponent r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        com.ss.android.lark.feed.cardcomponent.avatar.a r2 = null;
    L6:
        com.ss.android.lark.feed.cardcomponent.teams.b r3 = this.a;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("teamsComponent");
        com.ss.android.lark.feed.cardcomponent.teams.b r4 = null;
    L10:
        FeedCardComponent[] r5 = new FeedCardComponent[1];
        ehb.a r6 = this.c;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r6 = null;
    L13:
        r5[0] = r6;
        FeedCardComponent[] r7 = new FeedCardComponent[1];
        xdb.a r8 = this.d;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("titleRightComponent");
        r8 = null;
    L16:
        r7[0] = r8;
        FeedCardComponent[] r9 = new FeedCardComponent[2];
        com.ss.android.lark.flow.feed.component.preview.a r10 = this.e;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("previewComponent");
        r10 = null;
    L19:
        r9[0] = r10;
        com.ss.android.lark.flow.feed.component.badge.a r12 = this.g;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
        r12 = null;
    L22:
        r9[1] = r12;
        FeedCardComponent[] r13 = new FeedCardComponent[1];
        FeedCardButtonsComponent r14 = this.h;
        if (r14 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("buttonsComponent");
    L26:
        r13[0] = r1;
        return new com.ss.android.lark.feed.export.feedcard.a(r2, r4, r5, r7, r9, r13, null, 289);
    L25:
        r1 = r14;
        goto L26
    L9:
        r4 = r3;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    public final void b(View r20, UIFeedCard r21, com.ss.android.lark.feed.export.feedcard.c r22, com.ss.android.lark.feed.export.feedcard.d r23) {
        Intrinsics.checkNotNullParameter(r20, "itemView");
        Intrinsics.checkNotNullParameter(r21, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r22, "paramsFactory");
        Intrinsics.checkNotNullParameter(r23, "feedCardContext");
        this.i = r21;
        this.j = r23;
        if ((r21 instanceof ChatFeedPreview) == false) goto L5;
        ChatFeedPreview r5 = (ChatFeedPreview) r21;
    L6:
        if (r5 != null) goto L9;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatCell", "onBindView: unsupported id=" + r21.getId() + ", card=" + r21.getClass().getSimpleName());
        return;
    L9:
        Guideline r0 = r20.findViewById(2131372231);
        ArrayList r7 = r5.getJoinedTeamInfos();
        boolean r8 = true;
        int r9 = 0;
        if (r7 != null) goto L12;
    L15:
        boolean r10 = true;
    L17:
        if (r10 == false) goto L19;
        r0.setGuidelineBegin(k + (zz7.b.g(r20.getContext(), 48) / 2));
    L20:
        Context r1 = r20.getContext();
        if (r5.getChatType() != Chat.Type.P2P) goto L23;
        uz7.a.a r11 = new uz7.a.a();
        r11.k = r5.getP2pChatterId();
        r11.b(r5.getAvatarKey());
        r11.f(r5.getP2pChatterId());
        r11.a(false);
        uz7.a r12 = new uz7.a(r11);
    L24:
        String r13 = r5.getMiniAvatarKey();
        if (r13 != null) goto L27;
    L30:
        boolean r14 = true;
    L31:
        if (r14 == true) goto L34;
        wz7.d r15 = new wz7.d(null, 3);
        r15.c = r5.getMiniAvatarKey();
    L36:
        wz7.d r16 = r15;
    L39:
        if (r5.getShowSwitch() == true) goto L41;
    L43:
        String r17 = null;
    L44:
        boolean r18 = r5.isContainMarkType(UIFeedCard.MarkType.URGENT);
        if (r5.getFeedType() != FeedCard.FeedType.DONE) goto L47;
        boolean r19 = true;
    L48:
        tdb.a r110 = afb.a.a(r5, r19);
        com.ss.android.lark.feed.export.feedcard.b r111 = new com.ss.android.lark.feed.export.feedcard.b(r12, r17, r18, false);
        if (r5.getChatRole() != Chat.Role.MEMBER) goto L51;
    L57:
        Drawable r112 = null;
    L58:
        com.ss.android.lark.feed.cardcomponent.avatar.a.b r24 = new com.ss.android.lark.feed.cardcomponent.avatar.a.b(r111, r110, r16, r112, 16);
        FeedCardComponent r2 = this.a;
        if (r2 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("teamsComponent");
        r2 = null;
    L61:
        ArrayList r113 = r5.getJoinedTeamInfos();
        com.ss.android.lark.feed.cardcomponent.teams.b.b r114 = new com.ss.android.lark.feed.cardcomponent.teams.b.b(r113);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r114, "data");
        if (r113 != null) goto L64;
    L67:
        boolean r115 = true;
    L68:
        if (r115 == false) goto L70;
        r2.c().setVisibility(8);
    L71:
        com.ss.android.lark.feed.cardcomponent.avatar.a r3 = this.b;
        if (r3 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        r3 = null;
    L74:
        r3.d(r24);
        ehb.a r4 = this.c;
        if (r4 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        ehb.a r116 = null;
    L78:
        Context r117 = r20.getContext();
        if (TextUtils.isEmpty(r5.getName()) == true) goto L81;
    L83:
        String r6 = r5.getName();
    L84:
        String r118 = r6;
        ArrayList r119 = new ArrayList();
        boolean r120 = r23.getHost() instanceof FlowHumanFeedItemsFragment;
        qtb.b r25 = (qtb.b) LarkContext.spiByDwarf(qtb.b.class);     // Catch: Throwable -> L87
    L89:
        if (r25 != null) goto L91;
    L93:
        boolean r26 = false;
    L94:
        if (r26 == false) goto L99;
        if (r120 == true) goto L99;
        if (r5.getChatType() != Chat.Type.P2P) goto L99;
        xdb.a r121 = null;
        FlowTagView r27 = new FlowTagView(r117, null, 6, 0);
        r27.setText(UIHelper.getString(2131890013));
        r27.setTextSize(11.0f);
        r27.setTextColor(UIUtils.getColor(r117, 2131102000));
        r27.setIcon(UIUtils.getDrawable(r117, 2131237907));
        r27.setTagBackgroundColor(ContextCompat.getColor(r117, 2131101999));
        r119.add(new com.ss.android.lark.flow.feed.component.title.a.b(r27));
    L101:
        if (r5.isRemind() == true) goto L103;
        r119.add(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r117, 2131237908)));
    L103:
        Intrinsics.checkNotNull(r118);
        r116.d(new ehb.b(r118, r119, true, 16));
        xdb.a r28 = this.d;
        if (r28 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("titleRightComponent");
        r28 = r121;
    L106:
        r28.d(r22.a(r5));
        xdb.a r29 = this.e;
        if (r29 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("previewComponent");
        r29 = r121;
    L109:
        Context r30 = r20.getContext();
        com.ss.android.lark.feed.cardcomponent.preview.c r31 = r22.c(r5);
        r31.d = false;
        r31.e = false;
        r31.f = 20;
        com.ss.android.lark.feed.cardcomponent.preview.a.b r32 = r22.d(r30, r5);
        r32.e = 20;
        r32.d = 2131101973;
        UIFeedCard.AtInfo r122 = r5.getAtInfo();
        if (r122 == null) goto L112;
        xdb.a r123 = r122.getAtType();
    L114:
        if (r123 == AtInfo.AtType.USER) goto L124;
        UIFeedCard.AtInfo r124 = r5.getAtInfo();
        if (r124 == null) goto L118;
        xdb.a r125 = r124.getAtType();
    L120:
        if (r125 == AtInfo.AtType.ALL) goto L124;
        r8 = false;
        goto L124
    L118:
        r125 = r121;
    L124:
        if (r5.isRemind() == true) goto L126;
        r9 = r5.getBadgeCount();
    L126:
        r29.d(new com.ss.android.lark.flow.feed.component.preview.a.C0045a(r31, r32, new com.ss.android.lark.flow.feed.component.text_layer.a.C0046a(r8, r9)));
        xdb.a r33 = this.f;
        if (r33 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("muteComponent");
        r33 = r121;
    L129:
        r33.d(r22.e(r5));
        xdb.a r34 = this.h;
        if (r34 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("buttonsComponent");
        r34 = r121;
    L132:
        r34.d(r22.b(r5, r23));
        xdb.a r35 = this.g;
        if (r35 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
        xdb.a r36 = r121;
    L136:
        boolean r37 = r5.isRemind();
        tdb.a r126 = r24.b;
        r5.getAtInfo();
        r36.d(new com.ss.android.lark.flow.feed.component.badge.a.c(r37, r126, null, false, r5.getBadgeCount(), 8));
        return;
    L135:
        r36 = r35;
        goto L136
    L112:
        r123 = r121;
    L99:
        r121 = null;
        goto L101
    L91:
        if (r25.Y1() != true) goto L93;
        r26 = true;
    L87:
        th = move-exception;
        com.ss.android.lark.flow.feed.utils.b.c("FlowSidebarChatCell", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        r25 = null;
        goto L89
    L81:
        if (r5.isMeeting() == false) goto L83;
        r6 = UIHelper.getString(2131891715);
        goto L84
    L77:
        r116 = r4;
        goto L78
    L70:
        r2.c().setTeams(r113);
        r2.c().setVisibility(0);
        goto L71
    L64:
        if (r113.isEmpty() == true) goto L67;
        r115 = false;
        goto L68
    L51:
        if (CollectionsKt.listOf(new ChatNotMemberType[]{ChatNotMemberType.NORMAL_DISSOLVED, ChatNotMemberType.TNS_DISSOLVED}).contains(r5.getChatNotMemberType()) == false) goto L57;
        if (UIFeedCardExtraKt.isOnTop(r5) == false) goto L55;
        int r38 = 2131237910;
    L56:
        r112 = UIUtils.getDrawable(r1, r38);
        goto L58
    L55:
        r38 = 2131237909;
        goto L56
    L47:
        r19 = false;
        goto L48
    L41:
        if (TextUtils.isEmpty(r5.getOrderAvatarKey()) == true) goto L43;
        r17 = r5.getOrderAvatarKey();
        goto L44
    L34:
        if (r5.getChatMode() != Chat.ChatMode.THREAD_V2) goto L37;
        r15 = new wz7.d(AvatarType.THRED, 2);
        goto L36
    L37:
        r16 = null;
        goto L39
    L27:
        if (r13.length() == 0) goto L30;
        r14 = false;
        goto L31
    L23:
        qdb.a r39 = new qdb.a();
        r39.b(r5.getAvatarKey());
        r39.f(r5.getAvatarId());
        r39.h(AvatarModel.Size.MIDDLE);
        r39.a(false);
        r39.c(Biz.Messenger);
        r39.g(Scene.Feed);
        r12 = new AvatarModel(r39);
        goto L24
    L19:
        r0.setGuidelineBegin((k + (zz7.b.g(r20.getContext(), 48) / 2)) + zz7.b.g(r20.getContext(), 20));
        goto L20
    L12:
        if (r7.isEmpty() == true) goto L15;
        r10 = false;
        goto L17
    L5:
        r5 = null;
        goto L6
    }
}
