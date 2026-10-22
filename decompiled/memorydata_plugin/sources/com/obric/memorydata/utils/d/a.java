package com.obric.memorydata.utils.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.provider.Settings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/utils/reflect/BatteryManagerUtil;", "", "<init>", "()V", "TAG", "", "DEFAULT_DISCHARGE_CURRENT_MA", "", "MODE_COEFFICIENT_PERFORMANCE", "MODE_COEFFICIENT_BALANCED", "MODE_COEFFICIENT_SAVE", "MODE_COEFFICIENT_SUPER_SAVE", "batteryTimeRemainingTime", "", "isSaveMode", "", "getBatteryTimeRemainingViaPowerAdvisor", "(Z)Ljava/lang/Long;", "getBatteryTimeRemainingViaGREstimate", "()Ljava/lang/Long;", "getModeCoefficient", "getBatteryPercent", "", "context", "Landroid/content/Context;", "getBatteryCapacityMah", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13205a = null;

    static {
        f13205a = new a();
    }

    private a() {
    }

    private final int a(Context r4) {
        Intent r3 = ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r0 = r3.getIntExtra("level", -1);
        int r5 = r3.getIntExtra("scale", -1);
        if (r0 < 0) goto L11;
        if (r5 > 0) goto L10;
        return 0;
    L10:
        return (r0 * 100) / r5;
    L11:
        return 0;
    }

    private final Long a() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r2 = a(r0);
        int r1 = b(r0);
        if (r2 <= 0) goto L16;
        if (r1 <= 0) goto L18;
        Long r6 = Long.valueOf((long) ((((r1 * r2) * 60.0f) / 19000.0f) * b()));
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r6 = null;
    L13:
        if (r6 != null) goto L15;
        return null;
    L15:
        return Long.valueOf(r6.longValue() * 60000);
    L9:
        r3 = false;
        goto L10
    L18:
        return null;
    L16:
        return null;
    }

    private final float b() {
        ContentResolver r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        if (Settings.System.getInt(r6, "power_supersave_mode_open", 0) != 1) goto L6;
        return 3.23f;
    L6:
        if (Settings.System.getInt(r6, "POWER_PERFORMANCE_MODE_OPEN", 0) != 1) goto L9;
    L31:
        return 0.95f;
    L9:
        if (Settings.System.getInt(r6, "POWER_BALANCED_MODE_OPEN", 0) != 1) goto L12;
    L32:
        return 1.0f;
    L12:
        if (Settings.System.getInt(r6, "POWER_SAVE_MODE_OPEN", 0) == 1) goto L34;
        String r7 = Settings.System.getString(r6, "POWER_SAVE_PRE_HIDE_MODE");
        if (r7 == null) goto L32;
        int r0 = r7.hashCode();
        if (r0 == (-1762175919)) goto L28;
        if (r0 != (-1603157330)) goto L21;
        r7.equals("enhance");
        goto L32
    L21:
        if (r0 != (-1480388560)) goto L32;
        if (r7.equals("performance") == true) goto L31;
    L28:
        if (r7.equals("ultimate") == false) goto L32;
        return 1.23f;
    L34:
        return 1.23f;
    }

    private final int b(Context r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Class r1 = ZeusTransformUtils.forName("com.android.internal.os.PowerProfile", "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Object r9 = r1.getMethod("getBatteryCapacity", new Class[0]).invoke(r1.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r7}), new Object[0]);     // Catch: Throwable -> L10
        if (ZeusTransformUtils.instanceOf(r9, Double.class) == false) goto L6;
        Double r10 = (Double) ZeusTransformUtils.preCheckCast(r9, Double.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        if (r10 == null) goto L15;
        return (int) r10.doubleValue();
    L15:
        return 0;
    L6:
        r10 = null;
    L10:
        th = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BatteryManagerUtil", "getBatteryCapacityMah failed: " + th.getMessage(), null, 4, null);
        return 0;
    }

    private final Long b(boolean r9) {
        boolean r3 = true;
        Object r1 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.memorydata.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"poweradvisor"});     // Catch: Exception -> L28
        if (ZeusTransformUtils.instanceOf(r1, IBinder.class) == false) goto L6;
        IBinder r2 = (IBinder) ZeusTransformUtils.preCheckCast(r1, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
    L7:
        if (r2 != null) goto L9;
        return null;
    L9:
        Object r4 = ZeusTransformUtils.forName("android.os.IPowerAdvisor$Stub", "com.obric.memorydata.plugin").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r2});     // Catch: Exception -> L28
        if (r9 == false) goto L12;
        Object r10 = r4.getClass().getMethod("computePowerSavingModeBatteryTimeRemaining", new Class[0]).invoke(r4, new Object[0]);     // Catch: Exception -> L28
    L14:
        if (ZeusTransformUtils.instanceOf(r10, Long.class) == false) goto L16;
        Long r11 = (Long) ZeusTransformUtils.preCheckCast(r10, Long.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
    L17:
        if (r11 != null) goto L19;
        return null;
    L19:
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L22;
        r3 = false;
    L22:
        if (r3 == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L34;
        return Long.valueOf(r11.longValue() / ((long) 1000));
    L34:
        return null;
    L16:
        r11 = null;
        goto L17
    L12:
        r10 = r4.getClass().getMethod("computeBatteryTimeRemaining", new Class[0]).invoke(r4, new Object[0]);     // Catch: Exception -> L28
        goto L14
    L6:
        r2 = null;
    L28:
        e = move-exception;
        RunLog.INSTANCE.error("BatteryManagerUtil", "computePowerSavingModeBatteryTimeRemaining e: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    public final long a(boolean r4) {
        if (Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R") == false) goto L7;
        Long r3 = a();
        if (r3 != null) goto L10;
        return -1;
    L10:
        return r3.longValue();
    L7:
        r3 = b(r4);
        if (r3 != null) goto L10;
        return -1;
    }
}
