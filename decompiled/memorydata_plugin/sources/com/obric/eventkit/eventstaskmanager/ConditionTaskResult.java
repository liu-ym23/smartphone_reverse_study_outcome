package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskResult;", "Landroid/os/Parcelable;", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "(ILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getData", "()Ljava/util/List;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConditionTaskResult implements Parcelable {
    public static final Parcelable.Creator<ConditionTaskResult> CREATOR = null;
    private final int code;
    private final List<ConditionTask> data;
    private final String msg;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<ConditionTaskResult> {
        public a() {
        }

        public final ConditionTaskResult a(Parcel r9) {
            int r8 = r9.readInt();
            Intrinsics.checkNotNullParameter(r9, "parcel");
            int r0 = r9.readInt();
            String r1 = r9.readString();
            ArrayList r3 = null;
            if (r9.readInt() == 0) goto L13;
            int r2 = r9.readInt();
            ArrayList r5 = new ArrayList(r2);
            int r6 = 0;
        L6:
            if (r6 == r2) goto L12;
            if (r9.readInt() != 0) goto L10;
            ConditionTask r7 = null;
        L11:
            r5.add(r7);
            r6 = r6 + 1;
            goto L6
        L10:
            r7 = ConditionTask.CREATOR.createFromParcel(r9);
            goto L11
        L12:
            r3 = r5;
        L13:
            ConditionTaskResult r4 = new ConditionTaskResult(r0, r1, r3);
            int r10 = Math.min(r8, 0);
            ClassLoader r11 = a.class.getClassLoader();
            int r12 = 1;
        L14:
            if (r12 > r10) goto L16;
            r12 = r12 + 1;
        L16:
            if (r12 > r8) goto L18;
            com.obric.b.a.a(r9, r11);
            r12 = r12 + 1;
            goto L16
        L18:
            return r4;
        }

        public final ConditionTaskResult[] a(int r1) {
            return new ConditionTaskResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ConditionTaskResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ConditionTaskResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public ConditionTaskResult(int r3, String r4, List<ConditionTask> r5) {
        List<ConditionTask> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.code = r3;
        this.msg = r4;
        this.data = r6;
    }

    public static /* synthetic */ ConditionTaskResult copy$default(ConditionTaskResult r1, int r2, String r3, List r4, int r5, Object r6) {
        List<ConditionTask> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.msg;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r7 = r1.data;
    L12:
        return r1.copy(r2, r3, r7);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<ConditionTask> component3() {
        return this.data;
    }

    public final ConditionTaskResult copy(int r2, String r3, List<ConditionTask> r4) {
        return new ConditionTaskResult(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ConditionTaskResult.class) == true) goto L8;
        return false;
    L8:
        ConditionTaskResult r6 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(r5, ConditionTaskResult.class, "com.obric.memorydata.plugin");
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

    public final List<ConditionTask> getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.code) * 31;
        String r1 = this.msg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<ConditionTask> r5 = this.data;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ConditionTaskResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(0);
        Intrinsics.checkNotNullParameter(r6, "out");
        r6.writeInt(this.code);
        r6.writeString(this.msg);
        List<ConditionTask> r5 = this.data;
        if (r5 != null) goto L5;
        r6.writeInt(0);
        return;
    L5:
        r6.writeInt(1);
        r6.writeInt(r5.size());
        Iterator<ConditionTask> r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L19;
        ConditionTask r2 = (ConditionTask) ZeusTransformUtils.preCheckCast(r8.next(), ConditionTask.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        r6.writeInt(1);
        r2.writeToParcel(r6, r7);
        goto L7
    L10:
        r6.writeInt(0);
        goto L7
    }
}
