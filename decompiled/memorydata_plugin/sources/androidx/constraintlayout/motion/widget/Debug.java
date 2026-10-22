package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes.dex */
public class Debug {
    public Debug() {
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams r7, String r8) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r9 = ".(" + r0.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.getLineNumber() + ") " + r8 + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + r9 + "  " + r7.getClass().getName());
        Field[] r1 = r7.getClass().getFields();
        int r2 = 0;
    L4:
        if (r2 >= r1.length) goto L14;
        Field r3 = r1[r2];
        Object r4 = r3.get(r7);     // Catch: IllegalAccessException -> L16
        String r5 = r3.getName();     // Catch: IllegalAccessException -> L16
        if (r5.contains("To") == false) goto L13;
        if (r4.toString().equals(StructuredDataId.RESERVED) == true) goto L13;
        System.out.println(r9 + "       " + r5 + " " + r4);     // Catch: IllegalAccessException -> L16
    L13:
        r2 = r2 + 1;
        goto L4
    L14:
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + r9);
    }

    public static void dumpLayoutParams(ViewGroup r11, String r12) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.getLineNumber() + ") " + r12 + "  ";
        int r2 = r11.getChildCount();
        System.out.println(r12 + " children " + r2);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L17;
        View r4 = r11.getChildAt(r3);
        System.out.println(r1 + "     " + getName(r4));
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Field[] r6 = r5.getClass().getFields();
        int r7 = 0;
    L6:
        if (r7 >= r6.length) goto L16;
        Field r8 = r6[r7];
        Object r9 = r8.get(r5);     // Catch: IllegalAccessException -> L18
        if (r8.getName().contains("To") == false) goto L15;
        if (r9.toString().equals(StructuredDataId.RESERVED) == true) goto L15;
        System.out.println(r1 + "       " + r8.getName() + " " + r9);     // Catch: IllegalAccessException -> L18
    L15:
        r7 = r7 + 1;
        goto L6
    L16:
        r3 = r3 + 1;
        goto L3
    }

    public static void dumpPoc(Object r11) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.getLineNumber() + ")";
        Class<?> r2 = r11.getClass();
        System.out.println(r1 + "------------- " + r2.getName() + " --------------------");
        Field[] r3 = r2.getFields();
        int r4 = 0;
    L4:
        if (r4 >= r3.length) goto L31;
        Field r6 = r3[r4];
        Object r7 = r6.get(r11);     // Catch: IllegalAccessException -> L33
        if (r6.getName().startsWith("layout_constraint") == false) goto L30;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L15;
        if (r7.toString().equals(StructuredDataId.RESERVED) == true) goto L30;
    L15:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L20;
        if (r7.toString().equals("0") == true) goto L30;
    L20:
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L25;
        if (r7.toString().equals("1.0") == true) goto L30;
    L25:
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == true) goto L27;
    L29:
        System.out.println(r1 + "    " + r6.getName() + " " + r7);     // Catch: IllegalAccessException -> L33
        goto L30
    L27:
        if (r7.toString().equals("0.5") == false) goto L29;
    L30:
        r4 = r4 + 1;
        goto L4
    L31:
        System.out.println(r1 + "------------- " + r2.getSimpleName() + " --------------------");
    }

    public static String getActionType(MotionEvent r5) {
        int r6 = r5.getAction();
        Field[] r0 = MotionEvent.class.getFields();
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L15;
        Field r2 = r0[r1];
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L14;
        if (r2.getType().equals(Integer.TYPE) == false) goto L14;
        if (r2.getInt(null) != r6) goto L14;
        return r2.getName();
    L14:
        r1 = r1 + 1;
        goto L4
    L15:
        return "---";
    }

    public static String getCallFrom(int r2) {
        StackTraceElement r3 = new Throwable().getStackTrace()[r2 + 2];
        return ".(" + r3.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r3.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.getLineNumber() + ") " + r0.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement r0 = new Throwable().getStackTrace()[2];
        return ".(" + r0.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.getLineNumber() + ")";
    }

    public static String getName(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceEntryName(r3);
    L9:
        return "?" + r3;
    }

    public static String getName(Context r6, int[] r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        String r0 = r7.length + "[";     // Catch: Exception -> L18
        int r2 = 0;
    L5:
        if (r2 >= r7.length) goto L16;
        StringBuilder r1 = new StringBuilder().append(r0);     // Catch: Exception -> L18
        if (r2 != 0) goto L10;
        String r4 = "";
    L11:
        String r3 = r1.append(r4).toString();     // Catch: Exception -> L18
        String r5 = ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getResourceEntryName(r7[r2]);     // Catch: Resources.NotFoundException -> L14 Exception -> L18
    L15:
        r0 = r3 + r5;     // Catch: Exception -> L18
        r2 = r2 + 1;     // Catch: Exception -> L18
    L14:
        r5 = "? " + r7[r2] + " ";     // Catch: Exception -> L18
        goto L15
    L10:
        r4 = " ";
        goto L11
    L16:
        return r0 + "]";
    L18:
        e = move-exception;
        Log.v(CipherConst.LEVEL_DEBUG, e.toString());
        return "UNKNOWN";
    }

    public static String getName(View r3) {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r3.getId());
    L5:
        return "UNKNOWN";
    }

    public static String getState(MotionLayout r1, int r2) {
        return getState(r1, r2, -1);
    }

    public static String getState(MotionLayout r3, int r4, int r5) {
        if (r4 != (-1)) goto L6;
        return "UNDEFINED";
    L6:
        String r6 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r4);
        if (r5 != (-1)) goto L9;
        return r6;
    L9:
        if (r6.length() <= r5) goto L12;
        r6 = r6.replaceAll("([^_])[aeiou]+", "$1");
    L12:
        if (r6.length() <= r5) goto L18;
        int r7 = r6.replaceAll("[^_]", "").length();
        if (r7 > 0) goto L16;
        return r6;
    L16:
        return r6.replaceAll(CharBuffer.allocate((r6.length() - r5) / r7).toString().replace(0, '.') + "_", "_");
    L18:
        return r6;
    }

    public static void logStack(String r6, String r7, int r8) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r9 = Math.min(r8, r0.length - 1);
        String r3 = " ";
    L3:
        if (r2 > r9) goto L5;
        StackTraceElement r4 = r0[r2];
        r3 = r3 + " ";
        Log.v(r6, r7 + r3 + (".(" + r0[r2].getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0[r2].getLineNumber() + ") " + r0[r2].getMethodName()) + r3);
        r2 = r2 + 1;
        goto L3
    }

    public static void printStack(String r7, int r8) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r9 = Math.min(r8, r0.length - 1);
        String r3 = " ";
    L3:
        if (r2 > r9) goto L5;
        StackTraceElement r4 = r0[r2];
        r3 = r3 + " ";
        System.out.println(r7 + r3 + (".(" + r0[r2].getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0[r2].getLineNumber() + ") ") + r3);
        r2 = r2 + 1;
        goto L3
    }
}
