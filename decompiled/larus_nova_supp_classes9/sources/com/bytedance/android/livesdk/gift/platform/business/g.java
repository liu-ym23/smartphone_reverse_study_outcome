package com.bytedance.android.livesdk.gift.platform.business;

import android.content.Context;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface g {
    com.bytedance.android.livesdk.gift.platform.business.tray.k a(DataCenter r1);

    List<f> c();

    List<com.bytedance.android.livesdk.gift.platform.core.j> d();

    LiveDialogFragment f(DataCenter r1, Context r2, GiftViewModelManager r3, LocateGiftInfo r4);

    void g();

    Context getContext();

    Map<GiftPluginType, h> h();
}
