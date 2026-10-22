package im0;

import com.bytedance.android.live.room.api.messagewindow.schedule.ScheduleParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends a {
    @Override // java.lang.Runnable
    public final void run() {
        a(3);
    }

    public c(ScheduleParams<v61.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        super(r2.a);
    }
}
