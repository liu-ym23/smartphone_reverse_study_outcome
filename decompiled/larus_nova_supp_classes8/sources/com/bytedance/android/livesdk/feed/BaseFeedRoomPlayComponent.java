package com.bytedance.android.livesdk.feed;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseFeedRoomPlayComponent implements LifecycleObserver {
    public final RecyclerView a;
    public final BaseFeedAdapter b;
    public final BannerSwipeRefreshLayout c;
    public final ViewGroup d;
    public final Activity e;
    public d f;
    public final zw1.a g;
    public boolean h;
    public boolean i;
    public final a j;
    public final b k;

    public class a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ BaseFeedRoomPlayComponent a;

        public final void onChanged() {
            super.onChanged();
            b(true);
        }

        public a(BaseFeedRoomPlayComponent r1) {
            this.a = r1;
        }

        public final void b(boolean r9) {
            BaseFeedRoomPlayComponent r0 = this.a;
            d r1 = r0.f;
            boolean r2 = false;
            if (r1 != null) goto L5;
        L7:
            boolean r3 = false;
        L9:
            if (r0.b.getItemCount() > 0) goto L11;
            r2 = true;
        L11:
            this.a.getClass();
            if (r3 == false) goto L15;
            if (r2 == false) goto L15;
            this.a.e();
            return;
        L15:
            if (r3 == true) goto L18;
            if (r2 == true) goto L18;
            this.a.d();
            return;
        L18:
            if (r3 == false) goto L24;
            if (r9 == false) goto L25;
            this.a.e();
            this.a.d();
            return;
        L25:
            return;
        L24:
            return;
        L5:
            if (r1.b <= 0) goto L7;
            r3 = true;
            goto L9
        }

        public final void onItemRangeInserted(int r1, int r2) {
            super.onItemRangeInserted(r1, r2);
            if (r1 > this.a.f.a) goto L5;
            boolean r3 = true;
        L6:
            b(r3);
            return;
        L5:
            r3 = false;
            goto L6
        }

        public final void onItemRangeRemoved(int r1, int r2) {
            super.onItemRangeRemoved(r1, r2);
            if (r1 > this.a.f.a) goto L5;
            boolean r3 = true;
        L6:
            b(r3);
            return;
        L5:
            r3 = false;
            goto L6
        }

        public final void onItemRangeMoved(int r1, int r2, int r3) {
            super.onItemRangeMoved(r1, r2, r3);
            int r4 = this.a.f.a;
            if (r1 <= r4) goto L7;
            if (r2 <= r4) goto L7;
            boolean r5 = false;
        L8:
            b(r5);
            return;
        L7:
            r5 = true;
            goto L8
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ BaseFeedRoomPlayComponent a;

        public final void a() {
            BaseFeedRoomPlayComponent r0 = this.a;
            if (r0.h == true) goto L5;
            return;
        L5:
            if (r0.i == false) goto L20;
            RecyclerView r1 = r0.a;
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.getAdapter() != null) goto L11;
            return;
        L11:
            if (this.a.a.getAdapter().getItemCount() != 0) goto L14;
            return;
        L14:
            if (this.a.a() == false) goto L23;
            BaseFeedRoomPlayComponent r2 = this.a;
            d r3 = r2.f;
            if (r3 == null) goto L24;
            r3.onScrollStateChanged(r2.a, 0);
            return;
        L24:
            return;
        L23:
            return;
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

        public b(BaseFeedRoomPlayComponent r1) {
            this.a = r1;
        }
    }

    public interface c {
        FragmentActivity P2();

        zw1.a Q2();

        RecyclerView R2();

        BannerSwipeRefreshLayout S2();

        String T2();

        View U2();

        BaseFeedAdapter adapter();

        Lifecycle lifecycle();
    }

    public abstract class d extends RecyclerView.OnScrollListener {
        public int a;
        public long b;
        public final LinkedHashMap<Long, Long> c;
        public final LinkedHashMap<Long, Long> d;
        public final LinkedHashMap<Long, Long> e;
        public final /* synthetic */ BaseFeedRoomPlayComponent f;

        public int[] k() {
            return new int[]{-1, -1};
        }

        public abstract int l(boolean r1);

        public abstract void n();

        public void o() {
            this.a = -1;
            this.b = -1;
            ViewGroup r0 = this.f.d;
            if (r0 == null) goto L5;
            r0.setVisibility(4);
        L5:
            this.f.b();
        }

        public final Room m() {
            FeedItem r0 = this.f.b.D2(this.a);
            if (r0 != null) goto L5;
            return null;
        L5:
            if (r0.type == 1) goto L7;
            return null;
        L7:
            return r0.getItem();
        }

        public d(BaseFeedRoomPlayComponent r3) {
            this.f = r3;
            this.a = -1;
            this.b = -1;
            this.c = new LinkedHashMap();
            this.d = new LinkedHashMap();
            this.e = new LinkedHashMap();
        }

        public void j(int[] r3) {
            BaseFeedRoomPlayComponent r0 = this.f;
            if (r0.h == true) goto L5;
            return;
        L5:
            if (r0.i == false) goto L9;
            int r4 = r3[1];
            return;
        }

        public final void onScrollStateChanged(RecyclerView r3, int r4) {
            super.onScrollStateChanged(r3, r4);
            if (r4 == 0) goto L5;
            return;
        L5:
            if (this.f.h == false) goto L10;
            Logger.i("RoomPlayComponent", "event_v3 live_show: newPlayPosition--:" + l(true));
            int[] r5 = k();
            Logger.i("RoomPlayComponent", "event_v3 live_show: frogPos--:" + r5);
            j(r5);
            return;
        }

        public void onScrolled(RecyclerView r1, int r2, int r3) {
            super.onScrolled(r1, r2, r3);
            ViewGroup r4 = this.f.d;
            if (r4 != null) goto L5;
        L7:
            n();
            return;
        L5:
            if (r4.getVisibility() == 0) goto L7;
        }
    }

    public abstract boolean a();

    public abstract void b();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.h = false;
        if (a() == true) goto L5;
        return;
    L5:
        if (this.i == false) goto L9;
        e();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.h = true;
        d();
    }

    public final void e() {
        RecyclerView r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.k);
    L5:
        ViewGroup r1 = this.d;
        if (r1 == null) goto L8;
        r1.setVisibility(4);
    L8:
        b();
        d r2 = this.f;
        if (r2 == null) goto L12;
        r2.o();
        return;
    }

    public final void d() {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.h == true) goto L7;
        return;
    L7:
        if (this.i == false) goto L12;
        this.a.removeCallbacks(this.k);
        this.a.postDelayed(this.k, 1000);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.e.isFinishing() == false) goto L9;
        e();
        return;
    }

    public BaseFeedRoomPlayComponent(c r3) {
        this.h = false;
        this.i = false;
        this.j = new a(this);
        this.k = new b(this);
        this.d = (ViewGroup) r3.U2();
        RecyclerView r0 = r3.R2();
        this.a = r0;
        r0.getLayoutManager();
        this.b = r3.adapter();
        this.c = r3.S2();
        this.e = r3.P2();
        r3.T2();
        r3.lifecycle().addObserver(this);
        new WeakReference(r3.lifecycle());
        this.g = r3.Q2();
    }

    public final void c(boolean r2) {
        if (this.i != r2) goto L5;
        return;
    L5:
        this.i = r2;
        if (r2 == false) goto L9;
        d();
        return;
    L9:
        if (a() == true) goto L11;
        return;
    L11:
        if (this.h == false) goto L16;
        e();
        return;
    }
}
