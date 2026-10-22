package org.apache.poi.hssf.record;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class UnknownRecord extends StandardRecord {
    private byte[] _rawData;
    private int _sid;

    public UnknownRecord(RecordInputStream r2) {
        this._sid = r2.getSid();
        this._rawData = r2.readRemainder();
    }

    public static String getBiffName(int r2) {
        switch(r2) {
            case 51: goto L136;
            case 77: goto L134;
            case 80: goto L132;
            case 127: goto L130;
            case 129: goto L128;
            case 144: goto L126;
            case 148: goto L124;
            case 153: goto L122;
            case 160: goto L120;
            case 174: goto L118;
            case 178: goto L116;
            case 180: goto L114;
            case 181: goto L112;
            case 211: goto L110;
            case 220: goto L108;
            case 222: goto L106;
            case 233: goto L104;
            case 239: goto L102;
            case 241: goto L100;
            case 351: goto L98;
            case 425: goto L96;
            case 429: goto L94;
            case 442: goto L92;
            case 448: goto L90;
            case 2048: goto L88;
            case 2050: goto L86;
            case 2051: goto L84;
            case 2053: goto L82;
            case 2064: goto L80;
            case 2066: goto L78;
            case 2146: goto L76;
            case 2147: goto L74;
            case 2148: goto L72;
            case 2151: goto L70;
            case 2155: goto L68;
            case 2156: goto L66;
            case 2162: goto L64;
            case 2164: goto L62;
            case 2166: goto L60;
            case 2168: goto L58;
            case 2171: goto L56;
            case 2172: goto L54;
            case 2173: goto L52;
            case 2175: goto L50;
            case 2187: goto L48;
            case 2188: goto L46;
            case 2189: goto L44;
            case 2194: goto L42;
            case 2198: goto L40;
            case 2199: goto L38;
            case 2202: goto L36;
            case 2203: goto L34;
            case 2204: goto L32;
            case 2205: goto L30;
            case 2206: goto L28;
            case 2207: goto L26;
            case 2209: goto L25;
            case 2211: goto L23;
            case 2212: goto L22;
            case 2213: goto L20;
            case 2214: goto L18;
            case 2215: goto L16;
            case 2248: goto L14;
            case 4097: goto L12;
            case 4102: goto L10;
            case 4103: goto L8;
            default: goto L5;
        };
    L8:
        return "CHARTLINEFORMAT";
    L10:
        return "CHARTDATAFORMAT";
    L12:
        return "UNITS";
    L14:
        return "PLV{Mac Excel}";
    L16:
        return "CRTLAYOUT12A";
    L18:
        return "RICHTEXTSTREAM";
    L20:
        return "TEXTPROPSSTREAM";
    L22:
        return "SHAPEPROPSSTREAM";
    L23:
        return "FORCEFULLCALCULATION";
    L25:
        return "SHAPEPROPSSTREAM";
    L26:
        return "CRTMLFRTCONTINUE";
    L28:
        return "CRTMLFRT";
    L30:
        return "CRTLAYOUT12";
    L32:
        return "HEADERFOOTER";
    L34:
        return "COMPRESSPICTURES";
    L36:
        return "MTRSETTINGS";
    L38:
        return "GUIDTYPELIB";
    L40:
        return "THEME";
    L42:
        return "STYLEEXT";
    L44:
        return "DXF";
    L46:
        return "COMPAT12";
    L48:
        return "PLV";
    L50:
        return "CONTINUEFRT12";
    L52:
        return "XFEXT";
    L54:
        return "XFCRC";
    L56:
        return "CFEX";
    L58:
        return "SHARED FEATURE v12";
    L60:
        return "DCONN";
    L62:
        return "DROPDOWNOBJIDS";
    L64:
        return "SHARED FEATURE v11";
    L66:
        return "CELLWATCH";
    L68:
        return "DATALABEXTCONTENTS";
    L70:
        return "SHEETPROTECTION";
    L72:
        return "SXADDL";
    L74:
        return "BOOKEXT";
    L76:
        return "SHEETEXT";
    L78:
        return "CONTINUEFRT";
    L80:
        return "SXVIEWEX9";
    L82:
        return "TXTQUERY";
    L84:
        return "DBQUERYEXT";
    L86:
        return "QSISXTAG";
    L88:
        return "QUICKTIP";
    L90:
        return "EXCEL9FILE";
    L92:
        return "CODENAME";
    L94:
        return "QSI";
    L96:
        return "USERBVIEW";
    L98:
        return "LABELRANGES";
    L100:
        return "SXEX";
    L102:
        return "PHONETICPR";
    L104:
        return "BITMAP";
    L106:
        return "OLESIZE";
    L108:
        return "PARAMQRY";
    L110:
        return "OBPROJ";
    L112:
        return "SXLI";
    L114:
        return "SXIVD";
    L116:
        return "SXVI";
    L118:
        return "SCENMAN";
    L120:
        return "SCL";
    L122:
        return "STANDARDWIDTH";
    L124:
        return "LHRECORD";
    L126:
        return "SORT";
    L128:
        return "SHEETPR";
    L130:
        return "IMDATA";
    L132:
        return "DCON";
    L134:
        return "PLS";
    L136:
        return "PRINTSIZE";
    L5:
        if (isObservedButUnknown(r2) == true) goto L7;
        return null;
    L7:
        return "UNKNOWN-" + Integer.toHexString(r2).toUpperCase(Locale.ROOT);
    }

    private static boolean isObservedButUnknown(int r1) {
        if (r1 != 51) goto L5;
        return true;
    L5:
        if (r1 != 52) goto L7;
        return true;
    L7:
        if (r1 != 4170) goto L9;
        return true;
    L9:
        if (r1 != 4171) goto L11;
        return true;
    L11:
        if (r1 != 4174) goto L13;
        return true;
    L13:
        if (r1 != 4175) goto L15;
        return true;
    L15:
        if (r1 != 4188) goto L17;
        return true;
    L17:
        if (r1 == 4189) goto L34;
        switch(r1) {
            case 445: goto L35;
            case 450: goto L35;
            case 4116: goto L35;
            case 4125: goto L35;
            case 4126: goto L35;
            case 4127: goto L35;
            case 4128: goto L35;
            case 4129: goto L35;
            case 4130: goto L35;
            case 4154: goto L35;
            case 4161: goto L35;
            case 4177: goto L35;
            case 4191: goto L35;
            case 4192: goto L35;
            case 4194: goto L35;
            case 4195: goto L35;
            case 4196: goto L35;
            case 4197: goto L35;
            case 4198: goto L35;
            default: goto L19;
        };
    L19:
        switch(r1) {
            case 4105: goto L36;
            case 4106: goto L36;
            case 4107: goto L36;
            case 4108: goto L36;
            default: goto L20;
        };
    L20:
        switch(r1) {
            case 4119: goto L37;
            case 4120: goto L37;
            case 4121: goto L37;
            case 4122: goto L37;
            case 4123: goto L37;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 4132: goto L38;
            case 4133: goto L38;
            case 4134: goto L38;
            case 4135: goto L38;
            default: goto L22;
        };
    L22:
        switch(r1) {
            case 4146: goto L39;
            case 4147: goto L39;
            case 4148: goto L39;
            case 4149: goto L39;
            default: goto L23;
        };
    L23:
        switch(r1) {
            case 4163: goto L40;
            case 4164: goto L40;
            case 4165: goto L40;
            case 4166: goto L40;
            default: goto L24;
        };
    L24:
        return false;
    L40:
        return true;
    L39:
        return true;
    L38:
        return true;
    L37:
        return true;
    L36:
        return true;
    L35:
        return true;
    L34:
        return true;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._rawData.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        Supplier r3 = new $$Lambda$UnknownRecord$Io94f78GG7haQIXcqJ6C9quytPs(this);
        return GenericRecordUtil.getGenericProperties("sid", new $$Lambda$DSEjei4YonRllABo1KGvH9BNIbs(this), "biffName", r3, "rawData", new $$Lambda$UnknownRecord$GFhrT_KwlP2YzpgNkP9FaGW8N2c(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.UNKNOWN;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) this._sid;
    }

    public /* synthetic */ String lambda$getGenericProperties$0$UnknownRecord() {
        String r0 = getBiffName(this._sid);
        if (r0 != null) goto L6;
        return "UNKNOWNRECORD";
    L6:
        return r0;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$UnknownRecord() {
        return this._rawData;
    }
}
