package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.q;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.chat.utils.k1;
import com.ss.android.lark.chat.utils.o;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.selection.MovableSelectionManager;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatCopyActionProvider implements m {
    public final Lazy a;
    public final Set<Message.Type> b;

    public static final class a {
    }

    public final class b implements i {
        public final yya.a a;
        public final /* synthetic */ ChatCopyActionProvider b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[PageType.values().length];
                r0[PageType.MERGE_FORWARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L4:
                a = r0;
                int[] r1 = new int[Message.Type.values().length];
                r1[Message.Type.POST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L18:
                r1[Message.Type.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L24:
                r1[Message.Type.CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L16:
                r1[Message.Type.AUDIO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L9:
                b = r1;
            }
        }

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "copy"), TuplesKt.to("target", "none")});
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

        public final boolean isEnable() {
            return true;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final boolean isVisible() {
            Message.Type r0 = this.a.l();
            if (this.b.b.contains(r0) == true) goto L5;
            return false;
        L5:
            boolean r1 = ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.messenger.url_card");
            boolean r2 = this.a.m().na();
            if (this.a.m().e() == false) goto L10;
            if (r1 == false) goto L10;
            if (r2 == true) goto L10;
            return false;
        L10:
            g r3 = w.a(this.a).C();
            v5b.a r4 = this.a.m().b();
            if ((r4 instanceof LynxCardContentVO) == false) goto L14;
            return true;
        L14:
            if ((r4 instanceof com.ss.android.lark.message.card.view.a) == false) goto L17;
            return r3.isEnable("messagecard.surpportcopy.enable");
        L17:
            if ((r4 instanceof AudioContentVO) == true) goto L19;
            return true;
        L19:
            return r3.isEnable("messenger.message_voice_copy");
        }

        public MessageActionType getType() {
            return MessageActionType.COPY;
        }

        public final void d(c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131254165, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIHelper.getString(2131891639);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public b(ChatCopyActionProvider r2, yya.a r3) {
            Intrinsics.checkNotNullParameter(r3, "actionContext");
            this.b = r2;
            this.a = r3;
        }

        public final void b(View r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r7, "view");
            if (r8 == true) goto L6;
            return;
        L6:
            if (a.a[this.a.r().ordinal()] != 1) goto L8;
            Chat r9 = ChatParamUtils.b;
        L10:
            if (y0.a(r9) == true) goto L13;
            y0.f(this.a.getContext());
            return;
        L13:
            int r10 = a.b[this.a.m().getType().ordinal()];
            if (r10 != 1) goto L16;
            v5b.c r11 = this.a.m();
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<com.ss.android.lark.chat.base.view.vo.message.PostContentVO>");
            y6b.a r12 = (y6b.a) r11;
            new q(this.a.getContext()).a(r12);
            int r13 = o.a;
            o.a(this.a, r12.getType());
        L58:
            MovableView r14 = com.ss.android.lark.chat.message.menu.a.a(this.a.a);
            if (r14 == null) goto L64;
            MovableSelectionManager r15 = r14.getRootMovableView().n;
            if (r15 == null) goto L65;
            r15.d();
            return;
        L65:
            return;
        L64:
            return;
        L16:
            if (r10 != 2) goto L18;
            v5b.c r16 = this.a.m();
            Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO<com.ss.android.lark.chat.entity.message.content.TextContent>>");
            y6b.a r17 = (y6b.a) r16;
            Context r0 = this.a.getContext();
            if (r17 != null) goto L52;
            Log.e("TextMessageCopyHandler", "on copy return, message is null");
        L56:
            int r18 = o.a;
            o.a(this.a, r17.getType());
            goto L58
        L52:
            k1.a r19 = k1.a(r0, r17);
            CharSequence r1 = r19.a;
            RichText r2 = r19.b;
            boolean r5 = r19.c;
            HashMap r20 = new HashMap();
            Map<String, Object> r3 = ChatParamUtils.e();
            if (r3 == null) goto L55;
            r20.putAll(r3);
        L55:
            r20.putAll(IMRichTextCopyUtils.d(r17));
            IMRichTextCopyUtils.l(u.a.a.c, r2, r20);
            b7b.b.b(r0, IMRichTextCopyUtils.j(r1, r2), r2, r17.getId(), new Token("LARK-PSDA-messenger-android-copy-textmessage"), r5);
            goto L56
        L18:
            if (r10 != 3) goto L20;
            v5b.c r21 = this.a.m();
            Context r22 = this.a.getContext();
            if ((r21.b() instanceof com.ss.android.lark.message.card.view.a) == false) goto L37;
            com.ss.android.lark.message.card.view.a r4 = r21.b();
            if (r4 != null) goto L28;
            Log.e("chatwindow", "CardMessageCopyHandler onCopyMessage error: contentVO is null");
        L48:
            int r23 = o.a;
            o.a(this.a, r21.getType());
            goto L58
        L28:
            SpannableStringBuilder r6 = new SpannableStringBuilder();
            r4.getClass();
            CharSequence r24 = b7b.b.e(null);
            if (TextUtils.isEmpty(r24) == true) goto L32;
            r6.append(r24);
            b7b.b.a(r22, r6.toString(), new Token("LARK-PSDA-messenger-android-copy-cardmessage"), new b7b.a(r22));
            goto L48
        L32:
            if (r4.a != 0) goto L34;
            Log.e("chatwindow", "CardMessageCopyHandler onCopyMessage error: content is null");
            goto L48
        L34:
            r4.getClass();
            throw null;
        L37:
            if ((r21.b() instanceof LynxCardContentVO) == false) goto L48;
            LynxCardContentVO r25 = r21.b();
            if (r25 != null) goto L41;
            Log.e("chatwindow", "CardMessageCopyHandler onCopyMessage error: contentVO is null");
            goto L48
        L41:
            SpannableStringBuilder r26 = new SpannableStringBuilder();
            CharSequence r27 = b7b.b.e(r25.w);
            if (TextUtils.isEmpty(r27) == true) goto L44;
            r26.append(r27);
        L47:
            b7b.b.a(r22, r26.toString(), new Token("LARK-PSDA-messenger-android-copy-cardmessage"), new b7b.a(r22));
            goto L48
        L44:
            String r28 = ((CardContent) r25.a).getCardDetailDigest();
            if (TextUtils.isEmpty(r28) == true) goto L47;
            r26 = r26.append(r28);
            goto L47
        L20:
            if (r10 == 4) goto L22;
            Log.e("ChatCopyActionProvider", "Unsupported message type: " + this.a.m().getType());
            goto L58
        L22:
            v5b.c r29 = this.a.m();
            com.ss.android.lark.chat.chatwindow.chat.menu.handler.a r30 = new com.ss.android.lark.chat.chatwindow.chat.menu.handler.a(this.a.getContext());
            Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<com.ss.android.lark.chat.base.view.vo.message.AudioContentVO>");
            y6b.a r31 = (y6b.a) r29;
            r30.a(r31);
            int r32 = o.a;
            o.a(this.a, r31.getType());
            goto L58
        L8:
            r9 = this.a.getChat();
            goto L10
        }
    }

    static {
    }

    public final String getTAG() {
        return "ChatCopyActionProvider";
    }

    public ChatCopyActionProvider() {
        this.a = LazyKt.lazy(ChatCopyActionProvider$supportedPageTypes$2.INSTANCE);
        this.b = SetsKt.mutableSetOf(new Message.Type[]{Message.Type.TEXT, Message.Type.POST, Message.Type.CARD, Message.Type.AUDIO});
    }
}
