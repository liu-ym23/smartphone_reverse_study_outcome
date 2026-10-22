package amc;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final com.ss.ugc.live.sdk.msg.d a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return new com.ss.ugc.live.sdk.msg.d(r2, CollectionsKt.emptyList());
    }

    @JvmStatic
    public static final com.ss.ugc.live.sdk.msg.d b(e r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "config");
        Intrinsics.checkNotNullParameter(r2, "plugins");
        return new com.ss.ugc.live.sdk.msg.d(r1, r2);
    }
}
