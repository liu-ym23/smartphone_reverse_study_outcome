package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AudienceLandscapeGestureWidget a;

    public a(AudienceLandscapeGestureWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        AudienceLandscapeGestureWidget r0 = this.a;
        List<String> r1 = AudienceLandscapeGestureWidget.A;
        r0.kr((gh1.a) r3);
    }
}
