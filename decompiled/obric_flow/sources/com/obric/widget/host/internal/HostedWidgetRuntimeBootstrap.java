package com.obric.widget.host.internal;

import a3.f;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.e;
import com.bytedance.keva.KevaBuilder;
import com.obric.feature.miniapp.widget.AISdkInitController;
import com.obric.feature.miniapp.widget.WidgetSDKInitializer;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/widget/host/internal/HostedWidgetRuntimeBootstrap;", "", "<init>", "()V", "TAG", "", "DEFAULT_DEVICE_ID", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentActivity", "Landroid/app/Activity;", "ensureInitialized", "", "context", "Landroid/content/Context;", "registerActivityTracker", "app", "Landroid/app/Application;", "initKevaContext", "resolveDeviceId", "resolveAppName", "resolveAppId", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHostedWidgetRuntimeBootstrap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HostedWidgetRuntimeBootstrap.kt\ncom/obric/widget/host/internal/HostedWidgetRuntimeBootstrap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n1#2:196\n*E\n"})
public final class HostedWidgetRuntimeBootstrap {
    private static final String DEFAULT_DEVICE_ID = "0";
    public static final HostedWidgetRuntimeBootstrap INSTANCE = null;
    private static final String TAG = "HostedWidgetBootstrap";
    private static volatile Activity currentActivity;
    private static final AtomicBoolean initialized = null;

    static {
        INSTANCE = new HostedWidgetRuntimeBootstrap();
        initialized = new AtomicBoolean(false);
    }

    private HostedWidgetRuntimeBootstrap() {
    }

    public static /* synthetic */ Activity a() {
        return ensureInitialized$lambda$12$lambda$9$lambda$7();
    }

    public static final /* synthetic */ Activity access$getCurrentActivity$p() {
        return currentActivity;
    }

    public static final /* synthetic */ void access$setCurrentActivity$p(Activity r5) {
        currentActivity = r5;
    }

    public static /* synthetic */ Activity b() {
        return ensureInitialized$lambda$12$lambda$5();
    }

    public static /* synthetic */ Activity c() {
        return ensureInitialized$lambda$12$lambda$9$lambda$8();
    }

    public static /* synthetic */ Activity d() {
        return ensureInitialized$lambda$12$lambda$4();
    }

    private static final Activity ensureInitialized$lambda$12$lambda$4() {
        return currentActivity;
    }

    private static final Activity ensureInitialized$lambda$12$lambda$5() {
        return currentActivity;
    }

    private static final Activity ensureInitialized$lambda$12$lambda$9$lambda$7() {
        return currentActivity;
    }

    private static final Activity ensureInitialized$lambda$12$lambda$9$lambda$8() {
        return currentActivity;
    }

    private final void initKevaContext(Application r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        int r11 = KevaBuilder.f6713a;     // Catch: Throwable -> L4
        Object r12 = Result.m124constructorimpl(KevaBuilder.class.getMethod("setContext", new Class[]{Context.class}).invoke(KevaBuilder.class.getMethod("getInstance", null).invoke(null, null), new Object[]{r5.getApplicationContext()}));     // Catch: Throwable -> L4
    L7:
        if (Result.m131isSuccessimpl(r12) == false) goto L9;
        Log.i(TAG, "Keva context initialized for host package=" + r5.getPackageName());
    L9:
        Throwable r13 = Result.m127exceptionOrNullimpl(r12);
        if (r13 == null) goto L15;
        Log.w(TAG, "initKevaContext failed", r13);
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void registerActivityTracker(Application r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        r5.registerActivityLifecycleCallbacks(new HostedWidgetRuntimeBootstrap$registerActivityTracker$1$1(this));     // Catch: Throwable -> L4
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L12;
        Log.w(TAG, "registerActivityTracker failed", r12);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final int resolveAppId(Application r5) {
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        if (Build.VERSION.SDK_INT < 33) goto L8;
        ApplicationInfo r12 = e.c(r5.getPackageManager(), r5.getPackageName(), e.d());     // Catch: Throwable -> L6
    L9:
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L6
        Bundle r13 = r12.metaData;     // Catch: Throwable -> L6
        if (r13 == null) goto L12;
        Object r14 = r13.get("teatracker_app_id");     // Catch: Throwable -> L6
    L13:
        Object r15 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L6
    L17:
        if (Result.m130isFailureimpl(r15) == false) goto L19;
        r15 = null;
    L19:
        if (r15 != null) goto L21;
    L26:
        Integer r16 = null;
    L27:
        if (r16 != null) goto L29;
    L50:
        int r17 = r5.getResources().getIdentifier("app_id", "string", r5.getPackageName());     // Catch: Throwable -> L35
        if (r17 == 0) goto L37;
        Integer r18 = StringsKt.toIntOrNull(r5.getString(r17));     // Catch: Throwable -> L35
    L38:
        Object r19 = Result.m124constructorimpl(r18);     // Catch: Throwable -> L35
    L42:
        if (Result.m130isFailureimpl(r19) == true) goto L45;
        r10 = r19;
    L45:
        Integer r20 = (Integer) r10;
        if (r20 != null) goto L54;
        return 0;
    L54:
        return r20.intValue();
    L37:
        r18 = null;
    L35:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L42
    L29:
        if (r16.intValue() <= 0) goto L50;
        return r16.intValue();
    L21:
        if ((r15 instanceof Number) == false) goto L24;
        r16 = Integer.valueOf(((Number) r15).intValue());
        goto L27
    L24:
        if ((r15 instanceof String) == false) goto L26;
        r16 = StringsKt.toIntOrNull((String) r15);
        goto L27
    L12:
        r14 = null;
        goto L13
    L8:
        r12 = r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 128);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final String resolveAppName(Application r5) {
        String r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        CharSequence r12 = r5.getPackageManager().getApplicationLabel(r5.getApplicationInfo());     // Catch: Throwable -> L6
        if (r12 == null) goto L8;
        String r13 = r12.toString();     // Catch: Throwable -> L6
    L9:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L6
    L13:
        if (Result.m130isFailureimpl(r14) == false) goto L15;
        r14 = null;
    L15:
        String r15 = (String) r14;
        if (r15 == null) goto L23;
        if (StringsKt.isBlank(r15) == true) goto L20;
        r10 = r15;
    L20:
        if (r10 == null) goto L23;
        return r10;
    L23:
        return r5.getPackageName();
    L8:
        r13 = null;
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final String resolveDeviceId() {
        String r5 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L6
        Object r11 = MatrixTeaManager.class.getMethod("getDeviceId", null).invoke(MatrixTeaManager.class.getMethod("getInstance", null).invoke(null, null), null);     // Catch: Throwable -> L6
        if ((r11 instanceof String) == false) goto L8;
        String r12 = (String) r11;     // Catch: Throwable -> L6
    L9:
        Object r13 = Result.m124constructorimpl(r12);     // Catch: Throwable -> L6
    L13:
        if (Result.m130isFailureimpl(r13) == false) goto L15;
        r13 = null;
    L15:
        String r14 = (String) r13;
        if (r14 == null) goto L26;
        String r15 = StringsKt.trim(r14).toString();
        if (r15 == null) goto L26;
        if (StringsKt.isBlank(r15) == false) goto L22;
    L24:
        if (r5 == null) goto L26;
        return r5;
    L22:
        if (Intrinsics.areEqual(r15, "-1") == true) goto L24;
        r5 = r15;
    L26:
        return DEFAULT_DEVICE_ID;
    L8:
        r12 = null;
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void ensureInitialized(Context r28) {
        Intrinsics.checkNotNullParameter(r28, "context");
        AtomicBoolean r5 = initialized;
        if (r5.get() == false) goto L5;
        return;
    L5:
        Context r10 = r28.getApplicationContext();
        Integer r11 = null;
        if ((r10 instanceof Application) == false) goto L8;
        Application r12 = (Application) r10;
    L9:
        if (r12 != null) goto L11;
        return;
    L11:
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L13:
        if (r5.get() == false) goto L16;
        monitor-exit(this);
        return;
    L16:
        HostedWidgetRuntimeBootstrap r13 = INSTANCE;     // Catch: Throwable -> L36
        r13.registerActivityTracker(r12);     // Catch: Throwable -> L36
        r13.initKevaContext(r12);     // Catch: Throwable -> L36
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L20
        Object r15 = Result.m124constructorimpl(r12.getPackageManager().getPackageInfo(r12.getPackageName(), 0));     // Catch: Throwable -> L20
    L23:
        if (Result.m130isFailureimpl(r15) == false) goto L25;
        r15 = null;
    L25:
        PackageInfo r16 = (PackageInfo) r15;     // Catch: Throwable -> L36
        HostedWidgetRuntimeBootstrap r17 = INSTANCE;     // Catch: Throwable -> L36
        int r18 = r17.resolveAppId(r12);     // Catch: Throwable -> L36
        if (r16 == null) goto L38;
        long r19 = r16.getLongVersionCode();     // Catch: Throwable -> L36
        Long r110 = Long.valueOf(r19);     // Catch: Throwable -> L36
        if (r19 > 0) goto L31;
        r110 = null;
    L31:
        if (r110 == null) goto L38;
        String r20 = r110.toString();     // Catch: Throwable -> L36
        if (r20 == null) goto L38;
    L35:
        String r111 = r20;
        if (r16 == null) goto L48;
        String r21 = r16.versionName;     // Catch: Throwable -> L36
    L49:
        if (r21 != null) goto L52;
        r21 = "";
    L52:
        if (StringsKt.isBlank(r21) == false) goto L54;
        r21 = "0.0.0";
    L54:
        String r112 = r21;
        if ((r12.getApplicationInfo().flags & 2) == 0) goto L57;
        boolean r22 = true;
    L58:
        if (r22 == false) goto L60;
        String r23 = "local_test";
    L61:
        if (r18 <= 0) goto L64;
        String r24 = "nova_" + r18;     // Catch: Throwable -> L36
    L63:
        String r25 = r24;
        f r26 = new f(20);     // Catch: Throwable -> L36
        f r113 = new f(21);     // Catch: Throwable -> L36
        String r114 = r17.resolveDeviceId();     // Catch: Throwable -> L36
        String r115 = r17.resolveAppName(r12);     // Catch: Throwable -> L36
        Integer r27 = Integer.valueOf(r18);     // Catch: Throwable -> L36
        if (r18 <= 0) goto L68;
        r11 = r27;
    L68:
        if (r11 == null) goto L70;
        int r29 = r11.intValue();     // Catch: Throwable -> L36
    L71:
        String r116 = r12.getPackageName();     // Catch: Throwable -> L36
        boolean r210 = StringsKt.e(r23, "test", true);     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L36
        WidgetSDKInitializer.INSTANCE.init(r12, new AISdkInitController(r12, r26, r113, r114, r115, r29, r112, r111, r116, r23, r111, false, r22, r210, r25, false, "", false, ""), new f(22), new f(23));     // Catch: Throwable -> L74
        Object r30 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L74
    L77:
        if (Result.m131isSuccessimpl(r30) == false) goto L79;
        Unit r31 = (Unit) r30;     // Catch: Throwable -> L36
        initialized.set(true);     // Catch: Throwable -> L36
        Log.i(TAG, "WidgetSDK runtime initialized for host package=" + r12.getPackageName() + ", appId=" + r18);     // Catch: Throwable -> L36
    L79:
        Throwable r32 = Result.m127exceptionOrNullimpl(r30);     // Catch: Throwable -> L36
        if (r32 == null) goto L82;
        initialized.set(false);     // Catch: Throwable -> L36
        Log.e(TAG, "WidgetSDK runtime init failed for host package=" + r12.getPackageName(), r32);     // Catch: Throwable -> L36
    L82:
        monitor-exit(this);
        return;
    L74:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L36
        r30 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L36
        goto L77
    L70:
        r29 = 123456;
        goto L71
    L64:
        r24 = r12.getPackageName();     // Catch: Throwable -> L36
        goto L63
    L60:
        r23 = "release";
        goto L61
    L57:
        r22 = false;
        goto L58
    L48:
        r21 = null;
    L38:
        if (r16 == null) goto L45;
        int r34 = r16.versionCode;     // Catch: Throwable -> L36
        Integer r35 = Integer.valueOf(r34);     // Catch: Throwable -> L36
        if (r34 > 0) goto L43;
        r35 = null;
    L43:
        if (r35 == null) goto L45;
        r20 = r35.toString();     // Catch: Throwable -> L36
    L45:
        r20 = DEFAULT_DEVICE_ID;
    L20:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L36
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L36
        goto L23
    L8:
        r12 = null;
        goto L9
    }
}
