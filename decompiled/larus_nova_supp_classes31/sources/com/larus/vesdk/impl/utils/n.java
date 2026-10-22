package com.larus.vesdk.impl.utils;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.platform.api.c4;
import com.larus.settings.value.e10;
import com.larus.settings.value.on;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.vesdk.VEUtils;
import com.ss.android.vesdk.algorithm.VEBachAlgorithmParam;
import com.ss.android.vesdk.algorithm.VEBachSceneRecognitionParam;
import com.ss.android.vesdk.algorithm.VEBachSceneRecognitionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n {
    public static final Lazy a = null;
    public static final String b = null;

    public n() {
    }

    static {
        new LruCache(10);
        a = LazyKt.lazy(new m());
        e10 r0 = e10.a;
        b = (String) l0.a("", new on());
    }

    @JvmStatic
    public static final void b(Bitmap r6, CameraCaptureViewModel.f r7) {
        Intrinsics.checkNotNullParameter(r6, "bitmap");
        Intrinsics.checkNotNullParameter(r7, "callback");
        FLogger.a.i("VeOCRController", "bitmap:" + r6.getWidth() + '*' + r6.getHeight() + "***");
        if (r6.isRecycled() == false) goto L6;
        r7.onError("bitmap isRecycled");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new VeOCRController$hasTxtOnImage$4(r7, r6, null), 2, null);
    }

    public static final void a(Bitmap r4, String r5, final c4.b r6) {
        VEBachSceneRecognitionParam r0 = new VEBachSceneRecognitionParam();
        r0.setApplicationName("flow");
        r0.setSceneType(VEBachSceneRecognitionParam.RECONGNITION_TYPE.TEXT);
        ((VEBachAlgorithmParam) r0).algorithmConfig = (String) a.getValue();
        r0.setModelPath(r5);
        ((VEBachAlgorithmParam) r0).bitmap = r4;
        int r7 = 0;
        if (r4 == null) goto L5;
        int r8 = r4.getWidth();
    L6:
        Bitmap r1 = ((VEBachAlgorithmParam) r0).bitmap;
        if (r1 == null) goto L9;
        r7 = r1.getHeight();
    L9:
        FLogger.a.i("VeOCRController", "start scanPicture, bitmap_width:" + r8 + ", bitmap_height:" + r7);
        if (r8 == 0) goto L36;
        if (r7 == 0) goto L36;
        if ((r8 / r7) > 30.0f) goto L36;
        com.larus.vesdk.impl.e.a(null);
        List r9 = VEUtils.scanPicture(r0);
        if (r9 == null) goto L35;
        List r10 = CollectionsKt.filterNotNull(r9);
        if (r10 == null) goto L35;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L21:
        if (r12.hasNext() == false) goto L25;
        Object r2 = r12.next();
        if ((r2 instanceof VEBachSceneRecognitionResult) == false) goto L21;
        r11.add(r2);
        goto L21
    L25:
        Iterator r13 = r11.iterator();
    L27:
        if (r13.hasNext() == false) goto L35;
        VEBachSceneRecognitionResult r14 = (VEBachSceneRecognitionResult) r13.next();
        FLogger.a.i("VeOCRController", "result, errCode:" + r14.getErrCode() + ", type:" + r14.getSceneType() + ", prob:" + r14.getProb());
        if (r14.getErrCode() != 0) goto L27;
        if (r14.getSceneType() != VEBachSceneRecognitionParam.RECONGNITION_TYPE.TEXT) goto L27;
        if (r14.getProb() <= 0.8f) goto L27;
        t0.c(new k(r6));
        return;
    L35:
        t0.c(new l(r6));
        return;
    L36:
        t0.c(new j(r6));
        return;
    L5:
        r8 = 0;
        goto L6
    }
}
