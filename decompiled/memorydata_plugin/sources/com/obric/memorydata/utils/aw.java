package com.obric.memorydata.utils;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.DateUtils;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/utils/TimeUtil;", "", "<init>", "()V", "TAG", "", "FLAG_DAY", "", "APPLET_LUNAR_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "Landroid/net/Uri;", "METHOD_QUERY_HOLIDAYS", "holidayCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/utils/TimeUtil$HolidayDay;", "queryDayTypeFromApplet", "timestamp", "", "fetchYearHolidays", "callAppletLunarProvider", "Landroid/os/Bundle;", "calendar", "Ljava/util/Calendar;", "parseHolidayDays", "daysJson", "requestCalender", "Lorg/json/JSONObject;", "uriStr", "getJulianDay", "julianDayToTimestamp", "julianDay", "HolidayDay", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aw f13185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f13186b = null;
    private static final ConcurrentHashMap<Integer, List<a>> c = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/utils/TimeUtil$HolidayDay;", "", ActivityLifecycle.NAME, "", "date", "isOffDay", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getDate", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13188b;
        private final boolean c;

        public a(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r3, "date");
            this.f13187a = r2;
            this.f13188b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f13188b;
        }

        public final boolean b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13187a, r6.f13187a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13188b, r6.f13188b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f13187a.hashCode() * 31) + this.f13188b.hashCode()) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "HolidayDay(name=" + this.f13187a + ", date=" + this.f13188b + ", isOffDay=" + this.c + ')';
        }
    }

    static {
        f13185a = new aw();
        f13186b = Uri.parse("content://com.obric.applet.lunarprovider");
        c = new ConcurrentHashMap();
    }

    private aw() {
    }

    private final Bundle a(Calendar r9) {
        Bundle r0 = null;
        ContentProviderClient r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().acquireUnstableContentProviderClient(f13186b);     // Catch: SecurityException -> L23
        if (r1 != null) goto L26;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r4 = null;
        int r5 = 4;
        Object r6 = null;
        String r3 = "TimeUtil";
        String r7 = "acquire applet lunar provider failed";
    L6:
        IRunLog.a.a(r2, r3, r7, r4, r5, r6);
        return null;
    L26:
        Bundle r8 = new Bundle();     // Catch: Throwable -> L10 SecurityException -> L12 RemoteException -> L15 DeadObjectException -> L17
        r8.putInt("year", r9.get(1));     // Catch: Throwable -> L10 SecurityException -> L12 RemoteException -> L15 DeadObjectException -> L17
        r8.putInt("month", r9.get(2) + 1);     // Catch: Throwable -> L10 SecurityException -> L12 RemoteException -> L15 DeadObjectException -> L17
        r8.putInt("day", r9.get(5));     // Catch: Throwable -> L10 SecurityException -> L12 RemoteException -> L15 DeadObjectException -> L17
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L10 SecurityException -> L12 RemoteException -> L15 DeadObjectException -> L17
        r0 = r1.call("queryHolidays", null, r8);     // Catch: Throwable -> L10 SecurityException -> L12 RemoteException -> L15 DeadObjectException -> L17
    L9:
        r1.close();
        return r0;
    L15:
        e = move-exception;
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        String r12 = "TimeUtil";
        String r13 = "query applet holidays remote exception: " + e;     // Catch: Throwable -> L10
    L14:
        IRunLog.a.a(r11, r12, r13, null, 4, null);     // Catch: Throwable -> L10
    L17:
        e = move-exception;
        r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        r12 = "TimeUtil";
        r13 = "applet lunar provider dead: " + e;     // Catch: Throwable -> L10
    L12:
        e = move-exception;
        r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        r12 = "TimeUtil";
        r13 = "query applet holidays denied: " + e;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r1.close();
        throw th;
    L23:
        e = move-exception;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = "acquire applet lunar provider denied: " + e;
        r4 = null;
        r5 = 4;
        r6 = null;
        r3 = "TimeUtil";
        goto L6
    }

    private final List<a> b(String r10) {
        JSONArray r1 = new JSONArray(r10);     // Catch: JSONException -> L12
        List<a> r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L12
        int r2 = 0;
        int r3 = r1.length();     // Catch: JSONException -> L12
    L4:
        if (r2 >= r3) goto L10;
        JSONObject r4 = r1.optJSONObject(r2);     // Catch: JSONException -> L12
        if (r4 == null) goto L9;
        String r6 = r4.optString(ActivityLifecycle.NAME);     // Catch: JSONException -> L12
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");     // Catch: JSONException -> L12
        String r7 = r4.optString("date");     // Catch: JSONException -> L12
        Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");     // Catch: JSONException -> L12
        r11.add(new a(r6, r7, r4.optBoolean("isOffDay")));     // Catch: JSONException -> L12
    L9:
        r2 = r2 + 1;     // Catch: JSONException -> L12
        goto L4
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeUtil", "fetchYearHolidays success, size: " + r11.size(), false, 4, null);     // Catch: JSONException -> L12
        return r11;
    L12:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeUtil", "parse holiday days failed: " + e, null, 4, null);
        return null;
    }

    private final List<a> c(long r11) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r11);
        boolean r12 = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeUtil", "fetchYearHolidays from applet for year: " + r0.get(1), false, 4, null);
        Intrinsics.checkNotNull(r0);
        Bundle r13 = a(r0);
        if (r13 == null) goto L5;
        Integer r1 = Integer.valueOf(r13.getInt("result"));
    L6:
        if (r1 != null) goto L9;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeUtil", "fetchYearHolidays result: " + r1, null, 4, null);
        return null;
    L9:
        if (r1.intValue() != 1) goto L10;
        String r14 = r13.getString("days");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L15;
    L18:
        if (r12 == false) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeUtil", "fetchYearHolidays daysJson is empty", null, 4, null);
        return null;
    L22:
        return b(r14);
    L15:
        if (r2.length() == 0) goto L18;
        r12 = false;
        goto L18
    L5:
        r1 = null;
        goto L6
    }

    public final long a(int r4) {
        Calendar r3 = Calendar.getInstance();
        r3.set(2024, 5, 6);
        r3.add(6, r4 - 2460468);
        return r3.getTimeInMillis();
    }

    public final a a(long r9) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r9);
        int r1 = r0.get(1);
        String r2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(Long.valueOf(r9));
        ConcurrentHashMap<Integer, List<a>> r3 = c;
        List<a> r4 = (List) ZeusTransformUtils.preCheckCast(r3.get(Integer.valueOf(r1)), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        r4 = c(r9);
        if (r4 == null) goto L7;
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r1), r4);
    L7:
        a r8 = null;
        Object r10 = null;
        if (r4 == null) goto L16;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.memorydata.plugin")).a(), r2) == false) goto L11;
        r10 = r12;
    L15:
        r8 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.memorydata.plugin");
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TimeUtil", "queryDayTypeFromApplet for " + r2 + ", result: " + r8, false, 4, null);
        return r8;
    }

    public final JSONObject a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "uriStr");
        Uri r2 = Uri.parse(r11);     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r2, "parse(...)");     // Catch: Exception -> L22
        Cursor r12 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r2, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        if (r12 == null) goto L21;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1.moveToFirst() == false) goto L12;
        int r3 = r1.getInt(0);     // Catch: Throwable -> L15
        String r4 = r1.getString(1);     // Catch: Throwable -> L15
        String r5 = r1.getString(2);     // Catch: Throwable -> L15
        String r6 = r1.getString(3);     // Catch: Throwable -> L15
        String r7 = r1.getString(4);     // Catch: Throwable -> L15
        String r8 = r1.getString(5);     // Catch: Throwable -> L15
        String r9 = r1.getString(6);     // Catch: Throwable -> L15
        JSONObject r10 = new JSONObject().put("isHoliday", r3).put("holidayType", r4).put("holidayName", r5).put("holidayStartDate", r6).put("holidayEndDate", r7).put("lunarDate", r8).put("dayName", r9);     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r10, "put(...)");     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L22
        return r10;
    L12:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L22
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L22
        throw th;     // Catch: Exception -> L22
    L21:
        return new JSONObject();
    L22:
        e = move-exception;
        RunLog.INSTANCE.error("TimeUtil", "requestCalender error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return new JSONObject();
    }

    public final int b(long r3) {
        long r4 = (r3 - 1717603200000L) / ((long) DateUtils.DAY);
        return (int) (((long) 2460468) + r4);
    }
}
