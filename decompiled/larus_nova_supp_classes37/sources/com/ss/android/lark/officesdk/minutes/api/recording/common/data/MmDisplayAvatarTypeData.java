package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmDisplayAvatarTypeData;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "KEY", "URL", "USER_ID_FALLBACK", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmDisplayAvatarTypeData extends Enum<MmDisplayAvatarTypeData> {
    public static final MmDisplayAvatarTypeData KEY = null;
    public static final MmDisplayAvatarTypeData NONE = null;
    public static final MmDisplayAvatarTypeData URL = null;
    public static final MmDisplayAvatarTypeData USER_ID_FALLBACK = null;
    public static final /* synthetic */ MmDisplayAvatarTypeData[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmDisplayAvatarTypeData> getEntries() {
        return b;
    }

    static {
        MmDisplayAvatarTypeData r0 = new MmDisplayAvatarTypeData("NONE", 0);
        NONE = r0;
        MmDisplayAvatarTypeData r1 = new MmDisplayAvatarTypeData("KEY", 1);
        KEY = r1;
        MmDisplayAvatarTypeData r3 = new MmDisplayAvatarTypeData("URL", 2);
        URL = r3;
        MmDisplayAvatarTypeData r5 = new MmDisplayAvatarTypeData("USER_ID_FALLBACK", 3);
        USER_ID_FALLBACK = r5;
        MmDisplayAvatarTypeData[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmDisplayAvatarTypeData[] values() {
        return (MmDisplayAvatarTypeData[]) a.clone();
    }

    public static MmDisplayAvatarTypeData valueOf(String r1) {
        return (MmDisplayAvatarTypeData) a.a(MmDisplayAvatarTypeData.class, r1);
    }

    public MmDisplayAvatarTypeData(String r1, int r2) {
        super(r1, r2);
    }
}
