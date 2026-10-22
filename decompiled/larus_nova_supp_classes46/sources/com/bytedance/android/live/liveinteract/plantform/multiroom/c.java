package com.bytedance.android.live.liveinteract.plantform.multiroom;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ MultiLinkUIWidget a;

    public c(MultiLinkUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        MultiLinkUIWidget r6 = this.a;
        r6.Jq("MultiLinkUIWidget#_onRoomVisible", r6.hashCode(), "倒计时结束，兜底显示seatWindowView");
        l r7 = this.a.d;
        if (r7 == null) goto L8;
        ViewGroup r8 = r7.td();
        if (r8 == null) goto L9;
        UtilityKotlinExtentionsKt.x(r8);
        return;
    L9:
        return;
    }
}
