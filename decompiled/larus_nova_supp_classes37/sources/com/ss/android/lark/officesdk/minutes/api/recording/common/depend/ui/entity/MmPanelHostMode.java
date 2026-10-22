package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHostMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "DIALOG", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmPanelHostMode extends Enum<MmPanelHostMode> {
    public static final MmPanelHostMode DEFAULT = null;
    public static final MmPanelHostMode DIALOG = null;
    public static final /* synthetic */ MmPanelHostMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmPanelHostMode> getEntries() {
        return b;
    }

    static {
        MmPanelHostMode r0 = new MmPanelHostMode("DEFAULT", 0);
        DEFAULT = r0;
        MmPanelHostMode r1 = new MmPanelHostMode("DIALOG", 1);
        DIALOG = r1;
        MmPanelHostMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmPanelHostMode[] values() {
        return (MmPanelHostMode[]) a.clone();
    }

    public static MmPanelHostMode valueOf(String r1) {
        return (MmPanelHostMode) a.a(MmPanelHostMode.class, r1);
    }

    public MmPanelHostMode(String r1, int r2) {
        super(r1, r2);
    }
}
