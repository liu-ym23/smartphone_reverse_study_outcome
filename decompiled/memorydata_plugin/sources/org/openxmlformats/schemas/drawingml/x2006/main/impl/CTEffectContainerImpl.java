package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaCeilingEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaFloorEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaInverseEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaOutsetEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlendEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorChangeEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGlowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHSLEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInnerShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLuminanceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTReflectionEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeOffsetEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSoftEdgesEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTintEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransformEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.STEffectContainerType;
import org.openxmlformats.schemas.drawingml.x2006.main.STEffectContainerType$Enum;
import org.openxmlformats.schemas.drawingml.x2006.main.bi;
import org.openxmlformats.schemas.drawingml.x2006.main.c;
import org.openxmlformats.schemas.drawingml.x2006.main.r;
import org.openxmlformats.schemas.drawingml.x2006.main.s;

/* JADX INFO: loaded from: classes8.dex */
public class CTEffectContainerImpl extends XmlComplexContentImpl implements s {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cont"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effect"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaBiLevel"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaCeiling"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaFloor"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaInv"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaModFix"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOutset"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaRepl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "biLevel"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blend"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blur"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrChange"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrRepl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "duotone"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fill"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillOverlay"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "glow"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grayscl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hsl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "innerShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "outerShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "reflection"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "relOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "softEdge"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "xfrm"), new QName("", "type"), new QName("", ActivityLifecycle.NAME)};
    }

    public CTEffectContainerImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public CTAlphaBiLevelEffect addNewAlphaBiLevel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaBiLevelEffect r3 = (CTAlphaBiLevelEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), CTAlphaBiLevelEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaCeilingEffect addNewAlphaCeiling() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaCeilingEffect r3 = (CTAlphaCeilingEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), CTAlphaCeilingEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaFloorEffect addNewAlphaFloor() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaFloorEffect r3 = (CTAlphaFloorEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), CTAlphaFloorEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaInverseEffect addNewAlphaInv() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaInverseEffect r3 = (CTAlphaInverseEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), CTAlphaInverseEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaModulateEffect addNewAlphaMod() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaModulateEffect r3 = (CTAlphaModulateEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), CTAlphaModulateEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public c addNewAlphaModFix() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        c r3 = (c) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaOutsetEffect addNewAlphaOutset() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaOutsetEffect r3 = (CTAlphaOutsetEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), CTAlphaOutsetEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaReplaceEffect addNewAlphaRepl() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaReplaceEffect r3 = (CTAlphaReplaceEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), CTAlphaReplaceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBiLevelEffect addNewBiLevel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTBiLevelEffect r3 = (CTBiLevelEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), CTBiLevelEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBlendEffect addNewBlend() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTBlendEffect r3 = (CTBlendEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), CTBlendEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBlurEffect addNewBlur() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTBlurEffect r3 = (CTBlurEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), CTBlurEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTColorChangeEffect addNewClrChange() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTColorChangeEffect r3 = (CTColorChangeEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), CTColorChangeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTColorReplaceEffect addNewClrRepl() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTColorReplaceEffect r3 = (CTColorReplaceEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), CTColorReplaceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public s addNewCont() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        s r3 = (s) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public r addNewDuotone() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        r r3 = (r) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[15]), r.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTEffectReference addNewEffect() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTEffectReference r3 = (CTEffectReference) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), CTEffectReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTFillEffect addNewFill() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTFillEffect r3 = (CTFillEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[16]), CTFillEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTFillOverlayEffect addNewFillOverlay() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTFillOverlayEffect r3 = (CTFillOverlayEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[17]), CTFillOverlayEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGlowEffect addNewGlow() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTGlowEffect r3 = (CTGlowEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[18]), CTGlowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGrayscaleEffect addNewGrayscl() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTGrayscaleEffect r3 = (CTGrayscaleEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[19]), CTGrayscaleEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTHSLEffect addNewHsl() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTHSLEffect r3 = (CTHSLEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[20]), CTHSLEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTInnerShadowEffect addNewInnerShdw() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTInnerShadowEffect r3 = (CTInnerShadowEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[21]), CTInnerShadowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTLuminanceEffect addNewLum() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTLuminanceEffect r3 = (CTLuminanceEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[22]), CTLuminanceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bi addNewOuterShdw() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bi r3 = (bi) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[23]), bi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTPresetShadowEffect addNewPrstShdw() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTPresetShadowEffect r3 = (CTPresetShadowEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[24]), CTPresetShadowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTReflectionEffect addNewReflection() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTReflectionEffect r3 = (CTReflectionEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[25]), CTReflectionEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTRelativeOffsetEffect addNewRelOff() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTRelativeOffsetEffect r3 = (CTRelativeOffsetEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[26]), CTRelativeOffsetEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTSoftEdgesEffect addNewSoftEdge() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTSoftEdgesEffect r3 = (CTSoftEdgesEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[27]), CTSoftEdgesEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTintEffect addNewTint() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTintEffect r3 = (CTTintEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[28]), CTTintEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTransformEffect addNewXfrm() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTransformEffect r3 = (CTTransformEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[29]), CTTransformEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaBiLevelEffect getAlphaBiLevelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTAlphaBiLevelEffect r3 = (CTAlphaBiLevelEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), CTAlphaBiLevelEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTAlphaBiLevelEffect[] getAlphaBiLevelArray() {
        return (CTAlphaBiLevelEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new CTAlphaBiLevelEffect[0]), CTAlphaBiLevelEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTAlphaBiLevelEffect> getAlphaBiLevelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$aDLoEOMI0ft0uEGRdVj1PQW1FA(this), new $$Lambda$7XdIqm8Dd5ucrizEDMIiwhtfTs(this), new $$Lambda$JDVE1ZGYSCXQqf86NT5AGRD_H5M(this), new $$Lambda$Hjw_o_dddk8HFT2Onigdw2r84(this), new $$Lambda$1dGN_MTIzrY1buw_T8yBDxSDolM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaCeilingEffect getAlphaCeilingArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTAlphaCeilingEffect r3 = (CTAlphaCeilingEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), CTAlphaCeilingEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTAlphaCeilingEffect[] getAlphaCeilingArray() {
        return (CTAlphaCeilingEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new CTAlphaCeilingEffect[0]), CTAlphaCeilingEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTAlphaCeilingEffect> getAlphaCeilingList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$B3zNbsSUXTWAlRoKUnvBPnuIzuY(this), new $$Lambda$SdSBfYpwEpMYtUeoIBKhtYR0lM(this), new $$Lambda$zSVbrM7PutH_H4P326jqj9mG6Y(this), new $$Lambda$Jc8WQJxzTeCGCZvqMVAuPVuk70Q(this), new $$Lambda$qP2tL3QRUjXgFM4_Q50ZpAoWC10(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaFloorEffect getAlphaFloorArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTAlphaFloorEffect r3 = (CTAlphaFloorEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), CTAlphaFloorEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTAlphaFloorEffect[] getAlphaFloorArray() {
        return (CTAlphaFloorEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new CTAlphaFloorEffect[0]), CTAlphaFloorEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTAlphaFloorEffect> getAlphaFloorList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$pQHS7HYawW8HDTkmfBjvtsux2xo(this), new $$Lambda$Xa6sXTLWkt3ab2KQbYuDRHg7wIE(this), new $$Lambda$NjaQGdNfp9AY5cBZqcZ36_W5tQ(this), new $$Lambda$RYBUD6nYzx13gcVpS4eG3fhEIyo(this), new $$Lambda$KZclv4nWwDfbkbwD4H9r9Bh1lBE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaInverseEffect getAlphaInvArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTAlphaInverseEffect r3 = (CTAlphaInverseEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), CTAlphaInverseEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTAlphaInverseEffect[] getAlphaInvArray() {
        return (CTAlphaInverseEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new CTAlphaInverseEffect[0]), CTAlphaInverseEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTAlphaInverseEffect> getAlphaInvList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Lz76xpyKKi0Xkx8CI9FKSI1250(this), new $$Lambda$EORImVDG8dQm_GJz9cNI4GRiI(this), new $$Lambda$wknCwudJklg47HN5Ks1FcAV_M5U(this), new $$Lambda$ucVBrTDtQnSEdiqITgLObf17DAQ(this), new $$Lambda$6Bs66MnFbA3PwQSpGWqTHFzmFdc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaModulateEffect getAlphaModArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTAlphaModulateEffect r3 = (CTAlphaModulateEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), CTAlphaModulateEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTAlphaModulateEffect[] getAlphaModArray() {
        return (CTAlphaModulateEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new CTAlphaModulateEffect[0]), CTAlphaModulateEffect[].class, "com.obric.memorydata.plugin");
    }

    public c getAlphaModFixArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        c r3 = (c) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public c[] getAlphaModFixArray() {
        return (c[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new c[0]), c[].class, "com.obric.memorydata.plugin");
    }

    public List<c> getAlphaModFixList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$TUCgPLNCS3fNITxUpSU2XN9k0Jg(this), new $$Lambda$fNq_8YIFe0quOR1xoD8t276P8Dw(this), new $$Lambda$djgpPNyLVXc4J9G3CFxmUtIHe78(this), new $$Lambda$vVBP9HpaaTwojNlfqcF6KHjqcc(this), new $$Lambda$GWNP3rZeZk2o0xzz2kU6oC3g1w(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<CTAlphaModulateEffect> getAlphaModList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Wn6D24iXMcR8TlTPsdzWTLCP1KA(this), new $$Lambda$Qg2bWtbzSsFOAy1zUsN1sLER3mI(this), new $$Lambda$De9iaxAScvqNEkQCueCRkYcOOz0(this), new $$Lambda$VMhAzvMsEfx3ZXr_XvGRQyVdUCg(this), new $$Lambda$H9U1_YIBxnW3RZzjIZZ9tMO2Cnw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaOutsetEffect getAlphaOutsetArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTAlphaOutsetEffect r3 = (CTAlphaOutsetEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), CTAlphaOutsetEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTAlphaOutsetEffect[] getAlphaOutsetArray() {
        return (CTAlphaOutsetEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new CTAlphaOutsetEffect[0]), CTAlphaOutsetEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTAlphaOutsetEffect> getAlphaOutsetList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$vtWMShl1fF4zqoJ14M7r6yXph4(this), new $$Lambda$u9g5iQIw6yLe3pVLcCcPxyrAr0k(this), new $$Lambda$cyub6lc3kDbgbfORjOJdy1QK88(this), new $$Lambda$VS9ml7FItlpeXYbOqUPrzm0Pw(this), new $$Lambda$uEO7em3VQ2SsLSDSGtYIkEyjmk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaReplaceEffect getAlphaReplArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTAlphaReplaceEffect r3 = (CTAlphaReplaceEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), CTAlphaReplaceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTAlphaReplaceEffect[] getAlphaReplArray() {
        return (CTAlphaReplaceEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new CTAlphaReplaceEffect[0]), CTAlphaReplaceEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTAlphaReplaceEffect> getAlphaReplList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$hPpYdVfmU3Ts9DIgxCVMwZvbyw(this), new $$Lambda$G0pMD_W03RmzpWbIph4PA3I_RhU(this), new $$Lambda$wMnB2NuQgOF9oIFbfakfyoMfrTU(this), new $$Lambda$nRTegeoyCSPZhejJKRYUm_X92RY(this), new $$Lambda$WbrxBxdYqWHi9JOT3LhvOZVNyhI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBiLevelEffect getBiLevelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTBiLevelEffect r3 = (CTBiLevelEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), CTBiLevelEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTBiLevelEffect[] getBiLevelArray() {
        return (CTBiLevelEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new CTBiLevelEffect[0]), CTBiLevelEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTBiLevelEffect> getBiLevelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$wqPGh43587GBKIgITLR2BWNH2wM(this), new $$Lambda$xy0S4zhprdFVunb2DXuAKaFpl68(this), new $$Lambda$4DnOAi39IU_FnrLU8aDZQS3kNDo(this), new $$Lambda$jS3mQGQWwRpfEEXk3_qcRk0VYMQ(this), new $$Lambda$dSyCEk8p80ZQealXA3RHTPOxTcM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBlendEffect getBlendArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTBlendEffect r3 = (CTBlendEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), CTBlendEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTBlendEffect[] getBlendArray() {
        return (CTBlendEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[11], new CTBlendEffect[0]), CTBlendEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTBlendEffect> getBlendList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$u4Re7DWuYM8mVlf0C4JOeOY6v0(this), new $$Lambda$QqBvrSabv1EFzZj9ndsVAFY_mI(this), new $$Lambda$v0TzOb8tg4KdZDzxKI0_V8n0I0(this), new $$Lambda$mIyqWhX4R9twdcJuW80FbcLDqQ(this), new $$Lambda$3LlwMqPUMDRi7gYmf0THQ_SJlZk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBlurEffect getBlurArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTBlurEffect r3 = (CTBlurEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), CTBlurEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTBlurEffect[] getBlurArray() {
        return (CTBlurEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[12], new CTBlurEffect[0]), CTBlurEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTBlurEffect> getBlurList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$en3a_2dygYrELEllhkWOsztoro(this), new $$Lambda$IlJPMU00kUoHaUelpf1S8t_aWbY(this), new $$Lambda$2TFNs0NXm1md0uRAp1wKLCT40(this), new $$Lambda$ag0DYT6zno8wnKUjxmUJpWN4J8(this), new $$Lambda$0IBM9TBEPpbpypO1Q3LUJyiY8Q(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTColorChangeEffect getClrChangeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTColorChangeEffect r3 = (CTColorChangeEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), CTColorChangeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTColorChangeEffect[] getClrChangeArray() {
        return (CTColorChangeEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[13], new CTColorChangeEffect[0]), CTColorChangeEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTColorChangeEffect> getClrChangeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$xySb2gsNyehnDj4NEDshDXOik(this), new $$Lambda$e4CvPjCeBn5jPNu5VcCvka63hME(this), new $$Lambda$6HKNDeRpTNWqv9XOTh8XErj_z4(this), new $$Lambda$0Ii6coHZ3y71MPDTOmMNIqy3toc(this), new $$Lambda$VCdToEtUzDq8gVKTaez4VooLU1s(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTColorReplaceEffect getClrReplArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTColorReplaceEffect r3 = (CTColorReplaceEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), CTColorReplaceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTColorReplaceEffect[] getClrReplArray() {
        return (CTColorReplaceEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[14], new CTColorReplaceEffect[0]), CTColorReplaceEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTColorReplaceEffect> getClrReplList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$BpDD_IvbWDzdSi5xV_jg9SLR0Q(this), new $$Lambda$siP9MEI6na3TrZA5srpcqlZ6i2c(this), new $$Lambda$sMJo3RFVzGl5hasuA5ZtwWdYpxQ(this), new $$Lambda$R9gbGn550E8CsR9ZWyZEa3tjZK8(this), new $$Lambda$aNRU3OkRNBwcx9OhrYnGNASTr3s(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public s getContArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        s r3 = (s) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public s[] getContArray() {
        return (s[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new s[0]), s[].class, "com.obric.memorydata.plugin");
    }

    public List<s> getContList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$V4zGNuYyJgn6pqI_Uz6O2uUrDI(this), new $$Lambda$RWLK8gnfQZvmMuw86AEqioh70A(this), new $$Lambda$5l7_55M0TLxBjAIfi4IEY3o2JZw(this), new $$Lambda$9iCKnR3VH5aeCtqw4UxvbGWauII(this), new $$Lambda$YNrT22ZvJGyEkLqeMfUTgSfrmP4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public r getDuotoneArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        r r3 = (r) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), r.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public r[] getDuotoneArray() {
        return (r[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[15], new r[0]), r[].class, "com.obric.memorydata.plugin");
    }

    public List<r> getDuotoneList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$uyXgJwrBsaWOH9lmhfBP88qeqmY(this), new $$Lambda$aXu5Jbb_5c9RtsCocD3R8EAHulI(this), new $$Lambda$s_YeXBc4ldjlzi4tkn1kasgJXs(this), new $$Lambda$X4jlZw3CFgLkqi5i9h4vOZuqMuk(this), new $$Lambda$k8vjEWFuHeHTnCkcvTRfENxk8HE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTEffectReference getEffectArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTEffectReference r3 = (CTEffectReference) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), CTEffectReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTEffectReference[] getEffectArray() {
        return (CTEffectReference[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new CTEffectReference[0]), CTEffectReference[].class, "com.obric.memorydata.plugin");
    }

    public List<CTEffectReference> getEffectList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$n_JZzvt5tByewVyPJJ0b32s4LY(this), new $$Lambda$ZxDZhwBT5b6UhnL9zUrqpvFlxQ(this), new $$Lambda$5MPMnX81zB05fxqceMuwg6JXc(this), new $$Lambda$iWYmJLNaB70U4TzNLMXl3ibiAYI(this), new $$Lambda$uBIruA6EK_cszP0P8QDaZtu3JjQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTFillEffect getFillArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTFillEffect r3 = (CTFillEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), CTFillEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTFillEffect[] getFillArray() {
        return (CTFillEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[16], new CTFillEffect[0]), CTFillEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTFillEffect> getFillList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$4geDgimPmyyfsMskSGkwjzQnqHs(this), new $$Lambda$9DvjHCqcXMAcEH7xEeJhywKUDo(this), new $$Lambda$BOlXZX2DLOSJKJwLrO0DKSTMdPI(this), new $$Lambda$sR2loeQYWwyN3ha2j_czBGg_9Fg(this), new $$Lambda$MCEQ4uVKseCLdeyBKHDdwqr1uqE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTFillOverlayEffect getFillOverlayArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTFillOverlayEffect r3 = (CTFillOverlayEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), CTFillOverlayEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTFillOverlayEffect[] getFillOverlayArray() {
        return (CTFillOverlayEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[17], new CTFillOverlayEffect[0]), CTFillOverlayEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTFillOverlayEffect> getFillOverlayList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$NJaVIBMtGp_4MCfjW0qAayuNqo8(this), new $$Lambda$Dn2b9xav9_3qaQvwaHVJqTwKPg(this), new $$Lambda$9Qqi94L0a6oPleRHW3do09IB454(this), new $$Lambda$n0UjiEWrYad5snLO7zEFxWdzec(this), new $$Lambda$Q30psMaiKM9uVsUumLjBOGC0R4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGlowEffect getGlowArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTGlowEffect r3 = (CTGlowEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), CTGlowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTGlowEffect[] getGlowArray() {
        return (CTGlowEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[18], new CTGlowEffect[0]), CTGlowEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTGlowEffect> getGlowList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$OuC1uLZUUNpyhGz2jI5SBrLMG1Y(this), new $$Lambda$OxsteypR1sNXJMu8rVrSNKuBnnc(this), new $$Lambda$jkRRyw4jQ2mhgf6hgmGaIMVLIag(this), new $$Lambda$rnb8u8R6zBCOFGtaQ9mKklJVY6k(this), new $$Lambda$y9P__Ow3NJgsAWEsxwxWX6Erh5k(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGrayscaleEffect getGraysclArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTGrayscaleEffect r3 = (CTGrayscaleEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), CTGrayscaleEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTGrayscaleEffect[] getGraysclArray() {
        return (CTGrayscaleEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[19], new CTGrayscaleEffect[0]), CTGrayscaleEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTGrayscaleEffect> getGraysclList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$j02PsuzLpxKiDY066G09yIMtw(this), new $$Lambda$0UqReGDGYCPCTnUqi79eJYDdAms(this), new $$Lambda$18wQRQZknzNoPh9edefQ6w7c3Kk(this), new $$Lambda$qKz_ZRTP3bUMvW_aUT1DRXlRo(this), new $$Lambda$bIMA6p2IY6SCoZmJtns1F_I9pFg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTHSLEffect getHslArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTHSLEffect r3 = (CTHSLEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[20], r4), CTHSLEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTHSLEffect[] getHslArray() {
        return (CTHSLEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[20], new CTHSLEffect[0]), CTHSLEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTHSLEffect> getHslList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$aW_hSuQAvFalRFmukU0sLRjINUo(this), new $$Lambda$QjQyXuuPEYZsRW8gX3E2DVOPa9M(this), new $$Lambda$Tl9Ehami7HJNaEfYkmxauVn8s(this), new $$Lambda$qUerVOkSSXGFffmkAe39_U3Gjco(this), new $$Lambda$MC_zvgkkdKM7xuMP0SAETgRR2g(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTInnerShadowEffect getInnerShdwArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTInnerShadowEffect r3 = (CTInnerShadowEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[21], r4), CTInnerShadowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTInnerShadowEffect[] getInnerShdwArray() {
        return (CTInnerShadowEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[21], new CTInnerShadowEffect[0]), CTInnerShadowEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTInnerShadowEffect> getInnerShdwList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$srOZ4Y08c28QVBjbz5ZsQSfYWZI(this), new $$Lambda$YNrd1jeX5EwPJyfxyoAgw4toWds(this), new $$Lambda$LjY2u5pNnw7jLcMkD1fFvoAGDoc(this), new $$Lambda$55w7ma7ULewfNNvB0qHEdFo_RY(this), new $$Lambda$dAa8dKg7aWRhRJRpJwmtJVRrQw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTLuminanceEffect getLumArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTLuminanceEffect r3 = (CTLuminanceEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[22], r4), CTLuminanceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTLuminanceEffect[] getLumArray() {
        return (CTLuminanceEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[22], new CTLuminanceEffect[0]), CTLuminanceEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTLuminanceEffect> getLumList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$0gb0rMpXWhsXwNQJfIA4MWMTmOE(this), new $$Lambda$nP8cCcGInZZjp6yCIwZ6jzM_864(this), new $$Lambda$18Ej32iQVOSWCkqkDaIh1Paa_d0(this), new $$Lambda$11O9tCOvw7WPguI7gMsOJc0WPmg(this), new $$Lambda$Lldw_rlscF_5s1KY6qRXQZtRTgA(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getName() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[31]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        String r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = r3.getStringValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bi getOuterShdwArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bi r3 = (bi) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[23], r4), bi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bi[] getOuterShdwArray() {
        return (bi[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[23], new bi[0]), bi[].class, "com.obric.memorydata.plugin");
    }

    public List<bi> getOuterShdwList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Um7Z_XD06rj6p9aLCxZkxiyvhvU(this), new $$Lambda$t842DlVfubsGDpho3WwriGQWsw(this), new $$Lambda$nR_74S6teEBpYzM0NOSQvbHJZe4(this), new $$Lambda$l9kd9HjTtrfn6szI5lkxrV22bE(this), new $$Lambda$T4DTYurZE5nOv6U4tPo0WDrp4mQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTPresetShadowEffect getPrstShdwArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTPresetShadowEffect r3 = (CTPresetShadowEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[24], r4), CTPresetShadowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTPresetShadowEffect[] getPrstShdwArray() {
        return (CTPresetShadowEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[24], new CTPresetShadowEffect[0]), CTPresetShadowEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTPresetShadowEffect> getPrstShdwList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$HHwmBB5tt_PEnz42ONAv7YXrUTQ(this), new $$Lambda$MbYa9ZaCCyoBNEK6_GvlnJubyYk(this), new $$Lambda$ktDgcvgJkwo2qdbRKlZ2dGgWpZg(this), new $$Lambda$cdx9BGir8bOvZG943ULBmUarGwE(this), new $$Lambda$QdTwo1iY5LrEk1vwBZYIOXFME1Y(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTReflectionEffect getReflectionArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTReflectionEffect r3 = (CTReflectionEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[25], r4), CTReflectionEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTReflectionEffect[] getReflectionArray() {
        return (CTReflectionEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[25], new CTReflectionEffect[0]), CTReflectionEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTReflectionEffect> getReflectionList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$q_iJ6SHDxOXGpyCOO_uPr1o2d4I(this), new $$Lambda$jAVE1G3ZG9b0ndldmrLf4iBQSfY(this), new $$Lambda$og7b2y0Yu9dVJtxcJdHR37SGDI(this), new $$Lambda$0RJZnuXYpwTSkl3LmTCuaLf3jYo(this), new $$Lambda$Mu5QRcdwXPs7qUKi_DIKYy_59s(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTRelativeOffsetEffect getRelOffArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTRelativeOffsetEffect r3 = (CTRelativeOffsetEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[26], r4), CTRelativeOffsetEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTRelativeOffsetEffect[] getRelOffArray() {
        return (CTRelativeOffsetEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[26], new CTRelativeOffsetEffect[0]), CTRelativeOffsetEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTRelativeOffsetEffect> getRelOffList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$vMYDtdCY0E1dPESob7RF697FQrw(this), new $$Lambda$hi3OPuZJKXjrETei9_7m2fPVw4M(this), new $$Lambda$z7Y5N1honOChPfjaKu_fVEuCQj8(this), new $$Lambda$czyM3mmhFDS4WucTAuAO1MQGAo(this), new $$Lambda$0QcfKa7ow2ZCDzOpSI9kxhzxI0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTSoftEdgesEffect getSoftEdgeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTSoftEdgesEffect r3 = (CTSoftEdgesEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[27], r4), CTSoftEdgesEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTSoftEdgesEffect[] getSoftEdgeArray() {
        return (CTSoftEdgesEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[27], new CTSoftEdgesEffect[0]), CTSoftEdgesEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTSoftEdgesEffect> getSoftEdgeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$VzSGHsskMprrt6wAL9EPZcKFb44(this), new $$Lambda$A7hVGQCT2j3_2JbuYKXKHvW8lbg(this), new $$Lambda$1itwsxkMCrlNAM4SRhbdVUDDIQ(this), new $$Lambda$JLYJ02cI38LmsNOMoJgusUK5sC0(this), new $$Lambda$7J0UBaVG0Tjh2ssvQ9ffsDJ84(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTintEffect getTintArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTintEffect r3 = (CTTintEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[28], r4), CTTintEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTintEffect[] getTintArray() {
        return (CTTintEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[28], new CTTintEffect[0]), CTTintEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTintEffect> getTintList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$0HyEvM2to2JrU8krZcGxd8cY354(this), new $$Lambda$89zA9mU1ICfScyFdEzFcE6kHAbI(this), new $$Lambda$IMXJ52A1wvMHJqjb_JxVWjc0B0(this), new $$Lambda$6mAbilHgAa0O0brvkRYOpRP4J74(this), new $$Lambda$JUdgB4NBwEPSIZeImhuuma3hYQM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.s
    public STEffectContainerType$Enum getType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L12
        TypeStore r1 = get_store();     // Catch: Throwable -> L12
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L12
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[30]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[30]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L7:
        if (r3 != null) goto L9;
        STEffectContainerType$Enum r6 = null;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L9:
        r6 = (STEffectContainerType$Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STEffectContainerType$Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public CTTransformEffect getXfrmArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTransformEffect r3 = (CTTransformEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[29], r4), CTTransformEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTransformEffect[] getXfrmArray() {
        return (CTTransformEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[29], new CTTransformEffect[0]), CTTransformEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTransformEffect> getXfrmList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ulz0deSE9RXftS1qbaELIbJYrkg(this), new $$Lambda$2D3LYZtRMUpGdMRdugjgg3wKHY(this), new $$Lambda$H_EcPLpCIa_ETw59Kjq5bwP6Y(this), new $$Lambda$EBDUxMsNSo1_4fsz3rXePM1VQ_I(this), new $$Lambda$ETqRUm7qXKPe4MmItHjcz6KtMCk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaBiLevelEffect insertNewAlphaBiLevel(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaBiLevelEffect r3 = (CTAlphaBiLevelEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), CTAlphaBiLevelEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaCeilingEffect insertNewAlphaCeiling(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaCeilingEffect r3 = (CTAlphaCeilingEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), CTAlphaCeilingEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaFloorEffect insertNewAlphaFloor(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaFloorEffect r3 = (CTAlphaFloorEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), CTAlphaFloorEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaInverseEffect insertNewAlphaInv(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaInverseEffect r3 = (CTAlphaInverseEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), CTAlphaInverseEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaModulateEffect insertNewAlphaMod(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaModulateEffect r3 = (CTAlphaModulateEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), CTAlphaModulateEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public c insertNewAlphaModFix(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        c r3 = (c) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaOutsetEffect insertNewAlphaOutset(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaOutsetEffect r3 = (CTAlphaOutsetEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), CTAlphaOutsetEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTAlphaReplaceEffect insertNewAlphaRepl(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTAlphaReplaceEffect r3 = (CTAlphaReplaceEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), CTAlphaReplaceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBiLevelEffect insertNewBiLevel(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTBiLevelEffect r3 = (CTBiLevelEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), CTBiLevelEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBlendEffect insertNewBlend(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTBlendEffect r3 = (CTBlendEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), CTBlendEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTBlurEffect insertNewBlur(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTBlurEffect r3 = (CTBlurEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), CTBlurEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTColorChangeEffect insertNewClrChange(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTColorChangeEffect r3 = (CTColorChangeEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), CTColorChangeEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTColorReplaceEffect insertNewClrRepl(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTColorReplaceEffect r3 = (CTColorReplaceEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), CTColorReplaceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public s insertNewCont(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        s r3 = (s) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public r insertNewDuotone(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        r r3 = (r) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[15], r4), r.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTEffectReference insertNewEffect(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTEffectReference r3 = (CTEffectReference) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), CTEffectReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTFillEffect insertNewFill(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTFillEffect r3 = (CTFillEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[16], r4), CTFillEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTFillOverlayEffect insertNewFillOverlay(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTFillOverlayEffect r3 = (CTFillOverlayEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[17], r4), CTFillOverlayEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGlowEffect insertNewGlow(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTGlowEffect r3 = (CTGlowEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[18], r4), CTGlowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTGrayscaleEffect insertNewGrayscl(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTGrayscaleEffect r3 = (CTGrayscaleEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[19], r4), CTGrayscaleEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTHSLEffect insertNewHsl(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTHSLEffect r3 = (CTHSLEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[20], r4), CTHSLEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTInnerShadowEffect insertNewInnerShdw(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTInnerShadowEffect r3 = (CTInnerShadowEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[21], r4), CTInnerShadowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTLuminanceEffect insertNewLum(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTLuminanceEffect r3 = (CTLuminanceEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[22], r4), CTLuminanceEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bi insertNewOuterShdw(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bi r3 = (bi) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[23], r4), bi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTPresetShadowEffect insertNewPrstShdw(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTPresetShadowEffect r3 = (CTPresetShadowEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[24], r4), CTPresetShadowEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTReflectionEffect insertNewReflection(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTReflectionEffect r3 = (CTReflectionEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[25], r4), CTReflectionEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTRelativeOffsetEffect insertNewRelOff(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTRelativeOffsetEffect r3 = (CTRelativeOffsetEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[26], r4), CTRelativeOffsetEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTSoftEdgesEffect insertNewSoftEdge(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTSoftEdgesEffect r3 = (CTSoftEdgesEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[27], r4), CTSoftEdgesEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTintEffect insertNewTint(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTintEffect r3 = (CTTintEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[28], r4), CTTintEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTransformEffect insertNewXfrm(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTransformEffect r3 = (CTTransformEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[29], r4), CTTransformEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isSetName() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().find_attribute_user(PROPERTY_QNAME[31]) == null) goto L7;
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

    public boolean isSetType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().find_attribute_user(PROPERTY_QNAME[30]) == null) goto L7;
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

    public void removeAlphaBiLevel(int r4) {
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

    public void removeAlphaCeiling(int r4) {
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

    public void removeAlphaFloor(int r4) {
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

    public void removeAlphaInv(int r4) {
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
        get_store().remove_element(PROPERTY_QNAME[6], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAlphaModFix(int r4) {
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

    public void removeAlphaOutset(int r4) {
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

    public void removeAlphaRepl(int r4) {
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

    public void removeBiLevel(int r4) {
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

    public void removeBlend(int r4) {
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

    public void removeBlur(int r4) {
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

    public void removeClrChange(int r4) {
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

    public void removeClrRepl(int r4) {
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

    public void removeCont(int r4) {
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

    public void removeDuotone(int r4) {
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

    public void removeEffect(int r4) {
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

    public void removeFill(int r4) {
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

    public void removeFillOverlay(int r4) {
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

    public void removeGlow(int r4) {
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

    public void removeGrayscl(int r4) {
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

    public void removeHsl(int r4) {
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

    public void removeInnerShdw(int r4) {
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

    public void removeLum(int r4) {
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

    public void removeOuterShdw(int r4) {
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

    public void removePrstShdw(int r4) {
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

    public void removeReflection(int r4) {
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

    public void removeRelOff(int r4) {
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

    public void removeSoftEdge(int r4) {
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

    public void removeTint(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[28], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeXfrm(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[29], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAlphaBiLevelArray(int r3, CTAlphaBiLevelEffect r4) {
        generatedSetterHelperImpl((CTAlphaBiLevelEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTAlphaBiLevelEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
    }

    public void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[2]);
    }

    public void setAlphaCeilingArray(int r3, CTAlphaCeilingEffect r4) {
        generatedSetterHelperImpl((CTAlphaCeilingEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTAlphaCeilingEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
    }

    public void setAlphaCeilingArray(CTAlphaCeilingEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[3]);
    }

    public void setAlphaFloorArray(int r3, CTAlphaFloorEffect r4) {
        generatedSetterHelperImpl((CTAlphaFloorEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTAlphaFloorEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
    }

    public void setAlphaFloorArray(CTAlphaFloorEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[4]);
    }

    public void setAlphaInvArray(int r3, CTAlphaInverseEffect r4) {
        generatedSetterHelperImpl((CTAlphaInverseEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTAlphaInverseEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
    }

    public void setAlphaInvArray(CTAlphaInverseEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[5]);
    }

    public void setAlphaModArray(int r3, CTAlphaModulateEffect r4) {
        generatedSetterHelperImpl((CTAlphaModulateEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTAlphaModulateEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
    }

    public void setAlphaModArray(CTAlphaModulateEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[6]);
    }

    public void setAlphaModFixArray(int r3, c r4) {
        generatedSetterHelperImpl((c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
    }

    public void setAlphaModFixArray(c[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[7]);
    }

    public void setAlphaOutsetArray(int r3, CTAlphaOutsetEffect r4) {
        generatedSetterHelperImpl((CTAlphaOutsetEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTAlphaOutsetEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
    }

    public void setAlphaOutsetArray(CTAlphaOutsetEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[8]);
    }

    public void setAlphaReplArray(int r3, CTAlphaReplaceEffect r4) {
        generatedSetterHelperImpl((CTAlphaReplaceEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTAlphaReplaceEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
    }

    public void setAlphaReplArray(CTAlphaReplaceEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[9]);
    }

    public void setBiLevelArray(int r3, CTBiLevelEffect r4) {
        generatedSetterHelperImpl((CTBiLevelEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTBiLevelEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
    }

    public void setBiLevelArray(CTBiLevelEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[10]);
    }

    public void setBlendArray(int r3, CTBlendEffect r4) {
        generatedSetterHelperImpl((CTBlendEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTBlendEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[11], r3, 2);
    }

    public void setBlendArray(CTBlendEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[11]);
    }

    public void setBlurArray(int r3, CTBlurEffect r4) {
        generatedSetterHelperImpl((CTBlurEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTBlurEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[12], r3, 2);
    }

    public void setBlurArray(CTBlurEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[12]);
    }

    public void setClrChangeArray(int r3, CTColorChangeEffect r4) {
        generatedSetterHelperImpl((CTColorChangeEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTColorChangeEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[13], r3, 2);
    }

    public void setClrChangeArray(CTColorChangeEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[13]);
    }

    public void setClrReplArray(int r3, CTColorReplaceEffect r4) {
        generatedSetterHelperImpl((CTColorReplaceEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTColorReplaceEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[14], r3, 2);
    }

    public void setClrReplArray(CTColorReplaceEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[14]);
    }

    public void setContArray(int r3, s r4) {
        generatedSetterHelperImpl((s) ZeusTransformUtils.wrapperContextForParams(r4, s.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    public void setContArray(s[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    public void setDuotoneArray(int r3, r r4) {
        generatedSetterHelperImpl((r) ZeusTransformUtils.wrapperContextForParams(r4, r.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[15], r3, 2);
    }

    public void setDuotoneArray(r[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[15]);
    }

    public void setEffectArray(int r3, CTEffectReference r4) {
        generatedSetterHelperImpl((CTEffectReference) ZeusTransformUtils.wrapperContextForParams(r4, CTEffectReference.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
    }

    public void setEffectArray(CTEffectReference[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[1]);
    }

    public void setFillArray(int r3, CTFillEffect r4) {
        generatedSetterHelperImpl((CTFillEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTFillEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[16], r3, 2);
    }

    public void setFillArray(CTFillEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[16]);
    }

    public void setFillOverlayArray(int r3, CTFillOverlayEffect r4) {
        generatedSetterHelperImpl((CTFillOverlayEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTFillOverlayEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[17], r3, 2);
    }

    public void setFillOverlayArray(CTFillOverlayEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[17]);
    }

    public void setGlowArray(int r3, CTGlowEffect r4) {
        generatedSetterHelperImpl((CTGlowEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTGlowEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[18], r3, 2);
    }

    public void setGlowArray(CTGlowEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[18]);
    }

    public void setGraysclArray(int r3, CTGrayscaleEffect r4) {
        generatedSetterHelperImpl((CTGrayscaleEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTGrayscaleEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[19], r3, 2);
    }

    public void setGraysclArray(CTGrayscaleEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[19]);
    }

    public void setHslArray(int r3, CTHSLEffect r4) {
        generatedSetterHelperImpl((CTHSLEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTHSLEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[20], r3, 2);
    }

    public void setHslArray(CTHSLEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[20]);
    }

    public void setInnerShdwArray(int r3, CTInnerShadowEffect r4) {
        generatedSetterHelperImpl((CTInnerShadowEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTInnerShadowEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[21], r3, 2);
    }

    public void setInnerShdwArray(CTInnerShadowEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[21]);
    }

    public void setLumArray(int r3, CTLuminanceEffect r4) {
        generatedSetterHelperImpl((CTLuminanceEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTLuminanceEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[22], r3, 2);
    }

    public void setLumArray(CTLuminanceEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[22]);
    }

    public void setName(String r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[31]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[31]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setStringValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setOuterShdwArray(int r3, bi r4) {
        generatedSetterHelperImpl((bi) ZeusTransformUtils.wrapperContextForParams(r4, bi.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[23], r3, 2);
    }

    public void setOuterShdwArray(bi[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[23]);
    }

    public void setPrstShdwArray(int r3, CTPresetShadowEffect r4) {
        generatedSetterHelperImpl((CTPresetShadowEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTPresetShadowEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[24], r3, 2);
    }

    public void setPrstShdwArray(CTPresetShadowEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[24]);
    }

    public void setReflectionArray(int r3, CTReflectionEffect r4) {
        generatedSetterHelperImpl((CTReflectionEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTReflectionEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[25], r3, 2);
    }

    public void setReflectionArray(CTReflectionEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[25]);
    }

    public void setRelOffArray(int r3, CTRelativeOffsetEffect r4) {
        generatedSetterHelperImpl((CTRelativeOffsetEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTRelativeOffsetEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[26], r3, 2);
    }

    public void setRelOffArray(CTRelativeOffsetEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[26]);
    }

    public void setSoftEdgeArray(int r3, CTSoftEdgesEffect r4) {
        generatedSetterHelperImpl((CTSoftEdgesEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTSoftEdgesEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[27], r3, 2);
    }

    public void setSoftEdgeArray(CTSoftEdgesEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[27]);
    }

    public void setTintArray(int r3, CTTintEffect r4) {
        generatedSetterHelperImpl((CTTintEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTTintEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[28], r3, 2);
    }

    public void setTintArray(CTTintEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[28]);
    }

    public void setType(STEffectContainerType$Enum r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[30]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[30]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setEnumValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setXfrmArray(int r3, CTTransformEffect r4) {
        generatedSetterHelperImpl((CTTransformEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTTransformEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[29], r3, 2);
    }

    public void setXfrmArray(CTTransformEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[29]);
    }

    public int sizeOfAlphaBiLevelArray() {
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

    public int sizeOfAlphaCeilingArray() {
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

    public int sizeOfAlphaFloorArray() {
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

    public int sizeOfAlphaInvArray() {
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
        int r3 = get_store().count_elements(PROPERTY_QNAME[6]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfAlphaModFixArray() {
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

    public int sizeOfAlphaOutsetArray() {
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

    public int sizeOfAlphaReplArray() {
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

    public int sizeOfBiLevelArray() {
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

    public int sizeOfBlendArray() {
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

    public int sizeOfBlurArray() {
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

    public int sizeOfClrChangeArray() {
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

    public int sizeOfClrReplArray() {
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

    public int sizeOfContArray() {
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

    public int sizeOfDuotoneArray() {
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

    public int sizeOfEffectArray() {
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

    public int sizeOfFillArray() {
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

    public int sizeOfFillOverlayArray() {
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

    public int sizeOfGlowArray() {
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

    public int sizeOfGraysclArray() {
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

    public int sizeOfHslArray() {
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

    public int sizeOfInnerShdwArray() {
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

    public int sizeOfLumArray() {
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

    public int sizeOfOuterShdwArray() {
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

    public int sizeOfPrstShdwArray() {
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

    public int sizeOfReflectionArray() {
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

    public int sizeOfRelOffArray() {
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

    public int sizeOfSoftEdgeArray() {
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

    public int sizeOfTintArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[28]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfXfrmArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[29]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetName() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[31]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_attribute(PROPERTY_QNAME[30]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlToken xgetName() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlToken r3 = (XmlToken) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[31]), XmlToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STEffectContainerType xgetType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        TypeStore r1 = get_store();     // Catch: Throwable -> L9
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L9
        STEffectContainerType r3 = (STEffectContainerType) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[30]), STEffectContainerType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = (STEffectContainerType) ZeusTransformUtils.preCheckCast(get_default_attribute_value(r2[30]), STEffectContainerType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void xsetName(XmlToken r7) {
        XmlToken r8 = (XmlToken) ZeusTransformUtils.wrapperContextForParams(r7, XmlToken.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        XmlToken r3 = (XmlToken) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[31]), XmlToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (XmlToken) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[31]), XmlToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetType(STEffectContainerType r7) {
        STEffectContainerType r8 = (STEffectContainerType) ZeusTransformUtils.wrapperContextForParams(r7, STEffectContainerType.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        STEffectContainerType r3 = (STEffectContainerType) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[30]), STEffectContainerType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (STEffectContainerType) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[30]), STEffectContainerType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
