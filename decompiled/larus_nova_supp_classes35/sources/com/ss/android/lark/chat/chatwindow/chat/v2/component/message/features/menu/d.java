package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yya.l;
import yya.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.d {
    public final /* synthetic */ MessageListMenuFeature a;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.d
    public final List<l> a() {
        s2b.c r0 = this.a.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e.a();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.d
    public final ChatReplyActionProvider.a b() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r1 = this.a.m();
        if (r1 == null) goto L5;
        Chat r2 = r1.getCurrentChat();
    L7:
        return new ChatReplyActionProvider.a(r2);
    L5:
        r2 = null;
        goto L7
    }

    public d(MessageListMenuFeature r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.d
    public final s2b.b c(y6b.c r9, n r10) {
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r10, "itemHook");
        s2b.c r2 = this.a.c;
        if (r2 != null) goto L7;
        return null;
    L7:
        return new s2b.b(r2, r10, r2.g, r2.b, r2.c, r9);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.d
    public final void d(y6b.c<?> r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "messageVO");
        boolean r1 = false;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = null;
        if (r7.d() == true) goto L14;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = this.a.m();
        if (r0 == null) goto L9;
        Chat r3 = r0.getCurrentChat();
        if (r3 == null) goto L9;
        ChatDisplayModeSetting r4 = r3.getChatDisplayModeSetting();
    L11:
        if (r4 == ChatDisplayModeSetting.THREAD) goto L14;
        boolean r5 = false;
    L15:
        if (r5 == false) goto L38;
        String r9 = r7.Q1;
        if (r9 != null) goto L19;
    L22:
        boolean r10 = true;
    L23:
        boolean r11 = !r10;
        String r6 = r7.c;
        String r12 = r7.Q1;
        if (r12 != null) goto L27;
        r12 = BuildConfig.FLAVOR;
    L27:
        if (r12.length() != 0) goto L29;
        r1 = true;
    L29:
        if (r1 == false) goto L31;
        r12 = r6;
    L31:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r13 = this.a.b;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L35:
        a4b.a r14 = (a4b.a) r2.b(a4b.a.class);
        if (r14 == null) goto L40;
        r14.p(r6, r12, r11, r7.e);
        return;
    L40:
        return;
    L34:
        r2 = r13;
        goto L35
    L19:
        if (r9.length() == 0) goto L22;
        r10 = false;
        goto L23
    L38:
        this.a.F(r7.c, r8, null);
        return;
    L9:
        r4 = null;
    L14:
        r5 = true;
        goto L15
    }
}
