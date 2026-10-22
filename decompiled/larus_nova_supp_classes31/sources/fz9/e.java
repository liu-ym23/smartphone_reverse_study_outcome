package fz9;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e implements c {
    public final String a;
    public final int b;
    public final int c;
    public final Message d;
    public final Integer e;

    public e() {
        this(null, 0, 0, null, null);
    }

    public final String toString() {
        return "ProgressLoadingData(taskId=" + this.a + ", width=" + this.b + ", height=" + this.c + ", message=" + this.d + ", index=" + this.e + ')';
    }

    public final int hashCode() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.a);
        r0.append(this.b);
        r0.append(this.c);
        Message r1 = this.d;
        if (r1 == null) goto L5;
        String r2 = r1.getMessageId();
    L6:
        r0.append(r2);
        r0.append(this.e);
        return r0.toString().hashCode();
    L5:
        r2 = null;
        goto L6
    }

    @Override // fz9.c
    public final int getHeight() {
        return this.c;
    }

    @Override // fz9.c
    public final Integer getIndex() {
        return this.e;
    }

    @Override // fz9.c
    public final Message getMessage() {
        return this.d;
    }

    @Override // fz9.c
    public final String getTaskId() {
        return this.a;
    }

    @Override // fz9.c
    public final int getWidth() {
        return this.b;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof e) == false) goto L23;
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L7;
        return false;
    L7:
        if (this.b == r6.b) goto L9;
        return false;
    L9:
        if (this.c != r6.c) goto L26;
        Message r0 = this.d;
        String r2 = null;
        if (r0 == null) goto L13;
        String r1 = r0.getMessageId();
    L14:
        Message r3 = r6.d;
        if (r3 == null) goto L18;
        r2 = r3.getMessageId();
    L18:
        if (Intrinsics.areEqual(r1, r2) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.e, r6.e) == false) goto L28;
        return true;
    L28:
        return false;
    L13:
        r1 = null;
        goto L14
    L26:
        return false;
    L23:
        return false;
    }

    public e(String r1, int r2, int r3, Message r4, Integer r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
