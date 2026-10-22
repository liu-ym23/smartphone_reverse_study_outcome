package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ GestureWidget a;
    public final /* synthetic */ RoomContext b;

    public f(GestureWidget r1, RoomContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Intrinsics.checkNotNullParameter((Unit) r3, "aLong");
        ALogger.d("timerTag", "AbsInteractionFragment.java # onSingleTapConfirmed # timer done, execute cast invisible");
        com.bytedance.live.datacontext.m r4 = this.b.isShowCastScreenUIByClickScreen();
        Boolean r0 = Boolean.FALSE;
        r4.setValue(r0);
        GestureWidget r5 = this.a;
        int r1 = GestureWidget.y;
        if (r5.Qq() == false) goto L6;
        this.b.isShowTitleUIByClickScreen().setValue(r0);
        return;
    }
}
