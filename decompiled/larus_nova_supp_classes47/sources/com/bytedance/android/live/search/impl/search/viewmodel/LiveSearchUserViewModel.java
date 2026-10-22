package com.bytedance.android.live.search.impl.search.viewmodel;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.viewmodel.ListViewModel;
import com.bytedance.android.livesdkapi.model.LiveSearchUserResponse;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003J\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0005H\u0007R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/viewmodel/LiveSearchUserViewModel;", "Lcom/bytedance/android/livesdk/viewmodel/ListViewModel;", "Lcom/bytedance/android/live/base/model/user/User;", "", "keyword", "", "refresh", "searchUser", "loadMore", "", "Lcom/bytedance/android/live/search/impl/search/viewmodel/a;", "searchResultMap", "Ljava/util/Map;", "Lcom/bytedance/android/livehostapi/platform/IHostUser;", "hostUser", "Lcom/bytedance/android/livehostapi/platform/IHostUser;", "Lcom/bytedance/live/datacontext/m;", "currentKeyword$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentKeyword", "()Lcom/bytedance/live/datacontext/m;", "currentKeyword", "<init>", "()V", "Companion", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchUserViewModel extends ListViewModel<User> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int DEFAULT_SEARCH_COUNT = 20;
    public static final String DEFAULT_SEARCH_SOURCE = "live_search_user";
    private final p currentKeyword$delegate;
    private IHostUser hostUser;
    private final Map<String, com.bytedance.android.live.search.impl.search.viewmodel.a> searchResultMap;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveSearchUserViewModel a;

        public b(LiveSearchUserViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            LiveSearchUserResponse r6 = (LiveSearchUserResponse) r5;
            if (r6.getStatueCode() != 0) goto L21;
            List r0 = r6.getUserList();
            com.bytedance.android.live.search.impl.search.viewmodel.a r1 = (com.bytedance.android.live.search.impl.search.viewmodel.a) LiveSearchUserViewModel.access$getSearchResultMap$p(this.a).get(this.a.getCurrentKeyword().getValue());
            if (r1 == null) goto L14;
            if (r0 == null) goto L13;
            Iterator<T> r2 = r0.iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            User r3 = (User) r2.next();
            List<User> r4 = r1.a;
            if (r4 == null) goto L9;
            r4.add(r3);
        L13:
            r1.b = r6.getCursor();
            r1.c = r6.getHasMore();
        L14:
            LiveSearchUserViewModel r7 = this.a;
            com.bytedance.android.live.search.impl.search.viewmodel.a r8 = (com.bytedance.android.live.search.impl.search.viewmodel.a) LiveSearchUserViewModel.access$getSearchResultMap$p(r7).get(this.a.getCurrentKeyword().getValue());
            if (r8 == null) goto L19;
            List<User> r9 = r8.a;
            if (r9 == null) goto L19;
            List r10 = CollectionsKt.toMutableList(r9);
        L20:
            r7.setLoadMoreResult(r10, r6.getHasMore());
            return;
        L19:
            r10 = null;
            goto L20
        L21:
            this.a.setLoadMoreError(new Throwable(r6.getStatueMsg()));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveSearchUserViewModel a;

        public c(LiveSearchUserViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LiveSearchUserViewModel r0 = this.a;
            r0.setLoadMoreError((Throwable) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveSearchUserViewModel a;
        public final /* synthetic */ String b;

        public d(LiveSearchUserViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            LiveSearchUserResponse r8 = (LiveSearchUserResponse) r7;
            if (r8.getStatueCode() != 0) goto L25;
            List r0 = r8.getUserList();
            IHostUser r1 = LiveSearchUserViewModel.access$getHostUser$p(this.a);
            ArrayList r2 = null;
            if (r1 == null) goto L7;
            String r3 = r1.getCurUserId();
        L8:
            if (r0 == null) goto L16;
            ArrayList r4 = new ArrayList();
            Iterator<T> r5 = r0.iterator();
        L11:
            if (r5.hasNext() == false) goto L15;
            T r6 = r5.next();
            if ((!Intrinsics.areEqual(((User) r6).getIdString(), r3)) == false) goto L11;
            r4.add(r6);
            goto L11
        L15:
            r2 = r4;
        L16:
            ArrayList r9 = new ArrayList();
            if (r2 == null) goto L22;
            Iterator<T> r10 = r2.iterator();
        L20:
            if (r10.hasNext() == false) goto L22;
            r9.add((User) r10.next());
        L22:
            LiveSearchUserViewModel.access$getSearchResultMap$p(this.a).put(this.b, new com.bytedance.android.live.search.impl.search.viewmodel.a(r9, r8.getCursor(), r8.getHasMore()));
            if (TextUtils.equals(r8.getInputKeyword(), (CharSequence) this.a.getCurrentKeyword().getValue()) == false) goto L33;
            this.a.setRefreshResult(TypeIntrinsics.asMutableList(r0), r8.getHasMore());
            return;
        L33:
            return;
        L7:
            r3 = null;
            goto L8
        L25:
            this.a.setRefreshError(new Throwable(r8.getStatueMsg()));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LiveSearchUserViewModel a;

        public e(LiveSearchUserViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LiveSearchUserViewModel r0 = this.a;
            r0.setRefreshError((Throwable) r2);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LiveSearchUserViewModel.class, "currentKeyword", "getCurrentKeyword()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<String> getCurrentKeyword() {
        return (m) this.currentKeyword$delegate.a(this, $$delegatedProperties[0]);
    }

    public LiveSearchUserViewModel() {
        this.searchResultMap = new LinkedHashMap();
        this.currentKeyword$delegate = q.d(this, "");
        this.hostUser = TTLiveSDK.hostService().user();
    }

    public final void loadMore() {
        setLoadMoreLoading();
        com.bytedance.android.live.search.impl.search.viewmodel.a r0 = this.searchResultMap.get(getCurrentKeyword().getValue());
        if (r0 == null) goto L5;
        long r1 = r0.b;
    L6:
        long r3 = r1;
        IHostUser r2 = this.hostUser;
        if (r2 == null) goto L13;
        Observable r4 = r2.searchUserList(r3, (String) getCurrentKeyword().getValue(), 20, 1, 1, 0, DEFAULT_SEARCH_SOURCE);
        if (r4 == null) goto L13;
        Observable r5 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r5 == null) goto L13;
        Disposable r6 = r5.subscribe(new b(this), new c(this));
    L14:
        if (r6 == null) goto L17;
        bind(r6);
        return;
    L17:
        return;
    L13:
        r6 = null;
        goto L14
    L5:
        r1 = 0;
        goto L6
    }

    public final void searchUser() {
        String r0 = (String) getCurrentKeyword().getValue();
        setRefreshLoading();
        if (this.searchResultMap.containsKey(r0) == false) goto L11;
        com.bytedance.android.live.search.impl.search.viewmodel.a r1 = this.searchResultMap.get(r0);
        if (r1 == null) goto L13;
        List<User> r2 = r1.a;
        if (r2 == null) goto L9;
        List r3 = CollectionsKt.toMutableList(r2);
    L10:
        setRefreshResult(r3, r1.c);
        return;
    L9:
        r3 = null;
        goto L10
    L13:
        return;
    L11:
        refresh(r0);
    }

    public static final /* synthetic */ IHostUser access$getHostUser$p(LiveSearchUserViewModel r0) {
        return r0.hostUser;
    }

    public static final /* synthetic */ Map access$getSearchResultMap$p(LiveSearchUserViewModel r0) {
        return r0.searchResultMap;
    }

    private final void refresh(String r10) {
        IHostUser r0 = this.hostUser;
        if (r0 == null) goto L9;
        Observable r1 = r0.searchUserList(0, r10, 20, 1, 1, 0, DEFAULT_SEARCH_SOURCE);
        if (r1 == null) goto L9;
        Observable r2 = r1.compose(RxUtil.rxSchedulerHelper());
        if (r2 == null) goto L9;
        Disposable r12 = r2.subscribe(new d(this, r10), new e(this));
    L10:
        if (r12 == null) goto L13;
        bind(r12);
        return;
    L13:
        return;
    L9:
        r12 = null;
        goto L10
    }

    public static final /* synthetic */ void access$setHostUser$p(LiveSearchUserViewModel r0, IHostUser r1) {
        r0.hostUser = r1;
    }
}
