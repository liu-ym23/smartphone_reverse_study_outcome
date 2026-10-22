package b0;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class g implements r0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageDigest f816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lynx.tasm.base.f f817b;

    public g(MessageDigest r5) {
        this.f817b = new com.lynx.tasm.base.f();
        this.f816a = r5;
    }

    @Override // r0.e
    public final com.lynx.tasm.base.f b() {
        return this.f817b;
    }
}
