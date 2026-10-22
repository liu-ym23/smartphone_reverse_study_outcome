package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ColorsType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSheetType;
import com.microsoft.schemas.office.visio.x2012.main.EventListType;
import com.microsoft.schemas.office.visio.x2012.main.FaceNamesType;
import com.microsoft.schemas.office.visio.x2012.main.HeaderFooterType;
import com.microsoft.schemas.office.visio.x2012.main.PublishSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.d;
import com.microsoft.schemas.office.visio.x2012.main.v;
import com.microsoft.schemas.office.visio.x2012.main.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: classes3.dex */
public class VisioDocumentTypeImpl extends XmlComplexContentImpl implements z {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("http://schemas.microsoft.com/office/visio/2012/main", "DocumentSettings"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "Colors"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "FaceNames"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "StyleSheets"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "DocumentSheet"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "EventList"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "HeaderFooter"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "PublishSettings")};
    }

    public VisioDocumentTypeImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    public ColorsType addNewColors() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ColorsType r3 = (ColorsType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), ColorsType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public d addNewDocumentSettings() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        d r3 = (d) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public DocumentSheetType addNewDocumentSheet() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        DocumentSheetType r3 = (DocumentSheetType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), DocumentSheetType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public EventListType addNewEventList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        EventListType r3 = (EventListType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), EventListType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public FaceNamesType addNewFaceNames() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        FaceNamesType r3 = (FaceNamesType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), FaceNamesType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public HeaderFooterType addNewHeaderFooter() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        HeaderFooterType r3 = (HeaderFooterType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), HeaderFooterType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public PublishSettingsType addNewPublishSettings() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        PublishSettingsType r3 = (PublishSettingsType) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), PublishSettingsType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public v addNewStyleSheets() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        v r3 = (v) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), v.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public ColorsType getColors() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        ColorsType r3 = (ColorsType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], 0), ColorsType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public d getDocumentSettings() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        d r3 = (d) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], 0), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public DocumentSheetType getDocumentSheet() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        DocumentSheetType r3 = (DocumentSheetType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], 0), DocumentSheetType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public EventListType getEventList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        EventListType r3 = (EventListType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], 0), EventListType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public FaceNamesType getFaceNames() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        FaceNamesType r3 = (FaceNamesType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], 0), FaceNamesType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public HeaderFooterType getHeaderFooter() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        HeaderFooterType r3 = (HeaderFooterType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], 0), HeaderFooterType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public PublishSettingsType getPublishSettings() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        PublishSettingsType r3 = (PublishSettingsType) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], 0), PublishSettingsType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public v getStyleSheets() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L9
        v r3 = (v) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], 0), v.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isSetColors() {
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

    public boolean isSetDocumentSettings() {
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

    public boolean isSetDocumentSheet() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[4]) == 0) goto L7;
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

    public boolean isSetEventList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[5]) == 0) goto L7;
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

    public boolean isSetFaceNames() {
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

    public boolean isSetHeaderFooter() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[6]) == 0) goto L7;
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

    public boolean isSetPublishSettings() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        if (get_store().count_elements(PROPERTY_QNAME[7]) == 0) goto L7;
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

    public boolean isSetStyleSheets() {
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

    public void setColors(ColorsType r4) {
        generatedSetterHelperImpl((ColorsType) ZeusTransformUtils.wrapperContextForParams(r4, ColorsType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[1], 0, 1);
    }

    public void setDocumentSettings(d r4) {
        generatedSetterHelperImpl((d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[0], 0, 1);
    }

    public void setDocumentSheet(DocumentSheetType r4) {
        generatedSetterHelperImpl((DocumentSheetType) ZeusTransformUtils.wrapperContextForParams(r4, DocumentSheetType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[4], 0, 1);
    }

    public void setEventList(EventListType r4) {
        generatedSetterHelperImpl((EventListType) ZeusTransformUtils.wrapperContextForParams(r4, EventListType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[5], 0, 1);
    }

    public void setFaceNames(FaceNamesType r4) {
        generatedSetterHelperImpl((FaceNamesType) ZeusTransformUtils.wrapperContextForParams(r4, FaceNamesType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[2], 0, 1);
    }

    public void setHeaderFooter(HeaderFooterType r4) {
        generatedSetterHelperImpl((HeaderFooterType) ZeusTransformUtils.wrapperContextForParams(r4, HeaderFooterType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[6], 0, 1);
    }

    public void setPublishSettings(PublishSettingsType r4) {
        generatedSetterHelperImpl((PublishSettingsType) ZeusTransformUtils.wrapperContextForParams(r4, PublishSettingsType.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[7], 0, 1);
    }

    public void setStyleSheets(v r4) {
        generatedSetterHelperImpl((v) ZeusTransformUtils.wrapperContextForParams(r4, v.class, "com.obric.memorydata.plugin"), PROPERTY_QNAME[3], 0, 1);
    }

    public void unsetColors() {
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

    public void unsetDocumentSettings() {
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

    public void unsetDocumentSheet() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[4], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetEventList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[5], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetFaceNames() {
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

    public void unsetHeaderFooter() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[6], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetPublishSettings() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[7], 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unsetStyleSheets() {
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
