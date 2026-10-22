package i88;

import com.larus.av_call.util.ScreenWidthType;
import com.larus.utils.logger.FLogger;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final ScreenWidthType a(int r3) {
        FLogger.a.d("VoiceCallBottomLayout", "windowWidth: " + r3);
        float r4 = c7.d(Integer.valueOf(r3));
        if (r4 > 411.0f) goto L6;
        return ScreenWidthType.Small;
    L6:
        if (r4 > 600.0f) goto L9;
        return ScreenWidthType.Medium;
    L9:
        return ScreenWidthType.Large;
    }
}
