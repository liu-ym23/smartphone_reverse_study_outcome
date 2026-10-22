package com.bytedance.android.live.broadcastgame.xplay.perf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0011\u0012B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/perf/XplayPerfPanelView;", "Landroid/widget/FrameLayout;", "Lj20/c;", "", "isVisible", "", "setPerformancePanelVisible", "Landroid/view/View;", "getView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayPerfPanelView extends FrameLayout implements j20.c {
    public static final m20.a o = null;
    public final RecyclerView a;
    public final ImageView b;
    public final List<String> c;
    public Disposable d;
    public Disposable e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public boolean m;
    public final OpenPlatformPerfDog n;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ XplayPerfPanelView a;
        public final /* synthetic */ View b;

        public a(XplayPerfPanelView r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            XplayPerfPanelView r3 = this.a;
            boolean r0 = !r3.m;
            r3.m = r0;
            if (r0 == false) goto L7;
            ImageView r4 = r3.b;
            if (r4 == null) goto L10;
            r4.setImageResource(2131250940);
        L10:
            View r5 = this.b.findViewById(2131388772);
            if (r5 == null) goto L13;
            UtilityKotlinExtentionsKt.v(r5, this.a.m);
        L13:
            View r6 = this.b.findViewById(2131368534);
            if (r6 == null) goto L16;
            UtilityKotlinExtentionsKt.v(r6, this.a.m);
        L16:
            View r7 = this.b.findViewById(2131369232);
            if (r7 == null) goto L20;
            UtilityKotlinExtentionsKt.v(r7, this.a.m);
            return;
        L20:
            return;
        L7:
            ImageView r8 = r3.b;
            if (r8 == null) goto L10;
            r8.setImageResource(2131251244);
            goto L10
        }
    }

    public static final class b {
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L18;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r11 = this.d;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (r9 + r12) * 31;
            String r14 = this.e;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.f;
            if (r17 == null) goto L26;
            r1 = r17.hashCode();
        L26:
            return r16 + r1;
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "DebugPerfData(avgCpu=" + this.a + ", avgGpu=" + this.b + ", avgMem=" + this.c + ", avgStutter=" + this.d + ", avgFps=" + this.e + ", maxTemperature=" + this.f + ")";
        }

        public c(String r2, String r3, String r4, String r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "avgCpu");
            Intrinsics.checkNotNullParameter(r3, "avgGpu");
            Intrinsics.checkNotNullParameter(r4, "avgMem");
            Intrinsics.checkNotNullParameter(r5, "avgStutter");
            Intrinsics.checkNotNullParameter(r6, "avgFps");
            Intrinsics.checkNotNullParameter(r7, "maxTemperature");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ XplayPerfPanelView a;

        public d(XplayPerfPanelView r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            XplayPerfPanelView r6 = this.a;
            m20.a r0 = XplayPerfPanelView.o;
            r6.getClass();
            r6.e = Observable.create(new m20.b(r6)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m20.c(r6), m20.d.a);
        }
    }

    public XplayPerfPanelView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public XplayPerfPanelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // j20.c
    public View getView() {
        return this;
    }

    static {
        o = new m20.a(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setPerformancePanelVisible(false);
    }

    @Override // j20.c
    public void setPerformancePanelVisible(boolean r5) {
        if (r5 == true) goto L4;
    L6:
        int r0 = 0;
        if (r5 == false) goto L9;
        setVisibility(0);
        this.d = Observable.interval(0, 5, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this));
        return;
    L9:
        this.l = 0;
        float[] r1 = new float[6];
        r1[0] = this.f;
        r1[1] = this.g;
        r1[2] = this.h;
        r1[3] = this.i;
        r1[4] = this.j;
        r1[5] = this.k;
    L10:
        if (r0 >= 6) goto L12;
        r1[r0] = 0.0f;
        r0 = r0 + 1;
        goto L10
    L12:
        setVisibility(8);
        Disposable r6 = this.d;
        if (r6 == null) goto L15;
        r6.dispose();
    L15:
        this.d = null;
        Disposable r7 = this.e;
        if (r7 == null) goto L21;
        r7.dispose();
        return;
    L21:
        return;
    L4:
        if (getVisibility() != 0) goto L6;
    }

    public XplayPerfPanelView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        ArrayList r7 = new ArrayList();
        this.c = r7;
        this.m = true;
        this.n = OpenPlatformPerfDog.p;
        setVisibility(8);
        View r0 = FrameLayout.inflate(r4, 2131568054, this);
        ImageView r1 = (ImageView) r0.findViewById(2131376107);
        r1.setOnClickListener(new a(this, r0));
        Unit r2 = Unit.INSTANCE;
        this.b = r1;
        RecyclerView r3 = r0.findViewById(2131368532);
        r3.setAdapter(new GroupDataAdapter(r7, r4));
        r3.setLayoutManager(new LinearLayoutManager(r4, 1, false));
        this.a = r3;
    }

    public static String a(XplayPerfPanelView r4, float r5, int r6) {
        r4.getClass();
        float r7 = r5 / r6;
        float r8 = (float) Math.pow(10.0f, 2);
        return String.valueOf(((int) ((r7 * r8) + 0.5f)) / r8);
    }

    public /* synthetic */ XplayPerfPanelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
