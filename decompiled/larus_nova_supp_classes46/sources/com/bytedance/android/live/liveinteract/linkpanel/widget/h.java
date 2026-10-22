package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ GuestApplyContentWidget a;

    public h(GuestApplyContentWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L20;
        GuestApplyContentWidget r4 = this.a;
        r4.getClass();
        SimpleDateFormat r0 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        TextView r1 = r4.i;
        if (r1 == null) goto L7;
        r1.setBackgroundResource(2131249221);
    L7:
        TextView r2 = r4.i;
        if (r2 == null) goto L10;
        r2.setClickable(false);
    L10:
        TextView r5 = r4.i;
        if (r5 == null) goto L14;
        r5.setText(s1.B(2131919307));
    L14:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.y() == false) goto L30;
        GuestApplyViewModel r6 = r4.q;
        if (r6 == null) goto L31;
        LiveData<n0> r7 = r6.getUserWaitingData();
        if (r7 == null) goto L32;
        n0 r8 = (n0) r7.getValue();
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L20:
        GuestApplyContentWidget r9 = this.a;
        TextView r10 = r9.i;
        if (r10 == null) goto L23;
        r10.setBackgroundResource(2131249467);
    L23:
        TextView r11 = r9.i;
        if (r11 == null) goto L26;
        r11.setClickable(true);
    L26:
        TextView r12 = r9.i;
        if (r12 == null) goto L34;
        r12.setText(s1.B(2131919314));
        return;
    }
}
