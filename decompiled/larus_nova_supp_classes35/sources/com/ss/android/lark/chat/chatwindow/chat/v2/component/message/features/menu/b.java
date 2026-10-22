package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu;

import androidx.fragment.app.Fragment;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager$keyboardEventCenterHandler$2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yya.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements s2b.c.b {
    public final /* synthetic */ MessageListMenuFeature a;

    @Override // s2b.c.b
    public final ChatChatter N0() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = this.a.m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.N0();
    }

    @Override // s2b.c.b
    public final List<l> a() {
        return this.a.a.c();
    }

    @Override // s2b.c.b
    public final void b() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = MessageListMenuFeature.l(this.a);
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.C0064b());
        return;
    }

    @Override // s2b.c.b
    public final ChatChatter g7() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = this.a.m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.an();
    }

    @Override // s2b.c.b
    public final Fragment getFragment() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return r0.getFragment();
    }

    @Override // s2b.c.b
    public final void i7() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListComponent.e r1 = r0.getDependency();
        if (r1 == null) goto L11;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r2 = r1.a();
        if (r2 == null) goto L12;
        r2.c();
        return;
    L12:
        return;
    }

    @Override // s2b.c.b
    public final int k7() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListComponent.e r2 = r0.getDependency();
        if (r2 == null) goto L10;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.f r3 = r2.c();
        if (r3 == null) goto L10;
        return r3.b();
    L10:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r4 = this.a.b;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L15:
        return UIUtils.dp2px(r1.getContext(), 44.0f);
    L13:
        r1 = r4;
        goto L15
    }

    @Override // s2b.c.b
    public final Integer l7() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListComponent.e r1 = r0.getDependency();
        if (r1 == null) goto L11;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r2 = r1.a();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.d();
    L11:
        return null;
    }

    @Override // s2b.c.b
    public final boolean m7() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListComponent.e r2 = r0.getDependency();
        if (r2 == null) goto L12;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r3 = r2.a();
        if (r3 == null) goto L12;
        if (r3.h() != true) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L27;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.a.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L18:
        IMessageListComponent.e r6 = r1.getDependency();
        if (r6 == null) goto L25;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r7 = r6.a();
        if (r7 == null) goto L25;
        if (r7.g() != true) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L27;
        return false;
    L25:
        r8 = false;
        goto L26
    L17:
        r1 = r5;
    L27:
        return true;
    L12:
        r4 = false;
        goto L13
    }

    public b(MessageListMenuFeature r1) {
        this.a = r1;
    }

    @Override // s2b.c.b
    public final void h7(boolean r2) {
        this.a.d = r2;
    }

    @Override // s2b.c.b
    public final void j7(MessageActionPanelManager$keyboardEventCenterHandler$2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListComponent.e r1 = r0.getDependency();
        if (r1 == null) goto L11;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r3 = r1.a();
        if (r3 == null) goto L12;
        r3.b(r2);
        return;
    L12:
        return;
    }

    @Override // s2b.c.b
    public final MessageInfo p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = this.a.m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageInfoById(r2);
    }

    @Override // s2b.c.b
    public final void n7(y6b.c<? extends v5b.a<?>> r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "reactionKey");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = MessageListMenuFeature.l(this.a);
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.w(r3, r4, r5));
        return;
    }
}
