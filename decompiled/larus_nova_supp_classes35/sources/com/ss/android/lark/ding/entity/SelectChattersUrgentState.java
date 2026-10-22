package com.ss.android.lark.ding.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u0017J\u0016\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0010J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0010J\u0016\u0010&\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0010J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010(\u001a\u00020\u0010J\u0016\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\tJ\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lcom/ss/android/lark/ding/entity/SelectChattersUrgentState;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "unknownList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getUnknownList", "()Ljava/util/List;", "setUnknownList", "(Ljava/util/List;)V", "codeToChatterIds", BuildConfig.FLAVOR, "Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;", "Lcom/ss/android/lark/ding/entity/UrgentChatterRestrictGroup;", "getCodeToChatterIds", "()Ljava/util/Map;", "setCodeToChatterIds", "(Ljava/util/Map;)V", "selectedCount", BuildConfig.FLAVOR, "getSelectedCount", "()I", "getSelectedChatterIds", BuildConfig.FLAVOR, "addGroupByType", BuildConfig.FLAVOR, "code", "group", "getGroupCountByType", "getFailedCount", "updateCount", "count", "addChatterId", "chatterId", "removeChatterId", "getBoundedChatterIds", IPortraitService.TYPE, "containsBoundedChatterId", BuildConfig.FLAVOR, "id", "writeToParcel", "flags", "describeContents", "CREATOR", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectChattersUrgentState implements Parcelable {
    public static final a CREATOR = null;
    public final List<String> a;
    public final Map<DingInaccessibleCode, UrgentChatterRestrictGroup> b;

    public static final class a implements Parcelable.Creator<SelectChattersUrgentState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectChattersUrgentState createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new SelectChattersUrgentState(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SelectChattersUrgentState[] newArray(int r1) {
            return new SelectChattersUrgentState[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public SelectChattersUrgentState() {
        this.a = new ArrayList();
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(DingInaccessibleCode.DEFAULT, new UrgentChatterRestrictGroup(new LinkedHashSet(), 4)), TuplesKt.to(DingInaccessibleCode.CROSS_PLATFORM, new UrgentChatterRestrictGroup(new LinkedHashSet(), 4)), TuplesKt.to(DingInaccessibleCode.NOT_FRIEND, new UrgentChatterRestrictGroup(new LinkedHashSet(), 4)), TuplesKt.to(DingInaccessibleCode.EMPTY_NAME, new UrgentChatterRestrictGroup(new LinkedHashSet(), 4)), TuplesKt.to(DingInaccessibleCode.EMPTY_PHONE, new UrgentChatterRestrictGroup(new LinkedHashSet(), 4)), TuplesKt.to(DingInaccessibleCode.USER_SETTING_DISABLED, new UrgentChatterRestrictGroup(new LinkedHashSet(), 4))});
    }

    public SelectChattersUrgentState(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        this();
        ArrayList<String> r0 = r3.createStringArrayList();
        if (r0 != null) goto L6;
        r0 = new ArrayList();
    L6:
        this.a = r0;
        LinkedHashMap r1 = new LinkedHashMap();
        this.b = r1;
        r3.readMap(r1, UrgentChatterRestrictGroup.CREATOR.getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeStringList(this.a);
        r1.writeMap(this.b);
    }
}
