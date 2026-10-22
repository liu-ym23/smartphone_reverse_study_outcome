package com.obric.assistant.settings.autogui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/settings/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$launcherAppsDeferred$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$launcherAppsDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends com.obric.assistant.settings.b>>, Object> {
    final /* synthetic */ Context $appContext;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$launcherAppsDeferred$1(ObricAutoGuiSettingsImpl r1, Context r2, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$launcherAppsDeferred$1> r3) {
        this.this$0 = r1;
        this.$appContext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$launcherAppsDeferred$1(this.this$0, this.$appContext, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<com.obric.assistant.settings.b>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r17);
        ObricAutoGuiSettingsImpl r3 = this.this$0;
        Context r0 = this.$appContext;
        Intrinsics.checkNotNull(r0);
        Set r4 = ObricAutoGuiSettingsImpl.i;
        r3.getClass();
        long r9 = SystemClock.elapsedRealtime();
    L34:
        th = move-exception;
        long r1 = SystemClock.elapsedRealtime() - r9;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppsInternal, cost = " + r1 + "ms, success = false");
        ObricAutoGuiSettingsImpl.t("getLauncherAppsInternal", r1, false);
        throw th;
    L6:
        if (ObricAutoGuiSettingsImpl.m() == true) goto L8;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppsInternal, return emptylist by permission denied");     // Catch: Throwable -> L34
        List r2 = CollectionsKt.emptyList();     // Catch: Throwable -> L34
    L32:
        long r5 = SystemClock.elapsedRealtime() - r9;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppsInternal, cost = " + r5 + "ms, success = true");
        ObricAutoGuiSettingsImpl.t("getLauncherAppsInternal", r5, true);
        return r2;
    L8:
        List r12 = r3.g;     // Catch: Throwable -> L34
        if (r12 == null) goto L11;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherApps, hit cache, size: " + r12.size());     // Catch: Throwable -> L34
        r2 = r12;
        goto L32
    L11:
        PackageManager r7 = r0.getPackageManager();     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L34
        Intent r6 = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L34
        r6.addCategory("android.intent.category.LAUNCHER");     // Catch: Throwable -> L34
        List<ResolveInfo> r8 = r7.queryIntentActivities(r6, 0);     // Catch: Throwable -> L34
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherApps, resolveList: " + r8.size());     // Catch: Throwable -> L34
        ArrayList r10 = new ArrayList(r8.size());     // Catch: Throwable -> L34
        Iterator<T> r13 = r8.iterator();     // Catch: Throwable -> L34
    L14:
        if (r13.hasNext() == false) goto L42;
        ResolveInfo r11 = (ResolveInfo) r13.next();     // Catch: Throwable -> L34
    L21:
        e = move-exception;
        FLogger.a.e("ObricAutoGuiSettingsImpl", "getLauncherApps, error: " + e);     // Catch: Throwable -> L34
        goto L14
    L17:
        if (ObricAutoGuiSettingsImpl.s(r11.activityInfo.name) == true) goto L14;
        String r14 = r11.activityInfo.packageName;     // Catch: Exception -> L21 Throwable -> L34
        String r15 = r11.loadLabel(r7).toString();     // Catch: Exception -> L21 Throwable -> L34
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherApps, pkg=" + r14 + ", appName=" + r15);     // Catch: Exception -> L21 Throwable -> L34
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L21 Throwable -> L34
        r10.add(new com.obric.assistant.settings.b(r14, r15, com.obric.assistant.common.utils.k.a(r15)));     // Catch: Exception -> L21 Throwable -> L34
    L42:
        PackageInfo r16 = r7.getPackageInfo("com.obric.appletapp", 0);     // Catch: Exception -> L29 Throwable -> L34
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherApps, doubaoMiniAppPackageInfo: " + r16);     // Catch: Exception -> L29 Throwable -> L34
        ApplicationInfo r18 = r16.applicationInfo;     // Catch: Exception -> L29 Throwable -> L34
        if (r18 == null) goto L31;
        String r19 = r18.loadLabel(r7).toString();     // Catch: Exception -> L29 Throwable -> L34
        r10.add(new com.obric.assistant.settings.b("com.obric.appletapp", r19, com.obric.assistant.common.utils.k.a(r19)));     // Catch: Exception -> L29 Throwable -> L34
    L31:
        r2 = CollectionsKt.toList(r10);     // Catch: Throwable -> L34
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherApps, build done, size: " + r2.size());     // Catch: Throwable -> L34
        r3.g = r2;     // Catch: Throwable -> L34
    L29:
        e = move-exception;
        FLogger.a.e("ObricAutoGuiSettingsImpl", "getLauncherApps, error: " + e);     // Catch: Throwable -> L34
        goto L31
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
