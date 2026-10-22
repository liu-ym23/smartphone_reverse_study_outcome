package androidx.constraintlayout.motion.widget;

import ai.j0;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class Debug {
    public Debug() {
    }

    public static void dumpLayoutParams(ViewGroup r11, String r12) {
        StackTraceElement r5 = new Throwable().getStackTrace()[1];
        String r10 = ".(" + r5.getFileName() + ":" + r5.getLineNumber() + ") " + r12 + "  ";
        int r13 = r11.getChildCount();
        System.out.println(r12 + " children " + r13);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L17;
        View r15 = r11.getChildAt(r14);
        PrintStream r16 = System.out;
        StringBuilder r17 = j0.w(r10, "     ");
        r17.append(getName(r15));
        r16.println(r17.toString());
        ViewGroup.LayoutParams r18 = r15.getLayoutParams();
        Field[] r19 = r18.getClass().getFields();
        int r20 = 0;
    L6:
        if (r20 >= r19.length) goto L16;
        Field r21 = r19[r20];
        Object r22 = r21.get(r18);     // Catch: IllegalAccessException -> L18
        if (r21.getName().contains("To") == false) goto L15;
        if (r22.toString().equals("-1") == true) goto L15;
        System.out.println(r10 + "       " + r21.getName() + " " + r22);     // Catch: IllegalAccessException -> L18
    L15:
        r20 = r20 + 1;
        goto L6
    L16:
        r14 = r14 + 1;
        goto L3
    }

    public static void dumpPoc(Object r11) {
        StackTraceElement r5 = new Throwable().getStackTrace()[1];
        String r10 = ".(" + r5.getFileName() + ":" + r5.getLineNumber() + ")";
        Class<?> r12 = r11.getClass();
        PrintStream r13 = System.out;
        StringBuilder r14 = j0.w(r10, "------------- ");
        r14.append(r12.getName());
        r14.append(" --------------------");
        r13.println(r14.toString());
        Field[] r15 = r12.getFields();
        int r16 = 0;
    L4:
        if (r16 >= r15.length) goto L31;
        Field r17 = r15[r16];
        Object r18 = r17.get(r11);     // Catch: IllegalAccessException -> L33
        if (r17.getName().startsWith("layout_constraint") == false) goto L30;
        if ((r18 instanceof Integer) == false) goto L15;
        if (r18.toString().equals("-1") == true) goto L30;
    L15:
        if ((r18 instanceof Integer) == false) goto L20;
        if (r18.toString().equals("0") == true) goto L30;
    L20:
        if ((r18 instanceof Float) == false) goto L25;
        if (r18.toString().equals("1.0") == true) goto L30;
    L25:
        if ((r18 instanceof Float) == true) goto L27;
    L29:
        System.out.println(r10 + "    " + r17.getName() + " " + r18);     // Catch: IllegalAccessException -> L33
        goto L30
    L27:
        if (r18.toString().equals("0.5") == false) goto L29;
    L30:
        r16 = r16 + 1;
        goto L4
    L31:
        PrintStream r19 = System.out;
        StringBuilder r20 = j0.w(r10, "------------- ");
        r20.append(r12.getSimpleName());
        r20.append(" --------------------");
        r19.println(r20.toString());
    }

    public static String getActionType(MotionEvent r5) {
        int r10 = r5.getAction();
        Field[] r11 = MotionEvent.class.getFields();
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L15;
        Field r13 = r11[r12];
        if (Modifier.isStatic(r13.getModifiers()) == false) goto L14;
        if (r13.getType().equals(Integer.TYPE) == false) goto L14;
        if (r13.getInt(null) != r10) goto L14;
        return r13.getName();
    L14:
        r12 = r12 + 1;
        goto L4
    L15:
        return "---";
    }

    public static String getCallFrom(int r5) {
        StackTraceElement r10 = new Throwable().getStackTrace()[r5 + 2];
        return ".(" + r10.getFileName() + ":" + r10.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement r5 = new Throwable().getStackTrace()[1];
        return ".(" + r5.getFileName() + ":" + r5.getLineNumber() + ") " + r5.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement r5 = new Throwable().getStackTrace()[1];
        return ".(" + r5.getFileName() + ":" + r5.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement r5 = new Throwable().getStackTrace()[2];
        return ".(" + r5.getFileName() + ":" + r5.getLineNumber() + ")";
    }

    public static String getName(View r5) {
        return r5.getContext().getResources().getResourceEntryName(r5.getId());
    L4:
        return "UNKNOWN";
    }

    public static String getState(MotionLayout r5, int r10) {
        if (r10 != (-1)) goto L7;
        return "UNDEFINED";
    L7:
        return r5.getContext().getResources().getResourceEntryName(r10);
    }

    public static void logStack(String r10, String r11, int r12) {
        StackTraceElement[] r5 = new Throwable().getStackTrace();
        int r13 = 1;
        int r14 = Math.min(r12, r5.length - 1);
        String r15 = " ";
    L3:
        if (r13 > r14) goto L5;
        StackTraceElement r16 = r5[r13];
        String r17 = ".(" + r5[r13].getFileName() + ":" + r5[r13].getLineNumber() + ") " + r5[r13].getMethodName();
        r15 = j0.j(r15, " ");
        Log.v(r10, r11 + r15 + r17 + r15);
        r13 = r13 + 1;
        goto L3
    }

    public static void printStack(String r10, int r11) {
        StackTraceElement[] r5 = new Throwable().getStackTrace();
        int r12 = 1;
        int r13 = Math.min(r11, r5.length - 1);
        String r14 = " ";
    L3:
        if (r12 > r13) goto L5;
        StackTraceElement r15 = r5[r12];
        String r16 = ".(" + r5[r12].getFileName() + ":" + r5[r12].getLineNumber() + ") ";
        r14 = j0.j(r14, " ");
        System.out.println(r10 + r14 + r16 + r14);
        r12 = r12 + 1;
        goto L3
    }

    public static String getName(Context r5, int r10) {
        if (r10 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return r5.getResources().getResourceEntryName(r10);
    L9:
        return j0.g(r10, "?");
    }

    public static String getName(Context r5, int[] r10) {
        String r11 = r10.length + "[";     // Catch: Exception -> L9
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L17;
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L9
        r13.append(r11);     // Catch: Exception -> L9
        if (r12 != 0) goto L11;
        String r14 = "";
    L12:
        r13.append(r14);     // Catch: Exception -> L9
        String r15 = r13.toString();     // Catch: Exception -> L9
        String r16 = r5.getResources().getResourceEntryName(r10[r12]);     // Catch: Exception -> L9 Resources.NotFoundException -> L15
    L16:
        r11 = r15 + r16;     // Catch: Exception -> L9
        r12 = r12 + 1;     // Catch: Exception -> L9
    L15:
        r16 = "? " + r10[r12] + " ";     // Catch: Exception -> L9
        goto L16
    L11:
        r14 = " ";
        goto L12
    L17:
        return r11 + "]";
    L9:
        e = move-exception;
        Log.v("DEBUG", e.toString());
        return "UNKNOWN";
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams r10, String r11) {
        StackTraceElement r5 = new Throwable().getStackTrace()[1];
        String r12 = ".(" + r5.getFileName() + ":" + r5.getLineNumber() + ") " + r11 + "  ";
        PrintStream r13 = System.out;
        StringBuilder r14 = j0.x(" >>>>>>>>>>>>>>>>>>. dump ", r12, "  ");
        r14.append(r10.getClass().getName());
        r13.println(r14.toString());
        Field[] r15 = r10.getClass().getFields();
        int r16 = 0;
    L4:
        if (r16 >= r15.length) goto L14;
        Field r17 = r15[r16];
        Object r18 = r17.get(r10);     // Catch: IllegalAccessException -> L16
        String r19 = r17.getName();     // Catch: IllegalAccessException -> L16
        if (r19.contains("To") == false) goto L13;
        if (r18.toString().equals("-1") == true) goto L13;
        System.out.println(r12 + "       " + r19 + " " + r18);     // Catch: IllegalAccessException -> L16
    L13:
        r16 = r16 + 1;
        goto L4
    L14:
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + r12);
    }
}
