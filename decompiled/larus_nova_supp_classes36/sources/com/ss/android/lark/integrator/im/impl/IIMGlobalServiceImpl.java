package com.ss.android.lark.integrator.im.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus;
import com.larus.home.impl.main.side_bar.view.group.datasource.lark.r;
import com.larus.larkfeed.impl.mixedfeed.LarkMixedFeedFragment;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapter;
import com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapterWrapper;
import com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapterWrapper$feedItemListener$2;
import com.ss.android.lark.flow.feed.sidebar.human.OfficeSidebarHumanFeedController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKGlobalScope
public final class IIMGlobalServiceImpl implements aza.c {
    public final j a;
    public final vmb.c b;

    @Inject
    public sza.c c;
    public FeedSidebarAdapterWrapper d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    public final lza.a G5() {
        return new lza.a();
    }

    public final sza.c N1() {
        sza.c r0 = this.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("officeUrlPreviewService");
        return null;
    L7:
        return r0;
    }

    public final void d3(String r14) {
        Intrinsics.checkNotNullParameter(r14, "userId");
        Log.i("IIMGlobalServiceImpl", "clearFeedLocalCacheData invoked, userId=" + r14);
        ((com.ss.android.lark.feed.molten.cache.b) this.e.getValue()).f(r14);
        List<DoubaoFeedMigrateStatus> r15 = com.ss.android.lark.flow.feed.data.DoubaoFeedMigrateStatus.j;
        j r16 = this.a;
        Intrinsics.checkNotNullParameter(r16, "passport");
        com.ss.android.lark.flow.feed.utils.b.d("DoubaoFeedMigrateStatus", "clearMigrateStatusKvForAllUsers invoke");
        com.ss.android.lark.flow.feed.data.DoubaoFeedMigrateStatus.k.set(true);
        List r17 = r16.a();
        ArrayList r0 = new ArrayList();
        Iterator r18 = r17.iterator();
    L4:
        if (r18.hasNext() == false) goto L13;
        f0c.g r3 = ((f0c.b) r18.next()).a();
        if (r3 == null) goto L10;
        User r4 = r3.a;
        if (r4 == null) goto L10;
        String r5 = r4.userId;
    L11:
        if (r5 == null) goto L4;
        r0.add(r5);
    L10:
        r5 = null;
        goto L11
    L13:
        List r19 = CollectionsKt.distinct(r0);
        StringBuilder r1 = new StringBuilder("clearMigrateStatusKvForAllUsers:");
        List r110 = r19;
        r1.append(CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null));
        com.ss.android.lark.flow.feed.utils.b.d("DoubaoFeedMigrateStatus", r1.toString());
        Iterator r111 = r110.iterator();
    L15:
        if (r111.hasNext() == false) goto L24;
        String r6 = (String) r111.next();
        List<DoubaoFeedMigrateStatus> r2 = com.ss.android.lark.flow.feed.data.DoubaoFeedMigrateStatus.j;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L19
        com.ss.android.lark.storage.c.d(null, r6, new com.ss.android.lark.storage.a("mixed_feed"), "mixed_feed_storage", null, 49).remove("mixed_feed_migrate");     // Catch: Throwable -> L19
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L15;
        Intrinsics.checkNotNullParameter("DoubaoFeedMigrateStatus", "tag");
        Log.e("DoubaoFeedMigrateStatus", "[FlowFeedLog] ".concat("clearMigrateStatusKvForAllUsers error"), r9, true);
    L19:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public final FlowMixedFeedFragment y6(LarkMixedFeedFragment r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        FlowMixedFeedFragment r1 = new FlowMixedFeedFragment();
        vmb.c r2 = this.b;
        com.ss.android.lark.feed.molten.cache.b r3 = (com.ss.android.lark.feed.molten.cache.b) this.e.getValue();
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r3, "localCache");
        r1.d = r2;
        r1.k = r6;
        r1.h = r3;
        r1.V90().S(r2, r3);
        r1.V90().U();
        return r1;
    }

    @Inject
    public IIMGlobalServiceImpl(j r2, vmb.c r3) {
        Intrinsics.checkNotNullParameter(r2, "userService");
        Intrinsics.checkNotNullParameter(r3, "mixedFeedUserBundleProxy");
        this.a = r2;
        this.b = r3;
        this.e = LazyKt.lazy(IIMGlobalServiceImpl$feedItemsMoltenLocalCache$2.INSTANCE);
    }

    public final OfficeSidebarHumanFeedController p4(Fragment r8, iza.e r9) {
        r.a r0 = r.a.a;
        Intrinsics.checkNotNullParameter(r8, "hostFragment");
        Intrinsics.checkNotNullParameter(r9, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r0, "callback");
        Log.i("IIMGlobalServiceImpl", "createSidebarHumanFeedController invoked, hostFragment=" + r8.getClass().getSimpleName() + '@' + System.identityHashCode(r8));
        if (r8.getContext() != null) goto L7;
        Log.e("IIMGlobalServiceImpl", "createSidebarHumanFeedController skipped: hostFragment.context is null");
        return null;
    L7:
        return new OfficeSidebarHumanFeedController(r8, r8.getViewLifecycleOwner(), r9, this.b, (com.ss.android.lark.feed.molten.cache.b) this.e.getValue());
    }

    public final FeedSidebarAdapter Md(Fragment r12, RecyclerView r13, iza.e r14, com.larus.larkfeed.impl.mixedfeed.flow.a r15) {
        Intrinsics.checkNotNullParameter(r12, "hostFragment");
        Intrinsics.checkNotNullParameter(r13, "recyclerView");
        Intrinsics.checkNotNullParameter(r14, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r15, "callback");
        Log.i("IIMGlobalServiceImpl", "createSidebarFeedAdapter invoked, hostFragment=" + r12.getClass().getSimpleName() + '@' + System.identityHashCode(r12) + ", recyclerView=" + r13.getClass().getSimpleName() + '@' + System.identityHashCode(r13));
        Context r4 = r12.getContext();
        if (r4 != null) goto L6;
        Log.e("IIMGlobalServiceImpl", "createSidebarFeedAdapter skipped: hostFragment.context is null");
        return null;
    L6:
        FeedSidebarAdapterWrapper r2 = this.d;
        if (r2 == null) goto L9;
        r2.d();
    L9:
        this.d = null;
        FeedSidebarAdapterWrapper r1 = new FeedSidebarAdapterWrapper(r4, r12, r12.getViewLifecycleOwner(), FeedFolderCompat.INSTANCE.getMESSAGE(), r14, new e(), r15);
        vmb.c r16 = this.b;
        com.ss.android.lark.feed.molten.cache.b r17 = (com.ss.android.lark.feed.molten.cache.b) this.e.getValue();
        Intrinsics.checkNotNullParameter(r16, "dataSource");
        Intrinsics.checkNotNullParameter(r17, "localCache");
        r1.i = false;
        r1.g = r16;
        r1.a().S(r16, r17);
        r1.a().U();
        Intrinsics.checkNotNullParameter(r13, "recyclerView");
        com.ss.android.lark.flow.feed.sidebar.adapter.b r18 = new com.ss.android.lark.flow.feed.sidebar.adapter.b(r1.a, r13, r1.b());
        FeedSidebarAdapterWrapper$feedItemListener$2.a r19 = (FeedSidebarAdapterWrapper$feedItemListener$2.a) r1.r.getValue();
        Intrinsics.checkNotNullParameter(r19, "sidebarContainerListener");
        r18.c = r19;
        FeedSidebarAdapter r110 = r18.b;
        if (r110 == null) goto L12;
        ((FeedListAdapter) r110).d = new com.ss.android.lark.flow.feed.sidebar.adapter.c();
    L12:
        if (r110 == null) goto L14;
        ((FeedListAdapter) r110).e = new com.ss.android.lark.flow.feed.sidebar.adapter.d(r18);
    L14:
        r1.s = r18;
        r1.m = r13;
        r1.a().R();
        this.d = r1;
        return r1.b();
    }
}
