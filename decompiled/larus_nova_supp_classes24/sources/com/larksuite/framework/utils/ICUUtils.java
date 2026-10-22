package com.larksuite.framework.utils;

import android.content.Context;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ICUUtils {

    public static class FormatArgsBuilder {
        public final List<UFormatPair> a;

        public FormatArgsBuilder() {
            this.a = new ArrayList();
        }

        public final void a(Integer r3) {
            UFormatPair r0 = new UFormatPair();
            r0.key = "num";
            r0.valueType = UValueType.UValue_Long;
            r0.intValue = r3.intValue();
            ((ArrayList) this.a).add(r0);
        }

        public final void b(String r2, String r3) {
            UFormatPair r0 = new UFormatPair();
            r0.key = r2;
            r0.valueType = UValueType.UValue_String;
            r0.stringValue = r3;
            ((ArrayList) this.a).add(r0);
        }
    }

    public static class UFormatPair {
        public double doubleValue;
        public int intValue;
        public String key;
        public long longValue;
        public String stringValue;
        public UValueType valueType;

        public UFormatPair() {
        }
    }

    public static final enum UValueType extends Enum<UValueType> {
        public static final UValueType UValue_Date = null;
        public static final UValueType UValue_Double = null;
        public static final UValueType UValue_Int64 = null;
        public static final UValueType UValue_Long = null;
        public static final UValueType UValue_String = null;
        public static final /* synthetic */ UValueType[] a = null;

        static {
            UValueType r0 = new UValueType("UValue_Date", 0);
            UValue_Date = r0;
            UValueType r1 = new UValueType("UValue_Double", 1);
            UValue_Double = r1;
            UValueType r3 = new UValueType("UValue_Long", 2);
            UValue_Long = r3;
            UValueType r5 = new UValueType("UValue_String", 3);
            UValue_String = r5;
            UValueType r7 = new UValueType("UValue_Int64", 4);
            UValue_Int64 = r7;
            a = new UValueType[]{r0, r1, r3, r5, r7};
        }

        public static UValueType[] values() {
            return (UValueType[]) a.clone();
        }

        public static UValueType valueOf(String r1) {
            return (UValueType) r27.a.a(UValueType.class, r1);
        }

        public UValueType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public ICUUtils() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static native String icuFormat(String r0, String r1, List<UFormatPair> r2);

    static {
        INVOKESTATIC_com_larksuite_framework_utils_ICUUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("icu_lark");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_larksuite_framework_utils_ICUUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    private static String getLangCode(Context r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return r2.getResources().getConfiguration().getLocales().get(0).toLanguageTag();
    L6:
        return r2.getResources().getConfiguration().locale.toLanguageTag();
    }

    public static String icuFormat(String r1, List<UFormatPair> r2) {
        return icuFormat(getLangCode(b.a), r1, r2);
    }

    public static String icuFormat(String r3, String r4, Double r5) {
        String r0 = getLangCode(b.a);
        FormatArgsBuilder r1 = new FormatArgsBuilder();
        UFormatPair r2 = new UFormatPair();
        r2.key = r4;
        r2.valueType = UValueType.UValue_Double;
        r2.doubleValue = r5.doubleValue();
        ((ArrayList) r1.a).add(r2);
        return icuFormat(r0, r3, r1.a);
    }

    public static String icuTimeFormat(String r3, String r4, Double r5) {
        String r0 = getLangCode(b.a);
        FormatArgsBuilder r1 = new FormatArgsBuilder();
        UFormatPair r2 = new UFormatPair();
        r2.key = r4;
        r2.valueType = UValueType.UValue_Date;
        r2.doubleValue = r5.doubleValue();
        ((ArrayList) r1.a).add(r2);
        return icuFormat(r0, r3, r1.a);
    }

    public static String icuFormat(String r3, String r4, Long r5) {
        String r0 = getLangCode(b.a);
        FormatArgsBuilder r1 = new FormatArgsBuilder();
        UFormatPair r2 = new UFormatPair();
        r2.key = r4;
        r2.valueType = UValueType.UValue_Int64;
        r2.longValue = r5.longValue();
        ((ArrayList) r1.a).add(r2);
        return icuFormat(r0, r3, r1.a);
    }

    public static String icuFormat(String r2, String r3, String r4) {
        String r0 = getLangCode(b.a);
        FormatArgsBuilder r1 = new FormatArgsBuilder();
        r1.b(r3, r4);
        return icuFormat(r0, r2, r1.a);
    }
}
