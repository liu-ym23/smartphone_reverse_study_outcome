package nr0;

import com.bytedance.android.live.profit.lottery.LotteryState;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r4) {
        LotteryState.b r5 = (LotteryState) r4;
        if ((r5 instanceof LotteryState.b) == false) goto L13;
        CompositeDisposable r0 = h.a;
        JSONObject r1 = new JSONObject();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Result.constructor-impl(r1.put("is_participated", r5.b.a));     // Catch: Throwable -> L7
    L9:
        Unit r3 = Unit.INSTANCE;
        h.d("finished", r1);
        LotteryState.b r6 = r5;
        h.a(r6.a.a, true, r6.b.a);
        return;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
