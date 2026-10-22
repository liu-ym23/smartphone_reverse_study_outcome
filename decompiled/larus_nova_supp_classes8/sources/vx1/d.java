package vx1;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T, R> implements Function {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r3) {
        SubscriberJsEvent r4 = (SubscriberJsEvent) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        return Observable.just(new fw.b(r4.getEventName(), r4.getParams()));
    }
}
