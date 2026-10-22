package com.obric.memorydata.task.alarm;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/task/alarm/DAY;", "", "<init>", "(Ljava/lang/String;I)V", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DAY extends Enum<DAY> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DAY[] $VALUES = null;
    public static final a Companion = null;
    public static final DAY FRIDAY = null;
    public static final DAY MONDAY = null;
    public static final DAY SATURDAY = null;
    public static final DAY SUNDAY = null;
    public static final DAY THURSDAY = null;
    public static final DAY TUESDAY = null;
    public static final DAY WEDNESDAY = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/task/alarm/DAY$Companion;", "", "<init>", "()V", "of", "Lcom/obric/memorydata/task/alarm/DAY;", EventBody.KEY_VALUE, "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final DAY a(int r6) {
            DAY[] r5 = DAY.values();
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            DAY r3 = r5[r2];
            if (r3.ordinal() != r6) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L15;
            r2 = r2 + 1;
            goto L3
        L15:
            return r3;
        L7:
            r4 = false;
            goto L8
        L11:
            return null;
        }
    }

    private static final /* synthetic */ DAY[] $values() {
        return new DAY[]{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
    }

    static {
        MONDAY = new DAY("MONDAY", 0);
        TUESDAY = new DAY("TUESDAY", 1);
        WEDNESDAY = new DAY("WEDNESDAY", 2);
        THURSDAY = new DAY("THURSDAY", 3);
        FRIDAY = new DAY("FRIDAY", 4);
        SATURDAY = new DAY("SATURDAY", 5);
        SUNDAY = new DAY("SUNDAY", 6);
        DAY[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private DAY(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<DAY> getEntries() {
        return $ENTRIES;
    }

    public static DAY valueOf(String r2) {
        return (DAY) ZeusTransformUtils.preCheckCast(Enum.valueOf(DAY.class, r2), DAY.class, "com.obric.memorydata.plugin");
    }

    public static DAY[] values() {
        return (DAY[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DAY[].class, "com.obric.memorydata.plugin");
    }
}
