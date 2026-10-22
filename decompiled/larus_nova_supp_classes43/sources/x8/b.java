package x8;

import com.bytedance.ai.event.MessageIndication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;

    public b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        this.a = r10;
    }

    public static void c(b r1, Throwable r10) {
        Intrinsics.checkNotNullParameter("AnnieFragment", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        a.c("AnnieFragment", r10, false);
    }

    public final void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        int r0 = a.a;
        a.b(r10, d(null, r11), false);
    }

    public final String d(String r10, String r11) {
        if (r10 == null) goto L7;
        String r12 = "{\"session_id\": \"" + this.a + "\", \"name\": \"" + r10 + "\", \"msg\": \"" + r11 + "\"}";
        if (r12 == null) goto L7;
        return r12;
    L7:
        return "{\"session_id\": \"" + this.a + "\", \"msg\": \"" + r11 + "\"}";
    }

    public final void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        int r0 = a.a;
        a.d(r10, d(null, r11), false);
    }

    public final void f(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, "stage");
        Intrinsics.checkNotNullParameter(r12, MessageIndication.MESSAGE_TYPE_MSG);
        int r0 = a.a;
        a.d(r10, d(r11, r12), false);
    }

    public static void b(b r1, String r10, String r11, String r12) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, "stage");
        Intrinsics.checkNotNullParameter(r12, MessageIndication.MESSAGE_TYPE_MSG);
        int r0 = a.a;
        a.b(r10, r1.d(r11, r12), false);
    }
}
