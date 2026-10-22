package zvb;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public final GradientDrawable a;

    /* JADX INFO: renamed from: zvb.a$a, reason: collision with other inner class name */
    public static final class C0209a {
        public C0209a() {
        }

        public static GradientDrawable a(Context r2, Integer r3, Float r4, Integer r5, int r6) {
            int r0 = a.b;
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r5 = null;
        L11:
            Intrinsics.checkNotNullParameter(r2, "context");
            a r7 = new a();
            r7.a.setShape(1);
            if (r3 == null) goto L14;
            r3.intValue();
            r7.c(r2, r3.intValue(), r4);
        L14:
            if (r5 == null) goto L17;
            float r8 = r5.intValue();
            r7.b(Integer.valueOf(UIUtils.dp2px(r2, r8)), Integer.valueOf(UIUtils.dp2px(r2, r8)));
        L17:
            return r7.a;
        }

        public static GradientDrawable b(Context r1, Integer r2, Float r3, Integer r4, Integer r5, Integer r6) {
            Intrinsics.checkNotNullParameter(r1, "context");
            a r0 = new a();
            if (r2 == null) goto L5;
            r2.intValue();
            r0.c(r1, r2.intValue(), r3);
        L5:
            if (r4 == null) goto L7;
            int r7 = UIUtils.dp2px(r1, r4.intValue());
            r0.a(r7, r7, r7, r7);
        L7:
            if (r5 == null) goto L11;
            if (r6 == null) goto L11;
            a.d(r0, r1, UIUtils.dp2px(r1, r6.intValue()), r5.intValue());
        L11:
            return r0.a;
        }

        public static /* synthetic */ GradientDrawable c(Context r4, Integer r5, Integer r6, Integer r7, Integer r8, int r9) {
            if ((r9 & 2) == 0) goto L6;
            r5 = null;
        L6:
            if ((r9 & 8) == 0) goto L8;
            Integer r2 = null;
        L10:
            if ((r9 & 16) == 0) goto L12;
            Integer r3 = null;
        L14:
            if ((r9 & 32) == 0) goto L16;
            Integer r10 = null;
        L18:
            return b(r4, r5, null, r2, r3, r10);
        L16:
            r10 = r8;
            goto L18
        L12:
            r3 = r7;
            goto L14
        L8:
            r2 = r6;
            goto L10
        }

        public static GradientDrawable d(Context r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7, int r8) {
            int r0 = a.b;
            if ((r8 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r8 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r8 & 8) == 0) goto L12;
            r5 = null;
        L12:
            if ((r8 & 16) == 0) goto L15;
            r6 = null;
        L15:
            if ((r8 & 32) == 0) goto L17;
            r7 = null;
        L17:
            Intrinsics.checkNotNullParameter(r2, "context");
            a r9 = new a();
            if (r3 == null) goto L20;
            r3.intValue();
            r9.c(r2, r3.intValue(), null);
        L20:
            if (r4 != null) goto L24;
            if (r5 != null) goto L24;
            if (r6 != null) goto L24;
            if (r7 != null) goto L24;
        L41:
            return r9.a;
        L24:
            int r10 = 0;
            if (r4 == null) goto L27;
            int r11 = r4.intValue();
        L28:
            int r12 = UIUtils.dp2px(r2, r11);
            if (r5 == null) goto L31;
            int r13 = r5.intValue();
        L32:
            int r14 = UIUtils.dp2px(r2, r13);
            if (r6 == null) goto L35;
            int r15 = r6.intValue();
        L36:
            int r16 = UIUtils.dp2px(r2, r15);
            if (r7 == null) goto L39;
            r10 = r7.intValue();
        L39:
            r9.a(r12, r14, r16, UIUtils.dp2px(r2, r10));
            goto L41
        L35:
            r15 = 0;
            goto L36
        L31:
            r13 = 0;
            goto L32
        L27:
            r11 = 0;
            goto L28
        }
    }

    static {
        new C0209a();
    }

    public a() {
        this.a = new GradientDrawable();
    }

    public final void b(Integer r2, Integer r3) {
        if (r2 != null) goto L5;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r2 != null) goto L11;
        GradientDrawable r4 = this.a;
        if (r3 == null) goto L10;
        r4.setSize(-1, r3.intValue());
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        if (r3 != null) goto L13;
        this.a.setSize(r2.intValue(), -1);
        return;
    L13:
        this.a.setSize(r2.intValue(), r3.intValue());
    }

    public final void c(Context r2, int r3, Float r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r4 == null) goto L5;
        int r5 = UDColorUtils.getAlphaColor(r2, r3, r4.floatValue());
    L6:
        this.a.setColor(r5);
        return;
    L5:
        r5 = UDColorUtils.getColor(r2, r3);
        goto L6
    }

    public static void d(a r1, Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r5 = UDColorUtils.getColor(r2, r4);
        r1.a.setStroke(r3, r5, 0.0f, 0.0f);
    }

    public final void a(int r3, int r4, int r5, int r6) {
        float r7 = r3;
        float r8 = r4;
        float r9 = r5;
        float r10 = r6;
        this.a.setCornerRadii(new float[]{r7, r7, r8, r8, r9, r9, r10, r10});
    }
}
