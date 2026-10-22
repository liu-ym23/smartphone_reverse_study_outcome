package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StartScrollGiftSearchPanel;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.performance.PerformanceEventKitUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/GiftMVISearchView$onAttach$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftMVISearchView$onAttach$$inlined$apply$lambda$1 extends RecyclerView.OnScrollListener {
    public final Handler a;
    public final a b;
    public int c;
    public final /* synthetic */ RecyclerView d;
    public final /* synthetic */ GiftMVISearchView e;

    public static final class a implements Runnable {
        public final /* synthetic */ GiftMVISearchView$onAttach$$inlined$apply$lambda$1 a;

        public a(GiftMVISearchView$onAttach$$inlined$apply$lambda$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GiftMVISearchView$onAttach$$inlined$apply$lambda$1 r0 = this.a;     // Catch: Throwable -> L4
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

    public GiftMVISearchView$onAttach$$inlined$apply$lambda$1(RecyclerView r1, GiftMVISearchView r2) {
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
        PerformanceEventKitUtil.INSTANCE.trigger("scroll", Boolean.TRUE);
        return;
    L5:
        if (r4 == 1) goto L11;
        if (r4 != 2) goto L18;
        this.a.postDelayed(this.b, 20);
        return;
    L18:
        return;
    L11:
        if (this.e.r <= 0) goto L13;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.b.class).requestBlockGc(this.e.r);
    L13:
        PerformanceEventKitUtil.INSTANCE.trigger("scroll", Boolean.FALSE);
        this.e.o(new StartScrollGiftSearchPanel());
    }

    public final void onScrolled(RecyclerView r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        this.a.removeCallbacks(this.b);
        if (this.c != 2) goto L5;
        this.a.postDelayed(this.b, 20);
    L5:
        this.e.t();
    }
}
