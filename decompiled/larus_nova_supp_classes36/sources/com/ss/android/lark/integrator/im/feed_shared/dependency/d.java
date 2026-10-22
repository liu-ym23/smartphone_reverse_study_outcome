package com.ss.android.lark.integrator.im.feed_shared.dependency;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements peb.b.d {
    public d() {
    }

    public final void a(Context r3, String r4, int r5, boolean r6) {
        int r0 = FlowChatModule.d;
        FlowChatModule r1 = FlowChatModule.a.a();
        l1.a r2 = new l1.a();
        r2.e = r4;
        r2.k = r5;
        r2.j = "feed";
        r2.B = r6;
        l1 r7 = new l1(r2);
        r1.getClass();
        FlowChatModule.g(r3, r7);
    }

    public final void b(Context r3, String r4, int r5, boolean r6) {
        Log.i("ChatDependency", "enter openThreadPage");
        int r0 = FlowChatModule.d;
        FlowChatModule r1 = FlowChatModule.a.a();
        l1.a r2 = new l1.a();
        r2.e = r4;
        r2.k = r5;
        r2.j = "feed";
        r2.B = r6;
        l1 r7 = new l1(r2);
        r1.getClass();
        FlowChatModule.g(r3, r7);
    }

    public final void c(Context r2, Fragment r3, String r4, int r5, boolean r6) {
        l1.a r0 = new l1.a();
        r0.e = r4;
        r0.k = r5;
        r0.j = "feed";
        r0.B = r6;
        l1 r7 = new l1(r0);
        int r8 = FlowChatModule.d;
        FlowChatModule.a.a().getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r7, "bundle");
        KeyboardUtils.hideKeyboard(r2);
        whb.d.b(r2, r3, r7);
    }

    public final void d(Context r2, String r3, Chat.ChatMode r4, boolean r5, String r6, int r7, boolean r8) {
        ChatBundle.a r0 = new ChatBundle.a();
        r0.a = r3;
        r0.a(r4);
        r0.m = r5;
        r0.h = SourceType.fromValue("feed");
        r0.d = r6;
        r0.g = null;
        r0.y = r7;
        r0.G = r8;
        ChatBundle r9 = new ChatBundle(r0);
        int r10 = FlowChatModule.d;
        FlowChatModule.a.a().e(r2, r9, new ChatDependency$1(this));
    }
}
