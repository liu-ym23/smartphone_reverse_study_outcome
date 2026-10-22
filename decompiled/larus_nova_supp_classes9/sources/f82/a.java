package f82;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService;
import com.bytedance.android.livesdk.interactivity.imagerecognition.util.ImageRecognitionUtil;
import com.bytedance.android.livesdk.interactivity.jsb.ImageRecognitionResultModel;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import q82.d;
import s32.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "imageRecognition")
public final class a extends q82.a<d, ImageRecognitionResultModel> {
    public a() {
    }

    public final void invoke(Object r6, CallContext r7) {
        d r8 = (d) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r1 = r8.b();
        Integer r2 = r8.c();
        if (r1 == null) goto L19;
        if (r2 == null) goto L19;
        ImageRecognitionEntry r3 = ImageRecognitionEntry.Companion.from(r1);
        if (r2.intValue() <= 0) goto L19;
        if (r3 == null) goto L19;
        String r9 = r8.a();
        if (r9 != null) goto L21;
    L14:
        String r10 = null;
    L15:
        IImageRecognitionService r11 = (IImageRecognitionService) k.f(IImageRecognitionService.class);
        if (r11 == null) goto L18;
        r11.recognize(r2.intValue(), r3, r10);
    L18:
        finishWithSuccess();
        return;
    L21:
        int r4 = ImageRecognitionUtil.a;     // Catch: Exception -> L12
        r10 = ImageRecognitionUtil.c(r9, r7.d);     // Catch: Exception -> L12
        int r5 = f.a;     // Catch: Exception -> L12
        f.b("[ImageRecognitionMethod] createBtmToken " + r10 + " with " + r9);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        int r13 = f.a;
        Intrinsics.checkNotNullParameter("[ImageRecognitionMethod] createBtmToken failed", "info");
        Intrinsics.checkNotNullParameter(e, "t");
        ALogger.e("ImageRecognition", "[ImageRecognitionMethod] createBtmToken failed", e);
    L19:
        int r14 = x8.a.a;
        x8.a.d("ImageRecognitionMethod", "invalid params. entry=" + r1 + " scene=" + r2, false);
        finishWithFailure();
    }
}
