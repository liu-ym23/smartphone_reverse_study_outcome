package com.bytedance.android.live.effect.beauty.smallitem;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 implements LiveSwitchButton.e {
    public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter a;
    public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter.b b;

    public h0(LiveSmallItemBeautyTemplateAdapter r1, LiveSmallItemBeautyTemplateAdapter.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d0(LiveSwitchButton r3, boolean r4) {
        this.a.n = r4;
        TextView r5 = (TextView) ((RecyclerView.ViewHolder) this.b).itemView.findViewById(2131387943);
        if (r4 == false) goto L5;
        int r0 = 2131916440;
    L6:
        r5.setText(s1.B(r0));
        if (r4 == true) goto L12;
        LiveSmallItemBeautyTemplateAdapter r6 = this.a;
        int r1 = r6.d;
        r6.d = -1;
        LiveSmallItemBeautyTemplateAdapter.a r7 = r6.e;
        if (r7 == null) goto L11;
        r7.a(null);
    L11:
        this.a.notifyItemChanged(r1 + 1);
    L12:
        LiveSmallItemBeautyTemplateAdapter.a r8 = this.a.e;
        if (r8 == null) goto L16;
        r8.b(r4);
        return;
    L16:
        return;
    L5:
        r0 = 2131916439;
        goto L6
    }
}
