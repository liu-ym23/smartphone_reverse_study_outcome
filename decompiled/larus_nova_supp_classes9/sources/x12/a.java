package x12;

import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveDataKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final IGroupLiveData a(IRoomBase r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$groupLiveData");
        if ((r2 instanceof IRoom) == true) goto L5;
        r2 = null;
    L5:
        vh7.c r3 = (IRoom) r2;
        if (r3 == null) goto L13;
        IMainRoom r4 = r3.castToOrNull(IMainRoom.class);
        if (r4 == null) goto L14;
        com.bytedance.android.live.revenue.model.extension.main.c r5 = r4.getMainOthers();
        if (r5 != null) goto L12;
        return null;
    L12:
        return r5.getGroupLiveData();
    L14:
        return null;
    L13:
        return null;
    }

    public static final boolean b(IRoomBase r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isGroupLive");
        IGroupLiveData r2 = a(r1);
        if (r2 != null) goto L7;
        return false;
    L7:
        return IGroupLiveDataKt.isGroupLiveKmp(r2);
    }
}
