package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ TalkRoomNormalApplyTitleViewHolder$showBubbleView$$inlined$apply$lambda$1 a;
    public final /* synthetic */ TalkRoomNormalApplyTitleViewHolder b;

    public f(TalkRoomNormalApplyTitleViewHolder$showBubbleView$$inlined$apply$lambda$1 r1, TalkRoomNormalApplyTitleViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.invoke(40);
        TalkRoomNormalApplyTitleViewHolder r5 = this.b;
        com.bytedance.android.live.liveinteract.linkpanel.list.a r1 = r5.k;
        if (r1 == null) goto L5;
        r1.l(40, new TalkRoomNormalApplyTitleViewHolder$updateSortSetting$1(r5));
    L5:
        c90.a r6 = this.b.j;
        if (r6 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r6);
        r6.dismiss();
        return;
    }
}
