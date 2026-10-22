package org.apache.poi.hwpf.sprm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.model.TabDescriptor;
import org.apache.poi.hwpf.model.types.TBDAbstractType;
import org.apache.poi.hwpf.usermodel.BorderCode;
import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.apache.poi.hwpf.usermodel.DropCapSpecifier;
import org.apache.poi.hwpf.usermodel.LineSpacingDescriptor;
import org.apache.poi.hwpf.usermodel.ParagraphProperties;
import org.apache.poi.hwpf.usermodel.ShadingDescriptor;
import org.apache.poi.hwpf.usermodel.ShadingDescriptor80;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class ParagraphSprmUncompressor extends SprmUncompressor {
    private static final c LOG = null;

    static {
        LOG = b.a(ParagraphSprmUncompressor.class);
    }

    public ParagraphSprmUncompressor() {
    }

    private static void handleTabs(ParagraphProperties r9, SprmOperation r10) {
        byte[] r0 = r10.getGrpprl();
        int r11 = r10.getGrpprlOffset();
        int r1 = r11 + 1;
        byte r12 = r0[r11];
        int[] r2 = r9.getRgdxaTab();
        TabDescriptor[] r3 = r9.getRgtbd();
        HashMap r4 = new HashMap();
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r6 >= r2.length) goto L6;
        r4.put(Integer.valueOf(r2[r6]), r3[r6]);
        r6 = r6 + 1;
        goto L4
    L6:
        int r7 = 0;
    L7:
        if (r7 >= r12) goto L9;
        r4.remove(Integer.valueOf(LittleEndian.getShort(r0, r1)));
        r1 = r1 + 2;
        r7 = r7 + 1;
        goto L7
    L9:
        int r13 = r1 + 1;
        byte r8 = r0[r1];
        int r14 = r13;
        int r15 = 0;
    L10:
        if (r15 >= r8) goto L12;
        r4.put(Integer.valueOf(LittleEndian.getShort(r0, r14)), new TabDescriptor(r0, ((TBDAbstractType.getSize() * r8) + r15) + r13));
        r14 = r14 + 2;
        r15 = r15 + 1;
        goto L10
    L12:
        int r16 = r4.size();
        int[] r17 = new int[r16];
        TabDescriptor[] r18 = new TabDescriptor[r16];
        ArrayList r19 = new ArrayList(r4.keySet());
        Collections.sort(r19);
    L13:
        if (r5 >= r16) goto L19;
        Integer r20 = (Integer) ZeusTransformUtils.preCheckCast(r19.get(r5), Integer.class, "com.obric.memorydata.plugin");
        r17[r5] = r20.intValue();
        if (r4.containsKey(r20) == false) goto L17;
        r18[r5] = (TabDescriptor) ZeusTransformUtils.preCheckCast(r4.get(r20), TabDescriptor.class, "com.obric.memorydata.plugin");
    L18:
        r5 = r5 + 1;
        goto L13
    L17:
        r18[r5] = new TabDescriptor();
        goto L18
    L19:
        r9.setRgdxaTab(r17);
        r9.setRgtbd(r18);
    }

    static void unCompressPAPOperation(ParagraphProperties r5, SprmOperation r6) {
        int r0 = r6.getOperation();
        if (r0 != 93) goto L5;
    L130:
        r5.setDxaRight(r6.getOperand());
        return;
    L5:
        if (r0 != 94) goto L7;
    L128:
        int r7 = r6.getOperand();
    L129:
        r5.setDxaLeft(r7);
        return;
    L7:
        if (r0 != 96) goto L9;
    L126:
        r5.setDxaLeft1(r6.getOperand());
        return;
    L9:
        if (r0 != 97) goto L11;
        r5.setJustificationLogical((byte) r6.getOperand());
        return;
    L11:
        if (r0 == 103) goto L167;
        boolean r2 = false;
        switch(r0) {
            case 0: goto L165;
            case 1: goto L170;
            case 2: goto L158;
            case 3: goto L156;
            case 4: goto L153;
            case 5: goto L149;
            case 6: goto L145;
            case 7: goto L141;
            case 8: goto L139;
            case 9: goto L138;
            case 10: goto L137;
            case 11: goto L136;
            case 12: goto L133;
            case 13: goto L131;
            case 14: goto L130;
            case 15: goto L128;
            case 16: goto L127;
            case 17: goto L126;
            case 18: goto L125;
            case 19: goto L124;
            case 20: goto L123;
            case 21: goto L170;
            case 22: goto L120;
            case 23: goto L116;
            case 24: goto L114;
            case 25: goto L113;
            case 26: goto L112;
            case 27: goto L107;
            default: goto L14;
        };
    L14:
        switch(r0) {
            case 34: goto L106;
            case 35: goto L105;
            case 36: goto L104;
            case 37: goto L103;
            case 38: goto L102;
            case 39: goto L101;
            case 40: goto L100;
            case 41: goto L99;
            case 42: goto L96;
            case 43: goto L94;
            case 44: goto L93;
            case 45: goto L92;
            case 46: goto L91;
            case 47: goto L106;
            case 48: goto L88;
            case 49: goto L84;
            default: goto L15;
        };
    L15:
        switch(r0) {
            case 51: goto L80;
            case 52: goto L76;
            case 53: goto L72;
            case 54: goto L68;
            case 55: goto L64;
            case 56: goto L60;
            case 57: goto L58;
            case 58: goto L57;
            case 59: goto L171;
            default: goto L16;
        };
    L16:
        switch(r0) {
            case 62: goto L56;
            case 63: goto L52;
            case 64: goto L51;
            case 65: goto L48;
            default: goto L17;
        };
    L17:
        switch(r0) {
            case 67: goto L44;
            case 68: goto L172;
            case 69: goto L41;
            default: goto L18;
        };
    L18:
        switch(r0) {
            case 71: goto L37;
            case 72: goto L33;
            case 73: goto L30;
            case 74: goto L29;
            case 75: goto L26;
            case 76: goto L22;
            case 77: goto L20;
            default: goto L19;
        };
    L19:
        LOG.atDebug().a("Unknown PAP sprm ignored: {}", r6);
        return;
    L20:
        r5.setShading(new ShadingDescriptor(r6.getGrpprl(), 3));
        return;
    L29:
        int r8 = (byte) (r5.getItap() + r6.getOperand());
    L31:
        r5.setItap(r8);
        return;
    L30:
        r8 = r6.getOperand();
        goto L31
    L22:
        if (r6.getOperand() == 0) goto L24;
        r2 = true;
    L24:
        r5.setFTtpEmbedded(r2);
        return;
    L26:
        if (r6.getOperand() == 0) goto L28;
        r2 = true;
    L28:
        r5.setFInnerTableCell(r2);
        return;
    L33:
        if (r6.getOperand() == 0) goto L35;
        r2 = true;
    L35:
        r5.setFAdjustRight(r2);
        return;
    L37:
        if (r6.getOperand() == 0) goto L39;
        r2 = true;
    L39:
        r5.setFUsePgsuSettings(r2);
        return;
    L172:
        return;
    L41:
        if (r6.getSizeCode() != 6) goto L180;
        int r1 = r6.size() - 3;
        byte[] r3 = new byte[r1];
        System.arraycopy(r3, 0, r6.getGrpprl(), r6.getGrpprlOffset(), r1);
        r5.setNumrm(r3);
        return;
    L180:
        return;
    L44:
        if (r6.getOperand() == 0) goto L46;
        r2 = true;
    L46:
        r5.setFNumRMIns(r2);
        return;
    L51:
        r5.setLvl((byte) r6.getOperand());
        return;
    L52:
        byte[] r4 = r6.getGrpprl();
        int r9 = r6.getGrpprlOffset();
        if (r4[r9] == 0) goto L55;
        r2 = true;
    L55:
        r5.setFPropRMark(r2);
        r5.setIbstPropRMark(LittleEndian.getShort(r4, r9 + 1));
        r5.setDttmPropRMark(new DateAndTime(r4, r9 + 3));
        return;
    L56:
        r5.setAnld(Arrays.copyOfRange(r6.getGrpprl(), r6.getGrpprlOffset(), r6.getGrpprlOffset() + (r6.size() - 3)));
        return;
    L48:
        if (r6.getOperand() == 0) goto L50;
        r2 = true;
    L50:
        r5.setFBiDi(r2);
        return;
    L57:
        r5.setFontAlign((short) r6.getOperand());
        return;
    L58:
        r5.setWAlignFont(r6.getOperand());
        return;
    L171:
        return;
    L60:
        if (r6.getOperand() == 0) goto L62;
        r2 = true;
    L62:
        r5.setFAutoSpaceDN(r2);
        return;
    L64:
        if (r6.getOperand() == 0) goto L66;
        r2 = true;
    L66:
        r5.setFAutoSpaceDE(r2);
        return;
    L68:
        if (r6.getOperand() == 0) goto L70;
        r2 = true;
    L70:
        r5.setFTopLinePunct(r2);
        return;
    L72:
        if (r6.getOperand() == 0) goto L74;
        r2 = true;
    L74:
        r5.setFOverflowPunct(r2);
        return;
    L76:
        if (r6.getOperand() == 0) goto L78;
        r2 = true;
    L78:
        r5.setFWordWrap(r2);
        return;
    L80:
        if (r6.getOperand() == 0) goto L82;
        r2 = true;
    L82:
        r5.setFKinsoku(r2);
        return;
    L91:
        r5.setDyaFromText(r6.getOperand());
        return;
    L92:
        r5.setShd(new ShadingDescriptor80((short) r6.getOperand()).toShadingDescriptor());
        return;
    L93:
        r5.setDcs(new DropCapSpecifier((short) r6.getOperand()));
        return;
    L94:
        r5.setDyaHeight(r6.getOperand());
        return;
    L99:
        r5.setBrcBar(new BorderCode(r6.getGrpprl(), r6.getGrpprlOffset()));
        return;
    L100:
        r5.setBrcBetween(new BorderCode(r6.getGrpprl(), r6.getGrpprlOffset()));
        return;
    L101:
        r5.setBrcRight(new BorderCode(r6.getGrpprl(), r6.getGrpprlOffset()));
        return;
    L102:
        r5.setBrcBottom(new BorderCode(r6.getGrpprl(), r6.getGrpprlOffset()));
        return;
    L103:
        r5.setBrcLeft(new BorderCode(r6.getGrpprl(), r6.getGrpprlOffset()));
        return;
    L104:
        r5.setBrcTop(new BorderCode(r6.getGrpprl(), r6.getGrpprlOffset()));
        return;
    L105:
        r5.setWr((byte) r6.getOperand());
        return;
    L106:
        r5.setDxaFromText(r6.getOperand());
        return;
    L84:
        if (r6.getOperand() == 0) goto L86;
        r2 = true;
    L86:
        r5.setFWidowControl(r2);
        return;
    L88:
        if (r6.getOperand() == 0) goto L90;
        r2 = true;
    L90:
        r5.setFLocked(r2);
        return;
    L96:
        if (r6.getOperand() == 0) goto L98;
        r2 = true;
    L98:
        r5.setFNoAutoHyph(r2);
        return;
    L107:
        byte r10 = (byte) r6.getOperand();
        byte r11 = (byte) ((r10 & 12) >> 2);
        byte r12 = (byte) (r10 & 3);
        if (r11 == 3) goto L110;
        r5.setPcVert(r11);
    L110:
        if (r12 == 3) goto L210;
        r5.setPcHorz(r12);
        return;
    L210:
        return;
    L112:
        r5.setDxaWidth(r6.getOperand());
        return;
    L113:
        r5.setDyaAbs(r6.getOperand());
        return;
    L114:
        r5.setDxaAbs(r6.getOperand());
        return;
    L123:
        r5.setDyaAfter(r6.getOperand());
        return;
    L124:
        r5.setDyaBefore(r6.getOperand());
        return;
    L125:
        r5.setLspd(new LineSpacingDescriptor(r6.getGrpprl(), r6.getGrpprlOffset()));
        return;
    L127:
        r5.setDxaLeft(r5.getDxaLeft() + r6.getOperand());
        r7 = Math.max(0, r5.getDxaLeft());
        goto L129
    L131:
        handleTabs(r5, r6);
        return;
    L136:
        r5.setIlfo(r6.getOperandShortSigned());
        return;
    L137:
        r5.setIlvl((byte) r6.getOperand());
        return;
    L138:
        r5.setBrcp((byte) r6.getOperand());
        return;
    L139:
        r5.setBrcl((byte) r6.getOperand());
        return;
    L156:
        r5.setJc((byte) r6.getOperand());
        return;
    L165:
        int r13 = r6.getOperand();
    L166:
        r5.setIstd(r13);
        return;
    L170:
        return;
    L116:
        if (r6.getOperand() == 0) goto L118;
        r2 = true;
    L118:
        r5.setFTtp(r2);
        return;
    L120:
        if (r6.getOperand() == 0) goto L122;
        r2 = true;
    L122:
        r5.setFInTable(r2);
        return;
    L133:
        if (r6.getOperand() == 0) goto L135;
        r2 = true;
    L135:
        r5.setFNoLnn(r2);
        return;
    L141:
        if (r6.getOperand() == 0) goto L143;
        r2 = true;
    L143:
        r5.setFPageBreakBefore(r2);
        return;
    L145:
        if (r6.getOperand() == 0) goto L147;
        r2 = true;
    L147:
        r5.setFKeepFollow(r2);
        return;
    L149:
        if (r6.getOperand() == 0) goto L151;
        r2 = true;
    L151:
        r5.setFKeep(r2);
        return;
    L153:
        if (r6.getOperand() == 0) goto L155;
        r2 = true;
    L155:
        r5.setFSideBySide(r2);
        return;
    L158:
        if (r5.getIstd() > 9) goto L160;
    L161:
        byte r14 = (byte) r6.getOperand();
        r5.setIstd(r5.getIstd() + r14);
        r5.setLvl((byte) (r5.getLvl() + r14));
        if (((r14 >> 7) & 1) != 1) goto L164;
        r13 = Math.max(r5.getIstd(), 1);
        goto L166
    L164:
        r13 = Math.min(r5.getIstd(), 9);
        goto L166
    L160:
        if (r5.getIstd() >= 1) goto L161;
        return;
    L167:
        r5.setRsid(r6.getOperand());
    }

    public static ParagraphProperties uncompressPAP(ParagraphProperties r2, byte[] r3, int r4) {
        ParagraphProperties r5 = r2.copy();
        SprmIterator r0 = new SprmIterator(r3, r4);
    L4:
        if (r0.hasNext() == false) goto L11;
        SprmOperation r6 = r0.next();
        if (r6.getType() != 1) goto L4;
        unCompressPAPOperation(r5, r6);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        LOG.atError().a(e).a("Unable to apply SPRM operation '{}'", v.a(r6.getOperation()));
        goto L4
    L11:
        return r5;
    }
}
