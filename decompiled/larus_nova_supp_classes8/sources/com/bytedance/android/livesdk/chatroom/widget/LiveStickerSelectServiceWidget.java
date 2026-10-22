package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LiveStickerSelectServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerSelectServiceWidget extends RoomRecyclableWidget {
    public final CompositeDisposable a;

    public static final class a {
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.a.clear();
    }

    public LiveStickerSelectServiceWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onLoad(Object[] r2) {
        RxUtilKt.c(xs2.b.a().b(zg1.d2.class).subscribe(new a1(this)), this.a);
    }
}
