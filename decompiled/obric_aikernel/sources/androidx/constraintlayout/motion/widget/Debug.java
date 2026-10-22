package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm6.util.constant.NetConst;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"LogConditional"})
public class Debug {
    public Debug() {
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams r10, String r11) {
        StackTraceElement r12 = new Throwable().getStackTrace()[1];
        String r13 = ".(" + r12.getFileName() + ":" + r12.getLineNumber() + ") " + r11 + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + r13 + "  " + r10.getClass().getName());
        Field[] r14 = r10.getClass().getFields();
        int r15 = 0;
    L4:
        if (r15 >= r14.length) goto L14;
        Field r16 = r14[r15];
        Object r17 = r16.get(r10);     // Catch: IllegalAccessException -> L16
        String r18 = r16.getName();     // Catch: IllegalAccessException -> L16
        if (r18.contains("To") == false) goto L13;
        if (r17.toString().equals("-1") == true) goto L13;
        System.out.println(r13 + "       " + r18 + " " + r17);     // Catch: IllegalAccessException -> L16
    L13:
        r15 = r15 + 1;
        goto L4
    L14:
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + r13);
    }

    public static void dumpLayoutParams(ViewGroup r11, String r12) {
        StackTraceElement r10 = new Throwable().getStackTrace()[1];
        String r13 = ".(" + r10.getFileName() + ":" + r10.getLineNumber() + ") " + r12 + "  ";
        int r14 = r11.getChildCount();
        System.out.println(r12 + " children " + r14);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L17;
        View r16 = r11.getChildAt(r15);
        System.out.println(r13 + "     " + getName(r16));
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        Field[] r18 = r17.getClass().getFields();
        int r19 = 0;
    L6:
        if (r19 >= r18.length) goto L16;
        Field r20 = r18[r19];
        Object r21 = r20.get(r17);     // Catch: IllegalAccessException -> L18
        if (r20.getName().contains("To") == false) goto L15;
        if (r21.toString().equals("-1") == true) goto L15;
        System.out.println(r13 + "       " + r20.getName() + " " + r21);     // Catch: IllegalAccessException -> L18
    L15:
        r19 = r19 + 1;
        goto L6
    L16:
        r15 = r15 + 1;
        goto L3
    }

    public static void dumpPoc(Object r11) {
        StackTraceElement r10 = new Throwable().getStackTrace()[1];
        String r12 = ".(" + r10.getFileName() + ":" + r10.getLineNumber() + ")";
        Class<?> r13 = r11.getClass();
        System.out.println(r12 + "------------- " + r13.getName() + " --------------------");
        Field[] r14 = r13.getFields();
        int r15 = 0;
    L4:
        if (r15 >= r14.length) goto L31;
        Field r16 = r14[r15];
        Object r17 = r16.get(r11);     // Catch: IllegalAccessException -> L33
        if (r16.getName().startsWith("layout_constraint") == false) goto L30;
        if ((r17 instanceof Integer) == false) goto L15;
        if (r17.toString().equals("-1") == true) goto L30;
    L15:
        if ((r17 instanceof Integer) == false) goto L20;
        if (r17.toString().equals(NetConst.NOT_ENCRYPT_VERISON_CODE) == true) goto L30;
    L20:
        if ((r17 instanceof Float) == false) goto L25;
        if (r17.toString().equals("1.0") == true) goto L30;
    L25:
        if ((r17 instanceof Float) == true) goto L27;
    L29:
        System.out.println(r12 + "    " + r16.getName() + " " + r17);     // Catch: IllegalAccessException -> L33
        goto L30
    L27:
        if (r17.toString().equals("0.5") == false) goto L29;
    L30:
        r15 = r15 + 1;
        goto L4
    L31:
        System.out.println(r12 + "------------- " + r13.getSimpleName() + " --------------------");
    }

    public static String getActionType(MotionEvent r10) {
        int r11 = r10.getAction();
        Field[] r12 = MotionEvent.class.getFields();
        int r13 = 0;
    L4:
        if (r13 >= r12.length) goto L15;
        Field r14 = r12[r13];
        if (Modifier.isStatic(r14.getModifiers()) == false) goto L14;
        if (r14.getType().equals(Integer.TYPE) == false) goto L14;
        if (r14.getInt(null) != r11) goto L14;
        return r14.getName();
    L14:
        r13 = r13 + 1;
        goto L4
    L15:
        return "---";
    }

    public static String getCallFrom(int r10) {
        StackTraceElement r11 = new Throwable().getStackTrace()[r10 + 2];
        return ".(" + r11.getFileName() + ":" + r11.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement r10 = new Throwable().getStackTrace()[1];
        return ".(" + r10.getFileName() + ":" + r10.getLineNumber() + ") " + r10.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement r10 = new Throwable().getStackTrace()[1];
        return ".(" + r10.getFileName() + ":" + r10.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement r10 = new Throwable().getStackTrace()[2];
        return ".(" + r10.getFileName() + ":" + r10.getLineNumber() + ")";
    }

    public static String getName(Context r10, int r11) {
        if (r11 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return r10.getResources().getResourceEntryName(r11);
    L9:
        return "?" + r11;
    }

    public static String getName(Context r10, int[] r11) {
        String r12 = r11.length + "[";     // Catch: Exception -> L17
        int r13 = 0;
    L4:
        if (r13 >= r11.length) goto L15;
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L17
        r14.append(r12);     // Catch: Exception -> L17
        if (r13 != 0) goto L9;
        String r15 = "";
    L10:
        r14.append(r15);     // Catch: Exception -> L17
        String r16 = r14.toString();     // Catch: Exception -> L17
        String r17 = r10.getResources().getResourceEntryName(r11[r13]);     // Catch: Resources.NotFoundException -> L13 Exception -> L17
    L14:
        r12 = r16 + r17;     // Catch: Exception -> L17
        r13 = r13 + 1;     // Catch: Exception -> L17
    L13:
        r17 = "? " + r11[r13] + " ";     // Catch: Exception -> L17
        goto L14
    L9:
        r15 = " ";
        goto L10
    L15:
        return r12 + "]";
    L17:
        e = move-exception;
        Log.v("DEBUG", e.toString());
        return "UNKNOWN";
    }

    public static String getName(View r10) {
        return r10.getContext().getResources().getResourceEntryName(r10.getId());
    L4:
        return "UNKNOWN";
    }

    public static String getState(MotionLayout r10, int r11) {
        return getState(r10, r11, -1);
    }

    public static String getState(MotionLayout r10, int r11, int r12) {
        if (r11 != (-1)) goto L6;
        return "UNDEFINED";
    L6:
        String r13 = r10.getContext().getResources().getResourceEntryName(r11);
        if (r12 != (-1)) goto L9;
        return r13;
    L9:
        if (r13.length() <= r12) goto L12;
        r13 = r13.replaceAll("([^_])[aeiou]+", "$1");
    L12:
        if (r13.length() <= r12) goto L18;
        int r14 = r13.replaceAll("[^_]", "").length();
        if (r14 > 0) goto L16;
        return r13;
    L16:
        return r13.replaceAll(CharBuffer.allocate((r13.length() - r12) / r14).toString().replace(0, '.') + "_", "_");
    L18:
        return r13;
    }

    public static void logStack(String r10, String r11, int r12) {
        StackTraceElement[] r13 = new Throwable().getStackTrace();
        int r14 = 1;
        int r15 = Math.min(r12, r13.length - 1);
        String r16 = " ";
    L3:
        if (r14 > r15) goto L5;
        StackTraceElement r17 = r13[r14];
        r16 = r16 + " ";
        Log.v(r10, r11 + r16 + (".(" + r13[r14].getFileName() + ":" + r13[r14].getLineNumber() + ") " + r13[r14].getMethodName()) + r16);
        r14 = r14 + 1;
        goto L3
    }

    public static void printStack(String r10, int r11) {
        StackTraceElement[] r12 = new Throwable().getStackTrace();
        int r13 = 1;
        int r14 = Math.min(r11, r12.length - 1);
        String r15 = " ";
    L3:
        if (r13 > r14) goto L5;
        StackTraceElement r16 = r12[r13];
        String r17 = ".(" + r12[r13].getFileName() + ":" + r12[r13].getLineNumber() + ") ";
        r15 = r15 + " ";
        System.out.println(r10 + r15 + r17 + r15);
        r13 = r13 + 1;
        goto L3
    }
}
