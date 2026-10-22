package xa;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static void a(Bundle r10, StringBuilder r11) {
        Iterator<String> r12 = r10.keySet().iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L47;
        String r14 = r12.next();
        if (r13 == true) goto L8;
        r11.append(", ");
    L8:
        r11.append(r14);
        r11.append('=');
        Object r15 = r10.get(r14);
        if ((r15 instanceof int[]) == false) goto L13;
        String r16 = Arrays.toString((int[]) r15);
    L11:
        r11.append(r16);
    L46:
        r13 = false;
        goto L4
    L13:
        if ((r15 instanceof byte[]) == false) goto L19;
        byte[] r17 = (byte[]) r15;
        if (r17.length >= 102400) goto L17;
        r16 = Arrays.toString(r17);
        goto L11
    L17:
        r16 = "byte[] in Bundle is too long, limit for 100K";
        goto L11
    L19:
        if ((r15 instanceof boolean[]) == false) goto L22;
        r16 = Arrays.toString((boolean[]) r15);
        goto L11
    L22:
        if ((r15 instanceof short[]) == false) goto L25;
        r16 = Arrays.toString((short[]) r15);
        goto L11
    L25:
        if ((r15 instanceof long[]) == false) goto L28;
        r16 = Arrays.toString((long[]) r15);
        goto L11
    L28:
        if ((r15 instanceof float[]) == false) goto L31;
        r16 = Arrays.toString((float[]) r15);
        goto L11
    L31:
        if ((r15 instanceof double[]) == false) goto L34;
        r16 = Arrays.toString((double[]) r15);
        goto L11
    L34:
        if ((r15 instanceof String[]) == false) goto L37;
        r16 = Arrays.toString((String[]) r15);
        goto L11
    L37:
        if ((r15 instanceof CharSequence[]) == false) goto L40;
        r16 = Arrays.toString((CharSequence[]) r15);
        goto L11
    L40:
        if ((r15 instanceof Parcelable[]) == false) goto L43;
        r16 = Arrays.toString((Parcelable[]) r15);
        goto L11
    L43:
        if ((r15 instanceof Bundle) == false) goto L45;
        r16 = b((Bundle) r15);
        goto L11
    L45:
        r11.append(r15);
        goto L46
    }

    public static String b(Bundle r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        StringBuilder r11 = new StringBuilder(128);
        r11.append("Bundle[{");
        a(r10, r11);
        r11.append("}]");
        return r11.toString();
    }

    private static void c(Intent r10, StringBuilder r11) {
        String r12 = r10.getAction();
        boolean r13 = true;
        boolean r14 = false;
        if (r12 == null) goto L5;
        r11.append("act=");
        r11.append(r12);
        boolean r15 = false;
    L6:
        Set<String> r16 = r10.getCategories();
        if (r16 == null) goto L18;
        if (r15 == true) goto L10;
        r11.append(' ');
    L10:
        r11.append("cat=[");
        Iterator<String> r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L17;
        String r18 = r17.next();
        if (r13 == true) goto L16;
        r11.append(',');
    L16:
        r11.append(r18);
        r13 = false;
        goto L12
    L17:
        r11.append("]");
        r15 = false;
    L18:
        Uri r19 = r10.getData();
        if (r19 == null) goto L36;
        if (r15 == true) goto L22;
        r11.append(' ');
    L22:
        r11.append("dat=");
        if (Build.VERSION.SDK_INT < 14) goto L26;
        String r20 = e(r19);
    L25:
        r11.append(r20);
    L35:
        r15 = false;
        goto L36
    L26:
        String r21 = r19.getScheme();
        if (r21 != null) goto L29;
    L34:
        r11.append(r19);
        goto L35
    L29:
        if (r21.equalsIgnoreCase("tel") == false) goto L32;
        r20 = "tel:xxx-xxx-xxxx";
        goto L25
    L32:
        if (r21.equalsIgnoreCase("smsto") == false) goto L34;
        r20 = "smsto:xxx-xxx-xxxx";
    L36:
        String r22 = r10.getType();
        if (r22 == null) goto L41;
        if (r15 == true) goto L40;
        r11.append(' ');
    L40:
        r11.append("typ=");
        r11.append(r22);
        r15 = false;
    L41:
        int r23 = r10.getFlags();
        if (r23 == 0) goto L46;
        if (r15 == true) goto L45;
        r11.append(' ');
    L45:
        r11.append("flg=0x");
        r11.append(Integer.toHexString(r23));
        r15 = false;
    L46:
        String r24 = r10.getPackage();
        if (r24 == null) goto L51;
        if (r15 == true) goto L50;
        r11.append(' ');
    L50:
        r11.append("pkg=");
        r11.append(r24);
        r15 = false;
    L51:
        ComponentName r25 = r10.getComponent();
        if (r25 == null) goto L56;
        if (r15 == true) goto L55;
        r11.append(' ');
    L55:
        r11.append("cmp=");
        r11.append(r25.flattenToShortString());
        r15 = false;
    L56:
        Rect r26 = r10.getSourceBounds();
        if (r26 == null) goto L61;
        if (r15 == true) goto L60;
        r11.append(' ');
    L60:
        r11.append("bnds=");
        r11.append(r26.toShortString());
        r15 = false;
    L61:
        int r27 = Build.VERSION.SDK_INT;
        if (r27 >= 16) goto L64;
    L68:
        r14 = r15;
    L69:
        Bundle r28 = r10.getExtras();
        if (r28 == null) goto L75;
        if (r14 == true) goto L73;
        r11.append(' ');
    L73:
        r11.append("extras={");
        a(r28, r11);
        r11.append('}');
    L75:
        if (r27 < 15) goto L83;
        Intent r29 = r10.getSelector();
        if (r29 == null) goto L84;
        r11.append(" sel=");
        c(r29, r11);
        r11.append("}");
        return;
    L84:
        return;
    L83:
        return;
    L64:
        if (r10.getClipData() == null) goto L68;
        if (r15 == true) goto L67;
        r11.append(' ');
    L67:
        r11.append("(has clip)");
        goto L69
    L5:
        r15 = true;
        goto L6
    }

    public static String d(Intent r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        StringBuilder r11 = new StringBuilder(128);
        r11.append("Intent { ");
        c(r10, r11);
        r11.append(" }");
        return r11.toString();
    }

    private static String e(Uri r10) {
        if (Build.VERSION.SDK_INT < 14) goto L13;
        Method r11 = Uri.class.getDeclaredMethod("toSafeString", new Class[0]);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L10
        r11.setAccessible(true);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L10
        return (String) r11.invoke(r10, new Object[0]);
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
        return r10.toString();
    }
}
