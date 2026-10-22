package com.bytedance.android.livesdk.chatroom.ui.framework.anchor;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.ui.InteractionContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionRoomControllerManager;
import com.bytedance.android.livesdk.room.placeholder.widget.b;
import com.bytedance.android.livesdk.room.placeholder.widget.d;
import com.bytedance.android.livesdk.room.placeholder.widget.e;
import com.bytedance.android.livesdk.room.util.ConvertorKt;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.DirectedFLashSaleEntrance;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.FloatingButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.HourRankEntrance;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/anchor/AnchorInteractionRoomControllerManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/InteractionRoomControllerManager;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInteractionRoomControllerManager extends InteractionRoomControllerManager {
    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionRoomControllerManager
    public final Map<ILayoutConstraint, d> w() {
        HashMap r0 = new HashMap();
        DataCenter r1 = getContext().b();
        InteractionContext r2 = this.b;
        if (r2 != null) goto L5;
        InteractionContext.Companion.getClass();
        r2 = InteractionContext.b.a(r1);
        this.b = r2;
    L5:
        if (r2 == null) goto L16;
        m<Map<ILayoutConstraint, d>> r3 = r2.getRoomPlaceHolders();
        if (r3 == null) goto L16;
        Map r4 = (Map) r3.getValue();
        if (r4 == null) goto L16;
        Iterator r5 = r4.entrySet().iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Map.Entry r6 = (Map.Entry) r5.next();
        FloatingButton r7 = (ILayoutConstraint) r6.getKey();
        d r8 = (d) r6.getValue();
        if (r7 != FloatingButton.INSTANCE) goto L12;
        r0.put(r7, r8);
    L16:
        r0.put(DirectedFLashSaleEntrance.INSTANCE, new b(getContext().b()));
        r0.put(HourRankEntrance.INSTANCE, new e(getContext().b()));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionRoomControllerManager
    public final RoomState x() {
        RoomState r0 = super.x();
        Boolean r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.Q0.getValue();
        r0.getExtra().putBoolean("boolean_commerce_replay_switch_checked", r1.booleanValue());
        return r0;
    }

    public AnchorInteractionRoomControllerManager() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionRoomControllerManager
    public final RoomState t(Bundle r10, Room r11, Map<String, String> r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r11, "room");
        Intrinsics.checkNotNullParameter(r12, "eventParams");
        Intrinsics.checkNotNullParameter(r13, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r14, "adLiveParams");
        return ConvertorKt.d(true, getContext().a, r10, r11, r12, r13, r14, r15);
    }
}
