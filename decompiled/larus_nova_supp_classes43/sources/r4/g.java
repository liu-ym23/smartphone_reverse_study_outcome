package r4;

import com.bytedance.ai.api.navi.AppletNaviRideType;
import com.bytedance.ai.bridge.service.NavigateMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NavigateMode.values().length];
            r0[NavigateMode.DRIVING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[NavigateMode.TRANSIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[NavigateMode.WALKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[NavigateMode.RIDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final int a(NavigateMode r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = a.a[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0;
    L5:
        if (r11 != 2) goto L7;
        return 1;
    L7:
        if (r11 != 3) goto L9;
        return 2;
    L9:
        if (r11 != 4) goto L12;
        return 3;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static final String b(NavigateMode r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r10 = a.a[r1.ordinal()];
        if (r10 != 1) goto L5;
        return "drive";
    L5:
        if (r10 != 2) goto L7;
        return "bus";
    L7:
        if (r10 != 3) goto L9;
        return "walk";
    L9:
        if (r10 != 4) goto L12;
        return AppletNaviRideType.BIKE;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
