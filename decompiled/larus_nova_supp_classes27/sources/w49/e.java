package w49;

import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public static final StateFlowImpl a = null;
    public static final b1 b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HeadControlGestureType.values().length];
            r0[HeadControlGestureType.NOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[HeadControlGestureType.SHAKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        StateFlowImpl r0 = j1.a(new c(0));
        a = r0;
        b = kotlinx.coroutines.flow.e.b(r0);
    }
}
