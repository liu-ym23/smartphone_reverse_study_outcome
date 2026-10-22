package com.obric.aiagent.ipc.idl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FilePath$b implements Parcelable.Creator<FilePath> {
    public FilePath$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final FilePath createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        int r1 = r4.readInt();
        String r2 = r4.readString();
        if (r4.readInt() == 0) goto L5;
        boolean r5 = true;
    L7:
        return new FilePath(r1, r2, r5);
    L5:
        r5 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final FilePath[] newArray(int r1) {
        return new FilePath[r1];
    }
}
