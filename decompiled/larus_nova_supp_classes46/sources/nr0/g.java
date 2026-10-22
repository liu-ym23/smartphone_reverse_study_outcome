package nr0;

import android.os.Bundle;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements IEventListener {
    public g() {
    }

    public final Bundle onEvent(Bundle r3) {
        if (r3 == null) goto L6;
        long r0 = r3.getLong("lottery_id");
        CompositeDisposable r4 = h.a;
        h.c = Long.valueOf(r0);
        h.a(r0, false, false);
        return null;
    L6:
        return null;
    }
}
