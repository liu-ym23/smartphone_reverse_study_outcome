package l61;

import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final d.a a(d.a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$convert");
        if (TopSpeedModeUtils.a() == true) goto L5;
        return r1;
    L5:
        if ((r1 instanceof d.a.u0) == false) goto L8;
        return d.a.v0.e;
    L8:
        if ((r1 instanceof d.a.a0) == true) goto L10;
        return r1;
    L10:
        return d.a.y0.e;
    }
}
