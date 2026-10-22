package com.obric.download.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0019\u0010\u000b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/download/base/TaskOperateResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "toString", OaidModel.KEY_ID, "I", "getId", "()I", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "errorCode", "getErrorCode", "<init>", "(IILjava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "base_release"}, k = 1, mv = {1, 4, 3})
public final class TaskOperateResult implements Parcelable {
    public static final a CREATOR = null;
    private final int errorCode;
    private final String errorMsg;
    private final int id;

    public static final class a implements Parcelable.Creator<TaskOperateResult> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public TaskOperateResult a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new TaskOperateResult(r10);
        }

        public TaskOperateResult[] b(int r10) {
            return new TaskOperateResult[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskOperateResult createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskOperateResult[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public TaskOperateResult(int r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMsg");
        this.id = r10;
        this.errorCode = r11;
        this.errorMsg = r12;
    }

    public /* synthetic */ TaskOperateResult(int r10, int r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = "";
    L8:
        this(r10, r11, r12);
    }

    public TaskOperateResult(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        int r11 = r10.readInt();
        int r12 = r10.readInt();
        String r13 = r10.readString();
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        Intrinsics.checkNotNullExpressionValue(r13, "parcel.readString() ?: \"\"");
        this(r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final int getId() {
        return this.id;
    }

    public String toString() {
        return "TaskOperateResult(id=" + this.id + ", errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        r10.writeInt(this.id);
        r10.writeInt(this.errorCode);
        r10.writeString(this.errorMsg);
    }
}
