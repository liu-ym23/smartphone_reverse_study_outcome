package m02;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonSyntaxException;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static i02.g.b a(String r4) {
        if (r4 == null) goto L24;
        String r5 = b.a(r4);
        if (new PolarisFileWrapper(r5).exists() == false) goto L24;
        String r6 = b.b(r5);
        if (TextUtils.isEmpty(r6) == true) goto L24;
        i02.g r7 = (i02.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r6, i02.g.class);     // Catch: JsonSyntaxException -> L22
        if (r7 == null) goto L24;
        int r2 = s1.getContext().getResources().getConfiguration().orientation;     // Catch: JsonSyntaxException -> L22
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L16;
        return null;
    L16:
        if (PadConfigUtils.c() == false) goto L19;
        return r7.portrait;
    L19:
        return r7.landscape;
    L21:
        return r7.portrait;
    L22:
        e = move-exception;
        jy0.b.c("GiftAudioVibrateSwitchUtils", null, e, 2);
    L24:
        return null;
    }

    public static int b(String r7) {
        int r0 = 0;
        if (r7 == null) goto L154;
        String r8 = b.a(r7);
        if (new PolarisFileWrapper(r8).exists() == false) goto L155;
        String r9 = b.b(r8);
        if (TextUtils.isEmpty(r9) == false) goto L153;
        return 0;
    L153:
        i02.g r10 = (i02.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r9, i02.g.class);     // Catch: JsonSyntaxException -> L150
        if (r10 == null) goto L157;
        int r3 = s1.getContext().getResources().getConfiguration().orientation;     // Catch: JsonSyntaxException -> L150
        if (r3 == 1) goto L106;
        if (r3 == 2) goto L17;
        return 0;
    L17:
        if (PadConfigUtils.c() == false) goto L62;
        i02.g.b r4 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r4 == null) goto L34;
        HashMap<String, i02.g.b> r5 = r4.foregroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r5 == null) goto L34;
        if ((!r5.isEmpty()) != true) goto L34;
        i02.g.b r6 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r6 == null) goto L29;
        HashMap<String, i02.g.b> r11 = r6.foregroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r11 == null) goto L29;
        i02.g.b r13 = r11.get("foreground_default");     // Catch: JsonSyntaxException -> L150
    L30:
        if (r13 != null) goto L32;
    L55:
        i02.g.b r14 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r14 == null) goto L58;
        String r15 = r14.vibratePath;     // Catch: JsonSyntaxException -> L150
    L60:
        if (TextUtils.isEmpty(r15) == false) goto L161;
        return r0;
    L161:
        return r0 + 2;
    L58:
        r15 = null;
        goto L60
    L32:
        if (r13.isAudio != 1) goto L55;
    L54:
        r0 = 1;
    L29:
        r13 = null;
    L34:
        i02.g.b r16 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r16 == null) goto L50;
        HashMap<String, i02.g.b> r17 = r16.backgroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r17 == null) goto L50;
        if ((!r17.isEmpty()) != true) goto L50;
        i02.g.b r18 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r18 == null) goto L45;
        HashMap<String, i02.g.b> r19 = r18.backgroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r19 == null) goto L45;
        i02.g.b r20 = r19.get("background_default");     // Catch: JsonSyntaxException -> L150
    L46:
        if (r20 == null) goto L55;
        if (r20.isAudio != 1) goto L55;
    L45:
        r20 = null;
    L50:
        i02.g.b r21 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r21 == null) goto L55;
        if (r21.isAudio != 1) goto L55;
    L62:
        i02.g.b r23 = r10.landscape;     // Catch: JsonSyntaxException -> L150
        if (r23 == null) goto L78;
        HashMap<String, i02.g.b> r24 = r23.foregroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r24 == null) goto L78;
        if ((!r24.isEmpty()) != true) goto L78;
        i02.g.b r25 = r10.landscape;     // Catch: JsonSyntaxException -> L150
        if (r25 == null) goto L73;
        HashMap<String, i02.g.b> r26 = r25.foregroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r26 == null) goto L73;
        i02.g.b r27 = r26.get("foreground_default");     // Catch: JsonSyntaxException -> L150
    L74:
        if (r27 != null) goto L76;
    L99:
        i02.g.b r28 = r10.landscape;     // Catch: JsonSyntaxException -> L150
        if (r28 == null) goto L102;
        String r29 = r28.vibratePath;     // Catch: JsonSyntaxException -> L150
    L104:
        if (TextUtils.isEmpty(r29) == false) goto L161;
        return r0;
    L102:
        r29 = null;
        goto L104
    L76:
        if (r27.isAudio != 1) goto L99;
    L98:
        r0 = 1;
    L73:
        r27 = null;
    L78:
        i02.g.b r30 = r10.landscape;     // Catch: JsonSyntaxException -> L150
        if (r30 == null) goto L94;
        HashMap<String, i02.g.b> r31 = r30.backgroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r31 == null) goto L94;
        if ((!r31.isEmpty()) != true) goto L94;
        i02.g.b r33 = r10.landscape;     // Catch: JsonSyntaxException -> L150
        if (r33 == null) goto L89;
        HashMap<String, i02.g.b> r34 = r33.backgroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r34 == null) goto L89;
        i02.g.b r35 = r34.get("background_default");     // Catch: JsonSyntaxException -> L150
    L90:
        if (r35 == null) goto L99;
        if (r35.isAudio != 1) goto L99;
    L89:
        r35 = null;
    L94:
        i02.g.b r36 = r10.landscape;     // Catch: JsonSyntaxException -> L150
        if (r36 == null) goto L99;
        if (r36.isAudio != 1) goto L99;
    L106:
        i02.g.b r37 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r37 == null) goto L122;
        HashMap<String, i02.g.b> r38 = r37.foregroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r38 == null) goto L122;
        if ((!r38.isEmpty()) != true) goto L122;
        i02.g.b r39 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r39 == null) goto L117;
        HashMap<String, i02.g.b> r40 = r39.foregroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r40 == null) goto L117;
        i02.g.b r41 = r40.get("foreground_default");     // Catch: JsonSyntaxException -> L150
    L118:
        if (r41 != null) goto L120;
    L143:
        i02.g.b r43 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r43 == null) goto L146;
        String r44 = r43.vibratePath;     // Catch: JsonSyntaxException -> L150
    L148:
        if (TextUtils.isEmpty(r44) == false) goto L161;
        return r0;
    L146:
        r44 = null;
        goto L148
    L120:
        if (r41.isAudio != 1) goto L143;
    L142:
        r0 = 1;
    L117:
        r41 = null;
    L122:
        i02.g.b r45 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r45 == null) goto L138;
        HashMap<String, i02.g.b> r46 = r45.backgroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r46 == null) goto L138;
        if ((!r46.isEmpty()) != true) goto L138;
        i02.g.b r47 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r47 == null) goto L133;
        HashMap<String, i02.g.b> r48 = r47.backgroundItemMap;     // Catch: JsonSyntaxException -> L150
        if (r48 == null) goto L133;
        i02.g.b r49 = r48.get("background_default");     // Catch: JsonSyntaxException -> L150
    L134:
        if (r49 == null) goto L143;
        if (r49.isAudio != 1) goto L143;
    L133:
        r49 = null;
    L138:
        i02.g.b r50 = r10.portrait;     // Catch: JsonSyntaxException -> L150
        if (r50 == null) goto L143;
        if (r50.isAudio != 1) goto L143;
    L157:
        return 0;
    L150:
        e = move-exception;
        jy0.b.c("GiftAudioVibrateSwitchUtils", null, e, 2);
        return 0;
    L155:
        return 0;
    L154:
        return 0;
    }
}
