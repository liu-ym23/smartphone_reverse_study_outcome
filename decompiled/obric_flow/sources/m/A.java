package m;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final enum A extends Enum<A> {
    public static final A A = null;
    public static final A A0 = null;
    public static final A B = null;
    public static final A B0 = null;
    public static final A C = null;
    public static final A C0 = null;
    public static final A D = null;
    public static final /* synthetic */ A[] D0 = null;
    public static final A E = null;
    public static final A F = null;
    public static final A G = null;
    public static final A H = null;
    public static final A I = null;
    public static final A J = null;
    public static final A K = null;
    public static final A L = null;
    public static final A M = null;
    public static final A N = null;
    public static final A O = null;
    public static final A P = null;
    public static final A Q = null;
    public static final A R = null;
    public static final A S = null;
    public static final A T = null;
    public static final A U = null;
    public static final A V = null;
    public static final A W = null;
    public static final A X = null;
    public static final A Y = null;
    public static final A Z = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final A f19792a0 = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final A f19793b0 = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final A f19794c0 = null;
    public static final A d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final A f19795d0 = null;
    public static final A e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final A f19796e0 = null;
    public static final A f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final A f19797f0 = null;
    public static final A g = null;
    public static final A g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final A f19798h = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final A f19799h0 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final A f19800i = null;
    public static final A i0 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final A f19801j = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final A f19802j0 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final A f19803k = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final A f19804k0 = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final A f19805l = null;
    public static final A l0 = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final A f19806m = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final A f19807m0 = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final A f19808n = null;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final A f19809n0 = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final A f19810o = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final A f19811o0 = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final A f19812p = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final A f19813p0 = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final A f19814q = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final A f19815q0 = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final A f19816r = null;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final A f19817r0 = null;
    public static final A s = null;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final A f19818s0 = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final A f19819t = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final A f19820t0 = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final A f19821u = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final A f19822u0 = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final A f19823v = null;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final A f19824v0 = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final A f19825w = null;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final A f19826w0 = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final A f19827x = null;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final A f19828x0 = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final A f19829y = null;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final A f19830y0 = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final A f19831z = null;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final A f19832z0 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19835c;

    static {
        A r5 = new A("NormStandard", 0, "\\d{4}-\\d{1,2}-\\d{1,2}( \\d{1,2}:\\d{1,2}(:\\d{1,2})?)?", "标准时间");
        d = r5;
        A r10 = new A("NormStandardCn", 1, "\\d{4}(年)\\d{1,2}(月)\\d{1,2}(日)( \\d{1,2}:\\d{1,2}(:\\d{1,2})?)?", "标准时间中文");
        e = r10;
        A r11 = new A("NormYearTwo", 2, "[0-9]{2}(?=年)", "两位数来表示年份");
        f = r11;
        A r12 = new A("NormYearFour", 3, "[0-9]?[0-9]{3}(?=年)", "三位数和四位数表示的年份");
        g = r12;
        A r13 = new A("NormMonth", 4, "((10)|(11)|(12)|([1-9]))(?=月)", "月字段");
        f19798h = r13;
        A r14 = new A("NormDay", 5, "((?<!\\d))([0-3][0-9]|[1-9])(?=(日|号))", "日字段");
        f19800i = r14;
        A r15 = new A("NormMonthFuzzyDay", 6, "((10)|(11)|(12)|([1-9]))(月|\\.|\\-)([0-3][0-9]|[1-9])", "月-日 兼容模糊写法");
        f19801j = r15;
        A r16 = new A("NormMonthFuzzyDaySeparator", 7, "(月|\\.|\\-)", "月-日 兼容模糊写法分隔符");
        f19803k = r16;
        A r17 = new A("NormBaseRelatedDayBefore", 8, "\\d+(?=天[以之]?前)", "几天前");
        f19805l = r17;
        A r18 = new A("NormBaseRelatedDayAfter", 9, "\\d+(?=天[以之]?后)", "几天后");
        f19806m = r18;
        A r19 = new A("NormBaseRelatedMonthBefore", 10, "\\d+(?=(个)?月[以之]?前)", "几月前");
        f19808n = r19;
        A r110 = new A("NormBaseRelatedMonthAfter", 11, "\\d+(?=(个)?月[以之]?后)", "几月后");
        f19810o = r110;
        A r111 = new A("NormBaseRelatedYearBefore", 12, "\\d+(?=年[以之]?前)", "几年前");
        f19812p = r111;
        A r112 = new A("NormBaseRelatedYearAfter", 13, "\\d+(?=年[以之]?后)", "几年后");
        f19814q = r112;
        A r113 = new A("NormBaseTimeRelatedHourBefore", 14, "\\d+(?=个?半?(小时|钟头|h|H)[以之]?前)", "3小时前");
        f19816r = r113;
        A r114 = new A("NormBaseTimeRelatedHourAfter", 15, "\\d+(?=个?半?(小时|钟头|h|H)[以之]?后)", "3小时后");
        s = r114;
        A r115 = new A("NormBaseTimeRelatedHalfHourBefore", 16, "半个?(小时|钟头)[以之]?前", "半个小时前");
        f19819t = r115;
        A r116 = new A("NormBaseTimeRelatedHalfHourAfter", 17, "半个?(小时|钟头)[以之]?后", "半个小时后");
        f19821u = r116;
        A r117 = new A("NormBaseTimeRelatedHour", 18, "\\d+(?=个?半?(小时|钟头|h|H))", "1个小时");
        f19823v = r117;
        A r118 = new A("NormBaseTimeRelatedMinuteBefore", 19, "\\d+(?=(分钟|分|min)[以之]?前)", "3分钟前");
        f19825w = r118;
        A r119 = new A("NormBaseTimeRelatedMinuteAfter", 20, "\\d+(?=(分钟|分|min)[以之]?后)", "3分钟后");
        f19827x = r119;
        A r120 = new A("NormBaseTimeRelatedMinute", 21, "\\d+(?=(分钟|min))", "1分钟");
        f19829y = r120;
        A r121 = new A("NormBaseTimeRelatedSecondBefore", 22, "\\d+(?=(秒钟|秒|sec)[以之]?前)", "3秒钟前");
        f19831z = r121;
        A r122 = new A("NormBaseTimeRelatedSecondAfter", 23, "\\d+(?=(秒钟|秒|sec)[以之]?后)", "3秒钟后");
        A = r122;
        A r123 = new A("NormCurRelatedYearBeforeLast", 24, "前年", "前年");
        B = r123;
        A r124 = new A("NormCurRelatedYearBefore", 25, "去年", "去年");
        C = r124;
        A r125 = new A("NormCurRelatedYear", 26, "今年", "今年");
        D = r125;
        A r126 = new A("NormCurRelatedYearAfter", 27, "明年", "明年");
        E = r126;
        A r127 = new A("NormCurRelatedYearAfterNext", 28, "后年", "后年");
        F = r127;
        A r128 = new A("NormCurRelatedMonthBefore", 29, "上(个)?月", "上个月");
        G = r128;
        A r129 = new A("NormCurRelatedMonth", 30, "(本|这个)月", "这个月");
        H = r129;
        A r130 = new A("NormCurRelatedMonthAfter", 31, "下(个)?月", "下个月");
        I = r130;
        A r131 = new A("NormCurRelatedDayBeforeThree", 32, "大前天", "大前天");
        J = r131;
        A r132 = new A("NormCurRelatedDayBeforeLast", 33, "(?<!大)前天", "前天");
        K = r132;
        A r133 = new A("NormCurRelatedDayYesterday", 34, "昨", "昨天");
        L = r133;
        A r134 = new A("NormCurRelatedDayToday", 35, "今(?!年)", "今天");
        M = r134;
        A r135 = new A("NormCurRelatedDayTomorrow", 36, "明(?!年)", "明天");
        N = r135;
        A r136 = new A("NormCurRelatedDayAfterNext", 37, "(?<!大)后天", "后天");
        O = r136;
        A r137 = new A("NormCurRelatedDayAfterThree", 38, "大后天", "大后天");
        P = r137;
        A r138 = new A("NormCurRelatedWeekBeforeLast", 39, "(?<=(上上(周|星期)))[1-7]?", "上上周");
        Q = r138;
        A r139 = new A("NormCurRelatedWeekBefore", 40, "(?<=((?<!上)上(周|星期)))[1-7]?", "上周");
        R = r139;
        A r140 = new A("NormCurRelatedWeek", 41, "(?<=((?<!(上|下))(周|星期)))[1-7]?", "周一 二等");
        S = r140;
        A r141 = new A("NormCurRelatedWeekAfter", 42, "(?<=((?<!下)下(周|星期)))[1-7]?", "下周");
        T = r141;
        A r142 = new A("NormCurRelatedWeekAfterNext", 43, "(?<=(下下(周|星期)))[1-7]?", "下下周");
        U = r142;
        A r143 = new A("NormHour", 44, "(?<!(周|星期))([0-2]?[0-9])(?=(点|时))", "时字段");
        V = r143;
        A r144 = new A("NormHourDayBreak", 45, "凌晨", "凌晨");
        W = r144;
        A r145 = new A("NormHourEarlyMorning", 46, "早上|早晨|早间|晨间|今早|明早", "早上");
        X = r145;
        A r146 = new A("NormHourMorning", 47, "上午", "上午");
        Y = r146;
        A r147 = new A("NormHourNoon", 48, "(中午)|(午间)", "中午");
        Z = r147;
        A r148 = new A("NormHourAfternoon", 49, "(下午)|(午后)|(pm)|(PM)", "下午");
        f19792a0 = r148;
        A r149 = new A("NormHourNight", 50, "晚上|夜间|夜里|今晚|明晚", "晚上");
        f19793b0 = r149;
        A r150 = new A("NormMinute", 51, "([0-5]?[0-9](?=分(?!钟)))|((?<=((?<!小)[点时]))[0-5]?[0-9](?!刻))", "分字段");
        f19794c0 = r150;
        A r151 = new A("NormMinuteSpec", 52, "(\\d+(分钟|分|min)[以之]?[前后])", "排除30分后");
        f19795d0 = r151;
        A r152 = new A("NormMinuteOneQuarter", 53, "(?<=[点时])[1一]刻(?!钟)", "一刻");
        f19796e0 = r152;
        A r153 = new A("NormMinuteHalf", 54, "(?<=[点时])半", "点半");
        f19797f0 = r153;
        A r154 = new A("NormMinuteThreeQuarter", 55, "(?<=[点时])[3三]刻(?!钟)", "3刻");
        g0 = r154;
        A r155 = new A("NormSecondSpec", 56, "(\\d+(秒钟|秒|sec)[以之]?[前后])", "排除30秒后");
        f19799h0 = r155;
        A r156 = new A("NormSecond", 57, "([0-5]?[0-9](?=秒))|((?<=分)[0-5]?[0-9])", "秒字段");
        i0 = r156;
        A r157 = new A("NormTotalTime", 58, "(?<!(周|星期))([0-2]?[0-9]):[0-5]?[0-9]:[0-5]?[0-9]", "时分秒");
        f19802j0 = r157;
        A r158 = new A("NormTotalTimeShort", 59, "(?<!(周|星期))([0-2]?[0-9]):[0-5]?[0-9]", "时分");
        f19804k0 = r158;
        A r159 = new A("NormTotalNight", 60, "晚", "晚上");
        l0 = r159;
        A r160 = new A("NormTotalDateOne", 61, "[0-9]?[0-9]?[0-9]{2}-((10)|(11)|(12)|([1-9]))-((?<!\\d))([0-3][0-9]|[1-9])", "年月日 -");
        f19807m0 = r160;
        A r161 = new A("NormTotalDateTwo", 62, "((10)|(11)|(12)|([1-9]))/((?<!\\d))([0-3][0-9]|[1-9])/[0-9]?[0-9]?[0-9]{2}", "年月日 /");
        f19809n0 = r161;
        A r162 = new A("NormTotalDateThree", 63, "[0-9]?[0-9]?[0-9]{2}\\.((10)|(11)|(12)|([1-9]))\\.((?<!\\d))([0-3][0-9]|[1-9])", "年月日 .");
        f19811o0 = r162;
        A r163 = new A("NormLocalHoliday", 64, "(元旦|情人节|妇女节|植树节|消费者权益日|愚人节|清明节|五一节|劳动节|青年节|护士节|母亲节|儿童节|父亲节|建党节|建军节|教师节|国庆节|万圣节|圣诞节)", "新历节日");
        f19813p0 = r163;
        A r164 = new A("NormChineseHoliday", 65, "春节|元宵节|龙抬头|端午节|七夕节|中秋节|重阳节|腊八节|北方小年|南方小年|除夕", "农历节日");
        f19815q0 = r164;
        A r165 = new A("TextPreprocessSeparator", 66, "[的]+", "凌晨");
        f19817r0 = r165;
        A r166 = new A("TextPreprocessNumberTranslatorOne", 67, "[一二两三四五六七八九123456789]万[一二两三四五六七八九123456789](?!(千|百|十))", "数字正则1");
        f19818s0 = r166;
        A r167 = new A("TextPreprocessNumberTranslatorTwo", 68, "[一二两三四五六七八九123456789]千[一二两三四五六七八九123456789](?!(百|十))", "数字正则2");
        f19820t0 = r167;
        A r168 = new A("TextPreprocessNumberTranslatorThree", 69, "[一二两三四五六七八九123456789]百[一二两三四五六七八九123456789](?!十)", "数字正则3");
        f19822u0 = r168;
        A r169 = new A("TextPreprocessNumberTranslatorFour", 70, "[零一二两三四五六七八九]", "数字正则4");
        f19824v0 = r169;
        A r170 = new A("TextPreprocessNumberTranslatorFive", 71, "(?<=(周|星期))[末天日]", "数字正则5");
        f19826w0 = r170;
        A r171 = new A("TextPreprocessNumberTranslatorSix", 72, "(?<!(周|星期))0?[0-9]?十[0-9]?", "数字正则6");
        f19828x0 = r171;
        A r172 = new A("TextPreprocessNumberTranslatorSeven", 73, "0?[1-9]百[0-9]?[0-9]?", "数字正则7");
        f19830y0 = r172;
        A r173 = new A("TextPreprocessNumberTranslatorEight", 74, "0?[1-9]千[0-9]?[0-9]?[0-9]?", "数字正则8");
        f19832z0 = r173;
        A r174 = new A("TextPreprocessNumberTranslatorNine", 75, "[0-9]+万[0-9]?[0-9]?[0-9]?[0-9]?", "数字正则9");
        A0 = r174;
        A r175 = new A("TextPreprocessDelDecimalStrSeparator", 76, "[日号]", "日号");
        B0 = r175;
        A r176 = new A("TextPreprocessDelDecimalStr", 77, "\\{0,1\\}\\d+\\.\\d*|\\{0,1\\}\\d*\\.\\d+", "小数");
        C0 = r176;
        D0 = new A[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176};
    }

    public A(String r5, int r10, String r11, String r12) {
        super(r5, r10);
        this.f19833a = r11;
        this.f19834b = 0;
        this.f19835c = r12;
    }

    public static A valueOf(String r5) {
        return (A) Enum.valueOf(A.class, r5);
    }

    public static A[] values() {
        return (A[]) D0.clone();
    }

    public Pattern b() {
        String r5 = this.f19833a;
        return f0.f(this.f19834b, r5);
    }

    public String c() {
        return this.f19833a;
    }
}
