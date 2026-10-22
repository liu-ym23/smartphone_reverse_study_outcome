package com.bytedance.android.livesdk.interactivity.common.cleanarch.ext;

import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/cleanarch/ext/CompatLiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CompatLiveRecyclableWidget extends RoomRecyclableWidget {
    public final List<Disposable> a;

    public void onUnload() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Disposable) r0.next()).dispose();
        goto L4
    L6:
        ((ArrayList) this.a).clear();
    }

    public CompatLiveRecyclableWidget() {
        this.a = new ArrayList();
    }
}
