package com.ss.android.lark.member_manage.export.mention;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/member_manage/export/mention/IMMentionTabConfig;", "Landroid/os/Parcelable;", "type", "Lcom/ss/android/lark/member_manage/export/mention/IMMentionViewType;", "tabRes", "", "<init>", "(Lcom/ss/android/lark/member_manage/export/mention/IMMentionViewType;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getType", "()Lcom/ss/android/lark/member_manage/export/mention/IMMentionViewType;", "getTabRes", "()Ljava/lang/String;", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "group-member-manage-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class IMMentionTabConfig implements Parcelable {
    public static final a CREATOR = null;
    public final IMMentionViewType a;
    public final String b;

    public static final class a implements Parcelable.Creator<IMMentionTabConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IMMentionTabConfig createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Serializable r0 = r4.readSerializable();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.member_manage.export.mention.IMMentionViewType");
            IMMentionViewType r1 = (IMMentionViewType) r0;
            String r5 = r4.readString();
            if (r5 != null) goto L6;
            r5 = "";
        L6:
            return new IMMentionTabConfig(r1, r5);
        }

        @Override // android.os.Parcelable.Creator
        public final IMMentionTabConfig[] newArray(int r1) {
            return new IMMentionTabConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final IMMentionViewType getType() {
        return this.a;
    }

    public IMMentionTabConfig(IMMentionViewType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "tabRes");
        this.a = r2;
        this.b = r3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeSerializable(this.a);
        r1.writeString(this.b);
    }
}
