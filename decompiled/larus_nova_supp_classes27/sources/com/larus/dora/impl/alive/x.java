package com.larus.dora.impl.alive;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.dora.device.DoraDevice;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.dora.impl.databinding.LarusDoraPageKeepAliveBinding;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x<T> implements FlowCollector {
    public final /* synthetic */ KeepAliveGuideFragment a;

    public x(KeepAliveGuideFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        boolean r9 = ((Boolean) r7).booleanValue();
        KeepAliveGuideFragment r10 = this.a;
        int r0 = KeepAliveGuideFragment.n;
        int r1 = 0;
        if (r9 == false) goto L9;
        String r2 = r10.getString(2131903292);
        LarusDoraPageKeepAliveBinding r11 = r10.f;
        if (r11 == null) goto L15;
        AppCompatTextView r12 = r11.m;
        if (r12 == null) goto L15;
        r12.setText(r2);
    L15:
        if (this.a.W90() == null) goto L42;
        KeepAliveGuideFragment r13 = this.a;
        DoraDevice r3 = r13.W90();
        if (r3 == null) goto L19;
        String r4 = r3.name;
    L20:
        String r5 = "";
        if (r4 != null) goto L23;
        r4 = "";
    L23:
        LarusDoraPageKeepAliveBinding r6 = r13.f;
        if (r6 == null) goto L32;
        DoraItemTextToggleSubTitle r14 = r6.l;
        if (r14 == null) goto L32;
        TextView r15 = r14.getSubTitle();
        if (r15 == null) goto L32;
        if (r9 == false) goto L31;
        r5 = r13.getString(2131903294) + r4;
    L31:
        r15.setText(r5);
    L32:
        LarusDoraPageKeepAliveBinding r16 = r13.f;
        if (r16 == null) goto L42;
        DoraItemTextToggleSubTitle r17 = r16.l;
        if (r17 == null) goto L42;
        TextView r18 = r17.getSubTitle();
        if (r18 == null) goto L42;
        if (r9 == true) goto L41;
        r1 = 8;
    L41:
        r18.setVisibility(r1);
        goto L42
    L19:
        r4 = null;
    L42:
        LarusDoraPageKeepAliveBinding r20 = this.a.f;
        if (r20 == null) goto L50;
        DoraItemTextToggleSubTitle r21 = r20.l;
        if (r21 == null) goto L50;
        CustomSwitchCompat r22 = r21.getToggleView();
        if (r22 == null) goto L50;
        r22.setChecked(r9);
    L50:
        return Unit.INSTANCE;
    L9:
        String r23 = r10.getString(2131903293);
        SpannableString r24 = new SpannableString(r23 + r10.getString(2131903292));
        r24.setSpan(new ForegroundColorSpan(r10.getResources().getColor(2131103260)), 0, r23.length() + (-1), 33);
        LarusDoraPageKeepAliveBinding r25 = r10.f;
        if (r25 == null) goto L15;
        AppCompatTextView r26 = r25.m;
        if (r26 == null) goto L15;
        r26.setText(r24);
        goto L15
    }
}
