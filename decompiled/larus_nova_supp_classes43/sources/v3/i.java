package v3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import com.bytedance.ai.bridge.method.device.wifi.WifiError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ h a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ Function1<WifiError, Unit> d;
    public final /* synthetic */ Ref.BooleanRef e;
    public final /* synthetic */ ConnectivityManager f;

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        h r0 = this.a;
        Object r1 = r0.b;
        Ref.BooleanRef r10 = this.e;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r10.element == false) goto L7;
    L11:
        boolean r11 = false;
    L12:
        monitor-exit(r1);
        if (r11 == true) goto L15;
        return;
    L15:
        this.a.c.removeCallbacks(this.b);
        Function1<WifiError, Unit> r12 = this.d;
        f3.a.C0156a r13 = f3.a.c;
        f3.a r14 = f3.b.a;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r12.invoke(new WifiError(f3.b.g, "connect wifi unavailable"));
        return;
    L7:
        if (r0.g != this) goto L11;
        r11 = true;
        r10.element = true;     // Catch: Throwable -> L17
        r0.b();     // Catch: Throwable -> L17
        goto L12
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r10) {
        Intrinsics.checkNotNullParameter(r10, "network");
        h r0 = this.a;
        Object r1 = r0.b;
        Ref.BooleanRef r11 = this.e;
        monitor-enter(r1);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r11.element == false) goto L7;
    L11:
        boolean r12 = false;
    L12:
        monitor-exit(r1);
        if (r12 == true) goto L15;
        return;
    L15:
        this.a.c.removeCallbacks(this.b);
        ConnectivityManager r13 = this.f;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L21
        if (Build.VERSION.SDK_INT < 23) goto L19;
        r13.bindProcessToNetwork(r10);     // Catch: Throwable -> L21
    L19:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Object r15 = b.a;
        b.d(this.c);
        this.d.invoke(null);
        return;
    L21:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L7:
        if (r0.g != this) goto L11;
        r12 = true;
        r11.element = true;     // Catch: Throwable -> L25
        goto L12
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r10) {
        Intrinsics.checkNotNullParameter(r10, "network");
        h r11 = this.a;
        Object r0 = r11.b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r11.g != this) goto L7;
        r11.b();     // Catch: Throwable -> L10
    L7:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public i(h r1, g r10, Context r11, a r12, Ref.BooleanRef r13, ConnectivityManager r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
