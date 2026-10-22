package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.messagelist.m;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ BaseModelListScrollManager a;

    public c(BaseModelListScrollManager r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        BaseModelListScrollManager r0 = this.a;
        int r9 = ((Integer) r8).intValue();
        if (r9 < 200) goto L6;
        r0.getClass();
        r0.d(BaseModelListScrollManager.ScrollState.AutoScroll);
    L6:
        if (r9 > 0) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
    L37:
        r0.k.setVisibility(8);
        r0.l.setText(BuildConfig.FLAVOR);
        return;
    L14:
        if (r0.d == false) goto L16;
        boolean r4 = true;
    L28:
        if ((!r4) == true) goto L37;
        TextView r5 = r0.l;
        Object[] r1 = new Object[1];
        if (r9 > 99) goto L33;
        String r10 = String.valueOf(r9);
    L34:
        r1[0] = r10;
        r5.setText(s1.C(2131915221, r1));
        if (r0.k.getVisibility() == 0) goto L42;
        MainThreadPostUtils.b(new e(r0));
        return;
    L42:
        return;
    L33:
        r10 = "99+";
        goto L34
    L16:
        int r6 = r0.e.getItemCount();
        int r7 = 0;
        int r11 = 0;
    L17:
        if (r7 >= r6) goto L23;
        View r13 = r0.e.findViewByPosition(r7);
        if (r13 == null) goto L21;
        r11 = (r11 + r13.getHeight()) + m.g;
    L21:
        r7 = r7 + 1;
        goto L17
    L23:
        if (r11 < r0.j.getHeight()) goto L25;
        r4 = true;
    L26:
        r0.d = r4;
        goto L28
    L25:
        r4 = false;
        goto L26
    L8:
        if (r0.a == BaseModelListScrollManager.ScrollState.AutoScroll) goto L11;
        r3 = false;
        goto L12
    }
}
