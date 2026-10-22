package i02;

import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidgetOrigin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<E> {
    public final Object[] a;
    public final int b;
    public int c;
    public final a d;

    public interface a<E> {
        boolean compare(E r1, E r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        int r0 = 1;
        int r1 = 2;
    L3:
        int r2 = this.c;
        if (r1 > r2) goto L13;
        int r3 = r1 + 1;
        if (r3 > r2) goto L10;
        a r4 = this.d;
        Object[] r5 = this.a;
        if (r4.compare(r5[r3], r5[r1]) == false) goto L10;
        r1 = r3;
    L10:
        a r6 = this.d;
        Object[] r7 = this.a;
        if (r6.compare(r7[r1], r7[r0]) == false) goto L16;
        Object[] r8 = this.a;
        Object r9 = r8[r0];
        r8[r0] = r8[r1];
        r8[r1] = r9;
        int r10 = r1;
        r1 = r1 * 2;
        r0 = r10;
        goto L3
    L16:
        return;
    }

    public c(int r2, BaseVideoGiftWidgetOrigin.d r3) {
        this.b = r2;
        this.c = 0;
        this.a = new Object[r2 + 1];
        this.d = r3;
    }
}
