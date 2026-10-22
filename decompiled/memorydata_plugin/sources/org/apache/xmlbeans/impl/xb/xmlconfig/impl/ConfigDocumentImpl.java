package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* JADX INFO: loaded from: classes7.dex */
public class ConfigDocumentImpl extends XmlComplexContentImpl implements ConfigDocument {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class ConfigImpl extends XmlComplexContentImpl implements ConfigDocument.Config {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        static {
            PROPERTY_QNAME = new QName[]{new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "namespace"), new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "qname"), new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "extension"), new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "usertype")};
        }

        public ConfigImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public Extensionconfig addNewExtension() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            Extensionconfig r3 = (Extensionconfig) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), Extensionconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public Nsconfig addNewNamespace() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            Nsconfig r3 = (Nsconfig) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), Nsconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public Qnameconfig addNewQname() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            Qnameconfig r3 = (Qnameconfig) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), Qnameconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public Usertypeconfig addNewUsertype() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            Usertypeconfig r3 = (Usertypeconfig) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), Usertypeconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public Extensionconfig getExtensionArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            Extensionconfig r3 = (Extensionconfig) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), Extensionconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public Extensionconfig[] getExtensionArray() {
            return (Extensionconfig[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[2], new Extensionconfig[0]), Extensionconfig[].class, "com.obric.memorydata.plugin");
        }

        public List<Extensionconfig> getExtensionList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Ri9YSJTS3pAEZFr4T_Cnr4VuDRk(this), new $$Lambda$6OH1qicJp77VV2DR7AB8ZQYskQg(this), new $$Lambda$cisXGPCf6FbDrQlyGDHn0no665E(this), new $$Lambda$lWJ60xRSLBYQmEvWuKFDGB6fyUg(this), new $$Lambda$6qtUcGsY6xiEbkMGThPYdCd4(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public Nsconfig getNamespaceArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            Nsconfig r3 = (Nsconfig) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), Nsconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public Nsconfig[] getNamespaceArray() {
            return (Nsconfig[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new Nsconfig[0]), Nsconfig[].class, "com.obric.memorydata.plugin");
        }

        public List<Nsconfig> getNamespaceList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Sgk2yC5aDKVWG6Wd0OZwt9r8iJI(this), new $$Lambda$zZ_ZzlBOTJkm39CIstJu6YQcfFg(this), new $$Lambda$wc74UyzN39F_yECZzXfiGnVIK6M(this), new $$Lambda$7Db3tvXvb0nH8QmTOYNUKSVgqwc(this), new $$Lambda$aF1MejfTH_Y0vj8Rk6YkAzVeIg(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public Qnameconfig getQnameArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            Qnameconfig r3 = (Qnameconfig) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), Qnameconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public Qnameconfig[] getQnameArray() {
            return (Qnameconfig[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[1], new Qnameconfig[0]), Qnameconfig[].class, "com.obric.memorydata.plugin");
        }

        public List<Qnameconfig> getQnameList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$fvCJcFwr8TMghSbGEKnlrBN1ps(this), new $$Lambda$MhNgvK1fvbZiuC4HMyw3bzxuALY(this), new $$Lambda$4r37fAxAnHOrTPwoTs76gYYQd4o(this), new $$Lambda$9UThNwM55nvjN8MLYHsUD5Hstw(this), new $$Lambda$RPpaWp9QE4DxLNbhTEnlNKZvJKs(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public Usertypeconfig getUsertypeArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            Usertypeconfig r3 = (Usertypeconfig) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), Usertypeconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public Usertypeconfig[] getUsertypeArray() {
            return (Usertypeconfig[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[3], new Usertypeconfig[0]), Usertypeconfig[].class, "com.obric.memorydata.plugin");
        }

        public List<Usertypeconfig> getUsertypeList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$va_Z3sZm8MEDBNk4jDviDE9Rsw(this), new $$Lambda$s_l6oafkStAcJvYgBcdnGTRBWyI(this), new $$Lambda$SFBHS7AFQ3SQfNDwjo8D8Ndsn3o(this), new $$Lambda$pAz65shrS7HRyIK612OQugX3Sk(this), new $$Lambda$iDvAcNfm4fblp7GUCMEePhj8(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        public Extensionconfig insertNewExtension(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            Extensionconfig r3 = (Extensionconfig) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), Extensionconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public Nsconfig insertNewNamespace(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            Nsconfig r3 = (Nsconfig) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), Nsconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public Qnameconfig insertNewQname(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            Qnameconfig r3 = (Qnameconfig) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), Qnameconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public Usertypeconfig insertNewUsertype(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            Usertypeconfig r3 = (Usertypeconfig) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), Usertypeconfig.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeExtension(int r4) {
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

        public void removeNamespace(int r4) {
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

        public void removeQname(int r4) {
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

        public void removeUsertype(int r4) {
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

        public void setExtensionArray(int r3, Extensionconfig r4) {
            generatedSetterHelperImpl((Extensionconfig) ZeusTransformUtils.wrapperContextForParams(r4, Extensionconfig.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], r3, 2);
        }

        public void setExtensionArray(Extensionconfig[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[2]);
        }

        public void setNamespaceArray(int r3, Nsconfig r4) {
            generatedSetterHelperImpl((Nsconfig) ZeusTransformUtils.wrapperContextForParams(r4, Nsconfig.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
        }

        public void setNamespaceArray(Nsconfig[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[0]);
        }

        public void setQnameArray(int r3, Qnameconfig r4) {
            generatedSetterHelperImpl((Qnameconfig) ZeusTransformUtils.wrapperContextForParams(r4, Qnameconfig.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], r3, 2);
        }

        public void setQnameArray(Qnameconfig[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[1]);
        }

        public void setUsertypeArray(int r3, Usertypeconfig r4) {
            generatedSetterHelperImpl((Usertypeconfig) ZeusTransformUtils.wrapperContextForParams(r4, Usertypeconfig.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], r3, 2);
        }

        public void setUsertypeArray(Usertypeconfig[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[3]);
        }

        public int sizeOfExtensionArray() {
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

        public int sizeOfNamespaceArray() {
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

        public int sizeOfQnameArray() {
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

        public int sizeOfUsertypeArray() {
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
    }

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "config")};
    }

    public ConfigDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public ConfigDocument.Config addNewConfig() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ConfigDocument.Config r3 = (ConfigDocument.Config) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), ConfigDocument.Config.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ConfigDocument.Config getConfig() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ConfigDocument.Config r3 = (ConfigDocument.Config) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), ConfigDocument.Config.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setConfig(ConfigDocument.Config r4) {
        generatedSetterHelperImpl((ConfigDocument.Config) ZeusTransformUtils.wrapperContextForParams(r4, ConfigDocument.Config.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
