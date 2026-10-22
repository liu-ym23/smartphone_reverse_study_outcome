package com.ss.android.lark.flow.feed.sidebar.adapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.f;
import com.larksuite.arch.jack.i;
import com.larksuite.arch.jack.j;
import com.larksuite.arch.jack.l;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.listener.FeedItemScrollListener;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import iza.e;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0004;@E\\\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001vBC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010e\u001a\u00020fJ\u0016\u0010g\u001a\u00020f2\u0006\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020jJ\"\u0010k\u001a\u00020f2\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020\u001fJ\b\u0010o\u001a\u00020fH\u0002J\u0018\u0010p\u001a\n\u0012\u0004\u0012\u00020r\u0018\u00010q2\u0006\u0010s\u001a\u00020tH\u0002J\b\u0010u\u001a\u00020fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R#\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b)\u0010$R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010&\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010&\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010&\u001a\u0004\bF\u0010GR\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010K\u001a\b\u0012\u0004\u0012\u00020M0L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010&\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020R8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010&\u001a\u0004\bS\u0010TR\u001b\u0010V\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010&\u001a\u0004\bX\u0010YR\u001b\u0010[\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010&\u001a\u0004\b]\u0010^R\u001b\u0010`\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010&\u001a\u0004\bb\u0010c¨\u0006w"}, d2 = {"Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper;", "Lcom/larksuite/arch/jack/ISubscriber;", "Landroidx/lifecycle/ViewModelStoreOwner;", "context", "Landroid/content/Context;", "hostFragment", "Landroidx/fragment/app/Fragment;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "feedFilter", "Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "sidebarItemConfig", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;", "dependency", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsDependency;", "callback", "Lcom/ss/android/lark/feed/export/mixed/IMixedFeedSidebarCallback;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroidx/lifecycle/LifecycleOwner;Lcom/ss/android/lark/feed/app/entity/FeedFolder;Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;Lcom/ss/android/lark/feed/shared/page/IFeedItemsDependency;Lcom/ss/android/lark/feed/export/mixed/IMixedFeedSidebarCallback;)V", "getDependency", "()Lcom/ss/android/lark/feed/shared/page/IFeedItemsDependency;", "setDependency", "(Lcom/ss/android/lark/feed/shared/page/IFeedItemsDependency;)V", "sidebarFeedDataSource", "Lcom/ss/android/lark/flow/feed/base/user/IFeedUserDataSource;", "wrapperViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "isReleased", "", "rustClientHolder", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/bytedance/lark/rustclient/api/IRustClient;", "getRustClientHolder", "()Ljava/util/concurrent/atomic/AtomicReference;", "rustClientHolder$delegate", "Lkotlin/Lazy;", "sidebarViewModelHolder", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModel;", "getSidebarViewModelHolder", "sidebarViewModelHolder$delegate", "currentUserId", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mLastVisibleFirstEndPosition", "Lkotlin/Pair;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMLastVisibleFirstEndPosition", "()Lkotlin/Pair;", "mLastVisibleFirstEndPosition$delegate", "lifecycleOwnerHolder", "Lcom/larksuite/arch/jack/LifecycleOwnerHolder;", "getLifecycleOwnerHolder", "()Lcom/larksuite/arch/jack/LifecycleOwnerHolder;", "lifecycleOwnerHolder$delegate", "feedActionDependency", "com/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper$feedActionDependency$2$1", "getFeedActionDependency", "()Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper$feedActionDependency$2$1;", "feedActionDependency$delegate", "feedCardContext", "com/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper$feedCardContext$2$1", "getFeedCardContext", "()Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper$feedCardContext$2$1;", "feedCardContext$delegate", "feedItemListener", "com/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper$feedItemListener$2$1", "getFeedItemListener", "()Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper$feedItemListener$2$1;", "feedItemListener$delegate", "viewInit", "Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarItemsViewInit;", "feedCardWrapper", "Lcom/ss/android/lark/feed/shared/openfeed/card/OpenFeedCardWrapper;", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardFactory;", "getFeedCardWrapper", "()Lcom/ss/android/lark/feed/shared/openfeed/card/OpenFeedCardWrapper;", "feedCardWrapper$delegate", "feedAdapter", "Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapter;", "getFeedAdapter", "()Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapter;", "feedAdapter$delegate", "dataController", "Lcom/ss/android/lark/flow/feed/base/IMixedFeedDataControllerApi;", "getDataController", "()Lcom/ss/android/lark/flow/feed/base/IMixedFeedDataControllerApi;", "dataController$delegate", "dataDelegate", "com/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper$dataDelegate$2$1", "getDataDelegate", "()Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapterWrapper$dataDelegate$2$1;", "dataDelegate$delegate", "itemsScrollListenerV2", "Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener;", "getItemsScrollListenerV2", "()Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener;", "itemsScrollListenerV2$delegate", "release", "", "bind", "dataSource", "localCache", "Lcom/ss/android/lark/feed/molten/cache/IFeedItemsMoltenLocalCache;", "attachRecyclerView", "commonViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "isConcatAdapter", "setAdapterDiffCallback", "getCurrentPageShowedItems", "", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "attachUserReadyListeners", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FeedSidebarAdapterWrapper implements f, ViewModelStoreOwner {
    public static final /* synthetic */ int y = 0;
    public final Context a;
    public final Fragment b;
    public final LifecycleOwner c;
    public final FeedFolder d;
    public final e e;
    public final deb.d f;
    public chb.a g;
    public final ViewModelStore h;
    public boolean i;
    public final Lazy j;
    public final Lazy k;
    public String l;
    public RecyclerView m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public b s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.flow.feed.base.a a() {
        return (com.ss.android.lark.flow.feed.base.a) this.v.getValue();
    }

    public final FeedSidebarAdapter b() {
        return (FeedSidebarAdapter) this.u.getValue();
    }

    public final AtomicReference<s> c() {
        return (AtomicReference) this.k.getValue();
    }

    public final void d() {
        if (this.i == false) goto L6;
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarAdapterWrapper", "release skipped: already released");
        return;
    L6:
        this.i = true;
        b().F2();
        this.s = null;
        a().T();
        a().release();
        ((AtomicReference) this.j.getValue()).set(null);
        c().set(null);
        this.l = null;
        RecyclerView r1 = this.m;
        if (r1 == null) goto L9;
        r1.removeOnScrollListener((FeedItemScrollListener) this.x.getValue());
    L9:
        this.m = null;
        this.h.clear();
    }

    public final i getLifecycleOwnerHolder() {
        return (i) this.o.getValue();
    }

    public final ViewModelStore getViewModelStore() {
        return this.h;
    }

    public final <S extends j> com.larksuite.arch.jack.c nH(JackViewModel<S> r1, l<S> r2, Function1<? super S, Unit> r3) {
        return f.a.g(this, r1, r2, r3);
    }

    public final com.larksuite.arch.jack.c Ik(JackViewModel r1, PropertyReference1Impl r2, l r3, Function1 r4) {
        return f.a.a(this, r1, r2, r3, r4);
    }

    public final com.larksuite.arch.jack.c Ki(JackViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, l r4, Function1 r5) {
        return f.a.b(this, r1, r2, r3, r4, r5);
    }

    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, PropertyReference1Impl r4, l r5, Function1 r6) {
        return f.a.c(this, r1, r2, r3, r4, r5, r6);
    }

    public FeedSidebarAdapterWrapper(Context r1, Fragment r2, LifecycleOwner r3, FeedFolder r4, e r5, com.ss.android.lark.integrator.im.impl.e r6, com.larus.larkfeed.impl.mixedfeed.flow.a r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "feedFilter");
        Intrinsics.checkNotNullParameter(r5, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.h = new ViewModelStore();
        this.j = LazyKt.lazy(FeedSidebarAdapterWrapper$rustClientHolder$2.INSTANCE);
        this.k = LazyKt.lazy(FeedSidebarAdapterWrapper$sidebarViewModelHolder$2.INSTANCE);
        this.n = LazyKt.lazy(FeedSidebarAdapterWrapper$mLastVisibleFirstEndPosition$2.INSTANCE);
        this.o = LazyKt.lazy(new FeedSidebarAdapterWrapper$lifecycleOwnerHolder$2(this));
        Lazy r8 = LazyKt.lazy(FeedSidebarAdapterWrapper$feedActionDependency$2.INSTANCE);
        this.p = r8;
        Lazy r9 = LazyKt.lazy(new FeedSidebarAdapterWrapper$feedCardContext$2(this));
        this.q = r9;
        this.r = LazyKt.lazy(new FeedSidebarAdapterWrapper$feedItemListener$2(this));
        this.t = LazyKt.lazy(FeedSidebarAdapterWrapper$feedCardWrapper$2.INSTANCE);
        this.u = LazyKt.lazy(new FeedSidebarAdapterWrapper$feedAdapter$2(this));
        this.v = LazyKt.lazy(new FeedSidebarAdapterWrapper$dataController$2(this));
        this.w = LazyKt.lazy(new FeedSidebarAdapterWrapper$dataDelegate$2(this));
        this.x = LazyKt.lazy(LazyThreadSafetyMode.NONE, new FeedSidebarAdapterWrapper$itemsScrollListenerV2$2(this));
        ((FeedListAdapter) b()).k = new seb.b((FeedSidebarAdapterWrapper$feedActionDependency$2.a) r8.getValue(), (FeedSidebarAdapterWrapper$feedCardContext$2.a) r9.getValue());
        r3.getLifecycle().addObserver(new AnonymousClass1(this));
    }
}
