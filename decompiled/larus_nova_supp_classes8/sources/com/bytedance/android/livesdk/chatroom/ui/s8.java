package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s8 implements View.OnClickListener {
    public final /* synthetic */ ResolutionDowngradeView a;

    public s8(ResolutionDowngradeView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.getOnSelectResolutionDowngrade().invoke();
    }
}
