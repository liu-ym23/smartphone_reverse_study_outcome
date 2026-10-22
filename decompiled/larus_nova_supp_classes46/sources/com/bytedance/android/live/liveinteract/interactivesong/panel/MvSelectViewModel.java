package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.livesdk.chatroom.model.interact.IGetMVListResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.IGetMVTabListResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J,\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectViewModel;", "Landroidx/lifecycle/ViewModel;", "", "getMvTabList", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVTab;", "tabName", "getMvList", "", "vid", "itemId", "", "mvType", "Lkotlin/Function0;", "selectSuccessCB", "selectMv", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/i;", "lastMvData", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/i;", "getLastMvData", "()Lcom/bytedance/android/live/liveinteract/interactivesong/panel/i;", "setLastMvData", "(Lcom/bytedance/android/live/liveinteract/interactivesong/panel/i;)V", "", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/f;", "requestCache", "Ljava/util/Map;", "getRequestCache", "()Ljava/util/Map;", "setRequestCache", "(Ljava/util/Map;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/g;", "mvSelectUIState", "Landroidx/lifecycle/MutableLiveData;", "getMvSelectUIState", "()Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvSelectViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private String itemId;
    private i lastMvData;
    private final MutableLiveData<g> mvSelectUIState;
    private Map<String, com.bytedance.android.live.liveinteract.interactivesong.panel.f> requestCache;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MvSelectViewModel a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.interactivesong.panel.f b;
        public final /* synthetic */ IMVTab c;

        public a(MvSelectViewModel r1, com.bytedance.android.live.liveinteract.interactivesong.panel.f r2, IMVTab r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            final com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            if (r9 == null) goto L19;
            com.bytedance.android.live.liveinteract.interactivesong.panel.f r0 = this.b;
            if (r0 == null) goto L18;
            IGetMVListResponse r1 = (IGetMVListResponse) r9.data;
            if (r1 == null) goto L15;
            List r2 = r1.getMvList();
            if (r2 == null) goto L15;
            Iterator<T> r3 = r2.iterator();
        L13:
            if (r3.hasNext() == false) goto L15;
            IOrderSingMVInfo r4 = (IOrderSingMVInfo) r3.next();
            r0.b.add(new i(r4, r4.getPlayStatus(), 2));
        L15:
            this.a.getRequestCache().put(this.c.getName(), new com.bytedance.android.live.liveinteract.interactivesong.panel.f(this.c, r0.b));
            com.bytedance.android.livesdk.ktvapi.util.d.b(this.a.getMvSelectUIState(), new MvSelectViewModel$getMvList$1$$special$$inlined$apply$lambda$1(this, r9));
            return;
        L18:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Context r0 = s1.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MvSelectViewModel a;

        public c(MvSelectViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            if (r4 == null) goto L7;
            com.bytedance.android.livesdk.ktvapi.util.d.b(this.a.getMvSelectUIState(), new MvSelectViewModel$getMvTabList$1$1(r4));
            this.a.getMvList(((IGetMVTabListResponse) r4.data).getDefaultTab());
            return;
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
            Context r0 = s1.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public e(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
            this.a.invoke();
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
            Context r0 = s1.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    public MvSelectViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.itemId = "";
        this.requestCache = new LinkedHashMap();
        MutableLiveData<g> r0 = new MutableLiveData();
        r0.setValue(new g(0));
        Unit r1 = Unit.INSTANCE;
        this.mvSelectUIState = r0;
    }

    public final void getMvTabList() {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        long r2 = r1.getRoomId();
    L8:
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getMvTab(r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a), this.compositeDisposable);
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final i getLastMvData() {
        return this.lastMvData;
    }

    public final MutableLiveData<g> getMvSelectUIState() {
        return this.mvSelectUIState;
    }

    public final Map<String, com.bytedance.android.live.liveinteract.interactivesong.panel.f> getRequestCache() {
        return this.requestCache;
    }

    public final void getMvList(IMVTab r7) {
        Intrinsics.checkNotNullParameter(r7, "tabName");
        if (this.requestCache.get(r7.getName()) != null) goto L5;
        this.requestCache.put(r7.getName(), new com.bytedance.android.live.liveinteract.interactivesong.panel.f(r7, 2));
    L5:
        com.bytedance.android.live.liveinteract.interactivesong.panel.f r0 = this.requestCache.get(r7.getName());
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L10;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L10;
        long r3 = r2.getRoomId();
    L11:
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getMvList(r3, r7.getId(), this.itemId).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r0, r7), b.a), this.compositeDisposable);
        return;
    L10:
        r3 = 0;
        goto L11
    }

    public final void setItemId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.itemId = r2;
    }

    public final void setLastMvData(i r1) {
        this.lastMvData = r1;
    }

    public final void setRequestCache(Map<String, com.bytedance.android.live.liveinteract.interactivesong.panel.f> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.requestCache = r2;
    }

    public final void selectMv(String r9, String r10, int r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "vid");
        Intrinsics.checkNotNullParameter(r10, "itemId");
        Intrinsics.checkNotNullParameter(r12, "selectSuccessCB");
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        long r2 = r1.getRoomId();
    L8:
        long r3 = r2;
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).bindMvToItem(r3, r9, r10, r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r12), f.a), this.compositeDisposable);
        return;
    L7:
        r2 = 0;
        goto L8
    }
}
