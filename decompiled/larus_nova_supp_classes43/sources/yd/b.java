package yd;

import android.view.View;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.sti.IECExternalEntryEvent;
import com.bytedance.android.livesdk.livecommerce.room.widgets.coupon.CustomIconTemplate;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b<STATE> implements Disposable {
    public Function0<Unit> a;
    public Function1<? super STATE, Unit> b;
    public Function2<? super Integer, ? super Long, Integer> c;
    public Function0<Unit> d;
    public Function0<Unit> e;

    public b() {
    }

    public abstract void b(Object r1, Object r10);

    public abstract a d(STATE r1, STATE r10);

    public abstract STATE e();

    public abstract int j();

    public abstract CustomIconTemplate k(Object r1);

    public abstract void m();

    public void n(View r10, IECExternalEntryEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "entryView");
        Intrinsics.checkNotNullParameter(r11, "event");
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public final void l(STATE r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        Function1<? super STATE, Unit> r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("moveToState");
    L5:
        r0.invoke(r10);
    }
}
