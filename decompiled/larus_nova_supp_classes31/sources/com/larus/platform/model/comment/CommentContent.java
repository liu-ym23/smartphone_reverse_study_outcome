package com.larus.platform.model.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0005J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/comment/CommentContent;", "Landroid/os/Parcelable;", "content", "", "contentType", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "getContentType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/platform/model/comment/CommentContent;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommentContent implements Parcelable {
    public static final Parcelable.Creator<CommentContent> CREATOR = null;

    @SerializedName("content")
    private final String content;

    @SerializedName("content_type")
    private final Integer contentType;

    public static final class a implements Parcelable.Creator<CommentContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentContent createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            String r1 = r4.readString();
            if (r4.readInt() != 0) goto L5;
            Integer r5 = null;
        L7:
            return new CommentContent(r1, r5);
        L5:
            r5 = Integer.valueOf(r4.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CommentContent[] newArray(int r1) {
            return new CommentContent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CommentContent() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CommentContent) == true) goto L8;
        return false;
    L8:
        CommentContent r6 = (CommentContent) r5;
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contentType, r6.contentType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.content;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.contentType;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentContent(content=" + this.content + ", contentType=" + this.contentType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.content);
        Integer r4 = this.contentType;
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        r2.writeInt(r5);
        return;
    L5:
        r2.writeInt(1);
        r5 = r4.intValue();
        goto L6
    }

    public final String a() {
        return this.content;
    }

    public final Integer b() {
        return this.contentType;
    }

    public /* synthetic */ CommentContent(int r2) {
        this("", 0);
    }

    public CommentContent(String r1, Integer r2) {
        this.content = r1;
        this.contentType = r2;
    }
}
