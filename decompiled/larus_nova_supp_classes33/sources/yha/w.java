package yha;

import android.view.View;
import android.view.ViewGroup;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.assistant.util.m2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w {
    public static final /* synthetic */ int c = 0;
    public final e a;
    public final d b;

    public static final class a {
        public static int a(View r6, View r7, View r8, View r9) {
            int r0 = m0.a;
            int r1 = m0.a(AppHost.a.getApplication());
            int r2 = i5.k0();
            if (r7 == null) goto L5;
            int r3 = r7.getHeight();
        L6:
            if (r7 == null) goto L13;
            ViewGroup.LayoutParams r10 = r7.getLayoutParams();
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        L11:
            if (r11 == null) goto L13;
            int r12 = r11.bottomMargin;
        L14:
            int r4 = r3 + r12;
            if (r9 == null) goto L22;
            boolean r5 = true;
            if (r9.getVisibility() != 0) goto L19;
            boolean r13 = true;
        L20:
            if (r13 != true) goto L22;
        L23:
            if (r5 == true) goto L25;
        L27:
            int r14 = 0;
        L28:
            if (r8 == null) goto L30;
            int r15 = r8.getHeight();
        L31:
            int r16 = aia.d.a(r6, r8);
            int r17 = ((((((r1 - r2) - r4) - r15) - r16) - r14) + m2.f) - i5.z();
            if (r17 >= 0) goto L35;
            FLogger.a.w("ObricPageStateAnimationHelper", "getMaxTopEmptyHeight negative, maxTopEmptyHeight=" + r17 + ", fullScreenHeight=" + r1 + ", inputHeight=" + r4 + ", bottomLayoutHeight=" + r15 + ", bottomPadding=" + r16 + ", actionBarHeight=" + r14);
        L35:
            return RangesKt.coerceAtLeast(r17, 0);
        L30:
            r15 = 0;
            goto L31
        L25:
            if (r9.getHeight() != 0) goto L27;
            r14 = i5.X();
            goto L28
        L19:
            r13 = false;
        L22:
            r5 = false;
            goto L23
        L10:
            r11 = null;
        L13:
            r12 = 0;
            goto L14
        L5:
            r3 = 0;
            goto L6
        }
    }

    static {
    }

    public w(e r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.a = r2;
        this.b = new d(r2);
    }
}
