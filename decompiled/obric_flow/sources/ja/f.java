package ja;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.framwork.core.sdkmonitor.HttpResponseException;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil$CompressType;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.utils.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f18309c;
    public final e d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f18310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedList f18311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f18312j;

    public f(Context r5, d r10, LinkedList r11, AtomicBoolean r12) {
        super("LogSender");
        this.f18308b = new Object();
        this.e = -1;
        this.f = 0;
        this.g = 120000;
        this.f18310h = r10;
        this.f18307a = r5;
        this.f18311i = r11;
        this.f18309c = r12;
        if (e.f18305c == null) goto L5;
    L19:
        this.d = e.f18305c;
        return;
    L5:
        monitor-enter(e.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (e.f18305c != null) goto L15;
        e r13 = new e();     // Catch: Throwable -> L13
        if (r5 != null) goto L24;
    L12:
        e.f18305c = r13;     // Catch: Throwable -> L13
        goto L15
    L24:
        r13.f18306a = ea.a.e(r5).getWritableDatabase();     // Catch: Throwable -> L21
    L15:
        monitor-exit(e.class);     // Catch: Throwable -> L13
        goto L19
    }

    public static boolean a(ha.a r10, String r11, byte[] r12) {
        if (r12 != null) goto L5;
        return false;
    L5:
        if (r12.length > 0) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r11) == true) goto L131;
        String r5 = r10.g;
        ConcurrentHashMap r13 = ha.c.f17296a;
        if (((com.bytedance.framwork.core.sdkmonitor.e) r13.get(r5)) == null) goto L124;
        com.bytedance.framwork.core.sdkmonitor.e r14 = (com.bytedance.framwork.core.sdkmonitor.e) r13.get(r10.g);
        r14.getClass();
        String r15 = r14.j(r11).toString();     // Catch: Throwable -> L31
        new HashMap();     // Catch: Throwable -> L31
        if (r14.l() == null) goto L35;
        HashMap r16 = new HashMap();     // Catch: Throwable -> L31
        if (r12.length <= 128) goto L27;
        ByteArrayOutputStream r17 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L31
        GZIPOutputStream r18 = new GZIPOutputStream(r17);     // Catch: Throwable -> L31
        r18.write(r12);     // Catch: Throwable -> L20 IOException -> L22
        r18.close();     // Catch: Throwable -> L31
        r12 = r17.toByteArray();     // Catch: Throwable -> L31
        r16.put("Content-Encoding", "gzip");     // Catch: Throwable -> L31
        goto L27
    L20:
        th = move-exception;
        r18.close();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L22:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L27:
        if (r14.f4722r == false) goto L34;
        byte[] r19 = EncryptorUtil.a(r12.length, r12);     // Catch: Throwable -> L31
        if (r19 == null) goto L33;
        r15 = r15 + "&tt_data=a";     // Catch: Throwable -> L31
        r16.put("Content-Type", "application/octet-stream;tt-data=a");     // Catch: Throwable -> L31
    L33:
        oj.b r110 = r14.l().doPost(r15, r19, r16);     // Catch: Throwable -> L31
        byte[] r111 = r110.f20586b;     // Catch: Throwable -> L31
        HashMap r112 = r110.f20585a;     // Catch: Throwable -> L31
    L36:
        if (r112 != null) goto L38;
    L40:
        String r113 = null;
    L41:
        JSONObject r20 = new JSONObject(new String(r111));     // Catch: Throwable -> L31
        String r114 = r20.optString("data");     // Catch: Throwable -> L47
        if (r114.isEmpty() == true) goto L117;
        String r115 = g.j(r113, r114.getBytes());     // Catch: Throwable -> L47
        if (TextUtils.isEmpty(r115) == true) goto L49;
        r20 = new JSONObject(r115);     // Catch: Throwable -> L47
        goto L117
    L49:
        r20.put("message", "success");     // Catch: Throwable -> L47
    L117:
    L52:
        int r116 = 200;
    L58:
        ha.b r117 = r10.f17290h;
        r117.f17295i = null;
        if (r116 <= 0) goto L98;
        r117.f17293c = false;
        if (r116 != 200) goto L94;
        if (r20 == null) goto L94;
        if ("success".equals(r20.opt("message")) == false) goto L72;
        ha.b r118 = r10.f17290h;
        ea.b r119 = com.bytedance.framwork.core.sdkmonitor.f.b(r118.e).d;
        r119.f16800h = true;
        r119.f16803k = 0;
        com.bytedance.framwork.core.sdkmonitor.f.b(r118.e).f4711c.e = false;
        r118.d = 0;
        r118.f17292b = 0;
        r118.f = 0;
        r118.g = 0;
        r118.f17294h = 0;
        String r120 = r20.optString("redirect");
        long r21 = r20.optLong("delay");
        if (TextUtils.isEmpty(r120) == true) goto L69;
        r10.f17290h.f17295i = r120;
    L69:
        if (r21 <= 0) goto L125;
        ha.b r121 = r10.f17290h;
        r121.f17294h = r21 * 1000;
        com.bytedance.framwork.core.sdkmonitor.e r122 = com.bytedance.framwork.core.sdkmonitor.f.b(r121.e);
        long r22 = r121.f17294h;
        ea.b r123 = r122.d;
        r123.f16800h = false;
        r123.f16802j = System.currentTimeMillis();
        r123.f16803k = r22;
    L125:
        return true;
    L72:
        boolean r124 = "drop data".equals(r20.opt("message"));
        boolean r125 = "drop all data".equals(r20.opt("message"));
        String r23 = r20.optString("redirect");
        long r24 = r20.optLong("delay");
        if (TextUtils.isEmpty(r23) == true) goto L76;
        r10.f17290h.f17295i = r23;
    L76:
        if (r24 <= 0) goto L78;
        ha.b r25 = r10.f17290h;
        r25.f17294h = r24 * 1000;
        com.bytedance.framwork.core.sdkmonitor.e r26 = com.bytedance.framwork.core.sdkmonitor.f.b(r25.e);
        long r27 = r25.f17294h;
        ea.b r28 = r26.d;
        r28.f16800h = false;
        r28.f16802j = System.currentTimeMillis();
        r28.f16803k = r27;
    L78:
        if (r124 == false) goto L80;
        ha.b r126 = r10.f17290h;
        r126.a();
        com.bytedance.framwork.core.sdkmonitor.f.b(r126.e).f4711c.e = true;
    L81:
        if (r125 == false) goto L126;
        ha.b r127 = r10.f17290h;
        r127.a();
        com.bytedance.framwork.core.sdkmonitor.f.b(r127.e).f4711c.e = true;
        com.bytedance.framwork.core.sdkmonitor.e r128 = com.bytedance.framwork.core.sdkmonitor.f.b(r127.e);
        r128.getClass();
        ea.d r129 = r128.f4711c;     // Catch: Throwable -> L112
        LinkedList r29 = r129.f16810b;     // Catch: Throwable -> L112
        monitor-enter(r29);     // Catch: Throwable -> L112
        r129.f16810b.clear();     // Catch: Throwable -> L89
        monitor-exit(r29);     // Catch: Throwable -> L89
        r128.d.b(2147483647L);     // Catch: Throwable -> L112
        goto L92
    L89:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112
    L92:
        com.bytedance.framwork.core.sdkmonitor.e r130 = com.bytedance.framwork.core.sdkmonitor.f.b(r127.e);
        r130.d.f16801i = true;
        r130.f4721q = true;
        return false;
    L126:
        return false;
    L80:
        com.bytedance.framwork.core.sdkmonitor.f.b(r10.f17290h.e).f4711c.e = false;
    L94:
        if (500 <= r116) goto L96;
        return false;
    L96:
        if (r116 > 600) goto L129;
        r117.a();
        return false;
    L129:
        return false;
    L98:
        int r131 = r117.f;
        if (r131 != 0) goto L101;
        r117.g = 30000;
        r117.f++;
    L110:
        com.bytedance.framwork.core.sdkmonitor.e r132 = com.bytedance.framwork.core.sdkmonitor.f.b(r117.e);
        long r30 = r117.g;
        ea.b r133 = r132.d;
        r133.f16800h = false;
        r133.f16802j = System.currentTimeMillis();
        r133.f16803k = r30;
        r10.f17290h.f17293c = true;
        return false;
    L101:
        if (r131 != 1) goto L104;
        r117.g = 60000;
        r117.f++;
        goto L110
    L104:
        if (r131 != 2) goto L107;
        r117.g = 120000;
        r117.f++;
        goto L110
    L107:
        if (r131 != 3) goto L109;
        r117.g = 240000;
        r117.f++;
        goto L110
    L109:
        r117.g = 300000;
        r117.f++;
        goto L110
    L47:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L31
        goto L52
    L38:
        if (r112.isEmpty() == true) goto L40;
        r113 = (String) r112.get("ran");     // Catch: Throwable -> L31
        goto L41
    L34:
        oj.b r134 = r14.l().doPost(r15, r12, r16);     // Catch: Throwable -> L31
        r111 = r134.f20586b;     // Catch: Throwable -> L31
        r112 = r134.f20585a;     // Catch: Throwable -> L31
        goto L36
    L35:
        oj.b r135 = f4.b.g(r15, r12, MonitorNetUtil$CompressType.GZIP, r14.f4722r);     // Catch: Throwable -> L31
        r111 = r135.f20586b;     // Catch: Throwable -> L31
        r112 = r135.f20585a;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L56;
        r116 = th.getStatusCode();
    L57:
        r20 = null;
        goto L58
    L56:
        r116 = -1;
        goto L57
    L124:
        return false;
    L131:
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
    L4:
        if (this.f18309c.get() == true) goto L260;
        Cursor r5 = null;
        q7.a r10 = null;
        boolean r11 = false;
        if (this.f18309c.get() == false) goto L8;
    L7:
        boolean r12 = false;
    L29:
        if (this.f18309c.get() == true) goto L304;
        if (this.f18309c.get() == false) goto L35;
    L33:
        boolean r13 = true;
        boolean r14 = false;
    L234:
        if (r11 == true) goto L236;
        if (r12 == true) goto L236;
    L238:
        if (this.f18309c.get() == true) goto L305;
        if (r14 == true) goto L4;
        Object r15 = this.f18308b;
        monitor-enter(r15);
        long r16 = this.g;     // Catch: Throwable -> L247 InterruptedException -> L261
        if (r16 != 0) goto L249;
        this.f18308b.wait();     // Catch: Throwable -> L247 InterruptedException -> L261
        goto L250
    L249:
        this.f18308b.wait(r16);     // Catch: Throwable -> L247 InterruptedException -> L261
        goto L250
    L247:
        th = move-exception;
        throw th;
    L250:
        monitor-exit(r15);     // Catch: Throwable -> L247
        goto L4
    L305:
        return;
    L236:
        r14 = r13;
        goto L238
    L35:
        if (this.e >= 0) goto L64;
        if ((System.currentTimeMillis() - this.f) <= 600000) goto L64;
        this.e = 0;
        AtomicBoolean r17 = this.f18309c;
        if (r17.get() == true) goto L62;
        ConcurrentHashMap r18 = (ConcurrentHashMap) this.f18310h.f18301a;
        e r19 = this.d;
        if (r18 != null) goto L44;
    L61:
        r19.a(-1, null, 864000000);
        goto L62
    L44:
        if (r18.isEmpty() == true) goto L61;
        Iterator r110 = r18.keySet().iterator();
    L47:
        if (r110.hasNext() == false) goto L61;
        String r111 = (String) r110.next();
        if (r17.get() == true) goto L61;
        ha.a r112 = (ha.a) r18.get(r111);
        if (r112 == null) goto L47;
        q7.a r113 = r112.f17288b;
        ConcurrentHashMap r114 = fa.c.f16887a;
        String r115 = (String) r113.f21488b;
        if (TextUtils.isEmpty(r115) == true) goto L59;
        ConcurrentHashMap r116 = fa.c.f16887a;
        if (r116.get(r115) == null) goto L59;
        int r117 = ((fa.b) r116.get(r115)).f();
    L60:
        r19.a(r117, r111, 604800000);
    L59:
        r117 = 4;
    L62:
        this.f = System.currentTimeMillis();
    L64:
        if (c.f18299a.b(this.f18307a) == true) goto L66;
        this.g = 120000;
        goto L33
    L66:
        e r118 = this.d;
        long r119 = this.e;
        monitor-enter(r118);
    L88:
        th = move-exception;
        throw th;
    L69:
        if (r118.c() == true) goto L289;
        monitor-exit(r118);
        a r120 = null;
    L97:
        if (r120 == null) goto L99;
        long r121 = this.e;
        long r122 = r120.f18296a;
        if (r121 >= r122) goto L132;
        this.e = r122;
    L133:
        byte[] r20 = r120.f18297b;
        if (r20 != null) goto L136;
    L137:
        r14 = false;
        ha.a r21 = null;
        boolean r28 = false;
        r11 = true;
    L216:
        if (this.f18309c.get() == true) goto L164;
        if (r11 == false) goto L220;
        this.d.d(r120.f18296a, 0, 0, true);
        r13 = true;
    L141:
        r11 = r13;
        goto L234
    L220:
        e r22 = this.d;
        long r23 = r120.f18296a;
        r10.getClass();
        ConcurrentHashMap r24 = fa.c.f16887a;
        String r25 = (String) r10.f21488b;
        if (TextUtils.isEmpty(r25) == true) goto L225;
        ConcurrentHashMap r123 = fa.c.f16887a;
        if (r123.get(r25) == null) goto L225;
        int r27 = ((fa.b) r123.get(r25)).f();
    L227:
        if (r22.d(r23, 604800000, r27, r28) == false) goto L232;
        r13 = true;
        long r26 = r10.p() * ((long) (r120.f18298c + 1));
        if (r26 <= 0) goto L231;
        this.g = r26;
    L231:
        this.g = Math.min(120000, this.g);
    L233:
        r21.getClass();
        goto L141
    L232:
        r13 = true;
        this.g = 120000;
    L225:
        r27 = 4;
    L164:
        r11 = true;
        r13 = true;
        goto L234
    L136:
        if (r20.length <= 0) goto L137;
        d r29 = this.f18310h;
        r21 = (ha.a) ((ConcurrentHashMap) r29.f18301a).get(r120.e);
        if (r21 != null) goto L142;
        r13 = true;
        r14 = false;
        goto L141
    L142:
        q7.a r124 = r21.f17288b;
        s6.c r30 = r21.e;
        long r125 = System.currentTimeMillis();
        long r126 = r124.p();
        ConcurrentHashMap r127 = fa.c.f16887a;
        String r128 = (String) r30.f21828b;
        if (TextUtils.isEmpty(r128) == true) goto L147;
        ConcurrentHashMap r31 = fa.c.f16887a;
        if (r31.get(r128) == null) goto L147;
        boolean r32 = ((fa.b) r31.get(r128)).c();
    L148:
        if (r32 == false) goto L151;
        r28 = true;
        r14 = false;
    L150:
        r10 = r124;
        goto L216
    L151:
        ha.b r33 = (ha.b) r30.f21829c;
        if (r33.f17292b <= r33.g) goto L154;
        long r34 = r33.f17292b;
    L156:
        if (r34 > r33.f17294h) goto L160;
        r34 = r33.f17294h;
    L160:
        if (r34 > 0) goto L162;
    L165:
        r21.f = System.currentTimeMillis();
        if (r126 <= 0) goto L172;
        int r35 = r120.f18298c;
        if (r35 <= 0) goto L172;
        if ((r125 - r120.d) >= (r126 * ((long) r35))) goto L172;
    L163:
        r14 = false;
    L172:
        String r36 = r21.d;
        List r37 = r124.h();
        if (r37 == null) goto L163;
        String r38 = r124.n();     // Catch: Throwable -> L211
        if (TextUtils.isEmpty(r38) == true) goto L182;
        boolean r39 = a(r21, r38, r120.f18297b);     // Catch: Throwable -> L179
    L178:
        r14 = false;
    L208:
        r28 = r39;
        r11 = r14;
    L179:
        th = th;
        r14 = false;
        boolean r210 = false;
    L213:
        th.toString();
        r21 = r21;
        r11 = r14;
        r10 = r124;
        r28 = r210;
        goto L216
    L182:
        if (TextUtils.isEmpty(r36) == true) goto L192;
        boolean r40 = a(r21, r36, r120.f18297b);     // Catch: Throwable -> L179
        if (r40 == false) goto L272;
    L190:
        r39 = r40;
        goto L178
    L272:
        r21.d = "";     // Catch: Throwable -> L188
    L188:
        th = th;
        r210 = r40;
        r14 = false;
        goto L213
    L192:
        if (((ha.b) r30.f21829c).f17293c == false) goto L194;
        this.f18312j++;     // Catch: Throwable -> L179
    L194:
        int r41 = r37.size();     // Catch: Throwable -> L211
        int r42 = this.f18312j;     // Catch: Throwable -> L211
        if (r41 <= r42) goto L199;
        if (r42 < 0) goto L199;
        String r43 = (String) r37.get(r42);     // Catch: Throwable -> L179
        r14 = false;
    L279:
        boolean r44 = a(r21, r43, r120.f18297b);     // Catch: Throwable -> L209
        if (r44 == true) goto L266;
    L207:
        r39 = r44;
        goto L208
    L266:
        r21.d = r43;     // Catch: Throwable -> L205
    L205:
        th = th;
        r210 = r44;
    L209:
        th = th;
    L210:
        r210 = r14;
    L199:
        r14 = false;
        this.f18312j = 0;     // Catch: Throwable -> L209
        r43 = (String) r37.get(0);     // Catch: Throwable -> L209
    L211:
        th = th;
        r14 = false;
        goto L210
    L162:
        if ((r125 - r21.f) >= r34) goto L165;
    L154:
        r34 = r33.g;
    L147:
        r32 = false;
        goto L148
    L132:
        this.e = r121 + 1;
        goto L133
    L99:
        if (this.e != 0) goto L126;
        e r45 = this.d;
        monitor-enter(r45);
        if (r45.c() == true) goto L277;
        monitor-exit(r45);
        long r129 = 0;
    L121:
        if (r129 != 0) goto L126;
        this.g = 0;
        goto L33
    L277:
        String r130 = "select count(*) from queue";
        if (TextUtils.isEmpty(null) == true) goto L109;
        r130 = "select count(*) from queue null";     // Catch: Throwable -> L117
    L109:
        Cursor r46 = r45.f18306a.rawQuery(r130, null);     // Catch: Throwable -> L117
        if (r46.moveToNext() == false) goto L113;
        r129 = r46.getLong(0);     // Catch: Throwable -> L117
    L114:
        e.f(r46);     // Catch: Throwable -> L115
    L119:
        monitor-exit(r45);
        goto L121
    L113:
        r129 = 0;
        goto L114
    L117:
        e.f(null);     // Catch: Throwable -> L115
        r129 = 0;
    L115:
        th = move-exception;
        throw th;
    L126:
        if (this.e != (-1)) goto L128;
        this.g = 120000;
    L128:
        this.e = -1;
        goto L33
    L289:
        Cursor r131 = r118.f18306a.query("queue", e.f18304b, "_id > ?", new String[]{String.valueOf(r119)}, null, null, "_id ASC", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L90 Exception -> L92
        if (r131.moveToNext() == false) goto L85;
        r120 = new a();     // Catch: Throwable -> L78 Exception -> L83
        r120.f18296a = r131.getLong(0);     // Catch: Throwable -> L78 Exception -> L80
        r120.f18297b = r131.getBlob(1);     // Catch: Throwable -> L78 Exception -> L80
        r120.e = r131.getString(2);     // Catch: Throwable -> L78 Exception -> L80
        r131.getLong(3);     // Catch: Throwable -> L78 Exception -> L80
        r120.f18298c = r131.getInt(4);     // Catch: Throwable -> L78 Exception -> L80
        r120.d = r131.getLong(5);     // Catch: Throwable -> L78 Exception -> L80
    L86:
        e.f(r131);     // Catch: Throwable -> L88
        monitor-exit(r118);
    L80:
        e = e;
    L94:
        e.toString();     // Catch: Throwable -> L78
        goto L86
    L85:
        r120 = null;
    L83:
        e = e;
        r120 = null;
    L78:
        th = th;
        r5 = r131;
    L254:
        e.f(r5);     // Catch: Throwable -> L88
        throw th;     // Catch: Throwable -> L88
    L92:
        e = e;
        r131 = null;
        r120 = null;
    L90:
        th = th;
        goto L254
    L304:
        return;
    L8:
        LinkedList r47 = this.f18311i;
        monitor-enter(r47);
        if (this.f18309c.get() == false) goto L17;
        monitor-exit(r47);     // Catch: Throwable -> L14
        goto L7
    L17:
        if (this.f18311i.isEmpty() == true) goto L19;
        a r48 = (a) this.f18311i.poll();     // Catch: Throwable -> L14
    L20:
        r12 = !this.f18311i.isEmpty();     // Catch: Throwable -> L14
        monitor-exit(r47);     // Catch: Throwable -> L14
        if (r48 == null) goto L29;
    L27:
        this.d.e();
        goto L29
    L24:
        if (this.d.b(r48.e, r48.f18297b) < Long.MAX_VALUE) goto L29;
        this.d.e();     // Catch: SQLiteFullException -> L27
        goto L29
    L19:
        r48 = null;
    L14:
        th = move-exception;
        throw th;
    }
}
