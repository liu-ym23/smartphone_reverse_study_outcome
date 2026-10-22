package com.obric.oui.indexscrollbar;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.NpthBus;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersConfig;", "", "()V", "ENGLISH_LETTERS", "", "", "[Ljava/lang/String;", "JAPANESE_LETTERS", "KOREA_LETTERS", "RUSSIAN_LETTERS", "isLocaleLetter", "", Api.KEY_LANGUAGE, "index", "", "lettersByLanguage", "(Ljava/lang/String;)[Ljava/lang/String;", "setRussianLetterWithEnglish", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13917a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f13918b = null;
    private static final String[] c = null;
    private static final String[] d = null;
    private static String[] e;

    static {
        f13917a = new c();
        f13918b = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b, ExifInterface.LONGITUDE_EAST, "F", NpthBus.UUID_SUFIX_3_1_3, i.n, "I", "J", "K", i.u, "M", "N", "O", i.m, "Q", "R", "S", ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#"};
        c = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ".B", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b, ".E", NpthBus.UUID_SUFIX_3_1_3, ".H", "J", ".K", "M", ".N", i.m, ".Q", "S", ".T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ".W", "Y", ".Z", "#"};
        d = new String[]{"あ", "か", "さ", "た", "な", "は", "ま", "や", "ら", "わ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ".B", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b, ".E", NpthBus.UUID_SUFIX_3_1_3, ".H", "J", ".K", "M", ".N", i.m, ".Q", "S", ".T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ".W", "Y", ".Z", "#"};
        e = new String[]{"А", ".Б", "Г", ".Д", "З", ".И", "К", ".Л", "Н", ".О", "С", ".Т", "Ф", ".Х", "Ч", ".Ш", "ы", ".ь", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ".B", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b, ".E", NpthBus.UUID_SUFIX_3_1_3, ".H", "J", ".K", "M", ".N", i.m, ".Q", "S", ".T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ".W", "Y", ".Z", "#"};
    }

    private c() {
    }

    public final boolean a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, Api.KEY_LANGUAGE);
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r3) == false) goto L9;
        if (r4 >= 14) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r3) == false) goto L14;
        if (r4 >= 10) goto L17;
        return true;
    L14:
        if (Intrinsics.areEqual("ru", r3) == false) goto L17;
        if (r4 >= 5) goto L17;
        return true;
    }

    public final String[] a(String r1) {
        Intrinsics.checkNotNullParameter(r1, Api.KEY_LANGUAGE);
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r1) == false) goto L6;
        return c;
    L6:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r1) == false) goto L9;
        return d;
    L9:
        if (Intrinsics.areEqual("ru", r1) == false) goto L12;
        return e;
    L12:
        return f13918b;
    }
}
