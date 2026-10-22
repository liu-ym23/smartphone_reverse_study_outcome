package com.larus.bmhome.chat.list.cell.spacer;

import android.view.animation.PathInterpolator;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.view.ChatMessageList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ SpacerCell a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(SpacerCell r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpacerCell r0 = this.a;
        int r1 = this.b;
        PathInterpolator r2 = SpacerCell.e;
        if (r0.s(r1) != SpacerCell$FollowLatestResult.APPLIED) goto L13;
        ChatMessageList r3 = ((BaseMessageListCell) r0).b;
        if ((r3 instanceof ChatMessageList) == false) goto L7;
        ChatMessageList r4 = r3;
    L8:
        if (r4 == null) goto L10;
        int r5 = r4.getSpacing();
    L11:
        r0.u(r5);
        return;
    L10:
        r5 = 0;
        goto L11
    L7:
        r4 = null;
        goto L8
    }
}
