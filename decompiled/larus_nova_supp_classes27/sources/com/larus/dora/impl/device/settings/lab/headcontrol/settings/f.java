package com.larus.dora.impl.device.settings.lab.headcontrol.settings;

import android.widget.TextView;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlSettingsBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f<T> implements FlowCollector {
    public final /* synthetic */ HeadControlSettingsFragment a;

    public f(HeadControlSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        w49.c r4 = (w49.c) r2;
        LarusDoraPageHeadControlSettingsBinding r5 = this.a.f;
        if (r5 == null) goto L9;
        ItemTextArrow r6 = r5.f;
        if (r6 == null) goto L9;
        TextView r7 = r6.getSubTextView();
        if (r7 == null) goto L9;
        r7.setText(r4.a.getTitle());
    L9:
        LarusDoraPageHeadControlSettingsBinding r8 = this.a.f;
        if (r8 == null) goto L17;
        ItemTextArrow r9 = r8.h;
        if (r9 == null) goto L17;
        TextView r10 = r9.getSubTextView();
        if (r10 == null) goto L17;
        r10.setText(r4.b.getTitle());
    L17:
        return Unit.INSTANCE;
    }
}
