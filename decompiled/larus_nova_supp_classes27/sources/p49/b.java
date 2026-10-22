package p49;

import com.larus.dora.api.annotation.EnvObserveChangeReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EnvObserveChangeReason.values().length];
            r0[EnvObserveChangeReason.DEVICE_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[EnvObserveChangeReason.CONNECT_CHANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[EnvObserveChangeReason.SWITCH_CHANGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[EnvObserveChangeReason.TIMER_CHANGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[EnvObserveChangeReason.WIFI_CHANGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final String a(EnvObserveChangeReason r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "device state change";
    L5:
        if (r2 != 2) goto L7;
        return "link connect change";
    L7:
        if (r2 != 3) goto L9;
        return "env switch change";
    L9:
        if (r2 != 4) goto L11;
        return "env timer change";
    L11:
        if (r2 == 5) goto L13;
        return "unknown";
    L13:
        return "env wifi change";
    }
}
