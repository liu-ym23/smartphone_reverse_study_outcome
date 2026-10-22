package mm0;

import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import lm0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final lm0.a a(DataCenter r1, int r2, Long r3, int r4) {
        if (r2 != TriggerId.ENTER_ROOM_TIME_LIMIT.getValue()) goto L6;
        return new lm0.c(r1, r3, r4);
    L6:
        if (r2 != TriggerId.EXIT_MIC_TIME_LIMIT.getValue()) goto L9;
        return new lm0.e(r1, r3, r4);
    L9:
        if (r2 != TriggerId.NO_LIMIT_TRIGGER.getValue()) goto L12;
        return new g(r1, r3, r4);
    L12:
        if (r2 == TriggerId.CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER.getValue()) goto L19;
        return null;
    L19:
        return new lm0.b(r1, r3, r4);
    }
}
