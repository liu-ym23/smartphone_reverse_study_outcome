package com.obric.cae.smartNfc.event;

/* JADX INFO: loaded from: classes2.dex */
final class TransitAidConstants {
    static final AidRule[] AID_RULES = null;
    static final int AID_TYPE_ACCESS_CONTROL = 8;
    static final int AID_TYPE_ALL = 0;
    static final int AID_TYPE_BANK_CARD = 4;
    static final int AID_TYPE_CAR_KEY = 1;
    static final int AID_TYPE_NDEF_TAG = 16;
    static final int AID_TYPE_PRIVATE_MANAGEMENT = 32;
    static final int AID_TYPE_TRANSIT_CARD = 2;
    static final int AID_TYPE_UNKNOWN = 0;
    static final AidPrefixRule[] BANK_AID_PREFIX_RULES = null;
    static final int MATCH_TYPE_EXACT = 1;
    static final String TRANSIT_AID_COMMON_PREFIX = "A000000632010105";

    public static final class AidPrefixRule {
        final String aidPrefix;
        final int aidType;
        final String label;

        public AidPrefixRule(int r8, String r10, String r11) {
            this.aidType = r8;
            this.aidPrefix = r10;
            this.label = r11;
        }
    }

    public static final class AidRule {
        final String aid;
        final int aidType;
        final String label;
        final int matchType;

        public AidRule(int r8, int r10, String r11, String r12) {
            this.aidType = r8;
            this.matchType = r10;
            this.aid = r11;
            this.label = r12;
        }
    }

    static {
        BANK_AID_PREFIX_RULES = new AidPrefixRule[]{bankPrefix("A000000003", "Visa"), bankPrefix("A000000004", "Mastercard"), bankPrefix("A000000025", "American Express"), bankPrefix("A000000042", "Cartes Bancaires"), bankPrefix("A000000065", "JCB"), bankPrefix("A000000152", "Discover/Diners Club"), bankPrefix("A000000277", "Interac"), bankPrefix("A000000333", "China UnionPay/PBOC"), bankPrefix("A000000524", "RuPay"), bankPrefix("A000000658", "Mir")};
        AID_RULES = new AidRule[]{transit("A0000053425748544B", "湖北省武汉市"), transit("A0000006320101055800022058100101", "unknown"), transit("A00000063201010512105348494A4941", "河北省石家庄市"), transit("A000000632010105116044414C49414E", "辽宁省大连市"), transit("A0000000031500869807010000000000", "黑龙江省哈尔滨市"), transit("A0000006320101052140000057555849", "江苏省无锡市"), transit("A0000000032660869807010000000000", "山东省青岛市"), transit("A00000063201010541004348414E4753", "湖南省长沙市"), transit("A00000063201010511215449414E4A49", "天津市"), transit("A000000632010105710000005849414E", "陕西省西安市"), transit("A0000006320101055800027758800101", "unknown"), transit("A00000063201010545005A48454E475A", "河南省郑州市"), transit("A000000632010105215053555A484F55", "江苏省苏州市"), transit("A00000063201010531200053584D4F54", "unknown"), transit("A00000063201010539305849414D454E", "福建省厦门市"), transit("A0000006320101052100000000004E4A", "江苏省南京市"), transit("A0000006320101053610004846464549", "安徽省合肥市"), transit("A00000063201010553004755414E4758", "广西壮族自治区南宁市"), transit("A00000063201010510009156000014A1", "北京市"), transit("A0000006320101050113581058000000", "unknown"), transit("A0000006320101055800028559700101", "unknown"), transit("A0000006320101055800028058900101", "unknown"), transit("A0000006320101055800028259300101", "unknown"), transit("A0000006320101055800028858200101", "unknown"), transit("A0000006320101055800028659800101", "unknown"), transit("A0000006320101055800029059900101", "unknown"), transit("A0000006320101055800028159200101", "unknown"), transit("A0000006320101055800028960500101", "unknown"), transit("A0000006320101055800029260600101", "unknown"), transit("A0000006320101055800029160400101", "unknown"), transit("A00000063201010557004841494E414E", "海南省"), transit("A0000000033180869807010000000000", "浙江省台州市"), transit("A0000000033150869807010000000000", "浙江省宁波市"), transit("A00000063201010522604E414E544F4E", "江苏省南通市"), transit("A0000006320101053000004845424549", "河北省"), transit("A0000006320101051320004A494C494E", "吉林省吉林市"), transit("A00000063201010511005348454E474A", "辽宁省沈阳市"), transit("A000000632010105442053484959414E", "湖北省十堰市"), transit("A000000632010105850000004C415341", "西藏自治区拉萨市"), transit("A00000063201010571900059554C494E", "陕西省榆林市"), transit("A00000063201010521304348414E475A", "江苏省常州市"), transit("A00000063201010502002900FFFFFFFF", "unknown"), transit("A0000006320101051500484145524249", "黑龙江省哈尔滨市"), transit("A00000063201010526600051494E4744", "山东省青岛市"), transit("A000000003200386980701", "unknown"), transit("A0000000037100869807010000000000", "unknown"), transit("A00000000386980701", "unknown"), carKey("425944494B425944494B010101020001", "比亚迪王朝/比亚迪海洋"), carKey("A000000836444E5A444B010101020001", "腾势"), carKey("A0000008364D2D52444B010101020001", "仰望"), carKey("A000000836432D50444B010101020001", "方程豹"), bank("A0000003330101060003080000030801", "银联/PBOC 银行支付应用"), bank("A00000033301010600030800005A5954", "银联/PBOC 银行支付应用 ZYT"), bank("325041592E5359532E4444463031", "PPSE 支付目录"), bank("315041592E5359532E4444463031", "PSE 支付目录"), ndefTag("D2760000850100", "NFC Forum NDEF Type 4 Tag V1.0"), ndefTag("D2760000850101", "NFC Forum NDEF Type 4 Tag V2.0/V3.0"), privateManagement("A000000151000000", "GlobalPlatform ISD/管理域"), privateManagement("A00000015143525300", "GlobalPlatform CRS/Contactless Registry Service"), privateManagement("A000000300000000", "CardManager/卡管理路由"), accessControl("A0000053424D344D5F434F4D4D00000", "门禁 SNOW_DOOR_AID_HEADER"), privateManagement("A00000001800000047544F5749504500", "私有/系统管理类 unknown"), privateManagement("A00000337264414D534441494400", "私有/系统管理类 unknown")};
    }

    private TransitAidConstants() {
    }

    private static AidRule accessControl(String r8, String r10) {
        return new AidRule(8, 1, r8, r10);
    }

    private static AidRule bank(String r8, String r10) {
        return new AidRule(4, 1, r8, r10);
    }

    private static AidPrefixRule bankPrefix(String r8, String r10) {
        return new AidPrefixRule(4, r8, r10);
    }

    private static AidRule carKey(String r8, String r10) {
        return new AidRule(1, 1, r8, r10);
    }

    public static int getSupportedExternalAidTypeMask() {
        return 7;
    }

    public static boolean isValidAidTypeMask(int r8) {
        if (r8 >= 0) goto L4;
    L6:
        return false;
    L4:
        if ((r8 & (-8)) != 0) goto L6;
        return true;
    }

    private static AidRule ndefTag(String r8, String r10) {
        return new AidRule(16, 1, r8, r10);
    }

    private static AidRule privateManagement(String r8, String r10) {
        return new AidRule(32, 1, r8, r10);
    }

    private static AidRule transit(String r8, String r10) {
        return new AidRule(2, 1, r8, r10);
    }
}
