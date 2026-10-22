package jjb;

import android.app.Application;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.lark.pb.im.v1.SetPassThroughPushCommandsRequest;
import com.bytedance.lark.pb.im.v1.SetPassThroughPushCommandsResponse;
import com.bytedance.lark.pb.tool.v1.AccountFromSource;
import com.bytedance.lark.pb.tool.v1.MakeUserOnlineV2Request;
import com.bytedance.lark.pb.tool.v1.UserLoginState;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import com.bytedance.lark.sdk.refactor.state.LoginState;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.framework.assembly.rust.p;
import com.ss.android.lark.framework.assembly.rust.r;
import com.ss.android.lark.framework.assembly.rust.s;
import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements com.ss.android.lark.passportc.task.d {
    public static final j0c.b m = null;
    public final l a;
    public final com.bytedance.lark.rustclient.internal.l b;
    public final m c;
    public final yzb.a d;
    public final jzb.a e;
    public final n f;
    public final k3c.a g;
    public final IAppStateSyncService h;

    @Inject
    public p i;

    @Inject
    public com.ss.android.lark.framework.assembly.rust.d j;
    public Scene k;
    public final l0c.b l;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Scene.values().length];
            r0[Scene.FIRST_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[Scene.SWITCH_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[Scene.FAST_ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[Scene.SWITCH_FOREGROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Scene.SWITCH_BACKGROUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[Scene.CREATE_USER_COMPONENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ h a;
        public final /* synthetic */ User b;
        public final /* synthetic */ MakeUserOnlineV2Request.Builder c;
        public final /* synthetic */ j0c.e d;
        public final /* synthetic */ long e;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ j0c.e a;
            public final /* synthetic */ h b;
            public final /* synthetic */ User c;
            public final /* synthetic */ ObservableEmitter<j0c.c> d;

            public a(j0c.e r1, h r2, User r3, long r4, ObservableEmitter<j0c.c> r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r6;
            }

            public final void accept(Object r8) {
                boolean r9 = ((Boolean) r8).booleanValue();
                Log.i("ComponentTask", "user{" + this.a.a.a.userId + "} foreground online finish result = " + r9);
                h.a(this.b, this.c.userId);
                h r0 = this.b;
                Application r1 = LarkContext.getApplication();
                r0.getClass();
                Log.i("RustSDK", "MakeRustOnlineTask onMakeOnlineSuccess");
                if (com.ss.android.lark.featuregating.b.d.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
                r0.h.a(com.ss.android.lark.appcontext.applifecycle2.api.a.b());
                r0.f.u(s.a);
                r0.g.B5(r1);
            L18:
                l0c.b r2 = this.b.l;
                if (r2 == null) goto L21;
                String r3 = h.m.a;
                r2.b();
            L21:
                ObservableEmitter<j0c.c> r4 = this.d;
                this.b.getClass();
                r4.onNext(new j0c.c(h.m, r9, null, 12));
                this.d.onComplete();
                return;
            L5:
                com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.b.a.a(com.ss.android.lark.appcontext.applifecycle2.api.a.b());
                List<Command> r5 = s.a;
                if (r5.isEmpty() == true) goto L13;
                com.bytedance.lark.pb.basic.v1.Command r6 = com.bytedance.lark.pb.basic.v1.Command.SET_PASS_THROUGH_PUSH_COMMANDS;
                SetPassThroughPushCommandsRequest.Builder r7 = new SetPassThroughPushCommandsRequest.Builder();
                List<Command> r10 = r5;
                ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
                Iterator<T> r12 = r10.iterator();
            L10:
                if (r12.hasNext() == false) goto L12;
                r11.add(Integer.valueOf(((Command) r12.next()).getValue()));
                goto L10
            L12:
                SetPassThroughPushCommandsRequest.Builder r13 = r7.commands(r11);
                final ProtoAdapter r14 = SetPassThroughPushCommandsResponse.ADAPTER;
                SdkSender.asynSendRequestNonWrap(r6, r13, null, new r(r14));
            L13:
                new i3c.b(c3c.f.a());
                NetworkUtils.NetworkType r15 = NetworkUtils.a(r1);     // Catch: Exception -> L16
                Log.i("StoreRust", "rust network onNetworkStateChange networkState = " + r15);     // Catch: Exception -> L16
                i3c.b.b(r15);     // Catch: Exception -> L16
            L16:
                e = move-exception;
                Log.e(e.getMessage());
                goto L18
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ j0c.e a;
            public final /* synthetic */ h b;
            public final /* synthetic */ User c;
            public final /* synthetic */ ObservableEmitter<j0c.c> d;

            public b(j0c.e r1, h r2, User r3, ObservableEmitter<j0c.c> r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void accept(Object r7) {
                Throwable r8 = (Throwable) r7;
                StringBuilder r0 = new StringBuilder("user{");
                r0.append(this.a.a.a.userId);
                r0.append("} foreground online failed error = ");
                String r1 = null;
                if (r8 == null) goto L5;
                String r2 = r8.getMessage();
            L6:
                r0.append(r2);
                Log.e("ComponentTask", r0.toString(), r8);
                h r3 = this.b;
                String r4 = this.c.userId;
                j0c.b r5 = h.m;
                r3.getClass();
                Log.e("MakeRustOnlineTask ->make rust online result is null", new RuntimeException("MakeRustOnlineTask ->make rust online result is null"), true);
                r3.c(r4, false);
                l0c.b r6 = this.b.l;
                if (r6 == null) goto L12;
                String r9 = h.m.a;
                if (r8 == null) goto L11;
                r8.getMessage();
            L11:
                r6.a();
            L12:
                ObservableEmitter<j0c.c> r10 = this.d;
                this.b.getClass();
                j0c.b r11 = h.m;
                if (r8 == null) goto L15;
                r1 = r8.getMessage();
            L15:
                r10.onNext(new j0c.c(r11, false, 3, r1));
                this.d.onComplete();
                return;
            L5:
                r2 = null;
                goto L6
            }
        }

        public c(h r1, User r2, MakeUserOnlineV2Request.Builder r3, j0c.e r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void subscribe(ObservableEmitter<j0c.c> r13) {
            Intrinsics.checkNotNullParameter(r13, "e");
            h r0 = this.a;
            n r1 = r0.f;
            String r2 = this.b.userId;
            MakeUserOnlineV2Request.Builder r3 = this.c;
            com.ss.android.lark.framework.assembly.rust.d r4 = r0.j;
            if (r4 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("onlineRequestParamsFactory");
            r4 = null;
        L6:
            Observable r5 = r1.k(r2, r3, r4.a(), false);
            j0c.e r9 = this.d;
            h r10 = this.a;
            User r11 = this.b;
            r5.subscribe(new a(r9, r10, r11, this.e, r13), new b(r9, r10, r11, r13));
            this.a.c(this.b.userId, true);
        }
    }

    public final List<j0c.b> dependencies() {
        return CollectionsKt.mutableListOf(new j0c.b[]{new j0c.b("update_device_id")});
    }

    static {
        m = new j0c.b("make_rust_online");
    }

    public final boolean G() {
        if (this.k == Scene.FAST_ONLINE) goto L5;
        return true;
    L5:
        return false;
    }

    public final j0c.b F() {
        return m;
    }

    public final Observable<j0c.c> H(j0c.e r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new e(this.c, this.b, this.f).I(r5);
    }

    public final Observable<j0c.c> I(j0c.e r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Log.i("ComponentTask", "user{" + r10.a.a.userId + "} execute rust foreground online task ,scene = " + r10.b);
        Scene r0 = r10.b;
        this.k = r0;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        switch(r1) {
            case -1: goto L14;
            case 0: goto L8;
            case 1: goto L18;
            case 2: goto L18;
            case 3: goto L18;
            case 4: goto L9;
            case 5: goto L14;
            case 6: goto L14;
            default: goto L8;
        };
    L9:
        long r7 = System.currentTimeMillis();
        User r5 = r10.a.a;
        if (this.f.f(r5.userId) != LoginState.BACKGROUND) goto L17;
        return Observable.create(new i(this, r5, r10, r7));
    L17:
        return b(r10);
    L14:
        Log.i("ComponentTask", "user{" + r10.a.a.userId + "} execute rust foreground online task failed ,scene = " + r10.b + " is invalid");
        j0c.b r2 = m;
        StringBuilder r3 = new StringBuilder("foreground online task failed , receive invalid scene = ");
        r3.append(r10.b);
        Observable<j0c.c> r11 = Observable.just(new j0c.c(r2, false, 1, r3.toString()));
        Intrinsics.checkNotNull(r11);
        return r11;
    L8:
        throw new NoWhenBranchMatchedException();
    L18:
        return b(r10);
    L5:
        r1 = b.a[r0.ordinal()];
        goto L6
    }

    public final Observable<j0c.c> b(j0c.e r17) {
        long r5 = System.currentTimeMillis();
        User r2 = r17.a.a;
        String r0 = r2.getSession();
        if (r0 != null) goto L5;
        r0 = "use-access-token";
    L5:
        String r9 = r0;
        kzb.a r14 = this.d.a();
        p r1 = this.i;
        AccountFromSource r3 = null;
        if (r1 == null) goto L8;
        p r8 = r1;
    L9:
        MakeUserOnlineV2Request.Builder r4 = r8.a(r9, r2.userId, r2.getTenantId(), r2.getTenantTag(), r2.leanModeInfo, r14, this.e.a(r14.b));
        r4.destination_state(UserLoginState.FOREGROUND_ONLINE);
        Tenant r6 = r17.a.a.tenant;
        if (r6 == null) goto L12;
        r3 = AccountFromSource.fromValue(r6.fromSource);
    L12:
        r4.account_from_source = r3;
        return Observable.create(new c(this, r2, r4, r17, r5));
    L8:
        Intrinsics.throwUninitializedPropertyAccessException("makeOnlineRequestFactory");
        r8 = null;
        goto L9
    }

    public static final void a(h r4, String r5) {
        Pair r0 = r4.f.i(r5);
        if (r0 != null) goto L5;
        Log.e("RustSDK", "MakeRustOnlineTask get container id is null ");
        return;
    L5:
        Log.i("RustSDK", "MakeRustOnlineTask set container id : " + r0);
        r4.a.k(((Number) r0.getFirst()).longValue());
        r4.c.c(r5, r0, r4.b);
    }

    public final void c(String r3, boolean r4) {
        if (com.ss.android.lark.featuregating.b.d.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
        ((jdb.e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.e.class)).Tc(r3, r4);
        return;
    L5:
        i3c.b.a(r3, r4);
    }

    @Inject
    public h(l r2, com.bytedance.lark.rustclient.internal.l r3, m r4, yzb.a r5, jzb.a r6, n r7, k3c.a r8, IAppStateSyncService r9) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        Intrinsics.checkNotNullParameter(r4, "registry");
        Intrinsics.checkNotNullParameter(r5, "userApi");
        Intrinsics.checkNotNullParameter(r6, "deviceService");
        Intrinsics.checkNotNullParameter(r7, "rustSdk");
        Intrinsics.checkNotNullParameter(r8, "userStoreService");
        Intrinsics.checkNotNullParameter(r9, "appStateService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.l = (l0c.b) ClaymoreServiceLoader.loadFirstOrNull(l0c.b.class);
    }
}
