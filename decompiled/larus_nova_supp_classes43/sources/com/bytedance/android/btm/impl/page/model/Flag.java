package com.bytedance.android.btm.impl.page.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/btm/impl/page/model/Flag;", "", "NOT_SURE", "FORWARD", "BACK", "BACKGROUND", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum Flag extends Enum<Flag> {
    public static final Flag BACK = null;
    public static final Flag BACKGROUND = null;
    public static final Flag FORWARD = null;
    public static final Flag NOT_SURE = null;
    public static final /* synthetic */ Flag[] a = null;

    static {
        Flag r1 = new Flag("NOT_SURE", 0);
        NOT_SURE = r1;
        Flag r10 = new Flag("FORWARD", 1);
        FORWARD = r10;
        Flag r11 = new Flag("BACK", 2);
        BACK = r11;
        Flag r12 = new Flag("BACKGROUND", 3);
        BACKGROUND = r12;
        a = new Flag[]{r1, r10, r11, r12};
    }

    public static Flag valueOf(String r1) {
        return (Flag) r27.a.a(Flag.class, r1);
    }

    public static Flag[] values() {
        return (Flag[]) a.clone();
    }

    public Flag(String r1, int r10) {
        super(r1, r10);
    }
}
