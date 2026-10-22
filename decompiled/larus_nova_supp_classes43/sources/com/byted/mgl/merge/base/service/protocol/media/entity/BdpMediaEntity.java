package com.byted.mgl.merge.base.service.protocol.media.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpMediaEntity implements Parcelable {
    public static final Parcelable.Creator<BdpMediaEntity> CREATOR = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f5id;
    public int mediaType;
    public String name;
    public String parentDir;
    public String path;
    public long size;
    public long time;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public BdpMediaEntity(Parcel r10) {
        this.path = r10.readString();
        this.name = r10.readString();
        this.time = r10.readLong();
        this.mediaType = r10.readInt();
        this.size = r10.readLong();
        this.f5id = r10.readInt();
        this.parentDir = r10.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.path);
        r10.writeString(this.name);
        r10.writeLong(this.time);
        r10.writeInt(this.mediaType);
        r10.writeLong(this.size);
        r10.writeInt(this.f5id);
        r10.writeString(this.parentDir);
    }

    public BdpMediaEntity(String r1, String r10, long r11, int r12, long r13, int r14, String r15) {
        this.path = r1;
        this.name = r10;
        this.time = r11;
        this.mediaType = r12;
        this.size = r13;
        this.f5id = r14;
        this.parentDir = r15;
    }
}
