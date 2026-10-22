package com.larus.uaigc.lynx;

import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.e4;
import com.larus.platform.service.c1;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\f\u0010\u001d\u001a\u00020\u0016*\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/uaigc/lynx/LotteryLynxWarmer;", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activity", "Landroid/app/Activity;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/CoroutineScope;Landroid/app/Activity;)V", "warmUpIvyPluginView", "Lcom/larus/platform/api/IvyPluginView;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "warmUpLynxView", "", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "releaseIvyPluginView", "createIvyPluginView", "lynxUrl", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "releaseSignal", "Lkotlinx/coroutines/CompletableDeferred;", "", "convertToActualUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LotteryLynxWarmer extends SafeLifecycleObserver {
    public static final /* synthetic */ int b = 0;
    public e4 a;

    public static final class a {
    }

    static {
    }

    public final void d() {
        FLogger.a.i("LotteryLynxWarmer", "releaseIvyPluginView triggered");
        e4 r0 = this.a;
        if (r0 == null) goto L16;
        View r1 = r0.getView();
        if (r1 == null) goto L7;
        ViewParent r2 = r1.getParent();
    L9:
        if ((r2 instanceof ViewGroup) == false) goto L11;
        ViewGroup r3 = (ViewGroup) r2;
    L12:
        if (r3 == null) goto L14;
        r3.removeView(r1);
    L14:
        this.a = null;
        return;
    L11:
        r3 = null;
        goto L12
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.larus.utils.lifecycle.SafeLifecycleObserver
    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        d();
    }

    public static final Object c(LotteryLynxWarmer r7, String r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof LotteryLynxWarmer$createIvyPluginView$1) == false) goto L7;
        LotteryLynxWarmer$createIvyPluginView$1 r0 = (LotteryLynxWarmer$createIvyPluginView$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        e4 r12 = (e4) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L21:
        if (((Boolean) r10).booleanValue() == false) goto L24;
        return r12;
    L24:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        FLogger.a.i("LotteryLynxWarmer", "createIvyPluginView, lynxUrl: " + r8);
        c1 r13 = c1.a;
        if (r13.d() == true) goto L17;
        r13.f();
    L17:
        Application r3 = AppHost.a.getApplication();
        CompletableDeferred r4 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r12 = r13.g(r3, r8, "", new b(r4));
        r0.L$0 = r12;
        r0.label = 1;
        r10 = r4.await(r0);
        if (r10 != r11) goto L21;
        return r11;
    L7:
        r0 = new LotteryLynxWarmer$createIvyPluginView$1(r7, r9);
        goto L8
    }
}
