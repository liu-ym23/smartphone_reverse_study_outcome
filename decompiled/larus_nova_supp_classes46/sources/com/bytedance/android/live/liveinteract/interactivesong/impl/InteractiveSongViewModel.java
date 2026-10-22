package com.bytedance.android.live.liveinteract.interactivesong.impl;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.model.q2;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingInfoV2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001cJ\u0006\u0010\u001d\u001a\u00020\u000fJ\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/impl/InteractiveSongViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "curOrderSongUser", "", "getCurOrderSongUser", "()Ljava/lang/String;", "setCurOrderSongUser", "(Ljava/lang/String;)V", "orderSingListUserMicrophone", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/depend/message/IOrderSingInfoV2;", "closePlayingMv", "", "vid", "itemId", PbRequest.SwitchType.ROOM, "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "closeSource", "closeSuccessCB", "Lkotlin/Function0;", "fetchPlayModeInfo", "observeOrderSingListUserMicrophone", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "onDestroy", "turnOnOrderSing", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractiveSongViewModel extends DataContext {
    private final CompositeDisposable compositeDisposable;
    private String curOrderSongUser;
    private final MutableLiveData<IOrderSingInfoV2> orderSingListUserMicrophone;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
            Function0 r3 = this.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
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
        public final /* synthetic */ InteractiveSongViewModel a;

        public c(InteractiveSongViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData r0 = InteractiveSongViewModel.access$getOrderSingListUserMicrophone$p(this.a);
            k1 r3 = (k1) ((com.bytedance.android.live.network.response.e) r2).data;
            if (r3 == null) goto L7;
            p2 r4 = r3.getLinkmicPlayModeInfo();
            if (r4 == null) goto L7;
            IOrderSingInfoV2 r5 = r4.getOrderSingInfo();
        L8:
            r0.setValue(r5);
            return;
        L7:
            r5 = null;
            goto L8
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
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
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

    public final void onDestroy() {
        this.compositeDisposable.clear();
    }

    public InteractiveSongViewModel() {
        this.orderSingListUserMicrophone = new MutableLiveData(null);
        this.compositeDisposable = new CompositeDisposable();
    }

    public final String getCurOrderSongUser() {
        return this.curOrderSongUser;
    }

    public static final /* synthetic */ MutableLiveData access$getOrderSingListUserMicrophone$p(InteractiveSongViewModel r0) {
        return r0.orderSingListUserMicrophone;
    }

    public final void fetchPlayModeInfo(IRoom r4) {
        LinkApi r0 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        if (r4 == null) goto L5;
        long r1 = r4.getId();
    L6:
        RxUtilKt.c(r0.fetchPlayModeInfo(r1, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a), this.compositeDisposable);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void setCurOrderSongUser(String r1) {
        this.curOrderSongUser = r1;
    }

    public final void turnOnOrderSing(IRoom r12) {
        q2 r0 = (q2) b6.F.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        LinkApi r2 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        if (r12 == null) goto L8;
        long r3 = r12.getId();
    L9:
        String r13 = r0.c();
        if (r13 != null) goto L12;
        String r5 = "";
    L14:
        if (Intrinsics.areEqual(r0.d(), Boolean.TRUE) == false) goto L16;
        int r14 = LinkApi.OrderSingAutoEnlarge.ORDER_SING_AUTO_ENLARGE_OPEN.getValue();
    L17:
        int r6 = r14;
        Boolean r15 = r0.b();
        if (r15 == null) goto L20;
        boolean r16 = r15.booleanValue();
    L21:
        String r8 = r0.a();
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        Boolean r1 = r0.e();
        if (r1 == null) goto L27;
        boolean r9 = r1.booleanValue();
    L28:
        RxUtilKt.c(r2.orderSingTurnOn(r3, r5, r6, r16, r8, r9, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(e.a, f.a), this.compositeDisposable);
        return;
    L27:
        r9 = false;
        goto L28
    L20:
        r16 = false;
        goto L21
    L16:
        r14 = LinkApi.OrderSingAutoEnlarge.ORDER_SING_AUTO_ENLARGE_OFF.getValue();
        goto L17
    L12:
        r5 = r13;
        goto L14
    L8:
        r3 = 0;
        goto L9
    }

    public final void observeOrderSingListUserMicrophone(LifecycleOwner r2, Observer<IOrderSingInfoV2> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.orderSingListUserMicrophone.observe(r2, r3);
    }

    public final void closePlayingMv(String r8, String r9, IRoom r10, String r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r8, "vid");
        Intrinsics.checkNotNullParameter(r9, "itemId");
        Intrinsics.checkNotNullParameter(r11, "closeSource");
        LinkApi r1 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        if (r10 == null) goto L5;
        long r2 = r10.getId();
    L6:
        RxUtilKt.c(r1.closePlayingMv(r2, r9, r8, r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r12), b.a), this.compositeDisposable);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void closePlayingMv$default(InteractiveSongViewModel r6, String r7, String r8, IRoom r9, String r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        r6.closePlayingMv(r7, r8, r9, r10, r11);
    }
}
