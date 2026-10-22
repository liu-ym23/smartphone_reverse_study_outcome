package com.larus.dora.obric.device_management.setting.earbuds.keep_alive;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.bytedance.dora.device.DoraDevice;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsKeepAliveFragment a;

    public o(DoraObricEarbudsKeepAliveFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        boolean r9 = ((Boolean) r7).booleanValue();
        DoraObricEarbudsKeepAliveFragment r10 = this.a;
        r10.t = r9;
        if (r9 == false) goto L7;
        TextView r2 = r10.q;
        if (r2 == null) goto L11;
        r2.setText(r10.getString(2131903292));
    L11:
        if (this.a.ba0() == null) goto L24;
        DoraObricEarbudsKeepAliveFragment r11 = this.a;
        DoraDevice r3 = r11.ba0();
        if (r3 == null) goto L15;
        String r4 = r3.name;
    L17:
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        OCardListItem r5 = r11.s;
        if (r5 == null) goto L24;
        if (r9 == false) goto L23;
        r5.setSubTitle(r11.getString(2131903294) + r4);
        r5.q(true);
        goto L24
    L23:
        r5.setSubTitle("");
        r5.q(false);
        goto L24
    L15:
        r4 = null;
    L24:
        DoraObricEarbudsKeepAliveFragment r12 = this.a;
        OSwitch r0 = r12.r;
        if (r0 == null) goto L30;
        r0.setOnCheckedChangeListener(null);
        r0.setChecked(r9);
        OSwitch r13 = r12.r;
        if (r13 == null) goto L30;
        r13.setOnCheckedChangeListener(new j(r12));
    L30:
        return Unit.INSTANCE;
    L7:
        String r6 = r10.getString(2131903293);
        SpannableString r14 = new SpannableString(r6 + r10.getString(2131903292));
        r14.setSpan(new ForegroundColorSpan(r10.getResources().getColor(2131103260)), 0, r6.length() + (-1), 33);
        TextView r15 = r10.q;
        if (r15 == null) goto L11;
        r15.setText(r14);
        goto L11
    }
}
