package mw0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends LinearLayout {
    public final View a;
    public final int b;
    public final Integer c;
    public final Integer d;

    public final View getView() {
        ((TextView) this.a.findViewById(2131383841)).setText(s1.C(2131915546, new Object[]{String.valueOf(this.b)}));
        Integer r0 = this.d;
        if (r0 != null) goto L5;
    L9:
        ((TextView) this.a.findViewById(2131383840)).setText(s1.C(2131915545, new Object[]{"--", r3.b()}));
    L11:
        return this.a;
    L5:
        if (r0.intValue() == 0) goto L9;
        if (this.c == null) goto L9;
        ((TextView) this.a.findViewById(2131383840)).setText(s1.C(2131915545, new Object[]{Integer.valueOf((this.b / this.d.intValue()) * this.c.intValue()), r3.b()}));
        goto L11
    }

    public a(int r3, Integer r4, Integer r5, Context r6) {
        super(r6, null, 0);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.a = LayoutInflater.from(r6).inflate(2131567518, null);
    }
}
