package com.larus.platform.model.comment.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/comment/api/CommentHttpApi$ReportReason;", "Landroid/os/Parcelable;", "id", "", "displayContent", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getDisplayContent", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommentHttpApi$ReportReason implements Parcelable {
    public static final Parcelable.Creator<CommentHttpApi$ReportReason> CREATOR = null;

    @SerializedName("display_content")
    private final String displayContent;

    @SerializedName("id")
    private final int id;

    public static final class a implements Parcelable.Creator<CommentHttpApi$ReportReason> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentHttpApi$ReportReason createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new CommentHttpApi$ReportReason(r3.readInt(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CommentHttpApi$ReportReason[] newArray(int r1) {
            return new CommentHttpApi$ReportReason[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CommentHttpApi$ReportReason() {
        this(0, "");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CommentHttpApi$ReportReason) == true) goto L8;
        return false;
    L8:
        CommentHttpApi$ReportReason r6 = (CommentHttpApi$ReportReason) r5;
        if (this.id == r6.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayContent, r6.displayContent) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.id * 31;
        String r1 = this.displayContent;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ReportReason(id=" + this.id + ", displayContent=" + this.displayContent + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.id);
        r1.writeString(this.displayContent);
    }

    public final String a() {
        return this.displayContent;
    }

    public final int b() {
        return this.id;
    }

    public CommentHttpApi$ReportReason(int r1, String r2) {
        this.id = r1;
        this.displayContent = r2;
    }
}
