package com.ss.android.lark.flow.feed.cell.chat;

import aeb.f;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ChatNotMemberType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.ActionScene;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.flow.feed.action.FlowBaseActionHandler;
import com.ss.android.lark.flow.feed.action.FlowFeedActionMode;
import com.ss.android.lark.flow.feed.cell.chat.chatdismiss.FlowChatDismissDialog;
import com.ss.android.lark.flow.feed.utils.FlowEventManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatAction extends FlowBaseActionHandler implements f {
    public static final /* synthetic */ int d = 0;
    public final FlowFeedActionMode c;

    public static final class a {
        public static boolean a(ChatFeedPreview r5) {
            Intrinsics.checkNotNullParameter(r5, "data");
            if (r5.getUnreadCount() > 0) goto L5;
        L7:
            return false;
        L5:
            if (com.ss.android.lark.feed.shared.data.appconfig.a.a(r5.getType()) == false) goto L7;
            return true;
        }
    }

    static {
    }

    public final void b(FeedActionType r2, FeedActionStatus r3, UIFeedCard r4) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionStatus");
        Intrinsics.checkNotNullParameter(r4, "data");
    }

    public final List<aeb.c> c() {
        return CollectionsKt.emptyList();
    }

    public final void a(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        fhb.a.e(r2, fhb.a.b(this.a));
    }

    public final List<FeedActionType> e(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        if (this.c.getSupportLeftSwipe() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return q(r2);
    }

    public final List<FeedActionType> f(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.emptyList();
    }

    public final void g(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        fhb.a.g(r2, fhb.a.b(this.a));
    }

    public final List<FeedActionType> h(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        if (this.c.getSupportLeftSwipe() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return q(r2);
    }

    public final List<FeedActionType> k(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
        return CollectionsKt.emptyList();
    }

    public final void l(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
    }

    public final List<FeedActionType> n(UIFeedCard r6) {
        Intrinsics.checkNotNullParameter(r6, "uiFeedCard");
        ArrayList r0 = new ArrayList();
        if ((r6 instanceof ChatFeedPreview) == false) goto L5;
        ChatFeedPreview r1 = (ChatFeedPreview) r6;
    L6:
        if (r1 != null) goto L9;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatAction", "getSupportLongClickActionTypes: unsupported id=" + r6.getId() + ", card=" + r6.getClass().getSimpleName());
        return r0;
    L9:
        r0.add(FeedActionType.TOPPING_IN_LIST);
        if (a.a(r1) == false) goto L12;
        r0.add(FeedActionType.CLEAR_UNREAD);
    L12:
        Intrinsics.checkNotNullParameter(r1, "data");
        if (r1.getUnreadCount() != 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        r0.add(FeedActionType.MARK_UNREAD);
    L18:
        r0.add(FeedActionType.NO_DISTURB);
        r0.add(FeedActionType.DONE);
        return r0;
    L15:
        r7 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final List<FeedActionType> q(UIFeedCard r6) {
        if (r6.getIsFake() == true) goto L5;
        ArrayList r0 = new ArrayList();
        if ((r6 instanceof ChatFeedPreview) == false) goto L9;
        ChatFeedPreview r1 = (ChatFeedPreview) r6;
    L10:
        if (r1 != null) goto L13;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatAction", "getSwipeLeftActions: unsupported id=" + r6.getId() + ", card=" + r6.getClass().getSimpleName());
        return r0;
    L13:
        r0.add(FeedActionType.TOPPING_IN_LIST);
        if (a.a((ChatFeedPreview) r6) == false) goto L16;
        r0.add(FeedActionType.CLEAR_UNREAD);
    L16:
        Intrinsics.checkNotNullParameter(r1, "data");
        if (r1.getUnreadCount() != 0) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        r0.add(FeedActionType.MARK_UNREAD);
    L22:
        return r0;
    L19:
        r7 = false;
        goto L20
    L9:
        r1 = null;
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }

    public FlowChatAction(com.ss.android.lark.feed.export.feedcard.d r2, FlowFeedActionMode r3) {
        Intrinsics.checkNotNullParameter(r2, "feedContext");
        Intrinsics.checkNotNullParameter(r3, "actionMode");
        super(r2);
        this.c = r3;
    }

    public final void r(String r11, UIFeedCard r12) {
        LarkFeedListViewModel r1 = p();
        if (r1 == null) goto L6;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r1), null, null, new FlowChatAction$handleHideFeedItem$1$1(r1, r11, this, r12, null), 3, null);
        return;
    }

    public final void j(final UIFeedCard r10, View r11, int r12, ActionScene r13) {
        Intrinsics.checkNotNullParameter(r10, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r11, "clickView");
        Intrinsics.checkNotNullParameter(r13, "actionScene");
        fhb.a.d(r10, fhb.a.b(this.a));
        FeedSidebarItemsMoltenViewModel r14 = p();
        Integer r15 = null;
        if ((r14 instanceof FeedSidebarItemsMoltenViewModel) == false) goto L5;
        FeedSidebarItemsMoltenViewModel r16 = r14;
    L6:
        if (r16 == null) goto L9;
        r16.setFlowClickHint(r10.getId());
    L9:
        if ((r10 instanceof ChatFeedPreview) == false) goto L11;
        ChatFeedPreview r17 = (ChatFeedPreview) r10;
    L13:
        if (r17 != null) goto L16;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatAction", "onItemClick: unsupported id=" + r10.getId() + ", card=" + r10.getClass().getSimpleName());
        return;
    L16:
        final String r2 = r17.getId();
        com.ss.android.lark.flow.feed.utils.b.d("FlowChatAction", "test_onItemClick, chatId: " + r2 + ", chatRole: " + r17.getChatRole());
        boolean r3 = false;
        if (r17.getChatRole() == Chat.Role.MEMBER) goto L74;
        String r0 = r17.getId();
        StringBuilder r1 = new StringBuilder("checkAndShowDismissDialog, chatId: ");
        r1.append(r0);
        r1.append(", chatNotMemberType: ");
        ChatNotMemberType r4 = r17.getChatNotMemberType();
        if (r4 == null) goto L21;
        Integer r5 = Integer.valueOf(r4.getNotMemberType());
    L22:
        r1.append(r5);
        com.ss.android.lark.flow.feed.utils.b.d("FlowChatAction", r1.toString());
        ChatNotMemberType r18 = r17.getChatNotMemberType();
        if (r18 == null) goto L25;
        r15 = Integer.valueOf(r18.getNotMemberType());
    L25:
        int r19 = ChatNotMemberType.NORMAL_DISSOLVED.getNotMemberType();
        if (r15 != null) goto L29;
    L30:
        int r110 = ChatNotMemberType.TNS_DISSOLVED.getNotMemberType();
        if (r15 != null) goto L34;
    L36:
        int r111 = com.ss.android.lark.flow.feed.utils.c.a;
        com.ss.android.lark.flow.feed.utils.c.a(this.a.getHost().getContext(), 2131890128, 2131237938);
        Intrinsics.checkNotNull(r0);
        r(r0, r10);
        return;
    L34:
        if (r15.intValue() != r110) goto L36;
    L37:
        ChatNotMemberType r112 = r17.getChatNotMemberType();
        if (r112 != null) goto L40;
    L42:
        Context r113 = this.a.getHost().getContext();
        if (r113 != null) goto L45;
        r113 = LarkContext.getApplication();
    L45:
        String r114 = UIUtils.getString(r113, 2131890183);
        String r6 = "";
        if (r3 == false) goto L54;
        boolean r7 = r17.isChatOwner();
        if (r17.isChatAdmin() == true) goto L52;
        if (r7 == true) goto L52;
        int r8 = 2131890181;
    L53:
        String r9 = UIUtils.getString(r113, r8);
    L55:
        com.ss.android.lark.flow.feed.cell.chat.a r20 = new com.ss.android.lark.flow.feed.cell.chat.a(this, r0, r10);
        Lazy r115 = FlowEventManager.a;
        Intrinsics.checkNotNullParameter("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED", "eventName");
        Intrinsics.checkNotNullParameter(r20, "callback");
        Lazy r21 = FlowEventManager.a;     // Catch: Throwable -> L63
        CopyOnWriteArrayList r22 = (CopyOnWriteArrayList) ((ConcurrentHashMap) r21.getValue()).get("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED");     // Catch: Throwable -> L63
        if (r22 != null) goto L60;
        CopyOnWriteArrayList r23 = new CopyOnWriteArrayList();     // Catch: Throwable -> L63
        r23.add(r20);     // Catch: Throwable -> L63
        ((ConcurrentHashMap) r21.getValue()).put("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED", r23);     // Catch: Throwable -> L63
    L109:
    L65:
        Log.d("FlowEventManager", "registerEvent: EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED, callback: " + r20.hashCode());
        int r116 = FlowChatDismissDialog.a;
        String r117 = r17.getAvatarKey();
        if (r117 == null) goto L69;
        r6 = r117;
    L69:
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNull(r114);
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNullParameter(r6, "avatarKey");
        Intrinsics.checkNotNullParameter(r0, "entityId");
        Intrinsics.checkNotNullParameter(r114, "mainTitle");
        Intrinsics.checkNotNullParameter(r9, "subTitle");
        if (r113 != null) goto L72;
        com.ss.android.lark.flow.feed.utils.b.b("FlowChatDismissDialog", "startForDismiss error, context is null");
        return;
    L72:
        Intent r118 = new Intent(r113, FlowChatDismissDialog.class);
        Bundle r119 = new Bundle();
        r119.putString("key_avatar_key", r6);
        r119.putString("key_entity_id", r0);
        r119.putString("key_main_title", r114);
        r119.putString("key_sub_title", r9);
        r118.putExtras(r119);
        r113.startActivity(r118);
        return;
    L60:
        if (r22.contains(r20) == true) goto L109;
        r22.add(r20);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        Log.e("FlowEventManager", "registerEvent error, EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED, error: " + th.getMessage());
    L52:
        r8 = 2131890182;
        goto L53
    L54:
        r9 = "";
        goto L55
    L40:
        if (r112.getNotMemberType() != ChatNotMemberType.TNS_DISSOLVED.getNotMemberType()) goto L42;
        r3 = true;
        goto L42
    L29:
        if (r15.intValue() == r19) goto L37;
    L21:
        r5 = null;
        goto L22
    L74:
        new FlowChatAction$onItemClick$callback$1(r2, this, r10);
        Intrinsics.checkNotNull(r2);
        Context r24 = this.a.getHost().getContext();
        peb.b r120 = heb.a.a;
        peb.b.d r25 = r120.getChatDependency();
        if (r24 == null) goto L88;
        Chat.ChatMode r121 = r17.getChatMode();
        boolean r122 = r17.isSecret();
        Intrinsics.checkNotNullParameter(r17, "<this>");
        if (r17.isAIBotChat() == false) goto L80;
        int r26 = 3;
    L84:
        if (this.c != FlowFeedActionMode.SIDEBAR) goto L86;
        boolean r27 = true;
    L87:
        r25.d(r24, r2, r121, r122, "feed", r26, r27);
        goto L88
    L86:
        r27 = false;
        goto L87
    L80:
        if (r17.isAIMainChat() == false) goto L82;
        r26 = 2;
        goto L84
    L82:
        r26 = 1;
    L88:
        int r123 = com.ss.android.lark.feed.shared.hitpoint.a.a;
        Intrinsics.checkNotNullParameter(r17, "feedItem");
        Log.d("FeedHitPoint", "sendFeedChatClick");
        ((com.ss.android.lark.integrator.im.feed_shared.dependency.f) r120.getFeedDependency()).getClass();     // Catch: Throwable -> L106
        FeedFolder r124 = FeedFolderCompat.INSTANCE.getMESSAGE_WITHOUT_DOUBAO();     // Catch: Throwable -> L106
        if (r17.isContainMarkType(UIFeedCard.MarkType.AT_ALL) == false) goto L93;
        String r125 = "at_all";
    L96:
        JSONObject r126 = new JSONObject().put("feed_id", r17.getId()).put("filter_type", r124.label().toLowerCase(Locale.ROOT)).put("item_type", r17.getType()).put("unread_num", r17.getUnreadCount());     // Catch: Throwable -> L106
        if (r17.isRemind() == false) goto L99;
        String r28 = "notify";
    L100:
        JSONObject r127 = r126.put("un_read_type", r28);     // Catch: Throwable -> L106
        if (r17.isContainMarkType(UIFeedCard.MarkType.URGENT) == false) goto L103;
        String r29 = "true";
    L104:
        JSONObject r128 = r127.put("is_urgent", r29).put("at_me_type", r125);     // Catch: Throwable -> L106
        r128.put("is_focus", r17.isSpecialFocus());     // Catch: Throwable -> L106
        r128.put("chat_type", r17.getChatType());     // Catch: Throwable -> L106
        r128.put("is_bot_chat", r17.isBotChat());     // Catch: Throwable -> L106
        Statistics.sendEvent("feed_chat_click_dev", r128);     // Catch: Throwable -> L106
        return;
    L103:
        r29 = "false";
        goto L104
    L99:
        r28 = "mute";
        goto L100
    L93:
        if (r17.isContainMarkType(UIFeedCard.MarkType.AT_USER) == false) goto L95;
        r125 = "at_user";
        goto L96
    L95:
        r125 = "no_at";
    L106:
        th = move-exception;
        Log.e("FeedHitPoint", th.getMessage());
        return;
    L11:
        r17 = null;
        goto L13
    L5:
        r16 = null;
        goto L6
    }
}
