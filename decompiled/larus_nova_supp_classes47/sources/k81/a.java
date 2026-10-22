package k81;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public a(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Response r3 = (Response) r2;
        Function1 r0 = this.a;
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(((BaseResponse) r3).data);
        return;
    }
}
