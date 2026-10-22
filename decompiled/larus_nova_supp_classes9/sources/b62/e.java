package b62;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int d = 0;
    public final float a;
    public final int b;
    public final int c;

    public static final class a {
        public static e a(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            if (r2.f() == false) goto L6;
            return new e(s1.e(0.5f), ColorProtector.parseColor("#BF000000"));
        L6:
            return new e(s1.e(0.5f), ColorProtector.parseColor("#BF000000"));
        }
    }

    static {
    }

    public e(float r1, int r2) {
        this.a = r1;
        this.b = r2;
        this.c = 0;
    }
}
