package nr0;

import com.bytedance.android.live.profit.lottery.LotteryState;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void accept(Object r3) {
        JSONObject r4 = (JSONObject) r3;
        Object r0 = r4.opt("scene");
        if ((r0 instanceof LotteryState.b) == true) goto L5;
        r0 = null;
    L5:
        LotteryState.b r1 = (LotteryState.b) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.a.d != 52) goto L12;
        CompositeDisposable r2 = h.a;
        h.d = r4.optString("schema");
        return;
    }
}
