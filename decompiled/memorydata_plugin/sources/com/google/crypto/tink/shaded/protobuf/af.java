package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class af {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q f4944b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile at f4945a;
    private ByteString c;
    private q d;
    private volatile ByteString e;

    static {
        f4944b = q.a();
    }

    public af() {
    }

    public at a(at r3) {
        c((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin"));
        return this.f4945a;
    }

    public int b() {
        if (this.e != null) goto L5;
        ByteString r0 = this.c;
        if (r0 == null) goto L11;
        return r0.size();
    L11:
        if (this.f4945a != null) goto L13;
        return 0;
    L13:
        return this.f4945a.getSerializedSize();
    L5:
        return this.e.size();
    }

    public at b(at r3) {
        at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        at r0 = this.f4945a;
        this.c = null;
        this.e = null;
        this.f4945a = r4;
        return r0;
    }

    public ByteString c() {
        if (this.e != null) goto L5;
        ByteString r0 = this.c;
        if (r0 == null) goto L9;
        return r0;
    L9:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (this.e == null) goto L16;
        ByteString r1 = this.e;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r1;
    L16:
        if (this.f4945a != null) goto L19;
        ByteString r2 = ByteString.EMPTY;     // Catch: Throwable -> L23
    L18:
        this.e = r2;     // Catch: Throwable -> L23
        ByteString r3 = this.e;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return r3;
    L19:
        r2 = this.f4945a.toByteString();     // Catch: Throwable -> L23
        goto L18
    L5:
        return this.e;
    }

    public void c(at r4) {
        at r5 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
        if (this.f4945a == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.f4945a == null) goto L22;
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L22:
    L16:
        this.f4945a = r5;     // Catch: Throwable -> L19
        this.e = ByteString.EMPTY;     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L11:
        if (this.c == null) goto L14;
        this.f4945a = (at) ZeusTransformUtils.preCheckCast(r5.getParserForType().c(this.c, this.d), at.class, "com.obric.memorydata.plugin");     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L19
        ByteString r0 = this.c;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L19
    L13:
        this.e = r0;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L19
    L14:
        this.f4945a = r5;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L19
        r0 = ByteString.EMPTY;     // Catch: InvalidProtocolBufferException -> L16 Throwable -> L19
        goto L13
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, af.class) == true) goto L10;
        return false;
    L10:
        af r4 = (af) ZeusTransformUtils.preCheckCast(r3, af.class, "com.obric.memorydata.plugin");
        at r0 = this.f4945a;
        at r1 = r4.f4945a;
        if (r0 != null) goto L15;
        if (r1 != null) goto L15;
        return c().equals(r4.c());
    L15:
        if (r0 == null) goto L19;
        if (r1 == null) goto L19;
        return r0.equals(r1);
    L19:
        if (r0 == null) goto L23;
        return r0.equals(r4.a(r0.getDefaultInstanceForType()));
    L23:
        return a(r1.getDefaultInstanceForType()).equals(r1);
    }

    public int hashCode() {
        return 1;
    }
}
