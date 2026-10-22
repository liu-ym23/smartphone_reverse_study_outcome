package com.obric.memorydata.intelligence.b;

import android.content.Context;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.AppStateType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.af;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010$\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006%"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/AppUseCollect;", "", "<init>", "()V", "TAG", "", "WHITE_PACKAGE_LIST", "", "getWHITE_PACKAGE_LIST", "()Ljava/util/Set;", "curTopAppName", "getCurTopAppName", "()Ljava/lang/String;", "setCurTopAppName", "(Ljava/lang/String;)V", "MIN_USE_DURATION", "", "packageToAppNameMap", "", "preSummaryTimestamp", "", "fgPackageList", "Lcom/obric/memorydata/intelligence/predict/IFgPackage;", "getFgPackageList", "()Ljava/util/Map;", "updateFgPackageList", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isForeground", "", "curAppName", "getCurAppName", "setCurAppName", "curPackageName", "getCurPackageName", "setCurPackageName", "startCollect", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f9937b = null;
    private static String c;
    private static final Map<String, String> d = null;
    private static long e;
    private static final Map<String, c> f = null;
    private static String g;
    private static String h;

    /* JADX INFO: renamed from: com.obric.memorydata.intelligence.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/intelligence/predict/AppUseCollect$startCollect$1", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "onAppOpen", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0480a implements af.a {
        C0480a() {
        }

        private static final void a(String r2) {
            a.a(a.f9936a, r2, true);
            d.f9943a.a(r2, true);
        }

        private static final void b(String r2) {
            a.a(a.f9936a, r2, false);
            d.f9943a.a(r2, false);
        }

        public static /* synthetic */ void lambda$DOdT0wTr9l6Dpmiiw7nH8Cnt3K4(String r0) {
            a(r0);
        }

        public static /* synthetic */ void lambda$R01eQI3QK4HqkhoVTpktAKfscOw(String r0) {
            b(r0);
        }

        @Override // com.obric.memorydata.utils.af.a
        public void a(String r3, final String r4) {
            Intrinsics.checkNotNullParameter(r3, "appName");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            RunLog.INSTANCE.debug("AppUseCollect", "appName: " + r3 + " packageName: " + r4 + ' ');
            a.f9936a.b(r3);
            a.f9936a.c(r4);
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$a$a$DOdT0wTr9l6Dpmiiw7nH8Cnt3K4(r4));
            a.f9936a.a(r3);
            if (a.f9936a.a().contains(r4) == false) goto L5;
            return;
        L5:
            com.obric.memorydata.utils.c.a r2 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r4, null, 2, null);
            if (r2 == null) goto L9;
            String r5 = r2.c();
            if (r5 == null) goto L9;
        L10:
            Tracker r6 = Tracker.INSTANCE;
            JSONObject r0 = new JSONObject();
            r0.put("app_package", r4);
            r0.put("version_name", r5);
            Unit r7 = Unit.INSTANCE;
            r6.reportEvent("app_use_foreground", r0);
            return;
        L9:
            r5 = "";
            goto L10
        }

        @Override // com.obric.memorydata.utils.af.a
        public void b(String r3, final String r4) {
            Intrinsics.checkNotNullParameter(r3, "appName");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$a$a$R01eQI3QK4HqkhoVTpktAKfscOw(r4));
            if (a.f9936a.a().contains(r4) == false) goto L5;
            return;
        L5:
            com.obric.memorydata.utils.c.a r2 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r4, null, 2, null);
            if (r2 == null) goto L9;
            String r5 = r2.c();
            if (r5 == null) goto L9;
        L10:
            Tracker r6 = Tracker.INSTANCE;
            JSONObject r0 = new JSONObject();
            r0.put("app_package", r4);
            r0.put("version_name", r5);
            Unit r7 = Unit.INSTANCE;
            r6.reportEvent("app_use_background", r0);
            return;
        L9:
            r5 = "";
            goto L10
        }
    }

    static {
        f9936a = new a();
        f9937b = SetsKt.setOf(new String[]{"com.android.launcher3", "com.android.permissioncontroller"});
        c = "";
        d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        g = "";
        h = "";
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0, String r1, boolean r2) {
        r0.a(r1, r2);
    }

    private final void a(String r3, boolean r4) {
        if (f9937b.contains(r3) == false) goto L5;
        return;
    L5:
        if (r4 == false) goto L7;
        AppStateType r2 = AppStateType.FG;
    L9:
        if (Intrinsics.areEqual(r2.getState(), AppStateType.FG.getState()) == false) goto L11;
        f.put(r3, new c(r3, System.currentTimeMillis()));
        return;
    L11:
        f.remove(r3);
        return;
    L7:
        r2 = AppStateType.BG;
        goto L9
    }

    public final Set<String> a() {
        return f9937b;
    }

    public final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        c = r1;
    }

    public final Map<String, c> b() {
        return f;
    }

    public final void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        g = r1;
    }

    public final void c() {
        e = System.currentTimeMillis();
        String r5 = ba.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        String r1 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        h = r5;
        com.obric.memorydata.utils.c.a r6 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, h, null, 2, null);
        if (r6 == null) goto L11;
        String r7 = r6.a();
        if (r7 == null) goto L11;
        r1 = r7;
    L11:
        g = r1;
        af.f13160a.a((af.a) ZeusTransformUtils.preCheckCast(new C0480a(), af.a.class, "com.obric.memorydata.plugin"));
    }

    public final void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        h = r1;
    }
}
