package com.bytedance.android.live.lottie;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.livesdk.lottie.LottieService")
public interface ILottieService extends IService {
    public static final int STATUS_FINISH_LOTTIE_ANIMATION = 2;
    public static final int STATUS_LOTTIE_ANIMATION_FAILED = 0;
    public static final int STATUS_START_LOTTIE_ANIMATION = 1;

    void finishLottieAnimation();

    Observable<Integer> tryStartLottieAnimation(long r1, boolean r3);
}
