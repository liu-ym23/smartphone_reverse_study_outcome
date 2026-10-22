package lm0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Integer r3 = (Integer) r2;
        ALogger.d("EnterRoomTimeLimitTrigger", "insert");
        c r4 = this.a;
        r4.d(r4.f);
    }
}
