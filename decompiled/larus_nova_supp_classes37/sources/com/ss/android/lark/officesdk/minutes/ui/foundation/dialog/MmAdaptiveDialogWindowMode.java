package com.ss.android.lark.officesdk.minutes.ui.foundation.dialog;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/dialog/MmAdaptiveDialogWindowMode;", "", "<init>", "(Ljava/lang/String;I)V", "MobilePortrait", "MobileLandscape", "PadPortrait", "PadLandscape", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAdaptiveDialogWindowMode extends Enum<MmAdaptiveDialogWindowMode> {
    public static final MmAdaptiveDialogWindowMode MobileLandscape = null;
    public static final MmAdaptiveDialogWindowMode MobilePortrait = null;
    public static final MmAdaptiveDialogWindowMode PadLandscape = null;
    public static final MmAdaptiveDialogWindowMode PadPortrait = null;
    public static final /* synthetic */ MmAdaptiveDialogWindowMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAdaptiveDialogWindowMode> getEntries() {
        return b;
    }

    static {
        MmAdaptiveDialogWindowMode r0 = new MmAdaptiveDialogWindowMode("MobilePortrait", 0);
        MobilePortrait = r0;
        MmAdaptiveDialogWindowMode r1 = new MmAdaptiveDialogWindowMode("MobileLandscape", 1);
        MobileLandscape = r1;
        MmAdaptiveDialogWindowMode r3 = new MmAdaptiveDialogWindowMode("PadPortrait", 2);
        PadPortrait = r3;
        MmAdaptiveDialogWindowMode r5 = new MmAdaptiveDialogWindowMode("PadLandscape", 3);
        PadLandscape = r5;
        MmAdaptiveDialogWindowMode[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmAdaptiveDialogWindowMode[] values() {
        return (MmAdaptiveDialogWindowMode[]) a.clone();
    }

    public static MmAdaptiveDialogWindowMode valueOf(String r1) {
        return (MmAdaptiveDialogWindowMode) a.a(MmAdaptiveDialogWindowMode.class, r1);
    }

    public MmAdaptiveDialogWindowMode(String r1, int r2) {
        super(r1, r2);
    }
}
