package com.bytedance.android.live.effect.sticker.ui.aigc;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanelClickType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Generate", "ReGenerate", "ReSelectKeyword", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AigcTaskPanelClickType extends Enum<AigcTaskPanelClickType> {
    public static final AigcTaskPanelClickType Generate = null;
    public static final AigcTaskPanelClickType ReGenerate = null;
    public static final AigcTaskPanelClickType ReSelectKeyword = null;
    public static final /* synthetic */ AigcTaskPanelClickType[] a = null;
    private final String typeName;

    static {
        AigcTaskPanelClickType r1 = new AigcTaskPanelClickType("Generate", 0, "generate");
        Generate = r1;
        AigcTaskPanelClickType r2 = new AigcTaskPanelClickType("ReGenerate", 1, "regenerate");
        ReGenerate = r2;
        AigcTaskPanelClickType r3 = new AigcTaskPanelClickType("ReSelectKeyword", 2, "select_keyword");
        ReSelectKeyword = r3;
        a = new AigcTaskPanelClickType[]{r1, r2, r3};
    }

    public static AigcTaskPanelClickType valueOf(String r1) {
        return (AigcTaskPanelClickType) r27.a.a(AigcTaskPanelClickType.class, r1);
    }

    public static AigcTaskPanelClickType[] values() {
        return (AigcTaskPanelClickType[]) a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public AigcTaskPanelClickType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
