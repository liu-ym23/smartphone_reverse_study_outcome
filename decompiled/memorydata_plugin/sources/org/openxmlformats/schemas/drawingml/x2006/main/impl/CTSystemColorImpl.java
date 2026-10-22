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
import org.openxmlformats.schemas.drawingml.x2006.main.STSystemColorVal;
import org.openxmlformats.schemas.drawingml.x2006.main.bt;
import org.openxmlformats.schemas.drawingml.x2006.main.bx;
import org.openxmlformats.schemas.drawingml.x2006.main.by;
import org.openxmlformats.schemas.drawingml.x2006.main.cq;
import org.openxmlformats.schemas.drawingml.x2006.main.z;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.d;

/* JADX INFO: loaded from: classes8.dex */
public class CTSystemColorImpl extends XmlComplexContentImpl implements cq {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "shade"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "comp"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "inv"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gray"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alpha"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hue"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", LocalePreferences.FirstDayOfWeek.SATURDAY), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "red"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "green"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blue"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gamma"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "invGamma"), new QName("", "val"), new QName("", "lastClr")};
    }

    public CTSystemColorImpl(SchemaType r3) {
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$pqp5rjbw32GpXPfWDzWH4fitQ5k(this), new $$Lambda$m4EjBte9s_KSW_yv2Jsi_XMU6o(this), new $$Lambda$lENH9XSJaoOHT8ENe48PX9eObWU(this), new $$Lambda$DUBhmF165yBJn4znxkWxyxwaFoY(this), new $$Lambda$MEOspAwNPDeyC1tqqjDvwq9JFU(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$PZcJPurOIs7J0BEWOD4GdsgnooE(this), new $$Lambda$nZgMCXqzmGJwLGsoIyrP2T1r1dA(this), new $$Lambda$OCIqGC5EiMrOTJrxQALBtPoAzA(this), new $$Lambda$xeWwJpDS7YtkWQgxiv0JfLeKpss(this), new $$Lambda$180zrotnL2AF1NL4pLJvL9FYVu8(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$8qC_ai6aj8ixOdtb0TIdKjsHqi8(this), new $$Lambda$BoeFDT9wN6Yd22ZA2aamlWwAA1g(this), new $$Lambda$lT1D7lHjlHJkusx457Ig4WJdDM(this), new $$Lambda$IRO8zir3vz4mv1repsCvmdYGM(this), new $$Lambda$xSKSY23dEvs5GEKG75Ji2skP8HI(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$JRT408732_6oJFvLgbxUDrY6etg(this), new $$Lambda$4SlTspy2tjSuUPm1UtJNroeAF9w(this), new $$Lambda$z2HHCXn5LYXaqywuccVhInG5Dw(this), new $$Lambda$MbL2FCKBDfi5De4OEDnvoOAEXco(this), new $$Lambda$3J1DX1AqssmwlGMTsVyAyiySvo(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$zXKm7ZssdRPtn5NzhXVmoj8wqSA(this), new $$Lambda$oARSDgFfX7wQ5ZcF3zFnwDqDskA(this), new $$Lambda$eNv6XSUrrSCx2sLjNuKdfQyPOak(this), new $$Lambda$FRsuLZkhNowqQsX3ggwexUQgOZs(this), new $$Lambda$e6BhRQdN78ucRrdWQJ8FxZPJjik(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$fQHvhRSUZx6X15kgGZ81nG6Ppmo(this), new $$Lambda$zTssQPO09PPqgrYL6b6hnEgD5i8(this), new $$Lambda$dgLn05CxeOsVWUW81UZzmRLx0DU(this), new $$Lambda$tftmDlWBipnR25qfpeILwx2SOY(this), new $$Lambda$ZVwxPoYuWN2lg3q5rtcZSaDSC0(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$YSvSSLEhq9HZ8MbZLczrRb7V0NQ(this), new $$Lambda$_S3XnJNd2U0WmRr4WY5oBNKpDzA(this), new $$Lambda$abFQn8h4k7AHFQy3LpKqocrk2Kw(this), new $$Lambda$I6rC21zoyNuctiiNZTfVWz0Mb4(this), new $$Lambda$S805hv5778GKbaTPUkbBqBotxMY(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$R0xm2hbtJL4gxm8Vk7WALwNfTI(this), new $$Lambda$LW8LJyecEsSrGlg4ENfhC5PymY(this), new $$Lambda$0sVqgub71j9HFkzfFZh24lrmQsk(this), new $$Lambda$Vk7VmMhyCccHM9Ubk0XLfBr9Q(this), new $$Lambda$n9xAYLw_gAaFH3HLaE_y6PczlwA(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$q3EKvyOxJzBd2dTyNgB21Fx664(this), new $$Lambda$EikDDvwfhAKgWpP98zaDRyoEjSU(this), new $$Lambda$TvGpTx3HewADFFGStuXv0Pjho30(this), new $$Lambda$ffZmc4lNLaKa8YxUOQppF1sY8aw(this), new $$Lambda$Oeivler1Slx1XUA1iLtLYr0834(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$7DKie8TolfEevL0zd3TxoVV2xHw(this), new $$Lambda$0pkS3BcWEL9f3m1bv8E1HT9Cow0(this), new $$Lambda$kXYQPiEOfhPofeAtEidtHd9plQA(this), new $$Lambda$KpOWFeDeJGKxRef5QN6CEV32Dl0(this), new $$Lambda$ZvnOQROkOmHykWD3m_7lm1swUqM(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$PCARjKADXhhRrd7ae16rrxlFQhE(this), new $$Lambda$eFpLGpduKTnfLM6BPKCucT9Antk(this), new $$Lambda$MMQo4RJPJvYXJuIiN5PZfXdbbYE(this), new $$Lambda$6E244U9NwR_KsSl2VutJKzdIIps(this), new $$Lambda$HsSh2JsVT6gr6uaIFKeLt0jlV0(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$T6NLfay_rRokmMyoQOl8LNxhGA(this), new $$Lambda$KQFFpXvafjqvcKV5_P0D4F3CUZ4(this), new $$Lambda$veDuMh6BgnChr5Q5jkrLY9UG05o(this), new $$Lambda$XeohR0YfrCqzcDZ1dsnnKDAnUY(this), new $$Lambda$MbYvEXeBTltaNHWoENboiLyxCg(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Tj6nAhR7LqMjVq_2919pR_HUPVM(this), new $$Lambda$3GMP4jPhjgjyb_qiTjPYbOm6i0(this), new $$Lambda$9owbjhGtCvelDaC7fpqO_wIuU(this), new $$Lambda$IVTkIHC9c72Gj9IU8mULVprAAek(this), new $$Lambda$lLsJH6GZVL6Kgrn773w0l_XVMeY(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$be2uGaVmRM2Nv4p9Xx8Zo2WYwg(this), new $$Lambda$2ePrCFZSxpdqJ4Ww172o35BNqLo(this), new $$Lambda$EXXQXz6g3ZNMHvGqT8q2Udz_XBM(this), new $$Lambda$EFdjo1tw371n3rbuFcNMAyOAS3Q(this), new $$Lambda$XqqX4mWOksYvPMGJIXvpmym8voQ(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$6RYur38L4phyPkpwNGsaPyz4VLI(this), new $$Lambda$1bqgb0J5qsRpkSmZlEDS27hrxQs(this), new $$Lambda$bVitMQzS6nQHd71tB4H1rKg7ztE(this), new $$Lambda$FgzWT52BPDO1zyQnBdXE18MjWNY(this), new $$Lambda$UXicghIG_gHVCZQVVo8noEpZE(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$LL6Io0bnzvNuigqyivTb4KkVpWc(this), new $$Lambda$ZiQUwBGyAD5lKtZ8bIi0lfpIJpM(this), new $$Lambda$CujWCWoBwbdAMrDY1bOn6jIPUXo(this), new $$Lambda$Uay6GYlTEcjtewTsq3kHpmnp0Dw(this), new $$Lambda$dF1o6kBl7BiFljz6hHgnPVZXzgM(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$PfOIk7_5fprH2wG7wrnkxUXZTpY(this), new $$Lambda$HmoMlOyV8hlsYQZyDZNgYJTAS4(this), new $$Lambda$3vYr4E3A2FwXDixAOzjxAETDpA(this), new $$Lambda$M_PA7vIV9tfDVcDYmq_XGNmHEcA(this), new $$Lambda$JhmtnjK0pf9QJP9blT3PA86SHyI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.cq
    public byte[] getLastClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[29]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Gdks5pYLRzHv6Tzu1KD39nGs67Q(this), new $$Lambda$tw_qFY9bHxq2mmeEbnj65PPVBu4(this), new $$Lambda$7SDxTF_lrsgY2keeUuKipXFuYrw(this), new $$Lambda$gsyf6b2T3_vO30RHrVR3o4LtxY(this), new $$Lambda$5AowHkC3MadsDnoA_xpieiO0OPI(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$wqzwkQb4enjRlJsQepx9NjetyHg(this), new $$Lambda$kWVDbdIbcL_dsOVxd6tN1R8wTrw(this), new $$Lambda$kw2NGwugDTc6wPz77WAgl155DN0(this), new $$Lambda$jvw7Zjkj9n62cZhtAXv0Obhq2C4(this), new $$Lambda$PJKIxBRSX9wmBGILxpAAItYQi74(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$26jmh0Hn1Op89JBNdhL_CCB8Y30(this), new $$Lambda$0h8rDCSClrrGG3EdS1b_hAOkhEg(this), new $$Lambda$z2VRqlwchQyxAay57XFvoKKx81E(this), new $$Lambda$BGE18X00bhKJ9136rypef57U1sk(this), new $$Lambda$NMSL0l0XIlhHsIGCGZ0G8Jbczs8(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$DNWzhGHfWhjlTTJVjHXmNbglP8(this), new $$Lambda$T_chXa0Whqd4fjDaAiosZMA800(this), new $$Lambda$IK1rjLiDwkpsaNqWWkdaSZF60zk(this), new $$Lambda$JWBOXZsm6WBI3u4UC7E0GmD_6ac(this), new $$Lambda$W3aRg5H3L3Z_6XJHHCAO1M8S5w(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Q6P9YSOcWw6cdCDiWyVI9NeoLo(this), new $$Lambda$tgVZJO1TVIXyXwe4TZYlcOZ18_I(this), new $$Lambda$kW5v2mN_ERxdDLix1RxdMHL4jE(this), new $$Lambda$Sfgs0RPTjirtT9poejpobx2OPk(this), new $$Lambda$3pNhSoOHLYjcnRjd87PzLBGx1c(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$GB3cjbK1DBxv1tywsUNpReUEPy0(this), new $$Lambda$yYZbAlDd2An9iOON8wwqCpt4RPc(this), new $$Lambda$W6XUNGXkjP6j7sTB8Xfe7uSqmg(this), new $$Lambda$UzjjXwJbwjWJ738CMlmCgRorUww(this), new $$Lambda$FuTaO6u9wodsDRqXSVCc8LkNH8(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$LS1c9Vh2E_xAkOxiVDQE2NUccg(this), new $$Lambda$3iUsLHdOqsVJ4Qb4b_DDPyXrjY(this), new $$Lambda$NkxWllJqVYT_a2eRE_snF864Bg(this), new $$Lambda$jcAUOUqaz9LMNgllOWoS_E0Ww(this), new $$Lambda$l2vUjRQSSJiGFvLHqhJtUoau3GI(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$CSNzLjvDAZ2AyV78hf2UxWZVa1E(this), new $$Lambda$p4IMKodQ3XCo0e1TEHFkkdjacE(this), new $$Lambda$az8qLA8buxpc0QcJ8LRJ2ij1Fqs(this), new $$Lambda$DiHjf5evnKdhJ9uwBhhcktejk(this), new $$Lambda$FoP1aYx1W2ComhOXzxGYhnbq19Q(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$XSGYVKVtCuqdJhZk6wklDg4EAM(this), new $$Lambda$wxHGz9L3XJBX0wxNqfWK9Jy3H0(this), new $$Lambda$gQCqBw0MRa7yEr3ySuANWjl878(this), new $$Lambda$ZGSP1a7IHd3a2LRaH6nr_pyXlE(this), new $$Lambda$iCL8cL9dtzhyobVJ66jBe6Zcwr4(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$aLO24h3r83Pgb82jMPZp0OJ6B_s(this), new $$Lambda$3U7LLrdFoTT7SxSZ5BtGU0c7Pc(this), new $$Lambda$7ESNKXeD4orCVWdLlZ6Idl3trjY(this), new $$Lambda$k6DWY4dfWMSRiPh0J6lpnZqKfxE(this), new $$Lambda$xqNZh3NfWHgUFfCzmJ7TGz5o4M(this));     // Catch: Throwable -> L7
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
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$EETw_1ar6Sk4_7Cm02DtlOKkpI(this), new $$Lambda$GDVoqrCmYEj3ysmG0eQnqT8vSnU(this), new $$Lambda$4Nn9td8TwbFv7J4omgT57Ws9gnM(this), new $$Lambda$wy4aMDViBlXUJuTKmARRLGEMUk(this), new $$Lambda$_AIsqSdO97CBslMFHevmS2cYlmI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STSystemColorVal.Enum getVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[28]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        STSystemColorVal.Enum r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = (STSystemColorVal.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STSystemColorVal.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

    public boolean isSetLastClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().find_attribute_user(PROPERTY_QNAME[29]) == null) goto L7;
        boolean r3 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L7:
        r3 = false;
    L10:
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

    public void setLastClr(byte[] r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[29]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[29]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setByteArrayValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
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

    public void setVal(STSystemColorVal.Enum r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[28]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[28]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setEnumValue(r7);     // Catch: Throwable -> L10
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

    public void unsetLastClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[29]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public d xgetLastClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        d r3 = (d) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[29]), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STSystemColorVal xgetVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STSystemColorVal r3 = (STSystemColorVal) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[28]), STSystemColorVal.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetLastClr(d r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[29]), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (d) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[29]), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetVal(STSystemColorVal r7) {
        STSystemColorVal r8 = (STSystemColorVal) ZeusTransformUtils.wrapperContextForParams(r7, STSystemColorVal.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        STSystemColorVal r3 = (STSystemColorVal) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[28]), STSystemColorVal.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (STSystemColorVal) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[28]), STSystemColorVal.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
