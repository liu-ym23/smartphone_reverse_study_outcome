package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        WsChannelMsg.MsgHeader r10 = new WsChannelMsg.MsgHeader();
        r10.f4012a = r5.readString();
        r10.f4013b = r5.readString();
        return r10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new WsChannelMsg.MsgHeader[r5];
    }
}
