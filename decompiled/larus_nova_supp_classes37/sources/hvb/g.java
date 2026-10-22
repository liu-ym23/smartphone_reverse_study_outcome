package hvb;

import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.disposables.Disposable;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public g() {
    }

    public static final void a(s r1, IGetDataCallback r2, Disposable r3) {
        if ((r1 instanceof x) == false) goto L8;
        r2.onSuccess(((x) r1).c);
        if (r3 == null) goto L15;
        r3.dispose();
        return;
    L15:
        return;
    L8:
        if ((r1 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L14;
        r2.onError(p.a(((com.bytedance.lark.rustclient.api.c) r1).c));
        if (r3 == null) goto L17;
        r3.dispose();
        return;
    L17:
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
