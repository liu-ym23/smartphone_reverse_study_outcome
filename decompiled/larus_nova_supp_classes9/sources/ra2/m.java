package ra2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.s51;
import com.bytedance.android.livesdk.config.t2;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import ec2.u0;
import ec2.v1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface m {

    public static final class a {
        public static boolean a(m r6) {
            Integer r1 = null;
            if (((ys1.a) v1.a.getValue()).d() == false) goto L11;
            IInteractivityInjectService r0 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r0 == null) goto L7;
            Boolean r2 = Boolean.valueOf(r0.isShowWebAnim());
        L8:
            ALogger.i("IAnimComboView", "isShowWebAnim: " + r2);
            if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L11;
            return true;
        L7:
            r2 = null;
        L11:
            s51 r3 = (s51) u0.a.getValue();
            if (r3 == null) goto L43;
            t2 r4 = r3.b();
            if (r4 == null) goto L43;
            float r5 = z0.b(false);
            if (r5 <= 0.0f) goto L22;
            if (r5 > r4.b()) goto L22;
            return r6.a();
        L22:
            if (r4.a() == false) goto L43;
            if (r6.a() == false) goto L41;
            IPerformanceStrategyManager r7 = jc1.k.f(IPerformanceStrategyManager.class);
            if (r7 == null) goto L28;
            r1 = Integer.valueOf(r7.getCurrentPerformanceLevel());
        L28:
            if (r1 != null) goto L31;
        L32:
            if (r1 != null) goto L35;
        L37:
            boolean r8 = false;
        L39:
            if (r8 == false) goto L41;
            return true;
        L35:
            if (r1.intValue() != 2) goto L37;
        L38:
            r8 = true;
            goto L39
        L31:
            if (r1.intValue() == 1) goto L38;
        L41:
            return false;
        L43:
            return false;
        }
    }

    boolean a();
}
