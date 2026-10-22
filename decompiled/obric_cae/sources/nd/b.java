package nd;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static void a(Bundle r8, StringBuilder r10) {
        Iterator<String> r11 = r8.keySet().iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L47;
        String r13 = r11.next();
        if (r12 == true) goto L8;
        r10.append(", ");
    L8:
        r10.append(r13);
        r10.append('=');
        Object r14 = r8.get(r13);
        if ((r14 instanceof int[]) == false) goto L12;
        String r15 = Arrays.toString((int[]) r14);
    L44:
        r10.append(r15);
    L46:
        r12 = false;
        goto L4
    L12:
        if ((r14 instanceof byte[]) == false) goto L18;
        byte[] r16 = (byte[]) r14;
        if (r16.length >= 102400) goto L16;
        r15 = Arrays.toString(r16);
        goto L44
    L16:
        r15 = "byte[] in Bundle is too long, limit for 100K";
        goto L44
    L18:
        if ((r14 instanceof boolean[]) == false) goto L21;
        r15 = Arrays.toString((boolean[]) r14);
        goto L44
    L21:
        if ((r14 instanceof short[]) == false) goto L24;
        r15 = Arrays.toString((short[]) r14);
        goto L44
    L24:
        if ((r14 instanceof long[]) == false) goto L27;
        r15 = Arrays.toString((long[]) r14);
        goto L44
    L27:
        if ((r14 instanceof float[]) == false) goto L30;
        r15 = Arrays.toString((float[]) r14);
        goto L44
    L30:
        if ((r14 instanceof double[]) == false) goto L33;
        r15 = Arrays.toString((double[]) r14);
        goto L44
    L33:
        if ((r14 instanceof String[]) == false) goto L36;
        r15 = Arrays.toString((String[]) r14);
        goto L44
    L36:
        if ((r14 instanceof CharSequence[]) == false) goto L39;
        r15 = Arrays.toString((CharSequence[]) r14);
        goto L44
    L39:
        if ((r14 instanceof Parcelable[]) == false) goto L42;
        r15 = Arrays.toString((Parcelable[]) r14);
        goto L44
    L42:
        if ((r14 instanceof Bundle) == false) goto L45;
        r15 = b((Bundle) r14);
        goto L44
    L45:
        r10.append(r14);
        goto L46
    }

    public static String b(Bundle r8) {
        if (r8 != null) goto L5;
        return "null";
    L5:
        StringBuilder r10 = new StringBuilder(128);
        r10.append("Bundle[{");
        a(r8, r10);
        r10.append("}]");
        return r10.toString();
    }

    public static void c(Intent r8, StringBuilder r10) {
        String r11 = r8.getAction();
        boolean r12 = false;
        if (r11 == null) goto L5;
        r10.append("act=");
        r10.append(r11);
        boolean r13 = false;
    L6:
        Set<String> r14 = r8.getCategories();
        if (r14 == null) goto L18;
        if (r13 == true) goto L10;
        r10.append(' ');
    L10:
        r10.append("cat=[");
        Iterator<String> r15 = r14.iterator();
        boolean r16 = true;
    L12:
        if (r15.hasNext() == false) goto L17;
        String r17 = r15.next();
        if (r16 == true) goto L16;
        r10.append(',');
    L16:
        r10.append(r17);
        r16 = false;
        goto L12
    L17:
        r10.append("]");
        r13 = false;
    L18:
        Uri r18 = r8.getData();
        if (r18 == null) goto L33;
        if (r13 == true) goto L22;
        r10.append(' ');
    L22:
        r10.append("dat=");
        Method r19 = Uri.class.getDeclaredMethod("toSafeString", new Class[0]);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
        r19.setAccessible(true);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
        String r20 = (String) r19.invoke(r18, new Object[0]);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
    L32:
        r10.append(r20);
        r13 = false;
        goto L33
    L25:
        e = move-exception;
        e.printStackTrace();
    L31:
        r20 = r18.toString();
    L29:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        e.printStackTrace();
    L33:
        String r21 = r8.getType();
        if (r21 == null) goto L38;
        if (r13 == true) goto L37;
        r10.append(' ');
    L37:
        r10.append("typ=");
        r10.append(r21);
        r13 = false;
    L38:
        int r22 = r8.getFlags();
        if (r22 == 0) goto L43;
        if (r13 == true) goto L42;
        r10.append(' ');
    L42:
        r10.append("flg=0x");
        r10.append(Integer.toHexString(r22));
        r13 = false;
    L43:
        String r23 = r8.getPackage();
        if (r23 == null) goto L48;
        if (r13 == true) goto L47;
        r10.append(' ');
    L47:
        r10.append("pkg=");
        r10.append(r23);
        r13 = false;
    L48:
        ComponentName r24 = r8.getComponent();
        if (r24 == null) goto L53;
        if (r13 == true) goto L52;
        r10.append(' ');
    L52:
        r10.append("cmp=");
        r10.append(r24.flattenToShortString());
        r13 = false;
    L53:
        Rect r25 = r8.getSourceBounds();
        if (r25 == null) goto L59;
        if (r13 == true) goto L57;
        r10.append(' ');
    L57:
        r10.append("bnds=");
        r10.append(r25.toShortString());
        r13 = false;
    L59:
        if (r8.getClipData() == null) goto L63;
        if (r13 == true) goto L62;
        r10.append(' ');
    L62:
        r10.append("(has clip)");
    L64:
        Bundle r26 = r8.getExtras();
        if (r26 == null) goto L69;
        if (r12 == true) goto L68;
        r10.append(' ');
    L68:
        r10.append("extras={");
        a(r26, r10);
        r10.append('}');
    L69:
        Intent r27 = r8.getSelector();
        if (r27 == null) goto L78;
        r10.append(" sel=");
        c(r27, r10);
        r10.append("}");
        return;
    L78:
        return;
    L63:
        r12 = r13;
        goto L64
    L5:
        r13 = true;
        goto L6
    }
}
