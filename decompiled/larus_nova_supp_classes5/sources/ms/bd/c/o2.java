package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.ByteCompanionObject;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class o2 {
    public static final z3 a = null;

    static {
        z3 r0 = new z3();
        a = r0;
        monitor-enter(z3.class);
        z3.b = r0;     // Catch: Throwable -> L7
        monitor-exit(z3.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v26, types: [java.io.Serializable, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r9v50, types: [java.io.Serializable] */
    public static Serializable b(int r37, String r38, Object r39) {
        String r1 = r38;
        int r4 = 5;
        int r8 = 0;
        boolean r9 = false;
        int r10 = 0;
        if (r37 != 131073) goto L5;
    L172:
        z3 r5 = a;
        if (r37 != 131073) goto L204;
        if (r1 == null) goto L219;
        Context r0 = d2.b.a;
        JSONObject r11 = new JSONObject(r1);     // Catch: JSONException -> L178
    L179:
        if (r11 == null) goto L219;
        String r2 = JSONObjectProtectorUtils.getString(r11, (String) p2.a(16777217, 0, 0, "b35278", new byte[]{96, 53, 77, 121, 9, 38, 101}));     // Catch: JSONException -> L199
        String r14 = JSONObjectProtectorUtils.getString(r11, (String) p2.a(16777217, 0, 0, "404464", new byte[]{45, 61, 84, 84, 54, 34, 62, 21}));     // Catch: JSONException -> L224
        ArrayList r13 = new ArrayList();     // Catch: JSONException -> L198
        ArrayList r12 = new ArrayList();     // Catch: JSONException -> L198
        JSONArray r3 = JSONObjectProtectorUtils.getJSONArray(r11, (String) p2.a(16777217, 0, 0, "3a70e1", new byte[]{33, 108, 74, 66, 83, 33, 5, 114, 74, 115}));     // Catch: JSONException -> L198
        JSONArray r6 = JSONObjectProtectorUtils.getJSONArray(r11, (String) p2.a(16777217, 0, 0, "e29979", new byte[]{102, 53, 90, 66, 26, 58, 83, 33, 68, 122}));     // Catch: JSONException -> L198
        int r7 = 0;
    L187:
        if (r7 >= r3.length()) goto L190;
        r13.add(JSONArrayProtectorUtils.getString(r3, r7));     // Catch: JSONException -> L198
        r7 = r7 + 1;     // Catch: JSONException -> L198
    L190:
        if (r8 >= r6.length()) goto L193;
        r12.add(JSONArrayProtectorUtils.getString(r6, r8));     // Catch: JSONException -> L198
        r8 = r8 + 1;     // Catch: JSONException -> L198
        goto L190
    L193:
        if (r13.size() <= 0) goto L219;
        if (r12.size() <= 0) goto L219;
        SDKMonitorUtils.setConfigUrl(r2, r13);     // Catch: JSONException -> L198
        SDKMonitorUtils.setDefaultReportUrl(r2, r12);     // Catch: JSONException -> L198
    L202:
        r11.remove((String) p2.a(16777217, 0, 0, "4ebcc9", new byte[]{38, 104, 31, 17, 85, 41, 2, 118, 31, 32}));
        r11.remove((String) p2.a(16777217, 0, 0, "fc301e", new byte[]{101, 100, 80, 75, 28, 102, 80, 112, 78, 115}));
        SDKMonitorUtils.initMonitor(r0, r2, r11, new y3(r11, r14));
        r5.a = SDKMonitorUtils.getInstance(r2);
        return (String) p2.a(16777217, 0, 0, "76b933", new byte[]{9, 31});
    L198:
        String r15 = r14;
        int r16 = 5;
    L201:
        byte[] r17 = new byte[r16];
        r17 = {x091e: FILL_ARRAY_DATA  (LINE:50333982), data: [50, 98, 73, 41, 5} // fill-array;
        String r18 = (String) p2.a(16777217, 0, 0, "0e7b3d", r17);
        r14 = r15;
    L200:
        r16 = 5;
        r15 = null;
    L199:
        r2 = null;
    L178:
        String r19 = (String) p2.a(16777217, 0, 0, "6846ee", new byte[]{52, 63, 74});
        r11 = null;
    L219:
        return null;
    L204:
        if (r37 != 131074) goto L219;
        String[] r20 = (String[]) r39;
        if (r1 == null) goto L219;
        if (r20 == null) goto L219;
        if (r20.length == 0) goto L219;
        JSONObject r21 = new JSONObject(r20[0]);
        JSONObject r22 = new JSONObject(r20[1]);
        JSONObject r23 = new JSONObject(r20[2]);
        if (r5.a == null) goto L219;
        if (r21.length() <= 0) goto L217;
    L218:
        r5.a.monitorEvent(r1, r21, r22, r23);
        goto L219
    L217:
        if (r22.length() <= 0) goto L219;
    L5:
        if (r37 == 131074) goto L172;
        String r110 = "";
        switch(r37) {
            case 65537: goto L243;
            case 65538: goto L146;
            case 65539: goto L142;
            case 65540: goto L251;
            case 65541: goto L79;
            case 65542: goto L26;
            case 65543: goto L253;
            case 65544: goto L255;
            default: goto L8;
        };
    L8:
        Serializable r111 = null;
        switch(r37) {
            case 196609: goto L154;
            case 196610: goto L154;
            case 196611: goto L154;
            default: goto L296;
        };
    L154:
        if (d3.b(new String[]{(String) p2.a(16777217, 0, 0, "9c755a", new byte[]{41, 111, 64, 83, 5, ByteCompanionObject.MAX_VALUE, 62, 12, 118, 96, 58, 108, 77, 82, 25, ByteCompanionObject.MAX_VALUE, 53, 76, 40, 76, 6, 85, 97, 115, 36, 83, 14})}) == false) goto L219;
        switch(r37) {
            case 196609: goto L161;
            case 196610: goto L159;
            case 196611: goto L158;
            default: goto L296;
        };
    L158:
        Object[] r24 = (Object[]) r39;
        Object r25 = e4.d(r38, null, null, (String) r24[1], null, (String) r24[0], false);
    L295:
        return r25;
    L159:
        Object[] r26 = (Object[]) r39;
        r25 = e4.d(r38, null, (String) r26[0], (String) r26[1], null, null, false);
        goto L295
    L161:
        Object[] r27 = (Object[]) r39;
        byte[] r28 = (byte[]) r27[0];
        String r29 = (String) r27[1];
        String r30 = (String) r27[2];
        HashMap r31 = new HashMap();
        if (r27.length <= 3) goto L170;
        String[] r32 = (String[]) r27[3];
        if (r32 == null) goto L170;
        if ((r32.length % 2) != 0) goto L170;
    L168:
        if (r10 >= r32.length) goto L170;
        r31.put(r32[r10], r32[r10 + 1]);
        r10 = r10 + 2;
    L170:
        r25 = e4.d(r38, r28, r29, r30, r31, null, true);
    L296:
        return r111;
    L26:
        Context r33 = d2.b.a;
        ApplicationInfo r34 = r33.getPackageManager().getApplicationInfo(r33.getPackageName(), 0);
        String r35 = r34.sourceDir;
        if (r35 != null) goto L31;
        r35 = r34.publicSourceDir;
    L31:
        if (TextUtils.isEmpty(r35) == false) goto L33;
        HashMap r36 = null;
    L60:
        if (r36 != null) goto L62;
    L64:
        String r40 = "";
    L65:
        if (r40 != null) goto L67;
    L75:
        String r41 = "";
    L77:
        if (r41.isEmpty() == true) goto L289;
        return r41;
    L289:
        return (String) p2.a(16777217, 0, 0, "8758b3", new byte[]{7, 58, 72, 73});
    L67:
        if (r40.isEmpty() == true) goto L75;
        JSONObject r42 = new JSONObject(r40);
        String r43 = JSONObjectProtectorUtils.getString(r42, (String) p2.a(16777217, 0, 0, "56e4d6", new byte[]{41, 49, 2, 65, 100, 52, 59, 18, 58, 99, 27, 55, 30, 65, 85, 47, 51, 27}));     // Catch: JSONException -> L71
    L72:
        StringBuilder r44 = new StringBuilder();
        r44.append(r43);
        r44.append((String) p2.a(16777217, 0, 0, "c20582", new byte[]{41}));
        r110 = JSONObjectProtectorUtils.getString(r42, (String) p2.a(16777217, 0, 0, "9788fc", new byte[]{58, 48, 71, 73, 88, 103, 63, 41, 107, 125, 33, 57, 79}));     // Catch: JSONException -> L222
    L74:
        r44.append(r110);
        r41 = r44.toString();
    L71:
        r43 = "";
        goto L72
    L62:
        if (r36.containsKey(1903654775) == false) goto L64;
        r40 = (String) r36.get(1903654775);
        goto L65
    L33:
        HashMap r45 = new HashMap();
        RandomAccessFile r46 = new RandomAccessFile(r35, (String) p2.a(16777217, 0, 0, "39a4fd", new byte[]{48}));     // Catch: Throwable -> L54
        d r47 = f.b(r46.getChannel());     // Catch: Throwable -> L53
        if (r47 == null) goto L52;
        Iterator r48 = f.a((ByteBuffer) r47.a).entrySet().iterator();     // Catch: Throwable -> L53
    L39:
        if (r48.hasNext() == false) goto L52;
        Map.Entry r49 = (Map.Entry) r48.next();     // Catch: Throwable -> L53
        if (r49 == null) goto L39;
        if (r49.getKey() == null) goto L39;
        if (((Integer) r49.getKey()).intValue() == 1896449818) goto L39;
        ByteBuffer r50 = (ByteBuffer) r49.getValue();     // Catch: Throwable -> L223
        byte[] r51 = r50.array();     // Catch: Throwable -> L223
        int r112 = r50.arrayOffset();     // Catch: Throwable -> L223
        r45.put((Integer) r49.getKey(), new String(Arrays.copyOfRange(r51, r50.position() + r112, r50.limit() + r112)));     // Catch: Throwable -> L223
    L52:
        r46.close();     // Catch: Throwable -> L58
    L233:
    L53:
        RandomAccessFile r52 = r46;
    L55:
        if (r52 == null) goto L59;
        r52.close();     // Catch: Throwable -> L58
    L54:
        r52 = null;
    L59:
        r36 = r45;
        goto L60
    L79:
        Context r53 = d2.b.a;
        AssetManager r54 = r53.getAssets();
        if (r1.startsWith((String) p2.a(16777217, 0, 0, "2e8d81", new byte[]{109})) == true) goto L82;
        r1 = ((String) p2.a(16777217, 0, 0, "386440", new byte[]{108})) + r1;
    L82:
        String[] r55 = r54.list("");
        ArrayList r56 = new ArrayList();
        int r57 = 0;
    L84:
        if (r57 >= r55.length) goto L125;
        if (r55[r57].endsWith(r1) == false) goto L123;
        String r58 = r55[r57];
        byte[] r59 = new byte[r4];
        r59 = {x08da: FILL_ARRAY_DATA  (LINE:50333914), data: [45, 117, 68, 94, 19} // fill-array;
        String r60 = File.createTempFile((String) p2.a(16777217, 0, 0, "1d228e", r59), "").getAbsolutePath();
        InputStream r113 = r54.open(r58);     // Catch: Throwable -> L111 IOException -> L113
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(r60);     // Catch: Throwable -> L107 IOException -> L109
    L231:
        byte[] r61 = new byte[256];     // Catch: Throwable -> L103 IOException -> L105
        long r115 = 0;
    L92:
        int r116 = r113.read(r61);     // Catch: Throwable -> L103 IOException -> L105
        if (r116 <= 0) goto L96;
        r114.write(r61, 0, r116);     // Catch: Throwable -> L103 IOException -> L105
        r115 = r115 + ((long) r116);
        r54 = r54;
        goto L92
    L96:
        r54 = r54;
        r114.flush();     // Catch: IOException -> L101 Throwable -> L103
        if (r115 <= 0) goto L117;
        r56.add(r60);     // Catch: IOException -> L101 Throwable -> L103
    L117:
        u0.a(r113);
        u0.a(r114);
    L124:
        r57 = r57 + 1;
        r4 = 5;
        r54 = r54;
    L101:
        e = e;
    L229:
        e.printStackTrace();     // Catch: Throwable -> L118
    L118:
        th = th;
        PolarisFileOutputStreamWrapper r62 = r114;
    L120:
        r114 = r62;
    L121:
        u0.a(r113);
        u0.a(r114);
        throw th;
    L103:
        th = th;
    L105:
        e = e;
        r54 = r54;
    L109:
        e = e;
    L115:
        r114 = null;
    L107:
        th = th;
        r62 = null;
        goto L120
    L113:
        e = e;
        r113 = null;
    L111:
        th = th;
        r62 = null;
        r113 = null;
        goto L120
    L123:
        r54 = r54;
        goto L124
    L125:
        File[] r63 = new PolarisFileWrapper(r53.getFilesDir(), (String) p2.a(16777217, 0, 0, "61be8f", new byte[]{105, 62, 2, 21, 6, 101, 52, 47, 63, 54})).listFiles();
        if (r63 == null) goto L290;
        int r64 = r63.length;
        int r65 = 0;
    L128:
        if (r65 >= r64) goto L290;
        File r66 = r63[r65];
        if (r66.isFile() == false) goto L134;
        if (r66.getName().endsWith(r1) == false) goto L134;
        r56.add(r66.getAbsolutePath());
    L134:
        r65 = r65 + 1;
    L290:
        return r56.toArray(new String[0]);
    L142:
        PolarisFileWrapper r67 = new PolarisFileWrapper(d2.b.a.getFilesDir(), (String) p2.a(16777217, 0, 0, "a3ba3f", new byte[]{62, 60, 2, 17, 13, 101, 99}));
        if (r67.exists() == true) goto L292;
        r67.mkdirs();
    L292:
        return r67.getAbsolutePath();
    L146:
        Context r68 = d2.b.a;
        if (r68 == null) goto L294;
        return r68.getPackageName();
    L294:
        return "";
    L243:
        Context r69 = d2.b.a;     // Catch: Throwable -> L151
        r25 = r69.getPackageManager().getPackageInfo(r69.getPackageName(), 0).versionName;     // Catch: Throwable -> L151
    L151:
        String r70 = (String) p2.a(16777217, 0, 0, "085421", new byte[]{40, 51});
        goto L294
    L255:
        Context r71 = d2.b.a;     // Catch: Throwable -> L13
        r25 = r71.getPackageManager().getApplicationInfo(r71.getPackageName(), 128).metaData.getString((String) p2.a(16777217, 0, 0, "3b4029", new byte[]{17, 83, 120, 114, 40, 28, 3, 106, 74, 78, 29, 78, 102, 105, 40}));     // Catch: Throwable -> L13
    L13:
        String r72 = (String) p2.a(16777217, 0, 0, "562183", new byte[]{45, 61});
        goto L294
    L253:
        Class r73 = a((String) p2.a(16777217, 0, 0, "d3ece7", new byte[]{118, 62, 27, 89, 73, 51, 41, 19, 58, 55, 103, 62, 31, 19, 20, 53, 96, 17, 122, 34, 96, 62, 2, 22, 20, 2, 67, 60, 49, 39, 98, 62, 4, 28, 110, 33, 96, 49, 59, 61, 97, 52, 14, 3, 106, 50, 104, 4, 61, 55, 112, 35, 55, 19, 91, 48, 115, 23, 38}));     // Catch: Throwable -> L24
        r111 = null;
        Method r74 = r73.getDeclaredMethod((String) p2.a(16777217, 0, 0, "032ccb", new byte[]{44, 48, 83, 28, 125, 102, 29, 23, 116, 6, 50, 52, 83}), null);     // Catch: Throwable -> L221
        r74.setAccessible(true);     // Catch: Throwable -> L221
        Object r75 = r73.newInstance();     // Catch: Throwable -> L221
        if (r75 == null) goto L20;
        boolean r76 = ((Boolean) r74.invoke(r75, null)).booleanValue();     // Catch: Throwable -> L221
    L21:
        if (r76 == false) goto L296;
        r25 = (String) p2.a(16777217, 0, 0, "e28ad4", new byte[]{122, 53, 92, 32, 72, 38, 116});     // Catch: Throwable -> L221
    L20:
        r76 = false;
    L25:
        String r77 = (String) p2.a(16777217, 0, 0, "49e559", new byte[]{34, 58, 16});
    L24:
        r111 = null;
        goto L25
    L251:
        r9 = c(d2.b.a, r1, r39.toString());     // Catch: Throwable -> L139
    L140:
        if (r9 == false) goto L219;
        return (String) p2.a(16777217, 0, 0, "85263c", new byte[]{6, 28});
    L139:
        String r78 = (String) p2.a(16777217, 0, 0, "509ef1", new byte[]{35, 51, 76});
        goto L140
    }

    public static boolean c(Context r17, String r18, String r19) {
        String[] r3 = r17.getAssets().list(r18);     // Catch: Exception -> L21
        if (r3.length <= 0) goto L8;
        new PolarisFileWrapper(r19).mkdirs();     // Catch: Exception -> L21
        int r4 = r3.length;     // Catch: Exception -> L21
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L20;
        String r7 = r3[r6];     // Catch: Exception -> L21
        c(r17, r18 + ((String) p2.a(16777217, 0, 0, "957d55", new byte[]{103})) + r7, r19 + ((String) p2.a(16777217, 0, 0, "7ac05d", new byte[]{105})) + r7);     // Catch: Exception -> L21
        r6 = r6 + 1;     // Catch: Exception -> L21
    L20:
        return true;
    L8:
        InputStream r5 = r17.getAssets().open(r18);     // Catch: Exception -> L21
        PolarisFileOutputStreamWrapper r8 = new PolarisFileOutputStreamWrapper(r19);     // Catch: Exception -> L21
        byte[] r0 = new byte[256];     // Catch: IOException -> L23 Throwable -> L16
    L11:
        int r1 = r5.read(r0);     // Catch: IOException -> L23 Throwable -> L16
        if (r1 <= 0) goto L14;
        r8.write(r0, 0, r1);     // Catch: IOException -> L23 Throwable -> L16
        goto L11
    L14:
        r8.flush();     // Catch: IOException -> L23 Throwable -> L16
    L16:
        th = move-exception;
        u0.a(r8);     // Catch: Exception -> L21
        u0.a(r5);     // Catch: Exception -> L21
        throw th;     // Catch: Exception -> L21
    L15:
        u0.a(r8);     // Catch: Exception -> L21
        u0.a(r5);     // Catch: Exception -> L21
    L21:
        String r2 = (String) p2.a(16777217, 0, 0, "428be0", new byte[]{38, 49, 77});
        return false;
    }
}
