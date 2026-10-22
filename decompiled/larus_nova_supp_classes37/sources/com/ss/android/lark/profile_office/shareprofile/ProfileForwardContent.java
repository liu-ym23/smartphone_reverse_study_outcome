package com.ss.android.lark.profile_office.shareprofile;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/profile_office/shareprofile/ProfileForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "chatterId", "", "getChatterId", "()Ljava/lang/String;", "setChatterId", "(Ljava/lang/String;)V", "displayName", "getDisplayName", "setDisplayName", "avatarKey", "getAvatarKey", "setAvatarKey", "writeToParcel", "", "flags", "", "describeContents", "Builder", "CREATOR", "profile-office_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ProfileForwardContent implements IForwardContent {
    public static final b CREATOR = null;
    public String a;
    public String b;
    public String c;

    public static final class a {
        public String a;
        public String b;
        public String c;

        public a() {
            this.a = "";
            this.b = "";
            this.c = "";
        }
    }

    public static final class b implements Parcelable.Creator<ProfileForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileForwardContent createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            ProfileForwardContent r1 = new ProfileForwardContent();
            String r0 = r4.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.a = r0;
            String r3 = r4.readString();
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r1.b = r3;
            String r5 = r4.readString();
            if (r5 == null) goto L12;
            r2 = r5;
        L12:
            r1.c = r2;
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileForwardContent[] newArray(int r1) {
            return new ProfileForwardContent[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public final int describeContents() {
        return 0;
    }

    public ProfileForwardContent() {
        this.a = "";
        this.b = "";
        this.c = "";
    }

    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
    }
}
