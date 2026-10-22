package com.bytedance.android.livesdk.feed.tab;

import am2.x;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.cache.i;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.LiveDrawerFeedPageFragment;
import com.bytedance.android.livesdk.feed.LiveDrawerTabViewModel;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.drawer.preload.PreloadHelper;
import com.bytedance.android.livesdk.feed.drawerfeed.DrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.VSDrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleListDrawFragment;
import com.bytedance.android.livesdk.feed.e;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.services.d;
import com.bytedance.android.livesdk.feed.tab.monitor.FeedTabMonitor;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.feed.x0;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedUrlService implements IHostFeed {
    nv1.a fragmentProvider;

    public static /* synthetic */ void b(Throwable r0) {
        lambda$requestTabApi$1(r0);
    }

    public static /* synthetic */ void c(List r0) {
        lambda$requestTabApi$0(r0);
    }

    private static /* synthetic */ void lambda$requestTabApi$0(List r0) throws Exception {
    }

    public Fragment createSingleDrawerFeedFragment() {
        ((e) this.fragmentProvider).getClass();
        return new SingleListDrawFragment();
    }

    public FeedUrlService() {
        this.fragmentProvider = new e();
        k.l(IHostFeed.class, this);
    }

    public List<com.bytedance.android.livesdk.feed.feed.e> getNewDrawerTabList() {
        return p.f().c();
    }

    public List<com.bytedance.android.livesdk.feed.feed.e> getTabList() {
        LiveFeedContext.init(TTLiveSDK.hostService());
        return ((NewTabRepository) NewTabRepository.e.getValue()).c();
    }

    public void requestTabApi() {
        if (LiveFeedContext.hostService() != null) goto L5;
    L11:
        b0.o().getClass();
        g.c("FeedUrlService", "LiveFeedContext not init");
        return;
    L5:
        if (LiveFeedContext.hostService().appContext() == null) goto L11;
        if (LiveFeedContext.appContext() == null) goto L11;
        ((NewTabRepository) NewTabRepository.d.getValue()).a(FeedTabMonitor.Action.TRIGGER_ACTION_ENTER_ROOM).subscribe(new a(), new b());
    }

    public boolean shouldDrawerMultiTab() {
        LiveFeedContext.init(TTLiveSDK.hostService());
        boolean r0 = x0.d;
        if (x0.a.a().c().size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static /* synthetic */ void lambda$requestTabApi$1(Throwable r1) throws Exception {
        ALogger.e("Drawer Tab Request", r1);
    }

    public Fragment createVsDrawerFeedFragment(IDrawerFeedAction r2) {
        ((e) this.fragmentProvider).getClass();
        VSDrawerFeedLiveFragment r0 = new VSDrawerFeedLiveFragment();
        r0.H = r2;
        return r0;
    }

    public Map<String, Object> getFeedTab(long r8) {
        List<com.bytedance.android.livesdk.feed.feed.e> r0 = p.f().c();
        HashMap r1 = new HashMap();
        if (Lists.isEmpty(r0) == false) goto L5;
        return r1;
    L5:
        Iterator<com.bytedance.android.livesdk.feed.feed.e> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        com.bytedance.android.livesdk.feed.feed.e r3 = r2.next();
        if (r3 == null) goto L7;
        if (r3.f() != r8) goto L7;
    L14:
        if (r3 != null) goto L16;
        r3 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r0, 0);
    L16:
        if (r3 == null) goto L18;
        r1.put("feed_url", r3.h());
        r1.put("feed_style", Integer.valueOf(r3.m()));
    L18:
        return r1;
    L13:
        r3 = null;
        goto L14
    }

    public Fragment createDrawerFeedFragment(IDrawerFeedAction r3, boolean r4) {
        ((e) this.fragmentProvider).getClass();
        RoomContext r0 = RoomContext.getShared();
        if (r0 != null) goto L5;
    L9:
        if (r4 == false) goto L11;
        LiveDrawerFeedPageFragment r5 = new LiveDrawerFeedPageFragment();
        r5.x = r3;
        return r5;
    L11:
        DrawerFeedLiveFragment r6 = new DrawerFeedLiveFragment();
        r6.G = r3;
        return r6;
    L5:
        if (r0.isVSRoom() == false) goto L9;
        if (r0.isVSSpecialDrawer() == false) goto L9;
        DrawerFeedLiveFragment r7 = new DrawerFeedLiveFragment();
        r7.G = r3;
        return r7;
    }

    public void preloadDrawerFeed(FragmentActivity r23, boolean r24) {
        TabFeedViewModel r1 = PreloadHelper.a;
        Intrinsics.checkNotNullParameter(r23, "activity");
        IFeedRepository r4 = null;
        if (r23.hashCode() == PreloadHelper.e) goto L11;
        r23.getLifecycle().addObserver(PreloadHelper.f);
        PreloadHelper.e = r23.hashCode();
        if (PreloadHelper.a == null) goto L8;
        PreloadHelper.a = null;
    L8:
        if (PreloadHelper.b == null) goto L11;
        PreloadHelper.b = null;
    L11:
        if (r24 == false) goto L13;
        PreloadHelper.f.getClass();
        com.bytedance.android.livesdk.feed.feed.e r6 = PreloadHelper.c;
        if (r6.getType() == 1) goto L48;
        boolean r0 = false;
    L97:
        HashMap r2 = new HashMap();
        r2.put("predict_action", "preload_suc");
        if (r0 == false) goto L100;
        String r3 = "1";
    L101:
        r2.put("predict_value", r3);
        u.l().sendLog("livesdk_liveai_drawer_predict", r2, new Object[]{x.class, Room.class});
        return;
    L100:
        r3 = "0";
        goto L101
    L48:
        if (r23.hashCode() != PreloadHelper.e) goto L50;
        LiveDrawerTabViewModel r7 = PreloadHelper.b;
    L51:
        if (r7 != null) goto L57;
        Intrinsics.checkNotNullParameter(r23, "activity");
        LiveDrawerTabViewModel r8 = (LiveDrawerTabViewModel) ViewModelProviders.of(r23).get(LiveDrawerTabViewModel.class);
        PreloadHelper.b = r8;
        if (r8 != null) goto L57;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.LiveDrawerTabViewModel");
    L57:
        Intrinsics.checkNotNullParameter(r23, "activity");
        LiveDrawerTabViewModel r5 = PreloadHelper.b;
        if (r5 == null) goto L60;
        FragmentFeedViewModel r9 = r5.getTabViewModel(r6.f());
    L61:
        if (r9 != null) goto L87;
        LiveDrawerTabViewModel r10 = PreloadHelper.b;
        if (r10 == null) goto L67;
        FragmentFeedViewModel r11 = r10.getTabViewModel(r6.f());
        if (r11 == null) goto L67;
        IFeedRepository r12 = r11.feedRepository();
        d.a().g(r11.feedDataKey(), r12);
    L68:
        if (r12 == null) goto L70;
    L75:
        if (r12 != null) goto L78;
        f r13 = d.a();
        FeedApi r14 = (FeedApi) c.b().e(FeedApi.class);
        com.bytedance.android.live.core.cache.f r15 = new com.bytedance.android.live.core.cache.f();
        i r16 = new i(vv1.e.a, new com.bytedance.android.livesdk.feed.a(), vv1.f.a);
        com.bytedance.android.live.core.cache.f r17 = new com.bytedance.android.live.core.cache.f();
        hw1.a r18 = d.b();
        boolean r19 = x0.d;
        r12 = new LiveDrawerFeedRepository(r13, r14, r15, r16, r17, r18, new com.bytedance.android.livesdk.feed.c(x0.a.a()));
    L78:
        if ((r12 instanceof LiveDrawerFeedRepository) == false) goto L81;
        r4 = r12;
    L81:
        LiveDrawerFeedRepository r20 = (LiveDrawerFeedRepository) r4;
        if (r20 == null) goto L84;
        r20.w = PreloadHelper.d;
    L84:
        boolean r21 = x0.d;
        FeedViewModelFactory r22 = new FeedViewModelFactory(r12, x0.a.a(), LiveFeedContext.appContext().getApplicationContext(), vv1.g.a, new ax1.b());
        r22.c = r6.f();
        r22.d = uv1.c.a(uv1.c.c(r6), r6.j(), r6.f(), 4);
        r9 = (FragmentFeedViewModel) ViewModelProviders.of(r23, r22).get(FragmentFeedViewModel.class);
        LiveDrawerTabViewModel r25 = PreloadHelper.b;
        if (r25 == null) goto L94;
        r25.putTabViewModel(r6.f(), r9);
    L94:
        r9.setPreload(true);
        r9.setStarted(false);
        r9.clearDataCache();
        r9.start();
    L95:
        r0 = true;
        goto L97
    L70:
        if (TextUtils.isEmpty(r6.j()) == true) goto L75;
        ItemRepository r26 = d.a().d(FeedDataKey.a(r6.j(), r6.n(), r6.f()));
        if ((r26 instanceof IFeedRepository) == true) goto L74;
        r26 = null;
    L74:
        r12 = (IFeedRepository) r26;
    L67:
        r12 = null;
        goto L68
    L87:
        IFeedRepository r27 = r9.feedRepository();
        if ((r27 instanceof LiveDrawerFeedRepository) == false) goto L91;
        r4 = r27;
    L91:
        LiveDrawerFeedRepository r28 = (LiveDrawerFeedRepository) r4;
        if (r28 == null) goto L94;
        r28.w = PreloadHelper.d;
        goto L94
    L60:
        r9 = null;
        goto L61
    L50:
        r7 = null;
        goto L51
    L13:
        if (r23.hashCode() != PreloadHelper.e) goto L15;
        TabFeedViewModel r29 = PreloadHelper.a;
    L16:
        if (r29 != null) goto L44;
        Intrinsics.checkNotNullParameter(r23, "activity");
        com.bytedance.android.livesdk.feed.feed.e r30 = uv1.c.b();
        String r31 = uv1.c.d(r30);
        if (r30 != null) goto L20;
    L25:
        IFeedRepository r32 = null;
    L26:
        if (r32 != null) goto L28;
        f r33 = d.a();
        FeedApi r110 = (FeedApi) c.b().e(FeedApi.class);
        com.bytedance.android.live.core.cache.f r111 = new com.bytedance.android.live.core.cache.f();
        i r112 = new i(vv1.a.a, new com.bytedance.android.livesdk.feed.a(), vv1.b.a);
        com.bytedance.android.live.core.cache.f r113 = new com.bytedance.android.live.core.cache.f();
        hw1.a r114 = d.b();
        boolean r34 = x0.d;
        r32 = new LiveDrawerFeedRepository(r33, r110, r111, r112, r113, r114, new com.bytedance.android.livesdk.feed.c(x0.a.b()));
    L28:
        vv1.d r35 = new vv1.d();
        if ((r32 instanceof LiveDrawerFeedRepository) == false) goto L32;
        r4 = r32;
    L32:
        LiveDrawerFeedRepository r36 = (LiveDrawerFeedRepository) r4;
        if (r36 == null) goto L35;
        r36.w = r35;
    L35:
        boolean r37 = x0.d;
        FeedViewModelFactory r38 = new FeedViewModelFactory(r32, x0.a.b(), LiveFeedContext.appContext().getApplicationContext(), vv1.c.a, new ax1.b());
        if (r30 == null) goto L38;
        long r39 = r30.f();
    L39:
        r38.c = r39;
        r38.d = uv1.c.a(r31, "", 0, 4);
        r29 = (TabFeedViewModel) ViewModelProviders.of(r23, r38).get(TabFeedViewModel.class);
        PreloadHelper.a = r29;
        if (r29 != null) goto L44;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel");
    L38:
        r39 = 1;
        goto L39
    L20:
        if (TextUtils.isEmpty(r30.j()) == true) goto L25;
        ItemRepository r40 = d.a().d(FeedDataKey.a(r30.j(), r30.n(), r30.f()));
        if ((r40 instanceof IFeedRepository) == true) goto L24;
        r40 = null;
    L24:
        r32 = (IFeedRepository) r40;
    L44:
        r29.setPreload(true);
        r29.setStarted(false);
        r29.clearDataCache();
        r29.start();
        goto L95
    L15:
        r29 = null;
        goto L16
    }
}
