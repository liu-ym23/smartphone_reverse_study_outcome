package fhb;

import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.statistics.Statistics;
import deb.b;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: fhb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0261a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[FeedActionEvent.values().length];
            r0[FeedActionEvent.LEFT_SWIPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L28:
            r0[FeedActionEvent.LONG_CLICK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L6:
            a = r0;
            int[] r1 = new int[Chat.Type.values().length];
            r1[Chat.Type.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L40:
            r1[Chat.Type.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L9:
            b = r1;
            int[] r2 = new int[FeedCard.Type.values().length];
            r2[FeedCard.Type.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L32:
            r2[FeedCard.Type.THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L34:
            r2[FeedCard.Type.MSG_THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L26:
            r2[FeedCard.Type.DOC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L36:
            r2[FeedCard.Type.APP_FEED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L15:
            c = r2;
        }
    }

    static {
    }

    public static String a(UIFeedCard r5) {
        FeedCard.Type r0 = r5.getType();
        int r1 = -1;
        if (r0 != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 == 1) goto L23;
        if (r2 != 2) goto L10;
        return IOfflineExtraParser.ParserType.THREAD;
    L10:
        if (r2 != 3) goto L12;
        return "message_thread";
    L12:
        if (r2 != 4) goto L14;
        return "doc";
    L14:
        if (r2 == 5) goto L17;
        return "";
    L17:
        if (r5.getBizType() != AppFeedCardType.CONTACT) goto L41;
        return "contact_request";
    L41:
        return "";
    L23:
        if ((r5 instanceof ChatFeedPreview) == false) goto L25;
        ChatFeedPreview r6 = (ChatFeedPreview) r5;
    L26:
        if (r6 != null) goto L28;
        return "";
    L28:
        Chat.Type r3 = r6.getChatType();
        if (r3 == null) goto L32;
        r1 = C0261a.b[r3.ordinal()];
    L32:
        if (r1 == 1) goto L39;
        if (r1 == 2) goto L36;
        return "";
    L36:
        if (r6.getChatMode() != Chat.ChatMode.THREAD_V2) goto L38;
        return "thread_chat";
    L38:
        return INotificationHitPoint.ChatType.CHAT_TYPE_GROUP;
    L39:
        return "private";
    L25:
        r6 = null;
        goto L26
    L5:
        r2 = C0261a.c[r0.ordinal()];
        goto L7
    }

    @JvmStatic
    public static final HashMap<String, String> b(d r3) {
        Intrinsics.checkNotNullParameter(r3, "feedCardContext");
        deb.d r0 = r3.b();
        Fragment r4 = r3.getHost();
        b r2 = null;
        if ((r4 instanceof FlowMixedFeedFragment) == false) goto L5;
        FlowMixedFeedFragment r5 = (FlowMixedFeedFragment) r4;
    L6:
        if (r5 == null) goto L8;
        r2 = r5.k;
    L8:
        if (r0 == null) goto L11;
        HashMap<String, String> r6 = r0.J0();
        if (r6 == null) goto L11;
        return r6;
    L11:
        if (r2 == null) goto L14;
        return r2.J0();
    L14:
        return new HashMap();
    L5:
        r5 = null;
        goto L6
    }

    @JvmStatic
    public static final void d(UIFeedCard r5, HashMap<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "feedCard");
        Intrinsics.checkNotNullParameter(r6, "flowHitpointParams");
        String r0 = a(r5);
        String r2 = r6.get("is_navigation_sidebar");
        if (r2 != null) goto L5;
        r2 = "-1";
    L5:
        JSONObject r1 = new JSONObject().put("chat_type", r0).put("is_navigation_sidebar", r2);
        String r7 = r6.get("current_page");
        if (r7 != null) goto L8;
        r7 = "chat_list";
    L8:
        Statistics.sendEvent("list_cell_click", r1.put("current_page", r7).put("red_dot_cnt", r5.getUnreadCount()));
    }

    @JvmStatic
    public static final void e(UIFeedCard r3, HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "feedCard");
        Intrinsics.checkNotNullParameter(r4, "flowHitpointParams");
        String r0 = a(r3);
        String r5 = r4.get("is_navigation_sidebar");
        if (r5 != null) goto L5;
        r5 = "-1";
    L5:
        Statistics.sendEvent("long_press_bot_list", new JSONObject().put("is_navigation_sidebar", r5).put("chat_type", r0).put("red_dot_cnt", r3.getUnreadCount()));
    }

    @JvmStatic
    public static final void f(UIFeedCard r4, HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "feedCard");
        Intrinsics.checkNotNullParameter(r5, "flowHitpointParams");
        String r0 = a(r4);
        String r2 = r5.get("is_navigation_sidebar");
        if (r2 != null) goto L5;
        r2 = "-1";
    L5:
        JSONObject r6 = new JSONObject().put("is_navigation_sidebar", r2).put("chat_type", r0).put("red_dot_cnt", r4.getUnreadCount());
        String r1 = r5.get("current_page");
        String r3 = "";
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        JSONObject r7 = r6.put("current_page", r1);
        String r8 = r5.get("previous_page");
        if (r8 == null) goto L12;
        r3 = r8;
    L12:
        Statistics.sendEvent("show_bot_chat", r7.put("previous_page", r3));
    }

    @JvmStatic
    public static final void g(UIFeedCard r3, HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "feedCard");
        Intrinsics.checkNotNullParameter(r4, "flowHitpointParams");
        String r0 = a(r3);
        String r5 = r4.get("is_navigation_sidebar");
        if (r5 != null) goto L5;
        r5 = "-1";
    L5:
        Statistics.sendEvent("slide_on_bot_list", new JSONObject().put("is_navigation_sidebar", r5).put("chat_type", r0).put("red_dot_cnt", r3.getUnreadCount()));
    }

    public static void c(String r5, UIFeedCard r6, FeedActionEvent r7, HashMap r8) {
        String r0 = a(r6);
        String r2 = (String) r8.get("is_navigation_sidebar");
        if (r2 != null) goto L5;
        r2 = "-1";
    L5:
        int r9 = C0261a.a[r7.ordinal()];
        if (r9 != 1) goto L8;
    L11:
        String r10 = "slide_bot_list";
    L12:
        JSONObject r11 = new JSONObject().put("conversation_id", r6.getId()).put("is_navigation_sidebar", r2).put("click_from", r10);
        String r12 = (String) r8.get("current_page");
        if (r12 != null) goto L15;
        r12 = "";
    L15:
        Statistics.sendEvent(r5, r11.put("current_page", r12).put("chat_type", r0));
        return;
    L8:
        if (r9 != 2) goto L11;
        r10 = "long_press_cell";
        goto L12
    }
}
