package com.bytedance.als;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/als/AttachOption;", "", "IMMEDIATE", "LAZY", "FORCE_LAZY", "als_release"}, k = 1, mv = {1, 4, 1})
public final enum AttachOption extends Enum<AttachOption> {
    public static final AttachOption FORCE_LAZY = null;
    public static final AttachOption IMMEDIATE = null;
    public static final AttachOption LAZY = null;
    public static final /* synthetic */ AttachOption[] a = null;

    static {
        AttachOption r1 = new AttachOption("IMMEDIATE", 0);
        IMMEDIATE = r1;
        AttachOption r10 = new AttachOption("LAZY", 1);
        LAZY = r10;
        AttachOption r11 = new AttachOption("FORCE_LAZY", 2);
        FORCE_LAZY = r11;
        a = new AttachOption[]{r1, r10, r11};
    }

    public static AttachOption valueOf(String r1) {
        return (AttachOption) r27.a.a(AttachOption.class, r1);
    }

    public static AttachOption[] values() {
        return (AttachOption[]) a.clone();
    }

    public AttachOption(String r1, int r10) {
        super(r1, r10);
    }
}
