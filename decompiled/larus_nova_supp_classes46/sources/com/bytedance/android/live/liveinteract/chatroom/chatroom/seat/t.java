package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements Action {
    public final /* synthetic */ HSImageView a;

    public t(HSImageView r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.setVisibility(8);
        UtilityKotlinExtentionsKt.q(this.a);
    }
}
