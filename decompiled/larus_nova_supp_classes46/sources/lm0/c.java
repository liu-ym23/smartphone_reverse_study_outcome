package lm0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends lm0.a {
    public final TriggerId g;

    public static final class a {
    }

    static {
    }

    @Override // lm0.a
    public final void a() {
        super.a();
        DataCenter r0 = this.d;
        if (r0 == null) goto L5;
        Long r1 = (Long) r0.get("live_enter_room_complete_time");
    L6:
        if (r1 == null) goto L19;
        long r2 = System.currentTimeMillis() - r1.longValue();
        ALogger.d("EnterRoomTimeLimitTrigger", "start time count down wait" + r2);
        Long r3 = this.e;
        long r4 = 0;
        if (r3 == null) goto L10;
        long r5 = r3.longValue();
    L12:
        if (r2 >= r5) goto L17;
        Observable r6 = Observable.just(1);
        Long r7 = this.e;
        if (r7 == null) goto L16;
        r4 = r7.longValue() - r2;
    L16:
        Disposable r8 = r6.delay(r4, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this));
        Intrinsics.checkNotNullParameter(r8, "$this$autoBind");
        this.b.add(r8);
        return;
    L17:
        d(this.f);
        return;
    L10:
        r5 = 0;
        goto L12
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final TriggerId b() {
        return this.g;
    }

    public c(DataCenter r1, Long r2, int r3) {
        super(r1, r2, r3);
        this.g = TriggerId.ENTER_ROOM_TIME_LIMIT;
    }
}
