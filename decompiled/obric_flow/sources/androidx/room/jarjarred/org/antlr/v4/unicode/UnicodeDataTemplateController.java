package androidx.room.jarjarred.org.antlr.v4.unicode;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import com.bytedance.keva.KevaImpl;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.RangeValueIterator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnicodeDataTemplateController {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public UnicodeDataTemplateController() {
    }

    private static void addEmojiPresentationPropertyCodesToCodePointRanges(Map<String, IntervalSet> r5) {
        UnicodeSet r10 = new UnicodeSet("[[\\p{Emoji=Yes}]&[\\p{Emoji_Presentation=Yes}]]");
        IntervalSet r11 = new IntervalSet(new int[0]);
        addUnicodeSetToIntervalSet(r10, r11);
        r5.put("EmojiPresentation=EmojiDefault", r11);
        UnicodeSet r12 = new UnicodeSet("[[\\p{Emoji=Yes}]&[\\p{Emoji_Presentation=No}]]");
        IntervalSet r13 = new IntervalSet(new int[0]);
        addUnicodeSetToIntervalSet(r12, r13);
        r5.put("EmojiPresentation=TextDefault", r13);
        UnicodeSet r14 = new UnicodeSet("[\\p{Emoji=No}]");
        IntervalSet r15 = new IntervalSet(new int[0]);
        addUnicodeSetToIntervalSet(r14, r15);
        r5.put("EmojiPresentation=Text", r15);
    }

    private static void addIntPropertyAliases(int r10, String r11, Map<String, String> r12) {
        String r5 = getShortPropertyName(r10);
        int r13 = UCharacter.getIntPropertyMinValue(r10);
    L4:
        if (r13 > UCharacter.getIntPropertyMaxValue(r10)) goto L9;
        StringBuilder r14 = j0.w(r5, "=");
        int r15 = 0;
        r14.append(UCharacter.getPropertyValueName(r10, r13, 0));
    L10:
        addPropertyAlias(r12, r11 + UCharacter.getPropertyValueName(r10, r13, r15), r14.toString());
        r15 = r15 + 1;
    L8:
        r13 = r13 + 1;
        goto L4
    }

    private static void addIntPropertyRanges(int r5, String r10, Map<String, IntervalSet> r11) {
        int r12 = UCharacter.getIntPropertyMinValue(r5);
    L4:
        if (r12 > UCharacter.getIntPropertyMaxValue(r5)) goto L9;
        UnicodeSet r13 = new UnicodeSet();
        r13.applyIntPropertyValue(r5, r12);
        StringBuilder r14 = j0.u(r10);
        r14.append(UCharacter.getPropertyValueName(r5, r12, 0));
        String r15 = r14.toString();
        IntervalSet r16 = r11.get(r15);
        if (r16 != null) goto L8;
        r16 = new IntervalSet(new int[0]);
        r11.put(r15, r16);
    L8:
        addUnicodeSetToIntervalSet(r13, r16);
        r12 = r12 + 1;
        goto L4
    }

    private static void addIntervalForCategory(Map<String, IntervalSet> r5, String r10, int r11, int r12) {
        IntervalSet r13 = r5.get(r10);
        if (r13 != null) goto L5;
        r13 = new IntervalSet(new int[0]);
        r5.put(r10, r13);
    L5:
        r13.add(r11, r12);
    }

    private static void addPropertyAlias(Map<String, String> r5, String r10, String r11) {
        r5.put(r10, r11);
    }

    private static void addPropertyAliases(Map<String, String> r5, String r10, int r11) {
        int r12 = 1;
    L6:
        addPropertyAlias(r5, UCharacter.getPropertyName(r11, r12), r10);
        r12 = r12 + 1;
    }

    private static void addTR35ExtendedPictographicPropertyCodesToCodePointRanges(Map<String, IntervalSet> r5) {
        IntervalSet r10 = new IntervalSet(new int[0]);
        r10.add(128884, 128895);
        r10.add(9984, 9985);
        r10.add(9987, 9988);
        r10.add(9998);
        r10.add(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 10001);
        r10.add(10085, 10087);
        r10.add(127024, 127123);
        r10.add(127124, 127135);
        r10.add(127245, 127247);
        r10.add(127279);
        r10.add(127340, 127343);
        r10.add(127405, 127461);
        r10.add(127584, 127589);
        r10.add(127491, 127503);
        r10.add(127548, 127551);
        r10.add(127561, 127567);
        r10.add(127570, 127583);
        r10.add(127590, 127743);
        r10.add(128981, 129023);
        r10.add(126976, 126979);
        r10.add(126981, 127019);
        r10.add(127020, 127023);
        r10.add(127778, 127779);
        r10.add(127892, 127893);
        r10.add(127896);
        r10.add(127900, 127901);
        r10.add(127985, 127986);
        r10.add(127990);
        r10.add(128254);
        r10.add(128318, 128328);
        r10.add(128335);
        r10.add(128360, 128366);
        r10.add(128369, 128370);
        r10.add(128379, 128390);
        r10.add(128392, 128393);
        r10.add(128398, 128399);
        r10.add(128401, 128404);
        r10.add(128407, 128419);
        r10.add(128422, 128423);
        r10.add(128425, 128432);
        r10.add(128435, 128443);
        r10.add(128445, 128449);
        r10.add(128453, 128464);
        r10.add(128468, 128475);
        r10.add(128479, 128480);
        r10.add(128482);
        r10.add(128484, 128487);
        r10.add(128489, 128494);
        r10.add(128496, 128498);
        r10.add(128500, 128505);
        r10.add(9733);
        r10.add(9735, 9741);
        r10.add(9743, 9744);
        r10.add(9746);
        r10.add(9750, 9751);
        r10.add(9753, 9756);
        r10.add(9758, 9759);
        r10.add(9761);
        r10.add(9764, 9765);
        r10.add(9767, 9769);
        r10.add(9771, 9773);
        r10.add(9776, 9783);
        r10.add(9787, 9799);
        r10.add(9812, 9823);
        r10.add(9825, 9826);
        r10.add(9828);
        r10.add(9831);
        r10.add(9833, 9850);
        r10.add(9852, 9854);
        r10.add(9856, 9873);
        r10.add(9877);
        r10.add(9880);
        r10.add(9882);
        r10.add(9885, 9887);
        r10.add(9890, 9897);
        r10.add(9900, 9903);
        r10.add(9906, 9916);
        r10.add(9919, 9923);
        r10.add(9926, 9927);
        r10.add(9929, 9933);
        r10.add(9936);
        r10.add(9938);
        r10.add(9941, 9960);
        r10.add(9963, 9967);
        r10.add(9974);
        r10.add(9979, 9980);
        r10.add(9982, 9983);
        r10.add(9096);
        r10.add(129536, 131069);
        r10.add(127136, 127150);
        r10.add(127153, 127167);
        r10.add(127169, 127183);
        r10.add(127185, 127221);
        r10.add(127151, 127152);
        r10.add(127168);
        r10.add(127184);
        r10.add(127222, 127231);
        r10.add(129036, 129039);
        r10.add(129096, 129103);
        r10.add(129114, 129119);
        r10.add(129160, 129167);
        r10.add(129198, 129279);
        r10.add(129280, 129291);
        r10.add(129311);
        r10.add(129320, 129327);
        r10.add(129329, 129330);
        r10.add(129356);
        r10.add(129375, 129387);
        r10.add(129426, 129431);
        r10.add(129488, 129510);
        r10.add(129292, 129295);
        r10.add(129343);
        r10.add(129357, 129359);
        r10.add(129388, 129407);
        r10.add(129432, 129471);
        r10.add(129473, 129487);
        r10.add(129511, 129535);
        r10.add(128710, 128714);
        r10.add(128723, 128724);
        r10.add(128742, 128744);
        r10.add(128746);
        r10.add(128753, 128754);
        r10.add(128759, 128760);
        r10.add(128725, 128735);
        r10.add(128749, 128751);
        r10.add(128761, 128767);
        r5.put("Extended_Pictographic", r10);
        UnicodeSet r11 = new UnicodeSet("[\\p{GCB=Regional_Indicator}\\*#0-9\\u00a9\\u00ae\\u2122\\u3030\\u303d]");
        IntervalSet r12 = new IntervalSet(new int[0]);
        addUnicodeSetToIntervalSet(r11, r12);
        r5.put("EmojiRK", r12);
        UnicodeSet r13 = new UnicodeSet("[\\p{Emoji=Yes}]");
        r13.removeAll(r11);
        IntervalSet r14 = new IntervalSet(new int[0]);
        addUnicodeSetToIntervalSet(r13, r14);
        r5.put("EmojiNRK", r14);
    }

    private static void addUnicodeBinaryPropertyCodesToCodePointRanges(Map<String, IntervalSet> r10) {
        int r5 = 0;
    L4:
        if (r5 >= 61) goto L10;
        String r11 = getShortPropertyName(r5);
        IntervalSet r12 = new IntervalSet(new int[0]);
        UnicodeSet r13 = new UnicodeSet();
        r13.applyIntPropertyValue(r5, 1);
        Iterator r14 = r13.ranges().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        UnicodeSet.EntryRange r15 = (UnicodeSet.EntryRange) r14.next();
        r12.add(r15.codepoint, r15.codepointEnd);
        goto L7
    L9:
        r10.put(r11, r12);
        r5 = r5 + 1;
        goto L4
    }

    private static void addUnicodeBinaryPropertyCodesToNames(Map<String, String> r5) {
        int r10 = 0;
    L4:
        if (r10 >= 61) goto L6;
        addPropertyAliases(r5, getShortPropertyName(r10), r10);
        r10 = r10 + 1;
        goto L4
    }

    private static void addUnicodeBlocksToNames(Map<String, String> r5) {
        addIntPropertyAliases(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, "In", r5);
    }

    private static void addUnicodeCategoryCodesToCodePointRanges(Map<String, IntervalSet> r10) {
        RangeValueIterator r5 = UCharacter.getTypeIterator();
        RangeValueIterator.Element r11 = new RangeValueIterator.Element();
    L4:
        if (r5.next(r11) == false) goto L6;
        String r12 = UCharacter.getPropertyValueName(8192, 1 << r11.value, 0);
        addIntervalForCategory(r10, r12, r11.start, r11.limit - 1);
        addIntervalForCategory(r10, r12.substring(0, 1), r11.start, r11.limit - 1);
        goto L4
    }

    private static void addUnicodeCategoryCodesToNames(Map<String, String> r10) {
        RangeValueIterator r5 = UCharacter.getTypeIterator();
        RangeValueIterator.Element r11 = new RangeValueIterator.Element();
    L4:
        if (r5.next(r11) == false) goto L8;
        int r12 = 1;
        int r13 = 1 << r11.value;
        String r14 = UCharacter.getPropertyValueName(8192, r13, 0);
    L11:
        addPropertyAlias(r10, UCharacter.getPropertyValueName(8192, r13, r12), r14);
        r12 = r12 + 1;
        goto L11
    L8:
        addPropertyAlias(r10, "Control", "C");
        addPropertyAlias(r10, "Letter", "L");
        addPropertyAlias(r10, "Number", "N");
        addPropertyAlias(r10, "Mark", "M");
        addPropertyAlias(r10, "Punctuation", "P");
        addPropertyAlias(r10, "Symbol", ExifInterface.LATITUDE_SOUTH);
        addPropertyAlias(r10, "Space", "Z");
    }

    private static void addUnicodeIntPropertyCodesToCodePointRanges(Map<String, IntervalSet> r5) {
        int r10 = 4096;
    L4:
        if (r10 >= 4118) goto L6;
        addIntPropertyRanges(r10, j0.j(getShortPropertyName(r10), "="), r5);
        r10 = r10 + 1;
        goto L4
    }

    private static void addUnicodeIntPropertyCodesToNames(Map<String, String> r5) {
        int r10 = 4096;
    L4:
        if (r10 >= 4118) goto L9;
        int r11 = 1;
    L10:
        addIntPropertyAliases(r10, j0.j(UCharacter.getPropertyName(r10, r11), "="), r5);
        r11 = r11 + 1;
    L8:
        r10 = r10 + 1;
        goto L4
    }

    private static void addUnicodeScriptCodesToNames(Map<String, String> r5) {
        addIntPropertyAliases(4106, "", r5);
    }

    private static void addUnicodeSetToIntervalSet(UnicodeSet r5, IntervalSet r10) {
        Iterator r11 = r5.ranges().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        UnicodeSet.EntryRange r12 = (UnicodeSet.EntryRange) r11.next();
        r10.add(r12.codepoint, r12.codepointEnd);
        goto L4
    }

    public static Map<String, Object> getProperties() {
        LinkedHashMap r5 = new LinkedHashMap();
        addUnicodeCategoryCodesToCodePointRanges(r5);
        addUnicodeBinaryPropertyCodesToCodePointRanges(r5);
        addUnicodeIntPropertyCodesToCodePointRanges(r5);
        addTR35ExtendedPictographicPropertyCodesToCodePointRanges(r5);
        addEmojiPresentationPropertyCodesToCodePointRanges(r5);
        LinkedHashMap r10 = new LinkedHashMap();
        addUnicodeCategoryCodesToNames(r10);
        addUnicodeBinaryPropertyCodesToNames(r10);
        addUnicodeScriptCodesToNames(r10);
        addUnicodeBlocksToNames(r10);
        addUnicodeIntPropertyCodesToNames(r10);
        r10.put("EP", "Extended_Pictographic");
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("propertyCodePointRanges", r5);
        r11.put("propertyAliases", r10);
        return r11;
    }

    private static String getShortPropertyName(int r5) {
        String r10 = UCharacter.getPropertyName(r5, 0);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return UCharacter.getPropertyName(r5, 1);
    }
}
