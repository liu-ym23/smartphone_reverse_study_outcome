package com.obric.memorydata.task.alarm;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.task.impl.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J9\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010&\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/obric/memorydata/task/alarm/AlarmTime;", "", "type", "Lcom/obric/memorydata/task/alarm/Type;", OaidModel.KEY_TIME, "", "interval", "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "days", "", "Lcom/obric/memorydata/task/alarm/DAY;", "<init>", "(Lcom/obric/memorydata/task/alarm/Type;Ljava/lang/String;Lcom/obric/memorydata/task/impl/TaskTimeUnit;Ljava/util/List;)V", "getType", "()Lcom/obric/memorydata/task/alarm/Type;", "setType", "(Lcom/obric/memorydata/task/alarm/Type;)V", "getTime", "()Ljava/lang/String;", "setTime", "(Ljava/lang/String;)V", "getInterval", "()Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "setInterval", "(Lcom/obric/memorydata/task/impl/TaskTimeUnit;)V", "getDays", "()Ljava/util/List;", "setDays", "(Ljava/util/List;)V", "checkTimeValid", "", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AlarmTime {
    public static final a Companion = null;
    private List<? extends DAY> days;
    private g interval;
    private String time;
    private Type type;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/task/alarm/AlarmTime$Companion;", "", "<init>", "()V", "fromJson", "Lcom/obric/memorydata/task/alarm/AlarmTime;", "json", "Lorg/json/JSONObject;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AlarmTime(Type r7, String r8, g r9, List<? extends DAY> r10) {
        List<? extends DAY> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "type");
        Intrinsics.checkNotNullParameter(r8, OaidModel.KEY_TIME);
        Intrinsics.checkNotNullParameter(r11, "days");
        this.type = r7;
        this.time = r8;
        this.interval = r9;
        this.days = r11;
        if (StringsKt.startsWith$default(r8, "xx", false, 2, null) == false) goto L6;
        this.time = StringsKt.replaceFirst$default(this.time, "xx", "00", false, 4, null);
    L6:
        if (checkTimeValid(this.time) == true) goto L9;
        this.time = "";
        return;
    }

    public /* synthetic */ AlarmTime(Type r2, String r3, g r4, List r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = CollectionsKt.emptyList();
    L8:
        this(r2, r3, r4, r8);
    }

    private final boolean checkTimeValid(String r9) {
        if (new Regex("^([01]?[0-9]|2[0-3]):([0-5]?[0-9])$").matches((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("time param is invalid"), Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    L6:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{ParameterizedMessage.ERROR_MSG_SEPARATOR}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r10.add(Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"))));
        goto L8
    L10:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(r12.get(0), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r12.get(1), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r13 >= 0) goto L13;
    L15:
        boolean r15 = false;
    L16:
        if (r15 == false) goto L26;
        if (r14 >= 0) goto L19;
    L21:
        boolean r16 = false;
    L22:
        if (r16 == true) goto L24;
        return false;
    L24:
        return true;
    L19:
        if (r14 >= 60) goto L21;
        r16 = true;
        goto L22
    L26:
        return false;
    L13:
        if (r13 >= 24) goto L15;
        r15 = true;
        goto L16
    }

    public static /* synthetic */ AlarmTime copy$default(AlarmTime r1, Type r2, String r3, g r4, List r5, int r6, Object r7) {
        List<? extends DAY> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.type;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.time;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.interval;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.days;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final Type component1() {
        return this.type;
    }

    public final String component2() {
        return this.time;
    }

    public final g component3() {
        return this.interval;
    }

    public final List<DAY> component4() {
        return this.days;
    }

    public final AlarmTime copy(Type r2, String r3, g r4, List<? extends DAY> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_TIME);
        Intrinsics.checkNotNullParameter(r1, "days");
        return new AlarmTime(r2, r3, r4, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AlarmTime.class) == true) goto L8;
        return false;
    L8:
        AlarmTime r6 = (AlarmTime) ZeusTransformUtils.preCheckCast(r5, AlarmTime.class, "com.obric.memorydata.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interval, r6.interval) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.days, r6.days) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final List<DAY> getDays() {
        return this.days;
    }

    public final g getInterval() {
        return this.interval;
    }

    public final String getTime() {
        return this.time;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((this.type.hashCode() * 31) + this.time.hashCode()) * 31;
        g r1 = this.interval;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.days.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final void setDays(List<? extends DAY> r3) {
        List<? extends DAY> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.days = r4;
    }

    public final void setInterval(g r1) {
        this.interval = r1;
    }

    public final void setTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.time = r2;
    }

    public final void setType(Type r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public final JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put("type", this.type.ordinal());
        r0.put(OaidModel.KEY_TIME, this.time);
        if (this.interval == null) goto L14;
        JSONObject r1 = new JSONObject();
        g r2 = this.interval;
        String r3 = null;
        if (r2 == null) goto L7;
        Long r4 = Long.valueOf(r2.a());
    L8:
        r1.put(EventBody.KEY_VALUE, r4);
        g r5 = this.interval;
        if (r5 == null) goto L13;
        TimeUnit r6 = r5.b();
        if (r6 == null) goto L13;
        r3 = r6.name();
    L13:
        r1.put("timeUnit", r3);
        r0.put("interval", r1);
        goto L14
    L7:
        r4 = null;
    L14:
        JSONArray r7 = new JSONArray();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(this.days, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        r7.put(((DAY) ZeusTransformUtils.preCheckCast(r8.next(), DAY.class, "com.obric.memorydata.plugin")).ordinal());
        goto L16
    L18:
        r0.put("days", r7);
        return r0;
    }

    public String toString() {
        return "AlarmTime(type=" + this.type + ", time=" + this.time + ", interval=" + this.interval + ", days=" + this.days + ')';
    }
}
