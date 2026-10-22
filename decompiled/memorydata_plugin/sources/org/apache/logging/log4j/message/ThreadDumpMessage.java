package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.util.n;
import org.apache.logging.log4j.util.q;

/* JADX INFO: loaded from: classes6.dex */
public class ThreadDumpMessage implements Message, q {
    private static b FACTORY = null;
    private static final long serialVersionUID = -1103400781608841088L;
    private String formattedMessage;
    private volatile Map<h, StackTraceElement[]> threads;
    private final String title;

    /* JADX INFO: renamed from: org.apache.logging.log4j.message.ThreadDumpMessage$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ThreadDumpMessageProxy implements Serializable {
        private static final long serialVersionUID = -3476620450287648269L;
        private final String formattedMsg;
        private final String title;

        ThreadDumpMessageProxy(ThreadDumpMessage r2) {
            this.formattedMsg = r2.getFormattedMessage();
            this.title = ThreadDumpMessage.access$000(r2);
        }

        public Object readResolve() {
            return new ThreadDumpMessage(this.formattedMsg, this.title, null);
        }
    }

    private static class a implements b {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.logging.log4j.message.ThreadDumpMessage.b
        public Map<h, StackTraceElement[]> a() {
            Map<Thread, StackTraceElement[]> r6 = Thread.getAllStackTraces();
            HashMap r0 = new HashMap(r6.size());
            Iterator<Map.Entry<Thread, StackTraceElement[]>> r7 = r6.entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r0.put(new org.apache.logging.log4j.message.a((Thread) ZeusTransformUtils.preCheckCast(r1.getKey(), Thread.class, "com.obric.memorydata.plugin")), r1.getValue());
            goto L4
        L6:
            return r0;
        }
    }

    public interface b {
        Map<h, StackTraceElement[]> a();
    }

    public ThreadDumpMessage(String r1) {
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this.title = r1;
        this.threads = getFactory().a();
    }

    private ThreadDumpMessage(String r1, String r2) {
        this.formattedMessage = r1;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        this.title = r2;
    }

    /* synthetic */ ThreadDumpMessage(String r1, String r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ String access$000(ThreadDumpMessage r0) {
        return r0.title;
    }

    private static b getFactory() {
        if (FACTORY != null) goto L6;
        FACTORY = initFactory();
    L6:
        return FACTORY;
    }

    private static b initFactory() {
        return (b) ZeusTransformUtils.preCheckCast(n.a(b.class, MethodHandles.lookup(), false).findFirst().orElseGet($$Lambda$ThreadDumpMessage$I2QaQZnK0olBNdtY8MSwUluduA.INSTANCE), b.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ b lambda$initFactory$0() {
        return new a(null);
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Proxy required");
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r6) {
        r6.append(this.title);
        if (this.title.length() <= 0) goto L5;
        r6.append('\n');
    L5:
        Iterator<Map.Entry<h, StackTraceElement[]>> r5 = this.threads.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        h r2 = (h) ZeusTransformUtils.preCheckCast(r0.getKey(), h.class, "com.obric.memorydata.plugin");
        r2.a(r6);
        r2.a(r6, (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r0.getValue(), StackTraceElement[].class, "com.obric.memorydata.plugin"));
        r6.append('\n');
        goto L7
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        String r0 = this.title;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        String r0 = this.formattedMessage;
        if (r0 == null) goto L5;
        return r0;
    L5:
        StringBuilder r1 = new StringBuilder(255);
        formatTo(r1);
        return r1.toString();
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return null;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public String toString() {
        return getFormattedMessage();
    }

    public Object writeReplace() {
        return new ThreadDumpMessageProxy(this);
    }
}
