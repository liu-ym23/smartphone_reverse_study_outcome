package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods.AIWishGiftRoomScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a1 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public int b;
    public final DataCenter c;

    public final void onStart() {
    }

    public static Number c() {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L30;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L30;
        LiveMode r2 = r1.getStreamType();
        int r3 = x0.a[r2.ordinal()];
        if (r3 == 1) goto L28;
        if (r3 == 2) goto L26;
        if (r3 == 3) goto L24;
        if (r3 == 4) goto L22;
        if (r3 == 5) goto L20;
        return AIWishGiftRoomScene.Unknown.getValue();
    L20:
        return AIWishGiftRoomScene.Media.getValue();
    L22:
        return AIWishGiftRoomScene.ScreenShot.getValue();
    L24:
        return AIWishGiftRoomScene.External.getValue();
    L26:
        return AIWishGiftRoomScene.Audio.getValue();
    L28:
        return AIWishGiftRoomScene.Video.getValue();
    L30:
        return AIWishGiftRoomScene.Unknown.getValue();
    }

    public final Number a() {
        int r1 = 0;
        Integer r0 = (Integer) this.c.get("data_link_state", 0);
        if (r0 == null) goto L6;
        r1 = r0.intValue();
    L6:
        return Integer.valueOf(vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc().j(r1));
    }

    public final void onStop() {
        this.a.dispose();
    }

    public a1(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
        this.a = new CompositeDisposable();
    }
}
