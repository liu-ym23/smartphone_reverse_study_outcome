package com.tom_roush.fontbox.f;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String[]> f16021a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int[] f16022b;
    private static String[] c;

    static {
        Object[][] r3 = {new Object[]{"Adlam", new String[]{"adlm"}}, new Object[]{"Ahom", new String[]{"ahom"}}, new Object[]{"Anatolian_Hieroglyphs", new String[]{"hluw"}}, new Object[]{"Arabic", new String[]{"arab"}}, new Object[]{"Armenian", new String[]{"armn"}}, new Object[]{"Avestan", new String[]{"avst"}}, new Object[]{"Balinese", new String[]{"bali"}}, new Object[]{"Bamum", new String[]{"bamu"}}, new Object[]{"Bassa_Vah", new String[]{"bass"}}, new Object[]{"Batak", new String[]{"batk"}}, new Object[]{"Bengali", new String[]{"bng2", "beng"}}, new Object[]{"Bhaiksuki", new String[]{"bhks"}}, new Object[]{"Bopomofo", new String[]{"bopo"}}, new Object[]{"Brahmi", new String[]{"brah"}}, new Object[]{"Braille", new String[]{"brai"}}, new Object[]{"Buginese", new String[]{"bugi"}}, new Object[]{"Buhid", new String[]{"buhd"}}, new Object[]{"Canadian_Aboriginal", new String[]{"cans"}}, new Object[]{"Carian", new String[]{"cari"}}, new Object[]{"Caucasian_Albanian", new String[]{"aghb"}}, new Object[]{"Chakma", new String[]{"cakm"}}, new Object[]{"Cham", new String[]{"cham"}}, new Object[]{"Cherokee", new String[]{"cher"}}, new Object[]{"Common", new String[]{"DFLT"}}, new Object[]{"Coptic", new String[]{"copt"}}, new Object[]{"Cuneiform", new String[]{"xsux"}}, new Object[]{"Cypriot", new String[]{"cprt"}}, new Object[]{"Cyrillic", new String[]{"cyrl"}}, new Object[]{"Deseret", new String[]{"dsrt"}}, new Object[]{"Devanagari", new String[]{"dev2", "deva"}}, new Object[]{"Duployan", new String[]{"dupl"}}, new Object[]{"Egyptian_Hieroglyphs", new String[]{"egyp"}}, new Object[]{"Elbasan", new String[]{"elba"}}, new Object[]{"Ethiopic", new String[]{"ethi"}}, new Object[]{"Georgian", new String[]{"geor"}}, new Object[]{"Glagolitic", new String[]{"glag"}}, new Object[]{"Gothic", new String[]{"goth"}}, new Object[]{"Grantha", new String[]{"gran"}}, new Object[]{"Greek", new String[]{"grek"}}, new Object[]{"Gujarati", new String[]{"gjr2", "gujr"}}, new Object[]{"Gurmukhi", new String[]{"gur2", "guru"}}, new Object[]{"Han", new String[]{"hani"}}, new Object[]{"Hangul", new String[]{"hang"}}, new Object[]{"Hanunoo", new String[]{"hano"}}, new Object[]{"Hatran", new String[]{"hatr"}}, new Object[]{"Hebrew", new String[]{"hebr"}}, new Object[]{"Hiragana", new String[]{"kana"}}, new Object[]{"Imperial_Aramaic", new String[]{"armi"}}, new Object[]{"Inherited", new String[]{"Inherited"}}, new Object[]{"Inscriptional_Pahlavi", new String[]{"phli"}}, new Object[]{"Inscriptional_Parthian", new String[]{"prti"}}, new Object[]{"Javanese", new String[]{"java"}}, new Object[]{"Kaithi", new String[]{"kthi"}}, new Object[]{"Kannada", new String[]{"knd2", "knda"}}, new Object[]{"Katakana", new String[]{"kana"}}, new Object[]{"Kayah_Li", new String[]{"kali"}}, new Object[]{"Kharoshthi", new String[]{"khar"}}, new Object[]{"Khmer", new String[]{"khmr"}}, new Object[]{"Khojki", new String[]{"khoj"}}, new Object[]{"Khudawadi", new String[]{"sind"}}, new Object[]{"Lao", new String[]{"lao "}}, new Object[]{"Latin", new String[]{"latn"}}, new Object[]{"Lepcha", new String[]{"lepc"}}, new Object[]{"Limbu", new String[]{"limb"}}, new Object[]{"Linear_A", new String[]{"lina"}}, new Object[]{"Linear_B", new String[]{"linb"}}, new Object[]{"Lisu", new String[]{"lisu"}}, new Object[]{"Lycian", new String[]{"lyci"}}, new Object[]{"Lydian", new String[]{"lydi"}}, new Object[]{"Mahajani", new String[]{"mahj"}}, new Object[]{"Malayalam", new String[]{"mlm2", "mlym"}}, new Object[]{"Mandaic", new String[]{"mand"}}, new Object[]{"Manichaean", new String[]{"mani"}}, new Object[]{"Marchen", new String[]{"marc"}}, new Object[]{"Meetei_Mayek", new String[]{"mtei"}}, new Object[]{"Mende_Kikakui", new String[]{"mend"}}, new Object[]{"Meroitic_Cursive", new String[]{"merc"}}, new Object[]{"Meroitic_Hieroglyphs", new String[]{"mero"}}, new Object[]{"Miao", new String[]{"plrd"}}, new Object[]{"Modi", new String[]{"modi"}}, new Object[]{"Mongolian", new String[]{"mong"}}, new Object[]{"Mro", new String[]{"mroo"}}, new Object[]{"Multani", new String[]{"mult"}}, new Object[]{"Myanmar", new String[]{"mym2", "mymr"}}, new Object[]{"Nabataean", new String[]{"nbat"}}, new Object[]{"Newa", new String[]{"newa"}}, new Object[]{"New_Tai_Lue", new String[]{"talu"}}, new Object[]{"Nko", new String[]{"nko "}}, new Object[]{"Ogham", new String[]{"ogam"}}, new Object[]{"Ol_Chiki", new String[]{"olck"}}, new Object[]{"Old_Italic", new String[]{"ital"}}, new Object[]{"Old_Hungarian", new String[]{"hung"}}, new Object[]{"Old_North_Arabian", new String[]{"narb"}}, new Object[]{"Old_Permic", new String[]{"perm"}}, new Object[]{"Old_Persian", new String[]{"xpeo"}}, new Object[]{"Old_South_Arabian", new String[]{"sarb"}}, new Object[]{"Old_Turkic", new String[]{"orkh"}}, new Object[]{"Oriya", new String[]{"ory2", "orya"}}, new Object[]{"Osage", new String[]{"osge"}}, new Object[]{"Osmanya", new String[]{"osma"}}, new Object[]{"Pahawh_Hmong", new String[]{"hmng"}}, new Object[]{"Palmyrene", new String[]{"palm"}}, new Object[]{"Pau_Cin_Hau", new String[]{"pauc"}}, new Object[]{"Phags_Pa", new String[]{"phag"}}, new Object[]{"Phoenician", new String[]{"phnx"}}, new Object[]{"Psalter_Pahlavi", new String[]{"phlp"}}, new Object[]{"Rejang", new String[]{"rjng"}}, new Object[]{"Runic", new String[]{"runr"}}, new Object[]{"Samaritan", new String[]{"samr"}}, new Object[]{"Saurashtra", new String[]{"saur"}}, new Object[]{"Sharada", new String[]{"shrd"}}, new Object[]{"Shavian", new String[]{"shaw"}}, new Object[]{"Siddham", new String[]{"sidd"}}, new Object[]{"SignWriting", new String[]{"sgnw"}}, new Object[]{"Sinhala", new String[]{"sinh"}}, new Object[]{"Sora_Sompeng", new String[]{"sora"}}, new Object[]{"Sundanese", new String[]{"sund"}}, new Object[]{"Syloti_Nagri", new String[]{"sylo"}}, new Object[]{"Syriac", new String[]{"syrc"}}, new Object[]{"Tagalog", new String[]{"tglg"}}, new Object[]{"Tagbanwa", new String[]{"tagb"}}, new Object[]{"Tai_Le", new String[]{"tale"}}, new Object[]{"Tai_Tham", new String[]{"lana"}}, new Object[]{"Tai_Viet", new String[]{"tavt"}}, new Object[]{"Takri", new String[]{"takr"}}, new Object[]{"Tamil", new String[]{"tml2", "taml"}}, new Object[]{"Tangut", new String[]{"tang"}}, new Object[]{"Telugu", new String[]{"tel2", "telu"}}, new Object[]{"Thaana", new String[]{"thaa"}}, new Object[]{"Thai", new String[]{"thai"}}, new Object[]{"Tibetan", new String[]{"tibt"}}, new Object[]{"Tifinagh", new String[]{"tfng"}}, new Object[]{"Tirhuta", new String[]{"tirh"}}, new Object[]{"Ugaritic", new String[]{"ugar"}}, new Object[]{"Unknown", new String[]{"DFLT"}}, new Object[]{"Vai", new String[]{"vai "}}, new Object[]{"Warang_Citi", new String[]{"wara"}}, new Object[]{"Yi", new String[]{"yi  "}}};
        f16021a = new HashMap(138);
        int r4 = 0;
    L3:
        if (r4 >= 138) goto L5;
        Object[] r5 = r3[r4];
        f16021a.put((String) ZeusTransformUtils.preCheckCast(r5[0], String.class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(r5[1], String[].class, "com.obric.memorydata.plugin"));
        r4 = r4 + 1;
        goto L3
    L5:
        BufferedInputStream r6 = null;
    L17:
        e = move-exception;
        Log.w("PdfBox-Android", "Could not parse Scripts.txt, mirroring char map will be empty: " + e.getMessage());     // Catch: Throwable -> L15
        if (r6 == null) goto L35;
    L29:
        r6.close();     // Catch: IOException -> L14
        return;
    L14:
        Log.w("PdfBox-Android", "Could not close Scripts.txt");
        return;
    L35:
        return;
    L15:
        th = move-exception;
        if (r6 != null) goto L32;
    L26:
        throw th;
    L32:
        r6.close();     // Catch: IOException -> L25
    L25:
        Log.w("PdfBox-Android", "Could not close Scripts.txt");
        goto L26
    L7:
        if (com.tom_roush.pdfbox.android.a.a() == false) goto L10;
        BufferedInputStream r7 = new BufferedInputStream(com.tom_roush.pdfbox.android.a.a("/com/tom_roush/fontbox/resources/unicode/Scripts.txt"));     // Catch: Throwable -> L15 IOException -> L17
    L9:
        r6 = r7;
        a(r6);     // Catch: Throwable -> L15 IOException -> L17
    L10:
        r7 = new BufferedInputStream(y.class.getResourceAsStream("/com/tom_roush/fontbox/resources/unicode/Scripts.txt"));     // Catch: Throwable -> L15 IOException -> L17
        goto L9
    }

    private y() {
    }

    private static void a(InputStream r12) {
        TreeMap r0 = new TreeMap(new AnonymousClass1());
        LineNumberReader r1 = new LineNumberReader(new InputStreamReader(r12));
        int[] r2 = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        String r3 = null;
    L3:
        String r4 = r1.readLine();
        if (r4 == null) goto L5;
        int r7 = r4.indexOf(35);
        if (r7 == (-1)) goto L14;
        r4 = r4.substring(0, r7);
    L14:
        if (r4.length() < 2) goto L3;
        StringTokenizer r8 = new StringTokenizer(r4, ";");
        if (r8.countTokens() < 2) goto L3;
        String r5 = r8.nextToken().trim();
        String r9 = r8.nextToken().trim();
        int[] r10 = new int[2];
        int r11 = r5.indexOf("..");
        if (r11 != (-1)) goto L22;
        int r6 = Integer.parseInt(r5, 16);
        r10[1] = r6;
        r10[0] = r6;
    L24:
        if (r10[0] != (r2[1] + 1)) goto L28;
        if (r9.equals(r3) == false) goto L28;
        r2[1] = r10[1];
    L28:
        r0.put(r10, r9);
        r3 = r9;
        r2 = r10;
        goto L3
    L22:
        r10[0] = Integer.parseInt(r5.substring(0, r11), 16);
        r10[1] = Integer.parseInt(r5.substring(r11 + 2), 16);
        goto L24
    L5:
        r1.close();
        f16022b = new int[r0.size()];
        c = new String[r0.size()];
        Iterator r13 = r0.entrySet().iterator();
        int r14 = 0;
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        f16022b[r14] = ((int[]) ZeusTransformUtils.preCheckCast(r15.getKey(), int[].class, "com.obric.memorydata.plugin"))[0];
        c[r14] = (String) ZeusTransformUtils.preCheckCast(r15.getValue(), String.class, "com.obric.memorydata.plugin");
        r14 = r14 + 1;
        goto L7
    }

    public static String[] a(int r2) {
        c(r2);
        String r3 = b(r2);
        return (String[]) ZeusTransformUtils.preCheckCast(f16021a.get(r3), String[].class, "com.obric.memorydata.plugin");
    }

    private static String b(int r1) {
        c(r1);
        if (Character.getType(r1) != 0) goto L6;
        return "Unknown";
    L6:
        int r2 = Arrays.binarySearch(f16022b, r1);
        if (r2 >= 0) goto L10;
        r2 = (-r2) - 2;
    L10:
        return c[r2];
    }

    private static void c(int r3) {
        if (r3 < 0) goto L7;
        if (r3 > 1114111) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Invalid codepoint: " + r3);
    }
}
