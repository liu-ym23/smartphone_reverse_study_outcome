package kx0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends FrameLayout {
    public Long a;
    public Long b;
    public Integer c;
    public Integer d;
    public final View e;

    public final View getView() {
        Long r0 = this.a;
        if (r0 == null) goto L5;
        long r3 = r0.longValue();
    L7:
        if (r3 <= 0) goto L9;
        ((TextView) this.e.findViewById(2131383892)).setVisibility(0);
        ((TextView) this.e.findViewById(2131383892)).setText(s1.C(2131915546, new Object[]{String.valueOf(this.a)}));
    L9:
        Long r4 = this.b;
        if (r4 == null) goto L12;
        long r5 = r4.longValue();
    L14:
        if (r5 <= 0) goto L17;
        ((TextView) this.e.findViewById(2131383893)).setVisibility(0);
        ((TextView) this.e.findViewById(2131383893)).setText(s1.C(2131915545, new Object[]{String.valueOf(this.b), r3.b()}));
    L17:
        return this.e;
    L12:
        r5 = 0;
        goto L14
    L5:
        r3 = 0;
        goto L7
    }

    public final View getView2() {
        Long r0 = this.a;
        if (r0 == null) goto L5;
        long r3 = r0.longValue();
    L7:
        if (r3 <= 0) goto L16;
        ((TextView) this.e.findViewById(2131383892)).setVisibility(0);
        ((TextView) this.e.findViewById(2131383892)).setText(s1.C(2131915546, new Object[]{String.valueOf(this.a)}));
        Long r1 = this.a;
        Integer r4 = this.d;
        Integer r5 = this.c;
        if (r1 == null) goto L16;
        if (r4 == null) goto L16;
        if (r5 == null) goto L16;
        int r6 = r5.intValue();
        int r7 = r4.intValue();
        long r8 = r1.longValue();
        if (r7 <= 0) goto L16;
        ((TextView) this.e.findViewById(2131383893)).setVisibility(0);
        ((TextView) this.e.findViewById(2131383893)).setText(s1.C(2131915545, new Object[]{String.valueOf((r8 / ((long) r7)) * ((long) r6)), r3.b()}));
    L16:
        return this.e;
    L5:
        r3 = 0;
        goto L7
    }

    public final Long getMDeductAmount() {
        return this.b;
    }

    public final Integer getMGiftLimit() {
        return this.d;
    }

    public final Long getMRebateAmount() {
        return this.a;
    }

    public final Integer getMRebateLimit() {
        return this.c;
    }

    public final void setMDeductAmount(Long r1) {
        this.b = r1;
    }

    public final void setMGiftLimit(Integer r1) {
        this.d = r1;
    }

    public final void setMRebateAmount(Long r1) {
        this.a = r1;
    }

    public final void setMRebateLimit(Integer r1) {
        this.c = r1;
    }

    public e(Long r5, Long r6, Integer r7, Integer r8, Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, null, 0);
        this.a = 0L;
        this.b = 0L;
        this.c = 0;
        this.d = 0;
        this.e = LayoutInflater.from(getContext()).inflate(2131567270, null);
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
    }
}
