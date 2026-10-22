package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements mcc.i {
    public final c a;

    public final boolean o(View r1, String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
        return false;
    }

    public final c getContext() {
        return this.a;
    }

    public o(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void p(View r1, String r2, String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
        ChatCoreModule.a().openAppLinkUrl(this.a.getContext(), r5);
    }
}
