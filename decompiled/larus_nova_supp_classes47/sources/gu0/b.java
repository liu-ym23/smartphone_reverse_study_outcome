package gu0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.fansclub.i;
import com.bytedance.android.live.profit.fansclub.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements n, o {
    public final com.bytedance.android.livesdk.revenue.service.room.b a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.profit.fansclub.n
    public final boolean enableEcomFansClubReverse() {
        IRoom r0 = this.a.getRoom();
        if (r0 == null) goto L11;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L11;
        if (r1.isEnableShowFansClubReverse() != true) goto L11;
        if (((Boolean) i.i.getValue(null, i.a[7])).booleanValue() == false) goto L11;
        return true;
    L11:
        return false;
    }

    public b(com.bytedance.android.livesdk.revenue.service.room.b r2) {
        Intrinsics.checkNotNullParameter(r2, "roomService");
        this.a = r2;
    }
}
