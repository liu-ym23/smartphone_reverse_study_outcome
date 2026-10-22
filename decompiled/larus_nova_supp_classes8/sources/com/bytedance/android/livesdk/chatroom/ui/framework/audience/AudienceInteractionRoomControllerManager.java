package com.bytedance.android.livesdk.chatroom.ui.framework.audience;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.ui.InteractionContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionRoomControllerManager;
import com.bytedance.android.livesdk.room.placeholder.widget.d;
import com.bytedance.android.livesdk.room.placeholder.widget.e;
import com.bytedance.android.livesdk.room.util.ConvertorKt;
import com.bytedance.android.livesdk.room.util.c;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.HourRankEntrance;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/audience/AudienceInteractionRoomControllerManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/InteractionRoomControllerManager;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceInteractionRoomControllerManager extends InteractionRoomControllerManager {
    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionRoomControllerManager
    public final Map<ILayoutConstraint, d> w() {
        HashMap r0 = new HashMap();
        r0.put(HourRankEntrance.INSTANCE, new e(getContext().b()));
        DataCenter r1 = getContext().b();
        InteractionContext r2 = this.b;
        if (r2 != null) goto L5;
        InteractionContext.Companion.getClass();
        r2 = InteractionContext.b.a(r1);
        this.b = r2;
    L5:
        if (r2 == null) goto L9;
        m<Map<ILayoutConstraint, d>> r3 = r2.getRoomPlaceHolders();
        if (r3 == null) goto L9;
        Map r4 = (Map) r3.getValue();
    L10:
        if (r4 != null) goto L12;
    L15:
        return r0;
    L12:
        if (r0.keySet().removeAll(r4.keySet()) == false) goto L14;
        c.a("place holder duplicated");
    L14:
        r0.putAll(r4);
    L9:
        r4 = null;
        goto L10
    }

    public AudienceInteractionRoomControllerManager() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.InteractionRoomControllerManager
    public final RoomState t(Bundle r10, Room r11, Map<String, String> r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r11, "room");
        Intrinsics.checkNotNullParameter(r12, "eventParams");
        Intrinsics.checkNotNullParameter(r13, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r14, "adLiveParams");
        return ConvertorKt.d(false, getContext().a, r10, r11, r12, r13, r14, r15);
    }
}
