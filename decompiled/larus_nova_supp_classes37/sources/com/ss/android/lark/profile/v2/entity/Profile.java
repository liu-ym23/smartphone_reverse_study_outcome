package com.ss.android.lark.profile.v2.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/Profile;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "userInfo", "Lcom/ss/android/lark/profile/v2/entity/UserInfo;", "ctas", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/profile/v2/entity/CTA;", "Lkotlin/collections/ArrayList;", "fields", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "<init>", "(Lcom/ss/android/lark/profile/v2/entity/UserInfo;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getUserInfo", "()Lcom/ss/android/lark/profile/v2/entity/UserInfo;", "getCtas", "()Ljava/util/ArrayList;", "getFields", "isFromLocal", "", "()Z", "setFromLocal", "(Z)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class Profile implements Serializable, Parcelable {
    public static final a CREATOR = null;
    private final ArrayList<CTA> ctas;
    private final ArrayList<BaseField> fields;
    private boolean isFromLocal;
    private final UserInfo userInfo;

    public static final class a implements Parcelable.Creator<Profile> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Profile createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new Profile(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final Profile[] newArray(int r1) {
            return new Profile[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final ArrayList<CTA> getCtas() {
        return this.ctas;
    }

    public final ArrayList<BaseField> getFields() {
        return this.fields;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final boolean isFromLocal() {
        return this.isFromLocal;
    }

    public Profile(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        UserInfo r0 = (UserInfo) r3.readSerializable();
        if (r0 != null) goto L5;
        r0 = new UserInfo();
    L5:
        ArrayList r1 = (ArrayList) r3.readSerializable();
        if (r1 != null) goto L8;
        r1 = new ArrayList();
    L8:
        ArrayList r4 = (ArrayList) r3.readSerializable();
        if (r4 != null) goto L11;
        r4 = new ArrayList();
    L11:
        this(r0, r1, r4);
    }

    public final void setFromLocal(boolean r1) {
        this.isFromLocal = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeSerializable(this.userInfo);
        r1.writeSerializable(this.ctas);
        r1.writeSerializable(this.fields);
    }

    public Profile(UserInfo r2, ArrayList<CTA> r3, ArrayList<BaseField> r4) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        Intrinsics.checkNotNullParameter(r3, "ctas");
        Intrinsics.checkNotNullParameter(r4, "fields");
        this.userInfo = r2;
        this.ctas = r3;
        this.fields = r4;
    }
}
