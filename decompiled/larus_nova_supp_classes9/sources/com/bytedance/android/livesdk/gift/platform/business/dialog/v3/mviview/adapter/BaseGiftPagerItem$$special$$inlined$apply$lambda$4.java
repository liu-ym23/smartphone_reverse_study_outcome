package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.EndScrollGiftVerticalPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftListFirstScreenChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftListItemCompletelyVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftListItemVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StartScrollGiftVerticalPanel;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.performance.PerformanceEventKitUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/BaseGiftPagerItem$recyclerView$1$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseGiftPagerItem$$special$$inlined$apply$lambda$4 extends RecyclerView.OnScrollListener {
    public final Handler a;
    public final a b;
    public int c;
    public final /* synthetic */ RecyclerView d;
    public final /* synthetic */ Ref.BooleanRef e;
    public final /* synthetic */ BaseGiftPagerItem f;

    public static final class a implements Runnable {
        public final /* synthetic */ BaseGiftPagerItem$$special$$inlined$apply$lambda$4 a;

        public a(BaseGiftPagerItem$$special$$inlined$apply$lambda$4 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseGiftPagerItem$$special$$inlined$apply$lambda$4 r0 = this.a;     // Catch: Throwable -> L4
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

    public final void onScrollStateChanged(RecyclerView r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        this.c = r6;
        if (r6 == 0) goto L27;
        if (r6 != 1) goto L6;
        IntRange r7 = new IntRange(0, 0);
        RecyclerView.Adapter r2 = r5.getAdapter();
        if (r2 == null) goto L12;
        int r3 = r2.getItemCount();
    L14:
        if (r3 <= 12) goto L23;
        LinearLayoutManager r8 = r5.getLayoutManager();
        if ((r8 instanceof LinearLayoutManager) == true) goto L18;
        LinearLayoutManager r9 = null;
    L20:
        if (r9 != null) goto L22;
        r7 = new IntRange(-1, -1);
        goto L23
    L22:
        LinearLayoutManager r10 = r8;
        r7 = new IntRange(r10.findFirstVisibleItemPosition(), r10.findLastVisibleItemPosition());
        goto L23
    L18:
        r9 = r8;
    L23:
        HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r11 = GiftPreloadManager.a;
        BaseGiftPagerItem r4 = this.f;
        GiftPreloadManager.b(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.h.C0045h(r4.v, r4.E, r7));
        BaseGiftPagerItem r13 = this.f;
        r13.v = false;
        if (r13.q <= 0) goto L26;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.b.class).requestBlockGc(this.f.q);
    L26:
        PerformanceEventKitUtil.INSTANCE.trigger("scroll", Boolean.TRUE);
        BaseGiftPagerItem r14 = this.f;
        r14.o(new StartScrollGiftVerticalPanel(r14.E));
        return;
    L12:
        r3 = 0;
        goto L14
    L6:
        if (r6 != 2) goto L31;
        this.a.postDelayed(this.b, 20);
        return;
    L31:
        return;
    L27:
        this.e.element = true;
        BaseGiftPagerItem r15 = this.f;
        r15.o(new EndScrollGiftVerticalPanel(r15.E));
        PerformanceEventKitUtil.INSTANCE.trigger("scroll", Boolean.FALSE);
    }

    public BaseGiftPagerItem$$special$$inlined$apply$lambda$4(RecyclerView r1, Ref.BooleanRef r2, BaseGiftPagerItem r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.a = new Handler();
        this.b = new a(this);
        this.c = -1;
    }

    public final void onScrolled(RecyclerView r10, int r11, int r13) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        this.a.removeCallbacks(this.b);
        if (this.c != 2) goto L5;
        this.a.postDelayed(this.b, 20);
    L5:
        LinearLayoutManager r2 = null;
        if (this.f.s() == false) goto L25;
        BaseGiftPagerItem r14 = this.f;
        RecyclerView.LayoutManager r3 = r14.y.getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == true) goto L10;
        r3 = null;
    L10:
        LinearLayoutManager r4 = (LinearLayoutManager) r3;
        if (r4 != null) goto L13;
    L21:
        boolean r15 = false;
    L23:
        if (r14.t == r15) goto L25;
        r14.t = r15;
        r14.o(new OnGiftListFirstScreenChanged(r14.E, r15));
        goto L25
    L13:
        if (r14.w == false) goto L15;
        float r16 = UtilityKotlinExtentionsKt.h(58);
    L17:
        if (m02.e.a(r4, r14.y, 50, r14.s()) != 0) goto L21;
        if (r14.y.computeVerticalScrollOffset() >= r16) goto L21;
        r15 = true;
        goto L23
    L15:
        r16 = UtilityKotlinExtentionsKt.h(58) / 2;
    L25:
        BaseGiftPagerItem r17 = this.f;
        boolean r18 = r17.u;
        RecyclerView.LayoutManager r5 = r17.y.getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == true) goto L28;
        r5 = null;
    L28:
        LinearLayoutManager r6 = (LinearLayoutManager) r5;
        if (r6 == null) goto L31;
        IntRange r7 = new IntRange(m02.e.a(r6, r17.y, 50, r17.s()), m02.e.c(r6, r17.y, 50, r17.s()));
    L33:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == false) goto L38;
        if ((!Intrinsics.areEqual(r7, (IntRange) ((LinkedHashMap) r17.D).get(Long.valueOf(r17.C)))) == false) goto L40;
        r17.D.put(Long.valueOf(r17.C), r7);
        r17.o(new OnGiftListItemVisibleChanged(r17.E, r7, r17.F, r18));
    L40:
        BaseGiftPagerItem r19 = this.f;
        r19.getClass();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.E.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[29])).booleanValue() == true) goto L54;
        LinearLayoutManager r110 = r19.y.getLayoutManager();
        if ((r110 instanceof LinearLayoutManager) == false) goto L47;
        r2 = r110;
    L47:
        LinearLayoutManager r8 = r2;
        if (r8 == null) goto L50;
        IntRange r1 = new IntRange(r8.findFirstCompletelyVisibleItemPosition(), r8.findLastCompletelyVisibleItemPosition());
    L52:
        if ((!Intrinsics.areEqual(r1, r19.o)) == false) goto L54;
        r19.o = r1;
        r19.o(new OnGiftListItemCompletelyVisibleChanged(r19.E, r1));
        goto L54
    L50:
        r1 = new IntRange(-1, -1);
    L54:
        this.f.u = false;
        return;
    L38:
        if ((!Intrinsics.areEqual(r7, r17.n)) == false) goto L40;
        r17.n = r7;
        r17.o(new OnGiftListItemVisibleChanged(r17.E, r7, r17.F, r18));
        goto L40
    L31:
        r7 = new IntRange(-1, -1);
        goto L33
    }
}
