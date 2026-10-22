package lm0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.android.livesdk.config.ny0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends lm0.a {

    public static final class a {
    }

    /* JADX INFO: renamed from: lm0.b$b, reason: collision with other inner class name */
    public static final class C0233b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0233b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            ALogger.d("CycleDisplayTrigger", "recycleDisplayCard");
            if (((Boolean) ny0.a.getValue()).booleanValue() == true) goto L5;
            xs2.b.a().post(new u71.a(this.a.f));
        L5:
            this.a.e();
        }
    }

    static {
    }

    public final void e() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (((Boolean) ny0.a.getValue()).booleanValue() == false) goto L8;
        xs2.b.a().post(new u71.a(this.f));
    L8:
        Long r1 = this.e;
        if (r1 == null) goto L11;
        long r2 = r1.longValue();
    L12:
        this.a = Observable.timer(r2, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0233b(this));
        return;
    L11:
        r2 = 60000;
        goto L12
    }

    @Override // lm0.a
    public final void a() {
        super.a();
        e();
    }

    public final TriggerId b() {
        return TriggerId.CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER;
    }

    public b(DataCenter r1, Long r2, int r3) {
        super(r1, r2, r3);
    }
}
