package d5;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class v extends d {
    public v() {
        super(true, false);
    }

    @Override // d5.d
    public final boolean a(JSONObject r10) {
        StringBuilder r11 = new StringBuilder(16);
        boolean r8 = false;
        if (k5.j.h() == false) goto L6;
        String r12 = "MIUI-";
    L39:
        r11.append(r12);
    L40:
        r11.append(Build.VERSION.INCREMENTAL);
        r10.put("rom", r11.toString());
        String r13 = "";
        if (k5.j.h() == false) goto L46;
        if (k5.j.h() == false) goto L95;
        r13 = "miui_" + k5.j.c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    L95:
        if (TextUtils.isEmpty(r13) == true) goto L97;
        r10.put("rom_version", r13);
    L97:
        return true;
    L46:
        if (k5.j.e() == true) goto L48;
        String r14 = k5.j.c("ro.build.version.emui");
        if (r14 != null) goto L53;
    L57:
        String r15 = "";
    L59:
        if (TextUtils.isEmpty(r15) == true) goto L62;
    L60:
        r13 = r15;
        goto L95
    L62:
        if ((!TextUtils.isEmpty(k5.j.c("ro.vivo.os.build.display.id"))) == false) goto L65;
        r13 = k5.j.c("ro.vivo.os.build.display.id") + "_" + k5.j.c("ro.vivo.product.version");
        goto L95
    L65:
        if (k5.j.f() == false) goto L71;
        r15 = Build.DISPLAY;
        if (r15 == null) goto L95;
        if (r15.toLowerCase().contains("flyme") == false) goto L95;
    L71:
        r15 = Build.DISPLAY;
        if (TextUtils.isEmpty(r15) == false) goto L74;
    L76:
        boolean r16 = false;
    L77:
        if (r16 == false) goto L79;
        StringBuilder r17 = android.aimedia.a.k(r15, "_");
        r17.append(k5.j.c("ro.gn.sv.version"));
        r13 = r17.toString();
        goto L95
    L79:
        String r18 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r18) == true) goto L87;
        String r19 = r18.toLowerCase();
        if (r19.contains("360") == false) goto L85;
    L86:
        r8 = true;
        goto L87
    L85:
        if (r19.contains("qiku") == true) goto L86;
    L87:
        if (r8 == false) goto L90;
        r13 = k5.j.c("ro.build.uiversion") + "_" + r15;
        goto L95
    L90:
        if ((!TextUtils.isEmpty(k5.j.c("ro.letv.release.version"))) == false) goto L93;
        r13 = "eui_" + k5.j.c("ro.letv.release.version") + "_" + r15;
    L93:
        if (TextUtils.isEmpty(r13) == true) goto L60;
    L74:
        if (r15.toLowerCase().contains("amigo") == false) goto L76;
        r16 = true;
        goto L77
    L53:
        if (r14.toLowerCase().contains("emotionui") == false) goto L55;
    L56:
        StringBuilder r20 = android.aimedia.a.k(r14, "_");
        r20.append(Build.DISPLAY);
        r15 = r20.toString();
        goto L59
    L55:
        if (r14.toLowerCase().contains("magicui") == false) goto L57;
    L48:
        if (k5.j.e() == false) goto L95;
        r13 = "coloros_" + k5.j.c("ro.build.version.opporom") + "_" + Build.DISPLAY;
        goto L95
    L6:
        if (k5.j.f() == false) goto L8;
        r12 = "FLYME-";
        goto L39
    L8:
        String r21 = k5.j.c("ro.build.version.emui");
        if (TextUtils.isEmpty(r21) == false) goto L11;
        String r22 = k5.j.c("ro.build.version.emui");
    L13:
        if (TextUtils.isEmpty(r22) == false) goto L15;
    L19:
        String r23 = Build.BRAND;
        if (TextUtils.isEmpty(r23) == false) goto L22;
    L23:
        String r24 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r24) == false) goto L26;
    L28:
        boolean r25 = false;
    L29:
        if (r25 == false) goto L31;
    L34:
        boolean r26 = true;
    L35:
        if (r26 == false) goto L40;
        r11.append("EMUI-");
        if (TextUtils.isEmpty(r21) == true) goto L40;
        r11.append(r21);
        r12 = "-";
        goto L39
    L31:
        if (k5.j.g() == true) goto L34;
        r26 = false;
        goto L35
    L26:
        if (r24.toLowerCase().startsWith("huawei") == false) goto L28;
    L27:
        r25 = true;
        goto L29
    L22:
        if (r23.toLowerCase().startsWith("huawei") == true) goto L27;
    L15:
        if (r22.toLowerCase().contains("emotionui") == true) goto L34;
        if (r22.toLowerCase().contains("magicui") == false) goto L19;
    L11:
        r22 = r21;
        goto L13
    }
}
