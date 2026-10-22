package com.bytedance.android.livesdk.interactivity.api.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/CommonInputParams;", "Landroid/os/Parcelable;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonInputParams implements Parcelable {
    public static final Parcelable.Creator<CommonInputParams> CREATOR = null;
    public final boolean a;
    public final boolean b;
    public final String c;
    public final String d;
    public final int e;

    public static class a implements Parcelable.Creator<CommonInputParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonInputParams createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "in");
            boolean r3 = false;
            if (r8.readInt() == 0) goto L5;
            boolean r4 = true;
        L7:
            if (r8.readInt() == 0) goto L9;
            r3 = true;
        L9:
            boolean r2 = r4;
            return new CommonInputParams(r2, r3, r8.readString(), r8.readString(), r8.readInt());
        L5:
            r4 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CommonInputParams[] newArray(int r1) {
            return new CommonInputParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CommonInputParams() {
        this(false, false, null, null, 31, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a ? 1 : 0);
        r1.writeInt(this.b ? 1 : 0);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeInt(this.e);
    }

    public CommonInputParams(boolean r2, boolean r3, String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "hint");
        Intrinsics.checkNotNullParameter(r5, "input");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ CommonInputParams(boolean r8, boolean r9, String r10, String r11, int r13, int r14) {
        if ((r13 & 1) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r13 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r4 = BuildConfig.FLAVOR;
    L15:
        if ((r13 & 8) == 0) goto L17;
        String r5 = BuildConfig.FLAVOR;
    L19:
        if ((r13 & 16) == 0) goto L21;
        int r6 = 50;
    L22:
        this(r2, r3, r4, r5, r6);
        return;
    L21:
        r6 = 0;
        goto L22
    L17:
        r5 = r11;
        goto L19
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }
}
