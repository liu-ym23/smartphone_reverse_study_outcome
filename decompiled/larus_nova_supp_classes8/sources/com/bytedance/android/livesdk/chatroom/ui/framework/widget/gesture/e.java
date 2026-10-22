package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ GestureWidget a;
    public final /* synthetic */ RoomContext b;

    public e(GestureWidget r1, RoomContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Intrinsics.checkNotNullParameter((Unit) r2, "aLong");
        ALogger.d("timerTag", "AbsInteractionFragment.java # onSingleTapConfirmed # timer done, execute cast invisible");
        if (GestureWidget.wq(this.a) == null) goto L8;
        com.bytedance.live.datacontext.m r3 = this.b.isShowCastScreenUIByClickScreen();
        Boolean r0 = Boolean.FALSE;
        r3.setValue(r0);
        if (this.a.Qq() == false) goto L9;
        this.b.isShowTitleUIByClickScreen().setValue(r0);
        return;
    L9:
        return;
    }
}
