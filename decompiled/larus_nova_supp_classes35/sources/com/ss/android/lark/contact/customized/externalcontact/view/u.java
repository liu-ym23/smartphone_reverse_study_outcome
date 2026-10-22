package com.ss.android.lark.contact.customized.externalcontact.view;

import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u {
    public final FrameLayout a;
    public final TextView b;
    public final IndexBar c;
    public final View d;
    public final boolean e;
    public Vibrator f;

    public u(ViewGroup r3) {
        this.a = (FrameLayout) r3.findViewById(2131375221);
        TextView r0 = (TextView) r3.findViewById(2131375223);
        this.b = r0;
        this.c = (IndexBar) r3.findViewById(2131375220);
        View r4 = r3.findViewById(2131375222);
        this.d = r4;
        this.e = false;
        if (r4 == null) goto L5;
        r4.setVisibility(8);
    L5:
        r0.setVisibility(8);
    }

    public final void a(Map<Integer, String> r5) {
        if (r5.isEmpty() == false) goto L11;
        FrameLayout r6 = this.a;
        if (r6 == null) goto L7;
        r6.setVisibility(8);
    L7:
        this.c.setNavigators(new ArrayList());
        View r7 = this.d;
        if (r7 == null) goto L24;
        r7.setVisibility(8);
        return;
    L24:
        return;
    L11:
        FrameLayout r0 = this.a;
        if (r0 == null) goto L14;
        r0.setVisibility(0);
    L14:
        boolean r1 = this.e;
        final ArrayList r2 = new ArrayList(r5.size() + (r1 ? 1 : 0));
        if (this.e == false) goto L17;
        r2.add(BuildConfig.FLAVOR);
    L17:
        r2.addAll(r5.values());
        this.c.setNavigators(r2);
        if (this.e == false) goto L20;
        this.c.post(new r(this, r2));
        return;
    L20:
        View r8 = this.d;
        if (r8 == null) goto L26;
        r8.setVisibility(8);
        return;
    }
}
