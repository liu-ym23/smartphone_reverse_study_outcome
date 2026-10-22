package jg;

import ai.j0;
import com.bytedance.monitor.collector.BinderMonitor;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18324c;
    public StackTraceElement[] d;

    public final String toString() {
        StringBuilder r5 = new StringBuilder("{\"start\":");
        r5.append(this.f18322a);
        r5.append(",\"end\":");
        r5.append(this.f18323b);
        r5.append(",\"parcel_size\":");
        r5.append(this.f18324c);
        r5.append(",\"cost_millis\":");
        r5.append(this.f18323b - this.f18322a);
        r5.append(",\"java_stack\":\"");
        StackTraceElement[] r10 = this.d;
        ArrayList r11 = BinderMonitor.f6945a;
        int r12 = 0;
        if (r10 != null) goto L5;
    L18:
        if (r10 != null) goto L20;
        String r13 = "Invalid Stack\n";
    L28:
        return j0.q(r5, r13, "\"}");
    L20:
        StringBuilder r14 = new StringBuilder();
        int r15 = r10.length;
        int r16 = 0;
    L21:
        if (r12 >= r15) goto L26;
        StackTraceElement r17 = r10[r12];
        r16 = r16 + 1;
        r14.append("\\tat " + r17.getClassName());
        r14.append(".");
        r14.append(r17.getMethodName());
        r14.append("(");
        r14.append(r17.getFileName());
        r14.append(":");
        r14.append(r17.getLineNumber());
        r14.append(")\\n");
        if (r16 > 40) goto L26;
        r12 = r12 + 1;
    L26:
        r13 = r14.toString();
        goto L28
    L5:
        if (r10.length == 0) goto L18;
        int r18 = 0;
    L9:
        if (r18 >= r10.length) goto L14;
        if ("saveBinderInfo".equals(r10[r18].getMethodName()) == true) goto L15;
        r18 = r18 + 1;
    L15:
        int r19 = r18 + 1;
        if (r19 > r10.length) goto L18;
        r10 = (StackTraceElement[]) Arrays.copyOfRange(r10, r19, r10.length);
        goto L18
    L14:
        r18 = 0;
        goto L15
    }
}
