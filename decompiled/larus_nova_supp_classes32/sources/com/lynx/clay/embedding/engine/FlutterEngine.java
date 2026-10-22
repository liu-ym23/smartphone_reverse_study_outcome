package com.lynx.clay.embedding.engine;

import android.content.ClipboardManager;
import android.content.Context;
import com.lynx.clay.embedding.android.RenderMode;
import com.lynx.clay.embedding.engine.loader.FlutterLoader;
import com.lynx.clay.embedding.engine.loader.ImageLoader;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.lynx.clay.plugin.platform.PlatformViewsController;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterEngine {
    public static ClipboardManager i;
    public final FlutterJNI a;
    public final FlutterRenderer b;
    public final ClayPluginContext c;
    public final com.lynx.clay.embedding.engine.a d;
    public final com.lynx.clay.embedding.engine.accessibility.a e;
    public final PlatformViewsController f;
    public final Set<a> g;
    public RenderMode h;

    public interface a {
        void a();

        void b();
    }

    public final void a() {
        c5a.c.e();
        Iterator r0 = ((HashSet) this.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).a();
        goto L4
    L6:
        com.lynx.clay.embedding.engine.a r1 = this.d;
        r1.getClass();
        c5a.c.e();
        Iterator r2 = new HashSet(((HashMap) r1.a).keySet()).iterator();
    L8:
        if (r2.hasNext() == false) goto L24;
        Class r3 = (Class) r2.next();
        f5a.a r4 = (f5a.a) ((HashMap) r1.a).get(r3);
        if (r4 == null) goto L8;
        r4.toString();
        c5a.c.e();
        if ((r4 instanceof g5a.a) == false) goto L15;
        ((HashMap) r1.b).remove(r3);
    L15:
        if ((r4 instanceof q5a.a) == false) goto L18;
        ((HashMap) r1.c).remove(r3);
    L18:
        if ((r4 instanceof i5a.a) == false) goto L21;
        ((HashMap) r1.d).remove(r3);
    L21:
        if ((r4 instanceof j5a.a) == false) goto L23;
        ((HashMap) r1.e).remove(r3);
    L23:
        r4.a();
        ((HashMap) r1.a).remove(r3);
        goto L8
    L24:
        ((HashMap) r1.a).clear();
        this.f.onDetachedFromJNI();
        this.a.detachFromNativeAndReleaseResources();
    }

    public FlutterJNI getFlutterJNI() {
        return this.a;
    }

    public FlutterEngine(Context r10, String[] r11, boolean r12, boolean r13) {
        this(r10, c5a.b.a().a, new FlutterJNI(), new PlatformViewsController(), r11, r12, r13);
    }

    public FlutterEngine(Context r3, FlutterLoader r4, FlutterJNI r5, PlatformViewsController r6, String[] r7, boolean r8, boolean r9) {
        this.g = new HashSet();
        this.h = null;
        this.e = new com.lynx.clay.embedding.engine.accessibility.a();
        this.a = r5;
        ClayPluginContext r0 = new ClayPluginContext();
        this.c = r0;
        r5.setClayPluginContext(r0);
        if (i != null) goto L5;
        i = (ClipboardManager) r3.getApplicationContext().getSystemService("clipboard");
    L5:
        r5.setClipboardManager(i);
        if (r4 != null) goto L9;
        r4 = c5a.b.a().a;
    L9:
        if (r5.isAttached() == true) goto L11;
        Context r1 = r3.getApplicationContext();
        r4.getClass();
        r4.e(r1, new FlutterLoader.c());
        r4.a(r3, r7);
    L11:
        r5.setPlatformViewsController(r6);
        if (r5.isAttached() == true) goto L18;
        r5.attachToNative(false, r8, r9);
        if (r5.isAttached() == true) goto L18;
        throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
    L18:
        this.b = new FlutterRenderer(r5);
        this.f = r6;
        r6.onAttachedToJNI();
        r3.getApplicationContext();
        this.d = new com.lynx.clay.embedding.engine.a(this);
        ImageLoader.Initialize(r3);
    }
}
