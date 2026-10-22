package com.bytedance.android.live.draggablecomponent;

import com.bytedance.android.live.room.api.draggablecomponent.IDraggableComponentService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/draggablecomponent/DraggableComponentService;", "Lcom/bytedance/android/live/room/api/draggablecomponent/IDraggableComponentService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initContext", "Lc61/d;", "Lc61/f;", "getWindowContainer", "Lj70/h;", "Lh70/b;", "getDraggableComponentTetrisDesc", "getDraggableComponentSvDesc", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableComponentService implements IDraggableComponentService {
    public DraggableComponentService() {
    }

    public j70.h<? extends h70.b> getDraggableComponentSvDesc() {
        return new c();
    }

    public j70.h<? extends h70.b> getDraggableComponentTetrisDesc() {
        return new e();
    }

    public c61.d<c61.f> getWindowContainer() {
        DraggableWindowContext.Companion.getClass();
        c61.g r0 = DraggableWindowContext.b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.windowContainer();
    }

    public DataContext initContext(DataCenter r2, RoomContext r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        DraggableWindowContext r0 = new DraggableWindowContext(r3, r2);
        r0.initialize();
        return r0;
    }
}
