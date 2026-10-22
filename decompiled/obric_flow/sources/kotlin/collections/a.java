package kotlin.collections;

import android.util.Log;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.sequences.Sequence;
import m.A;
import org.threeten.bp.temporal.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static int a(CharSequence r5, String r10, Function1 r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, r10);
        Intrinsics.checkNotNullParameter(r11, r12);
        return r5.length();
    }

    public static Object b(CharSequence r5, int r10, Function1 r11) {
        return r11.invoke(Character.valueOf(r5.charAt(r10)));
    }

    public static Object c(byte[] r5, int r10, Function1 r11) {
        return r11.invoke(UByte.m136boximpl(UByteArray.m200getw2LRezQ(r5, r10)));
    }

    public static Object d(int[] r5, int r10, Function1 r11) {
        return r11.invoke(UInt.m213boximpl(UIntArray.m279getpVg5ArA(r5, r10)));
    }

    public static Object e(long[] r5, int r10, Function1 r11) {
        return r11.invoke(ULong.m292boximpl(ULongArray.m358getsVKNKU(r5, r10)));
    }

    public static Object f(short[] r5, int r10, Function1 r11) {
        return r11.invoke(UShort.m399boximpl(UShortArray.m463getMh2AYeg(r5, r10)));
    }

    public static String g(String r5, char r10) {
        return r5 + r10;
    }

    public static String h(String r5, g r10) {
        return r5 + r10;
    }

    public static StringBuilder i(String r5, SimpleTypeMarker r10, String r11) {
        StringBuilder r12 = new StringBuilder(r5);
        r12.append(r10);
        r12.append(r11);
        return r12;
    }

    public static ArrayList j(LinkedHashMap r5, Object r10) {
        ArrayList r11 = new ArrayList();
        r5.put(r10, r11);
        return r11;
    }

    public static Iterator k(Iterable r5, String r10, Function1 r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, r10);
        Intrinsics.checkNotNullParameter(r11, r12);
        return r5.iterator();
    }

    public static Iterator l(Sequence r5, String r10, Function1 r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, r10);
        Intrinsics.checkNotNullParameter(r11, r12);
        return r5.iterator();
    }

    public static void m(Exception r5, String r10, String r11) {
        Log.d(r11, r10 + r5);
    }

    public static void n(String r5, String r10, String r11) {
        Logger.d(r11, r5 + r10);
    }

    public static void o(StringBuilder r5, String r10, long r11, String r12) {
        r5.append(r10);
        r5.append(r11);
        r5.append(r12);
    }

    public static boolean p(A r5, String r10) {
        return r5.b().matcher(r10).find();
    }
}
