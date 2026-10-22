package com.bytedance.android.livesdk.feed;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.HotsoonAd;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveFeedRoomPlayComponent extends BaseFeedRoomPlayComponent {
    public String l;
    public b m;
    public a n;
    public final h o;
    public boolean p;
    public long q;

    public class a extends BaseFeedRoomPlayComponent.d {
        public final /* synthetic */ LiveFeedRoomPlayComponent g;

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.d
        public final int[] k() {
            int[] r0 = {-1, -1};
            RecyclerView r1 = this.g.a;
            if (r1 != null) goto L5;
            return r0;
        L5:
            int r2 = r1.getLayoutManager().findFirstVisibleItemPosition();
            int r3 = this.g.a.getLayoutManager().findLastVisibleItemPosition();
            if (r2 == (-1)) goto L33;
            if (r3 == (-1)) goto L33;
            int r4 = this.g.a.getHeight();
        L10:
            if (r2 > r3) goto L33;
            View r5 = this.g.a.getLayoutManager().findViewByPosition(r2);
            float r6 = (r5.getBottom() - r5.getTop()) * 0.7f;
            int r7 = (int) (r4 - r6);
            if (r5.getTop() <= 0) goto L28;
            if (r5.getTop() > r7) goto L28;
            FeedItem r8 = this.g.b.D2(r2);
            if (r8 == null) goto L28;
            int r9 = r8.type;
            if (r9 != 1) goto L21;
            r0[1] = r2;
            goto L28
        L21:
            if (r9 != 3) goto L28;
            if ((r8.getItem() instanceof HotsoonAd) == false) goto L28;
            if (r8.getItem().getVideoInfo() == null) goto L28;
            r0[1] = r2;
        L28:
            if (r5.getBottom() <= 0) goto L32;
            if (r5.getBottom() >= r6) goto L32;
            r0[0] = r2;
        L32:
            r2 = r2 + 1;
        L33:
            return r0;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.d
        public final void n() {
            View r0 = this.g.a.getLayoutManager().findViewByPosition(this.a);
            if (r0 != null) goto L5;
        L20:
            this.g.d.setVisibility(4);
            this.g.g();
            return;
        L5:
            if (r0.getBottom() <= 0) goto L20;
            if (this.g.a.getParent() == null) goto L20;
            final ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) this.g.d.getLayoutParams();
            r1.topMargin = (r0.getBottom() - r1.height) + ((View) this.g.a.getParent()).getPaddingTop();
            r1.rightMargin = this.g.a.getPaddingRight() + s1.f(1.0f);
            if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId() != ThreadMethodProxy.currentThread().getId()) goto L18;
            this.g.d.setLayoutParams(r1);
            Activity r2 = this.g.e;
            if (r2 != null) goto L14;
            return;
        L14:
            if (r2.getWindow() != null) goto L16;
            return;
        L16:
            if (p(this.g.e.getWindow()) == null) goto L24;
            p(this.g.e.getWindow()).requestLayout();
            return;
        L24:
            return;
        L18:
            this.g.d.post(new a1(this, r1));
        }

        public a(LiveFeedRoomPlayComponent r1) {
            this.g = r1;
            super(r1);
        }

        public static View p(Window r3) {
            View r4 = r3.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r0, "getDecorView");
        L7:
            return r4;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.d
        public final void j(int[] r25) {
            a r0 = this;
            super.j(r25);
            FeedItem r1 = r0.g.b.D2(r25[1]);
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.type != 1) goto L29;
            Room r2 = r1.getItem();
            if (r0.c.get(Long.valueOf(r2.getId())) == null) goto L9;
            return;
        L9:
            r0.c.put(Long.valueOf(r2.getId()), Long.valueOf(System.currentTimeMillis()));
            HashMap r3 = new HashMap();
            r3.put("enter_from_merge", "live_merge");
            r3.put("enter_method", "live_cover");
            r3.put("log_pb", r2.getLog_pb());
            r3.put("anchor_id", r2.getOwnerUserIdString());
            r3.put("request_id", r2.getRequestId());
            r3.put("room_id", String.valueOf(r2.getId()));
            String r4 = "show_type";
            r3.put("show_type", "stay");
            r3.put("event_belong", "live_view");
            r3.put("event_page", "live");
            Object r16 = "event_page";
            r3.put("event_type", "core");
            Object r17 = "event_type";
            Object r18 = "core";
            String r14 = "click";
            r3.put("action_type", "click");
            kw1.c.d("live_cover_show", r3);
            String r20 = "live_cover_show";
            int r5 = r25[1];
            if (r5 == (-1)) goto L30;
        L11:
            if (r5 <= 0) goto L31;
            int r6 = r5 - 1;
            FeedItem r7 = r0.g.b.D2(r6);
            if (r7 == null) goto L23;
            int r26 = r6;
            String r21 = r14;
            if (r7.type != 1) goto L21;
            Room r8 = r7.getItem();
            if (r0.c.get(Long.valueOf(r8.getId())) != null) goto L21;
            if (r0.d.get(Long.valueOf(r8.getId())) != null) goto L21;
            r0.d.put(Long.valueOf(r8.getId()), Long.valueOf(System.currentTimeMillis()));
            HashMap r9 = new HashMap();
            r9.put("enter_from_merge", "live_merge");
            r9.put("enter_method", "live_cover");
            r9.put("log_pb", r8.getLog_pb());
            r9.put("anchor_id", r8.getOwnerUserIdString());
            r9.put("request_id", r8.getRequestId());
            r9.put("room_id", String.valueOf(r8.getId()));
            r9.put(r4, "streak");
            r9.put("event_belong", "live_view");
            Object r10 = r16;
            r9.put(r10, "live");
            r17 = r17;
            r18 = r18;
            r9.put(r17, r18);
            Object r19 = r10;
            r9.put("event_module", this.g.l);
            String r11 = r21;
            r9.put("action_type", r11);
            String r12 = r20;
            kw1.c.d(r12, r9);
        L24:
            r0 = this;
            r20 = r12;
            r18 = r18;
            r4 = r4;
            r16 = r19;
            r14 = r11;
            r17 = r17;
            r5 = r26;
        L21:
            r11 = r21;
        L22:
            r19 = r16;
            r12 = r20;
            goto L24
        L23:
            r26 = r6;
            r11 = r14;
            goto L22
        L31:
            return;
        L30:
            return;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.d
        public final int l(boolean r6) {
            RecyclerView r7 = this.g.a;
            if (r7 != null) goto L5;
            return -1;
        L5:
            int r8 = r7.getLayoutManager().findFirstVisibleItemPosition();
            int r1 = this.g.a.getLayoutManager().findLastVisibleItemPosition();
            if (r8 == (-1)) goto L29;
            if (r1 == (-1)) goto L29;
            int r2 = this.g.a.getHeight() / 2;
        L10:
            if (r8 > r1) goto L29;
            View r3 = this.g.a.getLayoutManager().findViewByPosition(r8);
            if (r3.getTop() > r2) goto L17;
            if (r3.getBottom() < r2) goto L17;
            return r8;
        L17:
            if (r3.getTop() <= r2) goto L28;
            int r4 = r8 - 1;
            if (r4 < 0) goto L28;
            View r0 = this.g.a.getLayoutManager().findViewByPosition(r4);
            if (r0 != null) goto L24;
            return r8;
        L24:
            if ((r3.getTop() - r2) >= (r2 - r0.getBottom())) goto L27;
            return r8;
        L27:
            return r4;
        L28:
            r8 = r8 + 1;
        L29:
            return -1;
        }
    }

    public class b extends BaseFeedRoomPlayComponent.d {
        public final Random g;
        public final List<Integer> h;
        public final List<Integer> i;
        public final a j;
        public final /* synthetic */ LiveFeedRoomPlayComponent k;

        public class a extends Handler {
            public final /* synthetic */ b a;

            @Override // android.os.Handler
            public final void handleMessage(Message r2) {
                super.handleMessage(r2);
                b r3 = this.a;
                if (r3.k.h == true) goto L5;
                return;
            L5:
                if (r3.l(false) != (-1)) goto L9;
                this.a.l(true);
                return;
            }

            public a(b r1, Looper r2) {
                this.a = r1;
                super(r2);
            }
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.d
        public final void n() {
            Logger.d("SmallPerspectiveWindow", "layoutSurfaceContainer() called");
            View r0 = this.k.a.getLayoutManager().findViewByPosition(this.a);
            if (r0 != null) goto L5;
        L11:
            this.k.d.setVisibility(4);
            this.k.g();
            return;
        L5:
            if (r0.getBottom() <= 0) goto L11;
            if (this.k.a.getParent() == null) goto L11;
            ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) this.k.d.getLayoutParams();
            r1.topMargin = r0.getTop() + ((View) this.k.a.getParent()).getPaddingTop();
            r1.rightMargin = (((((View) this.k.a.getParent()).getWidth() - r0.getLeft()) - r0.getWidth()) - this.k.a.getPaddingLeft()) + this.k.a.getPaddingRight();
            this.k.d.setLayoutParams(r1);
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.d
        public final void o() {
            Logger.d("SmallPerspectiveWindow", "reset() called");
            super.o();
            ((ArrayList) this.h).clear();
            ((ArrayList) this.i).clear();
            this.j.removeCallbacksAndMessages(null);
        }

        public b(LiveFeedRoomPlayComponent r2) {
            this.k = r2;
            super(r2);
            this.g = new Random();
            this.h = new ArrayList();
            this.i = new ArrayList();
            this.j = new a(this, Looper.getMainLooper());
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.d
        public final int l(boolean r9) {
            Logger.d("SmallPerspectiveWindow", "findPlayPosition() called");
            if (this.k.a != null) goto L6;
            return -1;
        L6:
            if (Lists.isEmpty(this.h) == false) goto L21;
            Logger.d("SmallPerspectiveWindow", "getValidItems() called");
            if (Lists.isEmpty(this.h) == false) goto L21;
            GridLayoutManager r0 = this.k.a.getLayoutManager();
            int r4 = r0.getChildCount();
            int r5 = 0;
        L11:
            if (r5 >= r4) goto L21;
            View r6 = r0.getChildAt(r5);
            if (r0.isViewPartiallyVisible(r6, true, true) == false) goto L19;
            int r7 = this.k.a.getChildAdapterPosition(r6);
            FeedItem r8 = this.k.b.D2(r7);
            if (r8 == null) goto L19;
            if (r8.type != 1) goto L19;
            ((ArrayList) this.h).add(Integer.valueOf(r7));
        L19:
            r5 = r5 + 1;
        L21:
            if (Lists.isEmpty(this.i) == false) goto L24;
            ((ArrayList) this.i).addAll(this.h);
        L24:
            if (((ArrayList) this.i).contains(Integer.valueOf(this.a)) == false) goto L29;
            ((ArrayList) this.i).remove(Integer.valueOf(this.a));
            if (r9 == false) goto L29;
            return this.a;
        L29:
            Logger.d("SmallPerspectiveWindow", "findPlayPosition() called -> " + this.i);
        L31:
            if (((ArrayList) this.i).size() <= 0) goto L49;
            Integer r10 = (Integer) ListProtector.remove(this.i, this.g.nextInt(((ArrayList) this.i).size()));
            FeedItem r1 = this.f.b.D2(r10.intValue());
            if (r1 != null) goto L35;
        L37:
            Room r2 = null;
        L38:
            if (r2 == null) goto L31;
            if (r2.getMosaicStatus() != 0) goto L31;
            if (r2.isLiveTypeAudio() == true) goto L31;
            if (r2.getStatus() != 2) goto L31;
            return r10.intValue();
        L35:
            if (r1.type != 1) goto L37;
            r2 = (Room) r1.getItem();
            goto L38
        L49:
            return -1;
        }

        @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent.d
        public final void onScrolled(RecyclerView r1, int r2, int r3) {
            super.onScrolled(r1, r2, r3);
            ((ArrayList) this.h).clear();
            ((ArrayList) this.i).clear();
        }
    }

    @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent
    public final boolean a() {
        if (this.p == false) goto L6;
        return false;
    L6:
        return true;
    }

    public final BaseFeedRoomPlayComponent.d f() {
        if (this.p == false) goto L10;
        if (this.m != null) goto L8;
        this.m = new b(this);
    L8:
        return this.m;
    L10:
        if (this.n != null) goto L13;
        this.n = new a(this);
    L13:
        return this.n;
    }

    public final void g() {
        if (this.q >= 0) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("event_belong", "live_view");
        r0.put("event_page", "live");
        h r1 = this.o;
        if (r1 != null) goto L8;
    L10:
        r0.put("enter_from_merge", "live_merge");
        r0.put("enter_method", "live_cover");
        r0.put("event_module", this.l);
        BaseFeedRoomPlayComponent.d r2 = this.f;
        if (r2 != null) goto L13;
    L15:
        r0.put("duration", String.valueOf(System.currentTimeMillis() - this.q));
        r0.put("action_type", "click");
        com.bytedance.android.livesdk.log.filter.m0.J(r0);
        kw1.c.d("live_window_duration", r0);
        this.q = -1;
        return;
    L13:
        if (r2.m() == null) goto L15;
        Room r3 = this.f.m();
        r0.put("log_pb", r3.getLog_pb());
        r0.put("anchor_id", String.valueOf(r3.getOwnerUserIdString()));
        r0.put("request_id", r3.getRequestId());
        r0.put("room_id", String.valueOf(r3.getId()));
        int r4 = h1.a;
        r0.put("live_type", i1.a(r3.getStreamType()));
        r0.putAll(h1.a(r3));
        goto L15
    L8:
        if (r1.wg() == null) goto L10;
        this.l = this.o.wg().e();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent
    public final void b() {
        g();
    }

    public final void h(boolean r5) {
        this.p = r5;
        if (a() == true) goto L9;
        RecyclerView r6 = this.a;
        if (r6 == null) goto L29;
        BaseFeedRoomPlayComponent.d r0 = this.f;
        if (r0 == null) goto L30;
        r6.removeOnScrollListener(r0);
        this.f.o();
        return;
    L30:
        return;
    L29:
        return;
    L9:
        RecyclerView r7 = this.a;
        if (r7 == null) goto L21;
        BaseFeedRoomPlayComponent.d r1 = this.f;
        if (r1 == null) goto L15;
        r7.removeOnScrollListener(r1);
        this.f.o();
        this.b.unregisterAdapterDataObserver(this.j);
    L15:
        BaseFeedRoomPlayComponent.d r8 = f();
        this.f = r8;
        if (r8 == null) goto L21;
        this.a.addOnScrollListener(r8);
        this.b.registerAdapterDataObserver(this.j);
        BannerSwipeRefreshLayout r9 = this.c;
        if (r9 == null) goto L20;
        r9.setStartEndRefreshListener(new com.bytedance.android.livesdk.feed.b(this));
    L20:
        boolean r10 = true;
    L22:
        if (r10 == true) goto L25;
        return;
    L25:
        if (this.f.b <= 0) goto L27;
        e();
    L27:
        d();
        return;
    L21:
        r10 = false;
        goto L22
    }

    public LiveFeedRoomPlayComponent(BaseFeedRoomPlayComponent.c r2, h r3) {
        super(r2);
        this.p = false;
        this.l = r2.T2();
        this.o = r3;
    }
}
