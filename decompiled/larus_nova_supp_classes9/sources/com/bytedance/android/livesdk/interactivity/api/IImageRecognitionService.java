package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.interactivity.jsb.ImageRecognitionResultModel;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.ImageRecognitionService")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IImageRecognitionService;", "Lcom/bytedance/android/live/base/IService;", "Lj70/h;", "Ld90/a;", "getServiceWidgetDescriptor", "Lq82/a;", "Lq82/d;", "Lcom/bytedance/android/livesdk/interactivity/jsb/ImageRecognitionResultModel;", "createImageRecognitionMethod", BuildConfig.FLAVOR, "scene", "Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionEntry;", "entry", BuildConfig.FLAVOR, "btmToken", BuildConfig.FLAVOR, "recognize", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IImageRecognitionService extends IService {
    q82.a<q82.d, ImageRecognitionResultModel> createImageRecognitionMethod();

    j70.h<d90.a> getServiceWidgetDescriptor();

    void recognize(int r1, ImageRecognitionEntry r2, String r3);
}
