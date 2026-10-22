package ai;

import android.net.Uri;
import androidx.compose.runtime.ComposerKt;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class j0 {
    public static /* synthetic */ void A(Object r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        throw new ClassCastException();
    }

    public static double B(double r5, double r10, double r11, double r12) {
        return ((r5 * r10) * r11) + r12;
    }

    public static String C(String r5, String r10) {
        return r5 + r10;
    }

    public static String D(String r5, String r10, String r11) {
        return r5 + r10 + r11;
    }

    public static double a(double r5, double r10, double r11, double r12) {
        return ((r5 - r10) * r11) + r12;
    }

    public static float b(float r5, float r10, float r11, float r12) {
        return ((r5 - r10) * r11) + r12;
    }

    public static int c(int r5, int r10, int r11, int r12) {
        return ((r5 - r10) / r11) + r12;
    }

    public static int d(int r5, ArrayList r10, int r11, int r12) {
        r10.add(Integer.valueOf(r5));
        return r11 + r12;
    }

    public static Object e(List r5, int r10) {
        return r5.get(r5.size() - r10);
    }

    public static String f(int r5, int r10, String r11, String r12) {
        return r11 + r5 + r12 + r10;
    }

    public static String g(int r5, String r10) {
        return r10 + r5;
    }

    public static String h(int r5, String r10, String r11) {
        return r10 + r5 + r11;
    }

    public static String i(Uri r5, String r10) {
        return r10 + r5;
    }

    public static String j(String r5, String r10) {
        return r5 + r10;
    }

    public static String k(String r5, String r10, String r11) {
        return r5 + r10 + r11;
    }

    public static String l(String r5, String r10, String r11, String r12, String r13) {
        return r5 + r10 + r11 + r12 + r13;
    }

    public static String m(String r5, Type r10) {
        return r5 + r10;
    }

    public static String n(StringBuilder r5, int r10, char r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static String o(StringBuilder r5, long r10, String r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static String p(StringBuilder r5, String r10, char r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static String q(StringBuilder r5, String r10, String r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static String r(StringBuilder r5, boolean r10, String r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static StringBuilder s(int r5, String r10, String r11) {
        StringBuilder r12 = new StringBuilder(r10);
        r12.append(r5);
        r12.append(r11);
        return r12;
    }

    public static StringBuilder t(long r5, String r10, String r11) {
        StringBuilder r12 = new StringBuilder(r10);
        r12.append(r5);
        r12.append(r11);
        return r12;
    }

    public static StringBuilder u(String r5) {
        StringBuilder r10 = new StringBuilder();
        r10.append(r5);
        return r10;
    }

    public static StringBuilder v(String r5, int r10, int r11, String r12, String r13) {
        StringBuilder r14 = new StringBuilder(r5);
        r14.append(r10);
        r14.append(r12);
        r14.append(r11);
        r14.append(r13);
        return r14;
    }

    public static StringBuilder w(String r5, String r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(r5);
        r11.append(r10);
        return r11;
    }

    public static StringBuilder x(String r5, String r10, String r11) {
        StringBuilder r12 = new StringBuilder(r5);
        r12.append(r10);
        r12.append(r11);
        return r12;
    }

    public static ArrayList y(Map r5, Object r10) {
        ArrayList r11 = new ArrayList();
        r5.put(r10, r11);
        return r11;
    }

    public static KotlinNothingValueException z(String r5) {
        ComposerKt.composeRuntimeError(r5);
        return new KotlinNothingValueException();
    }
}
