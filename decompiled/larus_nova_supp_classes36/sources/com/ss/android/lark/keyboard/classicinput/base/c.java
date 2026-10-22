package com.ss.android.lark.keyboard.classicinput.base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final Map<String, IInputSupportAdditionPlugin> a;
    public final Map<String, b> b;
    public final List<Pair<IInputSupportAdditionPlugin, String>> c;
    public final Map<IInputSupportAdditionPlugin.OnPanelChangeListener, Object> d;
    public SlidingUpPanelLayout e;
    public View f;
    public Activity g;
    public int h;
    public com.ss.android.lark.keyboard.b i;
    public final C0132c j;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final ViewGroup b;
        public final IInputSupportAdditionPlugin.a c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PluginEnv(name=" + this.a + ", container=" + this.b + ", context=" + this.c + ')';
        }

        public final IInputSupportAdditionPlugin.a getContext() {
            return this.c;
        }

        public b(String r2, ViewGroup r3, IInputSupportAdditionPlugin.a r4) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "container");
            Intrinsics.checkNotNullParameter(r4, "context");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.classicinput.base.c$c, reason: collision with other inner class name */
    public static final class C0132c implements SlidingUpPanelLayout.d {
        public final /* synthetic */ c a;

        public final void a() {
            Iterator r0 = ((HashMap) this.a.d).entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r0.next()).getKey()).a();
            goto L4
        }

        public C0132c(c r1) {
            this.a = r1;
        }

        public final void b(SlidingUpPanelLayout.PanelState r4, SlidingUpPanelLayout.PanelState r5) {
            SlidingUpPanelLayout.PanelState r0 = SlidingUpPanelLayout.PanelState.COLLAPSED;
            if (r5 != r0) goto L10;
            SlidingUpPanelLayout r1 = this.a.e;
            if (r1 == null) goto L7;
            r1.setEnabled(false);
        L7:
            View r2 = this.a.f;
            if (r2 == null) goto L10;
            r2.setClickable(false);
        L10:
            if (r4 != r0) goto L22;
            SlidingUpPanelLayout r3 = this.a.e;
            if (r3 == null) goto L14;
            r3.setEnabled(true);
        L14:
            View r6 = this.a.f;
            if (r6 == null) goto L17;
            r6.setClickable(true);
        L17:
            Iterator r7 = ((HashMap) this.a.d).entrySet().iterator();
        L19:
            if (r7.hasNext() == false) goto L22;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r7.next()).getKey()).b();
        L22:
            if (r4 != SlidingUpPanelLayout.PanelState.EXPANDED) goto L28;
            Iterator r8 = ((HashMap) this.a.d).entrySet().iterator();
        L25:
            if (r8.hasNext() == false) goto L28;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r8.next()).getKey()).b();
        L28:
            if (r5 != SlidingUpPanelLayout.PanelState.COLLAPSED) goto L34;
            Iterator r9 = ((HashMap) this.a.d).entrySet().iterator();
        L31:
            if (r9.hasNext() == false) goto L34;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r9.next()).getKey()).c();
        L34:
            if (r5 != SlidingUpPanelLayout.PanelState.EXPANDED) goto L39;
            Iterator r10 = ((HashMap) this.a.d).entrySet().iterator();
        L37:
            if (r10.hasNext() == false) goto L44;
            ((IInputSupportAdditionPlugin.OnPanelChangeListener) ((Map.Entry) r10.next()).getKey()).c();
            goto L37
        L44:
            return;
        }
    }

    static {
    }

    public c() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ArrayList();
        this.d = new HashMap();
        this.h = 2;
        this.j = new C0132c(this);
    }
}
