package com.loc;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<ea> f5478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f5479b;
    private boolean c;
    private Handler d;
    private String e;
    private boolean f;
    private Runnable g;

    public eb(Context r3, Handler r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f5478a = new LinkedList();
        this.c = false;
        this.e = null;
        this.g = new AnonymousClass1(this);
        this.d = r4;
        String r6 = r5.getFilesDir().getPath();
        if (this.e != null) goto L13;
        this.e = fd.l(r5);
    L13:
        this.f5479b = new File(r6, "hisloc");     // Catch: Throwable -> L7
    L9:
        a();
        Handler r7 = this.d;
        if (r7 == null) goto L15;
        r7.removeCallbacks(this.g);
        this.d.postDelayed(this.g, 60000);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        de.a(th);
        goto L9
    }

    private void a() {
        LinkedList<ea> r0 = this.f5478a;
        if (r0 != null) goto L5;
    L7:
        Iterator<String> r1 = fd.a(this.f5479b).iterator();
    L9:
        if (r1.hasNext() == false) goto L17;
        String r2 = new String(eh.b(fq.b((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")), this.e), RpcUtils.CHARSET_UTF8);     // Catch: JSONException -> L13 UnsupportedEncodingException -> L15
        ea r3 = new ea();     // Catch: JSONException -> L13 UnsupportedEncodingException -> L15
        r3.a(new JSONObject(r2));     // Catch: JSONException -> L13 UnsupportedEncodingException -> L15
        this.f5478a.add(r3);     // Catch: JSONException -> L13 UnsupportedEncodingException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L17:
        return;
    L5:
        if (r0.size() <= 0) goto L7;
    }

    private void a(ea r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<ea> r0 = this.f5478a.iterator();
        ea r2 = null;
        int r4 = 0;
        ea r3 = null;
    L6:
        if (r0.hasNext() == false) goto L13;
        ea r5 = (ea) ZeusTransformUtils.preCheckCast(r0.next(), ea.class, "com.obric.memorydata.plugin");
        if (r5.f5476a != r11) goto L6;
        if (r3 != null) goto L11;
        r3 = r5;
    L11:
        r4 = r4 + 1;
        r2 = r5;
        goto L6
    L13:
        if (r2 == null) goto L20;
        if ((r10.d - r2.d) >= 20000) goto L20;
        if (fd.a(new double[]{r10.f5477b, r10.c, r2.f5477b, r2.c}) >= 20.0f) goto L20;
        return;
    L20:
        if (r4 < 5) goto L23;
        this.f5478a.remove(r3);
    L23:
        if (this.f5478a.size() < 10) goto L25;
        this.f5478a.removeFirst();
    L25:
        this.f5478a.add(r10);
        this.f = true;
    }

    static /* synthetic */ boolean a(eb r0) {
        return r0.c;
    }

    private void b() {
        StringBuilder r0 = new StringBuilder();
        Iterator<ea> r1 = this.f5478a.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        r0.append(fq.b(eh.a(((ea) ZeusTransformUtils.preCheckCast(r1.next(), ea.class, "com.obric.memorydata.plugin")).a().getBytes(RpcUtils.CHARSET_UTF8), this.e)) + "\n");     // Catch: UnsupportedEncodingException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        String r2 = r0.toString();
        if (TextUtils.isEmpty(r2) == true) goto L20;
        fd.a(this.f5479b, r2);
        return;
    }

    static /* synthetic */ boolean b(eb r0) {
        return r0.f;
    }

    private static boolean b(ArrayList<dt> r5, ArrayList<db> r6) {
        if (r5 != null) goto L5;
    L17:
        return true;
    L5:
        if (r5.size() <= 0) goto L17;
        if (r6 == null) goto L17;
        if (r6.size() <= 0) goto L17;
        if (r5.size() < 4) goto L15;
        return false;
    L15:
        if (r6.size() < 20) goto L17;
        return false;
    }

    static /* synthetic */ void c(eb r0) {
        r0.b();
    }

    static /* synthetic */ boolean d(eb r1) {
        r1.f = false;
        return false;
    }

    static /* synthetic */ Handler e(eb r0) {
        return r0.d;
    }

    static /* synthetic */ Runnable f(eb r0) {
        return r0.g;
    }

    public final List<ea> a(ArrayList<dt> r8, ArrayList<db> r9) {
        if (b(r8, r9) == false) goto L13;
        long r10 = System.currentTimeMillis();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        Iterator<ea> r7 = this.f5478a.iterator();
    L6:
        if (r7.hasNext() == false) goto L12;
        ea r2 = (ea) ZeusTransformUtils.preCheckCast(r7.next(), ea.class, "com.obric.memorydata.plugin");
        if ((r10 - r2.d) >= 21600000000L) goto L11;
        r0.add(r2);
        r1 = r1 + 1;
    L11:
        if (r1 != 10) goto L6;
    L12:
        return r0;
    L13:
        return null;
    }

    public final void a(ea r2) {
        a(r2, 1);
    }

    public final void a(boolean r2) {
        if (r2 == true) goto L4;
        this.g.run();
    L4:
        Handler r3 = this.d;
        if (r3 == null) goto L7;
        r3.removeCallbacks(this.g);
    L7:
        this.c = true;
    }

    public final void b(ea r2) {
        a(r2, 12);
    }

    public final void c(ea r10) {
        if (this.f5478a.size() > 0) goto L5;
        return;
    L5:
        if (r10.f5476a != 6) goto L7;
    L15:
        ea r0 = (ea) ZeusTransformUtils.preCheckCast(this.f5478a.getLast(), ea.class, "com.obric.memorydata.plugin");
        if (r0.c != r10.c) goto L22;
        if (r0.f5477b != r10.f5477b) goto L22;
        if (r0.e != r10.e) goto L22;
        return;
    L22:
        if (this.f5478a.size() < 10) goto L24;
        this.f5478a.removeFirst();
    L24:
        this.f5478a.add(r10);
        this.f = true;
        return;
    L7:
        if (r10.f5476a == 5) goto L15;
        if (this.f5478a.contains(r10) == false) goto L12;
        return;
    L12:
        if (this.f5478a.size() < 10) goto L14;
        this.f5478a.removeFirst();
    L14:
        this.f5478a.add(r10);
        this.f = true;
    }
}
