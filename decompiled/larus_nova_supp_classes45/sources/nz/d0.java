package nz;

import com.bytedance.android.live.broadcast.api.model.g1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public d0(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Function1 r0 = this.a;
        r0.invoke((g1) r2);
    }
}
