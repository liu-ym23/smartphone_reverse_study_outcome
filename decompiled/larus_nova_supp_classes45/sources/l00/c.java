package l00;

import android.graphics.Rect;
import com.bytedance.android.live.broadcast.api.utils.api.ICurrentRatioService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final int a = 0;

    static {
        a = UtilityKotlinExtentionsKt.i(132);
    }

    public static Rect a() {
        ICurrentRatioService r0 = (ICurrentRatioService) va1.b.a.a.a(ICurrentRatioService.class);
        if (r0 == null) goto L16;
        Pair<Integer, Integer> r1 = r0.f();
        if (r1 != null) goto L7;
        return null;
    L7:
        if (((Number) r1.getFirst()).intValue() > 0) goto L9;
    L13:
        ALogger.i("LandscapeBroadcastUtils", "getPreviewBroadcastRenderRect cu");
        return null;
    L9:
        if (((Number) r1.getSecond()).intValue() <= 0) goto L13;
        int r2 = s1.y();
        int r3 = (((Number) r1.getSecond()).intValue() * r2) / ((Number) r1.getFirst()).intValue();
        int r4 = a;
        Rect r5 = new Rect(0, r4, r2, r3 + r4);
        ALogger.i("LandscapeBroadcastUtils", "getPreviewBroadcastRenderRect rect is previewRect");
        return r5;
    L16:
        return null;
    }
}
