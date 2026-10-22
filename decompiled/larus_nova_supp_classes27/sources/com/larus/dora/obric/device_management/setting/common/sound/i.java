package com.larus.dora.obric.device_management.setting.common.sound;

import android.widget.SeekBar;
import androidx.lifecycle.LifecycleOwnerKt;
import com.obric.oui.slider.OSlider;
import com.obric.oui.slider.TickMarkSeekBar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements TickMarkSeekBar.b {
    public final /* synthetic */ DoraObricSoundSettingsFragment a;

    public final void e(int r1) {
    }

    public i(DoraObricSoundSettingsFragment r1) {
        this.a = r1;
    }

    public final void b(SeekBar r1) {
        Intrinsics.checkNotNullParameter(this, "this");
    }

    public final void d(TickMarkSeekBar r9) {
        OSlider r10 = this.a.n;
        if (r10 == null) goto L75;
        int r0 = 0;
        int r11 = RangesKt.coerceIn(MathKt.roundToInt(r10.getRealProgress()), 0, 5);
        DoraObricSoundSettingsFragment r2 = this.a;
        Integer r3 = Integer.valueOf(r11);
        r2.getClass();
        if (r3 == null) goto L11;
        if (r3.intValue() != 0) goto L11;
        r0 = 253;
    L73:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), Dispatchers.getIO(), null, new DoraObricSoundSettingsFragment$setupCueToneSeek$1$onStopTrackingTouch$1(r0, this.a, r11, null), 2, null);
        return;
    L11:
        if (r3 == null) goto L17;
        if (r3.intValue() != 1) goto L17;
        r0 = 254;
    L17:
        if (r3 == null) goto L23;
        if (r3.intValue() != 2) goto L23;
        r0 = 255;
    L23:
        if (r3 != null) goto L26;
    L28:
        r0 = 4;
        if (r3 != null) goto L32;
    L34:
        if (r3 == null) goto L40;
        if (r3.intValue() != 5) goto L40;
        r0 = 2;
    L40:
        if (r3 == null) goto L46;
        if (r3.intValue() != 6) goto L46;
        r0 = 3;
    L46:
        if (r3 != null) goto L49;
    L51:
        r0 = 8;
        if (r3 != null) goto L55;
    L57:
        if (r3 != null) goto L60;
    L62:
        if (r3 != null) goto L65;
    L67:
        if (r3 != null) goto L70;
    L72:
        r0 = -1;
        goto L73
    L70:
        if (r3.intValue() != 11) goto L72;
    L65:
        if (r3.intValue() != 10) goto L67;
        r0 = 7;
        goto L73
    L60:
        if (r3.intValue() != 9) goto L62;
        r0 = 6;
        goto L73
    L55:
        if (r3.intValue() != 8) goto L57;
        r0 = 5;
        goto L73
    L49:
        if (r3.intValue() != 7) goto L51;
    L32:
        if (r3.intValue() != 4) goto L34;
        r0 = 1;
        goto L73
    L26:
        if (r3.intValue() != 3) goto L28;
    }

    public final void onStartTrackingTouch(SeekBar r2) {
        g49.d.d("DoraObricSoundSettings", "cueToneSlider onStartTrackingTouch");
    }

    public final void c(SeekBar r1, float r2) {
        Intrinsics.checkNotNullParameter(this, "this");
    }

    public final void a(SeekBar r2, float r3, boolean r4) {
        g49.d.d("DoraObricSoundSettings", "cueToneSlider onProgressChanged: " + r3 + ", fromUser=" + r4);
    }
}
