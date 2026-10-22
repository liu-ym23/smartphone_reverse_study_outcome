package com.larus.uaigc.createpage.bussiness.remove;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.SeekBar;
import com.larus.uaigc.impl.databinding.LarusFragmentImageRemoveBinding;
import com.larus.utils.e1;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ LarusFragmentImageRemoveBinding a;
    public final /* synthetic */ ImageRemoveFragment b;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r3) {
        Job r4 = this.b.o;
        if (r4 == null) goto L5;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L5:
        this.b.o = null;
        e1.x(this.a.i);
        this.a.i.animate().cancel();
        this.a.i.setAlpha(1.0f);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r3) {
        this.a.i.animate().cancel();
        this.a.i.animate().setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).alpha(0.0f).start();
    }

    public u(LarusFragmentImageRemoveBinding r1, ImageRemoveFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        float r4 = r2;
        this.a.h.setPenPxSize(r4);
        this.a.i.setSize(r4 / 2);
    }
}
