package com.ss.android.lark.contact.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SelectedData implements Serializable, Parcelable {
    public static final Parcelable.Creator<SelectedData> CREATOR = null;
    private static final long serialVersionUID = -5081739513370342806L;
    public String avatarKey;
    public DataType dataType;
    public String description;
    public int descriptionDrawable;
    public String id;
    public boolean isRegistered;
    public boolean isShowDescription;
    public String name;

    public static final enum DataType extends Enum<DataType> {
        public static final DataType CHAT = null;
        public static final DataType CHATTER = null;
        public static final DataType DEPARTAMENT = null;
        public static final DataType UNKNOWN = null;
        public static final /* synthetic */ DataType[] a = null;
        private int value;

        static {
            DataType r0 = new DataType("CHATTER", 0, 1);
            CHATTER = r0;
            DataType r1 = new DataType("CHAT", 1, 2);
            CHAT = r1;
            DataType r4 = new DataType("UNKNOWN", 2, 0);
            UNKNOWN = r4;
            DataType r6 = new DataType("DEPARTAMENT", 3, 3);
            DEPARTAMENT = r6;
            a = new DataType[]{r0, r1, r4, r6};
        }

        public static DataType[] values() {
            return (DataType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static /* synthetic */ int access$000(DataType r0) {
            return r0.value;
        }

        public static DataType forNumber(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return UNKNOWN;
        L11:
            return DEPARTAMENT;
        L13:
            return CHAT;
        L15:
            return CHATTER;
        }

        public static DataType valueOf(String r1) {
            return (DataType) r27.a.a(DataType.class, r1);
        }

        public static DataType valueOf(int r0) {
            return forNumber(r0);
        }

        public DataType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public class a implements Parcelable.Creator<SelectedData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectedData createFromParcel(Parcel r2) {
            return new SelectedData(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SelectedData[] newArray(int r1) {
            return new SelectedData[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SelectedData() {
        this.isRegistered = true;
    }

    public SelectedData(Parcel r4) {
        boolean r0 = true;
        this.isRegistered = true;
        this.dataType = DataType.forNumber(r4.readInt());
        this.id = r4.readString();
        this.name = r4.readString();
        this.avatarKey = r4.readString();
        if (r4.readInt() != 1) goto L5;
        boolean r1 = true;
    L6:
        this.isRegistered = r1;
        if (r4.readInt() == 1) goto L10;
        r0 = false;
    L10:
        this.isShowDescription = r0;
        this.description = r4.readString();
        this.descriptionDrawable = r4.readInt();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static SelectedData getFromBundle(Bundle r1) {
        return (SelectedData) r1.getParcelable("selected_data");
    }

    public void addToBundle(Bundle r2) {
        r2.putParcelable("selected_data", this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        DataType r3 = this.dataType;
        if (r3 == null) goto L5;
        int r4 = DataType.access$000(r3);
    L6:
        r1.writeInt(r4);
        r1.writeString(this.id);
        r1.writeString(this.name);
        r1.writeString(this.avatarKey);
        r1.writeInt(this.isRegistered ? 1 : 0);
        r1.writeInt(this.isShowDescription ? 1 : 0);
        r1.writeString(this.description);
        r1.writeInt(this.descriptionDrawable);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public SelectedData(DataType r1, String r2, String r3, String r4, boolean r5, boolean r6, String r7, int r8) {
        this.dataType = r1;
        this.id = r2;
        this.name = r3;
        this.avatarKey = r4;
        this.isRegistered = r5;
        this.isShowDescription = r6;
        this.description = r7;
        this.descriptionDrawable = r8;
    }
}
