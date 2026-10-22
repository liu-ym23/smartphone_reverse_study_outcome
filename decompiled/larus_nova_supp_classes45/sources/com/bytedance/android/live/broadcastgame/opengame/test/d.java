package com.bytedance.android.live.broadcastgame.opengame.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.e0;
import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends FrameLayout {
    public Disposable a;
    public final ArrayList<com.bytedance.android.live.broadcastgame.opengame.test.a> b;
    public final LinkedList<String> c;
    public final RecyclerView d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public int m;
    public int n;
    public float o;
    public final /* synthetic */ i20.a p;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ViewGroup a;

        public a(ViewGroup r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.getVisibility() != 0) goto L5;
            this.a.setVisibility(8);
            return;
        L5:
            this.a.setVisibility(0);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (Intrinsics.areEqual((Boolean) sh6.c.b((sh6.b) r2), Boolean.FALSE) == false) goto L6;
            d r3 = this.a;
            r3.e = 0.0f;
            r3.f = 0.0f;
            r3.m = 0;
            r3.n = 0;
            return;
        }
    }

    public static class c {
        public c() {
        }

        public c(int r1) {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.test.d$d, reason: collision with other inner class name */
    public static final class C0087d {
    }

    public static final class e extends c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;

        public e(String r2, String r3, String r4, String r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "avgCpu");
            Intrinsics.checkNotNullParameter(r3, "avgMem");
            Intrinsics.checkNotNullParameter(r4, "avgStutter");
            Intrinsics.checkNotNullParameter(r5, "avgFps");
            Intrinsics.checkNotNullParameter(r6, "lowFpsRate");
            Intrinsics.checkNotNullParameter(r7, "maxTemperature");
            super(0);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class f extends c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public f(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "cpu");
            Intrinsics.checkNotNullParameter(r3, "mem");
            Intrinsics.checkNotNullParameter(r4, "stutter");
            Intrinsics.checkNotNullParameter(r5, "fps");
            Intrinsics.checkNotNullParameter(r6, "temperature");
            super(0);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class g<T> implements ObservableOnSubscribe {
        public final /* synthetic */ d a;

        public g(d r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<c> r21) {
            Intrinsics.checkNotNullParameter(r21, "it");
            float r2 = d.a(this.a).b();
            float r3 = d.a(this.a).c();
            float r4 = d.a(this.a).a();
            float r5 = d.a(this.a).getUIStallRate();
            float r6 = d.a(this.a).d();
            AnchorGameContext.Companion.getClass();
            AnchorGameContext r7 = AnchorGameContext.a.a();
            if (r7 == null) goto L9;
            m<Boolean> r8 = r7.getOpenGamePerfUploadState();
            if (r8 == null) goto L9;
            if (((Boolean) r8.getValue()).booleanValue() != true) goto L9;
            this.a.getClass();
            String r12 = d.b(r3);
            StringCompanionObject r9 = StringCompanionObject.INSTANCE;
            String r13 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r4)}, 1));
            this.a.getClass();
            r21.onNext(new f(r12, r13, d.b(r5), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r2)}, 1)), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r6)}, 1))));
        L16:
            r21.onComplete();
            return;
        L9:
            d r11 = this.a;
            int r14 = r11.m + 1;
            r11.m = r14;
            float r15 = r11.g + r3;
            r11.g = r15;
            float r16 = r14;
            float r17 = r15 / r16;
            float r18 = r11.i + r4;
            r11.i = r18;
            r11.h = r18 / r16;
            float r19 = r11.k + r5;
            r11.k = r19;
            r11.j = r19 / r16;
            float r22 = r11.f + r2;
            r11.f = r22;
            r11.e = r22 / r16;
            if (r6 <= r11.l) goto L13;
            r11.l = r6;
        L13:
            if (r2 >= 13) goto L15;
            r11.n++;
        L15:
            r11.o = r11.n / r16;
            String r110 = d.b(r17);
            StringCompanionObject r23 = StringCompanionObject.INSTANCE;
            r21.onNext(new e(r110, String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.a.h)}, 1)), d.b(this.a.j), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.a.e)}, 1)), d.b(this.a.o), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.a.l)}, 1))));
            goto L16
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ d a;

        public h(d r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            c r5 = (c) r4;
            this.a.c.clear();
            if ((r5 instanceof f) == false) goto L6;
            LinkedList<String> r0 = this.a.c;
            StringBuilder r1 = new StringBuilder("CPU(瞬时): ");
            f r6 = (f) r5;
            r1.append(r6.a);
            r0.add(r1.toString());
            this.a.c.add("内存(MB)(瞬时) : " + r6.b);
            this.a.c.add("卡顿率(瞬时) : " + r6.c);
            this.a.c.add("推流帧率(瞬时) : " + r6.d);
            this.a.c.add("温度(瞬时): " + r6.e);
        L8:
            RecyclerView.Adapter r7 = this.a.d.getAdapter();
            if (r7 == null) goto L12;
            r7.notifyDataSetChanged();
            return;
        L12:
            return;
        L6:
            if ((r5 instanceof e) == false) goto L8;
            LinkedList<String> r2 = this.a.c;
            StringBuilder r3 = new StringBuilder("CPU(均值): ");
            e r8 = (e) r5;
            r3.append(r8.a);
            r2.add(r3.toString());
            this.a.c.add("内存(MB)(均值) : " + r8.b);
            this.a.c.add("卡顿率(均值): " + r8.c);
            this.a.c.add("推流帧率(均值): " + r8.d);
            this.a.c.add("推流帧率低值占比: " + r8.e);
            this.a.c.add("温度最大值: " + r8.f);
            goto L8
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final void accept(Object r2) {
            ALogger.d("OpenPlatformPerformancePanel", ((Throwable) r2).toString());
        }
    }

    static {
    }

    public final void c() {
        Disposable r0 = Observable.create(new g(this)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this), i.a);
        Intrinsics.checkNotNullParameter(r0, "$this$autoDispose");
        this.p.a(r0);
    }

    private final e0 getOpenPlatformPerfProvider() {
        return OpenPlatformPerfDog.p;
    }

    public static final /* synthetic */ e0 a(d r0) {
        return r0.getOpenPlatformPerfProvider();
    }

    public static String b(float r2) {
        if (r2 >= 0) goto L9;
        r2 = 0.0f;
    L9:
        NumberFormat r0 = NumberFormat.getPercentInstance();     // Catch: ParseException -> L7
        r0.setMaximumFractionDigits(2);     // Catch: ParseException -> L7
        return r0.format(Float.valueOf(r2));
    L7:
        return "0";
    }

    public d(Context r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "rootView");
        super(r8);
        i20.a r0 = new i20.a();
        this.p = r0;
        ArrayList<com.bytedance.android.live.broadcastgame.opengame.test.a> r1 = new ArrayList();
        this.b = r1;
        LinkedList<String> r2 = new LinkedList();
        this.c = r2;
        setVisibility(8);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(s1.f(185), -2);
        r3.topMargin = s1.f(176);
        r3.rightMargin = s1.f(10);
        r3.gravity = 8388613;
        r9.addView(this, r3);
        View r11 = FrameLayout.inflate(r8, 2131567092, null);
        RecyclerView r4 = r11.findViewById(2131368532);
        r4.setAdapter(new GroupDataAdapter(r1, r8));
        r4.setLayoutManager(new LinearLayoutManager(r8, 1, false));
        Unit r12 = Unit.INSTANCE;
        this.d = r4;
        ((TextView) r11.findViewById(2131388772)).setOnClickListener(new a((ViewGroup) r11.findViewById(2131368534)));
        addView(r11);
        r1.add(new com.bytedance.android.live.broadcastgame.opengame.test.a(r2));
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r13 = AnchorGameContext.a.a();
        if (r13 == null) goto L12;
        n<Boolean> r14 = r13.getHasOpenGameLaunch();
        if (r14 == null) goto L13;
        Observable r15 = r14.a();
        if (r15 == null) goto L14;
        Disposable r16 = r15.subscribe(new b(this));
        if (r16 == null) goto L15;
        Intrinsics.checkNotNullParameter(r16, "$this$autoDispose");
        r0.a(r16);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
