package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import androidx.core.text.util.LocalePreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTComplementTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGammaTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInverseGammaTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInverseTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.bt;
import org.openxmlformats.schemas.drawingml.x2006.main.bx;
import org.openxmlformats.schemas.drawingml.x2006.main.by;
import org.openxmlformats.schemas.drawingml.x2006.main.cf;
import org.openxmlformats.schemas.drawingml.x2006.main.z;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.d;

/* JADX INFO: loaded from: classes8.dex */
public class CTSRgbColorImpl extends XmlComplexContentImpl implements cf {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "shade"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "comp"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "inv"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gray"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alpha"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hue"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", LocalePreferences.FirstDayOfWeek.SATURDAY), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "red"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "green"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blue"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gamma"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "invGamma"), new QName("", "val")};
    }

    public CTSRgbColorImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public bx addNewAlpha() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public by addNewAlphaMod() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        by r3 = (by) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), by.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public z addNewAlphaOff() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        z r3 = (z) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewBlue() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[23]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewBlueMod() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[25]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewBlueOff() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[24]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTComplementTransform addNewComp() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTComplementTransform r3 = (CTComplementTransform) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), CTComplementTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGammaTransform addNewGamma() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTGammaTransform r3 = (CTGammaTransform) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[26]), CTGammaTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGrayscaleTransform addNewGray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTGrayscaleTransform r3 = (CTGrayscaleTransform) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), CTGrayscaleTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewGreen() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[20]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewGreenMod() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[22]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewGreenOff() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[21]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTPositiveFixedAngle addNewHue() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTPositiveFixedAngle r3 = (CTPositiveFixedAngle) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), CTPositiveFixedAngle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public by addNewHueMod() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        by r3 = (by) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), by.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAngle addNewHueOff() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAngle r3 = (CTAngle) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), CTAngle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTInverseTransform addNewInv() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTInverseTransform r3 = (CTInverseTransform) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), CTInverseTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTInverseGammaTransform addNewInvGamma() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTInverseGammaTransform r3 = (CTInverseGammaTransform) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[27]), CTInverseGammaTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewLum() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewLumMod() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[16]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewLumOff() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[15]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewRed() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[17]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewRedMod() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[19]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewRedOff() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[18]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewSat() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewSatMod() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt addNewSatOff() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bx addNewShade() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bx addNewTint() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bx getAlphaArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bx[] getAlphaArray() {
        return (bx[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new bx[0]), bx[].class, "com.obric.memorydata.plugin");
    }

    public List<bx> getAlphaList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$yvy6oTjjrzU_LpXyTXZVL0nfloA(this), new $$Lambda$tghlIVeZZdq9nc0Y5mZp4Zwj2U(this), new $$Lambda$Rlkhvr9CuCUueWIaM7yxTLUCwa8(this), new $$Lambda$lLajas_zQ07V0q9ZFxxz_aVP88(this), new $$Lambda$9q1sqKfzdjPEoUb8QLDfDrns5sw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public by getAlphaModArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        by r3 = (by) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), by.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public by[] getAlphaModArray() {
        return (by[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new by[0]), by[].class, "com.obric.memorydata.plugin");
    }

    public List<by> getAlphaModList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$hxxdLjGcbxTvF9_uW3H2qdmCi9g(this), new $$Lambda$bbe3fD8SsZEnkdaiXL91GNF13c(this), new $$Lambda$olmfn9gu3Kb0weYJ5E1TxWSaAs(this), new $$Lambda$2TKKRgsS4h9IUaJVsChEJnDKSEE(this), new $$Lambda$Xe2_D_C2hInK_XIiz9QI5e_yFsw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public z getAlphaOffArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        z r3 = (z) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public z[] getAlphaOffArray() {
        return (z[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new z[0]), z[].class, "com.obric.memorydata.plugin");
    }

    public List<z> getAlphaOffList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ake7QPuszc8I9sVyYEO9DTDkxSg(this), new $$Lambda$e7sKQpNXC6DlxOHdbhSOGkoIuE(this), new $$Lambda$cydI4vYx6Z2pnsYpVA8JKauJVE(this), new $$Lambda$0F0IahWm6hIz8BMxIAB98HAtjUw(this), new $$Lambda$17FnWqrNMxg7loSInXLuxtDcqQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getBlueArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[23], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getBlueArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[23], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getBlueList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$qhp1S4OnC1fBwtOVYm2YpSDwas(this), new $$Lambda$5XXtg0U9hO5TWwZQyA2FVjIZ4(this), new $$Lambda$SZmhy4eBrVsyzYV4SR5nz4MlMiQ(this), new $$Lambda$CPUj0dHA_b7hliZ4YsqOv7nGQwA(this), new $$Lambda$DF2ynIJOv3tvSJyRToyWABPk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getBlueModArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[25], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getBlueModArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[25], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getBlueModList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$8dkmVGjxI2pZqFsEAXsboHfc8sY(this), new $$Lambda$_Ra0IoUNox57U0cDF7KxElak5Sk(this), new $$Lambda$2QYnb5HwWFmLr69hv_7SnERRFJQ(this), new $$Lambda$HkNLKEprXQn9f7Kh25x52cTMKc(this), new $$Lambda$Do6Jw2bmwqRB5uQ3NPGiu1907Ks(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getBlueOffArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[24], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getBlueOffArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[24], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getBlueOffList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$0J0WJ41KcXbYrNkC7H2_1V67e38(this), new $$Lambda$ACkwVhxG1L9NrUgYwM_RuI0co(this), new $$Lambda$pVTvCBWVPjPTGr38pg6Wb41h740(this), new $$Lambda$ebRM6TLS4WAGvbwbM6qTjZNU6xs(this), new $$Lambda$J_hiCXPrfanoetEyyMAqwRyHM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTComplementTransform getCompArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTComplementTransform r3 = (CTComplementTransform) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), CTComplementTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTComplementTransform[] getCompArray() {
        return (CTComplementTransform[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new CTComplementTransform[0]), CTComplementTransform[].class, "com.obric.memorydata.plugin");
    }

    public List<CTComplementTransform> getCompList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$T2gqwanRgIUQukYHXxKIRJ9764(this), new $$Lambda$kWU2jNPRDylm1QbQElbP7dXnRQM(this), new $$Lambda$U3NZBf5ckdISEcc_3yAI88h58UQ(this), new $$Lambda$Fq5lYU0LuF60uoyXuKFtjyaVeFQ(this), new $$Lambda$EUrqjvWdaQJLBtvo9uDwHiTAIs(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGammaTransform getGammaArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTGammaTransform r3 = (CTGammaTransform) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[26], r4), CTGammaTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTGammaTransform[] getGammaArray() {
        return (CTGammaTransform[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[26], new CTGammaTransform[0]), CTGammaTransform[].class, "com.obric.memorydata.plugin");
    }

    public List<CTGammaTransform> getGammaList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$3vzCeaigtjTD89F2AY3NqppLU(this), new $$Lambda$y6LN9MwJoE9CrzRofaeiVGaZt8o(this), new $$Lambda$HZd3wAg4mwbXEGfk5c6otbCVvI(this), new $$Lambda$OgDs0SspJAJmyOYvkC4j5axo8o(this), new $$Lambda$OHkyIL14An2HmWVLh1_UF0V0saE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGrayscaleTransform getGrayArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTGrayscaleTransform r3 = (CTGrayscaleTransform) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), CTGrayscaleTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTGrayscaleTransform[] getGrayArray() {
        return (CTGrayscaleTransform[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new CTGrayscaleTransform[0]), CTGrayscaleTransform[].class, "com.obric.memorydata.plugin");
    }

    public List<CTGrayscaleTransform> getGrayList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ZBQtueVwCcRBMagefG5stmEQvPg(this), new $$Lambda$FZNfChCfAgNK9CCPLD2BrDaXHSw(this), new $$Lambda$NNDg_dHJtIq_P9NrIJWfarrtpNI(this), new $$Lambda$vRihy4ZHvJgFJ9f8SJcBvAZm_s(this), new $$Lambda$pdMHc_jGNtDKmyJEg_5dcaiKRkk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getGreenArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[20], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getGreenArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[20], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getGreenList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$tf80ND1HLfXAMofBwgqzrAlT9u8(this), new $$Lambda$wYAypxla_UEb87E4MStdz6HxZ3M(this), new $$Lambda$bhvyPtXif6f0GatxGlJ7Uhj4o88(this), new $$Lambda$U5zfuLSbB_0AOnKGhG1zRxgImCk(this), new $$Lambda$yd1P_Js1Yfyu_tU8baBdyfpDdDQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getGreenModArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[22], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getGreenModArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[22], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getGreenModList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$HFbGXMiCEYPxkA3tIgUCzzTsp70(this), new $$Lambda$CvjqGbMlclXMpqodLPWeM8r20Tg(this), new $$Lambda$9nd7pFNS7lCIfQh_XdMEf9WZOG8(this), new $$Lambda$iz1bArUJa8uHRiDUT98Iwy3N3zg(this), new $$Lambda$RrFiJchs9CrsbdXBaAGXzyMpkXU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getGreenOffArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[21], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getGreenOffArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[21], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getGreenOffList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$B4AvgZtEd0Lwi8Oyzf5BTv34qV0(this), new $$Lambda$CqCzrab1O0gan5wQtAe1QCrb9M(this), new $$Lambda$xAenyjdL52chv9Ym1RM9akoknT4(this), new $$Lambda$f_XodmNntQ75Z7XjJspdSqxEh8g(this), new $$Lambda$OFqEQNneoanGWsi1sOejT57fZM4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTPositiveFixedAngle getHueArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTPositiveFixedAngle r3 = (CTPositiveFixedAngle) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), CTPositiveFixedAngle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTPositiveFixedAngle[] getHueArray() {
        return (CTPositiveFixedAngle[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new CTPositiveFixedAngle[0]), CTPositiveFixedAngle[].class, "com.obric.memorydata.plugin");
    }

    public List<CTPositiveFixedAngle> getHueList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$zcN7WIc3SBtKML9RNHjKyUuA_4(this), new $$Lambda$jfFwopy4i2Tnu8wAoLSTxFDQr8A(this), new $$Lambda$Zu0EITrDIAIiqPY_o45_DVlVhQ(this), new $$Lambda$svYLZ7zKkY2SuZKKFQvaJZXru24(this), new $$Lambda$ye2badC9T0nCE4TBNPEvS9GI2W0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public by getHueModArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        by r3 = (by) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), by.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public by[] getHueModArray() {
        return (by[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new by[0]), by[].class, "com.obric.memorydata.plugin");
    }

    public List<by> getHueModList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$56H0kIUCezdpF6gvOa05Ml95tlw(this), new $$Lambda$4TRS1l8GyJryDqZqe3z0c2xvugM(this), new $$Lambda$vHwe8OfOZGkaBN1eg6WLPVEpn8M(this), new $$Lambda$JYQzXVj6VqpObFtFxrggO3rJ2XQ(this), new $$Lambda$vcH7ooldD5o8ipomHyVA_U29I(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAngle getHueOffArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTAngle r3 = (CTAngle) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), CTAngle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTAngle[] getHueOffArray() {
        return (CTAngle[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new CTAngle[0]), CTAngle[].class, "com.obric.memorydata.plugin");
    }

    public List<CTAngle> getHueOffList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Le1eUqWQvEMgRHovgb7aixCPIg(this), new $$Lambda$r5PobZThyvfPQKR4Jx4n2w4geM(this), new $$Lambda$YBLcWBDvwxzURGm28BzYxPy8LQ4(this), new $$Lambda$e9o4rxZhNtFmLBdGcCxqn37BiY(this), new $$Lambda$z5l23mDofYnZb9zr6OVSdFpGLZ4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTInverseTransform getInvArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTInverseTransform r3 = (CTInverseTransform) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), CTInverseTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTInverseTransform[] getInvArray() {
        return (CTInverseTransform[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new CTInverseTransform[0]), CTInverseTransform[].class, "com.obric.memorydata.plugin");
    }

    public CTInverseGammaTransform getInvGammaArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTInverseGammaTransform r3 = (CTInverseGammaTransform) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[27], r4), CTInverseGammaTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTInverseGammaTransform[] getInvGammaArray() {
        return (CTInverseGammaTransform[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[27], new CTInverseGammaTransform[0]), CTInverseGammaTransform[].class, "com.obric.memorydata.plugin");
    }

    public List<CTInverseGammaTransform> getInvGammaList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$d2ZbvrG5nu4WbtwUY7zhwhrvrNM(this), new $$Lambda$tX4hA8D7J171T3HD7b_ajoMNMc(this), new $$Lambda$zTOF7jRuy083XuromV05acWfCTg(this), new $$Lambda$GTJclLezqIaZu0LsXRqpFeFFAk(this), new $$Lambda$E_J31T1zFh1XiUAR21X6mtLBQ6M(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<CTInverseTransform> getInvList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$_EDxCL3FH3Dccqk08psIuiaIn8(this), new $$Lambda$aBibyan1vW6JGvefhoCebpYfRbA(this), new $$Lambda$cOWzkljM44iTMJILIVYiplW3z2w(this), new $$Lambda$UtiKBoVGFAC7P4hW8RV313PORHo(this), new $$Lambda$KvV5eQ4XFvhApEWh4a6Eokrvxvk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getLumArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getLumArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[14], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getLumList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$CqLPdMfh4wwZjJOBXRvYn6JJvJs(this), new $$Lambda$DLnzNJUsvaoAak0l0b3Q9cHFOs(this), new $$Lambda$sK5fitz4bJgl_aj6BJN0UXz53ok(this), new $$Lambda$3SZ_NFVgV5W9DZ4SabwoaQqY6As(this), new $$Lambda$Ah0vw63RhNG5AtqSZ2LUdFXHXU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getLumModArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getLumModArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[16], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getLumModList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$mLuMYnd8L4D2DX6Pn4avvCwuL1E(this), new $$Lambda$GWsdXDc9qarHGOU8z8w7R3c42l0(this), new $$Lambda$lGfVL4AFkrFKzdyEdrL_N7KEm8(this), new $$Lambda$OfdsLhUoD05kN8aoDXJmwTEdsiU(this), new $$Lambda$pxkgxJrfJbXjsuPa2XWVlBWQRw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getLumOffArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getLumOffArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[15], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getLumOffList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$w9cfkno1LAQU7rq2gH1Z4D97YQQ(this), new $$Lambda$MUjXvzi_fSLaIr2ynv3vZCkfWTQ(this), new $$Lambda$RoT8HsaABi4SYsRDhGT5gySjwzY(this), new $$Lambda$BvVTE5V7GohC0hIWcrAfOrvNUY(this), new $$Lambda$aCmUFcKKbS6cG40LspcxAlNXUDA(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getRedArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getRedArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[17], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getRedList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$jG0wt3D90xtt76Xu0_HcnnQL8U(this), new $$Lambda$GwLNlSYrbo_JTdSNLHl8slQo7A(this), new $$Lambda$48rEaKHTjpuE1mM642Rb7egNVdE(this), new $$Lambda$yhHHujSIANLwHxecEGyThLPIwLI(this), new $$Lambda$u3Ml0z3C9PVA_zl7xXGd72Ua2Q(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getRedModArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getRedModArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[19], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getRedModList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$hfyfFrR3k9pv_8kU88pv5jVcSKU(this), new $$Lambda$Y80nNoNqsoN8SDxLqG1rJRQGlI(this), new $$Lambda$eDmlCuSERvn6DwZiaNMuISPVOKc(this), new $$Lambda$kmJ3u_BRZBYzbjeX2RiDqysejIM(this), new $$Lambda$CnFB4AHUrm0AFAEZNXBu8om5w(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getRedOffArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getRedOffArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[18], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getRedOffList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$NCutTsZhvLqcSLJlVCRvlI8e1rk(this), new $$Lambda$Rkp49ypW53IjKwcFz2UKuOnttNk(this), new $$Lambda$uInqecgOwrWso9grUnLRM_TUJM(this), new $$Lambda$06gWHp5omJqsl4b8_TBiBIYreHI(this), new $$Lambda$S3Hp0G5P5kfVlvj9Gq43gLJCxKo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getSatArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getSatArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[11], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getSatList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$51D7kLcFk1dHiUxwqalt8GYaQ(this), new $$Lambda$Utmoh_2v7UI0RZOjTB8q2nVkWU(this), new $$Lambda$VP8M4gkvGneWz35sEN1SrYORBs(this), new $$Lambda$vooPI8t0DrpNCOMm6Upg5OKauo(this), new $$Lambda$QT1HGyfzqd_Tbn1z3oNeyognEE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getSatModArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getSatModArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[13], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getSatModList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ojo4XhZSgsOLvZnl6NtCxj7bas(this), new $$Lambda$s4EsnM1Pn8zQ62wJhdyefvoH0XA(this), new $$Lambda$Uvf83vqn2pgnHpQ12Zg1J6LsRiI(this), new $$Lambda$SufCKJxgxc8y6AL12ONiV5j0uBo(this), new $$Lambda$1u6IdaEX7KKBcyIvD9g4CvrGetM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bt getSatOffArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bt[] getSatOffArray() {
        return (bt[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[12], new bt[0]), bt[].class, "com.obric.memorydata.plugin");
    }

    public List<bt> getSatOffList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$pVfIYDDGHJlvOA4CaG23vajiBNw(this), new $$Lambda$kjFm0gtZK_5qcVACuWDO0wFPuls(this), new $$Lambda$tQtSDPpw0u2YVzqLkoa7K5gBnE(this), new $$Lambda$Mxl8LGtlKIxCpGSWapwVBsLs4c(this), new $$Lambda$KkVHKMKvUNNY8Tv8xfM6Y1ILQc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bx getShadeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bx[] getShadeArray() {
        return (bx[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new bx[0]), bx[].class, "com.obric.memorydata.plugin");
    }

    public List<bx> getShadeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$A9hHn5JYRunhSvFFoqWSo7rZewE(this), new $$Lambda$quT_g_JJJcwQsaOaI9yVzB2TfM(this), new $$Lambda$obTEwU8RTm7GK2E_KicJGP1xeo(this), new $$Lambda$zgjh8YmjsqEqvdFDVTafNJooSws(this), new $$Lambda$dbleCow3aO9CvyiYj_siSrhd49I(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bx getTintArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bx[] getTintArray() {
        return (bx[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new bx[0]), bx[].class, "com.obric.memorydata.plugin");
    }

    public List<bx> getTintList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$3xRMzVcEqKw6R0P5H9ibrr7DU3g(this), new $$Lambda$ZbYBXxhNjshuGWLkx8XIIX7DPY(this), new $$Lambda$u8U7Cy2yMsxo4tY2oxi9aENWgo(this), new $$Lambda$ZVsFxyA1ScHRuyqxjkGctES4rfg(this), new $$Lambda$TaHjudUZ977uw27w_rfSH6usqQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.cf
    public byte[] getVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[28]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        byte[] r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = r3.getByteArrayValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bx insertNewAlpha(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public by insertNewAlphaMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        by r3 = (by) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), by.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public z insertNewAlphaOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        z r3 = (z) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewBlue(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[23], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewBlueMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[25], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewBlueOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[24], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTComplementTransform insertNewComp(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTComplementTransform r3 = (CTComplementTransform) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), CTComplementTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGammaTransform insertNewGamma(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTGammaTransform r3 = (CTGammaTransform) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[26], r4), CTGammaTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGrayscaleTransform insertNewGray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTGrayscaleTransform r3 = (CTGrayscaleTransform) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), CTGrayscaleTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewGreen(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[20], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewGreenMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[22], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewGreenOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[21], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTPositiveFixedAngle insertNewHue(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTPositiveFixedAngle r3 = (CTPositiveFixedAngle) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), CTPositiveFixedAngle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public by insertNewHueMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        by r3 = (by) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), by.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAngle insertNewHueOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAngle r3 = (CTAngle) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), CTAngle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTInverseTransform insertNewInv(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTInverseTransform r3 = (CTInverseTransform) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), CTInverseTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTInverseGammaTransform insertNewInvGamma(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTInverseGammaTransform r3 = (CTInverseGammaTransform) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[27], r4), CTInverseGammaTransform.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewLum(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewLumMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[16], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewLumOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[15], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewRed(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[17], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewRedMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[19], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewRedOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[18], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewSat(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewSatMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bt insertNewSatOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bt r3 = (bt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), bt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bx insertNewShade(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bx insertNewTint(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAlpha(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[5], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAlphaMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[7], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAlphaOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[6], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeBlue(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[23], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeBlueMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[25], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeBlueOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[24], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeComp(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[2], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeGamma(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[26], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeGray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[4], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeGreen(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[20], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeGreenMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[22], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeGreenOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[21], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeHue(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[8], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeHueMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[10], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeHueOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[9], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeInv(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[3], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeInvGamma(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[27], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeLum(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[14], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeLumMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[16], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeLumOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[15], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeRed(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[17], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeRedMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[19], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeRedOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[18], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeSat(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[11], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeSatMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[13], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeSatOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[12], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeShade(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[1], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeTint(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[0], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAlphaArray(int r3, bx r4) {
        generatedSetterHelperImpl((bx) ZeusTransformUtils.wrapperContextForParams(r4, bx.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
    }

    public void setAlphaArray(bx[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[5]);
    }

    public void setAlphaModArray(int r3, by r4) {
        generatedSetterHelperImpl((by) ZeusTransformUtils.wrapperContextForParams(r4, by.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
    }

    public void setAlphaModArray(by[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[7]);
    }

    public void setAlphaOffArray(int r3, z r4) {
        generatedSetterHelperImpl((z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
    }

    public void setAlphaOffArray(z[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[6]);
    }

    public void setBlueArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[23], r3, 2);
    }

    public void setBlueArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[23]);
    }

    public void setBlueModArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[25], r3, 2);
    }

    public void setBlueModArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[25]);
    }

    public void setBlueOffArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[24], r3, 2);
    }

    public void setBlueOffArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[24]);
    }

    public void setCompArray(int r3, CTComplementTransform r4) {
        generatedSetterHelperImpl((CTComplementTransform) ZeusTransformUtils.wrapperContextForParams(r4, CTComplementTransform.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
    }

    public void setCompArray(CTComplementTransform[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[2]);
    }

    public void setGammaArray(int r3, CTGammaTransform r4) {
        generatedSetterHelperImpl((CTGammaTransform) ZeusTransformUtils.wrapperContextForParams(r4, CTGammaTransform.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[26], r3, 2);
    }

    public void setGammaArray(CTGammaTransform[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[26]);
    }

    public void setGrayArray(int r3, CTGrayscaleTransform r4) {
        generatedSetterHelperImpl((CTGrayscaleTransform) ZeusTransformUtils.wrapperContextForParams(r4, CTGrayscaleTransform.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
    }

    public void setGrayArray(CTGrayscaleTransform[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[4]);
    }

    public void setGreenArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[20], r3, 2);
    }

    public void setGreenArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[20]);
    }

    public void setGreenModArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[22], r3, 2);
    }

    public void setGreenModArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[22]);
    }

    public void setGreenOffArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[21], r3, 2);
    }

    public void setGreenOffArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[21]);
    }

    public void setHueArray(int r3, CTPositiveFixedAngle r4) {
        generatedSetterHelperImpl((CTPositiveFixedAngle) ZeusTransformUtils.wrapperContextForParams(r4, CTPositiveFixedAngle.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
    }

    public void setHueArray(CTPositiveFixedAngle[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[8]);
    }

    public void setHueModArray(int r3, by r4) {
        generatedSetterHelperImpl((by) ZeusTransformUtils.wrapperContextForParams(r4, by.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
    }

    public void setHueModArray(by[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[10]);
    }

    public void setHueOffArray(int r3, CTAngle r4) {
        generatedSetterHelperImpl((CTAngle) ZeusTransformUtils.wrapperContextForParams(r4, CTAngle.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
    }

    public void setHueOffArray(CTAngle[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[9]);
    }

    public void setInvArray(int r3, CTInverseTransform r4) {
        generatedSetterHelperImpl((CTInverseTransform) ZeusTransformUtils.wrapperContextForParams(r4, CTInverseTransform.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
    }

    public void setInvArray(CTInverseTransform[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[3]);
    }

    public void setInvGammaArray(int r3, CTInverseGammaTransform r4) {
        generatedSetterHelperImpl((CTInverseGammaTransform) ZeusTransformUtils.wrapperContextForParams(r4, CTInverseGammaTransform.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[27], r3, 2);
    }

    public void setInvGammaArray(CTInverseGammaTransform[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[27]);
    }

    public void setLumArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[14], r3, 2);
    }

    public void setLumArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[14]);
    }

    public void setLumModArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[16], r3, 2);
    }

    public void setLumModArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[16]);
    }

    public void setLumOffArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[15], r3, 2);
    }

    public void setLumOffArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[15]);
    }

    public void setRedArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[17], r3, 2);
    }

    public void setRedArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[17]);
    }

    public void setRedModArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[19], r3, 2);
    }

    public void setRedModArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[19]);
    }

    public void setRedOffArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[18], r3, 2);
    }

    public void setRedOffArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[18]);
    }

    public void setSatArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[11], r3, 2);
    }

    public void setSatArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[11]);
    }

    public void setSatModArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[13], r3, 2);
    }

    public void setSatModArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[13]);
    }

    public void setSatOffArray(int r3, bt r4) {
        generatedSetterHelperImpl((bt) ZeusTransformUtils.wrapperContextForParams(r4, bt.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[12], r3, 2);
    }

    public void setSatOffArray(bt[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[12]);
    }

    public void setShadeArray(int r3, bx r4) {
        generatedSetterHelperImpl((bx) ZeusTransformUtils.wrapperContextForParams(r4, bx.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
    }

    public void setShadeArray(bx[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[1]);
    }

    public void setTintArray(int r3, bx r4) {
        generatedSetterHelperImpl((bx) ZeusTransformUtils.wrapperContextForParams(r4, bx.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    public void setTintArray(bx[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    public void setVal(byte[] r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[28]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[28]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setByteArrayValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int sizeOfAlphaArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[5]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfAlphaModArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[7]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfAlphaOffArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[6]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfBlueArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[23]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfBlueModArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[25]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfBlueOffArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[24]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfCompArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfGammaArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[26]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfGrayArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[4]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfGreenArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[20]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfGreenModArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[22]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfGreenOffArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[21]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfHueArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[8]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfHueModArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[10]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfHueOffArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[9]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfInvArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[3]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfInvGammaArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[27]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfLumArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[14]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfLumModArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[16]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfLumOffArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[15]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfRedArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[17]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfRedModArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[19]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfRedOffArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[18]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfSatArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[11]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfSatModArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[13]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfSatOffArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[12]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfShadeArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfTintArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[0]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public d xgetVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        d r3 = (d) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[28]), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetVal(d r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[28]), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (d) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[28]), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
