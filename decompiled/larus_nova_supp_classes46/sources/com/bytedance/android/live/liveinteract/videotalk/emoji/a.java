package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BaseDynamicEmojiDialog a;

    public a(BaseDynamicEmojiDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.disconnect();
    }
}
