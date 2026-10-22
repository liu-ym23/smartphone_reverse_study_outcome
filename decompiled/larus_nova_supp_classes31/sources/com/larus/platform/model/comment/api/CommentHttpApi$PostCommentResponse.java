package com.larus.platform.model.comment.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/larus/platform/model/comment/api/CommentHttpApi$PostCommentResponse;", "Landroid/os/Parcelable;", "commentId", "", "<init>", "(Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommentHttpApi$PostCommentResponse implements Parcelable {
    public static final Parcelable.Creator<CommentHttpApi$PostCommentResponse> CREATOR = null;

    @SerializedName("comment_id")
    private final String commentId;

    public static final class a implements Parcelable.Creator<CommentHttpApi$PostCommentResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentHttpApi$PostCommentResponse createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new CommentHttpApi$PostCommentResponse(r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CommentHttpApi$PostCommentResponse[] newArray(int r1) {
            return new CommentHttpApi$PostCommentResponse[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CommentHttpApi$PostCommentResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.commentId, ((CommentHttpApi$PostCommentResponse) r4).commentId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.commentId;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "PostCommentResponse(commentId=" + this.commentId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.commentId);
    }

    public CommentHttpApi$PostCommentResponse() {
        this("");
    }

    public final String a() {
        return this.commentId;
    }

    public CommentHttpApi$PostCommentResponse(String r1) {
        this.commentId = r1;
    }
}
