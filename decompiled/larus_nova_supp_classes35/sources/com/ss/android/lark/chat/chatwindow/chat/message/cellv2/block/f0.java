package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatAnnouncement;
import com.ss.android.lark.statistics.announce_opendoc.AnnounceOpenDocHitPoint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ PostContentBlock a;

    public f0(PostContentBlock r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Chat r4 = this.a.c.getChat();
        if (r4 == null) goto L7;
        ChatAnnouncement r5 = r4.getChatAnnouncement();
        if (r5 == null) goto L7;
        String r6 = r5.getAnnounceUrl();
    L8:
        AnnounceOpenDocHitPoint.a(this.a.c.getChatId());
        PostContentBlock r0 = this.a;
        r0.l.openUrl(r0.getContext(), r6);
        return;
    L7:
        r6 = null;
        goto L8
    }
}
