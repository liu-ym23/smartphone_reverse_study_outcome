package com.bytedance.android.live.service.preinflate;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layout.ViewState;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.badger.collect.impl.BuildConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x70.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0007R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/service/preinflate/ViewPool;", "Lcom/bytedance/android/live/service/preinflate/a;", "Landroidx/lifecycle/LifecycleObserver;", "", BuildConfig.BUILD_TYPE, "Landroidx/fragment/app/FragmentActivity;", "i", "Landroidx/fragment/app/FragmentActivity;", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "context", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewPool implements com.bytedance.android.live.service.preinflate.a, LifecycleObserver {
    public long a;
    public long b;
    public final HashMap<Integer, HashSet<d>> c;
    public final Map<Class<? extends View>, ViewGroup> d;
    public final x70.c e;
    public Function1<? super FragmentActivity, Unit> f;
    public final Handler g;
    public final a h;
    public final FragmentActivity i;

    public static final class a implements x70.c.e {
        public final /* synthetic */ ViewPool a;

        public a(ViewPool r1) {
            this.a = r1;
        }

        public final void a(View r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "view");
            if (v.a() == false) goto L5;
            ALogger.i("NewUserProfile_PreLayout", " preInflate finished, resName = " + this.a.getContext().getResources().getResourceEntryName(r7) + '.');
        L5:
            this.a.a++;
            d r0 = new d(r6, ViewState.CREATED);
            HashSet<d> r8 = this.a.c.get(Integer.valueOf(r7));
            if (r8 == null) goto L8;
            r8.add(r0);
            return;
        L8:
            HashSet<d> r9 = new HashSet();
            this.a.c.put(Integer.valueOf(r7), r9);
            r9.add(r0);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        ALogger.i("NewUserProfile_PreLayout", "ViewPool release, context hashcode = " + this.i.hashCode());
        this.c.clear();
        Function1<? super FragmentActivity, Unit> r0 = this.f;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(this.i);
    L5:
        String r2 = null;
        this.f = null;
        ((LinkedHashMap) this.d).clear();
        this.i.getLifecycle().removeObserver(this);
        this.g.removeCallbacksAndMessages(null);
        j0 r3 = j0.l();
        Pair[] r4 = new Pair[3];
        r4[0] = TuplesKt.to("create_count", String.valueOf(this.a));
        r4[1] = TuplesKt.to("get_count", String.valueOf(this.b));
        IMiddlewareUserService r5 = k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L10;
        e r6 = r5.user();
        if (r6 == null) goto L10;
        r2 = r6.n();
    L10:
        r4[2] = TuplesKt.to("current_user_id", String.valueOf(r2));
        r3.sendLog("livesdn_profile_pre_inflate_viewpool_info", MapsKt.mapOf(r4), new Object[0]);
        this.a = 0;
        this.b = 0;
    }

    public final FragmentActivity getContext() {
        return this.i;
    }

    public ViewPool(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.i = r2;
        this.c = new HashMap();
        this.d = new LinkedHashMap();
        this.e = new x70.c(r2);
        this.g = new Handler(Looper.getMainLooper());
        this.h = new a(this);
    }

    @Override // com.bytedance.android.live.service.preinflate.a
    public final boolean a(int r6) {
        HashSet<d> r7 = this.c.get(Integer.valueOf(r6));
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

    @Override // com.bytedance.android.live.service.preinflate.a
    public final int c(int r2) {
        HashSet<d> r3 = this.c.get(Integer.valueOf(r2));
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.size();
    }

    @Override // com.bytedance.android.live.service.preinflate.a
    public final void d(int r5, Class<? extends View> r6) {
        if (r5 != 0) goto L5;
        ALogger.i("NewUserProfile_PreLayout", "preInflateWithParentClass, resId is 0");
        return;
    L5:
        if (r6 != null) goto L8;
        ViewGroup r7 = null;
    L13:
        this.e.a(r5, r7, this.h);
        return;
    L8:
        if (this.d.containsKey(r6) == false) goto L10;
        r7 = (ViewGroup) ((LinkedHashMap) this.d).get(r6);
        goto L13
    L10:
        View r0 = r6.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.i});
        Map<Class<? extends View>, ViewGroup> r1 = this.d;
        if (r0 == null) goto L16;
        ViewGroup r2 = (ViewGroup) r0;
        r1.put(r6, r2);
        r7 = r2;
        goto L13
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.live.service.preinflate.a
    public final void e(long r2, b r4) {
        Intrinsics.checkNotNullParameter(r4, "runnable");
        this.g.postDelayed(r4, r2);
    }

    @Override // com.bytedance.android.live.service.preinflate.a
    public final View b(int r7, ViewGroup r8, boolean r9) {
        if (a(r7) == false) goto L31;
        this.b++;
        HashSet<d> r0 = this.c.get(Integer.valueOf(r7));
        View r1 = null;
        if (r0 == null) goto L25;
        Iterator<T> r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        if (((d) r3).b != ViewState.CREATED) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L9;
    L17:
        d r5 = (d) r3;
        if (r5 == null) goto L21;
        r0.remove(r5);
        ViewState r6 = ViewState.USING;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.b = r6;
    L21:
        if (v.a() == false) goto L23;
        ALogger.i("NewUserProfile_PreLayout", "match the cache, resName = " + this.i.getResources().getResourceEntryName(r7));
    L23:
        if (r5 == null) goto L25;
        r1 = r5.a;
        goto L25
    L13:
        r4 = false;
        goto L14
    L16:
        r3 = null;
    L25:
        if (r9 == false) goto L28;
        if (r8 == null) goto L28;
        r8.addView(r1);
    L28:
        if (r1 == null) goto L38;
        return r1;
    L38:
        return LayoutInflater.from(this.i).inflate(r7, r8, r9);
    L31:
        return LayoutInflater.from(this.i).inflate(r7, r8, r9);
    }
}
