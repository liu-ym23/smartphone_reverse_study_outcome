package com.ss.android.lark.integrator.im.module.export;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.auditsdk.security.SecurityService;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.create.groupchat.impl.service.interceptor.StrangerInterceptor;
import hab.b;
import hab.c;
import hab.d;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowGroupCreateExport implements b, hab.a, c, d {

    public static final class a {
    }

    static {
    }

    @Inject
    public FlowGroupCreateExport() {
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("new_group", "way");
    }

    public final IChatParser getChatParser() {
        return (IChatParser) ChatCoreModule.b.getValue();
    }

    public final void b(String r2, StrangerInterceptor.getP2pChatCreatedByChatterId.2.1 r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        ChatService.c.a.getP2pChatCreatedByChatterId(r2, r3);
    }

    public final boolean d(int r2, String r3) {
        return ((SecurityService) SecurityService.a.getValue()).a(r2, r3);
    }

    public final void openChat(Context r4, ChatBundle r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "chatBundle");
        int r0 = dgb.a.d;
        com.ss.android.lark.chatwindow.launcher.c r1 = dgb.a.C0248a.a().b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("chatLauncherV2");
        r1 = null;
    L6:
        int r2 = ChatBundleInput.j;
        r1.U7(r4, null, ChatBundleInput.Companion.a(r5), new AnonymousClass2());
    }

    public final void c(Fragment r3, Context r4, ChatBundle r5) {
        Intrinsics.checkNotNullParameter(r3, "sourceFragment");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "chatBundle");
        int r0 = dgb.a.d;
        com.ss.android.lark.chatwindow.launcher.c r1 = dgb.a.C0248a.a().b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("chatLauncherV2");
        r1 = null;
    L6:
        int r2 = ChatBundleInput.j;
        r1.U7(r4, r3, ChatBundleInput.Companion.a(r5), new AnonymousClass1());
    }
}
