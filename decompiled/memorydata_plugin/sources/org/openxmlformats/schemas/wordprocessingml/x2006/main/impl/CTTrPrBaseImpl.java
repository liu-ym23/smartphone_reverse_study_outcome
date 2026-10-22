package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.aw;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bu;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ev;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fi;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.m;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.u;

/* JADX INFO: loaded from: classes8.dex */
public class CTTrPrBaseImpl extends XmlComplexContentImpl implements fi {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "divId"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridBefore"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridAfter"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wBefore"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wAfter"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cantSplit"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trHeight"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblHeader"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hidden")};
    }

    public CTTrPrBaseImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public bu addNewCantSplit() {
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

    public m addNewCnfStyle() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        m r3 = (m) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public u addNewDivId() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public u addNewGridAfter() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public u addNewGridBefore() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewHidden() {
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

    public bc addNewJc() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bc r3 = (bc) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), bc.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ev addNewTblCellSpacing() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu addNewTblHeader() {
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

    public aw addNewTrHeight() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        aw r3 = (aw) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), aw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ev addNewWAfter() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ev addNewWBefore() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getCantSplitArray(int r4) {
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

    public bu[] getCantSplitArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[6], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getCantSplitList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Wt6SUvqcyvIK3bbyJ0ZR45Dacqc(this), new $$Lambda$sW21mPTjs3E29eLfS9Bp7LiO__o(this), new $$Lambda$qBMIDOmiIZukLt7WU1duDgKr60(this), new $$Lambda$1JVWfMnI1izAavgBtmi0bYhs7Ao(this), new $$Lambda$QgoBnjyxcI6R0k4z334tJxWOGFg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public m getCnfStyleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        m r3 = (m) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public m[] getCnfStyleArray() {
        return (m[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new m[0]), m[].class, "com.obric.memorydata.plugin");
    }

    public List<m> getCnfStyleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$S5M4D97CEukUFLL6o8jOj4s0eIM(this), new $$Lambda$XBR2DF8CjQmtrO7A0cR8viSP7Hg(this), new $$Lambda$0UHymGtHrSTWvDAmQUQnEjpUac(this), new $$Lambda$qiRlM0Zd29893RKoPAq9VEKZ8Qc(this), new $$Lambda$FMr3irmLrpZLaiJT5_77MlqqojM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public u getDivIdArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public u[] getDivIdArray() {
        return (u[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new u[0]), u[].class, "com.obric.memorydata.plugin");
    }

    public List<u> getDivIdList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$FQki8vANFZg6ITf3kC11hzmVKhE(this), new $$Lambda$yfcjky02aOIPrWh8xaMdesNyYA(this), new $$Lambda$Jvr6Lvk8NArPrR9la_DmMNIE04c(this), new $$Lambda$oLpJiGtNxO4RrFygvqEMnwoAEw(this), new $$Lambda$zHbzu9wvZ7ge4kyAAtTCYh6eV8A(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public u getGridAfterArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public u[] getGridAfterArray() {
        return (u[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new u[0]), u[].class, "com.obric.memorydata.plugin");
    }

    public List<u> getGridAfterList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$5zL5uawXFViOMTkDy0GLl3vA2Bo(this), new $$Lambda$a4_x9BgnknR0OyEodrRFLx3s33g(this), new $$Lambda$ffhpM0mJqfrrYA8KyDApqvqr1U(this), new $$Lambda$SWUlRvbMjuYWJU2qyUbgTbRD0vs(this), new $$Lambda$sv4QUsuRXga1JvhG3C0aHL8MKJE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public u getGridBeforeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public u[] getGridBeforeArray() {
        return (u[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new u[0]), u[].class, "com.obric.memorydata.plugin");
    }

    public List<u> getGridBeforeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$lR5414_8V1dJ9ZbHmHYBlyWfkNs(this), new $$Lambda$e8lGWHwUWIORVK3jD9mwInU8x8g(this), new $$Lambda$42E960E5_Nxug3JlAK0UZc9X7fc(this), new $$Lambda$BEZt9EthaFfSPfdNr7HrU7lLY_4(this), new $$Lambda$pbU0EPfVwxhekDNuTdtebvpVv3k(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getHiddenArray(int r4) {
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

    public bu[] getHiddenArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[11], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getHiddenList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$e0e37yn6tDqxRAOcaNSqCcJuE0(this), new $$Lambda$N6H1BsoywQcI8LKo7othMh2OGOU(this), new $$Lambda$xv7zRO5SF9DkhskreGp7TFim8Y8(this), new $$Lambda$QUyaty7ZLMBpZxHVmHQEE_yx8s(this), new $$Lambda$12yk7KSwq2X7DN2e3eUDFAaQAJM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bc getJcArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        bc r3 = (bc) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), bc.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public bc[] getJcArray() {
        return (bc[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[10], new bc[0]), bc[].class, "com.obric.memorydata.plugin");
    }

    public List<bc> getJcList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Jj5SRuC5lcpikL07U2hF3WY3cM(this), new $$Lambda$S6zauIUUZ8CR8SdISadIL57fvT8(this), new $$Lambda$SRJZu9upCoJT719YZZc2v9paBRA(this), new $$Lambda$HE9B9JtBOPnOwJmqeNsLLZ3ugQ(this), new $$Lambda$U4hy4JnKAv2vXzmbzzrCdZVpjk0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ev getTblCellSpacingArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ev[] getTblCellSpacingArray() {
        return (ev[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[9], new ev[0]), ev[].class, "com.obric.memorydata.plugin");
    }

    public List<ev> getTblCellSpacingList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$w4FPJFcVbU7WPYgV_zDEECz4R8U(this), new $$Lambda$ee4NOstPG_4iGvXzn15mMoPRBzM(this), new $$Lambda$HVypGmMvESSPfMeBtYHbVXfeQB4(this), new $$Lambda$ltKzlfvBvj_dIFM7OcF9wHItlkI(this), new $$Lambda$_gkGcOCOkJvpNE8TutRQGBQXvcI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu getTblHeaderArray(int r4) {
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

    public bu[] getTblHeaderArray() {
        return (bu[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[8], new bu[0]), bu[].class, "com.obric.memorydata.plugin");
    }

    public List<bu> getTblHeaderList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$qbjE4WTygjqNP7QhxGx5l6XtZvk(this), new $$Lambda$gKdJCfD8e9hHTt0gu0EjPxLE1SI(this), new $$Lambda$g8MRUggqbmhPKxumLcjxD3SaCwc(this), new $$Lambda$cDnr1toAGAAETzbsaoCPGrgJTQM(this), new $$Lambda$gY6jsRcoDntG39jRkgMZiITsszk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public aw getTrHeightArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        aw r3 = (aw) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), aw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public aw[] getTrHeightArray() {
        return (aw[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[7], new aw[0]), aw[].class, "com.obric.memorydata.plugin");
    }

    public List<aw> getTrHeightList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$MCLICDKEv6tXTpazvqs150E5t0(this), new $$Lambda$0nDxy8HAy8YGy1wTjUkuaxCxadY(this), new $$Lambda$vwoRQme_Nncaxhb4ux9HU9xHYGU(this), new $$Lambda$BC4ifhCfyYTypbjOBL0TdD535g(this), new $$Lambda$dlzJBXdLViW_T3_eQcjy_PwU8pE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ev getWAfterArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ev[] getWAfterArray() {
        return (ev[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[5], new ev[0]), ev[].class, "com.obric.memorydata.plugin");
    }

    public List<ev> getWAfterList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$SiCQoMCw2lhencfpmyB0zSA_oXg(this), new $$Lambda$gOYezL5U2dmV3jlM3ZeCq8gzqqs(this), new $$Lambda$ZBp3wu3n45zJb1DdK4_er6qAuU(this), new $$Lambda$XAC9MPHjjhZ1XpAZb4yBxuBt_vU(this), new $$Lambda$rCo3UwxaWs79MjaefazykGwtQHs(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public ev getWBeforeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public ev[] getWBeforeArray() {
        return (ev[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[4], new ev[0]), ev[].class, "com.obric.memorydata.plugin");
    }

    public List<ev> getWBeforeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ZGYiydUo7pAqoyIRrtXZzn73i5U(this), new $$Lambda$dRqoxfkTb5izaKVAuXnXmfBrPPI(this), new $$Lambda$QbGMs7guTB69xhqJsJBiLaCh008(this), new $$Lambda$7v2pclLwEeSEpW1USADBjn5W2to(this), new $$Lambda$iePX6ym0XWzGgglRlOMFiDNhjE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewCantSplit(int r4) {
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

    public m insertNewCnfStyle(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        m r3 = (m) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public u insertNewDivId(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public u insertNewGridAfter(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public u insertNewGridBefore(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        u r3 = (u) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewHidden(int r4) {
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

    public bc insertNewJc(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        bc r3 = (bc) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), bc.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ev insertNewTblCellSpacing(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public bu insertNewTblHeader(int r4) {
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

    public aw insertNewTrHeight(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        aw r3 = (aw) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), aw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ev insertNewWAfter(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ev insertNewWBefore(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ev r3 = (ev) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), ev.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeCantSplit(int r4) {
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

    public void removeCnfStyle(int r4) {
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

    public void removeDivId(int r4) {
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

    public void removeGridAfter(int r4) {
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

    public void removeGridBefore(int r4) {
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

    public void removeHidden(int r4) {
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

    public void removeJc(int r4) {
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

    public void removeTblCellSpacing(int r4) {
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

    public void removeTblHeader(int r4) {
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

    public void removeTrHeight(int r4) {
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

    public void removeWAfter(int r4) {
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

    public void removeWBefore(int r4) {
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

    public void setCantSplitArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], r3, 2);
    }

    public void setCantSplitArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[6]);
    }

    public void setCnfStyleArray(int r3, m r4) {
        generatedSetterHelperImpl((m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    public void setCnfStyleArray(m[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    public void setDivIdArray(int r3, u r4) {
        generatedSetterHelperImpl((u) ZeusTransformUtils.wrapperContextForParams(r4, u.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
    }

    public void setDivIdArray(u[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[1]);
    }

    public void setGridAfterArray(int r3, u r4) {
        generatedSetterHelperImpl((u) ZeusTransformUtils.wrapperContextForParams(r4, u.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
    }

    public void setGridAfterArray(u[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[3]);
    }

    public void setGridBeforeArray(int r3, u r4) {
        generatedSetterHelperImpl((u) ZeusTransformUtils.wrapperContextForParams(r4, u.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
    }

    public void setGridBeforeArray(u[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[2]);
    }

    public void setHiddenArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[11], r3, 2);
    }

    public void setHiddenArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[11]);
    }

    public void setJcArray(int r3, bc r4) {
        generatedSetterHelperImpl((bc) ZeusTransformUtils.wrapperContextForParams(r4, bc.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[10], r3, 2);
    }

    public void setJcArray(bc[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[10]);
    }

    public void setTblCellSpacingArray(int r3, ev r4) {
        generatedSetterHelperImpl((ev) ZeusTransformUtils.wrapperContextForParams(r4, ev.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[9], r3, 2);
    }

    public void setTblCellSpacingArray(ev[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[9]);
    }

    public void setTblHeaderArray(int r3, bu r4) {
        generatedSetterHelperImpl((bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[8], r3, 2);
    }

    public void setTblHeaderArray(bu[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[8]);
    }

    public void setTrHeightArray(int r3, aw r4) {
        generatedSetterHelperImpl((aw) ZeusTransformUtils.wrapperContextForParams(r4, aw.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], r3, 2);
    }

    public void setTrHeightArray(aw[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[7]);
    }

    public void setWAfterArray(int r3, ev r4) {
        generatedSetterHelperImpl((ev) ZeusTransformUtils.wrapperContextForParams(r4, ev.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
    }

    public void setWAfterArray(ev[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[5]);
    }

    public void setWBeforeArray(int r3, ev r4) {
        generatedSetterHelperImpl((ev) ZeusTransformUtils.wrapperContextForParams(r4, ev.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
    }

    public void setWBeforeArray(ev[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[4]);
    }

    public int sizeOfCantSplitArray() {
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

    public int sizeOfCnfStyleArray() {
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

    public int sizeOfDivIdArray() {
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

    public int sizeOfGridAfterArray() {
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

    public int sizeOfGridBeforeArray() {
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

    public int sizeOfHiddenArray() {
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

    public int sizeOfJcArray() {
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

    public int sizeOfTblCellSpacingArray() {
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

    public int sizeOfTblHeaderArray() {
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

    public int sizeOfTrHeightArray() {
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

    public int sizeOfWAfterArray() {
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

    public int sizeOfWBeforeArray() {
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
}
