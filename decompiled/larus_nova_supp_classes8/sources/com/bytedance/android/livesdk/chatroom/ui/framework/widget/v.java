package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ InRoomBannerManagerWidget a;

    public v(InRoomBannerManagerWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        BannerData r4 = (BannerData) r3;
        if (InRoomBannerManagerWidget.wq(this.a) == null) goto L24;
        DataContext r0 = InRoomBannerManagerWidget.wq(this.a);
        if (r0 == null) goto L10;
        if (r0.isCleared() != true) goto L10;
        return;
    L10:
        if (r4.getData().getBottomRightBanner() != null) goto L12;
    L19:
        RoomContext r5 = InRoomBannerManagerWidget.wq(this.a);
        if (r5 == null) goto L23;
        r5.isBannerRightBottom().setValue(Boolean.FALSE);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.RoomContext");
    L12:
        if (Lists.isEmpty(r4.getData().getBottomRightBanner().getBannerList()) == true) goto L19;
        RoomContext r6 = InRoomBannerManagerWidget.wq(this.a);
        if (r6 == null) goto L18;
        r6.isBannerRightBottom().setValue(Boolean.TRUE);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.RoomContext");
    }
}
