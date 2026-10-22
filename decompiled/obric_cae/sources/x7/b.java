package x7;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<o> f13593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<c> f13594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<x7.a> f13595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13597e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f13598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f13599b;

        public a(b r8, m r10) {
            this.f13599b = r8;
            this.f13598a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LinkedList<o> r8 = this.f13599b.f13593a;     // Catch: Throwable -> L48
            monitor-enter(r8);     // Catch: Throwable -> L48
            LinkedList r10 = new LinkedList(this.f13599b.f13593a);     // Catch: Throwable -> L43
            this.f13599b.f13593a.clear();     // Catch: Throwable -> L43
            monitor-exit(r8);     // Catch: Throwable -> L43
            Iterator r11 = r10.iterator();     // Catch: Throwable -> L48
        L8:
            if (r11.hasNext() == false) goto L15;
            o r12 = (o) r11.next();     // Catch: Throwable -> L48
            b r13 = this.f13599b;     // Catch: Throwable -> L48
            m r14 = this.f13598a;     // Catch: Throwable -> L48
            r13.getClass();     // Catch: Throwable -> L48
            if (r12 == null) goto L8;
            if (TextUtils.isEmpty(r12.f13667a) == true) goto L8;
            r14.s(r12.f13667a, r12.f13668b, r12.f13669c, r12.f13670d, r12.f13671e, r12.f13672f, r12.f13673g);     // Catch: Throwable -> L48
            goto L8
        L15:
            LinkedList<c> r15 = this.f13599b.f13594b;     // Catch: Throwable -> L48
            monitor-enter(r15);     // Catch: Throwable -> L48
            LinkedList r16 = new LinkedList(this.f13599b.f13594b);     // Catch: Throwable -> L40
            this.f13599b.f13594b.clear();     // Catch: Throwable -> L40
            monitor-exit(r15);     // Catch: Throwable -> L40
            Iterator r17 = r16.iterator();     // Catch: Throwable -> L48
        L21:
            if (r17.hasNext() == false) goto L28;
            c r18 = (c) r17.next();     // Catch: Throwable -> L48
            b r19 = this.f13599b;     // Catch: Throwable -> L48
            m r20 = this.f13598a;     // Catch: Throwable -> L48
            r19.getClass();     // Catch: Throwable -> L48
            if (r18 == null) goto L21;
            r20.getClass();     // Catch: Throwable -> L48
            throw null;     // Catch: Throwable -> L47
        L28:
            LinkedList<x7.a> r21 = this.f13599b.f13595c;     // Catch: Throwable -> L48
            monitor-enter(r21);     // Catch: Throwable -> L48
            LinkedList r22 = new LinkedList(this.f13599b.f13595c);     // Catch: Throwable -> L37
            this.f13599b.f13595c.clear();     // Catch: Throwable -> L37
            monitor-exit(r21);     // Catch: Throwable -> L37
            Iterator r23 = r22.iterator();     // Catch: Throwable -> L48
        L34:
            if (r23.hasNext() == false) goto L73;
            x7.a r24 = (x7.a) r23.next();     // Catch: Throwable -> L48
            b.a(this.f13599b, this.f13598a, r24);     // Catch: Throwable -> L48
            goto L34
        L73:
            return;
        L37:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L43:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        }
    }

    public b() {
        this.f13593a = new LinkedList();
        this.f13594b = new LinkedList();
        this.f13595c = new LinkedList();
        this.f13596d = 200;
    }

    public static void a(b r11, m r12, x7.a r13) {
        r11.getClass();
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r13.f13585a) == false) goto L25;
        return;
    L25:
        if (r13.f13585a.equals("api_error") == false) goto L16;
        long r8 = r13.f13586b;
        long r10 = r13.f13587c;
        String r14 = r13.f13588d;
        String r15 = r13.f13589e;
        String r16 = r13.f13590f;
        int r17 = r13.f13591g;
        JSONObject r18 = r13.f13592h;
        r12.getClass();
        if (r12.f13663z == true) goto L13;
        r12.B.c(new x7.a(r8, r10, r14, r15, r16, r17, r18));     // Catch: Throwable -> L23
    L24:
        return;
    L13:
        u7.a.b.f12503a.a(new k(r12, r8, r10, r14, r15, r16, r17, r18));     // Catch: Throwable -> L23
        goto L24
    L16:
        if (r13.f13585a.equals("api_all") == false) goto L28;
        long r19 = r13.f13586b;
        long r20 = r13.f13587c;
        String r21 = r13.f13588d;
        String r22 = r13.f13589e;
        String r23 = r13.f13590f;
        int r24 = r13.f13591g;
        JSONObject r110 = r13.f13592h;
        r12.getClass();
        if (r12.f13663z == true) goto L21;
        r12.B.c(new x7.a(r19, r20, r21, r22, r23, r24, r110));     // Catch: Throwable -> L23
        goto L24
    L21:
        u7.a.b.f12503a.a(new j(r12, r19, r20, r21, r22, r23, r24, r110));     // Catch: Throwable -> L23
        goto L24
    L28:
        return;
    }

    public final void b(m r8) {
        if (this.f13597e == false) goto L5;
        return;
    L5:
        this.f13597e = true;
        u7.a.b.f12503a.a(new a(this, r8));
    }

    public final void c(x7.a r8) {
        LinkedList<x7.a> r10 = this.f13595c;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f13595c.size() <= this.f13596d) goto L7;
        this.f13595c.poll();     // Catch: Throwable -> L10
    L7:
        this.f13595c.add(r8);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
    }
}
