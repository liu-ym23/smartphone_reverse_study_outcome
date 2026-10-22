package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.android.livesdk.gift.fastgift.task.FastTaskGiftConfirmDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements FastTaskGiftConfirmDialog.a {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    @Override // com.bytedance.android.livesdk.gift.fastgift.task.FastTaskGiftConfirmDialog.a
    public final void a() {
        this.a.A.hideConfirm();
        this.a.A.sendGift(Boolean.TRUE);
        a.b(this.b, this.c, "gift_coin_task", "confirm");
    }

    @Override // com.bytedance.android.livesdk.gift.fastgift.task.FastTaskGiftConfirmDialog.a
    public final void cancel() {
        a.b(this.b, this.c, "gift_coin_task", "cancel");
    }

    public t(FastGiftViewV3 r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
