package com.bytedance.android.live.componentsmarket.impl.components.title;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ RoomContext a;

    public k(RoomContext r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        RoomContext r4 = this.a;
        if (r4 == null) goto L8;
        m r5 = r4.isShowTitleUIByClickScreen();
        if (r5 == null) goto L9;
        r5.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }
}
