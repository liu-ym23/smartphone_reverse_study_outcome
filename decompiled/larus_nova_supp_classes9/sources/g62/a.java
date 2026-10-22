package g62;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.n;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.interactivity.service.messagelist.c a(tlc.d r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        if ((r1 instanceof p) == false) goto L6;
        return new i62.i((p) r1);
    L6:
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d) == false) goto L9;
        return new i62.c((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d) r1);
    L9:
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b) == false) goto L12;
        return new i62.b((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b) r1);
    L12:
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g) == false) goto L15;
        return new i62.d((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g) r1);
    L15:
        if ((r1 instanceof n) == false) goto L18;
        return new i62.h((n) r1);
    L18:
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h) == false) goto L21;
        return new i62.e((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h) r1);
    L21:
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i) == true) goto L31;
        return null;
    L31:
        return new i62.f((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i) r1);
    }
}
