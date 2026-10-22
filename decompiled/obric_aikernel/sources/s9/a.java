package s9;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.NpthBus;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f12760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f12761b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f12762c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f12763d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f12764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12765f = null;

    static {
        f12765f = new a();
        f12761b = new String[]{"A", "B", "C", "D", "E", "F", NpthBus.UUID_SUFIX_3_1_3, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
        f12762c = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ".~", "A", "B", "C", "D", "E", "F", NpthBus.UUID_SUFIX_3_1_3, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
        f12763d = new String[]{"あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "*い", "ゆ", "*え", "よ", "ら", "り", "る", "れ", "ろ", "わ", "*い", "*う", "*え", "を", "A", "B", "C", "D", "E", "F", NpthBus.UUID_SUFIX_3_1_3, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".~", ".~", ".~", ".>"};
        f12764e = new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", ".~", "A", "B", "C", "D", "E", "F", NpthBus.UUID_SUFIX_3_1_3, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", ".>"};
    }

    private a() {
    }

    private final boolean e(String r10) {
        String[] r11 = (String[]) Arrays.copyOfRange(f12762c, 0, 14);
        return Arrays.asList((String[]) Arrays.copyOf(r11, r11.length)).contains(r10);
    }

    public final String[] a(String r10) {
        Intrinsics.checkNotNullParameter(r10, Api.KEY_LANGUAGE);
        Locale r11 = Locale.KOREA;
        Intrinsics.checkNotNullExpressionValue(r11, "Locale.KOREA");
        if (Intrinsics.areEqual(r11.getLanguage(), r10) == true) goto L13;
        Locale r12 = Locale.JAPAN;
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.JAPAN");
        if (Intrinsics.areEqual(r12.getLanguage(), r10) == false) goto L9;
        return f12763d;
    L9:
        if (Intrinsics.areEqual("ru", r10) == false) goto L12;
        return f12764e;
    L12:
        return f12761b;
    L13:
        return f12762c;
    }

    public final boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, Api.KEY_LANGUAGE);
        Locale r11 = Locale.CHINESE;
        Intrinsics.checkNotNullExpressionValue(r11, "Locale.CHINESE");
        if (Intrinsics.areEqual(r11.getLanguage(), r10) == true) goto L19;
        Locale r12 = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.ENGLISH");
        if (Intrinsics.areEqual(r12.getLanguage(), r10) == true) goto L20;
        Locale r13 = Locale.KOREA;
        Intrinsics.checkNotNullExpressionValue(r13, "Locale.KOREA");
        if (Intrinsics.areEqual(r13.getLanguage(), r10) == true) goto L21;
        Locale r14 = Locale.JAPAN;
        Intrinsics.checkNotNullExpressionValue(r14, "Locale.JAPAN");
        if (Intrinsics.areEqual(r14.getLanguage(), r10) == false) goto L15;
        return true;
    L15:
        if (Intrinsics.areEqual("ru", r10) == true) goto L23;
        return false;
    L23:
        return true;
    L21:
        return true;
    L20:
        return true;
    L19:
        return true;
    }

    public final boolean c(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r10, "*", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "alphabet");
        String[] r11 = (String[]) Arrays.copyOfRange(f12763d, 0, 50);
        return Arrays.asList((String[]) Arrays.copyOf(r11, r11.length)).contains(r10);
    }

    public final boolean f(String r10) {
        Intrinsics.checkNotNullParameter(r10, "alphabet");
        return Intrinsics.areEqual(".~", r10);
    }

    public final boolean g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "alphabet");
        String[] r11 = (String[]) Arrays.copyOfRange(f12764e, 0, 32);
        return Arrays.asList((String[]) Arrays.copyOf(r11, r11.length)).contains(r10);
    }

    public final boolean h(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, Api.KEY_LANGUAGE);
        Intrinsics.checkNotNullParameter(r11, "alphabet");
        Locale r12 = Locale.CHINESE;
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.CHINESE");
        if (Intrinsics.areEqual(r12.getLanguage(), r10) == true) goto L23;
        Locale r13 = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(r13, "Locale.ENGLISH");
        if (Intrinsics.areEqual(r13.getLanguage(), r10) == true) goto L23;
        Locale r14 = Locale.KOREA;
        Intrinsics.checkNotNullExpressionValue(r14, "Locale.KOREA");
        if (Intrinsics.areEqual(r14.getLanguage(), r10) == true) goto L11;
        Locale r15 = Locale.JAPAN;
        Intrinsics.checkNotNullExpressionValue(r15, "Locale.JAPAN");
        if (Intrinsics.areEqual(r15.getLanguage(), r10) == false) goto L19;
        if (d(r11) == true) goto L23;
        return false;
    L19:
        if (Intrinsics.areEqual("ru", r10) == true) goto L21;
        return false;
    L21:
        if (g(r11) == true) goto L23;
        return false;
    L11:
        if (e(r11) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "alphabet");
        return Intrinsics.areEqual(".>", r10);
    }

    public final float j(String r10) {
        Intrinsics.checkNotNullParameter(r10, Api.KEY_LANGUAGE);
        Locale r11 = Locale.KOREA;
        Intrinsics.checkNotNullExpressionValue(r11, "Locale.KOREA");
        if (Intrinsics.areEqual(r11.getLanguage(), r10) == true) goto L13;
        Locale r12 = Locale.JAPAN;
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.JAPAN");
        if (Intrinsics.areEqual(r12.getLanguage(), r10) == false) goto L9;
        return 12.5f;
    L9:
        if (Intrinsics.areEqual("ru", r10) == false) goto L13;
        if (f12760a == true) goto L13;
        return 12.5f;
    L13:
        return 9.0f;
    }

    public final int k(String r10) {
        Intrinsics.checkNotNullParameter(r10, Api.KEY_LANGUAGE);
        Locale r11 = Locale.CHINESE;
        Intrinsics.checkNotNullExpressionValue(r11, "Locale.CHINESE");
        if (Intrinsics.areEqual(r11.getLanguage(), r10) == true) goto L16;
        Locale r12 = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.ENGLISH");
        if (Intrinsics.areEqual(r12.getLanguage(), r10) == true) goto L18;
        Locale r13 = Locale.KOREA;
        Intrinsics.checkNotNullExpressionValue(r13, "Locale.KOREA");
        if (Intrinsics.areEqual(r13.getLanguage(), r10) == true) goto L16;
        Locale r14 = Locale.JAPAN;
        Intrinsics.checkNotNullExpressionValue(r14, "Locale.JAPAN");
        if (Intrinsics.areEqual(r14.getLanguage(), r10) == false) goto L15;
        return 1;
    L15:
        if (Intrinsics.areEqual("ru", r10) == false) goto L16;
        return 1;
    L18:
        return 1;
    L16:
        return 0;
    }
}
