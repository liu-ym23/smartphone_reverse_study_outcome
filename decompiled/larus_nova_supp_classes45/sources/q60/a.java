package q60;

import android.content.Context;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import com.bytedance.android.live.core.privacy.av.api.b;
import com.bytedance.android.live.core.privacy.av.api.e;
import com.bytedance.android.live.core.privacy.av.api.h;
import com.bytedance.android.live.core.privacy.av.impl.AudioAndVideoCallbackSystemImpl;
import com.bytedance.android.live.core.privacy.av.impl.c;
import com.bytedance.android.live.core.privacy.av.impl.d;
import com.bytedance.android.live.core.privacy.av.impl.g;
import com.bytedance.android.live.core.privacy.av.impl.i;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements e {
    public static e a;
    public static h b;
    public static final AtomicBoolean c = null;
    public static final a d = null;

    public a() {
    }

    static {
        d = new a();
        a = new d();
        b = new com.bytedance.android.live.core.privacy.av.impl.h();
        c = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final void g() {
        a.g();
    }

    @JvmStatic
    public static final void a(Context r3, PrivacyConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        if (c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (r4.e() == false) goto L7;
        g.d = r4;
        b = new i();
        com.bytedance.android.live.core.privacy.av.impl.e r5 = new com.bytedance.android.live.core.privacy.av.impl.e(new c(r3, r4, b), new AudioAndVideoCallbackSystemImpl(r4, b), r4);
        Intrinsics.checkNotNullParameter(r5, "outerCallback");
        g.c = r5;
        e r6 = r5;
    L8:
        a = r6;
        return;
    L7:
        r6 = new d();
        goto L8
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int c(String r8, String r9, Map<String, String> r11, b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r8, "biz");
        Intrinsics.checkNotNullParameter(r9, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        return a.c(r8, r9, r11, r12, r13);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int d(String r8, String r9, Map<String, String> r11, b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r8, "biz");
        Intrinsics.checkNotNullParameter(r9, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        return a.d(r8, r9, r11, r12, r13);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int e(String r8, String r9, Map<String, String> r11, b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r8, "biz");
        Intrinsics.checkNotNullParameter(r9, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        return a.e(r8, r9, r11, r12, r13);
    }
}
