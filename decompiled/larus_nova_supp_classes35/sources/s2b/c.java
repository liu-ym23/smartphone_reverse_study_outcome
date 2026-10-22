package s2b;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.ReactionHandler;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager$keyboardEventCenterHandler$2;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.chat.message.menu.v2.e<y6b.c<?>> {
    public final v a;
    public final m2b.a b;
    public final com.ss.android.lark.chat.chatwindow.chat.menu.handler.b c;
    public ReactionHandler d;
    public final b e;
    public final MessageActionPanelManager<y6b.c<?>> f;
    public final PageType g;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
            a = r0;
            r0[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface b {
        ChatChatter N0();

        List<yya.l> a();

        void b();

        ChatChatter g7();

        Fragment getFragment();

        void h7(boolean r1);

        void i7();

        void j7(MessageActionPanelManager$keyboardEventCenterHandler$2.a r1);

        int k7();

        Integer l7();

        boolean m7();

        void n7(y6b.c<?> r1, String r2, int r3);

        MessageInfo p(String r1);
    }

    public final void a(boolean r2) {
        this.e.h7(r2);
    }

    public final void c(y6b.c<?> r5, String r6) {
        HashMap r0 = new HashMap(ChatParamUtils.i(r5));
        int r7 = a.a[ReplyInThreadUtil.d(this.a.C()).ordinal()];
        if (r7 != 1) goto L5;
        r0.put("ab_version", 0);
    L12:
        ChatHitPointNew.f(this.b.getChat(), r6, "im_msg_menu_view", r0);
        return;
    L5:
        if (r7 != 2) goto L7;
        r0.put("ab_version", 1);
        goto L12
    L7:
        if (r7 != 3) goto L12;
        r0.put("ab_version", 2);
        goto L12
    }

    public final void b(y6b.a r5, String r6, int r7) {
        y6b.c<?> r8 = (y6b.c) r5;
        if (this.d != null) goto L5;
        this.d = new ReactionHandler(this.b.getContext(), this.b.getChatId(), this.b);
    L5:
        List r0 = this.b.j5().c(mya.d.class);
        if (CollectionUtils.isEmpty(r0) == false) goto L8;
        this.d.a(r8.c, r6, r7);
    L12:
        this.e.n7(r8, r6, r7);
        return;
    L8:
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        ((mya.d) r1.next()).d(r8.c, r6, r7);
        goto L10
    }

    public c(v r1, RecyclerView r2, m2b.a r3, com.ss.android.lark.chat.chatwindow.chat.menu.handler.b r4, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.b r5, t6b.g r6) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.e = r5;
        MessageActionPanelManager<y6b.c<?>> r7 = new MessageActionPanelManager(r3, this, r2);
        this.f = r7;
        r7.d = r6.h();
        r7.f = r3.d0(com.ss.android.lark.biz.im.api.message.params.m.class);
        r7.e = r6.d();
        this.g = r6.f();
    }
}
