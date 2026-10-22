package com.bytedance.rpc.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MetaType extends Enum<MetaType> {
    private static final /* synthetic */ MetaType[] $VALUES = null;

    @SerializedName("3")
    public static final MetaType DocumentRef = null;

    @SerializedName(BDLocationException.ERROR_BEACON_ADVERTISING)
    public static final MetaType EmbeddedMultimedia = null;

    @SerializedName("2")
    public static final MetaType Insertable = null;

    @SerializedName("1")
    public static final MetaType Replaceable = null;
    private final int value;

    static {
        MetaType r0 = new MetaType("Replaceable", 0, 1);
        Replaceable = r0;
        MetaType r1 = new MetaType("Insertable", 1, 2);
        Insertable = r1;
        MetaType r4 = new MetaType("DocumentRef", 2, 3);
        DocumentRef = r4;
        MetaType r6 = new MetaType("EmbeddedMultimedia", 3, 100);
        EmbeddedMultimedia = r6;
        $VALUES = new MetaType[]{r0, r1, r4, r6};
    }

    private MetaType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MetaType findByValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 100) goto L13;
        return null;
    L13:
        return EmbeddedMultimedia;
    L15:
        return DocumentRef;
    L17:
        return Insertable;
    L19:
        return Replaceable;
    }

    public static MetaType valueOf(String r2) {
        return (MetaType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MetaType.class, r2), MetaType.class, "com.obric.memorydata.plugin");
    }

    public static MetaType[] values() {
        return (MetaType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MetaType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
