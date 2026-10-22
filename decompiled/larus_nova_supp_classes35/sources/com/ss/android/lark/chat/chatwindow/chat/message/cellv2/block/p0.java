package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p0 implements mcc.i {
    public final /* synthetic */ TextContentBlock a;

    public final boolean o(View r1, String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "s");
        Intrinsics.checkNotNullParameter(r3, "s1");
        return false;
    }

    public p0(TextContentBlock r1) {
        this.a = r1;
    }

    public final void p(View r1, String r2, String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
        ChatCoreModule.a().openAppLinkUrl(this.a.getContext(), r5);
    }
}
