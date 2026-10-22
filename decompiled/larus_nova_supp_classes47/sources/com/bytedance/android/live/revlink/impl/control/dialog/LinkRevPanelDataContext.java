package com.bytedance.android.live.revlink.impl.control.dialog;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000b\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB\u0007¢\u0006\u0004\b^\u0010_J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R+\u0010(\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b+\u0010,R!\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R!\u00106\u001a\b\u0012\u0004\u0012\u00020#0.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R!\u0010<\u001a\b\u0012\u0004\u0012\u000208078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b:\u0010;R-\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020?0>0=8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u00101\u001a\u0004\bA\u0010BR-\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020D0>0=8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u00101\u001a\u0004\bF\u0010BR-\u0010L\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020?0>0H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u00101\u001a\u0004\bJ\u0010KR-\u0010O\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020D0>0H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u00101\u001a\u0004\bN\u0010KR$\u0010Q\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR0\u0010X\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/dialog/LinkRevPanelDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/a;", "Landroid/content/Context;", "context", "", "asyncInflate", "Ljava/util/Deque;", "Landroid/view/View;", "getItemAsyncViews", "Ljava/lang/Runnable;", "asyncRunnable", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "asyncViews", "Ljava/util/Deque;", "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$OnInflateFinishedListener;", "asyncListener", "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$OnInflateFinishedListener;", "", "selectType", "I", "getSelectType", "()I", "setSelectType", "(I)V", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "followListUidSet$delegate", "getFollowListUidSet", "()Ljava/util/HashSet;", "followListUidSet", "Lcom/bytedance/android/live/revlink/impl/pk/utils/k;", "metricUtil$delegate", "getMetricUtil", "()Lcom/bytedance/android/live/revlink/impl/pk/utils/k;", "metricUtil", "Lcom/bytedance/live/datacontext/m;", "", "isOftenLinkList$delegate", "Lcom/bytedance/live/datacontext/p;", "isOftenLinkList", "()Lcom/bytedance/live/datacontext/m;", "recImplId$delegate", "getRecImplId", "recImplId", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/b;", "loader$delegate", "getLoader", "()Lcom/bytedance/live/datacontext/j;", "loader", "Lcom/bytedance/live/datacontext/k;", "Lkotlin/Pair;", "Lcom/bytedance/android/live/revlink/impl/control/dialog/e;", "loadCompleteEvent$delegate", "getLoadCompleteEvent", "()Lcom/bytedance/live/datacontext/k;", "loadCompleteEvent", "Lcom/bytedance/android/live/revlink/impl/control/dialog/f;", "loadFailEvent$delegate", "getLoadFailEvent", "loadFailEvent", "Lcom/bytedance/live/datacontext/n;", "loadCompleteRankEvent$delegate", "getLoadCompleteRankEvent", "()Lcom/bytedance/live/datacontext/n;", "loadCompleteRankEvent", "loadFailRankEvent$delegate", "getLoadFailRankEvent", "loadFailRankEvent", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/p;", "reporter", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/p;", "getReporter", "()Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/p;", "setReporter", "(Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/p;)V", "", "abValueMap", "Ljava/util/Map;", "getAbValueMap", "()Ljava/util/Map;", "setAbValueMap", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRevPanelDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.control.dialog.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    private Map<String, String> abValueMap;
    private final AsyncLayoutInflater.OnInflateFinishedListener asyncListener;
    private Runnable asyncRunnable;
    private Deque<View> asyncViews;
    private final CompositeDisposable cd;
    private final Lazy followListUidSet$delegate;
    private final com.bytedance.live.datacontext.p isOftenLinkList$delegate;
    private final com.bytedance.live.datacontext.p loadCompleteEvent$delegate;
    private final com.bytedance.live.datacontext.p loadCompleteRankEvent$delegate;
    private final com.bytedance.live.datacontext.p loadFailEvent$delegate;
    private final com.bytedance.live.datacontext.p loadFailRankEvent$delegate;
    private final com.bytedance.live.datacontext.p loader$delegate;
    private final Lazy mainHandler$delegate;
    private final Lazy metricUtil$delegate;
    private final com.bytedance.live.datacontext.p recImplId$delegate;
    private com.bytedance.android.live.revlink.impl.pk.dialog.fragment.p reporter;
    private int selectType;

    public static final class a implements Action {
        public final /* synthetic */ LinkRevPanelDataContext a;

        public a(LinkRevPanelDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            LinkRevPanelDataContext.access$getCd$p(this.a).dispose();
            if (LinkRevPanelDataContext.access$getAsyncRunnable$p(this.a) == null) goto L5;
            Handler r0 = LinkRevPanelDataContext.access$getMainHandler$p(this.a);
            Runnable r1 = LinkRevPanelDataContext.access$getAsyncRunnable$p(this.a);
            Intrinsics.checkNotNull(r1);
            r0.removeCallbacks(r1);
            LinkRevPanelDataContext.access$setAsyncRunnable$p(this.a, null);
        L5:
            LinkRevPanelDataContext.access$getAsyncViews$p(this.a).clear();
        }
    }

    public static final class b {
        public b() {
        }

        public final LinkRevPanelDataContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(com.bytedance.android.live.revlink.impl.control.dialog.a.class);
            if ((r0 instanceof LinkRevPanelDataContext) == true) goto L5;
            r0 = null;
        L5:
            LinkRevPanelDataContext r1 = (LinkRevPanelDataContext) r0;
            if (r1 != null) goto L8;
        L10:
            return r1;
        L8:
            if (r1.isCleared() != true) goto L10;
            return null;
        }

        public final e a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "activityId");
            LinkRevPanelDataContext r0 = getContext();
            if (r0 == null) goto L11;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.control.dialog.b> r1 = r0.getLoader();
            if (r1 == null) goto L11;
            com.bytedance.android.live.revlink.impl.control.dialog.b r4 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r1.getValue();
            if (r4 == null) goto L11;
            Pair<String, e> r5 = r4.e(r2, r3);
            if (r5 == null) goto L11;
            return (e) r5.getSecond();
        L11:
            return null;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinkRevPanelDataContext a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AsyncLayoutInflater d;

        public c(LinkRevPanelDataContext r1, int r2, int r3, AsyncLayoutInflater r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.b - this.c;     // Catch: Throwable -> L6
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L14;
            this.d.inflate(2131566289, null, LinkRevPanelDataContext.access$getAsyncListener$p(this.a));     // Catch: Throwable -> L6
            r1 = r1 + 1;
            goto L3
        L14:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L10;
            return;
        L10:
            throw th;
        }
    }

    public static final class d implements AsyncLayoutInflater.OnInflateFinishedListener {
        public final /* synthetic */ LinkRevPanelDataContext a;

        public d(LinkRevPanelDataContext r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onCancel(int r1) {
            AsyncLayoutInflater.OnInflateFinishedListener.-CC.$default$onCancel(this, r1);
        }

        public final void onInflateFinished(View r2, int r3, ViewGroup r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            LinkRevPanelDataContext.access$getAsyncViews$p(this.a).add(r2);
            jy0.b.c("LinkRevPanelDataContext", "async done for " + LinkRevPanelDataContext.access$getAsyncViews$p(this.a).size(), null, 4);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkRevPanelDataContext.class, "isOftenLinkList", "isOftenLinkList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevPanelDataContext.class, "recImplId", "getRecImplId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevPanelDataContext.class, "loader", "getLoader()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevPanelDataContext.class, "loadCompleteEvent", "getLoadCompleteEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevPanelDataContext.class, "loadFailEvent", "getLoadFailEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevPanelDataContext.class, "loadCompleteRankEvent", "getLoadCompleteRankEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkRevPanelDataContext.class, "loadFailRankEvent", "getLoadFailRankEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new b();
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler$delegate.getValue();
    }

    public final HashSet<String> getFollowListUidSet() {
        return (HashSet) this.followListUidSet$delegate.getValue();
    }

    public final com.bytedance.live.datacontext.k<Pair<String, e>> getLoadCompleteEvent() {
        return (com.bytedance.live.datacontext.k) this.loadCompleteEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.n<Pair<String, e>> getLoadCompleteRankEvent() {
        return (com.bytedance.live.datacontext.n) this.loadCompleteRankEvent$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.k<Pair<String, f>> getLoadFailEvent() {
        return (com.bytedance.live.datacontext.k) this.loadFailEvent$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.n<Pair<String, f>> getLoadFailRankEvent() {
        return (com.bytedance.live.datacontext.n) this.loadFailRankEvent$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.control.dialog.b> getLoader() {
        return (com.bytedance.live.datacontext.j) this.loader$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.android.live.revlink.impl.pk.utils.k getMetricUtil() {
        return (com.bytedance.android.live.revlink.impl.pk.utils.k) this.metricUtil$delegate.getValue();
    }

    public final com.bytedance.live.datacontext.m<String> getRecImplId() {
        return (com.bytedance.live.datacontext.m) this.recImplId$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isOftenLinkList() {
        return (com.bytedance.live.datacontext.m) this.isOftenLinkList$delegate.a(this, $$delegatedProperties[0]);
    }

    public LinkRevPanelDataContext() {
        this.mainHandler$delegate = LazyKt.lazy(LinkRevPanelDataContext$mainHandler$2.INSTANCE);
        CompositeDisposable r0 = new CompositeDisposable();
        this.cd = r0;
        this.asyncViews = new LinkedList();
        this.asyncListener = new d(this);
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r0);
        this.followListUidSet$delegate = LazyKt.lazy(LinkRevPanelDataContext$followListUidSet$2.INSTANCE);
        this.metricUtil$delegate = LazyKt.lazy(LinkRevPanelDataContext$metricUtil$2.INSTANCE);
        this.isOftenLinkList$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.FALSE);
        this.recImplId$delegate = com.bytedance.live.datacontext.q.d(this, "");
        this.loader$delegate = ConstantKt.c(this);
        this.loadCompleteEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.loadFailEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.loadCompleteRankEvent$delegate = com.bytedance.live.datacontext.q.c(this);
        this.loadFailRankEvent$delegate = com.bytedance.live.datacontext.q.c(this);
    }

    public final Map<String, String> getAbValueMap() {
        return this.abValueMap;
    }

    public final Deque<View> getItemAsyncViews() {
        return this.asyncViews;
    }

    public final com.bytedance.android.live.revlink.impl.pk.dialog.fragment.p getReporter() {
        return this.reporter;
    }

    public final int getSelectType() {
        return this.selectType;
    }

    public static final /* synthetic */ AsyncLayoutInflater.OnInflateFinishedListener access$getAsyncListener$p(LinkRevPanelDataContext r0) {
        return r0.asyncListener;
    }

    public static final /* synthetic */ Runnable access$getAsyncRunnable$p(LinkRevPanelDataContext r0) {
        return r0.asyncRunnable;
    }

    public static final /* synthetic */ Deque access$getAsyncViews$p(LinkRevPanelDataContext r0) {
        return r0.asyncViews;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(LinkRevPanelDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(LinkRevPanelDataContext r0) {
        return r0.getMainHandler();
    }

    public final void asyncInflate(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        b r0 = Companion;
        r0.getClass();
        b51.b r1 = b51.b.c0;
        int r2 = r1.i().s1();
        int r3 = this.asyncViews.size();
        if (r2 <= 0) goto L16;
        if (r3 >= r2) goto L18;
        AsyncLayoutInflater r4 = new AsyncLayoutInflater(r8);
        if (this.asyncRunnable == null) goto L10;
        Handler r9 = getMainHandler();
        Runnable r5 = this.asyncRunnable;
        Intrinsics.checkNotNull(r5);
        r9.removeCallbacks(r5);
    L10:
        r0.getClass();
        long r6 = r1.i().H8();
        if (r6 <= 0) goto L13;
        c r10 = new c(this, r2, r3, r4);
        getMainHandler().postDelayed(r10, r6);
        this.asyncRunnable = r10;
        return;
    L13:
        int r7 = r2 - r3;
        int r12 = 0;
    L14:
        if (r12 >= r7) goto L20;
        r4.inflate(2131566289, null, this.asyncListener);
        r12 = r12 + 1;
        goto L14
    L20:
        return;
    L18:
        return;
    }

    public final void setAbValueMap(Map<String, String> r1) {
        this.abValueMap = r1;
    }

    public final void setReporter(com.bytedance.android.live.revlink.impl.pk.dialog.fragment.p r1) {
        this.reporter = r1;
    }

    public final void setSelectType(int r1) {
        this.selectType = r1;
    }

    public static final /* synthetic */ void access$setAsyncRunnable$p(LinkRevPanelDataContext r0, Runnable r1) {
        r0.asyncRunnable = r1;
    }

    public static final /* synthetic */ void access$setAsyncViews$p(LinkRevPanelDataContext r0, Deque r1) {
        r0.asyncViews = r1;
    }
}
