package com.obric.memorydata.intelligence.b;

import android.content.Context;
import android.provider.Settings;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.database.dao.AppUsageDao;
import com.obric.memorydata.database.entity.AppStateType;
import com.obric.memorydata.database.entity.ae;
import com.obric.memorydata.database.entity.af;
import com.obric.memorydata.database.entity.ci;
import com.obric.memorydata.database.entity.ib;
import com.obric.memorydata.database.entity.n;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u001c\u0010\u0014\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0016\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001dJ\u001e\u0010#\u001a\u00020\u00122\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002J\u0006\u0010%\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/intelligence/predict/PreLaunch;", "", "<init>", "()V", "MAYBE_LAUNCH_PKG_FROM_PREDICT_RESULT", "", "LONG_TIME_NOT_LAUNCH_APP", "NEXT_LAUNCH_APP_PREDICT_RESULT", "TAG", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "sPredictHotApp", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "NOT_USE_APP_THRESHOLD_DAY", "", "curPredictLaunchApp", "collectDataAndTrain", "", "inferenceHour", "savePredictResultToDB", "result", "", "", "reportAppLaunchData", "appUsage", "Lcom/obric/memorydata/database/entity/AppUsageEntity;", "reportTrackerResult", "isRight", "", "predictAppName", "realAppName", "saveLaunchToDB", ObricMemoryConstants.KEY_PACKAGE_NAME, "isForeground", "notifyAppLaunchToFW", "bayesResultSort", "collectNotLaunchApp", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9944b = null;
    private static final ArrayList<String> c = null;
    private static String d;

    static {
        f9943a = new d();
        f9944b = d.class.getSimpleName();
        c = new ArrayList();
        d = "";
    }

    private d() {
    }

    private final void a(n r9) {
        List<String> r8 = AppSettingsManager.INSTANCE.getReportPackageNameBlackListSetting().getBlackList();
        if (r8 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L10;
        return;
    L10:
        long r2 = System.currentTimeMillis();
        long r4 = r2 - ((long) 3600000);
        Map<String, ? extends Object> r11 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("package_name", r9.a()), TuplesKt.to("longitude", Double.valueOf(r9.b())), TuplesKt.to("latitude", Double.valueOf(r9.c())), TuplesKt.to("app_usage_connection_type", Integer.valueOf(r9.d())), TuplesKt.to("app_usage_timestamp", Long.valueOf(r9.e())), TuplesKt.to("app_usage_state", r9.f())});
        ae r12 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getBatteryStateDao().queryLastRecord(r4, r2);
        if (r12 == null) goto L13;
        r11.put("battery_event", Integer.valueOf(r12.d()));
        r11.put("battery_charge_type", Integer.valueOf(r12.e()));
        r11.put("battery_level", Double.valueOf(r12.f()));
        r11.put("battery_temperature", Integer.valueOf(r12.g()));
        r11.put("battery_is_power_connect", Boolean.valueOf(r12.h()));
    L13:
        af r13 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getBluetoothDeviceDao().queryLastRecords(r4, r2);
        if (r13 == null) goto L16;
        r11.put("bluetooth_state", Integer.valueOf(r13.d()));
        r11.put("bluetooth_mac", r13.e());
        r11.put("bluetooth_name", r13.f());
        r11.put("bluetooth_type", r13.getType());
    L16:
        ci r14 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLightSensorDao().queryLastRecords(r4, r2);
        if (r14 == null) goto L19;
        r11.put("light_sensor_value", Float.valueOf(r14.d()));
    L19:
        ib r15 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScreenBrightnessDao().queryLastRecords(r4, r2);
        if (r15 == null) goto L22;
        r11.put("screen_brightness_brightness", Integer.valueOf(r15.d()));
    L22:
        Tracker.INSTANCE.reportWithSystemId(OsTeaTrackerEventId.APP_USAGE_INFO.getValue(), r11);
        return;
    L5:
        if (r8.contains(r9.a()) != true) goto L7;
        r10 = true;
        goto L8
    }

    public final void a() {
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r3 = f9944b;
        Intrinsics.checkNotNullExpressionValue(r3, "TAG");
        IRunLog.a.a(r2, r3, "collectNotLaunchApp", false, 4, null);
        long r12 = System.currentTimeMillis();
        ArrayList r14 = new ArrayList();
        r14.addAll((Collection) ZeusTransformUtils.preCheckCast(b.c(), Collection.class, "com.obric.memorydata.plugin"));
        AppUsageDao r8 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAppUsageDao();
        List<String> r9 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        List<n> r15 = r8.queryRecords(r9, r12 - 259200000, r12);
        HashSet r0 = new HashSet();
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(b.c(), Collection.class, "com.obric.memorydata.plugin"));
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r0.remove(((n) ZeusTransformUtils.preCheckCast(r16.next(), n.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        JSONArray r17 = new JSONArray();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r17.put((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        Settings.Global.putString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "long_time_not_launch_app", r17.toString());
    }

    public final void a(String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (a.f9936a.a().contains(r13) == false) goto L5;
        return;
    L5:
        if (r14 == false) goto L7;
        AppStateType r15 = AppStateType.FG;
    L8:
        n r16 = new n(r13, 0.0d, 0.0d, i.f9950a.a(), System.currentTimeMillis(), r15.getState(), 0);
        RunLog r17 = RunLog.INSTANCE;
        String r0 = f9944b;
        Intrinsics.checkNotNullExpressionValue(r0, "TAG");
        r17.debug(r0, "insert appUsage " + r16);
        a(r16);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAppUsageDao().insert(r16);
        return;
    L7:
        r15 = AppStateType.BG;
        goto L8
    }
}
