package hz0;

import com.bytedance.revenue.platform.api.core.rx.c;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements gz0.a, ha0.b {
    public final BehaviorSubject<String> a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // gz0.a
    public final String K2() {
        String r0 = (String) this.a.getValue();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public b() {
        int r0 = c.a;
        this.a = BehaviorSubject.create();
    }

    @Override // gz0.a
    public final BehaviorSubject P4() {
        return this.a;
    }

    public final void d1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.a.onNext(r2);
    }
}
