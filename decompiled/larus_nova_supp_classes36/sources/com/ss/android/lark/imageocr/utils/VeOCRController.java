package com.ss.android.lark.imageocr.utils;

import android.graphics.Bitmap;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.vesdk.VEUtils;
import com.ss.android.vesdk.algorithm.VEBachAlgorithmParam;
import com.ss.android.vesdk.algorithm.VEBachSceneRecognitionParam;
import com.ss.android.vesdk.algorithm.VEBachSceneRecognitionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VeOCRController {
    public static final ExecutorService a = null;
    public static final ConcurrentHashMap<String, a> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public static final class a {
        public final boolean a;
        public final float b;

        public a(boolean r1, float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public VeOCRController() {
    }

    static {
        a = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-ve-ocr");
        b = new ConcurrentHashMap();
        c = LazyKt.lazy(VeOCRController$algorithmConfig$2.INSTANCE);
        d = LazyKt.lazy(VeOCRController$modelSavePath$2.INSTANCE);
    }

    public static final void a(String r6, float r7, llb.b r8) {
        VEBachSceneRecognitionParam r0 = new VEBachSceneRecognitionParam();
        r0.setApplicationName("lark");
        r0.setSceneType(VEBachSceneRecognitionParam.RECONGNITION_TYPE.TEXT);
        ((VEBachAlgorithmParam) r0).algorithmConfig = (String) c.getValue();
        r0.setModelPath((String) d.getValue());
        Bitmap r1 = p.e(r6, 1440, 2560);
        ((VEBachAlgorithmParam) r0).bitmap = r1;
        if (r1 == null) goto L5;
        int r2 = r1.getWidth();
    L6:
        Bitmap r3 = ((VEBachAlgorithmParam) r0).bitmap;
        if (r3 == null) goto L9;
        int r4 = r3.getHeight();
    L10:
        Log.i("VeOCRController", "start scanPicture, bitmap_width:" + r2 + ", bitmap_height:" + r4);
        if (r2 == 0) goto L37;
        if (r4 == 0) goto L37;
        if ((r2 / r4) > 30.0f) goto L37;
        VideoTools.checkToInitSDK();
        List r5 = VEUtils.scanPicture(r0);
        if (r5 == null) goto L36;
        List r9 = CollectionsKt.filterNotNull(r5);
        if (r9 == null) goto L36;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        Object r12 = r11.next();
        if ((r12 instanceof VEBachSceneRecognitionResult) == false) goto L22;
        r10.add(r12);
        goto L22
    L26:
        Iterator r13 = r10.iterator();
    L28:
        if (r13.hasNext() == false) goto L36;
        VEBachSceneRecognitionResult r14 = (VEBachSceneRecognitionResult) r13.next();
        Log.i("VeOCRController", "scene result error is " + r14.getErrCode() + ", type is " + r14.getSceneType() + ", prob is " + r14.getProb());
        if (r14.getErrCode() != 0) goto L28;
        if (r14.getSceneType() != VEBachSceneRecognitionParam.RECONGNITION_TYPE.TEXT) goto L28;
        if (r14.getProb() <= r7) goto L28;
        b.put(r6, new a(true, r14.getProb()));
        UICallbackExecutor.execute(new e(r8, r14, r7));
        return;
    L36:
        b.put(r6, new a(false, 0.0f));
        UICallbackExecutor.execute(new f(r8, r7));
        return;
    L37:
        UICallbackExecutor.execute(new d(r8));
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }
}
