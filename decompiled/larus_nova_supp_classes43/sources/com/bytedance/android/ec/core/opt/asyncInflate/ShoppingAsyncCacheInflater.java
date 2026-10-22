package com.bytedance.android.ec.core.opt.asyncInflate;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.opt.asyncInflate.AsyncCacheInflaterImpl;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import com.bytedance.android.ec.sdk.plugin.e;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0003\u001a\u00020\u0002H\u0017¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/opt/asyncInflate/ShoppingAsyncCacheInflater;", "Lcom/bytedance/android/ec/opt/asyncInflate/ICachedAsyncInflater;", "", "onDestroy", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShoppingAsyncCacheInflater implements ICachedAsyncInflater {
    public static final Map<Activity, ShoppingAsyncCacheInflater> d = null;
    public final AsyncCacheInflaterImpl a;
    public final Activity b;
    public final Context c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater$a$a, reason: collision with other inner class name */
        public static final class RunnableC0143a implements Runnable {
            public final /* synthetic */ ShoppingAsyncCacheInflater a;
            public final /* synthetic */ Activity b;

            public RunnableC0143a(ShoppingAsyncCacheInflater r1, Activity r10) {
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

        public static ShoppingAsyncCacheInflater a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Activity r0 = e.getActivity(r10);
            if ((r0 instanceof LifecycleOwner) == false) goto L8;
            Map<Activity, ShoppingAsyncCacheInflater> r1 = ShoppingAsyncCacheInflater.d;
            ShoppingAsyncCacheInflater r11 = (ShoppingAsyncCacheInflater) ((LinkedHashMap) r1).get(r0);
            if (r11 != null) goto L9;
            ShoppingAsyncCacheInflater r12 = new ShoppingAsyncCacheInflater(new AsyncCacheInflaterImpl(r0), r0, r10);
            new Handler(Looper.getMainLooper()).post(new RunnableC0143a(r12, r0));
            r1.put(r0, r12);
            return r12;
        L9:
            return r11;
        L8:
            return new ShoppingAsyncCacheInflater(null, null, r10);
        }
    }

    public static final class b implements com.bytedance.android.ec.opt.asyncInflate.b {
        public b() {
        }

        public final com.bytedance.android.ec.opt.asyncInflate.b a(int r1, int r10) {
            return this;
        }

        public final String commit() {
            return "";
        }
    }

    static {
        d = new LinkedHashMap();
    }

    public final com.bytedance.android.ec.opt.asyncInflate.b a() {
        AsyncCacheInflaterImpl r0 = this.a;
        if (r0 == null) goto L7;
        r0.getClass();
        return new AsyncCacheInflaterImpl.InflateTransactionImpl(r0);
    L7:
        return new b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        AsyncCacheInflaterImpl r0 = this.a;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        Activity r1 = this.b;
        if (r1 == null) goto L9;
        d.remove(r1);
        return;
    }

    public final View b(String r10, ICachedAsyncInflater.b r11) {
        Intrinsics.checkNotNullParameter(r10, "layoutId");
        AsyncCacheInflaterImpl r0 = this.a;
        View r1 = null;
        if (r0 == null) goto L5;
        View r12 = r0.c(r10, r11);
    L6:
        if (r12 != null) goto L15;
        Activity r13 = this.b;
        if (r13 == null) goto L14;
        if (r11 == null) goto L11;
        r1 = r11.a(r13);
    L11:
        if (r1 == null) goto L14;
        return r1;
    L14:
        throw new Exception("[Django] >> AsyncCacheInflater: no view and no viewCreator, name = " + r10 + ", activity = " + this.b);
    L15:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    public ShoppingAsyncCacheInflater(AsyncCacheInflaterImpl r1, Activity r10, Context r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final View aU(int r10, ViewGroup r11, boolean r12) {
        AsyncCacheInflaterImpl r13 = this.a;
        if (r13 == null) goto L41;
        CopyOnWriteArraySet r1 = (CopyOnWriteArraySet) r13.a.get(Integer.valueOf(r10));
        if (r1 == null) goto L11;
        View r14 = AsyncCacheInflaterImpl.e(r1, false);
        if (r14 == null) goto L11;
        StringBuilder r15 = new StringBuilder("[Django] >> AsyncCacheInflater: preloadViewCaches has view, name = ");
        Map r16 = r13.f;
        LinkedHashMap r17 = (LinkedHashMap) r16;
        r15.append((String) r17.get(Integer.valueOf(r10)));
        String r18 = r15.toString();
        System.out.println(r18);
        r13.d(Integer.valueOf(r10), r14);
        if (r11 == null) goto L39;
        r11.addView(r14);
    L38:
        r14 = r11;
    L39:
        if (r14 == null) goto L41;
        return r14;
    L11:
        CopyOnWriteArraySet r19 = (CopyOnWriteArraySet) r13.b.get(Integer.valueOf(r10));
        if (r19 == null) goto L16;
        r14 = AsyncCacheInflaterImpl.e(r19, true);
        if (r14 == null) goto L16;
        StringBuilder r20 = new StringBuilder("[Django] >> AsyncCacheInflater: viewHolderItemViewCaches has view, name = ");
        Map r21 = r13.f;
        LinkedHashMap r22 = (LinkedHashMap) r21;
        r20.append((String) r22.get(Integer.valueOf(r10)));
        String r23 = r20.toString();
        System.out.println(r23);
        r13.d(Integer.valueOf(r10), r14);
    L16:
        CopyOnWriteArraySet r24 = (CopyOnWriteArraySet) r13.c.get(Integer.valueOf(r10));
        if (r24 == null) goto L23;
        r14 = AsyncCacheInflaterImpl.e(r24, true);
        if (r14 == null) goto L23;
        StringBuilder r25 = new StringBuilder("[Django] >> AsyncCacheInflater: statefulViewCaches has view, name = ");
        Map r26 = r13.f;
        LinkedHashMap r27 = (LinkedHashMap) r26;
        r25.append((String) r27.get(Integer.valueOf(r10)));
        String r28 = r25.toString();
        System.out.println(r28);
        r13.d(Integer.valueOf(r10), r14);
        if (r11 == null) goto L39;
        r11.addView(r14);
    L23:
        CopyOnWriteArraySet r29 = (CopyOnWriteArraySet) r13.d.get(Integer.valueOf(r10));
        if (r29 == null) goto L31;
        r14 = AsyncCacheInflaterImpl.e(r29, true);
        if (r14 == null) goto L31;
        StringBuilder r30 = new StringBuilder("[Django] >> AsyncCacheInflater: statelessViewCaches has view, name = ");
        Map r31 = r13.f;
        LinkedHashMap r32 = (LinkedHashMap) r31;
        r30.append((String) r32.get(Integer.valueOf(r10)));
        String r33 = r30.toString();
        System.out.println(r33);
        r13.d(Integer.valueOf(r10), r14);
        if (r11 == null) goto L39;
        r11.addView(r14);
    L31:
        if (r13.f.containsKey(Integer.valueOf(r10)) == false) goto L33;
        StringBuilder r34 = new StringBuilder("[Django] >> AsyncCacheInflater: no view, name = ");
        Map r35 = r13.f;
        LinkedHashMap r36 = (LinkedHashMap) r35;
        r34.append((String) r36.get(Integer.valueOf(r10)));
        String r37 = r34.toString();
        System.out.println(r37);
    L33:
        r14 = LayoutInflater.from(r13.k).cloneInContext(r13.k).inflate(r10, r11, false);
        if (r13.f.containsKey(Integer.valueOf(r10)) == false) goto L36;
        r13.d(Integer.valueOf(r10), r14);
    L36:
        if (r11 == null) goto L39;
        r11.addView(r14);
    L41:
        return th.a.c(this.c, r10, r11, true);
    }
}
