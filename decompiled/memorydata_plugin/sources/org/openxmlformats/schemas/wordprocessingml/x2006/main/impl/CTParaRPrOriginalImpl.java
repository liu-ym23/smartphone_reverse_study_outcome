package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEastAsianLayout;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextEffect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ad;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ak;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.am;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ax;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ay;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.be;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bu;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ck;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.du;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dw;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eb;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fj;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.i;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.n;

/* JADX INFO: loaded from: classes8.dex */
public class CTParaRPrOriginalImpl extends XmlComplexContentImpl implements ck {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rStyle"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rFonts"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "b"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bCs"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "i"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "iCs"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "caps"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smallCaps"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strike"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dstrike"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outline"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "emboss"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "imprint"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noProof"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vanish"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "webHidden"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", TypedValues.Custom.S_COLOR), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kern"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "position"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "szCs"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "highlight"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "u"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "effect"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bdr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fitText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vertAlign"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtl"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "em"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lang"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsianLayout"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "specVanish"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "oMath")};
    }

    public CTParaRPrOriginalImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public bu addNewB() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewBCs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public i addNewBdr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        i r3 = (i) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[32]), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewCaps() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public n addNewColor() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        n r3 = (n) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[22]), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewCs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[37]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fj addNewDel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), fj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewDstrike() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTEastAsianLayout addNewEastAsianLayout() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTEastAsianLayout r3 = (CTEastAsianLayout) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[40]), CTEastAsianLayout.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTextEffect addNewEffect() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTextEffect r3 = (CTTextEffect) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[31]), CTTextEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ad addNewEm() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ad r3 = (ad) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[38]), ad.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewEmboss() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[16]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ak addNewFitText() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ak r3 = (ak) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[34]), ak.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ax addNewHighlight() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ax r3 = (ax) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[29]), ax.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewI() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewICs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewImprint() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[17]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fj addNewIns() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), fj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay addNewKern() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[25]), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public be addNewLang() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        be r3 = (be) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[39]), be.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fj addNewMoveFrom() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), fj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fj addNewMoveTo() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), fj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewNoProof() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[18]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewOMath() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[42]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewOutline() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public dv addNewPosition() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        dv r3 = (dv) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[26]), dv.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public am addNewRFonts() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        am r3 = (am) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), am.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public eb addNewRStyle() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        eb r3 = (eb) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), eb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewRtl() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[36]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewShadow() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[15]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public du addNewShd() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        du r3 = (du) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[33]), du.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewSmallCaps() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewSnapToGrid() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[19]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public dw addNewSpacing() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        dw r3 = (dw) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[23]), dw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewSpecVanish() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[41]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewStrike() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay addNewSz() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[27]), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay addNewSzCs() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[28]), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fl addNewU() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fl r3 = (fl) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[30]), fl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewVanish() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[20]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fn addNewVertAlign() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fn r3 = (fn) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[35]), fn.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ff addNewW() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ff r3 = (ff) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[24]), ff.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewWebHidden() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[21]), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getBArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getBArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public bu getBCsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getBCsArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getBCsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$qaqfvWYhdiZql6vvPpfA1SB85Q(this), new $$Lambda$aVPQnTWGDHN5PAivkQhwSRc4mr8(this), new $$Lambda$uDeBdU030VYZkyaRC4jJTD51jj0(this), new $$Lambda$T2QHmd_e3u6bdBnaXjvcscTUQAM(this), new $$Lambda$v6si7Pt0vRHvN4Oj3pXs5z4JfhI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<bu> getBList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$LywWl1c2cUI8qf2CovgJV2XhZ24(this), new $$Lambda$EktumfdclNlGpDroZ4Sl8E9mqc(this), new $$Lambda$IOqCj4wFERNnnnPcvgi_dWbvaA(this), new $$Lambda$qswNnlUNzMpHHgkC1GbqPq1h2TI(this), new $$Lambda$inwzXj_FT3U4V52kVJkH4XDjOc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public i getBdrArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        i r3 = (i) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[32], r4), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public i[] getBdrArray() {
        return (i[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[32], new i[0]), i[].class, "com.obric.memorydata.plugin");
    }

    public List<i> getBdrList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$evGtmxpQzCBwLMngYNYBGJ3HKrQ(this), new $$Lambda$lJUeHYOCgG9ed8_TtVfevmaoVwU(this), new $$Lambda$LhUyjtfmOSefVCdYUXO2ZUtd_GM(this), new $$Lambda$Lx3aOSpQ8LsuVYBmCnvrE2OLE(this), new $$Lambda$VJ5hRIYSAYNltJBjVhXz6Fe_Ku8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getCapsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getCapsArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getCapsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Wecw6Npk8JCqL8heqY5Dl0WvylE(this), new $$Lambda$jPobxDNX6kNAwCry9jmX5pVINo(this), new $$Lambda$eMEH8FqTKDAAXH4GYmF6Vi8aFM(this), new $$Lambda$1xyd7R7j0Hc0wGrYrvDypjRsxk(this), new $$Lambda$b5oFiM5zhIUdn3dQr48QhLVNyUw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public n getColorArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        n r3 = (n) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[22], r4), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public n[] getColorArray() {
        return (n[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[22], new n[0]), n[].class, "com.obric.memorydata.plugin");
    }

    public List<n> getColorList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$WPfVs20DyYSOVchRMd_N9c5Xx8(this), new $$Lambda$kU8hc0CairlvyRHIFMRDzXlcWVo(this), new $$Lambda$L2D43grWDI4HwFy2B_33zruuMuE(this), new $$Lambda$z9RSzCrRSDa33uYdB_NquTuQ(this), new $$Lambda$ThtuyCfVBAOEh_WsExNm4rAC9s(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getCsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[37], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getCsArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[37], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getCsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$IRjAELDSIMzJLuF9JhP1UkoW1g(this), new $$Lambda$JvcnWPg756Rd8eIuuGjvlmL7BE(this), new $$Lambda$dDN6s14Hqxo3kX_BNjAwsZlI1M(this), new $$Lambda$QSXVXQN3LOK01cvU6qzxCqiojO0(this), new $$Lambda$5PC1ncmEffBa27M17PUmJAZYI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public fj getDel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], 0), fj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public bu getDstrikeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getDstrikeArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[13], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getDstrikeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$yHCsgTGDl5DSZqZqbU7TzdCfic(this), new $$Lambda$euNcfr1_oa7r2GuV1aC1Gjoon8(this), new $$Lambda$SR98vChy8dddReNMQ7alsdJCoso(this), new $$Lambda$UpTnRn7oe1hZQ6PWBh1RT9VvSGc(this), new $$Lambda$D0P5rP4246e0kf4YxZoGZHL0i2E(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTEastAsianLayout getEastAsianLayoutArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTEastAsianLayout r3 = (CTEastAsianLayout) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[40], r4), CTEastAsianLayout.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTEastAsianLayout[] getEastAsianLayoutArray() {
        return (CTEastAsianLayout[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[40], new CTEastAsianLayout[0]), CTEastAsianLayout[].class, "com.obric.memorydata.plugin");
    }

    public List<CTEastAsianLayout> getEastAsianLayoutList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$nOneLcaJ744oc_qrIJ6MwSEGI20(this), new $$Lambda$YT1iQDrO0J6QWErRcRpIiIxydx8(this), new $$Lambda$j1Yvinum8T9sMxnJUnmtO8idHFk(this), new $$Lambda$uGs0RgFKtzP7MU4KPHY2zVcYtvs(this), new $$Lambda$rqIF9DAMGjRDJ5EzI4KcKqZrvQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTextEffect getEffectArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        CTTextEffect r3 = (CTTextEffect) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[31], r4), CTTextEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CTTextEffect[] getEffectArray() {
        return (CTTextEffect[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[31], new CTTextEffect[0]), CTTextEffect[].class, "com.obric.memorydata.plugin");
    }

    public List<CTTextEffect> getEffectList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$yxcKrWqx3bNKKUk5sGubvPq7fEs(this), new $$Lambda$e8ZY4rBEyW4ZcYjv0lBj_F6uy8(this), new $$Lambda$wV1SUmoKlvTDB8EWwuYAJ1zWZM(this), new $$Lambda$lBS1qnaJ4rCgYeZd7UaVDTITjw(this), new $$Lambda$gnmGTCYtqfNu3ZoI9tmPeqWbGW0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ad getEmArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ad r3 = (ad) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[38], r4), ad.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ad[] getEmArray() {
        return (ad[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[38], new ad[0]), ad[].class, "com.obric.memorydata.plugin");
    }

    public List<ad> getEmList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$cVqRW71uVP1dkHa3ujhMJbBXna0(this), new $$Lambda$bUoQ5NBYBN9aDylpht7IvZKt8fI(this), new $$Lambda$5FKAwpk74bY3MJEAmfNLRycaiP4(this), new $$Lambda$tcmOSOk2Xs3PpRcTdIozUscBiB4(this), new $$Lambda$j07IxTldaVVlEvb5axqMnTxWA2s(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getEmbossArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getEmbossArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[16], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getEmbossList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$5JSPedmHX_EAddtsGOWOMvLfjM(this), new $$Lambda$EWIkHNVsX36MR6xBVb616OsoOk(this), new $$Lambda$yf8au0Pgx01ziKOK5jFO2G9Z60g(this), new $$Lambda$EFZZHwjEdoLfIHBCnYKa5tY8yY(this), new $$Lambda$6aXbtBd7Z1aMsPKOKi1F9HCqldw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ak getFitTextArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ak r3 = (ak) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[34], r4), ak.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ak[] getFitTextArray() {
        return (ak[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[34], new ak[0]), ak[].class, "com.obric.memorydata.plugin");
    }

    public List<ak> getFitTextList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$1luwI4SyaZ164_CNUZiQFuq2EP0(this), new $$Lambda$r5u8MGmX6s1L7zpR_QCHfS0A6RU(this), new $$Lambda$8rp9gjOkyqLfykv84rOEboiG_I(this), new $$Lambda$0G5y8ygHCamj0sl6_M9k8aSmcU(this), new $$Lambda$uRFj9LGVBsuebdiPhXFgnFWr4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ax getHighlightArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ax r3 = (ax) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[29], r4), ax.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ax[] getHighlightArray() {
        return (ax[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[29], new ax[0]), ax[].class, "com.obric.memorydata.plugin");
    }

    public List<ax> getHighlightList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$_NIuPsnT587tJicNoTSytKGOJw(this), new $$Lambda$poSIPShcToPKfwTO9kNzFQNDWEQ(this), new $$Lambda$aoTbKVRt4jxPYTYD48oR5qFAY0(this), new $$Lambda$n9wq11vnSen48a7_kP2X79pL9t4(this), new $$Lambda$gvCIZ9U0ioeI88ESJqCzt5m5YHM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getIArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getIArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public bu getICsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getICsArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getICsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Yx_E6tZGz5S1PDDZ8XYj_vWJPTo(this), new $$Lambda$LljXXp08_PPSTAQs243c7M0QVI(this), new $$Lambda$RQ4c8xNk7NeD8ibv1zx1anGts(this), new $$Lambda$ypTj4RTiIPBt7ztwf1w8HYcJVk(this), new $$Lambda$WSjxCJRyC27zsk6IS1jIEYKkx08(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<bu> getIList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$xXfXHQ1yZvAQJOAS218eBP59wzk(this), new $$Lambda$DfhkTMJVnUOXrZF1mHxAbqhQ0U(this), new $$Lambda$xwEe0zoS10dF1KW2StC1reYeriI(this), new $$Lambda$yZuFUmG2Zm8Ef9RM42aURkP45mk(this), new $$Lambda$UEyNS2g1kDL1livHXJLd2CXty80(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getImprintArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getImprintArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[17], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getImprintList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$gJjy7FbDDbYlrTPnsDyZK255g8(this), new $$Lambda$QgzWADGesMnJnAhmZpeZOls7gL0(this), new $$Lambda$peZjeblx9bipdZtGPoDwMfZ4gc(this), new $$Lambda$prMqo79kRN6OeMXgMrOGcUTX1LI(this), new $$Lambda$qG7g5A2mEQHVv3sX6tsMhFslMg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public fj getIns() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), fj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public ay getKernArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[25], r4), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ay[] getKernArray() {
        return (ay[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[25], new ay[0]), ay[].class, "com.obric.memorydata.plugin");
    }

    public List<ay> getKernList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$xM0cCmifi9TFS6dW81wuBppTHc(this), new $$Lambda$3quDwARHrsFHQ8eP3Jf37fNaNOk(this), new $$Lambda$EFBY0dEAY8w4ps6SkFn3nHktlRk(this), new $$Lambda$lDVKJirle_RCdJ18VD6d6zOdUI0(this), new $$Lambda$Oty_3U0qEiTtG7W8XBhlgcgvdpc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public be getLangArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        be r3 = (be) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[39], r4), be.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public be[] getLangArray() {
        return (be[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[39], new be[0]), be[].class, "com.obric.memorydata.plugin");
    }

    public List<be> getLangList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$78JdX0oUObqBNsTVPO2IJg2Vs(this), new $$Lambda$32fY6y03gMPaekCiiPZmUWcUWtg(this), new $$Lambda$n4CcEYtg9rpYJv8pOKpF6huokik(this), new $$Lambda$wTWcfFQn6Cmeetbe7tVfgINovic(this), new $$Lambda$mFcuv2aZsPvmxsxmkEKeNyPbRE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public fj getMoveFrom() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], 0), fj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public fj getMoveTo() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], 0), fj.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public bu getNoProofArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getNoProofArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[18], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getNoProofList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$issEUHkqHUCSKrJtduyNdleDcn8(this), new $$Lambda$CPDMv9udZOTaRtB8rRkbDETIyxc(this), new $$Lambda$XcDgRmQBzdE4QT9flHVcHRTAK7Y(this), new $$Lambda$Z5I0s6IyP2Aj_7LdxjQs0kYENH4(this), new $$Lambda$6_F309uvvjW7HVortYqQ6zOLelI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getOMathArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[42], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getOMathArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[42], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getOMathList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$nNhZDA4hK3f30J9LaP1d4zLcPVc(this), new $$Lambda$6b0Sf7EEtZnnYnoxWHnt2sx_YQ(this), new $$Lambda$w6kEdk9XaUUGjMKo0YzxD07hQ(this), new $$Lambda$pA2UKDSGIaeMnvlF3v37bU8qKmo(this), new $$Lambda$gzX8wd7ZWsli9NbEgz5qVXukGxw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getOutlineArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getOutlineArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[14], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getOutlineList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$3FBaCx4LABQWnVxQCxapXREU14(this), new $$Lambda$_6pEy5DpZp7h14kvsevVRdQvVc(this), new $$Lambda$ZstjWZ1BCBZehmuw9x8CquvwNrQ(this), new $$Lambda$85aJU39Kn1rKTDRYWIZQUorgFiI(this), new $$Lambda$S9F2oPunhgYjhILwaojCyp0sW4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public dv getPositionArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        dv r3 = (dv) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[26], r4), dv.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public dv[] getPositionArray() {
        return (dv[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[26], new dv[0]), dv[].class, "com.obric.memorydata.plugin");
    }

    public List<dv> getPositionList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$FLSLY5i_cFgIhOYP_M47IFt4XHE(this), new $$Lambda$meO6H33bmIVKZPi7dQOsp0w2pI(this), new $$Lambda$gQxOb7AiX0V1230B5LZMr41QE4(this), new $$Lambda$_aNJ42m8yqa2IiuNZ0vb02iOMPk(this), new $$Lambda$guWYnFS8ZCf70404w_iL2wiMfn0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public am getRFontsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        am r3 = (am) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), am.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public am[] getRFontsArray() {
        return (am[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new am[0]), am[].class, "com.obric.memorydata.plugin");
    }

    public List<am> getRFontsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$bxhJaOhnaWersGdqdG8zvniFn74(this), new $$Lambda$lpv45I2_oLuVbSByzNGRRWkV3g(this), new $$Lambda$Zyf1YkjXs9HBzzv_6orun3cTuJA(this), new $$Lambda$GI6z1XubRgVVed9CKJqZw9U6zzU(this), new $$Lambda$kP1oQOHVbHGVPYWDZA0A_BMf6Z8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public eb getRStyleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        eb r3 = (eb) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), eb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public eb[] getRStyleArray() {
        return (eb[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new eb[0]), eb[].class, "com.obric.memorydata.plugin");
    }

    public List<eb> getRStyleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$NmjDcrsleBR8CpwiD6QK3DiUQWI(this), new $$Lambda$nOSNTijWGwJBl1BvjP1DUdcl5k(this), new $$Lambda$YAU0Y_6U61JQuFzE2NHqHXpWlbQ(this), new $$Lambda$7maqqIX796iEem_YnyHG358LsSU(this), new $$Lambda$uAnTpxGgJIXU4zT5e6YNGjgkS8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getRtlArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[36], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getRtlArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[36], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getRtlList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$zJlbG8d_m2gfD0ETEWZjivaSU2I(this), new $$Lambda$HAI5T9t9RAsqFkE1vsYsRCvcnR4(this), new $$Lambda$mTFnCEd8WitkNi9Wno2kIcEdE(this), new $$Lambda$nzlgyLAI4RPmfqhsn01nG8ijbJI(this), new $$Lambda$BWcnrw7eVL3JmJUNjWn4jWqO5E(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getShadowArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getShadowArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[15], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getShadowList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$HzHRwG2aFuwfwkh522yL0QfvQLk(this), new $$Lambda$NVe6dqXs40RImgFzUeLIZ7NdCRo(this), new $$Lambda$oz4Moys4lqJEu7CU6N11jPiynyg(this), new $$Lambda$FfZtlBkyqLHHf4wPxpF9zjoSQts(this), new $$Lambda$etR8mDnGBZpnYPnKvN8bjhe8Oz4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public du getShdArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        du r3 = (du) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[33], r4), du.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public du[] getShdArray() {
        return (du[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[33], new du[0]), du[].class, "com.obric.memorydata.plugin");
    }

    public List<du> getShdList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$hr4XxW6HlBAwmMidWiiAu0lYvA(this), new $$Lambda$O9mlGMiksU96szfieR20wuvfKzk(this), new $$Lambda$6WiRMosYUSTDIq5QH7Qh8NQJM40(this), new $$Lambda$G6eG47pLAAHAo1SGqhCA7yGOluQ(this), new $$Lambda$Cs0uuPIsu2QTeNsD1t86QmpKkq4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getSmallCapsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getSmallCapsArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[11], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getSmallCapsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$EYu9wz0aCd5dAbmll9oC4gQP04(this), new $$Lambda$yj3R1NiFjEqvNX3x_s9wgpl_50E(this), new $$Lambda$jiZ535L11TkrXGi3k900iOpgn88(this), new $$Lambda$KL08005qijXcVMK3VybBT3B7Vs(this), new $$Lambda$7SuIoU2gG7a1p7wVX1Jcga5FC8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getSnapToGridArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getSnapToGridArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[19], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getSnapToGridList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Mo9NYijjVxr4XDdkRPJIvt8YXug(this), new $$Lambda$a6FwJajJo3V2SnWUbF8u0Bm5BJ0(this), new $$Lambda$svD4pqrkIh2b9AkOIBIkvexKJpQ(this), new $$Lambda$iIKBwnvZA9eGN59G_4UAhphvk(this), new $$Lambda$Ru0sLtmpW9_m04sZRzTaS51NEXA(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public dw getSpacingArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        dw r3 = (dw) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[23], r4), dw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public dw[] getSpacingArray() {
        return (dw[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[23], new dw[0]), dw[].class, "com.obric.memorydata.plugin");
    }

    public List<dw> getSpacingList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$jt1ivGvazfUucXEQN308Ucdwrxw(this), new $$Lambda$tJEyKFxIsy6pa2IVwwJ1kyWd3U(this), new $$Lambda$FJ95CKKiu9WryTQvJSWqCUNdSk(this), new $$Lambda$75ZebaofQt21nkREEAOTtOQk9s(this), new $$Lambda$Ip00KxL6vo_opzQiQ9XFymfColc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getSpecVanishArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[41], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getSpecVanishArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[41], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getSpecVanishList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$lADMMPRd9pySgAC8CtQzrmd_zhA(this), new $$Lambda$fdZNfFpa2LRBPAqZifO8byjDvP8(this), new $$Lambda$c__IdndyU9W48HGfFJC4QA51VrU(this), new $$Lambda$sykxS7FKO5lgjnaF19S5L9W5EU0(this), new $$Lambda$5sWGpkoOrKS5nQVp_h04fysz3pM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getStrikeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getStrikeArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[12], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getStrikeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$4HJbMzwIp1wU2zr8p1v0Qi0IQs(this), new $$Lambda$EFpc8iDyVmdL5Zl8DuVlBkk84(this), new $$Lambda$CQpXTqSrsvj_vzuoHIyLxtN08_0(this), new $$Lambda$WwjPXGgXsCzCseytVbiVIappayE(this), new $$Lambda$bxFmFlVVmjpRyHsPVpQk3x7OGHo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ay getSzArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[27], r4), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ay[] getSzArray() {
        return (ay[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[27], new ay[0]), ay[].class, "com.obric.memorydata.plugin");
    }

    public ay getSzCsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[28], r4), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ay[] getSzCsArray() {
        return (ay[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[28], new ay[0]), ay[].class, "com.obric.memorydata.plugin");
    }

    public List<ay> getSzCsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$BMfio4n_vAf2vsxxwXOwi1lXc(this), new $$Lambda$HQ7eErkBditQ277RrGJDx6LWMg(this), new $$Lambda$DNGATwZfGg9cb8T9TH4LNiPgs80(this), new $$Lambda$uBPD2AkKO3ENxC66hxwSVXIIK0(this), new $$Lambda$hol4jLPAJRT5WQQRvlKVvcW1nE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<ay> getSzList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$G1EZYtz7V1gtZxDaMi5INj_nXXU(this), new $$Lambda$wfLaOU7uXYUdR0hV2vKaw5885A(this), new $$Lambda$mrtbriVn_pn3hI_1BrPnyYLCyec(this), new $$Lambda$_ViA9A1OZOmpZyZhob_fY8x6wiM(this), new $$Lambda$pasFBaV0sKI6ktltrRmHHyyGNaE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public fl getUArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        fl r3 = (fl) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[30], r4), fl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public fl[] getUArray() {
        return (fl[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[30], new fl[0]), fl[].class, "com.obric.memorydata.plugin");
    }

    public List<fl> getUList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$u5ldMk3vmi_lslm3CsjUXPkHMTI(this), new $$Lambda$lL1J1IOxy4ZvvO6TnxSlhqeykKI(this), new $$Lambda$NKSoABQMaphJYWfU2mQMxA4tgp0(this), new $$Lambda$3sHpfW3dIfsCwL2AD37Qb_unVAM(this), new $$Lambda$5cP4Y_tCmisvRJA03imsgo6EaW8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getVanishArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[20], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getVanishArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[20], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getVanishList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$OMw5eGFrIN29j67Lo5E0anG_VWw(this), new $$Lambda$dLlbLyE7TlZPQLEYvoptd6xhjrw(this), new $$Lambda$aUxhX3WDwSlF2GfgadAG4dav4o(this), new $$Lambda$MVXJBsLUxnDOmQPEQsPGYh9OYg(this), new $$Lambda$dy2tw3PznNeWkPKbcysdO5D8II(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public fn getVertAlignArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        fn r3 = (fn) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[35], r4), fn.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public fn[] getVertAlignArray() {
        return (fn[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[35], new fn[0]), fn[].class, "com.obric.memorydata.plugin");
    }

    public List<fn> getVertAlignList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$8tyhQCJgTIXcjSowQ5kecchkSpI(this), new $$Lambda$iZVnkkzJQrNFZyo0K4YmFvCGaMc(this), new $$Lambda$X7PI3OJwtR_ep8jew7qIBVUak6U(this), new $$Lambda$h7uxK49rOi8Tnfyvwuf6Jkm6mso(this), new $$Lambda$MX2mM7c3RNLdgp94xK3Usip9GmE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ff getWArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ff r3 = (ff) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[24], r4), ff.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ff[] getWArray() {
        return (ff[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[24], new ff[0]), ff[].class, "com.obric.memorydata.plugin");
    }

    public List<ff> getWList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$2vox4aGVFoKSV85m0Zg4QtGN76k(this), new $$Lambda$duTL64pGVbg7VjHGVGJ74kwnFr4(this), new $$Lambda$j3L8Wc1pDcvadIVIwtE_D11ecC8(this), new $$Lambda$afBskOepPHetNN6XeXNHsahuNg(this), new $$Lambda$dacsICMJMCwFuiYkCvP7prMiSO0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getWebHiddenArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[21], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bu[] getWebHiddenArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[21], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getWebHiddenList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$hGNrsuh8QoSXgIMauFCShpfNCd8(this), new $$Lambda$1SJAKuaCu7XaMsWKAnCXHRdMEnc(this), new $$Lambda$TAzkcaEOPXzpQjvLhzawjQ9k0_Q(this), new $$Lambda$EIdfPY4p6nHDAMM5OnUEZb2yxm4(this), new $$Lambda$EfkWri6aUi7w7g9HJuRLgeAfv4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewB(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewBCs(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public i insertNewBdr(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        i r3 = (i) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[32], r4), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewCaps(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public n insertNewColor(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        n r3 = (n) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[22], r4), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewCs(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[37], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewDstrike(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTEastAsianLayout insertNewEastAsianLayout(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTEastAsianLayout r3 = (CTEastAsianLayout) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[40], r4), CTEastAsianLayout.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public CTTextEffect insertNewEffect(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        CTTextEffect r3 = (CTTextEffect) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[31], r4), CTTextEffect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ad insertNewEm(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ad r3 = (ad) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[38], r4), ad.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewEmboss(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[16], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ak insertNewFitText(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ak r3 = (ak) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[34], r4), ak.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ax insertNewHighlight(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ax r3 = (ax) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[29], r4), ax.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewI(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewICs(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewImprint(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[17], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay insertNewKern(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[25], r4), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public be insertNewLang(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        be r3 = (be) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[39], r4), be.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewNoProof(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[18], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewOMath(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[42], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewOutline(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public dv insertNewPosition(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        dv r3 = (dv) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[26], r4), dv.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public am insertNewRFonts(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        am r3 = (am) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), am.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public eb insertNewRStyle(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        eb r3 = (eb) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), eb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewRtl(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[36], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewShadow(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[15], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public du insertNewShd(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        du r3 = (du) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[33], r4), du.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewSmallCaps(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewSnapToGrid(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[19], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public dw insertNewSpacing(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        dw r3 = (dw) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[23], r4), dw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewSpecVanish(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[41], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewStrike(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay insertNewSz(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[27], r4), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ay insertNewSzCs(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ay r3 = (ay) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[28], r4), ay.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fl insertNewU(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fl r3 = (fl) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[30], r4), fl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewVanish(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[20], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fn insertNewVertAlign(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fn r3 = (fn) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[35], r4), fn.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ff insertNewW(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ff r3 = (ff) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[24], r4), ff.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewWebHidden(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bu r3 = (bu) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[21], r4), bu.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isSetDel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        boolean r2 = true;
        if (get_store().count_elements(PROPERTY_QNAME[1]) != 0) goto L8;
        r2 = false;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isSetIns() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        boolean r2 = false;
        if (get_store().count_elements(PROPERTY_QNAME[0]) == 0) goto L7;
        r2 = true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isSetMoveFrom() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[2]) == 0) goto L7;
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

    public boolean isSetMoveTo() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[3]) == 0) goto L7;
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

    public void removeB(int r4) {
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

    public void removeBCs(int r4) {
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

    public void removeBdr(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[32], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeCaps(int r4) {
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

    public void removeColor(int r4) {
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

    public void removeCs(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[37], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeDstrike(int r4) {
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

    public void removeEastAsianLayout(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[40], r4);     // Catch: Throwable -> L7
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
        get_store().remove_element(PROPERTY_QNAME[31], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeEm(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[38], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeEmboss(int r4) {
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

    public void removeFitText(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[34], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeHighlight(int r4) {
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

    public void removeI(int r4) {
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

    public void removeICs(int r4) {
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

    public void removeImprint(int r4) {
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

    public void removeKern(int r4) {
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

    public void removeLang(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[39], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeNoProof(int r4) {
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

    public void removeOMath(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[42], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeOutline(int r4) {
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

    public void removePosition(int r4) {
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

    public void removeRFonts(int r4) {
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

    public void removeRStyle(int r4) {
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

    public void removeRtl(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[36], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeShadow(int r4) {
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

    public void removeShd(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[33], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeSmallCaps(int r4) {
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

    public void removeSnapToGrid(int r4) {
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

    public void removeSpacing(int r4) {
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

    public void removeSpecVanish(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[41], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeStrike(int r4) {
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

    public void removeSz(int r4) {
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

    public void removeSzCs(int r4) {
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

    public void removeU(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[30], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeVanish(int r4) {
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

    public void removeVertAlign(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[35], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeW(int r4) {
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

    public void removeWebHidden(int r4) {
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

    public void setBArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
    }

    public void setBArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[6]);
    }

    public void setBCsArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
    }

    public void setBCsArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[7]);
    }

    public void setBdrArray(int r3, i r4) {
        generatedSetterHelperImpl((i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[32], r3, 2);
    }

    public void setBdrArray(i[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[32]);
    }

    public void setCapsArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
    }

    public void setCapsArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[10]);
    }

    public void setColorArray(int r3, n r4) {
        generatedSetterHelperImpl((n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[22], r3, 2);
    }

    public void setColorArray(n[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[22]);
    }

    public void setCsArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[37], r3, 2);
    }

    public void setCsArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[37]);
    }

    public void setDel(fj r4) {
        generatedSetterHelperImpl((fj) ZeusTransformUtils.wrapperContextForParams(r4, fj.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], 0, 1);
    }

    public void setDstrikeArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[13], r3, 2);
    }

    public void setDstrikeArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[13]);
    }

    public void setEastAsianLayoutArray(int r3, CTEastAsianLayout r4) {
        generatedSetterHelperImpl((CTEastAsianLayout) ZeusTransformUtils.wrapperContextForParams(r4, CTEastAsianLayout.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[40], r3, 2);
    }

    public void setEastAsianLayoutArray(CTEastAsianLayout[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[40]);
    }

    public void setEffectArray(int r3, CTTextEffect r4) {
        generatedSetterHelperImpl((CTTextEffect) ZeusTransformUtils.wrapperContextForParams(r4, CTTextEffect.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[31], r3, 2);
    }

    public void setEffectArray(CTTextEffect[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[31]);
    }

    public void setEmArray(int r3, ad r4) {
        generatedSetterHelperImpl((ad) ZeusTransformUtils.wrapperContextForParams(r4, ad.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[38], r3, 2);
    }

    public void setEmArray(ad[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[38]);
    }

    public void setEmbossArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[16], r3, 2);
    }

    public void setEmbossArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[16]);
    }

    public void setFitTextArray(int r3, ak r4) {
        generatedSetterHelperImpl((ak) ZeusTransformUtils.wrapperContextForParams(r4, ak.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[34], r3, 2);
    }

    public void setFitTextArray(ak[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[34]);
    }

    public void setHighlightArray(int r3, ax r4) {
        generatedSetterHelperImpl((ax) ZeusTransformUtils.wrapperContextForParams(r4, ax.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[29], r3, 2);
    }

    public void setHighlightArray(ax[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[29]);
    }

    public void setIArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
    }

    public void setIArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[8]);
    }

    public void setICsArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
    }

    public void setICsArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[9]);
    }

    public void setImprintArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[17], r3, 2);
    }

    public void setImprintArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[17]);
    }

    public void setIns(fj r4) {
        generatedSetterHelperImpl((fj) ZeusTransformUtils.wrapperContextForParams(r4, fj.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }

    public void setKernArray(int r3, ay r4) {
        generatedSetterHelperImpl((ay) ZeusTransformUtils.wrapperContextForParams(r4, ay.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[25], r3, 2);
    }

    public void setKernArray(ay[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[25]);
    }

    public void setLangArray(int r3, be r4) {
        generatedSetterHelperImpl((be) ZeusTransformUtils.wrapperContextForParams(r4, be.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[39], r3, 2);
    }

    public void setLangArray(be[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[39]);
    }

    public void setMoveFrom(fj r4) {
        generatedSetterHelperImpl((fj) ZeusTransformUtils.wrapperContextForParams(r4, fj.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], 0, 1);
    }

    public void setMoveTo(fj r4) {
        generatedSetterHelperImpl((fj) ZeusTransformUtils.wrapperContextForParams(r4, fj.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], 0, 1);
    }

    public void setNoProofArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[18], r3, 2);
    }

    public void setNoProofArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[18]);
    }

    public void setOMathArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[42], r3, 2);
    }

    public void setOMathArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[42]);
    }

    public void setOutlineArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[14], r3, 2);
    }

    public void setOutlineArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[14]);
    }

    public void setPositionArray(int r3, dv r4) {
        generatedSetterHelperImpl((dv) ZeusTransformUtils.wrapperContextForParams(r4, dv.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[26], r3, 2);
    }

    public void setPositionArray(dv[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[26]);
    }

    public void setRFontsArray(int r3, am r4) {
        generatedSetterHelperImpl((am) ZeusTransformUtils.wrapperContextForParams(r4, am.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
    }

    public void setRFontsArray(am[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[5]);
    }

    public void setRStyleArray(int r3, eb r4) {
        generatedSetterHelperImpl((eb) ZeusTransformUtils.wrapperContextForParams(r4, eb.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
    }

    public void setRStyleArray(eb[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[4]);
    }

    public void setRtlArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[36], r3, 2);
    }

    public void setRtlArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[36]);
    }

    public void setShadowArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[15], r3, 2);
    }

    public void setShadowArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[15]);
    }

    public void setShdArray(int r3, du r4) {
        generatedSetterHelperImpl((du) ZeusTransformUtils.wrapperContextForParams(r4, du.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[33], r3, 2);
    }

    public void setShdArray(du[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[33]);
    }

    public void setSmallCapsArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[11], r3, 2);
    }

    public void setSmallCapsArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[11]);
    }

    public void setSnapToGridArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[19], r3, 2);
    }

    public void setSnapToGridArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[19]);
    }

    public void setSpacingArray(int r3, dw r4) {
        generatedSetterHelperImpl((dw) ZeusTransformUtils.wrapperContextForParams(r4, dw.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[23], r3, 2);
    }

    public void setSpacingArray(dw[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[23]);
    }

    public void setSpecVanishArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[41], r3, 2);
    }

    public void setSpecVanishArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[41]);
    }

    public void setStrikeArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[12], r3, 2);
    }

    public void setStrikeArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[12]);
    }

    public void setSzArray(int r3, ay r4) {
        generatedSetterHelperImpl((ay) ZeusTransformUtils.wrapperContextForParams(r4, ay.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[27], r3, 2);
    }

    public void setSzArray(ay[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[27]);
    }

    public void setSzCsArray(int r3, ay r4) {
        generatedSetterHelperImpl((ay) ZeusTransformUtils.wrapperContextForParams(r4, ay.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[28], r3, 2);
    }

    public void setSzCsArray(ay[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[28]);
    }

    public void setUArray(int r3, fl r4) {
        generatedSetterHelperImpl((fl) ZeusTransformUtils.wrapperContextForParams(r4, fl.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[30], r3, 2);
    }

    public void setUArray(fl[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[30]);
    }

    public void setVanishArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[20], r3, 2);
    }

    public void setVanishArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[20]);
    }

    public void setVertAlignArray(int r3, fn r4) {
        generatedSetterHelperImpl((fn) ZeusTransformUtils.wrapperContextForParams(r4, fn.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[35], r3, 2);
    }

    public void setVertAlignArray(fn[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[35]);
    }

    public void setWArray(int r3, ff r4) {
        generatedSetterHelperImpl((ff) ZeusTransformUtils.wrapperContextForParams(r4, ff.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[24], r3, 2);
    }

    public void setWArray(ff[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[24]);
    }

    public void setWebHiddenArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[21], r3, 2);
    }

    public void setWebHiddenArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[21]);
    }

    public int sizeOfBArray() {
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

    public int sizeOfBCsArray() {
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

    public int sizeOfBdrArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[32]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfCapsArray() {
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

    public int sizeOfColorArray() {
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

    public int sizeOfCsArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[37]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfDstrikeArray() {
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

    public int sizeOfEastAsianLayoutArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[40]);     // Catch: Throwable -> L7
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
        int r3 = get_store().count_elements(PROPERTY_QNAME[31]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfEmArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[38]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfEmbossArray() {
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

    public int sizeOfFitTextArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[34]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfHighlightArray() {
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

    public int sizeOfIArray() {
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

    public int sizeOfICsArray() {
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

    public int sizeOfImprintArray() {
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

    public int sizeOfKernArray() {
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

    public int sizeOfLangArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[39]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfNoProofArray() {
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

    public int sizeOfOMathArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[42]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfOutlineArray() {
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

    public int sizeOfPositionArray() {
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

    public int sizeOfRFontsArray() {
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

    public int sizeOfRStyleArray() {
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

    public int sizeOfRtlArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[36]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfShadowArray() {
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

    public int sizeOfShdArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[33]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfSmallCapsArray() {
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

    public int sizeOfSnapToGridArray() {
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

    public int sizeOfSpacingArray() {
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

    public int sizeOfSpecVanishArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[41]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfStrikeArray() {
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

    public int sizeOfSzArray() {
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

    public int sizeOfSzCsArray() {
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

    public int sizeOfUArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[30]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfVanishArray() {
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

    public int sizeOfVertAlignArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[35]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfWArray() {
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

    public int sizeOfWebHiddenArray() {
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

    public void unsetDel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[1], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetIns() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[0], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetMoveFrom() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[2], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetMoveTo() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[3], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
