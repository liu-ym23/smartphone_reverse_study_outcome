package com.larus.bmhome.view.actionbar.edit.component;

import android.widget.SeekBar;
import android.widget.TextView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h0 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ List<com.larus.bmhome.actionbar.model.w> a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ Function1<Long, Unit> c;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r1) {
    }

    public h0(List r1, TextView r2, c0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r2, int r3, boolean r4) {
        com.larus.bmhome.actionbar.model.w r5 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(this.a, r3);
        TextView r6 = this.b;
        Long r7 = null;
        if (r5 == null) goto L5;
        String r0 = j0.d(r5);
    L6:
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        r6.setText(r0);
        Function1<Long, Unit> r8 = this.c;
        if (r5 == null) goto L11;
        r7 = r5.a;
    L11:
        r8.invoke(r7);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
