package zib;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.search.dto.Source;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import z5c.b3;
import z5c.c3;
import z5c.d3;
import z5c.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a {

        /* JADX INFO: renamed from: zib.e$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0353a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Source.Type.values().length];
                r0[Source.Type.SEARCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[Source.Type.FORWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[Source.Type.RECOMMEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        @JvmStatic
        public static String a(SearchBaseInfo r1) {
            Intrinsics.checkNotNullParameter(r1, "item");
            if ((r1 instanceof SearchChatInfo) == false) goto L6;
            return INotificationHitPoint.ChatType.CHAT_TYPE_GROUP;
        L6:
            if ((r1 instanceof SearchChatterInfo) == false) goto L12;
            if (((SearchChatterInfo) r1).getChatterType() != Chatter.ChatterType.BOT) goto L10;
            return "bot";
        L10:
            return "user";
        L12:
            if ((r1 instanceof SearchAiKnowledgeInfo) == false) goto L14;
            return "knowledge_ai";
        L14:
            return INotificationHitPoint.NoticeType.OTHER;
        }

        @JvmStatic
        public static void c(s5c.d r1) {
            Intrinsics.checkNotNullParameter(r1, "param");
            Statistics.sendEvent("im_msg_forward_select_click", r1.plus(ChatParamUtils.e()).toJson());
        }

        @JvmStatic
        public static void e(s5c.d r1) {
            Intrinsics.checkNotNullParameter(r1, "param");
            Statistics.sendEvent("im_msg_send_confirm_click", r1.plus(ChatParamUtils.e()).toJson());
        }

        public static void b(List r2, List r3) {
            Intrinsics.checkNotNullParameter(r3, "targets");
            if (CollectionUtils.isEmpty(r3) == false) goto L5;
            return;
        L5:
            if (CollectionUtils.isEmpty(r2) == true) goto L16;
            b.a r1 = new b.a();
            r1.a = r2;
            Intrinsics.checkNotNullParameter(r3, "targets");
            r1.b = r3;
            b r4 = new b(r1.a, r3);
            if (CollectionUtils.isEmpty(r4.b) == false) goto L10;
            return;
        L10:
            if (CollectionUtils.isEmpty(r4.c) == true) goto L17;
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new k(r4));
            return;
        L17:
            return;
        }

        @JvmStatic
        public static void d(s5c.a r2, boolean r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "version");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new i(r3, r4, r2));
        }
    }

    public static final class b {
        public final String a;
        public final List<String> b;
        public final List<ForwardTargetBaseInfoNew> c;

        public static final class a {
            public List<String> a;
            public List<? extends ForwardTargetBaseInfoNew> b;

            public a() {
                this.a = new ArrayList();
                this.b = new ArrayList();
            }
        }

        public b(List r2, List r3) {
            Intrinsics.checkNotNullParameter(r3, "targets");
            this.a = null;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @JvmStatic
    public static final s5c.d a(List<? extends SearchBaseInfo> r6) {
        Intrinsics.checkNotNullParameter(r6, "infos");
        Iterator<T> r7 = r6.iterator();
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r7.hasNext() == false) goto L16;
        SearchChatterInfo r4 = (SearchBaseInfo) r7.next();
        if ((r4 instanceof SearchChatInfo) == true) goto L8;
        if ((r4 instanceof SearchChatterInfo) == false) goto L4;
        r1 = r1 + 1;
        if (r4.getChatterType() != Chatter.ChatterType.BOT) goto L4;
        r3 = r3 + 1;
        goto L4
    L8:
        if (((SearchChatInfo) r4).isSecretChat() == false) goto L10;
        r0 = r0 + 1;
    L10:
        r2 = r2 + 1;
        goto L4
    L16:
        s5c.a r8 = c3.c.a(String.valueOf(r0));
        s5c.a r5 = e3.c.a(String.valueOf(r1));
        s5c.a r9 = d3.c.a(String.valueOf(r2));
        return s5c.d.b.b(b3.c.a(String.valueOf(r3)), r8).plus(r5).plus(r9);
    }
}
