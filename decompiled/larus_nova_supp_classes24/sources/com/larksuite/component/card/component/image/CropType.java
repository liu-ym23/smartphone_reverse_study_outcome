package com.larksuite.component.card.component.image;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larksuite/component/card/component/image/CropType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LEFT_TOP", "STRETCH", "CROP_CENTER", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum CropType extends Enum<CropType> {
    public static final CropType CROP_CENTER = null;
    public static final CropType LEFT_TOP = null;
    public static final CropType STRETCH = null;
    public static final /* synthetic */ CropType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CropType> getEntries() {
        return b;
    }

    static {
        CropType r0 = new CropType("LEFT_TOP", 0);
        LEFT_TOP = r0;
        CropType r1 = new CropType("STRETCH", 1);
        STRETCH = r1;
        CropType r3 = new CropType("CROP_CENTER", 2);
        CROP_CENTER = r3;
        CropType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CropType[] values() {
        return (CropType[]) a.clone();
    }

    public static CropType valueOf(String r1) {
        return (CropType) r27.a.a(CropType.class, r1);
    }

    public CropType(String r1, int r2) {
        super(r1, r2);
    }
}
