package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.values.JavaListObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STVectorBaseType;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STVectorBaseType$Enum;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.a;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.b;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.c;

/* JADX INFO: loaded from: classes8.dex */
public class CTVectorImpl extends XmlComplexContentImpl implements b {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "variant"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i1"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i2"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i4"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i8"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui1"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui2"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui4"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui8"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r4"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r8"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpstr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpwstr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bstr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "date"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "filetime"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bool"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cy"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "error"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "clsid"), new QName("", "baseType"), new QName("", "size")};
    }

    public CTVectorImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ String[] lambda$getBstrArray$15(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getClsidArray$26(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getCyArray$22(int r0) {
        return new String[r0];
    }

    static /* synthetic */ Calendar[] lambda$getDateArray$17(int r0) {
        return new Calendar[r0];
    }

    static /* synthetic */ String[] lambda$getErrorArray$24(int r0) {
        return new String[r0];
    }

    static /* synthetic */ Calendar[] lambda$getFiletimeArray$19(int r0) {
        return new Calendar[r0];
    }

    static /* synthetic */ String[] lambda$getLpstrArray$11(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getLpwstrArray$13(int r0) {
        return new String[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getUi8Array$7(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ XmlBoolean[] lambda$xgetBoolArray$21(int r0) {
        return new XmlBoolean[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetBstrArray$16(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ c[] lambda$xgetClsidArray$27(int r0) {
        return new c[r0];
    }

    static /* synthetic */ STCy[] lambda$xgetCyArray$23(int r0) {
        return new STCy[r0];
    }

    static /* synthetic */ XmlDateTime[] lambda$xgetDateArray$18(int r0) {
        return new XmlDateTime[r0];
    }

    static /* synthetic */ STError[] lambda$xgetErrorArray$25(int r0) {
        return new STError[r0];
    }

    static /* synthetic */ XmlDateTime[] lambda$xgetFiletimeArray$20(int r0) {
        return new XmlDateTime[r0];
    }

    static /* synthetic */ XmlByte[] lambda$xgetI1Array$0(int r0) {
        return new XmlByte[r0];
    }

    static /* synthetic */ XmlShort[] lambda$xgetI2Array$1(int r0) {
        return new XmlShort[r0];
    }

    static /* synthetic */ XmlInt[] lambda$xgetI4Array$2(int r0) {
        return new XmlInt[r0];
    }

    static /* synthetic */ XmlLong[] lambda$xgetI8Array$3(int r0) {
        return new XmlLong[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetLpstrArray$12(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetLpwstrArray$14(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlFloat[] lambda$xgetR4Array$9(int r0) {
        return new XmlFloat[r0];
    }

    static /* synthetic */ XmlDouble[] lambda$xgetR8Array$10(int r0) {
        return new XmlDouble[r0];
    }

    static /* synthetic */ XmlUnsignedByte[] lambda$xgetUi1Array$4(int r0) {
        return new XmlUnsignedByte[r0];
    }

    static /* synthetic */ XmlUnsignedShort[] lambda$xgetUi2Array$5(int r0) {
        return new XmlUnsignedShort[r0];
    }

    static /* synthetic */ XmlUnsignedInt[] lambda$xgetUi4Array$6(int r0) {
        return new XmlUnsignedInt[r0];
    }

    static /* synthetic */ XmlUnsignedLong[] lambda$xgetUi8Array$8(int r0) {
        return new XmlUnsignedLong[r0];
    }

    public void addBool(boolean r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[16]), SimpleValue.class, "com.obric.memorydata.plugin")).setBooleanValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addBstr(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addClsid(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[19]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addCy(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[17]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDate(Calendar r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), SimpleValue.class, "com.obric.memorydata.plugin")).setCalendarValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addError(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[18]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFiletime(Calendar r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[15]), SimpleValue.class, "com.obric.memorydata.plugin")).setCalendarValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addI1(byte r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), SimpleValue.class, "com.obric.memorydata.plugin")).setByteValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addI2(short r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), SimpleValue.class, "com.obric.memorydata.plugin")).setShortValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addI4(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), SimpleValue.class, "com.obric.memorydata.plugin")).setIntValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addI8(long r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), SimpleValue.class, "com.obric.memorydata.plugin")).setLongValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addLpstr(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addLpwstr(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlBoolean addNewBool() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[16]), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewBstr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public c addNewClsid() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        c r3 = (c) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[19]), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STCy addNewCy() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STCy r3 = (STCy) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[17]), STCy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDateTime addNewDate() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlDateTime r3 = (XmlDateTime) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), XmlDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STError addNewError() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STError r3 = (STError) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[18]), STError.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDateTime addNewFiletime() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlDateTime r3 = (XmlDateTime) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[15]), XmlDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlByte addNewI1() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlByte r3 = (XmlByte) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), XmlByte.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlShort addNewI2() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlShort r3 = (XmlShort) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), XmlShort.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInt addNewI4() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInt r3 = (XmlInt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), XmlInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlLong addNewI8() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlLong r3 = (XmlLong) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), XmlLong.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewLpstr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[11]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewLpwstr() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[12]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlFloat addNewR4() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlFloat r3 = (XmlFloat) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), XmlFloat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDouble addNewR8() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlDouble r3 = (XmlDouble) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), XmlDouble.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedByte addNewUi1() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedByte r3 = (XmlUnsignedByte) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), XmlUnsignedByte.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedShort addNewUi2() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedShort r3 = (XmlUnsignedShort) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), XmlUnsignedShort.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedInt addNewUi4() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedInt r3 = (XmlUnsignedInt) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), XmlUnsignedInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedLong addNewUi8() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedLong r3 = (XmlUnsignedLong) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), XmlUnsignedLong.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public a addNewVariant() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        a r3 = (a) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void addR4(float r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), SimpleValue.class, "com.obric.memorydata.plugin")).setFloatValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addR8(double r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), SimpleValue.class, "com.obric.memorydata.plugin")).setDoubleValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addUi1(short r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), SimpleValue.class, "com.obric.memorydata.plugin")).setShortValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addUi2(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), SimpleValue.class, "com.obric.memorydata.plugin")).setIntValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addUi4(long r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), SimpleValue.class, "com.obric.memorydata.plugin")).setLongValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addUi8(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public STVectorBaseType$Enum getBaseType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[20]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        STVectorBaseType$Enum r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = (STVectorBaseType$Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STVectorBaseType$Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public boolean getBoolArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        boolean r5 = r3.getBooleanValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public boolean[] getBoolArray() {
        return getBooleanArray(PROPERTY_QNAME[16]);
    }

    public List<Boolean> getBoolList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$T6ftTIhEhZhKiSdoFjabBntm57w(this), new $$Lambda$Hh4LwC1xFD16nU_MDJ91AjQyJJQ(this), new $$Lambda$ChSGtss02Ww1CaxnizVI52eHYAU(this), new $$Lambda$XEHgekuSquLOTCKBJE2yO6VYpc(this), new $$Lambda$Nr8xp6DasawXSuySb3go9Q7ql6c(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getBstrArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        String r5 = r3.getStringValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public String[] getBstrArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[13], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTVectorImpl$DHJLuCFyo2Zdn1kcpijjdhi8.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getBstrList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$tMfpqDOmj6f50FST0kHyAP7m_kk(this), new $$Lambda$SRqVL749n5M2FFHnJBZcVw9Qtg(this), new $$Lambda$SpRXz7CT5EPlJ51iqnsbcAWVIU(this), new $$Lambda$aTIyOonpmfiUmzHEUq_I1FkSjZk(this), new $$Lambda$fQD1gP4IgzEqeIeIuTCbDxnDeVU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getClsidArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        String r5 = r3.getStringValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public String[] getClsidArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[19], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTVectorImpl$XPIwvPiif15tB8QFN3ITlJjVm_M.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getClsidList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$CM5oZedujQjYkpw03MtOTHmAxFE(this), new $$Lambda$uJiiEOT2PEs91kdkkyfwCvy2z_k(this), new $$Lambda$ArlG7X8QclGcUJAQuql8THiHir8(this), new $$Lambda$4uyZSGVZ2KS9QJSQl51ONWLDayg(this), new $$Lambda$LxNYINCKWA6T3XrgRGvacvgUU8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getCyArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        String r5 = r3.getStringValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public String[] getCyArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[17], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTVectorImpl$twS7CG0oEE7jotcJjVhHKsTVHsk.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getCyList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Qk7cqzJtQx7VzRRr5bg0mpwJPM(this), new $$Lambda$J3Hzm2qW29Cd8SPetGeBvyShi0(this), new $$Lambda$tRiqcqh0hqgKqYXo7jOSLWXBlTk(this), new $$Lambda$Hutd394cd_MKX4ojF1mOkLf_LHI(this), new $$Lambda$cKzprlHy0ngCYH3cHC6CPhDSjhE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public Calendar getDateArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        Calendar r5 = r3.getCalendarValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public Calendar[] getDateArray() {
        return (Calendar[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[14], $$Lambda$Y2c27Q_BqgJPklJyqo2WhgChD4.INSTANCE, $$Lambda$CTVectorImpl$iFsHmavnKDxc_RY0MfSLnOdy7P0.INSTANCE), Calendar[].class, "com.obric.memorydata.plugin");
    }

    public List<Calendar> getDateList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$DkG7lWQZvNt8G2m7t1RAhL4oWVM(this), new $$Lambda$HFIEcip3KJz920hDwqoBfWFk8Wk(this), new $$Lambda$7uHig1qqfzHjglKSynkIYUN4Txc(this), new $$Lambda$ESe3OuSx3tXataRcEpYSJusT_Qo(this), new $$Lambda$ZSKuT1k6bXCDGEfyNJk2_MHNhQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getErrorArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        String r5 = r3.getStringValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public String[] getErrorArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[18], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTVectorImpl$8ydMYN6C7kUkWlCLzOSVEIsU6Eg.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getErrorList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$JBKHQTmLkEIDl3SFLVYpQ7gR_f0(this), new $$Lambda$Ei4sW0n4YjaH977wg8SRsm53WM(this), new $$Lambda$WD2HfwPYbysZqj5fRxm3CPX1YlA(this), new $$Lambda$YSxgeP3PPHLOYSPdSLlRdzXFI(this), new $$Lambda$k9IJqUz4auJxyj5S_yWnMLLgQ8Q(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public Calendar getFiletimeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        Calendar r5 = r3.getCalendarValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public Calendar[] getFiletimeArray() {
        return (Calendar[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[15], $$Lambda$Y2c27Q_BqgJPklJyqo2WhgChD4.INSTANCE, $$Lambda$CTVectorImpl$0_FIdYgw6LZExKfpJqm7IcF_yxU.INSTANCE), Calendar[].class, "com.obric.memorydata.plugin");
    }

    public List<Calendar> getFiletimeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$6WcvooW4dmqLIgSkqVKve1olNWs(this), new $$Lambda$NgaVxEIpqRgITabPjY1drOY5BE(this), new $$Lambda$b4XbIOv0CwS_w2K4rFdjTPmIOe8(this), new $$Lambda$hVVeWmLZlNzBqNP1lQ5seLwTwdc(this), new $$Lambda$DSj9WyG2BXeItaQhJFpCmMRteOw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public byte getI1Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        byte r5 = r3.getByteValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public byte[] getI1Array() {
        return getByteArray(PROPERTY_QNAME[1]);
    }

    public List<Byte> getI1List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$jAP0tXTdeRKJAWnzNpnwCUi_OJE(this), new $$Lambda$9k4PgfEe9snE1cwcGrz0qwCdwfY(this), new $$Lambda$TnyK1uKGadCPztD14tYJXG3wsxw(this), new $$Lambda$x0nMIMLP_nmX8dUgpumCMjbyges(this), new $$Lambda$4LWmoxwPaeFSqc9PbAuOozB1p8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public short getI2Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        short r5 = r3.getShortValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public short[] getI2Array() {
        return getShortArray(PROPERTY_QNAME[2]);
    }

    public List<Short> getI2List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$qTx0GC2BOJ2yjZVllOpsptQvHs(this), new $$Lambda$Xzr5VXtNSh3LvdGKQinw3WVgiVU(this), new $$Lambda$8s8d2YI9jNCyiar7lLfQyHX1CA(this), new $$Lambda$gCBuWO39yTIAA67EocMQIUE3o0o(this), new $$Lambda$64MkSUrdpxsHfUmP5tiLpSkvH1w(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public int getI4Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        int r5 = r3.getIntValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int[] getI4Array() {
        return getIntArray(PROPERTY_QNAME[3]);
    }

    public List<Integer> getI4List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$5eXUDd0LBdqbPZd8pEAxDR7YU3Q(this), new $$Lambda$r65nwJthC13TynuCDZYf6DQSR9Q(this), new $$Lambda$M_CnAOcCcWMFgBI4xtKuF36dJc(this), new $$Lambda$irawA8A5bZJ7ZiZaZG4aBp0a3CE(this), new $$Lambda$ky16umEreL489qxf2sJHdNp6Pjg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public long getI8Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        long r5 = r3.getLongValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public long[] getI8Array() {
        return getLongArray(PROPERTY_QNAME[4]);
    }

    public List<Long> getI8List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$H7dJ8_1dNWcTlxqfD0JXyqVUlXs(this), new $$Lambda$ejjM4x04ekzeoTJAxBVVaGWOB7Q(this), new $$Lambda$KnWapH0MjrUoARhNwtfkv1Gw(this), new $$Lambda$dNHl60Fs6ZXVA356yI_PUTqO_FA(this), new $$Lambda$y1QYPG_wYWd5INQvPKG3xCSr1E(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getLpstrArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        String r5 = r3.getStringValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public String[] getLpstrArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[11], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTVectorImpl$W80r85Tic7nYno4pEippUb_t7GQ.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getLpstrList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$z5VpgFS1hg6SRzwwTLuG7Fcfs7I(this), new $$Lambda$e4VK2TfaR8uAavtsMMK7o5FBntQ(this), new $$Lambda$YoQNgVZksplzqd6YYqR8ouZCybI(this), new $$Lambda$Rrvf13cK3h4ftv9mhrIFQP4ZYg(this), new $$Lambda$KFvL_KPJrYj53wVL9SbQXTMmgFE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getLpwstrArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        String r5 = r3.getStringValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public String[] getLpwstrArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[12], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTVectorImpl$0DbRc1vrUA7aJlNZJ6jd00s0vw.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getLpwstrList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Z_YZerzngeV4R3bsdNhkLWiYYM(this), new $$Lambda$QgJwIlJvcS9wxrfsQh2alAKcdQ(this), new $$Lambda$gqzRwwgfvNA4311HgXHnEUR5M(this), new $$Lambda$HwTPW4r6VNCuBm4rpcianSAU_rE(this), new $$Lambda$_0_DnJqcgFuwCUsMSyPH1ThJ9tc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public float getR4Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        float r5 = r3.getFloatValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public float[] getR4Array() {
        return getFloatArray(PROPERTY_QNAME[9]);
    }

    public List<Float> getR4List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Hu8Hfn0WVcbO8inrlBFdwVW3sic(this), new $$Lambda$l4zR6fH3B4rNJfkhdRyxyUKoh6Q(this), new $$Lambda$jEKIEoLwGDwTzUcd9ajNsKZpoY(this), new $$Lambda$AYySyKmFz_xAMkLFAqJAcUInpw(this), new $$Lambda$V5Qb4Wu_dui0AwKjnd7QADYM01Q(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public double getR8Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        double r5 = r3.getDoubleValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public double[] getR8Array() {
        return getDoubleArray(PROPERTY_QNAME[10]);
    }

    public List<Double> getR8List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$58Pl9bFTTJVBccK9GLCbAqv5ja8(this), new $$Lambda$vuRND6Yk8WVK3aPXLKXZ0gNp77c(this), new $$Lambda$c2cPejSfosp7OYwefiVxJUx_GZw(this), new $$Lambda$Rm87F8pK8fPY5eTkyMALojPU1iE(this), new $$Lambda$IH2qkBYcZMzFSomMe6WCodQkHY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public long getSize() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[21]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        long r1 = 0;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = r3.getLongValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public short getUi1Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        short r5 = r3.getShortValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public short[] getUi1Array() {
        return getShortArray(PROPERTY_QNAME[5]);
    }

    public List<Short> getUi1List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$XCBnFV5iMepS0LQl6gsXPEMgWmc(this), new $$Lambda$y46b4Bu_516IGMheFjLUdYRMLkw(this), new $$Lambda$vtbwZD7R1adXuUx06uUZVmtP8Y(this), new $$Lambda$7jZsQcLWhEC6nUCAIopM1Q2cX5s(this), new $$Lambda$mJWYbcE7fboGWuDcPOlicNAxG6w(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public int getUi2Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        int r5 = r3.getIntValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int[] getUi2Array() {
        return getIntArray(PROPERTY_QNAME[6]);
    }

    public List<Integer> getUi2List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$2B1USmabhLP22nhJq_P_fdQcbgQ(this), new $$Lambda$yzbydQH9kJPyK3Cbe7hi_3_U1yQ(this), new $$Lambda$IRYkgWZKeIEUBzYJ85_nmMrwIBM(this), new $$Lambda$OnmIyorwI3yDRlFYTsE7oDtbgik(this), new $$Lambda$sEkj_gjOsbEa9mvI1MBuo7rmjx4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public long getUi4Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        long r5 = r3.getLongValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public long[] getUi4Array() {
        return getLongArray(PROPERTY_QNAME[7]);
    }

    public List<Long> getUi4List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$YtkfLR0ynJQVCuRzyQx2wDpGkFI(this), new $$Lambda$KCW1Jt7rMAURSUqECRSkS25YSQg(this), new $$Lambda$vDYsjgH0DQikKg__kTlfmzXvXU(this), new $$Lambda$ZJObnuSIR_IQgj3UM8vn8_mE0(this), new $$Lambda$kJ7Cgkz9SZrp_svv0kPweMZdYh4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getUi8Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        BigInteger r5 = r3.getBigIntegerValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public BigInteger[] getUi8Array() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[8], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTVectorImpl$T_DqF0W22py9sDkwEOPp7iHMueE.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getUi8List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Yng6A5CunKe0xpPrpj2kFw1S7U(this), new $$Lambda$muiKk1NDTYbjh2oyTBdqFHJ2Z0I(this), new $$Lambda$L7chz9tFUbVWPSgFOJUrq8Gjtpg(this), new $$Lambda$0oHatrhwZTOk8EaCIj74guZXPY(this), new $$Lambda$tRMu6xntLyULlnWWYXFdyDNg6c(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public a getVariantArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        a r3 = (a) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public a[] getVariantArray() {
        return (a[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new a[0]), a[].class, "com.obric.memorydata.plugin");
    }

    public List<a> getVariantList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$zUW3CPeTwPdD0qUP2jzsQ2w8RnI(this), new $$Lambda$wrK3AVJ2drrWyBVdpeyzmDi_ek(this), new $$Lambda$g6PqUpDliVo8nYuiKC7d0cb3GM(this), new $$Lambda$DGWgqQ8hhjxV1hnrEObQKCpRM(this), new $$Lambda$DmjnPuuOcoGrGogMcO8s6a4ldg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertBool(int r4, boolean r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[16], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBooleanValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertBstr(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertClsid(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[19], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertCy(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[17], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDate(int r4, Calendar r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setCalendarValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertError(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[18], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertFiletime(int r4, Calendar r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[15], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setCalendarValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertI1(int r4, byte r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setByteValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertI2(int r4, short r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setShortValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertI4(int r4, int r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setIntValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertI8(int r4, long r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setLongValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertLpstr(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertLpwstr(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlBoolean insertNewBool(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[16], r4), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewBstr(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public c insertNewClsid(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        c r3 = (c) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[19], r4), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STCy insertNewCy(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STCy r3 = (STCy) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[17], r4), STCy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDateTime insertNewDate(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlDateTime r3 = (XmlDateTime) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), XmlDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STError insertNewError(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STError r3 = (STError) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[18], r4), STError.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDateTime insertNewFiletime(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlDateTime r3 = (XmlDateTime) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[15], r4), XmlDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlByte insertNewI1(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlByte r3 = (XmlByte) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), XmlByte.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlShort insertNewI2(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlShort r3 = (XmlShort) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), XmlShort.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInt insertNewI4(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInt r3 = (XmlInt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), XmlInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlLong insertNewI8(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlLong r3 = (XmlLong) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), XmlLong.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewLpstr(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[11], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewLpwstr(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[12], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlFloat insertNewR4(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlFloat r3 = (XmlFloat) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), XmlFloat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDouble insertNewR8(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlDouble r3 = (XmlDouble) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), XmlDouble.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedByte insertNewUi1(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedByte r3 = (XmlUnsignedByte) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), XmlUnsignedByte.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedShort insertNewUi2(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedShort r3 = (XmlUnsignedShort) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), XmlUnsignedShort.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedInt insertNewUi4(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedInt r3 = (XmlUnsignedInt) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), XmlUnsignedInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedLong insertNewUi8(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedLong r3 = (XmlUnsignedLong) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), XmlUnsignedLong.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public a insertNewVariant(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        a r3 = (a) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertR4(int r4, float r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setFloatValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertR8(int r4, double r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setDoubleValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertUi1(int r4, short r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setShortValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertUi2(int r4, int r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setIntValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertUi4(int r4, long r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setLongValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertUi8(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeBool(int r4) {
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

    public void removeBstr(int r4) {
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

    public void removeClsid(int r4) {
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

    public void removeCy(int r4) {
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

    public void removeDate(int r4) {
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

    public void removeError(int r4) {
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

    public void removeFiletime(int r4) {
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

    public void removeI1(int r4) {
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

    public void removeI2(int r4) {
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

    public void removeI4(int r4) {
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

    public void removeI8(int r4) {
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

    public void removeLpstr(int r4) {
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

    public void removeLpwstr(int r4) {
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

    public void removeR4(int r4) {
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

    public void removeR8(int r4) {
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

    public void removeUi1(int r4) {
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

    public void removeUi2(int r4) {
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

    public void removeUi4(int r4) {
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

    public void removeUi8(int r4) {
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

    public void removeVariant(int r4) {
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

    public void setBaseType(STVectorBaseType$Enum r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[20]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[20]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setEnumValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setBoolArray(int r4, boolean r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setBooleanValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setBoolArray(boolean[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[16]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setBstrArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setStringValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setBstrArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[13]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setClsidArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setStringValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setClsidArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[19]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setCyArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setStringValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setCyArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[17]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDateArray(int r4, Calendar r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setCalendarValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setDateArray(Calendar[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[14]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setErrorArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setStringValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setErrorArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[18]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setFiletimeArray(int r4, Calendar r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setCalendarValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setFiletimeArray(Calendar[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[15]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setI1Array(int r4, byte r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setByteValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setI1Array(byte[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setI2Array(int r4, short r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setShortValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setI2Array(short[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setI4Array(int r4, int r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setIntValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setI4Array(int[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[3]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setI8Array(int r4, long r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setLongValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setI8Array(long[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[4]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setLpstrArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setStringValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setLpstrArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[11]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setLpwstrArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setStringValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setLpwstrArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[12]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setR4Array(int r4, float r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setFloatValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setR4Array(float[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[9]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setR8Array(int r4, double r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setDoubleValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setR8Array(double[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[10]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSize(long r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[21]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[21]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setLongValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setUi1Array(int r4, short r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setShortValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setUi1Array(short[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[5]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setUi2Array(int r4, int r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setIntValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setUi2Array(int[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[6]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setUi4Array(int r4, long r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setLongValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setUi4Array(long[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[7]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setUi8Array(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setBigIntegerValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setUi8Array(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[8]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setVariantArray(int r3, a r4) {
        generatedSetterHelperImpl((a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
    }

    public void setVariantArray(a[] r3) {
        check_orphaned();
        arraySetterHelper(r3, PROPERTY_QNAME[0]);
    }

    public int sizeOfBoolArray() {
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

    public int sizeOfBstrArray() {
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

    public int sizeOfClsidArray() {
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

    public int sizeOfCyArray() {
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

    public int sizeOfDateArray() {
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

    public int sizeOfErrorArray() {
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

    public int sizeOfFiletimeArray() {
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

    public int sizeOfI1Array() {
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

    public int sizeOfI2Array() {
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

    public int sizeOfI4Array() {
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

    public int sizeOfI8Array() {
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

    public int sizeOfLpstrArray() {
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

    public int sizeOfLpwstrArray() {
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

    public int sizeOfR4Array() {
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

    public int sizeOfR8Array() {
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

    public int sizeOfUi1Array() {
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

    public int sizeOfUi2Array() {
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

    public int sizeOfUi4Array() {
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

    public int sizeOfUi8Array() {
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

    public int sizeOfVariantArray() {
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

    public STVectorBaseType xgetBaseType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STVectorBaseType r3 = (STVectorBaseType) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[20]), STVectorBaseType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlBoolean xgetBoolArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlBoolean[] xgetBoolArray() {
        return (XmlBoolean[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[16], $$Lambda$CTVectorImpl$k1nwetTpdTy5VGvj7Ylrx9Z02U.INSTANCE), XmlBoolean[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlBoolean> xgetBoolList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$VT7wUPFG6bisUUE1kUkuvfXhcLA(this), new $$Lambda$PWvzsIv6YIsTT3GCA3omeabkrHE(this), new $$Lambda$oaAuUJK4qXMQEjQm9QTD3XjKc9Y(this), new $$Lambda$XEHgekuSquLOTCKBJE2yO6VYpc(this), new $$Lambda$Nr8xp6DasawXSuySb3go9Q7ql6c(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetBstrArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetBstrArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[13], $$Lambda$CTVectorImpl$VJqMrJTse_LsQ7RbA75XpWPzM.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetBstrList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$TJHhSFVgJac1_atknVZPC6txtw(this), new $$Lambda$V2ddxdKJGc9LWzwmB2JljazBRPA(this), new $$Lambda$WH1cprnxkWAM5pDVcJ9vZ1gkFIY(this), new $$Lambda$aTIyOonpmfiUmzHEUq_I1FkSjZk(this), new $$Lambda$fQD1gP4IgzEqeIeIuTCbDxnDeVU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public c xgetClsidArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        c r3 = (c) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public c[] xgetClsidArray() {
        return (c[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[19], $$Lambda$CTVectorImpl$j_iYYX0BR1zl6J4AY6TTVZgM.INSTANCE), c[].class, "com.obric.memorydata.plugin");
    }

    public List<c> xgetClsidList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$gDceSMLg6sa8vOLeogOXDboHrsU(this), new $$Lambda$Z8XGos4ieo1pjp0yRaZnSBsQvvU(this), new $$Lambda$v3A6SAzVjHL6I7iEuehbd1atbMI(this), new $$Lambda$4uyZSGVZ2KS9QJSQl51ONWLDayg(this), new $$Lambda$LxNYINCKWA6T3XrgRGvacvgUU8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STCy xgetCyArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STCy r3 = (STCy) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), STCy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STCy[] xgetCyArray() {
        return (STCy[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[17], $$Lambda$CTVectorImpl$AV8qgrSen2A7GFmst7wFB7Mfa9s.INSTANCE), STCy[].class, "com.obric.memorydata.plugin");
    }

    public List<STCy> xgetCyList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$zEcB_wo7XAbzOdiTUalmC2D6Y9k(this), new $$Lambda$XyzovGp23cSlQUmYzxhU0PpPC6k(this), new $$Lambda$O_1MjWVMmOCm_AtbNbg8T3sHh5Y(this), new $$Lambda$Hutd394cd_MKX4ojF1mOkLf_LHI(this), new $$Lambda$cKzprlHy0ngCYH3cHC6CPhDSjhE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDateTime xgetDateArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlDateTime r3 = (XmlDateTime) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), XmlDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlDateTime[] xgetDateArray() {
        return (XmlDateTime[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[14], $$Lambda$CTVectorImpl$SE4nwEB_jGgcKF1AdBVfMRTvdGQ.INSTANCE), XmlDateTime[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlDateTime> xgetDateList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$c82EAAg84JlbEfplCnrULnUd4EE(this), new $$Lambda$R6TkvZF0LAzET2Y1YfonrnfVH68(this), new $$Lambda$03J6XT5Y_ZcYocWfFdT5ORtPKoA(this), new $$Lambda$ESe3OuSx3tXataRcEpYSJusT_Qo(this), new $$Lambda$ZSKuT1k6bXCDGEfyNJk2_MHNhQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STError xgetErrorArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STError r3 = (STError) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), STError.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STError[] xgetErrorArray() {
        return (STError[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[18], $$Lambda$CTVectorImpl$tLfPsc1aoiAOCd4q6gpp1xRBBc.INSTANCE), STError[].class, "com.obric.memorydata.plugin");
    }

    public List<STError> xgetErrorList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$E40TBZyTZaeKfhArcvyS_APSaHk(this), new $$Lambda$TYmF6eLfnG7BqurH73I12Q7cWw(this), new $$Lambda$jW_EoekZpfaU6GeOeYpd2uQQVOY(this), new $$Lambda$YSxgeP3PPHLOYSPdSLlRdzXFI(this), new $$Lambda$k9IJqUz4auJxyj5S_yWnMLLgQ8Q(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDateTime xgetFiletimeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlDateTime r3 = (XmlDateTime) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), XmlDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlDateTime[] xgetFiletimeArray() {
        return (XmlDateTime[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[15], $$Lambda$CTVectorImpl$Y8XH4kTwrUPsYtt_xnaR3roDg7A.INSTANCE), XmlDateTime[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlDateTime> xgetFiletimeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$s8s8ZoeRwqdXIG54yPl_bmLCPqQ(this), new $$Lambda$oaAzHx1jDSzL8brGALCfX70RqfI(this), new $$Lambda$KWH_A8hWQ8JFV49dKFP1lfVGFY(this), new $$Lambda$hVVeWmLZlNzBqNP1lQ5seLwTwdc(this), new $$Lambda$DSj9WyG2BXeItaQhJFpCmMRteOw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlByte xgetI1Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlByte r3 = (XmlByte) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), XmlByte.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlByte[] xgetI1Array() {
        return (XmlByte[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[1], $$Lambda$CTVectorImpl$PrBIChlUXnphW0VUxdkuvlREXhU.INSTANCE), XmlByte[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlByte> xgetI1List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$zwncvkJtdCtrslZA6g8lwcVpHs8(this), new $$Lambda$mes8e72sn3SmTyZVoOZgtTXIroA(this), new $$Lambda$drEkNSnNoxZ1KPlnle3sudTgt20(this), new $$Lambda$x0nMIMLP_nmX8dUgpumCMjbyges(this), new $$Lambda$4LWmoxwPaeFSqc9PbAuOozB1p8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlShort xgetI2Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlShort r3 = (XmlShort) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), XmlShort.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlShort[] xgetI2Array() {
        return (XmlShort[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[2], $$Lambda$CTVectorImpl$CetXSJwbdwlyrdUgcjXpCQS0Eo.INSTANCE), XmlShort[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlShort> xgetI2List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$SXtwozct0sYA5ry49iEzh94dr8(this), new $$Lambda$glZf4latEleskL8vjNeyRnZJg(this), new $$Lambda$ndGOM8oUoAw7Ah9EPNetXzDYVIY(this), new $$Lambda$gCBuWO39yTIAA67EocMQIUE3o0o(this), new $$Lambda$64MkSUrdpxsHfUmP5tiLpSkvH1w(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInt xgetI4Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInt r3 = (XmlInt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), XmlInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInt[] xgetI4Array() {
        return (XmlInt[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[3], $$Lambda$CTVectorImpl$tnMidxNDd3qBKBW0KsJ8liQ8f0k.INSTANCE), XmlInt[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInt> xgetI4List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$pMV2d0oZOIMIG36OjAPAJklrmXI(this), new $$Lambda$vbN0oxc_DR_rjl2eebFW0ERh7_w(this), new $$Lambda$jyiMsWU1lumHs_8Z8tAlPIjwc(this), new $$Lambda$irawA8A5bZJ7ZiZaZG4aBp0a3CE(this), new $$Lambda$ky16umEreL489qxf2sJHdNp6Pjg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlLong xgetI8Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlLong r3 = (XmlLong) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), XmlLong.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlLong[] xgetI8Array() {
        return (XmlLong[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[4], $$Lambda$CTVectorImpl$VtMnYV_zmHszMBShrIWPm0Pllo.INSTANCE), XmlLong[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlLong> xgetI8List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$c5dF9dk_QYZBXCfKKncjSCm_S4w(this), new $$Lambda$vsOpgSEN0J9_EfeuxHCMMmr2w(this), new $$Lambda$wPJe_y6o5JVADAiDz57YljVhbvs(this), new $$Lambda$dNHl60Fs6ZXVA356yI_PUTqO_FA(this), new $$Lambda$y1QYPG_wYWd5INQvPKG3xCSr1E(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetLpstrArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetLpstrArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[11], $$Lambda$CTVectorImpl$rUDBqIIzsdzqdPsPtLFms6j62aY.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetLpstrList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$_g2TSk27BTIS0ZASAsPpBNoKWKo(this), new $$Lambda$sHIsQ7JzEWMVUhV_MRNRWyR6Jw(this), new $$Lambda$RZ4hYW2jgVpAUgoRK0MJDB8V9wU(this), new $$Lambda$Rrvf13cK3h4ftv9mhrIFQP4ZYg(this), new $$Lambda$KFvL_KPJrYj53wVL9SbQXTMmgFE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetLpwstrArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetLpwstrArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[12], $$Lambda$CTVectorImpl$XX8WKhQdOqvUeChxKiNm17GNl8.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetLpwstrList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$o0zp2dmENXQ2aUSpZYgP_mRXjDE(this), new $$Lambda$gUw4AF8HsnK9dKu47rXKxiix0Po(this), new $$Lambda$j471h4G24ZnS5EL0glK76_Xq1Z0(this), new $$Lambda$HwTPW4r6VNCuBm4rpcianSAU_rE(this), new $$Lambda$_0_DnJqcgFuwCUsMSyPH1ThJ9tc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlFloat xgetR4Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlFloat r3 = (XmlFloat) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), XmlFloat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlFloat[] xgetR4Array() {
        return (XmlFloat[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[9], $$Lambda$CTVectorImpl$blXpHCQw1zk2Fy8jp2iApAU8WVk.INSTANCE), XmlFloat[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlFloat> xgetR4List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$RE05p8pepeCCS55FoPXAbQhc1Nw(this), new $$Lambda$GTVId7bzvLv_XfFdgID8jQmjhA4(this), new $$Lambda$qIBZ2x2iiKeliU6A7uorkUxsWMI(this), new $$Lambda$AYySyKmFz_xAMkLFAqJAcUInpw(this), new $$Lambda$V5Qb4Wu_dui0AwKjnd7QADYM01Q(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlDouble xgetR8Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlDouble r3 = (XmlDouble) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), XmlDouble.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlDouble[] xgetR8Array() {
        return (XmlDouble[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[10], $$Lambda$CTVectorImpl$N_meOkv65wq41PoT8xqvb2pvWro.INSTANCE), XmlDouble[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlDouble> xgetR8List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$QZkic7NY8af6kuyTpr2HH4_14eo(this), new $$Lambda$LqL0ZZVfBSEV2YTjNK2oGBUfYE(this), new $$Lambda$EAXRXW1JZRxF0RYyHfbnIYlCdH8(this), new $$Lambda$Rm87F8pK8fPY5eTkyMALojPU1iE(this), new $$Lambda$IH2qkBYcZMzFSomMe6WCodQkHY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedInt xgetSize() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlUnsignedInt r3 = (XmlUnsignedInt) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[21]), XmlUnsignedInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedByte xgetUi1Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlUnsignedByte r3 = (XmlUnsignedByte) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), XmlUnsignedByte.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedByte[] xgetUi1Array() {
        return (XmlUnsignedByte[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[5], $$Lambda$CTVectorImpl$dpU0YUuVN_9CDO60Hv4EjZ_ydek.INSTANCE), XmlUnsignedByte[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlUnsignedByte> xgetUi1List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$6Kq6qbem5OrJJJ7KP2SZwTB_7QA(this), new $$Lambda$YYJ3_zY6BtXZS861OgqewHfcUyI(this), new $$Lambda$LXvs5VeXuSW9xek8JU5OczFaU(this), new $$Lambda$7jZsQcLWhEC6nUCAIopM1Q2cX5s(this), new $$Lambda$mJWYbcE7fboGWuDcPOlicNAxG6w(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedShort xgetUi2Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlUnsignedShort r3 = (XmlUnsignedShort) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), XmlUnsignedShort.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedShort[] xgetUi2Array() {
        return (XmlUnsignedShort[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[6], $$Lambda$CTVectorImpl$AzZGP1WbVkP3Nv9S_Sx5bSo.INSTANCE), XmlUnsignedShort[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlUnsignedShort> xgetUi2List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$8lQHZqkDxRahsUy7aj4DVqWy4(this), new $$Lambda$JD1sPy4IcfXOqz6XrTEXgDDW9KQ(this), new $$Lambda$c2Rn_QgJFN7AwRY_8UbIEx7Du4E(this), new $$Lambda$OnmIyorwI3yDRlFYTsE7oDtbgik(this), new $$Lambda$sEkj_gjOsbEa9mvI1MBuo7rmjx4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedInt xgetUi4Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlUnsignedInt r3 = (XmlUnsignedInt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), XmlUnsignedInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedInt[] xgetUi4Array() {
        return (XmlUnsignedInt[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[7], $$Lambda$CTVectorImpl$MSghKkCjAvpX_QXRjMV3PFlJxg.INSTANCE), XmlUnsignedInt[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlUnsignedInt> xgetUi4List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$gKKsTE7dGrcRmO0sU9ufnQnLxog(this), new $$Lambda$ZZIq8_6i1YDTwd6LZw5MzxlMfeY(this), new $$Lambda$nnUukpAzKZ5rlWbDodXd3hudQkE(this), new $$Lambda$ZJObnuSIR_IQgj3UM8vn8_mE0(this), new $$Lambda$kJ7Cgkz9SZrp_svv0kPweMZdYh4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedLong xgetUi8Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlUnsignedLong r3 = (XmlUnsignedLong) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), XmlUnsignedLong.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlUnsignedLong[] xgetUi8Array() {
        return (XmlUnsignedLong[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[8], $$Lambda$CTVectorImpl$LZT9PYQvCRtZH2kQVjwZgbN5nH0.INSTANCE), XmlUnsignedLong[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlUnsignedLong> xgetUi8List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$DVDqYkZ8P8ST7byPlj79eMMTNAo(this), new $$Lambda$7PL6DijwqPJs1c1kjnM38ou_iVg(this), new $$Lambda$mZzSvn_ojTFT3djz1RCrrOgHd0(this), new $$Lambda$0oHatrhwZTOk8EaCIj74guZXPY(this), new $$Lambda$tRMu6xntLyULlnWWYXFdyDNg6c(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetBaseType(STVectorBaseType r7) {
        STVectorBaseType r8 = (STVectorBaseType) ZeusTransformUtils.wrapperContextForParams(r7, STVectorBaseType.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        STVectorBaseType r3 = (STVectorBaseType) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[20]), STVectorBaseType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (STVectorBaseType) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[20]), STVectorBaseType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetBoolArray(int r4, XmlBoolean r5) {
        XmlBoolean r6 = (XmlBoolean) ZeusTransformUtils.wrapperContextForParams(r5, XmlBoolean.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlBoolean r3 = (XmlBoolean) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), XmlBoolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetBoolArray(XmlBoolean[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[16]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetBstrArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetBstrArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[13]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetClsidArray(int r4, c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        c r3 = (c) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetClsidArray(c[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[19]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetCyArray(int r4, STCy r5) {
        STCy r6 = (STCy) ZeusTransformUtils.wrapperContextForParams(r5, STCy.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STCy r3 = (STCy) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), STCy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetCyArray(STCy[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[17]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetDateArray(int r4, XmlDateTime r5) {
        XmlDateTime r6 = (XmlDateTime) ZeusTransformUtils.wrapperContextForParams(r5, XmlDateTime.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlDateTime r3 = (XmlDateTime) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), XmlDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetDateArray(XmlDateTime[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[14]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetErrorArray(int r4, STError r5) {
        STError r6 = (STError) ZeusTransformUtils.wrapperContextForParams(r5, STError.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STError r3 = (STError) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), STError.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetErrorArray(STError[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[18]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetFiletimeArray(int r4, XmlDateTime r5) {
        XmlDateTime r6 = (XmlDateTime) ZeusTransformUtils.wrapperContextForParams(r5, XmlDateTime.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlDateTime r3 = (XmlDateTime) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), XmlDateTime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetFiletimeArray(XmlDateTime[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[15]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetI1Array(int r4, XmlByte r5) {
        XmlByte r6 = (XmlByte) ZeusTransformUtils.wrapperContextForParams(r5, XmlByte.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlByte r3 = (XmlByte) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), XmlByte.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetI1Array(XmlByte[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetI2Array(int r4, XmlShort r5) {
        XmlShort r6 = (XmlShort) ZeusTransformUtils.wrapperContextForParams(r5, XmlShort.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlShort r3 = (XmlShort) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), XmlShort.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetI2Array(XmlShort[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetI4Array(int r4, XmlInt r5) {
        XmlInt r6 = (XmlInt) ZeusTransformUtils.wrapperContextForParams(r5, XmlInt.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInt r3 = (XmlInt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), XmlInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetI4Array(XmlInt[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[3]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetI8Array(int r4, XmlLong r5) {
        XmlLong r6 = (XmlLong) ZeusTransformUtils.wrapperContextForParams(r5, XmlLong.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlLong r3 = (XmlLong) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), XmlLong.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetI8Array(XmlLong[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[4]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetLpstrArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[11], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetLpstrArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[11]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetLpwstrArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[12], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetLpwstrArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[12]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetR4Array(int r4, XmlFloat r5) {
        XmlFloat r6 = (XmlFloat) ZeusTransformUtils.wrapperContextForParams(r5, XmlFloat.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlFloat r3 = (XmlFloat) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), XmlFloat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetR4Array(XmlFloat[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[9]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetR8Array(int r4, XmlDouble r5) {
        XmlDouble r6 = (XmlDouble) ZeusTransformUtils.wrapperContextForParams(r5, XmlDouble.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlDouble r3 = (XmlDouble) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), XmlDouble.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetR8Array(XmlDouble[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[10]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetSize(XmlUnsignedInt r7) {
        XmlUnsignedInt r8 = (XmlUnsignedInt) ZeusTransformUtils.wrapperContextForParams(r7, XmlUnsignedInt.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        XmlUnsignedInt r3 = (XmlUnsignedInt) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[21]), XmlUnsignedInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (XmlUnsignedInt) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[21]), XmlUnsignedInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetUi1Array(int r4, XmlUnsignedByte r5) {
        XmlUnsignedByte r6 = (XmlUnsignedByte) ZeusTransformUtils.wrapperContextForParams(r5, XmlUnsignedByte.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlUnsignedByte r3 = (XmlUnsignedByte) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), XmlUnsignedByte.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetUi1Array(XmlUnsignedByte[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[5]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetUi2Array(int r4, XmlUnsignedShort r5) {
        XmlUnsignedShort r6 = (XmlUnsignedShort) ZeusTransformUtils.wrapperContextForParams(r5, XmlUnsignedShort.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlUnsignedShort r3 = (XmlUnsignedShort) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), XmlUnsignedShort.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetUi2Array(XmlUnsignedShort[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[6]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetUi4Array(int r4, XmlUnsignedInt r5) {
        XmlUnsignedInt r6 = (XmlUnsignedInt) ZeusTransformUtils.wrapperContextForParams(r5, XmlUnsignedInt.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlUnsignedInt r3 = (XmlUnsignedInt) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), XmlUnsignedInt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetUi4Array(XmlUnsignedInt[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[7]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetUi8Array(int r4, XmlUnsignedLong r5) {
        XmlUnsignedLong r6 = (XmlUnsignedLong) ZeusTransformUtils.wrapperContextForParams(r5, XmlUnsignedLong.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlUnsignedLong r3 = (XmlUnsignedLong) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), XmlUnsignedLong.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.set(r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void xsetUi8Array(XmlUnsignedLong[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[8]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
