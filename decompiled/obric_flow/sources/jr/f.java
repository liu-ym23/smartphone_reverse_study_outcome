package jr;

import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends g {
    public boolean g;

    @Override // jr.g
    public final void e(View r10, float r11) {
        if ((r10 instanceof MotionLayout) == false) goto L6;
        ((MotionLayout) r10).setProgress(a(r11));
        return;
    L6:
        if (this.g == false) goto L21;
        return;
    L21:
        Method r5 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L10
    L11:
        if (r5 == null) goto L26;
        r5.invoke(r10, new Object[]{Float.valueOf(a(r11))});     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16
    L28:
        return;
    L16:
        e = move-exception;
        Log.e("ViewOscillator", "unable to setProgress", e);
        return;
    L14:
        e = move-exception;
        Log.e("ViewOscillator", "unable to setProgress", e);
        return;
    L26:
        return;
    L10:
        this.g = true;
        r5 = null;
        goto L11
    }
}
