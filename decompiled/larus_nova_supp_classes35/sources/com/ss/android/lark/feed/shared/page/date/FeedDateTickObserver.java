package com.ss.android.lark.feed.shared.page.date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/date/FeedDateTickObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "contextProvider", "Lkotlin/Function0;", "Landroid/content/Context;", "onRefreshList", BuildConfig.FLAVOR, "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "lastVisibleDayOfYear", BuildConfig.FLAVOR, "timeReceiver", "Landroid/content/BroadcastReceiver;", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "registerTimeReceiver", "unregisterTimeReceiver", "checkDayChange", "Companion", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDateTickObserver implements DefaultLifecycleObserver {
    public final Function0<Context> a;
    public final Function0<Unit> b;
    public int c;
    public FeedDateTickObserver$registerTimeReceiver$1 d;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onDestroy(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onDestroy(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.lark.feed.shared.page.date.FeedDateTickObserver$registerTimeReceiver$1] */
    public final void onStart(LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        int r5 = Calendar.getInstance().get(6);
        int r0 = this.c;
        if (r0 == (-1)) goto L6;
        if (r0 == r5) goto L6;
        Log.i("FeedDateTickObserver", "Foreground check: day changed, refreshing.");
        this.b.invoke();
    L6:
        this.c = r5;
        if (this.d != null) goto L20;
        Context r6 = (Context) this.a.invoke();
        if (r6 == null) goto L21;
        this.d = new FeedDateTickObserver$registerTimeReceiver$1(this);
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.TIME_TICK");
        r1.addAction("android.intent.action.TIME_SET");
        r1.addAction("android.intent.action.TIMEZONE_CHANGED");
        a(r6, this.d, r1);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        Log.e("FeedDateTickObserver", "registerReceiver failed", e);
        return;
    L21:
        return;
    }

    public final void onStop(LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        FeedDateTickObserver$registerTimeReceiver$1 r5 = this.d;
        if (r5 == null) goto L22;
        Context r0 = (Context) this.a.invoke();
        if (r0 != null) goto L19;
        return;
    L19:
        b(r0, r5);     // Catch: Throwable -> L11 Exception -> L13
    L15:
        this.d = null;
        return;
    L13:
        e = move-exception;
        Log.e("FeedDateTickObserver", "unregisterReceiver failed", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.d = null;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedDateTickObserver(Function0<? extends Context> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "contextProvider");
        Intrinsics.checkNotNullParameter(r3, "onRefreshList");
        this.a = r2;
        this.b = r3;
        this.c = -1;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L12;
        r1.unregisterReceiver(r2);
        return;
    L12:
    L8:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r2.toString());
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L14;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
