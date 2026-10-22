package ip0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.repository.MiniAppListRepository;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ MiniAppListRepository a;

    public f(MiniAppListRepository r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        int r0 = qo0.a.a;
        StringBuilder r1 = new StringBuilder("fetch list fail, error: ");
        if (r4 == null) goto L5;
        Object r2 = r4;
    L6:
        r1.append(r2);
        qo0.a.c("choose_list", r1.toString());
        np0.b<Result<b>> r5 = this.a.b;
        Result.Companion r6 = Result.Companion;
        r5.a(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r4))));
        return;
    L5:
        r2 = "null";
        goto L6
    }
}
