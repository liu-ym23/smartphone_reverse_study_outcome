package com.ss.android.lark.flow.feed.sidebar.cell.chat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.AvatarType;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.export.feedcard.c;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.flow.common.component.tag.FlowTagView;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import com.ss.android.lark.parser.internal.a0;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowSidebarChatCell implements h, ihb.a {
    public com.ss.android.lark.feed.cardcomponent.avatar.a a;
    public ehb.a b;
    public com.ss.android.lark.flow.feed.component.badge.a c;
    public UIFeedCard d;
    public d e;
    public boolean f;
    public final Lazy g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AtInfo.AtType.values().length];
            r0[AtInfo.AtType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AtInfo.AtType.ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final void onViewAttachedToWindow() {
    }

    public final void onViewDetachedFromWindow() {
    }

    public final void onViewRecycled() {
    }

    public final void c() {
        UIFeedCard r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        d r1 = this.e;
        if (r1 != null) goto L8;
        return;
    L8:
        fhb.a.f(r0, fhb.a.b(r1));
    }

    public FlowSidebarChatCell() {
        this.f = true;
        this.g = LazyKt.lazy(LazyThreadSafetyMode.NONE, FlowSidebarChatCell$ntpService$2.INSTANCE);
    }

    public final com.ss.android.lark.feed.export.feedcard.a a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "itemView");
        this.a = new com.ss.android.lark.feed.cardcomponent.avatar.a(r11.getContext(), 28);
        this.b = new ehb.a(r11.getContext());
        this.c = new com.ss.android.lark.flow.feed.component.badge.a(r11.getContext());
        com.ss.android.lark.feed.cardcomponent.avatar.a r0 = this.a;
        com.ss.android.lark.flow.feed.component.badge.a r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        com.ss.android.lark.feed.cardcomponent.avatar.a r2 = null;
    L6:
        FeedCardComponent[] r4 = new FeedCardComponent[1];
        ehb.a r5 = this.b;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r5 = null;
    L9:
        r4[0] = r5;
        FeedCardComponent[] r6 = new FeedCardComponent[1];
        com.ss.android.lark.flow.feed.component.badge.a r3 = this.c;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
    L13:
        r6[0] = r1;
        return new com.ss.android.lark.feed.export.feedcard.a(r2, null, r4, r6, null, null, null, 485);
    L12:
        r1 = r3;
        goto L13
    L5:
        r2 = r0;
        goto L6
    }

    @Override // ihb.a
    public final void d(boolean r1) {
        this.f = r1;
    }

    public final void b(View r19, UIFeedCard r20, c r21, d r22) {
        Intrinsics.checkNotNullParameter(r19, "itemView");
        Intrinsics.checkNotNullParameter(r20, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r21, "paramsFactory");
        Intrinsics.checkNotNullParameter(r22, "feedCardContext");
        this.d = r20;
        this.e = r22;
        if ((r20 instanceof ChatFeedPreview) == false) goto L5;
        ChatFeedPreview r2 = (ChatFeedPreview) r20;
    L7:
        if (r2 != null) goto L10;
        com.ss.android.lark.flow.feed.utils.b.b("FlowSidebarChatCell", "onBindView: unsupported id=" + r20.getId() + ", card=" + r20.getClass().getSimpleName());
        return;
    L10:
        r19.getContext();
        if (r2.getChatType() != Chat.Type.P2P) goto L13;
        uz7.a.a r0 = new uz7.a.a();
        r0.k = r2.getP2pChatterId();
        r0.b(r2.getAvatarKey());
        r0.f(r2.getP2pChatterId());
        r0.a(false);
        uz7.a r6 = new uz7.a(r0);
    L14:
        String r1 = r2.getMiniAvatarKey();
        if (r1 != null) goto L17;
    L20:
        boolean r3 = true;
    L22:
        if (r3 == true) goto L25;
        wz7.d r4 = new wz7.d(null, 3);
        r4.c = r2.getMiniAvatarKey();
    L27:
        wz7.d r13 = r4;
    L29:
        boolean r5 = r2.isContainMarkType(UIFeedCard.MarkType.URGENT);
        if (r2.getFeedType() != FeedCard.FeedType.DONE) goto L32;
        boolean r10 = true;
    L33:
        com.ss.android.lark.feed.cardcomponent.avatar.a.b r7 = new com.ss.android.lark.feed.cardcomponent.avatar.a.b(new com.ss.android.lark.feed.export.feedcard.b(r6, null, r5, false), afb.a.a(r2, r10), r13, null, 24);
        com.ss.android.lark.feed.cardcomponent.avatar.a r8 = this.a;
        if (r8 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("avatarComponent");
        r8 = null;
    L36:
        r8.d(r7);
        ehb.a r9 = this.b;
        if (r9 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        ehb.a r11 = null;
    L40:
        Context r12 = r19.getContext();
        if (TextUtils.isEmpty(r2.getName()) == true) goto L43;
    L45:
        String r14 = r2.getName();
    L46:
        String r15 = r14;
        ArrayList r16 = new ArrayList();
        qtb.b r17 = (qtb.b) LarkContext.spiByDwarf(qtb.b.class);     // Catch: Throwable -> L49
    L51:
        if (r17 != null) goto L53;
    L55:
        boolean r18 = false;
    L56:
        if (r18 == true) goto L58;
    L61:
        if (r12 == null) goto L122;
        FlowTagBuilder r23 = new FlowTagBuilder(r12);
        r23.c = r2.isPublic();
        r23.d = r2.isDepartment();
        List r24 = r2.getTags();
        if (r24 != null) goto L65;
    L67:
        boolean r25 = false;
    L68:
        r23.e = r25;
        List r26 = r2.getTags();
        if (r26 != null) goto L71;
    L73:
        boolean r27 = false;
    L74:
        r23.f = r27;
        r23.g = r2.isBlocked();
        long r110 = ((cac.a) this.g.getValue()).a(30000) / 1000;
        List r28 = r2.getStatus();
        if (r28 != null) goto L77;
        r28 = CollectionsKt.emptyList();
    L77:
        List r29 = r28;
        if ((r29 instanceof Collection) == true) goto L80;
    L82:
        Iterator r30 = r29.iterator();
    L84:
        if (r30.hasNext() == false) goto L102;
        Chatter.ChatterCustomStatus r111 = (Chatter.ChatterCustomStatus) r30.next();
        StatusEffectiveInterval r31 = r111.effective_interval;
        if (r31 != null) goto L89;
    L98:
        boolean r32 = false;
    L99:
        if (r32 == false) goto L84;
        boolean r33 = true;
    L103:
        r23.h = r33;
        TagData r34 = a0.a(r2.getTagData());
        if (r34 == null) goto L117;
        TagData.Companion.getClass();
        Iterator r35 = ((ArrayList) TagData.a.b(r34)).iterator();
    L107:
        if (r35.hasNext() == false) goto L111;
        Object r36 = r35.next();
        if (g08.b.a(((g08.a) r36).b) == false) goto L107;
    L112:
        g08.a r37 = (g08.a) r36;
        if (r37 == null) goto L117;
        if (r37.b != 1) goto L117;
        boolean r38 = true;
    L118:
        r23.i = r38;
        r23.j = r2.isShowAgentTag();
        FlowTagView r39 = r23.b();
        if (r39 == null) goto L122;
        r16.add(new com.ss.android.lark.flow.feed.component.title.a.b(r39));
        goto L122
    L111:
        r36 = null;
    L117:
        r38 = false;
        goto L118
    L89:
        if (Intrinsics.areEqual(r111.icon_key, "GeneralVacation") == false) goto L98;
        Long r40 = r31.start_time;
        if (r110 <= r31.end_time.longValue()) goto L93;
    L95:
        boolean r41 = false;
    L96:
        if (r41 == false) goto L98;
        r32 = true;
        goto L99
    L93:
        if (r40.longValue() > r110) goto L95;
        r41 = true;
    L102:
        r33 = false;
        goto L103
    L80:
        if (r29.isEmpty() == false) goto L82;
    L71:
        if (r26.contains(Tag.FROZEN) != true) goto L73;
        r27 = true;
        goto L74
    L65:
        if (r24.contains(Tag.USER_RESIGNED) != true) goto L67;
        r25 = true;
    L122:
        if (this.f == false) goto L127;
        if (UIFeedCardExtraKt.isOnTop(r2) == false) goto L127;
        r16.add(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r12, 2131237933)));
    L127:
        if (r2.isRemind() == true) goto L129;
        r16.add(new com.ss.android.lark.flow.feed.component.title.a.C0047a(UIUtils.getDrawable(r12, 2131237908)));
    L129:
        Intrinsics.checkNotNull(r15);
        r11.d(new ehb.b(r15, r16, false, 17, 4));
        com.ss.android.lark.flow.feed.component.badge.a r42 = this.c;
        if (r42 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("badgeComponent");
        r42 = null;
    L132:
        boolean r112 = r2.isRemind();
        tdb.a r113 = r7.b;
        UIFeedCard.AtInfo r43 = r2.getAtInfo();
        if (r43 == null) goto L145;
        qdb.a r44 = new qdb.a();
        r44.b(r43.getAvatarKey());
        r44.f(r43.getId());
        r44.h(AvatarModel.Size.MINI);
        r44.a(false);
        r44.c(Biz.Messenger);
        r44.g(Scene.Feed);
        AvatarModel r45 = new AvatarModel(r44);
        AtInfo.AtType r46 = r43.getAtType();
        if (r46 != null) goto L137;
        int r47 = -1;
    L138:
        if (r47 != 1) goto L140;
        Drawable r48 = UIHelper.getDrawable(2131235353);
    L144:
        com.ss.android.lark.flow.feed.component.badge.a.b r114 = new com.ss.android.lark.flow.feed.component.badge.a.b(r45, r48);
    L146:
        r42.d(new com.ss.android.lark.flow.feed.component.badge.a.c(r112, r113, r114, true, r2.getBadgeCount(), 4));
        return;
    L140:
        if (r47 == 2) goto L142;
        r48 = null;
        goto L144
    L142:
        r48 = UIHelper.getDrawable(2131235352);
        goto L144
    L137:
        r47 = b.a[r46.ordinal()];
        goto L138
    L145:
        r114 = null;
        goto L146
    L58:
        if (r2.getChatType() != Chat.Type.P2P) goto L61;
        if (r12 == null) goto L61;
        FlowTagView r49 = new FlowTagView(r12, null, 6, 0);
        r49.setText(UIHelper.getString(2131890013));
        r49.setTextSize(11.0f);
        r49.setTextColor(ContextCompat.getColor(r12, 2131102000));
        r49.setIcon(UIUtils.getDrawable(r12, 2131237907));
        r49.setTagBackgroundColor(ContextCompat.getColor(r12, 2131101999));
        r16.add(new com.ss.android.lark.flow.feed.component.title.a.b(r49));
        goto L61
    L53:
        if (r17.Y1() != true) goto L55;
        r18 = true;
    L49:
        th = move-exception;
        com.ss.android.lark.flow.feed.utils.b.c("FlowSidebarChatCell", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        r17 = null;
        goto L51
    L43:
        if (r2.isMeeting() == false) goto L45;
        r14 = UIHelper.getString(2131891715);
        goto L46
    L39:
        r11 = r9;
        goto L40
    L32:
        r10 = false;
        goto L33
    L25:
        if (r2.getChatMode() != Chat.ChatMode.THREAD_V2) goto L28;
        r4 = new wz7.d(AvatarType.THRED, 2);
        goto L27
    L28:
        r13 = null;
        goto L29
    L17:
        if (r1.length() == 0) goto L20;
        r3 = false;
        goto L22
    L13:
        qdb.a r50 = new qdb.a();
        r50.b(r2.getAvatarKey());
        r50.f(r2.getAvatarId());
        r50.h(AvatarModel.Size.MINI);
        r50.a(false);
        r50.c(Biz.Messenger);
        r50.g(Scene.Feed);
        r6 = new AvatarModel(r50);
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
