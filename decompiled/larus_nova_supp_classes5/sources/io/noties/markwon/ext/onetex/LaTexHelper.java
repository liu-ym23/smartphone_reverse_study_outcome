package io.noties.markwon.ext.onetex;

import android.app.Application;
import android.content.Context;
import com.edu.onetex.OneTeXInitializer;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.OneTexConfiguration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class LaTexHelper implements e {
    public static final /* synthetic */ KProperty[] a = null;
    public static volatile e b;
    public static final Lazy c = null;
    public static final LaTexHelper d = null;

    public static final class a {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L5;
        L13:
            return true;
        L5:
            if ((r4 instanceof a) == true) goto L7;
        L12:
            return false;
        L7:
            if (this.a != ((a) r4).a) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == false) goto L12;
        L9:
            r5 = false;
            goto L10
        }

        public final int hashCode() {
            boolean r0 = this.a;
            if (r0 == false) goto L6;
            return 1;
        L6:
            return r0 ? 1 : 0;
        }

        public final String toString() {
            return "LatexInitConfig(supportNewCommand=" + this.a + ")";
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LaTexHelper.class), "executor", "getExecutor$markwon_ext_onetex_release()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        d = new LaTexHelper();
        c = LazyKt.lazy(LaTexHelper$executor$2.INSTANCE);
    }

    public LaTexHelper() {
    }

    @Override // io.noties.markwon.ext.onetex.e
    public final void a(String r2) {
        e r0 = b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // io.noties.markwon.ext.onetex.e
    public final void b(long r2) {
        e r0 = b;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // io.noties.markwon.ext.onetex.e
    public final void c(String r2) {
        e r0 = b;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final void d(Context r13, a r14) {
        Context r0 = null;
        if (r13 == null) goto L5;
        Context r15 = r13.getApplicationContext();
    L7:
        if ((r15 instanceof Application) == false) goto L10;
        r0 = r15;
    L10:
        Application r1 = (Application) r0;
        if (r1 == null) goto L30;
        LaTeXEngine r16 = LaTeXEngine.INSTANCE;
        if (r16.isInitialized() == false) goto L15;
        return;
    L15:
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L17:
        if (r16.isInitialized() == false) goto L33;
        monitor-exit(this);
        return;
    L33:
        OneTeXInitializer.init(r1);     // Catch: Throwable -> L22
        boolean r6 = r14.a;     // Catch: Throwable -> L22
        r16.setConfig(new OneTexConfiguration(null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cosx", "cos"), TuplesKt.to("sinx", "sin"), TuplesKt.to("arcsinx", "arcsin"), TuplesKt.to("arccosx", "arccos")}), r6, r6, false, false, false, 113, null));     // Catch: Throwable -> L22
    L24:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
        goto L24
    L30:
        return;
    L5:
        r15 = null;
        goto L7
    }
}
