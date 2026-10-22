package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0005J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/PicInfo;", "Landroid/os/Parcelable;", "tosKey", "", "width", "", "height", "resId", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getTosKey", "()Ljava/lang/String;", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getResId", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/aiagent/assistant/idl/bean/PicInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PicInfo implements Parcelable {
    public static final Parcelable.Creator<PicInfo> CREATOR = null;
    private final Integer height;
    private final String resId;
    private final Long time;
    private final String tosKey;
    private final Integer width;

    static {
        CREATOR = new a();
    }

    public PicInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PicInfo copy$default(PicInfo r3, String r4, Integer r5, Integer r6, String r7, Long r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.tosKey;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.width;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.height;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.resId;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.time;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.tosKey;
    }

    public final Integer component2() {
        return this.width;
    }

    public final Integer component3() {
        return this.height;
    }

    public final String component4() {
        return this.resId;
    }

    public final Long component5() {
        return this.time;
    }

    public final PicInfo copy(String r8, Integer r9, Integer r10, String r11, Long r12) {
        return new PicInfo(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PicInfo) == true) goto L8;
        return false;
    L8:
        PicInfo r6 = (PicInfo) r5;
        if (Intrinsics.areEqual(this.tosKey, r6.tosKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resId, r6.resId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.tosKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.width;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.height;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.resId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.time;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PicInfo(tosKey=" + this.tosKey + ", width=" + this.width + ", height=" + this.height + ", resId=" + this.resId + ", time=" + this.time + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.tosKey);
        Integer r5 = this.width;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.height;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.resId);
        Long r7 = this.time;
        if (r7 != null) goto L13;
        r3.writeInt(0);
        return;
    L13:
        r3.writeInt(1);
        r3.writeLong(r7.longValue());
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getResId() {
        return this.resId;
    }

    public final Long getTime() {
        return this.time;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public PicInfo(String r1, Integer r2, Integer r3, String r4, Long r5) {
        this.tosKey = r1;
        this.width = r2;
        this.height = r3;
        this.resId = r4;
        this.time = r5;
    }

    public /* synthetic */ PicInfo(String r4, Integer r5, Integer r6, String r7, Long r8, int r9, DefaultConstructorMarker r10) {
        String r0 = "";
        if ((r9 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r9 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        Integer r2 = r5;
        if ((r9 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        Integer r1 = r6;
        if ((r9 & 8) != 0) goto L17;
        r0 = r7;
    L17:
        if ((r9 & 16) == 0) goto L19;
        r8 = 0L;
    L19:
        Long r12 = r8;
        this(r11, r2, r1, r0, r12);
        return;
    L5:
        r11 = r4;
        goto L7
    }
}
