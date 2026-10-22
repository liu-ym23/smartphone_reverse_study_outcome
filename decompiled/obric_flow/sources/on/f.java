package on;

import com.lynx.animax.i;
import com.lynx.tasm.utils.DisplayMetricsHolder;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends i {
    public void d(int r5, int r10, int r11, int r12, int r13, int r14) {
        a("scrollLeft", Float.valueOf(r5 / DisplayMetricsHolder.a().density));
        a("scrollTop", Float.valueOf(r10 / DisplayMetricsHolder.a().density));
        a("scrollHeight", Float.valueOf(r11 / DisplayMetricsHolder.a().density));
        a("scrollWidth", Float.valueOf(r12 / DisplayMetricsHolder.a().density));
        a("deltaX", Float.valueOf(r13 / DisplayMetricsHolder.a().density));
        a("deltaY", Float.valueOf(r14 / DisplayMetricsHolder.a().density));
    }
}
