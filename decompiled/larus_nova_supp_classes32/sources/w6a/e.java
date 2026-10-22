package w6a;

import android.view.ViewGroup;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public final LynxUI a;
    public int b;
    public ViewGroup c;
    public UIGroup d;
    public s6a.a e;
    public s6a.a f;
    public s6a.a g;
    public s6a.a h;
    public String i;
    public volatile boolean j;
    public volatile boolean k;
    public final HashMap<String, LynxKeyframeAnimator.e> l;

    public final boolean a() {
        if (this.j == false) goto L5;
    L8:
        return true;
    L5:
        if (this.k == true) goto L8;
        return false;
    }

    public e(LynxUI r3) {
        this.b = 0;
        this.c = null;
        this.d = null;
        this.j = false;
        this.k = false;
        this.a = r3;
        this.l = new HashMap();
    }
}
