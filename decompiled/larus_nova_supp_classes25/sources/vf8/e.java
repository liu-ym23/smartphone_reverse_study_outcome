package vf8;

import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.chat.list.cell.loading.LoadingCell;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ LoadingCell a;

    public /* synthetic */ e(LoadingCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        LoadingCell r0 = this.a;
        int r1 = LoadingCell.l;
        de8.c r2 = (de8.c) r0.f.getValue();
        if (r2 == null) goto L5;
        Integer r3 = r2.m();
    L6:
        if (r3 == null) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L23;
        Lazy r5 = we8.e.a;
        int r6 = we8.e.d;
        if (r6 != FontLevel.SUPER_EXTRA_LARGE.getValue()) goto L15;
        float r7 = 1.2f;
    L25:
        return Float.valueOf(r7);
    L15:
        if (r6 != FontLevel.EXTRA_LARGE.getValue()) goto L18;
        r7 = 1.1f;
        goto L25
    L18:
        if (r6 != FontLevel.SMALL.getValue()) goto L21;
        r7 = 0.8f;
        goto L25
    L21:
        if (r6 != FontLevel.EXTRA_SMALL.getValue()) goto L23;
        r7 = 0.7f;
    L23:
        r7 = 1.0f;
        goto L25
    L8:
        r4 = false;
        goto L9
    L5:
        r3 = null;
        goto L6
    }
}
