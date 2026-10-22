package f4;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static String a(Context r10, Set r11) {
        if (Build.VERSION.SDK_INT < 33) goto L41;
        List r0 = CollectionsKt.listOf(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"});
        ArrayList r1 = new ArrayList();
        Iterator r12 = r0.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        if (r11.contains((String) r13) == false) goto L6;
        r1.add(r13);
        goto L6
    L10:
        boolean r14 = false;
        if (Build.VERSION.SDK_INT >= 34) goto L13;
    L15:
        boolean r15 = false;
    L17:
        if (r1.isEmpty() == false) goto L21;
        if (r15 == true) goto L21;
        return null;
    L21:
        if ((!r1.isEmpty()) == true) goto L23;
    L34:
        if (r15 == true) goto L36;
    L39:
        return "denied";
    L36:
        if (d(r10, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L39;
        return "limited";
    L23:
        if (r1.isEmpty() == true) goto L31;
        Iterator r16 = r1.iterator();
    L27:
        if (r16.hasNext() == false) goto L31;
        String r17 = (String) r16.next();
        a.getClass();
        if (d(r10, r17) == true) goto L27;
    L32:
        if (r14 == false) goto L34;
        return "full";
    L31:
        r14 = true;
        goto L32
    L13:
        if (r11.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L15;
        r15 = true;
        goto L17
    L41:
        if (r11.contains("android.permission.READ_EXTERNAL_STORAGE") == false) goto L47;
        if (d(r10, "android.permission.READ_EXTERNAL_STORAGE") == false) goto L56;
        return "full";
    L56:
        return "denied";
    L47:
        return null;
    }

    public static c c(Context r10, Set r11) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        List r0 = CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"});
    L6:
        ArrayList r1 = new ArrayList();
        Iterator r12 = r0.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        if (r11.contains((String) r13) == false) goto L8;
        r1.add(r13);
        goto L8
    L12:
        int r14 = 0;
        if (r1.isEmpty() == true) goto L23;
        Iterator r15 = r1.iterator();
    L17:
        if (r15.hasNext() == false) goto L23;
        String r16 = (String) r15.next();
        a.getClass();
        if (d(r10, r16) == false) goto L17;
        r14 = r14 + 1;
        if (r14 >= 0) goto L17;
        CollectionsKt.throwCountOverflow();
    L23:
        String r17 = "denied";
        if ((!r1.isEmpty()) == true) goto L26;
    L28:
        String r18 = "denied";
    L30:
        if (r1.isEmpty() == false) goto L33;
        r17 = null;
    L38:
        return new c(r18, r17);
    L33:
        if (r14 != r1.size()) goto L35;
        r17 = "full";
        goto L38
    L35:
        if (r14 <= 0) goto L38;
        r17 = "partial";
        goto L38
    L26:
        if (r14 != r1.size()) goto L28;
        r18 = "authorized";
        goto L30
    L5:
        r0 = CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"});
        goto L6
    }

    public static boolean d(Context r0, String r1) {
        if (ContextCompat.checkSelfPermission(r0, r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static c e(Context r10, Set r11) {
        Set r12 = SetsKt.setOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"});
        boolean r0 = d(r10, "android.permission.ACCESS_COARSE_LOCATION");
        boolean r1 = d(r10, "android.permission.ACCESS_FINE_LOCATION");
        boolean r13 = false;
        boolean r14 = true;
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        boolean r15 = false;
    L9:
        if (r15 == false) goto L11;
        String r16 = "authorized";
    L12:
        Set r17 = r11;
        if ((r17 instanceof Collection) == true) goto L15;
    L17:
        Iterator r18 = r17.iterator();
    L19:
        if (r18.hasNext() == false) goto L23;
        if (r12.contains((String) r18.next()) == false) goto L19;
    L24:
        if (r13 == true) goto L26;
        if (r15 == true) goto L31;
        return new c(r16, "denied");
    L31:
        if (Build.VERSION.SDK_INT < 29) goto L33;
        r14 = d(r10, "android.permission.ACCESS_BACKGROUND_LOCATION");
    L33:
        if (r14 == false) goto L36;
        if (r1 == false) goto L36;
        String r19 = "background precise";
    L42:
        return new c(r16, r19);
    L36:
        if (r14 == false) goto L38;
        r19 = "background approximate";
        goto L42
    L38:
        if (r1 == false) goto L40;
        r19 = "foreground precise";
        goto L42
    L40:
        r19 = "foreground approximate";
        goto L42
    L26:
        return new c(r16, null);
    L23:
        r13 = true;
        goto L24
    L15:
        if (r17.isEmpty() == false) goto L17;
    L11:
        r16 = "denied";
    L7:
        r15 = true;
        goto L9
    }

    public static c b(Context r10, Set r11, String r12) {
        boolean r13 = d(r10, r12);
        String r1 = "denied";
        if (r13 == false) goto L5;
        String r14 = "authorized";
    L7:
        if (r11.contains(r12) == true) goto L9;
        r1 = null;
    L12:
        return new c(r14, r1);
    L9:
        if (r13 == false) goto L12;
        r1 = "full";
        goto L12
    L5:
        r14 = "denied";
        goto L7
    }
}
