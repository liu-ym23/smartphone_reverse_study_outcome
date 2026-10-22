package com.bytedance.android.live.profile;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rs0.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: com.bytedance.android.live.profile.j$a$a, reason: collision with other inner class name */
        public static final class C0011a {
        }

        static {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            r4.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L18;
            r4.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L19;
            r4.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L20;
            r4.getClass();
            if (Float.compare(0.0f, 0.0f) == 0) goto L22;
            return false;
        L22:
            return true;
        L20:
            return false;
        L19:
            return false;
        L18:
            return false;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(0.0f) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f);
        }

        public final String toString() {
            return "Area(x=0.0, y=0.0, width=0.0, height=0.0)";
        }
    }

    public static boolean b() {
        return Intrinsics.areEqual(x0.a.getValue(), Boolean.TRUE);
    }

    public static int a() {
        if (PadConfigUtils.c() == false) goto L7;
        return UtilityKotlinExtentionsKt.i(375);
    L7:
        return RangesKt.coerceAtMost(s1.y(), s1.w());
    }

    static {
    }
}
