package jr;

import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends q {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18446k;

    @Override // jr.q
    public final boolean d(float r10, long r11, View r12, gr.e r13) {
        if ((r12 instanceof MotionLayout) == false) goto L6;
        ((MotionLayout) r12).setProgress(b(r10, r11, r12, r13));
    L22:
        return this.f18450h;
    L6:
        if (this.f18446k == false) goto L23;
        return false;
    L23:
        Method r5 = r12.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
    L12:
        if (r5 == null) goto L22;
        r5.invoke(r12, new Object[]{Float.valueOf(b(r10, r11, r12, r13))});     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L17
    L17:
        e = move-exception;
        Log.e("ViewTimeCycle", "unable to setProgress", e);
    L15:
        e = move-exception;
        Log.e("ViewTimeCycle", "unable to setProgress", e);
    L11:
        this.f18446k = true;
        r5 = null;
        goto L12
    }
}
