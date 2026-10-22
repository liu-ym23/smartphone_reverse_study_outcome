package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.widget.span.UrlInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s0 implements mcc.o {
    public final /* synthetic */ TextContentBlock a;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> b;

    public final boolean t(View r2, UrlInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "urlInfo");
        return false;
    }

    public s0(TextContentBlock r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void r(View r10, UrlInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "urlInfo");
        String r12 = r11.urlPreviewId;
        ChatCoreModule.a().getPerfEnterChatMonitor().c();
        mya.w r0 = this.a.g().j5().b(mya.w.class);
        if (r0 == null) goto L7;
        this.b.getId();
        boolean r1 = true;
        if (true != r0.w()) goto L7;
    L8:
        if (r1 == true) goto L10;
        Bundle r6 = com.ss.android.lark.chat.utils.i0.c(r12, this.b);
        BrowserDependency r2 = ChatCoreModule.a().getBrowserDependency();
        FragmentActivity r3 = this.a.g().getContext();
        String r4 = r11.href;
        boolean r5 = this.a.g().isGroup();
        Fragment r7 = this.a.g().R();
        r2.d(r3, r4, r5 ? 1 : 0, BrowserDependency.UrlClickType.INLINE, r6, r7, null);
        com.ss.android.lark.chat.utils.i0.e(r12, this.b);
    L10:
        String r13 = h7b.l.b(this.a.g().isMeeting(), this.a.g().isGroup(), this.a.g().X());
        Intrinsics.checkNotNull(r13);
        MessageHitPoint.e("text", r13, this.b.getId());
        int r14 = f3b.c.a;
        f3b.c.d(this.b);
        ChatCoreModule.a().getAuditDependency().auditLinkEvent(this.a.g().getChatId(), r11.href);
        if (this.a.g().e0() == false) goto L14;
        ChatHitPointExtraParams.Occasion r15 = ChatHitPointExtraParams.Occasion.MULTI_FORWARD;
    L17:
        f3b.c.c(this.a.g(), this.b, r11.href, r15);
        this.a.f().p(this.b.getId(), r11.href);
        return;
    L14:
        if ((this.a.g() instanceof s2b.d) == false) goto L16;
        r15 = ChatHitPointExtraParams.Occasion.MSG;
        goto L17
    L16:
        r15 = null;
    L7:
        r1 = false;
        goto L8
    }
}
