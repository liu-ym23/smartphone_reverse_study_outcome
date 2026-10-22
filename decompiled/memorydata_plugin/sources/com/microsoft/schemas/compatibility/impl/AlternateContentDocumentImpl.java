package com.microsoft.schemas.compatibility.impl;

import com.microsoft.schemas.compatibility.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: classes3.dex */
public class AlternateContentDocumentImpl extends XmlComplexContentImpl implements a {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    public static class AlternateContentImpl extends XmlComplexContentImpl implements a.InterfaceC0224a {
        private static final QName[] PROPERTY_QNAME = null;
        private static final long serialVersionUID = 1;

        public static class ChoiceImpl extends XmlComplexContentImpl implements a.InterfaceC0224a.InterfaceC0225a {
            private static final QName[] PROPERTY_QNAME = null;
            private static final long serialVersionUID = 1;

            static {
                PROPERTY_QNAME = new QName[]{new QName("", "Requires"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "Ignorable"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "MustUnderstand"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "ProcessContent")};
            }

            public ChoiceImpl(SchemaType r3) {
                super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
            }

            public String getIgnorable() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            public String getMustUnderstand() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            public String getProcessContent() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            @Override // com.microsoft.schemas.compatibility.a.InterfaceC0224a.InterfaceC0225a
            public String getRequires() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            public boolean isSetIgnorable() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                boolean r2 = true;
                if (get_store().find_attribute_user(PROPERTY_QNAME[1]) != null) goto L8;
                r2 = false;
            L8:
                monitor-exit(r0);     // Catch: Throwable -> L10
                return r2;
            L10:
                th = move-exception;
                throw th;
            }

            public boolean isSetMustUnderstand() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                if (get_store().find_attribute_user(PROPERTY_QNAME[2]) == null) goto L7;
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

            public boolean isSetProcessContent() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                if (get_store().find_attribute_user(PROPERTY_QNAME[3]) == null) goto L7;
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

            public void setIgnorable(String r7) {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.setStringValue(r7);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void setMustUnderstand(String r7) {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.setStringValue(r7);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void setProcessContent(String r7) {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.setStringValue(r7);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void setRequires(String r7) {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.setStringValue(r7);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void unsetIgnorable() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                get_store().remove_attribute(PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public void unsetMustUnderstand() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                get_store().remove_attribute(PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public void unsetProcessContent() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                get_store().remove_attribute(PROPERTY_QNAME[3]);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public XmlString xgetIgnorable() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r3;
            L7:
                th = move-exception;
                throw th;
            }

            public XmlString xgetMustUnderstand() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r3;
            L7:
                th = move-exception;
                throw th;
            }

            public XmlString xgetProcessContent() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[3]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r3;
            L7:
                th = move-exception;
                throw th;
            }

            public XmlString xgetRequires() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r3;
            L7:
                th = move-exception;
                throw th;
            }

            public void xsetIgnorable(XmlString r7) {
                XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.set(r8);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void xsetMustUnderstand(XmlString r7) {
                XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.set(r8);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void xsetProcessContent(XmlString r7) {
                XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[3]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.set(r8);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void xsetRequires(XmlString r7) {
                XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.set(r8);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }
        }

        public static class FallbackImpl extends XmlComplexContentImpl implements a.InterfaceC0224a.b {
            private static final QName[] PROPERTY_QNAME = null;
            private static final long serialVersionUID = 1;

            static {
                PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "Ignorable"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "MustUnderstand"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "ProcessContent")};
            }

            public FallbackImpl(SchemaType r3) {
                super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
            }

            public String getIgnorable() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            public String getMustUnderstand() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            public String getProcessContent() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

            public boolean isSetIgnorable() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L9
                boolean r2 = false;
                if (get_store().find_attribute_user(PROPERTY_QNAME[0]) == null) goto L7;
                r2 = true;
            L7:
                monitor-exit(r0);     // Catch: Throwable -> L9
                return r2;
            L9:
                th = move-exception;
                throw th;
            }

            public boolean isSetMustUnderstand() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                boolean r2 = true;
                if (get_store().find_attribute_user(PROPERTY_QNAME[1]) != null) goto L8;
                r2 = false;
            L8:
                monitor-exit(r0);     // Catch: Throwable -> L10
                return r2;
            L10:
                th = move-exception;
                throw th;
            }

            public boolean isSetProcessContent() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                if (get_store().find_attribute_user(PROPERTY_QNAME[2]) == null) goto L7;
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

            public void setIgnorable(String r7) {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.setStringValue(r7);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void setMustUnderstand(String r7) {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.setStringValue(r7);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void setProcessContent(String r7) {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.setStringValue(r7);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void unsetIgnorable() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                get_store().remove_attribute(PROPERTY_QNAME[0]);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public void unsetMustUnderstand() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                get_store().remove_attribute(PROPERTY_QNAME[1]);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public void unsetProcessContent() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                get_store().remove_attribute(PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public XmlString xgetIgnorable() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[0]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r3;
            L7:
                th = move-exception;
                throw th;
            }

            public XmlString xgetMustUnderstand() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[1]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r3;
            L7:
                th = move-exception;
                throw th;
            }

            public XmlString xgetProcessContent() {
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L7
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r3;
            L7:
                th = move-exception;
                throw th;
            }

            public void xsetIgnorable(XmlString r7) {
                XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[0]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[0]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.set(r8);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void xsetMustUnderstand(XmlString r7) {
                XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[1]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[1]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.set(r8);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public void xsetProcessContent(XmlString r7) {
                XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
                Object r0 = monitor();
                monitor-enter(r0);
                check_orphaned();     // Catch: Throwable -> L10
                TypeStore r1 = get_store();     // Catch: Throwable -> L10
                QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
                XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
                if (r3 != null) goto L7;
                r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L7:
                r3.set(r8);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }
        }

        static {
            PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "Choice"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "Fallback"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "Ignorable"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "MustUnderstand"), new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "ProcessContent")};
        }

        public AlternateContentImpl(SchemaType r3) {
            super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
        }

        public a.InterfaceC0224a.InterfaceC0225a addNewChoice() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            a.InterfaceC0224a.InterfaceC0225a r3 = (a.InterfaceC0224a.InterfaceC0225a) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), a.InterfaceC0224a.InterfaceC0225a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public a.InterfaceC0224a.b addNewFallback() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            a.InterfaceC0224a.b r3 = (a.InterfaceC0224a.b) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), a.InterfaceC0224a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.microsoft.schemas.compatibility.a.InterfaceC0224a
        public a.InterfaceC0224a.InterfaceC0225a getChoiceArray(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            a.InterfaceC0224a.InterfaceC0225a r3 = (a.InterfaceC0224a.InterfaceC0225a) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), a.InterfaceC0224a.InterfaceC0225a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 == null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L9:
            throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public a.InterfaceC0224a.InterfaceC0225a[] getChoiceArray() {
            return (a.InterfaceC0224a.InterfaceC0225a[]) ZeusTransformUtils.preCheckCast(getXmlObjectArray(PROPERTY_QNAME[0], new a.InterfaceC0224a.InterfaceC0225a[0]), a.InterfaceC0224a.InterfaceC0225a[].class, "com.obric.memorydata.plugin");
        }

        public List<a.InterfaceC0224a.InterfaceC0225a> getChoiceList() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$OJt78Q_vC1H9zTI2cEmNKEBmqkc(this), new $$Lambda$xkWkch3RKdcQGFUehvridvl0rT0(this), new $$Lambda$dDGE7ytyk03Wcky3nKdXBFsGBoQ(this), new $$Lambda$106NsP69Jl51a2zd4AdZ7RhFT1w(this), new $$Lambda$HLtC_TaA2veSaeWKoxjTv7DkkIY(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r7;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.microsoft.schemas.compatibility.a.InterfaceC0224a
        public a.InterfaceC0224a.b getFallback() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L9
            a.InterfaceC0224a.b r3 = (a.InterfaceC0224a.b) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], 0), a.InterfaceC0224a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r3 != null) goto L7;
            r3 = null;
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        public String getIgnorable() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public String getMustUnderstand() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public String getProcessContent() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[4]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
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

        public a.InterfaceC0224a.InterfaceC0225a insertNewChoice(int r4) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            a.InterfaceC0224a.InterfaceC0225a r3 = (a.InterfaceC0224a.InterfaceC0225a) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), a.InterfaceC0224a.InterfaceC0225a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.microsoft.schemas.compatibility.a.InterfaceC0224a
        public boolean isSetFallback() {
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

        public boolean isSetIgnorable() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[2]) == null) goto L7;
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

        public boolean isSetMustUnderstand() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[3]) == null) goto L7;
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

        public boolean isSetProcessContent() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            if (get_store().find_attribute_user(PROPERTY_QNAME[4]) == null) goto L7;
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

        public void removeChoice(int r4) {
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

        public void setChoiceArray(int r3, a.InterfaceC0224a.InterfaceC0225a r4) {
            generatedSetterHelperImpl((a.InterfaceC0224a.InterfaceC0225a) ZeusTransformUtils.wrapperContextForParams(r4, a.InterfaceC0224a.InterfaceC0225a.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], r3, 2);
        }

        public void setChoiceArray(a.InterfaceC0224a.InterfaceC0225a[] r3) {
            check_orphaned();
            arraySetterHelper(r3, PROPERTY_QNAME[0]);
        }

        public void setFallback(a.InterfaceC0224a.b r4) {
            generatedSetterHelperImpl((a.InterfaceC0224a.b) ZeusTransformUtils.wrapperContextForParams(r4, a.InterfaceC0224a.b.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], 0, 1);
        }

        public void setIgnorable(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setMustUnderstand(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[3]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setProcessContent(String r7) {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[4]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[4]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.setStringValue(r7);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.microsoft.schemas.compatibility.a.InterfaceC0224a
        public int sizeOfChoiceArray() {
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

        public void unsetFallback() {
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

        public void unsetIgnorable() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[2]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetMustUnderstand() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[3]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unsetProcessContent() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            get_store().remove_attribute(PROPERTY_QNAME[4]);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlString xgetIgnorable() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlString xgetMustUnderstand() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[3]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public XmlString xgetProcessContent() {
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L7
            XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[4]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        public void xsetIgnorable(XmlString r7) {
            XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetMustUnderstand(XmlString r7) {
            XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[3]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[3]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void xsetProcessContent(XmlString r7) {
            XmlString r8 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r7, XmlString.class, "com.obric.memorydata.plugin");
            Object r0 = monitor();
            monitor-enter(r0);
            check_orphaned();     // Catch: Throwable -> L10
            TypeStore r1 = get_store();     // Catch: Throwable -> L10
            QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
            XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[4]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r3 != null) goto L7;
            r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[4]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            r3.set(r8);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "AlternateContent")};
    }

    public AlternateContentDocumentImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public a.InterfaceC0224a addNewAlternateContent() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        a.InterfaceC0224a r3 = (a.InterfaceC0224a) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), a.InterfaceC0224a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.microsoft.schemas.compatibility.a
    public a.InterfaceC0224a getAlternateContent() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        a.InterfaceC0224a r3 = (a.InterfaceC0224a) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), a.InterfaceC0224a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void setAlternateContent(a.InterfaceC0224a r4) {
        generatedSetterHelperImpl((a.InterfaceC0224a) ZeusTransformUtils.wrapperContextForParams(r4, a.InterfaceC0224a.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }
}
