package com.larus.avlink.e;

import com.larus.avlink.api.model.DoraEvent;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x {
    public x() {
    }

    public static void a(int r7) {
        FLogger.a.i("DoraVision_OCRProcessor", "uploadOcrDetectionResult. imageId: " + r7 + ", ocrDetectionRes: false");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new OCRProcessor$uploadOcrDetectionResult$1(r7, false, null), 3, null);
    }

    public final void b(final int r15, List<f98.r> r16, final Map<String, ? extends Object> r17) {
        FLogger.a.i("DoraVision_OCRProcessor", "uploadOCRInfo. imageId: " + r15 + ", visionInfo: " + r16);
        Map<String, com.larus.avlink.model.a> r1 = DoraImageManager.a;
        final com.larus.avlink.model.a r2 = DoraImageManager.a(Integer.valueOf(r15));
        if (r2 == null) goto L5;
        r2.z = true;
    L5:
        if (r2 == null) goto L7;
        r2.v = Long.valueOf(System.currentTimeMillis());
    L7:
        m r3 = m.a;
        int r4 = o.b();
        Function2 r5 = new v(r2, r15, r17, this);
        Intrinsics.checkNotNullParameter(r16, "visionInfo");
        Intrinsics.checkNotNullParameter(r17, "extra");
        Unit r0 = Unit.INSTANCE;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraENetworkUtil$uploadOcrResult$1(r15, r5, r16, r4, null), 3, null);
        Lazy r6 = ia8.m.a;
        DoraEvent r7 = DoraEvent.OCRUploadStart;
        r7.setExtra("imageUuid: " + r15);
        ia8.m.b(r7);
    }
}
