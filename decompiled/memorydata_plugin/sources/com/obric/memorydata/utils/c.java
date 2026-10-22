package com.obric.memorydata.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.rpc.model.func_callConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\tJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0006J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020!2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/utils/AppInfoManager;", "", "<init>", "()V", "cachedAppInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/utils/AppInfoManager$AppInfo;", "cachedUidPackageNames", "", "CACHE_TIME_OUT_TIME", "", "TAG", "normalizeSourceAppName", "pkgName", "appName", "getAppInfo", "activityName", "queryAppInfo", "queryPackageName", "uid", "isPackageInstalled", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getAppIconFromResId", "Landroid/graphics/drawable/Drawable;", "iconResId", "getLauncherComponent", "Landroid/content/ComponentName;", "context", "Landroid/content/Context;", "getApplicationIcon", "updateCache", "", "updateApplicationIcon", "AppInfo", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f13194b = null;
    private static final ConcurrentHashMap<Integer, String> c = null;
    private static final long d = 0;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\tHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/utils/AppInfoManager$AppInfo;", "", "appName", "", "pkgName", "versionCode", "", "versionName", "iconRes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getPkgName", "getVersionCode", "()J", "getVersionName", "getIconRes", "()I", "cachedTime", "isCacheTimeOut", "", "isCacheTimeOut$utils_obricRelease", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13196b;
        private final long c;
        private final String d;
        private final int e;
        private final long f;

        public a(String r2, String r3, long r4, String r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            Intrinsics.checkNotNullParameter(r3, "pkgName");
            Intrinsics.checkNotNullParameter(r6, "versionName");
            this.f13195a = r2;
            this.f13196b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
            this.f = SystemClock.elapsedRealtime();
        }

        public final String a() {
            return this.f13195a;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.f13195a = r2;
        }

        public final long b() {
            return this.c;
        }

        public final String c() {
            return this.d;
        }

        public final boolean d() {
            if ((SystemClock.elapsedRealtime() - this.f) <= c.a()) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13195a, r10.f13195a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13196b, r10.f13196b) == true) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f13195a.hashCode() * 31) + this.f13196b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "AppInfo(appName=" + this.f13195a + ", pkgName=" + this.f13196b + ", versionCode=" + this.c + ", versionName=" + this.d + ", iconRes=" + this.e + ')';
        }
    }

    static {
        f13193a = new c();
        f13194b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = TimeUnit.HOURS.toMillis(1);
    }

    private c() {
    }

    public static final /* synthetic */ long a() {
        return d;
    }

    public static /* synthetic */ a a(c r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.b(r1, r2);
    }

    private final a d(String r12) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppInfoManager", "queryAppInfo", false, 4, null);
        PackageManager r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(r11.getPackageInfo(r12, Integer.MIN_VALUE));     // Catch: Throwable -> L5
    L7:
        a r3 = null;
        if (Result.m1427isFailureimpl(r1) == false) goto L10;
        r1 = null;
    L10:
        PackageInfo r2 = (PackageInfo) ZeusTransformUtils.preCheckCast(r1, PackageInfo.class, "com.obric.memorydata.plugin");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        if (r2 == null) goto L14;
        String r13 = r11.getApplicationLabel(r2.applicationInfo).toString();     // Catch: Throwable -> L17
    L15:
        Object r14 = Result.m1421constructorimpl(r13);     // Catch: Throwable -> L17
    L20:
        if (Result.m1427isFailureimpl(r14) == false) goto L22;
        r14 = null;
    L22:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L25;
    L33:
        return r3;
    L25:
        if (r15 != null) goto L27;
        String r5 = "";
    L28:
        long r7 = r2.getLongVersionCode();
        String r16 = r2.versionName;
        if (r16 != null) goto L31;
        String r9 = "";
    L32:
        r3 = new a(r5, r12, r7, r9, r2.applicationInfo.icon);
        goto L33
    L31:
        r9 = r16;
        goto L32
    L27:
        r5 = r15;
        goto L28
    L14:
        r13 = null;
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final ComponentName a(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        PackageManager r5 = r2.getPackageManager();
        Intent r6 = new Intent("android.intent.action.MAIN");
        r6.addCategory("android.intent.category.LAUNCHER");
        r6.setPackage(r4);
        List<ResolveInfo> r7 = r5.queryIntentActivities(r6, 0);
        Intrinsics.checkNotNullExpressionValue(r7, "queryIntentActivities(...)");
        ResolveInfo r8 = (ResolveInfo) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r7), ResolveInfo.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L7;
        return null;
    L7:
        return new ComponentName(r8.activityInfo.packageName, r8.activityInfo.name);
    }

    public final String a(int r6) {
        if (r6 > 1000) goto L6;
        return func_callConstants.RoleType_System;
    L6:
        String r5 = (String) ZeusTransformUtils.preCheckCast(c.get(Integer.valueOf(r6)), String.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        return r5;
    L9:
        PackageManager r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r8 = Result.m1421constructorimpl(r7.getPackagesForUid(r6));     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r8) == false) goto L17;
        r8 = null;
    L17:
        String[] r9 = (String[]) ZeusTransformUtils.preCheckCast(r8, String[].class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (r9 != null) goto L20;
    L26:
        if (r1 == true) goto L29;
        String r10 = r9[0];
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r6), r10);
        return r10;
    L29:
        return null;
    L20:
        if (r9.length != 0) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == true) goto L26;
        r1 = false;
        goto L26
    L22:
        r4 = false;
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final String a(String r2, String r3) {
        if (Intrinsics.areEqual(r2, AppInfo.AppletApp.getPackageName()) == false) goto L5;
        String r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.utils_calendar_app_name, TypedValues.Custom.S_STRING, "utils_calendar_app_name"));
        Intrinsics.checkNotNull(r4);
        return r4;
    L5:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }

    public final boolean a(String r8) {
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r8, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppInfoManager", "Package " + r8 + " is not installed.", null, 4, null);
        return false;
    }

    public final Drawable b(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        PackageManager r4 = r1.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L5
        Intrinsics.checkNotNullExpressionValue(r4, "getPackageManager(...)");     // Catch: PackageManager.NameNotFoundException -> L5
        return r4.getApplicationIcon(r3);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final a b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "pkgName");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L9;
        return null;
    L9:
        ConcurrentHashMap<String, a> r7 = f13194b;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r7.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L12;
    L15:
        a r2 = d(r4);
        if (r2 == null) goto L18;
        r2.a(a(r4, r2.a()));
        ((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin")).put(r4, r2);
    L18:
        return r2;
    L12:
        if (r1.d() == true) goto L15;
        r1.a(a(r4, r1.a()));
        return r1;
    L5:
        r6 = false;
        goto L6
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "pkgName");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        ConcurrentHashMap<String, a> r1 = f13194b;
        r1.remove(r4);
        a r3 = d(r4);
        if (r3 == null) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin")).put(r4, r3);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L14;
        a r3 = d(r4);
        if (r3 == null) goto L15;
        ((Map) ZeusTransformUtils.preCheckCast(f13194b, Map.class, "com.obric.memorydata.plugin")).put(r4, r3);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
