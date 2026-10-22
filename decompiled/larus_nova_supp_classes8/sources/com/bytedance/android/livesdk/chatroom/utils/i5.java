package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i5<T> implements Consumer {
    public final /* synthetic */ List a;
    public final /* synthetic */ DataContext b;

    public i5(List r1, RoomContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        if (((Boolean) r3).booleanValue() == false) goto L5;
        VrUtils.b(true, this.a, this.b);
        return;
    L5:
        VrUtils.b(false, this.a, this.b);
    }
}
