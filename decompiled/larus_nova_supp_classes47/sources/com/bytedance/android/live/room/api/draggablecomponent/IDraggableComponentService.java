package com.bytedance.android.live.room.api.draggablecomponent;

import c61.d;
import c61.f;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import h70.b;
import j70.h;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.draggablecomponent.DraggableComponentService")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH&J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/room/api/draggablecomponent/IDraggableComponentService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initContext", "Lc61/d;", "Lc61/f;", "getWindowContainer", "Lj70/h;", "Lh70/b;", "getDraggableComponentTetrisDesc", "getDraggableComponentSvDesc", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDraggableComponentService extends IService {
    h<? extends b> getDraggableComponentSvDesc();

    h<? extends b> getDraggableComponentTetrisDesc();

    d<f> getWindowContainer();

    DataContext initContext(DataCenter r1, RoomContext r2);
}
