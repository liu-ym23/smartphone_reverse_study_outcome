package com.ss.android.agilelogger.utils;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static String a(Intent r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("Intent { ");
        a(r2, r0);
        r0.append(" }");
        return r0.toString();
    }

    private static String a(Uri r4) {
        if (Build.VERSION.SDK_INT < 14) goto L13;
        Method r0 = Uri.class.getDeclaredMethod("toSafeString", new Class[0]);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L10
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L10
        return (String) ZeusTransformUtils.preCheckCast(r0.invoke(r4, new Object[0]), String.class, "com.obric.memorydata.plugin");
    L6:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r4.toString();
    }

    public static String a(Bundle r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("Bundle[{");
        a(r2, r0);
        r0.append("}]");
        return r0.toString();
    }

    private static void a(Intent r7, StringBuilder r8) {
        String r0 = r7.getAction();
        boolean r1 = true;
        boolean r2 = false;
        if (r0 == null) goto L5;
        r8.append("act=").append(r0);
        boolean r3 = false;
    L6:
        Set<String> r4 = r7.getCategories();
        if (r4 == null) goto L18;
        if (r3 == true) goto L10;
        r8.append(' ');
    L10:
        r8.append("cat=[");
        Iterator<String> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (r1 == true) goto L16;
        r8.append(',');
    L16:
        r8.append(r6);
        r1 = false;
        goto L12
    L17:
        r8.append("]");
        r3 = false;
    L18:
        Uri r9 = r7.getData();
        if (r9 == null) goto L36;
        if (r3 == true) goto L22;
        r8.append(' ');
    L22:
        r8.append("dat=");
        if (Build.VERSION.SDK_INT < 14) goto L26;
        String r10 = a(r9);
    L25:
        r8.append(r10);
    L35:
        r3 = false;
        goto L36
    L26:
        String r11 = r9.getScheme();
        if (r11 != null) goto L29;
    L34:
        r8.append(r9);
        goto L35
    L29:
        if (r11.equalsIgnoreCase("tel") == false) goto L32;
        r10 = "tel:xxx-xxx-xxxx";
        goto L25
    L32:
        if (r11.equalsIgnoreCase("smsto") == false) goto L34;
        r10 = "smsto:xxx-xxx-xxxx";
    L36:
        String r12 = r7.getType();
        if (r12 == null) goto L41;
        if (r3 == true) goto L40;
        r8.append(' ');
    L40:
        r8.append("typ=").append(r12);
        r3 = false;
    L41:
        int r13 = r7.getFlags();
        if (r13 == 0) goto L46;
        if (r3 == true) goto L45;
        r8.append(' ');
    L45:
        r8.append("flg=0x").append(Integer.toHexString(r13));
        r3 = false;
    L46:
        String r14 = r7.getPackage();
        if (r14 == null) goto L51;
        if (r3 == true) goto L50;
        r8.append(' ');
    L50:
        r8.append("pkg=").append(r14);
        r3 = false;
    L51:
        ComponentName r15 = r7.getComponent();
        if (r15 == null) goto L56;
        if (r3 == true) goto L55;
        r8.append(' ');
    L55:
        r8.append("cmp=").append(r15.flattenToShortString());
        r3 = false;
    L56:
        Rect r16 = r7.getSourceBounds();
        if (r16 == null) goto L62;
        if (r3 == true) goto L60;
        r8.append(' ');
    L60:
        r8.append("bnds=").append(r16.toShortString());
        r3 = false;
    L62:
        if (Build.VERSION.SDK_INT >= 16) goto L64;
    L68:
        r2 = r3;
    L69:
        Bundle r17 = r7.getExtras();
        if (r17 == null) goto L75;
        if (r2 == true) goto L73;
        r8.append(' ');
    L73:
        r8.append("extras={");
        a(r17, r8);
        r8.append('}');
    L75:
        if (Build.VERSION.SDK_INT < 15) goto L83;
        Intent r18 = r7.getSelector();
        if (r18 == null) goto L84;
        r8.append(" sel=");
        a(r18, r8);
        r8.append("}");
        return;
    L84:
        return;
    L83:
        return;
    L64:
        if (r7.getClipData() == null) goto L68;
        if (r3 == true) goto L67;
        r8.append(' ');
    L67:
        r8.append("(has clip)");
        goto L69
    L5:
        r3 = true;
        goto L6
    }

    private static void a(Bundle r12, StringBuilder r13) {
        Iterator<String> r7 = r12.keySet().iterator();
        boolean r8 = true;
    L4:
        if (r7.hasNext() == false) goto L47;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (r8 == true) goto L8;
        r13.append(", ");
    L8:
        r13.append(r9).append('=');
        Object r10 = r12.get(r9);
        if ((r10 instanceof int[]) == false) goto L13;
        String r11 = Arrays.toString((int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r10, int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin"));
    L11:
        r13.append(r11);
    L46:
        r8 = false;
        goto L4
    L13:
        if ((r10 instanceof byte[]) == false) goto L19;
        if (((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r10, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")).length >= 102400) goto L17;
        r11 = Arrays.toString((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r10, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
        goto L11
    L17:
        r11 = "byte[] in Bundle is too long, limit for 100K";
        goto L11
    L19:
        if ((r10 instanceof boolean[]) == false) goto L22;
        r11 = Arrays.toString((boolean[]) ZeusTransformUtils.preCheckCast((boolean[]) ZeusTransformUtils.preCheckCast(r10, boolean[].class, "com.obric.memorydata.plugin"), boolean[].class, "com.obric.memorydata.plugin"));
        goto L11
    L22:
        if ((r10 instanceof short[]) == false) goto L25;
        r11 = Arrays.toString((short[]) ZeusTransformUtils.preCheckCast((short[]) ZeusTransformUtils.preCheckCast(r10, short[].class, "com.obric.memorydata.plugin"), short[].class, "com.obric.memorydata.plugin"));
        goto L11
    L25:
        if ((r10 instanceof long[]) == false) goto L28;
        r11 = Arrays.toString((long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r10, long[].class, "com.obric.memorydata.plugin"), long[].class, "com.obric.memorydata.plugin"));
        goto L11
    L28:
        if ((r10 instanceof float[]) == false) goto L31;
        r11 = Arrays.toString((float[]) ZeusTransformUtils.preCheckCast((float[]) ZeusTransformUtils.preCheckCast(r10, float[].class, "com.obric.memorydata.plugin"), float[].class, "com.obric.memorydata.plugin"));
        goto L11
    L31:
        if ((r10 instanceof double[]) == false) goto L34;
        r11 = Arrays.toString((double[]) ZeusTransformUtils.preCheckCast((double[]) ZeusTransformUtils.preCheckCast(r10, double[].class, "com.obric.memorydata.plugin"), double[].class, "com.obric.memorydata.plugin"));
        goto L11
    L34:
        if ((r10 instanceof String[]) == false) goto L37;
        r11 = Arrays.toString((String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r10, String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin"));
        goto L11
    L37:
        if ((r10 instanceof CharSequence[]) == false) goto L40;
        r11 = Arrays.toString((CharSequence[]) ZeusTransformUtils.preCheckCast((CharSequence[]) ZeusTransformUtils.preCheckCast(r10, CharSequence[].class, "com.obric.memorydata.plugin"), CharSequence[].class, "com.obric.memorydata.plugin"));
        goto L11
    L40:
        if ((r10 instanceof Parcelable[]) == false) goto L43;
        r11 = Arrays.toString((Parcelable[]) ZeusTransformUtils.preCheckCast((Parcelable[]) ZeusTransformUtils.preCheckCast(r10, Parcelable[].class, "com.obric.memorydata.plugin"), Parcelable[].class, "com.obric.memorydata.plugin"));
        goto L11
    L43:
        if (ZeusTransformUtils.instanceOf(r10, Bundle.class) == false) goto L45;
        r11 = a((Bundle) ZeusTransformUtils.preCheckCast(r10, Bundle.class, "com.obric.memorydata.plugin"));
        goto L11
    L45:
        r13.append(r10);
        goto L46
    }
}
