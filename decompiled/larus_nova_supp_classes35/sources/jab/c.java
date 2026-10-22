package jab;

import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final Boolean a;

    public static final class a {
    }

    static {
    }

    public c(CreateChatRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        this.a = r2.is_crypto;
    }
}
