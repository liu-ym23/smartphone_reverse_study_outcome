package th8;

import android.util.Size;
import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final b a;
    public final Lazy b;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((((r0 * 31) + this.b) * 31) + this.c) * 31) + this.d;
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "SizeConfig(isDeepThinkVlm=" + this.a + ", padHorizontalWidth=" + this.b + ", singleImageLongerSize=" + this.c + ", multipleImageFixHeight=" + this.d + ')';
        }

        public b(boolean r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public f(b r2) {
        Intrinsics.checkNotNullParameter(r2, "sizeConfig");
        this.a = r2;
        this.b = LazyKt.lazy(new e());
    }

    public final Size a(int r4, FlowVLMContainerViewType r5, Integer r6, Integer r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "flowVLMContainerViewType");
        if (r6 == null) goto L5;
        int r10 = r6.intValue();
    L6:
        if (r7 == null) goto L8;
        int r11 = r7.intValue();
    L10:
        if (r5 != FlowVLMContainerViewType.NoContent) goto L14;
        return new Size(0, 0);
    L14:
        if (r5 != FlowVLMContainerViewType.SingleItem) goto L16;
        boolean r12 = true;
    L17:
        Integer r13 = Integer.valueOf(r10);
        Integer r14 = Integer.valueOf(r11);
        if (r13 == null) goto L20;
        int r15 = r13.intValue();
    L21:
        if (r14 == null) goto L23;
        int r16 = r14.intValue();
    L25:
        if (r9 == false) goto L33;
        if (r15 <= 0) goto L32;
        if (r16 <= 0) goto L32;
        if (r15 >= r16) goto L32;
        float r17 = 0.75f;
    L42:
        if (r12 == false) goto L60;
        b r18 = this.a;
        if (r18.c == 0) goto L46;
        int r19 = r4 - (c7.b(16) * 2);
        if (r17 <= 1.0f) goto L58;
        b r20 = this.a;
        if (r20.a == false) goto L55;
        int r21 = r20.c;
        Size r22 = new Size((int) (r21 / 0.7407407f), r21 + 0);
    L68:
        return r22;
    L55:
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L57;
        r19 = Math.min(this.a.b, r19);
    L57:
        r22 = new Size(r19, ((int) (r19 * 0.7407407f)) + 0);
        goto L68
    L58:
        int r23 = this.a.c;
        r22 = new Size((int) (r23 * 0.7407407f), r23 + 0);
        goto L68
    L46:
        if (r17 >= 1.0f) goto L48;
        float r24 = Math.min(r18.b, r4) * 0.6666667f;
        return new Size((int) (r17 * r24), (int) r24);
    L48:
        float r25 = Math.min(r18.b, r4) * 0.6666667f;
        return new Size((int) r25, (int) (r25 / r17));
    L60:
        b r26 = this.a;
        int r27 = r26.d;
        if (r27 > 0) goto L65;
        r27 = (int) (Math.min(r26.b, r4) * 0.44444445f);
    L65:
        return new Size((int) (r27 * r17), r27);
    L32:
        r17 = 1.3333334f;
        goto L42
    L33:
        if (r15 <= 0) goto L41;
        if (r16 <= 0) goto L41;
        if (r12 == true) goto L40;
        if (r8 == false) goto L40;
        r17 = Math.max(0.6666667f, Math.min(1.5f, r15 / r16));
    L40:
        r17 = Math.max(0.5625f, Math.min(1.7777778f, r15 / r16));
    L41:
        r17 = 1.0f;
        goto L42
    L23:
        r16 = 0;
        goto L25
    L20:
        r15 = 0;
        goto L21
    L16:
        r12 = false;
        goto L17
    L8:
        r11 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }
}
