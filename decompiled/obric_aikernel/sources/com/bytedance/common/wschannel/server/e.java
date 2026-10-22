package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f1418f = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MappedByteBuffer f1420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PriorityQueue<Integer> f1421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, C0049e> f1422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f1423e;

    class a extends g2.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f1424i;

        a(e r10, long r11, long r12) {
            this.f1424i = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.a(this.f1424i).get() == false) goto L5;
            return;
        L5:
            e.b(this.f1424i);
            e.c(this.f1424i, null, 2, -1);
        }
    }

    class b extends g2.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1425i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f1426j;

        b(e r10, String r11) {
            this.f1426j = r10;
            this.f1425i = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c(this.f1426j, this.f1425i, 0, -1);
        }
    }

    class c extends g2.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1427i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f1428j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ e f1429k;

        c(e r10, String r11, long r12) {
            this.f1429k = r10;
            this.f1427i = r11;
            this.f1428j = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = e.d(this.f1429k, this.f1427i, this.f1428j);
            if (r10 < 0) goto L10;
            C0049e r11 = (C0049e) e.e(this.f1429k).get(this.f1427i);
            if (r11 == null) goto L8;
            r11.c(r10);
        L8:
            if (Logger.debug() == false) goto L12;
            Logger.d(e.f(), "mapToFile success, message id:" + this.f1427i + " offset:" + r10);
            return;
        L12:
            return;
        L10:
            e.c(this.f1429k, this.f1427i, 1, -1);
        }
    }

    class d extends g2.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f1430i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f1431j;

        d(e r10, List r11) {
            this.f1431j = r10;
            this.f1430i = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f1430i.iterator();
            boolean r11 = false;
        L4:
            if (r10.hasNext() == false) goto L10;
            String r12 = (String) r10.next();
            if (e.e(this.f1431j).containsKey(r12) == false) goto L4;
            int r13 = ((C0049e) e.e(this.f1431j).get(r12)).a();
            e.e(this.f1431j).remove(r12);
            e.g(this.f1431j, r13);
            if (r11 == true) goto L4;
            r11 = true;
            goto L4
        L10:
            if (r11 == false) goto L20;
            e.h(this.f1431j);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.e$e, reason: collision with other inner class name */
    static class C0049e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1433b;

        public C0049e(long r10, int r11) {
            this.f1432a = r10;
            this.f1433b = r11;
        }

        public int a() {
            return this.f1433b;
        }

        public long b() {
            return this.f1432a;
        }

        public void c(int r10) {
            this.f1433b = r10;
        }
    }

    static {
    }

    public e(Context r13) {
        this.f1419a = new byte[40];
        this.f1421c = new PriorityQueue();
        this.f1422d = new ConcurrentHashMap();
        this.f1423e = new AtomicBoolean(false);
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L23
        FileChannel r14 = new RandomAccessFile(g2.a.a(r13), "rw").getChannel();     // Catch: Throwable -> L23
        FileLock r11 = r14.tryLock();     // Catch: Throwable -> L21
        this.f1420b = r14.map(FileChannel.MapMode.READ_WRITE, 0, PlaybackStateCompat.ACTION_SET_REPEAT_MODE);     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L9;
        Logger.d(f1418f, "magic number: " + l() + " file version: " + k() + " total count: " + n() + " total bytes: " + m());     // Catch: Throwable -> L19
    L9:
        if (l() == 2114) goto L11;
    L16:
        y();     // Catch: Throwable -> L19
    L17:
        g2.d.d().e(new a(this, 3600000, 3600000));     // Catch: Throwable -> L19
        x(null, 4, System.currentTimeMillis() - r10);     // Catch: Throwable -> L19
        return;
    L11:
        if (m() <= 0) goto L16;
        if (n() <= 0) goto L16;
        p();     // Catch: Throwable -> L19
    L19:
        Throwable th = th;
    L25:
        Logger.e(f1418f, "create MappedByteBuffer failed: ", th);
        this.f1423e.set(true);
        w(5, th);
        if (r11 != null) goto L32;
    L28:
        if (r14 == null) goto L40;
        r14.close();     // Catch: IOException -> L31
        return;
    L42:
        return;
    L40:
        return;
    L32:
        r11.release();     // Catch: IOException -> L31
    L21:
        th = move-exception;
        r11 = null;
        th = th;
    L23:
        th = move-exception;
        r11 = null;
        th = th;
        r14 = null;
        goto L25
    }

    private void A(int r10) {
        this.f1420b.putInt(4, r10);
    }

    static /* synthetic */ AtomicBoolean a(e r10) {
        return r10.f1423e;
    }

    static /* synthetic */ void b(e r10) {
        r10.u();
    }

    static /* synthetic */ void c(e r10, String r11, int r12, long r13) {
        r10.x(r11, r12, r13);
    }

    static /* synthetic */ int d(e r10, String r11, long r12) {
        return r10.r(r11, r12);
    }

    static /* synthetic */ ConcurrentHashMap e(e r10) {
        return r10.f1422d;
    }

    static /* synthetic */ String f() {
        return f1418f;
    }

    static /* synthetic */ void g(e r10, int r11) {
        r10.v(r11);
    }

    static /* synthetic */ void h(e r10) {
        r10.j();
    }

    private void j() {
        this.f1420b.force();
    }

    private long k() {
        return this.f1420b.getShort(2);
    }

    private short l() {
        return this.f1420b.getShort(0);
    }

    private int m() {
        return this.f1420b.getInt(8);
    }

    private int n() {
        return this.f1420b.getInt(4);
    }

    private void p() {
        this.f1420b.position(12);
        long r10 = System.currentTimeMillis();
        int r11 = m() / 40;
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 >= r11) goto L19;
        byte[] r14 = new byte[32];
        this.f1420b.get(r14);
        long r15 = this.f1420b.getLong();
        if (q(r14) == false) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d(f1418f, "Data is empty, bypass remove offset:" + r12);
    L9:
        this.f1421c.add(Integer.valueOf(r12));
    L18:
        r12 = r12 + 1;
        goto L3
    L11:
        if (r15 >= r10) goto L15;
        v(r12);
        if (r13 == true) goto L18;
        r13 = true;
        goto L18
    L15:
        String r16 = new String(r14, StandardCharsets.UTF_8);
        C0049e r17 = new C0049e(r15, r12);
        this.f1422d.put(r16, r17);
        if (Logger.debug() == false) goto L18;
        Logger.d(f1418f, "initPersistentBuffer item: " + new String(r14) + "&" + r17.b() + "_" + r17.a());
        goto L18
    L19:
        if (r13 == false) goto L22;
        j();
    L22:
        if (Logger.debug() == false) goto L31;
        Logger.d(f1418f, "map size:" + this.f1422d.size() + " total count:" + n() + " data size:" + r11 + " total bytes:" + m());
        return;
    }

    private boolean q(byte[] r10) {
        if (r10 != null) goto L5;
    L14:
        return true;
    L5:
        if (r10.length == 0) goto L14;
        int r11 = 0;
    L9:
        if (r11 >= r10.length) goto L14;
        if (r10[r11] != 0) goto L12;
        r11 = r11 + 1;
        goto L9
    L12:
        return false;
    }

    private int r(String r10, long r11) {
        byte[] r12 = r10.getBytes();
        if (r12 != null) goto L5;
    L27:
        return -1;
    L5:
        if (r12.length != 32) goto L27;
        int r13 = s(r12, r11);
        if (r13 < 0) goto L11;
        return r13;
    L11:
        if (this.f1420b.remaining() >= 40) goto L13;
    L22:
        String r14 = f1418f;
        Logger.i(r14, "remaining:" + this.f1420b.remaining() + " total count:" + n() + " threshold:6553 total bytes:" + m() + " threshold:262104");
        x(r10, 3, -1);
        t();
        int r15 = s(r12, r11);
        if (r15 >= 0) goto L26;
        Logger.e(r14, "Push data failed, removeDataForAvailableStorage is not working.");
        return -1;
    L26:
        return r15;
    L13:
        if (n() >= 6553) goto L22;
        if (m() >= 262104) goto L22;
        this.f1420b.position(m() + 12);
        this.f1420b.put(r12);
        this.f1420b.putLong(r11);
        int r16 = n();
        A(r16 + 1);
        z(m() + 40);
        if (Logger.debug() == false) goto L20;
        Logger.d(f1418f, String.format("push success in file: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r16), Integer.valueOf(n()), Integer.valueOf(m()), r10}));
    L20:
        j();
        return r16;
    }

    private int s(byte[] r10, long r11) {
        if (this.f1421c.isEmpty() == false) goto L6;
        return -1;
    L6:
        int r12 = this.f1421c.poll().intValue();
        this.f1420b.position((r12 * 40) + 12);
        this.f1420b.put(r10);
        this.f1420b.putLong(r11);
        A(n() + 1);
        if (Logger.debug() == false) goto L9;
        Logger.d(f1418f, String.format("push success in queue: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r12), Integer.valueOf(n()), Integer.valueOf(m()), new String(r10)}));
    L9:
        return r12;
    }

    private void t() {
        Logger.i(f1418f, "available:1092 queue:" + this.f1421c.size());
        Iterator<Map.Entry<String, C0049e>> r10 = this.f1422d.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        C0049e r11 = r10.next().getValue();
        if (r11.a() >= 1092) goto L4;
        v(r11.a());
        r10.remove();
        goto L4
    }

    private void u() {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1418f, "removeExpiredCachedData");
    L5:
        Iterator<Map.Entry<String, C0049e>> r10 = this.f1422d.entrySet().iterator();
        long r11 = System.currentTimeMillis();
        boolean r12 = false;
    L7:
        if (r10.hasNext() == false) goto L13;
        C0049e r13 = r10.next().getValue();
        if (r13.b() >= r11) goto L7;
        v(r13.a());
        r10.remove();
        if (r12 == true) goto L7;
        r12 = true;
        goto L7
    L13:
        if (r12 == false) goto L23;
        j();
        return;
    }

    private void v(int r10) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        this.f1420b.position((r10 * 40) + 12);
        this.f1420b.put(this.f1419a);
        A(n() - 1);
        this.f1421c.add(Integer.valueOf(r10));
        if (Logger.debug() == false) goto L8;
        Logger.d(f1418f, String.format("remove success: offset=%s, totalCount=%s, totalBytes=%s", new Object[]{Integer.valueOf(r10), Integer.valueOf(n()), Integer.valueOf(m())}));
        return;
    }

    private void w(int r10, Throwable r11) {
        JSONObject r12 = new JSONObject();
        r12.put("action", r10);     // Catch: JSONException -> L10
        String r13 = g2.c.p(r11);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r13) == false) goto L6;
    L8:
        r12.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r13);     // Catch: JSONException -> L10
    L12:
        com.bytedance.common.wschannel.server.d.k(r12);
        return;
    L6:
        if (r13.length() <= 2048) goto L8;
        r13 = r13.substring(0, 2048);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void x(String r10, int r11, long r12) {
        int r13 = this.f1422d.size();
        int r14 = this.f1421c.size();
        int r15 = n();
        int r16 = m();
        JSONObject r17 = new JSONObject();
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        com.bytedance.common.wschannel.server.d.k(r17);
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L7;
        r17.put("messageId", r10);     // Catch: JSONException -> L11
    L7:
        if (r12 < 0) goto L9;
        r17.put("duration", r12);     // Catch: JSONException -> L11
    L9:
        r17.put("action", r11);     // Catch: JSONException -> L11
        r17.put("mapSize", r13);     // Catch: JSONException -> L11
        r17.put("queueSize", r14);     // Catch: JSONException -> L11
        r17.put("totalCount", r15);     // Catch: JSONException -> L11
        r17.put("totalBytes", r16);     // Catch: JSONException -> L11
        goto L13
    }

    private void y() {
        Logger.i(f1418f, "reset");
        this.f1420b.clear();
        this.f1420b.putShort(2114);
        this.f1420b.putShort(1);
        this.f1420b.putInt(0);
        this.f1420b.putInt(0);
    }

    private void z(int r10) {
        this.f1420b.putInt(8, r10);
    }

    public boolean B(String r10, long r11) {
        if (this.f1423e.get() == false) goto L6;
        return false;
    L6:
        if (this.f1422d.containsKey(r10) == false) goto L9;
        Logger.i(f1418f, "Drop existed messageId:" + r10);
        g2.d.d().e(new b(this, r10));
        return true;
    L9:
        long r12 = System.currentTimeMillis() + r11;
        this.f1422d.put(r10, new C0049e(r12, -1));
        g2.d.d().e(new c(this, r10, r12));
        return false;
    }

    public void i(String[] r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1418f, "ack message id: " + Arrays.toString(r10));
    L6:
        if (this.f1423e.get() == true) goto L36;
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.length == 0) goto L38;
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L25;
        String r14 = r10[r13];
        if (TextUtils.isEmpty(r14) == true) goto L23;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L17:
        if (r14.getBytes("UTF-8").length != 32) goto L23;
        r11.add(r14);     // Catch: UnsupportedEncodingException -> L21
    L23:
        r13 = r13 + 1;
        goto L12
    L25:
        if (r11.isEmpty() == false) goto L27;
        return;
    L27:
        g2.d.d().e(new d(this, r11));
        return;
    L38:
        return;
    }

    public void o() {
        com.bytedance.common.wschannel.server.d.l();
    }
}
