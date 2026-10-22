package jjb;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
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
public final class e implements com.ss.android.lark.passportc.task.c {
    public static final j0c.b d = null;
    public final m a;
    public final l b;
    public final n c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Scene.values().length];
            r0[Scene.SWITCH_BACKGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
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
        d = new j0c.b("make_rust_offline");
    }

    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    public final j0c.b F() {
        return d;
    }

    public final Observable<j0c.c> I(j0c.e r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Log.i("ComponentTask", "user{" + r3.a.a.userId + "} execute rust foreground offline task ,scene = " + r3.b);
        Scene r0 = r3.b;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L10;
        return Observable.create(new g(r3, this));
    L10:
        return Observable.create(new f(this, r3));
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    public static final void b(e r4, String r5) {
        Pair r0 = r4.c.i(r5);
        if (r0 != null) goto L5;
        Log.e("RustSDK", "MakeRustOfflineTask get container id is null ");
        return;
    L5:
        Log.i("RustSDK", "MakeRustOnlineTask unregisterReceiver container id : " + r0);
        r4.a.a(r5, r0);
    }

    @Inject
    public e(m r2, l r3, n r4) {
        Intrinsics.checkNotNullParameter(r2, "registry");
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        Intrinsics.checkNotNullParameter(r4, "rustSdk");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static final void a(e r1, String r2, boolean r3) {
        r1.getClass();
        if (com.ss.android.lark.featuregating.b.d.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
        ((jdb.e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.e.class)).Tc(r2, r3);
        return;
    L5:
        i3c.b.a(r2, r3);
    }
}
