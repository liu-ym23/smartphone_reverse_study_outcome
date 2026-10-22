package com.bytedance.android.livesdk.interactivity.roomintro.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public p(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((sh6.b) r2).a() == false) goto L6;
        RoomIntroDialogV2.U90(this.a, "livesdk_live_room_detail_poi_set_show");
        return;
    }
}
