package com.bytedance.android.live.ktv.common.midi;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/KtvMidiView;", "Landroid/widget/RelativeLayout;", "", "interval", "", "setScoreInterval", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiView extends RelativeLayout {
    public Map<Integer, View> a;
    public long b;
    public db0.a c;
    public Disposable d;
    public ValueAnimator e;
    public int f;
    public int g;
    public Disposable h;
    public long i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final int n;
    public final int o;
    public final int p;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvMidiView a;
        public final /* synthetic */ long b;

        public b(KtvMidiView r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            KSongToneLinesView r0 = (KSongToneLinesView) this.a.a(2131389045);
            long r1 = this.b;
            r0.d(r1, (List) r4);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ KtvMidiView b;

        public d(int r1, KtvMidiView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ValueAnimator r0 = this.b.e;
            if (r0 != null) goto L5;
        L6:
            KtvMidiView r1 = this.b;
            if (r1.j != this.a) goto L10;
            return;
        L10:
            if (KtvSettingHelper.o() == false) goto L12;
            ValueAnimator r2 = LiveDegradeFpsAnimator.ofFloat(this.b.a(2131389046), LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{this.b.j, this.a}).setFpsConfig(2);
        L13:
            r1.e = r2;
            KtvMidiView r3 = this.b;
            int r4 = r3.j;
            int r5 = this.a;
            if (r4 <= r5) goto L18;
            ValueAnimator r6 = r3.e;
            if (r6 == null) goto L21;
            r6.setDuration(100);
        L21:
            ValueAnimator r7 = this.b.e;
            if (r7 == null) goto L24;
            r7.start();
        L24:
            this.b.j = this.a;
            return;
        L18:
            ValueAnimator r8 = r3.e;
            if (r8 == null) goto L21;
            r8.setDuration(Math.max((long) (Math.abs(r4 - r5) * 4.0f), 100));
            goto L21
        L12:
            r2 = ObjectAnimator.ofFloat(this.b.a(2131389046), LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{this.b.j, this.a});
            goto L13
        L5:
            if (r0.isRunning() != true) goto L6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KtvMidiView a;

        public e(KtvMidiView r1) {
            this.a = r1;
        }

        public final void accept(Object r18) {
            cb0.c r1 = (cb0.c) r18;
            List<cb0.a> r2 = r1.c;
            if (r2 != null) goto L5;
            r2 = new CopyOnWriteArrayList();
        L5:
            KtvMidiView r4 = this.a;
            long r5 = r4.b;
            r2.add(new cb0.a(r5, Math.min(r4.i + r5, r1.a.b)));
            KtvMidiView r3 = this.a;
            r3.getClass();
            int r6 = 1;
            if (r2.size() <= 1) goto L16;
            CopyOnWriteArrayList r7 = new CopyOnWriteArrayList();
            long r8 = ((cb0.a) ListProtector.get(r2, 0)).a;
            long r9 = ((cb0.a) ListProtector.get(r2, 0)).b;
            cb0.a r11 = new cb0.a(r8, r9);
            r7.add(r11);
            int r12 = r2.size();
        L9:
            if (r6 >= r12) goto L15;
            cb0.a r13 = (cb0.a) ListProtector.get(r2, r6);
            long r14 = r13.a;
            List<cb0.a> r19 = r2;
            KtvMidiView r16 = r3;
            if (r14 > ((r3.i * ((long) 2)) + r9)) goto L13;
            long r15 = Math.max(r13.b, r9);
            r11.b = r15;
        L14:
            r9 = r15;
            r6 = r6 + 1;
            r2 = r19;
            r3 = r16;
            goto L9
        L13:
            r15 = r13.b;
            r11 = new cb0.a(r14, r15);
            r7.add(r11);
            goto L14
        L15:
            r2 = r7;
        L16:
            r1.c = r2;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    static {
    }

    public KtvMidiView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvMidiView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void d() {
        Disposable r0 = this.h;
        if (r0 != null) goto L5;
    L9:
        db0.a r1 = this.c;
        if (r1 == null) goto L13;
        this.h = r1.findMidiSegment(this.b).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this), f.a);
        return;
    L13:
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r2 = this.h;
        if (r2 == null) goto L9;
        r2.dispose();
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.h;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        ValueAnimator r2 = this.e;
        if (r2 == null) goto L12;
        r2.cancel();
        return;
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void b(long r6) {
        this.b = r6;
        Disposable r0 = this.d;
        if (r0 != null) goto L5;
    L9:
        db0.a r1 = this.c;
        if (r1 == null) goto L16;
        Single<List<cb0.c>> r2 = r1.findMidiSegments(r6 - 800, 4000 + r6);
        if (r2 != null) goto L14;
        return;
    L14:
        this.d = r2.compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r6), c.a);
        return;
    L16:
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r3 = this.d;
        if (r3 == null) goto L9;
        r3.dispose();
        goto L9
    }

    public final int c(float r3) {
        int r0 = this.l % this.o;
        this.l = r0 + 1;
        if (r0 != 0) goto L20;
        if (getVisibility() != 0) goto L20;
        if (r3 >= this.f) goto L10;
    L13:
        int r1 = this.m + 1;
        this.m = r1;
        if (r1 < this.p) goto L16;
    L17:
        int r4 = ((KSongToneLinesView) a(2131389045)).f((int) r3) - this.n;
        this.k = r4;
        ((ImageView) a(2131389046)).post(new d(r4, this));
        return r4;
    L16:
        return this.k;
    L10:
        if (r3 > this.g) goto L13;
        this.m = 0;
    L20:
        return this.k;
    }

    public final void setScoreInterval(long r1) {
        this.i = r1;
    }

    public KtvMidiView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = new LinkedHashMap();
        this.f = 58;
        this.g = 90;
        this.i = ((Number) vm2.h.A1.getValue(null, vm2.h.a[129(0x81, float:1.81E-43)])).longValue();
        this.n = s1.f(5.0f);
        this.o = vm2.h.H();
        this.p = vm2.h.J();
        RelativeLayout.inflate(r3, 2131566501, this);
        ((KSongToneLinesView) a(2131389045)).e(800, 4000);
    }

    public /* synthetic */ KtvMidiView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
