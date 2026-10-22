package com.bytedance.android.live.core.tetris.layout;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import d80.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import x70.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layout/ViewPools;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewPools implements LifecycleObserver {
    public static final Map<AppCompatActivity, b> a = null;
    public static x70.a b;
    public static final ViewPools c = null;

    public static final class a implements ViewPool.a {
        public a() {
        }

        @Override // com.bytedance.android.live.core.tetris.layout.ViewPool.a
        public final void a(AppCompatActivity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Map<AppCompatActivity, b> r0 = ViewPools.a;
            Map<AppCompatActivity, b> r1 = ViewPools.a;
            if (r1.containsKey(r3) == false) goto L6;
            r1.remove(r3);
            return;
        }
    }

    private ViewPools() {
    }

    static {
        c = new ViewPools();
        a = new LinkedHashMap();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        x70.a r0 = b;
        if ((r0 instanceof x70.a) == true) goto L5;
        r0 = null;
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        Context r1 = r0.getContext();
        if ((r1 instanceof AppCompatActivity) == true) goto L10;
        r1 = null;
    L10:
        AppCompatActivity r2 = (AppCompatActivity) r1;
        if (r2 == null) goto L15;
        Lifecycle r3 = r2.getLifecycle();
        if (r3 == null) goto L15;
        r3.removeObserver(this);
    L15:
        x70.a r4 = b;
        if (r4 == null) goto L19;
        b = null;
        r4.g();
        return;
    }

    @JvmStatic
    public static final b a(AppCompatActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if ((d.a & 8) <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        x70.a r1 = b;
        if (r1 == null) goto L10;
        return r1;
    L10:
        x70.a r2 = new x70.a(r3);
        b = r2;
        r3.getLifecycle().addObserver(c);
        return r2;
    L12:
        Map<AppCompatActivity, b> r4 = a;
        if (r4.containsKey(r3) == false) goto L15;
        Object r5 = ((LinkedHashMap) r4).get(r3);
        Intrinsics.checkNotNull(r5);
        return (b) r5;
    L15:
        ViewPool r6 = new ViewPool(r3);
        r4.put(r3, r6);
        a r7 = new a();
        Intrinsics.checkNotNullParameter(r7, "destroyCallback");
        if (r6.d == true) goto L20;
        r6.f = r7;
        r6.d = true;
        r6.h.getLifecycle().addObserver(r6);
    L20:
        return r6;
    L5:
        r0 = false;
        goto L6
    }
}
