package com.obric.aiagent.assistant.utils;

import android.app.role.RoleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.util.Log;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility;", "", "<init>", "()V", "TAG", "", "CONTENT_URI", "Landroid/net/Uri;", "kAssistantPkg", "AUTHORITY", "PRIVACY_CONTENT_URI", "PERMISSION_MANAGE_ROLE_HOLDERS", "FAKE_DEFAULT_ASSISTANT_KEY", "CACHE_DURATION_MS", "", "QUERY_TIMEOUT_MS", "checkAppEnableStatus", "Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "context", "Landroid/content/Context;", ObricMemoryConstants.KEY_PACKAGE_NAME, "isLogin", "", "mCachedStatus", "Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility$CachedStatus;", "mScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchUnexpiredCachedStatus", "checkApprovalAsync", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkApprovalSync", "cancellationSignal", "Landroid/os/CancellationSignal;", "getSystemDefaultAssistant", "getSystemProperty", "key", "defaultValue", "CachedStatus", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f5904b = null;
    private static final Uri c = null;
    private static final String d = null;
    private static final String e = null;
    private static volatile a f;
    private static final al g = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility$CachedStatus;", "", "status", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "timestamp", "", "<init>", "(Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;J)V", "getStatus", "()Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrivacyApprovalStatus f5905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f5906b;

        public a(PrivacyApprovalStatus r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "status");
            this.f5905a = r2;
            this.f5906b = r3;
        }

        public /* synthetic */ a(PrivacyApprovalStatus r1, long r2, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = -1;
        L5:
            this(r1, r2);
        }

        public final PrivacyApprovalStatus a() {
            return this.f5905a;
        }

        public final long b() {
            return this.f5906b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (this.f5905a == r8.f5905a) goto L12;
            return false;
        L12:
            if (this.f5906b == r8.f5906b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f5905a.hashCode() * 31) + Long.hashCode(this.f5906b);
        }

        public String toString() {
            return "CachedStatus(status=" + this.f5905a + ", timestamp=" + this.f5906b + ')';
        }
    }

    static {
        f5903a = new b();
        Uri r0 = Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(...)");
        f5904b = r0;
        Uri r1 = Uri.parse("content://com.larus.nova.privacy.provider/status");
        Intrinsics.checkNotNullExpressionValue(r1, "parse(...)");
        c = r1;
        d = "android.permission.MANAGE_ROLE_HOLDERS";
        e = "sys.debug.doubao.obric_fake_default_assist";
        f = new a(PrivacyApprovalStatus.CannotObtain, 0, 2, null);
        g = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private b() {
    }

    public static final /* synthetic */ al a() {
        return g;
    }

    private final a b() {
        long r0 = System.currentTimeMillis();
        a r4 = f;
        if ((r0 - r4.b()) < 5000) goto L5;
        return null;
    L5:
        if (r4.b() == (-1)) goto L9;
        return r4;
    L9:
        return null;
    }

    public final AppEnableStatus a(Context r9, String r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r10 == null) goto L39;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = r11.length() - 1;
        boolean r3 = false;
        int r4 = 0;
        boolean r5 = false;
    L5:
        if (r4 > r1) goto L21;
        if (r5 == true) goto L8;
        int r6 = r4;
    L10:
        if (Intrinsics.compare(r11.charAt(r6), 32) > 0) goto L12;
        boolean r7 = true;
    L13:
        if (r5 == false) goto L14;
        if (r7 == false) goto L21;
        r1 = r1 - 1;
        goto L5
    L14:
        if (r7 == false) goto L15;
        r4 = r4 + 1;
        goto L5
    L15:
        r5 = true;
        goto L5
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = r1;
    L21:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11.subSequence(r4, r1 + 1).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L23;
        r3 = true;
    L23:
        if (r3 == true) goto L39;
        int r12 = r8.getPackageManager().getApplicationEnabledSetting(r10);     // Catch: Exception -> L32 PackageManager.NameNotFoundException -> L36
        Log.i("ObricAppStatusUtil", "assistState = " + r12);     // Catch: Exception -> L32 PackageManager.NameNotFoundException -> L36
        if (r12 == 0) goto L31;
        if (r12 == 1) goto L31;
        return AppEnableStatus.AppDisabled;
    L31:
        return AppEnableStatus.Enabled;
    L36:
        e = move-exception;
        e.printStackTrace();
    L35:
        return AppEnableStatus.NoInstalled;
    L32:
        e = move-exception;
        e.printStackTrace();
    L39:
        return AppEnableStatus.NoInstalled;
    }

    public final PrivacyApprovalStatus a(Context r12, CancellationSignal r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        a r11 = b();
        if (r11 != null) goto L5;
        Cursor r15 = null;
        r15 = ZeusProviderTransform.query(r14.getContentResolver(), c, new String[]{EventBody.KEY_VALUE}, null, null, null, r13, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        if (r15 != null) goto L10;
    L15:
        Log.e("ObricAppStatusUtil", "[Assist-PrivApproval] query failed: cursor is null");     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        PrivacyApprovalStatus r16 = PrivacyApprovalStatus.CannotObtain;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
    L16:
        Log.d("ObricAppStatusUtil", "[Assist-PrivApproval] query result: " + r16);     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        if (r15 == null) goto L29;
    L18:
        r15.close();
    L29:
        a r17 = new a(r16, System.currentTimeMillis());
        f = r17;
        return r17.a();
    L10:
        if (r15.moveToFirst() == false) goto L15;
        if (r15.getInt(0) != 1) goto L14;
        r16 = PrivacyApprovalStatus.Approved;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        goto L16
    L14:
        r16 = PrivacyApprovalStatus.NotApproved;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
    L19:
        th = move-exception;
        if (r15 == null) goto L33;
        r15.close();
    L33:
        throw th;
    L25:
        e = move-exception;
        Log.e("ObricAppStatusUtil", "[Assist-PrivApproval] query timeout (" + e + ')', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        r16 = PrivacyApprovalStatus.Timeout;     // Catch: Throwable -> L19
        if (r15 == null) goto L29;
    L21:
        e = move-exception;
        Log.e("ObricAppStatusUtil", "[Assist-PrivApproval] query failed (exception, " + e + ')', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        r16 = PrivacyApprovalStatus.CannotObtain;     // Catch: Throwable -> L19
        if (r15 == null) goto L29;
    L5:
        return r11.a();
    }

    public final Object a(Context r8, Continuation<? super PrivacyApprovalStatus> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, ObricAppStatusUtility$checkApprovalAsync$1.class) == false) goto L7;
        ObricAppStatusUtility$checkApprovalAsync$1 r0 = (ObricAppStatusUtility$checkApprovalAsync$1) ZeusTransformUtils.preCheckCast(r11, ObricAppStatusUtility$checkApprovalAsync$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CancellationSignal r7 = (CancellationSignal) ZeusTransformUtils.preCheckCast(r0.L$0, CancellationSignal.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L21:
        PrivacyApprovalStatus r13 = (PrivacyApprovalStatus) ZeusTransformUtils.preCheckCast(r12, PrivacyApprovalStatus.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L25;
        Log.e("ObricAppStatusUtil", "[Assist-PrivApproval] query timeout");
        r7.cancel();
        return PrivacyApprovalStatus.Timeout;
    L25:
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        a r14 = b();
        if (r14 != null) goto L17;
        r7 = new CancellationSignal();
        Function2 r15 = (Function2) ZeusTransformUtils.preCheckCast(new ObricAppStatusUtility$checkApprovalAsync$result$1(r10, r7, null), Function2.class, "com.obric.memorydata.plugin");
        r0.L$0 = r7;
        r0.label = 1;
        r12 = da.b(200000, r15, r0);
        if (r12 != r2) goto L21;
        return r2;
    L17:
        return r14.a();
    L7:
        r0 = new ObricAppStatusUtility$checkApprovalAsync$1(this, r11);
        goto L8
    }

    public final String a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "defaultValue");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        b r7 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Class r10 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r11 = r10.getMethod("get", new Class[]{String.class, String.class}).invoke(r10, new Object[]{r8, r9});     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L5
        Object r12 = Result.m1421constructorimpl((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
    L7:
        Object r13 = r9;
        if (Result.m1427isFailureimpl(r12) == true) goto L12;
        r13 = r12;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean a(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        b r8 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Bundle r11 = ZeusProviderTransform.call(r10.getContentResolver(), f5904b, "is_login", null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        boolean r12 = r11.getBoolean("is_login");     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.m1421constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
        if (r14 == null) goto L15;
        Log.w("ObricAppStatusUtil", "isLogin error: " + r14.getMessage(), r14);
    L15:
        if (Result.m1427isFailureimpl(r13) == false) goto L18;
        r13 = false;
    L18:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        r12 = false;
    L9:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final String b(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return null;
    L5:
        RoleManager r0 = (RoleManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("role"), RoleManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual("true", a(e, "false")) == false) goto L13;
        return "com.larus.nova";
    L13:
        if (r0.isRoleAvailable("android.app.role.ASSISTANT") == false) goto L31;
        String r3 = d;
        if (r10.checkSelfPermission(r3) == 0) goto L32;
        Log.e("ObricAppStatusUtil", "fail to get permission: " + r3);
        return null;
    L32:
        Method r11 = RoleManager.class.getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L27 SecurityException -> L29
        r11.setAccessible(true);     // Catch: Exception -> L27 SecurityException -> L29
        Object r8 = r11.invoke(r0, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L27 SecurityException -> L29
        if (ZeusTransformUtils.instanceOf(r8, List.class) == false) goto L21;
        List r12 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 SecurityException -> L29
    L22:
        if (r12 == null) goto L25;
        String r13 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r12, 0), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 SecurityException -> L29
        if (r13 == null) goto L25;
        return r13;
    L25:
        return "";
    L21:
        r12 = null;
    L29:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        e.printStackTrace();
    L31:
        return null;
    }
}
