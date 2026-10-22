package com.obric.aikernel.res;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.runtime.utils.d;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0010\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0002J\u000e\u0010*\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/aikernel/res/AssistantAutoUpdateStateMonitor;", "", "()V", "ACCOUNT_URI", "", "AUTO_UPDATE_URI", "KEY_IS_LOGIN", "KEY_WIFI_AUTO_UPDATE_ENABLED", "METHOD_ACCOUNT_INFO", "METHOD_AUTO_UPDATE_SETTING", "TAG", "blocked", "", "getBlocked", "()Z", "blockedFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getBlockedFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "blockedState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "context", "Landroid/content/Context;", "observer", "Landroid/database/ContentObserver;", "getObserver", "()Landroid/database/ContentObserver;", "observer$delegate", "Lkotlin/Lazy;", "refreshMutex", "Lkotlinx/coroutines/sync/Mutex;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "started", "queryBoolean", "uri", "method", "key", "refresh", "", AILabCheckPermissionTask.KEY_SOURCE, "refreshAsync", CommonConsts.APM_INNER_EVENT_COST_START, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f6000b = null;
    private static final kotlinx.coroutines.sync.a c = null;
    private static final ae<Boolean> d = null;
    private static boolean e;
    private static Context f;
    private static final Lazy g = null;

    static {
        f5999a = new a();
        f6000b = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = c.a(false, 1, null);
        d = at.a(true);
        g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(AssistantAutoUpdateStateMonitor$observer$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.b(r1);
    }

    private final void a(String r7) {
        i.a(f6000b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AssistantAutoUpdateStateMonitor$refreshAsync$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final boolean a(String r10, String r11, String r12) {
        Context r1 = f;
        if (r1 != null) goto L20;
        return false;
    L20:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Bundle r13 = ZeusProviderTransform.call(r1.getContentResolver(), Uri.parse(r10), r11, null, new Bundle(), "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        boolean r14 = true;
        if (r13 != null) goto L8;
    L10:
        r14 = false;
    L11:
        Object r15 = Result.m1421constructorimpl(Boolean.valueOf(r14));     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r15) == false) goto L19;
        r15 = false;
    L19:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        if (r13.getBoolean(r12, false) != true) goto L10;
    L13:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static final /* synthetic */ void b(a r0, String r1) {
        r0.a(r1);
    }

    private final void b(String r6) {
        if (f != null) goto L5;
        return;
    L5:
        boolean r0 = a("content://com.obric.assistant.provider.AssistantHybridAbilityProvider/query_auto_update_setting", "query_auto_update_setting", "wifi_auto_update_enabled");
        boolean r5 = a("content://com.obric.assistant.provider.AssistantHybridAbilityProvider/query_account_info", "query_account_info", "is_login");
        if (r0 == false) goto L10;
        if (r5 == false) goto L10;
        boolean r1 = false;
    L11:
        d.b(Boolean.valueOf(r1));
        d.f6216a.b("AssistantAutoUpdateStateMonitor", "assistant auto-update state source=" + r6 + " blocked=" + r1 + " wifiAutoUpdateEnabled=" + r0 + " isLogin=" + r5);
        return;
    L10:
        r1 = true;
        goto L11
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a c() {
        return c;
    }

    private final ContentObserver d() {
        return (ContentObserver) ZeusTransformUtils.preCheckCast(g.getValue(), ContentObserver.class, "com.obric.memorydata.plugin");
    }

    public final synchronized void a(Context r7) {
        monitor-enter(this);
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r8, "context");     // Catch: Throwable -> L32
        if (e == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        e = true;     // Catch: Throwable -> L32
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r1 == null) goto L12;
        r8 = r1;
    L12:
        f = r8;     // Catch: Throwable -> L32
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L25
        a r10 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Context r2 = f;     // Catch: Throwable -> L25
        if (r2 == null) goto L18;
        ContentResolver r3 = r2.getContentResolver();     // Catch: Throwable -> L25
        if (r3 == null) goto L18;
        ZeusProviderTransform.registerContentObserver(r3, Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider/query_auto_update_setting"), false, r10.d(), "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
    L18:
        Context r4 = f;     // Catch: Throwable -> L25
        if (r4 == null) goto L23;
        ContentResolver r5 = r4.getContentResolver();     // Catch: Throwable -> L25
        if (r5 == null) goto L23;
        ZeusProviderTransform.registerContentObserver(r5, Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider/query_account_info"), false, r10.d(), "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
    L23:
        r10.a("assistant_monitor_start");     // Catch: Throwable -> L25
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);     // Catch: Throwable -> L32
        if (r12 == null) goto L30;
        d.b(true);     // Catch: Throwable -> L32
        d.f6216a.f("AssistantAutoUpdateStateMonitor", "assistant auto-update monitor start failed: " + r12.getMessage());     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L32
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public final boolean a() {
        if (e == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(d.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return true;
    }

    public final ar<Boolean> b() {
        return k.a(d);
    }
}
