package com.bytedance.android.ec.core.opt.asyncInflate;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.opt.asyncInflate.AsyncInflaterImpl;
import com.bytedance.android.ec.opt.asyncInflate.ILifecycleInflater;
import com.bytedance.android.ec.opt.asyncInflate.d;
import com.bytedance.android.ec.sdk.plugin.e;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0003\u001a\u00020\u0002H\u0017¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/opt/asyncInflate/ShoppingAsyncInflater;", "Lcom/bytedance/android/ec/opt/asyncInflate/ILifecycleInflater;", "", "onDestroy", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShoppingAsyncInflater implements ILifecycleInflater {
    public static final Map<Activity, ShoppingAsyncInflater> d = null;
    public static final a e = null;
    public final AsyncInflaterImpl a;
    public final Activity b;
    public final Context c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater$a$a, reason: collision with other inner class name */
        public static final class RunnableC0144a implements Runnable {
            public final /* synthetic */ ShoppingAsyncInflater a;
            public final /* synthetic */ Activity b;

            public RunnableC0144a(ShoppingAsyncInflater r1, Activity r10) {
                this.a = r1;
                this.b = r10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.getLifecycle().addObserver(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a() {
        }

        public static ShoppingAsyncInflater a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Activity r0 = e.getActivity(r10);
            if ((r0 instanceof LifecycleOwner) == false) goto L8;
            Map<Activity, ShoppingAsyncInflater> r1 = ShoppingAsyncInflater.d;
            ShoppingAsyncInflater r11 = (ShoppingAsyncInflater) ((LinkedHashMap) r1).get(r0);
            if (r11 != null) goto L9;
            ShoppingAsyncInflater r12 = new ShoppingAsyncInflater(new AsyncInflaterImpl(r0), r0, r10);
            new Handler(Looper.getMainLooper()).post(new RunnableC0144a(r12, r0));
            r1.put(r0, r12);
            return r12;
        L9:
            return r11;
        L8:
            return new ShoppingAsyncInflater(null, null, r10);
        }
    }

    public static final class b implements d {
        public b() {
        }

        public final d a(int r1, int r10) {
            return this;
        }

        public final d b(int r1, String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            return this;
        }

        public final d c(int r1, int r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            return this;
        }

        public final void commit() {
        }

        public final d d(int r1) {
            return this;
        }
    }

    static {
        e = new a();
        d = new LinkedHashMap();
    }

    public final d a() {
        AsyncInflaterImpl r0 = this.a;
        if (r0 == null) goto L7;
        return new AsyncInflaterImpl.b(r0, false);
    L7:
        return new b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Activity r0 = this.b;
        if (r0 == null) goto L6;
        e.getClass();
        d.remove(r0);
        return;
    }

    public final boolean b(int r10) {
        AsyncInflaterImpl r0 = this.a;
        if (r0 == null) goto L14;
        LinkedList r11 = (LinkedList) r0.a.get(Integer.valueOf(r10));
        if (r11 == null) goto L17;
        monitor-enter(r11);
        boolean r1 = !r11.isEmpty();
        monitor-exit(r11);
        return r1;
    L11:
        th = move-exception;
        throw th;
    L17:
        return false;
    L14:
        return false;
    }

    public ShoppingAsyncInflater(AsyncInflaterImpl r1, Activity r10, Context r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final View aU(int r10, ViewGroup r11, boolean r12) {
        AsyncInflaterImpl r0 = this.a;
        if (r0 == null) goto L7;
        View r1 = r0.aU(r10, r11, r12);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return th.a.c(this.c, r10, r11, r12);
    }
}
