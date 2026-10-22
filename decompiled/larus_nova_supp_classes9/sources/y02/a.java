package y02;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.l;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements Comparator<NormalGiftMessage> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(NormalGiftMessage r8, NormalGiftMessage r9) {
        NormalGiftMessage r10 = r8;
        NormalGiftMessage r11 = r9;
        if (r10 == null) goto L38;
        if (r11 == null) goto L38;
        if (r10.n() == null) goto L12;
        if (r11.n() == null) goto L12;
        return r10.g(r11);
    L12:
        if (r10.o() != null) goto L14;
    L16:
        long r0 = r10.l();
        long r2 = r11.l();
        if (r10.v == true) goto L19;
        long r1 = r0 - r2;
    L21:
        if (r1 != 0) goto L27;
        if ((r11 instanceof l) == true) goto L37;
        r1 = r11.m().compareTo(r10.m());
    L37:
        return -1;
    L27:
        if (r1 >= 0) goto L29;
    L28:
        return 1;
    L29:
        if (r1 != 0) goto L37;
        long r3 = r10.G;
        long r4 = r11.G;
        if (r3 > r4) goto L37;
        if (r3 < r4) goto L28;
        if (r10.K == false) goto L38;
    L19:
        r1 = 0;
        goto L21
    L14:
        if (r11.o() == null) goto L16;
        return r10.c(r11);
    L38:
        return 0;
    }
}
