package n8b;

import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ConditionalAccessNetDependency a;

    public f(ConditionalAccessNetDependency r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Disposable r2 = (Disposable) r1;
        this.a.a.i();
    }
}
