package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.EndScrollGiftVerticalPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftCounterItemVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftCounterVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftListFirstScreenChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StartScrollGiftVerticalPanel;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.performance.PerformanceEventKitUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/GiftCounterPageItem$recyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftCounterPageItem$$special$$inlined$apply$lambda$1 extends RecyclerView.OnScrollListener {
    public final Handler a;
    public final a b;
    public int c;
    public final /* synthetic */ RecyclerView d;
    public final /* synthetic */ GiftCounterPageItem e;

    public static final class a implements Runnable {
        public final /* synthetic */ GiftCounterPageItem$$special$$inlined$apply$lambda$1 a;

        public a(GiftCounterPageItem$$special$$inlined$apply$lambda$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GiftCounterPageItem$$special$$inlined$apply$lambda$1 r0 = this.a;     // Catch: Throwable -> L4
            r0.c = -1;     // Catch: Throwable -> L4
            r0.d.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public GiftCounterPageItem$$special$$inlined$apply$lambda$1(RecyclerView r1, GiftCounterPageItem r2) {
        this.d = r1;
        this.e = r2;
        this.a = new Handler();
        this.b = new a(this);
        this.c = -1;
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        this.c = r4;
        if (r4 != 0) goto L5;
        GiftCounterPageItem r5 = this.e;
        r5.o(new EndScrollGiftVerticalPanel(((com.bytedance.android.anya.c) r5).i));
        PerformanceEventKitUtil.INSTANCE.trigger("scroll", Boolean.FALSE);
        return;
    L5:
        if (r4 == 1) goto L11;
        if (r4 != 2) goto L18;
        this.a.postDelayed(this.b, 20);
        return;
    L18:
        return;
    L11:
        if (this.e.n <= 0) goto L13;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.b.class).requestBlockGc(this.e.n);
    L13:
        PerformanceEventKitUtil.INSTANCE.trigger("scroll", Boolean.TRUE);
        GiftCounterPageItem r6 = this.e;
        r6.o(new StartScrollGiftVerticalPanel(((com.bytedance.android.anya.c) r6).i));
    }

    public final void onScrolled(RecyclerView r11, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "recyclerView");
        this.a.removeCallbacks(this.b);
        if (this.c != 2) goto L5;
        this.a.postDelayed(this.b, 20);
    L5:
        super.onScrolled(r11, r13, r14);
        if (this.e.s() == false) goto L21;
        GiftCounterPageItem r15 = this.e;
        RecyclerView.LayoutManager r2 = r15.q.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == true) goto L10;
        r2 = null;
    L10:
        LinearLayoutManager r3 = (LinearLayoutManager) r2;
        if (r3 != null) goto L13;
    L17:
        boolean r1 = false;
    L19:
        if (r15.p == r1) goto L21;
        r15.p = r1;
        r15.o(new OnGiftListFirstScreenChanged(((com.bytedance.android.anya.c) r15).i, r1));
        goto L21
    L13:
        if (m02.e.a(r3, r15.q, 50, r15.s()) != 0) goto L17;
        if (r15.q.computeVerticalScrollOffset() >= (UtilityKotlinExtentionsKt.h(58) / 2)) goto L17;
        r1 = true;
    L21:
        GiftCounterPageItem r16 = this.e;
        RecyclerView.LayoutManager r4 = r16.q.getLayoutManager();
        if ((r4 instanceof LinearLayoutManager) == true) goto L24;
        r4 = null;
    L24:
        LinearLayoutManager r5 = (LinearLayoutManager) r4;
        if (r5 == null) goto L59;
        IntRange r6 = new IntRange(r5.findFirstVisibleItemPosition(), r5.findLastVisibleItemPosition());
        if ((!Intrinsics.areEqual(r16.l, r6)) == false) goto L30;
        r16.o(new OnGiftCounterVisibleChanged(((com.bytedance.android.anya.c) r16).i, r6));
        r16.l = r6;
    L30:
        if ((!Intrinsics.areEqual(r6, new IntRange(-1, -1))) == false) goto L60;
        LinkedHashMap r7 = new LinkedHashMap();
        IntIterator r8 = r6.iterator();
    L33:
        if (r8.hasNext() == false) goto L47;
        int r9 = r8.nextInt();
        View r10 = r5.findViewByPosition(r9);
        if (r10 == null) goto L33;
        RecyclerView r17 = r10.findViewById(2131373779);
        if (r17 == null) goto L33;
        RecyclerView.LayoutManager r18 = r17.getLayoutManager();
        if ((r18 instanceof LinearLayoutManager) == true) goto L43;
        r18 = null;
    L43:
        LinearLayoutManager r19 = (LinearLayoutManager) r18;
        if (r19 == null) goto L33;
        r7.put(Integer.valueOf(r9), new IntRange(m02.e.a(r19, r16.q, 50, r16.s()), m02.e.c(r19, r16.q, 50, r16.s())));
        goto L33
    L47:
        if ((true ^ r7.isEmpty()) == false) goto L61;
        r16.o(new OnGiftCounterItemVisibleChanged(((com.bytedance.android.anya.c) r16).i, r7));
        return;
    L61:
        return;
    L60:
        return;
    }
}
