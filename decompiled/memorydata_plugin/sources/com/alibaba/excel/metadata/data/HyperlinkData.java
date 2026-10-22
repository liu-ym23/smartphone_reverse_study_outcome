package com.alibaba.excel.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class HyperlinkData extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HyperlinkType f267b;

    public static final enum HyperlinkType extends Enum<HyperlinkType> {
        private static final /* synthetic */ HyperlinkType[] $VALUES = null;
        public static final HyperlinkType DOCUMENT = null;
        public static final HyperlinkType EMAIL = null;
        public static final HyperlinkType FILE = null;
        public static final HyperlinkType NONE = null;
        public static final HyperlinkType URL = null;
        org.apache.poi.common.usermodel.HyperlinkType value;

        static {
            HyperlinkType r0 = new HyperlinkType("NONE", 0, org.apache.poi.common.usermodel.HyperlinkType.NONE);
            NONE = r0;
            HyperlinkType r1 = new HyperlinkType("URL", 1, org.apache.poi.common.usermodel.HyperlinkType.URL);
            URL = r1;
            HyperlinkType r2 = new HyperlinkType("DOCUMENT", 2, org.apache.poi.common.usermodel.HyperlinkType.DOCUMENT);
            DOCUMENT = r2;
            HyperlinkType r4 = new HyperlinkType("EMAIL", 3, org.apache.poi.common.usermodel.HyperlinkType.EMAIL);
            EMAIL = r4;
            HyperlinkType r6 = new HyperlinkType("FILE", 4, org.apache.poi.common.usermodel.HyperlinkType.FILE);
            FILE = r6;
            $VALUES = new HyperlinkType[]{r0, r1, r2, r4, r6};
        }

        private HyperlinkType(String r1, int r2, org.apache.poi.common.usermodel.HyperlinkType r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static HyperlinkType valueOf(String r2) {
            return (HyperlinkType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HyperlinkType.class, r2), HyperlinkType.class, "com.obric.memorydata.plugin");
        }

        public static HyperlinkType[] values() {
            return (HyperlinkType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HyperlinkType[].class, "com.obric.memorydata.plugin");
        }

        public org.apache.poi.common.usermodel.HyperlinkType getValue() {
            return this.value;
        }
    }

    public HyperlinkData() {
    }

    public String a() {
        return this.f266a;
    }

    @Override // com.alibaba.excel.metadata.data.c
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, HyperlinkData.class);
    }

    public HyperlinkType b() {
        return this.f267b;
    }

    @Override // com.alibaba.excel.metadata.data.c
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HyperlinkData.class) == true) goto L8;
        return false;
    L8:
        HyperlinkData r0 = (HyperlinkData) ZeusTransformUtils.preCheckCast(r5, HyperlinkData.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        String r6 = a();
        String r2 = r0.a();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        HyperlinkType r4 = b();
        HyperlinkType r7 = r0.b();
        if (r4 != null) goto L26;
        if (r7 != null) goto L27;
    L28:
        return true;
    L27:
        return false;
    L26:
        if (r4.equals(r7) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    @Override // com.alibaba.excel.metadata.data.c
    public int hashCode() {
        int r0 = super.hashCode();
        String r1 = a();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        HyperlinkType r5 = b();
        int r6 = (r2 + r4) * 59;
        if (r5 == null) goto L11;
        r3 = r5.hashCode();
    L11:
        return r6 + r3;
    L5:
        r4 = r1.hashCode();
        goto L6
    }
}
