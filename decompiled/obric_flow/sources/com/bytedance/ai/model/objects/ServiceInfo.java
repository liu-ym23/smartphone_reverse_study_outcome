package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w2.o;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/model/objects/ServiceInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "entry", "getEntry", "setEntry", "CREATOR", "w2/o", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ServiceInfo implements Parcelable {
    public static final o CREATOR = null;
    private String entry;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f2290id;

    static {
        CREATOR = new o();
    }

    public ServiceInfo() {
        this.f2290id = "";
        this.entry = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getEntry() {
        return this.entry;
    }

    public final String getId() {
        return this.f2290id;
    }

    public final void setEntry(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.entry = r5;
    }

    public final void setId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f2290id = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeString(this.f2290id);
        r5.writeString(this.entry);
    }

    public ServiceInfo(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        this();
        String r10 = r5.readString();
        String r11 = "";
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        this.f2290id = r10;
        String r12 = r5.readString();
        if (r12 == null) goto L9;
        r11 = r12;
    L9:
        this.entry = r11;
    }
}
