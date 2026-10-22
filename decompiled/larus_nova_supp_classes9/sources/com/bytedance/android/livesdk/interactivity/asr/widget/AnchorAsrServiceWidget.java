package com.bytedance.android.livesdk.interactivity.asr.widget;

import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.asr.utils.c;
import com.bytedance.android.livesdk.interactivity.api.asr.utils.d;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/asr/widget/AnchorAsrServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorAsrServiceWidget extends RoomRecyclableWidget {
    public final CompositeDisposable a;
    public l22.a b;

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        c.c("AnchorAsrServiceWidget onLoad");
        this.a.clear();
        l22.a r0 = this.b;
        if (r0 == null) goto L5;
        r0.getAnchorAsrManager().release();
        r0.getUserActionCollector().release();
        this.b = null;
    L5:
        com.bytedance.android.livesdk.interactivity.asr.c.c = null;
    }

    public AnchorAsrServiceWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onLoad(Object[] r2) {
        c.c("AnchorAsrServiceWidget onLoad");
        int r3 = d.a;
        Function0<Unit> r4 = new AnonymousClass1(this);
        if (com.bytedance.android.livesdk.interactivity.asr.c.b == false) goto L5;
        r4.invoke();
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.asr.c.c = r4;
    }
}
