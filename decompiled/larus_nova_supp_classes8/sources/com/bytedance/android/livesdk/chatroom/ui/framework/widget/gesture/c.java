package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ AudiencePortraitGestureWidget a;

    public c(AudiencePortraitGestureWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        AudiencePortraitGestureWidget r0 = this.a;
        int r1 = AudiencePortraitGestureWidget.F;
        r0.nr((gh1.a) r3);
    }
}
