package androidx.lifecycle;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006H\u0017R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/MethodCallsLogger;", "", "()V", "calledMethods", "", "", "", "approveCall", "", ActivityLifecycle.NAME, "type", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class MethodCallsLogger {
    private final Map<String, Integer> calledMethods;

    public MethodCallsLogger() {
        this.calledMethods = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public boolean approveCall(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.calledMethods.get(r5), Integer.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L7:
        if ((r2 & r6) == 0) goto L9;
        r1 = true;
    L9:
        this.calledMethods.put(r5, Integer.valueOf(r6 | r2));
        return !r1;
    L5:
        r2 = 0;
        goto L7
    }
}
