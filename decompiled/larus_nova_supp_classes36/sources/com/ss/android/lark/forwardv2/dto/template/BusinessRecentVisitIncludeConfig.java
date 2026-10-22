package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class BusinessRecentVisitIncludeConfig implements Parcelable {
    public static final Parcelable.Creator<BusinessRecentVisitIncludeConfig> CREATOR = null;
    public ArrayList<EntityItem> a;

    public class a implements Parcelable.Creator<BusinessRecentVisitIncludeConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BusinessRecentVisitIncludeConfig createFromParcel(Parcel r2) {
            return new BusinessRecentVisitIncludeConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BusinessRecentVisitIncludeConfig[] newArray(int r1) {
            return new BusinessRecentVisitIncludeConfig[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BusinessRecentVisitIncludeConfig() {
        this.a = new ArrayList();
    }

    public BusinessRecentVisitIncludeConfig(Parcel r3) {
        ArrayList<EntityItem> r0 = new ArrayList();
        this.a = r0;
        r3.readTypedList(r0, EntityItem.CREATOR);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeTypedList(this.a);
    }
}
