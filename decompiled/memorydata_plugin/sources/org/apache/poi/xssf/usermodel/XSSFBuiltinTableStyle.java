package org.apache.poi.xssf.usermodel;

import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.ss.usermodel.DifferentialStyleProvider;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.ss.usermodel.TableStyleType;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.model.StylesTable;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes7.dex */
public final enum XSSFBuiltinTableStyle extends Enum<XSSFBuiltinTableStyle> {
    private static final /* synthetic */ XSSFBuiltinTableStyle[] $VALUES = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark1 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark10 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark11 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark12 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark13 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark14 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark15 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark16 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark17 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark18 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark19 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark2 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark20 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark21 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark22 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark23 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark24 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark25 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark26 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark27 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark28 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark3 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark4 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark5 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark6 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark7 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark8 = null;
    public static final XSSFBuiltinTableStyle PivotStyleDark9 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight1 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight10 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight11 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight12 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight13 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight14 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight15 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight16 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight17 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight18 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight19 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight2 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight20 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight21 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight22 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight23 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight24 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight25 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight26 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight27 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight28 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight3 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight4 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight5 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight6 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight7 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight8 = null;
    public static final XSSFBuiltinTableStyle PivotStyleLight9 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium1 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium10 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium11 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium12 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium13 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium14 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium15 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium16 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium17 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium18 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium19 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium2 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium20 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium21 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium22 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium23 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium24 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium25 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium26 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium27 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium28 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium3 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium4 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium5 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium6 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium7 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium8 = null;
    public static final XSSFBuiltinTableStyle PivotStyleMedium9 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark1 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark10 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark11 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark2 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark3 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark4 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark5 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark6 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark7 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark8 = null;
    public static final XSSFBuiltinTableStyle TableStyleDark9 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight1 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight10 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight11 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight12 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight13 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight14 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight15 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight16 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight17 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight18 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight19 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight2 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight20 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight21 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight3 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight4 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight5 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight6 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight7 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight8 = null;
    public static final XSSFBuiltinTableStyle TableStyleLight9 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium1 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium10 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium11 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium12 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium13 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium14 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium15 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium16 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium17 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium18 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium19 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium2 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium20 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium21 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium22 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium23 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium24 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium25 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium26 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium27 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium28 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium3 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium4 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium5 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium6 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium7 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium8 = null;
    public static final XSSFBuiltinTableStyle TableStyleMedium9 = null;
    private static final Map<XSSFBuiltinTableStyle, TableStyle> styleMap = null;

    protected static class XSSFBuiltinTypeStyleStyle implements TableStyle {
        private final XSSFBuiltinTableStyle builtIn;
        private final TableStyle style;

        public XSSFBuiltinTypeStyleStyle(XSSFBuiltinTableStyle r3, TableStyle r4) {
            TableStyle r5 = (TableStyle) ZeusTransformUtils.wrapperContextForParams(r4, TableStyle.class, "com.obric.memorydata.plugin");
            this.builtIn = r3;
            this.style = r5;
        }

        @Override // org.apache.poi.ss.usermodel.TableStyle
        public String getName() {
            return this.style.getName();
        }

        @Override // org.apache.poi.ss.usermodel.TableStyle
        public DifferentialStyleProvider getStyle(TableStyleType r1) {
            return this.style.getStyle(r1);
        }
    }

    static {
        TableStyleDark1 = new XSSFBuiltinTableStyle("TableStyleDark1", 0);
        TableStyleDark2 = new XSSFBuiltinTableStyle("TableStyleDark2", 1);
        TableStyleDark3 = new XSSFBuiltinTableStyle("TableStyleDark3", 2);
        TableStyleDark4 = new XSSFBuiltinTableStyle("TableStyleDark4", 3);
        TableStyleDark5 = new XSSFBuiltinTableStyle("TableStyleDark5", 4);
        TableStyleDark6 = new XSSFBuiltinTableStyle("TableStyleDark6", 5);
        TableStyleDark7 = new XSSFBuiltinTableStyle("TableStyleDark7", 6);
        TableStyleDark8 = new XSSFBuiltinTableStyle("TableStyleDark8", 7);
        TableStyleDark9 = new XSSFBuiltinTableStyle("TableStyleDark9", 8);
        TableStyleDark10 = new XSSFBuiltinTableStyle("TableStyleDark10", 9);
        TableStyleDark11 = new XSSFBuiltinTableStyle("TableStyleDark11", 10);
        TableStyleLight1 = new XSSFBuiltinTableStyle("TableStyleLight1", 11);
        TableStyleLight2 = new XSSFBuiltinTableStyle("TableStyleLight2", 12);
        TableStyleLight3 = new XSSFBuiltinTableStyle("TableStyleLight3", 13);
        TableStyleLight4 = new XSSFBuiltinTableStyle("TableStyleLight4", 14);
        TableStyleLight5 = new XSSFBuiltinTableStyle("TableStyleLight5", 15);
        TableStyleLight6 = new XSSFBuiltinTableStyle("TableStyleLight6", 16);
        TableStyleLight7 = new XSSFBuiltinTableStyle("TableStyleLight7", 17);
        TableStyleLight8 = new XSSFBuiltinTableStyle("TableStyleLight8", 18);
        TableStyleLight9 = new XSSFBuiltinTableStyle("TableStyleLight9", 19);
        TableStyleLight10 = new XSSFBuiltinTableStyle("TableStyleLight10", 20);
        TableStyleLight11 = new XSSFBuiltinTableStyle("TableStyleLight11", 21);
        TableStyleLight12 = new XSSFBuiltinTableStyle("TableStyleLight12", 22);
        TableStyleLight13 = new XSSFBuiltinTableStyle("TableStyleLight13", 23);
        TableStyleLight14 = new XSSFBuiltinTableStyle("TableStyleLight14", 24);
        TableStyleLight15 = new XSSFBuiltinTableStyle("TableStyleLight15", 25);
        TableStyleLight16 = new XSSFBuiltinTableStyle("TableStyleLight16", 26);
        TableStyleLight17 = new XSSFBuiltinTableStyle("TableStyleLight17", 27);
        TableStyleLight18 = new XSSFBuiltinTableStyle("TableStyleLight18", 28);
        TableStyleLight19 = new XSSFBuiltinTableStyle("TableStyleLight19", 29);
        TableStyleLight20 = new XSSFBuiltinTableStyle("TableStyleLight20", 30);
        TableStyleLight21 = new XSSFBuiltinTableStyle("TableStyleLight21", 31);
        TableStyleMedium1 = new XSSFBuiltinTableStyle("TableStyleMedium1", 32);
        TableStyleMedium2 = new XSSFBuiltinTableStyle("TableStyleMedium2", 33);
        TableStyleMedium3 = new XSSFBuiltinTableStyle("TableStyleMedium3", 34);
        TableStyleMedium4 = new XSSFBuiltinTableStyle("TableStyleMedium4", 35);
        TableStyleMedium5 = new XSSFBuiltinTableStyle("TableStyleMedium5", 36);
        TableStyleMedium6 = new XSSFBuiltinTableStyle("TableStyleMedium6", 37);
        TableStyleMedium7 = new XSSFBuiltinTableStyle("TableStyleMedium7", 38);
        TableStyleMedium8 = new XSSFBuiltinTableStyle("TableStyleMedium8", 39);
        TableStyleMedium9 = new XSSFBuiltinTableStyle("TableStyleMedium9", 40);
        TableStyleMedium10 = new XSSFBuiltinTableStyle("TableStyleMedium10", 41);
        TableStyleMedium11 = new XSSFBuiltinTableStyle("TableStyleMedium11", 42);
        TableStyleMedium12 = new XSSFBuiltinTableStyle("TableStyleMedium12", 43);
        TableStyleMedium13 = new XSSFBuiltinTableStyle("TableStyleMedium13", 44);
        TableStyleMedium14 = new XSSFBuiltinTableStyle("TableStyleMedium14", 45);
        TableStyleMedium15 = new XSSFBuiltinTableStyle("TableStyleMedium15", 46);
        TableStyleMedium16 = new XSSFBuiltinTableStyle("TableStyleMedium16", 47);
        TableStyleMedium17 = new XSSFBuiltinTableStyle("TableStyleMedium17", 48);
        TableStyleMedium18 = new XSSFBuiltinTableStyle("TableStyleMedium18", 49);
        TableStyleMedium19 = new XSSFBuiltinTableStyle("TableStyleMedium19", 50);
        TableStyleMedium20 = new XSSFBuiltinTableStyle("TableStyleMedium20", 51);
        TableStyleMedium21 = new XSSFBuiltinTableStyle("TableStyleMedium21", 52);
        TableStyleMedium22 = new XSSFBuiltinTableStyle("TableStyleMedium22", 53);
        TableStyleMedium23 = new XSSFBuiltinTableStyle("TableStyleMedium23", 54);
        TableStyleMedium24 = new XSSFBuiltinTableStyle("TableStyleMedium24", 55);
        TableStyleMedium25 = new XSSFBuiltinTableStyle("TableStyleMedium25", 56);
        TableStyleMedium26 = new XSSFBuiltinTableStyle("TableStyleMedium26", 57);
        TableStyleMedium27 = new XSSFBuiltinTableStyle("TableStyleMedium27", 58);
        TableStyleMedium28 = new XSSFBuiltinTableStyle("TableStyleMedium28", 59);
        PivotStyleMedium1 = new XSSFBuiltinTableStyle("PivotStyleMedium1", 60);
        PivotStyleMedium2 = new XSSFBuiltinTableStyle("PivotStyleMedium2", 61);
        PivotStyleMedium3 = new XSSFBuiltinTableStyle("PivotStyleMedium3", 62);
        PivotStyleMedium4 = new XSSFBuiltinTableStyle("PivotStyleMedium4", 63);
        PivotStyleMedium5 = new XSSFBuiltinTableStyle("PivotStyleMedium5", 64);
        PivotStyleMedium6 = new XSSFBuiltinTableStyle("PivotStyleMedium6", 65);
        PivotStyleMedium7 = new XSSFBuiltinTableStyle("PivotStyleMedium7", 66);
        PivotStyleMedium8 = new XSSFBuiltinTableStyle("PivotStyleMedium8", 67);
        PivotStyleMedium9 = new XSSFBuiltinTableStyle("PivotStyleMedium9", 68);
        PivotStyleMedium10 = new XSSFBuiltinTableStyle("PivotStyleMedium10", 69);
        PivotStyleMedium11 = new XSSFBuiltinTableStyle("PivotStyleMedium11", 70);
        PivotStyleMedium12 = new XSSFBuiltinTableStyle("PivotStyleMedium12", 71);
        PivotStyleMedium13 = new XSSFBuiltinTableStyle("PivotStyleMedium13", 72);
        PivotStyleMedium14 = new XSSFBuiltinTableStyle("PivotStyleMedium14", 73);
        PivotStyleMedium15 = new XSSFBuiltinTableStyle("PivotStyleMedium15", 74);
        PivotStyleMedium16 = new XSSFBuiltinTableStyle("PivotStyleMedium16", 75);
        PivotStyleMedium17 = new XSSFBuiltinTableStyle("PivotStyleMedium17", 76);
        PivotStyleMedium18 = new XSSFBuiltinTableStyle("PivotStyleMedium18", 77);
        PivotStyleMedium19 = new XSSFBuiltinTableStyle("PivotStyleMedium19", 78);
        PivotStyleMedium20 = new XSSFBuiltinTableStyle("PivotStyleMedium20", 79);
        PivotStyleMedium21 = new XSSFBuiltinTableStyle("PivotStyleMedium21", 80);
        PivotStyleMedium22 = new XSSFBuiltinTableStyle("PivotStyleMedium22", 81);
        PivotStyleMedium23 = new XSSFBuiltinTableStyle("PivotStyleMedium23", 82);
        PivotStyleMedium24 = new XSSFBuiltinTableStyle("PivotStyleMedium24", 83);
        PivotStyleMedium25 = new XSSFBuiltinTableStyle("PivotStyleMedium25", 84);
        PivotStyleMedium26 = new XSSFBuiltinTableStyle("PivotStyleMedium26", 85);
        PivotStyleMedium27 = new XSSFBuiltinTableStyle("PivotStyleMedium27", 86);
        PivotStyleMedium28 = new XSSFBuiltinTableStyle("PivotStyleMedium28", 87);
        PivotStyleLight1 = new XSSFBuiltinTableStyle("PivotStyleLight1", 88);
        PivotStyleLight2 = new XSSFBuiltinTableStyle("PivotStyleLight2", 89);
        PivotStyleLight3 = new XSSFBuiltinTableStyle("PivotStyleLight3", 90);
        PivotStyleLight4 = new XSSFBuiltinTableStyle("PivotStyleLight4", 91);
        PivotStyleLight5 = new XSSFBuiltinTableStyle("PivotStyleLight5", 92);
        PivotStyleLight6 = new XSSFBuiltinTableStyle("PivotStyleLight6", 93);
        PivotStyleLight7 = new XSSFBuiltinTableStyle("PivotStyleLight7", 94);
        PivotStyleLight8 = new XSSFBuiltinTableStyle("PivotStyleLight8", 95);
        PivotStyleLight9 = new XSSFBuiltinTableStyle("PivotStyleLight9", 96);
        PivotStyleLight10 = new XSSFBuiltinTableStyle("PivotStyleLight10", 97);
        PivotStyleLight11 = new XSSFBuiltinTableStyle("PivotStyleLight11", 98);
        PivotStyleLight12 = new XSSFBuiltinTableStyle("PivotStyleLight12", 99);
        PivotStyleLight13 = new XSSFBuiltinTableStyle("PivotStyleLight13", 100);
        PivotStyleLight14 = new XSSFBuiltinTableStyle("PivotStyleLight14", 101);
        PivotStyleLight15 = new XSSFBuiltinTableStyle("PivotStyleLight15", 102);
        PivotStyleLight16 = new XSSFBuiltinTableStyle("PivotStyleLight16", 103);
        PivotStyleLight17 = new XSSFBuiltinTableStyle("PivotStyleLight17", 104);
        PivotStyleLight18 = new XSSFBuiltinTableStyle("PivotStyleLight18", 105);
        PivotStyleLight19 = new XSSFBuiltinTableStyle("PivotStyleLight19", 106);
        PivotStyleLight20 = new XSSFBuiltinTableStyle("PivotStyleLight20", 107);
        PivotStyleLight21 = new XSSFBuiltinTableStyle("PivotStyleLight21", 108);
        PivotStyleLight22 = new XSSFBuiltinTableStyle("PivotStyleLight22", 109);
        PivotStyleLight23 = new XSSFBuiltinTableStyle("PivotStyleLight23", 110);
        PivotStyleLight24 = new XSSFBuiltinTableStyle("PivotStyleLight24", 111);
        PivotStyleLight25 = new XSSFBuiltinTableStyle("PivotStyleLight25", 112);
        PivotStyleLight26 = new XSSFBuiltinTableStyle("PivotStyleLight26", 113);
        PivotStyleLight27 = new XSSFBuiltinTableStyle("PivotStyleLight27", 114);
        PivotStyleLight28 = new XSSFBuiltinTableStyle("PivotStyleLight28", 115);
        PivotStyleDark1 = new XSSFBuiltinTableStyle("PivotStyleDark1", 116);
        PivotStyleDark2 = new XSSFBuiltinTableStyle("PivotStyleDark2", 117);
        PivotStyleDark3 = new XSSFBuiltinTableStyle("PivotStyleDark3", 118);
        PivotStyleDark4 = new XSSFBuiltinTableStyle("PivotStyleDark4", IdlErrors.E_RejectInferDeviceOverheat);
        PivotStyleDark5 = new XSSFBuiltinTableStyle("PivotStyleDark5", 120);
        PivotStyleDark6 = new XSSFBuiltinTableStyle("PivotStyleDark6", 121);
        PivotStyleDark7 = new XSSFBuiltinTableStyle("PivotStyleDark7", 122);
        PivotStyleDark8 = new XSSFBuiltinTableStyle("PivotStyleDark8", 123);
        PivotStyleDark9 = new XSSFBuiltinTableStyle("PivotStyleDark9", 124);
        PivotStyleDark10 = new XSSFBuiltinTableStyle("PivotStyleDark10", 125);
        PivotStyleDark11 = new XSSFBuiltinTableStyle("PivotStyleDark11", WebSocketProtocol.PAYLOAD_SHORT);
        PivotStyleDark12 = new XSSFBuiltinTableStyle("PivotStyleDark12", 127);
        PivotStyleDark13 = new XSSFBuiltinTableStyle("PivotStyleDark13", 128);
        PivotStyleDark14 = new XSSFBuiltinTableStyle("PivotStyleDark14", 129);
        PivotStyleDark15 = new XSSFBuiltinTableStyle("PivotStyleDark15", 130);
        PivotStyleDark16 = new XSSFBuiltinTableStyle("PivotStyleDark16", 131);
        PivotStyleDark17 = new XSSFBuiltinTableStyle("PivotStyleDark17", 132);
        PivotStyleDark18 = new XSSFBuiltinTableStyle("PivotStyleDark18", 133);
        PivotStyleDark19 = new XSSFBuiltinTableStyle("PivotStyleDark19", 134);
        PivotStyleDark20 = new XSSFBuiltinTableStyle("PivotStyleDark20", 135);
        PivotStyleDark21 = new XSSFBuiltinTableStyle("PivotStyleDark21", 136);
        PivotStyleDark22 = new XSSFBuiltinTableStyle("PivotStyleDark22", 137);
        PivotStyleDark23 = new XSSFBuiltinTableStyle("PivotStyleDark23", 138);
        PivotStyleDark24 = new XSSFBuiltinTableStyle("PivotStyleDark24", 139);
        PivotStyleDark25 = new XSSFBuiltinTableStyle("PivotStyleDark25", 140);
        PivotStyleDark26 = new XSSFBuiltinTableStyle("PivotStyleDark26", 141);
        PivotStyleDark27 = new XSSFBuiltinTableStyle("PivotStyleDark27", 142);
        PivotStyleDark28 = new XSSFBuiltinTableStyle("PivotStyleDark28", 143);
        $VALUES = new XSSFBuiltinTableStyle[]{TableStyleDark1, TableStyleDark2, TableStyleDark3, TableStyleDark4, TableStyleDark5, TableStyleDark6, TableStyleDark7, TableStyleDark8, TableStyleDark9, TableStyleDark10, TableStyleDark11, TableStyleLight1, TableStyleLight2, TableStyleLight3, TableStyleLight4, TableStyleLight5, TableStyleLight6, TableStyleLight7, TableStyleLight8, TableStyleLight9, TableStyleLight10, TableStyleLight11, TableStyleLight12, TableStyleLight13, TableStyleLight14, TableStyleLight15, TableStyleLight16, TableStyleLight17, TableStyleLight18, TableStyleLight19, TableStyleLight20, TableStyleLight21, TableStyleMedium1, TableStyleMedium2, TableStyleMedium3, TableStyleMedium4, TableStyleMedium5, TableStyleMedium6, TableStyleMedium7, TableStyleMedium8, TableStyleMedium9, TableStyleMedium10, TableStyleMedium11, TableStyleMedium12, TableStyleMedium13, TableStyleMedium14, TableStyleMedium15, TableStyleMedium16, TableStyleMedium17, TableStyleMedium18, TableStyleMedium19, TableStyleMedium20, TableStyleMedium21, TableStyleMedium22, TableStyleMedium23, TableStyleMedium24, TableStyleMedium25, TableStyleMedium26, TableStyleMedium27, TableStyleMedium28, PivotStyleMedium1, PivotStyleMedium2, PivotStyleMedium3, PivotStyleMedium4, PivotStyleMedium5, PivotStyleMedium6, PivotStyleMedium7, PivotStyleMedium8, PivotStyleMedium9, PivotStyleMedium10, PivotStyleMedium11, PivotStyleMedium12, PivotStyleMedium13, PivotStyleMedium14, PivotStyleMedium15, PivotStyleMedium16, PivotStyleMedium17, PivotStyleMedium18, PivotStyleMedium19, PivotStyleMedium20, PivotStyleMedium21, PivotStyleMedium22, PivotStyleMedium23, PivotStyleMedium24, PivotStyleMedium25, PivotStyleMedium26, PivotStyleMedium27, PivotStyleMedium28, PivotStyleLight1, PivotStyleLight2, PivotStyleLight3, PivotStyleLight4, PivotStyleLight5, PivotStyleLight6, PivotStyleLight7, PivotStyleLight8, PivotStyleLight9, PivotStyleLight10, PivotStyleLight11, PivotStyleLight12, PivotStyleLight13, PivotStyleLight14, PivotStyleLight15, PivotStyleLight16, PivotStyleLight17, PivotStyleLight18, PivotStyleLight19, PivotStyleLight20, PivotStyleLight21, PivotStyleLight22, PivotStyleLight23, PivotStyleLight24, PivotStyleLight25, PivotStyleLight26, PivotStyleLight27, PivotStyleLight28, PivotStyleDark1, PivotStyleDark2, PivotStyleDark3, PivotStyleDark4, PivotStyleDark5, PivotStyleDark6, PivotStyleDark7, PivotStyleDark8, PivotStyleDark9, PivotStyleDark10, PivotStyleDark11, PivotStyleDark12, PivotStyleDark13, PivotStyleDark14, PivotStyleDark15, PivotStyleDark16, PivotStyleDark17, PivotStyleDark18, PivotStyleDark19, PivotStyleDark20, PivotStyleDark21, PivotStyleDark22, PivotStyleDark23, PivotStyleDark24, PivotStyleDark25, PivotStyleDark26, PivotStyleDark27, PivotStyleDark28};
        styleMap = new EnumMap(XSSFBuiltinTableStyle.class);
    }

    private XSSFBuiltinTableStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static synchronized void init() {
        monitor-enter(XSSFBuiltinTableStyle.class);
    L43:
        th = move-exception;
        throw th;
    L5:
        if (styleMap.isEmpty() == true) goto L56;
        monitor-exit(XSSFBuiltinTableStyle.class);
        return;
    L56:
        InputStream r1 = XSSFBuiltinTableStyle.class.getResourceAsStream("presetTableStyles.xml");     // Catch: Exception -> L40 Throwable -> L43
        NodeList r2 = DocumentHelper.readDocument(r1).getDocumentElement().getChildNodes();     // Catch: Throwable -> L31
        int r4 = 0;
    L11:
        if (r4 >= r2.getLength()) goto L27;
        Node r5 = r2.item(r4);     // Catch: Throwable -> L31
        if (r5.getNodeType() != 1) goto L18;
        Element r6 = (Element) ZeusTransformUtils.preCheckCast(r5, Element.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        String r7 = r6.getTagName();     // Catch: Throwable -> L31
        XSSFBuiltinTableStyle r8 = valueOf(r7);     // Catch: Throwable -> L31
        Node r9 = r6.getElementsByTagName("dxfs").item(0);     // Catch: Throwable -> L31
        Node r10 = r6.getElementsByTagName("tableStyles").item(0);     // Catch: Throwable -> L31
        StylesTable r11 = new StylesTable();     // Catch: Throwable -> L31
        UnsynchronizedByteArrayInputStream r12 = new UnsynchronizedByteArrayInputStream(styleXML(r9, r10).getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L31
        r11.readFrom(r12);     // Catch: Throwable -> L19
        r12.close();     // Catch: Throwable -> L31
        styleMap.put(r8, new XSSFBuiltinTypeStyleStyle(r8, r11.getExplicitTableStyle(r7)));     // Catch: Throwable -> L31
        goto L18
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L31
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31
    L18:
        r4 = r4 + 1;
        goto L11
    L27:
        if (r1 == null) goto L29;
        r1.close();     // Catch: Exception -> L40 Throwable -> L43
    L29:
        monitor-exit(XSSFBuiltinTableStyle.class);
        return;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        if (r1 != null) goto L46;
    L39:
        throw th;     // Catch: Exception -> L40 Throwable -> L43
    L46:
        r1.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L40 Throwable -> L43
    L40:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L43
    }

    public static boolean isBuiltinStyle(TableStyle r2) {
        TableStyle r3 = (TableStyle) ZeusTransformUtils.wrapperContextForParams(r2, TableStyle.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        return false;
    L9:
        valueOf(r3.getName());     // Catch: IllegalArgumentException -> L8
        return true;
    L8:
        return false;
    }

    private static String styleXML(Node r2, Node r3) {
        Node r4 = (Node) ZeusTransformUtils.wrapperContextForParams(r2, Node.class, "com.obric.memorydata.plugin");
        Node r5 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        r4.insertBefore(r4.getOwnerDocument().createElement("dxf"), r4.getFirstChild());
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<styleSheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:x14ac=\"http://schemas.microsoft.com/office/spreadsheetml/2009/9/ac\" xmlns:x16r2=\"http://schemas.microsoft.com/office/spreadsheetml/2015/02/main\" mc:Ignorable=\"x14ac x16r2\">\n" + writeToString(r4) + writeToString(r5) + "</styleSheet>";
    }

    public static XSSFBuiltinTableStyle valueOf(String r2) {
        return (XSSFBuiltinTableStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(XSSFBuiltinTableStyle.class, r2), XSSFBuiltinTableStyle.class, "com.obric.memorydata.plugin");
    }

    public static XSSFBuiltinTableStyle[] values() {
        return (XSSFBuiltinTableStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XSSFBuiltinTableStyle[].class, "com.obric.memorydata.plugin");
    }

    private static String writeToString(Node r4) {
        Node r5 = (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin");
        StringBuilderWriter r0 = new StringBuilderWriter(1024);
        Transformer r1 = XMLHelper.newTransformer();     // Catch: Throwable -> L6
        r1.setOutputProperty("omit-xml-declaration", "yes");     // Catch: Throwable -> L6
        r1.transform(new DOMSource(r5), new StreamResult(r0));     // Catch: Throwable -> L6
        String r6 = r0.toString();     // Catch: Throwable -> L6
        r0.close();
        return r6;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public TableStyle getStyle() {
        init();
        return (TableStyle) ZeusTransformUtils.preCheckCast(styleMap.get(this), TableStyle.class, "com.obric.memorydata.plugin");
    }
}
