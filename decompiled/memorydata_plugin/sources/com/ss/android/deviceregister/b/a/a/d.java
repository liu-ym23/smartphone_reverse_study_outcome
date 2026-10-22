package com.ss.android.deviceregister.b.a.a;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.ss.android.deviceregister.i;
import com.ss.android.deviceregister.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class d extends b {
    private static volatile Pair<byte[], String> i;
    private static volatile Pair<String, byte[]> j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15178b;
    private final boolean c;
    private final String d;
    private final String e;
    private String f;
    private volatile Map<String, String> g;
    private AtomicBoolean h;

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f15180a;

        private a(d r1) {
            this.f15180a = r1;
        }

        /* synthetic */ a(d r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(this.f15180a).set(false);
            String r0 = "";
        L7:
            th = move-exception;
            th.printStackTrace();
        L9:
            d.a(this.f15180a, r0);
            return;
        L4:
            if (d.b(this.f15180a) == null) goto L9;
            d r1 = this.f15180a;     // Catch: Throwable -> L7
            r0 = d.a(r1, d.b(r1));     // Catch: Throwable -> L7
            goto L9
        }
    }

    public d(Context r4, boolean r5, String r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.h = new AtomicBoolean(false);
        this.f15177a = Environment.getExternalStorageState();
        this.f = r6;
        this.c = r5;
        this.f15178b = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.d = r7;
        this.e = r8;
    }

    private String a() {
        return this.f + "/" + this.d;
    }

    static /* synthetic */ String a(d r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private String a(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return "";
    L6:
        JSONObject r6 = new JSONObject();
        Iterator r7 = r4.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (i.a() == false) goto L14;
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r1.getKey(), CharSequence.class, "com.obric.memorydata.plugin"), "device_id") == false) goto L8;
    L14:
        r6.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r1.getValue());
        goto L8
    L16:
        return r6.toString();
    }

    private String a(byte[] r4) {
        if (i == null) goto L10;
        if (Arrays.equals(r4, (byte[]) ZeusTransformUtils.preCheckCast(i.first, byte[].class, "com.obric.memorydata.plugin")) == false) goto L10;
        Object r3 = i.second;
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L10:
        if (j != null) goto L12;
    L14:
        String r0 = null;
        r0 = c.a(r4, this.e);     // Catch: Throwable -> L17
    L19:
        if (r0 == null) goto L21;
        i = new Pair(r4, r0);
    L21:
        return r0;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L12:
        if (Arrays.equals(r4, (byte[]) ZeusTransformUtils.preCheckCast(j.second, byte[].class, "com.obric.memorydata.plugin")) == false) goto L14;
        r3 = j.first;
        goto L8
    }

    static /* synthetic */ AtomicBoolean a(d r0) {
        return r0.h;
    }

    static /* synthetic */ void a(d r0, String r1) {
        r0.e(r1);
    }

    private void a(String r5, String r6, boolean r7) {
        AnonymousClass1 r1 = null;
        if (this.g != null) goto L8;
        c(null);
        if (this.g != null) goto L8;
        this.g = new ConcurrentHashMap();
    L8:
        if (h.a((String) ZeusTransformUtils.preCheckCast(this.g.get(r5), String.class, "com.obric.memorydata.plugin"), r6) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r6) == false) goto L16;
        if (this.g.containsKey(r5) == false) goto L16;
        this.g.remove(r5);
    L18:
        if (r7 == false) goto L21;
        new a(this, r1).run();
        return;
    L21:
        if (this.c == true) goto L23;
        return;
    L23:
        if (this.h.compareAndSet(false, true) == false) goto L28;
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(this), 1000);
        return;
    L28:
        return;
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        this.g.put(r5, r6);
        goto L18
    }

    static /* synthetic */ Map b(d r0) {
        return r0.g;
    }

    private synchronized String c(String r8) {
        monitor-enter(this);
    L88:
        th = move-exception;
        throw th;
    L4:
        if (h.a(r8) == true) goto L14;
        if (this.g == null) goto L14;
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.g.get(r8), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        if (Logger.debug() == false) goto L10;
        Logger.v("DirectoryCacheHelper", "get key = " + r8 + " value = " + r0 + " way = memory dir = " + a());     // Catch: Throwable -> L88
    L10:
        monitor-exit(this);
        return r0;
    L14:
        if ("mounted".equals(this.f15177a) == true) goto L102;
        monitor-exit(this);
        return null;
    L102:
    L64:
        th = th;
        RandomAccessFile r2 = null;
        FileLock r3 = null;
    L120:
    L79:
        th = move-exception;
        if (this.g != null) goto L83;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L83:
        if (r3 != null) goto L100;
    L85:
        if (r2 == null) goto L126;
        r2.close();     // Catch: Exception -> L99 Throwable -> L88
        throw th;     // Catch: Throwable -> L88
    L127:
        throw th;     // Catch: Throwable -> L88
    L126:
        throw th;     // Catch: Throwable -> L88
    L100:
        r3.release();     // Catch: Exception -> L98 Throwable -> L88
        goto L85
    L67:
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L69;
        th.printStackTrace();     // Catch: Throwable -> L79
    L69:
        Logger.d("DirectoryCacheHelper", "load openudid exception " + th);     // Catch: Throwable -> L79
    L71:
        if (this.g != null) goto L73;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L73:
        if (r3 != null) goto L107;
    L75:
        if (r2 != null) goto L112;
    L77:
        monitor-exit(this);
        return null;
    L112:
        r2.close();     // Catch: Exception -> L96 Throwable -> L88
        goto L77
    L107:
        r3.release();     // Catch: Exception -> L97 Throwable -> L88
        goto L75
    L18:
        if (new File(this.f).exists() == true) goto L25;
        Logger.v("DirectoryCacheHelper", "dir : " + this.f + " not exist, read failed");     // Catch: Throwable -> L64
        if (this.g != null) goto L23;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L23:
        monitor-exit(this);
        return null;
    L25:
        File r1 = new File(a());     // Catch: Throwable -> L64
        r2 = new RandomAccessFile(r1, "rwd");     // Catch: Throwable -> L64
        r3 = r2.getChannel().lock();     // Catch: Throwable -> L62
    L60:
        th = th;
        goto L120
    L28:
        if (r1.isFile() == false) goto L54;
        byte[] r4 = new byte[2049];     // Catch: Throwable -> L60
        int r5 = r2.read(r4, 0, 2049);     // Catch: Throwable -> L60
        if (r5 <= 0) goto L54;
        if (r5 >= 2049) goto L54;
        this.g = d(a(Arrays.copyOf(r4, r5)));     // Catch: Throwable -> L60
        if (h.a(r8) == true) goto L35;
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.g.get(r8), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
        if (Logger.debug() == false) goto L46;
        Logger.v("DirectoryCacheHelper", "get key = " + r8 + " value = " + r6 + " way = disk dir = " + a());     // Catch: Throwable -> L60
    L46:
        if (this.g != null) goto L48;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L48:
        if (r3 != null) goto L118;
    L116:
        r2.close();     // Catch: Exception -> L94 Throwable -> L88
    L51:
        monitor-exit(this);
        return r6;
    L118:
        r3.release();     // Catch: Exception -> L93 Throwable -> L88
        goto L116
    L35:
        if (this.g != null) goto L37;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L37:
        if (r3 != null) goto L105;
    L103:
        r2.close();     // Catch: Exception -> L92 Throwable -> L88
    L40:
        monitor-exit(this);
        return null;
    L105:
        r3.release();     // Catch: Exception -> L91 Throwable -> L88
    L54:
        if (this.g != null) goto L56;
        this.g = new ConcurrentHashMap();     // Catch: Throwable -> L88
    L56:
        if (r3 == null) goto L112;
        r3.release();     // Catch: Exception -> L95 Throwable -> L88
    L62:
        th = th;
        r3 = null;
        goto L120
    }

    private Map<String, String> d(String r6) {
        if (h.a(r6) == true) goto L5;
        JSONObject r5 = new JSONObject(r6);
        Iterator<String> r7 = r5.keys();
        ConcurrentHashMap r0 = new ConcurrentHashMap();
    L8:
        if (r7.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r1, (String) ZeusTransformUtils.preCheckCast(r5.get(r1), String.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        return r0;
    L5:
        return new ConcurrentHashMap();
    }

    private void e(String r6) {
        if ("mounted".equals(this.f15177a) == true) goto L5;
        return;
    L5:
        FileLock r0 = null;
        File r1 = new File(this.f);     // Catch: Throwable -> L19
        if (r1.exists() == false) goto L9;
    L11:
        RandomAccessFile r2 = new RandomAccessFile(new File(a()), "rwd");     // Catch: Throwable -> L19
        r0 = r2.getChannel().lock();     // Catch: Throwable -> L17
        byte[] r5 = f(r6);     // Catch: Throwable -> L17
        r2.setLength(0);     // Catch: Throwable -> L17
        r2.write(r5);     // Catch: Throwable -> L17
        if (r0 != null) goto L45;
    L41:
        r2.close();     // Catch: Exception -> L37
        return;
    L58:
        return;
    L45:
        r0.release();     // Catch: Exception -> L36
    L17:
        th = th;
    L51:
    L30:
        th = move-exception;
        if (r0 != null) goto L49;
    L33:
        if (r2 == null) goto L59;
        r2.close();     // Catch: Exception -> L40
        throw th;
    L60:
        throw th;
    L59:
        throw th;
    L49:
        r0.release();     // Catch: Exception -> L39
        goto L33
    L22:
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L24;
        th.printStackTrace();     // Catch: Throwable -> L30
    L24:
        Logger.d("DirectoryCacheHelper", "load exception " + th);     // Catch: Throwable -> L30
        if (r0 != null) goto L43;
    L27:
        if (r2 != null) goto L41;
        return;
    L43:
        r0.release();     // Catch: Exception -> L38
        goto L27
    L9:
        if (r1.mkdirs() == true) goto L11;
        return;
    L19:
        th = th;
        r2 = null;
        goto L51
    }

    private byte[] f(String r5) {
        if (j == null) goto L10;
        if (h.a(r5, (String) ZeusTransformUtils.preCheckCast(j.first, String.class, "com.obric.memorydata.plugin")) == false) goto L10;
        Object r4 = j.second;
    L8:
        return (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin");
    L10:
        if (i != null) goto L12;
    L14:
        byte[] r0 = null;
        r0 = c.a(r5, this.e);     // Catch: Throwable -> L17
    L19:
        if (r0 == null) goto L21;
        j = new Pair(r5, r0);
    L21:
        return r0;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L12:
        if (h.a(r5, (String) ZeusTransformUtils.preCheckCast(i.second, String.class, "com.obric.memorydata.plugin")) == false) goto L14;
        r4 = i.first;
        goto L8
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public String a(String r1) {
        return c(r1);
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public void a(String r3, String r4) {
        if (Logger.debug() == false) goto L5;
        Logger.v("DirectoryCacheHelper", "set key = " + r3 + " value = " + r4 + " dir = " + a());
    L5:
        a(r3, r4, false);
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public void b(String r4) {
        a(r4, null, true);
        l.b(l.f15219a, "ExternalDirectoryCacheHelper#clear key=" + r4 + " path=" + a() + " getCachedString(key)=" + a(r4));
        super.b(r4);
    }
}
