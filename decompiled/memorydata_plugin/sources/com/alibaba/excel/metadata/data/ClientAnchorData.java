package com.alibaba.excel.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.ClientAnchor;

/* JADX INFO: loaded from: classes.dex */
public class ClientAnchorData extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f265b;
    private Integer c;
    private Integer d;
    private AnchorType e;

    public static final enum AnchorType extends Enum<AnchorType> {
        private static final /* synthetic */ AnchorType[] $VALUES = null;
        public static final AnchorType DONT_MOVE_AND_RESIZE = null;
        public static final AnchorType DONT_MOVE_DO_RESIZE = null;
        public static final AnchorType MOVE_AND_RESIZE = null;
        public static final AnchorType MOVE_DONT_RESIZE = null;
        ClientAnchor.AnchorType value;

        static {
            AnchorType r0 = new AnchorType("MOVE_AND_RESIZE", 0, ClientAnchor.AnchorType.MOVE_AND_RESIZE);
            MOVE_AND_RESIZE = r0;
            AnchorType r1 = new AnchorType("DONT_MOVE_DO_RESIZE", 1, ClientAnchor.AnchorType.DONT_MOVE_DO_RESIZE);
            DONT_MOVE_DO_RESIZE = r1;
            AnchorType r2 = new AnchorType("MOVE_DONT_RESIZE", 2, ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
            MOVE_DONT_RESIZE = r2;
            AnchorType r4 = new AnchorType("DONT_MOVE_AND_RESIZE", 3, ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE);
            DONT_MOVE_AND_RESIZE = r4;
            $VALUES = new AnchorType[]{r0, r1, r2, r4};
        }

        private AnchorType(String r1, int r2, ClientAnchor.AnchorType r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static AnchorType byId(int r1) {
            return values()[r1];
        }

        public static AnchorType valueOf(String r2) {
            return (AnchorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AnchorType.class, r2), AnchorType.class, "com.obric.memorydata.plugin");
        }

        public static AnchorType[] values() {
            return (AnchorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AnchorType[].class, "com.obric.memorydata.plugin");
        }

        public ClientAnchor.AnchorType getValue() {
            return this.value;
        }
    }

    public ClientAnchorData() {
    }

    public Integer a() {
        return this.f264a;
    }

    @Override // com.alibaba.excel.metadata.data.c
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, ClientAnchorData.class);
    }

    public Integer b() {
        return this.f265b;
    }

    public Integer c() {
        return this.c;
    }

    public Integer d() {
        return this.d;
    }

    public AnchorType e() {
        return this.e;
    }

    @Override // com.alibaba.excel.metadata.data.c
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClientAnchorData.class) == true) goto L8;
        return false;
    L8:
        ClientAnchorData r0 = (ClientAnchorData) ZeusTransformUtils.preCheckCast(r5, ClientAnchorData.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Integer r6 = a();
        Integer r2 = r0.a();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Integer r7 = b();
        Integer r3 = r0.b();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Integer r8 = c();
        Integer r4 = r0.c();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Integer r9 = d();
        Integer r10 = r0.d();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        AnchorType r11 = e();
        AnchorType r12 = r0.e();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        return true;
    L48:
        return false;
    L47:
        if (r11.equals(r12) == true) goto L49;
    L41:
        return false;
    L40:
        if (r9.equals(r10) == true) goto L42;
    L34:
        return false;
    L33:
        if (r8.equals(r4) == true) goto L35;
    L27:
        return false;
    L26:
        if (r7.equals(r3) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    @Override // com.alibaba.excel.metadata.data.c
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = a();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Integer r6 = b();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        Integer r10 = c();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Integer r14 = d();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        AnchorType r17 = e();
        int r18 = (r15 + r16) * 59;
        if (r17 == null) goto L23;
        r3 = r17.hashCode();
    L23:
        return r18 + r3;
    L17:
        r16 = r14.hashCode();
        goto L18
    L13:
        r12 = r10.hashCode();
        goto L14
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = r1.hashCode();
        goto L6
    }
}
