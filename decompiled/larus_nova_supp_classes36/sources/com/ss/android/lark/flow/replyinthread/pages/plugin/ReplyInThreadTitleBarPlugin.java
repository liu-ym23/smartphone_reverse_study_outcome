package com.ss.android.lark.flow.replyinthread.pages.plugin;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ReplyInThreadTitleBarPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public static final /* synthetic */ int p = 0;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public i7b.a h;
    public IMessageListComponent i;
    public IKeyboardComponent j;
    public ITitlebarComponent k;
    public zhb.a l;
    public String m;
    public final Lazy n;
    public final Lazy o;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TitleBarActionKey.values().length];
            r0[TitleBarActionKey.FORWARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TitleBarActionKey.SETTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final boolean F() {
        IMessageListComponent r0 = this.i;
        if (r0 == null) goto L10;
        MessageInfo r1 = r0.getTopicMessageInfo();
        if (r1 == null) goto L10;
        Message r2 = r1.getMessage();
        if (r2 == null) goto L10;
        Map r3 = r2.getDisabledAction();
        if (r3 == null) goto L10;
    L11:
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r4 = (com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior) r3.get(Integer.valueOf(com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.TRANSMIT.getValue()));
        if (r4 == null) goto L15;
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode r5 = r4.display_mode;
        if (r5 == null) goto L15;
    L16:
        if (r4 == null) goto L20;
        Integer r6 = r4.code;
        if (r6 == null) goto L20;
        int r7 = r6.intValue();
    L22:
        if (r5 == com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode.DISABLE) goto L24;
        return false;
    L24:
        if (r7 != 311150) goto L32;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r8 = this.g;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r8 = null;
    L28:
        FlowToast.c(r8.getContext(), 2131891223);
        return true;
    L32:
        return false;
    L20:
        r7 = -1;
    L15:
        r5 = com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode.MODE_UNSPECIFIED;
    L10:
        r3 = MapsKt.emptyMap();
        goto L11
    }

    public final boolean H() {
        i7b.a r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chatInitData");
        r0 = null;
    L5:
        Chat r1 = r0.f;
        w4b.c.p r2 = ChatCoreModule.a().getProfile();
        if (r2 == null) goto L9;
        r2.getClass();
    L9:
        if (com.ss.android.lark.chat.utils.k.d(r1) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public ReplyInThreadTitleBarPlugin() {
        this.m = "";
        this.n = LazyKt.lazy(new ReplyInThreadTitleBarPlugin$settingsAction$2(this));
        this.o = LazyKt.lazy(new ReplyInThreadTitleBarPlugin$forwardAction$2(this));
    }

    public final s5c.d G() {
        Map r0 = ChatParamUtils.e();
        IMessageListComponent r1 = this.i;
        if (r1 == null) goto L7;
        MessageInfo r2 = r1.getTopicMessageInfo();
        if (r2 == null) goto L7;
        Map r3 = ChatParamUtils.g(r2.getMessage());
    L9:
        return s5c.d.b.a(t3.c.a(this.m), r0).plus(r3);
    L7:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r4v25, types: [com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$onCreate$2] */
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r3, r4);
        this.g = r3;
        this.h = r4;
        zhb.a r5 = r3.getFragment();
        if ((r5 instanceof zhb.a) == false) goto L5;
        zhb.a r6 = r5;
    L6:
        this.l = r6;
        if (r6 == null) goto L12;
        ThreadTopic r7 = r6.N1();
        if (r7 == null) goto L12;
        String r8 = r7.getId();
        if (r8 == null) goto L12;
    L13:
        this.m = r8;
        this.i = r3.a(IMessageListComponent.class);
        this.j = r3.a(IKeyboardComponent.class);
        this.k = r3.a(ITitlebarComponent.class);
        IMessageListComponent r9 = this.i;
        if (r9 == null) goto L16;
        r9.m(new ReplyInThreadTitleBarPlugin$onCreate$1(this));
    L16:
        ITitlebarComponent r10 = this.k;
        if (r10 == null) goto L19;
        r10.xD(new ReplyInThreadTitleBarPlugin$onCreate$2(this));
    L19:
        ITitlebarComponent r11 = this.k;
        if (r11 == null) goto L22;
        r11.updateTitle();
    L22:
        ITitlebarComponent r12 = this.k;
        if (r12 == null) goto L27;
        FlowTitleBarComponent.RightAreaImpl r13 = r12.F00();
        if (r13 == null) goto L27;
        r13.e(TitleBarActionKey.SETTING);
    L27:
        zhb.a r14 = this.l;
        if (r14 == null) goto L56;
        List<TitleBarActionKey> r15 = r14.sr();
        if (r15 == null) goto L75;
        Iterator<T> r16 = r15.iterator();
    L33:
        if (r16.hasNext() == false) goto L76;
        TitleBarActionKey r17 = (TitleBarActionKey) r16.next();
        int r18 = b.a[r17.ordinal()];
        boolean r0 = true;
        if (r18 != 1) goto L37;
        ITitlebarComponent r19 = this.k;
        if (r19 == null) goto L33;
        FlowTitleBarComponent.RightAreaImpl r20 = r19.F00();
        if (r20 == null) goto L33;
        r20.a((ReplyInThreadTitleBarPlugin$forwardAction$2.a) this.o.getValue());
        goto L33
    L37:
        if (r18 != 2) goto L33;
        zhb.a r21 = this.l;
        if (r21 != null) goto L42;
    L44:
        r0 = false;
    L45:
        if (r0 == false) goto L33;
        ITitlebarComponent r22 = this.k;
        if (r22 == null) goto L33;
        FlowTitleBarComponent.RightAreaImpl r23 = r22.F00();
        if (r23 == null) goto L33;
        r23.a((ReplyInThreadTitleBarPlugin$settingsAction$2.a) this.n.getValue());
        goto L33
    L42:
        if (r21.E80() == true) goto L44;
    L76:
        return;
    L75:
        return;
    L56:
        return;
    L12:
        r8 = "";
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public static void I(ReplyInThreadTitleBarPlugin r1, String r2, int r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        r1.getClass();
        ViewUtils.runOnUiThread(new p(r2, r1, r3));
    }
}
