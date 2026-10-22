package org.apache.poi.poifs.crypt;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum ChainingMode extends Enum<ChainingMode> {
    private static final /* synthetic */ ChainingMode[] $VALUES = null;
    public static final ChainingMode cbc = null;
    public static final ChainingMode cfb = null;
    public static final ChainingMode ecb = null;
    public final int ecmaId;
    public final String jceId;
    public final String xmlId;

    static {
        ChainingMode r6 = new ChainingMode("ecb", 0, "ECB", 1, null);
        ecb = r6;
        ChainingMode r0 = new ChainingMode("cbc", 1, "CBC", 2, "ChainingModeCBC");
        cbc = r0;
        ChainingMode r1 = new ChainingMode("cfb", 2, "CFB8", 3, "ChainingModeCFB");
        cfb = r1;
        $VALUES = new ChainingMode[]{r6, r0, r1};
    }

    private ChainingMode(String r1, int r2, String r3, int r4, String r5) {
        super(r1, r2);
        this.jceId = r3;
        this.ecmaId = r4;
        this.xmlId = r5;
    }

    public static ChainingMode fromXmlId(String r5) {
        ChainingMode[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        ChainingMode r3 = r0[r2];
        String r4 = r3.xmlId;
        if (r4 == null) goto L9;
        if (r4.equals(r5) == false) goto L9;
        return r3;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return null;
    }

    public static ChainingMode valueOf(String r2) {
        return (ChainingMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChainingMode.class, r2), ChainingMode.class, "com.obric.memorydata.plugin");
    }

    public static ChainingMode[] values() {
        return (ChainingMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChainingMode[].class, "com.obric.memorydata.plugin");
    }
}
