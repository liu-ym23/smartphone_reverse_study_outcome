package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    private final Map<String, Integer> calledMethods;

    public MethodCallsLogger() {
        this.calledMethods = new HashMap();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Integer r12 = this.calledMethods.get(r10);
        boolean r13 = false;
        if (r12 == null) goto L5;
        int r14 = r12.intValue();
    L7:
        if ((r14 & r11) == 0) goto L9;
        r13 = true;
    L9:
        this.calledMethods.put(r10, Integer.valueOf(r11 | r14));
        return !r13;
    L5:
        r14 = 0;
        goto L7
    }
}
