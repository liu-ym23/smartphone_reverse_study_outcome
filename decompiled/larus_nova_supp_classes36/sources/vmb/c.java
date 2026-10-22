package vmb;

import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKSPIKtxKt;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import f0c.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends c0c.b implements vmb.a, chb.a {
    public final CopyOnWriteArraySet<Function0<Unit>> b;
    public final CopyOnWriteArraySet<Function0<Unit>> c;

    public static final class a {
    }

    static {
    }

    public static vmb.a rf() {
        OfficeSDKUserComponent r0 = OfficeSDKManager.getOfficeSDKUserComponent();     // Catch: Throwable -> L6
        if (r0 == null) goto L8;
        return (vmb.a) OfficeSDKSPIKtxKt.spiByDwarf(r0, vmb.a.class);
    L8:
        return null;
    L6:
        th = move-exception;
        Log.e("UserFeedBundleProxy", "spiByDwarf(IUserFeedBundle) failed", th);
        goto L8
    }

    @Override // vmb.a
    public final com.ss.android.lark.flow.feed.data.a Q() {
        vmb.a r0 = rf();
        if (r0 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] provideDoubaoFeedMigrateStatus skipped: delegate not ready");
        return null;
    L7:
        return r0.Q();
    }

    @Override // vmb.a
    public final String t() {
        vmb.a r0 = rf();
        if (r0 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] provideCurrentUserId skipped: delegate not ready");
        return null;
    L7:
        return r0.t();
    }

    @Override // vmb.a
    public final l w() {
        vmb.a r0 = rf();
        if (r0 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] provideRustClient skipped: delegate not ready");
        return null;
    L7:
        return r0.w();
    }

    public c(j r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        super(r2);
        this.b = new CopyOnWriteArraySet();
        this.c = new CopyOnWriteArraySet();
    }

    @Override // vmb.a
    public final s M(FlowMixedFeedFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "storeOwner");
        vmb.a r0 = rf();
        if (r0 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] createMixedFeedViewModel skipped: delegate not ready");
        return null;
    L7:
        return r0.M(r2);
    }

    @Override // chb.a
    public final void Nb(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.add(r2);
    }

    @Override // chb.a
    public final void ce(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.remove(r2);
    }

    @Override // chb.a
    public final void i8(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.b.add(r3);
        UserSession r0 = ((c0c.b) this).a.b();
        if (r0 != null) goto L6;
        r0 = ContainerConstsKt.a();
    L6:
        if (r0 == ContainerConstsKt.a()) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r3.invoke();
        return;
    L12:
        return;
    L8:
        r1 = false;
        goto L9
    }

    @Override // chb.a
    public final void k3(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.remove(r2);
    }

    public final void mf(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("UserFeedBundleProxy", "[FlowFeedLog] destroy, sessionKey = " + r4.b.a);
        Iterator<T> r5 = this.c.iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Function0 r1 = (Function0) r5.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.invoke();     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L4;
        Log.e("UserFeedBundleProxy", "[FlowFeedLog] onUserNotReady listener err", r6);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void of(g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("UserFeedBundleProxy", "[FlowFeedLog] onPrepared, sessionKey = " + r4.b.a);
        Iterator<T> r5 = this.b.iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Function0 r1 = (Function0) r5.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.invoke();     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L4;
        Log.e("UserFeedBundleProxy", "[FlowFeedLog] onUserReady listener err", r6);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // vmb.a
    public final s t0(ViewModelStoreOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "storeOwner");
        vmb.a r0 = rf();
        if (r0 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] createSidebarFeedViewModel skipped: delegate not ready");
        return null;
    L7:
        return r0.t0(r2);
    }

    public final void qf(g r3, g r4) {
        StringBuilder r0 = new StringBuilder("[FlowFeedLog] preparing, from=");
        String r1 = null;
        if (r3 == null) goto L7;
        UserSession r5 = r3.b;
        if (r5 == null) goto L7;
        String r6 = r5.a;
    L8:
        r0.append(r6);
        r0.append(", to=");
        if (r4 == null) goto L13;
        UserSession r7 = r4.b;
        if (r7 == null) goto L13;
        r1 = r7.a;
    L13:
        r0.append(r1);
        r0.append(", hasDelegate=");
        if (rf() == null) goto L16;
        boolean r8 = true;
    L17:
        r0.append(r8);
        Log.i("UserFeedBundleProxy", r0.toString());
        return;
    L16:
        r8 = false;
    L7:
        r6 = null;
        goto L8
    }
}
