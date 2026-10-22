package com.ctc.wstx.shaded.msv_core.datatype.regexp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
class d extends f {
    private static Hashtable l;
    private static Hashtable m;

    static {
    }

    public d() {
    }

    public static synchronized RangeToken a(String r5, boolean r6) {
        monitor-enter(d.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (l != null) goto L7;
        l = new Hashtable();     // Catch: Throwable -> L14
        m = new Hashtable();     // Catch: Throwable -> L14
        RangeToken r1 = Token.createRange();     // Catch: Throwable -> L14
        a(r1, "\t\n\r\r  ");     // Catch: Throwable -> L14
        l.put("xml:isSpace", r1);     // Catch: Throwable -> L14
        m.put("xml:isSpace", Token.complementRanges(r1));     // Catch: Throwable -> L14
        RangeToken r2 = Token.createRange();     // Catch: Throwable -> L14
        a(r2, "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩");     // Catch: Throwable -> L14
        l.put("xml:isDigit", r2);     // Catch: Throwable -> L14
        m.put("xml:isDigit", Token.complementRanges(r2));     // Catch: Throwable -> L14
        RangeToken r3 = Token.createRange();     // Catch: Throwable -> L14
        a(r3, "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩");     // Catch: Throwable -> L14
        l.put("xml:isDigit", r3);     // Catch: Throwable -> L14
        m.put("xml:isDigit", Token.complementRanges(r3));     // Catch: Throwable -> L14
        RangeToken r4 = Token.createRange();     // Catch: Throwable -> L14
        a(r4, "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣");     // Catch: Throwable -> L14
        r4.mergeRanges((Token) ZeusTransformUtils.preCheckCast(l.get("xml:isDigit"), Token.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        l.put("xml:isWord", r4);     // Catch: Throwable -> L14
        m.put("xml:isWord", Token.complementRanges(r4));     // Catch: Throwable -> L14
        RangeToken r7 = Token.createRange();     // Catch: Throwable -> L14
        a(r7, "-.0:AZ__az··ÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁːˑ̀͠͡ͅΆΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁ҃҆ҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆֹֻֽֿֿׁׂ֑֣֡ׄׄאתװײءغـْ٠٩ٰڷںھۀێېۓە۪ۭۨ۰۹ँःअह़्॑॔क़ॣ०९ঁঃঅঌএঐওনপরললশহ়়াৄেৈো্ৗৗড়ঢ়য়ৣ০ৱਂਂਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹ਼਼ਾੂੇੈੋ੍ਖ਼ੜਫ਼ਫ਼੦ੴઁઃઅઋઍઍએઑઓનપરલળવહ઼ૅેૉો્ૠૠ૦૯ଁଃଅଌଏଐଓନପରଲଳଶହ଼ୃେୈୋ୍ୖୗଡ଼ଢ଼ୟୡ୦୯ஂஃஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹாூெைொ்ௗௗ௧௯ఁఃఅఌఎఐఒనపళవహాౄెైొ్ౕౖౠౡ౦౯ಂಃಅಌಎಐಒನಪಳವಹಾೄೆೈೊ್ೕೖೞೞೠೡ೦೯ംഃഅഌഎഐഒനപഹാൃെൈൊ്ൗൗൠൡ൦൯กฮะฺเ๎๐๙ກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະູົຽເໄໆໆ່ໍ໐໙༘༙༠༩༹༹༵༵༷༷༾ཇཉཀྵ྄ཱ྆ྋྐྕྗྗྙྭྱྷྐྵྐྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼ⃐⃜⃡⃡ΩΩKÅ℮℮ↀↂ々々〇〇〡〯〱〵ぁゔ゙゚ゝゞァヺーヾㄅㄬ一龥가힣");     // Catch: Throwable -> L14
        l.put("xml:isNameChar", r7);     // Catch: Throwable -> L14
        m.put("xml:isNameChar", Token.complementRanges(r7));     // Catch: Throwable -> L14
        RangeToken r8 = Token.createRange();     // Catch: Throwable -> L14
        a(r8, "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣");     // Catch: Throwable -> L14
        r8.addRange(95, 95);     // Catch: Throwable -> L14
        r8.addRange(58, 58);     // Catch: Throwable -> L14
        l.put("xml:isInitialNameChar", r8);     // Catch: Throwable -> L14
        m.put("xml:isInitialNameChar", Token.complementRanges(r8));     // Catch: Throwable -> L14
    L7:
        if (r6 == false) goto L10;
        Object r9 = ZeusTransformUtils.preCheckCast(l.get(r5), RangeToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L9:
        RangeToken r10 = (RangeToken) r9;     // Catch: Throwable -> L14
        monitor-exit(d.class);
        return r10;
    L10:
        r9 = ZeusTransformUtils.preCheckCast(m.get(r5), RangeToken.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        goto L9
    }

    static void a(Token r4, String r5) {
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.addRange(r5.charAt(r1), r5.charAt(r1 + 1));
        r1 = r1 + 2;
        goto L3
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    int A() {
        if (B() != 10) goto L26;
        int r0 = this.f;
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
        throw a("parser.process.1", this.f3565a - 2);
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
        throw a("parser.next.1", this.f3565a - 1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    int a(RangeToken r1, int r2) {
        r1.mergeRanges(b(r2));
        return -1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    public RangeToken a(boolean r17) {
        c(1);
        C();
        boolean r3 = false;
        if (B() == 0) goto L5;
    L7:
        RangeToken r4 = Token.createRange();
        RangeToken r2 = null;
        boolean r5 = false;
    L8:
        boolean r6 = true;
    L9:
        int r7 = B();
        if (r7 == 1) goto L118;
        if (r7 == 0) goto L14;
    L18:
        int r10 = this.f;
        if (r7 == 10) goto L21;
        if (r7 != 24) goto L67;
        if (r6 == true) goto L67;
        if (r5 == false) goto L59;
        r2.subtractRanges(r4);
    L60:
        r2.subtractRanges(a(r3));
        if (B() != 0) goto L66;
        if (this.f != 93) goto L66;
    L120:
        if (B() == 1) goto L124;
        r2.sortRanges();
        r2.compactRanges();
        c(0);
        C();
        return r2;
    L124:
        throw a("parser.cc.2", this.f3565a);
    L66:
        throw a("parser.cc.5", this.f3565a);
    L59:
        r2 = r4;
    L67:
        boolean r8 = r3;
    L68:
        C();
        if (r8 == true) goto L117;
        if (r7 != 0) goto L83;
        if (r10 == 91) goto L81;
        if (r10 == 93) goto L79;
        if (r10 != 45) goto L83;
        throw a("parser.cc.8", this.f3565a - 2);
    L79:
        throw a("parser.cc.7", this.f3565a - 2);
    L81:
        throw a("parser.cc.6", this.f3565a - 2);
    L83:
        if (B() == 0) goto L85;
    L116:
        r4.addRange(r10, r10);
        goto L117
    L85:
        if (this.f != 45) goto L116;
        C();
        int r9 = B();
        if (r9 == 1) goto L115;
        if (r9 == 0) goto L91;
    L92:
        if (r9 == 24) goto L113;
        int r11 = this.f;
        if (r9 != 0) goto L105;
        if (r11 == 91) goto L104;
        if (r11 == 93) goto L102;
        if (r11 == 45) goto L100;
    L107:
        C();
        if (r10 > r11) goto L111;
        r4.addRange(r10, r11);
        goto L117
    L111:
        throw a("parser.ope.3", this.f3565a - 1);
    L100:
        throw a("parser.cc.8", this.f3565a - 2);
    L102:
        throw a("parser.cc.7", this.f3565a - 1);
    L104:
        throw a("parser.cc.6", this.f3565a - 1);
    L105:
        if (r9 != 10) goto L107;
        r11 = A();
    L113:
        throw a("parser.cc.8", this.f3565a - 1);
    L91:
        if (this.f == 93) goto L113;
    L115:
        throw a("parser.cc.2", this.f3565a);
    L117:
        r3 = false;
        r6 = false;
        goto L9
    L21:
        if (r10 != 67) goto L23;
    L52:
        r10 = a(r4, r10);
        if (r10 >= 0) goto L67;
    L51:
        r8 = true;
        goto L68
    L23:
        if (r10 != 68) goto L25;
    L50:
        r4.mergeRanges(b(r10));
        goto L51
    L25:
        if (r10 == 73) goto L52;
        if (r10 != 80) goto L29;
    L45:
        int r12 = this.f3565a;
        RangeToken r13 = d(r10);
        if (r13 == null) goto L49;
        r4.mergeRanges(r13);
        goto L51
    L49:
        throw a("parser.atom.5", r12);
    L29:
        if (r10 == 83) goto L50;
        if (r10 == 87) goto L50;
        if (r10 == 105) goto L52;
        if (r10 == 112) goto L45;
        if (r10 == 115) goto L50;
        if (r10 == 119) goto L50;
        if (r10 == 99) goto L52;
        if (r10 == 100) goto L50;
        r10 = A();
        goto L67
    L14:
        if (this.f != 93) goto L18;
        if (r6 == true) goto L18;
        if (r5 == false) goto L118;
        r2.subtractRanges(r4);
    L118:
        r2 = r4;
        goto L120
    L5:
        if (this.f != 94) goto L7;
        C();
        r2 = Token.createRange();
        r2.addRange(0, 1114111);
        r4 = Token.createRange();
        r5 = true;
        goto L8
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token a() {
        C();
        return Token.createChar(94);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token a(Token r1) {
        C();
        return Token.createClosure(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    boolean a(int r1) {
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token b() {
        C();
        return Token.createChar(36);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token b(int r7) {
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
        return a("xml:isDigit", true);
    L25:
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(r7, 16));
    L27:
        return a("xml:isNameChar", true);
    L29:
        return a("xml:isWord", true);
    L31:
        return a("xml:isSpace", true);
    L33:
        return a("xml:isInitialNameChar", true);
    L35:
        return a("xml:isWord", false);
    L37:
        return a("xml:isSpace", false);
    L39:
        return a("xml:isInitialNameChar", false);
    L41:
        return a("xml:isDigit", false);
    L43:
        return a("xml:isNameChar", false);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token b(Token r1) {
        C();
        return Token.createConcat(r1, Token.createClosure(r1));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token c() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token c(Token r1) {
        C();
        Token.UnionToken r0 = Token.createUnion();
        r0.addChild(r1);
        r0.addChild(Token.createEmpty());
        return r0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token d() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token e() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token f() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token g() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token h() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token i() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token j() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token k() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token l() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token m() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token n() {
        C();
        Token.ParenToken r0 = Token.createParen(D(), 0);
        if (B() != 7) goto L7;
        C();
        return r0;
    L7:
        throw a("parser.factor.1", this.f3565a - 1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token o() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token p() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token q() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token r() {
        throw a("parser.process.1", this.f3565a);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token s() {
        C();
        return b(99);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token t() {
        C();
        return b(67);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token u() {
        C();
        return b(105);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token v() {
        C();
        return b(73);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token w() {
        throw a("parser.process.1", this.f3565a - 2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token x() {
        throw a("parser.process.1", this.f3565a - 2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    Token y() {
        throw a("parser.process.1", this.f3565a - 4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.f
    public RangeToken z() {
        throw a("parser.process.1", this.f3565a);
    }
}
