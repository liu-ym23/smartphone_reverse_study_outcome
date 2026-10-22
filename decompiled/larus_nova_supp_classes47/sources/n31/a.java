package n31;

import com.bytedance.android.live.revenuelink.connect.f;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.livesdk.common.k;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends k<Object> {
    public final f b;
    public final c c;
    public final IRoom d;

    public a(c r2, IRoom r3) {
        Intrinsics.checkNotNullParameter(r3, "mRoom");
        this.c = r2;
        this.d = r3;
        if (r2 == null) goto L5;
        r2.getLinkCrossRoomDataHolder();
    L5:
        if (r2 == null) goto L7;
        f r4 = r2.Z0();
    L8:
        this.b = r4;
        return;
    L7:
        r4 = null;
        goto L8
    }
}
