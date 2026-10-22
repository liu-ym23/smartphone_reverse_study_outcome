package mx;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class g extends l {
    public int p;

    @Override // mx.l
    public void c(SwitchSettingViewHolder r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.l = r3;
        if (r3 == false) goto L5;
        int r4 = 1;
    L6:
        this.p = r4;
        return;
    L5:
        r4 = 2;
        goto L6
    }

    public g(String r11, int r12, String r13, int r14) {
        String r1 = "";
        if ((r14 & 4) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r14 & 16) == 0) goto L9;
        boolean r7 = true;
    L11:
        if ((r14 & 32) != 0) goto L14;
        r1 = null;
    L14:
        String r8 = r1;
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r8, "disableToast");
        if (r12 != 1) goto L17;
        boolean r5 = true;
    L18:
        super(r11, r4, r5, false, r7, r8, 64);
        this.p = r12;
        return;
    L17:
        r5 = false;
        goto L18
    L9:
        r7 = false;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }
}
