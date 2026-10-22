package jjb;

import com.bytedance.lark.pb.tool.v1.AccountFromSource;
import com.bytedance.lark.pb.tool.v1.MakeUserOnlineV2Request;
import com.bytedance.lark.pb.tool.v1.UserLoginState;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import com.bytedance.lark.sdk.refactor.state.LoginState;
import com.ss.android.lark.framework.assembly.rust.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.passportc.task.d {
    public static final j0c.b h = null;
    public final l a;
    public final com.bytedance.lark.rustclient.internal.l b;
    public final m c;
    public final yzb.a d;
    public final jzb.a e;
    public final n f;

    @Inject
    public p g;

    public static final class a {
    }

    public final boolean G() {
        return true;
    }

    public final /* synthetic */ Observable H(j0c.e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    static {
        h = new j0c.b("make_rust_background_online");
    }

    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    public final j0c.b F() {
        return h;
    }

    public final Observable<j0c.c> I(j0c.e r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Log.i("ComponentTask", "user{" + r15.a.a.userId + "} execute rust background online task ,scene = " + r15.b);
        User r0 = r15.a.a;
        AccountFromSource r5 = null;
        if (this.f.f(r0.userId) != LoginState.BACKGROUND) goto L5;
        Log.i("ComponentTask", "user{" + r15.a.a.userId + "} already background online , skip rust background online");
        b(r0.userId);
        return Observable.just(new j0c.c(h, true, null, 12));
    L5:
        kzb.a r12 = this.d.a();
        String r7 = r0.getSession();
        if (r7 == null) goto L16;
        p r1 = this.g;
        if (r1 == null) goto L10;
        p r6 = r1;
    L11:
        MakeUserOnlineV2Request.Builder r2 = r6.a(r7, r0.userId, r0.getTenantId(), r0.getTenantTag(), r0.leanModeInfo, r12, this.e.a(r12.b));
        r2.destination_state(UserLoginState.BACKGROUND_ONLINE);
        Tenant r3 = r15.a.a.tenant;
        if (r3 == null) goto L14;
        r5 = AccountFromSource.fromValue(r3.fromSource);
    L14:
        r2.account_from_source = r5;
        return Observable.create(new d(this, r0, r2, r15));
    L10:
        Intrinsics.throwUninitializedPropertyAccessException("makeOnlineRequestFactory");
        r6 = null;
        goto L11
    L16:
        return Observable.just(new j0c.c(h, false, 2, "user.session is null"));
    }

    public final void b(String r5) {
        Pair r0 = this.f.i(r5);
        if (r0 != null) goto L5;
        Log.e("RustSDK", "MakeRustBackgroundOnlineTask get container id is null ");
        return;
    L5:
        this.a.k(((Number) r0.getFirst()).longValue());
        this.c.c(r5, r0, this.b);
    }

    public static final void a(c r1, String r2, boolean r3) {
        r1.getClass();
        if (com.ss.android.lark.featuregating.b.d.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
        ((jdb.e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.e.class)).Tc(r2, r3);
        return;
    L5:
        i3c.b.a(r2, r3);
    }

    @Inject
    public c(l r2, com.bytedance.lark.rustclient.internal.l r3, m r4, yzb.a r5, jzb.a r6, n r7) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        Intrinsics.checkNotNullParameter(r4, "registry");
        Intrinsics.checkNotNullParameter(r5, "userApi");
        Intrinsics.checkNotNullParameter(r6, "deviceService");
        Intrinsics.checkNotNullParameter(r7, "rustSdk");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
