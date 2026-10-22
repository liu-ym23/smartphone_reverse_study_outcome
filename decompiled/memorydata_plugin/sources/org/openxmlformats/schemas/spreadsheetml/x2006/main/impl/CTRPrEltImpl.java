package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ac;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ca;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cb;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cc;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cm;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dx;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.e;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fg;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fh;

/* JADX INFO: loaded from: classes8.dex */
public class CTRPrEltImpl extends XmlComplexContentImpl implements dx {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rFont"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "charset"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "family"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "i"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "strike"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "outline"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "shadow"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "condense"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", CozeCloudExt.API_KEY_CLOUD_EXTEND_MAP), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", TypedValues.Custom.S_COLOR), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sz"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "u"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "vertAlign"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "scheme")};
    }

    public CTRPrEltImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public e addNewB() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public cm addNewCharset() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cm r3 = (cm) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), cm.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public ac addNewColor() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ac r3 = (ac) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), ac.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public e addNewCondense() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public e addNewExtend() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public cm addNewFamily() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cm r3 = (cm) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), cm.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public e addNewI() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public e addNewOutline() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public ca addNewRFont() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ca r3 = (ca) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public cb addNewScheme() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cb r3 = (cb) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), cb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public e addNewShadow() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public e addNewStrike() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public cc addNewSz() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cc r3 = (cc) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), cc.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public fg addNewU() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fg r3 = (fg) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), fg.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public fh addNewVertAlign() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fh r3 = (fh) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), fh.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public e getBArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public e[] getBArray() {
        return (e[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new e[0]), e[].class, "com.obric.memorydata.plugin");
    }

    public List<e> getBList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$7_VVaC_NElRKyujpk7fk74TcLoA(this), new $$Lambda$Gi06Bn83rJQenUVMLBdtRTkLxMk(this), new $$Lambda$VGffx9kp2rQgdKIdWDmBwGxOU6E(this), new $$Lambda$0OzBFeXSqVAuSljZNMuMJQXxSD8(this), new $$Lambda$iousyaW_Uv7Q6XdTY8SbQds1HUM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public cm getCharsetArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        cm r3 = (cm) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), cm.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public cm[] getCharsetArray() {
        return (cm[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new cm[0]), cm[].class, "com.obric.memorydata.plugin");
    }

    public List<cm> getCharsetList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$5rjlaSNBGiC8WlyqDhyPnRx63PA(this), new $$Lambda$YgoJ8PBimhyF69yVn67urv6oSFQ(this), new $$Lambda$6RI9oi8Knzke9PCI7XPRkKxSdJE(this), new $$Lambda$2j4xyZLBiPJbEC3RJslyrt1wg2U(this), new $$Lambda$WiF56rBufR0hWb5SGT0m3PmSw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ac getColorArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ac r3 = (ac) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), ac.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ac[] getColorArray() {
        return (ac[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new ac[0]), ac[].class, "com.obric.memorydata.plugin");
    }

    public List<ac> getColorList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$nNdZ9Ra8IqJRRTJNSuOpVxOxeU(this), new $$Lambda$YBtjW_YYajyZhdGc8o2Sn5OXLpw(this), new $$Lambda$_qkEDSPkpyyQjvCtYcsvYMkidY(this), new $$Lambda$jBngpDTIGtf8rmNAFB5Aiz1g6E(this), new $$Lambda$iaqsK9O_ISptoMTgsKnaRBtaT0Q(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public e getCondenseArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public e[] getCondenseArray() {
        return (e[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new e[0]), e[].class, "com.obric.memorydata.plugin");
    }

    public List<e> getCondenseList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$DWhHtUWDDejWrMtK3rQQV5mJV3s(this), new $$Lambda$nFvA4Fueb0jU0fGhCeokvowlEK8(this), new $$Lambda$kl_WrvwLOvvnD0fFUkmmTT_o4(this), new $$Lambda$5KYF0PiVQVo3OGBnplfxFLYgHKg(this), new $$Lambda$Nx76q1MSPLfJ6iWE8sJtr4EDK7A(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public e getExtendArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public e[] getExtendArray() {
        return (e[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new e[0]), e[].class, "com.obric.memorydata.plugin");
    }

    public List<e> getExtendList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$iz3F_q8Ex6014FJyGkYrQj7ZTY(this), new $$Lambda$TNaiHPnMuXGmx9ojiYOYkn2Xfg(this), new $$Lambda$NWRXM6edarmyTtzHUCMkniZQUXE(this), new $$Lambda$4bygXwAXxzLkopd7fJLdrKXK1EA(this), new $$Lambda$dnIME12T9MaIkS7vUXHfuYAIS84(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public cm getFamilyArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        cm r3 = (cm) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), cm.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public cm[] getFamilyArray() {
        return (cm[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new cm[0]), cm[].class, "com.obric.memorydata.plugin");
    }

    public List<cm> getFamilyList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ElZpVhNvFdN04VvGyyCe6DoeMU(this), new $$Lambda$1Dr5aK4LfyuCl6yNqgXJSKJMn2Y(this), new $$Lambda$RVJW9gnveHnSq_PH9BM7cgRXaK4(this), new $$Lambda$eY537n0DkHIgDIiB5kzX8sYBVG0(this), new $$Lambda$pCNaiqES5OYj6SBKuz2oisVi9kM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public e getIArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public e[] getIArray() {
        return (e[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new e[0]), e[].class, "com.obric.memorydata.plugin");
    }

    public List<e> getIList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$__laSbsXfA4CAy1gb6XLQM5O8MY(this), new $$Lambda$fsDglJaJVsf4SK9E9jySVupJgYI(this), new $$Lambda$S6n2SPbLAkVQlVYKZdirAbhGLqA(this), new $$Lambda$a3ERETLoWUTZs4v0b_RDTGuEocI(this), new $$Lambda$f9sRPfdzaB5XluIgbiWek1GHySo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public e getOutlineArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public e[] getOutlineArray() {
        return (e[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new e[0]), e[].class, "com.obric.memorydata.plugin");
    }

    public List<e> getOutlineList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$jsbrX9sy_dvK0M2N8XKWOdx_foU(this), new $$Lambda$xyoAhcjl60BCo4jCsZNa3dXsW8I(this), new $$Lambda$TzTZJ4tm9pP9eM3xBogFgPHkLAw(this), new $$Lambda$_kbaszPDtgj5ZzpHzp1q1HX_4(this), new $$Lambda$ncgKCTjahYLdTg0Rc5koqwF8mmY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public ca getRFontArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ca r3 = (ca) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ca[] getRFontArray() {
        return (ca[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new ca[0]), ca[].class, "com.obric.memorydata.plugin");
    }

    public List<ca> getRFontList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$KUz6vj0jiols3qmQeDKvzOOas(this), new $$Lambda$i7e5E5K6ms1I7C48otIVkTbc7Jc(this), new $$Lambda$r3CUPFNzk93cb5O3jMrP0BndtkM(this), new $$Lambda$GaoOG6JkVZq4fjquL22m6nCkzDc(this), new $$Lambda$zlqs4fuQZJ6wXaTPvmxCTKvN9Q(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public cb getSchemeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        cb r3 = (cb) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), cb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public cb[] getSchemeArray() {
        return (cb[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[14], new cb[0]), cb[].class, "com.obric.memorydata.plugin");
    }

    public List<cb> getSchemeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ibGzILTbrveCe7hR47ppxJrxNJY(this), new $$Lambda$b7e86TACyc1f53FF81yLrv2AC8E(this), new $$Lambda$vWOfWBWm4P0rmWSvGbGHDz_1U(this), new $$Lambda$Avdh9GFIXpd4C_IIrNEYpBfI3uQ(this), new $$Lambda$5TmaoQqu2s1edT6bIMfsRJ5dOUY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public e getShadowArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public e[] getShadowArray() {
        return (e[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new e[0]), e[].class, "com.obric.memorydata.plugin");
    }

    public List<e> getShadowList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$RmvzyNBPuRz98WQwaMPAaXFYu4(this), new $$Lambda$oOZZKNKxSo07y0RUbNumrKaCGs(this), new $$Lambda$RETGWMsVl1vS5OhsNDYIzhlQWzk(this), new $$Lambda$r5RjFOn9bR2AACfPfa_vRHufx4(this), new $$Lambda$jM5UGcP4dqBNm8d5yxzsy5e9N4g(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public e getStrikeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public e[] getStrikeArray() {
        return (e[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new e[0]), e[].class, "com.obric.memorydata.plugin");
    }

    public List<e> getStrikeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$flhEri5Lbx3vOVqAnTBgCOZOk(this), new $$Lambda$d9fGgawRVdFDwsufm9b0xh56aEs(this), new $$Lambda$IB1BD95CnCBmUY0QEjeGp7pIkd4(this), new $$Lambda$iFvhdH8NQC_uttru6CAVLSuss(this), new $$Lambda$O9PKev2jOdQbxNLRG7nKIplji4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public cc getSzArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        cc r3 = (cc) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), cc.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public cc[] getSzArray() {
        return (cc[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[11], new cc[0]), cc[].class, "com.obric.memorydata.plugin");
    }

    public List<cc> getSzList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$pcM8VkBwI1jYUHOhCLL_wxyt1kw(this), new $$Lambda$srrGp0SPOLBvFb9aQ373nR9wQk(this), new $$Lambda$DAOKS_h8UwJSsIltmflQCs2zKFs(this), new $$Lambda$VV37da38LUhWK6TSZRjd2wmeRE(this), new $$Lambda$TGT5nxqruShCS9JEPpat_pWbKUo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public fg getUArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        fg r3 = (fg) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), fg.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public fg[] getUArray() {
        return (fg[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[12], new fg[0]), fg[].class, "com.obric.memorydata.plugin");
    }

    public List<fg> getUList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$PF_nhy4ch_u2jyD6jRavbion_g(this), new $$Lambda$bLdcd14k5e8wVGFUWSJvMxp8gQ0(this), new $$Lambda$FCtn80nzB1dIogrfLqT6jQaywCI(this), new $$Lambda$4UHKFamxuM_wswERGwhlmfMQVDk(this), new $$Lambda$E4ZOxSh51ex5Bz1S2eLRIEy7dMo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public fh getVertAlignArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        fh r3 = (fh) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), fh.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public fh[] getVertAlignArray() {
        return (fh[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[13], new fh[0]), fh[].class, "com.obric.memorydata.plugin");
    }

    public List<fh> getVertAlignList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$uY2uklyDstTHw17LAXc9dYUG198(this), new $$Lambda$POs0jg9iv0OUxtX7NVKlW3ta1k(this), new $$Lambda$9giHkhx5bmyGnKofkzsUfXBgsH8(this), new $$Lambda$XDFr9U8OpIKXuu8Xdm3mfcGU4Y(this), new $$Lambda$ZcbcmwqnxixmGF2crE_wsde01U(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public e insertNewB(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public cm insertNewCharset(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cm r3 = (cm) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), cm.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ac insertNewColor(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ac r3 = (ac) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), ac.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public e insertNewCondense(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public e insertNewExtend(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public cm insertNewFamily(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cm r3 = (cm) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), cm.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public e insertNewI(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public e insertNewOutline(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ca insertNewRFont(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ca r3 = (ca) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public cb insertNewScheme(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cb r3 = (cb) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), cb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public e insertNewShadow(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public e insertNewStrike(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        e r3 = (e) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public cc insertNewSz(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        cc r3 = (cc) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), cc.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fg insertNewU(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fg r3 = (fg) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), fg.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public fh insertNewVertAlign(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        fh r3 = (fh) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), fh.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeB(int r4) {
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

    public void removeCharset(int r4) {
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

    public void removeColor(int r4) {
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

    public void removeCondense(int r4) {
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

    public void removeExtend(int r4) {
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

    public void removeFamily(int r4) {
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

    public void removeI(int r4) {
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

    public void removeOutline(int r4) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public void removeRFont(int r4) {
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

    public void removeScheme(int r4) {
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

    public void removeShadow(int r4) {
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

    public void removeStrike(int r4) {
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

    public void removeSz(int r4) {
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

    public void removeU(int r4) {
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

    public void removeVertAlign(int r4) {
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

    public void setBArray(int r3, e r4) {
        generatedSetterHelperImpl((e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
    }

    public void setBArray(e[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[3]);
    }

    public void setCharsetArray(int r3, cm r4) {
        generatedSetterHelperImpl((cm) ZeusTransformUtils.wrapperContextForParams(r4, cm.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
    }

    public void setCharsetArray(cm[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[1]);
    }

    public void setColorArray(int r3, ac r4) {
        generatedSetterHelperImpl((ac) ZeusTransformUtils.wrapperContextForParams(r4, ac.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
    }

    public void setColorArray(ac[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[10]);
    }

    public void setCondenseArray(int r3, e r4) {
        generatedSetterHelperImpl((e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
    }

    public void setCondenseArray(e[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[8]);
    }

    public void setExtendArray(int r3, e r4) {
        generatedSetterHelperImpl((e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
    }

    public void setExtendArray(e[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[9]);
    }

    public void setFamilyArray(int r3, cm r4) {
        generatedSetterHelperImpl((cm) ZeusTransformUtils.wrapperContextForParams(r4, cm.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
    }

    public void setFamilyArray(cm[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[2]);
    }

    public void setIArray(int r3, e r4) {
        generatedSetterHelperImpl((e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
    }

    public void setIArray(e[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[4]);
    }

    public void setOutlineArray(int r3, e r4) {
        generatedSetterHelperImpl((e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
    }

    public void setOutlineArray(e[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[6]);
    }

    public void setRFontArray(int r3, ca r4) {
        generatedSetterHelperImpl((ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    public void setRFontArray(ca[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    public void setSchemeArray(int r3, cb r4) {
        generatedSetterHelperImpl((cb) ZeusTransformUtils.wrapperContextForParams(r4, cb.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[14], r3, 2);
    }

    public void setSchemeArray(cb[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[14]);
    }

    public void setShadowArray(int r3, e r4) {
        generatedSetterHelperImpl((e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
    }

    public void setShadowArray(e[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[7]);
    }

    public void setStrikeArray(int r3, e r4) {
        generatedSetterHelperImpl((e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
    }

    public void setStrikeArray(e[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[5]);
    }

    public void setSzArray(int r3, cc r4) {
        generatedSetterHelperImpl((cc) ZeusTransformUtils.wrapperContextForParams(r4, cc.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[11], r3, 2);
    }

    public void setSzArray(cc[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[11]);
    }

    public void setUArray(int r3, fg r4) {
        generatedSetterHelperImpl((fg) ZeusTransformUtils.wrapperContextForParams(r4, fg.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[12], r3, 2);
    }

    public void setUArray(fg[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[12]);
    }

    public void setVertAlignArray(int r3, fh r4) {
        generatedSetterHelperImpl((fh) ZeusTransformUtils.wrapperContextForParams(r4, fh.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[13], r3, 2);
    }

    public void setVertAlignArray(fh[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[13]);
    }

    public int sizeOfBArray() {
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

    public int sizeOfCharsetArray() {
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

    public int sizeOfColorArray() {
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

    public int sizeOfCondenseArray() {
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

    public int sizeOfExtendArray() {
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

    public int sizeOfFamilyArray() {
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

    public int sizeOfIArray() {
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

    public int sizeOfOutlineArray() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.dx
    public int sizeOfRFontArray() {
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

    public int sizeOfSchemeArray() {
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

    public int sizeOfShadowArray() {
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

    public int sizeOfStrikeArray() {
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

    public int sizeOfSzArray() {
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

    public int sizeOfUArray() {
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

    public int sizeOfVertAlignArray() {
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
}
