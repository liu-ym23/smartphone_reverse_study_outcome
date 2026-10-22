package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.CodedOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static void A(String r5, String r10, String r11) {
        Log.d(r11, r5 + r10);
    }

    public static void B(StringBuilder r5, String r10, String r11) {
        r5.append(r10);
        Log.d(r11, r5.toString());
    }

    public static void C(StringBuilder r5, String r10, String r11, String r12, String r13) {
        r5.append(r10);
        r5.append(r11);
        r5.append(r12);
        r5.append(r13);
    }

    public static StringBuilder D(String r5, String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, r10);
        Intrinsics.checkNotNullParameter(r11, r12);
        return new StringBuilder(r13);
    }

    public static float a(float r5, float r10, float r11, float r12) {
        return ((r5 - r10) / r11) + r12;
    }

    public static int b(float r5, int r10, int r11) {
        return (Float.hashCode(r5) + r10) * r11;
    }

    public static int c(int r5, int r10, String r11) {
        return (r11.hashCode() + r5) * r10;
    }

    public static int d(int r5, Integer r10) {
        return CodedOutputStream.computeInt32SizeNoTag(r10.intValue()) + r5;
    }

    public static int e(List r5, int r10) {
        return RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r5)), r10);
    }

    public static int f(List r5, int r10, int r11) {
        return (r5.hashCode() + r10) * r11;
    }

    public static ClassCastException g(Iterator r5) {
        r5.next().getClass();
        return new ClassCastException();
    }

    public static Object h(ArrayList r5, int r10) {
        return r5.get(r5.size() - r10);
    }

    public static String i(int r5, String r10, int r11) {
        StringBuilder r12 = new StringBuilder(r5);
        r12.append(r10);
        r12.append(r11);
        return r12.toString();
    }

    public static String j(long r5, String r10) {
        return r10 + r5;
    }

    public static String k(RecyclerView r5, StringBuilder r10) {
        r10.append(r5.exceptionLabel());
        return r10.toString();
    }

    public static String l(Class r5, String r10) {
        return r10 + r5;
    }

    public static String m(String r5, char r10, String r11) {
        return r5 + r10 + r11;
    }

    public static String n(String r5, int r10, int r11) {
        return r5.substring(r11, r5.length() - r10);
    }

    public static String o(String r5, Fragment r10, String r11) {
        return r5 + r10 + r11;
    }

    public static String p(String r5, String r10, String r11, String r12) {
        return r5 + r10 + r11 + r12;
    }

    public static String q(String r5, String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, r10);
        return r11 + r12 + r13;
    }

    public static String r(StringBuilder r5, float r10, String r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static String s(StringBuilder r5, int r10, String r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static String t(StringBuilder r5, String r10, String r11, String r12) {
        r5.append(r10);
        r5.append(r11);
        r5.append(r12);
        return r5.toString();
    }

    public static String u(StringBuilder r5, String r10, String r11, String r12, String r13) {
        r5.append(r10);
        r5.append(r11);
        r5.append(r12);
        r5.append(r13);
        return r5.toString();
    }

    public static String v(StringBuilder r5, List r10, char r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static String w(StringBuilder r5, boolean r10, char r11) {
        r5.append(r10);
        r5.append(r11);
        return r5.toString();
    }

    public static StringBuilder x(int r5, String r10) {
        StringBuilder r11 = new StringBuilder(r5);
        r11.append(r10);
        return r11;
    }

    public static StringBuilder y(String r5, String r10, String r11, String r12, String r13) {
        StringBuilder r14 = new StringBuilder(r5);
        r14.append(r10);
        r14.append(r11);
        r14.append(r12);
        r14.append(r13);
        return r14;
    }

    public static void z(int r5, Canvas r10, int r11, int r12) {
        InlineMarker.finallyStart(r5);
        r10.restoreToCount(r11);
        InlineMarker.finallyEnd(r12);
    }
}
