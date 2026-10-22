package c8b;

import com.lark.kmp.logger.LarkLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        LarkLogger r0 = LarkLogger.a;
        LarkLogger.b("FlowChatSetting", r1);
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        LarkLogger r0 = LarkLogger.a;
        LarkLogger.c("FlowChatSetting", r1);
    }
}
