package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j extends ClickableSpan {
    public final /* synthetic */ DLPBlock a;
    public final /* synthetic */ String b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "widget");
        long r0 = System.currentTimeMillis();
        DLPBlock r9 = this.a;
        long r2 = r9.h;
        if (r2 != (-1)) goto L5;
    L6:
        FragmentActivity r10 = r9.c.getContext();
        String r3 = this.b;
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent("messenger", "messenger_chat");
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).openUrl(r10, r3);
        this.a.h = r0;
        return;
    L5:
        if ((r0 - r2) > 1000) goto L6;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        r3.setColor(UIUtils.getColor(this.a.c.getContext(), 2131106616));
        r3.setUnderlineText(false);
    }

    public j(DLPBlock r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
