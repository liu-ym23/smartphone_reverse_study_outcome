package l02;

import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements o, e02.a {
    public final BehaviorSubject<d02.a> a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public c() {
        int r0 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.a = BehaviorSubject.create();
    }

    @Override // e02.a
    public final Observable<d02.a> observeEffectMessage() {
        return this.a;
    }
}
