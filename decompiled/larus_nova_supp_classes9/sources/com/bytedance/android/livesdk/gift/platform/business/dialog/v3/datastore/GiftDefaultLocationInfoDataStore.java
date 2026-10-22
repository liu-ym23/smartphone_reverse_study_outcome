package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftDefaultLocationInfoDataStore implements com.bytedance.android.scope.o {
    public final LocateGiftInfo a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public GiftDefaultLocationInfoDataStore(LocateGiftInfo r4, GiftListRepository r5) {
        Intrinsics.checkNotNullParameter(r4, "locationGiftInfo");
        Intrinsics.checkNotNullParameter(r5, "giftListRepository");
        new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h(r4, null, GiftDefaultLocationInfoDataStore$defaultSelectHelper$1.INSTANCE);
        this.a = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h.c(r4, r5.c);
    }
}
