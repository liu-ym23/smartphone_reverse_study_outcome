package com.bumptech.glide.load;

import com.bytedance.rpc.internal.RpcUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f667a = null;

    static {
        f667a = Charset.forName(RpcUtils.CHARSET_UTF8);
    }

    void a(MessageDigest r1);

    boolean equals(Object r1);

    int hashCode();
}
