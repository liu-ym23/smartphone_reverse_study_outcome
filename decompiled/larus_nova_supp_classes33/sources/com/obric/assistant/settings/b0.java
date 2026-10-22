package com.obric.assistant.settings;

import android.os.SystemClock;
import android.view.View;
import android.widget.CompoundButton;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ObricSettingAdapter a;
    public final /* synthetic */ g1 b;
    public final /* synthetic */ ObricSettingAdapter.GroupViewHolder c;
    public final /* synthetic */ int d;

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r9, boolean r10) {
        long r0 = SystemClock.elapsedRealtime();
        Long r2 = (Long) ((LinkedHashMap) this.a.c).get(this.b.a);
        if (r2 == null) goto L5;
        long r3 = r2.longValue();
    L6:
        g1 r6 = null;
        if ((r0 - r3) >= 500) goto L16;
        FLogger.a.d("ObricSettingAdapter", "onCheckedChangeListener isQuick, " + this.b.a);
        if (r9 == null) goto L11;
        r9.setOnCheckedChangeListener(null);
    L11:
        if (r9 == null) goto L13;
        r9.setChecked(!r10);
    L13:
        if (r9 == null) goto L29;
        r9.setOnCheckedChangeListener(this);
        return;
    L29:
        return;
    L16:
        this.a.c.put(this.b.a, Long.valueOf(r0));
        ObricSettingAdapter.GroupViewHolder r1 = this.c;
        j r4 = (j) r1.c.invoke(Integer.valueOf(r1.getBindingAdapterPosition()));
        if (r4 == null) goto L21;
        List<q0> r5 = r4.b;
        if (r5 == null) goto L21;
        q0 r7 = (q0) ListProtector.get(r5, this.d);
    L23:
        if ((r7 instanceof g1) == false) goto L25;
        r6 = (g1) r7;
    L25:
        if (r6 == null) goto L27;
        r6.d = r10;
    L27:
        Function2<Boolean, View, Unit> r8 = this.b.e;
        Boolean r11 = Boolean.valueOf(r10);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.View");
        r8.invoke(r11, r9);
        return;
    L21:
        r7 = null;
        goto L23
    L5:
        r3 = 0;
        goto L6
    }

    public b0(ObricSettingAdapter r1, g1 r2, ObricSettingAdapter.GroupViewHolder r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
