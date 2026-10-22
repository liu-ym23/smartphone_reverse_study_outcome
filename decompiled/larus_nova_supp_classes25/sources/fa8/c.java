package fa8;

import com.larus.audio.call.RealtimeCallParam;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c extends com.larus.audio.call.play.c {
    public final AtomicBoolean x;
    public final d y;

    public static final class a {
    }

    static {
    }

    public final void init() {
        i(this.y);
        super.init();
    }

    public final void release(boolean r2) {
        j(this.y);
        super.release(r2);
    }

    public c(RealtimeCallParam r7, Integer r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "realtimeCallParam");
        super(r7, false, false, r8, r9);
        this.x = new AtomicBoolean(false);
        this.y = new d(this);
    }
}
