package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.util.BitField;

/* JADX INFO: loaded from: classes7.dex */
public abstract class GrfhicAbstractType {
    private static final BitField fHtmlBuiltInBullet = null;
    private static final BitField fHtmlChecked = null;
    private static final BitField fHtmlFirstLineMismatch = null;
    private static final BitField fHtmlHangingIndentBeneathNumber = null;
    private static final BitField fHtmlListTextNotSharpDot = null;
    private static final BitField fHtmlNotPeriod = null;
    private static final BitField fHtmlTabLeftIndentMismatch = null;
    private static final BitField fHtmlUnsupported = null;
    protected byte field_1_grfhic;

    static {
        fHtmlChecked = new BitField(1);
        fHtmlUnsupported = new BitField(2);
        fHtmlListTextNotSharpDot = new BitField(4);
        fHtmlNotPeriod = new BitField(8);
        fHtmlFirstLineMismatch = new BitField(16);
        fHtmlTabLeftIndentMismatch = new BitField(32);
        fHtmlHangingIndentBeneathNumber = new BitField(64);
        fHtmlBuiltInBullet = new BitField(128);
    }

    public GrfhicAbstractType() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        GrfhicAbstractType r6 = (GrfhicAbstractType) ZeusTransformUtils.preCheckCast(r5, GrfhicAbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_grfhic != r6.field_1_grfhic) goto L15;
        return true;
    L15:
        return false;
    }

    public void fillFields(byte[] r1, int r2) {
        this.field_1_grfhic = r1[r2 + 0];
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Byte.valueOf(this.field_1_grfhic)});
    }

    public boolean isFHtmlBuiltInBullet() {
        return fHtmlBuiltInBullet.isSet(this.field_1_grfhic);
    }

    public boolean isFHtmlChecked() {
        return fHtmlChecked.isSet(this.field_1_grfhic);
    }

    public boolean isFHtmlFirstLineMismatch() {
        return fHtmlFirstLineMismatch.isSet(this.field_1_grfhic);
    }

    public boolean isFHtmlHangingIndentBeneathNumber() {
        return fHtmlHangingIndentBeneathNumber.isSet(this.field_1_grfhic);
    }

    public boolean isFHtmlListTextNotSharpDot() {
        return fHtmlListTextNotSharpDot.isSet(this.field_1_grfhic);
    }

    public boolean isFHtmlNotPeriod() {
        return fHtmlNotPeriod.isSet(this.field_1_grfhic);
    }

    public boolean isFHtmlTabLeftIndentMismatch() {
        return fHtmlTabLeftIndentMismatch.isSet(this.field_1_grfhic);
    }

    public boolean isFHtmlUnsupported() {
        return fHtmlUnsupported.isSet(this.field_1_grfhic);
    }

    public String toString() {
        return "[Grfhic]\n    .grfhic               =  ( " + this.field_1_grfhic + " )\n         .fHtmlChecked             = " + isFHtmlChecked() + "\n         .fHtmlUnsupported         = " + isFHtmlUnsupported() + "\n         .fHtmlListTextNotSharpDot     = " + isFHtmlListTextNotSharpDot() + "\n         .fHtmlNotPeriod           = " + isFHtmlNotPeriod() + "\n         .fHtmlFirstLineMismatch     = " + isFHtmlFirstLineMismatch() + "\n         .fHtmlTabLeftIndentMismatch     = " + isFHtmlTabLeftIndentMismatch() + "\n         .fHtmlHangingIndentBeneathNumber     = " + isFHtmlHangingIndentBeneathNumber() + "\n         .fHtmlBuiltInBullet       = " + isFHtmlBuiltInBullet() + "\n[/Grfhic]";
    }
}
