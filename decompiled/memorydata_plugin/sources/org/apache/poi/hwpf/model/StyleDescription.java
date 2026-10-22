package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.model.types.StdfBaseAbstractType;
import org.apache.poi.hwpf.usermodel.CharacterProperties;
import org.apache.poi.hwpf.usermodel.ParagraphProperties;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class StyleDescription {
    private static final c LOG = null;
    private int _baseLength;

    @Deprecated
    CharacterProperties _chp;
    String _name;

    @Deprecated
    ParagraphProperties _pap;
    private StdfBase _stdfBase;
    private StdfPost2000 _stdfPost2000;
    UPX[] _upxs;

    static {
        LOG = b.a(StyleDescription.class);
    }

    public StyleDescription() {
    }

    public StyleDescription(byte[] r7, int r8, int r9, boolean r10) {
        this._baseLength = r8;
        int r0 = r9 + r8;
        int r1 = 0;
        if (r8 != 18) goto L6;
        boolean r11 = true;
    L10:
        this._stdfBase = new StdfBase(r7, r9);
        int r12 = r9 + StdfBaseAbstractType.getSize();
        if (r11 == false) goto L14;
        this._stdfPost2000 = new StdfPost2000(r7, r12);
    L14:
        if (r10 == false) goto L16;
        short r13 = LittleEndian.getShort(r7, r0);
        r0 = r0 + 2;
        short r14 = 2;
    L17:
        this._name = StringUtil.getFromUnicodeLE(r7, r0, (r13 * r14) / 2);
        int r15 = ((r13 + 1) * r14) + r0;
        int r16 = this._stdfBase.getCupx();
        this._upxs = new UPX[r16];
    L18:
        if (r1 >= r16) goto L23;
        short r2 = LittleEndian.getShort(r7, r15);
        int r17 = r15 + 2;
        this._upxs[r1] = new UPX(IOUtils.safelyClone(r7, r17, r2, 32767));
        r15 = r17 + r2;
        if ((r2 & 1) != 1) goto L22;
        r15 = r15 + 1;
    L22:
        r1 = r1 + 1;
        goto L18
    L23:
        return;
    L16:
        r13 = r7[r0];
        r14 = 1;
        goto L17
    L6:
        if (r8 == 10) goto L9;
        LOG.atWarn().a("Style definition has non-standard size of {}", v.a(r8));
    L9:
        r11 = false;
        goto L10
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, StyleDescription.class) == true) goto L9;
        return false;
    L9:
        StyleDescription r5 = (StyleDescription) ZeusTransformUtils.preCheckCast(r4, StyleDescription.class, "com.obric.memorydata.plugin");
        if (Objects.equals(this._name, r5._name) == true) goto L13;
        return false;
    L13:
        if (Objects.equals(this._stdfBase, r5._stdfBase) == true) goto L16;
        return false;
    L16:
        return Arrays.equals(this._upxs, r5._upxs);
    }

    public int getBaseStyle() {
        return this._stdfBase.getIstdBase();
    }

    @Deprecated
    public CharacterProperties getCHP() {
        return this._chp;
    }

    public byte[] getCHPX() {
        byte r0 = this._stdfBase.getStk();
        if (r0 != 1) goto L5;
        UPX[] r3 = this._upxs;
        if (r3.length <= 1) goto L13;
        UPX r4 = r3[1];
    L9:
        return r4.getUPX();
    L13:
        return null;
    L5:
        if (r0 == 2) goto L7;
        return null;
    L7:
        r4 = this._upxs[0];
        goto L9
    }

    @Deprecated
    public ParagraphProperties getPAP() {
        return this._pap;
    }

    public byte[] getPAPX() {
        if (this._stdfBase.getStk() == 1) goto L7;
        return null;
    L7:
        return this._upxs[0].getUPX();
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{this._name, this._stdfBase, this._upxs});
    }

    @Deprecated
    void setCHP(CharacterProperties r1) {
        this._chp = r1;
    }

    @Deprecated
    void setPAP(ParagraphProperties r1) {
        this._pap = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[STD]: '");
        r0.append(this._name);
        r0.append("'");
        r0.append(("\nStdfBase:\t" + this._stdfBase).replace("\n", "\n    "));
        r0.append(("\nStdfPost2000:\t" + this._stdfPost2000).replace("\n", "\n    "));
        UPX[] r8 = this._upxs;
        int r1 = r8.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L6;
        r0.append(("\nUPX:\t" + r8[r4]).replace("\n", "\n    "));
        r4 = r4 + 1;
        goto L3
    L6:
        return r0.toString();
    }
}
