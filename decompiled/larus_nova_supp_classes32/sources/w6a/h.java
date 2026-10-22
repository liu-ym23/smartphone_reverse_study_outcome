package w6a;

import android.view.View;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public final ConcurrentHashMap<String, WeakReference<View>> a;
    public final WeakHashMap<LynxUI, s6a.a> b;
    public final WeakHashMap<LynxUI, s6a.a> c;
    public final WeakHashMap<LynxUI, s6a.a> d;
    public final WeakHashMap<LynxUI, s6a.a> e;
    public final WeakHashMap<LynxUI, String> f;
    public volatile boolean g;

    public static final class a {
        public static final h a = null;

        static {
            a = new h();
        }
    }

    public interface b {
    }

    public interface c {
        void a();
    }

    public h() {
        this.a = new ConcurrentHashMap();
        this.b = new WeakHashMap();
        this.c = new WeakHashMap();
        this.d = new WeakHashMap();
        this.e = new WeakHashMap();
        this.f = new WeakHashMap();
        this.g = true;
    }

    public final void b(LynxView r4) {
        Iterator<LynxUI> r0 = this.d.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        LynxUI r1 = r0.next();
        if (r1.getLynxContext().getUIBody().getBodyView() != r4) goto L4;
        r1.execResumeAnim();
        goto L4
    }

    public static void a(Map r1, LynxView r2) {
        Iterator r3 = ((WeakHashMap) r1).entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        LynxUI r0 = (LynxUI) ((Map.Entry) r3.next()).getKey();
        if (r0 == null) goto L4;
        if (r0.getLynxContext().getUIBody().getBodyView() != r2) goto L4;
        r3.remove();
        goto L4
    }
}
