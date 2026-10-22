package n62;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.j;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends n62.a implements s22.e.c {
    public final Context f;
    public final s22.e g;
    public final List<com.bytedance.android.live.base.model.user.f> h;
    public final com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e i;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            IBaseUser r2 = (IBaseUser) r1;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    /* JADX INFO: renamed from: n62.c$c, reason: collision with other inner class name */
    public static final class C0255c<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ s22.a b;
        public final /* synthetic */ long c;

        public C0255c(c r1, s22.a r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Response r8 = (Response) r7;
            int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.h(this.b, ((BaseResponse) r8).logId, this.c);
            j r1 = (j) ((BaseResponse) r8).data;
            if (r1 == null) goto L5;
            int r2 = r1.b();
        L6:
            j r3 = (j) ((BaseResponse) r8).data;
            if (r3 == null) goto L9;
            long r4 = r3.a();
        L10:
            j r9 = (j) ((BaseResponse) r8).data;
            if (r9 == null) goto L14;
            String r10 = r9.c();
            if (r10 == null) goto L14;
        L15:
            c r5 = this.a;
            s22.a r6 = this.b;
            Disposable r11 = r5.b;
            if (r11 == null) goto L18;
            r11.dispose();
        L18:
            ShareParams r13 = r5.a(r2, r4, r10);
            IHostBusiness r14 = k.f(IHostBusiness.class);
            if (r14 == null) goto L22;
            r14.shareInviteMsg(r5.f, r13, r5.h, new n62.b(r5, r6));
            return;
        L22:
            return;
        L14:
            r10 = BuildConfig.FLAVOR;
            goto L15
        L9:
            r4 = -1;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ s22.a b;
        public final /* synthetic */ long c;

        public d(c r1, s22.a r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            ApiServerException r5 = (Throwable) r4;
            int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.g(this.b, r5, this.c);
            if ((r5 instanceof ApiServerException) == false) goto L5;
            f2.c(r5.getPrompt(), 0);
        L5:
            Disposable r6 = this.a.b;
            if (r6 == null) goto L8;
            r6.dispose();
        L8:
            n62.a.e = false;
            f2.b(2131915710, 0);
        }
    }

    @Override // s22.e.c
    public final void Df() {
    }

    @Override // s22.e.c
    public final void Ij(long r1, long r3, Long r5, Long r6, Throwable r7) {
    }

    @Override // s22.e.c
    public final void Nc() {
    }

    @Override // s22.e.c
    public final void Va(long r1) {
    }

    @Override // s22.e.c
    public final void Y9(long r1) {
    }

    @Override // s22.e.c
    public final void a3(long r1, Throwable r3) {
    }

    @Override // s22.e.c
    public final void p6(long r1) {
    }

    @Override // s22.e.c
    public final void t9(long r1) {
    }

    @Override // s22.e.c
    public final void Oo() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        n62.a.d = false;
    }

    @Override // s22.e.c
    public final void Dm(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void W5(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    public final void c(CompositeDisposable r6) {
        if (f72.b.a().user().isLogin() == true) goto L8;
        Bundle r0 = new Bundle();
        com.bytedance.android.livesdk.user.f r1 = f72.b.a().user();
        Context r2 = this.f;
        l.a r3 = new l.a();
        r3.e = BuildConfig.FLAVOR;
        r3.h = r0;
        Disposable r4 = r1.login(r2, new l(r3)).subscribe(a.a, b.a);
        if (r4 == null) goto L10;
        RxUtilKt.c(r4, r6);
        return;
    L10:
        return;
    L8:
        n62.a.d = true;
        this.g.addListener(this);
        this.a = Disposables.fromAction(new n62.d(this));
        this.g.createChannel(this.i);
        int r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.m(this.i);
    }

    public final void d(s22.a r6) {
        long r0 = System.currentTimeMillis();
        n62.a.e = true;
        this.b = this.g.getInviteId(r6.getChannelId()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new C0255c(this, r6, r0), new d(this, r6, r0));
    }

    @Override // s22.e.c
    public final void d8(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void gf(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void hb(List<? extends s22.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "channels");
        Intrinsics.checkNotNullParameter(r2, "channels");
    }

    @Override // s22.e.c
    public final void kf(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void vg(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void D9(s22.a r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r2) {
        Intrinsics.checkNotNullParameter(r1, "channel");
        Disposable r3 = this.a;
        if (r3 == null) goto L5;
        r3.dispose();
    L5:
        d(r1);
        n62.a.d = false;
    }

    @Override // s22.e.c
    public final void Gh(s22.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "channel");
        Intrinsics.checkNotNullParameter(r1, "channel");
    }

    @Override // s22.e.c
    public final void Hh(long r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    @Override // s22.e.c
    public final void Rn(long r1, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public c(RoomContext r2, Context r3, s22.e r4, List<? extends com.bytedance.android.live.base.model.user.f> r5, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r6) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatManager");
        Intrinsics.checkNotNullParameter(r5, "inviteUsers");
        super(r2);
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
    }
}
