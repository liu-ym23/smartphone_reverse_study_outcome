package org.apache.xmlbeans.impl.xb.substwsdl.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.substwsdl.TImport;

/* JADX INFO: loaded from: classes7.dex */
public class DefinitionsDocumentImpl extends XmlComplexContentImpl implements DefinitionsDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class DefinitionsImpl extends XmlComplexContentImpl implements DefinitionsDocument.Definitions {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "import"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "types"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "message"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "binding"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "portType"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "service")};
        }

        public DefinitionsImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public XmlObject addNewBinding() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TImport addNewImport() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TImport r3 = (TImport) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), TImport.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject addNewMessage() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject addNewPortType() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject addNewService() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject addNewTypes() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject getBindingArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public XmlObject[] getBindingArray() {
            return getXmlObjectArray(PROPERTY_QNAME[3], new XmlObject[0]);
        }

        public List<XmlObject> getBindingList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$CiQo93vVW1PD4uTYuZ7VkpImJU(this), new $$Lambda$M2cVilRctXnrMT_2BfInhYFm3T4(this), new $$Lambda$RSMPJmfPV9O7znI_Vfsr6tYR5LQ(this), new $$Lambda$7uU4QVbc6G4qBnkYu8cvIVFr6cI(this), new $$Lambda$ikPEfYwXCln8Yu0AkkUX2ZCXxEk(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public TImport getImportArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TImport r3 = (TImport) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), TImport.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public TImport[] getImportArray() {
            return (TImport[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new TImport[0]), TImport[].class, "com.obric.memorydata.plugin");
        }

        public List<TImport> getImportList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Er6ujoJ20xIx94vhJklAnwYBFw(this), new $$Lambda$9vCk3hi2DeZPx4cMLO5fnPxunw(this), new $$Lambda$dDe9mPz7IBxa6iP37vE5yfBANNo(this), new $$Lambda$QQdRo3vOFlkV7i7TK1WWEQaC8lI(this), new $$Lambda$pC5yPapIT9Pp64qHdWpaMhnakno(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject getMessageArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public XmlObject[] getMessageArray() {
            return getXmlObjectArray(PROPERTY_QNAME[2], new XmlObject[0]);
        }

        public List<XmlObject> getMessageList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$_YkITZtJMzC1OMFHCC7hql_an4(this), new $$Lambda$3ddCPHVBTUAWYUQshdk3MuioXU(this), new $$Lambda$gMOaTPaAbghKQknhF1UuDr_Vl0s(this), new $$Lambda$3G2rUBachbQJagMMvqhYw3Fp1ok(this), new $$Lambda$xdFuXcsgZDjSXRlNsw16ShGarXc(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject getPortTypeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public XmlObject[] getPortTypeArray() {
            return getXmlObjectArray(PROPERTY_QNAME[4], new XmlObject[0]);
        }

        public List<XmlObject> getPortTypeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$9ivSIeOcGvXi14No6zrMltRm1dI(this), new $$Lambda$fh_ODkGfe0hxJkCfw_9JoU49KI(this), new $$Lambda$sqLYuGgvJJEIn0GyVkbrSmbD_og(this), new $$Lambda$lEwGyB1KdopJgWek0D8_lghy2U(this), new $$Lambda$EV7U3S4iXefOthaMcpng8sqCGo(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject getServiceArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public XmlObject[] getServiceArray() {
            return getXmlObjectArray(PROPERTY_QNAME[5], new XmlObject[0]);
        }

        public List<XmlObject> getServiceList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Au3R_OpJbR94K50XA7oN99h1FM(this), new $$Lambda$TPNfNKyrQ61GeAhyvOW7vYlK16U(this), new $$Lambda$GWRth3BdK3GxF0jmnaTQOtrQgfI(this), new $$Lambda$5A1z5esZm5khoRRAk4uKAkenYWk(this), new $$Lambda$lleawbgtWJVkap0xlxTlgKNtDo(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject getTypesArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public XmlObject[] getTypesArray() {
            return getXmlObjectArray(PROPERTY_QNAME[1], new XmlObject[0]);
        }

        public List<XmlObject> getTypesList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Hanbkzaopc7N_I224l01jNceeDg(this), new $$Lambda$NVmhAgPaHKi6RgAmQntpQs7Q1d4(this), new $$Lambda$NkzFgTwLv2uzzuMThoM__q7a9o(this), new $$Lambda$O18pMrqnvD8yrnTTD9MJaPzISgo(this), new $$Lambda$pdSy1x6f0OANN8QiSEWBEA1A4w(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject insertNewBinding(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public TImport insertNewImport(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            TImport r3 = (TImport) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), TImport.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject insertNewMessage(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject insertNewPortType(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject insertNewService(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlObject insertNewTypes(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlObject r3 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeBinding(int r4) {
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

        public void removeImport(int r4) {
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

        public void removeMessage(int r4) {
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

        public void removePortType(int r4) {
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

        public void removeService(int r4) {
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

        public void removeTypes(int r4) {
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

        public void setBindingArray(int r3, XmlObject r4) {
            generatedSetterHelperImpl((XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
        }

        public void setBindingArray(XmlObject[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[3]);
        }

        public void setImportArray(int r3, TImport r4) {
            generatedSetterHelperImpl((TImport) ZeusTransformUtils.wrapperContextForParams(r4, TImport.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
        }

        public void setImportArray(TImport[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[0]);
        }

        public void setMessageArray(int r3, XmlObject r4) {
            generatedSetterHelperImpl((XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
        }

        public void setMessageArray(XmlObject[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[2]);
        }

        public void setPortTypeArray(int r3, XmlObject r4) {
            generatedSetterHelperImpl((XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], r3, 2);
        }

        public void setPortTypeArray(XmlObject[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[4]);
        }

        public void setServiceArray(int r3, XmlObject r4) {
            generatedSetterHelperImpl((XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], r3, 2);
        }

        public void setServiceArray(XmlObject[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[5]);
        }

        public void setTypesArray(int r3, XmlObject r4) {
            generatedSetterHelperImpl((XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
        }

        public void setTypesArray(XmlObject[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[1]);
        }

        public int sizeOfBindingArray() {
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

        public int sizeOfImportArray() {
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

        public int sizeOfMessageArray() {
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

        public int sizeOfPortTypeArray() {
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

        public int sizeOfServiceArray() {
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

        public int sizeOfTypesArray() {
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
    }

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "definitions")};
    }

    public DefinitionsDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public DefinitionsDocument.Definitions addNewDefinitions() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        DefinitionsDocument.Definitions r3 = (DefinitionsDocument.Definitions) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), DefinitionsDocument.Definitions.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public DefinitionsDocument.Definitions getDefinitions() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        DefinitionsDocument.Definitions r3 = (DefinitionsDocument.Definitions) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), DefinitionsDocument.Definitions.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setDefinitions(DefinitionsDocument.Definitions r4) {
        generatedSetterHelperImpl((DefinitionsDocument.Definitions) ZeusTransformUtils.wrapperContextForParams(r4, DefinitionsDocument.Definitions.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
