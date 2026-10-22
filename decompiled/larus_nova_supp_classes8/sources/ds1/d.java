package ds1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        StringBuilder r0 = new StringBuilder("MatchRoomLandScapeAnimUtil.mStateSubject ERROR ");
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r0.append(r5);
        ALogger.i("LiveMultiTab", r0.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }
}
