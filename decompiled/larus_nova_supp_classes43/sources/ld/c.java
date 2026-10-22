package ld;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.l;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static Observable a(NextLiveData r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$observeEx");
        l r0 = l.a;
        return Observable.create(new b(r10, false));
    }
}
