package ms.bd.c;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.mobsec.metasec.ml.MSC;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class i2 {
    public static Object a(int r46, int r47, long r48, String r50, Object r51) {
        if (r46 > 268435456) goto L5;
    L65:
        z3 r1 = o2.a;
        if (r46 <= 65536) goto L71;
        if (r46 >= 65545) goto L71;
    L81:
        return o2.b(r46, r50, r51);
    L71:
        if (r46 <= 196608) goto L76;
        if (r46 < 196612) goto L81;
    L76:
        if (r46 > 131072) goto L78;
    L82:
        g4 r4 = g2.a;
        if (r46 <= 16777216) goto L88;
        if (r46 >= 16777281) goto L88;
    L92:
        return g2.c(r46, r47, r48, r50, r51);
    L88:
        if (r46 > 33554432) goto L90;
    L93:
        return null;
    L90:
        if (r46 >= 33554435) goto L93;
    L78:
        if (r46 >= 131075) goto L82;
    L5:
        if (r46 >= 268435474) goto L65;
        switch(r46) {
            case 268435457: goto L99;
            case 268435458: goto L59;
            case 268435459: goto L59;
            case 268435460: goto L58;
            case 268435461: goto L57;
            case 268435462: goto L44;
            case 268435463: goto L36;
            case 268435464: goto L103;
            case 268435465: goto L18;
            case 268435466: goto L118;
            case 268435467: goto L17;
            case 268435468: goto L16;
            case 268435469: goto L12;
            case 268435470: goto L11;
            case 268435471: goto L10;
            case 268435472: goto L9;
            case 268435473: goto L8;
            default: goto L118;
        };
    L8:
        Object r0 = z2.a(d2.b.a).c;
    L117:
        return r0;
    L9:
        r0 = z2.a(d2.b.a).b;
        goto L117
    L10:
        r0 = Long.valueOf(MSC.GetDelayTime());
        goto L117
    L11:
        r0 = Long.valueOf(MSC.GetABSwitch());
        goto L117
    L12:
        Context r2 = d2.b.a;
        if (r2 == null) goto L119;
        r0 = new StringBuilder(l3.a(r2)).toString();
        goto L117
    L119:
        return null;
    L16:
        r0 = z2.a(d2.b.a).a;
        goto L117
    L17:
        z2.a(d2.b.a);
        return null;
    L18:
        Context r3 = d2.b.a;
        if (r3 == null) goto L120;
        StringBuilder r5 = new StringBuilder(l3.a(r3));
        Iterator<InputMethodInfo> r6 = ((InputMethodManager) r3.getSystemService("input_method")).getInputMethodList().iterator();     // Catch: Throwable -> L94
    L24:
        if (r6.hasNext() == false) goto L116;
        String r7 = r6.next().getPackageName();     // Catch: Throwable -> L94
        if (TextUtils.isEmpty(r7) == true) goto L24;
        if (r5.indexOf(r7) >= 0) goto L24;
        r5.append("[<!>]");     // Catch: Throwable -> L94
        r5.append(r7);     // Catch: Throwable -> L94
    L116:
        return r5.toString();
    L120:
        return null;
    L36:
        Context r8 = d2.b.a;
        JSONArray r9 = new JSONArray();
        if (r8 != null) goto L105;
        r0 = r9.toString();
        goto L117
    L105:
        if (d3.a() == false) goto L43;
        r0 = r9.toString();     // Catch: Throwable -> L95
    L43:
        r0 = "[]";
        goto L117
    L44:
        String r10 = v.a;
        JSONObject r11 = new JSONObject();
        HashMap r12 = v.c();     // Catch: Throwable -> L52
        String r13 = v.i;     // Catch: Throwable -> L52
        int r14 = new PolarisFileWrapper((String) p2.a(16777217, 0, 0, "1cd30d", new byte[]{111, 114, 14, 84, 64, 119, 55, 84, 60, 96, 37, 114, 88, 84, 22, 96, 38, 71, 56, 44, 35, 113, 2, 8})).listFiles(v.j).length;     // Catch: Throwable -> L49
    L50:
        r11.put(r13, r14);     // Catch: Throwable -> L52
        r11.put(v.d, v.b(r12, v.a));     // Catch: Throwable -> L52
        r11.put(v.e, v.b(r12, v.b));     // Catch: Throwable -> L52
        r11.put(v.g, v.a((String) p2.a(16777217, 0, 0, "7d0ef7", new byte[]{105, 117, 90, 2, 22, 36, 49, 83, 104, 54, 35, 117, 12, 2, 64, 51, 32, 64, 108, 122, 37, 118, 86, 94, 90, 48, 33, 21, 46, 54, 54, 115, 69, 3, 92, 49, 123, 70, 113, 32, 47, 104, 69, 30, 102, 45, 53, 93, 94, 51, 52, 99, 82})));     // Catch: Throwable -> L52
        r11.put(v.h, v.a((String) p2.a(16777217, 0, 0, "dea820", new byte[]{58, 116, 11, 95, 66, 35, 98, 82, 57, 107, 112, 116, 93, 95, 20, 52, 115, 65, 61, 39, 118, 119, 7, 3, 14, 55, 114, 20, ByteCompanionObject.MAX_VALUE, 107, 101, 114, 20, 94, 8, 54, 40, 71, 32, 125, 124, 105, 20, 67, 50, 42, 110, 74, 15, 110, 103, 98, 3})));     // Catch: Throwable -> L52
        r11.put(v.f, v.b(r12, v.c));     // Catch: Throwable -> L52
    L49:
        r14 = -1;
    L53:
        String r15 = r11.toString();
        if (TextUtils.isEmpty(r15) == false) goto L56;
        r0 = (String) p2.a(16777217, 0, 0, "20c1e3", new byte[]{56, 47});
        goto L117
    L56:
        r0 = r15.trim();
        goto L117
    L57:
        int r16 = b4.a;
        r0 = "";
        goto L117
    L58:
        r0 = b4.a("");
        goto L117
    L59:
        r0 = "np";
        goto L117
    L103:
        d3.a();     // Catch: Throwable -> L34
        int r17 = b4.a;
    L35:
        r0 = "null[<!>]null[<!>]0[<!>]";
    L34:
        int r18 = b4.a;
        goto L35
    L118:
        return null;
    L99:
        Display r19 = ((WindowManager) d2.b.a.getSystemService("window")).getDefaultDisplay();     // Catch: Throwable -> L96
        Point r20 = new Point();     // Catch: Throwable -> L96
        r19.getRealSize(r20);     // Catch: Throwable -> L96
        k3.a = r20.x;     // Catch: Throwable -> L96
        k3.b = r20.y;     // Catch: Throwable -> L96
    L63:
        r0 = k3.a + "*" + k3.b;
        goto L117
    }
}
