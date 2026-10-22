package s00;

import com.bytedance.android.live.core.log.ALogger;
import fg1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class e extends b {
    public boolean b;
    public final r00.a c;

    @Override // s00.c
    public final r00.a getName() {
        return this.c;
    }

    public e(k r2) {
        Intrinsics.checkNotNullParameter(r2, "taskName");
        this.c = r2;
    }

    @Override // s00.b
    public final f a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        if (this.b == false) goto L7;
        return f.c.a;
    L7:
        return f.b.a;
    }

    public final void b(r00.d r3) {
        Intrinsics.checkNotNullParameter(r3, "taskContext");
        ALogger.i("KeyNodeCheckTask", "KeyNodeCheckTask " + this.c + " onTrigger.");
        this.b = true;
        r3.b(this);
    }
}
