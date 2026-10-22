package com.bytedance.android.livesdk.gameguess.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y;
import com.bytedance.android.livesdk.gameguess.api.PredictorGuessApi;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ita.i;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarPredictorTempAreaBehavior implements y {
    public DataCenter a;
    public Room b;
    public final Lazy c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ToolbarPredictorTempAreaBehavior a;
        public final /* synthetic */ View b;

        public a(ToolbarPredictorTempAreaBehavior r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            this.a.a(this.b.getContext());
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            Logger.e("ToolbarPredictorTempAreaBehavior : " + r4);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ToolbarPredictorTempAreaBehavior a;
        public final /* synthetic */ Context b;

        public c(ToolbarPredictorTempAreaBehavior r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            e r10 = (e) r9;
            if (r10 == null) goto L5;
            com.bytedance.android.livesdk.gameguess.model.a r0 = (com.bytedance.android.livesdk.gameguess.model.a) ((ExtraResponse) r10).data;
        L6:
            if (r0 == null) goto L14;
            com.bytedance.android.livesdk.gameguess.model.a r11 = (com.bytedance.android.livesdk.gameguess.model.a) ((ExtraResponse) r10).data;
            Logger.i("ToolbarPredictorTempAreaBehavior", r11.toString());
            if (r11.b() == false) goto L11;
            Context r12 = this.b;
            ToolbarPredictorTempAreaBehavior r1 = this.a;
            yx1.a.d(r12, r1.b, yx1.a.c(r1.a, false, false, false, true, false), "more", "more");
            return;
        L11:
            f2.b(2131921642, 0);
            return;
        L14:
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Context a;

        public d(Context r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            Logger.e("GameGuessPredictorWidget : " + r4);
            Context r5 = this.a;
            int r0 = i.a;
            if (NetworkUtils.isNetworkAvailable(r5) == true) goto L6;
            f2.b(2131916005, 0);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y
    public final void onShow() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y
    public final void yl() {
        f2.c("功能暂时不可用", 0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y
    public final boolean b80() {
        String r0 = yx1.a.c(this.a, false, false, false, true, false);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        return !r1;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public ToolbarPredictorTempAreaBehavior() {
        this.c = LazyKt.lazy(ToolbarPredictorTempAreaBehavior$compositeDisposable$2.INSTANCE);
    }

    public final void a(Context r7) {
        Room r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.id != 0) goto L8;
        return;
    L8:
        Disposable r8 = ((PredictorGuessApi) com.bytedance.android.live.network.c.b().e(PredictorGuessApi.class)).requestIsGameRoomByMergeTag(String.valueOf(r0.id), false, PredictorGuessApi.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r7), new d(r7));
        ((CompositeDisposable) this.c.getValue()).add(r8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (k.n(IUserService.class).user().isLogin() == true) goto L8;
        f0 r0 = TTLiveSDKContext.getHostService().h();
        f0 r1 = r0;
        Disposable r6 = r1.login(r5.getContext(), new l(new l.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r5), b.a);
        ((CompositeDisposable) this.c.getValue()).add(r6);
        return;
    L8:
        a(r5.getContext());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
        this.b = (Room) r3.get("data_room", null);
        ((Boolean) r3.get("data_is_portrait", Boolean.TRUE)).booleanValue();
    }
}
