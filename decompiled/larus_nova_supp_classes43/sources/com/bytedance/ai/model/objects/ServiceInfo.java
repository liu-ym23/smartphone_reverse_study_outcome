package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/model/objects/ServiceInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "entry", "getEntry", "setEntry", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServiceInfo implements Parcelable {
    public static final a CREATOR = null;
    private String entry;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f12id;

    public static final class a implements Parcelable.Creator<ServiceInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ServiceInfo createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new ServiceInfo(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final ServiceInfo[] newArray(int r1) {
            return new ServiceInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ServiceInfo() {
        this.f12id = "";
        this.entry = "";
    }

    public final String getEntry() {
        return this.entry;
    }

    public final String getId() {
        return this.f12id;
    }

    public ServiceInfo(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this();
        String r0 = r10.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.f12id = r0;
        String r11 = r10.readString();
        if (r11 == null) goto L9;
        r1 = r11;
    L9:
        this.entry = r1;
    }

    public final void setEntry(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.entry = r10;
    }

    public final void setId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f12id = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.f12id);
        r1.writeString(this.entry);
    }
}
