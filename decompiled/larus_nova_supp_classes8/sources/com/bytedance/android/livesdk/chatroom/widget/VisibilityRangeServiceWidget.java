package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.message.model.gn;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/VisibilityRangeServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VisibilityRangeServiceWidget extends RoomRecyclableWidget implements vlc.l, Observer<KVData> {
    public vlc.d a;
    public final List<Integer> b;

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        vlc.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public VisibilityRangeServiceWidget() {
        this.b = CollectionsKt.listOf(Integer.valueOf(MessageType.VISIBILITY_RANGE_CHANGE_MESSAGE.getIntType()));
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-1434292000)) goto L12;
        return;
    L12:
        if (r0.equals("data_message_manager") == false) goto L22;
        vlc.d r6 = (vlc.d) r5.getData();
        if (r6 == null) goto L30;
        this.a = r6;
        Iterator<T> r7 = this.b.iterator();
    L18:
        if (r7.hasNext() == false) goto L31;
        int r1 = ((Number) r7.next()).intValue();
        vlc.d r2 = this.a;
        if (r2 == null) goto L18;
        r2.addMessageListener(r1, this);
        goto L18
    L31:
        return;
    L30:
        return;
    L22:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onLoad(Object[] r3) {
        DataCenter r4 = ((Widget) this).dataCenter;
        vlc.d r1 = null;
        if (r4 == null) goto L5;
        r1 = (vlc.d) r4.get("data_message_manager", null);
    L5:
        this.a = r1;
        if (r1 == null) goto L13;
        Iterator<T> r5 = this.b.iterator();
    L9:
        if (r5.hasNext() == false) goto L23;
        int r0 = ((Number) r5.next()).intValue();
        vlc.d r2 = this.a;
        if (r2 == null) goto L9;
        r2.addMessageListener(r0, this);
        goto L9
    L23:
        return;
    L13:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L22;
        r6.observe("data_message_manager", this);
        return;
    }

    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof gn) == false) goto L14;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L15;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 == null) goto L16;
        Long r5 = ((gn) r4).visibilityRange;
        if (r5 == null) goto L11;
        Integer r6 = Integer.valueOf((int) r5.longValue());
    L12:
        Intrinsics.checkNotNull(r6);
        r1.setVisibilityRange(r6.intValue());
        return;
    L11:
        r6 = null;
        goto L12
    L16:
        return;
    L15:
        return;
    }
}
