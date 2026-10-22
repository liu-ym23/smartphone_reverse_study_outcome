package ox1;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements InnerContextEntity.FloatWindowDataSource {
    public final Room a;

    public final IRoom getRoomData() {
        return this.a;
    }

    public e(Room r1) {
        this.a = r1;
    }

    public final void runAfterDataReady(LifecycleOwner r1, Function1<? super Room, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Room r3 = this.a;
        if (r3 == null) goto L6;
        r2.invoke(r3);
        return;
    }
}
