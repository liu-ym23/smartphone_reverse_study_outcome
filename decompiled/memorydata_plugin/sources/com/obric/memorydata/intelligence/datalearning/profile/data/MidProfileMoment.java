package com.obric.memorydata.intelligence.datalearning.profile.data;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.utils.Format;
import com.obric.memorydata.utils.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/data/MidProfileMoment;", "", "moment", "", "workDay", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMoment", "()Ljava/lang/String;", "getWorkDay", "toJson", "toTimestamp", "", "ms", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MidProfileMoment {
    public static final a Companion = null;
    private final String moment;

    @SerializedName("work_day")
    private final String workDay;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/data/MidProfileMoment$Companion;", "", "<init>", "()V", "fromJson", "Lcom/obric/memorydata/intelligence/datalearning/profile/data/MidProfileMoment;", EventBody.KEY_VALUE, "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public MidProfileMoment(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "moment");
        Intrinsics.checkNotNullParameter(r3, "workDay");
        this.moment = r2;
        this.workDay = r3;
    }

    public static /* synthetic */ MidProfileMoment copy$default(MidProfileMoment r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.moment;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.workDay;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.moment;
    }

    public final String component2() {
        return this.workDay;
    }

    public final MidProfileMoment copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "moment");
        Intrinsics.checkNotNullParameter(r2, "workDay");
        return new MidProfileMoment(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MidProfileMoment.class) == true) goto L8;
        return false;
    L8:
        MidProfileMoment r6 = (MidProfileMoment) ZeusTransformUtils.preCheckCast(r5, MidProfileMoment.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.moment, r6.moment) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.workDay, r6.workDay) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getMoment() {
        return this.moment;
    }

    public final String getWorkDay() {
        return this.workDay;
    }

    public int hashCode() {
        return (this.moment.hashCode() * 31) + this.workDay.hashCode();
    }

    public final String toJson() {
        String r1 = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(r1, "toJson(...)");
        return r1;
    }

    public String toString() {
        return "MidProfileMoment(moment=" + this.moment + ", workDay=" + this.workDay + ')';
    }

    public final long toTimestamp(long r2) {
        Date r1 = r.a(r.e(r2) + ' ' + this.moment + ":00", Format.FULL.getValue());
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getTime();
    }
}
