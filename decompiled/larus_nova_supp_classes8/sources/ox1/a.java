package ox1;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.live.datacontext.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements InnerContextEntity.FloatWindowDataSource {
    public final Room a;

    public a() {
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        r4 = (Room) r1.getValue();
    L7:
        this.a = r4;
    }

    public final IRoom getRoomData() {
        return this.a;
    }

    public final void runAfterDataReady(LifecycleOwner r1, Function1<? super Room, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Room r3 = this.a;
        if (r3 == null) goto L6;
        r2.invoke(r3);
        return;
    }
}
