package xz0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.scope.o;
import com.bytedance.livesdk.preview.viewmodel.VHPreviewContext;
import kotlin.jvm.internal.Intrinsics;
import yz0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements j, o {
    public final VHPreviewContext a;
    public final vh6.b b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yz0.j
    /* JADX INFO: renamed from: getRoom */
    public final IRoomBase mo444getRoom() {
        VHPreviewContext r0 = this.a;
        if (r0 == null) goto L8;
        Room r1 = r0.getMRoom();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return new Room();
    }

    public c(vh6.b r2) {
        Intrinsics.checkNotNullParameter(r2, "dependencyResolver");
        this.b = r2;
        this.a = (VHPreviewContext) r2.a(com.bytedance.livesdk.preview.viewmodel.b.a);
    }
}
