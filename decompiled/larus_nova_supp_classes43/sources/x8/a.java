package x8;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        b(r1, r10, false);
    }

    public static void b(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        b8.a r0 = b8.a.a;
        b8.a.a(new b8.b("Annie_" + r10, LogLevel.ERROR, null, r11, 4), r12);
    }

    public static void c(String r10, Throwable r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        b8.a r0 = b8.a.a;
        b8.a.a(new b8.b("Annie_" + r10, LogLevel.ERROR, r11, null, 8), r12);
    }

    public static void d(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        b8.a r0 = b8.a.a;
        b8.a.a(new b8.b("Annie_" + r10, LogLevel.INFO, null, r11, 4), r12);
    }
}
