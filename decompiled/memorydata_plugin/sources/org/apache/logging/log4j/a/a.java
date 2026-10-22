package org.apache.logging.log4j.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.f;
import org.apache.logging.log4j.util.p;
import org.apache.logging.log4j.util.t;

/* JADX INFO: loaded from: classes6.dex */
public class a implements org.apache.logging.log4j.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Message f17884b;
    private static final String c = null;
    private static final c d = null;
    private final c e;
    private Level f;
    private Marker g;
    private Throwable h;
    private StackTraceElement i;
    private volatile boolean j;
    private long k;

    static {
        f17884b = new SimpleMessage("");
        c = a.class.getName();
        d = StatusLogger.getLogger();
    }

    public a(c r3) {
        this.e = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.j = false;
        this.k = Thread.currentThread().getId();
    }

    public a(c r3, Level r4) {
        this.e = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f = r4;
        this.k = Thread.currentThread().getId();
        this.j = true;
    }

    private void a(Message r8) {
        Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r8, Message.class, "com.obric.memorydata.plugin");
        this.e.logMessage(this.f, this.g, c, this.i, r5, this.h);     // Catch: Throwable -> L6
        this.j = false;
        return;
    L6:
        th = move-exception;
        this.j = false;
        throw th;
    }

    private boolean b() {
        if (this.j == true) goto L8;
        c r7 = d;
        Class<?> r0 = p.a(2);
        String r2 = "Attempt to reuse LogBuilder was ignored. {}";
    L5:
        r7.warn(r2, r0);
        return false;
    L8:
        if (this.k == Thread.currentThread().getId()) goto L10;
        r7 = d;
        r0 = p.a(2);
        r2 = "LogBuilder can only be used on the owning thread. {}";
        goto L5
    L10:
        return true;
    }

    @Override // org.apache.logging.log4j.a
    public org.apache.logging.log4j.a a(Throwable r1) {
        this.h = r1;
        return this;
    }

    public org.apache.logging.log4j.a a(Level r2) {
        this.j = true;
        this.f = r2;
        this.g = null;
        this.h = null;
        this.i = null;
        return this;
    }

    @Override // org.apache.logging.log4j.a
    public void a(String r2) {
        if (b() == false) goto L6;
        a(this.e.getMessageFactory().newMessage(r2));
        return;
    }

    @Override // org.apache.logging.log4j.a
    public void a(String r4, Object r5) {
        if (b() == false) goto L6;
        a(this.e.getMessageFactory().newMessage(r4, new Object[]{r5}));
        return;
    }

    @Override // org.apache.logging.log4j.a
    public void a(String r4, Object r5, Object r6) {
        if (b() == false) goto L6;
        a(this.e.getMessageFactory().newMessage(r4, new Object[]{r5, r6}));
        return;
    }

    @Override // org.apache.logging.log4j.a
    public void a(String r4, Object r5, Object r6, Object r7) {
        if (b() == false) goto L6;
        a(this.e.getMessageFactory().newMessage(r4, new Object[]{r5, r6, r7}));
        return;
    }

    @Override // org.apache.logging.log4j.a
    public void a(String r4, Object r5, Object r6, Object r7, Object r8) {
        if (b() == false) goto L6;
        a(this.e.getMessageFactory().newMessage(r4, new Object[]{r5, r6, r7, r8}));
        return;
    }

    @Override // org.apache.logging.log4j.a
    public void a(String r2, t<?>... r3) {
        if (b() == false) goto L6;
        a(this.e.getMessageFactory().newMessage(r2, f.a(r3)));
        return;
    }

    @Override // org.apache.logging.log4j.a
    public void a(t<Message> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        if (b() == false) goto L6;
        a((Message) ZeusTransformUtils.preCheckCast(r4.get(), Message.class, "com.obric.memorydata.plugin"));
        return;
    }

    public boolean a() {
        return this.j;
    }
}
