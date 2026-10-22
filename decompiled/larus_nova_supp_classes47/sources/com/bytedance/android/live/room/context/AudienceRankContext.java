package com.bytedance.android.live.room.context;

import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w71.a;
import w71.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/room/context/AudienceRankContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lw71/b;", "Lw71/a;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "", "getRoomPCU", "getDynamicRoomMemberCount", "", "getShareCountText", "pcu", "", "updateRoomPCU", "count", "updateRoomDynamicMemberCount", "shareStr", "setShareCountText", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "roomPCU", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "dynamicMemberCount", "shareCountText", "Ljava/lang/String;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AudienceRankContext extends DataContext implements b, a {
    private final DataCenter dataCenter;
    private final PropertyOwner<Long> dynamicMemberCount;
    private final PropertyOwner<Long> roomPCU;
    private String shareCountText;

    @Override // w71.b
    public d<Long> getDynamicRoomMemberCount() {
        PropertyOwner<Long> r0 = this.dynamicMemberCount;
        r0.getClass();
        return r0;
    }

    @Override // w71.b
    public d<Long> getRoomPCU() {
        PropertyOwner<Long> r0 = this.roomPCU;
        r0.getClass();
        return r0;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    @Override // w71.b
    public String getShareCountText() {
        return this.shareCountText;
    }

    public AudienceRankContext(DataCenter r7) {
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        this.dataCenter = r7;
        long r1 = 0;
        this.roomPCU = new PropertyOwner(0L);
        IRoom r3 = a0.n(r7);
        String r5 = null;
        if ((r3 instanceof Room) == true) goto L5;
        r3 = null;
    L5:
        Room r4 = (Room) r3;
        if (r4 == null) goto L10;
        RoomViewStats r6 = r4.viewStats;
        if (r6 == null) goto L10;
        r1 = r6.getDisplayValue();
    L10:
        this.dynamicMemberCount = new PropertyOwner(Long.valueOf(r1));
        IRoom r8 = a0.n(r7);
        if ((r8 instanceof Room) == true) goto L13;
        r8 = null;
    L13:
        Room r9 = (Room) r8;
        if (r9 == null) goto L18;
        RoomViewStats r10 = r9.viewStats;
        if (r10 == null) goto L18;
        r5 = r10.getDisplayLong();
    L18:
        this.shareCountText = r5;
    }

    @Override // w71.a
    public void setShareCountText(String r1) {
        this.shareCountText = r1;
    }

    @Override // w71.a
    public void updateRoomDynamicMemberCount(long r2) {
        this.dynamicMemberCount.a(Long.valueOf(r2));
    }

    @Override // w71.a
    public void updateRoomPCU(long r2) {
        this.roomPCU.a(Long.valueOf(r2));
    }
}
