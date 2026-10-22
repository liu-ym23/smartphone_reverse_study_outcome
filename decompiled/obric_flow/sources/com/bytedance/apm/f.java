package com.bytedance.apm;

import android.content.Context;
import android.util.LruCache;
import androidx.room.writer.DaoWriter;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.forest.model.w;
import com.bytedance.forest.pollyfill.q;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.x;
import com.lynx.tasm.behavior.ui.y;
import com.lynx.tasm.p;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3874c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ f(Object r5, Object r10, Object r11, Object r12, Object r13, int r14) {
        this.f3872a = r14;
        this.f3873b = r5;
        this.f3874c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Integer r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        InputStream r10 = null;
        r10 = null;
        r5 = null;
        switch(this.f3872a) {
            case 0: goto L225;
            case 1: goto L223;
            case 2: goto L122;
            case 3: goto L115;
            case 4: goto L102;
            case 5: goto L7;
            default: goto L4;
        };
    L4:
        p.e((String) this.f3873b, (String) this.f3874c, (String) this.d, (String) this.e, (String) this.f, null);
        return;
    L102:
        h0 r11 = (h0) this.f;
        if (r11.f1510a == false) goto L105;
        CrashType r12 = CrashType.LAUNCH;
    L106:
        String r13 = r12.getName();
        if (r11.f1510a == false) goto L109;
        String r14 = n.f4062j.getLaunchCrashUploadUrl();
    L110:
        JSONObject r15 = (JSONObject) this.d;
        if (com.bytedance.crash.upload.b.a(r13, com.bytedance.crash.upload.b.i(r14, r15.optJSONObject("header")), r15.toString(), null, new c5.a[]{new c5.a(new File[]{(File) this.f3873b}, true)}).c() == false) goto L113;
        cl.a.C((File) this.f3874c);
    L113:
        ((CountDownLatch) this.e).countDown();
        return;
    L109:
        r14 = n.f4062j.getJavaCrashUploadUrl();
        goto L110
    L105:
        r12 = CrashType.JAVA;
        goto L106
    L115:
        y r16 = (y) this.f;
        boolean r17 = r16.f10783z;
        HashMap r18 = r16.f10779v;
        if (r17 == false) goto L118;
    L120:
        r18.put((String) this.f3873b, new x((LynxBaseUI) this.d, (String) this.f3874c, (JavaOnlyMap) this.e));
        return;
    L118:
        if (r18.isEmpty() == false) goto L120;
        r16.c();
        goto L120
    L122:
        String r19 = (String) this.f3873b;
        lh.b r20 = (lh.b) this.d;
        if (r20 != null) goto L238;
    L134:
        com.bytedance.frameworks.baselib.network.http.cronet.b r21 = com.bytedance.pia.core.tracing.b.f7104r;
        com.bytedance.pia.core.tracing.b r22 = (com.bytedance.pia.core.tracing.b) this.e;
        r22.getClass();
        boolean r23 = StringsKt.g(r19, "script name=\"pia-ssr-data\"");
        if (StringsKt.g(r19, "window.use_pia_ssr = true") == false) goto L137;
    L140:
        Object[] r24 = true;
    L142:
        if (r24 == false) goto L146;
        r22.f7109h = "ssr";
        if (r22.f7114m == 3) goto L157;
    L147:
        if (r23 == false) goto L150;
        if (r24 == false) goto L150;
        r22.f7114m = 0;
    L150:
        if (r23 == false) goto L152;
        r22.f7114m = 2;
        goto L157
    L152:
        if (r24 == false) goto L157;
        int r25 = r22.f7114m;
        if (r25 == 1) goto L157;
        if (r25 == (-1)) goto L157;
        r22.f7114m = -1;
    L157:
        boolean r26 = StringsKt.g(r19, "window.pia_nsr_enable = true");
        if (StringsKt.g(r19, "window.use_pia_nsr = true") == false) goto L160;
    L163:
        boolean r27 = true;
    L164:
        com.bytedance.pia.core.setting.a r110 = (com.bytedance.pia.core.setting.a) this.f;
        if (r27 == true) goto L167;
    L169:
        if (r110 != null) goto L171;
    L182:
        r22.f7113l = 6;
    L183:
        boolean r28 = StringsKt.g(r19, "window.pia_snapshot_enable = true");
        if (StringsKt.g(r19, "window.use_pia_snapshot = true") == false) goto L186;
    L189:
        boolean r29 = true;
    L190:
        if (r29 == false) goto L194;
        int r111 = r22.d;
        if (r111 < 0) goto L194;
        r22.f7112k = r111;
    L208:
        MatchResult r112 = Regex.find$default(new Regex("pia-version\\s*=\\s*\"([^\"]+)\""), r19, 0, 2, null);
        if (r112 == null) goto L215;
        List<String> r113 = r112.getGroupValues();
        if (r113 == null) goto L215;
        String r114 = r113.get(1);
        if (r114 == null) goto L215;
        r22.g = r114;
    L215:
        MatchResult r115 = Regex.find$default(new Regex("pia_ssr_mode\\s*=\\s*\"([^\"]+)\""), r19, 0, 2, null);
        if (r115 == null) goto L259;
        List<String> r116 = r115.getGroupValues();
        if (r116 == null) goto L260;
        String r117 = r116.get(1);
        if (r117 == null) goto L261;
        r22.f7109h = "ssr:".concat(r117);
        return;
    L261:
        return;
    L260:
        return;
    L259:
        return;
    L194:
        if (r110 != null) goto L196;
    L207:
        r22.f7112k = 6;
        goto L208
    L196:
        if (((Set) r110.e.getValue()).contains("snapshot") != r29) goto L207;
        if (r28 == false) goto L200;
        if (r29 == false) goto L200;
        r22.f7112k = 0;
    L200:
        if (r28 == false) goto L202;
        r22.f7112k = 2;
        goto L208
    L202:
        if (r29 == false) goto L208;
        int r118 = r22.f7112k;
        if (r118 == 1) goto L208;
        if (r118 == (-1)) goto L208;
        r22.f7112k = -1;
        goto L208
    L186:
        if (StringsKt.g(r19, "window.use_pia_snapshot=!0") == true) goto L189;
        r29 = false;
        goto L190
    L171:
        if (((Set) r110.e.getValue()).contains("nsr") != r27) goto L182;
        if (r26 == false) goto L175;
        if (r27 == false) goto L175;
        r22.f7113l = 0;
    L175:
        if (r26 == false) goto L177;
        r22.f7113l = 2;
        goto L183
    L177:
        if (r27 == false) goto L183;
        int r30 = r22.f7114m;
        if (r30 == 1) goto L183;
        if (r30 == (-1)) goto L183;
        r22.f7113l = -1;
        goto L183
    L167:
        if (r22.d < 0) goto L169;
    L160:
        if (StringsKt.g(r19, "window.use_pia_nsr=!0") == true) goto L163;
        r27 = false;
        goto L164
    L146:
        r22.f7114m = 1;
        goto L147
    L137:
        if (StringsKt.g(r19, "window.use_pia_ssr!=0") == true) goto L140;
        r24 = false;
        goto L142
    L238:
    L133:
        com.bytedance.pia.core.utils.j.x("online monitor read html error", null);
        goto L134
    L125:
        if (r19.length() == 0) goto L229;
        r20.close();     // Catch: Throwable -> L133
    L237:
        goto L134
    L229:
        r19 = com.bytedance.pia.core.utils.j.m(r20, (String) this.f3874c);     // Catch: Throwable -> L129
    L129:
        th = move-exception;
        com.bytedance.pia.core.utils.j.s("[HTML] Parse HTML Exception: " + th);     // Catch: Throwable -> L133
        r19 = "";
        goto L237
    L223:
        AtomicBoolean r31 = q.f4535b;
        ((q) this.f3873b).e((com.bytedance.forest.pollyfill.d) this.f3874c, (com.bytedance.forest.model.q) this.d, (w) this.e);
        q.f4536c.remove(((com.bytedance.forest.pollyfill.c) this.f).toString());
        return;
    L225:
        i6.a.i().b(new j6.e((String) this.f3873b, (String) this.f3874c, (JSONObject) this.d, (JSONObject) this.e, (JSONObject) this.f));
        return;
    L7:
        if (((String) this.f3873b).startsWith("http://") == true) goto L11;
        if (((String) this.f3873b).startsWith("https://") == true) goto L11;
    L244:
        if (((String) this.f3873b).startsWith("asset:///") == false) goto L40;
        if (((String) this.f3873b).length() <= 9) goto L40;
        mn.i r32 = (mn.i) this.f;
        String r33 = (String) this.f3873b;
        fo.d r119 = (fo.d) this.d;
        r32.getClass();
        fo.f r34 = new fo.f();
        r10 = LynxEnv.inst().getAppContext().getAssets().open(r33.substring(9));     // Catch: Throwable -> L25 IOException -> L27
        StringBuilder r35 = new StringBuilder(r10.available());     // Catch: Throwable -> L25 IOException -> L27
        byte[] r36 = new byte[1024];     // Catch: Throwable -> L25 IOException -> L27
    L22:
        int r37 = r10.read(r36);     // Catch: Throwable -> L25 IOException -> L27
        if (r37 == (-1)) goto L29;
        r35.append(new String(r36, 0, r37));     // Catch: Throwable -> L25 IOException -> L27
        goto L22
    L29:
        ByteArrayInputStream r38 = new ByteArrayInputStream(r35.toString().getBytes());     // Catch: Throwable -> L25 IOException -> L27
        r34.f16963b = r38;     // Catch: Throwable -> L25 IOException -> L27
        r119.c(r34);     // Catch: Throwable -> L25 IOException -> L27
        r38.close();     // Catch: Throwable -> L25 IOException -> L27
        r10.close();     // Catch: IOException -> L227
    L243:
        return;
    L25:
        th = move-exception;
        if (r10 != null) goto L233;
    L38:
        throw th;
    L233:
        r10.close();     // Catch: IOException -> L228
    L27:
        e = move-exception;
        r34.f16962a = e.toString();     // Catch: Throwable -> L25
        r119.d(r34);     // Catch: Throwable -> L25
        if (r10 == null) goto L253;
        r10.close();     // Catch: IOException -> L227
        goto L243
    L253:
        return;
    L40:
        if (((String) this.f3873b).startsWith("res:///") == false) goto L84;
        if (((String) this.f3873b).length() <= 7) goto L84;
        mn.i r39 = (mn.i) this.f;
        String r40 = (String) this.f3873b;
        fo.d r120 = (fo.d) this.d;
        r39.getClass();
        Context r41 = LynxEnv.inst().getAppContext();
        String r42 = r40.substring(7);
        if (r42 != null) goto L46;
    L77:
        fo.f r43 = new fo.f();
        if (r5 == null) goto L82;
        InputStream r44 = LynxEnv.inst().getAppContext().getResources().openRawResource(r5.intValue());
        r43.f16963b = r44;
        r120.c(r43);
        r44.close();     // Catch: IOException -> L227
        goto L243
    L82:
        r43.f16962a = "resource not found!";
        r120.d(r43);
        return;
    L46:
        if (r42.isEmpty() == true) goto L77;
        r5 = Integer.valueOf(Integer.parseInt(r42));     // Catch: NumberFormatException -> L50
    L50:
        String r45 = r42.toLowerCase().replace(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, "_");
        Integer r46 = (Integer) ((LruCache) r39.f20153a).get(r45);
        if (r46 == null) goto L53;
        r5 = r46;
        goto L77
    L53:
        int r47 = r45.indexOf(47);
        if (r47 <= 0) goto L77;
        if (r47 == (r45.length() - 1)) goto L77;
        String r48 = r45.substring(0, r47);
        String r49 = r45.substring(r47 + 1);
        int r50 = r49.lastIndexOf(46);
        if (r50 <= 0) goto L61;
        r49 = r49.substring(0, r50);
    L61:
        monitor-enter(r39);
        Integer r51 = (Integer) ((LruCache) r39.f20153a).get(r45);     // Catch: Throwable -> L66
        if (r51 != null) goto L65;
        int r52 = r41.getResources().getIdentifier(r49, r48, r41.getPackageName());     // Catch: Throwable -> L66
        if (r52 == 0) goto L240;
        ((LruCache) r39.f20153a).put(r45, Integer.valueOf(r52));     // Catch: Throwable -> L66
        r5 = Integer.valueOf(r52);     // Catch: Throwable -> L66
    L240:
        goto L77
    L65:
        r5 = r51;
    L66:
        th = move-exception;
        throw th;
    L84:
        if (((String) this.f3873b).startsWith("file://") == true) goto L86;
    L100:
        new RuntimeException("illegal url:" + ((String) this.f3873b));
        ((fo.f) this.e).f16962a = "url is illegal:" + ((String) this.f3873b);
        ((fo.d) this.d).d((fo.f) this.e);
        return;
    L86:
        if (((String) this.f3873b).length() <= 7) goto L100;
        mn.i r53 = (mn.i) this.f;
        String r54 = (String) this.f3873b;
        fo.d r121 = (fo.d) this.d;
        r53.getClass();
        String r55 = r54.substring(7);
        if (r55.startsWith("/") == false) goto L90;
        File r56 = new File(r55);
    L91:
        fo.f r57 = new fo.f();
        FileInputStream r58 = new FileInputStream(r56);     // Catch: IOException -> L98 FileNotFoundException -> L99
        StringBuilder r59 = new StringBuilder(r58.available());     // Catch: IOException -> L98 FileNotFoundException -> L99
        byte[] r60 = new byte[1024];     // Catch: IOException -> L98 FileNotFoundException -> L99
    L93:
        int r61 = r58.read(r60);     // Catch: IOException -> L98 FileNotFoundException -> L99
        if (r61 == (-1)) goto L96;
        r59.append(new String(r60, 0, r61));     // Catch: IOException -> L98 FileNotFoundException -> L99
        goto L93
    L96:
        r57.f16963b = new ByteArrayInputStream(r59.toString().getBytes());     // Catch: IOException -> L98 FileNotFoundException -> L99
        r121.c(r57);     // Catch: IOException -> L98 FileNotFoundException -> L99
        r58.close();     // Catch: IOException -> L98 FileNotFoundException -> L99
    L257:
        return;
    L99:
        r57.f16962a = "file not found!";
        r121.d(r57);
        return;
    L98:
        r57.f16962a = "IO failed";
        r121.d(r57);
        return;
    L90:
        r56 = new File(LynxEnv.inst().getAppContext().getFilesDir(), r55);
    L258:
        return;
    L11:
        if (((String) this.f3873b).length() <= 8) goto L244;
        mn.i r62 = (mn.i) this.f;
        fo.e r63 = (fo.e) this.f3874c;
        fo.d r122 = (fo.d) this.d;
        r62.getClass();
        fo.i r64 = LynxEnv.inst().getResProvider();
        if (r64 != null) goto L15;
        fo.f r65 = new fo.f();
        r65.f16962a = "don't have ResProvider.Can't Get Resource.";
        r122.d(r65);
        return;
    L15:
        r64.a(r63, r122);
    }

    public f(String r5, lh.b r10, String r11, com.bytedance.pia.core.tracing.b r12, com.bytedance.pia.core.setting.a r13) {
        this.f3872a = 2;
        this.f3873b = r5;
        this.d = r10;
        this.f3874c = r11;
        this.e = r12;
        this.f = r13;
    }

    public f(h0 r5, JSONObject r10, File r11, File r12, CountDownLatch r13) {
        this.f3872a = 4;
        this.f = r5;
        this.d = r10;
        this.f3873b = r11;
        this.f3874c = r12;
        this.e = r13;
    }

    public f(y r5, String r10, LynxBaseUI r11, String r12, JavaOnlyMap r13) {
        this.f3872a = 3;
        this.f = r5;
        this.f3873b = r10;
        this.d = r11;
        this.f3874c = r12;
        this.e = r13;
    }

    public f(mn.i r5, String r10, fo.e r11, fo.d r12, fo.f r13) {
        this.f3872a = 5;
        this.f = r5;
        this.f3873b = r10;
        this.f3874c = r11;
        this.d = r12;
        this.e = r13;
    }
}
