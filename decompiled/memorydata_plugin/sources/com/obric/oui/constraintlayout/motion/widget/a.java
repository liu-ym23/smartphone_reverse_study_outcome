package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.CharBuffer;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static String a() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.getLineNumber() + ")";
    }

    public static String a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceEntryName(r3);
    L9:
        return "?" + r3;
    }

    public static String a(View r3) {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r3.getId());
    L5:
        return "UNKNOWN";
    }

    public static String a(MotionLayout r1, int r2) {
        return a(r1, r2, -1);
    }

    public static String a(MotionLayout r3, int r4, int r5) {
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

    public static void a(String r6, String r7, int r8) {
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

    public static String b() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.getLineNumber() + ") " + r0.getMethodName() + "()";
    }
}
