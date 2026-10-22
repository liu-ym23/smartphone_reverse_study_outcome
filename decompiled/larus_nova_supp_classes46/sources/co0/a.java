package co0;

import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.cache.LruCache;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void accept(Object r2) {
        UserEvent r3 = (UserEvent) r2;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        LruCache r5 = c.a;     // Catch: Throwable -> L8
        if (r5 == null) goto L6;
        r5.clear();     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
