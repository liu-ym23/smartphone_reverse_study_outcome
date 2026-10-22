package com.bytedance.android.livesdk.interactivity.like;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.config.f2;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.like.view.CustomDiggTapView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x0 extends com.bytedance.android.livesdk.interactivity.like.view.a {
    public CustomDiggTapView d;
    public final ArrayList<ImageModel> e;
    public boolean f;
    public final ArrayList<Integer> g;
    public final SparseArray<Bitmap> h;
    public final Set<Bitmap> i;
    public final Room j;
    public long k;
    public Disposable l;
    public CompositeDisposable m;
    public int n;

    public static final class a {
    }

    static {
    }

    public final String getSpm() {
        return "a100.a100.a175";
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a
    public View getView() {
        return this;
    }

    @Override // v32.b
    public final Bitmap a() {
        if ((!this.i.isEmpty()) == true) goto L5;
    L7:
        Bitmap r1 = null;
        if (getContext() != null) goto L11;
    L21:
        return r1;
    L11:
        if (this.g.isEmpty() == true) goto L21;
        int r0 = ((Number) CollectionsKt.random(this.g, Random.Default)).intValue();
        Context r2 = getContext();
        if (r2 == null) goto L21;
        Resources r3 = r2.getResources();
        if (r3 == null) goto L21;
        r1 = this.h.get(r0);
        if (r1 != null) goto L21;
        BitmapFactory.Options r4 = new BitmapFactory.Options();
        r4.inPreferredConfig = Bitmap.Config.ARGB_4444;
        Unit r5 = Unit.INSTANCE;
        r1 = BitmapFactory.decodeResource(r3, r0, r4);
        this.h.put(r0, r1);
        goto L21
    L5:
        if (this.f == false) goto L7;
        return (Bitmap) CollectionsKt.random(this.i, Random.Default);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public View getTapView() {
        CustomDiggTapView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public final void clear() {
        super.clear();
        int r0 = this.h.size() - 1;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.h.valueAt(r1).recycle();
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public final void init() {
        Context r0 = getContext();
        if (r0 == null) goto L27;
        this.d = new CustomDiggTapView(r0);
        Resources r1 = r0.getResources();
        if (r1 == null) goto L18;
        Room r2 = this.j;
        if (r2 != null) goto L9;
    L14:
        TypedArray r3 = r1.obtainTypedArray(2130903116);
        int r4 = r3.length();
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L17;
        this.g.add(Integer.valueOf(r3.getResourceId(r5, 0)));
        r5 = r5 + 1;
        goto L15
    L17:
        r3.recycle();
        goto L18
    L9:
        if (r2.isMediaRoom() != true) goto L14;
        TypedArray r6 = r1.obtainTypedArray(2130903120);
        int r7 = r6.length();
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L13;
        this.g.add(Integer.valueOf(r6.getResourceId(r8, 0)));
        r8 = r8 + 1;
        goto L11
    L13:
        r6.recycle();
    L18:
        int r9 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.b(getSpm(), "Start Fetch Digg Icon");
        Room r10 = this.j;
        if (r10 == null) goto L23;
        long r11 = r10.getRoomId();
        Disposable r13 = ((DiggApi) com.bytedance.android.live.network.c.b().e(DiggApi.class)).getIcons(r11).subscribeOn(Schedulers.io()).flatMap(new y0(this)).filter(z0.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new a1(this), new b1(this), new c1(this));
        CompositeDisposable r14 = this.m;
        if (r14 == null) goto L23;
        r14.add(r13);
    L23:
        super.init();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public final void load() {
        super.load();
        this.m = new CompositeDisposable();
        CustomDiggTapView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");
    L5:
        boolean r1 = r0 instanceof com.bytedance.android.livesdk.interactivity.like.view.z;
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public final void unload() {
        super.unload();
        CompositeDisposable r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        CompositeDisposable r1 = this.m;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        CustomDiggTapView r2 = this.d;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");
    L12:
        if ((r2 instanceof com.bytedance.android.livesdk.interactivity.like.view.z) == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L17;
        r2.clear();
        return;
    }

    public final Room getRoom() {
        return this.j;
    }

    public x0(Context r1, DataCenter r2) {
        super(r1, r2);
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.h = new SparseArray();
        this.i = Collections.newSetFromMap(new ConcurrentHashMap());
        if (r2 == null) goto L5;
        Room r3 = com.bytedance.android.live.core.utils.z.o(r2);
    L6:
        this.j = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // v32.b
    public final boolean b(PointF r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "point");
        long r1 = ((Long) f2.a.getValue()).longValue();
        Intrinsics.checkNotNullParameter(r8, "point");
        long r3 = SystemClock.elapsedRealtime();
        boolean r0 = true;
        if (r9 == false) goto L23;
        if ((r3 - this.k) > r1) goto L20;
        Disposable r10 = this.l;     // Catch: Throwable -> L42
        if (r10 == null) goto L9;
        r10.dispose();     // Catch: Throwable -> L42
    L9:
        this.l = Observable.timer(r1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d1(this));     // Catch: Throwable -> L42
        this.n++;     // Catch: Throwable -> L42
        Iterator<v32.a> r11 = getControllerList().iterator();     // Catch: Throwable -> L42
    L11:
        if (r11.hasNext() == false) goto L15;
        v32.a r2 = r11.next();     // Catch: Throwable -> L42
        if ((r2 instanceof v32.c) == false) goto L11;
        ((v32.c) r2).a(r8, this.n);     // Catch: Throwable -> L42
        goto L11
    L15:
        DiggContext.a r13 = DiggContext.Companion;     // Catch: Throwable -> L42
        DataCenter r14 = getDataCenter();     // Catch: Throwable -> L42
        r13.getClass();     // Catch: Throwable -> L42
        DiggContext r15 = DiggContext.a.a(r14);     // Catch: Throwable -> L42
        if (r15 == null) goto L21;
        com.bytedance.live.datacontext.m<Long> r16 = r15.getDiggTime();     // Catch: Throwable -> L42
        if (r16 == null) goto L21;
        r16.setValue(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L42
    L21:
        this.k = r3;
        return r0;
    L20:
        r0 = false;
        this.n = 0;     // Catch: Throwable -> L42
        goto L21
    L23:
        if ((r3 - this.k) > r1) goto L25;
        this.n++;     // Catch: Throwable -> L42
    L26:
        Disposable r17 = this.l;     // Catch: Throwable -> L42
        if (r17 == null) goto L29;
        r17.dispose();     // Catch: Throwable -> L42
    L29:
        this.l = Observable.timer(r1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e1(this));     // Catch: Throwable -> L42
        Iterator<v32.a> r18 = getControllerList().iterator();     // Catch: Throwable -> L42
    L31:
        if (r18.hasNext() == false) goto L35;
        v32.a r4 = r18.next();     // Catch: Throwable -> L42
        if ((r4 instanceof v32.c) == false) goto L31;
        ((v32.c) r4).a(r8, this.n);     // Catch: Throwable -> L42
        goto L31
    L35:
        DiggContext.a r19 = DiggContext.Companion;     // Catch: Throwable -> L42
        DataCenter r20 = getDataCenter();     // Catch: Throwable -> L42
        r19.getClass();     // Catch: Throwable -> L42
        DiggContext r21 = DiggContext.a.a(r20);     // Catch: Throwable -> L42
        if (r21 == null) goto L21;
        com.bytedance.live.datacontext.m<Long> r23 = r21.getDiggTime();     // Catch: Throwable -> L42
        if (r23 == null) goto L21;
        r23.setValue(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L42
        goto L21
    L25:
        this.n = 1;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.k = r3;
        throw th;
    }
}
