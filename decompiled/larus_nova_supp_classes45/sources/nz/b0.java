package nz;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function1 b;

    public b0(Function1 r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Response r3 = (Response) r2;
        if (r3 != null) goto L5;
    L9:
        this.b.invoke(new Throwable());
        return;
    L5:
        if (((BaseResponse) r3).statusCode != 0) goto L9;
        com.bytedance.android.live.broadcast.api.model.o r4 = (com.bytedance.android.live.broadcast.api.model.o) ((BaseResponse) r3).data;
        if (r4 == null) goto L11;
        Unit r5 = (Unit) this.a.invoke(r4);
        return;
    }
}
