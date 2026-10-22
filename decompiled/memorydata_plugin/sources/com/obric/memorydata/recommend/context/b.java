package com.obric.memorydata.recommend.context;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.memoryindex.m;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.UserProfileLabel;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.context.data.FestivalThroughData;
import com.obric.memorydata.utils.Format;
import com.obric.memorydata.utils.aw;
import com.obric.memorydata.utils.r;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\b\u001a \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00100\u00142\u0006\u0010\u0012\u001a\u00020\b\u001a\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002\u001a\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0007\u001a\u0006\u0010\u001e\u001a\u00020\u0001\u001a\u0006\u0010\u001f\u001a\u00020\u0001\u001a\u0015\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010!\u001a\u00020\u0001¢\u0006\u0002\u0010\"\u001a\u0012\u0010#\u001a\u0004\u0018\u00010\u00012\b\u0010$\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0001H\u0007\u001a\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0010\u001a\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0010\u001a\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010+\u001a\u00020,\u001a\u0006\u0010-\u001a\u00020\u0001\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0018H\u0002\u001a\u0006\u00100\u001a\u000201\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"IS_HOLIDAY", "", "HOLIDAY_NAME", "DAY_NAME", "HOLIDAY_START_DATE", "HOLIDAY_END_DATE", "LUNAR_DATE", "HOLIDAY", "", "HOLIDAY_TYPE", "HOLIDAY_TYPE_HOLIDAY", "FESTIVAL_TYPE", "ANNIVERSARY_TYPE", "TAG", "REQUEST_HOLIDAY_SCHEMA", "getFutureFestival", "", "Lorg/json/JSONObject;", "days", "getFestivalAndAnniversaryData", "Lkotlin/Pair;", "Lcom/obric/memorydata/recommend/context/data/FestivalThroughData;", "getAnniversaryData", "getDateTimeDescByAnniversaryMemory", "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/InfoAnniversaryMemoryEntity;", "(Lcom/obric/capabilitykit/entity/memory/InfoAnniversaryMemoryEntity;)Ljava/lang/Long;", "getFestivalData", "getCurrentTimeZone", "getSleepTime", "getWakeTime", "getTodayMinLeaveTime", EventBody.KEY_VALUE, "(Ljava/lang/String;)Ljava/lang/Long;", "getArriveLeaveTimeFormat", "input", "minutesToHourMinute", "minuteString", "getHomeGps", "", "getCompanyGps", "getPastDaysArriveLeaveTime", AnnotatedPrivateKey.LABEL, "Lcom/obric/memorydata/intelligence/api/ProfileLabel;", "getPhoneState", "formatMillisToHoursMinutes", "millis", "isNetConnect", "", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((FestivalThroughData) ZeusTransformUtils.preCheckCast(r2, FestivalThroughData.class, "com.obric.memorydata.plugin")).getStartTime()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((FestivalThroughData) ZeusTransformUtils.preCheckCast(r3, FestivalThroughData.class, "com.obric.memorydata.plugin")).getStartTime()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    public static final Long a(InfoAnniversaryMemoryEntity r11) {
        Intrinsics.checkNotNullParameter(r11, "memoryEntity");
        boolean r1 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11.getAnniversaryDate(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L39;
        List r2 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11.getAnniversaryDate(), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).size() == 2) goto L11;
    L34:
        long r3 = r.d(r11.getAnniversaryDate());
        if (r3 != 0) goto L38;
        return null;
    L38:
        return Long.valueOf(r3);
    L11:
        if (TextUtils.isDigitsOnly((CharSequence) ZeusTransformUtils.preCheckCast(r2.get(0), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L34;
        if (TextUtils.isDigitsOnly((CharSequence) ZeusTransformUtils.preCheckCast(r2.get(1), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L34;
        Integer r5 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r2.get(0), String.class, "com.obric.memorydata.plugin"));
        int r7 = -1;
        if (r5 == null) goto L17;
        int r6 = r5.intValue();
    L18:
        Integer r4 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r2.get(1), String.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L21;
        r7 = r4.intValue();
    L21:
        if (1 <= r6) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L34;
        if (1 <= r7) goto L29;
    L31:
        if (r1 == false) goto L34;
        Calendar r12 = Calendar.getInstance();
        r12.set(2, r6 - 1);
        r12.set(5, r7);
        return Long.valueOf(r12.getTimeInMillis());
    L29:
        if (r7 >= 32) goto L31;
        r1 = true;
        goto L31
    L23:
        if (r6 >= 13) goto L25;
        r8 = true;
        goto L26
    L17:
        r6 = -1;
        goto L18
    L39:
        return null;
    L5:
        r0 = false;
        goto L7
    }

    public static final String a() {
        TimeZone r0 = TimeZone.getDefault();
        r0.toZoneId();
        long r1 = r0.getOffset(System.currentTimeMillis());
        long r4 = r1 / ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
        long r2 = (r1 % ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) / 60000;
        if (r4 < 0) goto L5;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        String r5 = String.format("UTC+%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r4), Long.valueOf(r2)}, 2));
    L6:
        Intrinsics.checkNotNullExpressionValue(r5, "format(...)");
        return r5;
    L5:
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        r5 = String.format("UTC-%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r4), Long.valueOf(r2)}, 2));
        goto L6
    }

    public static final List<JSONObject> a(int r5) {
        int r0 = aw.f13185a.b(System.currentTimeMillis());
        ArrayList r1 = new ArrayList();
        int r2 = r0 + 1;
        int r3 = r0 + r5;
        if (r2 > r3) goto L8;
    L4:
        r1.add(aw.f13185a.a("content://com.obric.calendar.holidays/julianday/" + r2));
        if (r2 == r3) goto L8;
        r2 = r2 + 1;
    L8:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    public static final String b() {
        return UserProfileLabel.INSTANCE.querySleepMoment();
    }

    public static final Pair<String, List<FestivalThroughData>> b(int r8) {
        List r9 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(d(r8), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(c(r8), Iterable.class, "com.obric.memorydata.plugin"));
        CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin"));
        Iterator r0 = r9.iterator();
        String r1 = "";
    L4:
        if (r0.hasNext() == false) goto L10;
        FestivalThroughData r3 = (FestivalThroughData) ZeusTransformUtils.preCheckCast(r0.next(), FestivalThroughData.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append(r1);
        if (r3.getType() != 1) goto L8;
        StringBuilder r4 = new StringBuilder().append('-').append(r3.getName()).append(65306).append(r.e(r3.getStartTime())).append(" (").append(r.e(r3.getEndTime())).append('~').append(r.e(r3.getFestivalStartTime())).append("假期)\n");
    L9:
        r1 = r2.append(r4.toString()).toString();
        goto L4
    L8:
        r4 = new StringBuilder().append('-').append(r3.getName()).append(65306).append(r.e(r3.getStartTime())).append('\n');
        goto L9
    L10:
        StringsKt.removeSuffix(r1, (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"));
        return new Pair(r1, r9);
    }

    public static final String c() {
        return UserProfileLabel.INSTANCE.queryWakeupMoment();
    }

    private static final List<FestivalThroughData> c(int r22) {
        List<FestivalThroughData> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<RawMemoryEntity> r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getAnniversaryMemory();
        long r3 = System.currentTimeMillis();
        Iterator<RawMemoryEntity> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L20;
        RawMemoryEntity r5 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        MemoryEntity r6 = m.a().toMemoryEntity(r5);
        if (ZeusTransformUtils.instanceOf(r6, InfoAnniversaryMemoryEntity.class) == false) goto L8;
        InfoAnniversaryMemoryEntity r7 = (InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin");
    L9:
        if (r7 == null) goto L4;
        Long r8 = a(r7);
        if (r8 == null) goto L4;
        long r13 = r8.longValue();
        if (r13 < r3) goto L4;
        if (r13 > ((((long) r22) * WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) + r3)) goto L4;
        r0.add(new FestivalThroughData(2, r7.getAnniversaryType(), r13, r13, 0, 0, 48, null));
        RunLog.INSTANCE.debug("ContextUtil", String.valueOf(r5));
        goto L4
    L8:
        r7 = null;
        goto L9
    L20:
        return r0;
    }

    private static final List<FestivalThroughData> d(int r19) {
        List<FestivalThroughData> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<JSONObject> r1 = a(r19);
        RunLog.INSTANCE.debug("ContextUtil", u.a(r1));
        Iterator<JSONObject> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L39;
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(r2.next(), JSONObject.class, "com.obric.memorydata.plugin");
        RunLog r4 = RunLog.INSTANCE;
        String r6 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        r4.debug("ContextUtil", r6);
        boolean r7 = true;
        if (r3.optInt("isHoliday") != 1) goto L4;
        if (r3.optInt("holidayType") != 2) goto L4;
        String r10 = r3.optString("holidayName");
        if (r10 == null) goto L4;
        String r5 = r3.optString("dayName");
        if (r5 == null) goto L4;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L4;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L25;
        r7 = false;
    L25:
        if (r7 == true) goto L4;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L4;
        String r9 = r3.optString("holidayStartDate");
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        Integer r11 = StringsKt.toIntOrNull(r9);
        if (r11 == null) goto L4;
        int r12 = r11.intValue();
        String r13 = r3.optString("holidayEndDate");
        Intrinsics.checkNotNullExpressionValue(r13, "optString(...)");
        Integer r14 = StringsKt.toIntOrNull(r13);
        if (r14 == null) goto L4;
        int r15 = r14.intValue();
        String r16 = r3.optString("lunarDate");
        if (r16 == null) goto L4;
        long r17 = aw.f13185a.a(r12);
        long r18 = aw.f13185a.a(r15);
        Date r20 = r.a(r16, Format.DATE.getValue());
        if (r20 == null) goto L4;
        long r110 = r20.getTime();
        r0.add(new FestivalThroughData(1, r10, r17, r18, r110, r110));
        goto L4
    L19:
        r8 = false;
        goto L20
    L39:
        return r0;
    }

    public static final boolean d() {
        Object r0 = FeatureManager.INSTANCE.getFeature("device_active_network");
        if (r0 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L8;
        return true;
    L8:
        if (Intrinsics.areEqual(r0, "none") == false) goto L12;
        return false;
    L12:
        return true;
    }
}
