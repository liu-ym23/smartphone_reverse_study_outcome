package bk;

import com.bytedance.vmsdk.worker.JsWorker;
import ek.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile jk.a f955h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d f956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsWorker f958c;
    public final String d;
    public final dk.a e;
    public final ek.c f;
    public final LinkedList g;

    public c(JsWorker r10) {
        if (f955h != null) goto L5;
        f955h = new jk.a(1);
        jk.a r5 = f955h;
        r5.getClass();
        new Thread(new androidx.fragment.app.d(r5, 6)).start();
    L5:
        this.g = new LinkedList();
        if (r10.EngineType() != JsWorker.EngineType.V8) goto L8;
        String r11 = "V8";
    L9:
        this.f957b = "VMSDK_JSWorker_".concat(r11);
        String r12 = "/inspector/" + r10.getNativePtr();
        this.d = r12;
        this.f958c = r10;
        dk.a r13 = new dk.a(r12);
        this.e = r13;
        ek.c r14 = new ek.c(new zm.c(this, 1));
        this.f = r14;
        jk.a r15 = f955h;
        a r16 = (a) r15.d;
        ArrayList r17 = r16.f954b;
        monitor-enter(r17);
    L14:
        th = move-exception;
        throw th;
    L12:
        if (r16.f954b.contains(this) == true) goto L16;
        r16.f954b.add(this);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r17);     // Catch: Throwable -> L14
        ((p) r15.e).k(r13, r14);
        return;
    L8:
        r11 = "QuickJS";
        goto L9
    }

    public final void a() {
        this.f956a = null;
        this.f958c.onCloseInspectorSession();
        Iterator r5 = this.g.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((c) ((b) r5.next())).a();
        goto L4
    }

    public final boolean b(String r5) {
        Iterator r10 = this.g.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (((c) ((b) r10.next())).b(r5) == false) goto L4;
        return true;
    L9:
        this.f958c.onInspectorMessage(r5);
        return false;
    }

    public final void c(d r5) {
        this.f956a = r5;
        Iterator r10 = this.g.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((c) ((b) r10.next())).c(r5);
        goto L4
    L6:
        this.f958c.onOpenInspectorSession();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L15:
        return false;
    L8:
        if (c.class != r5.getClass()) goto L15;
        c r10 = (c) r5;
        if (Objects.equals(this.f957b, r10.f957b) == false) goto L15;
        if (Objects.equals(this.d, r10.d) == false) goto L15;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f957b, this.d});
    }
}
