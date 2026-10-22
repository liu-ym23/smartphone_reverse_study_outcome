package com.bytedance.android.live.core.tetris.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x70.c;
import x70.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layout/ViewPool;", "Landroidx/lifecycle/LifecycleObserver;", "Lx70/b;", "", "release", "a", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewPool implements LifecycleObserver, x70.b {
    public final HashMap<Integer, HashSet<d>> a;
    public final c b;
    public final Map<Class<? extends View>, ViewGroup> c;
    public boolean d;
    public final int e;
    public a f;
    public final b g;
    public final AppCompatActivity h;

    public interface a {
        void a(AppCompatActivity r1);
    }

    public static final class b implements c.e {
        public final /* synthetic */ ViewPool a;

        public b(ViewPool r1) {
            this.a = r1;
        }

        @Override // x70.c.e
        public final void a(View r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            LocalTestManager.a(new Class[]{wy.a.class});
            d r0 = new d(r4, ViewState.CREATED);
            if (this.a.a.get(Integer.valueOf(r5)) == null) goto L5;
            HashSet<d> r6 = this.a.a.get(Integer.valueOf(r5));
            Intrinsics.checkNotNull(r6);
            HashSet<d> r7 = r6;
        L6:
            r7.add(r0);
            return;
        L5:
            r7 = new HashSet();
            this.a.a.put(Integer.valueOf(r5), r7);
            goto L6
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        this.a.clear();
        a r0 = this.f;
        if (r0 == null) goto L5;
        r0.a(this.h);
    L5:
        this.f = null;
    }

    @Override // x70.b
    public final int f() {
        return this.e;
    }

    public ViewPool(AppCompatActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.h = r2;
        this.a = new HashMap();
        this.b = new c(r2);
        this.c = new LinkedHashMap();
        this.e = 1;
        this.g = new b(this);
    }

    @Override // x70.b
    public final boolean a(int r6) {
        HashSet<d> r7 = this.a.get(Integer.valueOf(r6));
        if (r7 != null) goto L5;
        return false;
    L5:
        Iterator<T> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        Object r1 = r8.next();
        if (((d) r1).b != ViewState.CREATED) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
    L15:
        if (r1 == null) goto L23;
        return true;
    L23:
        return false;
    L11:
        r3 = false;
        goto L12
    L14:
        r1 = null;
        goto L15
    }

    @Override // x70.b
    public final int c(int r2) {
        HashSet<d> r3 = this.a.get(Integer.valueOf(r2));
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.size();
    }

    @Override // x70.b
    public final View e(int r8) {
        HashSet<d> r9 = this.a.get(Integer.valueOf(r8));
        if (r9 != null) goto L5;
        return null;
    L5:
        Iterator<T> r1 = r9.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (((d) r2).b != ViewState.CREATED) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L7;
    L15:
        d r3 = (d) r2;
        if (r3 != null) goto L18;
    L21:
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r3 != null) goto L24;
        return null;
    L24:
        return r3.a;
    L18:
        if (LiveInfraSettingKeys.LIVE_FIX_VIEWPOOL_LEAK.getValue().booleanValue() == false) goto L20;
        r9.remove(r3);
        ViewState r11 = ViewState.USING;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r3.b = r11;
        goto L21
    L20:
        ViewState r4 = ViewState.USING;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.b = r4;
        r9.remove(r3);
        goto L21
    L11:
        r5 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    @Override // x70.b
    public final void d(int r5, Class<? extends View> r6) {
        if (r6 != null) goto L5;
        ViewGroup r7 = null;
    L10:
        this.b.a(r5, r7, this.g);
        return;
    L5:
        if (this.c.containsKey(r6) == false) goto L7;
        r7 = (ViewGroup) ((LinkedHashMap) this.c).get(r6);
        goto L10
    L7:
        View r0 = r6.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.h});
        Map<Class<? extends View>, ViewGroup> r1 = this.c;
        if (r0 == null) goto L13;
        ViewGroup r2 = (ViewGroup) r0;
        r1.put(r6, r2);
        r7 = r2;
        goto L10
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // x70.b
    public final View b(int r2, ViewGroup r3, boolean r4) {
        if (a(r2) == false) goto L11;
        View r0 = e(r2);
        if (r4 == false) goto L8;
        if (r3 == null) goto L8;
        r3.addView(r0);
    L8:
        if (r0 == null) goto L13;
        return r0;
    L13:
        return LayoutInflater.from(this.h).inflate(r2, r3, r4);
    L11:
        return LayoutInflater.from(this.h).inflate(r2, r3, r4);
    }
}
