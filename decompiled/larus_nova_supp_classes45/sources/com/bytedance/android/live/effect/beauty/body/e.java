package com.bytedance.android.live.effect.beauty.body;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements LiveSwitchButton.e {
    public final /* synthetic */ LiveBodyBeautyAdapter a;
    public final /* synthetic */ LiveBodyBeautyAdapter.b b;

    public e(LiveBodyBeautyAdapter r1, LiveBodyBeautyAdapter.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d0(LiveSwitchButton r3, boolean r4) {
        this.a.m = r4;
        TextView r5 = (TextView) ((RecyclerView.ViewHolder) this.b).itemView.findViewById(2131387943);
        if (r4 == false) goto L5;
        int r0 = 2131916440;
    L6:
        r5.setText(s1.B(r0));
        if (r4 == true) goto L12;
        LiveBodyBeautyAdapter r6 = this.a;
        int r1 = r6.c;
        r6.c = -1;
        LiveBodyBeautyAdapter.a r7 = r6.d;
        if (r7 == null) goto L11;
        r7.a(null);
    L11:
        this.a.notifyItemChanged(r1 + 1);
    L13:
        LiveBodyBeautyAdapter.a r8 = this.a.d;
        if (r8 == null) goto L17;
        r8.b(r4);
        return;
    L17:
        return;
    L12:
        r3.g(((RecyclerView.ViewHolder) this.b).itemView.findViewById(2131387878), "已开启");
        goto L13
    L5:
        r0 = 2131916439;
        goto L6
    }
}
