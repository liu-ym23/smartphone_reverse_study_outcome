package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.base.view.vo.message.e;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.l;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.selection.MovableSelectionManager;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatReplyActionProvider implements m {
    public static final /* synthetic */ int a = 0;

    public static class ReplyMessageAction implements i {
        public final yya.a a;
        public final Lazy b;
        public final Lazy c;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L20:
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L26:
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L8:
                a = r0;
                int[] r1 = new int[Message.Type.values().length];
                r1[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L22:
                r1[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L28:
                r1[Message.Type.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L12:
                b = r1;
            }
        }

        public final boolean c() {
            return false;
        }

        public final Integer e() {
            return null;
        }

        public final boolean f() {
            return false;
        }

        public final d g() {
            return null;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final Map<String, Object> R4() {
            int r0 = ChatReplyActionProvider.a;
            g r1 = (g) this.b.getValue();
            Intrinsics.checkNotNullParameter(r1, "fgService");
            if (ReplyInThreadUtil.d(r1) != ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE) goto L5;
        L8:
            Map r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "quote")});
        L9:
            g r3 = (g) this.b.getValue();
            Intrinsics.checkNotNullParameter(r3, "fgService");
            int r4 = b.a.a[ReplyInThreadUtil.d(r3).ordinal()];
            if (r4 != 1) goto L12;
            Map r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ab_version", 0)});
        L20:
            if (r2 != null) goto L24;
            return null;
        L24:
            return MapsKt.plus(r2, r5);
        L12:
            if (r4 != 2) goto L14;
            r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ab_version", 1)});
            goto L20
        L14:
            if (r4 != 3) goto L17;
            r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ab_version", 2)});
            goto L20
        L17:
            throw new NoWhenBranchMatchedException();
        L5:
            if (ReplyInThreadUtil.d(r1) == ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE) goto L8;
            r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "reply")});
            goto L9
        }

        public final boolean isEnable() {
            Chat r0 = this.a.getChat();
            if (r0 == null) goto L5;
            ChatDisplayModeSetting r1 = r0.getChatDisplayModeSetting();
        L7:
            if (r1 == ChatDisplayModeSetting.THREAD) goto L9;
            return true;
        L9:
            return this.a.m().d();
        L5:
            r1 = null;
            goto L7
        }

        public final boolean isVisible() {
            if (((g) this.b.getValue()).isEnable("messenger.swipe.reply") == false) goto L12;
            a r0 = (a) this.c.getValue();
            c r3 = this.a;
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider.ReplyContext");
            if (r0.a(r3.e()) == true) goto L8;
            return false;
        L8:
            if (u.a.a.c == true) goto L10;
        L36:
            int r1 = a.b[this.a.m().getType().ordinal()];
            BaseTextContentVO r4 = null;
            boolean r5 = true;
            if (r1 == 1) goto L85;
            if (r1 == 2) goto L66;
            if (r1 == 3) goto L44;
            return true;
        L44:
            if (u.a.a.c == false) goto L64;
            v5b.a r2 = this.a.m().b();
            if ((r2 instanceof AudioContentVO) == false) goto L48;
            AudioContentVO r6 = (AudioContentVO) r2;
        L49:
            if (r6 == null) goto L51;
            r4 = r6.h;
        L51:
            if (r4 == null) goto L62;
            CharSequence r7 = r4.u;
            if (r7 != null) goto L55;
        L58:
            if (r5 == false) goto L61;
            return false;
        L61:
            return a(r4.y);
        L55:
            if (r7.length() == 0) goto L58;
            r5 = false;
            goto L58
        L62:
            Log.i("ChatReplyActionProvider", "AudioContentVO is null, do not show partial reply menu.");
            return false;
        L48:
            r6 = null;
            goto L49
        L64:
            return true;
        L66:
            if (u.a.a.c == false) goto L83;
            v5b.a r8 = this.a.m().b();
            if ((r8 instanceof PostContentVO) == false) goto L70;
            r4 = (PostContentVO) r8;
        L70:
            if (r4 == null) goto L81;
            CharSequence r9 = r4.u;
            if (r9 != null) goto L74;
        L77:
            if (r5 == false) goto L80;
            return false;
        L80:
            return a(r4.y);
        L74:
            if (r9.length() == 0) goto L77;
            r5 = false;
            goto L77
        L81:
            Log.i("ChatReplyActionProvider", "PostContentVO is null, do not show partial reply menu.");
            return false;
        L83:
            return true;
        L85:
            if (u.a.a.c == false) goto L102;
            v5b.a r10 = this.a.m().b();
            if ((r10 instanceof e) == false) goto L89;
            r4 = (e) r10;
        L89:
            if (r4 == null) goto L100;
            CharSequence r11 = r4.u;
            if (r11 != null) goto L93;
        L96:
            if (r5 == false) goto L99;
            return false;
        L99:
            return a(r4.y);
        L93:
            if (r11.length() == 0) goto L96;
            r5 = false;
            goto L96
        L100:
            Log.i("ChatReplyActionProvider", "TextContentVO is null, do not show partial reply menu.");
            return false;
        L102:
            return true;
        L10:
            if (this.a.m().d() == false) goto L36;
            return false;
        L12:
            Chat r12 = this.a.getChat();
            if (r12 != null) goto L16;
            return false;
        L16:
            if (r12.isChatable() == true) goto L19;
            return false;
        L19:
            if (r12.isAllowPost() == true) goto L21;
            return false;
        L21:
            c r13 = this.a;
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider.ReplyContext");
            OpenApp r14 = r13.e();
            if (r14 == null) goto L34;
            if (r14.getState() == null) goto L29;
            if (r14.getState() == OpenApp.State.USABLE) goto L29;
            return false;
        L29:
            if (r14.getChatable() == null) goto L34;
            if (r14.getChatable() != OpenApp.Chatable.UNCHATABLE) goto L34;
            return false;
        L34:
            if (this.a.m().d() == false) goto L36;
            return false;
        }

        public MessageActionType getType() {
            return MessageActionType.REPLY;
        }

        public ReplyMessageAction(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
            this.b = LazyKt.lazy(new ChatReplyActionProvider$ReplyMessageAction$fgService$2(this));
            this.c = LazyKt.lazy(new ChatReplyActionProvider$ReplyMessageAction$rule$2(this));
        }

        public final boolean a(boolean r5) {
            if (ReplyActionUtils.c() == false) goto L10;
            Chat r0 = this.a.getChat();
            if (r0 != null) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L10;
            boolean r2 = true;
        L12:
            if (r2 == true) goto L15;
            Log.i("ChatReplyActionProvider", "isPartialReplyOn is false, do not show partial reply menu.");
            return false;
        L15:
            if (r5 == false) goto L18;
            Log.i("ChatReplyActionProvider", "current message is translated, do not show partial reply menu.");
            return false;
        L18:
            Log.i("ChatReplyActionProvider", "current message is not translated, show partial reply menu.");
            return true;
        L7:
            r1 = r0.isSecret();
        L10:
            r2 = false;
            goto L12
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public Drawable getIcon(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            ReplyInThreadUtil.ReplyOptimizeFGState r0 = ReplyInThreadUtil.e((g) this.b.getValue(), this.a.getChat());
            int r1 = a.a[r0.ordinal()];
            if (r1 != 1) goto L5;
            int r2 = d6b.a.a;
            return UDIconUtils.getIconDrawable(r4, 2131255541, UDColorUtils.getColor(r4, 2131100799));
        L5:
            if (r1 != 2) goto L7;
        L11:
            int r3 = d6b.a.a;
            return UDIconUtils.getIconDrawable(r4, 2131237590, UDColorUtils.getColor(r4, 2131100799));
        L7:
            if (r1 == 3) goto L11;
            throw new NoWhenBranchMatchedException();
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (this.a.m().d() == false) goto L5;
            String r3 = UIHelper.getString(2131891361);
            Intrinsics.checkNotNull(r3);
            return r3;
        L5:
            ReplyInThreadUtil.ReplyOptimizeFGState r4 = ReplyInThreadUtil.e((g) this.b.getValue(), this.a.getChat());
            int r5 = a.a[r4.ordinal()];
            if (r5 != 1) goto L8;
            String r6 = UIHelper.getString(2131892131);
            Intrinsics.checkNotNull(r6);
            return r6;
        L8:
            if (r5 == 2) goto L15;
            if (r5 == 3) goto L15;
            throw new NoWhenBranchMatchedException();
        L15:
            return UIHelper.getString(2131891291);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r7, "view");
            PartialReplyInfo r0 = null;
            ChatDisplayModeSetting r1 = null;
            if (r8 == true) goto L11;
            Chat r9 = this.a.getChat();
            if (r9 == null) goto L8;
            r1 = r9.getChatDisplayModeSetting();
        L8:
            if (r1 != ChatDisplayModeSetting.THREAD) goto L59;
            UDToast.show(this.a.getContext(), 2131891362);
            return;
        L59:
            return;
        L11:
            yya.g r10 = this.a;
            if (r10 != null) goto L14;
            return;
        L14:
            v5b.c r11 = r10.m();
            String r2 = r11.getId();
            boolean r3 = false;
            if (r11.d() == true) goto L17;
            int r12 = this.a.d.b();
            if (ReplyActionUtils.c() == false) goto L41;
            Chat r13 = this.a.getChat();
            if (r13 != null) goto L37;
            boolean r14 = true;
        L38:
            if (r14 == true) goto L41;
            r3 = true;
            goto L41
        L37:
            r14 = r13.isSecret();
        L41:
            if (r3 == true) goto L43;
        L52:
            l r4 = this.a;
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.menu.handler.IReplyMenuHandler");
            r4.o(r2, r12);
        L53:
            MovableView r15 = com.ss.android.lark.chat.message.menu.a.a(this.a.a);
            if (r15 == null) goto L60;
            MovableSelectionManager r16 = r15.getRootMovableView().n;
            if (r16 == null) goto L61;
            r16.d();
            return;
        L61:
            return;
        L60:
            return;
        L43:
            if (u.a.a.c == false) goto L52;
            Log.i("ChatReplyActionProvider", "current select mode is partial.");
            v5b.c r5 = this.a.m();
            if ((r5 instanceof y6b.a) == false) goto L47;
            y6b.a r6 = (y6b.a) r5;
        L48:
            Message.Type r17 = this.a.m().getType();
            if (r6 == null) goto L51;
            r0 = ReplyActionUtils.d(r6, r17);
        L51:
            l r18 = this.a;
            Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.menu.handler.IReplyMenuHandler");
            r18.I(r2, r12, r0);
            goto L53
        L47:
            r6 = null;
            goto L48
        L17:
            if ((r11 instanceof y6b.c) == false) goto L19;
            y6b.c r19 = (y6b.c) r11;
        L20:
            if (r19 == null) goto L23;
            String r20 = r19.Q1;
            if (r20 == null) goto L23;
        L25:
            if (r20.length() != 0) goto L27;
            r3 = true;
        L27:
            if (r3 == true) goto L30;
            r2 = r20;
        L30:
            l1.a r21 = new l1.a();
            r21.e = r2;
            r21.l = r11.getChatId();
            r21.b = true;
            l1 r22 = new l1(r21);
            Context r23 = r7.getContext();
            Intrinsics.checkNotNull(r22);
            Boolean r24 = ReplyInThreadUtil.a;
            Intrinsics.checkNotNullParameter(r23, "context");
            Intrinsics.checkNotNullParameter(r22, "bundle");
            ReplyInThreadUtil.c(r23, r22, null);
            return;
        L23:
            r20 = BuildConfig.FLAVOR;
            goto L25
        L19:
            r19 = null;
            goto L20
        }
    }

    public static final class a {
        public final Chat a;

        public a(Chat r1) {
            this.a = r1;
        }

        public final boolean a(OpenApp r4) {
            Chat r0 = this.a;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (r0.isChatable() == true) goto L9;
            return false;
        L9:
            if (r0.isAllowPost() == true) goto L11;
            return false;
        L11:
            if (r4 != null) goto L13;
            return true;
        L13:
            if (r4.getState() == null) goto L18;
            if (r4.getState() == OpenApp.State.USABLE) goto L18;
            return false;
        L18:
            if (r4.getChatable() != null) goto L20;
            return true;
        L20:
            if (r4.getChatable() != OpenApp.Chatable.UNCHATABLE) goto L25;
            return false;
        L25:
            return true;
        }
    }

    public static final class b {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }
    }

    public interface c {
        OpenApp e();
    }

    static {
    }

    public ChatReplyActionProvider() {
    }

    public final String getTAG() {
        return "ChatReplyActionProvider";
    }
}
