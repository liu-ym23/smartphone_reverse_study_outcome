package m31;

import com.bytedance.android.live.revlink.impl.multianchor.player.utils.LiveType;
import com.bytedance.android.livesdk.revenue.room.RevLiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final LiveType a(ILiveMode r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toLiveType");
        if (r1 == LiveMode.THIRD_PARTY) goto L35;
        if (r1 == RevLiveMode.THIRD_PARTY) goto L35;
        if (r1 == LiveMode.VIDEO) goto L33;
        if (r1 == RevLiveMode.VIDEO) goto L33;
        if (r1 == LiveMode.MEDIA) goto L31;
        if (r1 == RevLiveMode.MEDIA) goto L31;
        if (r1 == LiveMode.AUDIO) goto L29;
        if (r1 == RevLiveMode.AUDIO) goto L29;
        if (r1 != LiveMode.SCREEN_RECORD) goto L27;
        return LiveType.SCREEN_RECORD;
    L27:
        return LiveType.OTHERS;
    L29:
        return LiveType.AUDIO;
    L31:
        return LiveType.VIDEO;
    L33:
        return LiveType.VIDEO;
    L35:
        return LiveType.PC_LIVE;
    }
}
