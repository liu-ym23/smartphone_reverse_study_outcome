package zl0;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class c implements t71.a {
    public final CompositeDisposable a;
    public final DataCenter b;
    public final Long c;
    public final Integer d;
    public final v61.a e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ICardLifecycle.State r3 = (ICardLifecycle.State) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (d.a[r3.ordinal()] != 1) goto L11;
            this.a.a.clear();
            return;
        }
    }

    public Single<Boolean> a() {
        return null;
    }

    public abstract Object getIdentity();

    public final void onIntercept() {
        com.bytedance.android.live.room.api.messagewindow.monitor.i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L13;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r1 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_fail_show");
        r1.b("type", this.d);
        r1.b("reason", "1");
        StringBuilder r2 = new StringBuilder("interceptor: ");
        Object r3 = getIdentity();
        String r5 = null;
        if ((r3 instanceof ConditionId) == true) goto L8;
        r3 = null;
    L8:
        ConditionId r4 = (ConditionId) r3;
        if (r4 == null) goto L11;
        r5 = r4.getDesc();
    L11:
        r2.append(r5);
        r2.append(", value: ");
        r2.append(this.c);
        r1.b("extra", r2.toString());
        Unit r6 = Unit.INSTANCE;
        r0.b(r1.a());
        return;
    }

    public c(DataCenter r1, Long r2, Integer r3, v61.a r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new CompositeDisposable();
        if (r4 == null) goto L8;
        Observable r5 = r4.v();
        if (r5 == null) goto L9;
        r5.subscribe(new a(this));
        return;
    L9:
        return;
    }
}
