package org.apache.poi.hslf.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.AbstractMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.util.LocaleID;

/* JADX INFO: loaded from: classes7.dex */
public final class LocaleDateFormat {

    private static final enum MapFormatBase extends Enum<MapFormatBase> {
        private static final /* synthetic */ MapFormatBase[] $VALUES = null;
        public static final MapFormatBase ABBREVIATED_MONTH_AND_YEAR = null;
        public static final MapFormatBase ALTERNATE_SHORT_DATE = null;
        public static final MapFormatBase ALTERNATE_SHORT_DATE_WITH_ABBREVIATED_MONTH = null;
        public static final MapFormatBase DATE_AND_HOUR12_TIME = null;
        public static final MapFormatBase DATE_AND_HOUR12_TIME_WITH_SECONDS = null;
        public static final MapFormatBase ENGLISH_DATE = null;
        public static final MapFormatBase HOUR12_TIME = null;
        public static final MapFormatBase HOUR12_TIME_WITH_SECONDS = null;
        public static final MapFormatBase HOUR24_TIME = null;
        public static final MapFormatBase HOUR24_TIME_WITH_SECONDS = null;
        public static final MapFormatBase ISO_STANDARD_DATE = null;
        public static final MapFormatBase LONG_DATE = null;
        public static final MapFormatBase LONG_DATE_WITHOUT_WEEKDAY = null;
        public static final MapFormatBase MONTH_AND_YEAR = null;
        public static final MapFormatBase SHORT_DATE = null;
        public static final MapFormatBase SHORT_DATE_WITH_ABBREVIATED_MONTH = null;
        public static final MapFormatBase SHORT_DATE_WITH_SLASHES = null;
        private final String datefmt;
        private final Function<FormatStyle, DateTimeFormatter> formatFct;
        private final FormatStyle formatStyle;

        static {
            MapFormatBase r6 = new MapFormatBase("SHORT_DATE", 0, null, FormatStyle.MEDIUM, $$Lambda$LocaleDateFormat$MapFormatBase$ok_SQpScH9p6YUztxTAfG1nM.INSTANCE);
            SHORT_DATE = r6;
            MapFormatBase r0 = new MapFormatBase("LONG_DATE", 1, null, FormatStyle.FULL, $$Lambda$LocaleDateFormat$MapFormatBase$ok_SQpScH9p6YUztxTAfG1nM.INSTANCE);
            LONG_DATE = r0;
            MapFormatBase r1 = new MapFormatBase("LONG_DATE_WITHOUT_WEEKDAY", 2, "d. MMMM yyyy", null, null);
            LONG_DATE_WITHOUT_WEEKDAY = r1;
            MapFormatBase r2 = new MapFormatBase("ALTERNATE_SHORT_DATE", 3, "dd/MM/yy", null, null);
            ALTERNATE_SHORT_DATE = r2;
            MapFormatBase r3 = new MapFormatBase("ISO_STANDARD_DATE", 4, "yyyy-MM-dd", null, null);
            ISO_STANDARD_DATE = r3;
            MapFormatBase r4 = new MapFormatBase("SHORT_DATE_WITH_ABBREVIATED_MONTH", 5, "d-MMM-yy", null, null);
            SHORT_DATE_WITH_ABBREVIATED_MONTH = r4;
            MapFormatBase r5 = new MapFormatBase("SHORT_DATE_WITH_SLASHES", 6, "d/M/y", null, null);
            SHORT_DATE_WITH_SLASHES = r5;
            MapFormatBase r13 = new MapFormatBase("ALTERNATE_SHORT_DATE_WITH_ABBREVIATED_MONTH", 7, "d. MMM yy", null, null);
            ALTERNATE_SHORT_DATE_WITH_ABBREVIATED_MONTH = r13;
            MapFormatBase r7 = new MapFormatBase("ENGLISH_DATE", 8, "d MMMM yyyy", null, null);
            ENGLISH_DATE = r7;
            MapFormatBase r8 = new MapFormatBase("MONTH_AND_YEAR", 9, "MMMM yy", null, null);
            MONTH_AND_YEAR = r8;
            if (LocaleDateFormat.access$000() == false) goto L5;
            String r10 = "MMM-yy";
        L6:
            MapFormatBase r9 = new MapFormatBase("ABBREVIATED_MONTH_AND_YEAR", 10, r10, null, null);
            ABBREVIATED_MONTH_AND_YEAR = r9;
            MapFormatBase r11 = new MapFormatBase("DATE_AND_HOUR12_TIME", 11, null, FormatStyle.MEDIUM, $$Lambda$LocaleDateFormat$MapFormatBase$aYWFTjcP5B5i68tIrtUuheq3ww.INSTANCE);
            DATE_AND_HOUR12_TIME = r11;
            MapFormatBase r12 = new MapFormatBase("DATE_AND_HOUR12_TIME_WITH_SECONDS", 12, null, FormatStyle.MEDIUM, $$Lambda$LocaleDateFormat$MapFormatBase$eoG1Y8WR9AJuYTIPWq1hy9D1APA.INSTANCE);
            DATE_AND_HOUR12_TIME_WITH_SECONDS = r12;
            MapFormatBase r14 = new MapFormatBase("HOUR12_TIME", 13, "K:mm", null, null);
            HOUR12_TIME = r14;
            MapFormatBase r20 = new MapFormatBase("HOUR12_TIME_WITH_SECONDS", 14, "K:mm:ss", null, null);
            HOUR12_TIME_WITH_SECONDS = r20;
            MapFormatBase r15 = new MapFormatBase("HOUR24_TIME", 15, "HH:mm", null, null);
            HOUR24_TIME = r15;
            MapFormatBase r16 = new MapFormatBase("HOUR24_TIME_WITH_SECONDS", 16, "HH:mm:ss", null, null);
            HOUR24_TIME_WITH_SECONDS = r16;
            $VALUES = new MapFormatBase[]{r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r11, r12, r14, r20, r15, r16};
            return;
        L5:
            r10 = "LLL-yy";
            goto L6
        }

        private MapFormatBase(String r3, int r4, String r5, FormatStyle r6, Function r7) {
            Function<FormatStyle, DateTimeFormatter> r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r7, Function.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.formatStyle = r6;
            this.datefmt = r5;
            this.formatFct = r8;
        }

        /* JADX INFO: renamed from: lambda$ok_SQpS-cH9p6YUzt-xTA-fG1nM, reason: not valid java name */
        public static /* synthetic */ DateTimeFormatter m3158lambda$ok_SQpScH9p6YUztxTAfG1nM(FormatStyle r0) {
            return DateTimeFormatter.ofLocalizedDate(r0);
        }

        static /* synthetic */ DateTimeFormatter lambda$static$0(FormatStyle r2) {
            return new DateTimeFormatterBuilder().appendLocalized(FormatStyle.SHORT, null).appendLiteral("  ").appendLocalized(null, FormatStyle.SHORT).toFormatter();
        }

        static /* synthetic */ DateTimeFormatter lambda$static$1(FormatStyle r3) {
            return new DateTimeFormatterBuilder().appendLocalized(FormatStyle.SHORT, null).appendLiteral("  ").appendLocalized(null, r3).toFormatter();
        }

        public static DateTimeFormatter mapFormatId(Locale r2, int r3) {
            MapFormatBase[] r0 = values();
            if (r3 < 0) goto L13;
            if (r3 >= r0.length) goto L13;
            MapFormatBase r4 = r0[r3];
            String r1 = r4.datefmt;
            if (r1 != null) goto L11;
            return ((DateTimeFormatter) ZeusTransformUtils.preCheckCast(r4.formatFct.apply(r4.formatStyle), DateTimeFormatter.class, "com.obric.memorydata.plugin")).withLocale(r2);
        L11:
            return DateTimeFormatter.ofPattern(r1, r2);
        L13:
            return DateTimeFormatter.BASIC_ISO_DATE;
        }

        public static MapFormatBase valueOf(String r2) {
            return (MapFormatBase) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapFormatBase.class, r2), MapFormatBase.class, "com.obric.memorydata.plugin");
        }

        public static MapFormatBase[] values() {
            return (MapFormatBase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapFormatBase[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final enum MapFormatException extends Enum<MapFormatException> {
        private static final /* synthetic */ MapFormatException[] $VALUES = null;
        public static final MapFormatException BOKMAL = null;
        public static final MapFormatException CHINESE = null;
        public static final MapFormatException CZECH = null;
        public static final MapFormatException DANISH = null;
        public static final MapFormatException DUTCH = null;
        public static final MapFormatException FINISH = null;
        public static final MapFormatException FRENCH_CANADIAN = null;
        public static final MapFormatException GERMAN = null;
        public static final MapFormatException HINDI = null;
        public static final MapFormatException HUNGARIAN = null;
        public static final MapFormatException ITALIAN = null;
        public static final MapFormatException JAPANESE = null;
        public static final MapFormatException KOREAN = null;
        private static final Map<LocaleID, MapFormatException> LCID_LOOKUP = null;
        public static final MapFormatException NO_MAP = null;
        private final LocaleID[] lcid;
        private final Object[] mapping;

        static {
            MapFormatException r0 = new MapFormatException("CHINESE", 0, new LocaleID[]{LocaleID.ZH, LocaleID.ZH_HANS, LocaleID.ZH_HANT, LocaleID.ZH_CN, LocaleID.ZH_SG, LocaleID.ZH_MO, LocaleID.ZH_HK, LocaleID.ZH_YUE_HK}, new Object[]{0, 1, "yyyy年M月d日星期W", "yyyy年M月d日", "yyyy/M/d", "yy.M.d", "yyyy年M月d日星期W", "yyyy年M月d日", "yyyy年M月d日星期W", "yyyy年M月", "yyyy年M月", "h时m分s秒", "h时m分", "h时m分", "h时m分", "ah时m分", "ah时m分", "EEEE年O月A日", "EEEE年O月A日星期W", "EEEE年O月"});
            CHINESE = r0;
            MapFormatException r3 = new MapFormatException("HINDI", 1, new LocaleID[]{LocaleID.HI, LocaleID.HI_IN}, new Object[]{"dd/M/g", "dddd, d MMMM yyyy", "dd MMMM yyyy", "dd/M/yy", "yy-M-dd", "d-MMMM-yyyy", "dd.M.g", "dd MMMM. yy", "dd MMMM yy", "MMMM YY", "MMMM-g", "dd/M/g HH:mm", "dd/M/g HH:mm:ss", "HH:mm a", "HH:mm:ss a", "HH:mm", "HH:mm:ss"});
            HINDI = r3;
            MapFormatException r1 = new MapFormatException("JAPANESE", 2, new LocaleID[]{LocaleID.JA, LocaleID.JA_JP, LocaleID.JA_PLOC_JP}, new Object[]{0, 1, "EEEy年M月d日", "yyyy年M月d日", "yyyy/M/d", "yyyy年M月d日", "yy年M月d日", "yyyy年M月d日", "yyyy年M月d日(EEE)", "yyyy年M月", "yyyy年M月", "yy/M/d H時m分", "yy/M/d H時m分s秒", "a h時m分", "a h時m分s秒", "H時m分", "H時m分s秒", "yyyy年M月d日 EEE曜日"});
            JAPANESE = r1;
            MapFormatException r4 = new MapFormatException("KOREAN", 3, new LocaleID[]{LocaleID.KO, LocaleID.KO_KR}, new Object[]{0, 1, "yyyy년 M월 d일 EEE요일", "yyyy년 M월 d일", "yyyy/M/d", "yyMMdd", "yyyy년 M월 d일", "yyyy년 M월", "yyyy년 M월 d일", "yyyy", "yyyy년 M월", "yyyy년 M월 d일 a h시 m분", "yy년 M월 d일 H시 m분 s초", "a h시 m분", "a h시 m분 s초", "H시 m분", "H시 m분 S초"});
            KOREAN = r4;
            MapFormatException r7 = new MapFormatException("HUNGARIAN", 4, new LocaleID[]{LocaleID.HU, LocaleID.HU_HU}, new Object[]{0, 1, 2, 3, 4, 5, 6, "yy. MMM. dd.", "’yy MMM.", "MMMM ’yy", 10, 11, 12, "a h:mm", "a h:mm:ss", 15, 16});
            HUNGARIAN = r7;
            MapFormatException r9 = new MapFormatException("BOKMAL", 5, new LocaleID[]{LocaleID.NB_NO}, new Object[]{0, 1, 2, 3, 4, "d. MMM. yyyy", "d/m yyyy", "MMM. yy", "yyyy.mm.dd", 9, "d. MMM.", 11, 12, 13, 14, 15, 16});
            BOKMAL = r9;
            MapFormatException r5 = new MapFormatException("CZECH", 6, new LocaleID[]{LocaleID.CS, LocaleID.CS_CZ}, new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, "MMMM ’yy", 10, 11, 12, 13, 14, 15, 16});
            CZECH = r5;
            MapFormatException r8 = new MapFormatException("DANISH", 7, new LocaleID[]{LocaleID.DA, LocaleID.DA_DK}, new Object[]{0, "d. MMMM yyyy", "yy-MM-dd", "yyyy.MM.dd", 4, "MMMM yyyy", "d.M.yy", "d/M yyyy", "dd.MM.yyyy", "d.M.yyyy", "dd/MM yyyy", 11, 12, 13, 14, 15, 16});
            DANISH = r8;
            MapFormatException r6 = new MapFormatException("DUTCH", 8, new LocaleID[]{LocaleID.NL, LocaleID.NL_BE, LocaleID.NL_NL}, new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, "MMMM ’yy", 10, 11, 12, 13, 14, 15, 16});
            DUTCH = r6;
            MapFormatException r10 = new MapFormatException("FINISH", 9, new LocaleID[]{LocaleID.FI, LocaleID.FI_FI}, new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, "MMMM ’yy", 10, 11, 12, 13, 14, 15, 16});
            FINISH = r10;
            MapFormatException r11 = new MapFormatException("FRENCH_CANADIAN", 10, new LocaleID[]{LocaleID.FR_CA}, new Object[]{0, 1, 2, "yy MM dd", 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            FRENCH_CANADIAN = r11;
            MapFormatException r12 = new MapFormatException("GERMAN", 11, new LocaleID[]{LocaleID.DE, LocaleID.DE_AT, LocaleID.DE_CH, LocaleID.DE_DE, LocaleID.DE_LI, LocaleID.DE_LU}, new Object[]{0, 1, 2, 3, 4, "yy-MM-dd", 6, "dd. MMM. yyyy", 8, 9, 10, 11, 12, 13, 14, 15, 16});
            GERMAN = r12;
            MapFormatException r13 = new MapFormatException("ITALIAN", 12, new LocaleID[]{LocaleID.IT, LocaleID.IT_IT, LocaleID.IT_CH}, new Object[]{0, 1, 2, 3, 4, "d-MMM.-yy", 6, "d. MMM. yy", "MMM. ’yy", "MMMM ’yy", 10, 11, 12, 13, 14, 15, 16});
            ITALIAN = r13;
            MapFormatException r14 = new MapFormatException("NO_MAP", 13, new LocaleID[]{LocaleID.INVALID_O}, new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
            NO_MAP = r14;
            $VALUES = new MapFormatException[]{r0, r3, r1, r4, r7, r9, r5, r8, r6, r10, r11, r12, r13, r14};
            LCID_LOOKUP = (Map) ZeusTransformUtils.preCheckCast(Stream.of(values()).flatMap($$Lambda$LocaleDateFormat$MapFormatException$sYHkqdZ2Jf9swde88G1jk9UgBMo.INSTANCE).collect(Collectors.toMap($$Lambda$OHgvjeG4_Jbe6rr89IeuOeOn52o.INSTANCE, $$Lambda$efN72eJvEMwJM7vnXuWb8H3aFr8.INSTANCE)), Map.class, "com.obric.memorydata.plugin");
        }

        private MapFormatException(String r1, int r2, LocaleID[] r3, Object... r4) {
            super(r1, r2);
            this.lcid = r3;
            this.mapping = r4;
        }

        static /* synthetic */ AbstractMap.SimpleEntry lambda$null$0(MapFormatException r1, LocaleID r2) {
            return new AbstractMap.SimpleEntry(r2, r1);
        }

        static /* synthetic */ Stream lambda$static$1(final MapFormatException r2) {
            return Stream.of(r2.lcid).map(new $$Lambda$LocaleDateFormat$MapFormatException$2Ww8VxaJd9ryFcvzWvCTWPkVU4A(r2));
        }

        public static Object mapFormatId(LocaleID r2, int r3) {
            Object[] r4 = ((MapFormatException) ZeusTransformUtils.preCheckCast(LCID_LOOKUP.getOrDefault(r2, NO_MAP), MapFormatException.class, "com.obric.memorydata.plugin")).mapping;
            if (r3 < 0) goto L8;
            if (r3 >= r4.length) goto L8;
            return r4[r3];
        L8:
            return Integer.valueOf(r3);
        }

        public static MapFormatException valueOf(String r2) {
            return (MapFormatException) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapFormatException.class, r2), MapFormatException.class, "com.obric.memorydata.plugin");
        }

        public static MapFormatException[] values() {
            return (MapFormatException[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapFormatException[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum MapFormatId extends Enum<MapFormatId> {
        private static final /* synthetic */ MapFormatId[] $VALUES = null;
        public static final MapFormatId NONE = null;
        public static final MapFormatId PPT = null;

        static {
            MapFormatId r0 = new MapFormatId("NONE", 0);
            NONE = r0;
            MapFormatId r1 = new MapFormatId("PPT", 1);
            PPT = r1;
            $VALUES = new MapFormatId[]{r0, r1};
        }

        private MapFormatId(String r1, int r2) {
            super(r1, r2);
        }

        public static MapFormatId valueOf(String r2) {
            return (MapFormatId) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapFormatId.class, r2), MapFormatId.class, "com.obric.memorydata.plugin");
        }

        public static MapFormatId[] values() {
            return (MapFormatId[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapFormatId[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final enum MapFormatPPT extends Enum<MapFormatPPT> {
        private static final /* synthetic */ MapFormatPPT[] $VALUES = null;
        public static final MapFormatPPT AR_SA = null;
        public static final MapFormatPPT EN_AU = null;
        public static final MapFormatPPT EN_US = null;
        public static final MapFormatPPT HE_IL = null;
        public static final MapFormatPPT HI_IN = null;
        public static final MapFormatPPT JA_JP = null;
        public static final MapFormatPPT KO_KR = null;
        private static final Map<LocaleID, MapFormatPPT> LCID_LOOKUP = null;
        public static final MapFormatPPT NO_MAP = null;
        public static final MapFormatPPT SV_SE = null;
        public static final MapFormatPPT SYR_SY = null;
        public static final MapFormatPPT TH_TH = null;
        public static final MapFormatPPT VI_VN = null;
        public static final MapFormatPPT ZH_CN = null;
        public static final MapFormatPPT ZH_HK = null;
        public static final MapFormatPPT ZH_MO = null;
        public static final MapFormatPPT ZH_SG = null;
        public static final MapFormatPPT ZH_TW = null;
        private final LocaleID lcid;
        private final Object[] mapping;

        static {
            MapFormatPPT r0 = new MapFormatPPT("EN_US", 0, LocaleID.EN_US, new Object[]{"MM/dd/yyyy", 1, 8, "MMMM dd, yyyy", 5, 9, 10, 11, 12, 15, 16, "h:mm a", "h:mm:ss a"});
            EN_US = r0;
            MapFormatPPT r1 = new MapFormatPPT("EN_AU", 1, LocaleID.EN_AU, new Object[]{0, 1, "d MMMM, yyy", 2, 5, 9, 10, 11, 12, 15, 16, 13, 14});
            EN_AU = r1;
            MapFormatPPT r4 = new MapFormatPPT("JA_JP", 2, LocaleID.JA_JP, new Object[]{4, 8, 7, 3, 0, 9, 5, 11, 12, "HH:mm", "HH:mm:ss", 15, 16});
            JA_JP = r4;
            MapFormatPPT r5 = new MapFormatPPT("ZH_TW", 3, LocaleID.ZH_TW, new Object[]{0, 1, 3, 7, 12, 9, 10, 4, 11, "HH:mm", "HH:mm:ss", "H:mm a", "H:mm:ss a"});
            ZH_TW = r5;
            MapFormatPPT r9 = new MapFormatPPT("KO_KR", 4, LocaleID.KO_KR, new Object[]{0, 1, 6, 3, 4, 10, 7, 12, 11, "HH:mm", "HH:mm:ss", 13, 14});
            KO_KR = r9;
            MapFormatPPT r2 = new MapFormatPPT("AR_SA", 5, LocaleID.AR_SA, new Object[]{0, 1, 2, 3, 4, 5, 8, 7, 8, 1, 10, 11, 5});
            AR_SA = r2;
            MapFormatPPT r6 = new MapFormatPPT("HE_IL", 6, LocaleID.HE_IL, new Object[]{0, 1, 2, 6, 11, 5, 12, 7, 8, 9, 1, 11, 6});
            HE_IL = r6;
            MapFormatPPT r3 = new MapFormatPPT("SV_SE", 7, LocaleID.SV_SE, new Object[]{0, 1, 3, 2, 7, 9, 10, 11, 12, 15, 16, 13, 14});
            SV_SE = r3;
            MapFormatPPT r7 = new MapFormatPPT("ZH_CN", 8, LocaleID.ZH_CN, new Object[]{0, 1, 2, 2, 4, 9, 5, "yyyy年M月d日h时m分", "yyyy年M月d日星期Wh时m分s秒", "HH:mm", "HH:mm:ss", "a h时m分", "a h时m分s秒"});
            ZH_CN = r7;
            MapFormatPPT r8 = new MapFormatPPT("ZH_SG", 9, LocaleID.ZH_SG, new Object[]{0, 1, 3, 2, 4, 9, 5, "yyyy年M月d日h时m分", "yyyy年M月d日星期Wh时m分s秒", "HH:mm", "HH:mm:ss", "a h时m分", "a h时m分s秒"});
            ZH_SG = r8;
            MapFormatPPT r10 = new MapFormatPPT("ZH_MO", 10, LocaleID.ZH_MO, new Object[]{0, 1, 3, 2, 4, 9, 5, "yyyy年M月d日h时m分", "yyyy年M月d日星期Wh时m分s秒", "HH:mm", "HH:mm:ss", "a h时m分", "a h时m分s秒"});
            ZH_MO = r10;
            MapFormatPPT r11 = new MapFormatPPT("ZH_HK", 11, LocaleID.ZH_HK, new Object[]{0, 1, 3, 2, 4, 9, 5, "yyyy年M月d日h时m分", "yyyy年M月d日星期Wh时m分s秒", "HH:mm", "HH:mm:ss", "a h时m分", "a h时m分s秒"});
            ZH_HK = r11;
            MapFormatPPT r12 = new MapFormatPPT("TH_TH", 12, LocaleID.TH_TH, new Object[]{0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 13, 14});
            TH_TH = r12;
            MapFormatPPT r13 = new MapFormatPPT("VI_VN", 13, LocaleID.VI_VN, new Object[]{0, 1, 2, 3, 5, 6, 10, 11, 12, 13, 14, 15, 16});
            VI_VN = r13;
            MapFormatPPT r14 = new MapFormatPPT("HI_IN", 14, LocaleID.HI_IN, new Object[]{1, 2, 3, 5, 7, 11, 13, 0, 1, 5, 10, 11, 14});
            HI_IN = r14;
            MapFormatPPT r15 = new MapFormatPPT("SYR_SY", 15, LocaleID.SYR_SY, new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
            SYR_SY = r15;
            MapFormatPPT r16 = new MapFormatPPT("NO_MAP", 16, LocaleID.INVALID_O, new Object[]{0, 1, 3, 2, 5, 9, 10, 11, 12, 15, 16, 13, 14, 4, 6, 7, 8});
            NO_MAP = r16;
            $VALUES = new MapFormatPPT[]{r0, r1, r4, r5, r9, r2, r6, r3, r7, r8, r10, r11, r12, r13, r14, r15, r16};
            LCID_LOOKUP = (Map) ZeusTransformUtils.preCheckCast(Stream.of(values()).collect(Collectors.toMap($$Lambda$l1lF_ygzqDyCYXTWhf83nM9i_Y.INSTANCE, Function.identity())), Map.class, "com.obric.memorydata.plugin");
        }

        private MapFormatPPT(String r1, int r2, LocaleID r3, Object... r4) {
            super(r1, r2);
            this.lcid = r3;
            this.mapping = r4;
        }

        public static Object mapFormatId(LocaleID r2, int r3) {
            Object[] r4 = ((MapFormatPPT) ZeusTransformUtils.preCheckCast(LCID_LOOKUP.getOrDefault(r2, NO_MAP), MapFormatPPT.class, "com.obric.memorydata.plugin")).mapping;
            if (r3 < 0) goto L8;
            if (r3 >= r4.length) goto L8;
            return r4[r3];
        L8:
            return Integer.valueOf(r3);
        }

        public static MapFormatPPT valueOf(String r2) {
            return (MapFormatPPT) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapFormatPPT.class, r2), MapFormatPPT.class, "com.obric.memorydata.plugin");
        }

        public static MapFormatPPT[] values() {
            return (MapFormatPPT[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapFormatPPT[].class, "com.obric.memorydata.plugin");
        }

        public LocaleID getLocaleID() {
            return this.lcid;
        }
    }

    static /* synthetic */ boolean access$000() {
        return isOldFmt();
    }

    private static boolean isOldFmt() {
        return System.getProperty("java.version").startsWith("1.8");
    }
}
