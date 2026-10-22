package org.apache.poi.hwpf.sprm;

import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.hwpf.model.Colorref;
import org.apache.poi.hwpf.model.Hyphenation;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.usermodel.BorderCode;
import org.apache.poi.hwpf.usermodel.CharacterProperties;
import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.apache.poi.hwpf.usermodel.ShadingDescriptor80;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class CharacterSprmUncompressor extends SprmUncompressor {
    private static final c LOG = null;

    static {
        LOG = b.a(CharacterSprmUncompressor.class);
    }

    public CharacterSprmUncompressor() {
    }

    private static void applySprms(CharacterProperties r2, byte[] r3, int r4, boolean r5, CharacterProperties r6) {
        SprmIterator r0 = new SprmIterator(r3, r4);
    L4:
        if (r0.hasNext() == false) goto L10;
        SprmOperation r7 = r0.next();
        if (r7.getType() != 2) goto L7;
        unCompressCHPOperation(r2, r6, r7);
        goto L4
    L7:
        if (r5 == false) goto L4;
        LOG.atWarn().a("Non-CHP SPRM returned by SprmIterator: {}", r7);
        goto L4
    }

    private static boolean getCHPFlag(byte r4, boolean r5) {
        if (r4 != 0) goto L6;
        return false;
    L6:
        if (r4 != 1) goto L8;
        return true;
    L8:
        int r6 = r4 & 129;
        if (r6 != 128) goto L11;
        return r5;
    L11:
        if (r6 == 129) goto L13;
        return false;
    L13:
        return !r5;
    }

    private static Integer getIstd(byte[] r3, int r4) {
        Integer r0 = null;
        SprmIterator r1 = new SprmIterator(r3, r4);     // Catch: Exception -> L12
    L5:
        if (r1.hasNext() == false) goto L14;
        SprmOperation r5 = r1.next();     // Catch: Exception -> L12
        if (r5.getType() != 2) goto L5;
        if (r5.getOperation() != 48) goto L5;
        r0 = Integer.valueOf(r5.getOperand());     // Catch: Exception -> L12
    L14:
        return r0;
    L12:
        e = move-exception;
        LOG.atError().a(e).a("Unable to extract istd from direct CHP SPRM");
        goto L14
    }

    static void unCompressCHPOperation(CharacterProperties r5, CharacterProperties r6, SprmOperation r7) {
        boolean r2 = true;
        switch(r7.getOperation()) {
            case 0: goto L101;
            case 1: goto L100;
            case 2: goto L99;
            case 3: goto L98;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L103;
            case 8: goto L94;
            case 9: goto L93;
            case 10: goto L92;
            case 11: goto L103;
            case 12: goto L91;
            case 13: goto L103;
            case 14: goto L90;
            case 15: goto L103;
            case 16: goto L103;
            case 17: goto L103;
            case 18: goto L103;
            case 19: goto L103;
            case 20: goto L103;
            case 21: goto L103;
            case 22: goto L103;
            case 23: goto L103;
            case 24: goto L103;
            case 25: goto L103;
            case 26: goto L103;
            case 27: goto L103;
            case 28: goto L103;
            case 29: goto L103;
            case 30: goto L103;
            case 31: goto L103;
            case 32: goto L103;
            case 33: goto L103;
            case 34: goto L103;
            case 35: goto L103;
            case 36: goto L103;
            case 37: goto L103;
            case 38: goto L103;
            case 39: goto L103;
            case 40: goto L103;
            case 41: goto L103;
            case 42: goto L103;
            case 43: goto L103;
            case 44: goto L103;
            case 45: goto L103;
            case 46: goto L103;
            case 47: goto L103;
            case 48: goto L89;
            case 49: goto L103;
            case 50: goto L88;
            case 51: goto L86;
            case 52: goto L103;
            case 53: goto L85;
            case 54: goto L84;
            case 55: goto L83;
            case 56: goto L82;
            case 57: goto L81;
            case 58: goto L80;
            case 59: goto L79;
            case 60: goto L78;
            case 61: goto L77;
            case 62: goto L76;
            case 63: goto L51;
            case 64: goto L50;
            case 65: goto L49;
            case 66: goto L48;
            case 67: goto L46;
            case 68: goto L45;
            case 69: goto L44;
            case 70: goto L37;
            case 71: goto L103;
            case 72: goto L36;
            case 73: goto L35;
            case 74: goto L34;
            case 75: goto L33;
            case 76: goto L103;
            case 77: goto L32;
            case 78: goto L31;
            case 79: goto L77;
            case 80: goto L30;
            case 81: goto L29;
            case 82: goto L103;
            case 83: goto L28;
            case 84: goto L27;
            case 85: goto L26;
            case 86: goto L25;
            case 87: goto L20;
            case 88: goto L19;
            case 89: goto L18;
            case 90: goto L103;
            case 91: goto L103;
            case 92: goto L103;
            case 93: goto L103;
            case 94: goto L103;
            case 95: goto L103;
            case 96: goto L103;
            case 97: goto L103;
            case 98: goto L13;
            case 99: goto L12;
            case 100: goto L11;
            case 101: goto L10;
            case 102: goto L9;
            case 103: goto L103;
            case 104: goto L103;
            case 105: goto L103;
            case 106: goto L103;
            case 107: goto L103;
            case 108: goto L103;
            case 109: goto L49;
            case 110: goto L8;
            case 111: goto L7;
            case 112: goto L6;
            case 113: goto L103;
            case 114: goto L103;
            case 115: goto L103;
            case 116: goto L103;
            case 117: goto L5;
            default: goto L4;
        };
    L4:
        LOG.atDebug().a("Unknown CHP sprm ignored: {}", r7);
        return;
    L5:
        r6.setFNoProof(getCHPFlag((byte) r7.getOperand(), r5.isFNoProof()));
        return;
    L6:
        r6.setCv(new Colorref(r7.getOperand()));
        return;
    L7:
        r6.setIdctHint((byte) r7.getOperand());
        return;
    L8:
        r6.setLidFE((short) r7.getOperand());
        return;
    L9:
        r6.setShd(new ShadingDescriptor80(r7.getGrpprl(), r7.getGrpprlOffset()).toShadingDescriptor());
        return;
    L10:
        r6.setBrc(new BorderCode(r7.getGrpprl(), r7.getGrpprlOffset()));
        return;
    L11:
        r6.setDttmRMarkDel(new DateAndTime(r7.getGrpprl(), r7.getGrpprlOffset()));
        return;
    L12:
        r6.setIbstRMarkDel((short) r7.getOperand());
        return;
    L13:
        byte[] r0 = new byte[32];
        byte[] r1 = r7.getGrpprl();
        int r8 = r7.getGrpprlOffset();
        if (r1[r8] != 0) goto L17;
        r2 = false;
    L17:
        r6.setFDispFldRMark(r2);
        r6.setIbstDispFldRMark(LittleEndian.getShort(r1, r8 + 1));
        r6.setDttmDispFldRMark(new DateAndTime(r1, r8 + 3));
        System.arraycopy(r1, r8 + 7, r0, 0, 32);
        r6.setXstDispFldRMark(r0);
        return;
    L18:
        r6.setSfxtText((byte) r7.getOperand());
        return;
    L19:
        r6.setFEmboss(getFlag(r7.getOperand()));
        return;
    L20:
        byte[] r9 = r7.getGrpprl();
        int r10 = r7.getGrpprlOffset();
        if (r9[r10] != 0) goto L24;
        r2 = false;
    L24:
        r6.setFPropRMark(r2);
        r6.setIbstPropRMark(LittleEndian.getShort(r9, r10 + 1));
        r6.setDttmPropRMark(new DateAndTime(r9, r10 + 3));
        return;
    L25:
        r6.setFObj(getFlag(r7.getOperand()));
        return;
    L26:
        r6.setFSpec(getFlag(r7.getOperand()));
        return;
    L27:
        r6.setFImprint(getFlag(r7.getOperand()));
        return;
    L28:
        r6.setFDStrike(getFlag(r7.getOperand()));
        return;
    L29:
        r6.setFtcOther((short) r7.getOperand());
        return;
    L30:
        r6.setFtcFE((short) r7.getOperand());
        return;
    L31:
        r6.setHresi(new Hyphenation((short) r7.getOperand()));
        return;
    L32:
        r6.setHps(r6.getHps() + ((int) ((r7.getOperand() / 100.0f) * r6.getHps())));
        return;
    L33:
        r6.setHpsKern(r7.getOperand());
        return;
    L34:
        int r11 = Math.max(r6.getHps() + LittleEndian.getShort(r7.getGrpprl(), r7.getGrpprlOffset()), 8);
    L47:
        r6.setHps(r11);
        return;
    L35:
        r11 = LittleEndian.getShort(r7.getGrpprl(), r7.getGrpprlOffset());
        goto L47
    L36:
        r6.setIss((byte) r7.getOperand());
        return;
    L37:
        int r12 = r7.getOperand();
        short r13 = r5.getHpsPos();
        if (r12 == 0) goto L41;
        if (r13 != 0) goto L127;
        int r14 = r6.getHps() - 2;
    L43:
        r11 = Math.max(r14, 2);
        goto L47
    L127:
        return;
    L41:
        if (r13 == 0) goto L128;
    L42:
        r14 = r6.getHps() + 2;
        goto L43
    L128:
        return;
    L44:
        r6.setHpsPos((short) r7.getOperand());
        return;
    L45:
        r11 = Math.max(r6.getHps() + (((byte) r7.getOperand()) * 2), 2);
        goto L47
    L46:
        r11 = r7.getOperand();
        goto L47
    L48:
        r6.setIco((byte) r7.getOperand());
        return;
    L49:
        r6.setLidDefault((short) r7.getOperand());
        return;
    L50:
        r6.setDxaSpace(r7.getOperand());
        return;
    L51:
        int r15 = r7.getOperand();
        int r3 = r15 & 255;
        if (r3 == 0) goto L54;
        r6.setHps(r3);
    L54:
        byte r4 = (byte) (((byte) ((65280 & r15) >>> 8)) >>> 1);
        if (r4 == 0) goto L57;
        r6.setHps(Math.max(r6.getHps() + (r4 * 2), 2));
    L57:
        byte r16 = (byte) ((16711680 & r15) >>> 16);
        if (r16 == (-128)) goto L61;
        r6.setHpsPos(r16);
    L61:
        if ((r15 & 256) > 0) goto L64;
        r2 = false;
    L64:
        if (r2 == true) goto L66;
    L71:
        if (r2 == false) goto L134;
        if (r16 == 0) goto L74;
        return;
    L74:
        if (r5.getHpsPos() != 0) goto L42;
        return;
    L134:
        return;
    L66:
        if ((r16 & 255) == 128) goto L71;
        if (r16 == 0) goto L71;
        if (r5.getHpsPos() != 0) goto L71;
        r6.setHps(Math.max(r6.getHps() - 2, 2));
        goto L71
    L76:
        r6.setKul((byte) r7.getOperand());
        return;
    L77:
        r6.setFtcAscii((short) r7.getOperand());
        return;
    L78:
        r6.setFVanish(getCHPFlag((byte) r7.getOperand(), r5.isFVanish()));
        return;
    L79:
        r6.setFCaps(getCHPFlag((byte) r7.getOperand(), r5.isFCaps()));
        return;
    L80:
        r6.setFSmallCaps(getCHPFlag((byte) r7.getOperand(), r5.isFSmallCaps()));
        return;
    L81:
        r6.setFShadow(getCHPFlag((byte) r7.getOperand(), r5.isFShadow()));
        return;
    L82:
        r6.setFOutline(getCHPFlag((byte) r7.getOperand(), r5.isFOutline()));
        return;
    L83:
        r6.setFStrike(getCHPFlag((byte) r7.getOperand(), r5.isFStrike()));
        return;
    L84:
        r6.setFItalic(getCHPFlag((byte) r7.getOperand(), r5.isFItalic()));
        return;
    L85:
        r6.setFBold(getCHPFlag((byte) r7.getOperand(), r5.isFBold()));
        return;
    L86:
        r5.copy().setFSpec(r6.isFSpec());
        return;
    L88:
        r6.setFBold(false);
        r6.setFItalic(false);
        r6.setFOutline(false);
        r6.setFStrike(false);
        r6.setFShadow(false);
        r6.setFSmallCaps(false);
        r6.setFCaps(false);
        r6.setFVanish(false);
        r6.setKul((byte) 0);
        r6.setIco((byte) 0);
        return;
    L89:
        r6.setIstd(r7.getOperand());
        return;
    L90:
        r6.setFcObj(r7.getOperand());
        return;
    L91:
        r6.setIcoHighlight((byte) r7.getOperand());
        r6.setFHighlight(getFlag(r7.getOperand()));
        return;
    L92:
        r6.setFOle2(getFlag(r7.getOperand()));
        return;
    L93:
        r6.setFSpec(true);
        r6.setFtcSym(LittleEndian.getShort(r7.getGrpprl(), r7.getGrpprlOffset()));
        r6.setXchSym(LittleEndian.getShort(r7.getGrpprl(), r7.getGrpprlOffset() + 2));
        return;
    L94:
        int r17 = r7.getOperand();
        r6.setFChsDiff(getFlag((short) (r17 & 255)));
        r6.setChse((short) (r17 & 16776960));
        return;
    L95:
        r6.setFData(getFlag(r7.getOperand()));
        return;
    L96:
        r6.setDttmRMark(new DateAndTime(r7.getGrpprl(), r7.getGrpprlOffset()));
        return;
    L97:
        r6.setIbstRMark((short) r7.getOperand());
        return;
    L98:
        r6.setFcPic(r7.getOperand());
        r6.setFSpec(true);
        return;
    L99:
        r6.setFFldVanish(getFlag(r7.getOperand()));
        return;
    L100:
        r6.setFRMark(getFlag(r7.getOperand()));
        return;
    L101:
        r6.setFRMarkDel(getFlag(r7.getOperand()));
        return;
    }

    public static CharacterProperties uncompressCHP(StyleSheet r3, CharacterProperties r4, byte[] r5, int r6) {
        if (r4 != null) goto L4;
        r4 = new CharacterProperties();
        CharacterProperties r0 = new CharacterProperties();
    L5:
        Integer r1 = getIstd(r5, r6);
        if (r1 != null) goto L19;
    L11:
        CharacterProperties r7 = r0.copy();
        applySprms(r0, r5, r6, true, r7);     // Catch: Exception -> L14
    L16:
        return r7;
    L14:
        e = move-exception;
        LOG.atError().a(e).a("Unable to process all direct CHP SPRMs");
        goto L16
    L19:
        applySprms(r4, r3.getCHPX(r1.intValue()), 0, false, r0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        LOG.atError().a(e).a("Unable to apply all style {} CHP SPRMs to CHP", r1);
        goto L11
    L4:
        r0 = r4.copy();
        goto L5
    }

    @Deprecated
    public static CharacterProperties uncompressCHP(CharacterProperties r2, byte[] r3, int r4) {
        CharacterProperties r0 = r2.copy();
        applySprms(r2, r3, r4, true, r0);
        return r0;
    }
}
