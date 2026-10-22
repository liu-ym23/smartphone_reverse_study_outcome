package r00;

import com.bytedance.android.live.broadcast.corepath.TaskLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public a() {
        this(TaskLevel.Normal);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public a(TaskLevel r2) {
        Intrinsics.checkNotNullParameter(r2, "level");
    }
}
