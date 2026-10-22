package com.obric.update.impl.v2;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.t;
import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricBannerType;
import com.obric.update.api.v2.ObricUpdateAction;
import com.obric.update.impl.v2.handler.ObricScheduledUpdateHandler;
import com.obric.update.impl.v2.handler.ObricUpdateHandler;
import com.obric.update.impl.v2.handler.e;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\"H\u0002J!\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)H\u0002¢\u0006\u0002\u0010*J2\u0010+\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u001c\u0010(\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010.0,H\u0082@¢\u0006\u0002\u0010/J\u001a\u00100\u001a\u00020\"2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0018\u00105\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0096@¢\u0006\u0002\u00106J\u001a\u00107\u001a\u0004\u0018\u0001042\b\u00103\u001a\u0004\u0018\u000104H\u0096@¢\u0006\u0002\u00106J\u000e\u00108\u001a\u000202H\u0096@¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020\"2\u0006\u0010=\u001a\u00020>H\u0016J\u0012\u0010@\u001a\u00020\"2\b\b\u0001\u0010@\u001a\u00020;H\u0016J$\u0010A\u001a\u00020\"2\u001a\u0010B\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000204\u0018\u00010C0)H\u0016J\u001c\u0010D\u001a\u00020\"2\b\u0010E\u001a\u0004\u0018\u0001042\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J,\u0010H\u001a\u00020\"2\u0006\u0010I\u001a\u0002042\u0006\u0010J\u001a\u0002042\b\u0010K\u001a\u0004\u0018\u0001042\b\u0010L\u001a\u0004\u0018\u00010GH\u0016J\n\u0010M\u001a\u0004\u0018\u000104H\u0016J\b\u0010N\u001a\u000202H\u0016J\b\u0010O\u001a\u000202H\u0016J\b\u0010P\u001a\u00020QH\u0016J\n\u0010R\u001a\u0004\u0018\u000104H\u0016J\b\u0010S\u001a\u00020TH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001f¨\u0006V"}, d2 = {"Lcom/obric/update/impl/v2/ObricUpdateBitImpl;", "Lcom/obric/update/api/v2/IObricUpdateService;", "<init>", "()V", "flowContext", "Lcom/obric/update/impl/v2/context/ObricUpdateContext;", "stateHolder", "Lcom/obric/update/impl/v2/context/UpdateStateHolder;", "gateways", "Lcom/obric/update/impl/v2/UpdateGateways;", "pipelineReporter", "Lcom/obric/update/impl/v2/ObricUpdatePipelineReporter;", "initHandler", "Lcom/obric/update/impl/v2/handler/ObricInitHandler;", "getInitHandler", "()Lcom/obric/update/impl/v2/handler/ObricInitHandler;", "initHandler$delegate", "Lkotlin/Lazy;", "updateHandler", "Lcom/obric/update/impl/v2/handler/ObricUpdateHandler;", "getUpdateHandler", "()Lcom/obric/update/impl/v2/handler/ObricUpdateHandler;", "updateHandler$delegate", "installHandler", "Lcom/obric/update/impl/v2/handler/ObricInstallHandler;", "getInstallHandler", "()Lcom/obric/update/impl/v2/handler/ObricInstallHandler;", "installHandler$delegate", "scheduledUpdateHandler", "Lcom/obric/update/impl/v2/handler/ObricScheduledUpdateHandler;", "getScheduledUpdateHandler", "()Lcom/obric/update/impl/v2/handler/ObricScheduledUpdateHandler;", "scheduledUpdateHandler$delegate", "init", "", "context", "Landroid/content/Context;", "registerNetworkChangeListener", "ensureInit", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ensureInitSuspend", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkUpdate", "isAutoCheck", "", "scene", "", "isUpdateAvailable", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchLatestApkDownloadUrl", "checkForceUpdateForRomUnmatched", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUpdateState", "", "addUpdateListener", "listener", "Lcom/obric/update/api/v2/ObricUpdateListener;", "removeUpdateListener", "action", "setRequestTagHeaderProvider", "provider", "Landroid/util/Pair;", "reportUpdateEventLog", "event", "params", "Lorg/json/JSONObject;", "reportPipelineEvent", "stage", "result", "reason", DBDefinition.EXTRA, "triggerUpdateType", "isObricChannel", "isAutoDownloadInterferedByUser", "getPackageSizeInBytes", "", "versionName", "getBannerType", "Lcom/obric/update/api/v2/ObricBannerType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateBitImpl implements IObricUpdateService {
    public static final /* synthetic */ int i = 0;
    public final goa.a a;
    public final goa.b b;
    public final o c;
    public final m d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final ObricBannerType getBannerType() {
        boolean r0 = this.a.c;
        int r1 = this.b.b;
        if (r1 == 1) goto L11;
        if (r1 == 4) goto L14;
        if (r0 == false) goto L13;
        return ObricBannerType.WIFI_DOWNLOADING;
    L13:
        return ObricBannerType.DOWNLOADING;
    L14:
        return ObricBannerType.STATE_DOWNLOADED;
    L11:
        return ObricBannerType.AVAILABLE;
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final void init() {
        FLogger.a.i("ObricUpdateBitImpl", "init start");
        p().b();
        Object r0 = AppHost.a.getApplication().getSystemService("connectivity");     // Catch: Exception -> L11
        if ((r0 instanceof ConnectivityManager) == false) goto L6;
        ConnectivityManager r1 = (ConnectivityManager) r0;     // Catch: Exception -> L11
    L7:
        k r2 = new k(this);     // Catch: Exception -> L11
        if (r1 == null) goto L13;
        r1.registerNetworkCallback(new NetworkRequest.Builder().build(), r2);     // Catch: Exception -> L11
    L13:
        ((ObricScheduledUpdateHandler) this.h.getValue()).b();
        FLogger.a.i("ObricUpdateBitImpl", "init success");
        return;
    L6:
        r1 = null;
    L11:
        e = move-exception;
        FLogger.a.e("ObricUpdateBitImpl", "registerNetworkChangeListener failed: " + e);
        goto L13
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final boolean j() {
        boolean r0 = this.a.d;
        FLogger.a.i("ObricUpdateBitImpl", "isAutoDownloadInterferedByUser returns: " + r0);
        return r0;
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final int l() {
        return this.b.b;
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final String m() {
        if (this.a.b == false) goto L6;
        return "manual_check";
    L6:
        if (this.a.c == false) goto L8;
        return "wifi_auto_download";
    L8:
        return "launch_auto";
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final long o() {
        Regex r0 = ioa.a.a;
        this.c.a.getClass();
        String r1 = com.ss.android.update.d.x().H();
        Long r2 = null;
        if (r1 == null) goto L45;
        MatchResult r3 = Regex.find$default(ioa.a.a, r1, 0, 2, null);
        if (r3 == null) goto L45;
        Double r4 = StringsKt.toDoubleOrNull((String) ListProtector.get(r3.getGroupValues(), 1));
        if (r4 == null) goto L45;
        double r5 = r4.doubleValue();
        String r6 = ((String) ListProtector.get(r3.getGroupValues(), 3)).toUpperCase(Locale.ROOT);
        int r7 = r6.hashCode();
        if (r7 == 71) goto L41;
        if (r7 == 75) goto L37;
        if (r7 == 77) goto L33;
        if (r7 == 2267) goto L30;
        if (r7 == 2391) goto L27;
        if (r7 == 2453) goto L24;
    L42:
        Long r8 = Long.valueOf((long) r5);
    L43:
        r2 = r8;
        goto L45
    L24:
        if (r6.equals("MB") == false) goto L42;
    L35:
        double r9 = 1024;
        r8 = Long.valueOf((long) ((r5 * r9) * r9));
        goto L43
    L27:
        if (r6.equals("KB") == false) goto L42;
    L39:
        r8 = Long.valueOf((long) (r5 * ((double) 1024)));
        goto L43
    L30:
        if (r6.equals("GB") == false) goto L42;
    L44:
        double r10 = 1024;
        r8 = Long.valueOf((long) (((r5 * r10) * r10) * r10));
        goto L43
    L33:
        if (r6.equals("M") == true) goto L35;
    L37:
        if (r6.equals("K") == true) goto L39;
    L41:
        if (r6.equals("G") == true) goto L44;
    L45:
        if (r2 == null) goto L47;
        long r11 = r2.longValue();
    L48:
        FLogger.a.i("ObricUpdateBitImpl", "getPackageSizeInBytes returns: " + r11);
        return r11;
    L47:
        r11 = 0;
        goto L48
    }

    public final com.obric.update.impl.v2.handler.f p() {
        return (com.obric.update.impl.v2.handler.f) this.e.getValue();
    }

    public final ObricUpdateHandler q() {
        return (ObricUpdateHandler) this.f.getValue();
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final String versionName() {
        this.c.a.getClass();
        String r0 = com.ss.android.update.d.x().z();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public ObricUpdateBitImpl() {
        goa.a r0 = new goa.a();
        this.a = r0;
        goa.b r1 = new goa.b();
        this.b = r1;
        o r2 = new o();
        this.c = r2;
        this.d = new m(r0, r1, r2);
        this.e = LazyKt.lazy(new com.obric.update.impl.v2.a(this));
        this.f = LazyKt.lazy(new b(this));
        this.g = LazyKt.lazy(new c(this));
        this.h = LazyKt.lazy(new d(this));
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final boolean e() {
        return q().l();
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final void b(t r5) {
        Intrinsics.checkNotNullParameter(r5, "provider");
        FLogger.a.i("ObricUpdateBitImpl", "setRequestTagHeaderProvider called");
        p().getClass();
        Intrinsics.checkNotNullParameter(r5, "provider");
        yhc.n.a = new e(r5);
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final Object c(Continuation r4) {
        isUpdateAvailable.2 r0 = new isUpdateAvailable.2("about_app", this, null);
        p().b();
        return r0.invoke(r4);
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final void f(coa.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        FLogger.a.i("ObricUpdateBitImpl", "addUpdateListener: " + r5);
        goa.b r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "listener");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        r1.a.addIfAbsent(r5);     // Catch: Throwable -> L8
        r5.onStateUpdate(r1.b);     // Catch: Throwable -> L8
        if (r1.b != 2) goto L6;
        r5.onProgress(r1.c);     // Catch: Throwable -> L8
    L6:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L16;
        FLogger.a.e("UpdateStateHolder", "addListener failed", r7);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final Object g(Continuation<? super Boolean> r3) {
        checkForceUpdateForRomUnmatched.2 r0 = new checkForceUpdateForRomUnmatched.2(this, null);
        p().b();
        return r0.invoke(r3);
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final void i(coa.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        FLogger.a.i("ObricUpdateBitImpl", "removeUpdateListener: " + r5);
        goa.b r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "listener");
        r1.a.remove(r5);
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final void k(@ObricUpdateAction int r2) {
        e r0 = new e(r2, this);
        p().b();
        r0.invoke();
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final Object n(Continuation r4) {
        fetchLatestApkDownloadUrl.2 r0 = new fetchLatestApkDownloadUrl.2("boot_protector", this, null);
        p().b();
        return r0.invoke(r4);
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final void d(boolean r4, String r5) {
        p().b();
        FLogger.a.i("ObricUpdateBitImpl", "checkUpdate called with isAutoCheck:" + r4 + ", scene:" + r5);
        q().i(r4, r5, p().g);
        Unit r6 = Unit.INSTANCE;
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final void h(String r1, JSONObject r2) {
        l.a(r1, r2);
    }

    @Override // com.obric.update.api.v2.IObricUpdateService
    public final void a(String r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter("banner_show", "stage");
        Intrinsics.checkNotNullParameter(r3, "result");
        this.d.b("banner_show", r3, r4, r5);
    }
}
