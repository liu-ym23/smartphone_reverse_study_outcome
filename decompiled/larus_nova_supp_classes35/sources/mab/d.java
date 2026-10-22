package mab;

import android.content.Context;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends c {
    public String[] e;
    public Boolean f;

    @Override // mab.c, android.widget.Adapter
    public final int getCount() {
        if (this.e != null) goto L9;
        this.e = new String[35];
        int r0 = 0;
    L6:
        if (r0 >= 31) goto L9;
        int r2 = r0 + 1;
        this.e[r0] = String.valueOf(r2);
        r0 = r2;
    L9:
        return this.e.length;
    }

    @Override // mab.c
    public final String a(int r2) {
        if (r2 >= 0) goto L4;
        return BuildConfig.FLAVOR;
    L4:
        if (r2 < 31) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return this.e[r2];
    }

    public final void c(int r5) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        if (r5 < 31) goto L6;
        return;
    L6:
        if (this.f.booleanValue() == false) goto L16;
        this.a[r5] = true;
        int r0 = 0;
    L8:
        boolean[] r2 = this.a;
        if (r0 >= r2.length) goto L17;
        boolean r3 = r2[r0];
        if (r3 == false) goto L15;
        if (r0 == r5) goto L15;
        r2[r0] = !r3;
    L15:
        r0 = r0 + 1;
    L17:
        notifyDataSetChanged();
        return;
    L16:
        boolean[] r1 = this.a;
        r1[r5] = true ^ r1[r5];
        goto L17
    }

    public d(Context r2, int r3) {
        super(r2, 7, r3);
        this.f = Boolean.FALSE;
        boolean[] r4 = new boolean[this.e.length];
        this.a = r4;
        Arrays.fill(r4, false);
    }
}
