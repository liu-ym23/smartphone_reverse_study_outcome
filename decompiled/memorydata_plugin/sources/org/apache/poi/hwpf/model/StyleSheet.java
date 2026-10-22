package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hwpf.sprm.CharacterSprmUncompressor;
import org.apache.poi.hwpf.sprm.ParagraphSprmUncompressor;
import org.apache.poi.hwpf.usermodel.CharacterProperties;
import org.apache.poi.hwpf.usermodel.ParagraphProperties;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class StyleSheet {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Deprecated
    private static final CharacterProperties NIL_CHP = null;
    private static final byte[] NIL_CHPX = null;

    @Deprecated
    private static final ParagraphProperties NIL_PAP = null;
    private static final byte[] NIL_PAPX = null;
    private int _cbStshi;
    private Stshif _stshif;
    StyleDescription[] _styleDescriptions;

    static {
        NIL_PAP = new ParagraphProperties();
        NIL_CHP = new CharacterProperties();
        NIL_CHPX = new byte[0];
        NIL_PAPX = new byte[]{0, 0};
    }

    public StyleSheet(byte[] r7, int r8) {
        this._cbStshi = LittleEndian.getShort(r7, r8);
        int r9 = r8 + 2;
        Stshif r0 = new Stshif(r7, r9);
        this._stshif = r0;
        if (r0.getCstd() < 0) goto L19;
        int r10 = r9 + this._cbStshi;
        this._styleDescriptions = new StyleDescription[this._stshif.getCstd()];
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= this._stshif.getCstd()) goto L11;
        short r3 = LittleEndian.getShort(r7, r10);
        int r11 = r10 + 2;
        if (r3 <= 0) goto L10;
        this._styleDescriptions[r2] = new StyleDescription(r7, this._stshif.getCbSTDBaseInFile(), r11, true);
    L10:
        r10 = r11 + r3;
        r2 = r2 + 1;
    L11:
        StyleDescription[] r12 = this._styleDescriptions;
        if (r1 >= r12.length) goto L17;
        if (r12[r1] == null) goto L16;
        createPap(r1);
        createChp(r1);
    L16:
        r1 = r1 + 1;
        goto L11
    L17:
        return;
    L19:
        throw new IllegalArgumentException("Cannot create StyleSheet, invalid Cstd: " + this._stshif.getCstd());
    }

    @Deprecated
    private void createChp(int r6) {
        StyleDescription r0 = this._styleDescriptions[r6];
        CharacterProperties r1 = r0.getCHP();
        byte[] r2 = r0.getCHPX();
        int r3 = r0.getBaseStyle();
        if (r3 != r6) goto L5;
        r3 = 4095;
    L5:
        if (r1 != null) goto L16;
        if (r2 == null) goto L17;
        CharacterProperties r7 = new CharacterProperties();
        if (r3 == 4095) goto L14;
        r7 = this._styleDescriptions[r3].getCHP();
        if (r7 != null) goto L12;
        createChp(r3);
        r7 = this._styleDescriptions[r3].getCHP();
    L12:
        if (r7 != null) goto L14;
        r7 = new CharacterProperties();
    L14:
        r0.setCHP(CharacterSprmUncompressor.uncompressCHP(r7, r2, 0));
        return;
    L17:
        return;
    }

    @Deprecated
    private void createPap(int r6) {
        StyleDescription r0 = this._styleDescriptions[r6];
        ParagraphProperties r1 = r0.getPAP();
        byte[] r2 = r0.getPAPX();
        int r3 = r0.getBaseStyle();
        if (r1 != null) goto L17;
        if (r2 == null) goto L18;
        ParagraphProperties r4 = new ParagraphProperties();
        if (r3 == 4095) goto L13;
        r4 = this._styleDescriptions[r3].getPAP();
        if (r4 != null) goto L13;
        if (r3 == r6) goto L12;
        createPap(r3);
        r4 = this._styleDescriptions[r3].getPAP();
        goto L13
    L12:
        throw new IllegalStateException("Pap style " + r6 + " claimed to have itself as its parent, which isn't allowed");
    L13:
        if (r4 != null) goto L15;
        r4 = new ParagraphProperties();
    L15:
        r0.setPAP(ParagraphSprmUncompressor.uncompressPAP(r4, r2, 2));
        return;
    L18:
        return;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, StyleSheet.class) == true) goto L5;
        return false;
    L5:
        StyleSheet r6 = (StyleSheet) ZeusTransformUtils.preCheckCast(r5, StyleSheet.class, "com.obric.memorydata.plugin");
        if (r6._stshif.equals(this._stshif) == true) goto L8;
    L27:
        return false;
    L8:
        if (r6._cbStshi != this._cbStshi) goto L27;
        if (r6._styleDescriptions.length != this._styleDescriptions.length) goto L27;
        int r0 = 0;
    L13:
        StyleDescription[] r1 = this._styleDescriptions;
        if (r0 >= r1.length) goto L25;
        StyleDescription r2 = r1[r0];
        StyleDescription r3 = r6._styleDescriptions[r0];
        if (r2 != null) goto L19;
        if (r3 != null) goto L19;
    L23:
        r0 = r0 + 1;
    L19:
        if (r3 == null) goto L24;
        if (r3.equals(r2) == true) goto L23;
    L24:
        return false;
    L25:
        return true;
    }

    public byte[] getCHPX(int r3) {
        if (r3 == 4095) goto L5;
        StyleDescription[] r0 = this._styleDescriptions;
        if (r3 < r0.length) goto L11;
        return NIL_CHPX;
    L11:
        if (r3 != (-1)) goto L15;
        return NIL_CHPX;
    L15:
        if (r0[r3] != null) goto L19;
        return NIL_CHPX;
    L19:
        if (r0[r3].getCHPX() != null) goto L23;
        return NIL_CHPX;
    L23:
        return this._styleDescriptions[r3].getCHPX();
    L5:
        return NIL_CHPX;
    }

    @Deprecated
    public CharacterProperties getCharacterStyle(int r2) {
        if (r2 == 4095) goto L5;
        StyleDescription[] r1 = this._styleDescriptions;
        if (r2 < r1.length) goto L11;
        return NIL_CHP;
    L11:
        if (r2 != (-1)) goto L15;
        return NIL_CHP;
    L15:
        if (r1[r2] == null) goto L18;
        return r1[r2].getCHP();
    L18:
        return NIL_CHP;
    L5:
        return NIL_CHP;
    }

    public byte[] getPAPX(int r3) {
        if (r3 == 4095) goto L5;
        StyleDescription[] r0 = this._styleDescriptions;
        if (r3 < r0.length) goto L11;
        return NIL_PAPX;
    L11:
        if (r3 != (-1)) goto L15;
        return NIL_PAPX;
    L15:
        if (r0[r3] != null) goto L19;
        return NIL_PAPX;
    L19:
        if (r0[r3].getPAPX() != null) goto L23;
        return NIL_PAPX;
    L23:
        return this._styleDescriptions[r3].getPAPX();
    L5:
        return NIL_PAPX;
    }

    public int hashCode() {
        return 42;
    }
}
