package androidx.room.jarjarred.org.antlr.runtime;

import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.solver.CodeGenScope;
import com.bytedance.ies.bullet.base.utils.logger.c;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.metadata.internal.protobuf.g;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static void A(Exception r5, String r10, String r11) {
        Log.e(r11, r10 + r5);
    }

    public static void B(String r5, String r10, ArrayList r11) {
        r11.add(new c(r5, r10));
    }

    public static void C(StringBuilder r5, int r10, String r11, int r12, String r13) {
        r5.append(r10);
        r5.append(r11);
        r5.append(r12);
        r5.append(r13);
    }

    public static void D(StringBuilder r5, int r10, String r11, String r12, String r13) {
        r5.append(r10);
        r5.append(r11);
        r5.append(r12);
        r5.append(r13);
    }

    public static int a(float r5, int r10) {
        return MathKt.roundToInt(TypedValue.applyDimension(r10, r5, Resources.getSystem().getDisplayMetrics()));
    }

    public static int b(int r5, int r10) {
        return UInt.m219constructorimpl(UInt.m219constructorimpl(r5) + r10);
    }

    public static int c(int r5, int r10, int r11) {
        return (Integer.hashCode(r5) + r10) * r11;
    }

    public static int d(int r5, int r10, boolean r11) {
        return (Boolean.hashCode(r11) + r5) * r10;
    }

    public static int e(int r5, long r10, int r11) {
        return (Long.hashCode(r10) + r5) * r11;
    }

    public static int f(int r5, Integer r10) {
        return g.d(r10.intValue()) + r5;
    }

    public static int g(int r5, String r10) {
        return String.valueOf(r10).length() + r5;
    }

    public static int h(int r5, IntRange r10) {
        return r10.getEndInclusive().intValue() + r5;
    }

    public static int i(UInt r5, int r10) {
        return UInt.m219constructorimpl(r5.m271unboximpl() + r10);
    }

    public static IntervalSet j(List r5, boolean r10) {
        IntervalSet r11 = new IntervalSet(r5);
        r11.setReadonly(r10);
        return r11;
    }

    public static com.squareup.javapoet.g k(String r5, String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r5, r10);
        Intrinsics.checkNotNullParameter(r12, r11);
        return r12.builder();
    }

    public static String l(int r5, String r10, String r11) {
        StringBuilder r12 = new StringBuilder(r5);
        r12.append(r10);
        r12.append(r11);
        return r12.toString();
    }

    public static String m(int r5, String r10, String r11, String r12) {
        StringBuilder r13 = new StringBuilder(r5);
        r13.append(r10);
        r13.append(r11);
        r13.append(r12);
        return r13.toString();
    }

    public static String n(RecyclerView r5, StringBuilder r10) {
        r10.append(r5.t());
        return r10.toString();
    }

    public static String o(Exception r5, StringBuilder r10) {
        r10.append(r5.getMessage());
        return r10.toString();
    }

    public static String p(String r5, char r10, String r11) {
        return r5 + r11 + r10;
    }

    public static String q(String r5, String r10, String r11, String r12) {
        return r5 + r10 + r11 + r12;
    }

    public static String r(String r5, String r10, String r11, String r12, String r13) {
        String r14 = r5 + r10 + r11;
        Intrinsics.checkNotNullParameter(r12, r13);
        return r14;
    }

    public static String s(StringBuilder r5, int r10, int r11, String r12, char r13) {
        StringBuilder r14 = r5.replace(r10, r11, r12);
        r14.append(r13);
        return r14.toString();
    }

    public static String t(StringBuilder r5, long r10, char r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static String u(StringBuilder r5, String r10, String r11, Object r12) {
        r5.append(r10);
        r5.append(r11);
        r5.append(r12.getClass());
        return r5.toString();
    }

    public static String v(StringBuilder r5, String r10, String r11, String r12) {
        r5.append(r10);
        String r13 = r5.toString();
        Intrinsics.checkNotNullParameter(r11, r12);
        return r13;
    }

    public static String w(StringBuilder r5, String r10, String r11, String r12, String r13) {
        r5.append(r10);
        String r14 = r5.toString();
        Intrinsics.checkNotNullParameter(r11, r12);
        Intrinsics.checkNotNullParameter(r14, r13);
        return r14;
    }

    public static String x(Throwable r5, StringBuilder r10) {
        r10.append(r5.getMessage());
        return r10.toString();
    }

    public static StringBuilder y(String r5, String r10, String r11, String r12, String r13) {
        StringBuilder r14 = new StringBuilder();
        r14.append(r5);
        r14.append(r10);
        r14.append(r11);
        r14.append(r12);
        r14.append(r13);
        return r14;
    }

    public static void z(int r5, HashMap r10, String r11, int r12, String r13) {
        r10.put(r11, Integer.valueOf(r5));
        r10.put(r13, Integer.valueOf(r12));
    }
}
