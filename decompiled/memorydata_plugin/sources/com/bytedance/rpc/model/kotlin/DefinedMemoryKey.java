package com.bytedance.rpc.model.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0087\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "HOME_GPS", "HOME_CELL_ID", "HOME_BSS_ID", "HOME_CITY", "COMPANY_GPS", "COMPANY_CELL_ID", "COMPANY_BSS_ID", "ARRIVE_HOME_MOMENT", "LEAVE_HOME_MOMENT", "ARRIVE_COMPANY_MOMENT", "LEAVE_COMPANY_MOMENT", "COMMUTE_BY_SUBWAY", "WORK_DAY", "HOME_SUBWAY_STATION", "SLEEP_MOMENT", "WAKEUP_MOMENT", "DAILY_AVERAGE_CELL_PHONE_USAGE", "APP_TRAFFIC_CONCERN", "PHONE_TRAFFIC_CONCERN", "COMMUTE_TYPE", "USER_NAME", "INTERESTED_NEWS", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final enum DefinedMemoryKey extends Enum<DefinedMemoryKey> {
    private static final /* synthetic */ DefinedMemoryKey[] $VALUES = null;

    @SerializedName("17")
    public static final DefinedMemoryKey APP_TRAFFIC_CONCERN = null;

    @SerializedName("9")
    public static final DefinedMemoryKey ARRIVE_COMPANY_MOMENT = null;

    @SerializedName("7")
    public static final DefinedMemoryKey ARRIVE_HOME_MOMENT = null;

    @SerializedName("11")
    public static final DefinedMemoryKey COMMUTE_BY_SUBWAY = null;

    @SerializedName("19")
    public static final DefinedMemoryKey COMMUTE_TYPE = null;

    @SerializedName("6")
    public static final DefinedMemoryKey COMPANY_BSS_ID = null;

    @SerializedName("5")
    public static final DefinedMemoryKey COMPANY_CELL_ID = null;

    @SerializedName("4")
    public static final DefinedMemoryKey COMPANY_GPS = null;
    public static final Companion Companion = null;

    @SerializedName("16")
    public static final DefinedMemoryKey DAILY_AVERAGE_CELL_PHONE_USAGE = null;

    @SerializedName("2")
    public static final DefinedMemoryKey HOME_BSS_ID = null;

    @SerializedName("1")
    public static final DefinedMemoryKey HOME_CELL_ID = null;

    @SerializedName("3")
    public static final DefinedMemoryKey HOME_CITY = null;

    @SerializedName("0")
    public static final DefinedMemoryKey HOME_GPS = null;

    @SerializedName("13")
    public static final DefinedMemoryKey HOME_SUBWAY_STATION = null;

    @SerializedName("10001")
    public static final DefinedMemoryKey INTERESTED_NEWS = null;

    @SerializedName("10")
    public static final DefinedMemoryKey LEAVE_COMPANY_MOMENT = null;

    @SerializedName("8")
    public static final DefinedMemoryKey LEAVE_HOME_MOMENT = null;

    @SerializedName("18")
    public static final DefinedMemoryKey PHONE_TRAFFIC_CONCERN = null;

    @SerializedName("14")
    public static final DefinedMemoryKey SLEEP_MOMENT = null;

    @SerializedName("10000")
    public static final DefinedMemoryKey USER_NAME = null;

    @SerializedName("15")
    public static final DefinedMemoryKey WAKEUP_MOMENT = null;

    @SerializedName("12")
    public static final DefinedMemoryKey WORK_DAY = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey$Companion;", "", "()V", "findByValue", "Lcom/bytedance/rpc/model/kotlin/DefinedMemoryKey;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final DefinedMemoryKey findByValue(int r1) {
            if (r1 == 10000) goto L30;
            if (r1 == 10001) goto L52;
            switch(r1) {
                case 0: goto L51;
                case 1: goto L50;
                case 2: goto L49;
                case 3: goto L48;
                case 4: goto L47;
                case 5: goto L46;
                case 6: goto L45;
                case 7: goto L44;
                case 8: goto L43;
                case 9: goto L42;
                case 10: goto L41;
                case 11: goto L40;
                case 12: goto L39;
                case 13: goto L38;
                case 14: goto L37;
                case 15: goto L36;
                case 16: goto L35;
                case 17: goto L34;
                case 18: goto L33;
                case 19: goto L32;
                default: goto L7;
            };
        L7:
            return null;
        L32:
            return DefinedMemoryKey.COMMUTE_TYPE;
        L33:
            return DefinedMemoryKey.PHONE_TRAFFIC_CONCERN;
        L34:
            return DefinedMemoryKey.APP_TRAFFIC_CONCERN;
        L35:
            return DefinedMemoryKey.DAILY_AVERAGE_CELL_PHONE_USAGE;
        L36:
            return DefinedMemoryKey.WAKEUP_MOMENT;
        L37:
            return DefinedMemoryKey.SLEEP_MOMENT;
        L38:
            return DefinedMemoryKey.HOME_SUBWAY_STATION;
        L39:
            return DefinedMemoryKey.WORK_DAY;
        L40:
            return DefinedMemoryKey.COMMUTE_BY_SUBWAY;
        L41:
            return DefinedMemoryKey.LEAVE_COMPANY_MOMENT;
        L42:
            return DefinedMemoryKey.ARRIVE_COMPANY_MOMENT;
        L43:
            return DefinedMemoryKey.LEAVE_HOME_MOMENT;
        L44:
            return DefinedMemoryKey.ARRIVE_HOME_MOMENT;
        L45:
            return DefinedMemoryKey.COMPANY_BSS_ID;
        L46:
            return DefinedMemoryKey.COMPANY_CELL_ID;
        L47:
            return DefinedMemoryKey.COMPANY_GPS;
        L48:
            return DefinedMemoryKey.HOME_CITY;
        L49:
            return DefinedMemoryKey.HOME_BSS_ID;
        L50:
            return DefinedMemoryKey.HOME_CELL_ID;
        L51:
            return DefinedMemoryKey.HOME_GPS;
        L52:
            return DefinedMemoryKey.INTERESTED_NEWS;
        L30:
            return DefinedMemoryKey.USER_NAME;
        }
    }

    static {
        DefinedMemoryKey r1 = new DefinedMemoryKey("HOME_GPS", 0, 0);
        HOME_GPS = r1;
        DefinedMemoryKey r2 = new DefinedMemoryKey("HOME_CELL_ID", 1, 1);
        HOME_CELL_ID = r2;
        DefinedMemoryKey r3 = new DefinedMemoryKey("HOME_BSS_ID", 2, 2);
        HOME_BSS_ID = r3;
        DefinedMemoryKey r4 = new DefinedMemoryKey("HOME_CITY", 3, 3);
        HOME_CITY = r4;
        DefinedMemoryKey r5 = new DefinedMemoryKey("COMPANY_GPS", 4, 4);
        COMPANY_GPS = r5;
        DefinedMemoryKey r6 = new DefinedMemoryKey("COMPANY_CELL_ID", 5, 5);
        COMPANY_CELL_ID = r6;
        DefinedMemoryKey r7 = new DefinedMemoryKey("COMPANY_BSS_ID", 6, 6);
        COMPANY_BSS_ID = r7;
        DefinedMemoryKey r8 = new DefinedMemoryKey("ARRIVE_HOME_MOMENT", 7, 7);
        ARRIVE_HOME_MOMENT = r8;
        DefinedMemoryKey r9 = new DefinedMemoryKey("LEAVE_HOME_MOMENT", 8, 8);
        LEAVE_HOME_MOMENT = r9;
        DefinedMemoryKey r10 = new DefinedMemoryKey("ARRIVE_COMPANY_MOMENT", 9, 9);
        ARRIVE_COMPANY_MOMENT = r10;
        DefinedMemoryKey r11 = new DefinedMemoryKey("LEAVE_COMPANY_MOMENT", 10, 10);
        LEAVE_COMPANY_MOMENT = r11;
        DefinedMemoryKey r12 = new DefinedMemoryKey("COMMUTE_BY_SUBWAY", 11, 11);
        COMMUTE_BY_SUBWAY = r12;
        DefinedMemoryKey r13 = new DefinedMemoryKey("WORK_DAY", 12, 12);
        WORK_DAY = r13;
        DefinedMemoryKey r14 = new DefinedMemoryKey("HOME_SUBWAY_STATION", 13, 13);
        HOME_SUBWAY_STATION = r14;
        DefinedMemoryKey r15 = new DefinedMemoryKey("SLEEP_MOMENT", 14, 14);
        SLEEP_MOMENT = r15;
        DefinedMemoryKey r16 = new DefinedMemoryKey("WAKEUP_MOMENT", 15, 15);
        WAKEUP_MOMENT = r16;
        DefinedMemoryKey r17 = new DefinedMemoryKey("DAILY_AVERAGE_CELL_PHONE_USAGE", 16, 16);
        DAILY_AVERAGE_CELL_PHONE_USAGE = r17;
        DefinedMemoryKey r18 = new DefinedMemoryKey("APP_TRAFFIC_CONCERN", 17, 17);
        APP_TRAFFIC_CONCERN = r18;
        DefinedMemoryKey r19 = new DefinedMemoryKey("PHONE_TRAFFIC_CONCERN", 18, 18);
        PHONE_TRAFFIC_CONCERN = r19;
        DefinedMemoryKey r20 = new DefinedMemoryKey("COMMUTE_TYPE", 19, 19);
        COMMUTE_TYPE = r20;
        DefinedMemoryKey r21 = new DefinedMemoryKey("USER_NAME", 20, 10000);
        USER_NAME = r21;
        DefinedMemoryKey r22 = new DefinedMemoryKey("INTERESTED_NEWS", 21, 10001);
        INTERESTED_NEWS = r22;
        $VALUES = new DefinedMemoryKey[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22};
        Companion = new Companion(null);
    }

    private DefinedMemoryKey(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final DefinedMemoryKey findByValue(int r1) {
        return Companion.findByValue(r1);
    }

    public static DefinedMemoryKey valueOf(String r2) {
        return (DefinedMemoryKey) ZeusTransformUtils.preCheckCast(Enum.valueOf(DefinedMemoryKey.class, r2), DefinedMemoryKey.class, "com.obric.memorydata.plugin");
    }

    public static DefinedMemoryKey[] values() {
        return (DefinedMemoryKey[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DefinedMemoryKey[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
