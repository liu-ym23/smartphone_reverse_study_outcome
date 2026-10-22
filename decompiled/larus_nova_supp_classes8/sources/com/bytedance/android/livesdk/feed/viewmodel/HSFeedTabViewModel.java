package com.bytedance.android.livesdk.feed.viewmodel;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.android.livesdk.feed.tab.monitor.FeedTabMonitor;
import com.bytedance.android.livesdk.model.a1;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R.\u0010\u000b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \n*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/feed/viewmodel/HSFeedTabViewModel;", "Lcom/bytedance/android/live/core/utils/rxutils/RxViewModel;", "", "queryTab", "queryRemoteTabAndSave", "Lcom/bytedance/android/livesdk/feed/feed/e;", "itemTab", "setCurrentItemTab", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "tabList", "Lio/reactivex/subjects/BehaviorSubject;", "currentItemTab", "Lcom/bytedance/android/livesdk/feed/feed/e;", "Lcom/bytedance/android/livesdk/feed/j;", "feedTabRepository", "Lcom/bytedance/android/livesdk/feed/j;", "getFeedTabRepository", "()Lcom/bytedance/android/livesdk/feed/j;", "Lcom/bytedance/android/livesdk/feed/k;", "tabListDiff", "Lcom/bytedance/android/livesdk/feed/k;", "getTabListDiff", "()Lcom/bytedance/android/livesdk/feed/k;", "Lhw1/a;", "userCenter", "Lhw1/a;", "getUserCenter", "()Lhw1/a;", "<init>", "(Lcom/bytedance/android/livesdk/feed/j;Lcom/bytedance/android/livesdk/feed/k;Lhw1/a;)V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HSFeedTabViewModel extends RxViewModel {
    private com.bytedance.android.livesdk.feed.feed.e currentItemTab;
    private final com.bytedance.android.livesdk.feed.j feedTabRepository;
    private final BehaviorSubject<List<com.bytedance.android.livesdk.feed.feed.e>> tabList;
    private final com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> tabListDiff;
    private final hw1.a userCenter;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            Intrinsics.checkNotNullParameter(r3, "res");
            return r3.getStatus();
        }
    }

    public static final class b<T> implements Predicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r2) {
            IBaseUser.Status r3 = (IBaseUser.Status) r2;
            Intrinsics.checkNotNullParameter(r3, "status");
            if (r3 != IBaseUser.Status.Login) goto L5;
        L8:
            return true;
        L5:
            if (r3 == IBaseUser.Status.Logout) goto L8;
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ HSFeedTabViewModel a;

        public c(HSFeedTabViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            IBaseUser.Status r2 = (IBaseUser.Status) r1;
            HSFeedTabViewModel.access$queryTab(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "obj");
            r3.printStackTrace();
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            List r2 = (List) r1;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r2) {
            ALogger.e("Tab Request", (Throwable) r2);
        }
    }

    public static final class g<T> implements Predicate {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final boolean test(Object r1) {
            return !Lists.isEmpty((List) r1);
        }
    }

    public static final class h<T, R> implements Function {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final Object apply(Object r4) {
            List r5 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "res");
            ArrayList r0 = new ArrayList();
            Iterator r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L10;
            com.bytedance.android.livesdk.feed.feed.e r1 = (com.bytedance.android.livesdk.feed.feed.e) r6.next();
            if (r1 == null) goto L4;
            if (r1.q() == false) goto L4;
            r0.add(r1);
            goto L4
        L10:
            return r0;
        }
    }

    public static final class i<T> implements Predicate {
        public final /* synthetic */ HSFeedTabViewModel a;

        public i(HSFeedTabViewModel r1) {
            this.a = r1;
        }

        public final boolean test(Object r3) {
            return !this.a.getTabListDiff().a((List) r3, (List) HSFeedTabViewModel.access$getTabList$p(this.a).getValue());
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ HSFeedTabViewModel a;

        public j(HSFeedTabViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            if (r3 == null) goto L6;
            HSFeedTabViewModel.access$getTabList$p(this.a).onNext(r3);
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final void accept(Object r1) {
            Logger.throwException((Throwable) r1);
        }
    }

    private final void queryRemoteTabAndSave() {
        register(this.feedTabRepository.a(FeedTabMonitor.Action.TRIGGER_ACTION_OPEN_TAB_PAGE).subscribe(e.a, f.a));
    }

    private final void queryTab() {
        register(this.feedTabRepository.e().filter(g.a).map(h.a).filter(new i(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), k.a));
    }

    public final com.bytedance.android.livesdk.feed.j getFeedTabRepository() {
        return this.feedTabRepository;
    }

    public final com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> getTabListDiff() {
        return this.tabListDiff;
    }

    public final hw1.a getUserCenter() {
        return this.userCenter;
    }

    public static final /* synthetic */ BehaviorSubject access$getTabList$p(HSFeedTabViewModel r0) {
        return r0.tabList;
    }

    public static final /* synthetic */ void access$queryTab(HSFeedTabViewModel r0) {
        r0.queryTab();
    }

    public final void setCurrentItemTab(com.bytedance.android.livesdk.feed.feed.e r1) {
        this.currentItemTab = r1;
    }

    public HSFeedTabViewModel(com.bytedance.android.livesdk.feed.j r2, com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> r3, hw1.a r4) {
        Intrinsics.checkNotNullParameter(r2, "feedTabRepository");
        Intrinsics.checkNotNullParameter(r3, "tabListDiff");
        Intrinsics.checkNotNullParameter(r4, "userCenter");
        this.feedTabRepository = r2;
        this.tabListDiff = r3;
        this.userCenter = r4;
        this.tabList = BehaviorSubject.create();
        register(r4.m().map(a.a).filter(b.a).subscribe(new c(this), d.a));
        if (a1.a() == false) goto L5;
        queryRemoteTabAndSave();
    L5:
        a1.c = true;
    }
}
