package com.obric.memory.datacollect.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/TimeAccuracy;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "ACCURATE", "LATE", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final enum TimeAccuracy extends Enum<TimeAccuracy> {
    private static final /* synthetic */ TimeAccuracy[] $VALUES = null;

    @SerializedName("0")
    public static final TimeAccuracy ACCURATE = null;
    public static final a Companion = null;

    @SerializedName("1")
    public static final TimeAccuracy LATE = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/TimeAccuracy$Companion;", "", "()V", "findByValue", "Lcom/obric/memory/datacollect/kotlin/TimeAccuracy;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final TimeAccuracy a(int r1) {
            if (r1 == 0) goto L8;
            if (r1 == 1) goto L10;
            return null;
        L10:
            return TimeAccuracy.LATE;
        L8:
            return TimeAccuracy.ACCURATE;
        }
    }

    static {
        TimeAccuracy r1 = new TimeAccuracy("ACCURATE", 0, 0);
        ACCURATE = r1;
        TimeAccuracy r2 = new TimeAccuracy("LATE", 1, 1);
        LATE = r2;
        $VALUES = new TimeAccuracy[]{r1, r2};
        Companion = new a(null);
    }

    private TimeAccuracy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final TimeAccuracy findByValue(int r1) {
        return Companion.a(r1);
    }

    public static TimeAccuracy valueOf(String r2) {
        return (TimeAccuracy) ZeusTransformUtils.preCheckCast(Enum.valueOf(TimeAccuracy.class, r2), TimeAccuracy.class, "com.obric.memorydata.plugin");
    }

    public static TimeAccuracy[] values() {
        return (TimeAccuracy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TimeAccuracy[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
