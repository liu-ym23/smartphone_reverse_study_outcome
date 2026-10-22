package com.byted.mgl.merge.service.api.optimize.cpu;

import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IMglOptimizeCpuService extends IBdpService {
    void bindBigCore();

    void initCpuSetter(Context r1, boolean r10, ExecutorService r11);

    void resetCoreBind();
}
