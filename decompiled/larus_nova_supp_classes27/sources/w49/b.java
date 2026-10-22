package w49;

import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[HeadControlGestureType.values().length];
            r0[HeadControlGestureType.NOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[HeadControlGestureType.SHAKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[HeadControlActionOption.values().length];
            r1[HeadControlActionOption.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[HeadControlActionOption.ACCEPT_CONFIRM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[HeadControlActionOption.REJECT_CLOSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    public static String a(byte[] r9) {
        if (r9 == null) goto L4;
        String r10 = ArraysKt.joinToString$default(r9, null, "[", "]", 0, null, new w49.a(), 25, null);
    L5:
        if (r10 != null) goto L8;
        return "";
    L8:
        return r10;
    L4:
        r10 = null;
        goto L5
    }

    public static c b(byte[] r11) {
        Intrinsics.checkNotNullParameter(r11, "config");
        if ((r11.length % 2) == 0) goto L6;
        g49.d.e("HeadControlOptionProtocol", "Invalid head gesture config size, size=" + r11.length);
        return null;
    L6:
        int r4 = 0;
        int r0 = ProgressionUtilKt.getProgressionLastElement(0, r11.length - 1, 2);
        HeadControlActionOption r5 = null;
        HeadControlActionOption r6 = null;
        if (r0 < 0) goto L36;
    L8:
        int r7 = r11[r4] & 255;
        if (r7 != 3) goto L11;
        HeadControlGestureType r8 = HeadControlGestureType.NOD;
    L15:
        int r9 = r4 + 1;
        int r10 = r11[r9] & 255;
        if (r10 == 0) goto L22;
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L20;
        HeadControlActionOption r12 = null;
    L23:
        if (r8 == null) goto L33;
        if (r12 == null) goto L33;
        int r13 = a.a[r8.ordinal()];
        if (r13 == 1) goto L32;
        if (r13 != 2) goto L31;
        r6 = r12;
    L34:
        if (r4 == r0) goto L36;
        r4 = r4 + 2;
        goto L8
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        r5 = r12;
    L33:
        g49.d.e("HeadControlOptionProtocol", "Skip unknown head gesture pair, gesture=" + (r11[r4] & 255) + ", action=" + (r11[r9] & 255));
        goto L34
    L20:
        r12 = HeadControlActionOption.REJECT_CLOSE;
        goto L23
    L21:
        r12 = HeadControlActionOption.ACCEPT_CONFIRM;
        goto L23
    L22:
        r12 = HeadControlActionOption.NONE;
        goto L23
    L11:
        if (r7 == 4) goto L13;
        r8 = null;
        goto L15
    L13:
        r8 = HeadControlGestureType.SHAKE;
    L36:
        if (r5 != null) goto L40;
        if (r6 != null) goto L40;
        return null;
    L40:
        if (r5 != null) goto L42;
        r5 = HeadControlActionOption.NONE;
    L42:
        if (r6 != null) goto L45;
        r6 = HeadControlActionOption.NONE;
    L45:
        return new c(r5, r6);
    }
}
