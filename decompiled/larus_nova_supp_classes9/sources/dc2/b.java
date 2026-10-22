package dc2;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final <T extends RoomDataSyncModel> T a(ylc.e r1, Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$createRoomDataSyncModel");
        Intrinsics.checkNotNullParameter(r2, "factory");
        T r3 = (T) r2.invoke();
        r3.bindManager(r1);
        return r3;
    }
}
