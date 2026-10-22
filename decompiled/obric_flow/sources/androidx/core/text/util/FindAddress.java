package androidx.core.text.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class FindAddress {
    private static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    private static final String HOUSE_END = "(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String HOUSE_POST_DELIM = ",\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String HOUSE_PRE_DELIM = ":,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int MAX_ADDRESS_LINES = 5;
    private static final int MAX_ADDRESS_WORDS = 14;
    private static final int MAX_LOCATION_NAME_DISTANCE = 5;
    private static final int MIN_ADDRESS_WORDS = 4;
    private static final String NL = "\n\u000b\f\r\u0085\u2028\u2029";
    private static final String SP = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000";
    private static final String WORD_DELIM = ",*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String WORD_END = "(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String WS = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int kMaxAddressNameWordLength = 25;
    private static final Pattern sHouseNumberRe = null;
    private static final Pattern sLocationNameRe = null;
    private static final Pattern sStateRe = null;
    private static final ZipRange[] sStateZipCodeRanges = null;
    private static final Pattern sSuffixedNumberRe = null;
    private static final Pattern sWordRe = null;
    private static final Pattern sZipCodeRe = null;

    public static class ZipRange {
        int mException1;
        int mException2;
        int mHigh;
        int mLow;

        public ZipRange(int r5, int r10, int r11, int r12) {
            this.mLow = r5;
            this.mHigh = r10;
            this.mException1 = r11;
            this.mException2 = r12;
        }

        public boolean matches(String r5) {
            int r10 = Integer.parseInt(r5.substring(0, 2));
            if (this.mLow > r10) goto L7;
            if (r10 > this.mHigh) goto L7;
        L10:
            return true;
        L7:
            if (r10 == this.mException1) goto L10;
            if (r10 == this.mException2) goto L10;
            return false;
        }
    }

    static {
        sStateZipCodeRanges = new ZipRange[]{new ZipRange(99, 99, -1, -1), new ZipRange(35, 36, -1, -1), new ZipRange(71, 72, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(85, 86, -1, -1), new ZipRange(90, 96, -1, -1), new ZipRange(80, 81, -1, -1), new ZipRange(6, 6, -1, -1), new ZipRange(20, 20, -1, -1), new ZipRange(19, 19, -1, -1), new ZipRange(32, 34, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(30, 31, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(50, 52, -1, -1), new ZipRange(83, 83, -1, -1), new ZipRange(60, 62, -1, -1), new ZipRange(46, 47, -1, -1), new ZipRange(66, 67, 73, -1), new ZipRange(40, 42, -1, -1), new ZipRange(70, 71, -1, -1), new ZipRange(1, 2, -1, -1), new ZipRange(20, 21, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(48, 49, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(63, 65, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(38, 39, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(27, 28, -1, -1), new ZipRange(58, 58, -1, -1), new ZipRange(68, 69, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(7, 8, -1, -1), new ZipRange(87, 88, 86, -1), new ZipRange(88, 89, 96, -1), new ZipRange(10, 14, 0, 6), new ZipRange(43, 45, -1, -1), new ZipRange(73, 74, -1, -1), new ZipRange(97, 97, -1, -1), new ZipRange(15, 19, -1, -1), new ZipRange(6, 6, 0, 9), new ZipRange(96, 96, -1, -1), new ZipRange(2, 2, -1, -1), new ZipRange(29, 29, -1, -1), new ZipRange(57, 57, -1, -1), new ZipRange(37, 38, -1, -1), new ZipRange(75, 79, 87, 88), new ZipRange(84, 84, -1, -1), new ZipRange(22, 24, 20, -1), new ZipRange(6, 9, -1, -1), new ZipRange(5, 5, -1, -1), new ZipRange(98, 99, -1, -1), new ZipRange(53, 54, -1, -1), new ZipRange(24, 26, -1, -1), new ZipRange(82, 83, -1, -1)};
        sWordRe = Pattern.compile("[^,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]+(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sHouseNumberRe = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+states[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mariana[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(nd|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(ne|nebraska)|(nh|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+hampshire)|(nj|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+jersey)|(nm|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mexico)|(nv|nevada)|(ny|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+rico)|(pw|palau)|(ri|rhode[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+island)|(sc|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(sd|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+virginia)|(wy|wyoming))(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sSuffixedNumberRe = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);
        sZipCodeRe = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    }

    private FindAddress() {
    }

    private static int attemptMatch(String r13, MatchResult r14) {
        int r15 = r14.end();
        Matcher r5 = sWordRe.matcher(r13);
        String r10 = "";
        int r11 = -1;
        int r12 = -1;
        int r16 = 1;
        int r17 = 1;
        boolean r18 = true;
        boolean r19 = false;
    L4:
        if (r15 >= r13.length()) goto L58;
        if (r5.find(r15) == false) goto L7;
        if ((r5.end() - r5.start()) > 25) goto L12;
    L14:
        if (r15 >= r5.start()) goto L20;
        int r110 = r15 + 1;
        if (NL.indexOf(r13.charAt(r15)) == (-1)) goto L18;
        r16 = r16 + 1;
    L18:
        r15 = r110;
        goto L14
    L20:
        if (r16 > 5) goto L58;
        r17 = r17 + 1;
        if (r17 > 14) goto L58;
        if (matchHouseNumber(r13, r15) == null) goto L34;
        if (r18 == false) goto L31;
        if (r16 <= 1) goto L31;
        return -r15;
    L31:
        if (r11 != (-1)) goto L57;
        r11 = r15;
    L57:
        r10 = r5.group(0);
        r15 = r5.end();
        goto L4
    L34:
        if (isValidLocationName(r5.group(0)) == false) goto L37;
        r19 = true;
    L36:
        r18 = false;
        goto L57
    L37:
        if (r17 != 5) goto L40;
        if (r19 == true) goto L40;
        r15 = r5.end();
    L40:
        if (r19 == false) goto L36;
        if (r17 <= 4) goto L36;
        MatchResult r111 = matchState(r13, r15);
        if (r111 == null) goto L36;
        if (r10.equals("et") == true) goto L48;
    L50:
        Matcher r20 = sWordRe.matcher(r13);
        if (r20.find(r111.end()) == true) goto L53;
        r12 = r111.end();
        goto L36
    L53:
        if (isValidZipCode(r20.group(0), r111) == false) goto L36;
        return r20.end();
    L48:
        if (r111.group(0).equals("al") == false) goto L50;
        r15 = r111.end();
        goto L58
    L12:
        int r112 = r5.end();
    L9:
        return -r112;
    L7:
        r112 = r13.length();
    L58:
        if (r12 <= 0) goto L60;
        return r12;
    L60:
        if (r11 > 0) goto L64;
        r11 = r15;
    L64:
        return -r11;
    }

    private static boolean checkHouseNumber(String r5) {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= r5.length()) goto L10;
        if (Character.isDigit(r5.charAt(r10)) == false) goto L8;
        r11 = r11 + 1;
    L8:
        r10 = r10 + 1;
        goto L4
    L10:
        if (r11 <= 5) goto L12;
        return false;
    L12:
        Matcher r12 = sSuffixedNumberRe.matcher(r5);
        if (r12.find() == false) goto L42;
        int r13 = Integer.parseInt(r12.group(1));
        if (r13 != 0) goto L17;
        return false;
    L17:
        String r14 = r12.group(2).toLowerCase(Locale.getDefault());
        int r15 = r13 % 10;
        String r16 = "th";
        if (r15 == 1) goto L37;
        if (r15 == 2) goto L31;
        if (r15 == 3) goto L25;
        return r14.equals("th");
    L25:
        if ((r13 % 100) == 13) goto L29;
        r16 = "rd";
    L29:
        return r14.equals(r16);
    L31:
        if ((r13 % 100) == 12) goto L35;
        r16 = "nd";
    L35:
        return r14.equals(r16);
    L37:
        if ((r13 % 100) == 11) goto L41;
        r16 = "st";
    L41:
        return r14.equals(r16);
    L42:
        return true;
    }

    public static String findAddress(String r5) {
        Matcher r10 = sHouseNumberRe.matcher(r5);
        int r11 = 0;
    L4:
        if (r10.find(r11) == false) goto L13;
        if (checkHouseNumber(r10.group(0)) == true) goto L7;
        r11 = r10.end();
        goto L4
    L7:
        int r12 = r10.start();
        int r13 = attemptMatch(r5, r10);
        if (r13 > 0) goto L10;
        r11 = -r13;
        goto L4
    L10:
        return r5.substring(r12, r13);
    L13:
        return null;
    }

    @VisibleForTesting
    public static boolean isValidLocationName(String r5) {
        return sLocationNameRe.matcher(r5).matches();
    }

    private static boolean isValidZipCode(String r5, MatchResult r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = r10.groupCount();
    L6:
        if (r11 <= 0) goto L12;
        int r12 = r11 - 1;
        if (r10.group(r11) != null) goto L9;
        r11 = r12;
        goto L6
    L9:
        r11 = r12;
    L12:
        if (sZipCodeRe.matcher(r5).matches() == true) goto L14;
        return false;
    L14:
        if (sStateZipCodeRanges[r11].matches(r5) == false) goto L20;
        return true;
    L20:
        return false;
    }

    @VisibleForTesting
    public static MatchResult matchHouseNumber(String r5, int r10) {
        if (r10 > 0) goto L5;
    L7:
        Matcher r11 = sHouseNumberRe.matcher(r5).region(r10, r5.length());
        if (r11.lookingAt() == false) goto L12;
        MatchResult r12 = r11.toMatchResult();
        if (checkHouseNumber(r12.group(0)) == false) goto L12;
        return r12;
    L12:
        return null;
    L5:
        if (HOUSE_PRE_DELIM.indexOf(r5.charAt(r10 - 1)) != (-1)) goto L7;
        return null;
    }

    @VisibleForTesting
    public static MatchResult matchState(String r5, int r10) {
        if (r10 > 0) goto L5;
    L7:
        Matcher r11 = sStateRe.matcher(r5).region(r10, r5.length());
        if (r11.lookingAt() == true) goto L10;
        return null;
    L10:
        return r11.toMatchResult();
    L5:
        if (WORD_DELIM.indexOf(r5.charAt(r10 - 1)) != (-1)) goto L7;
        return null;
    }

    @VisibleForTesting
    public static boolean isValidZipCode(String r5, String r10) {
        return isValidZipCode(r5, matchState(r10, 0));
    }

    @VisibleForTesting
    public static boolean isValidZipCode(String r5) {
        return sZipCodeRe.matcher(r5).matches();
    }
}
