package org.apache.poi.hwpf.model;

import org.apache.poi.hwpf.model.types.FibRgLw95AbstractType;

/* JADX INFO: loaded from: classes7.dex */
class FibRgLw95 extends FibRgLw95AbstractType implements FibRgLw {

    /* JADX INFO: renamed from: org.apache.poi.hwpf.model.FibRgLw95$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType = null;

        static {
            int[] r0 = new int[SubdocumentType.values().length];
            $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType = r0;
            r0[SubdocumentType.MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[SubdocumentType.FOOTNOTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[SubdocumentType.HEADER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[SubdocumentType.MACRO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[SubdocumentType.ANNOTATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[SubdocumentType.ENDNOTE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[SubdocumentType.TEXTBOX.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[SubdocumentType.HEADER_TEXTBOX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public FibRgLw95() {
    }

    public FibRgLw95(byte[] r1, int r2) {
        fillFields(r1, r2);
    }

    @Override // org.apache.poi.hwpf.model.FibRgLw
    public int getSubdocumentTextStreamLength(SubdocumentType r3) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[r3.ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L5;
        };
    L5:
        throw new UnsupportedOperationException("Unsupported: " + r3);
    L7:
        return getCcpHdrTxbx();
    L9:
        return getCcpTxbx();
    L11:
        return getCcpEdn();
    L13:
        return getCcpAtn();
    L15:
        return getCcpMcr();
    L17:
        return getCcpHdd();
    L19:
        return getCcpFtn();
    L21:
        return getCcpText();
    }

    @Override // org.apache.poi.hwpf.model.FibRgLw
    public void setSubdocumentTextStreamLength(SubdocumentType r3, int r4) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$hwpf$model$SubdocumentType[r3.ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        setCcpHdrTxbx(r4);
        return;
    L8:
        setCcpTxbx(r4);
        return;
    L10:
        setCcpEdn(r4);
        return;
    L12:
        setCcpAtn(r4);
        return;
    L14:
        setCbMac(r4);
        return;
    L16:
        setCcpHdd(r4);
        return;
    L18:
        setCcpFtn(r4);
        return;
    L20:
        setCcpText(r4);
        return;
    L5:
        throw new UnsupportedOperationException("Unsupported: " + r3);
    }
}
