package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateColorBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateEffectBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateMotionBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateRotationBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateScaleBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommandBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSetBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeExclusive;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeSequence;
import org.openxmlformats.schemas.presentationml.x2006.main.av;
import org.openxmlformats.schemas.presentationml.x2006.main.az;
import org.openxmlformats.schemas.presentationml.x2006.main.bc;

/* JADX INFO: loaded from: classes8.dex */
public class CTTimeNodeListImpl extends XmlComplexContentImpl implements bc {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "par"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "seq"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "excl"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "anim"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animClr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animEffect"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animMotion"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animRot"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animScale"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cmd"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "set"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "audio"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "video")};
    }

    public CTTimeNodeListImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public CTTLAnimateBehavior addNewAnim() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateBehavior r3 = (CTTLAnimateBehavior) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), CTTLAnimateBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateColorBehavior addNewAnimClr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateColorBehavior r3 = (CTTLAnimateColorBehavior) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), CTTLAnimateColorBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateEffectBehavior addNewAnimEffect() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateEffectBehavior r3 = (CTTLAnimateEffectBehavior) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), CTTLAnimateEffectBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateMotionBehavior addNewAnimMotion() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateMotionBehavior r3 = (CTTLAnimateMotionBehavior) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), CTTLAnimateMotionBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateRotationBehavior addNewAnimRot() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateRotationBehavior r3 = (CTTLAnimateRotationBehavior) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), CTTLAnimateRotationBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateScaleBehavior addNewAnimScale() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateScaleBehavior r3 = (CTTLAnimateScaleBehavior) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), CTTLAnimateScaleBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLMediaNodeAudio addNewAudio() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLMediaNodeAudio r3 = (CTTLMediaNodeAudio) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), CTTLMediaNodeAudio.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLCommandBehavior addNewCmd() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLCommandBehavior r3 = (CTTLCommandBehavior) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), CTTLCommandBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLTimeNodeExclusive addNewExcl() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLTimeNodeExclusive r3 = (CTTLTimeNodeExclusive) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), CTTLTimeNodeExclusive.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public az addNewPar() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        az r3 = (az) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), az.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLTimeNodeSequence addNewSeq() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLTimeNodeSequence r3 = (CTTLTimeNodeSequence) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), CTTLTimeNodeSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLSetBehavior addNewSet() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLSetBehavior r3 = (CTTLSetBehavior) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), CTTLSetBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public av addNewVideo() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        av r3 = (av) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), av.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateBehavior getAnimArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLAnimateBehavior r3 = (CTTLAnimateBehavior) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), CTTLAnimateBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateBehavior[] getAnimArray() {
        return (CTTLAnimateBehavior[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new CTTLAnimateBehavior[0]), CTTLAnimateBehavior[].class, "com.obric.memorydata.plugin");
    }

    public CTTLAnimateColorBehavior getAnimClrArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLAnimateColorBehavior r3 = (CTTLAnimateColorBehavior) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), CTTLAnimateColorBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateColorBehavior[] getAnimClrArray() {
        return (CTTLAnimateColorBehavior[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new CTTLAnimateColorBehavior[0]), CTTLAnimateColorBehavior[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLAnimateColorBehavior> getAnimClrList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$soLvzV7cd7M3H0jRwIZBH5wBzQ(this), new $$Lambda$cvyFOayFxWFga1XdtLTbzLgopwk(this), new $$Lambda$N3h4G9CwthZhRuCmBWr3okyAo(this), new $$Lambda$9vhv9smxObl8gWjAXcNCiPc5PKA(this), new $$Lambda$2lcWrjIxp27dfITTWGuBeRoIRPI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateEffectBehavior getAnimEffectArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLAnimateEffectBehavior r3 = (CTTLAnimateEffectBehavior) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), CTTLAnimateEffectBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateEffectBehavior[] getAnimEffectArray() {
        return (CTTLAnimateEffectBehavior[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new CTTLAnimateEffectBehavior[0]), CTTLAnimateEffectBehavior[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLAnimateEffectBehavior> getAnimEffectList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$pdTcWVGAxFfpBnTJJDlIyljTz_4(this), new $$Lambda$GCyaimE6N1b41x98Gqva9a1Htxo(this), new $$Lambda$_ilzWxDkEcCXQupT3IT3Ee4zcc(this), new $$Lambda$nCbMfMR9y2Pdfzuh3LxERjn_2oQ(this), new $$Lambda$bPyPn9ceW6_grMrrA9ew_hHKnE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<CTTLAnimateBehavior> getAnimList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$qmEmS1oAMITIlP7fVICb7fx8syY(this), new $$Lambda$L6uwvXp35zBu5qSM6w0_ZA9IVCo(this), new $$Lambda$G2R83JmDygUUiYqDSRQxar7y_uQ(this), new $$Lambda$3Eol1_ri2BvwJEOXLCr8b8jc6_8(this), new $$Lambda$O8x6r1OYTB6RXfysEMyuB1LpX00(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateMotionBehavior getAnimMotionArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLAnimateMotionBehavior r3 = (CTTLAnimateMotionBehavior) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), CTTLAnimateMotionBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateMotionBehavior[] getAnimMotionArray() {
        return (CTTLAnimateMotionBehavior[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new CTTLAnimateMotionBehavior[0]), CTTLAnimateMotionBehavior[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLAnimateMotionBehavior> getAnimMotionList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$mGGHwAmAMI_8fKfHKo5ktaRHQbI(this), new $$Lambda$pzpDVdLGvlVE8AQTpIhRozw7hHg(this), new $$Lambda$EE4hz781tTzS7Hxc3xqdLM7qHMU(this), new $$Lambda$JrUawYu66PZuenNWAj6agUxPThg(this), new $$Lambda$Mn6w5xlo4sVx0pzaSWvVtCniHPU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateRotationBehavior getAnimRotArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLAnimateRotationBehavior r3 = (CTTLAnimateRotationBehavior) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), CTTLAnimateRotationBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateRotationBehavior[] getAnimRotArray() {
        return (CTTLAnimateRotationBehavior[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new CTTLAnimateRotationBehavior[0]), CTTLAnimateRotationBehavior[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLAnimateRotationBehavior> getAnimRotList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$S3yLkKsqHPkU5giaGuRCawwcmc(this), new $$Lambda$ljs1k2D3euZQR5nYitYXUFNBYM(this), new $$Lambda$YJ2N1bGPvSlB_uhhUMMbnHLxfBs(this), new $$Lambda$1vw3ARcYvGGrfxAXGraajb8D1qU(this), new $$Lambda$JpI51sUnFhBPYxun93L0UQhUj4M(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateScaleBehavior getAnimScaleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLAnimateScaleBehavior r3 = (CTTLAnimateScaleBehavior) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), CTTLAnimateScaleBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateScaleBehavior[] getAnimScaleArray() {
        return (CTTLAnimateScaleBehavior[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new CTTLAnimateScaleBehavior[0]), CTTLAnimateScaleBehavior[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLAnimateScaleBehavior> getAnimScaleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$vF1GNkAU2QQMqj4WVVWQg29fRDc(this), new $$Lambda$m0wuPYZAMFltVyKizK9EJoA4Oes(this), new $$Lambda$QzHVqGXgiP8bFHbSoOqAMnLYpxc(this), new $$Lambda$HTgEkW9E___cEWAVPDziXPMejeA(this), new $$Lambda$4Z_PgNTYSVoFKhpRtIu3sWlZds(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLMediaNodeAudio getAudioArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLMediaNodeAudio r3 = (CTTLMediaNodeAudio) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), CTTLMediaNodeAudio.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLMediaNodeAudio[] getAudioArray() {
        return (CTTLMediaNodeAudio[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[11], new CTTLMediaNodeAudio[0]), CTTLMediaNodeAudio[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLMediaNodeAudio> getAudioList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$lMYNNqkTu79gINTfFncsyj6B5c(this), new $$Lambda$iGpsAILIFS0uaHN9TBDFdMMp0w(this), new $$Lambda$oqmpfBXVnMDNM4ebLUibMQli1ZE(this), new $$Lambda$UZfAG7HCJkyrXIoI3opPVud8SF8(this), new $$Lambda$0w4quRxzDNvuSu1pSArVMaONCI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLCommandBehavior getCmdArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLCommandBehavior r3 = (CTTLCommandBehavior) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), CTTLCommandBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLCommandBehavior[] getCmdArray() {
        return (CTTLCommandBehavior[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new CTTLCommandBehavior[0]), CTTLCommandBehavior[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLCommandBehavior> getCmdList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$lzxPRs_3yuIRQbBCRCh2lPhs2HA(this), new $$Lambda$1CrBUJFNKRsaoxu6pD1QGTXi3i4(this), new $$Lambda$7cIPo6AbFwr9oyUvWWRCIihFLQ(this), new $$Lambda$edspzHwKhuTzI306WRrfQ9VArB0(this), new $$Lambda$dxo2TZzbUle3o8rnGZQlGzk8IHU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLTimeNodeExclusive getExclArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLTimeNodeExclusive r3 = (CTTLTimeNodeExclusive) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), CTTLTimeNodeExclusive.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLTimeNodeExclusive[] getExclArray() {
        return (CTTLTimeNodeExclusive[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new CTTLTimeNodeExclusive[0]), CTTLTimeNodeExclusive[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLTimeNodeExclusive> getExclList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$wzRklVD9Ifrh1rO1MHEtoezvztM(this), new $$Lambda$ftbqdnbswq4vedQWk1KSYse_Cc(this), new $$Lambda$mk4asNWpT4EiTTuzUZG9SEHQTns(this), new $$Lambda$fJfmP5w_Ml5dQ7Dta68KQucpQQQ(this), new $$Lambda$8MDt9y1XfhzTNptqBNjlQAvp4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public az getParArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        az r3 = (az) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), az.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public az[] getParArray() {
        return (az[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new az[0]), az[].class, "com.obric.memorydata.plugin");
    }

    public List<az> getParList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$edlLSb2toH38zcguS010XaVk58(this), new $$Lambda$8rqw6O3NCOIuSP_tQgi3Drfho(this), new $$Lambda$ph4L3y4CIcdjS_UzbeQUZ6uhrRU(this), new $$Lambda$Xznompm20_qXvhx1Ob54r5lkof4(this), new $$Lambda$PWA90B0SnyOuPZ29G9NLJB4Tfc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLTimeNodeSequence getSeqArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLTimeNodeSequence r3 = (CTTLTimeNodeSequence) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), CTTLTimeNodeSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLTimeNodeSequence[] getSeqArray() {
        return (CTTLTimeNodeSequence[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new CTTLTimeNodeSequence[0]), CTTLTimeNodeSequence[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLTimeNodeSequence> getSeqList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$hlfM0dvx2t9KissmZDwNYaiqeQQ(this), new $$Lambda$UIGTdggTAUsPqJGMlv9p6dPMx04(this), new $$Lambda$_dlkun2kAGM8pG1Y4VQpkhqCtpA(this), new $$Lambda$Y0GpMi5HLSJej6A7QXLXczTnZE(this), new $$Lambda$gbW8aoDMzRXFCC2OB8G6hzjBuEo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLSetBehavior getSetArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTLSetBehavior r3 = (CTTLSetBehavior) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), CTTLSetBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTLSetBehavior[] getSetArray() {
        return (CTTLSetBehavior[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new CTTLSetBehavior[0]), CTTLSetBehavior[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTLSetBehavior> getSetList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$PeAXdKNnM2L2Ot4Ajqk1vxKGg(this), new $$Lambda$I_pps80JMbGjUkosqjKb4rZxC84(this), new $$Lambda$6fG1dhtesYNSRXsIzuTLpuN7P_o(this), new $$Lambda$TYi8HMOPV7WUHYAjRlkEEBwNro(this), new $$Lambda$b2rkrR1ID9mfWwSh36i3QWRjfYM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public av getVideoArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        av r3 = (av) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), av.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public av[] getVideoArray() {
        return (av[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[12], new av[0]), av[].class, "com.obric.memorydata.plugin");
    }

    public List<av> getVideoList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$rhtKo_WDLxCpByJXjBAev2QCMxc(this), new $$Lambda$JczNm6t8blRHQQoywl0UY5huSA(this), new $$Lambda$yxuY0I02CDtMLJmsXk2sl0w0OVA(this), new $$Lambda$9HrH2hQ5oiPF9EUpD4DwFSqGvM(this), new $$Lambda$oYtwMvGZjEjOgcPeKY6CI5hUUc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateBehavior insertNewAnim(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateBehavior r3 = (CTTLAnimateBehavior) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), CTTLAnimateBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateColorBehavior insertNewAnimClr(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateColorBehavior r3 = (CTTLAnimateColorBehavior) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), CTTLAnimateColorBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateEffectBehavior insertNewAnimEffect(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateEffectBehavior r3 = (CTTLAnimateEffectBehavior) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), CTTLAnimateEffectBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateMotionBehavior insertNewAnimMotion(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateMotionBehavior r3 = (CTTLAnimateMotionBehavior) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), CTTLAnimateMotionBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateRotationBehavior insertNewAnimRot(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateRotationBehavior r3 = (CTTLAnimateRotationBehavior) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), CTTLAnimateRotationBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLAnimateScaleBehavior insertNewAnimScale(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLAnimateScaleBehavior r3 = (CTTLAnimateScaleBehavior) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), CTTLAnimateScaleBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLMediaNodeAudio insertNewAudio(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLMediaNodeAudio r3 = (CTTLMediaNodeAudio) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), CTTLMediaNodeAudio.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLCommandBehavior insertNewCmd(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLCommandBehavior r3 = (CTTLCommandBehavior) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), CTTLCommandBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLTimeNodeExclusive insertNewExcl(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLTimeNodeExclusive r3 = (CTTLTimeNodeExclusive) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), CTTLTimeNodeExclusive.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public az insertNewPar(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        az r3 = (az) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), az.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLTimeNodeSequence insertNewSeq(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLTimeNodeSequence r3 = (CTTLTimeNodeSequence) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), CTTLTimeNodeSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTLSetBehavior insertNewSet(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTLSetBehavior r3 = (CTTLSetBehavior) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), CTTLSetBehavior.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public av insertNewVideo(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        av r3 = (av) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), av.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAnim(int r4) {
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

    public void removeAnimClr(int r4) {
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

    public void removeAnimEffect(int r4) {
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

    public void removeAnimMotion(int r4) {
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

    public void removeAnimRot(int r4) {
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

    public void removeAnimScale(int r4) {
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

    public void removeAudio(int r4) {
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

    public void removeCmd(int r4) {
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

    public void removeExcl(int r4) {
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

    public void removePar(int r4) {
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

    public void removeSeq(int r4) {
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

    public void removeSet(int r4) {
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

    public void removeVideo(int r4) {
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

    public void setAnimArray(int r3, CTTLAnimateBehavior r4) {
        generatedSetterHelperImpl((CTTLAnimateBehavior) ZeusTransformUtils.wrapperContextForParams(r4, CTTLAnimateBehavior.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
    }

    public void setAnimArray(CTTLAnimateBehavior[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[3]);
    }

    public void setAnimClrArray(int r3, CTTLAnimateColorBehavior r4) {
        generatedSetterHelperImpl((CTTLAnimateColorBehavior) ZeusTransformUtils.wrapperContextForParams(r4, CTTLAnimateColorBehavior.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
    }

    public void setAnimClrArray(CTTLAnimateColorBehavior[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[4]);
    }

    public void setAnimEffectArray(int r3, CTTLAnimateEffectBehavior r4) {
        generatedSetterHelperImpl((CTTLAnimateEffectBehavior) ZeusTransformUtils.wrapperContextForParams(r4, CTTLAnimateEffectBehavior.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
    }

    public void setAnimEffectArray(CTTLAnimateEffectBehavior[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[5]);
    }

    public void setAnimMotionArray(int r3, CTTLAnimateMotionBehavior r4) {
        generatedSetterHelperImpl((CTTLAnimateMotionBehavior) ZeusTransformUtils.wrapperContextForParams(r4, CTTLAnimateMotionBehavior.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
    }

    public void setAnimMotionArray(CTTLAnimateMotionBehavior[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[6]);
    }

    public void setAnimRotArray(int r3, CTTLAnimateRotationBehavior r4) {
        generatedSetterHelperImpl((CTTLAnimateRotationBehavior) ZeusTransformUtils.wrapperContextForParams(r4, CTTLAnimateRotationBehavior.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
    }

    public void setAnimRotArray(CTTLAnimateRotationBehavior[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[7]);
    }

    public void setAnimScaleArray(int r3, CTTLAnimateScaleBehavior r4) {
        generatedSetterHelperImpl((CTTLAnimateScaleBehavior) ZeusTransformUtils.wrapperContextForParams(r4, CTTLAnimateScaleBehavior.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
    }

    public void setAnimScaleArray(CTTLAnimateScaleBehavior[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[8]);
    }

    public void setAudioArray(int r3, CTTLMediaNodeAudio r4) {
        generatedSetterHelperImpl((CTTLMediaNodeAudio) ZeusTransformUtils.wrapperContextForParams(r4, CTTLMediaNodeAudio.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[11], r3, 2);
    }

    public void setAudioArray(CTTLMediaNodeAudio[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[11]);
    }

    public void setCmdArray(int r3, CTTLCommandBehavior r4) {
        generatedSetterHelperImpl((CTTLCommandBehavior) ZeusTransformUtils.wrapperContextForParams(r4, CTTLCommandBehavior.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
    }

    public void setCmdArray(CTTLCommandBehavior[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[9]);
    }

    public void setExclArray(int r3, CTTLTimeNodeExclusive r4) {
        generatedSetterHelperImpl((CTTLTimeNodeExclusive) ZeusTransformUtils.wrapperContextForParams(r4, CTTLTimeNodeExclusive.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
    }

    public void setExclArray(CTTLTimeNodeExclusive[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[2]);
    }

    public void setParArray(int r3, az r4) {
        generatedSetterHelperImpl((az) ZeusTransformUtils.wrapperContextForParams(r4, az.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    public void setParArray(az[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    public void setSeqArray(int r3, CTTLTimeNodeSequence r4) {
        generatedSetterHelperImpl((CTTLTimeNodeSequence) ZeusTransformUtils.wrapperContextForParams(r4, CTTLTimeNodeSequence.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
    }

    public void setSeqArray(CTTLTimeNodeSequence[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[1]);
    }

    public void setSetArray(int r3, CTTLSetBehavior r4) {
        generatedSetterHelperImpl((CTTLSetBehavior) ZeusTransformUtils.wrapperContextForParams(r4, CTTLSetBehavior.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
    }

    public void setSetArray(CTTLSetBehavior[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[10]);
    }

    public void setVideoArray(int r3, av r4) {
        generatedSetterHelperImpl((av) ZeusTransformUtils.wrapperContextForParams(r4, av.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[12], r3, 2);
    }

    public void setVideoArray(av[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[12]);
    }

    public int sizeOfAnimArray() {
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

    public int sizeOfAnimClrArray() {
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

    public int sizeOfAnimEffectArray() {
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

    public int sizeOfAnimMotionArray() {
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

    public int sizeOfAnimRotArray() {
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

    public int sizeOfAnimScaleArray() {
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

    public int sizeOfAudioArray() {
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

    public int sizeOfCmdArray() {
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

    public int sizeOfExclArray() {
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

    public int sizeOfParArray() {
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

    public int sizeOfSeqArray() {
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

    public int sizeOfSetArray() {
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

    public int sizeOfVideoArray() {
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
}
