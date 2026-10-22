package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w2.h;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/model/objects/Icons;", "Landroid/os/Parcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "1x", "Ljava/lang/String;", "get1x", "()Ljava/lang/String;", "set1x", "(Ljava/lang/String;)V", "2x", "get2x", "set2x", "3x", "get3x", "set3x", "CREATOR", "w2/h", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Icons implements Parcelable {
    public static final h CREATOR = null;

    /* JADX INFO: renamed from: 1x, reason: not valid java name */
    private String f31x;

    /* JADX INFO: renamed from: 2x, reason: not valid java name */
    private String f42x;

    /* JADX INFO: renamed from: 3x, reason: not valid java name */
    private String f53x;

    static {
        CREATOR = new h();
    }

    public Icons() {
        this.f31x = "";
        this.f42x = "";
        this.f53x = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String get1x() {
        return this.f31x;
    }

    public final String get2x() {
        return this.f42x;
    }

    public final String get3x() {
        return this.f53x;
    }

    public final void set1x(String r5) {
        this.f31x = r5;
    }

    public final void set2x(String r5) {
        this.f42x = r5;
    }

    public final void set3x(String r5) {
        this.f53x = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeString(this.f31x);
        r5.writeString(this.f42x);
        r5.writeString(this.f53x);
    }

    public Icons(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        this();
        this.f31x = r5.readString();
        this.f42x = r5.readString();
        this.f53x = r5.readString();
    }
}
