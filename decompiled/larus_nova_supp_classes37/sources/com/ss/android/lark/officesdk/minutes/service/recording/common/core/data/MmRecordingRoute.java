package com.ss.android.lark.officesdk.minutes.service.recording.common.core.data;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\bj\u0002\b\t¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingRoute;", "", "storageValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStorageValue", "()Ljava/lang/String;", "LEGACY", "RECORDING_API", "usesRecordingApi", "", "getUsesRecordingApi", "()Z", "resolvedAfterJoin", "source", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "recordingId", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingRoute extends Enum<MmRecordingRoute> {
    public static final a Companion = null;
    public static final MmRecordingRoute LEGACY = null;
    public static final MmRecordingRoute RECORDING_API = null;
    public static final /* synthetic */ MmRecordingRoute[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String storageValue;

    public static final class a {
        public a() {
        }

        public static MmRecordingRoute a(MmRecordingSource r1, boolean r2) {
            if (r1 != MmRecordingSource.FEISHU) goto L7;
            if (r2 == false) goto L17;
            return MmRecordingRoute.RECORDING_API;
        L17:
            return MmRecordingRoute.LEGACY;
        L7:
            if (r1 == null) goto L11;
            boolean r3 = true;
            if (r1.usesRecordingApiByDefault() != true) goto L11;
        L12:
            if (r3 == false) goto L15;
            return MmRecordingRoute.RECORDING_API;
        L15:
            return MmRecordingRoute.LEGACY;
        L11:
            r3 = false;
            goto L12
        }
    }

    public static EnumEntries<MmRecordingRoute> getEntries() {
        return b;
    }

    static {
        MmRecordingRoute r0 = new MmRecordingRoute("LEGACY", 0, "legacy");
        LEGACY = r0;
        MmRecordingRoute r1 = new MmRecordingRoute("RECORDING_API", 1, "recording_api");
        RECORDING_API = r1;
        MmRecordingRoute[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static MmRecordingRoute[] values() {
        return (MmRecordingRoute[]) a.clone();
    }

    public final boolean getUsesRecordingApi() {
        if (this != RECORDING_API) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getStorageValue() {
        return this.storageValue;
    }

    public static MmRecordingRoute valueOf(String r1) {
        return (MmRecordingRoute) r27.a.a(MmRecordingRoute.class, r1);
    }

    public final MmRecordingRoute resolvedAfterJoin(MmRecordingSource r5, String r6) {
        MmRecordingRoute r0 = RECORDING_API;
        if (this != r0) goto L30;
        boolean r1 = false;
        if (r5 == null) goto L12;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5 != MmRecordingSource.FEISHU) goto L9;
        boolean r7 = true;
    L10:
        if (r7 != true) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L30;
        Companion.getClass();
        if (r6 != null) goto L18;
    L21:
        boolean r9 = true;
    L22:
        if (r9 == false) goto L24;
    L26:
        if (r1 == false) goto L29;
        return r0;
    L29:
        return LEGACY;
    L24:
        if (Intrinsics.areEqual(r6, UserInfo.NONE_NAME_CARD_ID) == true) goto L26;
        r1 = true;
        goto L26
    L18:
        if (StringsKt.isBlank(r6) == true) goto L21;
        r9 = false;
        goto L22
    L9:
        r7 = false;
    L12:
        r8 = false;
    L30:
        return this;
    }

    public MmRecordingRoute(String r1, int r2, String r3) {
        super(r1, r2);
        this.storageValue = r3;
    }
}
