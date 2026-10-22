package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.view.View;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ReplyInThreadKeyboardPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public static final /* synthetic */ int m = 0;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public IMessageListComponent h;
    public IKeyboardComponent i;
    public ITitlebarComponent j;
    public zhb.a k;
    public final Lazy l;

    public static final class a {
    }

    static {
    }

    public ReplyInThreadKeyboardPlugin() {
        this.l = LazyKt.lazy(new ReplyInThreadKeyboardPlugin$draftService$2(this));
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r4, i7b.a r5) {
        Intrinsics.checkNotNullParameter(r4, "chatApp");
        Intrinsics.checkNotNullParameter(r5, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r4, r5);
        this.g = r4;
        zhb.a r6 = r4.getFragment();
        ChatBaseComponent.a r1 = null;
        if ((r6 instanceof zhb.a) == false) goto L5;
        zhb.a r7 = r6;
    L6:
        this.k = r7;
        if (r7 == null) goto L11;
        ThreadTopic r8 = r7.N1();
        if (r8 == null) goto L11;
        r8.getId();
    L11:
        this.h = r4.a(IMessageListComponent.class);
        this.i = r4.a(IKeyboardComponent.class);
        this.j = r4.a(ITitlebarComponent.class);
        boolean r9 = false;
        if (KeyboardVoiceFGUtils.c() == false) goto L29;
        IKeyboardComponent r10 = this.i;
        if (r10 == null) goto L24;
        com.ss.android.lark.keyboard.b r11 = r10.n();
        if (r11 == null) goto L24;
        com.ss.android.lark.keyboard.keyboard2.content.c r12 = r11.v();
        if (r12 == null) goto L24;
        IKeyboardContent r13 = r12.l();
        if (r13 == null) goto L24;
        IKeyboardContent.a r14 = r13.getKey();
        if (r14 == null) goto L24;
        String r15 = r14.getTag();
    L25:
        ImmersiveVoiceInputComponent.a r2 = ImmersiveVoiceInputComponent.a;
        if (Intrinsics.areEqual(r15, "ImmersiveVoiceKeyboardKey") == false) goto L29;
        boolean r16 = false;
    L30:
        zhb.a r3 = this.k;
        if (r3 != null) goto L33;
    L35:
        boolean r17 = false;
    L36:
        if (r17 == false) goto L52;
        zhb.a r18 = this.k;
        if (r18 != null) goto L40;
    L42:
        if (r9 == true) goto L53;
        if (r16 == false) goto L54;
        ChatBaseComponent.a r19 = this.g;
        if (r19 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L48:
        View r20 = r1.getFragment().getView();
        if (r20 == null) goto L55;
        r20.postDelayed(new com.ss.android.lark.flow.replyinthread.pages.plugin.a(this), 200);
        return;
    L55:
        return;
    L47:
        r1 = r19;
        goto L48
    L54:
        return;
    L53:
        return;
    L40:
        if (r18.io() != true) goto L42;
        r9 = true;
        goto L42
    L52:
        return;
    L33:
        if (r3.hE() != true) goto L35;
        r17 = true;
    L24:
        r15 = null;
    L29:
        r16 = true;
        goto L30
    L5:
        r7 = null;
        goto L6
    }
}
