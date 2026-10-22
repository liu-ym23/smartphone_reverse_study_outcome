package com.obric.memorydata.union.build;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/union/build/EntityIdGenerator;", "", "<init>", "()V", "random", "Ljava/security/SecureRandom;", "SUFFIX_LEN", "", "generate", "", "suffix", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SecureRandom f13067b = null;

    static {
        f13066a = new a();
        f13067b = new SecureRandom();
    }

    private a() {
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$O6YVg8Pk74-s8YrgpcryxuHOKP0, reason: not valid java name */
    public static /* synthetic */ CharSequence m1224lambda$O6YVg8Pk74s8YrgpcryxuHOKP0(byte r0) {
        return a(r0);
    }

    public final String a(String r12) {
        Intrinsics.checkNotNullParameter(r12, "suffix");
        long r0 = System.currentTimeMillis();
        byte[] r2 = new byte[3];
        f13067b.nextBytes(r2);
        return r0 + '_' + ArraysKt.joinToString$default(r2, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$O6YVg8Pk74s8YrgpcryxuHOKP0.INSTANCE, 30, null) + '_' + r12;
    }
}
