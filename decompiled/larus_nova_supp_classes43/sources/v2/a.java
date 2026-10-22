package v2;

import com.bytedance.ai.applet.base.log.b;
import com.bytedance.ai.applet.base.log.h;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.applet.base.e;
import g2.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public final d a;

    public a() {
        e r0 = e.a;
        Intrinsics.checkNotNullParameter(r0, "logger");
        this.a = r0;
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.d(r10, h.a(r11));
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.i(r10, h.a(r11));
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void e(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.e(r10, h.a(r11), r12);
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void w(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.w(r10, h.a(r11), r12);
    }
}
