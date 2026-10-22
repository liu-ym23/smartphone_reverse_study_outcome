package com.bytedance.android.live.core.tetris;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import g70.f;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ComponentManagerFactory$config$1 implements com.bytedance.android.live.core.tetris.componentx.a {
    public final LifecycleOwner a;
    public final h70.b b;
    public final Context c;
    public final String d;
    public final f70.a e;
    public final c f;
    public final b g;
    public final Function1<Runnable, Unit> h;
    public final a i;
    public final /* synthetic */ LifecycleOwner j;
    public final /* synthetic */ com.bytedance.android.live.core.tetris.layer.view.a k;
    public final /* synthetic */ String l;
    public final /* synthetic */ DataCenter m;
    public final /* synthetic */ List n;

    public static final class a implements f {
        public final boolean a;
        public final String b;

        @Override // g70.f
        public final boolean a() {
            return this.a;
        }

        public a(ComponentManagerFactory$config$1 r3) {
            this.a = ComponentManagerABHelper.INSTANCE.enableFullLog();
            this.b = "ComponentManager_" + r3.l;
        }

        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            ALogger.e(this.b, r2);
        }

        @Override // g70.f
        public final void log(String r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            ALogger.i(this.b, r2);
        }
    }

    public static final class b {
        public final /* synthetic */ ComponentManagerFactory$config$1 a;

        public final r70.a<h70.b> a() {
            return this.a.k.f;
        }

        public final ElementBuilderMap b() {
            ElementBuilderMap r0 = this.a.k.b;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("elementBuilderMap");
        L5:
            return r0;
        }

        public final r70.b<h70.b> c() {
            return this.a.k.e;
        }

        public final LayerEventDispatcher d() {
            LayerEventDispatcher r0 = this.a.k.d;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("layerEventDispatcher");
        L5:
            return r0;
        }

        public final Map<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>> e() {
            return this.a.k.h;
        }

        public final p70.b f() {
            return this.a.k.l;
        }

        public final r70.a<h70.b> g() {
            return this.a.k.g;
        }

        public final b80.a h() {
            return this.a.k.i;
        }

        public final com.bytedance.android.live.core.tetris.layer.view.a.C0161a i() {
            return this.a.k.k;
        }

        public b(ComponentManagerFactory$config$1 r1) {
            this.a = r1;
        }
    }

    public static final class c {
        public final /* synthetic */ ComponentManagerFactory$config$1 a;

        public final com.bytedance.android.live.core.tetris.layer.core.delegate.c<h70.b> a() {
            com.bytedance.android.live.core.tetris.layer.core.delegate.c<h70.b> r0 = this.a.k.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("layerDelegateConfig");
        L5:
            return r0;
        }

        public final Map<LayerIndex, Integer> b() {
            this.a.k.getClass();
            return null;
        }

        public c(ComponentManagerFactory$config$1 r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final b a() {
        return this.g;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final String b() {
        return this.d;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final c c() {
        return this.f;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final Function1<Runnable, Unit> d() {
        return this.h;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final h70.b getComponentContext() {
        return this.b;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public Context getContext() {
        return this.c;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final a getLogger() {
        return this.i;
    }

    public ComponentManagerFactory$config$1(LifecycleOwner r1, com.bytedance.android.live.core.tetris.layer.view.a r2, Context r3, String r4, DataCenter r5, f70.a r6, List r7) {
        this.j = r1;
        this.k = r2;
        this.l = r4;
        this.m = r5;
        this.n = r7;
        this.a = r1;
        this.b = r2.a();
        this.c = r3;
        StringBuilder r8 = new StringBuilder();
        r8.append(r4);
        r8.append(':');
        if (r5 == null) goto L6;
        String r9 = c50.b.b(r5);
        if (r9 == null) goto L6;
    L7:
        r8.append(r9);
        this.d = r8.toString();
        this.e = r6;
        this.f = new c(this);
        this.g = new b(this);
        this.h = new ComponentManagerFactory$config$1$cmcRunnableExecutor$1(this);
        this.i = new a(this);
        return;
    L6:
        r9 = "null";
        goto L7
    }
}
