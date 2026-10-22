package org.apache.xmlbeans.impl.regex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
class ParserForXMLSchema extends RegexParser {
    private static Hashtable ranges;
    private static Hashtable ranges2;

    static {
    }

    public ParserForXMLSchema() {
    }

    public ParserForXMLSchema(Locale r1) {
    }

    public static synchronized RangeToken getRange(String r5, boolean r6) {
        monitor-enter(ParserForXMLSchema.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (ranges != null) goto L7;
        ranges = new Hashtable();     // Catch: Throwable -> L14
        ranges2 = new Hashtable();     // Catch: Throwable -> L14
        RangeToken r1 = Token.createRange();     // Catch: Throwable -> L14
        setupRange(r1, "\t\n\r\r  ");     // Catch: Throwable -> L14
        ranges.put("xml:isSpace", r1);     // Catch: Throwable -> L14
        ranges2.put("xml:isSpace", Token.complementRanges(r1));     // Catch: Throwable -> L14
        RangeToken r2 = Token.createRange();     // Catch: Throwable -> L14
        setupRange(r2, "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩");     // Catch: Throwable -> L14
        ranges.put("xml:isDigit", r2);     // Catch: Throwable -> L14
        ranges2.put("xml:isDigit", Token.complementRanges(r2));     // Catch: Throwable -> L14
        RangeToken r3 = Token.createRange();     // Catch: Throwable -> L14
        setupRange(r3, "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩");     // Catch: Throwable -> L14
        ranges.put("xml:isDigit", r3);     // Catch: Throwable -> L14
        ranges2.put("xml:isDigit", Token.complementRanges(r3));     // Catch: Throwable -> L14
        RangeToken r4 = Token.createRange();     // Catch: Throwable -> L14
        setupRange(r4, "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣");     // Catch: Throwable -> L14
        r4.mergeRanges((Token) ZeusTransformUtils.preCheckCast(ranges.get("xml:isDigit"), Token.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        ranges.put("xml:isWord", r4);     // Catch: Throwable -> L14
        ranges2.put("xml:isWord", Token.complementRanges(r4));     // Catch: Throwable -> L14
        RangeToken r7 = Token.createRange();     // Catch: Throwable -> L14
        setupRange(r7, "-.0:AZ__az··ÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁːˑ̀͠͡ͅΆΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁ҃҆ҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆֹֻֽֿֿׁׂ֑֣֡ׄׄאתװײءغـْ٠٩ٰڷںھۀێېۓە۪ۭۨ۰۹ँःअह़्॑॔क़ॣ०९ঁঃঅঌএঐওনপরললশহ়়াৄেৈো্ৗৗড়ঢ়য়ৣ০ৱਂਂਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹ਼਼ਾੂੇੈੋ੍ਖ਼ੜਫ਼ਫ਼੦ੴઁઃઅઋઍઍએઑઓનપરલળવહ઼ૅેૉો્ૠૠ૦૯ଁଃଅଌଏଐଓନପରଲଳଶହ଼ୃେୈୋ୍ୖୗଡ଼ଢ଼ୟୡ୦୯ஂஃஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹாூெைொ்ௗௗ௧௯ఁఃఅఌఎఐఒనపళవహాౄెైొ్ౕౖౠౡ౦౯ಂಃಅಌಎಐಒನಪಳವಹಾೄೆೈೊ್ೕೖೞೞೠೡ೦೯ംഃഅഌഎഐഒനപഹാൃെൈൊ്ൗൗൠൡ൦൯กฮะฺเ๎๐๙ກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະູົຽເໄໆໆ່ໍ໐໙༘༙༠༩༹༹༵༵༷༷༾ཇཉཀྵ྄ཱ྆ྋྐྕྗྗྙྭྱྷྐྵྐྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼ⃐⃜⃡⃡ΩΩKÅ℮℮ↀↂ々々〇〇〡〯〱〵ぁゔ゙゚ゝゞァヺーヾㄅㄬ一龥가힣");     // Catch: Throwable -> L14
        ranges.put("xml:isNameChar", r7);     // Catch: Throwable -> L14
        ranges2.put("xml:isNameChar", Token.complementRanges(r7));     // Catch: Throwable -> L14
        RangeToken r8 = Token.createRange();     // Catch: Throwable -> L14
        setupRange(r8, "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣");     // Catch: Throwable -> L14
        r8.addRange(95, 95);     // Catch: Throwable -> L14
        r8.addRange(58, 58);     // Catch: Throwable -> L14
        ranges.put("xml:isInitialNameChar", r8);     // Catch: Throwable -> L14
        ranges2.put("xml:isInitialNameChar", Token.complementRanges(r8));     // Catch: Throwable -> L14
    L7:
        if (r6 == false) goto L10;
        Object r9 = ZeusTransformUtils.preCheckCast(ranges.get(r5), RangeToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L9:
        RangeToken r10 = (RangeToken) r9;     // Catch: Throwable -> L14
        monitor-exit(ParserForXMLSchema.class);
        return r10;
    L10:
        r9 = ZeusTransformUtils.preCheckCast(ranges2.get(r5), RangeToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        goto L9
    }

    static void setupRange(Token r4, String r5) {
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.addRange(r5.charAt(r1), r5.charAt(r1 + 1));
        r1 = r1 + 2;
        goto L3
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    boolean checkQuestion(int r1) {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    int decodeEscaped() {
        if (read() != 10) goto L26;
        int r0 = this.chardata;
        if (r0 == 45) goto L24;
        if (r0 == 46) goto L35;
        if (r0 == 63) goto L36;
        if (r0 != 110) goto L13;
        return 10;
    L13:
        if (r0 != 114) goto L15;
        return 13;
    L15:
        if (r0 == 116) goto L21;
        switch(r0) {
            case 40: goto L37;
            case 41: goto L37;
            case 42: goto L37;
            case 43: goto L37;
            default: goto L17;
        };
    L17:
        switch(r0) {
            case 91: goto L38;
            case 92: goto L38;
            case 93: goto L38;
            case 94: goto L38;
            default: goto L18;
        };
    L18:
        switch(r0) {
            case 123: goto L39;
            case 124: goto L39;
            case 125: goto L39;
            default: goto L20;
        };
    L20:
        throw ex("parser.process.1", this.offset - 2);
    L39:
        return r0;
    L38:
        return r0;
    L37:
        return r0;
    L21:
        return 9;
    L36:
        return r0;
    L35:
        return r0;
    L24:
        return r0;
    L26:
        throw ex("parser.next.1", this.offset - 1);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token getTokenForShorthand(int r7) {
        if (r7 == 67) goto L43;
        if (r7 == 68) goto L41;
        if (r7 == 73) goto L39;
        if (r7 == 83) goto L37;
        if (r7 == 87) goto L35;
        if (r7 == 105) goto L33;
        if (r7 == 115) goto L31;
        if (r7 == 119) goto L29;
        if (r7 == 99) goto L27;
        if (r7 != 100) goto L25;
        return getRange("xml:isDigit", true);
    L25:
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(r7, 16));
    L27:
        return getRange("xml:isNameChar", true);
    L29:
        return getRange("xml:isWord", true);
    L31:
        return getRange("xml:isSpace", true);
    L33:
        return getRange("xml:isInitialNameChar", true);
    L35:
        return getRange("xml:isWord", false);
    L37:
        return getRange("xml:isSpace", false);
    L39:
        return getRange("xml:isInitialNameChar", false);
    L41:
        return getRange("xml:isDigit", false);
    L43:
        return getRange("xml:isNameChar", false);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public RangeToken parseCharacterClass(boolean r17) {
        setContext(1);
        next();
        boolean r3 = false;
        if (read() == 0) goto L5;
    L7:
        RangeToken r4 = Token.createRange();
        RangeToken r2 = null;
        boolean r5 = false;
    L8:
        boolean r6 = true;
    L9:
        int r7 = read();
        if (r7 == 1) goto L128;
        if (r7 == 0) goto L14;
    L18:
        int r10 = this.chardata;
        if (r7 == 10) goto L21;
        if (r7 != 24) goto L67;
        if (r6 == true) goto L67;
        if (r5 == false) goto L59;
        r2.subtractRanges(r4);
    L60:
        r2.subtractRanges(parseCharacterClass(r3));
        if (read() != 0) goto L66;
        if (this.chardata != 93) goto L66;
    L130:
        if (read() == 1) goto L134;
        r2.sortRanges();
        r2.compactRanges();
        setContext(0);
        next();
        return r2;
    L134:
        throw ex("parser.cc.2", this.offset);
    L66:
        throw ex("parser.cc.5", this.offset);
    L59:
        r2 = r4;
    L67:
        boolean r13 = r3;
    L68:
        next();
        if (r13 == true) goto L127;
        if (r7 != 0) goto L86;
        if (r10 == 91) goto L84;
        if (r10 == 93) goto L82;
        if (r10 != 45) goto L86;
        if (r6 == true) goto L86;
        if (this.chardata == 93) goto L86;
        throw ex("parser.cc.8", this.offset - 2);
    L82:
        throw ex("parser.cc.7", this.offset - 2);
    L84:
        throw ex("parser.cc.6", this.offset - 2);
    L86:
        if (read() == 0) goto L88;
    L126:
        r4.addRange(r10, r10);
        goto L127
    L88:
        if (this.chardata != 45) goto L126;
        next();
        int r8 = read();
        if (r8 == 1) goto L125;
        if (r8 == 24) goto L123;
        if (r8 == 0) goto L95;
    L97:
        int r9 = this.chardata;
        if (r8 != 0) goto L112;
        if (r9 == 91) goto L110;
        if (r9 == 93) goto L108;
        if (r9 != 45) goto L114;
        next();
        if (this.chardata == 93) goto L114;
        throw ex("parser.cc.8", this.offset - 2);
    L114:
        if (r9 == 45) goto L116;
    L117:
        next();
    L118:
        if (r10 > r9) goto L121;
        r4.addRange(r10, r9);
        goto L127
    L121:
        throw ex("parser.ope.3", this.offset - 1);
    L116:
        if (this.chardata == 93) goto L118;
    L108:
        throw ex("parser.cc.7", this.offset - 1);
    L110:
        throw ex("parser.cc.6", this.offset - 1);
    L112:
        if (r8 != 10) goto L114;
        r9 = decodeEscaped();
        goto L114
    L95:
        if (this.chardata != 93) goto L97;
        r4.addRange(r10, r10);
        r4.addRange(45, 45);
        goto L127
    L123:
        throw ex("parser.cc.8", this.offset - 1);
    L125:
        throw ex("parser.cc.2", this.offset);
    L127:
        r3 = false;
        r6 = false;
        goto L9
    L21:
        if (r10 != 67) goto L23;
    L52:
        r10 = processCIinCharacterClass(r4, r10);
        if (r10 >= 0) goto L67;
    L51:
        r13 = true;
        goto L68
    L23:
        if (r10 != 68) goto L25;
    L50:
        r4.mergeRanges(getTokenForShorthand(r10));
        goto L51
    L25:
        if (r10 == 73) goto L52;
        if (r10 != 80) goto L29;
    L45:
        int r14 = this.offset;
        RangeToken r15 = processBacksolidus_pP(r10);
        if (r15 == null) goto L49;
        r4.mergeRanges(r15);
        goto L51
    L49:
        throw ex("parser.atom.5", r14);
    L29:
        if (r10 == 83) goto L50;
        if (r10 == 87) goto L50;
        if (r10 == 105) goto L52;
        if (r10 == 112) goto L45;
        if (r10 == 115) goto L50;
        if (r10 == 119) goto L50;
        if (r10 == 99) goto L52;
        if (r10 == 100) goto L50;
        r10 = decodeEscaped();
        goto L67
    L14:
        if (this.chardata != 93) goto L18;
        if (r6 == true) goto L18;
        if (r5 == false) goto L128;
        r2.subtractRanges(r4);
    L128:
        r2 = r4;
        goto L130
    L5:
        if (this.chardata != 94) goto L7;
        next();
        r2 = Token.createRange();
        r2.addRange(0, 1114111);
        r4 = Token.createRange();
        r5 = true;
        goto L8
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public RangeToken parseSetOperations() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBackreference() {
        throw ex("parser.process.1", this.offset - 4);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_A() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_B() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_C() {
        next();
        return getTokenForShorthand(67);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_I() {
        next();
        return getTokenForShorthand(73);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_X() {
        throw ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_Z() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_b() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_c() {
        next();
        return getTokenForShorthand(99);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_g() {
        throw ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_gt() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_i() {
        next();
        return getTokenForShorthand(105);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_lt() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processBacksolidus_z() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    int processCIinCharacterClass(RangeToken r1, int r2) {
        r1.mergeRanges(getTokenForShorthand(r2));
        return -1;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processCaret() {
        next();
        return Token.createChar(94);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processCondition() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processDollar() {
        next();
        return Token.createChar(36);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processIndependent() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processLookahead() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processLookbehind() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processModifiers() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processNegativelookahead() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processNegativelookbehind() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processParen() {
        next();
        Token.ParenToken r0 = Token.createParen(parseRegex(), 0);
        if (read() != 7) goto L7;
        next();
        return r0;
    L7:
        throw ex("parser.factor.1", this.offset - 1);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processParen2() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processPlus(Token r1) {
        next();
        return Token.createConcat(r1, Token.createClosure(r1));
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processQuestion(Token r1) {
        next();
        Token.UnionToken r0 = Token.createUnion();
        r0.addChild(r1);
        r0.addChild(Token.createEmpty());
        return r0;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    Token processStar(Token r1) {
        next();
        return Token.createClosure(r1);
    }
}
