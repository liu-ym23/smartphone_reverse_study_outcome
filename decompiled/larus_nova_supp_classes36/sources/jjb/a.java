package jjb;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import com.bytedance.lark.sdk.refactor.state.LoginState;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.passportc.task.c {
    public static final j0c.b d = null;
    public final m a;
    public final l b;
    public final n c;

    /* JADX INFO: renamed from: jjb.a$a, reason: collision with other inner class name */
    public static final class C0282a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Scene.values().length];
            r0[Scene.SWITCH_FOREGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public final /* synthetic */ boolean G() {
        return false;
    }

    public final /* synthetic */ Observable H(j0c.e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    static {
        d = new j0c.b("make_rust_background_offline");
    }

    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    public final j0c.b F() {
        return d;
    }

    public final Observable<j0c.c> I(j0c.e r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Scene r0 = r9.b;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        Log.i("ComponentTask", "user{" + r9.a.a.userId + "} from background online switch to foreground online , skip rust background offline");
        b(r9.a.a.userId);
        Observable<j0c.c> r10 = Observable.just(new j0c.c(d, true, null, 12));
        Intrinsics.checkNotNull(r10);
        return r10;
    L9:
        User r2 = r9.a.a;
        LoginState r6 = this.c.f(r2.userId);
        Log.i("ComponentTask", "user{" + r9.a.a.userId + "} execute rust background offline task ,scene = " + r9.b + " , loginState = " + r6);
        if (r6 != LoginState.BACKGROUND) goto L13;
        return Observable.create(new jjb.b(this, r2, r9));
    L13:
        return Observable.just(new j0c.c(d, true, null, 12));
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    public final void b(String r5) {
        Pair r0 = this.c.i(r5);
        if (r0 != null) goto L5;
        Log.e("RustSDK", "MakeRustOfflineTask get container id is null ");
        return;
    L5:
        Log.i("RustSDK", "MakeRustOnlineTask unregisterReceiver container id : " + r0);
        this.a.a(r5, r0);
    }

    @Inject
    public a(m r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "registry");
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        this.a = r2;
        this.b = r3;
        this.c = (n) ((DwarfSPIEntryPoint) EntryPoints.get(Contexts.getApplication(LarkContext.getApplication()), DwarfSPIEntryPoint.class)).dwarfSPI().get(n.class);
    }

    public static final void a(a r1, String r2, boolean r3) {
        r1.getClass();
        if (com.ss.android.lark.featuregating.b.d.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
        ((jdb.e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.e.class)).Tc(r2, r3);
        return;
    L5:
        i3c.b.a(r2, r3);
    }
}
