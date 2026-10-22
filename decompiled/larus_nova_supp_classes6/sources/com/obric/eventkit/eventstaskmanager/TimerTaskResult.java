package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001&B+\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR!\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "component1", "", "component2", "", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "component3", "code", "msg", "data", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getCode", "()I", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "Ljava/util/List;", "getData", "()Ljava/util/List;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class TimerTaskResult implements Parcelable {
    public static final a CREATOR = null;
    private final int code;
    private final List<TimerTask> data;
    private final String msg;

    static {
        CREATOR = new a();
    }

    public TimerTaskResult(int r1, String r2, List<TimerTask> r3) {
        this.code = r1;
        this.msg = r2;
        this.data = r3;
    }

    public TimerTaskResult(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        this(r4.readInt(), r4.readString(), r4.createTypedArrayList(TimerTask.CREATOR));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimerTaskResult copy$default(TimerTaskResult r0, int r1, String r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.msg;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<TimerTask> component3() {
        return this.data;
    }

    public final TimerTaskResult copy(int r2, String r3, List<TimerTask> r4) {
        return new TimerTaskResult(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TimerTaskResult) == true) goto L8;
        return false;
    L8:
        TimerTaskResult r6 = (TimerTaskResult) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final List<TimerTask> getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int r0 = this.code * 31;
        String r1 = this.msg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<TimerTask> r5 = this.data;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TimerTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.code);
        r1.writeString(this.msg);
        r1.writeTypedList(this.data);
    }
}
