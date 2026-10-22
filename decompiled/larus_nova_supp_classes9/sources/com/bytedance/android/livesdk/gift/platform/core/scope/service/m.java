package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ n a;

    public m(n r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Long r9 = (Long) r8;
        Bundle r3 = new Bundle();
        r3.putString("gift_show_from", "auto_callup");
        i12.e r10 = i12.o.b();
        if (r10 == null) goto L5;
        Object r11 = com.bytedance.android.scope.m.e.d(r10, OpenDialogService.class);
    L7:
        if (((OpenDialogService) r11) == null) goto L9;
        xs2.b r13 = xs2.b.a();
        LocateGiftInfo.Companion.getClass();
        r13.post(new zg1.o3(null, LocateGiftInfo.a.b(0), r3, BuildConfig.FLAVOR, null));
    L9:
        this.a.a();
        return;
    L5:
        r11 = null;
        goto L7
    }
}
