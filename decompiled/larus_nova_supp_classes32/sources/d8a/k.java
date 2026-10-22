package d8a;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class k<T, C> {
    public k() {
    }

    public void cancel(LynxResourceRequest<T> r1) {
    }

    public void request(LynxResourceRequest<T> r1, LynxResourceCallback<C> r2) {
    }

    public void request(LynxResourceRequest<T> r1, LynxResourceCallback<C> r2, LynxContext r3) {
        request(r1, r2);
    }
}
