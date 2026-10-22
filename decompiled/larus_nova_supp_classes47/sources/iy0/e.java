package iy0;

import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final IMainRoom a(IRoom r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$mainOrNull");
        return (IMainRoom) ((vh7.c) r1).castToOrNull(IMainRoom.class);
    }

    public static final boolean b(IRoom r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isGroupLive");
        IMainRoom r2 = (IMainRoom) r1.castToOrNull(IMainRoom.class);
        if (r2 == null) goto L9;
        com.bytedance.android.live.revenue.model.extension.main.c r3 = r2.getMainOthers();
        if (r3 == null) goto L9;
        IGroupLiveData r4 = r3.getGroupData();
        if (r4 == null) goto L9;
        return r4.isCurrentGroupLive();
    L9:
        return false;
    }
}
