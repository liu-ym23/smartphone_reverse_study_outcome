package e8;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final void a(RequestParams r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        r10.getBackend().putString("loraType", r11);
    }

    public static final void b(RequestParams r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.getBackend().putBoolean("needPreload", true);
        r10.getBackend().putInt("preloadSeconds", r11);
    }
}
