package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WsComponent implements Parcelable {
    public static final Parcelable.Creator<WsComponent> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ComponentName f3924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f3925b;

    public static class a implements Parcelable.Creator<WsComponent> {
        @Override // android.os.Parcelable.Creator
        public final WsComponent createFromParcel(Parcel r8) {
            WsComponent r10 = new WsComponent();
            r10.f3924a = (ComponentName) r8.readParcelable(a.class.getClassLoader());
            r10.f3925b = r8.createTypedArrayList(WsApi.CREATOR);
            return r10;
        }

        @Override // android.os.Parcelable.Creator
        public final WsComponent[] newArray(int r8) {
            return new WsComponent[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public WsComponent() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.f3924a, r10);
        r8.writeTypedList(this.f3925b);
    }
}
