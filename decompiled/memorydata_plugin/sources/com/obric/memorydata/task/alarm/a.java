package com.obric.memorydata.task.alarm;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.task.impl.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/task/alarm/AlarmTimeHelper;", "", "<init>", "()V", "calculateTimeDifference", "", "alarmTime", "Lcom/obric/memorydata/task/alarm/AlarmTime;", "convertAlarmTimeFromJson", "json", "Lorg/json/JSONObject;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12865a = null;

    static {
        f12865a = new a();
    }

    private a() {
    }

    public final long a(AlarmTime r10) {
        Intrinsics.checkNotNullParameter(r10, "alarmTime");
        LocalDateTime r9 = LocalDateTime.now();
        LocalTime r0 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r10.getTime(), CharSequence.class, "com.obric.memorydata.plugin"), DateTimeFormatter.ofPattern("HH:mm"));
        int r3 = 0;
        LocalDateTime r1 = r9.withHour(r0.getHour()).withMinute(r0.getMinute()).withSecond(0).withNano(0);
        Intrinsics.checkNotNullExpressionValue(r1, "withNano(...)");
        if (r10.getDays().isEmpty() == true) goto L5;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10.getDays(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L18;
        int r7 = 7;
        int r6 = (((((DAY) ZeusTransformUtils.preCheckCast(r12.next(), DAY.class, "com.obric.memorydata.plugin")).ordinal() + 1) - r9.getDayOfWeek().getValue()) + 7) % 7;
        if (r6 == 0) goto L14;
    L16:
        r7 = r6;
    L17:
        r4.add(Integer.valueOf(r7));
        goto L10
    L14:
        if (r9.toLocalTime().compareTo(r0) <= 0) goto L16;
    L18:
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L21;
        r3 = r13.intValue();
    L21:
        long r5 = r3;
    L7:
        r1 = r1.plusDays(r5);
        Intrinsics.checkNotNullExpressionValue(r1, "plusDays(...)");
    L23:
        return Duration.between((Temporal) ZeusTransformUtils.preCheckCast(r9, Temporal.class, "com.obric.memorydata.plugin"), (Temporal) ZeusTransformUtils.preCheckCast(r1, Temporal.class, "com.obric.memorydata.plugin")).toSeconds();
    L5:
        if (r9.compareTo((ChronoLocalDateTime) ZeusTransformUtils.preCheckCast(r1, ChronoLocalDateTime.class, "com.obric.memorydata.plugin")) <= 0) goto L23;
        r5 = 1;
        goto L7
    }

    public final AlarmTime a(JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "json");
        Type r8 = Type.Companion.a(r9.optInt("type"));
        if (r8 != null) goto L5;
        r8 = Type.ONCE;
    L5:
        String r0 = r9.optString(OaidModel.KEY_TIME);
        int r1 = r9.optInt("interval");
        Object r10 = r9.opt("days");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray r11 = (JSONArray) ZeusTransformUtils.preCheckCast(r10, JSONArray.class, "com.obric.memorydata.plugin");
        ArrayList r2 = new ArrayList();
        if (r11.length() <= 0) goto L13;
        int r4 = 0;
        int r5 = r11.length();
    L8:
        if (r4 >= r5) goto L13;
        DAY r6 = DAY.Companion.a(r11.optInt(r4));
        if (r6 == null) goto L12;
        r2.add(r6);
    L12:
        r4 = r4 + 1;
    L13:
        Intrinsics.checkNotNull(r0);
        return new AlarmTime(r8, r0, new g(r1, TimeUnit.MILLISECONDS), (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
    }
}
