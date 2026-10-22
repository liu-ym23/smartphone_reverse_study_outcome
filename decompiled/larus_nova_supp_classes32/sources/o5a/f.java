package o5a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.engine.plugins.platformview.InternalPlatformViewRegistry;
import com.lynx.clay.embedding.engine.plugins.platformview.LynxUIClayUIBridge$CompositionPreference;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallbackResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import n5a.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends com.lynx.clay.embedding.engine.plugins.platformview.a {
    public Context h;
    public boolean i;
    public View j;
    public final List<b> k;
    public final a l;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ f a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        public a(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r3) {
            f r4 = this.a;
            r4.getClass();
            View r0 = r4.j;
            if (r0 == null) goto L6;
            r0.removeOnAttachStateChangeListener(r4.l);
            r4.j = null;
        L6:
            this.a.getClass();
        }
    }

    public static final class b {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final boolean d(String r1, JSONObject r2, n5a.a r3) {
        return false;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void g() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void j() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void l() {
        this.i = false;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void m() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void n(String r1, Object r2) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void h() {
        View r0 = this.j;
        if (r0 == null) goto L6;
        r0.removeOnAttachStateChangeListener(this.l);
        this.j = null;
    L6:
        Iterator r1 = ((ArrayList) this.k).iterator();
        if (r1.hasNext() == true) goto L10;
        ((ArrayList) this.k).clear();
        this.i = false;
        return;
    L10:
        ((b) r1.next()).getClass();
        PlatformMethodCallbackResult r2 = PlatformMethodCallbackResult.NODE_NOT_FOUND;
        throw null;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void k() {
        boolean r0 = this.i;
        this.i = true;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final View a(Context r5) {
        Context r0 = this.h;
        if (r0 != null) goto L29;
        WeakHashMap<Context, WeakReference<Context>> r1 = n5a.g.a;
        monitor-enter(n5a.g.class);
        Context r2 = null;
        if (r5 != null) goto L37;
        monitor-exit(n5a.g.class);
    L10:
        r0 = r2;
        goto L29
    L37:
        WeakHashMap<Context, WeakReference<Context>> r3 = n5a.g.a;     // Catch: Throwable -> L34
        WeakReference<Context> r4 = r3.get(r5);     // Catch: Throwable -> L34
        if (r4 == null) goto L17;
        r2 = r4.get();     // Catch: Throwable -> L34
        if (r2 != null) goto L17;
        r3.remove(r5);     // Catch: Throwable -> L34
    L17:
        Iterator<Map.Entry<Context, WeakReference<Context>>> r6 = r3.entrySet().iterator();     // Catch: Throwable -> L34
    L18:
        if (r6.hasNext() == false) goto L26;
        WeakReference<Context> r7 = r6.next().getValue();     // Catch: Throwable -> L34
        if (r7 == null) goto L24;
        if (r7.get() != null) goto L18;
    L24:
        r6.remove();     // Catch: Throwable -> L34
        goto L18
    L26:
        monitor-exit(n5a.g.class);
    L34:
        th = move-exception;
        throw th;
    L29:
        if (r0 != null) goto L32;
        c5a.c.d(6, "InternalPlatformViewWrapper", "No LynxContext found for " + this.a);
        return new FrameLayout(r5);
    L32:
        c5a.c.d(6, "InternalPlatformViewWrapper", "No LynxUIClayUIBridge provider found for " + this.a);
        return new FrameLayout(r5);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void o(j r1) {
        this.c = r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void p(List<String> r1) {
        this.d = r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void i(int r1, int r2, int r3, int r4) {
        b();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void r(float r1, float r2, float r3, float r4) {
        super.r(r1, r2, r3, r4);
        b();
    }

    public f(Context r1, int r2, String r3, LynxUIClayUIBridge$CompositionPreference r4, InternalPlatformViewRegistry.ViewDrawType r5) {
        super(r1, r2, r3);
        this.i = false;
        this.k = new ArrayList();
        this.l = new a(this);
        this.g = r4;
        this.f = r5;
    }
}
