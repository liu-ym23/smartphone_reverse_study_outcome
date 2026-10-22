package com.ss.android.lark.ding.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\tJ\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/ding/entity/ChattersUrgentInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "infoMap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/ding/entity/UrgentInfo;", "getInfoMap", "()Ljava/util/Map;", "setInfoMap", "(Ljava/util/Map;)V", "add", BuildConfig.FLAVOR, "chatterId", "info", "isChatterUnread", BuildConfig.FLAVOR, "getDingInaccessibleInfo", "Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;", "existUrgentInfo", "getUserAuthDeniedReason", BuildConfig.FLAVOR, "writeToParcel", "flags", "describeContents", "CREATOR", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChattersUrgentInfo implements Parcelable {
    public static final a CREATOR = null;
    public final Map<String, UrgentInfo> a;

    public static final class a implements Parcelable.Creator<ChattersUrgentInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChattersUrgentInfo createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ChattersUrgentInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ChattersUrgentInfo[] newArray(int r1) {
            return new ChattersUrgentInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ChattersUrgentInfo() {
        this.a = new LinkedHashMap();
    }

    public ChattersUrgentInfo(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        this();
        LinkedHashMap r0 = new LinkedHashMap();
        this.a = r0;
        r3.readMap(r0, UrgentInfo.CREATOR.getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeMap(this.a);
    }
}
