package s9;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.NpthBus;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f12771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f12772b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f12773c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String[] f12774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f12775e = null;

    static {
        f12775e = new c();
        f12771a = new String[]{"A", "B", "C", "D", "E", "F", NpthBus.UUID_SUFIX_3_1_3, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        f12772b = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", "A", ".B", "D", ".E", NpthBus.UUID_SUFIX_3_1_3, ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
        f12773c = new String[]{"あ", "か", "さ", "た", "な", "は", "ま", "や", "ら", "わ", "A", ".B", "D", ".E", NpthBus.UUID_SUFIX_3_1_3, ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
        f12774d = new String[]{"А", ".Б", "Г", ".Д", "З", ".И", "К", ".Л", "Н", ".О", "С", ".Т", "Ф", ".Х", "Ч", ".Ш", "ы", ".ь", "A", ".B", "D", ".E", NpthBus.UUID_SUFIX_3_1_3, ".H", "J", ".K", "M", ".N", "P", ".Q", "S", ".T", "V", ".W", "Y", ".Z", "#"};
    }

    private c() {
    }

    public final boolean a(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, Api.KEY_LANGUAGE);
        Locale r12 = Locale.KOREA;
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.KOREA");
        if (Intrinsics.areEqual(r12.getLanguage(), r10) == true) goto L5;
        Locale r13 = Locale.JAPAN;
        Intrinsics.checkNotNullExpressionValue(r13, "Locale.JAPAN");
        if (Intrinsics.areEqual(r13.getLanguage(), r10) == false) goto L14;
        if (r11 >= 10) goto L17;
        return true;
    L17:
        return false;
    L14:
        if (Intrinsics.areEqual("ru", r10) == false) goto L17;
        if (r11 >= 5) goto L17;
        return true;
    L5:
        if (r11 >= 14) goto L17;
        return true;
    }

    public final String[] b(String r10) {
        Intrinsics.checkNotNullParameter(r10, Api.KEY_LANGUAGE);
        Locale r11 = Locale.KOREA;
        Intrinsics.checkNotNullExpressionValue(r11, "Locale.KOREA");
        if (Intrinsics.areEqual(r11.getLanguage(), r10) == true) goto L13;
        Locale r12 = Locale.JAPAN;
        Intrinsics.checkNotNullExpressionValue(r12, "Locale.JAPAN");
        if (Intrinsics.areEqual(r12.getLanguage(), r10) == false) goto L9;
        return f12773c;
    L9:
        if (Intrinsics.areEqual("ru", r10) == false) goto L12;
        return f12774d;
    L12:
        return f12771a;
    L13:
        return f12772b;
    }
}
