package com.ss.android.lark.chat.entity.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/LarkAgentContext;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "activeChatId", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getActiveChatId", "()Ljava/lang/String;", "component1", "copy", "describeContents", BuildConfig.FLAVOR, "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Builder", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkAgentContext implements Parcelable, Serializable {
    public static final Parcelable.Creator<LarkAgentContext> CREATOR = null;
    private final String activeChatId;

    public static final class a implements Parcelable.Creator<LarkAgentContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LarkAgentContext createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new LarkAgentContext(r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final LarkAgentContext[] newArray(int r1) {
            return new LarkAgentContext[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ LarkAgentContext copy$default(LarkAgentContext r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.activeChatId;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.activeChatId;
    }

    public final LarkAgentContext copy(String r2) {
        return new LarkAgentContext(r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof LarkAgentContext) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.activeChatId, ((LarkAgentContext) r4).activeChatId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.activeChatId;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "LarkAgentContext(activeChatId=" + this.activeChatId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.activeChatId);
    }

    public final String getActiveChatId() {
        return this.activeChatId;
    }

    public LarkAgentContext(String r1) {
        this.activeChatId = r1;
    }
}
