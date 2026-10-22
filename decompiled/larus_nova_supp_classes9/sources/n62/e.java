package n62;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends n62.a implements s22.e.c {
    public ShareParams f;
    public final String g;
    public final Context h;
    public final DataCenter i;
    public final s22.e j;
    public final i k;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ e a;
        public final /* synthetic */ s22.a b;
        public final /* synthetic */ String c;

        public b(e r1, s22.a r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            IBaseUser r2 = (IBaseUser) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    /* JADX INFO: renamed from: n62.e$e, reason: collision with other inner class name */
    public static final class RunnableC0256e implements Runnable {
        public final /* synthetic */ String a;

        public RunnableC0256e(String r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f2.c(this.a, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ s22.a b;
        public final /* synthetic */ long c;

        public f(e r1, s22.a r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Response r6 = (Response) r5;
            int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.h(this.b, ((BaseResponse) r6).logId, this.c);
            j r1 = (j) ((BaseResponse) r6).data;
            if (r1 == null) goto L5;
            int r2 = r1.b();
        L6:
            j r3 = (j) ((BaseResponse) r6).data;
            if (r3 == null) goto L9;
            long r4 = r3.a();
        L10:
            j r7 = (j) ((BaseResponse) r6).data;
            if (r7 == null) goto L14;
            String r8 = r7.c();
            if (r8 == null) goto L14;
        L15:
            e r9 = this.a;
            r9.f = r9.a(r2, r4, r8);
            Disposable r10 = this.a.b;
            if (r10 == null) goto L19;
            r10.dispose();
            return;
        L19:
            return;
        L14:
            r8 = BuildConfig.FLAVOR;
            goto L15
        L9:
            r4 = -1;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ s22.a b;
        public final /* synthetic */ long c;

        public g(e r1, s22.a r2, long r3) {
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
            if (r6 == null) goto L9;
            r6.dispose();
            return;
        }
    }

    static {
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
        if (f72.b.a().user().isLogin() == true) goto L9;
        Bundle r0 = new Bundle();
        com.bytedance.android.livesdk.user.f r1 = f72.b.a().user();
        Context r2 = this.h;
        l.a r3 = new l.a();
        r3.e = BuildConfig.FLAVOR;
        r3.h = r0;
        Disposable r4 = r1.login(r2, new l(r3)).subscribe(c.a, d.a);
        if (r4 == null) goto L13;
        RxUtilKt.c(r4, r6);
        return;
    L13:
        return;
    L9:
        if (this.k == null) goto L14;
        n62.a.d = true;
        this.j.addListener(this);
        this.a = Disposables.fromAction(new n62.g(this));
        this.j.createChannel(this.k.d);
        int r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.m(this.k.d);
        return;
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
    public final void D9(s22.a r6, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r7) {
        Intrinsics.checkNotNullParameter(r6, "channel");
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        i r1 = this.k;
        if (r1 != null) goto L8;
    L18:
        n62.a.d = false;
        return;
    L8:
        if (r1.a != true) goto L18;
        if (r1.c == false) goto L13;
        if (r7 == null) goto L13;
        String r8 = r7.c();
    L14:
        long r2 = this.k.b;
        if (r2 <= 0) goto L17;
        MainThreadPostUtils.c(new b(this, r6, r8), r2);
        goto L18
    L17:
        e(r6, r8);
    L13:
        r8 = null;
        goto L14
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
    public final void Rn(long r1, k r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void d(s22.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        e(r2, r3);
    }

    public final void e(s22.a r19, String r20) {
        if ((this.h instanceof FragmentActivity) == true) goto L6;
        this.i.put("cmd_room_channel_show_invite_dialog", new f62.b(false, r20, r19));
        return;
    L6:
        long r9 = System.currentTimeMillis();
        n62.a.e = true;
        ShareParams r13 = a(0, -1, BuildConfig.FLAVOR);
        Context r14 = this.h;
        IVSPlayerService r0 = jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(this.i);
        if (r1 == null) goto L11;
        r1.setVisibilityStatus(false);
    L11:
        int r2 = e62.a.a;
        int r15 = (int) UtilityKotlinExtentionsKt.j(e62.a.b(this.c));
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("openNewShareDialog, height is " + r15);
        DialogFragment r3 = jc1.k.n(IHostBusiness.class).loadLiveSharePanel(r14, r13, Boolean.FALSE, Boolean.valueOf(this.j.getConfig().j), r15, new n62.f(this, r9, r14, r19));
        if (r3 == null) goto L14;
        this.j.recordChatChannelDialog(this.g, r3);
    L14:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_invite_panel_show", null);
        if (TextUtils.isEmpty(r20) == true) goto L17;
        MainThreadPostUtils.c(new RunnableC0256e(r20), 200);
    L17:
        this.b = this.j.getInviteId(r19.getChannelId()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new f(this, r19, r9), new g(this, r19, r9));
    }

    public e(RoomContext r2, Context r3, DataCenter r4, s22.e r5, i r6) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "chatManager");
        super(r2);
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.g = "SharePanel";
    }
}
