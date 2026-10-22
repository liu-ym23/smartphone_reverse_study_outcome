package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements com.ss.android.lark.coremd.base.parse.n.b<eab.g> {
    public final /* synthetic */ i a;

    public e(i r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(com.ss.android.lark.coremd.impl.parse.f r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ChatCoreModule.a().getPhoneDependency().a(this.a.a.getContext(), ((eab.g) r3.d).j);
    }
}
