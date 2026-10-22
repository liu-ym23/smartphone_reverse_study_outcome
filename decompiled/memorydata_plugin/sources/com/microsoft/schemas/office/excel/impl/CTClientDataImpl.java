package com.microsoft.schemas.office.excel.impl;

import com.microsoft.schemas.office.excel.STObjectType;
import com.microsoft.schemas.office.excel.a;
import com.microsoft.schemas.office.excel.b;
import com.tom_roush.pdfbox.pdmodel.a.d.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaListObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: loaded from: classes3.dex */
public class CTClientDataImpl extends XmlComplexContentImpl implements a {
    private static final QName[] PROPERTY_QNAME = null;
    private static final long serialVersionUID = 1;

    static {
        PROPERTY_QNAME = new QName[]{new QName("urn:schemas-microsoft-com:office:excel", "MoveWithCells"), new QName("urn:schemas-microsoft-com:office:excel", "SizeWithCells"), new QName("urn:schemas-microsoft-com:office:excel", "Anchor"), new QName("urn:schemas-microsoft-com:office:excel", "Locked"), new QName("urn:schemas-microsoft-com:office:excel", "DefaultSize"), new QName("urn:schemas-microsoft-com:office:excel", "PrintObject"), new QName("urn:schemas-microsoft-com:office:excel", "Disabled"), new QName("urn:schemas-microsoft-com:office:excel", "AutoFill"), new QName("urn:schemas-microsoft-com:office:excel", "AutoLine"), new QName("urn:schemas-microsoft-com:office:excel", "AutoPict"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaMacro"), new QName("urn:schemas-microsoft-com:office:excel", "TextHAlign"), new QName("urn:schemas-microsoft-com:office:excel", "TextVAlign"), new QName("urn:schemas-microsoft-com:office:excel", "LockText"), new QName("urn:schemas-microsoft-com:office:excel", "JustLastX"), new QName("urn:schemas-microsoft-com:office:excel", "SecretEdit"), new QName("urn:schemas-microsoft-com:office:excel", "Default"), new QName("urn:schemas-microsoft-com:office:excel", "Help"), new QName("urn:schemas-microsoft-com:office:excel", "Cancel"), new QName("urn:schemas-microsoft-com:office:excel", "Dismiss"), new QName("urn:schemas-microsoft-com:office:excel", "Accel"), new QName("urn:schemas-microsoft-com:office:excel", "Accel2"), new QName("urn:schemas-microsoft-com:office:excel", h.i), new QName("urn:schemas-microsoft-com:office:excel", h.h), new QName("urn:schemas-microsoft-com:office:excel", "Visible"), new QName("urn:schemas-microsoft-com:office:excel", "RowHidden"), new QName("urn:schemas-microsoft-com:office:excel", "ColHidden"), new QName("urn:schemas-microsoft-com:office:excel", "VTEdit"), new QName("urn:schemas-microsoft-com:office:excel", "MultiLine"), new QName("urn:schemas-microsoft-com:office:excel", "VScroll"), new QName("urn:schemas-microsoft-com:office:excel", "ValidIds"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaRange"), new QName("urn:schemas-microsoft-com:office:excel", "WidthMin"), new QName("urn:schemas-microsoft-com:office:excel", "Sel"), new QName("urn:schemas-microsoft-com:office:excel", "NoThreeD2"), new QName("urn:schemas-microsoft-com:office:excel", "SelType"), new QName("urn:schemas-microsoft-com:office:excel", "MultiSel"), new QName("urn:schemas-microsoft-com:office:excel", "LCT"), new QName("urn:schemas-microsoft-com:office:excel", "ListItem"), new QName("urn:schemas-microsoft-com:office:excel", "DropStyle"), new QName("urn:schemas-microsoft-com:office:excel", "Colored"), new QName("urn:schemas-microsoft-com:office:excel", "DropLines"), new QName("urn:schemas-microsoft-com:office:excel", "Checked"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaLink"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaPict"), new QName("urn:schemas-microsoft-com:office:excel", "NoThreeD"), new QName("urn:schemas-microsoft-com:office:excel", "FirstButton"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaGroup"), new QName("urn:schemas-microsoft-com:office:excel", "Val"), new QName("urn:schemas-microsoft-com:office:excel", "Min"), new QName("urn:schemas-microsoft-com:office:excel", "Max"), new QName("urn:schemas-microsoft-com:office:excel", "Inc"), new QName("urn:schemas-microsoft-com:office:excel", "Page"), new QName("urn:schemas-microsoft-com:office:excel", "Horiz"), new QName("urn:schemas-microsoft-com:office:excel", "Dx"), new QName("urn:schemas-microsoft-com:office:excel", "MapOCX"), new QName("urn:schemas-microsoft-com:office:excel", "CF"), new QName("urn:schemas-microsoft-com:office:excel", "Camera"), new QName("urn:schemas-microsoft-com:office:excel", "RecalcAlways"), new QName("urn:schemas-microsoft-com:office:excel", "AutoScale"), new QName("urn:schemas-microsoft-com:office:excel", "DDE"), new QName("urn:schemas-microsoft-com:office:excel", "UIObj"), new QName("urn:schemas-microsoft-com:office:excel", "ScriptText"), new QName("urn:schemas-microsoft-com:office:excel", "ScriptExtended"), new QName("urn:schemas-microsoft-com:office:excel", "ScriptLanguage"), new QName("urn:schemas-microsoft-com:office:excel", "ScriptLocation"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaTxbx"), new QName("", "ObjectType")};
    }

    public CTClientDataImpl(SchemaType r3) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ BigInteger[] lambda$getAccel2Array$42(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getAccelArray$40(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ String[] lambda$getAnchorArray$4(int r0) {
        return new String[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getAutoFillArray$14(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getAutoLineArray$16(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getAutoPictArray$18(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getAutoScaleArray$118(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ String[] lambda$getCFArray$112(int r0) {
        return new String[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getCameraArray$114(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getCancelArray$36(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getCheckedArray$84(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getColHiddenArray$52(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getColoredArray$80(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getColumnArray$46(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDDEArray$120(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDefaultArray$32(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDefaultSizeArray$8(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDisabledArray$12(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDismissArray$38(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getDropLinesArray$82(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ String[] lambda$getDropStyleArray$78(int r0) {
        return new String[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getDxArray$108(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getFirstButtonArray$92(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ String[] lambda$getFmlaGroupArray$94(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getFmlaLinkArray$86(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getFmlaMacroArray$20(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getFmlaPictArray$88(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getFmlaRangeArray$62(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getFmlaTxbxArray$132(int r0) {
        return new String[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getHelpArray$34(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getHorizArray$106(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getIncArray$102(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getJustLastXArray$28(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ String[] lambda$getLCTArray$74(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getListItemArray$76(int r0) {
        return new String[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getLockTextArray$26(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getLockedArray$6(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getMapOCXArray$110(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getMaxArray$100(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getMinArray$98(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getMoveWithCellsArray$0(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getMultiLineArray$56(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ String[] lambda$getMultiSelArray$72(int r0) {
        return new String[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getNoThreeD2Array$68(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getNoThreeDArray$90(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getPageArray$104(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getPrintObjectArray$10(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getRecalcAlwaysArray$116(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getRowArray$44(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getRowHiddenArray$50(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ String[] lambda$getScriptExtendedArray$126(int r0) {
        return new String[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getScriptLanguageArray$128(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getScriptLocationArray$130(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ String[] lambda$getScriptTextArray$124(int r0) {
        return new String[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getSecretEditArray$30(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getSelArray$66(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ String[] lambda$getSelTypeArray$70(int r0) {
        return new String[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getSizeWithCellsArray$2(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ String[] lambda$getTextHAlignArray$22(int r0) {
        return new String[r0];
    }

    static /* synthetic */ String[] lambda$getTextVAlignArray$24(int r0) {
        return new String[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getUIObjArray$122(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getVScrollArray$58(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getVTEditArray$54(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getValArray$96(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getValidIdsArray$60(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getVisibleArray$48(int r0) {
        return new STTrueFalseBlank.Enum[r0];
    }

    static /* synthetic */ BigInteger[] lambda$getWidthMinArray$64(int r0) {
        return new BigInteger[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetAccel2Array$43(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetAccelArray$41(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetAnchorArray$5(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetAutoFillArray$15(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetAutoLineArray$17(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetAutoPictArray$19(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetAutoScaleArray$119(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ b[] lambda$xgetCFArray$113(int r0) {
        return new b[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetCameraArray$115(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetCancelArray$37(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetCheckedArray$85(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetColHiddenArray$53(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetColoredArray$81(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetColumnArray$47(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetDDEArray$121(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetDefaultArray$33(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetDefaultSizeArray$9(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetDisabledArray$13(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetDismissArray$39(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetDropLinesArray$83(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetDropStyleArray$79(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetDxArray$109(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetFirstButtonArray$93(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetFmlaGroupArray$95(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetFmlaLinkArray$87(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetFmlaMacroArray$21(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetFmlaPictArray$89(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetFmlaRangeArray$63(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetFmlaTxbxArray$133(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetHelpArray$35(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetHorizArray$107(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetIncArray$103(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetJustLastXArray$29(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetLCTArray$75(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetListItemArray$77(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetLockTextArray$27(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetLockedArray$7(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetMapOCXArray$111(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetMaxArray$101(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetMinArray$99(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetMoveWithCellsArray$1(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetMultiLineArray$57(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetMultiSelArray$73(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetNoThreeD2Array$69(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetNoThreeDArray$91(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetPageArray$105(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetPrintObjectArray$11(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetRecalcAlwaysArray$117(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetRowArray$45(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetRowHiddenArray$51(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetScriptExtendedArray$127(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlNonNegativeInteger[] lambda$xgetScriptLanguageArray$129(int r0) {
        return new XmlNonNegativeInteger[r0];
    }

    static /* synthetic */ XmlNonNegativeInteger[] lambda$xgetScriptLocationArray$131(int r0) {
        return new XmlNonNegativeInteger[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetScriptTextArray$125(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetSecretEditArray$31(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetSelArray$67(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetSelTypeArray$71(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetSizeWithCellsArray$3(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetTextHAlignArray$23(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ XmlString[] lambda$xgetTextVAlignArray$25(int r0) {
        return new XmlString[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetUIObjArray$123(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetVScrollArray$59(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetVTEditArray$55(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetValArray$97(int r0) {
        return new XmlInteger[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetValidIdsArray$61(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ STTrueFalseBlank[] lambda$xgetVisibleArray$49(int r0) {
        return new STTrueFalseBlank[r0];
    }

    static /* synthetic */ XmlInteger[] lambda$xgetWidthMinArray$65(int r0) {
        return new XmlInteger[r0];
    }

    public void addAccel(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[20]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAccel2(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[21]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAnchor(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAutoFill(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAutoLine(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAutoPict(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAutoScale(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[59]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addCF(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[56]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addCamera(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[57]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addCancel(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[18]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addChecked(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[42]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addColHidden(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[26]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addColored(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[40]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addColumn(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[23]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDDE(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[60]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDefault(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[16]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDefaultSize(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDisabled(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDismiss(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[19]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDropLines(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[41]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDropStyle(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[39]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDx(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[54]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFirstButton(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[46]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFmlaGroup(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[47]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFmlaLink(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[43]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFmlaMacro(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFmlaPict(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[44]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFmlaRange(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[31]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFmlaTxbx(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[66]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addHelp(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[17]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addHoriz(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[53]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addInc(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[51]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addJustLastX(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addLCT(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[37]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addListItem(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[38]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addLockText(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addLocked(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addMapOCX(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[55]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addMax(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[50]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addMin(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[49]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addMoveWithCells(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addMultiLine(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[28]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addMultiSel(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[36]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewAccel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[20]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewAccel2() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[21]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewAnchor() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[2]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewAutoFill() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[7]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewAutoLine() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[8]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewAutoPict() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[9]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewAutoScale() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[59]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public b addNewCF() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        b r3 = (b) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[56]), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewCamera() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[57]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewCancel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[18]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewChecked() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[42]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewColHidden() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[26]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewColored() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[40]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewColumn() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[23]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewDDE() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[60]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewDefault() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[16]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewDefaultSize() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[4]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewDisabled() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[6]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewDismiss() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[19]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewDropLines() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[41]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewDropStyle() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[39]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewDx() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[54]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewFirstButton() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[46]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewFmlaGroup() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[47]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewFmlaLink() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[43]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewFmlaMacro() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[10]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewFmlaPict() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[44]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewFmlaRange() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[31]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewFmlaTxbx() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[66]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewHelp() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[17]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewHoriz() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[53]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewInc() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[51]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewJustLastX() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[14]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewLCT() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[37]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewListItem() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[38]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewLockText() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[13]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewLocked() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[3]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewMapOCX() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[55]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewMax() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[50]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewMin() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[49]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewMoveWithCells() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[0]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewMultiLine() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[28]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewMultiSel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[36]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewNoThreeD() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[45]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewNoThreeD2() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[34]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewPage() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[52]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewPrintObject() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewRecalcAlways() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[58]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewRow() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[22]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewRowHidden() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[25]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewScriptExtended() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[63]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlNonNegativeInteger addNewScriptLanguage() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[64]), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlNonNegativeInteger addNewScriptLocation() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[65]), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewScriptText() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[62]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewSecretEdit() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[15]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewSel() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[33]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewSelType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[35]), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewSizeWithCells() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString addNewTextHAlign() {
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

    public XmlString addNewTextVAlign() {
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

    public STTrueFalseBlank addNewUIObj() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[61]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewVScroll() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[29]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewVTEdit() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[27]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewVal() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[48]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewValidIds() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[30]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank addNewVisible() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[24]), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger addNewWidthMin() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[32]), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void addNoThreeD(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[45]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addNoThreeD2(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[34]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addPage(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[52]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addPrintObject(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[5]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addRecalcAlways(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[58]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addRow(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[22]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addRowHidden(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[25]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addScriptExtended(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[63]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addScriptLanguage(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[64]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addScriptLocation(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[65]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addScriptText(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[62]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addSecretEdit(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[15]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addSel(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[33]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addSelType(String r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[35]), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addSizeWithCells(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[1]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addTextHAlign(String r4) {
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

    public void addTextVAlign(String r4) {
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

    public void addUIObj(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[61]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addVScroll(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[29]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addVTEdit(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[27]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addVal(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[48]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addValidIds(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[30]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addVisible(STTrueFalseBlank.Enum r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[24]), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addWidthMin(BigInteger r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_element_user(PROPERTY_QNAME[32]), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getAccel2Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[21], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getAccel2Array() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[21], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$XJxNC9AtnOUuozs5ucQL9p2amA.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getAccel2List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$9TE2MXu5xd6D9USXe3zZtBRnuUM(this), new $$Lambda$MxE5E07hGN8qptUAlWkWxG3sHBs(this), new $$Lambda$4Au5YEVkdJ1nNaH9N1N663LqH3A(this), new $$Lambda$3YnKjk2tsetd7ONyhLcoxXUYUdA(this), new $$Lambda$2Yedp1qIwrlR2TJ845f2Zc0vZq0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getAccelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[20], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getAccelArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[20], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$SQchtgSODjvybJQnwtZYNiGFBC0.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getAccelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$svhZ9VyGeIKu31vDuD7w9e2MxNY(this), new $$Lambda$uNprpMj6XaA3ibhca954sbbF8E0(this), new $$Lambda$5sGAUgCqlTkF6SOVmOjzCn0_E(this), new $$Lambda$IMQlckqiJ6we7sOCtscC609DQ(this), new $$Lambda$5BQSXDryEcWAWu9VG0GhUeqxiUw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getAnchorArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getAnchorArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[2], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$1B4bbvuYP0ZRmKj6nW9zWIyMyUI.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getAnchorList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$1wpl6DgrUpv6MGCnhBf7eSUK1TA(this), new $$Lambda$ITFwAPlgKVRruRD0TbJLIe0wDM(this), new $$Lambda$8GfePturKE91Y8YRgvizfFXacU(this), new $$Lambda$rSWxinzNEJY0IvN0FrtdLssipLg(this), new $$Lambda$CiZLLcvE_Dk6Xo7_EKVlIHRBk0k(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getAutoFillArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getAutoFillArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[7], $$Lambda$CTClientDataImpl$x3fTI_oDgkdi34QnHO6dcMbod4.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getAutoFillList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$gnJAs_VfiShutxo84rOzqE64(this), new $$Lambda$wfykx7HSvcT5ZgtDg9dX9nqe6XM(this), new $$Lambda$ht7CEb7CIYCTGISEEsMxnB3ob64(this), new $$Lambda$4BL35YWmRBiY_dOYT4u3OF6YQdU(this), new $$Lambda$wfla1uDYVcwULzmZGFjOuP24aH4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getAutoLineArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getAutoLineArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[8], $$Lambda$CTClientDataImpl$A5pcUd9FLH8ajIbKKuv4EiPsM.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getAutoLineList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$hcFpgdClqAmR0P7ILzJsaEPyZnQ(this), new $$Lambda$hIiJ56r2ZJSCc_ngcoYVDRuUcs(this), new $$Lambda$a7Dq8C1q7XKbkiaW81I3krh_Y(this), new $$Lambda$oflvmwAGSu8DXQloi9AunJ2m4ec(this), new $$Lambda$Iz2bJfdRt6JF4tT0krhqYt_3h2c(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getAutoPictArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getAutoPictArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[9], $$Lambda$CTClientDataImpl$DcPXa5GX1hTcG6pCqf6FnVLsxtc.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getAutoPictList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$J3F5T2evfZGOrf4Lu_NdQEo2CDk(this), new $$Lambda$8Euq1_JhS37A6A2vDuZsnxH1XcA(this), new $$Lambda$4xTYePGP6RYYq54cO87YkYtjAzg(this), new $$Lambda$El1rNzoHvGO3plxtyw36utsVU(this), new $$Lambda$t5vXcCKKIH9TKorK9GiON_4xn84(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getAutoScaleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[59], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getAutoScaleArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[59], $$Lambda$CTClientDataImpl$u785iTgxBmuwgZPNxYCuiQ0JzwQ.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getAutoScaleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$GAspdJHnzwyd0_rEJVSIxjLcFyE(this), new $$Lambda$6pGfQpqvg_yOMbEIq_WYqstSFlQ(this), new $$Lambda$e2PsF8wKlgGIIhTPY_jD5QUUWo(this), new $$Lambda$apy7EavKKHd2WpwvZHXqeZMaDc4(this), new $$Lambda$diXrJ1YV0S3gkN8JFk9Cb9olVk0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getCFArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[56], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getCFArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[56], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$s5nYqFCgoqxiMjqYtMmTO_n7KDM.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getCFList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$lmDGthDmdE7TTop3Wuzekn5T860(this), new $$Lambda$iX_ADAmhhwkO_vGn6cqu2hwBu14(this), new $$Lambda$uDqFh0GOgDCQ1K4hpouEzAlBZY8(this), new $$Lambda$Q6Ue95HkzLI2JnmffL_Fm_CZNi8(this), new $$Lambda$oVDDdKDtuHqjdOekVxsdiJYwiwg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getCameraArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[57], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getCameraArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[57], $$Lambda$CTClientDataImpl$WsTiHIDkD3WgWeS33lXV_QKeJj4.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getCameraList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$c0dlFLzvHPTPh02ZymYZbJe2XVY(this), new $$Lambda$PeFdVJDhAsAt3_wG1UJlsR2_zc(this), new $$Lambda$6XEnjM9AU83FhXgqxNe_5ovr4(this), new $$Lambda$2Uw_tFFAjkOB3sRhGDoP64a38(this), new $$Lambda$sEOUL1RVtz8Wfj0_2ssW7lECA8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getCancelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getCancelArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[18], $$Lambda$CTClientDataImpl$W2MuQ0NQCgik1VNPwVIN8qJxk.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getCancelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$QgoeLO3EPZwPSmuH1bvSiXxljI(this), new $$Lambda$jOQp2lH_H7FHuF4JBuP6k_OWgGY(this), new $$Lambda$LDZfnYOmtqr9WlQ0Q_O3TXXgsk(this), new $$Lambda$27EECSfOCj0Y2QrKOD3vhYJtX48(this), new $$Lambda$WemHsNO8tOCcyiW4TWSJxPr3A(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getCheckedArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[42], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getCheckedArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[42], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$RwbcKA08CLMWpvNwpKGlBPSspPE.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getCheckedList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$21JDeyKMOTaw07zNq7TEqAlQhQU(this), new $$Lambda$l8z0VWl4GXlsoLfsb2KWKtaMiEI(this), new $$Lambda$BqZut57Lc65ssofYQGCt1u2jG_Q(this), new $$Lambda$WUp2xqgwO8wwpF_CzKtGGrz_CBg(this), new $$Lambda$tNTUZVX67RIi_KuZGJNFbDl1Y8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getColHiddenArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[26], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getColHiddenArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[26], $$Lambda$CTClientDataImpl$YR1t6Dpj2u8C6zxlj_NziKp8GVs.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getColHiddenList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$3tEaxa37VrNq_DUCCmXGZQXtuLg(this), new $$Lambda$EhimJ4nATFggKzqo7bzVXVQqgY8(this), new $$Lambda$reARDUodLVMv2sFthoUBapWqkxE(this), new $$Lambda$QMTg7Sj0KZh3Kbk31jome9hmG8(this), new $$Lambda$i45By7VjzrSiJzdkLhBCrw0loGI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getColoredArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[40], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getColoredArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[40], $$Lambda$CTClientDataImpl$iRPhzOe7tn5a_f4gzmpQJPMPaI.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getColoredList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$e9rS3MaNB9dtsx4Hc2I4uL45_gA(this), new $$Lambda$Db3MXaPbIhgrITlQC4oIkTc(this), new $$Lambda$3epyJAyC63C5fJOw3ZxnDSb24c(this), new $$Lambda$qb16M8ABXHnYvExtNKfltUU2Ug4(this), new $$Lambda$v0hboh8KCn1NVP3Pf_iZQ7XGFY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.microsoft.schemas.office.excel.a
    public BigInteger getColumnArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[23], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getColumnArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[23], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$IMEcDHpkhL1DbR0RpRtRSkmwwGM.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getColumnList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$eJ_oIjV69QQILbTBoihbi_aG69k(this), new $$Lambda$tSf2emOuCY3t7rqsw1m_qXmZopk(this), new $$Lambda$xJvTo_qnIGQFxVt7s4GieCsxN8g(this), new $$Lambda$Aul2hafpolFp5BEWcvFmi5_g0(this), new $$Lambda$GDQiNxlRnLHccwW2lFD41brPRDI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getDDEArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[60], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getDDEArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[60], $$Lambda$CTClientDataImpl$NZPM2wTQuaX4kTgfXU9fbR7IZM.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getDDEList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$BrwvJoBOwLSdXiq62z6DfRa2PA(this), new $$Lambda$Pe5sJCB0r4BElZXOR15i9Wn_npg(this), new $$Lambda$iP1WdvPdSvUF7g79ZhSp6Rzd0jg(this), new $$Lambda$ttL6_gPQJKPmUHOPLR7FPJe7Ubg(this), new $$Lambda$cSZ22IsFOgP3rN8g4sYREzqok4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getDefaultArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getDefaultArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[16], $$Lambda$CTClientDataImpl$aT2dY69mp0qDhcl_LnZPiZj5dZQ.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getDefaultList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$rvCHx5osxcyxKWD7drSlZh7s4AY(this), new $$Lambda$GAWJfBabmXqsSzW8ADXbs0GEqqA(this), new $$Lambda$JuK81qojguLvzysR1NKNEFux8s(this), new $$Lambda$7vQZPWqHPGnTftRrypyFN_RDBws(this), new $$Lambda$0RMFJxKFy5txc6DfAaisAsgvwrU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getDefaultSizeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getDefaultSizeArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[4], $$Lambda$CTClientDataImpl$KA54YRygbttC7mQxAhXJg5HYnk.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getDefaultSizeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$9FPFywr2wna0PBkG_5HVz_0rJtU(this), new $$Lambda$G_d5AgE1NB9U3hlHI_yve56U2o(this), new $$Lambda$T9Vp63JdBLBlhtddUiezzNOgWPY(this), new $$Lambda$Cd5ZbSbLGIySo2UuQ4dp8z4lCFw(this), new $$Lambda$1pKd1NAYBWzUpZkcSaltzg6kn5I(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getDisabledArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getDisabledArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[6], $$Lambda$CTClientDataImpl$teWnMYDs6e36DYamM91B5WA4WQI.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getDisabledList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$EoyKFagZRqVkP4M4fZG8ceyGK4U(this), new $$Lambda$UpGAMC3jTYCS35T_1FqJQmqMS38(this), new $$Lambda$1a93cYAFvD54w8nPnntmXfSk8(this), new $$Lambda$0Q2xGiYRKSfxeVCgUz3mkBsYI3A(this), new $$Lambda$YOLZv0upYB5tcdZB6LNeIEs3kM4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getDismissArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getDismissArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[19], $$Lambda$CTClientDataImpl$iCxJX6l4JdzvSwLCxIlxJxU3VeI.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getDismissList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$jQHDtYAcGzyPGImMGBBT7mYRSEU(this), new $$Lambda$lmIDjXYrvf9sJfXRFjUuiBwJ2mk(this), new $$Lambda$v8FOigHgILX44nJ1PY7j4sQ(this), new $$Lambda$3atnZHHSxAlXwnyOao3y3yg6Fbg(this), new $$Lambda$zNa8Dzj4PEs9YJ6mDZjN28bsVng(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getDropLinesArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[41], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getDropLinesArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[41], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$d8Vl3Y1uzDh9UmgODoQy7P7J2Y.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getDropLinesList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$pdfjYBzHYSDpjIsXsWUJt9y6vgs(this), new $$Lambda$A89wNVRKYdBH92O8pOSJbszPos(this), new $$Lambda$Chjf4EfhA6focGl6JrjTqZg7Js(this), new $$Lambda$Fp97Eib2cuuwePv6xcxkFjKzqQ(this), new $$Lambda$mhKsvqgGlIrO0KgkN69tqLgDNM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getDropStyleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[39], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getDropStyleArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[39], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$f8HxcEJxO2yj0TtjlH6g1loQvuE.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getDropStyleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$QnCmpDOOq5LqM_Xk6QCgbkVKzbg(this), new $$Lambda$rZwa3T0Ght9Uc5OWKNxqDpqAkKQ(this), new $$Lambda$CwITLQYe1TCO5Jk0NLkLr8BsWs(this), new $$Lambda$yh38pV1iNT0fbYmX50fNrnKdFcw(this), new $$Lambda$y0fEEguGUoMFBGW0iMxTOAkqbPU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getDxArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[54], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getDxArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[54], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$JuQX0tLX9YO1J_rPvEMd6YiUNw.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getDxList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$FSPSanjTOurprsjyXN2ob7TM6Q(this), new $$Lambda$wQVlUF3B4ZjjtLyFtMjEWSs0Qv0(this), new $$Lambda$ccEaWnQe_mDCvDO2VMkpp2wWYbo(this), new $$Lambda$ytgQqfJI3_Ye_puZnyh53VdZQy0(this), new $$Lambda$8h5vKdBQ2qr8dae3QT7JRTKlFE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getFirstButtonArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[46], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getFirstButtonArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[46], $$Lambda$CTClientDataImpl$RMc1q_3OnmmO77VOCiMT_aPLJL0.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getFirstButtonList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$6HvHVDZCd0hNLz29wXMN8Q4qDQ(this), new $$Lambda$HDAWGMcK6n7kP6wrCazRDArXO4(this), new $$Lambda$2qERrT_onnkENJSPvslw7bn8PVU(this), new $$Lambda$g1xiop8U7xeOSJj6OamQfZlIyNU(this), new $$Lambda$zEppJyrbd2CWe2lfRaKNouS11M(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getFmlaGroupArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[47], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getFmlaGroupArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[47], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$mbVtS523_5kP9eg0iPkqDBUA_c.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getFmlaGroupList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$7qzmkJW2mSrFxHi_hIad1TnE4TA(this), new $$Lambda$G6i_Sx0McWvfnAexzp_bh94CxlA(this), new $$Lambda$uRC_aerzNmmL92pqOT_Law3apkE(this), new $$Lambda$uUYTh1JFMsX8BOTOxmCaBfKWhZA(this), new $$Lambda$hwkk1k0tTfLdrlpgGnz5GOaqUGE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getFmlaLinkArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[43], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getFmlaLinkArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[43], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$6NkOC05kkkbDINe2xpldAn2L_OA.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getFmlaLinkList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$_Dhm23cH19HvN2_YYdBnTUNg0(this), new $$Lambda$8Be8nK0Wtoo7cKoA6Zq4r_6DPvU(this), new $$Lambda$Kf2u1dot_cZZKfFy2c9V9oyDTg(this), new $$Lambda$KP6Fgv87sl5UwDah8p_km4JBkXw(this), new $$Lambda$QLYsgJuKtHqkq5gzFd3Tbwa3pUQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getFmlaMacroArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getFmlaMacroArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[10], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$YfRVUkPoxzl5C1eqwAgii40uPs.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getFmlaMacroList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$36rDT4boac_Cod2I9aQ9sS1evrs(this), new $$Lambda$sJg30w9OswwR_JEW9o7Qi01qxZU(this), new $$Lambda$g8fVxGkOAQFo5hYdGa9_ddow(this), new $$Lambda$TkfUWvmcAGIgITMkItuM20s9dA(this), new $$Lambda$H9m5oaZeYiEyz_0i4sZwxifWn7I(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getFmlaPictArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[44], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getFmlaPictArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[44], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$SeqHz_DoT4hmmbZSnZ0JqF04BMw.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getFmlaPictList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$c2zNW1zERslm45Cm4spSlbNUTE(this), new $$Lambda$6PlOsEjtTqwBZ3Nb5CLEaxNHx3E(this), new $$Lambda$sUs0pcZPC0j_dqM7fPLMp9UiNbI(this), new $$Lambda$agUI8uuKTu0T23S_4Nt8MOLZLwA(this), new $$Lambda$lXyXmkXiKOLaRxL2XMUOcB1QRng(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getFmlaRangeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[31], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getFmlaRangeArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[31], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$CVrvuSyglBJtEQSZAkKtjeUNAkU.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getFmlaRangeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$VdF6xSLSFEYNfYn0dB7n5gY81E(this), new $$Lambda$fmVtcrKP1ZnbB4_x_WUAkWw9jRw(this), new $$Lambda$vanSWv7y_jh2t4Se4XuGGTfzP_0(this), new $$Lambda$pm01oKN5twkl5ICNiHiVmlDBiD8(this), new $$Lambda$06JOb8u1SObGvrvVv34F03IBPE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getFmlaTxbxArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[66], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getFmlaTxbxArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[66], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$F8Pjm066AtvdddEiFUCeMYYaIA.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getFmlaTxbxList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Tnjt21A6M1arqtuY9tS14b_zqEg(this), new $$Lambda$LstQaSD1QkA2qTEMXusaqL9OaiI(this), new $$Lambda$JgdTaBWLQPFIazTZv2I3NtcAM(this), new $$Lambda$qVkyJDNT7pZX_Es6PHCmDMjPpAA(this), new $$Lambda$ziuIcDTTQzFymIbQltMs35p_o0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getHelpArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getHelpArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[17], $$Lambda$CTClientDataImpl$VVg418yFBJlw9fJt9b3GEVMk5Zw.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getHelpList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$AiEfphjiG_WTXO6pn3acWpBMe5c(this), new $$Lambda$3KPaeO0m4i9adYnVLtbHju1ymg(this), new $$Lambda$9shipoVtk8ktm6Y2fEj1_Da320k(this), new $$Lambda$V6wkgXLFJLQLzoYoQwvqVwQfwA(this), new $$Lambda$wVxkgLgLxj_dKMwDPotkhybiZ5k(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getHorizArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[53], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getHorizArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[53], $$Lambda$CTClientDataImpl$3a3J1wBt1kL55XjLkQWJ__cSRE.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getHorizList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$3g8ETkA7po26tStNIEKJrRRNpR4(this), new $$Lambda$uD5psKs0taE2I3wqbxCr6AJBs98(this), new $$Lambda$oFnnVDzk3GPKeUlYw2o0scMfr0(this), new $$Lambda$Y8FtMSs8hJOwB4gVPDbNAVNZYA(this), new $$Lambda$w2_HUBRuMIh1Ez3QOkZhLMxZ4KI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getIncArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[51], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getIncArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[51], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$wv4p0JoJJ09KFRJBVhcNrvWFr5o.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getIncList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$p4H9POBIa4z2vJI7Q4tISljWtg(this), new $$Lambda$2J1YERlYXTHuO5zjyp0nNN5_U9o(this), new $$Lambda$cLvAYJMxWd1HLE4QLuleK8cL2v4(this), new $$Lambda$w6xvFxrddkSYfrtQLH_s740CG90(this), new $$Lambda$IxX5dQ___smvPE_3FGq9gPJgQBw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getJustLastXArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getJustLastXArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[14], $$Lambda$CTClientDataImpl$sQwH0Se7iYOZM0I3sqh4dsQcxDs.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getJustLastXList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$FLt4NJBaYIsXwzgY60MxyGHGi00(this), new $$Lambda$XX7Xvp8AdzLFTPHr29ULQJ5c5v4(this), new $$Lambda$AvpmjCsoR_Y_N6vLumEbzMUAzyY(this), new $$Lambda$Kv4LwvhxHn4UacPdy37LMTzancA(this), new $$Lambda$5nJo8urDro0OUUHHblkqdP5ZRhE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getLCTArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[37], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getLCTArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[37], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$iJ3SIUgilmG_Xs2sZxL3lAPT6Ro.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getLCTList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$SQZ5I5AsV35dWB7zPIBEuItHhlQ(this), new $$Lambda$4zC6s2Lql5HwDK9ixSjazCmTM9U(this), new $$Lambda$4bAx6ZhmYR8GQ0n0YwYlIWa5gs(this), new $$Lambda$FYnbh0SgKOs6KEx8GbmtSr5OUQ(this), new $$Lambda$q3qr3lzb_BAmHyOzUr4z8OEMQFo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getListItemArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[38], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getListItemArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[38], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$KZvqnqcuTZcLzVjkf0Gwcy8chkA.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getListItemList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Q1QAUKMqa29l8xtvW4vF5nQnfEc(this), new $$Lambda$_HEcfl5jqXeY12aTwVmdZlK8MeE(this), new $$Lambda$JrfjU37HtGPq4rLMktosre7xo(this), new $$Lambda$gGNBqN_RTi1I_9EwSWDB2NAoB0g(this), new $$Lambda$ZWpx9HU_hYLbZI3lCCtNV3qRi8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getLockTextArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getLockTextArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[13], $$Lambda$CTClientDataImpl$hjIJJW59kDNR93XegVh3gll0Gk.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getLockTextList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$bojHhG5nshdmQmcuNogCKisPVM(this), new $$Lambda$fA6ZmImFyK6RkhaYhxKwS7P1Pfw(this), new $$Lambda$Zf1yfK4Li4yw3RloXcgzqbqtq68(this), new $$Lambda$EgJrADOGXOqtNkjRuD6rOGGapc(this), new $$Lambda$t4qldCStnx3sY23NVWWfNZNkqHI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getLockedArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getLockedArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[3], $$Lambda$CTClientDataImpl$V10hpZ8aB6xceroky6j2hPEisQ.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getLockedList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$VOwGaHrhXQr4Hs4u7U6jyQdoatI(this), new $$Lambda$Bi2OeUX3zHsDh6pZfvkR0UsG6I(this), new $$Lambda$jAcjSPghkdKkAQOz13ed6oDK4A(this), new $$Lambda$ocWdZ9s2dEY02MmElbkJHcRsMy4(this), new $$Lambda$H4R2oT6ud5IY4dScQy2IVVMWoLg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getMapOCXArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[55], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getMapOCXArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[55], $$Lambda$CTClientDataImpl$_u_CCUindl_gQ0xJa_l0tt0TMLQ.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getMapOCXList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$tERAQozj2IB0HSxbvsGhy6JylmE(this), new $$Lambda$xA7wZcSG_RJ5EEWkz8Z5beIzXfs(this), new $$Lambda$ikosmmjGx6Be7FZn5J6_YZ0VbUE(this), new $$Lambda$s9XAFyuLp1gzO5UHXK8bH0j05To(this), new $$Lambda$tlogvyiB5qX49V4KWUEWku1TKE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getMaxArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[50], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getMaxArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[50], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$dlLeEC47CgkKmA38_LUu8QsUI8.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getMaxList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$1afx_K9WYh8BUoN4ecZ0TUtz5c(this), new $$Lambda$BuTpHJcZTtez9nGcih8VyfPSrfA(this), new $$Lambda$QKjtSYEAQU7Sg3aB8uv2KRKDuKU(this), new $$Lambda$vOMdhYhYl5Zv_K4A08iCAPG2hIk(this), new $$Lambda$CWRUnNSmv8Pjr3D9uZ95sB8oDVI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getMinArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[49], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getMinArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[49], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$p2dbJ_oBDS8W5liZNJznDVAQpn0.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getMinList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$dNYni8DXfu25QsHAVqWeKinRu8(this), new $$Lambda$ewuHfRpbMAUNvWRApLPcmFp7GP8(this), new $$Lambda$f9EPKOYpHePAYeawVQE9vd0s3E(this), new $$Lambda$B7Ky5siVx_umJ6C1SxSniea6bA(this), new $$Lambda$XTCwud852og4Sz30SSZwxWnd3zI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getMoveWithCellsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getMoveWithCellsArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[0], $$Lambda$CTClientDataImpl$kG3gaPSp2CLak1yxnAyRABLPNYM.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getMoveWithCellsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Ri8_BDBMzTujNO8fcOVDTjp9ZNQ(this), new $$Lambda$c6e83kDnRfSpqc9DeNYtKp53Mo8(this), new $$Lambda$UFKANdFsJHQp42QLp2DlIhBSjMo(this), new $$Lambda$ADx5dZytaAxgmC2hVr0LgXF8ySU(this), new $$Lambda$MYw3s33pxjthMQ8x0MZkE6OQ1is(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getMultiLineArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[28], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getMultiLineArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[28], $$Lambda$CTClientDataImpl$S6RVEnKYWFsS0bJ4ee1jzYx4Z5c.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getMultiLineList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$gn0i_rDSNhCCxvyNJO2VTSDc(this), new $$Lambda$uiRovUK0ZHZILBXHBU3ZDfUYwk(this), new $$Lambda$TdZgNRGuEZZAxeLNw1PVwt_6pGk(this), new $$Lambda$Bupv09uZW0ApP15yReT1nFIlrw(this), new $$Lambda$LiagtY88uG9hLqs0uxAwzgMEeA(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getMultiSelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[36], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getMultiSelArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[36], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$iHIPBBRnt0xYjoVFQg9Z0yJhsd8.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getMultiSelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$GbHSmEDKCXGlSGIcmhdL8Csfaxo(this), new $$Lambda$zzwL1k8eXHxkuQ4z5d0rMhRSLdY(this), new $$Lambda$hq9XhI3rc_alqa1RdKGqxfX7tc(this), new $$Lambda$axzHxXExfaw1UUq1Y9msKwJQtXg(this), new $$Lambda$e1vmoSS6Ifwd81Wu5SjIazYwYlo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getNoThreeD2Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[34], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getNoThreeD2Array() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[34], $$Lambda$CTClientDataImpl$70ENh0pjOyY9nNpUgoVCArZLXno.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getNoThreeD2List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$BplJPv12itg4ZV5GBoYhXGb8Ybc(this), new $$Lambda$b3NYClH28BCdzjhhfcG4_EaYg(this), new $$Lambda$5OiWBj7pn_d8Tmh_hWHP3rfBOo(this), new $$Lambda$73NIdQYsAXsY1dRraW3A2J64O8(this), new $$Lambda$msJ_ZQoSEYUagoDctgzz6qnTx8c(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getNoThreeDArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[45], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getNoThreeDArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[45], $$Lambda$CTClientDataImpl$LFiGxzKt3n_Rv8kyNvrxUXLom5Y.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getNoThreeDList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Jy6OBIFiO9X9M2yKCEtpm1H7lv0(this), new $$Lambda$J_mIPLfUD2V2GgEFEcreg52KLKc(this), new $$Lambda$zFQzo941k8acS31jvi8KOcfpgY(this), new $$Lambda$XRqCzbFfH8eXvI6VliDDTuqWavM(this), new $$Lambda$nI99fZnFHa1Yr83AT6u5alpt7xk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.microsoft.schemas.office.excel.a
    public STObjectType.Enum getObjectType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[67]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        STObjectType.Enum r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = (STObjectType.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STObjectType.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public BigInteger getPageArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[52], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getPageArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[52], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$I1kF8thZ8zZ5mkqL5NirjucNI7k.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getPageList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$hE5tT1o_pv7PQ2bzuUNdPtL0(this), new $$Lambda$mVgW379sioQWmaZrjz6Xrnwc7w(this), new $$Lambda$HLuk0UZAFhkYfQBuKtihRjouMWE(this), new $$Lambda$jvlaCsOlMehwQD3bOiGzsCBoYew(this), new $$Lambda$X19ip9aEmW6jTtAx__CrHtbuZeo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getPrintObjectArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getPrintObjectArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[5], $$Lambda$CTClientDataImpl$2cNlWvSI1yrVtO_A_ZOU9MlsONc.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getPrintObjectList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$lUueywW56WOCR49FKAkhUN2sIzA(this), new $$Lambda$95tMbTtn5y80AzsX14EKl_nTOU(this), new $$Lambda$dyvsuce2pu3p2LpZTeMrIE9jCeM(this), new $$Lambda$fgMh2DirTsBNoAE_mbJxEbAk9B4(this), new $$Lambda$9mq01LQJNTvbzRmcixbhoQEV8I(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getRecalcAlwaysArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[58], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getRecalcAlwaysArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[58], $$Lambda$CTClientDataImpl$1vyxhH60RnX025pf34wqHAOUJwI.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getRecalcAlwaysList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$49E06tPFQdJjcqtG6komCO_k0(this), new $$Lambda$pH4kAFCrOe9pO4OiqeJSBcKMqs(this), new $$Lambda$EQh_rbAKwJreSYrqOiNvAhmlkmg(this), new $$Lambda$wCSsOzwt5MLsTVCm98mR6vgVWA(this), new $$Lambda$d5przCs37B3qaDxCZJlHABboyyM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.microsoft.schemas.office.excel.a
    public BigInteger getRowArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[22], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getRowArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[22], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$5WDzET7gJjCVowbk4rzl24atLcY.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public STTrueFalseBlank.Enum getRowHiddenArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[25], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getRowHiddenArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[25], $$Lambda$CTClientDataImpl$lSZd87v_jkoO7jjoRM_bCFY3Sg.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getRowHiddenList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$b8LvOL5y4xFM79eOzkxzKSthukw(this), new $$Lambda$PmEMuw2EPYDLzrX5k4ilf1brYUg(this), new $$Lambda$9fQ5DdZ8c_BeFZ7nqyULxUp74Mw(this), new $$Lambda$H0svn85s8Er6CQvk4TXzgc4CeU(this), new $$Lambda$1hV4I6m7UCJCtt9jKWCf1Dnt96s(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BigInteger> getRowList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$APGxQe2jvqTiF6HEobJhOcnwFvM(this), new $$Lambda$dX2vHhJi19St8s0fw2jnXss8rgE(this), new $$Lambda$xcWTD1CNcl2xBIQ2VZkLf2z_lD0(this), new $$Lambda$lejKkDMQwqi90CQSvXG6zUDB88(this), new $$Lambda$m2NghEHbpG4oiIpoxP2MlsJqOd4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getScriptExtendedArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[63], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getScriptExtendedArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[63], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$Ag8k7zJl4DfZr8OZbVVFGs494QQ.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getScriptExtendedList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$eTrx980R_sRLTrFsgFG43vy8c(this), new $$Lambda$F8SlndXny6IKSsO3LL5LXkpT5Kg(this), new $$Lambda$UFxjlXiapvDSQAhIE_pPQ7L9Wc(this), new $$Lambda$7c9NYuWwGoDQmQ28yTZ7j0sDa90(this), new $$Lambda$tzACmQL7ZloZ4q2EP8lxgRKaITY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getScriptLanguageArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[64], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getScriptLanguageArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[64], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$UvRuYbhXIpXPFoikluzhHoDrBaw.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getScriptLanguageList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$eCZbyvFC7YeGWn5Hl5mDVmsnWeE(this), new $$Lambda$c6Pz45zR2XYRGrXnmUzCtyJwpk(this), new $$Lambda$BbSmopGyk7HWbtXumAMOsqQm_N0(this), new $$Lambda$PWNwOz8HMPB68pnCmpoifl9ppPg(this), new $$Lambda$0CG4yJKGuRH9S6RDfN_5IQzw2fY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getScriptLocationArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[65], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getScriptLocationArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[65], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$FXumrobFToO136vy2BGFaFSCQOk.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getScriptLocationList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$i1OcVyIBJ_SFj6evLo7ROVeCUKk(this), new $$Lambda$crjtSrsYqaaIwlic0bQiglnunNQ(this), new $$Lambda$TM_mpAz0tNLFxuR1I2oMF_TpVg(this), new $$Lambda$wAmIGGBi_ZSa4TKOAlVkA5O8aE(this), new $$Lambda$2UUKgr6DgBsLgGsh89Grde79u1E(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getScriptTextArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[62], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getScriptTextArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[62], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$XCzMxJYdOdrIo3b7qui_Soc_lpU.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getScriptTextList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$Ul4CiRcR2NjitKw4fBrbLSHH6I(this), new $$Lambda$FY08c33MPJ4_Xsx0Q4BUN7naLQ(this), new $$Lambda$L7k_Yql06RNwkGR_HL4JUpHh7Y(this), new $$Lambda$_y9FTritJNEkA5FKhYpjf3CHI(this), new $$Lambda$wlkHnUUYodRqWAdHvhtLDdgFgac(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getSecretEditArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getSecretEditArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[15], $$Lambda$CTClientDataImpl$iSRRIADlOQc_ferXlz_S7jkUj64.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getSecretEditList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$bjgo9qqWCVorB2Fy59gHqy8OP8(this), new $$Lambda$r8S_WhwQPE1VWVgzGgg9fAzGIOU(this), new $$Lambda$M5P7yqVywRlCsqdMvS1sRTZo19I(this), new $$Lambda$yINxT_pkYDzuo7lCvSSdRvEhI_4(this), new $$Lambda$2UmYaBjMMZkrF0iCFbohnksDV4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getSelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[33], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getSelArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[33], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$qHL3N6qQfod1A3rbmVWo149yL0.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getSelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$05qDjPpZWsCKQ3zNvBbfYZZ52I(this), new $$Lambda$PEuKVY3vja90QuZYqCqvgI4y9Y(this), new $$Lambda$x5KeqFcBIcEb9m_slJCMrSe9GPQ(this), new $$Lambda$dYelp2yY0xYIF8UQs5gtZFRTQ(this), new $$Lambda$_A_8zpTRns_dlcuC7jotbkIcw3A(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getSelTypeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[35], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public String[] getSelTypeArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[35], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$WHRUtwoorgzZEdEftGvTLTTrjVM.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getSelTypeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$eQnGz_yCJuIE6OnRXIk0cpXrXnE(this), new $$Lambda$0jqjbVF_3br_yaP2Sa2FFmpFnH8(this), new $$Lambda$K_sTT9HkHgoN2lgQEQGlttvg8c(this), new $$Lambda$dhRfh_IQI3ivhAzeOajyL2Hodb0(this), new $$Lambda$l7unPzIjmMFUuCVoV7wYSk_d9MA(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getSizeWithCellsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getSizeWithCellsArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[1], $$Lambda$CTClientDataImpl$7Dzdeq6yWWRlm1ag_5Yw6VuS8Oo.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getSizeWithCellsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$7tRaHOIxQzo1pc9kwSZ3sW6LNJ0(this), new $$Lambda$uveznKwuEChCcdsrTxJxqkQRE64(this), new $$Lambda$ZdrqDXK5cUpo2HitLgKnrqSsoU(this), new $$Lambda$DAOjkgZSZ_2_sckiiqSto2SC6Ys(this), new $$Lambda$M8IX3kjxHcLW3L8v9Y4Otsz_JtQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getTextHAlignArray(int r4) {
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

    public String[] getTextHAlignArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[11], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$WYklX4EYDD_mv_TmlEj9ChUISQs.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getTextHAlignList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$HmEXDnjFybhOCPYvqmOid280zVY(this), new $$Lambda$Q3JNFpEwQYhrQdLLmVTDIlih0Sk(this), new $$Lambda$Ds3OIcliwLnZkBNeiC6VeQfC2Tk(this), new $$Lambda$ibuSItcsBXEBF7LEP9S4qMstedA(this), new $$Lambda$UkPB0LnmKpYptz3f1Fd7v9Lq59E(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public String getTextVAlignArray(int r4) {
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

    public String[] getTextVAlignArray() {
        return (String[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[12], $$Lambda$W6_VmUC3b4oZ3X9ETvtSg2YTPVM.INSTANCE, $$Lambda$CTClientDataImpl$JzoJrsnS2luxHYgBifPjjQHSbvk.INSTANCE), String[].class, "com.obric.memorydata.plugin");
    }

    public List<String> getTextVAlignList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$tOr3NWG93V_5XVydjcwldlFTHI(this), new $$Lambda$Lj3EzESD81GdvuBjEQN_ZXs39W0(this), new $$Lambda$2M7gSk1wYH4MkkaWfN1OND7_c38(this), new $$Lambda$_heMd2cKiuZLqC1dTG1WmMPJ5d4(this), new $$Lambda$1_hWYiuBj3v6qUCzfuNo_OIcrvc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getUIObjArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[61], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getUIObjArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[61], $$Lambda$CTClientDataImpl$AyJFwx1aU30QtDQzuWtESeUJFw.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getUIObjList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$474UZYQR9ZIIVGT21yBWZru_VVw(this), new $$Lambda$9WZXvcjbEz9EH47a3IGWOMzpLRs(this), new $$Lambda$Ip3vDIbdYJFUlmvamnRu1AYdNWg(this), new $$Lambda$O9EIoc9fpFmMrblsEjBlAhp0gXQ(this), new $$Lambda$SvolCexMUMvqawcpOLekYeT3EI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getVScrollArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[29], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getVScrollArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[29], $$Lambda$CTClientDataImpl$RoCNOwbpW4d7etdjdNYX47oLstY.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getVScrollList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$1Ir_f1z8JCMT3c0uzzl_a9Giyvc(this), new $$Lambda$cATySHtFXxI2ZcWDVCnFOXMCOhc(this), new $$Lambda$R5veZ1m2rVcyPDf3nTuibPQFA6I(this), new $$Lambda$akIfqb1PeI55FAJXPm6pT2zZx5w(this), new $$Lambda$Qa1aVDcnEz0ae8WpD9Lg61uqxo0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getVTEditArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[27], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getVTEditArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[27], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$EHlj3_SYiW1Yxznn_s22C3Ubkck.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getVTEditList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$0_YpkWlI5MlXGchh9ouCEsH6RZM(this), new $$Lambda$GsXwzHpXNcuRNw4Dn0r5Fsn_Rc(this), new $$Lambda$VIus1ZL8hXf0z2iiLjfms7YrKE(this), new $$Lambda$ww0ULlrLFC5SzS0B5Q7rAC1ZG5g(this), new $$Lambda$L5wzapqW06vIUQJnl8yRvOrQCV4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getValArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[48], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getValArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[48], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$mY2hHehDpBEgzc9xhCVtnpKrs10.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getValList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$FMJp0D2zJqqkqBqy7MbEPICA(this), new $$Lambda$ugBz4_H6J1aEVpAJWq9POfqgyQs(this), new $$Lambda$PsJZ8s7uIm91Pl9uv5OIJWrarLo(this), new $$Lambda$1TBSUOC4EfpYRzwm_qSqcGXFZjI(this), new $$Lambda$WX5tbo8CGj60nvX3iu5S8MyJpGs(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getValidIdsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[30], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getValidIdsArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[30], $$Lambda$CTClientDataImpl$JWyJvUzBRs2dlUOyv6SO6sG3Om8.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getValidIdsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$ZbZFgXttqf6fuT29bDJ2Uzp3cvg(this), new $$Lambda$1rj9aCZliiDQUdVllQzXxsmaelI(this), new $$Lambda$CqobDXnxpRWdEWNGcBWHucOC4Ik(this), new $$Lambda$s1j7_sPNt94mJcUzDVhxvhZOaQ(this), new $$Lambda$OeSLPChgMI7SKGC1u6mWNxT0oQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum getVisibleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[24], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        STTrueFalseBlank.Enum r5 = (STTrueFalseBlank.Enum) ZeusTransformUtils.preCheckCast(r3.getEnumValue(), STTrueFalseBlank.Enum.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank.Enum[] getVisibleArray() {
        return (STTrueFalseBlank.Enum[]) ZeusTransformUtils.preCheckCast(getEnumArray(PROPERTY_QNAME[24], $$Lambda$CTClientDataImpl$WjbQlZJR6toz1vvlOLvBFJXboU.INSTANCE), STTrueFalseBlank.Enum[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank.Enum> getVisibleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$1xmfRX1vuBGDM0BMATPPjqNvEso(this), new $$Lambda$jCxz76oawV5ubkbvDdNmnw9UUE(this), new $$Lambda$FTH2zd3X4gw8s5lCb0SFw8nlkMY(this), new $$Lambda$9vCfVTt33lbRFBqsLxVWFJ16nQU(this), new $$Lambda$jgx4ms9K3TI59kZNr9yP97QSvjQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public BigInteger getWidthMinArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[32], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public BigInteger[] getWidthMinArray() {
        return (BigInteger[]) ZeusTransformUtils.preCheckCast(getObjectArray(PROPERTY_QNAME[32], $$Lambda$PYZScm63zWY6MEaVXLBUh5hJ8r0.INSTANCE, $$Lambda$CTClientDataImpl$7Jx7OEbwnyDtOoBuBOEx4Y3PYrQ.INSTANCE), BigInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<BigInteger> getWidthMinList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListObject r7 = new JavaListObject(new $$Lambda$3GHgv41Xd_EaTO_ekjAo9DOqQpk(this), new $$Lambda$xRYVoqBz5eErLbLvfwKjHeJeXOE(this), new $$Lambda$JZX1RplbA3a1FVTlfDWvSP0SVWA(this), new $$Lambda$pkaGtOwbA8rRFoP0rqRdxkZFnz4(this), new $$Lambda$09R2MblJIvA7DfehlY0865Jf67w(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertAccel(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[20], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertAccel2(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[21], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertAnchor(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertAutoFill(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertAutoLine(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertAutoPict(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertAutoScale(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[59], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertCF(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[56], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertCamera(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[57], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertCancel(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[18], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertChecked(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[42], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertColHidden(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[26], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertColored(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[40], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertColumn(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[23], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDDE(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[60], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDefault(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[16], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDefaultSize(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDisabled(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDismiss(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[19], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDropLines(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[41], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDropStyle(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[39], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertDx(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[54], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertFirstButton(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[46], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertFmlaGroup(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[47], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertFmlaLink(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[43], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertFmlaMacro(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertFmlaPict(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[44], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertFmlaRange(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[31], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertFmlaTxbx(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[66], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertHelp(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[17], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertHoriz(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[53], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertInc(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[51], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertJustLastX(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertLCT(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[37], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertListItem(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[38], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertLockText(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertLocked(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertMapOCX(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[55], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertMax(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[50], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertMin(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[49], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertMoveWithCells(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertMultiLine(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[28], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertMultiSel(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[36], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewAccel(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[20], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewAccel2(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[21], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewAnchor(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[2], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewAutoFill(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[7], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewAutoLine(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[8], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewAutoPict(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[9], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewAutoScale(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[59], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public b insertNewCF(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        b r3 = (b) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[56], r4), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewCamera(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[57], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewCancel(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[18], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewChecked(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[42], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewColHidden(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[26], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewColored(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[40], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewColumn(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[23], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewDDE(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[60], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewDefault(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[16], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewDefaultSize(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[4], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewDisabled(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[6], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewDismiss(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[19], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewDropLines(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[41], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewDropStyle(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[39], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewDx(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[54], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewFirstButton(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[46], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewFmlaGroup(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[47], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewFmlaLink(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[43], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewFmlaMacro(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[10], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewFmlaPict(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[44], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewFmlaRange(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[31], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewFmlaTxbx(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[66], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewHelp(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[17], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewHoriz(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[53], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewInc(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[51], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewJustLastX(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[14], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewLCT(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[37], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewListItem(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[38], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewLockText(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[13], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewLocked(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[3], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewMapOCX(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[55], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewMax(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[50], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewMin(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[49], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewMoveWithCells(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[0], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewMultiLine(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[28], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewMultiSel(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[36], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewNoThreeD(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[45], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewNoThreeD2(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[34], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewPage(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[52], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewPrintObject(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewRecalcAlways(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[58], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewRow(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[22], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewRowHidden(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[25], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewScriptExtended(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[63], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlNonNegativeInteger insertNewScriptLanguage(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[64], r4), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlNonNegativeInteger insertNewScriptLocation(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[65], r4), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewScriptText(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[62], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewSecretEdit(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[15], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewSel(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[33], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewSelType(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[35], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewSizeWithCells(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString insertNewTextHAlign(int r4) {
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

    public XmlString insertNewTextVAlign(int r4) {
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

    public STTrueFalseBlank insertNewUIObj(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[61], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewVScroll(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[29], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewVTEdit(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[27], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewVal(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[48], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewValidIds(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[30], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank insertNewVisible(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[24], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger insertNewWidthMin(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[32], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertNoThreeD(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[45], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertNoThreeD2(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[34], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertPage(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[52], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertPrintObject(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[5], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertRecalcAlways(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[58], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertRow(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[22], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertRowHidden(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[25], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertScriptExtended(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[63], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertScriptLanguage(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[64], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertScriptLocation(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[65], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertScriptText(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[62], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertSecretEdit(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[15], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertSel(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[33], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertSelType(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[35], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setStringValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertSizeWithCells(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[1], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertTextHAlign(int r4, String r5) {
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

    public void insertTextVAlign(int r4, String r5) {
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

    public void insertUIObj(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[61], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertVScroll(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[29], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertVTEdit(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[27], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertVal(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[48], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertValidIds(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[30], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertVisible(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[24], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setEnumValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void insertWidthMin(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ((SimpleValue) ZeusTransformUtils.preCheckCast(get_store().insert_element_user(PROPERTY_QNAME[32], r4), SimpleValue.class, "com.obric.memorydata.plugin")).setBigIntegerValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAccel(int r4) {
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

    public void removeAccel2(int r4) {
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

    public void removeAnchor(int r4) {
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

    public void removeAutoFill(int r4) {
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

    public void removeAutoLine(int r4) {
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

    public void removeAutoPict(int r4) {
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

    public void removeAutoScale(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[59], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeCF(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[56], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeCamera(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[57], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeCancel(int r4) {
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

    public void removeChecked(int r4) {
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

    public void removeColHidden(int r4) {
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

    public void removeColored(int r4) {
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

    public void removeColumn(int r4) {
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

    public void removeDDE(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[60], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeDefault(int r4) {
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

    public void removeDefaultSize(int r4) {
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

    public void removeDisabled(int r4) {
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

    public void removeDismiss(int r4) {
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

    public void removeDropLines(int r4) {
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

    public void removeDropStyle(int r4) {
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

    public void removeDx(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[54], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeFirstButton(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[46], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeFmlaGroup(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[47], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeFmlaLink(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[43], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeFmlaMacro(int r4) {
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

    public void removeFmlaPict(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[44], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeFmlaRange(int r4) {
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

    public void removeFmlaTxbx(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[66], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeHelp(int r4) {
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

    public void removeHoriz(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[53], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeInc(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[51], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeJustLastX(int r4) {
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

    public void removeLCT(int r4) {
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

    public void removeListItem(int r4) {
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

    public void removeLockText(int r4) {
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

    public void removeLocked(int r4) {
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

    public void removeMapOCX(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[55], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeMax(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[50], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeMin(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[49], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeMoveWithCells(int r4) {
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

    public void removeMultiLine(int r4) {
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

    public void removeMultiSel(int r4) {
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

    public void removeNoThreeD(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[45], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeNoThreeD2(int r4) {
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

    public void removePage(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[52], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removePrintObject(int r4) {
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

    public void removeRecalcAlways(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[58], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeRow(int r4) {
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

    public void removeRowHidden(int r4) {
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

    public void removeScriptExtended(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[63], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeScriptLanguage(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[64], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeScriptLocation(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[65], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeScriptText(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[62], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeSecretEdit(int r4) {
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

    public void removeSel(int r4) {
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

    public void removeSelType(int r4) {
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

    public void removeSizeWithCells(int r4) {
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

    public void removeTextHAlign(int r4) {
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

    public void removeTextVAlign(int r4) {
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

    public void removeUIObj(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[61], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeVScroll(int r4) {
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

    public void removeVTEdit(int r4) {
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

    public void removeVal(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        get_store().remove_element(PROPERTY_QNAME[48], r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeValidIds(int r4) {
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

    public void removeVisible(int r4) {
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

    public void removeWidthMin(int r4) {
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

    public void setAccel2Array(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[21], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setAccel2Array(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[21]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAccelArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[20], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setAccelArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[20]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAnchorArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setAnchorArray(String[] r4) {
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

    public void setAutoFillArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setAutoFillArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setAutoLineArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setAutoLineArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setAutoPictArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setAutoPictArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setAutoScaleArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[59], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setAutoScaleArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[59]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setCFArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[56], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setCFArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[56]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setCameraArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[57], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setCameraArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[57]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setCancelArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setCancelArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setCheckedArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[42], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setCheckedArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[42]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setColHiddenArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[26], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setColHiddenArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[26]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setColoredArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[40], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setColoredArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[40]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.microsoft.schemas.office.excel.a
    public void setColumnArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[23], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setColumnArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[23]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDDEArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[60], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setDDEArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[60]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDefaultArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setDefaultArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setDefaultSizeArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setDefaultSizeArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setDisabledArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setDisabledArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setDismissArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setDismissArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setDropLinesArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[41], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setDropLinesArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[41]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDropStyleArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[39], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setDropStyleArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[39]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDxArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[54], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setDxArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[54]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setFirstButtonArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[46], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setFirstButtonArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[46]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setFmlaGroupArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[47], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setFmlaGroupArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[47]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setFmlaLinkArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[43], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setFmlaLinkArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[43]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setFmlaMacroArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setFmlaMacroArray(String[] r4) {
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

    public void setFmlaPictArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[44], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setFmlaPictArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[44]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setFmlaRangeArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[31], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setFmlaRangeArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[31]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setFmlaTxbxArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[66], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setFmlaTxbxArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[66]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setHelpArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setHelpArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setHorizArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[53], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setHorizArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[53]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setIncArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[51], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setIncArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[51]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setJustLastXArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setJustLastXArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setLCTArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[37], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setLCTArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[37]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setListItemArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[38], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setListItemArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[38]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setLockTextArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setLockTextArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setLockedArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setLockedArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setMapOCXArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[55], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setMapOCXArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[55]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMaxArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[50], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setMaxArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[50]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMinArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[49], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setMinArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[49]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMoveWithCellsArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setMoveWithCellsArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[0]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMultiLineArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[28], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setMultiLineArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[28]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMultiSelArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[36], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setMultiSelArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[36]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setNoThreeD2Array(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[34], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setNoThreeD2Array(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[34]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setNoThreeDArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[45], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setNoThreeDArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[45]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setObjectType(STObjectType.Enum r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[67]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[67]), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.setEnumValue(r7);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setPageArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[52], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setPageArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[52]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPrintObjectArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setPrintObjectArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setRecalcAlwaysArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[58], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setRecalcAlwaysArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[58]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.microsoft.schemas.office.excel.a
    public void setRowArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[22], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setRowArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[22]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRowHiddenArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[25], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setRowHiddenArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[25]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setScriptExtendedArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[63], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setScriptExtendedArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[63]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setScriptLanguageArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[64], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setScriptLanguageArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[64]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setScriptLocationArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[65], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setScriptLocationArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[65]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setScriptTextArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[62], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setScriptTextArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[62]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSecretEditArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setSecretEditArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setSelArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[33], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setSelArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[33]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSelTypeArray(int r4, String r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[35], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setSelTypeArray(String[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[35]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSizeWithCellsArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setSizeWithCellsArray(STTrueFalseBlank.Enum[] r4) {
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

    public void setTextHAlignArray(int r4, String r5) {
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

    public void setTextHAlignArray(String[] r4) {
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

    public void setTextVAlignArray(int r4, String r5) {
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

    public void setTextVAlignArray(String[] r4) {
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

    public void setUIObjArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[61], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setUIObjArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[61]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setVScrollArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[29], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setVScrollArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[29]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setVTEditArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[27], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setVTEditArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[27]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setValArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[48], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setValArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[48]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setValidIdsArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[30], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setValidIdsArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[30]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setVisibleArray(int r4, STTrueFalseBlank.Enum r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[24], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.setEnumValue(r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setVisibleArray(STTrueFalseBlank.Enum[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[24]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setWidthMinArray(int r4, BigInteger r5) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        SimpleValue r3 = (SimpleValue) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[32], r4), SimpleValue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void setWidthMinArray(BigInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[32]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfAccel2Array() {
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

    public int sizeOfAccelArray() {
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

    public int sizeOfAnchorArray() {
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

    public int sizeOfAutoFillArray() {
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

    public int sizeOfAutoLineArray() {
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

    public int sizeOfAutoPictArray() {
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

    public int sizeOfAutoScaleArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[59]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfCFArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[56]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfCameraArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[57]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfCancelArray() {
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

    public int sizeOfCheckedArray() {
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

    public int sizeOfColHiddenArray() {
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

    public int sizeOfColoredArray() {
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

    public int sizeOfColumnArray() {
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

    public int sizeOfDDEArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[60]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfDefaultArray() {
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

    public int sizeOfDefaultSizeArray() {
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

    public int sizeOfDisabledArray() {
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

    public int sizeOfDismissArray() {
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

    public int sizeOfDropLinesArray() {
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

    public int sizeOfDropStyleArray() {
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

    public int sizeOfDxArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[54]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfFirstButtonArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[46]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfFmlaGroupArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[47]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfFmlaLinkArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[43]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfFmlaMacroArray() {
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

    public int sizeOfFmlaPictArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[44]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfFmlaRangeArray() {
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

    public int sizeOfFmlaTxbxArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[66]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfHelpArray() {
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

    public int sizeOfHorizArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[53]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfIncArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[51]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfJustLastXArray() {
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

    public int sizeOfLCTArray() {
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

    public int sizeOfListItemArray() {
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

    public int sizeOfLockTextArray() {
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

    public int sizeOfLockedArray() {
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

    public int sizeOfMapOCXArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[55]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfMaxArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[50]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfMinArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[49]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfMoveWithCellsArray() {
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

    public int sizeOfMultiLineArray() {
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

    public int sizeOfMultiSelArray() {
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

    public int sizeOfNoThreeD2Array() {
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

    public int sizeOfNoThreeDArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[45]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfPageArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[52]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfPrintObjectArray() {
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

    public int sizeOfRecalcAlwaysArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[58]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfRowArray() {
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

    public int sizeOfRowHiddenArray() {
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

    public int sizeOfScriptExtendedArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[63]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfScriptLanguageArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[64]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfScriptLocationArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[65]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfScriptTextArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[62]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfSecretEditArray() {
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

    public int sizeOfSelArray() {
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

    public int sizeOfSelTypeArray() {
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

    public int sizeOfSizeWithCellsArray() {
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

    public int sizeOfTextHAlignArray() {
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

    public int sizeOfTextVAlignArray() {
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

    public int sizeOfUIObjArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[61]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfVScrollArray() {
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

    public int sizeOfVTEditArray() {
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

    public int sizeOfValArray() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        int r3 = get_store().count_elements(PROPERTY_QNAME[48]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOfValidIdsArray() {
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

    public int sizeOfVisibleArray() {
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

    public int sizeOfWidthMinArray() {
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

    public XmlInteger xgetAccel2Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[21], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetAccel2Array() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[21], $$Lambda$CTClientDataImpl$6X1M2plV6tWVG5BobCcjsHak80E.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetAccel2List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$f6HqbBvwvbnC2w6LrbvHvNN8iU(this), new $$Lambda$wn3DlAQkkM3DlqRIUGvR2N4tY(this), new $$Lambda$0PvHBVAsa6tqe1EmJqDdXqka3Y(this), new $$Lambda$3YnKjk2tsetd7ONyhLcoxXUYUdA(this), new $$Lambda$2Yedp1qIwrlR2TJ845f2Zc0vZq0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetAccelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[20], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetAccelArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[20], $$Lambda$CTClientDataImpl$DJk7fyaZEj4o3HUWNkZGw52qU.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetAccelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$d5v4BiXemLEL2X0QeIVJxp7kGMo(this), new $$Lambda$PaOMB9CQzotzrcwkKE5Z9OYpnt8(this), new $$Lambda$f4kcyfbATyGTVqXxM_6Fim1l74(this), new $$Lambda$IMQlckqiJ6we7sOCtscC609DQ(this), new $$Lambda$5BQSXDryEcWAWu9VG0GhUeqxiUw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetAnchorArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetAnchorArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[2], $$Lambda$CTClientDataImpl$PW5NDGUIBnaU3eJbuodSkmtbD4.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetAnchorList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$acmGRdMpYvHxz7NnBHnqIt3Vww(this), new $$Lambda$aUXur6kd78mvnbgiSVcNE7EE_xA(this), new $$Lambda$GCpGCbFxD1UBSllIaRS1X3mtQ(this), new $$Lambda$rSWxinzNEJY0IvN0FrtdLssipLg(this), new $$Lambda$CiZLLcvE_Dk6Xo7_EKVlIHRBk0k(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetAutoFillArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetAutoFillArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[7], $$Lambda$CTClientDataImpl$ORYZIEkFtdcOXdXhFc04mjAnbf0.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetAutoFillList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$C9Fijf57fX_9Idi4ozkxYUoGjHc(this), new $$Lambda$C16IwshTJaRDWod_x_hw1_bCkE(this), new $$Lambda$uNgnEo4bG04WEbV5q8yPiz50Vt8(this), new $$Lambda$4BL35YWmRBiY_dOYT4u3OF6YQdU(this), new $$Lambda$wfla1uDYVcwULzmZGFjOuP24aH4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetAutoLineArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetAutoLineArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[8], $$Lambda$CTClientDataImpl$6k19ZQwK3ZpTyvPmwrL_qtdvlo.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetAutoLineList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$4uMf5S5FQ4zPZ1DDb7lacIyqNFk(this), new $$Lambda$vxhcVTag7kqdbrQdlML21ZUjjLI(this), new $$Lambda$bdbnhi2kXl5dLMrr_GzMu8D0cA(this), new $$Lambda$oflvmwAGSu8DXQloi9AunJ2m4ec(this), new $$Lambda$Iz2bJfdRt6JF4tT0krhqYt_3h2c(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetAutoPictArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetAutoPictArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[9], $$Lambda$CTClientDataImpl$8CrIg6Yh4BYRJloB01JHeQSADug.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetAutoPictList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$BGszNvPyOagLZBBM6k_9dlrrhGg(this), new $$Lambda$N3bkVsSSXZmnNskiE4F815e97Q0(this), new $$Lambda$l0Ry0H3jhs9FOe6DMJrfUC_vQDM(this), new $$Lambda$El1rNzoHvGO3plxtyw36utsVU(this), new $$Lambda$t5vXcCKKIH9TKorK9GiON_4xn84(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetAutoScaleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[59], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetAutoScaleArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[59], $$Lambda$CTClientDataImpl$_ECCE1_tuMJu0fQ_T0_DLXxQnHI.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetAutoScaleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$NYFpjtSMP5zOoTckMCpa_17joPk(this), new $$Lambda$CB7sYiA6hzVECpuop2HvvZJtlmo(this), new $$Lambda$pddTcgA0_UHIBZVyVCKO0vhxtww(this), new $$Lambda$apy7EavKKHd2WpwvZHXqeZMaDc4(this), new $$Lambda$diXrJ1YV0S3gkN8JFk9Cb9olVk0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public b xgetCFArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        b r3 = (b) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[56], r4), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public b[] xgetCFArray() {
        return (b[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[56], $$Lambda$CTClientDataImpl$kNWKUcD7Lo_Oor1_UYms_G0UXs.INSTANCE), b[].class, "com.obric.memorydata.plugin");
    }

    public List<b> xgetCFList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ockZ1AUTZGUvVDpGs41MJY7koE(this), new $$Lambda$xO5mt7l5FEjxbAhDSqAiSjIzak(this), new $$Lambda$HxLI4ic5rx8c5MLMoT48vJdxf8(this), new $$Lambda$Q6Ue95HkzLI2JnmffL_Fm_CZNi8(this), new $$Lambda$oVDDdKDtuHqjdOekVxsdiJYwiwg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetCameraArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[57], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetCameraArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[57], $$Lambda$CTClientDataImpl$TgikfHA5dZfIhB4wCDDD0DFcfc.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetCameraList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$axblzO5Gwjfvpy6KQwQfYZwhhII(this), new $$Lambda$oYCDtilfOX3ff7qzTwrDJbPqndk(this), new $$Lambda$5qjFCIKeWOl5gBpCCJ2BPZrBBN0(this), new $$Lambda$2Uw_tFFAjkOB3sRhGDoP64a38(this), new $$Lambda$sEOUL1RVtz8Wfj0_2ssW7lECA8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetCancelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetCancelArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[18], $$Lambda$CTClientDataImpl$5p9KxcbDdz57chCxp0yXK57nwaI.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetCancelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$WeqLqTO6lVP_iy2QZpRwa4BuZWg(this), new $$Lambda$IGeAxhSdSVk_t3jp4LVR_xmnjnM(this), new $$Lambda$e6B4GvR4B1cW9NLznu8ZGCGHWOA(this), new $$Lambda$27EECSfOCj0Y2QrKOD3vhYJtX48(this), new $$Lambda$WemHsNO8tOCcyiW4TWSJxPr3A(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetCheckedArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[42], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetCheckedArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[42], $$Lambda$CTClientDataImpl$qa_ONftYFIEBVbgF8w0cUX6FOn8.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetCheckedList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$O1JPKvoyuxHM2tIdfuhLbzxDQKQ(this), new $$Lambda$mobC4DsHirY6RebCM9xb9U9vOHg(this), new $$Lambda$1Rvsc1MUUoWwDFQch5AG250pd8(this), new $$Lambda$WUp2xqgwO8wwpF_CzKtGGrz_CBg(this), new $$Lambda$tNTUZVX67RIi_KuZGJNFbDl1Y8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetColHiddenArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[26], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetColHiddenArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[26], $$Lambda$CTClientDataImpl$ZJ5QL4pPXfAnStoZbABjo9AQ1T4.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetColHiddenList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$diGkVz7uH4OI7vPtpqERiu_maBs(this), new $$Lambda$7zmdAjmrEbBLTQfPBAfBXb778(this), new $$Lambda$WmE0ePF1beYHEQ17r_aVdaQ2M(this), new $$Lambda$QMTg7Sj0KZh3Kbk31jome9hmG8(this), new $$Lambda$i45By7VjzrSiJzdkLhBCrw0loGI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetColoredArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[40], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetColoredArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[40], $$Lambda$CTClientDataImpl$nBB5ig25ZS3YG8bGGbvKxzDnU.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetColoredList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$TzB31c1n845lTecvidgiedqNvk(this), new $$Lambda$Bv5IOqELbtCFE0c6b02iCiTqZg(this), new $$Lambda$DpNLVQTTCmDtK_OzY0TXpjWFYHM(this), new $$Lambda$qb16M8ABXHnYvExtNKfltUU2Ug4(this), new $$Lambda$v0hboh8KCn1NVP3Pf_iZQ7XGFY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetColumnArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[23], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetColumnArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[23], $$Lambda$CTClientDataImpl$FQSg5fb8_Ov8KfKngDp4CHswQg4.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetColumnList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$5T9Djr_C8GFUAoxeFbYv1ug8Wg(this), new $$Lambda$kDsAKtQnRBl3cpYdWOaCLrFl9WQ(this), new $$Lambda$Ao9FUWN4VbKMymEp0Ocx2zTekM(this), new $$Lambda$Aul2hafpolFp5BEWcvFmi5_g0(this), new $$Lambda$GDQiNxlRnLHccwW2lFD41brPRDI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetDDEArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[60], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetDDEArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[60], $$Lambda$CTClientDataImpl$nyITTOyf4Uy5Md1NuKqpSPaPoWg.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetDDEList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$yzJ4MhoczHAkrJ5GpEtkqiwNqBA(this), new $$Lambda$AktEJ0_SrCmXpBH_Y_NMdfEdpSk(this), new $$Lambda$HlxNYXRuDP7mN9L3TA8wSz6ZYiM(this), new $$Lambda$ttL6_gPQJKPmUHOPLR7FPJe7Ubg(this), new $$Lambda$cSZ22IsFOgP3rN8g4sYREzqok4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetDefaultArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetDefaultArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[16], $$Lambda$CTClientDataImpl$TUBfAep0fYmoe5IwgK7T1TL8cXw.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetDefaultList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$K9D2ABWWKomTqw3IHdRNaXtiGnc(this), new $$Lambda$Q3x6vM0ZFMq1aLcWq82TbVIX24(this), new $$Lambda$r7I5VD3gL695Vpt3_uqAkWPbt4(this), new $$Lambda$7vQZPWqHPGnTftRrypyFN_RDBws(this), new $$Lambda$0RMFJxKFy5txc6DfAaisAsgvwrU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetDefaultSizeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetDefaultSizeArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[4], $$Lambda$CTClientDataImpl$JjElVefu91HMAKQ1TDOGwmGoIY.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetDefaultSizeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$qKdDvAU7CVDJJUUC3NkdJLgFEc4(this), new $$Lambda$ufwFRWpDzotvvcue_OxcQstuQ(this), new $$Lambda$MdPrCuPN9AQSNK9DCjvc_7Y4HPs(this), new $$Lambda$Cd5ZbSbLGIySo2UuQ4dp8z4lCFw(this), new $$Lambda$1pKd1NAYBWzUpZkcSaltzg6kn5I(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetDisabledArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetDisabledArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[6], $$Lambda$CTClientDataImpl$E2DLyOYXu9tHkEr15DDIXgjXYs0.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetDisabledList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$YmknbcwBXh138_f8udKS2ORTY6w(this), new $$Lambda$Z3tg6vtJAluflaM7f0J6hwhoQ(this), new $$Lambda$QryakHgAcYjBBKeoSGDl4EdwM(this), new $$Lambda$0Q2xGiYRKSfxeVCgUz3mkBsYI3A(this), new $$Lambda$YOLZv0upYB5tcdZB6LNeIEs3kM4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetDismissArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetDismissArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[19], $$Lambda$CTClientDataImpl$hGENi627DrrIo3MgEb55PJGkvo.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetDismissList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$liugka6W4efEQdHs2n2ESGa6hpg(this), new $$Lambda$KfDGdLEl5saf0ICd0NIPE7EvpmA(this), new $$Lambda$_xcN2OKd7MVShr6nSLwnJBcWA34(this), new $$Lambda$3atnZHHSxAlXwnyOao3y3yg6Fbg(this), new $$Lambda$zNa8Dzj4PEs9YJ6mDZjN28bsVng(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetDropLinesArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[41], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetDropLinesArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[41], $$Lambda$CTClientDataImpl$Xho1wi04VXFDjmIyRREwr50pI.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetDropLinesList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$KkrADmPQUtdKxdXY8ty2WIMRPLk(this), new $$Lambda$vJZPWiwPh_p1UcgGjwsd7yWEgc(this), new $$Lambda$bOdWrm9ZgS8z6M0lFukcYf6T0mw(this), new $$Lambda$Fp97Eib2cuuwePv6xcxkFjKzqQ(this), new $$Lambda$mhKsvqgGlIrO0KgkN69tqLgDNM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetDropStyleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[39], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetDropStyleArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[39], $$Lambda$CTClientDataImpl$YhE_16xJ0eF8EuF6NnpRlCruZss.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetDropStyleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$dTgswNh_Y4nf3Naw_rh0mOc5SZY(this), new $$Lambda$1rC39IuzIR1LUKt45FXQwdN8Qlk(this), new $$Lambda$aWperXaPcJO7qfv8kHM9nMUKVkc(this), new $$Lambda$yh38pV1iNT0fbYmX50fNrnKdFcw(this), new $$Lambda$y0fEEguGUoMFBGW0iMxTOAkqbPU(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetDxArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[54], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetDxArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[54], $$Lambda$CTClientDataImpl$KrLBEHbkb5zlQoNFnGWH4DVbXg.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetDxList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$2_0NsV2iIF2QLZf2aT2xUk2vWUM(this), new $$Lambda$JZ8x2r6de4PL1G5Rj0jyRJ81GHc(this), new $$Lambda$wzBP1Spymk9wx21R7eCBRE2dOU(this), new $$Lambda$ytgQqfJI3_Ye_puZnyh53VdZQy0(this), new $$Lambda$8h5vKdBQ2qr8dae3QT7JRTKlFE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetFirstButtonArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[46], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetFirstButtonArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[46], $$Lambda$CTClientDataImpl$iNzQNm6SODeLAzkHeFLgDhLVFBk.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetFirstButtonList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$rMPUdogldiJN8imrxPTaVDqIQ78(this), new $$Lambda$v76POMrR9BS0m_GKDfZeVRv6r8(this), new $$Lambda$znzn9TpYrPxRTsE0KHKKVrwoUM(this), new $$Lambda$g1xiop8U7xeOSJj6OamQfZlIyNU(this), new $$Lambda$zEppJyrbd2CWe2lfRaKNouS11M(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetFmlaGroupArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[47], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetFmlaGroupArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[47], $$Lambda$CTClientDataImpl$LyRDt11QODctFCfTOYgrxofC_hM.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetFmlaGroupList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$DP7fEnGaCKZd35MK3cMVxOi0BHE(this), new $$Lambda$QB8qAYveK98thtxr4S8tQNWJ0(this), new $$Lambda$7HNyEy1ZY8XLQxsQLI1Ic4XJU(this), new $$Lambda$uUYTh1JFMsX8BOTOxmCaBfKWhZA(this), new $$Lambda$hwkk1k0tTfLdrlpgGnz5GOaqUGE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetFmlaLinkArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[43], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetFmlaLinkArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[43], $$Lambda$CTClientDataImpl$3S3faCyu34tEpLPnwxoGo9tPsYo.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetFmlaLinkList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$HpxldYIeVp4Wrw9pTX2WitKRKJM(this), new $$Lambda$QrkuneqNiKiS0W9cj9oi_Xme_Y(this), new $$Lambda$SSv40Y80fwWBJHUsjnimf7or3c(this), new $$Lambda$KP6Fgv87sl5UwDah8p_km4JBkXw(this), new $$Lambda$QLYsgJuKtHqkq5gzFd3Tbwa3pUQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetFmlaMacroArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetFmlaMacroArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[10], $$Lambda$CTClientDataImpl$arsXaMLoR4VTQ0lJhLDQ7Br250.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetFmlaMacroList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$7lndZIRY8kKzUAN8RQlx0rHoH_c(this), new $$Lambda$nUf9XTmJXj4KMLvHNUJtbyOvqtw(this), new $$Lambda$QljbarIExayLxWol8nJKVSndjXM(this), new $$Lambda$TkfUWvmcAGIgITMkItuM20s9dA(this), new $$Lambda$H9m5oaZeYiEyz_0i4sZwxifWn7I(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetFmlaPictArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[44], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetFmlaPictArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[44], $$Lambda$CTClientDataImpl$9tlwlH85CWX2YVb838jDZnCYBc.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetFmlaPictList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$jfNXK2YZRvbxK2ldUHjSxkagFyQ(this), new $$Lambda$jDzTEhJ71EsdyEaUem9nB52585Q(this), new $$Lambda$vioILB0EkriftHZyzBLnxJq6_g(this), new $$Lambda$agUI8uuKTu0T23S_4Nt8MOLZLwA(this), new $$Lambda$lXyXmkXiKOLaRxL2XMUOcB1QRng(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetFmlaRangeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[31], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetFmlaRangeArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[31], $$Lambda$CTClientDataImpl$oYwE_4pu_qU8Qcr4D_BLELfS2o.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetFmlaRangeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$o2N7UEKNtxVACPNxktR1DBsLwaA(this), new $$Lambda$nqCVAiE_Gt3r0FfAZRHDnBf0z8w(this), new $$Lambda$L40SNSnaUsSUYFZEn_C4thhJiqM(this), new $$Lambda$pm01oKN5twkl5ICNiHiVmlDBiD8(this), new $$Lambda$06JOb8u1SObGvrvVv34F03IBPE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetFmlaTxbxArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[66], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetFmlaTxbxArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[66], $$Lambda$CTClientDataImpl$wA3jfVN9_CZVpnfRpc3KvLix5bQ.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetFmlaTxbxList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$BepiEZHFGv0v6xSL8E8wKxpPF4(this), new $$Lambda$T85pXPt_VBcdy2iAFHIYlN2izKo(this), new $$Lambda$iErIG7uWS5gzakJyEs_ArMgJCs(this), new $$Lambda$qVkyJDNT7pZX_Es6PHCmDMjPpAA(this), new $$Lambda$ziuIcDTTQzFymIbQltMs35p_o0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetHelpArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetHelpArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[17], $$Lambda$CTClientDataImpl$pYFSSuxMf_9knozxyq5zRhLNsvU.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetHelpList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$uNpauJKE2Mc3Qb6wg3xpEkptHQ(this), new $$Lambda$8A0O4ra4eZb_hd_HmSV3o0lDLGQ(this), new $$Lambda$FrojDtq8f6BmT79dqGv0kg4oUbs(this), new $$Lambda$V6wkgXLFJLQLzoYoQwvqVwQfwA(this), new $$Lambda$wVxkgLgLxj_dKMwDPotkhybiZ5k(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetHorizArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[53], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetHorizArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[53], $$Lambda$CTClientDataImpl$iTFKvglhqAQEnLI8WK5ytOscMk.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetHorizList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$mJ9kpBW17g870DPAMBa7viZhaG0(this), new $$Lambda$0mOqgpHO42iRHRygxM_mu2phPmg(this), new $$Lambda$DEUJiW10mETnklrDP_8E9j8QYLY(this), new $$Lambda$Y8FtMSs8hJOwB4gVPDbNAVNZYA(this), new $$Lambda$w2_HUBRuMIh1Ez3QOkZhLMxZ4KI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetIncArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[51], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetIncArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[51], $$Lambda$CTClientDataImpl$PSCDX6y5CZt436_agfFiZ489h0.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetIncList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$nZW7KxmeZda6mM1BonPNoaH3Fik(this), new $$Lambda$nvnovekCZGugKq9ChuNecvZ4eU(this), new $$Lambda$5gxH33PPyX0xWfm3ZlM9GqW6QSk(this), new $$Lambda$w6xvFxrddkSYfrtQLH_s740CG90(this), new $$Lambda$IxX5dQ___smvPE_3FGq9gPJgQBw(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetJustLastXArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetJustLastXArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[14], $$Lambda$CTClientDataImpl$f5UBYg01BwapPUUQXyNoxa6NKI.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetJustLastXList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$eW1xrn9PU38BD77LMbdj1jgME(this), new $$Lambda$wE2rEGLJIfUUuOMAyW683NMqzc(this), new $$Lambda$Xpiv6xHofAJnrmggnX0JGpA7O_Y(this), new $$Lambda$Kv4LwvhxHn4UacPdy37LMTzancA(this), new $$Lambda$5nJo8urDro0OUUHHblkqdP5ZRhE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetLCTArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[37], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetLCTArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[37], $$Lambda$CTClientDataImpl$6QbnO_NGAhVfvWxpybxL67dEU.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetLCTList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$CezL3jB1_R46OfMmx1Dx3kfYzU(this), new $$Lambda$tEUNEwovU4g8AmGSQZTnkUSmPek(this), new $$Lambda$Z8Vg4ycqJCxkQiPQr1F9q9tWWnk(this), new $$Lambda$FYnbh0SgKOs6KEx8GbmtSr5OUQ(this), new $$Lambda$q3qr3lzb_BAmHyOzUr4z8OEMQFo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetListItemArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[38], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetListItemArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[38], $$Lambda$CTClientDataImpl$x4_Vf0Hi0XQ_iPNttiaH98D2Yc.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetListItemList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$7gYPMZZmi53Mqu4_ITydKORlvo(this), new $$Lambda$QpOhMdEp1jm5iT2B9Fy18lvIAjs(this), new $$Lambda$nwk8d8HWnGM7xzsF8MS75layQs(this), new $$Lambda$gGNBqN_RTi1I_9EwSWDB2NAoB0g(this), new $$Lambda$ZWpx9HU_hYLbZI3lCCtNV3qRi8(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetLockTextArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetLockTextArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[13], $$Lambda$CTClientDataImpl$40NIxNBZtfE_KuuJ_s1Npih1gc.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetLockTextList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Mc1ozYg20vQewrDrTMauDcQ7M(this), new $$Lambda$ZyCAkVfBd89rKQDRTh8hPW0nE(this), new $$Lambda$rW6kWe3D_Qo0Yp3cPfafzZHUitk(this), new $$Lambda$EgJrADOGXOqtNkjRuD6rOGGapc(this), new $$Lambda$t4qldCStnx3sY23NVWWfNZNkqHI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetLockedArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetLockedArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[3], $$Lambda$CTClientDataImpl$LoSP9Pb6D4TEu5eYSgN7bvIu5HA.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetLockedList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$tnP8ESFBsX7Y1ECIMd8qj5jmZxQ(this), new $$Lambda$KSKm6FgWXX6PRvDQkWI219qmiE(this), new $$Lambda$RLDiqfzJHMOX36P4EKhrCrd8fx0(this), new $$Lambda$ocWdZ9s2dEY02MmElbkJHcRsMy4(this), new $$Lambda$H4R2oT6ud5IY4dScQy2IVVMWoLg(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetMapOCXArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[55], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetMapOCXArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[55], $$Lambda$CTClientDataImpl$wz2rAKnkV0BgmW7J1T8ZMigTQg.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetMapOCXList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$SHrbxBvObXgwlGS9si6wvb0HOMQ(this), new $$Lambda$lF3nSBJAetp7f_8jpFNUL4s5E9c(this), new $$Lambda$qXdSZ0C3FGULfH1AVygcthuP4(this), new $$Lambda$s9XAFyuLp1gzO5UHXK8bH0j05To(this), new $$Lambda$tlogvyiB5qX49V4KWUEWku1TKE(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetMaxArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[50], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetMaxArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[50], $$Lambda$CTClientDataImpl$vTOTBeQHveSch1HEV1dk6zgSa70.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetMaxList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$pwnSPnVHviksujXFE9R0GX_wXc(this), new $$Lambda$WWM5hIgCzF8vwoAckyH71sPqXO4(this), new $$Lambda$IGJzH_7kLOozKiujDoqygsgQblw(this), new $$Lambda$vOMdhYhYl5Zv_K4A08iCAPG2hIk(this), new $$Lambda$CWRUnNSmv8Pjr3D9uZ95sB8oDVI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetMinArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[49], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetMinArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[49], $$Lambda$CTClientDataImpl$9baMyd4SP3bH1OUX8PMmRPWTTkA.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetMinList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$YUMKVqoQIIOZLaX97qDn4gFcyB0(this), new $$Lambda$sZuQjVz87psSyhXXlF95976WrM0(this), new $$Lambda$DWncBm76NgMtFiX1mAg9r2B1F7g(this), new $$Lambda$B7Ky5siVx_umJ6C1SxSniea6bA(this), new $$Lambda$XTCwud852og4Sz30SSZwxWnd3zI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetMoveWithCellsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetMoveWithCellsArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[0], $$Lambda$CTClientDataImpl$vz8ZSsEaT9tB2kyp8zIW9TvOfHc.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetMoveWithCellsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$b37KyhOW1IuIaZT8Qr08YiEd8(this), new $$Lambda$OrgNdGff3locrq8Tt0x6CtoZHZk(this), new $$Lambda$cDKOlorE1zulZfbyMoKtAYBA6Q(this), new $$Lambda$ADx5dZytaAxgmC2hVr0LgXF8ySU(this), new $$Lambda$MYw3s33pxjthMQ8x0MZkE6OQ1is(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetMultiLineArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[28], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetMultiLineArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[28], $$Lambda$CTClientDataImpl$S5coR3JvL3bQdOUcOPhTrF3pB4.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetMultiLineList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Djg_GYksk2HrNaqX3w9CBNwfNg4(this), new $$Lambda$QO3261OalYKoQe5ydGignCdY2o(this), new $$Lambda$9evYRcLKW_8NryXsWEkL63NS70(this), new $$Lambda$Bupv09uZW0ApP15yReT1nFIlrw(this), new $$Lambda$LiagtY88uG9hLqs0uxAwzgMEeA(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetMultiSelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[36], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetMultiSelArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[36], $$Lambda$CTClientDataImpl$E0Q5Fjgsno0eskdL0eijUrn3hc.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetMultiSelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$FJeDkThjaJViNxjO2qUFZ7BZ2Io(this), new $$Lambda$s4ewgOZf7dPDsyBuzgWO0NWA_c(this), new $$Lambda$2nBL_59twiKuDosEUQTHsyiksI(this), new $$Lambda$axzHxXExfaw1UUq1Y9msKwJQtXg(this), new $$Lambda$e1vmoSS6Ifwd81Wu5SjIazYwYlo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetNoThreeD2Array(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[34], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetNoThreeD2Array() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[34], $$Lambda$CTClientDataImpl$b1_5HSQoZX7prox9l2nSTQzl0Xs.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetNoThreeD2List() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$9Itz8FM2tKfARqStPLxukHycw(this), new $$Lambda$pGhs7jT40PbRJFwj6rKXobsJEVE(this), new $$Lambda$q50hyZeLgmcXhBY21BVZYfNhIY(this), new $$Lambda$73NIdQYsAXsY1dRraW3A2J64O8(this), new $$Lambda$msJ_ZQoSEYUagoDctgzz6qnTx8c(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetNoThreeDArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[45], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetNoThreeDArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[45], $$Lambda$CTClientDataImpl$_UcK1BoQPQcs4grvXoLYu7xzNQ4.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetNoThreeDList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Cop3Lqv1mWSgZt0EsdZbon5TZ8Y(this), new $$Lambda$uAaudnHBBcBoMpp0t97YHB7o6Q(this), new $$Lambda$RXwbEqcMEt5c6lvpIU1KfapxQo8(this), new $$Lambda$XRqCzbFfH8eXvI6VliDDTuqWavM(this), new $$Lambda$nI99fZnFHa1Yr83AT6u5alpt7xk(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STObjectType xgetObjectType() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        STObjectType r3 = (STObjectType) ZeusTransformUtils.preCheckCast(get_store().find_attribute_user(PROPERTY_QNAME[67]), STObjectType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetPageArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[52], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetPageArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[52], $$Lambda$CTClientDataImpl$ADacW6BDVIQFvamVHdmKHjufDnI.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetPageList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$ekzchFo7pxNFFwG86CByTvKZ98(this), new $$Lambda$maxKYi6k7vQ7R4xtHASVHDLoa0(this), new $$Lambda$LaqqQOeFiH15sdGorzqI42NpPKg(this), new $$Lambda$jvlaCsOlMehwQD3bOiGzsCBoYew(this), new $$Lambda$X19ip9aEmW6jTtAx__CrHtbuZeo(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetPrintObjectArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetPrintObjectArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[5], $$Lambda$CTClientDataImpl$FDhnX3leh6fFGL5XnWul8y6_zoo.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetPrintObjectList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$xSiNpjHPDchGTUGu95Bsuwh3FZA(this), new $$Lambda$FaHkht14BXkVG8pVWddJyEHj43k(this), new $$Lambda$xsn7cU67PkBdY3uhELpk1DjwEOQ(this), new $$Lambda$fgMh2DirTsBNoAE_mbJxEbAk9B4(this), new $$Lambda$9mq01LQJNTvbzRmcixbhoQEV8I(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetRecalcAlwaysArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[58], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetRecalcAlwaysArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[58], $$Lambda$CTClientDataImpl$IakW9QxSmcjGsvpz3ufsCDGvqQ.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetRecalcAlwaysList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$k4H05DMgDbIiKEx57IYFoNMv4Pg(this), new $$Lambda$zGOi21AKM10R49j7qNPR8YAE2lw(this), new $$Lambda$zg64VtMloJjvf8AOdvyYw4wGVs(this), new $$Lambda$wCSsOzwt5MLsTVCm98mR6vgVWA(this), new $$Lambda$d5przCs37B3qaDxCZJlHABboyyM(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetRowArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[22], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetRowArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[22], $$Lambda$CTClientDataImpl$gikH5jH9rJW1QoB8UpUaNmeh5Tg.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public STTrueFalseBlank xgetRowHiddenArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[25], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetRowHiddenArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[25], $$Lambda$CTClientDataImpl$YdHmyfNwGa55ENyFp9ZXQYilUs.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetRowHiddenList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$KPJ7k_NOlIqYSdxTNu2BqAt3U(this), new $$Lambda$5SnAiRJb6qf4WhvKSY5s_aYyPgY(this), new $$Lambda$_GMSsCVm790pm24fllk3QwBE0RI(this), new $$Lambda$H0svn85s8Er6CQvk4TXzgc4CeU(this), new $$Lambda$1hV4I6m7UCJCtt9jKWCf1Dnt96s(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public List<XmlInteger> xgetRowList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$YfdQigJmcI2TyX_Qfi2RAvcxMPE(this), new $$Lambda$0EHNVERKcIIuo5fZPTarMdeeqE(this), new $$Lambda$sArSPuDgyaZg3CrOmAZ9vc0NWIQ(this), new $$Lambda$lejKkDMQwqi90CQSvXG6zUDB88(this), new $$Lambda$m2NghEHbpG4oiIpoxP2MlsJqOd4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetScriptExtendedArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[63], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetScriptExtendedArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[63], $$Lambda$CTClientDataImpl$_1SMmC2lrQPW4OUjsBOsivD34A.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetScriptExtendedList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$2CHbBnGy0zxM3AaVzheXU6kS4U(this), new $$Lambda$KQS4rrYp6XU9hNjN4w1wiUmaYM(this), new $$Lambda$haVIQWdY8AoWuHYeVe8vboEMclo(this), new $$Lambda$7c9NYuWwGoDQmQ28yTZ7j0sDa90(this), new $$Lambda$tzACmQL7ZloZ4q2EP8lxgRKaITY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlNonNegativeInteger xgetScriptLanguageArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[64], r4), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlNonNegativeInteger[] xgetScriptLanguageArray() {
        return (XmlNonNegativeInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[64], $$Lambda$CTClientDataImpl$tzX4l1VbhsGUgjRCSsGOy1YXaCs.INSTANCE), XmlNonNegativeInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlNonNegativeInteger> xgetScriptLanguageList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$U4qkM1mHlKFxZ36TF2VVj_uj4Kw(this), new $$Lambda$LQUAajcSYsD9GW2EFantrbfKKI(this), new $$Lambda$tNe0SKzVmDW_sY6ZD254iSR95bM(this), new $$Lambda$PWNwOz8HMPB68pnCmpoifl9ppPg(this), new $$Lambda$0CG4yJKGuRH9S6RDfN_5IQzw2fY(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlNonNegativeInteger xgetScriptLocationArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[65], r4), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlNonNegativeInteger[] xgetScriptLocationArray() {
        return (XmlNonNegativeInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[65], $$Lambda$CTClientDataImpl$03L9v9mmIEJvvJssSz4YR9xL_6g.INSTANCE), XmlNonNegativeInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlNonNegativeInteger> xgetScriptLocationList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$K1WECmX9oYy5EzAgo4mg7cdV0(this), new $$Lambda$_ioT3i4bmEL2XV4ASOQsIN2TnQE(this), new $$Lambda$wUTjj8p5imY7uxcohGMfwn_wYu8(this), new $$Lambda$wAmIGGBi_ZSa4TKOAlVkA5O8aE(this), new $$Lambda$2UUKgr6DgBsLgGsh89Grde79u1E(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetScriptTextArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[62], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetScriptTextArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[62], $$Lambda$CTClientDataImpl$rzyUVnaEpS0efG_k2OntPbKDvVg.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetScriptTextList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$mtcI2LEJ8EwPOOxwzoiNJQi2cMA(this), new $$Lambda$innG4PkNfNwYDY_rApW_jwBwvi8(this), new $$Lambda$kgtwwEYqY5NO3u3uwoMp8F5WbWs(this), new $$Lambda$_y9FTritJNEkA5FKhYpjf3CHI(this), new $$Lambda$wlkHnUUYodRqWAdHvhtLDdgFgac(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetSecretEditArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetSecretEditArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[15], $$Lambda$CTClientDataImpl$tdse77GcCOsss5maih9dT9Yjqt8.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetSecretEditList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$rHqkZMXq6ExqD0qyjYl0BNY8xw(this), new $$Lambda$2lQ8V_t3n4nod9puEsJLE68P1wA(this), new $$Lambda$NKL9xYBOLoafc__wEOevy1jEY(this), new $$Lambda$yINxT_pkYDzuo7lCvSSdRvEhI_4(this), new $$Lambda$2UmYaBjMMZkrF0iCFbohnksDV4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetSelArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[33], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetSelArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[33], $$Lambda$CTClientDataImpl$GIQ8ixCEOpiEFqaaKDe0AUlSd7U.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetSelList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$1vDB1RJXVmzu15J1Ip0HjmHu5o(this), new $$Lambda$oDrN1HqmAnJQZotiCL2nKI6mtIw(this), new $$Lambda$hOUt0rQOubPVWfEZ1WEOBE39Pec(this), new $$Lambda$dYelp2yY0xYIF8UQs5gtZFRTQ(this), new $$Lambda$_A_8zpTRns_dlcuC7jotbkIcw3A(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetSelTypeArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[35], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlString[] xgetSelTypeArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[35], $$Lambda$CTClientDataImpl$DABSdeWMEcfxaqnWcslqUMBuhZM.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetSelTypeList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$szdY1ZTNk4b4Ncgya66EkKMaF6U(this), new $$Lambda$QxjuC9rjBpnIraUBNMKXn7GFQ4(this), new $$Lambda$My5sWox07ACeniudzBkBLUUmfOE(this), new $$Lambda$dhRfh_IQI3ivhAzeOajyL2Hodb0(this), new $$Lambda$l7unPzIjmMFUuCVoV7wYSk_d9MA(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetSizeWithCellsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetSizeWithCellsArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[1], $$Lambda$CTClientDataImpl$oGTzuFNeLKNfef2USFT1ZryEPQ.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetSizeWithCellsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$Mc1IVCzDJcJOTil5KW8d6iO3x8(this), new $$Lambda$0B2HeOpgJNQKSmt6ozdg8pzKoVs(this), new $$Lambda$GtmiN5qLqbVYeVapG7IdEk2iZI(this), new $$Lambda$DAOjkgZSZ_2_sckiiqSto2SC6Ys(this), new $$Lambda$M8IX3kjxHcLW3L8v9Y4Otsz_JtQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetTextHAlignArray(int r4) {
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

    public XmlString[] xgetTextHAlignArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[11], $$Lambda$CTClientDataImpl$bwj2cuh4xNbXDVj5E6PKe1_nY.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetTextHAlignList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$nMZIYFY2P9o3ZfkE483DfumLMSg(this), new $$Lambda$RruXfiEtbaA2ksXN93hn4RKlL3g(this), new $$Lambda$jL8417XvdQPtRbtwU8AvUTWlhxg(this), new $$Lambda$ibuSItcsBXEBF7LEP9S4qMstedA(this), new $$Lambda$UkPB0LnmKpYptz3f1Fd7v9Lq59E(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlString xgetTextVAlignArray(int r4) {
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

    public XmlString[] xgetTextVAlignArray() {
        return (XmlString[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[12], $$Lambda$CTClientDataImpl$E7nr7psnjQVT2HtV3jNJhvGbMA0.INSTANCE), XmlString[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlString> xgetTextVAlignList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$3ZQ7dXCIIw_AUyxsRbnkPPyIdyE(this), new $$Lambda$OuO5tGki91aMlz8KEbfzWawUVM(this), new $$Lambda$EtnAJ62wcNy4wmnNz67qE0FcnI(this), new $$Lambda$_heMd2cKiuZLqC1dTG1WmMPJ5d4(this), new $$Lambda$1_hWYiuBj3v6qUCzfuNo_OIcrvc(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetUIObjArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[61], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetUIObjArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[61], $$Lambda$CTClientDataImpl$CS2XG4s2oFYYIw0kPfVYL504tds.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetUIObjList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$8uvOBY73GDk3TZN2q25MY3B3h8(this), new $$Lambda$2XNX8RhfNYMDgRvFYkHB6CPeDQ(this), new $$Lambda$NL837ukxfvQw24lceSMiQer2m0(this), new $$Lambda$O9EIoc9fpFmMrblsEjBlAhp0gXQ(this), new $$Lambda$SvolCexMUMvqawcpOLekYeT3EI(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetVScrollArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[29], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetVScrollArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[29], $$Lambda$CTClientDataImpl$0gToRf9jzO5F81SAyfvF0m6EISY.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetVScrollList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$y4fRFehQ5CzXvrNWQOKyKEQIDJU(this), new $$Lambda$PpRpsEPewHzn298n9KxslMbBQ(this), new $$Lambda$ZITFF6ZpZ1BtoMNTcEtQ_BD30(this), new $$Lambda$akIfqb1PeI55FAJXPm6pT2zZx5w(this), new $$Lambda$Qa1aVDcnEz0ae8WpD9Lg61uqxo0(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetVTEditArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[27], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetVTEditArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[27], $$Lambda$CTClientDataImpl$sZcSCxXm79X4Sx1_QyvRGinn_0k.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetVTEditList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$wURqBQgdmj6_pqLBB77WZebBkY(this), new $$Lambda$S37LZsIq4q0iG1gpkjcs3qWgfSQ(this), new $$Lambda$9aHWQ_TkQtVJy5ewiEpgNSvwZ8Y(this), new $$Lambda$ww0ULlrLFC5SzS0B5Q7rAC1ZG5g(this), new $$Lambda$L5wzapqW06vIUQJnl8yRvOrQCV4(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetValArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[48], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetValArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[48], $$Lambda$CTClientDataImpl$qABjFRitlypLF7C_VZ4pACHtj4.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetValList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$q3ZNtmvH2bH_vNDJxST4YWp43g(this), new $$Lambda$PtDtamLHg3Vp0Q9frYB9PJFoeo(this), new $$Lambda$APvfahw5cTeUdwLUN1gIPNiU0(this), new $$Lambda$1TBSUOC4EfpYRzwm_qSqcGXFZjI(this), new $$Lambda$WX5tbo8CGj60nvX3iu5S8MyJpGs(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetValidIdsArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[30], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetValidIdsArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[30], $$Lambda$CTClientDataImpl$LG2n56UOFjoIWSg74S1rtzc1vH0.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetValidIdsList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$54aWHo1TAXAuXl4ai1lifi26xw(this), new $$Lambda$n7t1HCCHVcUODUjmqz9wJTlOyFs(this), new $$Lambda$L7O5BrT6KngJtycXd1_pjLN2Q(this), new $$Lambda$s1j7_sPNt94mJcUzDVhxvhZOaQ(this), new $$Lambda$OeSLPChgMI7SKGC1u6mWNxT0oQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank xgetVisibleArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[24], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public STTrueFalseBlank[] xgetVisibleArray() {
        return (STTrueFalseBlank[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[24], $$Lambda$CTClientDataImpl$iId8oCbsuUu_CEPGlICr_hpI.INSTANCE), STTrueFalseBlank[].class, "com.obric.memorydata.plugin");
    }

    public List<STTrueFalseBlank> xgetVisibleList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$hL4ifUUFHOMJP0YSxRtCkQOdKo(this), new $$Lambda$pq2zrhuA74BDDswc2NQzkyjdUy4(this), new $$Lambda$iDeefqfEVck6Z0LnisRMcb6VmM(this), new $$Lambda$9vCfVTt33lbRFBqsLxVWFJ16nQU(this), new $$Lambda$jgx4ms9K3TI59kZNr9yP97QSvjQ(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public XmlInteger xgetWidthMinArray(int r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[32], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L9:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public XmlInteger[] xgetWidthMinArray() {
        return (XmlInteger[]) ZeusTransformUtils.preCheckCast(xgetArray(PROPERTY_QNAME[32], $$Lambda$CTClientDataImpl$hH3spxuswVqhT1Hdz32qQDb9q4.INSTANCE), XmlInteger[].class, "com.obric.memorydata.plugin");
    }

    public List<XmlInteger> xgetWidthMinList() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        JavaListXmlObject r7 = new JavaListXmlObject(new $$Lambda$uur_Nc2affpOgtVUY69Qnh6ehQ(this), new $$Lambda$g_ARMdGLQa86Eh_T2tZxpMlgpKY(this), new $$Lambda$cLWhGujWf226VfH4MbQBIe5SELw(this), new $$Lambda$pkaGtOwbA8rRFoP0rqRdxkZFnz4(this), new $$Lambda$09R2MblJIvA7DfehlY0865Jf67w(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetAccel2Array(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[21], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetAccel2Array(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[21]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetAccelArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[20], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetAccelArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[20]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetAnchorArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[2], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetAnchorArray(XmlString[] r4) {
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

    public void xsetAutoFillArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[7], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetAutoFillArray(STTrueFalseBlank[] r4) {
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

    public void xsetAutoLineArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[8], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetAutoLineArray(STTrueFalseBlank[] r4) {
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

    public void xsetAutoPictArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[9], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetAutoPictArray(STTrueFalseBlank[] r4) {
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

    public void xsetAutoScaleArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[59], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetAutoScaleArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[59]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetCFArray(int r4, b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        b r3 = (b) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[56], r4), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetCFArray(b[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[56]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetCameraArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[57], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetCameraArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[57]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetCancelArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[18], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetCancelArray(STTrueFalseBlank[] r4) {
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

    public void xsetCheckedArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[42], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetCheckedArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[42]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetColHiddenArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[26], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetColHiddenArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[26]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetColoredArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[40], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetColoredArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[40]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetColumnArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[23], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetColumnArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[23]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetDDEArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[60], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetDDEArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[60]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetDefaultArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[16], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetDefaultArray(STTrueFalseBlank[] r4) {
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

    public void xsetDefaultSizeArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[4], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetDefaultSizeArray(STTrueFalseBlank[] r4) {
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

    public void xsetDisabledArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[6], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetDisabledArray(STTrueFalseBlank[] r4) {
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

    public void xsetDismissArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[19], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetDismissArray(STTrueFalseBlank[] r4) {
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

    public void xsetDropLinesArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[41], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetDropLinesArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[41]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetDropStyleArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[39], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetDropStyleArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[39]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetDxArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[54], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetDxArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[54]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetFirstButtonArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[46], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetFirstButtonArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[46]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetFmlaGroupArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[47], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetFmlaGroupArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[47]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetFmlaLinkArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[43], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetFmlaLinkArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[43]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetFmlaMacroArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[10], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetFmlaMacroArray(XmlString[] r4) {
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

    public void xsetFmlaPictArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[44], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetFmlaPictArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[44]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetFmlaRangeArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[31], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetFmlaRangeArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[31]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetFmlaTxbxArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[66], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetFmlaTxbxArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[66]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetHelpArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[17], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetHelpArray(STTrueFalseBlank[] r4) {
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

    public void xsetHorizArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[53], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetHorizArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[53]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetIncArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[51], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetIncArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[51]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetJustLastXArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[14], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetJustLastXArray(STTrueFalseBlank[] r4) {
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

    public void xsetLCTArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[37], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetLCTArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[37]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetListItemArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[38], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetListItemArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[38]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetLockTextArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[13], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetLockTextArray(STTrueFalseBlank[] r4) {
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

    public void xsetLockedArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[3], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetLockedArray(STTrueFalseBlank[] r4) {
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

    public void xsetMapOCXArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[55], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetMapOCXArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[55]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetMaxArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[50], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetMaxArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[50]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetMinArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[49], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetMinArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[49]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetMoveWithCellsArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[0], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetMoveWithCellsArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[0]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetMultiLineArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[28], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetMultiLineArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[28]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetMultiSelArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[36], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetMultiSelArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[36]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetNoThreeD2Array(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[34], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetNoThreeD2Array(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[34]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetNoThreeDArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[45], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetNoThreeDArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[45]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetObjectType(STObjectType r7) {
        STObjectType r8 = (STObjectType) ZeusTransformUtils.wrapperContextForParams(r7, STObjectType.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L10
        TypeStore r1 = get_store();     // Catch: Throwable -> L10
        QName[] r2 = PROPERTY_QNAME;     // Catch: Throwable -> L10
        STObjectType r3 = (STObjectType) ZeusTransformUtils.preCheckCast(r1.find_attribute_user(r2[67]), STObjectType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        r3 = (STObjectType) ZeusTransformUtils.preCheckCast(get_store().add_attribute_user(r2[67]), STObjectType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        r3.set(r8);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void xsetPageArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[52], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetPageArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[52]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetPrintObjectArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[5], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetPrintObjectArray(STTrueFalseBlank[] r4) {
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

    public void xsetRecalcAlwaysArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[58], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetRecalcAlwaysArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[58]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetRowArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[22], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetRowArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[22]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetRowHiddenArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[25], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetRowHiddenArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[25]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetScriptExtendedArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[63], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetScriptExtendedArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[63]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetScriptLanguageArray(int r4, XmlNonNegativeInteger r5) {
        XmlNonNegativeInteger r6 = (XmlNonNegativeInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[64], r4), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetScriptLanguageArray(XmlNonNegativeInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[64]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetScriptLocationArray(int r4, XmlNonNegativeInteger r5) {
        XmlNonNegativeInteger r6 = (XmlNonNegativeInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlNonNegativeInteger r3 = (XmlNonNegativeInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[65], r4), XmlNonNegativeInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetScriptLocationArray(XmlNonNegativeInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[65]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetScriptTextArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[62], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetScriptTextArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[62]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetSecretEditArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[15], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetSecretEditArray(STTrueFalseBlank[] r4) {
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

    public void xsetSelArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[33], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetSelArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[33]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetSelTypeArray(int r4, XmlString r5) {
        XmlString r6 = (XmlString) ZeusTransformUtils.wrapperContextForParams(r5, XmlString.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlString r3 = (XmlString) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[35], r4), XmlString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetSelTypeArray(XmlString[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[35]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetSizeWithCellsArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[1], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetSizeWithCellsArray(STTrueFalseBlank[] r4) {
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

    public void xsetTextHAlignArray(int r4, XmlString r5) {
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

    public void xsetTextHAlignArray(XmlString[] r4) {
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

    public void xsetTextVAlignArray(int r4, XmlString r5) {
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

    public void xsetTextVAlignArray(XmlString[] r4) {
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

    public void xsetUIObjArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[61], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetUIObjArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[61]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetVScrollArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[29], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetVScrollArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[29]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetVTEditArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[27], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetVTEditArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[27]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetValArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[48], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetValArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[48]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetValidIdsArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[30], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetValidIdsArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[30]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetVisibleArray(int r4, STTrueFalseBlank r5) {
        STTrueFalseBlank r6 = (STTrueFalseBlank) ZeusTransformUtils.wrapperContextForParams(r5, STTrueFalseBlank.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        STTrueFalseBlank r3 = (STTrueFalseBlank) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[24], r4), STTrueFalseBlank.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetVisibleArray(STTrueFalseBlank[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[24]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void xsetWidthMinArray(int r4, XmlInteger r5) {
        XmlInteger r6 = (XmlInteger) ZeusTransformUtils.wrapperContextForParams(r5, XmlInteger.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlInteger r3 = (XmlInteger) ZeusTransformUtils.preCheckCast(get_store().find_element_user(PROPERTY_QNAME[32], r4), XmlInteger.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
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

    public void xsetWidthMinArray(XmlInteger[] r4) {
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        arraySetterHelper(r4, PROPERTY_QNAME[32]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
