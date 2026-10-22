package com.bytedance.android.live.revlink.impl.pk.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/state/SubCategoryInputType;", "", "InputUndefined", "InputRadio", "InputCheckBox", "InputText", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SubCategoryInputType extends Enum<SubCategoryInputType> {
    public static final SubCategoryInputType InputCheckBox = null;
    public static final SubCategoryInputType InputRadio = null;
    public static final SubCategoryInputType InputText = null;
    public static final SubCategoryInputType InputUndefined = null;
    public static final /* synthetic */ SubCategoryInputType[] a = null;

    static {
        SubCategoryInputType r1 = new SubCategoryInputType("InputUndefined", 0);
        InputUndefined = r1;
        SubCategoryInputType r2 = new SubCategoryInputType("InputRadio", 1);
        InputRadio = r2;
        SubCategoryInputType r3 = new SubCategoryInputType("InputCheckBox", 2);
        InputCheckBox = r3;
        SubCategoryInputType r4 = new SubCategoryInputType("InputText", 3);
        InputText = r4;
        a = new SubCategoryInputType[]{r1, r2, r3, r4};
    }

    public static SubCategoryInputType valueOf(String r1) {
        return (SubCategoryInputType) a.a(SubCategoryInputType.class, r1);
    }

    public static SubCategoryInputType[] values() {
        return (SubCategoryInputType[]) a.clone();
    }

    public SubCategoryInputType(String r1, int r2) {
        super(r1, r2);
    }
}
