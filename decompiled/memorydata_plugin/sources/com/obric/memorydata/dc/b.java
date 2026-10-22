package com.obric.memorydata.dc;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.gson.Gson;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.ActivityPage;
import com.obric.memorydata.middleware.api.settings.App;
import com.obric.memorydata.middleware.api.settings.Extras;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.middleware.api.settings.Version;
import com.obric.memorydata.middleware.impl.settings.g;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0018\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0016\u0010-\u001a\u00020$*\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u00100\u001a\u0004\u0018\u000101*\u00020)2\u0006\u00102\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/memorydata/dc/PageContextManager;", "", "<init>", "()V", "TAG", "", "DEFAULT_TIMEOUT_MS", "", "KEY_SESSION_ID", "KEY_SESSION_RULE", "KEY_SESSION_STATE", "KEY_SESSION_RESULT", "KEY_SESSION_INTENT", "KEY_SESSION_CONTEXT", "KEY_SESSION_PACKAGE_NAME", "TYPE_PAGE_CONTEXT", "", "VALUE_SUCCESS", "VALUE_FAILURE", "VALUE_TIMEOUT", "VALUE_SECURE", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pendingSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/dc/PageContextManager$PendingPageContext;", "callbackRegistered", "", "isSourceLinkEnabled", "getPageContextSettings", "Lcom/obric/memorydata/middleware/impl/settings/PageContextSettings;", "capturePageContextAsync", "Lcom/obric/memorydata/dc/PageContextHandle;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/dc/PageContextRequest;", "registerCallbackIfNeeded", "", "unregisterCallback", "completeFromCallback", ObricMemoryConstants.KEY_SESSION_ID, "resultBundle", "Landroid/os/Bundle;", "parseState", "Lcom/obric/memorydata/dc/PageContextState;", "state", "onPostCheck", "Lcom/obric/memorydata/dc/PageContextData;", "callingPackage", "getIntentCompat", "Landroid/content/Intent;", "key", "PendingPageContext", "deep_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9848a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f9849b = null;
    private static final ConcurrentHashMap<String, a> c = null;
    private static boolean d;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/dc/PageContextManager$PendingPageContext;", "", "session", "Lcom/obric/memorydata/dc/PageContextSession;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/obric/memorydata/dc/PageContextResult;", "<init>", "(Lcom/obric/memorydata/dc/PageContextSession;Lkotlinx/coroutines/CompletableDeferred;)V", "getSession", "()Lcom/obric/memorydata/dc/PageContextSession;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "deep_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f9850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final w<PageContextResult> f9851b;

        public a(c r3, w<PageContextResult> r4) {
            w<PageContextResult> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "session");
            Intrinsics.checkNotNullParameter(r5, "deferred");
            this.f9850a = r3;
            this.f9851b = r5;
        }

        public final c a() {
            return this.f9850a;
        }

        public final w<PageContextResult> b() {
            return this.f9851b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9850a, r6.f9850a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9851b, r6.f9851b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9850a.hashCode() * 31) + this.f9851b.hashCode();
        }

        public String toString() {
            return "PendingPageContext(session=" + this.f9850a + ", deferred=" + this.f9851b + ')';
        }
    }

    static {
        f9848a = new b();
        f9849b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = new ConcurrentHashMap();
    }

    private b() {
    }

    private final Intent a(Bundle r3, String r4) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Object r2 = r3.getParcelable(r4, Intent.class);
    L7:
        return (Intent) ZeusTransformUtils.preCheckCast(r2, Intent.class, "com.obric.memorydata.plugin");
    L5:
        r2 = r3.getParcelable(r4);
        goto L7
    }

    private final PageContextState a(int r7) {
        if (r7 == 1) goto L15;
        if (r7 == 2) goto L19;
        if (r7 == 3) goto L18;
        if (r7 == 4) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "invalid page context state: " + r7, null, 4, null);
        return PageContextState.NULL;
    L17:
        return PageContextState.SECURE;
    L18:
        return PageContextState.TIMEOUT;
    L19:
        return PageContextState.FAILURE;
    L15:
        return PageContextState.SUCCESS;
    }

    private final void a(PageContextData r11, String r12) {
        SettingsManager r10 = SettingsManager.INSTANCE;
        String r0 = r10.getSettingsStr(SettingsManager.KEY_PAGE_CONTEXT_SETTINGS);
        if (r0 != null) goto L64;
    L4:
        Object r13 = null;
    L9:
        g r14 = (g) ZeusTransformUtils.preCheckCast(r13, g.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L12;
        List<App> r15 = r14.c();
    L13:
        String r1 = r11.getUrl();
        if (r1 == null) goto L45;
        if (StringsKt.startsWith(r1, "http", true) == true) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "invalid url", null, 4, null);
        r11.setUrl(null);
    L18:
        if (r12 == null) goto L45;
        if (r15 == null) goto L41;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r3.hasNext() == false) goto L26;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((App) ZeusTransformUtils.preCheckCast(r4, App.class, "com.obric.memorydata.plugin")).getPackageName(), r12) == false) goto L22;
    L27:
        App r5 = (App) ZeusTransformUtils.preCheckCast(r4, App.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L41;
        Extras r6 = r5.getExtras();
        if (r6 == null) goto L41;
        List<String> r7 = r6.getUrlBlackList();
        if (r7 == null) goto L41;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r8.hasNext() == false) goto L39;
        Object r9 = r8.next();
        if (StringsKt.startsWith$default(r1, (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L35;
    L40:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");
    L42:
        if (r2 == null) goto L45;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "url blacklist hit", null, 4, null);
        r11.setUrl(null);
        goto L45
    L39:
        r9 = null;
        goto L40
    L26:
        r4 = null;
    L41:
        r2 = null;
    L45:
        if (r11.getTitle() == null) goto L75;
        if (r15 == null) goto L59;
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L49:
        if (r16.hasNext() == false) goto L53;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((App) ZeusTransformUtils.preCheckCast(r17, App.class, "com.obric.memorydata.plugin")).getPackageName(), r12) == false) goto L49;
    L54:
        App r18 = (App) ZeusTransformUtils.preCheckCast(r17, App.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L59;
        Extras r19 = r18.getExtras();
        if (r19 == null) goto L59;
        String r110 = r19.getTitleMode();
    L61:
        if (Intrinsics.areEqual(r110, "self") == true) goto L76;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "title ignored", null, 4, null);
        r11.setTitle(null);
        return;
    L76:
        return;
    L53:
        r17 = null;
    L59:
        r110 = null;
        goto L61
    L75:
        return;
    L12:
        r15 = null;
        goto L13
    L64:
        r13 = r10.getGSON().fromJson(r0, g.class);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        goto L4
    }

    public static final /* synthetic */ void a(b r0, String r1, Bundle r2) {
        r0.a(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r9v8 */
    private final void a(String r10, Bundle r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "complete page context: " + r10, false, 4, null);
        a r0 = (a) ZeusTransformUtils.preCheckCast(c.remove(r10), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "ignore page context result, session not pending: " + r10, null, 4, null);
        return;
    L6:
        PageContextState r1 = a(r11.getInt("state"));
        Object r4 = null;
        if (r1 != PageContextState.SUCCESS) goto L22;
        String r3 = r11.getString("result");
        if (r3 == null) goto L16;
        Object r5 = new Gson().fromJson(r3, PageContextData.class);
        PageContextData r6 = (PageContextData) ZeusTransformUtils.preCheckCast(r5, PageContextData.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        f9848a.a(r6, r0.a().a().getPackageName());
        Unit r7 = Unit.INSTANCE;
    L14:
        if (r7 != null) goto L17;
        r4 = r5;
    L17:
        RunLog r9 = RunLog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("endSession: ").append(r10).append(", result: ").append(r3).append(", intent: ");
        if (r4 == null) goto L20;
        boolean r13 = true;
    L21:
        r9.debug("PageContextManager", r12.append(r13).toString());
        ?? r14 = r4;
        r4 = r5;
    L23:
        r0.b().a(new PageContextResult(r1, (PageContextData) ZeusTransformUtils.preCheckCast(r4, PageContextData.class, "com.obric.memorydata.plugin"), r14));
        return;
    L20:
        r13 = false;
        goto L21
    L13:
        r7 = null;
    L16:
        b r15 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        r5 = r4;
        r4 = f9848a.a(r11, MemorySourceLinkType.INTENT);
        goto L17
    L22:
        r14 = 0;
        goto L23
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return c;
    }

    private final g d() {
        SettingsManager r15 = SettingsManager.INSTANCE;
        Object r8 = new g(false, 0, null, null, 15, null);
        String r0 = r15.getSettingsStr(SettingsManager.KEY_PAGE_CONTEXT_SETTINGS);
        Object r2 = null;
        if (r0 != null) goto L14;
    L9:
        if (r2 == null) goto L13;
        r8 = r2;
    L13:
        return (g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.memorydata.plugin");
    L14:
        r2 = r15.getGSON().fromJson(r0, g.class);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        goto L9
    }

    public final com.obric.memorydata.dc.a a(PageContextRequest r21) {
        Intrinsics.checkNotNullParameter(r21, Ext.KEY_REQUEST);
        g r0 = d();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "get page context settings from memory_settings, enabled: " + r0.a(), false, 4, null);
        if (r0.a() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "page context not enabled", null, 4, null);
        return null;
    L6:
        long r5 = r0.b();
        if (AppContext.INSTANCE.getVersionCode() >= r5) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "page context not enabled, versionCode: " + AppContext.INSTANCE.getVersionCode() + " < " + r5, null, 4, null);
        return null;
    L10:
        ComponentName r2 = r21.getComponentName();
        if (Intrinsics.areEqual(r2.getPackageName(), AppContext.INSTANCE.getPackageName()) == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "page context not enabled, packageName: " + r2.getPackageName(), null, 4, null);
        return null;
    L14:
        long r6 = System.currentTimeMillis();
        com.obric.memorydata.utils.c r7 = com.obric.memorydata.utils.c.f13193a;
        String r8 = r2.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r8, "getPackageName(...)");
        com.obric.memorydata.utils.c.a r9 = com.obric.memorydata.utils.c.a(r7, r8, null, 2, null);
        if (r9 == null) goto L17;
        long r10 = r9.b();
    L18:
        List<App> r11 = r0.c();
        if (r11 == null) goto L28;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r12.hasNext() == false) goto L26;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((App) ZeusTransformUtils.preCheckCast(r13, App.class, "com.obric.memorydata.plugin")).getPackageName(), r2.getPackageName()) == false) goto L22;
    L27:
        App r14 = (App) ZeusTransformUtils.preCheckCast(r13, App.class, "com.obric.memorydata.plugin");
    L29:
        if (r14 != null) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "app config is null, componentName: " + r2, false, 4, null);
        return null;
    L32:
        List<Version> r15 = r14.getVersions();
        if (r15 != null) goto L35;
        r15 = CollectionsKt.emptyList();
    L35:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L36:
        boolean r19 = false;
        if (r18.hasNext() == false) goto L43;
        Object r110 = r18.next();
        if (r10 < ((Version) ZeusTransformUtils.preCheckCast(r110, Version.class, "com.obric.memorydata.plugin")).getMinVersion()) goto L41;
        r19 = true;
    L41:
        if (r19 == false) goto L36;
        r17.add(r110);
        goto L36
    L43:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r20.hasNext() == true) goto L46;
        Object r22 = null;
    L55:
        Version r23 = (Version) ZeusTransformUtils.preCheckCast(r22, Version.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L72;
        List<ActivityPage> r24 = r23.getActivities();
        if (r24 == null) goto L67;
        Iterator r25 = ((Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L61:
        if (r25.hasNext() == false) goto L65;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((ActivityPage) ZeusTransformUtils.preCheckCast(r26, ActivityPage.class, "com.obric.memorydata.plugin")).getActivity(), r2.getClassName()) == false) goto L61;
    L66:
        ActivityPage r27 = (ActivityPage) ZeusTransformUtils.preCheckCast(r26, ActivityPage.class, "com.obric.memorydata.plugin");
    L68:
        if (r27 == null) goto L71;
        String r28 = r27.getRules();
        if (r28 == null) goto L71;
    L73:
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin");
        if (r29 != null) goto L76;
    L79:
        boolean r30 = true;
    L80:
        if (r30 == false) goto L83;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "rule is null, componentName: " + r2, false, 4, null);
        return null;
    L83:
        b();
        String r1 = r0.d();
        if (r1 != null) goto L86;
        r1 = "";
    L86:
        String r31 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r31, "toString(...)");
        w r32 = y.a(null, 1, null);
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r31, new a(new c(r31, r2, r28, r1), r32));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "request page context: " + r31 + ", componentName: " + r2, false, 4, null);
        com.obric.memorydata.utils.c.c r111 = com.obric.memorydata.utils.c.c.f13202a;     // Catch: Throwable -> L89
        Bundle r112 = new Bundle();     // Catch: Throwable -> L89
        r112.putString(ObricMemoryConstants.KEY_SESSION_ID, r31);     // Catch: Throwable -> L89
        r112.putString(ObricMemoryConstants.KEY_PACKAGE_NAME, r2.getPackageName());     // Catch: Throwable -> L89
        r112.putString("rule", r28);     // Catch: Throwable -> L89
        r112.putString("context", r1);     // Catch: Throwable -> L89
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L89
        r19 = r111.a(1, r112);     // Catch: Throwable -> L89
    L91:
        if (r19 == true) goto L94;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "page context action not available", null, 4, null);
        c.remove(r31);
        return null;
    L94:
        i.a(f9849b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PageContextManager$capturePageContextAsync$1(r21, r31, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "page context request sent: " + r31 + ", cost: " + (System.currentTimeMillis() - r6), false, 4, null);
        return new com.obric.memorydata.dc.a(r31, (ar) ZeusTransformUtils.preCheckCast(r32, ar.class, "com.obric.memorydata.plugin"));
    L89:
        th = move-exception;
        RunLog.INSTANCE.error("PageContextManager", "request page context failed", th);
        goto L91
    L76:
        if (r29.length() == 0) goto L79;
        r30 = false;
    L71:
        r28 = r23.getRules();
        goto L73
    L65:
        r26 = null;
        goto L66
    L67:
        r27 = null;
        goto L68
    L72:
        r28 = null;
        goto L73
    L46:
        r22 = r20.next();
        if (r20.hasNext() == false) goto L55;
        long r33 = ((Version) ZeusTransformUtils.preCheckCast(r22, Version.class, "com.obric.memorydata.plugin")).getMinVersion();
    L50:
        Object r113 = r20.next();
        long r114 = ((Version) ZeusTransformUtils.preCheckCast(r113, Version.class, "com.obric.memorydata.plugin")).getMinVersion();
        if (r33 >= r114) goto L54;
        r22 = r113;
        r33 = r114;
    L54:
        if (r20.hasNext() == true) goto L50;
    L26:
        r13 = null;
        goto L27
    L28:
        r14 = null;
        goto L29
    L17:
        r10 = -1;
        goto L18
    }

    public final boolean a() {
        return d().a();
    }

    public final synchronized void b() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (d == false) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "registerCallbackIfNeeded ignored, already registered", false, 4, null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L19:
        boolean r0 = com.obric.memorydata.utils.c.c.f13202a.a(1, (com.obric.memorydata.utils.c.c.a) ZeusTransformUtils.preCheckCast(new PageContextManager$registerCallbackIfNeeded$registered$1(), com.obric.memorydata.utils.c.c.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        d = r0;     // Catch: Throwable -> L12
        if (r0 == true) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PageContextManager", "register page context callback failed: proxy returned false", null, 4, null);     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        RunLog.INSTANCE.error("PageContextManager", "register page context callback failed", th);     // Catch: Throwable -> L16
        goto L14
    }
}
