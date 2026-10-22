package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.f;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftPanelViewPreloadService implements o {
    public static final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a j = null;
    public static final boolean k = false;
    public static final a l = null;
    public final IRoom a;
    public final CompositeDisposable b;
    public boolean c;
    public final boolean d;
    public AsyncLayoutInflater e;
    public GiftPanelPreloadViewModel f;
    public final LinkedList<ItemListData> g;
    public final Context h;
    public final k i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelViewPreloadService$PreloadSource;", BuildConfig.FLAVOR, "CLICK_ACTION_DOWN", "OPEN_RECHARGE_PANEL", "ENTER_ROOM_DELAY", "CLOSE_PANEL", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PreloadSource extends Enum<PreloadSource> {
        public static final PreloadSource CLICK_ACTION_DOWN = null;
        public static final PreloadSource CLOSE_PANEL = null;
        public static final PreloadSource ENTER_ROOM_DELAY = null;
        public static final PreloadSource OPEN_RECHARGE_PANEL = null;
        public static final /* synthetic */ PreloadSource[] a = null;

        static {
            PreloadSource r1 = new PreloadSource("CLICK_ACTION_DOWN", 0);
            CLICK_ACTION_DOWN = r1;
            PreloadSource r2 = new PreloadSource("OPEN_RECHARGE_PANEL", 1);
            OPEN_RECHARGE_PANEL = r2;
            PreloadSource r3 = new PreloadSource("ENTER_ROOM_DELAY", 2);
            ENTER_ROOM_DELAY = r3;
            PreloadSource r4 = new PreloadSource("CLOSE_PANEL", 3);
            CLOSE_PANEL = r4;
            a = new PreloadSource[]{r1, r2, r3, r4};
        }

        public static PreloadSource valueOf(String r1) {
            return (PreloadSource) r27.a.a(PreloadSource.class, r1);
        }

        public static PreloadSource[] values() {
            return (PreloadSource[]) a.clone();
        }

        public PreloadSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }

        public static View a(int r4) {
            if (GiftPanelViewPreloadService.k == false) goto L6;
            HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r0 = GiftPreloadManager.a;
            return (View) GiftPreloadManager.a(new f.b(r4));
        L6:
            i12.e r1 = i12.o.b();
            Object r2 = null;
            if (r1 == null) goto L9;
            Object r3 = m.e.d(r1, GiftPanelViewPreloadService.class);
        L10:
            GiftPanelViewPreloadService r5 = (GiftPanelViewPreloadService) r3;
            if (r5 == null) goto L37;
            GiftPanelPreloadViewModel r6 = r5.f;
            if (r6 == null) goto L15;
            View r7 = r6.getViewByLayoutId(r4);
        L16:
            GiftPanelPreloadViewModel r8 = r5.f;
            if (r8 == null) goto L19;
            GiftPanelPreloadView r9 = r8.getViewTypeByLayoutId(r4);
        L20:
            if (r7 != null) goto L22;
            return null;
        L22:
            if (r9 != GiftPanelPreloadView.GiftSearchView) goto L26;
            if (r5.d == false) goto L26;
        L29:
            i12.d r10 = i12.m.e2.a();
            if (r10 == null) goto L32;
            r2 = m.e.d(r10, GiftPanelMonitorService.class);
        L32:
            GiftPanelMonitorService r11 = (GiftPanelMonitorService) r2;
            if (r11 == null) goto L36;
            r11.n = true;
        L36:
            return r7;
        L26:
            if (r9 != GiftPanelPreloadView.VerticalPageItem) goto L36;
            if (r5.d == true) goto L36;
        L19:
            r9 = null;
            goto L20
        L15:
            r7 = null;
            goto L16
        L37:
            return null;
        L9:
            r3 = null;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GiftPanelViewPreloadService a;

        public b(GiftPanelViewPreloadService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.a(PreloadSource.ENTER_ROOM_DELAY);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftPanelViewPreloadService a;
        public final /* synthetic */ PreloadSource b;

        public c(GiftPanelViewPreloadService r1, PreloadSource r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            PreloadSource r11 = (PreloadSource) r10;
            GiftPanelPreloadViewModel r13 = this.a.f;
            if (r13 != null) goto L5;
        L7:
            StringBuilder r14 = new StringBuilder("start preload views, viewTypeCnt=");
            GiftPanelPreloadView.Companion.getClass();
            r14.append(((List) GiftPanelPreloadView.access$getAllViews$cp().getValue()).size());
            r14.append(" source=");
            r14.append(this.b);
            jy0.b.d("ttlive_gift_preload", r14.toString());
            Iterator<T> r15 = ((List) GiftPanelPreloadView.access$getAllViews$cp().getValue()).iterator();
        L9:
            if (r15.hasNext() == false) goto L91;
            GiftPanelPreloadView r1 = (GiftPanelPreloadView) r15.next();
            GiftPanelViewPreloadService r2 = this.a;
            PreloadSource r3 = this.b;
            GiftPanelPreloadViewModel r4 = r2.f;
            if (r4 == null) goto L13;
            int r5 = r4.getCachedViewCount(r1);
        L15:
            if (r5 >= r1.getCount()) goto L17;
            if (r1.isPanelView() == false) goto L26;
            if (GiftPanelViewPreloadService.j.g() == false) goto L9;
        L26:
            if (r1.isGiftItemView() == false) goto L30;
            if (GiftPanelViewPreloadService.j.f() == false) goto L9;
        L30:
            PreloadSource r6 = PreloadSource.CLICK_ACTION_DOWN;
            if (r3 != r6) goto L35;
            if (r1.getSupportTouchDown() == false) goto L9;
        L35:
            if (r3 == r6) goto L40;
            if (r1.getOnlyTouchDown() == true) goto L9;
        L40:
            if (r3 != PreloadSource.ENTER_ROOM_DELAY) goto L45;
            if (r1.isPanelView() == false) goto L9;
        L45:
            if (r3 != PreloadSource.CLOSE_PANEL) goto L49;
            if (r1.isPanelView() == false) goto L9;
        L49:
            int r7 = r1.getCount() - r5;
            if (1 > r7) goto L9;
            int r8 = 1;
        L53:
            if (r1.getHasParent() == false) goto L55;
            FrameLayout r9 = new FrameLayout(r2.h);
        L56:
            AsyncLayoutInflater r16 = r2.e;
            if (r16 == null) goto L59;
            r16.inflate(r1.getLayoutId(), r9, new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.b(r2, r1));
        L59:
            if (r8 == r7) goto L9;
            r8 = r8 + 1;
            goto L53
        L55:
            r9 = null;
            goto L56
        L17:
            if (r1.isPanelView() == false) goto L20;
            if (r1.getOnlyTouchDown() == false) goto L9;
        L20:
            r1.toString();
            goto L9
        L13:
            r5 = 0;
            goto L15
        L91:
            return;
        L5:
            if (r13.isCacheFull() != true) goto L7;
            jy0.b.d("ttlive_gift_preload", "intercept preInflate, view cache is already full");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ GiftPanelViewPreloadService a;

        public d(GiftPanelViewPreloadService r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            PreloadSource r7 = (PreloadSource) r6;
            long r0 = System.currentTimeMillis();
            ArrayList r8 = new ArrayList(500);
            int r3 = this.a.g.size();
        L3:
            if (r3 >= 500) goto L5;
            r8.add(new ItemListData());
            r3 = r3 + 1;
            goto L3
        L5:
            this.a.g.addAll(r8);
            jy0.b.d("ttlive_gift_preload", "itemListDataCache size=" + this.a.g.size() + " cost=" + (System.currentTimeMillis() - r0));
        }
    }

    public final void onStart() {
        this.c = true;
        this.e = new AsyncLayoutInflater(this.h);
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.h);
        if (r1 == null) goto L5;
        this.f = (GiftPanelPreloadViewModel) ViewModelProviders.of(r1).get(GiftPanelPreloadViewModel.class);
    L5:
        IBaseUser r2 = this.a.getOwner();
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.isFollowing() != true) goto L12;
        Disposable r0 = Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        this.b.add(r0);
        return;
    }

    static {
        l = new a();
        j = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a) GiftPreloadSettingsKt.b.getValue(null, GiftPreloadSettingsKt.a[0]);
        k = ((Boolean) GiftPreloadSettingsKt.f.getValue()).booleanValue();
    }

    public final void onStop() {
        this.b.dispose();
        this.c = false;
    }

    public final void a(PreloadSource r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (k == false) goto L6;
    L23:
        boolean r0 = false;
    L24:
        if (r0 == true) goto L26;
        return;
    L26:
        GiftPanelPreloadViewModel r1 = this.f;
        if (r1 != null) goto L29;
    L31:
        RxUtilKt.c(Observable.just(r3).observeOn(Schedulers.computation()).subscribe(new c(this, r3)), this.b);
        return;
    L29:
        if (r1.isCacheFull() != true) goto L31;
        return;
    L6:
        if (this.i.isAnchor() == true) goto L23;
        if (i12.m.e2.a() != null) goto L23;
        if (r3 != PreloadSource.CLICK_ACTION_DOWN) goto L15;
        r0 = j.a();
        goto L24
    L15:
        if (r3 != PreloadSource.OPEN_RECHARGE_PANEL) goto L18;
        r0 = j.c();
        goto L24
    L18:
        if (r3 != PreloadSource.ENTER_ROOM_DELAY) goto L21;
        r0 = j.b();
        goto L24
    L21:
        if (r3 != PreloadSource.CLOSE_PANEL) goto L23;
        r0 = j.d();
        goto L24
    }

    public final void c(PreloadSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if (k == false) goto L5;
        return;
    L5:
        RxUtilKt.c(Observable.just(r2).observeOn(Schedulers.computation()).subscribe(new d(this)), this.b);
    }

    public GiftPanelViewPreloadService(Context r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.h = r2;
        this.i = r3;
        this.a = r3.getRoom();
        this.b = new CompositeDisposable();
        this.d = v.c();
        this.g = new LinkedList();
    }
}
