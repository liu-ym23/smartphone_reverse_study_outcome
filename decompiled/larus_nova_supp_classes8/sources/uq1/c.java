package uq1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final IRoom a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$room");
        DataCenter r3 = r2.e;
        if (r3 != null) goto L5;
        return null;
    L5:
        return (IRoom) r3.get("data_room", null);
    }
}
