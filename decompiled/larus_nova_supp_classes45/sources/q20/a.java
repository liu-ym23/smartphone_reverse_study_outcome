package q20;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "text");
        f2.c("据抖音要求，剪贴板为敏感权限，不允许复制。请使用发送lark替代", 0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        f2.c("复制失败 " + e.getMessage(), 0);
    }
}
