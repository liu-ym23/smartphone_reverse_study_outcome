package ra2;

import com.bytedance.android.live.base.model.message.g3;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements Comparator {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r4, Object r5) {
        g3 r6 = (g3) r4;
        g3 r7 = (g3) r5;
        Intrinsics.checkNotNullParameter(r6, "msg1");
        Intrinsics.checkNotNullParameter(r7, "msg2");
        return (r6.getSequenceId() > r7.getSequenceId() ? 1 : (r6.getSequenceId() == r7.getSequenceId() ? 0 : -1));
    }
}
