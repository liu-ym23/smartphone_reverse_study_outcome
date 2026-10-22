package com.obric.aiagent.assistant.utils;

import android.app.role.RoleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4374b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l0 f4375a;

    /* JADX INFO: renamed from: com.obric.aiagent.assistant.utils.a$a, reason: collision with other inner class name */
    private static final class C0094a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrivacyApprovalStatus f4376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f4377b;

        public C0094a(PrivacyApprovalStatus r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "status");
            this.f4376a = r10;
            this.f4377b = r11;
        }

        public /* synthetic */ C0094a(PrivacyApprovalStatus r10, long r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 2) == 0) goto L5;
            r11 = -1;
        L5:
            this(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0094a) == true) goto L8;
            return false;
        L8:
            C0094a r11 = (C0094a) r10;
            if (this.f4376a == r11.f4376a) goto L12;
            return false;
        L12:
            if (this.f4377b == r11.f4377b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f4376a.hashCode() * 31) + Long.hashCode(this.f4377b);
        }

        public String toString() {
            return "CachedStatus(status=" + this.f4376a + ", timestamp=" + this.f4377b + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new b(null);
        Intrinsics.checkNotNullExpressionValue(Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider"), "parse(\"content://com.obr…ntHybridAbilityProvider\")");
        Intrinsics.checkNotNullExpressionValue(Uri.parse("content://com.larus.nova.privacy.provider/status"), "parse(\"content://$AUTHORITY/status\")");
        f4374b = "android.permission.MANAGE_ROLE_HOLDERS";
    }

    public a() {
        new C0094a(PrivacyApprovalStatus.CannotObtain, 0, 2, null);
        this.f4375a = m0.a(z0.b());
    }

    public final AppEnableStatus a(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r11 == null) goto L36;
        int r12 = r11.length() - 1;
        boolean r13 = false;
        int r14 = 0;
        boolean r15 = false;
    L5:
        if (r14 > r12) goto L21;
        if (r15 == true) goto L8;
        int r16 = r14;
    L10:
        if (Intrinsics.compare(r11.charAt(r16), 32) > 0) goto L12;
        boolean r17 = true;
    L13:
        if (r15 == false) goto L14;
        if (r17 == false) goto L21;
        r12 = r12 - 1;
        goto L5
    L14:
        if (r17 == false) goto L15;
        r14 = r14 + 1;
        goto L5
    L15:
        r15 = true;
        goto L5
    L12:
        r17 = false;
        goto L13
    L8:
        r16 = r12;
    L21:
        if (r11.subSequence(r14, r12 + 1).toString().length() != 0) goto L23;
        r13 = true;
    L23:
        if (r13 == true) goto L36;
        int r18 = r10.getPackageManager().getApplicationEnabledSetting(r11);     // Catch: PackageManager.NameNotFoundException -> L32
        Log.i("ObricAppStatusUtil", "assistState = " + r18);     // Catch: PackageManager.NameNotFoundException -> L32
        if (r18 == 0) goto L31;
        if (r18 == 1) goto L31;
        return AppEnableStatus.AppDisabled;
    L31:
        return AppEnableStatus.Enabled;
    L32:
        e = move-exception;
        e.printStackTrace();
        return AppEnableStatus.NoInstalled;
    L36:
        return AppEnableStatus.NoInstalled;
    }

    public final String b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return null;
    L5:
        RoleManager r11 = (RoleManager) r10.getSystemService("role");
        if (r11 != null) goto L9;
        return null;
    L9:
        if (r11.isRoleAvailable("android.app.role.ASSISTANT") == false) goto L27;
        String r12 = f4374b;
        if (r10.checkSelfPermission(r12) == 0) goto L28;
        Log.e("ObricAppStatusUtil", "fail to get permission: " + r12);
        return null;
    L28:
        Method r13 = RoleManager.class.getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L23 SecurityException -> L25
        r13.setAccessible(true);     // Catch: Exception -> L23 SecurityException -> L25
        Object r14 = r13.invoke(r11, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L23 SecurityException -> L25
        if ((r14 instanceof List) == false) goto L17;
        List r15 = (List) r14;     // Catch: Exception -> L23 SecurityException -> L25
    L18:
        if (r15 == null) goto L21;
        String r16 = (String) CollectionsKt.getOrNull(r15, 0);     // Catch: Exception -> L23 SecurityException -> L25
        if (r16 == null) goto L21;
        return r16;
    L21:
        return "";
    L17:
        r15 = null;
    L25:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e.printStackTrace();
    L27:
        return null;
    }
}
